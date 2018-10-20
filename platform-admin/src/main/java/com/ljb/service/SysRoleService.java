package com.ljb.service;

import com.ljb.model.RoleDeptModel;
import com.ljb.utils.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 角色管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
public interface SysRoleService<T,K,E> extends BaseService<T,K,E> {
    T update(RoleDeptModel model);
    T save(RoleDeptModel model);
    List<Map<String, Object>> roleListByuserIdAndAdminId(Integer userId, Integer adminId);
    Object selectByRole(Integer id);
}
