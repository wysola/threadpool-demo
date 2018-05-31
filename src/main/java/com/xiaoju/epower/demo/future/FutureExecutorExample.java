package com.xiaoju.epower.demo.future;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午6:13
 * description
 */
public class FutureExecutorExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future future = executorService.submit(new MyCallable(i));
            futureList.add(future);
        }
        for (Future future : futureList) {
            try {
                System.out.println("future " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
