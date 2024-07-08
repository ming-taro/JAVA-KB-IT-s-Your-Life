package com.multi.ex03.abstract_exam;

// 추상 클래스화
// -> 최상위 부모는 생성하지 못하도록 abstract
public abstract class Car {
    // 공통으로 사용할 멤버변수
    protected String name; // 자동차의 이름
    protected int cc;      // 배기량

    // 인자 있는 생성자를 통해 필수적인 데이터를 담는다 -> 인자 없는 생성자는 만들지 않는다
    public Car(String name, int cc) {
        this.name = name;
        this.cc = cc;
    }

    // 공통기능 1. 주유기능
    public void oilling() {
        System.out.println("주유중 입니다.");
    }

    // 공통기능 2. 움직이는 기능
    public void move() {
        System.out.println("부릉부릉");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("name='").append(name).append('\'');
        sb.append(", ClassName='").append(this.getClass().getSimpleName()).append('\'');
        sb.append(", cc=").append(cc);
        sb.append('}');
        return sb.toString();
    }
}
