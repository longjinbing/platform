package com.ljb.dao;

import com.ljb.entity.SysRoleDept;
import com.ljb.example.SysRoleDeptExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 角色部门Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Repository
public interface SysRoleDeptDao extends BaseDao<SysRoleDept,Integer,SysRoleDeptExample> {

}
