package com.ljb.dao;

import com.ljb.entity.Question;
import com.ljb.example.QuestionExample;
import com.ljb.utils.BaseDao;
import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 评价问题Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
@Repository
public interface QuestionDao extends BaseDao<Question,Integer,QuestionExample> {
    List<Map<String, Object>> questionList(Integer type);
}
