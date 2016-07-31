package com.sunshine.expsystem.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.JobDetailBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kong on 16/7/28.
 */
public class RecalculateTask extends QuartzJobBean{

    private static int counter;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        long ms = System.currentTimeMillis();
        System.out.println("\t\t" + new Date(ms));
        System.out.println(ms);
        System.out.println("(" + counter++ + ")");
        String s = (String) context.getMergedJobDataMap().get("service");
        System.out.println(s);
        System.out.println();

    }

}
