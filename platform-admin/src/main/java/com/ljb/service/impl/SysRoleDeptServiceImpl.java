package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.SysRoleDeptDao;
import com.ljb .entity.SysRoleDept;
import com.ljb.service.SysRoleDeptService;
import com.ljb.example.SysRoleDeptExample;

/**
 * 角色部门Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Service
public class SysRoleDeptServiceImpl implements SysRoleDeptService<SysRoleDept,Integer, SysRoleDeptExample> {
    @Autowired
    private SysRoleDeptDao sysRoleDeptDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysRoleDeptDao.selectMapList(query);
        Long total = sysRoleDeptDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysRoleDept selectById(Integer id) {
        return sysRoleDeptDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return sysRoleDeptDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return sysRoleDeptDao.deleteBatch(ids);
    }

    @Override
    public int save(SysRoleDept entity) {
                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                                                                                            return sysRoleDeptDao.insert(entity);
    }

    @Override
    public int update(SysRoleDept entity) {
                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                            return sysRoleDeptDao.updateByPrimaryKeySelective(entity);
    }

}
