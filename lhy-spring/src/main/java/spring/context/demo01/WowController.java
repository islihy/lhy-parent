package spring.context.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午2:46
 */
@Controller("wowController")
public class WowController {


    @Autowired
    private Alleria alleria;

    /**
     * JSR-250
     */
    @Resource
    private Sylvanas sylvanas;

    /**
     * JSR-330
     */
    @Inject
    private Vereesa vereesa;

    public void say(){
        System.out.println(
                "alleria: "+alleria.getClass().getName()+
                "sylvanas: "+sylvanas.getClass().getName()+
                        "vereesa: "+vereesa.getClass().getName());
    }
}
