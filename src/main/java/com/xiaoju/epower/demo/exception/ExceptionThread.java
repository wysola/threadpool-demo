package com.xiaoju.epower.demo.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午8:43
 * description
 */
public class ExceptionThread implements Runnable {
    private int num;

    public ExceptionThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (num == 4) {
            throw new IllegalArgumentException("ExceptionThread");
        }
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "  "
                + Thread.currentThread().getName() + ":"
                + num);
    }
}
