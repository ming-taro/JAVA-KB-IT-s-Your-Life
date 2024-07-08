package ex01.singletone;

/**
 * 초반부터 생성되는 문제점을 해결하고, 사용할때만 객체를 생성하도록 변경한 단순버전에서
 * synchronized를 키워드 통해 메소드 레벨에 원자(Atomic) 영역을 생성함.
 * -> 동기화 문법으로 임계영역(경쟁 영역)에 대한 보호가 확실해져서 한개 이상의 객체를 생성할수 없다.
 *
 * 문제점 : 쓰레드 개념에서 사용하기 매우 느리다.
 *
 */
public class SingleToneV3 {
	private static SingleToneV3 instance;
	private SingleToneV3() {
		System.out.print("SingleToneV3 생성!!!!!");
		makeCount++;
	}
	public static int makeCount = 0;

	// synchronized 명령어로 해당 메소드는 단 하나의 쓰레드만 들어갈수 있다.
	public static synchronized SingleToneV3 getInstance() {
		if(instance == null) {
			instance = new SingleToneV3();
		}
		return instance;
	}
}

