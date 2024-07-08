package com.multi.ex05.serial_object_io;

import java.io.*;
import java.util.Arrays;

public class ObjectIO {
	// 객체 단위로 IO 하는 법
	
	public static boolean saveObject(File file, Object obj) {
		try ( FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				) {
			oos.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static Object loadObject(File file) {
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				) {
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void main2(String[] args) {
		Member member = new Member("test", "홍길동", 23, "010-3131-3333");
		File file = new File("/13_IO/objInfo");
		
		boolean result = ObjectIO.saveObject(file, member); // 직렬화
		System.out.println("result : " + result);
		// 저장 완료
		
		// 읽어 오기
		Member member2 = (Member) ObjectIO.loadObject(file); // 역직렬화
		System.out.println("member1 : " + member.toString());
		System.out.println("member2 : " + member2.toString());
		System.out.println(member.equals(member2)); // 그냥하면 같지 않다고 나옴!
		// equals 오버라이딩 (재정의) 필요하다.  -> 반드시 이클립스 자동완선 기능으로 해야함!
		// java.io.NotSerializableException : 직렬화 되지 않은 객체를 저장할때 발생하는 오류!
	}
	
	// 객체 배열 단위로 r/w 하기
	public static void main(String[] args) {
		Member member1 = new Member("test1", "홍길동3", 23, "010-3131-3333");
		Member member2 = new Member("test2", "홍길동2", 33, "010-3131-3333");
		Member member3 = new Member("test3", "홍길동3", 43, "010-3131-3333");
		Member member4 = new Member("test4", "홍길동4", 53, "010-3131-3333");

		Member[] memberArray = new Member[4];
		memberArray[0] = member1; 
		memberArray[1] = member2; 
		memberArray[2] = member3; 
		memberArray[3] = member4; 

		File file = new File("./objInfo");
		boolean result = ObjectIO.saveObject(file, memberArray); // 직렬화
		System.out.println("result : " + result);
		// 저장 완료

		// 읽어 오기
		Member[] memberArray2 =(Member[]) ObjectIO.loadObject(file); // 역직렬화

		System.out.println("user1 : " + Arrays.toString(memberArray));
		System.out.println("user2 : " + Arrays.toString(memberArray2));
	}
}

