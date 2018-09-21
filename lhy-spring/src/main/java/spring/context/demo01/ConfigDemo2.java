package spring.context.demo01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午5:10
 */
@Configuration
public class ConfigDemo2 {
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Alleria createAlleria(){
        return new Alleria();
    }
}
