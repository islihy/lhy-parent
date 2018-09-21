package spring.context.demo01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 希尔瓦娜斯 Sylvanas Windrunner
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 上午9:49
 */
public class Sylvanas {


    @PostConstruct
    public void inital(){
        System.out.println("=========Sylvanas init==========");
    }

    @PreDestroy
    public void destory(){
        System.out.println("=========Sylvanas destory==========");
    }
}

