package com.multi.ex02.reference;

import java.util.Date;

public class ReferenceVariable {
    // 참조형(Reference Type) -> Pointer
    // 실제 값을 갖지 않고, 주소 가르치는 주소 값을 갖는 변수 ex) 0x0100 -> 값이 있는 주소지
    // 객체를 생성할시 객체는 heap에 생성이 되는데, 이 힙에 있는 객체를 접근하기 위하여 사용이 됨.
    // 학계 용어 : indirect / 간접이라는 표현으로 사용
    // 참조형은 주소값을 저장하는 공간으로 실제 메모리의 주소 크기를 갖는데.
    // OS별 - 32bit / 64bit

    // 참조형=Class의 특징(기본형과 다른)
    // 1. 기본형을 제외한 Java의 모든 변수는 참조형이다.
    // 2. 참조형의 Type은 대문자로 시작한다. (사용자가 만든 참조형=class는 소문자로 정의 가능하나 룰 위반이다.)
    // 3. 참조형은 null 초기화가 가능하다.
    // 4. 참조형은 대부분이 new를 통해 생성하고 heap에 저장된다.
    //    -> 가끔 new로 생성 되지 않는 클래스도 있다. (후반부에 알려줌. 이유 : 그렇게 설계해서)
    // 5. 모든 참조형은 Object를 상속한다. (Object는 모든 클래스의 부모이다.)

    public static void main(String[] args) {
        // 참조형의 대표 type = String(문자열)
        String str1 = null; // null = 참조형 값이 없을때 표기하는 키워드, '존재하지 않는다. 없다.'
        String str2 = "안녕하세요?"; // 문자열은 특수한 type으로 new 없이 생성 가능하다.
        String str3 = new String("안녕하세요?"); // 권장하지 않는 문법!

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        // 날짜 관련 Type
        Date date1 = new Date();
        Date date2 = null;
        System.out.println(date1);
        System.out.println(date2);

        // Integer = int의 참조형
        Integer intValue1 = null;
        Integer intValue2 = 31; // Auto boxing, 기본형을 자동으로 참조형으로 바꿔주는 방법
        Integer intValue3 = new Integer(31); // deprecated : Java에서 쓰지 않는것을 권장
        System.out.println(intValue1);
        System.out.println(intValue2);
        System.out.println(intValue3);
    }
}

