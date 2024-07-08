package com.multi.ex01.basic_thread;

// 1초 세는 프로그램
public class RunnableClass implements Runnable  {
	private int count = 0;
	private String name;
	
	public RunnableClass(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		while(true) {
			System.out.println(count + "초 입니다. " + name);
			count++;
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
