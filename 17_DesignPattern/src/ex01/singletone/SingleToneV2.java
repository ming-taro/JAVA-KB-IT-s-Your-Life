package ex01.singletone;
/**
 * 초반부터 생성되는 문제점을 해결하고, 사용할때만 객체를 생성하도록 변경한 단순버전
 * 문제점 : 객체가 여러개 생성될수 있다.
 */

public class SingleToneV2 {
	private static SingleToneV2 instance;
	private SingleToneV2() {
		makeCount++;
		System.out.print("SingleToneV2 생성!!");
	}
	public static int makeCount = 0;

	// 명령어에서 가장 작은 단위인 어셈블리어(기계어) 차원에서 보면 아래 코드에 구멍이 많다.
	public static SingleToneV2 getInstance() {
		if(instance == null) {
			instance = new SingleToneV2();
		}
		return instance;
	}
}
