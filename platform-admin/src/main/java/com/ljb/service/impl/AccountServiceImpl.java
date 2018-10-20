package com.ljb.service.impl;

import com.alibaba.fastjson.JSON;
import com.ljb.dao.*;
import com.ljb.entity.*;
import com.ljb.example.SysUserExample;
import com.ljb.example.TokenExample;
import com.ljb.security.IdentityUtils;
import com.ljb.service.AccountService;
import com.ljb.utils.DateUtils;
import com.ljb.utils.RequestUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/11<br>
 * 描述: <br>
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysLoginLogDao sysLoginLogDao;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TokenDao tokenDao;

    @Override
    public void recordLog(Integer status){
        SysLoginLog sysLoginLog=new SysLoginLog();
        if(SecurityUtils.getSubject().isAuthenticated()){
            sysLoginLog.setCreateId(IdentityUtils.getUserId());
        }
        sysLoginLog.setCreateTime(DateUtils.currentTime());
        sysLoginLog.setStatus(status);
        if(status==1){
            sysLoginLog.setResult("登录成功");
            sysLoginLog.setRemark("网站登录");
        }else{
            sysLoginLog.setResult("登录失败");
            sysLoginLog.setRemark("网站登录");
        }
        sysLoginLog.setUpdateTime(DateUtils.currentTime());
        sysLoginLog.setIp(RequestUtils.getIp(request));
        sysLoginLog.setDevice(RequestUtils.getOsAndBrowserInfo(request));
        sysLoginLogDao.insert(sysLoginLog);
        TokenExample tokenExample=new TokenExample();
        tokenExample.createCriteria().andCreateIdEqualTo(IdentityUtils.getUserId());
        if(tokenDao.selectByExample(tokenExample)!=null){
            tokenDao.deleteByExample(tokenExample);
        }
        Token token=new Token();
        token.setId(IdentityUtils.getUserId());
        token.setCreateId(IdentityUtils.getUserId());
        token.setCreateTime(DateUtils.currentTime());
        token.setTicket(SecurityUtils.getSubject().getSession().getId().toString());
        token.setExpireTime(new Date(SecurityUtils.getSubject().getSession().getTimeout()));
        PrincipalCollection p=SecurityUtils.getSubject().getPrincipals();
        token.setPrinciple(JSON.toJSONString( SecurityUtils.getSubject().getPrincipals()));
        token.setRemark("在线");
        token.setIp(SecurityUtils.getSubject().getSession().getHost());
        tokenDao.insert(token);
    }

    @Override
    public List<String> allPermission(){
        return sysMenuDao.allPermission();
    }

    @Override
    public void logout() {
        Subject subject=SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            tokenDao.deleteByPrimaryKey(((Identity)subject.getPrincipal()).getId());
            subject.logout();
        }
    }

    @Override
    public SysUser findByUserName(String username) {
        SysUserExample sysUserExample=new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(username);
        List<SysUser> list=sysUserDao.selectByExample(sysUserExample);
        if(list.size()==1)
            return list.get(0);
        return null;
    }
    @Override
    public SysUser findByNumber(String number) {
        SysUserExample sysUserExample=new SysUserExample();
        sysUserExample.createCriteria().andNumberEqualTo(number);
        List<SysUser> list=sysUserDao.selectByExample(sysUserExample);
        if(list.size()==1)
            return list.get(0);
        return null;
    }


    @Override
    public SysUser findById(Integer id) {
        return sysUserDao.selectByPrimaryKey(id);
    }

    @Override
    public List<String> roles(Integer sysUserId){
        return sysRoleDao.roleList(sysUserId);
    }

    @Override
    public List<String> permissions(Integer sysUserId) {
        return sysMenuDao.urlList(sysUserId);
    }
}
