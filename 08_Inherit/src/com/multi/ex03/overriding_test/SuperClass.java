package com.multi.ex03.overriding_test;

// class의 앞에 붙은 final은 class 상속을 불가능하게 만든다!
public /* final */ class SuperClass {
    // 접근 제한자 별로 Override 실습

    private void privateMethod() {
        System.out.println("privateMethod 호출!");
    }

    void defaultMethod() {
        System.out.println("defaultMethod 호출!");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod 호출!");
    }

    public void publicMethod() {
        System.out.println("publicMethod 호출!");
    }

    // final : 메소드에 붙으면 오버라이드 불가!
    public final void finalMethod() {
        System.out.println("finalMethod 호출!");
    }
}
