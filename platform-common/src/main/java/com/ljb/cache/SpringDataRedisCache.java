package com.ljb.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.*;
import java.util.concurrent.Callable;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/13<br>
 * 描述: <br>
 */
public class SpringDataRedisCache extends RedisCache implements Cache {
    Logger logger= LoggerFactory.getLogger(SpringDataRedisCache.class);

    private RedisTemplate<String, Object> redisTemplate;

    private String name;

    public SpringDataRedisCache(String name, byte[] prefix, RedisOperations<?, ?> redisOperations, long expiration) {
        super(name, prefix, redisOperations, expiration);
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

}
