package com.multi.ex05.method_test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMethod {
    public static void main(String[] args) {
        // static 메소드의 올바른 사용법
        // static 메소드 접근 방법은 class이름.static메소드
        MyObject.staticMethod(); // static이면 이텔릭으로 기울어짐!
        MyObject object = new MyObject();
        object.staticMethod();   // 생성된 객체에서도 접근은 가능하나 권장하지 않음!

        object.printArgs(1, 2, "가", "나", "다");
//        printf(String format, Object ...args);
    }
}

class MyObject {
    // static method : 외부에서 클래스의 생성(new) 없이 접근 가능한 메소드
    // public static을 붙여서 활용한다
    public static void staticMethod() {
        System.out.println("static method 입니다.");
    }

    // 인자 1개 받는 메소드
    public void singleParameter(String str) {
        System.out.println(str);
    }

    // 인자는 무제한으로 선언할수 있지만, 상식적으로 3 ~ 4개까지가 적당. 많아도 5개까지만..
    // 5개 이상부터는 Class 묶어서 인자를 받는 형태로 설계
    // 인자 2개 이상 받는 메소드
    protected void multipleParameter(int a, int b, String str) {
        System.out.println(a + b);
        System.out.println(str);
    }

    // 많은 인자를 한번에 받는 Class 인자 예시
//    void printMember(MemberVO m) { // -> m에서는 인자 4개를 가지고 있음.
//        System.out.println(m.getName());
//        System.out.println(m.getAge());
//        System.out.println(m.getPhoneNum());
//        System.out.println(m.getAddress());
//    }

    // 반환값이 있는 메소드
    int returnValue(int a, int b) {
        return a + b;
    }

    // toString꼴
    String returnValue2(String name, String address) {
        return "이름 : " + name + ", 주소 : " + address;
    }

    public void printArgs(int val1, int val2, String... args) {
        for (String arg: args) {
            System.out.println(arg);
        }
    }
}
