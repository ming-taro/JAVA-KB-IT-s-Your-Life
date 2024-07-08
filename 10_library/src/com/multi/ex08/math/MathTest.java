package com.multi.ex08.math;

import java.util.Random;

// Math Class : 산술 연산을 위한 기능을 제공하는 클래스
public class MathTest {
	public static void main(String[] args) {
		// 상수 표현
		System.out.println(Math.PI);
		System.out.println(Math.E);

		// 절대값 
		System.out.println(Math.abs(10));
		System.out.println(Math.abs(-10));
		System.out.println(Math.abs(-3.14));
		
		// 제곱, 제곱근
		System.out.println((int)Math.pow(5, 2)); // 5 ^ 2, 5의 2승 = 25
		System.out.println((int)Math.sqrt(25));  //square root, 5
		
		// sin, cos, tan
		System.out.println(Math.sin(Math.toRadians(30)));
		System.out.println(Math.sin(Math.PI / 6));
		System.out.println(Math.tan(Math.toRadians(45)));
		System.out.println(Math.tan(Math.PI / 4));
		System.out.println(Math.cos(Math.toRadians(60)));
		System.out.println(Math.cos(Math.PI / 3));
	
		// ceil = 소수점 올림
		System.out.println(Math.ceil(10.0));      // 10.0
		System.out.println(Math.ceil(10.1));      // 11.0
		System.out.println(Math.ceil(10.000001)); // 11.0

		// floor = 소수점 버림
		System.out.println(Math.floor(10.0));     // 10.0
		System.out.println(Math.floor(10.9));     // 10.0
		 
		// round = 소수점 반올림
		System.out.println(Math.round(10.0));     // 10
		System.out.println(Math.round(10.4));     // 10
		System.out.println(Math.round(10.5));     // 11
		
		// 숫자 비교
		// => 큰, 작은값을 가져올때
		System.out.println(Math.max(3.14, 3.14159));
		System.out.println(Math.max(10, 5));
		System.out.println(Math.min(3.14, 3.14159));
		System.out.println(Math.min(10, 5));
		
		// 랜덤 변수 가지고 올때
		System.out.println(Math.random()); // 소수점으로 랜덤값을 리턴
		System.out.println((int)(Math.random() * 100));
		System.out.println(new Random().nextInt(100));
	}
	
}













