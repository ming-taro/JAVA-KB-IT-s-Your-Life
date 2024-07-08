package com.multi.ex03.run;

import com.multi.ex02.object.Member;
import com.multi.ex02.object.MemberVO;

// 실행 클래스, main만 가지는 클래스
public class Run {
    public static void main(String[] args) {
        // 멤버 객체 실습 공간
        Member m = new Member(); // 객체 선언시 최근애는 1~2글자로 줄여서 활용하는 것이 좋아보인다

        System.out.println("Member default값 출력");
        System.out.println(m.name); // 이름 없음, 생성자에서 초기화
        System.out.println(m.age);  // 0, JVM default 값
        System.out.println(m.phoneNum);  // null, JVM default 값
        System.out.println(m.address);   // 서울시 강남구, 멤버변수 선언시 초기화
        System.out.println("--------------------------");

        // 멤버변수/메소드 접근하는 연산자 : .(dot) 연산자 활용
        m.name = "홍길동";
        System.out.println(m.name);
        m.sayHello();
        System.out.println("\n--------------------------");

        // getter/setter 활용법
        m.setName("홍길동");
        System.out.println(m.getName());
        System.out.println("--------------------------");

        // 이름하고 주소 동시에 변경하는 메소드
        m.setNameAddAddress("박길동", "서울시 강남구 삼성동");
        System.out.println(m.getName() + ", " + m.address);
        System.out.println("--------------------------");

        // set and get
        String name = m.setAndGetName("박길동");
        System.out.println(name);
        System.out.println("--------------------------");

        // chain 설계 활용
        String name2 = m.setNameAndChain("임길동").getName();
        System.out.println(name2);
        System.out.println("--------------------------");
        // Member 실습 끝!

        // MemberVO 실습 시작
        MemberVO m2 = new MemberVO();
        m2 = new MemberVO("홍길동", 21, "010-1234-5678", "서울시 강남구");

        // 보통 인자를 받아와서 객체로 생성할 때 자동완성을 사용하면 편리하다.
        String name1 = "홍길동";
        int age = 21;
        String phoneNumber = "홍길동";
        String address = "홍길동";
        MemberVO m3 = new MemberVO(name1, age, phoneNumber, address); // 생성자의 인자와 타입을 일치시켜야 자동완성이 뜸
        System.out.println(m3.getName());
        System.out.println(m3.getAge());
        System.out.println(m3.getPhoneNum());
        System.out.println(m3.getAddress());
//        m3.name = "최길동";  // 안된다! private으로 인해 안된다!!
        m3.setName("최길동");
        System.out.println(m3.toString());

        // 객체 배열
        MemberVO[] mArray = new MemberVO[5];
        mArray[0] = new MemberVO("홍길동", 31, "010-1234-5678", "서울시 강남구 역삼동");
        mArray[1] = new MemberVO("최길동", 21, "010-1234-5678", "서울시 강남구 역삼동");
        mArray[2] = new MemberVO("김길동", 23, "010-1234-5678", "서울시 강남구 역삼동");
        mArray[3] = new MemberVO("이길동", 25, "010-1234-5678", "서울시 강남구 역삼동");
        mArray[4] = new MemberVO("유길동", 33, "010-1234-5678", "서울시 강남구 역삼동");

        for (MemberVO member: mArray) {
            System.out.println(member);
        }
    }
}