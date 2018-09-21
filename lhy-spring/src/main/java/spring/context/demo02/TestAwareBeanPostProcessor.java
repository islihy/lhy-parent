package spring.context.demo02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午9:05
 */
@Component
public class TestAwareBeanPostProcessor implements BeanPostProcessor{

    @Autowired
    private ApplicationContext applicationContext;

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof TestAware){
            ((TestAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
