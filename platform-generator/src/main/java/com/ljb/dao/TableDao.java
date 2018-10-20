package com.ljb.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/9<br>
 * 描述: <br>
 */
@Repository
public interface TableDao {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    Long queryTotal(Map<String,Object> map);

    Map<String, Object> queryTable(String tableName);

    List<Map<String, Object>> queryColumns(String tableName);
}
