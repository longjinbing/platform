package com.ljb.service.impl;

import com.ljb.dao.SysRoleDao;
import com.ljb.dao.SysUserDao;
import com.ljb.dao.SysUserRoleDao;
import com.ljb.entity.Identity;
import com.ljb.entity.SysRole;
import com.ljb.entity.SysUser;
import com.ljb.entity.SysUserRole;
import com.ljb.example.*;
import com.ljb.security.IdentityUtils;
import com.ljb.service.SysUserService;
import com.ljb.service.UserImportService;
import com.ljb.utils.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 系统用户Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Service
public class SysUserServiceImpl implements SysUserService<SysUser, Integer, SysUserExample> {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
   private SysRoleDao sysRoleDao;
    @Autowired
    private UserImportService userImportService;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysUserDao.selectMapList(query);
        Long total = sysUserDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public PageUtils selectTList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysUserDao.selectMapTList(query);
        Long total = sysUserDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysUser selectById(Integer id) {
        return sysUserDao.selectByPrimaryKey(id);
    }

    @Override
    public FileResult saveBatch(MultipartFile file) {
        FileResult fileResult = userImportService.importByExcel(file);
        if (fileResult.getMsg() != FileResult.Success) {
            return fileResult;
        }
        return fileResult;
    }

    @Override
    public SysUser findByNumber(String number) {
        SysUserExample sysUserExample=new SysUserExample();
        sysUserExample.createCriteria().andNumberEqualTo(number);
       List<SysUser> sysUsers= sysUserDao.selectByExample(sysUserExample);
       if(sysUsers.size()==0){
           return null;
       }
        return sysUsers.get(0);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return sysUserDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        for (Object obj:ids){
            SysUserRoleExample sysUserRoleExample=new SysUserRoleExample();
            sysUserRoleExample.createCriteria().andRoleIdEqualTo(Integer.valueOf(obj.toString()));
            sysUserRoleDao.deleteByExample(sysUserRoleExample);
        }
        return sysUserDao.deleteBatch(ids);
    }

    @Override
    public int save(SysUser entity) {
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        entity.setPassword(SHA256Util.getSHA256Str(entity.getPassword()));
        entity.setStatus(1);
        sysUserDao.insert(entity);
        SysRoleExample sysRoleExample=new SysRoleExample();
        sysRoleExample.createCriteria().andNameEqualTo(Constant.MEMBER_ROLE);
        List<SysRole> sysRoles= sysRoleDao.selectByExample(sysRoleExample);
        if(sysRoles.size()>0){
            SysUserRole sysUserRole=new SysUserRole();
            if(SecurityUtils.getSubject().isAuthenticated()){
                sysUserRole.setCreateId(IdentityUtils.getUserId());
            }else{
                sysUserRole.setCreateId(entity.getId());
            }
            sysUserRole.setUserId(entity.getId());
            sysUserRole.setRoleId(sysRoles.get(0).getId());
            sysUserRole.setCreateTime(DateUtils.currentTime());
            sysUserRole.setUpdateTime(DateUtils.currentTime());
            sysUserRoleDao.insert(sysUserRole);
        }
        return 1;
    }

    @Override
    public int update(SysUser entity) {
        entity.setPassword(sysUserDao.selectByPrimaryKey(entity.getId()).getPassword());
        entity.setUpdateId(IdentityUtils.getUserId());
        entity.setUpdateTime(DateUtils.currentTime());
        return sysUserDao.updateByPrimaryKeySelective(entity);
    }

}
