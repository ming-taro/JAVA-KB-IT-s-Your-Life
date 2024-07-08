package com.multi.ex04.srting_series;

public class StringSeriesBasic {
	// String 시리즈간 장단점 비교.
	
	// 1. String : 가장 기본적인 문자열 Class, 가장 많은 Library 보유, immutable(불변성) -> 한번 정해지면 바뀌지 않음
	//     - 장점 : 많은 Library 제공하고 전용 연산자도 제공, 활용하기 좋음
	//     - 단점 : 불변성의 원칙으로 인해 메모리 관리가 필요하고, 문자열 합칠때 연산속도가 엄청 느리다.
	//             -> 메모리 많이 먹고, 느리다.
	
	// 2. StringBuffer : 문자열에 더하기 연산과 텍스트 교체, 삭제를 위해 개발된 Library
	//    - 특징 : 가변성 배열 통해 문자열을 삽입, 삭제가 자율적임, Thread safe함
	//	  - 장점 : 빠르고, 메모리 낭비가 없다. 
	//    - 단점 : Library 지원이 적다. -> String 사용해야함 , Thread safe하여 StringBulider보다 아주조금 느림
	
	// 3. StringBuilder : StringBuffer와 기능 동일,  Thread safe하지 않음 -> 좀 더 빠르다.
	
	// String의 덧샘 연산의 예시 -> 연산도 많아지고, 메모리 낭비도 심하다.
	// String str = "a" + "b" + "c" + "d";  // 메모리 크기 : 4, 문자열하나를 1개로 취급 
	// Step 1) "a" + "b" -> "ab"			// 메모리 크기 : 4 + 2 = 6
	// Step 2) "ab" + "c" -> "abc"   		// 메모리 크기 : 6 + 3 = 9
	// Step 3) "abc" + "d" -> "abcd"   		// 메모리 크기 : 9 + 4 = 13
	
	// StringBuffer의 덧샘 연산의 예시 -> 빠르고, 메모리 낭비가 없다.
	// append("a"), append("b"), append("c"), append("d") // 4
	// 1) [a .... ] -> ['a','b' ....]					// 메모리 크기 : 2
	// 2) ['a','b' ....] -> ['a', 'b', 'c' ....]        // 메모리 크기 : 3
	// 2) ['a', 'b', 'c' ....] -> ['a', 'b', 'c', 'd' ] // 메모리 크기 : 4
	public static void main(String[] args) {
		// 0. 선언 및 출력하기
		StringBuffer sb = new StringBuffer("안녕하세요?"); // Buffer = 양동이/공간, 버퍼링, 예비공간
//		StringBuilder sb = new StringBuilder("안녕하세요?"); // StringBuffer와 문법이 완벽히 호환됨.
		System.out.println(sb); // toString이 생략
		System.out.println(sb.toString()); 
		
		// 1. append : 문자열 추가하는 기능 ★★★★★
//		String str = str.concat("~~"); // 문자열 메커니즘 -> 변수로 받아야했었다.
		// StringBuffer 메소드 메커니즘은 자기 자신에 덧샘과 연산이 더해진다.
		sb.append(" 저는 홍길동입니다.");
		sb.append(" 만나서 반갑습니다. 홍길동");
		System.out.println(sb);
		
		// 2. 중간 삽입 (위치 지정이 필요)
		// offset : 거리, 떨어진 거리, 여기서의 거리는 문자열의 index를 의미함
		sb.insert(0, "하이!! ");
		System.out.println(sb);
		sb.insert(5, "@@@@");
		System.out.println(sb);
		
		// 3. indexOf : 문자열을 탐색하여 index로 반환하는 기능
		int index = sb.indexOf("홍길동");
		System.out.println(index); // 0, 양수 = 문자열에 있을때 
		index = sb.indexOf("김길동");
		System.out.println(index); // 음수 = 문자열이 없을때
		index = sb.indexOf("홍길동", sb.indexOf("홍길동") + 1);
		System.out.println(index);
		
		// 4. delete : 지정한 문자의 index의 시작, 끝점을 삭제하는 기능
		// 첫번째 홍길동 삭제
		int index2 =  sb.indexOf("홍길동");
		sb.delete(index2, index2 + 3); // 시작점, 끝점
//		sb.delete(index2, index2 + "홍길동".length());
		System.out.println(sb);
		
		// 4-1. 삭제한 곳에 다른 이름 추가하기, 참고로 replace 제공하지 않아서 이런식으로 진해야함
		sb.insert(index2, "김길동");
		System.out.println(sb);
		
		// 5. replace : 교체하는데, 시작, 끝점 바꿀 문자열 필요
		sb.replace(index2, index2 + 3, "최길동");
		System.out.println(sb);
		
		// 6. 비교연산=compareTo, ※ 주의 : 가능하면 문자열로 비교할 것.
		StringBuffer sb2 = new StringBuffer("abc"); 
		System.out.println(sb2.equals("abc"));// 안되는 문법
		System.out.println(sb2.equals(new StringBuffer("abc"))); // 안되는 문법
		System.out.println(sb2.compareTo(new StringBuffer("abc"))); // 된다! -> 결과 0
		// compareTo : 0이면 같고, -1 앞이 크고, +1 뒤가 작다.
		// 추천 문법
		System.out.println(sb2.toString().equals("abc"));
		
		// 7. reverse : 문자열 반전시키기! ★★★★★
		StringBuffer sb3 = new StringBuffer("가나다라마바사"); 
		System.out.println(sb3.reverse());
		
		// 8. setCharAt : 한글자만 바꿔주는 기능
		sb3.setCharAt(0, 'a');
		System.out.println(sb3);
		
		// 9. sebSequence : 문자열 자르기
		String str = (String) sb.subSequence(10, 20);
		// CharSequence -> 문자열 type의 원형
		System.out.println(str);
	}
}























