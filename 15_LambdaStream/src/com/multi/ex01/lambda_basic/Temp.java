package com.multi.ex01.lambda_basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Temp {
	//	https://docs.oracle.com/javase/8/docs/api/java/util/List.html?is-external=true
	// 컬렉션에서 다양한 람다식 사용 실습

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(i + 1);
		}
		System.out.println(list);

		// 1. forEach : list를 람다식으로 출력하는 방법
		//  인자 꼴 : java. util. function. Consumer<? super T> action
		//  메소드 꼴 : void accept(T t)
		list.forEach(v -> System.out.print(v + ", "));
		System.out.println();
		list.forEach((v) -> System.out.print(v + ", ")); // () 있는 버전
		list.forEach(System.out::println); // soutc : sout + consumer의 약자
		System.out.println();
		// 람다 시그니처 (v) -> ~~~
		
		// 2. removeif : list에서 일부 조건의 값을 제거하는 함수
		// 짝수 제거 예시
		list.removeIf((v) -> v % 2 == 0); // Predicate : 행동할 조건값, 필터링 값  boolean test(T t);
//		list.removeIf((v) -> v % 2 == 0 && v < 5);
//		list.removeIf((v) -> v > 5 && v < 10);
		System.out.println("짝수 제거된 : " + list);
		
		// 3. replaceAll : 내부있는 모든 변수를 교체하는 함수
		list.replaceAll((v) -> v * 10); // 자신의 값에서 10을 곱한 숫자를 넣는 방법
		System.out.println(list);

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
//		map.compute("5", (k, v) -> v.toUpperCase()); 
		
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


















