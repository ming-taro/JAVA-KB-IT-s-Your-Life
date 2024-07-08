package com.multi.ex05.enum_exam;

// Enum(열거형)이란?
// - 기존 상수(public static final)표현의 대체 문법으로 상수를 Type으로 정의하여 활용하는 문법
// - 상수에 대한 실제 값을 여러개로 가질수 있고, 타입 체크와 편리성을 갖춘 문법
// - 주로 Error 코드나 개발자간의 약속 된 상수를 활용하기 위한 방법으로 활용
//   -> public static final 구성 된 상수 Class를 사용하는 코드도 존재한다.

// 주요 메소드
// valueOf(String arg) : String 값을 enum에서 가져옴. 값이 없으면 예외 발생
// valueOf(Class<T> class, String arg) :넘겨받은 class에서 String찾아, enum에 가져옴.
// valueOf(String arg) :  내부적으로 자기자신 Class를 가져옴.
// values() : eum의 요소들을 순서대로 enum타입의 배열로 리턴.

// name() : 호출된 값의 이름을 String으로 리턴.
// ordinal() : 해당 값이 enum에 정의된 순서를 리턴.
// compareTo(E o) : enum과 지정된 객체의 순서를 비교. 지정된 객체보다 작은 경우
//                   음의 정수, 동일하면 0, 크면 양의 정수 리턴
// equals(Object other) : 지정된 객체가 enum 정수와 같은경우, true를 리턴.

// enum은 이질적으로 보이지만 class의 변형 구조로 유사한 구조를 가짐
public enum EnumBasic {
    // 상수선언 영역
    // 상수이름(상수인자1, 상수인자2 ....) -> 사실은 생성자 호출 문법이다.
    VALUE1(1, "문자열 상수값1"),
    VALUE2(2, "문자열 상수값2"),
    VALUE3(3, "문자열 상수값2");
//  public static final EnumBasic VALUE1 = new EnumBasic(1,"문자열 상수값)";

    private final int intValue;
    private final String stringValue;

    // 생성자 + 메소드 영역
    EnumBasic(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    // toString을 선언할수 있지만 웬만하면 쓰지 않는다... (과하다)
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EnumBasic{");
        sb.append("intValue=").append(intValue);
        sb.append(", stringValue='").append(stringValue).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
