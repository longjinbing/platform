package com.ljb.service.impl;

import com.ljb.cache.JedisPoolUtil;
import com.ljb.dao.SysUserRoleDao;
import com.ljb.entity.SysUserRole;
import com.ljb.example.SysUserRoleExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.SysUserRoleService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户角色Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService<SysUserRole, Integer, SysUserRoleExample> {
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public int save(Integer userId, Integer[] roleIds, Integer adminId) {
        JedisPoolUtil.clear("*SysRoleDao*");
        JedisPoolUtil.clear("*SysUserDao*");
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        sysUserRoleDao.deleteByExample(sysUserRoleExample);
        List<SysUserRole> list = new ArrayList<>();
        for (Integer roleId : roleIds) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(roleId);
            sysUserRole.setCreateId(adminId);
            sysUserRole.setCreateTime(DateUtils.currentTime());
            list.add(sysUserRole);
        }
        return sysUserRoleDao.saveBatch(list) > 0 ? 1 : 0;
    }

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysUserRoleDao.selectMapList(query);
        Long total = sysUserRoleDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysUserRole selectById(Integer id) {
        return sysUserRoleDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return sysUserRoleDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return sysUserRoleDao.deleteBatch(ids);
    }

    @Override
    public int save(SysUserRole entity) {
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        return sysUserRoleDao.insert(entity);
    }

    @Override
    public int update(SysUserRole entity) {
        entity.setUpdateId(IdentityUtils.getUserId());
        entity.setUpdateTime(DateUtils.currentTime());
        return sysUserRoleDao.updateByPrimaryKeySelective(entity);
    }

}
