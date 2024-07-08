package com.multi.ex03.abstract_exam;

public class _Run {
    public static void main(String[] args) {
        // 부모의 type의 array
        Car[] carArray = new Car[4];
//        carArray[0] = new Car("", 1000);
        carArray[0] = new Avante();
        carArray[1] = new Sonata();
        carArray[2] = new Grandeur();
        carArray[3] = new BmwM5();

        for (Car car : carArray) {
            printCar(car);
            // 만일 이 자리에서 아반떼의 닉네임을 출력하고 싶다면? -> 반드시 cast 검사가 필요하다
//            ((Avante)car).avanteNickName();
            // java.lang.ClassCastException, com.multi.ex02.poly_exam.Car cannot be cast to class com.multi.ex02.poly_exam.Avante
        }
    }

    // 자동차가 가지고 있는 모든 정보를 출력하는 메소드
    // 인자를 부모의 type인 Car로 대체할 수 있다
    private static void printCar(Car car) {
        System.out.println(car.toString());
        car.move(); // 동적 바인딩 발생하는 코드!
        car.oilling();

        if (car instanceof HyundaiCar hyundaiCar) {
            hyundaiCar.nickName();
            hyundaiCar.service();
            System.out.println(hyundaiCar.serviceName);
        }

        if (car instanceof BmwM5 bmwM5) {
            bmwM5.nickName();
        }
        System.out.println();
    }
}
