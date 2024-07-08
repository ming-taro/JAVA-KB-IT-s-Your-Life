package ex03.observer;

public class Run {
	public static void main(String[] args) {
		ChatClient client1 = new ChatClient();
		ChatClient client2 = new ChatClient();
		ChatClient client3 = new ChatClient();
		ChatClient client4 = new ChatClient();
		ChatClient client5 = new ChatClient();

		client1.sendMsg("안녕하세요?");
		client2.sendMsg("네 안녕하세요?");
		client3.sendMsg("저는 홍길동이라는데, 여기 어디?");
		client4.sendMsg("님 누구?");
		client5.sendMsg("ㅈㅅ...");

		client1.close();
		client2.close();
		client3.close();
		client4.close();
		client5.close();
	}
}
