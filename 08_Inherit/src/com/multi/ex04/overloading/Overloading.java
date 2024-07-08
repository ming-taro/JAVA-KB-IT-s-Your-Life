package com.multi.ex04.overloading;

// 메소드 오버로딩이란?
// - 같은 메소드(함수) 이름 이면서 다른 타입의 인자를 받아들이고 같은 기능을 동작하게끔 설계할 때 사용
// - 대표적인 예시는 System.out.println()이다.

//  메소드 오버로딩 규칙
//	  1. 메소드의 이름이 같아야한다.
//	  2. 매개변수의 갯수가 다르거나
//	  3. 매개변수의 Type(종류)가 다르거나
//	  4. 매개변수의 Type 순서가 다르거나
//	  5. 반환형은 무관하다. (return 을 하든 안하든 된다.)
//	  6. 변수명은 무관하다. (Type으로만 판단함!)

public class Overloading {
    // 기본형
    void myMethod(){
        System.out.println("myMethod 호출!");
    }

    // 인자가 추가된 경우 -> OK
    void myMethod(int val){
        System.out.println("myMethod 호출! val : " + val);
    }

    // 리턴 type만 달라지는 경우 -> NG!
    // 'myMethod(int)' is already defined in 'com.multi.ex04.overloading.Overloading'
//    int myMethod(int val){
//        System.out.println("myMethod 호출! val : " + val);
//        return 1;
//    }

    // 인자가 많아지는 경우 -> OK
    void myMethod(int val1, int val2){
        System.out.println("myMethod 호출! val1 : " + val1 + "val2 : " + val2);
    }

    // 인자의 갯수는 같아도 type 다르면? -> OK
    void myMethod(String str){
        System.out.println("myMethod 호출! str : " + str);
    }

    public static void main(String[] args) {
        // 대표적인 오버로딩 된 메소드 : System.out.println();
        System.out.println();
        System.out.println(12);
        System.out.println(3.14);
        System.out.println('a');
        System.out.println("안녕");

        // 만일 오버로딩이 안된다면? -> type별로 함수의 이름을 바꿔서 활용해야한다.
//		System.out.printlnForInt(32);
//		System.out.printlnForStr("안녕");

        Overloading test = new Overloading();
        test.myMethod();
        test.myMethod(10);
        test.myMethod(10, 5);
        test.myMethod("안녕");
    }

    // 오버로딩 설계 방법 -> 생성자, 일반 메소드 둘다 활용 가능
    // 1. 인자가 가장 많은 메소드로 기능 구현을 한다. ★주기능 메소드
    // 2. 적은 인자의 메소드를 오버로딩으로 구현하고, 인자가 가장 많은 메소드를 호출
    // 설계 이유 : 편리성, 코드 중복 제거, 인자가 적게 들어와도 문제 없다는 알리기 위한 설계?

    // 최대 인자를 가지는 메소드 = 3, ★ 주기능 메소드!
    public void print(String name, String age, String address){
        if(name == null || name.isEmpty()){ // null 체크 + 빈문자열 체크
            name = "홍길동";
        }
        if(age == null || age.isEmpty()){ // null 체크 + 빈문자열 체크
            age = "21";
        }
        if(address == null || address.isEmpty()){ // null 체크 + 빈문자열 체크
            address = "서울시 강남구 역삼동";
        }

        System.out.println(name +", " + age +", " + address);
    }

    // 유지보수를 생각 없이 막짠 코딩 -> 코드를 중복해서 만듬
//    public void print(String name, String age){
//        if(name == null || name.isEmpty()){ // null 체크 + 빈문자열 체크
//            name = "홍길동";
//        }
//        if(age == null || age.isEmpty()){ // null 체크 + 빈문자열 체크
//            age = "21";
//        }
//
//        System.out.println(name +", " + age);
//    }

    public void print(String name, String age){
        print(name, age, null); // 인자가 가장 많은 메소드를 호출한다.
    }

    public void print(String name){
        print(name, null, null); // 인자가 가장 많은 메소드를 호출한다.
    }
}