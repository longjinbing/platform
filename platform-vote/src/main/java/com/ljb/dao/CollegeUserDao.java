package com.ljb.dao;

import com.ljb.entity.CollegeUser;
import com.ljb.example.CollegeUserExample;
import com.ljb.utils.BaseDao;
import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 学院教师Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 21:49:00
 */
@Repository
public interface CollegeUserDao extends BaseDao<CollegeUser,Integer,CollegeUserExample> {
    List<Map<String, Object>> selectMapTList(Map<String, Object> map);
    Long selectTCount(Map<String, Object> map);
}
