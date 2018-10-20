package com.ljb.service.impl;

import com.ljb.dao.CourseUserDao;
import com.ljb.entity.CourseUser;
import com.ljb.entity.SysUser;
import com.ljb.example.CourseUserExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.CourseUserService;
import com.ljb.service.UserImportService;
import com.ljb.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 课程学生Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Service
public class CourseUserServiceImpl implements CourseUserService<CourseUser, Integer, CourseUserExample> {
    @Autowired
    private CourseUserDao courseUserDao;
    @Autowired
    private UserImportService userImportService;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = courseUserDao.selectMapList(query);
        Long total = courseUserDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public CourseUser selectById(Integer id) {
        return courseUserDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return courseUserDao.selectMapById(id);
    }
    @Override
    public FileResult saveBatch(MultipartFile file, Integer id) {
        FileResult fileResult = userImportService.importByExcel(file);
        if (fileResult.getMsg() != FileResult.Success) {
            return fileResult;
        }
        List<SysUser> users = (List<SysUser>) fileResult.getList();
        List<CourseUser> courseUsers = new ArrayList<>();
        for (SysUser user : users) {
            CourseUserExample courseUserExample=new CourseUserExample();
            courseUserExample.createCriteria().andCourseIdEqualTo(id).andUserIdEqualTo(user.getId());
            if(courseUserDao.selectByExample(courseUserExample).size()<=0) {
                CourseUser courseUser = new CourseUser();
                courseUser.setUserId(user.getId());
                courseUser.setCourseId(id);
                courseUser.setCreateId(IdentityUtils.getUserId());
                courseUser.setCreateTime(DateUtils.currentTime());
                courseUsers.add(courseUser);
            }
        }
        if(courseUsers.size()>0) {
            courseUserDao.saveBatch(courseUsers);
        }
        return fileResult;
    }


    @Override
    public int deleteBatch(Object[] ids) {
        return courseUserDao.deleteBatch(ids);
    }

    @Override
    public int save(CourseUser entity) {
        CourseUserExample courseUserExample=new CourseUserExample();
        courseUserExample.createCriteria().andUserIdEqualTo(entity.getUserId()).andCourseIdEqualTo(entity.getCourseId());
        if(courseUserDao.selectByExample(courseUserExample).size()>0){
            return 0;
        }
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        return courseUserDao.insert(entity);
    }

    @Override
    public int update(CourseUser entity) {
        return courseUserDao.updateByPrimaryKeySelective(entity);
    }

}
