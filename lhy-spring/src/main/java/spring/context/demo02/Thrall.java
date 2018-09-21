package spring.context.demo02;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午9:02
 */
@Component
public class Thrall implements TestAware{

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void show(){
        System.out.println("Thrall : "+applicationContext.getClass());
    }
}
