package com.multi.ex01.basic_thread;

public class BasicThread3 {
	// Thread 생성법 3가지
	// 1. Thread를 상속 받아서 사용하기 -> 설계가 커지고 복잡할때 사용
	// 2. Thread Runnable Interface를 구현하여 사용하기
	//  2.1 - Class에서 직접 구현하기
	//  2.2 - 익명 Class를 사용하는 방법★ 짧은 쓰레드를 만들때 사용한다.

	// Thread의 생명주기 실험
	// - Main Thread가 죽어도 다른(자식) Thread가 살아 있는 경우 프로그램은 종료되지 않는다.
	// - 만일 Main Thread를 죽이지 않고 다른 Thread의 처리를 기다릴 경우 join을 활용

	// ※ 주의 run 호출하는 것은 그냥 메소드 호출이다. Sub Thread 생성하기 위해선 반드시 start를 사용!
	public static void main(String[] args) throws InterruptedException {
		// 1. Thread를 상속해서 사용하는 방법
		MyThread thread1 = new MyThread("thread1");
//		thread1.run(); // 잘못된 호출!!
		thread1.start();
		
		// thread safe test 코드
//		for(int i = 0 ; i < 5; i++) {
//			MyThread thread = new MyThread("thread"+i);
//			thread.start();
//		}
		
		// 2.1 Thread Runnable interface 생성하는 방법
		Thread thread2 = new Thread(new RunnableClass("thread2"));
		thread2.start();
		
		// 2.2 Thread Runnable interface - 익명 Class 기법
		// -> 간단한 쓰레드 생성시 이방법이 유용
		String userName = "thread3";
		Thread thread3 = new Thread(new Runnable() {
			// 익명쓰레드 시작부!
			// 멤버자리
			int count = 0;
//			String name = "thread3";
			
			public void run() {
				while(true) {
					System.out.println(count + "초 입니다. " + userName);
					count++;
					try {
						Thread.sleep(900);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread3.start();
		
		// 2.3 Thread Runnable interface - 람다식
		// -> 한두줄 정도의 간단한 쓰레드를 설계할때 사용한다.
		Thread thread4 = new Thread(()->System.out.println("1초 입니다. thread4"));
		thread4.start();

		// join : 생성 된 thread가 종료되기 전까지 main thread를 멈추는 방법
//		thread1.join();
//		thread2.join();
//		thread3.join();
//		thread4.join();
		System.out.println("Main Thread 끝!");
	}
}
















