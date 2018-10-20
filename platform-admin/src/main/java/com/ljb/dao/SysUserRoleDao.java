package com.ljb.dao;

import com.ljb.entity.SysUserRole;
import com.ljb.example.SysUserRoleExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 用户角色Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Repository
public interface SysUserRoleDao extends BaseDao<SysUserRole,Integer,SysUserRoleExample> {

}
