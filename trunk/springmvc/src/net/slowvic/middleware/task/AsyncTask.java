package net.slowvic.middleware.task;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;

public class AsyncTask {

    @Async()
    // 异步执行
    public void waitSoLong() {
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("靠，已经结束了么？");
    }

}
