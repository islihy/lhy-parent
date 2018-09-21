package spring.context.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *
 * 杜隆坦 Durotan
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午8:17
 */
@Component
public class Durotan {


    private ApplicationContext applicationContext;

    @PostConstruct
    private void init(){
        System.out.println("Durotan : init");
    }

    public void show(){
        System.out.println("Durotan : "+applicationContext.getClass());
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("Durotan : setApplicationContext");
        this.applicationContext = applicationContext;
    }
}
