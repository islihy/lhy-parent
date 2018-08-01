package org.lhy.sb.service;


import org.apache.shiro.authc.AuthenticationException;
import org.lhy.sb.bean.User;
import org.lhy.sb.nutz.base.service.BaseService;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/16 上午7:49
 */
public interface UserService extends BaseService<User> {
    User findByUsername(String userName);
    void createUser(User user);
}
