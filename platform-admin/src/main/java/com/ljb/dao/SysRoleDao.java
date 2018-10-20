package com.ljb.dao;

import com.ljb.entity.SysRole;
import com.ljb.example.SysRoleExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Repository
public interface SysRoleDao extends BaseDao<SysRole,Integer,SysRoleExample> {
    List<SysRole> findByUserId(Integer id);

    List<String> roleList(Integer id);
}
