package com.multi.ex01.conditional;

import java.util.Scanner;

public class IfStatement4 {
	// 강사의 if문 구성 스타일
	// 1. 예외를 먼저 if + return문으로 필터링한다. (예외를 날린다.)
	// 2. 정상 케이스를 가장 아래쪽으로 배치하고, 들여쓰기 0 level로 구성 하도록 한다.
	// -> 해당 스타일의 장점 : 코드의 복잡도가 줄어든다. (간결해진다.)
	
	public static void main(String[] args) {
		// 로그인 기능
		// ID를 입력 받고 3글자 미만이면 "ID가 짧습니다." -> 실패
		// PW를 입력 받고 8글자 미만이면 실패, PW에 ID가 포함 되어 있으면 실패.

		Scanner sc = new Scanner(System.in);
		System.out.println("id를 입력해주세요.");
		String id = sc.nextLine();
		
		// 예외 필터링 할 자리
		if(id.length() < 3) {
			System.out.println("id가 짧습니다.");
			return; // main(메소드)를 종료하는 키워드
		}
		
		System.out.println("pw를 입력해주세요.");
		String pw = sc.nextLine();
		
		if(pw.length() < 8 || pw.contains(id)) {
			System.out.println("pw가 짧거나 pw에 id가 포함되었습니다.");
			return;
		}
		
		// 정상 케이스 들어갈 자리
		System.out.println("로그인이 성공하였습니다.");
	}

}





