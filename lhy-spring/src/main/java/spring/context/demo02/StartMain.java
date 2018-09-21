package spring.context.demo02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午6:10
 */
public class StartMain {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("spring.context.demo02");
        System.out.println(applicationContext.getBean("malfurion"));
        System.out.println(applicationContext.getBean(Malfurion.class));

//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigDemo02.class);
//        System.out.println(applicationContext.getBean("createMalfurion"));
//        System.out.println(applicationContext.getBean(Malfurion.class));


        applicationContext.getBean("durotan",Durotan.class).show();
        applicationContext.getBean("fenris",Fenris.class).show();
        applicationContext.getBean("rexxar",Rexxar.class).show();


        applicationContext.getBean("thrall",Thrall.class).show();

        applicationContext.close();
    }
}
