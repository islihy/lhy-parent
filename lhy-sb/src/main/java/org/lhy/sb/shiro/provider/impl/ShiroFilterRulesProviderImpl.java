package org.lhy.sb.shiro.provider.impl;

import org.lhy.sb.shiro.provider.ShiroFilterRulesProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ShiroFilterRulesProvider")
public class ShiroFilterRulesProviderImpl implements ShiroFilterRulesProvider {

    @Override
    public List loadRolePermRules() {

        return null;
    }

}
