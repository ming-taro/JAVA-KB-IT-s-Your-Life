package com.multi.ex02.lambda_function;

// 람다함수(function)이란?
// - 람다식 표현을 표준적으로 활용하기 위해  Java에서 제공하는 함수의 원형
// - 주로 인자로 람다함수를 받기 위해 활용 된다. (= callback 함수 용도)
// - 최신 라이브러이나 프레임워크는 해당 문법을 통해 활용을 강제화하고 있다. ex) Criteria Query
// - https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

// 주요한 람다 function 구조

// Supplier<T> : 공급자(생산자)로 특정 값을 생성하는 객체, 입력이 없고 리턴값만 존재
//         원형 : T get();

// Consumer<T> : 구매자(소비자)로 특정값을 소비(출력)하는 객체, 입력은 있고 리턴 값이 없다.
//         원형 : void accept(T t);

// Predicate<T> : 서술부란 의미로 주로 필터로 활용되며 입력값을 논리식으로 판별하는 구조
//             입력값이 있고, 출력은 boolean으로 활용
//          원형 : boolean test(T t);

// Function<T, R> : 함수형으로 인자와 리턴값의 모든 Type을 정하여 전달할수 있다.
//              T : 인자의 Type, R : 리턴값의 Type
//          원형 : R apply(T t)

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

// BiConsumer<T,U>, BiFunction<T,U,R>, BiPredicate<T,U>
// : 기존 기본 구조에서 2개의 인자를 활용할때 사용하는 람다 function
//   -> 인자가 3개 이상이면 일반 구조에서 컬렉션이나 객체 형태로 활용한다. ex) List, Member ...
public class LambdaFunc1 {
    public static void main(String[] args) {
        // Supplier : 공급자, T get();
        Supplier<Integer> supplier = () -> new Random().nextInt(100) + 1; // 1 ~ 100
        List<Integer> list = new ArrayList<>();
        makeRandomList(list, supplier, 10);
        System.out.println(list);
        System.out.println("--------------------------------------------");

        // Consumer : 소비자, void accept(T t); // 출력값이 없다? void 함수 사용!
        Consumer<Integer> consumer = (v) -> System.out.print(v + ", ");
        printFormat(list, consumer);
        printFormat(list, System.out::print); // consumer, println -> static(out이 static임)이면서 인자가 하나이므로 사용 가능
        System.out.println("--------------------------------------------");

        // Predicate : 동작부, 필터로 활용! boolean test(T t);
        Predicate<Integer> predicate1 = v -> v % 2 == 0; // 짝수 필터링
        Predicate<Integer> predicate2 = v -> v % 2 == 0 && v % 3 == 0; //  2와 3의 배수 필터링
        Predicate<Integer> predicate3 = v -> v % 2 == 0 || v % 3 == 0; // 2, 3의 배수 필터링

        printComputeNumber(list, predicate1, consumer);
        printComputeNumber(list, predicate2, consumer);
        printComputeNumber(list, predicate3, consumer);
        System.out.println("--------------------------------------------");

        // Function : 함수형, R apply(T t)
        // int로 받고 16진수 String으로 변환하는 예제
        Function<Integer, String> function1 = (v) -> "0x" + Integer.toHexString(v);
        List<String> newList = makeNewList(list, function1);
        System.out.println(newList);
        System.out.println("--------------------------------------------");

        // BiXXX류 : 기존 기본형에서 함수 인자를 2개로 활용 가능
        BiConsumer<String, Integer> biConsumer =
                (v1, v2) -> System.out.print(v1 + ": " + v2 + ", ");
        biConsumer.accept("test1", 1000);
        System.out.println("\n--------------------------------------------");

        // 만일 3개 이상 인자로 활용할 때는? 컬렉션 활용
        Consumer<List<String>> myConsumer = (l) -> {
            l.forEach(System.out::println);
        };
        myConsumer.accept(List.of("test1", "test2", "tset3"));
    }

    // 제네릭 함수
    // Supplier 함수부 예시
    private static <T> void makeRandomList(List<T> list, Supplier<T> s, int size) {
        for(int i = 0; i < size; i++) {
            list.add(s.get());
        }
    }

    // Consumer 함수부 예시
    private static <T> void printFormat(List<T> list, Consumer<T> c) {
        System.out.print("[");
        for(T v : list) {
            c.accept(v);
        }
        System.out.println("]");
    }

    // Predicate 함수부 예시
    private static <T> void printComputeNumber(List<T> list, Predicate<T> p,
                                               Consumer<T> c) {
        System.out.print("[");
        for(T v : list) {
            if(p.test(v)) {
                c.accept(v);
            }
        }
        System.out.println("]");
    }

    // Function 함수부 예시
    private static <T, R> List<R> makeNewList(List<T> list, Function<T, R> f) {
        List<R> newList = new ArrayList<>();
        for(T v : list) {
            newList.add(f.apply(v));
        }
        return newList;
    }
}
