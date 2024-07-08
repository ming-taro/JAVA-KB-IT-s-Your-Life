package com.multi.ex01.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class FileBasic {
	// 파일 경로(Path)란?
	//  - File이 저장되어 있는 보조기억장치(HDD, SSD)의 실제 물리적인 경로(위치)
	
	// 절대 경로 vs 상대 경로
	
	// 1. 절대 경로 - 익숙한 것
	// - Root(윈도우-'c:\', 리눅스-'\')로 부터 표기되는 절대적인 경로
	// C:\dev_source\work_space_java_lecture\Javalecture\13_IO\covid.txt
	// c:\test\data.txt
	// 빠르게 이스케이프 문자 적용하는 방법은 "" 안에 경로를 복사하는 것을 추천 ★★★★★
	
	// 2. 상대 경로
	// - 프로그램의 실행 위치(나)로부터 표기되는 상대적인 경로 '.'현재, '..'이전으로 표기되는 경로
	// - os console 명령어로부터 파생된 개념
	// - '.' : 현재 위치, '..' : 상위폴더(이전) 경로, './../../' 현재-상위-상위 경로
	// - ex) './covid.txt', 'covid.txt', './../13_IO/covid.txt'

	public static void main(String[] args) {
		// 상대 경로로 열기
		File file = new File("./");
		System.out.println(file.getAbsolutePath()); // 절대경로 위치 확인
//		File file1 = new File("./13_IO/covid.txt"); // 상대 경로로 열림(open)
		File file1 = new File("13_IO/covid.txt"); // 파일/폴더의 경로명
		
		// 절대 경로로 열기
//		File file2 = new File("C:\\dev_source\\work_space_java_multi1030\\13_IO\\covid.txt");
		File file2 = new File(file1.getAbsolutePath()); // 절대경로로 열기
		
		// 상대, 절대 경로 출력
		System.out.println(file1.getPath()); // 상대 경로
		System.out.println(file2.getPath()); // 절대 경로
		System.out.println(file1.getAbsolutePath()); // 상대여도 절대경로 보이는 방법
		System.out.println("------------------------------------------------");
		
		// 부모(상위 폴더)
		System.out.println(file1.getParent()); // 상대경로로 읽어서 부모를 찾을수 없다.
		System.out.println(file2.getParent());
		System.out.println("------------------------------------------------");
		
		// 권한 물어보기
		System.out.println(file1.canRead()); 	// 읽기 true
		System.out.println(file1.canWrite()); 	// 쓰기 true
		System.out.println(file1.canExecute()); // 실행 true
		System.out.println("------------------------------------------------");
		
		// 권한 설정 (윈도우는 쓰기 권한만 가능)
		file1.setWritable(false); // 읽기전용 만들기
		System.out.println(file1.canWrite()); 	// 쓰기 못함
		file1.setWritable(true);
		System.out.println(file1.canWrite()); 	// 쓰기 가능!
		System.out.println("------------------------------------------------");
		
		// 파일 이름 변경
//		File file = new File("./covid2.txt");
//		boolean result = file1.renameTo(file);
//		System.out.println(result);
		// 이클립스에서 파일구조가 변경되는 경우 반드시 새로고침을 해야 반영된다. F5
		
		// 수정된 시간 출력 -> 사용 이력
		System.out.println(file1.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(file1.lastModified())); // 마지막 수정 시간
		
		// 파일 길이
		System.out.println(file1.length() + "byte");
		System.out.println(file1.length() / 1024 + "kbyte");
		System.out.println(file1.length() / 1024.0 / 1024.0 + "Mbyte");
		// byte, k, M, G, T, P -> 높아짐
		
		// 파일 삭제
//		file1.delete();
		
		// 디렉토리(폴더) 다뤄보기
		File folder = new File("./");
		if(folder.isDirectory()) {
			System.out.println("디렉토리 입니다.");
		}
		
		// 디렉토리가 가진 자식(파일 + 폴더) 가져오기
		System.out.println(Arrays.toString(folder.listFiles()));
		System.out.println(folder.listFiles());
	}
}
















