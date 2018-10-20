package com.ljb.service;

import com.ljb.utils.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 学校管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
public interface UniversityService<T,K,E> extends BaseService<T,K,E> {
    List<Map<String,Object>> teacherList();
    List<Map<String,Object>> schoolList();
    List<Map<String,Object>> collegeList();
}
