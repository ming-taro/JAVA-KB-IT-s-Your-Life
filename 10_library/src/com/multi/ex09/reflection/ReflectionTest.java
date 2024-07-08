package com.multi.ex09.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // Reflection이란?
        // - .class 파일을 JVM에서 읽어 Class의 구조를 해석한 정보를 접근하는 방법
        // - class의 구조 정보는 Method Area(static 영역)에 존재하며 해당 메모리 영역에 접근한다.
        // - class의 구조에 관련된 모든 정보(생성자, 멤버변수, 메소드, 정적 영역, 어노테이션 등)을 읽어올수 있다.
        // - 필요시 class의 메소드를 호출할수도 있다.
        // - 사실 일반적인 java 사용자를 위한 기능이 아님으로 응용프로그래밍 영역에서는 사용해서 안된다.(서버,앱 개발)
        // - 프레임워크나 라이브러리 레벨에서 활용하는 기능으로 다른 사용자가 정의한 Class 구조를 해석할때 활용된다.
        // - 자세한건 리플렉션 개념글 참고 : https://steady-coding.tistory.com/609

        // 리플렉션 객체로 불러오는 방법
        // 1. Class이름.class
        System.out.println(ReflectionTest.class.getName());

        // 2. Class.forName
        // ctrl + alt + t -> try-catch문 자동생성
        try {
            System.out.println(Class.forName("java.lang.String").getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 3. getClass()로 활용
        ReflectionTest obj = new ReflectionTest();
        System.out.println(obj.getClass());


        // 리플렉션 활용 방법
        String str = "Hello Java World";
        System.out.println(str.getClass().getName()); // 패키지 포함한 이름
        System.out.println(str.getClass().getName()); // 패키지 포함한 이름
        System.out.println(str.getClass().getSimpleName()); // 클래스 이름
        System.out.println(str.getClass().getSuperclass().getName()); // 부모
        System.out.println(str.getClass().toGenericString()); // toGenericString
        System.out.println("---------------------------------------------------");

        // 생성자 정보
        System.out.println("생성자 정보");
        for (Constructor<?> constructor : str.getClass().getDeclaredConstructors()) {
            System.out.println(constructor.toGenericString());
            try {
                if(constructor.getParameterCount() == 1
                        && constructor.getParameterTypes()[0].getName().equals("java.lang.String")){
                    // 생성자로 객체 생성하는 방법
                    String str2 = (String)constructor.newInstance("Hello Java World!");
                    System.out.println(str2 + "@@@@@@@");
                }
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("----------------------------------------------------");

        // 필드 정보
        System.out.println("필드 정보");
        for (Field field : str.getClass().getDeclaredFields()) {
            System.out.println(field.toGenericString());
//            field.set(str, "Test"); 필드가 set 하기
        }
        System.out.println("----------------------------------------------------");

        // 메서드 정보
        System.out.println("메서드 정보");
        for (Method method : str.getClass().getDeclaredMethods()) {
            System.out.println(method.toGenericString());
            if (method.getName().equals("length")) {
                // invoke : 대상 메소드를 실제 호출하는 기능
                System.out.println(method.invoke(str, null));
                System.out.println(((String) str).length());
            }
        }
        System.out.println("----------------------------------------------------");

    }
}







