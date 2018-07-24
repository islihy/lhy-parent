package org.lhy.sb.shiro.provider;


import org.lhy.sb.shiro.provider.bean.Account;

public interface AccountProvider {
     Account loadAccount(String appId);
}
