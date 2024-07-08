package com.multi.ex04.interface_exam;

// interface란?
// - 객체지향 설계를 위해 상속 전용으로 상위(부모) class를 정의 하는 문법2 (추상 클래스와 용도는 같음)
// - interface 역시 생성(new) 할수 없으며, 상속하는 경우 implement를 통해 상속 가능
// - 유사 다중상속이 가능하며 'implement interface1, interface2'로 활용한다.
// - 추상 class와 다르게 일반적인 class 기능이 제한된다. (생성자X, 멤버변수X, 메소드는 일부 가능)
// - interface는 아래의 기능을 활용할수 있다.
//   1) 상수(public static final), 2) abstract 메소드 // 여기 까지가 1.8 이전문법
//   3) default 메소드(몸통 필요!),  4) private 메소드(몸통 필요!) // 1.8 버전부터 추가된 기능

public interface  _InterfaceBasic {
    // 멤버변수는 public static final을 생략 가능하다. 
    //  -> 만일 생략하면 public static final 자동으로 붙는다.
    // 상수만 선언할수 있다.
    public static final String STATIC_VALUE1 = "TEST1";
    String STATIC_VALUE2 = "TEST1"; // public static final 생략, 같은 문법

    public abstract void abstractMethod1();
    void abstractMethod2(); // public abstract를 생략할수 있으나 같은 문법

    default void defaultMethod(){
        privateMethod();
        System.out.println("call default method");
    }

    private void privateMethod(){
        System.out.println("call privateMethod method");
    }
}
