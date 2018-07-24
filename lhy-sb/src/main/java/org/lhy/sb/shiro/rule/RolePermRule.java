package org.lhy.sb.shiro.rule;


import org.apache.commons.lang3.StringUtils;
import org.lhy.sb.utils.StringUtil;

import java.io.Serializable;
import java.util.Set;

public class RolePermRule implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url; // 资源URL
    private String needRoles; // 访问资源所需要的角色列表，多个列表用逗号间隔

    public String getUrl() {
        return url;
    }

    public String getNeedRoles() {
        return needRoles;
    }

    /* *
     * @Description  将url needRoles 转化成shiro可识别的过滤器链：url=jwt[角色1、角色2、角色n]
     * @Param []
     * @Return java.lang.StringBuilder
     */
    public StringBuilder toFilterChain() {

        if (null == this.url || this.url.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> setRole = StringUtil.splitC(this.getNeedRoles());

        // 约定若role_anon角色拥有此uri资源的权限,则此uri资源直接访问不需要认证和权限
        if (!StringUtils.isEmpty(this.getNeedRoles()) && setRole.contains("role_anon")) {
            stringBuilder.append("anon");
        }
        //  其他自定义资源uri需通过jwt认证和角色认证
        if (!StringUtils.isEmpty(this.getNeedRoles()) && !setRole.contains("role_anon")) {
            stringBuilder.append("jwt"+"["+this.getNeedRoles()+"]");
        }

        return stringBuilder.length() > 0 ? stringBuilder : null;
    }

    @Override
    public String toString() {
        return "RolePermRule [url="+url+", needRoles="+needRoles+"]";
    }
}
