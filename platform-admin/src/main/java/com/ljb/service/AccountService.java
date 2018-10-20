package com.ljb.service;

import com.ljb.entity.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/11<br>
 * 描述: <br>
 */

public interface AccountService{

    SysUser findByUserName(String username);

    SysUser findByNumber(String number);

    SysUser findById(Integer id);

    List<String> roles(Integer sysUserId);

    List<String> permissions(Integer sysUserId);

    List<String> allPermission();

    void recordLog(Integer status);

    void logout();
}

