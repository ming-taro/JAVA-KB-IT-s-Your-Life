package com.multi.ex01.socket_basic;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

// 에러 정리
// Address already in use: bind : ip + 9000 번호가 중복된 경우

public class UDPSimpleServer {
	public static void main(String[] args) throws Exception {
		// 1. port 설정 : 실제 서버에서 사용할 port 번호 선정, 일반적으로 1023 이후로 숫자를 셋팅하는것이 원칙
		int serverPort = 7000; // 서버의 포트번호

		// 2. ServerSocket 객체 생성하기
		//  - OS로부터 네트워크 포트 자원을 요청함 -> Bind 과정
		//  - 성공하면 객체 반환, 실패하면 예외 발생
		DatagramSocket socket = new DatagramSocket(serverPort); // port 번호 : 대표 포트번호가 선정
		System.out.println("Server 소켓 생성을 성공하였습니다. port : " + serverPort);

		// 3. 데이터를 받을 buffer 생성
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);

		// 4. receive : blocking 함수로 클라이언트 요청을 받을때 까지 대기됨
		socket.receive(dp);

		// 5. 메세지를 받은 상태
		String message = new String(dp.getData(), 0, dp.getLength());
		System.out.println("수신된 메세지 : " + message);

		// 6. 서비스 완료 이후 socket 자원 정리 코드
		socket.close();
		System.out.println("서버가 종료 되었습니다.");
	}
}














