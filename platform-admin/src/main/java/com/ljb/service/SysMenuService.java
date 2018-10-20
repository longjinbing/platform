package com.ljb.service;

import com.ljb.utils.BaseService;

import java.util.Collection;

/**
 * 菜单管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
public interface SysMenuService<T,K,E> extends BaseService<T,K,E> {
    Boolean resetMenu();

    Collection<Object> menuList(Integer userId);

    Collection<Object> menuSelectList(Integer userId);

    Collection<Object> zTreeList(Integer userId);
}
