package com.multi.ex01.socket_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 에러 정리
// Address already in use: bind : ip + 9000 번호가 중복된 경우

public class TCPSimpleServer {
	public static void main(String[] args) throws Exception {
		// 1. port 설정 : 실제 서버에서 사용할 port 번호 선정, 일반적으로 1023 이후로 숫자를 셋팅하는것이 원칙
		int port = 9000; // 컴퓨터 프로그램(프로세스) 내부적인 주소
		
		// 2. ServerSocket 객체 생성하기
		//  - OS로부터 네트워크 포트 자원을 요청함 -> Bind 과정
		//  - 성공하면 객체 반환, 실패하면 예외 발생
		ServerSocket serverSocket = new ServerSocket(port); // port번호 : 대표 포트번호가 선정
		System.out.println("Server 소켓 생성을 성공하였습니다. port : " + port);
		
		// 3. Accept 명령을 통해 Client의 요청이 들어올때까지 대기함
		// - accept() : blocking 함수로 클라이언트 요청이 올때까지 대기가 되고, time out 존재함
		Socket socket = serverSocket.accept(); // 생성되는 socket은 기존 9000이 아닌 다른 포트번호로 생성됨!
		
		// 4. Client의 요청 수락 성공 상태!
		System.out.println("연결 성공!");
		System.out.println(" Client ip : " + socket.getInetAddress().getHostAddress());
		System.out.println(" Client port : " + socket.getPort()); // ? 
		
		// 5. Client에게 서비스를 제공하는 코드 작성(데이터 송수신 코드)
		boolean result = connectClient(socket);
		System.out.println("통신 결과 : " + (result ? "성공" : "실패"));
		
		// 6. 서비스 완료 이후 socket 자원 정리 코드
		// 순서 : socket -> serverSocket으로 정리 필요!
		socket.close();
		
		// 7. 서버가 닫혀야 하는경우는 serverSocket 자원 정리도 필요
		serverSocket.close();
		System.out.println("서버가 종료 되었습니다.");
	}

	// client와 데이터 송수신하는 코드
	// 문자열 echo 서비스 기능 작성 
	private static boolean connectClient(Socket socket) {
		try (	InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);
				) {
			String readStr = br.readLine(); // blocking 함수 -> 클라이언트의 입력(newline)이 있을때 까지 대기
			System.out.println("수신된 메세지 : " + readStr);
			bw.append(readStr); // echo부
			bw.newLine();
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}














