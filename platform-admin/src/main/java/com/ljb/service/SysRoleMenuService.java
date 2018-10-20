package com.ljb.service;

import com.ljb.utils.BaseService;

import java.util.Collection;

/**
 * 角色菜单Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
public interface SysRoleMenuService<T,K,E> extends BaseService<T,K,E> {
    int save(Integer roleId,Integer[] menuIds,Integer adminId);

    Collection<Object> menuList(Integer roleId, Integer adminId);
}
