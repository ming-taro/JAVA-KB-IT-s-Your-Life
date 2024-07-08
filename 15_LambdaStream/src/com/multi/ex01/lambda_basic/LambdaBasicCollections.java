package com.multi.ex01.lambda_basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaBasicCollections {
    //	https://docs.oracle.com/javase/8/docs/api/java/util/List.html?is-external=true
    // 컬렉션에서 다양한 람다식 사용 실습

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
        System.out.println(list);

        // 1. forEach : list를 stream으로 변경해주는 메소드, 반복 용도로 활용!
        // 필요 인자 : public interface Consumer<T> = 출력할 때, 소비할 때
        // 람다식 꼴 == type : void accept(T t); -> 메소드 이름은 무시하고 꼴만 맞으면 된다
        // -> 리턴값은 없고 인자 1개를 가진 메소드를 구현 하면 된다
        list.forEach(v -> System.out.print(v + ", "));
//		list.stream().forEach();
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();

        // 2. removeIf : list에서 일부 조건을 제거해주는 기능
        // 인자 : Predicate = 필터 용도
        // 람다꼴 : boolean test(T t);
        // 짝수 제거 예시
//		list.removeIf(v -> v % 2 == 0);
        // 짝수 제거 + 5보다 작은 수 제거
        list.removeIf(v -> v % 2 == 0 || v < 5);
        System.out.println(list);

        // 3. replaceAll
        // 인자 : Function<T, R>
        // R apply(T t); // 인자가 있고 리턴값이 있는 함수
        // 자신을 10으로 곱한 수로 만들어주는 연산
//		List<Integer> list2 = List.of(1, 2, 3, 4 ,5); // ImmutableCollections -> 변경 불가
        List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        list2.replaceAll(v -> v * 10);
        System.out.println(list2);

        // Map에서 람다 문법 사용해보기
        Map<String, String> map = new HashMap<>();
        map.put("1", "aaa");
        map.put("2", "bbb");
        map.put("3", "ccc");
        map.forEach((k, v) -> System.out.print("{" + k + ":" + v + "}, "));
        System.out.println();

        // compute : key가 존재하면 선언한 함수식의 실행되고 값을 바꿔야한다.
        map.compute("1", (k, v) -> v.toUpperCase()); // R apply(T t, U u);
        // -> k, v 동시에 인자로 오지만 둘다 사용해도되고 안해도 된다.
        System.out.println(map);

        // compute 도중에 만약 key값이 없다면?
        // --> error발생!
//     map.compute("5", (k, v) -> v.toUpperCase());

        // computeIfPresent : 만일 key값이 존재할때만 함수식 실행
        map.computeIfPresent("1", (k, v) -> v.toUpperCase() + "BBB");
        map.computeIfPresent("5", (k, v) -> v.toUpperCase() + "BBB");
        System.out.println(map);

        // computeIfAbsent : 만일 key가 존재하지 않으면 새로운 value를 추가함
        map.computeIfAbsent("3", (v) -> v.toUpperCase() + "부재중");
        System.out.println(map);

        // 없어도 에러 발생하지 않음!
        map.computeIfAbsent("4", (v) -> v + "DDD");
        System.out.println(map);
    }
}