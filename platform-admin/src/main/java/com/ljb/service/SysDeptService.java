package com.ljb.service;

import com.ljb.utils.BaseService;

import java.util.Collection;

/**
 * 部门管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
public interface SysDeptService<T,K,E> extends BaseService<T,K,E> {
    Collection<Object> zTreeList(Integer userId);
}
