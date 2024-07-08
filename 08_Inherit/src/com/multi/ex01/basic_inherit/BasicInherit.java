package com.multi.ex01.basic_inherit;

import java.util.Date;

// Object는 모든 객체의 최상위 부모(Root)
// 모든 클래스는 Object를 상속 받아 작성한 클래스이고, Object 상속 문법은 생략이 가능하다.
public class BasicInherit extends Object{
    public static void main(String[] args) {
        // Object 활용법 : 모든 type을 대체해서 활용 할 수 있다.
        // 부모(조상)의 type으로 자식의 type을 대체해서 활용 할 수 있다. 단, 자식의 기능은 활용할수 없다.
        Object obj1 = new Object();
        Object obj2 = new String();
        Object obj3 = new Date();
        Object obj4 = new BasicInherit();

        // getClass : 클래스의 다양한 정보를 알수 있는 메소드, 일반 사용자 용도는 아니다.
        // 리플렉션 (Reflection)에 해당하는 기술
        // Class의 이름을 출력
        System.out.println(obj1.getClass().getName());
        System.out.println(obj2.getClass().getName());
        System.out.println(obj3.getClass().getName());
        System.out.println(obj4.getClass().getName());

        // Class의 부모를 출력하는 방법
        System.out.println(obj1.getClass().getSuperclass()); // null -> root임으로 조상이 없다(Object는 최상위 클래스)
        System.out.println(obj2.getClass().getSuperclass());
        System.out.println(obj3.getClass().getSuperclass());
        System.out.println(obj4.getClass().getSuperclass());

        // 부모의 type을 자식의 type으로 복원하는 방법
        // Object -> Date
        // class간 type casting 문법을 활용하면 된다!
        System.out.println(obj3);
        System.out.println(((Date)obj3).getTime()); // 객체 casting 단축표현
        // 위에 문법을 풀어 쓰면
        Date date = (Date)obj3;
        long time = date.getTime();
        System.out.println(time);

        // ■ 참고 var 사용법 = 자바 11버전 이상만 활용 가능!
        // - var는 기본형의 type을 정하지 않고, 선언된 값의 type으로 대체하는 type(=익명 type)
        //  -> 멤버 변수로는 활용 할 수 없고, 로컬 변수로만 제약적으로 활용 가능
        var value1 = 5;
        var value2 = 3.14;
        var value3 = 518901890183183183L;
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }
}