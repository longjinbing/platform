package com.ljb.cache;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/13<br>
 * 描述: <br>
 */
public class ShiroSpringCacheManager extends AbstractCacheManager implements CacheManager, Destroyable {

    private RedisTemplate redisTemplate;

    @Override
    protected Cache createCache(String name) throws CacheException {
        return new ShiroSpringCache(name,this.redisTemplate);
    }

    @Override
    public void destroy() throws Exception {
        redisTemplate=null;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
