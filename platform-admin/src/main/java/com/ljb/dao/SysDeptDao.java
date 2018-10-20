package com.ljb.dao;

import com.ljb.entity.SysDept;
import com.ljb.example.SysDeptExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 部门管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Repository
public interface SysDeptDao extends BaseDao<SysDept,Integer,SysDeptExample> {
SysDept findByRole(Integer id);
}
