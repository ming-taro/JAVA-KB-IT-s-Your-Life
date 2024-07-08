package com.multi.ex06.anotation_exam;

// Anotaion이란?
// - 자바 어너테이션은 자바 소스 코드에 추가하여 사용할 수 있는 메타데이터의 일종
//   -> 메타데이터란? 데이터에 관한 구조화된 데이터로 다른 데이터를 설명해준다. ex) 확장자(.jpg, .mp3 .exe ...)
// - @ 기호를 앞에 붙여서 사용한다. JDK 1.5 버전 이상에서 사용 가능 (더 과거에는 xml base로 메타데이터를 입력하였음)
// - 어노테이션은 클래스 파일에 임베디드되어 컴파일러에 의해 생성된 후 자바 가상머신에 포함되어 작동
// - 보통 사용자가 정의해서 사용하기 보단 프레임워크 레벨에서 필요한 정보를 입력 받을때 활용
// - java 내부적으로는 interface의 변형 문법으로 활용된다.
// - https://ittrue.tistory.com/160
// - https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Target.html
// - https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/ElementType.html

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target: 어노테이션을 활용할 대상을 지정하는 어노테아션
@Target({ElementType.TYPE, ElementType.METHOD}) // 의미: 멤버변수나, Class 위에 붙이거나 메소드에도 붙을 수 있음
// @Retention: 어노테이션이 유지되는 정책을 의미
@Retention(RetentionPolicy.RUNTIME) // 실행 도중에 활용할 메타데이터
// interface 앞에 @을 붙여서 Anotation interface임을 알림!
public @interface AnotaionBasic {
    // 어노테이션에서 사용할 변수를 선언하는 영역
    // @AnotationBasic("test") -> value로 들어옴

    // value: 특수한 어노테이션 변수의 이름으로 변수명을 생략하는 경우 value로 맵핑됨
    String value() default "-";
    String[] values() default { "-", "-" };
    int number() default 0;
}
