package spring.context.demo02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午8:41
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor{


    /**
     * 在bean的依赖装配完成之后进行触发
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("===========postProcessBeforeInitialization============"+bean.getClass().getName());
        if(bean instanceof Durotan){
            System.out.println("杜隆坦是个好孩子");
        }

        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("===========postProcessAfterInitialization============="+bean.getClass().getName());
        return bean;
    }
}
