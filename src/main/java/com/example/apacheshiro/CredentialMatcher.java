package com.example.apacheshiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @Author zeroback13
 * @Date 2021/4/5 3:21
 * @Version 1.0
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String password = new String(usernamePasswordToken.getPassword());
        String dbPassword = (String)info.getCredentials();
        return this.equals(password,dbPassword);
    }
}
