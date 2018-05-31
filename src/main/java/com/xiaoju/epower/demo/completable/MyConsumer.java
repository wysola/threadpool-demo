package com.xiaoju.epower.demo.completable;

import java.util.function.Consumer;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/30 下午4:35
 * description
 */
public class MyConsumer implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println("consume " + s);
    }
}
