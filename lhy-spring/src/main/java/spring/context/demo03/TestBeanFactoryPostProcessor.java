package spring.context.demo03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 容器初始化结束-触发回调-BeanFactoryPostProcessor
 * 只会触发一次
 * 触发时间比BeanPostProcessor靠前，在{@link AbstractApplicationContext#refresh()}可以看到
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/20 下午12:07
 */
//@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("========"+beanFactory.getBeanDefinitionCount());
    }
}
