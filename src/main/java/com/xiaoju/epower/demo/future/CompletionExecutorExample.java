package com.xiaoju.epower.demo.future;

import java.util.concurrent.*;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午7:47
 * description
 */
public class CompletionExecutorExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
        for (int i = 0; i < 10; i++) {
            completionService.submit(new MyCallable(i));
        }
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("future " + completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
