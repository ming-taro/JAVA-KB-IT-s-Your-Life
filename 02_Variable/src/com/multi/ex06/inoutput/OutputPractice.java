package com.multi.ex06.inoutput;

public class OutputPractice {
	
	public static void main(String[] args) {
		// 사용자 정보 출력하는 예제
		String name = "김길동";
		int age = 26;
		double height = 180.23;
		double weight = 65.23;
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		
		System.out.println("안녕하세요? 저는 " + name + "입니다.");
		
		// printf = format 출력
		// %s=문자열, %d=정수, %f=실수, %3.2f : 정수부를 3자리 간격, 소수점을 2자리까지 출력
		System.out.printf("이름은 %s, 나이는 %d, 키는 %f, 몸무게 %f\n", name, age, height, weight);
		System.out.printf("키는 %9.2f, 몸무게 %.2f\n", height, weight);

		System.out.println("안녕하세요? 저는 " + name + "입니다. 키는 " + height + "입니다.");
		System.out.println("안녕하세요? 저는 " + name + "입니다. 키는 " + height + "입니다.");
		
		// 문자열 format 활용하는 다른 방법
		String heightStr = String.format("%.1f", height);
		System.out.println("안녕하세요? 저는 " + name + "입니다. 키는 " + heightStr + "입니다.");
		System.out.println("안녕하세요? 저는 " + name + "입니다. 키는 "
								+ "" + String.format("%.1f", height) + "입니다.");
	}
}
