package com.ljb.dao;

import com.ljb.entity.CommentResultDetails;
import com.ljb.example.CommentResultDetailsExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 评价结果明细Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-19 12:53:57
 */
@Repository
public interface CommentResultDetailsDao extends BaseDao<CommentResultDetails,Integer,CommentResultDetailsExample> {

}
