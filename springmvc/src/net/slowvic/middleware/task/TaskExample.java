package net.slowvic.middleware.task;

import net.slowvic.util.AppContextUtil;

import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;

public class TaskExample {
    private TaskExecutor taskExecutor;

    private AsyncTask task;

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void setTask(AsyncTask task) {
        this.task = task;
    }

    public void printMessage() {
        for (int i = 0; i < 10; i++) {
            taskExecutor.execute(new MessagePrintTask("message" + i));
        }
    }

    // @Scheduled(fixedRate = 5000)
    // 定时任务调度
    public void printMsg() {
        System.out.println(Thread.currentThread());
    }

    public void doALot() {
        doFirst();
        // 异步执行，先打印"结束"
        task.waitSoLong();
        doLast();
    }

    public void doFirst() {
        System.out.println("开始");
    }

    public void doLast() {
        System.out.println("结束");
    }

    public static void main(String[] args) {
        ApplicationContext ctx = AppContextUtil.getApplicationContext();
        TaskExample te = ctx.getBean(TaskExample.class);
        // te.printMessage();
        te.doALot();
    }
}
