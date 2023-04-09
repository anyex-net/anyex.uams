package com.uams.security.shiro.cache;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uams.tools.utils.RedisUtils;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * <p>File：RedisCache.java </p>
 * <p>Title: 自定义REDIS缓存 </p>
 * <p>Description:RedisCache </p>
 * <p>Copyright: Copyright (c) 15/10/16 </p>
 * <p>Company: BloCain</p>
 *
 * @author Playguy
 * @version 1.0
 */
public class RedisCache<K, V> implements Cache<K, V>
{
    private Logger logger       = LoggerFactory.getLogger(getClass());
    
    private String cacheKeyName = null;
    
    public RedisCache(String cacheKeyName)
    {
        this.cacheKeyName = cacheKeyName;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public V get(K key) throws CacheException
    {
        if (key == null) { return null; }
        V value = null;
        try
        {
            value = (V) RedisUtils.hget(cacheKeyName, String.valueOf(key));
        }
        catch (Exception e)
        {
            logger.error("get {} {} {}", cacheKeyName, key, e);
        }
        return value;
    }
    
    @Override
    public V put(K key, V value) throws CacheException
    {
        if (key == null) { return null; }
        try
        {
            Map<String, Object> maps = Maps.newHashMap();
            maps.put(String.valueOf(key), value);
            RedisUtils.putMap(cacheKeyName, maps);
        }
        catch (Exception e)
        {
            logger.error("put {} {}", cacheKeyName, key, e);
        }
        return value;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public V remove(K key) throws CacheException
    {
        V value = null;
        try
        {
            RedisUtils.delMap(cacheKeyName, String.valueOf(key));
        }
        catch (Exception e)
        {
            logger.warn("remove {} {}", cacheKeyName, key, e);
        }
        return value;
    }
    
    @Override
    public void clear() throws CacheException
    {
        try
        {
            RedisUtils.del(cacheKeyName);
        }
        catch (Exception e)
        {
            logger.error("clear shiro cache key {} {}", cacheKeyName, e);
        }
    }
    
    @Override
    public int size()
    {
        int size = 0;
        try
        {
            size = RedisUtils.getSize(cacheKeyName).intValue();
            return size;
        }
        catch (Exception e)
        {
            logger.error("clear {}", cacheKeyName, e);
        }
        return size;
    }
    
    @Override
    public Set<K> keys()
    {
        Set<K> keys = Sets.newHashSet();
        try
        {
            RedisUtils.getMap(cacheKeyName);
            Set<Object> set = RedisUtils.getKeys(cacheKeyName);
            for (Object key : set)
            {
                keys.add((K) key);
            }
            return keys;
        }
        catch (Exception e)
        {
            logger.error("keys {}", cacheKeyName, e);
        }
        return keys;
    }
    
    @Override
    public Collection<V> values()
    {
        Collection<V> vals = Collections.emptyList();
        try
        {
            Map<String, Object> maps = RedisUtils.getMap(cacheKeyName);
            for (Object val : maps.values())
            {
                vals.add((V) val);
            }
            return vals;
        }
        catch (Exception e)
        {
            logger.error("values {}", cacheKeyName, e);
        }
        return vals;
    }
}