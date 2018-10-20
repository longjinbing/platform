package com.ljb.dao;

import com.ljb.entity.CommentQuestion;
import com.ljb.example.CommentQuestionExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 评价问题关联Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
@Repository
public interface CommentQuestionDao extends BaseDao<CommentQuestion,Integer,CommentQuestionExample> {

}
