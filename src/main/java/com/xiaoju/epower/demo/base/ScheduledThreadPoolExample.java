package com.xiaoju.epower.demo.base;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午4:47
 * description
 */
public class ScheduledThreadPoolExample {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executorService.scheduleAtFixedRate(new MyThread(i), 0, 5, TimeUnit.SECONDS);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
