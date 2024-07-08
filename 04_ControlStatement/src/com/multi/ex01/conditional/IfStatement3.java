package com.multi.ex01.conditional;

import java.util.Scanner;

public class IfStatement3 {

	public static void main(String[] args) {
		// 로그인 기능
		// ID를 입력 받고 3글자 미만이면 "ID가 짧습니다." -> 실패
		// PW를 입력 받고 8글자 미만이면 실패, PW에 ID가 포함 되어 있으면 실패.
		
		Scanner sc = new Scanner(System.in);
		
		// 아래와 같은 코드는 스파게티 코드에 가깝다.
		// if문이 아주 복잡해지는 경우에는 재설계(리팩토링)가 필요하다.
		// 현업에서 아래와 같은 코드를 만날수 있는데, 아래와 같이 짜는 이유는 뗌빵처리를 하다보면 저렇게 된다.
		// -> 이런 코드를 개선해야한가? 강사 생각 : 돌아가는 코드 건들지 않는다.
		
		// 강사의 표현 : if문 안으로 말려들어가는 코드 -> 안좋은 코드!!!!
		System.out.println("id를 입력해주세요.");
		String id = sc.nextLine();
		
		if(id.length() > 3) {
			System.out.println("pw를 입력해주세요.");
			String pw = sc.nextLine();
			if(pw.length() < 8) {
				System.out.println("pw가 짧습니다.");
			} else {
				if(pw.contains(id)) {
					System.out.println("pw에 아이디가 포함되어 있습니다.");
				}else {
					System.out.println("로그인에 성공하였습니다.");
				}
			}
		} else { // id 3글자 미만인 경우
			System.out.println("id가 짧습니다.");
		}
	}
}
