package ex03.observer;

public class ChatClient extends Observer {
	private StringBuffer chatMsg = new StringBuffer();
	
	@Override
	protected void update(String msg) {
		chatMsg.append(msg+"\n");
		print();
	}

	private void print() {
		System.out.println(chatMsg);
	}
	
	public void sendMsg(String msg) {
		ObserverManager.getInstance().notifyAll(msg);
	}

}
