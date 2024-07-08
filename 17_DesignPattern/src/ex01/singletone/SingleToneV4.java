package ex01.singletone;

/**
 * 2중 Locking 기법을 통해 임계 영역에 대한 원자성도 해결하고 속도도 해결함.
 *
 */
public class SingleToneV4 {
	private static SingleToneV4 instance;
	private SingleToneV4() {
		value++;
	}
	public static int value = 0;

	public static SingleToneV4 getInstance() {
		if(instance == null) {
			synchronized(SingleToneV4.class) { // 2중 lock 기법
				if(instance == null) {
					instance = new SingleToneV4();
				}
			}
		}
		return instance;
	}
}