package org.lhy.sb.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.lhy.sb.bean.ResponseBean;
import org.lhy.sb.bean.User;
import org.lhy.sb.config.shiro.JWTToken;
import org.lhy.sb.exception.UnauthorizedException;
import org.lhy.sb.service.UserService;
import org.lhy.sb.utils.JWTUtil;
import org.lhy.sb.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public ResponseBean loginUser(@RequestParam("username") String username,
                                  @RequestParam("password") String password) {
        User user = userService.findByUsername(username);
        if ( MD5Util.encryptPassword(password,user.getSalt()).equals(user.getPassword())){

            return new ResponseBean(200, "Login success", JWTUtil.sign(username, user.getPassword()));
        } else {
            throw new UnauthorizedException();
        }
    }

//    @RequestMapping("/login")
//    public Object loginUser(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session) {
//
//        User user = userService.findByUsername(username);
//        if ( MD5Util.encryptPassword(password,user.getSalt()).equals(user.getPassword())){
//            String token = JWTUtil.sign(username, user.getPassword());
//            JWTToken jwtToken = new JWTToken(token);
//            Subject subject = SecurityUtils.getSubject();
//            try {
//                subject.login(jwtToken);
//
//                User user1 = (User) subject.getPrincipal();
//                session.setAttribute("user", user1);
//                return new ResponseBean(200, "Login success",token);
//            } catch (Exception e) {
//                System.out.println(e);
//                return "登录失败";
//            }
//        } else {
//            throw new UnauthorizedException();
//        }
//    }

    @GetMapping("/article")
    public ResponseBean article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new ResponseBean(200, "You are already logged in", null);
        } else {
            return new ResponseBean(200, "You are guest", null);
        }
    }

}
