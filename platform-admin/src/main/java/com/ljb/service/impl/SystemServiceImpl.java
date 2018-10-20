package com.ljb.service.impl;

import com.ljb.annotion.DescBean;
import com.ljb.cache.JedisPoolUtil;
import com.ljb.dao.*;
import com.ljb.entity.*;
import com.ljb.security.IdentityUtils;
import com.ljb.service.SystemService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.SHA256Util;
import com.ljb.utils.ZTree;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/15<br>
 * 描述: <br>
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysDeptDao sysDeptDao;
    @Autowired
    private SysRoleDeptDao sysRoleDeptDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private DescBean descBean;
    @Autowired
    private SysLogDao sysLogDao;
    @Autowired
    private SysLoginLogDao sysLoginLogDao;
    @Autowired
    private TokenDao tokenDao;

    @Override
    public void initSystem() {
            JedisPoolUtil.clear();
            sysMenuDao.deleteByExample(null);
            sysUserDao.deleteByExample(null);
            sysRoleDao.deleteByExample(null);
            sysDeptDao.deleteByExample(null);
            sysRoleDeptDao.deleteByExample(null);
            sysRoleMenuDao.deleteByExample(null);
            sysUserRoleDao.deleteByExample(null);
            sysLogDao.deleteByExample(null);
            sysLoginLogDao.deleteByExample(null);
            tokenDao.deleteByExample(null);

            SysUser sysUser=new SysUser();
            sysUser.setUsername("龙锦兵");
            sysUser.setNumber("201501014027");
            sysUser.setPassword(SHA256Util.getSHA256Str("123456"));
            sysUser.setStatus(1);
            sysUser.setEmail("1106335838@qq.com");
            sysUser.setCreateTime(DateUtils.currentTime());
            sysUser.setCreateId(0);
            sysUser.setMobile("15879598195");
            sysUserDao.insert(sysUser);
            sysUser.setUpdateTime(DateUtils.currentTime());
            sysUser.setUpdateId(sysUser.getId());
            sysUser.setCreateId(sysUser.getId());
            sysUserDao.updateByPrimaryKeySelective(sysUser);

            SysDept sysDept=new SysDept();
            sysDept.setName("总部");
            sysDept.setParentId(0);
            sysDept.setCreateTime(DateUtils.currentTime());
            sysDept.setOrderNum(1);
            sysDept.setCreateId(sysUser.getId());
            sysDeptDao.insert(sysDept);

            SysRole sysRole=null;
            String[] roles=new String[]{"注册会员","教师","学生","超级管理员"};
            for(int i=0;i<4;i++){
                sysRole=new SysRole();
                sysRole.setName(roles[i]);
                sysRole.setDescription("权限");
                sysRole.setCreateTime(DateUtils.currentTime());
                sysRole.setCreateId(sysUser.getId());
                sysRole.setIsDelete(0);
                sysRoleDao.insert(sysRole);
                SysRoleDept sysRoleDept=new SysRoleDept();
                sysRoleDept.setRoleId(sysRole.getId());
                sysRoleDept.setDeptId(sysDept.getId());
                sysRoleDept.setCreateId(sysUser.getId());
                sysRoleDept.setCreateTime(DateUtils.currentTime());
                sysRoleDeptDao.insert(sysRoleDept);
            }
            SysUserRole sysUserRole=new SysUserRole();
            sysUserRole.setRoleId(sysRole.getId());
            sysUserRole.setUserId(sysUser.getId());
            sysUserRole.setCreateId(sysUser.getId());
            sysUserRole.setCreateTime(DateUtils.currentTime());
            sysUserRoleDao.insert(sysUserRole);

            List<SysMenu> result=new ArrayList<>();
            List<ZTree> ztreeList=descBean.getZtree();
            for (ZTree root : ztreeList) {
                int rootNum=1;
                List<ZTree> menuList=root.getChildren();
                SysMenu r=new SysMenu();
                r.setName(root.getName());
                r.setIcon(root.getIcon());
                r.setOrderNum(rootNum);
                r.setType(0);
                r.setParentId(0);
                r.setStatus(1);
                r.setUrl("#");
                r.setStatus(root.getChecked()?1:0);
                r.setCreateTime(DateUtils.currentTime());
                r.setCreateId(sysUser.getId());
                r.setUpdateTime(DateUtils.currentTime());
                sysMenuDao.insert(r);
                result.add(r);
                rootNum++;
                int menuNum=1;
                if(menuList!=null) {
                    for (ZTree menu : menuList) {
                        SysMenu m=new SysMenu();
                        m.setName(menu.getName());
                        m.setIcon(menu.getIcon());
                        m.setOrderNum(menuNum);
                        m.setType(1);
                        m.setParentId(r.getId());
                        m.setUrl(menu.getUrl());
                        m.setStatus(menu.getChecked()?1:0);
                        m.setCreateTime(DateUtils.currentTime());
                        m.setUpdateTime(DateUtils.currentTime());
                        m.setCreateId(sysUser.getId());
                        sysMenuDao.insert(m);
                        result.add(m);
                        menuNum++;
                        List<ZTree>	buttonList=menu.getChildren();
                        int buttonNum=1;
                        if(buttonList!=null) {
                            for (ZTree button : buttonList) {
                                SysMenu b=new SysMenu();
                                b.setName(button.getName());
                                b.setIcon(button.getIcon());
                                b.setOrderNum(buttonNum);
                                b.setType(2);
                                b.setParentId(m.getId());
                                b.setUrl(button.getUrl());
                                b.setStatus(button.getChecked()?1:0);
                                b.setCreateTime(DateUtils.currentTime());
                                b.setUpdateTime(DateUtils.currentTime());
                                b.setCreateId(sysUser.getId());
                                sysMenuDao.insert(b);
                                result.add(b);
                                buttonNum++;
                            }
                        }
                    }
                }
            }

            List<SysRoleMenu> sysRoleMenus=new ArrayList<>();
            for (SysMenu sysMenu:result){
                SysRoleMenu sysRoleMenu=new SysRoleMenu();
                sysRoleMenu.setRoleId(sysRole.getId());
                sysRoleMenu.setMenuId(sysMenu.getId());
                sysRoleMenu.setCreateId(sysUser.getId());
                sysRoleMenu.setCreateTime(DateUtils.currentTime());
                sysRoleMenus.add(sysRoleMenu);
            }
            sysRoleMenuDao.saveBatch(sysRoleMenus);
    }
}
