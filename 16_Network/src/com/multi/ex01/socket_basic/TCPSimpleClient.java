package com.multi.ex01.socket_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

// 에러 정리 
// Connection refused: connect, 거절 된 경우, ip, port가 잘못된 경우

public class TCPSimpleClient {
	public static void main(String[] args) throws Exception {
		// 1. 접속할 서버의 ip주소와 port번호를 설정
		String ip = "127.0.0.1"; // 서버의 ip, 127.0.0.1 = loopback주소, 본인의 주소
		int port = 9000; // 서버가 미리 정하고 약속된 번호!!
		
		// 2. socket 생성
		Socket socket = new Socket(ip, port);
		System.out.println("Clint 소켓 생성 성공되었습니다.");
		
		// 3. 서버와의 송수신 로직 구성
		boolean result = connectServer(socket);
		System.out.println("통신 결과 : " + (result ? "성공" : "실패"));
		
		// 4. socket 자원 정리
		socket.close();
		System.out.println("Client 소켓을 종료하였습니다.");
	}

	private static boolean connectServer(Socket socket) {
		System.out.println("서버와 연결 성공!");
		System.out.println("\t서버 IP : " + socket.getInetAddress().getHostAddress());
		System.out.println("\t서버 port : " + socket.getPort());
		System.out.println("\tlocal port : " + socket.getLocalPort());
		
		// echo 기능 구현
		try (   InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);
				Scanner sc = new  Scanner(System.in);
				) {
			System.out.println("전송할 메세지를 입력하세요.");
			String readText = sc.nextLine();
			System.out.println("read : " + readText);
			bw.append(readText);
			bw.newLine();
			bw.flush();
			String recvMessage = br.readLine();
			System.out.println("서버 메세지 : " + recvMessage);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}





