package org.lhy.sb.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.lhy.sb.bean.User;
import org.lhy.sb.service.UserService;
import org.lhy.sb.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @RequestMapping("/logout")
    public Object logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "登出成功";
    }
    @RequestMapping("/un")
    public Object un() {
        return "未授权页面";
    }


    /**
     * shiro登录逻辑:身份认证流程
     * 1、首先调用 Subject.login(token)进行登录，其会自动委托给 Security Manager;
     * 2、SecurityManager 负责真正的身份验证逻辑;它会委托给 Authenticator 进行身份验证;
     * 3、Authenticator 才是真正的身份验证者，Shiro API 中核心的身份认证入口点，此处可以自 定义插入自己的实现;
     * 4、Authenticator 可能会委托给相应的 AuthenticationStrategy 进行多 Realm 身份验证，默认 ModularRealmAuthenticator 会调用 AuthenticationStrategy 进行多 Realm 身份验证;
     * 5、Authenticator 会把相应的 token 传入 Realm，从 Realm 获取身份验证信息，如果没有返 回/抛出异常表示身份验证失败了。此处可以配置多个 Realm，将按照相应的顺序及策略进 行访问。
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public Object loginUser(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session) {
        User dbuser = userService.findByUsername(username);
        String dbPassword = MD5Util.encryptPassword(password,dbuser.getSalt());
        UsernamePasswordToken token = new UsernamePasswordToken(username, dbPassword);
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
