package spring.context.demo01;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 上午8:49
 */
public class RunnableFactoryBean implements FactoryBean<Runnable>{
    @Nullable
    @Override
    public Runnable getObject() throws Exception {
        return () -> {};
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Runnable.class;
    }


    @Override
    public boolean isSingleton() {
        return true;
    }
}
