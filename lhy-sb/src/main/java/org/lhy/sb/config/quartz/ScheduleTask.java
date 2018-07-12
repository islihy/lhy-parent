package org.lhy.sb.config.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/4/16 下午8:30
 */
@Configuration
@Component
@EnableScheduling // 该注解必须要加
public class ScheduleTask {
    public void scheduleTest() {
        System.err.println("scheduleTest开始定时执行");
    }
}
