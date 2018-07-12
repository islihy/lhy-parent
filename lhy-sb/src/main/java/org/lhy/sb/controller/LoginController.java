package org.lhy.sb.controller;

import org.lhy.sb.bean.User;
import org.lhy.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/15 下午4:26
 */
@Controller
@ResponseBody
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/logout")
    public Object logout() {
        return "登出成功";
    }

    @RequestMapping("/login")
    public Object loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        try {
            User user = userService.findByUsername(username);
            if (password.equals(user.getPassword())){
                return "登录成功";
            }else {
                return "登录失败";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "登录失败";
        }
    }
}
