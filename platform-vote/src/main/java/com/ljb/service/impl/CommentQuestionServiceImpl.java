package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.CommentQuestionDao;
import com.ljb .entity.CommentQuestion;
import com.ljb.service.CommentQuestionService;
import com.ljb.example.CommentQuestionExample;

/**
 * 评价问题关联Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
@Service
public class CommentQuestionServiceImpl implements CommentQuestionService<CommentQuestion,Integer, CommentQuestionExample> {
    @Autowired
    private CommentQuestionDao commentQuestionDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = commentQuestionDao.selectMapList(query);
        Long total = commentQuestionDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public CommentQuestion selectById(Integer id) {
        return commentQuestionDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return commentQuestionDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return commentQuestionDao.deleteBatch(ids);
    }

    @Override
    public int save(CommentQuestion entity) {
                                                                                                                                    entity.setCreateId(IdentityUtils.getUserId());
                                                                        entity.setCreateTime(DateUtils.currentTime());
                                                            return commentQuestionDao.insert(entity);
    }

    @Override
    public int update(CommentQuestion entity) {
                                                                                                                                                                                                                return commentQuestionDao.updateByPrimaryKeySelective(entity);
    }

}
