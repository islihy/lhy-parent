package spring.context.demo01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/18 下午5:29
 */
public class StartMain2 {
    public static void main(String[] args) {

        /**
         * 通过扫描包进行容器bena加载
         */
        AnnotationConfigApplicationContext annoApplication = new  AnnotationConfigApplicationContext(AnnotationScan.class);

        annoApplication.getBean("wowController",WowController.class).say();
        annoApplication.close();
    }
}
