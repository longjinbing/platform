package com.ljb.filter;

import com.ljb.dao.TokenDao;
import com.ljb.entity.Identity;
import com.ljb.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 作者: @author longjinbin <br>
 * 时间: 2018/10/14<br>
 * 描述: <br>
 */
public class LogoutFilter extends AdviceFilter {
    private static final Logger log = LoggerFactory.getLogger(org.apache.shiro.web.filter.authc.LogoutFilter.class);

    /**
     * The default redirect URL to where the user will be redirected after logout.  The value is {@code "/"}, Shiro's
     * representation of the web application's context root.
     */
    public static final String DEFAULT_REDIRECT_URL = "/";

    @Autowired
    private AccountService accountService;

    /**
     * The URL to where the user will be redirected after logout.
     */
    private String redirectUrl = DEFAULT_REDIRECT_URL;

    /**
     * Acquires the currently executing {@link #getSubject(javax.servlet.ServletRequest, javax.servlet.ServletResponse) subject},
     * a potentially Subject or request-specific
     * {@link #getRedirectUrl(javax.servlet.ServletRequest, javax.servlet.ServletResponse, org.apache.shiro.subject.Subject) redirectUrl},
     * and redirects the end-user to that redirect url.
     *
     * @param request  the incoming ServletRequest
     * @param response the outgoing ServletResponse
     * @return {@code false} always as typically no further interaction should be done after user logout.
     * @throws Exception if there is any error.
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        String redirectUrl = getRedirectUrl(request, response, subject);
        try {
            accountService.logout();
        } catch (SessionException ise) {
            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
        }
        issueRedirect(request, response, redirectUrl);
        return false;
    }

    protected Subject getSubject(ServletRequest request, ServletResponse response) {
        return SecurityUtils.getSubject();
    }

    protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl) throws Exception {
        WebUtils.issueRedirect(request, response, redirectUrl);
    }

    protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {
        return getRedirectUrl();
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
