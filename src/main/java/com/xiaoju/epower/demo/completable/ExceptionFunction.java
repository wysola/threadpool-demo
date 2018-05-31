package com.xiaoju.epower.demo.completable;

import java.util.function.Function;

/**
 * @author wanyuan
 * @since 2.0
 * time  2018/5/30 下午4:50
 * description
 */
public class ExceptionFunction implements Function<Throwable, String> {

    @Override
    public String apply(Throwable throwable) {
        System.out.println("catch exception");
        throwable.printStackTrace();
        return "";
    }
}
