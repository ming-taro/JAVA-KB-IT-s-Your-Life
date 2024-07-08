package com.multi.ex01.fisrt_object;

public class FirstObject {
    public static void main(String[] args) {
//      type   변수명   초기화문
        int    value  = 10;
        Member member = new Member(); // 객체를 생성하는 키워드 = new, heap으로 할당한다

        member.name = "홍길동";
        member.age = 20;
        member.phoneNumber = "010-2875-7356";
        member.address = "서울시 강남구 역삼동";

        member.printInfo();
    }
}

// public class : .java파일과 이름이 일치하는 class이고, 파일당 하나만 존재 가능함!
// default class : public class가 아닌 일반 class를 의미하고, 외부에서 접근이 불가!
// -> 가능하면 public 클래스와 .java파일을 1:1로 만든다.

// 회원 정보를 관리하는 Class
class Member {
    // 멤버 변수
    String name;
    int age;
    String phoneNumber;
    String address;

    // 멤버 메소드
    void printInfo () {
        System.out.printf("name : " + name + "\nage : " + age + "\nphone number : " + phoneNumber + "\naddress : " + address);
    }
}