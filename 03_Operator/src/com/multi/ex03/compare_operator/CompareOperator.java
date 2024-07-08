package com.multi.ex03.compare_operator;


// 비교 연산자
public class CompareOperator {
	public static void main(String[] args) {
		int a = 100;
		int b = 200;
		
		// 비교연산자 사용
		System.out.println(a == b); // a와 b가 같은가? -> 답 아니요=false
		System.out.println(a != b); // a와 b가 같지 않은가? -> 답 예=true
		System.out.println("--------------------------------");
		
		// 문자열 비교, ※ 주의 : 이해하기 어렵다. 그러니 외우는 것을 추천.
		// -> 상식 : 비교연산자는 문자열에 사용할 수 없다. (진리)
		// https://www.javastring.net/java/string/pool 참고 할 것
		String str1 = "안녕하세요?"; // string pool
		String str2 = "안녕하세요?"; // string pool
		String str3 = new String("안녕하세요?"); // heap에 저장되는 값
		
		System.out.println(str1 == str2); // 예측 : true, 결과 : true
		System.out.println(str2 == str3); // 예측 : true, 결과 : false!!!, 예측 틀림!!
		
		
		// String 비교시에는 항상 주의 필요, '==' 사용하면 예측과 틀린 결과가 발생한다. 
		// 프로그래머가 new를 사용하지 않더라도 시스템에서 생성되는 문자열은 heap에 들어갈수도 있다.
		// -> 문자열 비교시에는 String.equals라는 메소드 활용할것! ★★★★★
		
		// java에서 문자열 비교 정석 방법 ★★★★★
		System.out.println(str1.equals(str2)); // 예측 : true, 결과 : true
		System.out.println(str2.equals(str3)); // 예측 : true, 결과 : true
		
		// 문자열이 포함되는지 확인하는 방법
		String str4 = "안녕";
		System.out.println(str1.contains(str2)); // 안녕하세요?에 안녕하세요?가 있는지 확인
		System.out.println(str1.contains(str4)); // 안녕하세요?에 안녕가 있는지 확인
		System.out.println("안녕하세요?".contains("하이")); // false

		// 결론!! 문자열 비교는 ==로 하면 안된다. equals를 활용해야한다!!
	}
}
