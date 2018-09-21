package spring.context.demo01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 上午8:43
 */
@Configuration
public class ConfigDemo1 {

    @Bean("Korialstrasz")
    @Scope("prototype")//指定非单例
    public Korialstrasz creatKorialstrasz(){
        return new Korialstrasz();
    }

    @Bean
    public RunnableFactoryBean createRunnableFactoryBean(){
        return new RunnableFactoryBean();
    }

    @Bean
    public HeroFactory createHeroFacotry(){
        return new HeroFactory();
    }

    @Bean
    public Rhonin createRhonin(HeroFactory factory){
        return factory.createRhonin();
    }

    @Bean
    public Vereesa createVereesa(){
        return new Vereesa();
    }

    @Bean
    public Sylvanas createSylvanas(){
        return new Sylvanas();
    }
}
