package spring.context.demo03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/20 下午12:34
 */
@Component
public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        for (int i=0;i<10;i++){
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Varian.class);
            builder.addPropertyValue("name","Varian name : "+ i);
            registry.registerBeanDefinition("Varian"+i,builder.getBeanDefinition());
        }
    }
}
