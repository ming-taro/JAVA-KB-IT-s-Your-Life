package com.multi.ex01.lambda_basic;

// 람다식으로 쓰게끔 하나의 추상메소드만 허용한다
@FunctionalInterface // 하나의 추상 메소드가 있는 것을 확인하는 인터페이스, 생량 가능!
public interface MyLambda1 {
    void run();
//    void run2(); // 추상 메소드가 두 개 이상 있는 경우 error
}
