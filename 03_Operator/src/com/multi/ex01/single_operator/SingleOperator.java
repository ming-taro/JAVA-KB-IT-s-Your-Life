package com.multi.ex01.single_operator;

public class SingleOperator {
	public static void main(String[] args) {
		// 1. not(!)연산자 : 논리 값을 토글(Toggle)하는 용도로 활용
		boolean isTrue = true;
		
		System.out.println(isTrue);
		System.out.println(!isTrue);
		System.out.println(!!isTrue);
		
		isTrue = !isTrue;
		System.out.println(isTrue);
		System.out.println("-------------------------------");
		
		// 2. 증감 연산자 ++ --, 전위증감연산자, 후위증감연산자
		//    -> Tip. 한줄에 하나씩 쓴다.
		int a = 10;
		
		// 후위 연산, 세미콜론 기준으로 뒤에서 더해진다.
		System.out.println("a++");
		System.out.println(a++) /*(10)*/ ; /*(11)*/ 	// 출력 : 10
		System.out.println(a); // 출력 : 11
		
		a = 10;
		
		// 전위 연산, 자기를 먼저 더하는 연산을 시도하고 출력
		System.out.println("++a");
		System.out.println(++a); // 출력 : 11
		System.out.println(a);   // 출력 : 11
		
		a = 10;
		// 후위 연산을 쓰지않는 후위연산 하는 방법
		System.out.println("a++");
		System.out.println(a); // 출력 : 10
		a = a + 1;
		System.out.println(a); // 출력 : 11
		
		
		a = 10;
		// 전위 연산을 쓰지않는 전위연산 하는 방법
		System.out.println("++a");
		a = a + 1;
		System.out.println(a); // 출력 : 11
		System.out.println(a); // 출력 : 11
		
		
		// 3. 부호 연산 +,-
		a = +10;
		System.out.println(a);
		a = -10;
		System.out.println(a);
	}
}
