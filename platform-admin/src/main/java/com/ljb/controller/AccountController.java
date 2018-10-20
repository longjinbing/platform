package com.ljb.controller;

import com.ljb.entity.Identity;
import com.ljb.entity.SysUser;
import com.ljb.service.AccountService;
import com.ljb.service.SysUserService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.R;
import com.ljb.utils.SHA256Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleInfoNotFoundException;
import javax.management.relation.RoleNotFoundException;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/9/12<br>
 * 描述: <br>
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/login")
    public String login(){
        return "account/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public R login(@RequestParam String number, @RequestParam String password, @RequestParam Boolean remember, @RequestParam(required = false) String url){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(number, SHA256Util.getSHA256Str(password));
        token.setRememberMe(remember);
        try {
            subject.login(token);
            accountService.recordLog(1);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            accountService.recordLog(2);
            return R.error("学号或密码错误");
        } catch (IncorrectCredentialsException e) {
            return R.error("学号或密码错误");
        } catch (LockedAccountException lae ) {
            return R.error("账户已锁定，请联系管理员");
        } catch (ExcessiveAttemptsException eae ) {
            return R.error("尝试登录次数超限，请稍后尝试");
        }catch (DisabledAccountException ade){
            return R.error("用户没有权限登录系统" );
        }
        return R.ok("登录成功");
    }


    @RequestMapping(value = "/register")
    public String register(){
        return "account/register";
    }

    @RequestMapping(value="/register",method=RequestMethod.POST)
    public @ResponseBody R Register(@Validated @RequestBody SysUser sysUser) {
        if(accountService.findByNumber(sysUser.getNumber())!=null) {
            return R.error("学号已注册");
        }
        sysUser.setStatus(1);
        sysUser.setCreateTime(DateUtils.currentTime());
        sysUser.setPassword(SHA256Util.getSHA256Str(sysUser.getPassword()));
        if(sysUserService.save(sysUser)==0)
            return R.error("注册失败");
        return R.ok("注册成功");
    }

    @RequestMapping(value="/number",method=RequestMethod.GET)
    @ResponseBody
    public R numberIsExist(@RequestParam String number) {
        if(accountService.findByNumber(number)==null) {
            return R.ok();
        }else{
            return R.error(1, "学号已注册");
        }
    }

    @RequestMapping(value="/unauthorized",method=RequestMethod.GET)
    public String unAuthorized(@RequestParam(required = false,defaultValue = "请登录") String message, Model model) {
        accountService.logout();
        model.addAttribute("message", message);
        return "/account/unauthorized";
    }

}
