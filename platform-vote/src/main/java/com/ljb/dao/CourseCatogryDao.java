package com.ljb.dao;

import com.ljb.entity.CourseCatogry;
import com.ljb.example.CourseCatogryExample;
import com.ljb.utils.BaseDao;
import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 课程分类Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-17 16:01:48
 */
@Repository
public interface CourseCatogryDao extends BaseDao<CourseCatogry,Integer,CourseCatogryExample> {
    List<Map<String,Object>> allList();
}
