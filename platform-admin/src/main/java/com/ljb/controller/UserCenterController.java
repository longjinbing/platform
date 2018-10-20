package com.ljb.controller;

import com.ljb.annotion.Desc;
import com.ljb.entity.SysUser;
import com.ljb.security.IdentityUtils;
import com.ljb.service.SysUserService;
import com.ljb.utils.R;
import com.ljb.utils.SHA256Util;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 系统用户Controller
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-11 21:43:47
 */

@RestController
@RequestMapping("user")
@Desc(group="个人中心",name="用户信息",type=1,url="admin/user.html")
public class UserCenterController extends BaseController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/userinfo")
    @Desc(name="登录信息",type=2,level = 0)
    public R info() {
        Object sysUser  = SecurityUtils.getSubject().getPrincipal();
        return R.ok().put("data", sysUser);
    }

    @RequestMapping("/updatepass")
    @Desc(name="修改密码",type=2,level = 0)
    public R update(@RequestParam("password") String password,@RequestParam("confirmpassword") String confirmpassword) {
        if(!password.equals(confirmpassword)||password.length()<6){
            return R.error(-1, "密码不符合要求，请重新尝试");
        }
        SysUser sysUser=new SysUser();
        sysUser.setId(IdentityUtils.getUserId());
        sysUser.setPassword(SHA256Util.getSHA256Str(password));
        sysUserService.update(sysUser);
        return R.ok("修改成功");
    }

    /**
     * 查看详细信息
     */
    @RequestMapping("/details")
    @Desc(name="用户个人信息",type=2,level = 0)
    public R details() {
        Object sysUser  = sysUserService.selectMapById(getSysUserId());
        return R.ok().put("data", sysUser);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Desc(name="修改信息",type=2,level = 0)
    public R update(@Validated  @RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
        return R.ok();
    }

}
