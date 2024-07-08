package com.multi.ex04.access_modifier;

// 같은 패키지 내 Class 영역
public class TestAccessModifier {
    public static void main(String[] args) {
        // AccessModifier와 같은 패키지에서 멤버변수 접근 테스트
        AccessModifier accessModifier = new AccessModifier();
        accessModifier.publicValue = 1;    // O, 접근 가능!
        accessModifier.protectedValue = 2; // O, 접근 가능!
        accessModifier.defaultValue = 3;   // O, 접근 가능!
//        accessModifier.privateValue = 1;   // X, Error 발생! private은 절대 직접 접근할 수 없다!
        accessModifier.myMethod();

    }

}
