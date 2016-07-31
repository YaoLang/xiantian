package com.gep.test;

import com.sunshine.expsystem.job.RecalculateTask;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.JobDetailBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kong on 16/7/31.
 */
public class TriggerTest {

    public static void main(String[] args) throws Exception {
        JobDetailBean jobDetailBean = new JobDetailBean();
        jobDetailBean.setJobClass(RecalculateTask.class);
        jobDetailBean.setName("exampleJob");
        Map<String,String> map = new HashMap<>();
        map.put("service","simple is the beat");
        jobDetailBean.setJobDataAsMap(map);

        CronTriggerBean cronTriggerBean = new CronTriggerBean();
        cronTriggerBean.setJobDetail(jobDetailBean);
        cronTriggerBean.setCronExpression("0/5 * * * * ?");


        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        Trigger[] trigger = new CronTriggerBean[1];
        trigger[0] = cronTriggerBean;
        schedulerFactoryBean.setTriggers(trigger);

        schedulerFactoryBean.start();

        Thread.sleep(10000);
//        synchronized (TriggerTest.class) {
//            while (true) {
//                try {
//                    TriggerTest.class.wait();
//                } catch (Throwable e) {
//                }
//            }
//        }
    }
}
