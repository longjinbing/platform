package com.ljb.service;

import com.ljb.utils.BaseService;

/**
 * 用户票据Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-15 17:20:47
 */
public interface TokenService<T,K,E> extends BaseService<T,K,E> {
    void logout(Integer[] ids);
}
