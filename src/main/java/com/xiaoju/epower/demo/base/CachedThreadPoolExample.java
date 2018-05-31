package com.xiaoju.epower.demo.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午4:37
 * description
 */
public class CachedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyThread(i));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------");
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyThread(i));
        }
        executorService.shutdown();
    }

}
