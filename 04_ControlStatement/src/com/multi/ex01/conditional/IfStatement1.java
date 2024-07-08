package com.multi.ex01.conditional;

// if 문법 정리
// if (조건식1) {
//    (조건식1이 참이면 실행되는 문장)
// } 
// else if (조건식2){
//    (조건식2가 참일때 실행되는 문장)
// }
// .... (else if문이 더 붙을수 있다!)
// else {
//    (모든 조건이 해당되지 않을때 실행되는 문장)
// }
//
// 조합1 : if
// 조합2 : if - else
// 조합3 : if - else if - else
// 조합4 : if - else if 

public class IfStatement1 {
	
	public static void main(String[] args) {
		int a = 5;
		
		// 가장 기본적인 if문 스타일
		if(a == 5) {
			System.out.println("5입니다.");
		}
		
		// 중괄호가 없어도 되지만, 코딩 스타일상 포함하는을 권장!
		// 만일 중괄호가 없는 경우 아래 한줄만 if문으로 제어 가능!
		if(a > 0)
			System.out.println("양수입니다.");
		
		
		// if-else문 java 스타일
		if (a % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}

		
		// if-else문의 c언어 스타일(고전), 추천X
		if(a % 2 == 0)
		{
			System.out.println("짝수입니다.");
		} 
		else 
		{
			System.out.println("홀수입니다.");
		}
		
		
		// else 역시 중괄호가 없이 if문으로 활용 가능하다, 권장하지 않는다!
		if (a % 2 == 0)
			System.out.println("짝수입니다.");
		else
			System.out.println("홀수입니다.");
			System.out.println("a는 홀수가 맞습니다!");
	}
}














