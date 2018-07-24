package org.lhy.sb.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;
import org.lhy.sb.utils.AESUtil;

public class PasswordToken implements AuthenticationToken{

    private static final long serialVersionUID = 1L;
    /**
     * 设备或者渠道id
     */
    private String appId;
    /**
     * 密码：
     */
    private String password;
    /**
     * 时间
     */
    private String timestamp;
    private String host;
    private String tokenKey;

    public PasswordToken(String appId, String password, String timestamp, String host,String tokenKey) {
        this.appId = appId;
        this.timestamp = timestamp;
        this.host = host;
        this.password = AESUtil.aesDecode(password,tokenKey);
        this.tokenKey = tokenKey;

    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    @Override
    public Object getPrincipal() {
        return this.appId;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }
}
