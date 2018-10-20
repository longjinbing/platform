package com.ljb.dao;

import com.ljb.entity.GradesUser;
import com.ljb.example.GradesUserExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 班级用户Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
@Repository
public interface GradesUserDao extends BaseDao<GradesUser,Integer,GradesUserExample> {

}
