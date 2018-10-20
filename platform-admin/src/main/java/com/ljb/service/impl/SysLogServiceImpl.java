package com.ljb.service.impl;

import com.ljb.dao.SysLogDao;
import com.ljb.entity.SysLog;
import com.ljb.example.SysLogExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.SysLogService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统日志Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 16:51:52
 */
@Service
public class SysLogServiceImpl implements SysLogService<SysLog, Integer, SysLogExample> {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysLogDao.selectMapList(query);
        Long total = sysLogDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysLog selectById(Integer id) {
        return sysLogDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> selectMapById(Integer id) {
        return sysLogDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return sysLogDao.deleteBatch(ids);
    }

    @Override
    public int complete(Object[] ids) {
        return sysLogDao.complete(ids);
    }

    @Override
    public int save(SysLog entity) {
        entity.setCreateId(IdentityUtils.getUserId());
        entity.setCreateTime(DateUtils.currentTime());
        return sysLogDao.insert(entity);
    }

    @Override
    public int update(SysLog entity) {
        entity.setUpdateTime(DateUtils.currentTime());
        entity.setUpdateId(IdentityUtils.getUserId());
        return sysLogDao.updateByPrimaryKeySelective(entity);
    }

}
