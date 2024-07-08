package com.multi.ex02.test_inherit;

public class Run {
    public static void main(String[] args) {
//        new ChildClass(); // 부모가 먼저 생성되고, 다음으로 상속받은 자식이 생성된다
        System.out.println("부모 클래스 생성 시작!");
        new SuperClass();
        System.out.println("부모 클래스 생성 끝!");

        System.out.println("자식 클래스 생성 시작!");
        new ChildClass();
        System.out.println("자식 클래스 생성 끝!");

        // 부모의 publicMethod를 접근하는 방법
        // -> 자신의 클래스에서 오버라이딩 하지 않으면 부모의 메소드가 호출된다
        // -> 오버라이딩 된 메소드는 부모의 메소드로 절대 호출할 수 없다
        ChildClass childClass = new ChildClass();
        System.out.println("-----------------------------");
        System.out.println("＃ 자식 -> 부모");
        childClass.publicMethod();
        System.out.println("＃ 부모 publicMethod 호출");
        ((SuperClass)childClass).publicMethod(); // 동적바인딩
        System.out.println("-----------------------------");
    }
}
