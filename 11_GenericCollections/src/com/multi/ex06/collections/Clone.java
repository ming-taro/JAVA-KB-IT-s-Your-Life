package com.multi.ex06.collections;

public class Clone {
	
	// 객체 단위로 hard copy하는 방법
	public static void main(String[] args) {
		Member4 user1 = new Member4("testID1", "김길동1", 21, 10000.123);
		Member4 user2 = new Member4("testID2", "김길동2", 22, 10000.123);
		
		// 1. 전통적인 방법 ★★★ -> 치명적인 단점은 멤버변수가 많아지면 사용 불가능..
		Member4 user1copy = new Member4();
		user1copy.setId(user1.getId());
		user1copy.setName(user1.getName());
		user1copy.setAge(user1.getAge());
		user1copy.setAccount(user1.getAccount());
		
		// 메모리 주소 비교 = false
		System.out.println(user1 == user1copy);
		// equals 비교 = true, 재정의한 equals로 인하여 true
		System.out.println(user1.equals(user1copy)); // 성공!
		user1copy.setName("박길동");
		// 메모리 주소 비교 = false
		System.out.println(user1 == user1copy);
		// equals 비교, 값이 수정된 상태라 false
		System.out.println(user1.equals(user1copy));
		
		
		// 2. cloneable을 상속하여 사용하는 방법
		Member4 user2copy = null;
		try {
			user2copy = (Member4) user2.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("user2 user2copy 비교 : "+user2.equals(user2copy));


		// 3. cloneable + 내부적으로 예외처리 + Casting 하는 문법 ★★★★★★★★★★★★★★★
		Member4 user3copy = user2.clone();
		System.out.println("user2 user3copy 비교 : "+user2.equals(user3copy));
	}
}











