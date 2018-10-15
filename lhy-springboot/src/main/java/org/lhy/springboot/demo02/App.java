package org.lhy.springboot.demo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/27 下午5:35
 */
@SpringBootApplication(scanBasePackages = "org.lhy.springboot.demo02")
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class,args);
        //System.out.println(context.getEnvironment().getProperty("local.ip"));
        context.getBean(KalimdorConfig.class).show();

        context.close();
    }
}
