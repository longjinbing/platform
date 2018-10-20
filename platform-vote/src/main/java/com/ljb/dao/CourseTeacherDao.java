package com.ljb.dao;

import com.ljb.entity.CourseTeacher;
import com.ljb.example.CourseTeacherExample;
import com.ljb.utils.BaseDao;
import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 课程教师Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 21:49:00
 */
@Repository
public interface CourseTeacherDao extends BaseDao<CourseTeacher,Integer,CourseTeacherExample> {

}
