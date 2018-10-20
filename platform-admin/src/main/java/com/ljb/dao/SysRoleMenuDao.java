package com.ljb.dao;

import com.ljb.entity.SysRoleMenu;
import com.ljb.example.SysRoleMenuExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * 角色菜单Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Repository
public interface SysRoleMenuDao extends BaseDao<SysRoleMenu,Integer,SysRoleMenuExample> {

}
