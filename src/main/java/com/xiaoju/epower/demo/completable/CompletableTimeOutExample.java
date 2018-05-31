package com.xiaoju.epower.demo.completable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/30 下午6:04
 * description
 */
public class CompletableTimeOutExample {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static <T> CompletableFuture<T> failAfter(Duration duration) {
        final CompletableFuture<T> promise = new CompletableFuture<>();
        scheduler.schedule(() -> {
            final TimeoutException ex = new TimeoutException("Timeout after " + duration);
            return promise.completeExceptionally(ex);
        }, duration.toMillis(), MILLISECONDS);
        return promise;
    }

    public static void main(String[] args) {
        runWithOutTimeOut();

        //runWithTimeOut();
    }

    private static void runWithTimeOut(){
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(new MySupplier(i))
                    .acceptEither(failAfter(Duration.ofSeconds(1)), new MyConsumer())
                    .exceptionally(new Function<Throwable, Void>() {
                        @Override
                        public Void apply(Throwable throwable) {
                            System.out.println("cat exception");
                            throwable.printStackTrace();
                            return null;
                        }
                    });
            futures.add(completableFuture);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allOf.join();
    }

    private static void runWithOutTimeOut(){
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(new MySupplier(i))
                    .thenAccept(new MyConsumer())
                    .exceptionally(new Function<Throwable, Void>() {
                        @Override
                        public Void apply(Throwable throwable) {
                            System.out.println("cat exception");
                            throwable.printStackTrace();
                            return null;
                        }
                    });
            futures.add(completableFuture);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        allOf.join();
    }
}
