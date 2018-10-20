package com.ljb.utils;

import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/8<br>
 * 描述: <br>
 */
public interface BaseDao<T,K,E> {

    Long countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(K id);

    int deleteBatch(Object ids);

    int insert(T entity);

    int insertSelective(T entity);

    int saveBatch(Collection list);

    int updateBatch(Collection list);

    List<T> selectByExample(E example);

    T selectByPrimaryKey(K id);

    int updateByExampleSelective(@Param("record") T entity, @Param("example") E example);

    int updateByExample(@Param("record") T entity, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    Map<String, Object> selectMapById(K id);

    List<Map<String, Object>> selectMapList(Map<String, Object> map);

    Long selectCount(Map<String, Object> map);

}
