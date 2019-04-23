package com.zhangj.ymm.thread.juc.executors;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author zhangj
 * @date 2019/4/23
 */
public class QuertzScheduler {
    public static void main(String[] args) throws SchedulerException {
        JobDetail job = newJob(SimpleJob.class)
                .withIdentity("Job1", "Group1")
                .build();
        CronTrigger trigger = newTrigger()
                .withIdentity("Trigger1", "Group1")
                .withSchedule(cronSchedule("0/2 * * * * ?"))
                .build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

    public static class SimpleJob implements Job {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) {
            System.out.println("=====================" + System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
