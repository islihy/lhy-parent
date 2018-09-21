package spring.context.demo03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/20 下午12:14
 */
//@Component
public class TestBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before postProcessBeforeInitialization() : "+bean.getClass());
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after postProcessAfterInitialization() : "+bean.getClass());
        return bean;
    }
}
