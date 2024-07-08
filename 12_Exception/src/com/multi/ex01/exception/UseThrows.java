package com.multi.ex01.exception;

public class UseThrows {
    // throws : 예외가 발생하면 호출한 메소드에게 예외의 책임을 전가하는 키워드
    //          단, main에서 발생시에는 프로그램 종료를 의미

    // throw : 예외를 만들어서 던지는 문장

    // main에서 상위 프로세스에게 예외를 전가하는 코드 -> 죽는 코드
//    public static void main(String[] args) throws Exception {
//    }

    // main에서 try-catch문을 통해 예외를 처리하는 구문
    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            // 대충 예외를 처리하는 구간
            System.out.println("main에서 예외를 처리하는 구간!");
            e.printStackTrace();
        }
    }

    // 예외를 만드는 method
    private static void method() throws Exception {
        if (true) {
            throw new Exception();
        }
    }
}
