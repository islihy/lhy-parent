package spring.context.demo02;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 芬里斯·狼脉Fenris Wolfbrother
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午8:21
 */
@Component
public class Fenris implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    @PostConstruct
    private void init(){
        System.out.println("Fenris : init");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void show(){
        System.out.println("Fenris : "+applicationContext.getClass());
    }
}
