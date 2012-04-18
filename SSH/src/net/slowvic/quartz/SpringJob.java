package net.slowvic.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SpringJob implements Job {

    public void execute(JobExecutionContext context)
        throws JobExecutionException {
        JobDataMap map = context.getJobDetail().getJobDataMap();
        int size = map.getInt("size");
        System.out.println(size);
        map.put("size", size + 1);
    }

}
