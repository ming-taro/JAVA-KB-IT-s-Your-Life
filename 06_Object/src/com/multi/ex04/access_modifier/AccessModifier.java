package com.multi.ex04.access_modifier;

// 접근 제한자
public class AccessModifier {
    public int publicValue;       // 공공의 ,어디서든 접근 가능한 제한자 ★★★★★
    protected int protectedValue; // 상속시 부모 자식 + 같은 패키지 내에서 활용 가능
    int defaultValue;             // 같은 패키지 내에서만 활용, 일반적으로 보이면 안되는 접근 제한자
    private int privateValue;     // 자기 자신만 사용 가능한 접근 제한자 ★★★★★

    // 클래스 내부 필드 영역 = 자신의 영역
    public void myMethod() {
        publicValue = 1;     // O, 활용가능!
        protectedValue = 1;  // O, 활용가능!
        defaultValue = 1;    // O, 활용가능!
        privateValue = 1;    // O, 활용가능!

        System.out.println("publicValue = " + publicValue);
        System.out.println("protectedValue = " + protectedValue);
        System.out.println("defaultValue = " + defaultValue);
        System.out.println("privateValue = " + privateValue);
    }
}
