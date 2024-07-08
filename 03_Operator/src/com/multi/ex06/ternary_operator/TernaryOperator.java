package com.multi.ex06.ternary_operator;

// 삼항연산자, if문 정리
public class TernaryOperator {
	public static void main(String[] args) {
		int a = 100;
		int b = 50;
		int c = 30;
		
		// 삼항연산자 문법
		// (조건절) ? (참일때 실행,리턴 되는 문장) : (거짓일때 실행,리턴 되는 문장);
		String result = a > b ? "a가 b보다 크다." : "a가 b보다 작다.";
		System.out.println(result);
		// ★ 삼항 연산자의 장점 -> 한줄로 논리값을 판단하고 출력할수 있다
		System.out.println(a > b ? "a가 b보다 크다." : "a가 b보다 작다.");
		
		// 중첩 사용이 가능한다. 단, 권장하지 않는다. -> 가독성이 너무 떨어지면 if문으로 변경해서 사용한다. 
		// a, b, c를 비교하는 삼항 연산자
		result = a > b ? (b > c ? "a가 b보다 크고, b는 c보다 큼": "a가 b보다 크고, b는 c보다 작다") 
						 : (b > c ? "a가 b보다 작고, b는 c보다 큼" : "a가 b보다 작고, b는 c보다 작다");
		System.out.println(result);
		
		// 삼항연산자는 if문으로 완벽히 호환된다.
		// if문은 제어문으로 논리값을 통해 수식을 실행 시켜주는 문장
		// if(조건식) {조건식이 참이면 실행되는 문장}
		// else {조건식이 거짓이면 실행되는 문장}
		
		// String result = a > b ? "a가 b보다 크다." : "a가 b보다 작다.";
		if (a > b) {
			result = "a가 b보다 크다.";
		} else {
			result = "a가 b보다 작다.";
		}
		System.out.println(result);
		
//		result = a > b ? (b > c ? "a가 b보다 크고, b는 c보다 큼" : "a가 b보다 크고, b는 c보다 작다") 
//					 : (b > c ? "a가 b보다 작고, b는 c보다 큼" : "a가 b보다 작고, b는 c보다 작다");
		
		if(a > b) {
			if(b > c) {
				result = "a가 b보다 크고, b는 c보다 큼";
			} else {
				result = "a가 b보다 크고, b는 c보다 작다";
			}
		} else {
			if(b > c) {
				result = "a가 b보다 작고, b는 c보다 큼";
			} else {
				result = "a가 b보다 작고, b는 c보다 작다";
			}
		}
		System.out.println(result);
	}
}














