package com.ljb.security;

import com.ljb.entity.Identity;
import com.ljb.utils.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalMap;

import java.security.Principal;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/10<br>
 * 描述: <br>
 */
public class IdentityUtils {

    public static Integer getUserId(){
       Object obj=SecurityUtils.getSubject().getPrincipal();
       if(obj!=null){
           Identity identity=(Identity)obj;
           return identity.getId();
       }
       SecurityUtils.getSubject().logout();
        return 0;
    }
}
