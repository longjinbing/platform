package com.ljb.service;

import com.ljb.entity.QuestionModel;
import com.ljb.utils.BaseService;
import com.ljb.utils.PageUtils;
import com.ljb.utils.R;
import java.util.List;

import java.util.Map;

/**
 * 评价问题Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
public interface QuestionService<T,K,E> extends BaseService<T,K,E> {
    int saveByComment(QuestionModel entity);
    R selectList(Integer id);
}
