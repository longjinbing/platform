package com.ljb.service;

import com.ljb.utils.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 课程分类Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-17 16:01:48
 */
public interface CourseCatogryService<T,K,E> extends BaseService<T,K,E> {
    List<Map<String,Object>> allList();
}
