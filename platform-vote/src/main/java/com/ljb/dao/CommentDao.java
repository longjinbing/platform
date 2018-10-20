package com.ljb.dao;

import com.ljb.entity.Comment;
import com.ljb.example.CommentExample;
import com.ljb.utils.BaseDao;
import com.ljb.utils.PageUtils;
import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 评价管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
@Repository
public interface CommentDao extends BaseDao<Comment,Integer,CommentExample> {
    List<Map<String, Object>> selectMapHList(Map<String, Object> map);
    Long selectHCount(Map<String, Object> map);
}
