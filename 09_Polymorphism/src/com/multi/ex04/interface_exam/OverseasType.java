package com.multi.ex04.interface_exam;

// 수입차임을 알리는 인터페이스
public interface OverseasType {
    // 추상 메소드
    String getOrigin();

    private String getMadeInText() {
        return "Made in " + getOrigin();
    }

    default void printOrigin() {
        System.out.println(getMadeInText());
    }
}
