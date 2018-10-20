package com.ljb.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ljb.dao.*;
import com.ljb.entity.Identity;
import com.ljb.entity.SysDept;
import com.ljb.entity.SysRoleDept;
import com.ljb.example.SysRoleDeptExample;
import com.ljb.example.SysRoleMenuExample;
import com.ljb.model.RoleDeptModel;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.*;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ljb .entity.SysRole;
import com.ljb.service.SysRoleService;
import com.ljb.example.SysRoleExample;

/**
 * 角色管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Service
public class SysRoleServiceImpl implements SysRoleService<SysRole,Integer, SysRoleExample> {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleDeptDao sysRoleDeptDao;
    @Autowired
    private SysDeptDao sysDeptDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public SysRole update(RoleDeptModel model){
        SysRole sysRole=sysRoleDao.selectByPrimaryKey(model.getId());
        sysRole.setName(model.getName());
        sysRole.setDescription(model.getDescription());
        sysRole.setRemark(model.getRemark());
        sysRole.setUpdateId(IdentityUtils.getUserId());
        sysRole.setUpdateTime(DateUtils.currentTime());
        sysRoleDao.updateByPrimaryKeySelective(sysRole);
        SysRoleDeptExample sysRoleDeptExample=new SysRoleDeptExample();
        sysRoleDeptExample.createCriteria().andDeptIdEqualTo(model.getDeptId()).andRoleIdEqualTo(sysRole.getId());
        List<SysRoleDept> sysRoleDepts=sysRoleDeptDao.selectByExample(sysRoleDeptExample);
        if(sysRoleDepts.size()>0){
            return sysRole;
        }else{
            sysRoleDeptExample.clear();
            sysRoleDeptExample.createCriteria().andRoleIdEqualTo(sysRole.getId());
            sysRoleDeptDao.deleteByExample(sysRoleDeptExample);
            SysRoleDept sysRoleDept=new SysRoleDept();
            sysRoleDept.setRoleId(sysRole.getId());
            sysRoleDept.setCreateId(IdentityUtils.getUserId());
            sysRoleDept.setDeptId(model.getDeptId());
            sysRoleDept.setCreateTime(DateUtils.currentTime());
            sysRoleDeptDao.insert(sysRoleDept);
            return sysRole;
        }
    }
    @Override
    public SysRole save(RoleDeptModel model){
        SysRole sysRole=new SysRole();
        sysRole.setName(model.getName());
        sysRole.setDescription(model.getDescription());
        sysRole.setRemark(model.getRemark());
        sysRole.setCreateId(IdentityUtils.getUserId());
        sysRole.setCreateTime(DateUtils.currentTime());
        sysRoleDao.insert(sysRole);
        SysRoleDept sysRoleDept=new SysRoleDept();
        sysRoleDept.setRoleId(sysRole.getId());
        sysRoleDept.setCreateId(IdentityUtils.getUserId());
        sysRoleDept.setDeptId(model.getDeptId());
        sysRoleDept.setCreateTime(DateUtils.currentTime());
        sysRoleDeptDao.insert(sysRoleDept);
        return sysRole;
    }

    @Override
    public List<Map<String, Object>> roleListByuserIdAndAdminId(Integer userId,Integer adminId){
        //登录账户所拥有的角色
        List<SysRole> allRoles;
        //判断是否是超级管理员
        if(SecurityUtils.getSubject().hasRole(Constant.SUPER_ADMIN)){
            allRoles=sysRoleDao.selectByExample(null);
        }else {
            allRoles = sysRoleDao.findByUserId(adminId);
        }
        //将赋予角色用户拥有的角色
        List<SysRole> hasRoles;
        hasRoles=sysRoleDao.findByUserId(userId);
        Map<Integer, Object> ids=new HashMap<>();
        for (SysRole role : hasRoles) {
            ids.put(role.getId(), "");
        }
        List<Map<String, Object>> result=new ArrayList<>();
        for (SysRole role : allRoles) {
            Map<String, Object> map=new HashMap<>();
            map.put("id", role.getId());
            map.put("name", role.getName());
            if(ids.containsKey(role.getId())) {
                map.put("checked", "checked");
            }else {
                map.put("checked", false);
            }
            result.add(map);
        }
        return result;
    }


    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysRoleDao.selectMapList(query);
        Long total = sysRoleDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysRole selectById(Integer id) {
        return sysRoleDao.selectByPrimaryKey(id);
    }

    @Override
    public Object selectByRole(Integer id) {
        SysRole sysRole=sysRoleDao.selectByPrimaryKey(id);
        Map<String,Object> map=new HashMap<>();
        map=BeanUtils.bean2Map(sysRole, true);
        SysDept sysDept=sysDeptDao.findByRole(sysRole.getId());
        map.put("deptId", sysDept.getId());
        map.put("deptName",sysDept.getName());
        return map;
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return sysRoleDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        for (Object obj:ids){
            SysRoleDeptExample sysRoleDeptExample=new SysRoleDeptExample();
            sysRoleDeptExample.createCriteria().andRoleIdEqualTo(Integer.valueOf(obj.toString()));
            sysRoleDeptDao.deleteByExample(sysRoleDeptExample);
            SysRoleMenuExample sysRoleMenuExample=new SysRoleMenuExample();
            sysRoleDeptExample.createCriteria().andRoleIdEqualTo(Integer.valueOf(obj.toString()));
            sysRoleMenuDao.deleteByExample(sysRoleMenuExample);
        }
        return sysRoleDao.deleteBatch(ids);
    }

    @Override
    public int save(SysRole entity) {
                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                                                                                                                                                            return sysRoleDao.insert(entity);
    }

    @Override
    public int update(SysRole entity) {
                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                                                                                            return sysRoleDao.updateByPrimaryKeySelective(entity);
    }

}
