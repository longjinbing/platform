package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.SysLoginLogDao;
import com.ljb .entity.SysLoginLog;
import com.ljb.service.SysLoginLogService;
import com.ljb.example.SysLoginLogExample;

/**
 * 系统日志Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 16:51:52
 */
@Service
public class SysLoginLogServiceImpl implements SysLoginLogService<SysLoginLog,Integer, SysLoginLogExample> {
    @Autowired
    private SysLoginLogDao sysLoginLogDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysLoginLogDao.selectMapList(query);
        Long total = sysLoginLogDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysLoginLog selectById(Integer id) {
        return sysLoginLogDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return sysLoginLogDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return sysLoginLogDao.deleteBatch(ids);
    }

    @Override
    public int save(SysLoginLog entity) {
                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                                                                                                                                                                                            return sysLoginLogDao.insert(entity);
    }

    @Override
    public int update(SysLoginLog entity) {
                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                                                                                                                            return sysLoginLogDao.updateByPrimaryKeySelective(entity);
    }

}
