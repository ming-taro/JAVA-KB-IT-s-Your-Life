package com.multi.ex06.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsBasic {

	// Collections : 컬렉션을 활용할때 도움 줄수 있는 메소드를 모아 놓은 class
	public static void main(String[] args) {
		// 1. List.of, Set.of, Map.of : 배열이나 빈값을 컬렉션으로 만들때 활용
		String[] strArray = {"abc", "bbb", "ccc", "bcc", "cca"}; 
		List<String> strlist = new ArrayList<>(List.of(strArray));

		int[] intArray = {1,2,30,100,40,30};
//		List<Integer> intList = new ArrayList<>(Arrays.asList(intArray)); // 에러 발생!
		List<Integer> intList = new ArrayList<>(List.of(1,2,30,100,40,30));

		// 2. 각종 기본 컬렉션들 생성하기 -> 비추...
		List<String> list1 = Collections.emptyList();
		List<String> list2 = Collections.synchronizedList(list1); // 동기화 처리된 list 만들기

		// 3. sort
		Collections.sort(strlist, Collections.reverseOrder());
		Collections.sort(intList);
		System.out.println(strlist);
		System.out.println(intList);

		// 4. max, min
		System.out.println(Collections.max(strlist));
		System.out.println(Collections.min(strlist));
		System.out.println(Collections.max(intList));
		System.out.println(Collections.min(intList));

		// 5. fill : 특정값으로 채우는 기능
//		Collections.fill(intList, 10);
//		System.out.println(intList);
		
		// 6. shuffle : 랜덤하게 섞을때 사용
		Collections.shuffle(intList);
		System.out.println(intList);
		
		// 7. reverse : list를 역순으로 만들어주기
		Collections.sort(intList); // 정렬
		Collections.reverse(intList); // 역순으로 만들기
		System.out.println(intList);
	}
}











