package org.lhy.sb.config.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/7/25 上午11:27
 */
public class StatelessAuthcFilter extends AccessControlFilter {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private TokenManager tokenManager;
//
//    public TokenManager getTokenManager() {
//        return tokenManager;
//    }

//    public void setTokenManager(TokenManager tokenManager) {
//        this.tokenManager = tokenManager;
//    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        LOGGER.info("拦截到的url:" + httpRequest.getRequestURL().toString());
        // 前段token授权信息放在请求头中传入
        String authorization = httpRequest.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            onLoginFail(response, "请求头不包含认证信息authorization");
            return false;
        }
        // 获取无状态Token
        JWTToken jwtToken = new JWTToken(authorization);

        try {
            // 委托给Realm进行登录
            getSubject(request, response).login(jwtToken);
        } catch (Exception e) {
            LOGGER.error("auth error:" + e.getMessage(), e);
            onLoginFail(response, "auth error:" + e.getMessage()); // 6、登录失败
            return false;
        }
        // 通过isPermitted 才能调用doGetAuthorizationInfo方法获取权限信息
        return getSubject(request, response).isPermitted(httpRequest.getRequestURI());
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {
        onLoginFail(response, "权限不足");
        return false;
    }

    /**
     * 登录失败时默认返回401状态码
     * @param response
     * @param errorMsg
     * @throws IOException
     */
    private void onLoginFail(ServletResponse response,String errorMsg) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setContentType("text/html");
        httpResponse.setCharacterEncoding("utf-8");
        httpResponse.getWriter().write(errorMsg);
        httpResponse.getWriter().close();
    }
}
