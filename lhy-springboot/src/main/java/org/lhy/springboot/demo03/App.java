package org.lhy.springboot.demo03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/10/15 上午10:41
 */
@SpringBootApplication(scanBasePackages = "org.lhy.springboot.demo03")
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class);
        System.out.println(applicationContext.getBean(SagerasProperties.class));

        applicationContext.close();
    }
}