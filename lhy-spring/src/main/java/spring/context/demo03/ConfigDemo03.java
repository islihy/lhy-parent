package spring.context.demo03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/20 下午12:10
 */
//@Configuration
public class ConfigDemo03 {

    @Bean(initMethod = "init")
    public Arthas creaet01(){
        return new Arthas();
    }
    @Bean
    public Arthas creaet02(){
        return new Arthas();
    }
}
