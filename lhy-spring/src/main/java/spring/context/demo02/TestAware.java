package spring.context.demo02;

import org.springframework.context.ApplicationContext;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午9:03
 */
public interface TestAware {
    void setApplicationContext(ApplicationContext applicationContext);
}
