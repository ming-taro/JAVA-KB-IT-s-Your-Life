package ex03.observer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;


public class ObserverManager {
	// 싱글톤으로 만들어야한다.
	private ObserverManager() {}
	private static final ObserverManager instance = new ObserverManager();
	public static ObserverManager getInstance() {
		return instance;
	}

	// synchronized가 해결된 컬렉션으로 생성하지 않으면 동시성 문제로 인해 프로그램이 죽을수 있음.
	private final Queue<Observer> obQueue = new ConcurrentLinkedDeque<>();

	// 옵저저 구독 시키기
	public void subscribe(Observer ob) {
		obQueue.add(ob);
	}

	// 구독해지
	public void unSubscribe(Observer ob) {
		obQueue.remove(ob);
	}

	// 구독된 모든 객체에게 메세지를 보내는 방법
	public void notifyAll(String msg) {
		for(Observer ob : obQueue) {
			ob.update(msg);
		}
	}
}
