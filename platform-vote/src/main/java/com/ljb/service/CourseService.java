package com.ljb.service;

import com.ljb.utils.BaseService;
import com.ljb.utils.PageUtils;

import java.util.Map;

/**
 * 课程管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
public interface CourseService<T,K,E> extends BaseService<T,K,E> {
    PageUtils selectHList(Map<String, Object> map);
}
