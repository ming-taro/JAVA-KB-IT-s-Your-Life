package ex01.singletone;

public class Run {
	public static void main(String[] args) {
//		SingleToneV1 singleObj = new SingleToneV1(); // �����ڰ� private�� ���� �Ұ�!
		SingleToneV1 singleObj = SingleToneV1.getInstance();
		System.out.println(singleObj.getString());
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					SingleToneV2.getInstance();
					SingleToneV2.getInstance();
					SingleToneV2.getInstance();
					SingleToneV2.getInstance();
					SingleToneV2.getInstance();
				}
			}).start();
		}
		System.out.println();
		System.out.println("SingleToneV2 생성 갯수 : " + SingleToneV2.makeCount);

		//
		System.out.println("");
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					SingleToneV3.getInstance();
					SingleToneV3.getInstance();
					SingleToneV3.getInstance();
				}
			}).start();
		}
		System.out.println();
		System.out.println("SingleToneV3 생성 갯수 : " + SingleToneV3.makeCount);
	}
}
