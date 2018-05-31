package com.xiaoju.epower.demo.exception;

import com.xiaoju.epower.demo.customize.CustomizeRejectedExecutionHandler;
import com.xiaoju.epower.demo.customize.CustomizeThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午8:42
 * description
 */
public class CaughtFutureExecutorExample {

    public static void main(String[] args) {
        catchWhenGet();

        catchWithHandler();
    }

    private static void catchWhenGet(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(new ExceptionCallable(i));
            futureList.add(future);
        }
        for (Future<String> future : futureList) {
            try {
                System.out.println("future " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                System.out.println("catch exception");
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    private static void catchWithHandler(){
        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 30, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                new CustomizeThreadFactory(),
                new CustomizeRejectedExecutionHandler());
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(new ExceptionCallable(i));
            futureList.add(future);
        }
        executorService.shutdown();
    }
}
