package com.ljb.controller;

import com.ljb.entity.Identity;
import com.ljb.security.IdentityUtils;
import com.ljb.utils.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/9<br>
 * 描述: <br>
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected Identity getSysUser() {
        return null;
    }

    protected Integer getSysUserId() {
        return IdentityUtils.getUserId();
    }

}
