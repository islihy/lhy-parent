package org.lhy.springboot.demo01;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/27 下午5:08
 */
@SpringBootConfiguration
public class Nordrassil {

    @Bean
    public List createList(){
        return new ArrayList();
    }


    @Bean
    public List createList2(){
        return new ArrayList();
    }

}
