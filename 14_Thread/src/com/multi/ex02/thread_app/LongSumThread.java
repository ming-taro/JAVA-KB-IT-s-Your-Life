package com.multi.ex02.thread_app;

import java.util.List;
import java.util.concurrent.Callable;

public class LongSumThread implements Callable<Long> {
    private long startValue = 0;
    private long endValue   = 0;

    public LongSumThread(long startValue, long endValue) {
        this.startValue = startValue;
        this.endValue   = endValue;
    }

    @Override
    public Long call() throws Exception {
        long sumValue = 0;
        for(long i = startValue; i < endValue; i++ ) {
            sumValue += i;
        }
        return sumValue;
    }
}

