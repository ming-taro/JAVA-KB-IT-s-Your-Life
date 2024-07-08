package com.multi.ex02.thread_app;

public class DoubleSumThread extends Thread{
    private double sumValue   = 0;
    private double startValue = 0;
    private double endValue   = 0;

    public DoubleSumThread(double startValue, double endValue) {
        this.startValue = startValue;
        this.endValue   = endValue;
    }

    public double getSumValue() {
        return sumValue;
    }

    public void run() {
        for(double i = startValue; i < endValue; i++ ) {
            sumValue += i;
        }
    }
}

