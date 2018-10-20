package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.GradesDao;
import com.ljb .entity.Grades;
import com.ljb.service.GradesService;
import com.ljb.example.GradesExample;

/**
 * 班级管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Service
public class GradesServiceImpl implements GradesService<Grades,Integer, GradesExample> {
    @Autowired
    private GradesDao gradesDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = gradesDao.selectMapList(query);
        Long total = gradesDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public Grades selectById(Integer id) {
        return gradesDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return gradesDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return gradesDao.deleteBatch(ids);
    }

    @Override
    public int save(Grades entity) {
                                                                                                                entity.setCreateTime(DateUtils.currentTime());
                                                                                entity.setCreateId(IdentityUtils.getUserId());
                                                                                                                                                                        return gradesDao.insert(entity);
    }

    @Override
    public int update(Grades entity) {
                                                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                                                            return gradesDao.updateByPrimaryKeySelective(entity);
    }

}
