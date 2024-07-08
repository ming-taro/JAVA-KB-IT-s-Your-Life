package com.multi.com.multi.ex05.typecasting;

public class TypeCasting {
    // TypeCasting이란? type간의 형을 변환하는 방법, ex) int -> long, int -> double

    // 종류 2가지
    // 1) 자동 형변환 : 작은 Type에서 큰 Type으로 갈 때, 아무 문제가 없고, cast를 명시하지 않아도 된다. (묵시적 형변환)
    // 2) 강제 형변환 : 큰 Type에서 작은 Type으로 갈 때, 데이터 손실이 발생할수 있다. (명시적 형변환)
    //		   	      반드시 cast 문법을 명시해야한다. -> 안하면 에러 발생 -> 프로그램이 죽는다!
    public static void main(String[] args) {
        byte value = 100; // java에서 정수는 int형으로 정의된다.
        value = 123; // 자동형변환
        value = (byte)123; // 문제없음
        value = (byte)40000;
        System.out.println("value = " + value); // 64 : overflow 발생한 값


        // 의도한 강제형변환 문법 1. 소수점 버리기
        int intValue = 0;
        long longValue = 0;
        double doubleValue = 3.14;
        float floatValue = 3.14f;
        intValue = (int)doubleValue;
        longValue = (long)floatValue;
        System.out.println("intValue = " + intValue);
        System.out.println("longValue = " + longValue);
        
        // 의도한 강제형변환 문법 2. 문자열 형변환
        char ch = 'A';
        int alpha = ch; // 65, 자동형변환 발생
        System.out.println(ch);
        System.out.println(alpha);
        System.out.println((char)alpha); // 강제 형변환
        System.out.println((char)++alpha); // 강제 형변환
        System.out.println((char)++alpha); // 강제 형변환
        System.out.println((char)++alpha); // 강제 형변환
        System.out.println((char)++alpha); // 강제 형변환
        // 대문자에서 소문자 바꾸는 방법
        System.out.println('A' - 'a'); // gap 계산
        System.out.println((char)(alpha - 'A' + 'a'));
        System.out.println("e".toUpperCase()); // 문자열 메소드 활용!

    }



}
