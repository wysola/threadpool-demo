package com.xiaoju.epower.demo.exception;

import com.xiaoju.epower.demo.base.MyThread;
import com.xiaoju.epower.demo.customize.CustomizeRejectedExecutionHandler;
import com.xiaoju.epower.demo.customize.CustomizeThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午8:42
 * description
 */
public class CaughtExecutorExample {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 30, TimeUnit.MINUTES,
                new ArrayBlockingQueue(10),
                new CustomizeThreadFactory(),
                new CustomizeRejectedExecutionHandler());

        for (int i = 0; i < 10; i++) {
            executorService.execute(new ExceptionThread(i));
        }
        executorService.shutdown();
    }
}
