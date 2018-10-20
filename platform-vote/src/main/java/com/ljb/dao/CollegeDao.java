package com.ljb.dao;

import com.ljb.entity.College;
import com.ljb.example.CollegeExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 学院管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Repository
public interface CollegeDao extends BaseDao<College,Integer,CollegeExample> {

}
