package com.ljb.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.AbstractCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/13<br>
 * 描述: <br>
 */
public class CustomCacheManager extends AbstractCacheManager {

    private RedisTemplate redisTemplate;

    private Collection<? extends Cache> caches = Collections.emptySet();
    /**
     * Specify the collection of Cache instances to use for this CacheManager.
     */
    public void setCaches(Collection<? extends Cache> caches) {
        this.caches = caches;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return caches;
    }

    @Nullable
    protected Cache getMissingCache(String name) {
        Cache cache=new RedisCache();
        ((RedisCache) cache).setName(name);
        ((RedisCache) cache).setRedisTemplate(redisTemplate);
        ((RedisCache) cache).setCacheManager(this);
        return cache;
    }
}
