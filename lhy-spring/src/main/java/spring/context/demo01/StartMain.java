package spring.context.demo01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/18 下午5:29
 */
public class StartMain {
    public static void main(String[] args) {

        /**
         * 通过扫描包进行容器bena加载
         */
        AnnotationConfigApplicationContext annoApplication = new  AnnotationConfigApplicationContext("spring.context.demo01");
        //AnnotationConfigApplicationContext annoApplication = new  AnnotationConfigApplicationContext(ConfigDemo1.class,Guldan.class);
        //System.out.println(annoApplication.getBean("creatKorialstrasz"));//非单例模式不能通过这样拿
        System.out.println(annoApplication.getBean("Korialstrasz"));
        System.out.println(annoApplication.getBean(Korialstrasz.class));

        //获取的是FactoryBean的本身
        System.out.println(annoApplication.getBean(RunnableFactoryBean.class));
        System.out.println(annoApplication.getBean("&createRunnableFactoryBean"));
        //获取FactoryBean生产的bean
        System.out.println(annoApplication.getBean("createRunnableFactoryBean"));
        System.out.println(annoApplication.getBean(Runnable.class));

        System.out.println(annoApplication.getBean(HeroFactory.class));
        System.out.println(annoApplication.getBean("createRhonin"));


        System.out.println(annoApplication.getBean(Vereesa.class));
        System.out.println(annoApplication.getBean(Alleria.class));
        System.out.println(annoApplication.getBean(Sylvanas.class));

        System.out.println(annoApplication.getBean("guldan"));
        System.out.println(annoApplication.getBean(Guldan.class));
        System.out.println(annoApplication.getBeansOfType(Guldan.class));

        annoApplication.getBean("wowController",WowController.class).say();
        annoApplication.close();
    }
}
