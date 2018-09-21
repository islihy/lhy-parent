package spring.context.demo03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;


/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/20 上午11:53
 */
public class StartMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("spring.context.demo03");
        context.getBeansOfType(Varian.class).values().forEach(System.out::println);
        context.close();
    }
}
