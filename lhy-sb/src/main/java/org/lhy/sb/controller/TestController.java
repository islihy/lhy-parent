package org.lhy.sb.controller;

import org.lhy.sb.utils.JWTUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/16 上午7:45
 */

@Controller
@ResponseBody
@RequestMapping("/test")
public class TestController {

    @RequestMapping("")
    public String test(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        System.out.println(JWTUtil.getUsername(authorization));
        return "test测试";
    }
}
