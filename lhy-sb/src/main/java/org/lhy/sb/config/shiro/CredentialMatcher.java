package org.lhy.sb.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CredentialMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        JWTToken jwtToken = (JWTToken) token;
        String password = (String) jwtToken.getCredentials();
        String dbPassword = (String) info.getCredentials();
        return this.equals(password, dbPassword);
    }
}
