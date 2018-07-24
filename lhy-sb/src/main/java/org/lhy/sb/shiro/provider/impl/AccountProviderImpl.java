package org.lhy.sb.shiro.provider.impl;


import org.lhy.sb.shiro.provider.bean.Account;
import org.lhy.sb.shiro.provider.AccountProvider;
import org.springframework.stereotype.Service;


@Service("AccountProvider")
public class AccountProviderImpl implements AccountProvider {

    @Override
    public Account loadAccount(String appId) {
        return null;
    }
}
