package spring.context.demo01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author hangyu.li E-mail:islihy@qq.com
 * @date 2018/9/19 下午3:07
 */
@ComponentScan(basePackages = "spring.context.demo01",excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE,classes = ConfigDemo2.class))
@Configuration
public class AnnotationScan {
}
