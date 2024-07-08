package com.multi.ex03.abstract_exam;

public abstract class HyundaiCar extends Car {
    // 현대자동차의 공통적인 필드
    public String serviceName = "블루핸즈";

    public HyundaiCar(String name, int cc) {
        super(name, cc);
    }

    // 추상메소드 -> 자식이 강제로 오버라이딩해야하는 메소드
    abstract public void nickName(); // 몸통(={ })이 없다

    // 일반 메소드 : 공통적인 기능을 구현할 때 일반 메소드를 활용하고 자식은 그냥 재사용!
    public void service() {
        System.out.println(serviceName + "로 출발 합니다.");
    }
}
