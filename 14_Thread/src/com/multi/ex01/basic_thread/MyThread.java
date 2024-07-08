package com.multi.ex01.basic_thread;

// 1초씩 셀수 있는 프로그램
public class MyThread extends Thread {
	private int count = 0;
	private static StringBuilder log = new StringBuilder(); // thread non-safe
	
	public MyThread(String name) {
		super(name);
	}
	
	public StringBuilder getLog() {
		return log;
	}

	// synchronized란? 
	// - 사용하는 메소드나 변수를 병행 처리 중 Thread safe하게 만드는 키워드
	// synchronized 사용법  
	// 1. 메소드 앞에 붙여주는 방법 : run이 아닌 다른 메소드로 만들어서 붙여줘야한다.
	// 2. 사용할 변수 이전에 synchronized 영역을 생성하여 감싼다.
	private synchronized void printLog(String msg) {
		// 메소드 사용법
		synchronized(log) {
			log.append(msg);
		}
	}
	
	// thread를 실제 동작시킬수 있는 메소드 :run -> 오버라이딩 필요!
	@Override
	public void run() {
		while(true) {
			System.out.println(count + "초 입니다. " + getName());
			printLog(count + "초 입니다. " + getName() +"\n");
			count++;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			if(count > 5) {
				synchronized(log) {
					System.out.println("-----------------"+getName()+"------------------");
					System.out.println(log);
					System.out.println("------------------------------------");
				}
				break;
			}
		}
	}
}
