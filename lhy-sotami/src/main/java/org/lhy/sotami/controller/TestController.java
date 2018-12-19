package org.lhy.sotami.controller;

import org.lhy.sotami.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/12/19 6:22 PM
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/msg")
    public void test(){
        testService.test();
    }

}
