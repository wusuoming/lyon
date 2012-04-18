package net.slowvic.quartz;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerRunner {
    public static void main(String[] args) throws SchedulerException {
        Date runtime = DateBuilder.evenSecondDate(new Date());
        JobDetail detail = JobBuilder.newJob(SimpleJob.class).withIdentity(
            "job1", "group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().startAt(runtime).build();
        Scheduler schd = new StdSchedulerFactory().getScheduler();
        schd.scheduleJob(detail, trigger);
        schd.start();
        try {
            Thread.sleep(10000);
        }
        catch (Exception e) {
            System.out.println("线程被中断");
        }
        schd.shutdown(true);
    }
}
