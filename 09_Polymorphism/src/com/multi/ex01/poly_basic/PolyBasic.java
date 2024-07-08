package com.multi.ex01.poly_basic;

import java.math.BigDecimal;
import java.util.Date;

// 다형성이란?
// -> 부모의 타입으로 자식의 타입을 대체할수 있는 개념, 부모의 type으로 배열을 선언하여 자식을 담을수 있다.
public class PolyBasic {
    public static void main(String[] args) {
        Object[] objArray = new Object[5]; // Java의 만능주머니
        // 다형성의 속성을 통해서 모든 객체는 Object type으로 대체 될수 있다.
        // 가능한 이유 : the root of the class hierarchy, 최상위 부모이기 때문에

        objArray[0] = new Object();
//		objArray[1] = new String("test");
        objArray[1] = "test";
        objArray[2] = new Date();
        objArray[3] = new BigDecimal("1232432432423434.12121212121212");
        objArray[4] = 5; // Auto Boxing - java 1.5 이후에 담길수 있는 문법
        objArray[4] = (Integer)5; // Boxing? - 기본형과 참조형간의 타입 변경
//		objArray[4] = new Integer(5); // has been deprecated since version 9, 1.4버전 문법

        for(Object o : objArray) {
            System.out.println(o.toString());
            // Object의 toString 오버라이드한 자식의 toString을 출력하는 과정
        }

//		java.lang.Object@5e265ba4 - Object.toString()
//		test - String.toString() - ※오버라이드
//		Thu Nov 09 10:13:13 KST 2023 - Date.toString() - ※오버라이드
//		1232432432423434.12121212121212  BigDecimal.toString() - ※오버라이드
//		5  Integer.toString() - ※오버라이드
    }
}