package org.lhy.springboot.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 获取配置方法
 * 默认配置文件名字：app.properties，默认的位置在classpath根目录，或者classpath:/config，或者file:/，或者file:config/
 *
 * 默认的配置文件名字可以使用--spring.config.name来指定，只需指定文件的名字，文件扩展名省略
 * 默认的配置文件名字可以使用--spring.config.location来指定，
 * --spring.config.name=app
 * --spring.config.location=classpath:conf/app.properties
 * 同时可以指定外挂配置文件
 * --spring.config.location=classpath:conf/app.properties,file:E:/tmp/tomcat.properties
 *
 *
 *
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/27 下午5:57
 */
@Component
//@Configuration
public class KalimdorConfig {
    @Autowired
    private Environment environment;

    @Value("${local.port}")
    private String localPort;

    @Value("${local.port}")
    private Integer localPort2;

    /**
     * @Value 默认必须要有配置项，哪怕就是null，或者下面的这种形式
     */
    @Value("${tomcat.port:9090}")
    private String defaultPort;

    public void show(){
        System.out.println("local ip : "+environment.getProperty("local.ip"));
        System.out.println("local ip : "+environment.getProperty("local.port",Integer.class));
        System.out.println("local port : "+localPort);
        System.out.println("local port2 : "+localPort2);

        System.out.println("defaultPort : "+defaultPort);

        System.out.println("local ip : "+environment.getProperty("app.name"));
    }
}
