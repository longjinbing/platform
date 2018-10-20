package com.ljb.service;

import com.ljb.entity.CollegeUser;
import com.ljb.utils.BaseService;

/**
 * 学院教师Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 21:49:00
 */
public interface CollegeUserService<T,K,E> extends BaseService<T,K,E> {
    CollegeUser selectByUser(Integer id);
}
