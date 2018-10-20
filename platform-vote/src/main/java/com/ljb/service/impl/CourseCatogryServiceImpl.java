package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.CourseCatogryDao;
import com.ljb .entity.CourseCatogry;
import com.ljb.service.CourseCatogryService;
import com.ljb.example.CourseCatogryExample;

/**
 * 课程分类Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-17 16:01:48
 */
@Service
public class CourseCatogryServiceImpl implements CourseCatogryService<CourseCatogry,Integer, CourseCatogryExample> {
    @Autowired
    private CourseCatogryDao courseCatogryDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = courseCatogryDao.selectMapList(query);
        Long total = courseCatogryDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public List<Map<String,Object>> allList() {
        return courseCatogryDao.allList();
    }

    @Override
    public CourseCatogry selectById(Integer id) {
        return courseCatogryDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return courseCatogryDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return courseCatogryDao.deleteBatch(ids);
    }

    @Override
    public int save(CourseCatogry entity) {
                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                                                                                            return courseCatogryDao.insert(entity);
    }

    @Override
    public int update(CourseCatogry entity) {
                                                                                                                                                                                                                                                return courseCatogryDao.updateByPrimaryKeySelective(entity);
    }

}
