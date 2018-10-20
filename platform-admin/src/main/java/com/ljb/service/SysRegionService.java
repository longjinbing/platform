package com.ljb.service;

import com.ljb.utils.BaseService;

import java.util.Collection;

/**
 * 地区管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-14 09:04:53
 */
public interface SysRegionService<T,K,E> extends BaseService<T,K,E> {
    Collection<Object> zTreeList();
}
