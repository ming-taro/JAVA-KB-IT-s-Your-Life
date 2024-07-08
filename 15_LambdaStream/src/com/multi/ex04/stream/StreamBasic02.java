package com.multi.ex04.stream;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.IntStream;

public class StreamBasic02 {
    // Collection에서 Stream 활용 예제
    // stream : 하나의 쓰레드 처리로 서버 프로그래밍에서는 일반적으로 stream을 활용 권장
    //          -> 이유 : 이미 Server가 Thread 처리가 기본적이라 의미가 없다.
    // parallelStream : 병렬처리 알고리즘, Thread 환경이 아니고 고속처리가 필요할때

    public static void main(String[] args) {
        // List 선언부
        // List - stream : 이 방법을 추천
        List<Integer> list = new ArrayList<>(List.of(2, 1, 4, 5, 9, 6, 8, 3, 7, 10));
        List<String> strList1 = new ArrayList<>(List.of("CCC","BBB","AAA","DDD","ABC"));

        // 중복 된 값이 포함된 리스트
        List<Integer> list2 = new ArrayList<>(List.of(2, 1, 2, 3, 3, 4, 4, 5, 5, 2));
        List<String> strList2 = new ArrayList<>(List.of("AAA","AAA","AAA","AAA","AAA"));

        // reduce : 스트림을 반복해서 연산하면서 값을 하나로 모으는 기능, BinaryOperator
        // reduce를 통한 sum 예제
        Optional<Integer> sum1 = list.stream().reduce((a, b) -> a + b);
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        System.out.println("sum: " + sum1.get() + ", sum2: " + sum2.get());
        System.out.println("----------------------------------------");

        // sum, average 메소드는 InputStream, DoubleStream 등 기본형 스트림에서 존재
        // 일반 스트림에서 IntStream으로 변경하는 방법
        IntStream intStream = list.stream().mapToInt(x -> x);   // 항등 함수
        int sum = intStream.sum();
//        intStream.average(); // stream has already been operated upon or closed
        OptionalDouble average = list.stream().mapToInt(x -> x).average();
        System.out.println("sum : " + sum);
        System.out.println("avg : " + average.getAsDouble());
        System.out.println("----------------------------------------");

        // 병렬처리로 sum 하는 방법 -> parallelStream 활용만 하면 된다.
        // -> 자동으로 Thread로 계산함으로 연산속도가 비약적으로 상승한다!
        int sum3 = list.parallelStream().reduce(0, Integer::sum);
        Optional<Integer> sum4 = list.parallelStream().reduce(Integer::sum);
        System.out.println("sum3 : " + sum3);
        System.out.println("sum4 : " + sum4.get());
        System.out.println("----------------------------------------");

        // 병렬처리로 min 값 구하기
        Optional<Integer> min1 = list.parallelStream().reduce(Integer::min);
        OptionalInt min2 = list.stream().mapToInt(x -> x).parallel().min();
        System.out.println("min1 : " + min1.get());
        System.out.println("min2 : " + min2.getAsInt());

        // 병렬처리로 min 값 구하기
        Optional<Integer> max1 = list.parallelStream().reduce(Integer::max);
        OptionalInt max2 = list.stream().mapToInt(x -> x).parallel().max();
        System.out.println("max1 : " + max1.get());
        System.out.println("max2 : " + max2.getAsInt());
        System.out.println("----------------------------------------");

        // count 하기
        long count = list.stream().count();
        long count2 = list.stream().distinct().count();
        System.out.println("count : " + count);
        System.out.println("count2 : " + count2);
        System.out.println("----------------------------------------");

        // 필터 예제
        // 3 초과
        System.out.println("3 초과값만 출력하기");
        list.stream()
                .filter(x -> x > 3)
                .forEach(x -> System.out.print(x + ", "));
        System.out.println("\n----------------------------------------");

        // 2단 필터링
        // 3 초과 7 미만
        System.out.println("3 초과 7미만 값만 출력하기");
        list.stream()
                .filter(x -> x > 4 && x < 7)
                .forEach(x -> System.out.print(x + ", "));
        System.out.println();
        list.stream()  // 위 처럼 조건절을 한 줄에 묶어서 처리해줘야 한다
                .filter(x -> x > 4)
                .filter(x -> x < 7)
                .forEach(x -> System.out.print(x + ", "));
        System.out.println("\n----------------------------------------");
    }
}
