package com.ljb.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ljb.dao.*;
import com.ljb.entity.CollegeUser;
import com.ljb.entity.Course;
import com.ljb.entity.CourseTeacher;
import com.ljb.example.*;
import com.ljb.security.IdentityUtils;
import com.ljb.service.CourseService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 课程管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Service
public class CourseServiceImpl implements CourseService<Course, Integer, CourseExample> {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    CourseTeacherDao courseTeacherDao;
    @Autowired
    CollegeUserDao collegeUserDao;
@Autowired
    CourseCommentDao courseCommentDao;
@Autowired
    CourseUserDao courseUserDao;
    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = courseDao.selectMapList(query);
        Long total = courseDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public PageUtils selectHList(Map<String, Object> map) {
        map.put("pid", IdentityUtils.getUserId());
        Query query = new Query(map);
        List<Map<String, Object>> list = courseDao.selectMapHList(query);
        Long total = courseDao.selectHCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public Course selectById(Integer id) {
        return courseDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return courseDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        for(Integer id:(Integer[]) ids){
            Course course=courseDao.selectByPrimaryKey(id);
            CourseTeacherExample courseTeacherExample=new CourseTeacherExample();
            courseTeacherExample.createCriteria().andCourseIdEqualTo(course.getId());
            courseTeacherDao.deleteByExample(courseTeacherExample);
            CourseCommentExample courseCommentExample=new CourseCommentExample();
            courseCommentExample.createCriteria().andCourseIdEqualTo(course.getId());
            courseCommentDao.deleteByExample(courseCommentExample);
            CourseUserExample courseUserExample=new CourseUserExample();
            courseUserExample.createCriteria().andCourseIdEqualTo(course.getId());
            courseUserDao.deleteByExample(courseUserExample);
        }
        return courseDao.deleteBatch(ids);
    }

    @Override
    public int save(Course entity) {
        CollegeUserExample collegeUserExample=new CollegeUserExample();
        collegeUserExample.createCriteria().andUserIdEqualTo(IdentityUtils.getUserId());
        List<CollegeUser> collegeUsers=collegeUserDao.selectByExample(collegeUserExample);
        if(collegeUsers.size()>0){
            entity.setCollegeId(collegeUsers.get(0).getCollegeId());
        }
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        entity.setStatus(1);
        courseDao.insert(entity);
        CourseTeacher courseTeacher=new CourseTeacher();
        courseTeacher.setCourseId(entity.getId());
        courseTeacher.setUserId(IdentityUtils.getUserId());
        courseTeacher.setCreateId(IdentityUtils.getUserId());
        courseTeacher.setCreateTime(DateUtils.currentTime());
        return courseTeacherDao.insert(courseTeacher);
    }

    @Override
    public int update(Course entity) {
        entity.setUpdateId(IdentityUtils.getUserId());
        entity.setUpdateTime(DateUtils.currentTime());
        return courseDao.updateByPrimaryKeySelective(entity);
    }

}
