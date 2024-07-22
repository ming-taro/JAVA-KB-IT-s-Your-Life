package com.multi.ex01.basic_thread;

public class BasicThread {
	public static int second = 0;
	public static void main(String[] args) {
		// 1초를 셀 수 있는 프로그램

		// Main Thread 구간 : main이 실행되는 Thread, 프로그램의 분기가 시작되는 곳
		while(true) {
			try {
				second++;
				System.out.println(second + "초 입니다.");
				Thread.sleep(1000); // millis, 1000ms = 1초, 1/1000초
				// Sleep을 주면 Thread가 지정한 시간까지 잠시 멈춤
				// -> 실제 현업에서 네트워크 or 파일 입출력을 수행시 잠시 멈추지 않으면 데이터전송/읽기쓰기 되지 않을때가 있다.
				//  (이유 : 다른 thread가 일할 시간을 안주거나 상대방의 응답시간을 고려하지 않은 경우)
				//    이럴때 sleep을 주면 해결되는 경우가 있다.
				//   nano second 옵션도 존재! -> 아주 적게줄때 가능
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
