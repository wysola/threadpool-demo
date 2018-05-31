package com.xiaoju.epower.demo.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午4:22
 * description
 */
public class FixedSizeThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyThread(i));
        }
        executorService.shutdown();

    }

}
