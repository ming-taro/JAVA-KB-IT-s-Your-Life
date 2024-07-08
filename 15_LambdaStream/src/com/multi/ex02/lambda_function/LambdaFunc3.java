package com.multi.ex02.lambda_function;

import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaFunc3 {
	// Function 조합하는 방법
	// andThen : 자신을 실행하고 그 다음 실행할 함수를 정할수 있다.
	// compose : 인자 함수를 먼저 실행하고 그 다음 자신이 실행된다.
	
	// Predicate 조합
	// : 조건식을 논리절로 조합하여 조합 Predicate를 만들수 있다. 있다. 
	// negate : 기존 조건식의 반대식, !가 붙음 
	// and : and조건으로 묶임 a and b
	// or : or조건으로 묶음 a or b
	// isEqual : ==을 대신함

	public static void main(String[] args) {
		// Function 조합하기
		// Function<T=인자 type, R=리턴 type>
		// 함수 조합시에는 주로 만들어진 함수를 사용하는데, String, wrapper, math 함수들을 활용
		Function<String, Integer> f1 = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String> f2 = (i) -> Integer.toBinaryString(i);
		Function<String, String> f3 = (str) -> str.repeat(3); // 반복시키는 함수
		
		// f1 -> f2 함수의 조합
		Function<String, String> h1 = f1.andThen(f2); // 자기자신 호출되고 그다음 인자(after)가 호출되는데
		// f2 -> f1 함수의 조합
		Function<Integer, Integer> h2 = f1.compose(f2); // 인자 함수(before)가 호출되고 그 다음 자신
		// f1 -> f2 -> f3 함수의 조합
		Function<String, String> h3 = f1.andThen(f2).andThen(f3);
		Function<String, String> h4 = h1.andThen(f3);
		
		System.out.println(h1.apply("FF")); // FF -> 255 -> 11111111
		System.out.println(h2.apply(2)); // 2 -> b0000010 -> 0x16
		System.out.println(h3.apply("F")); // F -> 16 -> b00001111 -> "111111111111"
		System.out.println(h4.apply("F")); // F -> 16 -> b00001111 -> "111111111111"
	
		// 항등함수 만드는 방법
		Function<String, String> f4 = (x) -> x;  // 항등 함수(identity function)
		System.out.println(f4.apply("TEST"));
		System.out.println("-------------------------------------------");
		
		// Predicate 논리절 조합하기 = boolean test(T t);
		Predicate<Integer> p = (i) -> i > 100; 
		Predicate<Integer> q = (i) -> i < 200; 
		Predicate<Integer> r = (i) -> i % 2 == 0; // 짝수
		Predicate<Integer> notR = r.negate(); // 부정을 당해서 -> 홀수
		
		// 조합해보기
		Predicate<Integer> combi1 = p.and(q); // i > 100 && i < 200
		System.out.println(combi1.test(50));  // false
		System.out.println(combi1.test(150)); // true
		System.out.println(combi1.test(250)); // false
		System.out.println("-------------------------------------------");
		
		Predicate<Integer> combi2 = p.and(q).and(r); // i > 100 && i < 200 && i % 2 == 0
		System.out.println(combi2.test(151)); // false
		System.out.println(combi2.test(150)); // true
		System.out.println(combi2.test(250)); // false
		System.out.println(combi2.test(251)); // false
		System.out.println("-------------------------------------------");
		
		Predicate<Integer> combi3 = p.and(q).or(r); // (i > 100 && i < 200) || i % 2 == 0
		// 100~200범위이거나 짝수일때
		System.out.println(combi3.test(151)); // true
		System.out.println(combi3.test(150)); // true
		System.out.println(combi3.test(250)); // true
		System.out.println(combi3.test(251)); // false
		System.out.println("-------------------------------------------");
		
		Predicate<Integer> combi4 = notR.or(p).and(q); // (i % 2 != 0 || i > 100) && i < 200
		System.out.println(combi4.test(151)); // true
		System.out.println(combi4.test(150)); // true
		System.out.println(combi4.test(250)); // false
		System.out.println(combi4.test(251)); // false
		System.out.println("-------------------------------------------");
		
		String str1 = "abc";
		String str2 = "abc";
		// str1과 str2가 같은지 비교한 결과를 반환
		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result);
	}
	
}













