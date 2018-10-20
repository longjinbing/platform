package com.ljb.dao;

import com.ljb.entity.University;
import com.ljb.example.UniversityExample;
import com.ljb.utils.BaseDao;
import com.ljb.utils.ZTree;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 学校管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Repository
public interface UniversityDao extends BaseDao<University,Integer,UniversityExample> {
    List<University> schoolList();
}
