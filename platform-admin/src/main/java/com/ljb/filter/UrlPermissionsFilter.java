package com.ljb.filter;

import com.alibaba.fastjson.JSON;
import com.ljb.dao.SysLogDao;
import com.ljb.entity.SysLog;
import com.ljb.security.IdentityUtils;
import com.ljb.service.AccountService;
import com.ljb.utils.Constant;
import com.ljb.utils.DateUtils;
import com.ljb.utils.R;
import com.ljb.utils.RequestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/12<br>
 * 描述: <br>
 */
public class UrlPermissionsFilter extends PermissionsAuthorizationFilter {

    @Autowired
    private SysLogDao sysLogDao;
    @Autowired
    private AccountService accountService;

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws IOException {
        String[] url=buildPermissionsFromRequest(request);
        return url==null?true:super.isAccessAllowed(request, response, url);
    }
    protected String[] buildPermissionsFromRequest(ServletRequest request) {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String contextPath=servletRequest.getContextPath();
        String uri = servletRequest.getRequestURI();
        String tmpUri = uri.replace(contextPath+"/", "");
        if(Arrays.binarySearch(Constant.NOAUTHORIZATIONURL,tmpUri )>-1){
            return null;
        }
        String params=tmpUri.substring(tmpUri.lastIndexOf("/")+1,tmpUri.length());
        Pattern pattern = Pattern.compile("[0-9]*");
        if(pattern.matcher(params).matches()){
            tmpUri=tmpUri.replace(params, "");
            if(tmpUri.indexOf("?")>-1){
                tmpUri=tmpUri.substring(0, tmpUri.indexOf("?"));
            }
        }
        if(!accountService.allPermission().contains(tmpUri)){
            return null;
        }
        return new String[]{tmpUri};
    }
    @Override
    public boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

        Subject subject = getSubject(request, response);
        // If the subject isn't identified, redirect to login URL
        if (subject.getPrincipal() == null) {
            saveRequestAndRedirectToLogin(request, response);
        } else {
            // If subject is known but not authorized, redirect to the unauthorized URL if there is one
            // If no unauthorized URL is specified, just return an unauthorized HTTP status code
            String unauthorizedUrl = getUnauthorizedUrl();
            //SHIRO-142 - ensure that redirect _or_ error code occurs - both cannot happen due to response commit:
            if (StringUtils.hasText(unauthorizedUrl)) {
                /*WebUtils.issueRedirect(request, response, unauthorizedUrl);*/
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter writer = response.getWriter();
                R r=R.error(405, "您没有得到访问授权,无法访问页面");
                HttpServletRequest httpServletRequest=(HttpServletRequest)request;
                recodError(httpServletRequest,httpServletRequest.getRequestURI());
                writer.write(JSON.toJSONString(r));
                writer.close();
            } else {
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        return false;
    }
    public void recodError(ServletRequest request,String url){
        SysLog sysLog=new SysLog();
        try {
            if (SecurityUtils.getSubject().isAuthenticated()) {
                sysLog.setCreateId(IdentityUtils.getUserId());
                sysLog.setRemark("系统用户");
            } else {
                sysLog.setRemark("未知用户");
            }
            sysLog.setRemark("访问未授权页面");
            sysLog.setIp(request.getRemoteHost());
            sysLog.setErrorStack("");
            sysLog.setCreateTime(DateUtils.currentTime());
            sysLog.setLevel(1);
            sysLog.setUpdateTime(DateUtils.currentTime());
            sysLog.setOperation("功能操作");
            sysLog.setUrl(url);
            sysLog.setMethod("");
            sysLog.setParams(JSON.toJSONString(request.getParameterMap()));
            sysLogDao.insert(sysLog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
