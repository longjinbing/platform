package com.ljb.cache;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/13<br>
 * 描述: <br>
 */
public class JedisPoolUtil {
    private static JedisPool JEDIS_POOL = null;

    private JedisPoolUtil() {
    }

    public static JedisPool getJedisPool() {
        if (JEDIS_POOL == null) {
            synchronized (JedisPoolUtil.class) {
                if (JEDIS_POOL == null) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(500); // 500个连接
                    poolConfig.setMaxIdle(32);
                    // 最大的空闲连接
                    poolConfig.setMaxWaitMillis(100 * 1000);
                    // 最长的等待时间
                    poolConfig.setTestOnBorrow(true);
                    //获得一个jedis连接时检测可用性
                    JEDIS_POOL = new JedisPool(poolConfig, "127.0.0.1", 6379);
                }
            }
        }
        return JEDIS_POOL;
    }

    public static boolean remove(String key){
        if(getJedisPool().getResource().del(key)!=null){
              return true;
         };
        return false;
    }

    public static boolean remove(byte[] key){
        if(getJedisPool().getResource().del(key)!=null){
            return true;
        };
        return false;
    }

    public static boolean clear(String patter){
        Jedis jedis=getJedisPool().getResource();
        for(String key: jedis.keys(patter)){
         jedis.del(key);
        }
        return true;
    }

    public  static String get(String key){
        Jedis jedis=getJedisPool().getResource();
        return jedis.get(key);
    }

    public  static byte[] get(byte[] key){
        Jedis jedis=getJedisPool().getResource();
        return jedis.get(key);
    }

    public static void clear(){
        Jedis jedis=getJedisPool().getResource();
       Set<String> keys= jedis.keys("*");
       for(String key:keys){
           jedis.del(key);
       }
    }

}
