package com.multi.ex06.inoutput;

import java.util.Scanner;

public class InputPractice {
	public static void main(String[] args) {
//		String str = ""; // java.lang import 안해도 된다.
		Scanner sc = new Scanner(System.in); 
		
		// 문자열 입력 받아오기
		System.out.println("문자열을 입력 바랍니다.");
		String str = sc.nextLine();
		System.out.println(str);
		
		// 숫자 입력 받아오기
//		System.out.println("숫자를 입력 바랍니다.");
//		int value = sc.nextInt(); // -> 이 방법 쓰지 말것!
//		System.out.println(value);
//		
		// 실수 입력 받아오기
//		System.out.println("실수를 입력 바랍니다.");
//		double value2 = sc.nextDouble(); // -> 이 방법 쓰지 말것!
//		System.out.println(value2);
		
		// 아래의 방법으로 향후 과제 진행해주세요!
		
		// 정수 입력받기
		System.out.println("숫자를 입력 하세요.");
		String str1 = sc.nextLine();
		int value = Integer.parseInt(str1);
		System.out.println(value);

		// 단축표현
		System.out.println("숫자를 입력 하세요.2");
		int value2 = Integer.parseInt(sc.nextLine());
		System.out.println(value2);
		
		// 실수 입력받기
		System.out.println("실수를 입력 하세요.");
		String str2 = sc.nextLine();
		double value3 = Double.parseDouble(str2);
		System.out.println(value3);
		
		// 단축표현
		System.out.println("실수를 입력 하세요.2");
		double value4 = Double.parseDouble(sc.nextLine());
		System.out.println(value4);
	}
}






