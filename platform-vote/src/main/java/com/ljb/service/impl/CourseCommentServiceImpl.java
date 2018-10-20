package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.CourseCommentDao;
import com.ljb .entity.CourseComment;
import com.ljb.service.CourseCommentService;
import com.ljb.example.CourseCommentExample;

/**
 * 课程评价Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:12
 */
@Service
public class CourseCommentServiceImpl implements CourseCommentService<CourseComment,Integer, CourseCommentExample> {
    @Autowired
    private CourseCommentDao courseCommentDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = courseCommentDao.selectMapList(query);
        Long total = courseCommentDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public CourseComment selectById(Integer id) {
        return courseCommentDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return courseCommentDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return courseCommentDao.deleteBatch(ids);
    }

    @Override
    public int save(CourseComment entity) {
                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                            return courseCommentDao.insert(entity);
    }

    @Override
    public int update(CourseComment entity) {
                                                                                                                                                                                return courseCommentDao.updateByPrimaryKeySelective(entity);
    }

}
