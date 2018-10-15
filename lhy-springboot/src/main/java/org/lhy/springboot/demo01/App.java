package org.lhy.springboot.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/25 下午5:14
 */
public class App {


    public static void main(String[] args) {

        SpringApplication app = new SpringApplication();
        Set<Object> sets = new HashSet<>();
        sets.add(App2.class);
        app.setSources(sets);
        ConfigurableApplicationContext context = app.run(args);

//        ConfigurableApplicationContext context = SpringApplication.run(App2.class,args);
        context.getBean(Runnable.class).run();
        System.out.println(context.getBean(Thrall.class));
        System.out.println(context.getBean("createList"));
        //System.out.println(context.getBean(List.class));

        context.close();
    }
}
