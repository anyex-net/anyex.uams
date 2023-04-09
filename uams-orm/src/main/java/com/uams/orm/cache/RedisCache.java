package com.uams.orm.cache;

import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.exceptions.JedisConnectionException;

import com.uams.tools.utils.ObjectUtils;
import com.uams.tools.utils.RedisUtils;
import com.uams.tools.utils.StringUtils;
import com.google.common.collect.Maps;

/**
 * <p>File：RedisCache.java </p>
 * <p>Title: RedisCache </p>
 * <p>Description: RedisCache </p>
 * <p>Copyright: Copyright (c) 2014 08/15/2015 09:14</p>
 * <p>Company: BloCain</p>
 *
 * @author playguy
 * @version 1.0
 */
public class RedisCache implements Cache
{
    private static Logger       logger        = LoggerFactory.getLogger(RedisCache.class);
    
    /** The ReadWriteLock. */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    private String              id;
    
    public RedisCache(final String id)
    {
        if (StringUtils.isBlank(id)) throw new IllegalArgumentException("cache id not be null");
        this.id = id;
        if (logger.isDebugEnabled())
        {
            logger.debug("redis-mybatis-cache-id=" + id);
        }
    }
    
    @Override
    public String getId()
    {
        return this.id;
    }
    
    @Override
    public void putObject(Object key, Object value)
    {
        try
        {
            Map<String, Object> maps = Maps.newHashMap();
            maps.put(String.valueOf(key.hashCode()), value);
            RedisUtils.putMap(getId(), maps);
            if (logger.isDebugEnabled())
            {
                logger.debug(" Mybatis Cache putObject:" + key.hashCode());
            }
        }
        catch (JedisConnectionException e)
        {
            logger.error("Mybatis Cache putObject {} {}", key.hashCode(), e);
        }
    }
    
    @Override
    public Object getObject(Object key)
    {
        Object value = null;
        try
        {
            value = RedisUtils.hget(getId(), String.valueOf(key.hashCode()));
            if (logger.isDebugEnabled())
            {
                logger.debug("Mybatis Cache getObject:" + key.hashCode());
            }
        }
        catch (JedisConnectionException e)
        {
            logger.error("Mybatis Cache getObject {} {}", key.hashCode(), e);
        }
        return value;
    }
    
    @Override
    public Object removeObject(Object key)
    {
        Object value = null;
        try
        {
            value = RedisUtils.delMap(getId(), String.valueOf(hashCode()));
            if (logger.isDebugEnabled())
            {
                logger.debug("Mybatis Cache removeObject {} ", key);
            }
        }
        catch (JedisConnectionException e)
        {
            logger.error("Mybatis Cache removeObject {} {}", ObjectUtils.serialize(key.hashCode()), e);
        }
        if (logger.isDebugEnabled())
        {
            logger.debug("Mybatis Cache removeObject:" + key.hashCode());
        }
        return value;
    }
    
    @Override
    public void clear()
    {
        try
        {
            RedisUtils.del(getId());
            if (logger.isDebugEnabled())
            {
                logger.debug("remove mybatis cache key {} ", getId());
            }
        }
        catch (JedisConnectionException e)
        {
            logger.error("Mybatis Cache clearCache {}", e);
        }
    }
    
    @Override
    public int getSize()
    {
        int result = 0;
        try
        {
            result = RedisUtils.getSize(getId()).intValue();
            if (logger.isDebugEnabled())
            {
                logger.debug("Mybatis Cache getSize {}", getId());
            }
        }
        catch (JedisConnectionException e)
        {
            logger.error("Mybatis Cache getSize  {}", e);
        }
        return result;
    }
    
    @Override
    public ReadWriteLock getReadWriteLock()
    {
        return readWriteLock;
    }
}
