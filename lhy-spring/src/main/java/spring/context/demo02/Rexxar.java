package spring.context.demo02;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Rexxar Remar 雷克萨
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午8:35
 */
@Component
public class Rexxar {

    private ApplicationContext applicationContext;

    public Rexxar(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public void show(){
        System.out.println("Rexxar Remar : "+applicationContext.getClass());
    }
}
