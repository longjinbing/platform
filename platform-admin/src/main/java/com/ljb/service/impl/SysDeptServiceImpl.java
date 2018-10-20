package com.ljb.service.impl;

import com.ljb.dao.SysDeptDao;
import com.ljb.dao.SysRoleDeptDao;
import com.ljb.entity.SysDept;
import com.ljb.example.SysDeptExample;
import com.ljb.example.SysRoleDeptExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.SysDeptService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import com.ljb.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 部门管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Service
public class SysDeptServiceImpl implements SysDeptService<SysDept, Integer, SysDeptExample> {
    @Autowired
    private SysDeptDao sysDeptDao;
    @Autowired
    private SysRoleDeptDao sysRoleDeptDao;

    @Override
    public Collection<Object> zTreeList(Integer userId) {
        List<SysDept> depts;
        depts = sysDeptDao.selectByExample(null);
        return TreeUtils.buildTree(depts);
    }

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysDeptDao.selectMapList(query);
        Long total = sysDeptDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysDept selectById(Integer id) {
        return sysDeptDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return sysDeptDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        for (Object obj : ids) {
            SysRoleDeptExample sysRoleDeptExample = new SysRoleDeptExample();
            sysRoleDeptExample.createCriteria().andDeptIdEqualTo(Integer.valueOf(obj.toString()));
            sysRoleDeptDao.deleteByExample(sysRoleDeptExample);
        }
        return sysDeptDao.deleteBatch(ids);
    }

    @Override
    public int save(SysDept entity) {
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        return sysDeptDao.insert(entity);
    }

    @Override
    public int update(SysDept entity) {
        entity.setUpdateId(IdentityUtils.getUserId());
        entity.setUpdateTime(DateUtils.currentTime());
        return sysDeptDao.updateByPrimaryKeySelective(entity);
    }

}
