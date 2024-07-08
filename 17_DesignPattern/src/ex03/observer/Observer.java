package ex03.observer;

import java.io.Closeable;

public abstract class Observer implements Closeable{ 
	
	public Observer() {
		ObserverManager obManage = ObserverManager.getInstance();
		obManage.subscribe(this);
	}

	protected abstract void update(String msg);
	
	public void close() {
		ObserverManager obManage = ObserverManager.getInstance();
		obManage.unSubscribe(this);
	}
	
}
