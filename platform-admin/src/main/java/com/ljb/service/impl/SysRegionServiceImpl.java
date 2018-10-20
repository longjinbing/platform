package com.ljb.service.impl;

import com.ljb.entity.SysMenu;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import com.ljb.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import com.ljb.dao.SysRegionDao;
import com.ljb .entity.SysRegion;
import com.ljb.service.SysRegionService;
import com.ljb.example.SysRegionExample;

/**
 * 地区管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */
@Service
public class SysRegionServiceImpl implements SysRegionService<SysRegion,Integer, SysRegionExample> {
    @Autowired
    private SysRegionDao sysRegionDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = sysRegionDao.selectMapList(query);
        Long total = sysRegionDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public Collection<Object> zTreeList() {
        List<SysRegion> regions = sysRegionDao.zTreeList();
        return TreeUtils.buildTree(regions);
    }

    @Override
    public SysRegion selectById(Integer id) {
        return sysRegionDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return sysRegionDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return sysRegionDao.deleteBatch(ids);
    }

    @Override
    public int save(SysRegion entity) {
                                                                                                                                                                                return sysRegionDao.insert(entity);
    }

    @Override
    public int update(SysRegion entity) {
                                                                                                                                                                                return sysRegionDao.updateByPrimaryKeySelective(entity);
    }

}
