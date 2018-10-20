package com.ljb.service;

import com.ljb.utils.BaseService;
import com.ljb.utils.FileResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 班级用户Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 17:25:42
 */
public interface GradesUserService<T,K,E> extends BaseService<T,K,E> {
    FileResult saveBatch(MultipartFile file, Integer id);
}
