package com.multi.ex03.overriding_test;

public class ChildClass extends SuperClass {
    // 접근 제한자 별로 상속 실습

    // 1. privateMethod -> 오버라이드 불가!
    // 이유 : private 접근제한자는 다른 클래스에서 사용할 수 없다!!

    // 2. defaultMethod -> 오버라이드
    // 이유 : 같은 패키지이므로 default 접근이 가능하다
    @Override
    void defaultMethod() {
        super.defaultMethod();
    }

    // 3. protectedMethod -> 오버라이드 가능!
    // 이유 : protected 접근 제한자는 패키지 상관 없이 부모자식에서 재사용 가능하다!
    // 오버라이드시 접근제한자는 더 넓은 접근제한자 범위로 변경할 수 있다
    // protected는 대부분 public으로 변경하여 메소드를 활용해야 한다
//    @Override
//    protected void protectedMethod() {
//        super.protectedMethod();
//    }

    // protected -> public 변경 가능! (필수!!)
    @Override
    public void protectedMethod() {
        super.protectedMethod();
    }

    // 4. publicMethod -> 오버라이드 성공!
    // 이유 : public은 모든 된다!
    @Override
    public void publicMethod() {
        super.publicMethod();
    }

    // 5. finalMethod -> 오버라이드 불가!
    // 이유 : finale 키워드는 오버라이드가 불가하다
    // finalMethod()' cannot override 'finalMethod()' in 'com.multi.ex03.overriding_test.SuperClass';
    // overridden method is final
//    public void finalMethod() {}
}
