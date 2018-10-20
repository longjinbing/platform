package com.ljb.dao;

import com.ljb.entity.CourseComment;
import com.ljb.example.CourseCommentExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 课程评价Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:12
 */
@Repository
public interface CourseCommentDao extends BaseDao<CourseComment,Integer,CourseCommentExample> {

}
