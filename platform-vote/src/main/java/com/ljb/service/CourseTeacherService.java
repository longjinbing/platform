package com.ljb.service;

import com.ljb.entity.CourseTeacher;
import com.ljb.utils.BaseService;

/**
 * 课程教师Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 21:49:00
 */
public interface CourseTeacherService<T,K,E> extends BaseService<T,K,E> {
    CourseTeacher selectByCourse(Integer id);
}
