package org.lhy.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/3/16 上午7:45
 */

@Controller
@ResponseBody
@RequestMapping("/test")
public class TestController {

    @RequestMapping("")
    public String test(){
        return "test测试";
    }
}
