package com.ljb.service;

import com.ljb.entity.QuestionAnswer;
import com.ljb.utils.BaseService;
import com.ljb.utils.PageUtils;

import java.util.Map;

/**
 * 评价结果Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
public interface CommentResultService<T,K,E> extends BaseService<T,K,E> {
    PageUtils selectHList(Map<String, Object> map);
    Map<String,Object> selectHMapById(Integer id);
    int save(QuestionAnswer questionAnswer);
    int update(QuestionAnswer questionAnswer);
    PageUtils selectResultList(Map<String, Object> map);
}
