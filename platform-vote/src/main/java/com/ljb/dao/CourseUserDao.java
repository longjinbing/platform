package com.ljb.dao;

import com.ljb.entity.CourseUser;
import com.ljb.example.CourseUserExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 课程学生Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Repository
public interface CourseUserDao extends BaseDao<CourseUser,Integer,CourseUserExample> {

}
