package com.multi.ex01.socket_basic;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class UDPSimpleClient {
	public static void main(String[] args) throws Exception {
		// 1. 접속할 서버의 ip주소와 port번호를 설정
		String ip = "localhost"; // 서버의 ip, 127.0.0.1 = loopback주소, 본인의 주소
		int serverPort = 7000; // 서버의 포트번호
		int clientPort = 7001; // 클라이언트의 포트번호

		// 2. socket 생성
		InetAddress inetAddr = InetAddress.getByName(ip);
		DatagramSocket socket = new DatagramSocket(clientPort);
		System.out.println("Clint 소켓 생성 성공되었습니다.");
		
		// 3. 서버와의 송수신 로직 구성
		Scanner sc = new  Scanner(System.in);
		System.out.println("전송할 메세지를 입력하세요.");
		String readText = sc.nextLine();
		System.out.println("send : " + readText);
		byte[] readBytes = readText.getBytes();
		// 전송할 메세지 + 서버의 주소 + 포트로 생성
		DatagramPacket packet = new DatagramPacket(readBytes,readBytes.length, inetAddr,serverPort);
		socket.send(packet); // 전송이 제대로 되었는지 확인 불가!
		System.out.println("Datagram Packet이 전송 되었습니다.");

		// 4. socket 자원 정리
		socket.close(); // 소켓 정리
		System.out.println("Client 소켓을 종료하였습니다.");
	}
}





