package org.lhy.sb.controller;

import org.lhy.sb.bean.User;
import org.lhy.sb.service.UserService;
import org.lhy.sb.utils.MD5Util;
import org.nutz.lang.random.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/16 上午7:45
 */

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/create")
    public String createUser(@RequestParam("username") String username,
                             @RequestParam("password") String password){
        User user = new User();
        user.setUserName(username);

        String s = R.captchaChar(4,false);
        String passwordE = MD5Util.encryptPassword(password,s);

        user.setPassword(passwordE);
        user.setSalt(s);
        userService.createUser(user);
        return "成功";
    }
}
