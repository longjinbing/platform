package com.ljb.dao;

import com.ljb.entity.SysMenu;
import com.ljb.example.SysMenuExample;
import com.ljb.utils.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单管理Dao
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
@Repository
public interface SysMenuDao extends BaseDao<SysMenu,Integer,SysMenuExample> {

    List<SysMenu> menuList(Integer id);

    List<String> urlList(Integer id);

    List<String> allPermission();

    List<SysMenu> findByStatusAndUserId(Integer id);

    List<SysMenu> findByUserId(Integer id);

    List<SysMenu>  findByRoleId(Integer id);

}
