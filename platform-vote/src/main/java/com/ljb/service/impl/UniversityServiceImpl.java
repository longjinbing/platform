package com.ljb.service.impl;

import com.ljb.dao.RegionDao;
import com.ljb.entity.Region;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.UniversityDao;
import com.ljb .entity.University;
import com.ljb.service.UniversityService;
import com.ljb.example.UniversityExample;

/**
 * 学校管理Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Service
public class UniversityServiceImpl implements UniversityService<University,Integer, UniversityExample> {
    @Autowired
    private UniversityDao universityDao;
    @Autowired
    private RegionDao regionDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = universityDao.selectMapList(query);
        Long total = universityDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public University selectById(Integer id) {
        return universityDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return universityDao.selectMapById(id);
    }


    @Override
    public List<Map<String,Object>> schoolList() {
        List<Map<String,Object>> regions=regionDao.schoolList();
        return regions;
    }
    @Override
    public List<Map<String,Object>> collegeList() {
        List<Map<String,Object>> colleges=regionDao.collegeList();
        return colleges;
    }

    @Override
    public List<Map<String,Object>> teacherList() {
        List<Map<String,Object>> colleges=regionDao.teacherList();
        return colleges;
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return universityDao.deleteBatch(ids);
    }

    @Override
    public int save(University entity) {
                                                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                                                                                            return universityDao.insert(entity);
    }

    @Override
    public int update(University entity) {
                                                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                            return universityDao.updateByPrimaryKeySelective(entity);
    }

}
