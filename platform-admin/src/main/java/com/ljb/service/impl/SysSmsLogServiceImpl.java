package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.SysSmsLogDao;
import com.ljb .entity.SysSmsLog;
import com.ljb.service.SysSmsLogService;
import com.ljb.example.SysSmsLogExample;

/**
 * 短信日志Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:05:13
 */
@Service
public class SysSmsLogServiceImpl implements SysSmsLogService<SysSmsLog,Integer, SysSmsLogExample> {
    @Autowired
    private SysSmsLogDao sysSmsLogDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysSmsLogDao.selectMapList(query);
        Long total = sysSmsLogDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysSmsLog selectById(Integer id) {
        return sysSmsLogDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return sysSmsLogDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return sysSmsLogDao.deleteBatch(ids);
    }

    @Override
    public int save(SysSmsLog entity) {
                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                                                                                        entity.setCreateTime(DateUtils.currentTime());
                                                                                                                                                                                                                                                                                                                                                            return sysSmsLogDao.insert(entity);
    }

    @Override
    public int update(SysSmsLog entity) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                return sysSmsLogDao.updateByPrimaryKeySelective(entity);
    }

}
