package com.multi.ex01.generic;

import java.util.ArrayList;
import java.util.Date;

public class GenericBasic {
    // Generic(제네릭)이란?
    // - Type을 사용자가 외부에서 주입(injection) 시켜 정의하는 문법
    // - Java에서는 Type check 문법이 중요함으로 다형성이 적용되는 상황에서 type을 미리 정하는 문법으로 활용
    // - 주로 컬렉션에서 활용되며, 정해진 type 외의 다른 type이 삽입되지 않아 type을 check할 필요가 없음

    public static void main(String[] args) {
        // Type을 정하지 않고 Object 배열 선언하는 경우의 문제점
        // 1. 지정된 Type이 아닌 다른 Type에 대한 Check가 항상 필요했다. instanceof
        // 2. 객체를 제대로 활용하기 위해선 casting 필요했다.
        Object[] array = new Object[10];
        array[0] = "abc"; // String
        array[1] = new Date(); // Date
        array[2] = 4; // Integer

        for(Object o : array) {
            if(o instanceof Date) {
                System.out.println("날짜 : " + o);
            } else if(o instanceof String)  {
                System.out.println("문자 : " + o);
                System.out.println(((String)o).toUpperCase());
            }
        }
        System.out.println("---------------------------------------");

        // 상위 문제를 해결하기 위해 Type을 외부에서 정해 주입하는 제네릭 문법을 총해 해결!
        MyGenericArray<Integer> intArray = new MyGenericArray<>(10);
        MyGenericArray<Member> memberArray1 = new MyGenericArray<Member>(10); // 1.7 이전 문법
        MyGenericArray<Member> memberArray2 = new MyGenericArray<>(10);      // 1.7 이후 문법
        MyGenericArray memberArray3 = new MyGenericArray(10);        // Raw use of parameterized class 'MyGenericArray'

        MyGenericArray<Member> memberArray = new MyGenericArray<>(10); // 1.7 이후 정석적인 문법
//        memberArray.add(5); // error!
//        memberArray.add("test"); // error!
        memberArray.add(new Member("test1", "홍길동", 31));
        memberArray.add(new Member("test2", "김길동", 41));
        memberArray.add(new Member("test3", "박길동", 21));
        // 컴파일적으로 자신이 정하지 않은 type이 유입 되는 것을 막을 수 있다!

        Member m1 = memberArray.get(0); // type casting이 필요 없다!
        Member m2 = memberArray.get(1);
        Member m3 = memberArray.get(2);
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println("---------------------------------------");

        // Generic 상ㅇ속 문법 1 - 일반적인 문법, super, extends를 사용하지 않아도 문제가 없다!
        // Number는 Integer, Double의 부모!
        MyGenericArray<Number> numberArray = new MyGenericArray<>(10);
        numberArray.add(11);
        numberArray.add(new Integer(4));
        numberArray.add(new Float(3.14f));
        numberArray.add(new Double(3.14f));
        numberArray.add((double)3.14);
        System.out.println(numberArray.get(0));
        System.out.println(numberArray.get(1));
        System.out.println(numberArray.get(2));
        System.out.println(numberArray.get(3));
        System.out.println("---------------------------------------");

        // Generic 상속 문법 2 - ?(와일드카드) 표현법
        // Number가 부모인 Class만 해당 배열에 넣을 수 있다!
        MyGenericArray<? super Number> numberArray2 = new MyGenericArray<>(10);
        numberArray2.add(11);
        numberArray2.add(new Integer(4));
        numberArray2.add(new Float(3.14f));
        System.out.println(numberArray2.get(0));
        System.out.println(numberArray2.get(1));
        System.out.println(numberArray2.get(2));
    }
}
