package com.ljb.cache;


import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.util.CollectionUtils;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.exceptions.JedisConnectionException;
import sun.net.www.protocol.http.AuthenticationInfo;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.regex.Pattern;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/13<br>
 * 描述: <br>
 */
@SuppressWarnings("unchecked")
public class ShiroSpringCache<K,V> implements org.apache.shiro.cache.Cache<K, V>{
    private static final Logger logger = LoggerFactory.getLogger(ShiroSpringCache.class);
    private RedisTemplate<K,V> redisTemplate;
    private String name;

    @SuppressWarnings("rawtypes")
    public ShiroSpringCache(String name,RedisTemplate<K,V> redisTemplate) {
        this.redisTemplate=redisTemplate;
        this.name=name;
    }

    @Override
    public V get(K key) throws CacheException {
       ValueOperations<K,V> operations= redisTemplate.opsForValue();
        return  operations.get(key);
    }

    @Override
    public V put(K key, V value) throws CacheException {
        ValueOperations<K,V> operations= redisTemplate.opsForValue();
        return operations.getAndSet(key,value );
    }

    @Override
    public V remove(K key) throws CacheException {
        ValueOperations<K,V> operations= redisTemplate.opsForValue();
        V v=operations.get(key);
        redisTemplate.delete(key);
        return v;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
