package com.xiaoju.epower.demo.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午4:51
 * description
 */
public class MyThread implements Runnable {
    private int num;

    public MyThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + "  "
                + Thread.currentThread().getName() + ":"
                + num);
    }
}
