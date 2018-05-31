package com.xiaoju.epower.demo.completable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/30 下午4:32
 * description
 */
public class MySupplier implements Supplier<String>{
    private int num;

    public MySupplier(int num) {
        this.num = num;
    }

    @Override
    public String get() {
        if (num == 4) {
            throw new IllegalArgumentException("ExceptionSupplier");
        }
        String print = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "  "
                + Thread.currentThread().getName() + ":"
                + num;
        System.out.println("call " + print);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return print;
    }
}
