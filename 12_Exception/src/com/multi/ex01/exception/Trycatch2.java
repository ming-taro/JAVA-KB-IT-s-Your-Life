package com.multi.ex01.exception;

import java.io.IOException;

public class Trycatch2 {
    public static void main(String[] args) {
        // try-catch문 복합형
        try {
            System.out.println("에러가 발생할 수 있는 구간! 시작");
//            if (false) { // false -> finally 구간
            if (true) { // true -> IOException 에러 발생 후 finally
                throw new IOException(); // IO 에러를 발생!
    //            throw new Exception(); // 그냥 에러를 발생하는 코드!
            }
            System.out.println("에러가 발생할 수 있는 구간! 끝");
        } catch (IOException e) { // 가까운 곳부터 좁은 범위 에러를 처리할 수 있다
            // catch문으로 받은 예외는 다음 catch문으로 전파되지 않는다!!
            System.out.println("IOException 처리 완료!");
            // -> sout문은 spring으로 올라가면 log로 처리하는 구간
        } catch (Exception e) {   // 가장 넓은 범위의 에러를 묶어 Exception으로 처리할 수 있다
            System.out.println("Exception 처리 완료!");
            return; // try-catch문 이후에 문장을 실행시키지 않을 때는 return으로 처리
        } finally {
            // try-catch문 이후에 반드시 동작해야 하는 코드가 있는 경우 작성하는 곳
            // 예시 : 주로 자원을 닫는 용도로 활용
            System.out.println("finally 구간 출력!");
            System.out.println("이곳은 예외가 발생하든 안하든 둘 다 동작하는 구간!");
        } // finally 이후의 return은 X

        System.out.println("main문 끝!!");
    }
}
