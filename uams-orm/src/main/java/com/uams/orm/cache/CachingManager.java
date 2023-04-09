package com.uams.orm.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>File：CachingManager.java </p>
 * <p>Title: CachingManager </p>
 * <p>Description:   MyBatis 全局二级缓存管理器
 * 负责管理MyBatis内部的所有二级缓存Cache
 * 该对象应该是 单例模式，一个MyBatis应用上下文中应该只有一个实例对象
 * 该管理器维护着MyBatis所有的查询所产生的CacheKey集合，当有update 操作执行时，
 * 会根据此update操作对应的StatementId
 * </p>
 * <p>Copyright: Copyright (c) 2014 08/21/2015 10:49</p>
 * <p>Company: BloCain</p>
 *
 * @author playguy
 * @version 1.0
 */
public class CachingManager
{
    static final Logger                    logger              = LoggerFactory.getLogger(CachingManager.class);
    
    /**
     * 每一个statementId 更新依赖的statementId集合
     */
    private Map<String, Set<String>>       observers           = new ConcurrentHashMap<String, Set<String>>();
    
    /**
     * 全局性的 statemntId与CacheKey集合
     */
    private CacheKeysPool                  sharedCacheKeysPool = new CacheKeysPool();
    
    /**
     *  记录每一个statementId 对应的Cache 对象
      */
    private Map<String, Cache>             holds               = new ConcurrentHashMap<String, Cache>();
    
    private boolean                        initialized         = false;
    
    private boolean                        cacheEnabled        = false;
    
    private volatile static CachingManager instance;
    
    private CachingManager()
    {
    }
    
    public static synchronized CachingManager getInstance()
    {
        if (instance == null)
        {
            instance = new CachingManager();
        }
        return instance;
    }
    
    public boolean isInitialized()
    {
        return initialized;
    }
    
    /**
     * 将Session会话级别产生的CacheKey缓冲池中的数据 更新到全局CacheKey缓冲池中
     * @param keysPool
     */
    public void refreshCacheKey(CacheKeysPool keysPool)
    {
        sharedCacheKeysPool.putAll(keysPool);
    }
    
    /**
     * 整个插件的核心，根据指定的statementId更新与之关联的二级缓存
     * 传入的StatementId集合是由会话级别的update语句对应的StatementId，
     * EnhancedCachingManager将通过查询相应的StatementId去查看是否配置了依赖关系，如果有，则将依赖关系中的statementId的查询缓存全部清空
     * @param set
     */
    public void clearRelatedCaches(final Set<String> set)
    {
        for (String observable : set)
        {
            if (logger.isDebugEnabled())
            {
                logger.debug("statementId: " + observable);
            }
            Set<String> relatedStatements = observers.get(observable);
            if (null != relatedStatements)
            {
                for (String statementId : relatedStatements)
                {
                    Cache cache = holds.get(statementId);
                    if (null != cache)
                    {
                        Set<Object> cacheKeys = sharedCacheKeysPool.get(statementId);
                        for (Object cacheKey : cacheKeys)
                        {
                            cache.removeObject(cacheKey);
                        }
                    }
                }
                sharedCacheKeysPool.remove(observable);
            }
        }
    }
    
    /**
     *
     * 初始化 缓存管理器，应该只被调用一次;
     *
     * @param properties
     * 	properties 中至少包含两个属性：
     * 		dependency 	: 该值表示着缓存依赖配置文件的位置
     * 		cacheEnbled	: "true" or "false",该配置必须要与<setting name="cacheEnabled">的值保持一致
     */
    public void initialize(Properties properties)
    {
        String dependency = properties.getProperty("dependency");
        if (!("".equals(dependency) || dependency == null))
        {
            InputStream inputStream;
            try
            {
                inputStream = Resources.getResourceAsStream(dependency);
                XPathParser parser = new XPathParser(inputStream);
                List<XNode> statements = parser.evalNodes("/dependencies/statements/statement");
                for (XNode node : statements)
                {
                    Set<String> temp = new HashSet<String>();
                    List<XNode> obs = node.evalNodes("observer");
                    for (XNode observer : obs)
                    {
                        temp.add(observer.getStringAttribute("id"));
                    }
                    this.observers.put(node.getStringAttribute("id"), temp);
                }
                initialized = true;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        String cacheEnabled = properties.getProperty("cacheEnabled", "true");
        if ("true".equals(cacheEnabled))
        {
            this.cacheEnabled = true;
        }
    }
    
    /**
     * 如果MyBatis开启了二级缓存，并且本查询的StatementId使用了二级缓存，并且对应的Mapper配置了缓存，
     * 则将此StatementId和Cache已键值对的形式存储到全局缓存管理器中
     * @param statementId
     * @param cache
     */
    public void appendStatementCacheMap(String statementId, Cache cache)
    {
        if (holds.containsKey(statementId) && holds.get(statementId) != null) { return; }
        holds.put(statementId, cache);
    }
    
    /**
     * MyBatis是否开启了二级缓存，即 <setting name="cacheEnabled" value="true"/>
     * @return {@link Boolean}
     */
    public boolean isCacheEnabled()
    {
        return cacheEnabled;
    }
}
