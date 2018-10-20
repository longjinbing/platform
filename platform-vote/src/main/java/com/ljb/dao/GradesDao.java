package com.ljb.dao;

import com.ljb.entity.Grades;
import com.ljb.example.GradesExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 班级管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Repository
public interface GradesDao extends BaseDao<Grades,Integer,GradesExample> {

}
