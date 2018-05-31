package com.xiaoju.epower.demo.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午8:43
 * description
 */
public class ExceptionCallable implements Callable<String> {

    private int num;

    public ExceptionCallable(int num) {
        this.num = num;
    }

    @Override
    public String call() throws Exception {
        if (num == 4) {
            throw new IllegalArgumentException("ExceptionCallable");
        }
        String print = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "  "
                + Thread.currentThread().getName() + ":"
                + num;
        System.out.println("call " + print);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return print;
    }
}
