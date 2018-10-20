package com.ljb.dao;

import com.ljb.entity.CommentResult;
import com.ljb.example.CommentResultExample;
import com.ljb.utils.BaseDao;
import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 评价结果Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
@Repository
public interface CommentResultDao extends BaseDao<CommentResult,Integer,CommentResultExample> {
  List<Map<String, Object>> selectMapHList(Map<String, Object> map);
   Long selectHCount(Map<String, Object> map);
   Map<String, Object> selectHMapById(Integer id);
    List<Map<String, Object>> selectMapResultList(Map<String, Object> map);
    Long selectResultCount(Map<String, Object> map);
    int complete(Integer id);
}
