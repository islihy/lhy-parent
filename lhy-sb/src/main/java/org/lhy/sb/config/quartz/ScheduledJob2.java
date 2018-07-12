package org.lhy.sb.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * User: hangyu.li E-mail:islihy@qq.com
 * DateTime: 2018/4/16 下午8:44
 */
public class ScheduledJob2 implements Job {

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.err.println("第二个任务正在运行 is running…………………………………… ");

    }

}
