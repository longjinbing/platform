package com.ljb.service;

import com.ljb.entity.SysUser;
import com.ljb.utils.BaseService;
import com.ljb.utils.FileResult;
import com.ljb.utils.PageUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 系统用户Service接口
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */
public interface SysUserService<T,K,E> extends BaseService<T,K,E> {
    SysUser findByNumber(String number);
    FileResult saveBatch(MultipartFile file);
    PageUtils selectTList(Map<String, Object> map);
}
