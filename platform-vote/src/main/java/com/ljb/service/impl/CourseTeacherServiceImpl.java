package com.ljb.service.impl;

import com.ljb.annotion.Desc;
import com.ljb.dao.SysRoleDao;
import com.ljb.dao.SysUserRoleDao;
import com.ljb.entity.SysRole;
import com.ljb.example.SysRoleExample;
import com.ljb.example.SysUserRoleExample;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import com.ljb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.CourseTeacherDao;
import com.ljb .entity.CourseTeacher;
import com.ljb.service.CourseTeacherService;
import com.ljb.example.CourseTeacherExample;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 课程教师Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 21:49:00
 */
@Service
public class CourseTeacherServiceImpl implements CourseTeacherService<CourseTeacher,Integer, CourseTeacherExample> {
    @Autowired
    private CourseTeacherDao courseTeacherDao;
    @Autowired
    SysUserRoleDao sysUserRoleDao;
    @Autowired
    SysRoleDao sysRoleDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = courseTeacherDao.selectMapList(query);
        Long total = courseTeacherDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public CourseTeacher selectById(Integer id) {
        return courseTeacherDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return courseTeacherDao.selectMapById(id);
    }
    @Override
    public CourseTeacher selectByCourse(Integer id) {
        CourseTeacherExample courseTeacherExample=new CourseTeacherExample();
        courseTeacherExample.createCriteria().andCourseIdEqualTo(id);
        List<CourseTeacher> courseTeachers=courseTeacherDao.selectByExample(courseTeacherExample);
        if(courseTeachers.size()==0){
            return null;
        }
        return courseTeachers.get(0);
    }


    @Override
    public int deleteBatch(Object[] ids) {
        return courseTeacherDao.deleteBatch(ids);
    }

    @Override
    public int save(CourseTeacher entity) {
                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                            return courseTeacherDao.insert(entity);
    }

    @Override
    public int update(CourseTeacher entity) {
                                                                                                                                                                                return courseTeacherDao.updateByPrimaryKeySelective(entity);
    }

}
