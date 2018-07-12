package org.lhy.sb.service.impl;

import org.lhy.sb.bean.User;
import org.lhy.sb.nutz.base.service.BaseServiceImpl;
import org.lhy.sb.service.UserService;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.springframework.stereotype.Service;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/16 上午7:50
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    public UserServiceImpl(Dao dao) {
        super(dao);
    }

    @Override
    public User findByUsername(String userName){
        Cnd cnd = Cnd.where("user_name","=",userName);
        return this.fetch(cnd);
    }

    @Override
    public void createUser(User user){
        this.insert(user);
    }
}
