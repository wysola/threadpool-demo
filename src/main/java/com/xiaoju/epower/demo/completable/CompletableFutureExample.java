package com.xiaoju.epower.demo.completable;

import com.xiaoju.epower.demo.customize.CustomizeRejectedExecutionHandler;
import com.xiaoju.epower.demo.customize.CustomizeThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/30 下午4:26
 * description
 */
public class CompletableFutureExample {

    public static void main(String[] args) {
        useDefaultPool();

        userCustomizePool();
    }

    private static void useDefaultPool(){
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(new MySupplier(i))
                    .exceptionally(new ExceptionFunction())
                    .thenAccept(new MyConsumer());
            futures.add(completableFuture);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allOf.join();
    }

    private static void userCustomizePool(){
        ExecutorService executorService = new ThreadPoolExecutor(2, 4, 30, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(20),
                new CustomizeThreadFactory(),
                new CustomizeRejectedExecutionHandler());

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(new MySupplier(i), executorService)
                    .exceptionally(new ExceptionFunction())
                    .thenAccept(new MyConsumer());
            futures.add(completableFuture);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allOf.join();
        executorService.shutdown();
    }
}
