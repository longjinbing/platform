package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.CollegeDao;
import com.ljb .entity.College;
import com.ljb.service.CollegeService;
import com.ljb.example.CollegeExample;

/**
 * 学院管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Service
public class CollegeServiceImpl implements CollegeService<College,Integer, CollegeExample> {
    @Autowired
    private CollegeDao collegeDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = collegeDao.selectMapList(query);
        Long total = collegeDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public College selectById(Integer id) {
        return collegeDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return collegeDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return collegeDao.deleteBatch(ids);
    }

    @Override
    public int save(College entity) {
                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                                                                                                                            return collegeDao.insert(entity);
    }

    @Override
    public int update(College entity) {
                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                            return collegeDao.updateByPrimaryKeySelective(entity);
    }

}
