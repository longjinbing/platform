package com.ljb.service;

import com.ljb.utils.BaseService;

/**
 * 用户角色Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
public interface SysUserRoleService<T,K,E> extends BaseService<T,K,E> {
    int save(Integer userId,Integer[] roleIds,Integer adminId);
}
