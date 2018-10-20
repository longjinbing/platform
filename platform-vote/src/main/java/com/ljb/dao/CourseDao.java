package com.ljb.dao;

import com.ljb.entity.Course;
import com.ljb.example.CourseExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;
import java.util.*;

/**
 * 课程管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Repository
public interface CourseDao extends BaseDao<Course,Integer,CourseExample> {
    List<Map<String,Object>>  selectMapHList(Map<String,Object> map);
    Long  selectHCount(Map<String,Object> map);
}
