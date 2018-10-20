package com.ljb.service.impl;

import com.ljb.dao.CourseTeacherDao;
import com.ljb.dao.SysRoleDao;
import com.ljb.dao.SysUserRoleDao;
import com.ljb.entity.CourseTeacher;
import com.ljb.entity.SysRole;
import com.ljb.entity.SysUserRole;
import com.ljb.example.CourseTeacherExample;
import com.ljb.example.SysRoleExample;
import com.ljb.example.SysUserRoleExample;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.CollegeUserDao;
import com.ljb .entity.CollegeUser;
import com.ljb.service.CollegeUserService;
import com.ljb.example.CollegeUserExample;

/**
 * 学院教师Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 21:49:00
 */
@Service
public class CollegeUserServiceImpl implements CollegeUserService<CollegeUser,Integer, CollegeUserExample> {
    @Autowired
    private CollegeUserDao collegeUserDao;
    @Autowired
    SysUserRoleDao sysUserRoleDao;
    @Autowired
    SysRoleDao sysRoleDao;
    @Autowired
    CourseTeacherDao courseTeacherDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = collegeUserDao.selectMapTList(query);
        Long total = collegeUserDao.selectTCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public CollegeUser selectById(Integer id) {
        CollegeUserExample collegeUserExample=new CollegeUserExample();
        collegeUserExample.createCriteria().andUserIdEqualTo(id);
        return collegeUserDao.selectByExample(collegeUserExample).get(0);
    }

    @Override
    public CollegeUser selectByUser(Integer id) {
        CollegeUserExample collegeUserExample=new CollegeUserExample();
        collegeUserExample.createCriteria().andUserIdEqualTo(id);
        List<CollegeUser> collegeUsers=collegeUserDao.selectByExample(collegeUserExample);
        if(collegeUsers.size()==0){
            return null;
        }
        return collegeUsers.get(0);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return collegeUserDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        SysRoleExample sysRoleExample=new SysRoleExample();
        sysRoleExample.createCriteria().andNameEqualTo("教师");
        SysRole sysRole=sysRoleDao.selectByExample(sysRoleExample).get(0);
        for(Integer id:(Integer[]) ids){
            SysUserRoleExample sysUserRoleExample=new SysUserRoleExample();
            sysUserRoleExample.createCriteria().andUserIdEqualTo(id).andRoleIdEqualTo(sysRole.getId());
            sysUserRoleDao.deleteByExample(sysUserRoleExample);
            CourseTeacherExample courseTeacherExample=new CourseTeacherExample();
            courseTeacherExample.createCriteria().andUserIdEqualTo(id);
            courseTeacherDao.deleteByExample(courseTeacherExample);
            CollegeUserExample collegeUserExample=new CollegeUserExample();
            collegeUserExample.createCriteria().andUserIdEqualTo(id);
            collegeUserDao.deleteByExample(collegeUserExample);
        }
        return collegeUserDao.deleteBatch(ids);
    }

    @Override
    public int save(CollegeUser entity) {
                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                                                                                                                        return collegeUserDao.insert(entity);
    }

    @Override
    public int update(CollegeUser entity) {
                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                                                            return collegeUserDao.updateByPrimaryKeySelective(entity);
    }

}
