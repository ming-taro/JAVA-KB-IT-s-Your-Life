package com.multi.ex02.poly_exam;

public class Grandeur extends Car {
    public Grandeur() {
        super("그랜저", 3000);
    }

    @Override
    public void oilling() {
        System.out.println("휘발유를 주유합니다.");
    }

    @Override
    public void move() {
        System.out.println("(조용히)위이이이잉");
    }

    // 고유 메소드
    public void grandeurNickName() {
        System.out.println("각그랜저");
    }
}
