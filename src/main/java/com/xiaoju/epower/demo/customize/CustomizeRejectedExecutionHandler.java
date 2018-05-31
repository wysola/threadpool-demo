package com.xiaoju.epower.demo.customize;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/29 下午5:16
 * description
 */
public class CustomizeRejectedExecutionHandler implements RejectedExecutionHandler{
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("epower customize rejectedExecution");
    }
}
