package org.lhy.sb.service.impl;

import org.apache.shiro.authc.AuthenticationException;
import org.lhy.sb.bean.Role;
import org.lhy.sb.bean.User;
import org.lhy.sb.nutz.base.service.BaseServiceImpl;
import org.lhy.sb.service.UserService;
import org.nutz.aop.interceptor.ioc.TransAop;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.aop.Aop;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/16 上午7:50
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public UserServiceImpl(Dao dao) {
        super(dao);
    }

    @Override
    @Transactional
    public User findByUsername(String userName) {
        Cnd cnd = Cnd.where("user_name","=",userName);
        User user = this.fetch(cnd);
        this.fetchLinks(user,"roles");
        List<Role> roleList = user.getRoles();
        for (Role role:roleList){
            this.fetchLinks(role,"permissions");
        }
        User user2 = new User();
        user2.setUserName("无用");
        this.createUser(user2);
        redisTemplate.opsForList().leftPush("user:list", Json.toJson(user));

        stringRedisTemplate.opsForValue().set("user:name", "张三");
        stringRedisTemplate.executePipelined(new RedisCallback<List<String>>() {
            @Nullable
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {

                StringRedisConnection stringRedisConn = (StringRedisConnection)connection;
                stringRedisConn.openPipeline();
                stringRedisConn.rPush("1","2");
                stringRedisConn.closePipeline();
                return null;
            }
        });

        Object o  =redisTemplate.opsForList().index("user:list",1);
        User user1 = Json.fromJson(User.class, new StringReader((String)o));
        System.out.println(user1.getPassword());
        return user;
    }

    @Override
    public void createUser(User user){
        this.insert(user);
    }
}
