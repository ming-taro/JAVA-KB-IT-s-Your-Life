package com.multi.ex04.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamBasic01 {
    // 스트림(Stream)이란?
    // - 함수형 프로그래밍이 가능한 순수 함수 문법인 람다의 확장 기능으로 우아한 코딩(?)이 가능하다.
    // - 본래 용도는 데이터 분석용도로 개발된 기능으로 다른 분석용 언어에서 지원하는 다양한 기능을 내장화 하였다.
    // - 또한 내부적으로 병렬처리를 지원함으로써 더욱 빠르게 데이터 처리가 가능하다.
    //   -> java에서 유일한 공식적인 병렬처리 방법으로 알고는 있어야한다. (혹시 모를 대용량 병렬처리를 위해)

    // 스트림 병렬처리 : 내부적으로 알고리즘과 Thread를 자동으로 구성하여 병렬처리 가능하다. -> 자동화
    // Thread : 병렬처리가 가능하도록 도구 제공하고 알고리즘은 개발자가 구성 필요 -> 반자동

    // https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html

    public static void main(String[] args) {
        String[] strArray = {"abc", "bbb", "ccc", "abb", "bcc", "ddd"};
        Stream<String> strStream = Stream.of(strArray); // 문자열 스트림 생성 방법

        // forEach : 스트림을 반복하면서 Consumer를 호출하는 방법
        // 단순 출력하는 방법
        strStream.forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------");

        // stream has already been operated upon or closed
        // -> ★★★★★ stream은 한번 사용하면 close 되므로 재사용할 수 없다!!
//        strStream.forEach(System.out::println); // System.out.print의 Consumer 버전

        // 해결 방법1 : Stream.of를 통해 계속 생성해서 사용하면 된다
        strStream = Stream.of(strArray); // stream을 사용하기 전에 다시 생성한다
        strStream.forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------");

        // 해결 방법2 : Arrays나 List 스트림 활용
        // Arrays.stream을 활용하거나 List.stream을 활용한다
        List<String> stringList = new ArrayList<>(Arrays.asList(strArray));
        stringList.stream().forEach(str -> System.out.print(str + ", "));
        System.out.println();
        stringList.stream().forEach(str -> System.out.print(str + ", "));     // stream을 두 번 이상 사용 가능
        System.out.println();
        Arrays.stream(strArray).forEach(str -> System.out.print(str + ", ")); // Arrays.stream으로 불러오는 방법도 있다
        System.out.println("\n----------------------------------------");

        // sorted : 스트림을 정렬하는 방법
        System.out.println("스트림 정렬");
        Stream.of(strArray).sorted().forEach(str -> System.out.print(str + ", "));
        System.out.println();
        Stream.of(strArray).sorted(Comparator.reverseOrder()).forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------");

        // map : 모든 인자를 조회 하면서 함수를 통해 값을 변경할 때 사용, Function 필요!
        System.out.println("대문자 변경");
//        Stream.of(strArray).map(str -> str); // 항등함수꼴 알아둘 것
        Stream.of(strArray)
                .map(String::toUpperCase)
                .forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------");

        // filter : 스트림에서 특정 조건에 해당되는 변수를 필터링할 때 사용, Predicate 필요
        System.out.println("a가 포함된 문자열 제거");
        Stream.of(strArray)
                .filter(str -> !str.contains("a")) // 즉, a를 포함하지 않는 문자열을 출력한다
                .forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------");

        // anyMatch : 스트림의 특정 객체가 조건에 매칭되는지 확인하는 기능
        // allMatch : 스트림의 모든 객체가 조건에 매칭되는지 확인하는 기능
        // noneMatch : allMatch 반대, 스트림의 모든 객체가 조건에 매칭되지 않는지 확인하는 기능
        System.out.println("a가 포함된 문자열 ");
        System.out.println("allMatch : " + Stream.of(strArray).allMatch((str) -> str.contains("a")));
        System.out.println("anyMatch : " + Stream.of(strArray).anyMatch((str) -> str.contains("a")));      // 하나라도 있는가
        System.out.println("noneMatch : " + Stream.of(strArray).noneMatch((str) -> str.contains("a")));
        System.out.println("----------------------------------------");

        // distinct : 중복을 제거하는 기능
        String[] strArray2 = {"aaa", "bbb", "bbb", "ccc", "ccc", "ccc"};
        System.out.println("중복 제거");
        Stream.of(strArray2).forEach(str -> System.out.print(str + ", "));
        System.out.println();
        Stream.of(strArray2).distinct().forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------");

        // 복합 예제1) 대문자 변경 + 중복 제거
        System.out.println("대문자 변경 + 중복 제거");
        Stream.of(strArray2) // 연산 ↑
                .map(String::toUpperCase)
                .distinct()
                .forEach(str -> System.out.print(str + ", "));
        System.out.println();
        Stream.of(strArray2) // 연산 ↓
                .distinct()
                .map(String::toUpperCase)
                .forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------");

        // 복합 예제2) 대문자 변경 + 중복 제거 + 정렬
        System.out.println("대문자 변경 + 중복 제거 + 정렬");
        Stream.of(strArray2)
                .sorted()
                .distinct()
                .map(String::toUpperCase)
                .forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------");

        Stream<String[]> strArrStrm2 = Stream.of(
                new String[]{"abc", "bbb", "ccc"},
                new String[]{"ABC", "bbb", "ddd"} );

        // 스트림을 만드는 가장 기본적인 방법
//     Stream<Stream<String>> strStream2 = strArrStrm2.map(Arrays::stream);

        // flatMap : 2차원을 1차원으로 바꾸는 메소드
        System.out.println("2차원 스트림을 1차원으로 변경");
        Stream<String> strStream3 = strArrStrm2.flatMap(Arrays::stream);
        strStream3.forEach(s -> System.out.print(s + ", "));
    }
}