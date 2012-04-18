package net.slowvic.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

    public void execute(JobExecutionContext context)
        throws JobExecutionException {
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .format(new Date());
        System.out.println(context.getJobDetail().getKey()+"于" + nowTime + "触发");
    }
}
