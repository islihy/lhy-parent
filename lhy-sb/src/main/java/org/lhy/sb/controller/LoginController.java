package org.lhy.sb.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.lhy.sb.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/15 下午4:26
 */
@Controller
@ResponseBody
public class LoginController {

    @RequestMapping("/logout")
    public Object logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "登出成功";
    }

    @RequestMapping("/login")
    public Object loginUser(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);

            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            return "登录成功";
        } catch (Exception e) {
            System.out.println(e);
            return "登录失败";
        }
    }
}
