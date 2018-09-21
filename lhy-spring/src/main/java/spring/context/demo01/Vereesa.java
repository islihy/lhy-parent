package spring.context.demo01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 温蕾萨·风行者 Vereesa Windrunner
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 上午9:25
 */
public class Vereesa implements InitializingBean,DisposableBean{

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=========Vereesa 在属性装配完成后进行设置============");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("=========Vereesa destroy()============");
    }
}
