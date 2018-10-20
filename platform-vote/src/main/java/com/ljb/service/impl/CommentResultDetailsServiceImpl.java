package com.ljb.service.impl;

import com.ljb.security.IdentityUtils;
import com.ljb.utils.DateUtils;
import com.ljb.utils.PageUtils;
import com.ljb.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ljb.dao.CommentResultDetailsDao;
import com.ljb .entity.CommentResultDetails;
import com.ljb.service.CommentResultDetailsService;
import com.ljb.example.CommentResultDetailsExample;

/**
 * 评价结果明细Service实现类
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-19 12:53:57
 */
@Service
public class CommentResultDetailsServiceImpl implements CommentResultDetailsService<CommentResultDetails,Integer, CommentResultDetailsExample> {
    @Autowired
    private CommentResultDetailsDao commentResultDetailsDao;

    @Override
    public PageUtils selectList(Map<String, Object> map) {
        Query query = new Query(map);
        List<Map<String, Object>> list = commentResultDetailsDao.selectMapList(query);
        Long total = commentResultDetailsDao.selectCount(query);
        PageUtils pageUtils = new PageUtils(list, total, query.getOffset(), query.getLimit());
        return pageUtils;
    }

    @Override
    public CommentResultDetails selectById(Integer id) {
        return commentResultDetailsDao.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> selectMapById(Integer id) {
        return commentResultDetailsDao.selectMapById(id);
    }

    @Override
    public int deleteBatch(Object[] ids) {
        return commentResultDetailsDao.deleteBatch(ids);
    }

    @Override
    public int save(CommentResultDetails entity) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                entity.setCreateTime(DateUtils.currentTime());
                                                entity.setCreateId(IdentityUtils.getUserId());
                                                                                                                                        return commentResultDetailsDao.insert(entity);
    }

    @Override
    public int update(CommentResultDetails entity) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    entity.setUpdateId(IdentityUtils.getUserId());
                                                                        entity.setUpdateTime(DateUtils.currentTime());
                                                            return commentResultDetailsDao.updateByPrimaryKeySelective(entity);
    }

}
