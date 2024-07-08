package com.multi.ex02.poly_exam;

public class _Run {
    public static void main(String[] args) {
        // 부모의 type의 array
        Car[] carArray = new Car[5];
        carArray[0] = new Car("", 1000); // 이름이 없는 자동차
        carArray[1] = new Avante();
        carArray[2] = new Sonata();
        carArray[3] = new Grandeur();
        carArray[4] = new BmwM5();

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
        // 동적 바인딩이란?
        // - 컴파일 시점(정적 상황)에 호출될 메소드를 특정하지 않고, 실행중(runtime) 도중 동적으로 호출될 메소드를 찾아 정해지는 메커니즘
        // - 이 시점에서는 부모의 move를 실행할지 자식의 move를 실행할지를 실시간으로 찾아서 정해준다.
        // Avante -> 부모의 move 실행
        // Sonata -> Sonata Class의 move 실행
        car.oilling();

        // 각자의 닉네임을 출력하는 방법
        // insteadOf : 객체의 type을 비교하여 동일한 type인지 확인하는 연산자, 반환값은 boolean
        if (car instanceof Avante) {
//            ((Avante)car).avanteNickName();
            Avante avante = (Avante) car; // step1
            avante.avanteNickName();      // step2
        }

        // 단축된 instanceof 문법
        if (car instanceof Sonata sonata) {
            sonata.sonataNickName();
        }
        if (car instanceof Grandeur grandeur) {
            grandeur.grandeurNickName();
        }
        if (car instanceof BmwM5 bmwM5) {
            bmwM5.nickName();
        }
        System.out.println();
    }
}
