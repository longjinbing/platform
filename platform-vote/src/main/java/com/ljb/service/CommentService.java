package com.ljb.service;

import com.ljb.entity.CommentModel;
import com.ljb.utils.BaseService;
import com.ljb.utils.PageUtils;
import com.ljb.utils.R;

import java.util.Map;

/**
 * 评价管理Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-18 13:08:11
 */
public interface CommentService<T,K,E> extends BaseService<T,K,E> {
    int saveByCourse(CommentModel entity);
    R start(Integer id);
    R complete(Integer id);
    R clear(Integer id);
    PageUtils selectHList(Map<String, Object> map);
    Map<String,Object> selectResult(Integer id);

}
