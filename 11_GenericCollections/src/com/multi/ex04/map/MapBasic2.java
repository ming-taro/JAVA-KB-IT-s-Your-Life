package com.multi.ex04.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapBasic2 {

	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("testID1", "김길동1", 21, 10000.123));
		list.add(new Member("testID1", "김길동1", 21, 10000.123)); // 완전동일
		list.add(new Member("testID3", "김길동3", 23, 444000.123));
		list.add(new Member("testID2", "홍길동3", 41, 3300.123)); // ID 만 다름
		list.add(new Member("testID2", "김길동2", 22, 10000.123));
		
		// 선언법
		Map<String, Member> map = new HashMap<>();
		
		// 1. 데이터 삽입하는 방법
		for(Member m : list) {
			// 기본적인 문법
//			map.put(m.getId(), m);
			
			// 덮어쓰기 하지 않는 방법1 ★★★★★
			// get : 데이터를 가져오는데, 없으면 null
//			if(map.get(m.getId()) == null) {
//				map.put(m.getId(), m);
//			}
			
			// 덮어쓰기 하지 않는 방법2 
			// containsKey : 키값이 있는지 확인하는 메소드
//			if(map.containsKey(m.getId()) == false) {
//				map.put(m.getId(), m);
//			}
			
			// 덮어쓰기 하지 않는 방법3
			// putIfAbsent : 키값이 존재하지 않을때만 put하는 메소드
			map.putIfAbsent(m.getId(), m);
		}

		map.forEach((k, v) -> System.out.println("k : " + k + ", v : " + v));
		System.out.println("-----------------------------------------------------");
		
		
		// 2. 순회하는 방법
		// 1) keySet - 표준적인 방법 ★★★★★
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(map.get(key));
		}
		System.out.println("------------------------------------------------");
		
		// 2) entrySet - key-value 둘다 쌍으로 가져오는 방법 
		Set<Entry<String, Member>> entrySet = map.entrySet();
		for(Entry<String, Member> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("------------------------------------------------");
		
		// 3) forEach문 활용
		map.forEach((k, v) -> System.out.println("k : " + k + ", v : " + v));
		System.out.println("------------------------------------------------");
		
		// 3. 데이터 가져오는 방법
		// get : key를 통해 value를 가져오는 가장 기본적인 방법
		System.out.println(map.get("testID1"));     // key가 있으면 value값 가져오고
		System.out.println(map.get("testID34828")); // key가 없으면 null 
		
		// getOrDefault : key값이 없는 경우, default값을 선언할수 있는 기능
		System.out.println(map.get("testID1").getId()); // value가 있어서 에러 안나는데..
//		System.out.println(map.get("testID34828").getId()); // 없는 경우는 null 에러 발생!
		System.out.println(map.getOrDefault(keySet, new Member()).getId()); // 없는 경우 빈멤버를 반환
		
		// getOrDefault가 없이 default값 초기화하는 문법 -> if문 필요
		Member m = map.get("testID34828");
		if(m == null) {
			m = new Member();
		}
		System.out.println(m.getId());
		// 아래 한줄로 변환됨
		System.out.println(map.getOrDefault(keySet, new Member()).getId()); // 없는 경우 빈멤버를 반환
		
		// 4. 삭제하는 방법
//		map.remove("testID1"); // 기본적인 삭제 방법
		Member m2 = map.remove("testID1"); // 삭제한 객체를 받아오는 방법
//		map.remove("testID1", new Member(...)); // 인자 2개인 remove는 value도 반드시 일치해야한다. equals도 존재해야함
		if(m2 == null) {
			System.out.println("삭제되지 않음");
		}else {
			System.out.println("삭제된 데이터 : " + m2);
		}
		
		// 5. 수정하는 방법
		// - 기본적으로 map은 덮어쓰기로 수정된다. -> put으로 활용
		// - replace 메소드가 있지만 실제 put과 같은 메커니즘
		map.put("testID2", new Member("testID2", "최길동", 22, 10000.123));
		System.out.println(map.get("testID2"));
		map.replace("testID2", new Member("testID2", "박길동", 22, 10000.123));
		System.out.println(map.get("testID2"));


		// value에 있는 객체에 일부 값만 변경하고 싶을 때
		// 가장 간편한 방법 -> 위험하다.
		map.get("testID2").setName("홍길동");
		
		// 아래 안전한 방법을 통해 진행하는것을 권장
		Member m3 = map.get("testID2");
		if(m3 != null) { // null check 필수!
			m3.setAge(40);
		}
		System.out.println(map.get("testID2"));

		// 6. map이 사이즈, 비었는지 확인하는 방법
		System.out.println(map.size());
		System.out.println(map.isEmpty());

		// 7. map 비우는 방법
		map.clear(); // 당장 초기화하는 방법
		System.out.println(map);
		map = null;  // 이것도 삭제하는 방법, java JVM - gc가 정리한다.
		System.out.println(map);
	}
}



















