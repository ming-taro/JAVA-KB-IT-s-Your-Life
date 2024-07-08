package com.multi.ex04.srting_series;

public class StringSeriesSpeedTest {
	public static void main(String[] args) {
		System.out.println("시작");
		
		long current = System.currentTimeMillis();
		
//		String temp = "";
//		for(int i = 0; i < 100000; i++) {
//			temp += i;
//		}
		
//		StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100000; i++) {
			sb.append(i);
		}
		
		long finish = System.currentTimeMillis();
		System.out.println("종료");
		System.out.println(finish - current);

		// String 덧샘연산 가장 느리다. -> 느린정도가 아닌 실제로 서버에서는 응답 타임이 엄청 늦어지는 속도
		// String : 8015, 5027, 7207, 5118
		// StringBuffer : 13, 7, 7, 5
		// StringBuilder : 10, 6, 7, 3

	}
}
