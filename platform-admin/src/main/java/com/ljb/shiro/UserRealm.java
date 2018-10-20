package com.ljb.shiro;

import com.ljb.entity.Identity;
import com.ljb.entity.SysUser;
import com.ljb.service.AccountService;
import com.ljb.utils.Constant;
import com.ljb.utils.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.plexus.components.sec.dispatcher.PasswordDecryptorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.relation.RoleInfoNotFoundException;
import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private AccountService accountService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        Identity identity = (Identity)subject.getPrincipal();
        List<String> permissions = accountService.permissions(identity.getId());
        List<String> roles = accountService.roles(identity.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        info.addRoles(roles);
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String number = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        SysUser sysUser = accountService.findByNumber(number);
            if (sysUser == null) {
                throw new UnknownAccountException();
            }
            if (!sysUser.getPassword().equals(password)) {
                throw new IncorrectCredentialsException();
            }
            if (sysUser.getStatus() == null || sysUser.getStatus() != 1) {
                throw new LockedAccountException();
            }
            if(accountService.roles(sysUser.getId()).size()==0){
                throw new DisabledAccountException();
            }
            Session session = SecurityUtils.getSubject().getSession();
            Identity identity = new Identity();
            identity.setId(sysUser.getId());
            identity.setUsername(sysUser.getUsername());
            identity.setLoginTime(DateUtils.currentTime());
            identity.setRoles(accountService.roles(sysUser.getId()));
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(identity, sysUser.getPassword(), this.getName());
            return info;
    }
}
