package com.multi.ex02.thread_app;

import java.util.ArrayList;

public class ThreadSum {
	// 병렬 프로그래밍 알고리즘
	// -> 그래픽카드 연산하거나 산술연산중에 독립적인 연산을 병렬적으로 처리할때 사용
	public static void main(String[] args) {
		int threadNum = 256; // Thread의 수!
		// 0 ~ 1억 까지 더하는 프로그램
		// double -> 부동소수점 -> int 50배 느리다!
		// 1 : 4541.0 880 2504.0 992.0 1101.0
		// 2 : 2484.0 461 1305.0 539.0 1248.0
		// 4 : 1424.0 248 689    327.0 670
		// 8 : 1003.0 174 255    560   433
		// 16 : 905.0 175 254    359   355
		// 32 : 840
		// 64 : 540
		// 128 : 945 666 823
		// 256 : 1129

		// 결론 : 적절한 Thread의 갯수를 유지하는 것이 중요하다.
		//       -> Thread가 많아지면 오히려 Thread 간의 Swap 시간으로 인해 성능 저하 발생
		//       적절? -> System이나 돌아가는 프로그램마다 달라짐으로 이걸 찾아내는게 엔지니어 일이다..

		double startValue = 0;
		double endValue   = 1_000_000_000; // threadNum 배수만큼만!
		double sumValue   = 0;
		long start = System.currentTimeMillis();

		if(endValue % threadNum != 0) {
			System.out.println("다시 입력해주세요.");
			return;
		}

		ArrayList<DoubleSumThread> threadList = new ArrayList<>(threadNum);

		// start!!
		for(int i=0; i<threadNum; i++) {
			double threadStart = (endValue / threadNum) * (i)+1;
			double threadEnd = (endValue / threadNum) * (i+1)+1;
            DoubleSumThread thread = new DoubleSumThread(threadStart, threadEnd);
			threadList.add(thread);
			thread.start();
		}

		// calc!!
		for(int i=0; i<threadList.size(); i++) {
			try {
				threadList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

        for(int i=0; i<threadList.size(); i++) {
            sumValue += threadList.get(i).getSumValue();
        }

		// finish!!
		long end = System.currentTimeMillis();


		double estimated = end - start;

		System.out.println("sumValue : "+ sumValue);
		System.out.println("time estimated : " + estimated);
	}
}
