package com.xiaoju.epower.demo.customize;

import com.xiaoju.epower.demo.base.MyThread;

import java.util.concurrent.*;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午5:05
 * description
 */
public class CustomizeThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 30, TimeUnit.MINUTES,
                new ArrayBlockingQueue(20),
                new CustomizeThreadFactory(),
                new CustomizeRejectedExecutionHandler());

        for (int i = 0; i < 30; i++) {
            executorService.execute(new MyThread(i));
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------");
        executorService.shutdown();
    }

}
