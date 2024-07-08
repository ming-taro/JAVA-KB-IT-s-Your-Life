package com.multi.ex04.srting_series;

public class StringSeriesThreadTest {
	static StringBuffer sb = new StringBuffer();   // Thread safe     
//	static StringBuilder sb = new StringBuilder(); // Non Thread safe 
	
	public static void main(String[] args) {
		Thread thread = null;
		for (int i = 0; i < 100; i++) {
			thread = new Thread(new Runnable() {
				public void run() {
					System.out.println("생성");
					for (int i = 0; i < 100; i++) {
						try {
							sb.append(i % 10);
							Thread.sleep(5);
						} catch (Exception e) {
						}
					}
					System.out.println("종료");
				}
			});
			thread.start();
		}

		try {
			while (thread.isAlive() == true)
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("갯수 : " + sb.toString().length());
		System.out.println(sb.toString());
	}
}
