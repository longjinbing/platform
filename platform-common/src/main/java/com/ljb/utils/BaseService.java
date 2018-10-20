package com.ljb.utils;

import org.apache.ibatis.annotations.Param;
import redis.clients.jedis.BinaryClient;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/10<br>
 * 描述: <br>
 */
public interface BaseService<T,K,E> {

    PageUtils selectList(Map<String,Object> map);

    T selectById(K id);

    Map<String,Object> selectMapById(K id);

    int deleteBatch(Object[] ids);

    int save(T entity);

    int update(T entity);
}
