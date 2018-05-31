package com.xiaoju.epower.demo.future;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午5:57
 * description
 */
public class MyCallable implements Callable<String> {
    private int num;

    public MyCallable(int num) {
        this.num = num;
    }

    @Override
    public String call() throws Exception {

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
