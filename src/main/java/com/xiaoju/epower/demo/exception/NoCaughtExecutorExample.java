package com.xiaoju.epower.demo.exception;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午8:42
 * description
 */
public class NoCaughtExecutorExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new ExceptionThread(i));
        }
        executorService.shutdown();
    }
}
