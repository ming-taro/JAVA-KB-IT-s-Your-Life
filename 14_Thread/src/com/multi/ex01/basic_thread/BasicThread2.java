package com.multi.ex01.basic_thread;

import java.util.Timer;
import java.util.TimerTask;

public class BasicThread2 {
	public static int second = 0;
	public static void main(String[] args) {
		// 1초를 셀 수 있는 프로그램

		// Timer 기반 Thread 구현
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				second++;
				System.out.println(second + "초 입니다.");
			}
		}, 1000, 1000);
		System.out.println("Main Thread 끝!");
	}
}
