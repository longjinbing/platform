package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.SysConfigDao;
import com.ljb .entity.SysConfig;
import com.ljb.service.SysConfigService;
import com.ljb.example.SysConfigExample;

/**
 * 系统配置Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */
@Service
public class SysConfigServiceImpl implements SysConfigService<SysConfig,Integer, SysConfigExample> {
    @Autowired
    private SysConfigDao sysConfigDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysConfigDao.selectMapList(query);
        Long total = sysConfigDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public SysConfig selectById(Integer id) {
        return sysConfigDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return sysConfigDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return sysConfigDao.deleteBatch(ids);
    }

    @Override
    public int save(SysConfig entity) {
                                                                                                                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                                                                                            return sysConfigDao.insert(entity);
    }

    @Override
    public int update(SysConfig entity) {
                                                                                                                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                            return sysConfigDao.updateByPrimaryKeySelective(entity);
    }

}
