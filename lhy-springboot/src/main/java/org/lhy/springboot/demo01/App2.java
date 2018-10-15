package org.lhy.springboot.demo01;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/27 下午4:40
 */
@SpringBootApplication(scanBasePackages = "org.lhy.springboot.demo01")
public class App2 {

    @Bean
    public Runnable createRunnable(){
        return ()->{ System.out.println("spring is running"); };
    }

}
