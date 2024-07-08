package com.multi.ex02.object;

// Member의 제대로 된 버전! 이게 표준문법
// ValueObject : '브이오'로 읽고, 데이터만 있는 객체의 표현법, 멤버변수 + 생성자 + getter + setter + 기타(toString)
// VO의 객체에서는 멤버변수를 private로 접근 제한한다.
// 이유 : 외부에서 직접 변수로 접근하지 않고, getter/setter로 변수 접근을 제어한다!
// 만드는 방법은 반드시 자동완성으로 완성 시킨다. -> 나중에는 lombok 사용할 예정

// VO 만드는 방법! ★★★★★
// Step1. 객체에서 사용할 변수를 선언한다. 접근제한자 private로 통일한다. 올바른 타입을 활용
// Step2. alt + insert 혹은 우클릭 -> Generate를 클릭하여 필요한 코드를 자동생성한다.
//         생성자, 필드 있는 생성자, getter/setter, toString 생성한다!

import java.util.Objects;

public class MemberVO {
    private String name;
    private int age;
    private String phoneNum;
    private String address = "서울시 강남구";

    public MemberVO() {
    }

    public MemberVO(String name, int age, String phoneNum, String address) {
        this.name = name;
        this.age = age;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberVO memberVO = (MemberVO) o;
        return age == memberVO.age && Objects.equals(name, memberVO.name) && Objects.equals(phoneNum, memberVO.phoneNum) && Objects.equals(address, memberVO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, phoneNum, address);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MemberVO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", phoneNum='").append(phoneNum).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
