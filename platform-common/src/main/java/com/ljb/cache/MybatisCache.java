package com.ljb.cache;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/13<br>
 * 描述: <br>
 */
public class MybatisCache implements Cache{
    private static final Logger logger = LoggerFactory.getLogger(MybatisCache.class);
    private static JedisConnectionFactory jedisConnectionFactory;
    RedisSerializer<Object> jdkSerializer = new GenericJackson2JsonRedisSerializer();
    RedisSerializer<String> stringSerializer = new StringRedisSerializer();
    private Jedis jedis;
    private final String id;
    /**
     * The {@code ReadWriteLock}.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MybatisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug("MybatisRedisCache:id=" + id);
        jedis=JedisPoolUtil.getJedisPool().getResource();
        this.id = id;
    }

    public byte[] getKey(Object key) {
        CacheKey cacheKey=(CacheKey)key;
        Field field= null;
        List<Object> updateList=new ArrayList<>();
        String result="";
        try {
            field = cacheKey.getClass().getDeclaredField("updateList");
            field.setAccessible(true);
            updateList=(List)field.get(cacheKey);
            for(int i=0;i<updateList.size()-1;i++){
                if(i==0){
                    result+=updateList.get(i).toString().replace("com.ljb.dao.", "m-");
                    i=i+3;
                    String sql=updateList.get(i).toString();
                    if(sql.indexOf("LIMIT")>-1){
                        sql=sql.substring(sql.indexOf("LIMIT")+6);
                    }else{
                        sql="";
                    }
                    result+=":"+sql;
                }else{
                    result+="-"+updateList.get(i);
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result.getBytes();
    }

    @Override
    public void clear()
    {
        Set<String> keys=jedis.keys("*"+this.id.replace("com.ljb.dao.", "")+"*");
        for(String key:keys){
            jedis.del(key);
        }
    }

    @Override
    public String getId()
    {
        return this.id;
    }

    @Override
    public Object getObject(Object key)
    {
        Object result = null;
        try
        {
            result = jdkSerializer.deserialize(jedis.get(getKey(key))); //利用其反序列化方法获取值
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ReadWriteLock getReadWriteLock()
    {
        return this.readWriteLock;
    }

    @Override
    public int getSize()
    {
        int result = 0;
        try
        {
            result = Integer.valueOf(jedis.dbSize().toString());
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void putObject(Object key, Object value)
    {
        try
        {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value);
            jedis.set(getKey(key), jdkSerializer.serialize(value)); //利用其序列化方法将数据写入redis服务的缓存中

        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Object removeObject(Object key)
    {
        Object result = null;
        try
        {
            result =jedis.expire(getKey(key), 0);
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
       MybatisCache.jedisConnectionFactory = jedisConnectionFactory;
    }
}
