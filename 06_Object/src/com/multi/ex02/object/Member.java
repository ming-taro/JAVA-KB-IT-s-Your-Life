package com.multi.ex02.object;

// 객체란? 현실에서 존재하는 대상(Object)를 추상화하여 데이터 + 메소드로 표현한 방법
// Member : 한 사람의 개인정보를 추상화 시켜 놓은 객체, 추상화 : 일부만 활용한다!
public class Member {
    // 멤버의 블록범위, 이곳을 필드라 부른다
    // 객체의 시작은 보통 멤버 변수 선언부로 시작하는게 일반적

    // 멤버변수란? 객체가 가질 수 있는 데이터(속성)
    // -> 멤버변수는 사용자가 초기화하지 않아도 0에 준하는 값으로 초기화
    //    숫자는 0, boolean false, 참조형(String, Date, 사용자 클래스)은 null로 초기화
    public String name;
    public int age;
    public String phoneNum;
    public String address = "서울시 강남구";  // 초기화문 선언도 가능!, 하지만 사용 거의 안함

    // 생성자란?
    // - 객체가 생성될 때 호출되는 특별한 메소드
    // - 용도 : 객체의 멤버변수를 초기화하거나 다른 초기화 로직이 필요할 때 활용
    // - 특징 : 1) return 값을 가질 수 없다 2) 만일 생성하지 않으면 JVM이 알아서 만들어준다
    // - 형식 : 객체이름() = default 생성자 끝, 만일 없는 경우 JVM이 생성시켜주는 꼴
    // 생성자 -> 사용시에는 new Member(); // new 뒤에 붙는 문장이 생성자 호출 문장
    public Member() {
        name = "이름 없음"; // 의도적인 초기화 문장
    }

    // 메소드 : 객체에서 특별한 기능을 가지는 함수
    // private void method() : 인자(입력값)가 없고, 리턴값도 없는 일반 메소드
    // void : 리턴값이 없을 때 사용하는 키워드
    public void sayHello() {
        System.out.printf("안녕하세요? 저는 " + name + "입니다.");
    }

    // 파라미터(인자)가 있는 메소드 설계 예시
    // 파라미터란? 메소드(함수) 외부에서 함수를 호출할 때 입력값을 전달하는 변수, 메소드의 로컬변수로 할당
    // void method(인자) : 리턴값이 없고, 인자 1개 이상을 가지는 메소드
    // 로컬변수 : 메소드가 호출될 때 Stack 영역에서 생성되고 메소드가 종료되면 정리되는 변수
    // setter의 표준 형태 - write only(쓰기 전용)
    public void setName(String name) {
//        String name = "홍길동";
        name = "홍길동"; // 인자인 로컬변수 값을 홍길동으로 변경! --> 의미가 없는 코드!!(가장 가까운 값부터 찍게 된다)
        this.name = name; // this 키워드는 필드를 가리키는 키워드이다
        // 멤버 변수인 name을 인자이자 로컬변수인 name의 값으로 대체하는 문장
    }

    // void method (인자1, 인자2) : 리턴값이 없고 인자가 2개인 메소드
    public void setNameAddAddress(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Stirng method() : 인자가 없고, 리턴값만 존재하는 메소드 꼴
    // 인자는 없지만, 실제로는 1개가 있다(해당 객체의 주소지)
    public String getName() {
//        return this.name;
        return name; // 인자가 없으므로 그냥 name을 쓰면 멤버변수가 반환됨
    }

    public int getAge() {
        return age;
    }

    public String getAgeStr() {
        return "" + age;
    }

    // Stirng method(인자) : 인자가 있고, 리턴값이 있는 메소드
    // 보통 인자는 많아도 3~4개까지 적당, 그 이상이 될때는 다른방법으로 전달할 필요가 있음
    // -> 객체!, Map
    public String setAndGetName(String name) {
        this.name = name;
        return this.name;
    }

    // chain 설계
    // m.setNameAndChain("홍길동").getName();
    public Member setNameAndChain(String name) {
        this.name = name;
        return this;
    }
}