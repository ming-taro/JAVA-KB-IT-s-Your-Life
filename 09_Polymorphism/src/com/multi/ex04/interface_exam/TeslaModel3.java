package com.multi.ex04.interface_exam;


// Car + 전기차 + 해외차(중국산)
public class TeslaModel3 extends Car implements OverseasAndEletricType {

    public TeslaModel3() {
        super("테슬라 모델3", 175); // km/h
    }

    @Override
    public void oilling() {
        charge();
    }

    // 인터페이스에서 강제화한 메소드
    @Override
    public void charge() {
        System.out.println("테슬라 전용 급속 충전기 충전합니다.");
    }

    @Override
    public String getOrigin() {
        return "china";
    }
}

