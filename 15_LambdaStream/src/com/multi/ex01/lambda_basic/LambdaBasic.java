package com.multi.ex01.lambda_basic;

import java.util.Map;

// 람다식이란? (Java8부터 활용)
// - 함수형 프로그래밍이 가능한 순수 함수 문법
// - 메서드를 하나의 식(반드시 입력과 출력이 있는 식)으로 표현 가능한 문법
// - 기존 익명 클래스로 가능한 방법이었으나 그 문법을 간편화하여 구성
public class LambdaBasic {
    public static void main(String[] args) {
        // 기존의 익명 클래스로 MyLambda를 구현하는 문법
        MyLambda1 f0 = new MyLambda1() { // MyLambda1를 상속받는 익명 클래스
            @Override
            public void run() {
                System.out.println("MyLambda1 call!!");
            }
        };
        f0.run();

        // 람다 기본형: (v1, v2, ...) { }
        // -> 중괄호 사용시 여러줄의 내용을 사용할 수 있다
        MyLambda1 f1 = () -> {
            System.out.println("MyLambda1 call!!");
            System.out.println("MyLambda1 call!!");
        };
        f1.run();

        // 람다 단축 표현1 - { ... } 한 줄일 때 중괄호 생략 가능!
        MyLambda1 f2 = () -> System.out.println("MyLambda1 call!!");
        f2.run();

        // 람다 단축 표현2 - 인자가 한 개일 때는 (~~)도 생략 가능!
//        MyLambda1 f3 = () -> System.out.println("MyLambda1 call!!"); // 0개이므로 안됨
        MyLambda2 f3 = msg -> System.out.println("msg: " + msg);  // 인자가 1개이므로 괄호 생략 가능
        f3.print("Hello World!");

        // 여러 파라메터 + 리턴값을 받는 람다식 활용
        MyLambda3 f4 = (value1, value2) -> {
            return value1 * value2;
        };

        int result = f4.calc(2, 5);
        System.out.println("result: " + result);

        // 람다 단축표현3 - return이 있을 때 한 줄짜리 리턴은 생략 가능 (여러 줄은 생략 불가!)
        MyLambda3 f5 = (a, b) -> a * b;
        int result2 = f5.calc(4, 5);
        System.out.println(result2);

        // 람다 함수의 메소드 인자 활용
        MyLambda3 f6 = (a, b) -> a * b; // 람다의 전제는 익명클래스라는 것!
        int result3 =staticMethod(f6, 10, 5);
        System.out.println(result3);

        // 직접 람다를 선언하여 인자로 활용!
        int result4 = staticMethod((a, b) -> a * b, 10, 20);
        // 익명 클래스 버전
        int result5 = staticMethod(new MyLambda3() {
            @Override
            public int calc(int value1, int value2) {
                return value1 * value2;
            }
        }, 10, 20);
        System.out.println(result4);
        System.out.println(result5);

        // 이미 생성된 람다함수 활용법 '::' 활용, static 메소드만 활용 가능!!
        // MyClass는 인터페이스가 아니지만 형식만 같다면 함수를 사용할 수 있다
        int result6 = staticMethod(MyClass::sum, 10, 20);
        int result7 = staticMethod(MyClass::multiply, 10, 20);
        int result8 = staticMethod(Integer::sum, 5, 4);
        int result9 = staticMethod(Math::multiplyExact, 5, 4);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);

        // 생성자 람다 활용법
        MyMember member = staticMethod2(MyMember::new);
        System.out.println(member);

        MyMember member2 = staticMethod3(MyMember::new, "홍길동", 31);
        System.out.println(member2);
    }

    public static int staticMethod(MyLambda3 func, int a, int b) {
        return func.calc(a, b);
    }

    public static MyMember staticMethod2(MyLambdaCreatable creatable){
        return creatable.createMember(); // 생성자 꼴을 람다로 돌려줌
    }

    public static MyMember staticMethod3(MyLambdaCreatable2 creatable, String name, int age){
        return creatable.createMember(name, age);
    }
}
