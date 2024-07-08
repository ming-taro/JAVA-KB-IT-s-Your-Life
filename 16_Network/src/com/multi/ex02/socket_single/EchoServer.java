package com.multi.ex02.socket_single;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws Exception {
		int port = 9000; 
		
		ServerSocket serverSocket = new ServerSocket(port); 
		System.out.println("Server 소켓을 생성하였습니다. port : " + port);
		
		while(true) {
			System.out.println("Client 연결 대기");
			Socket socket = serverSocket.accept(); //  새로운 port 번호로 통신
			
			System.out.println("연결 성공");
			System.out.println("\t Client IP : "+ socket.getInetAddress().getHostAddress());
			System.out.println("\t Client Port : "+ socket.getPort());
			
			int result = connectClient(socket);
			System.out.println("통신 결과 : " + (result != 0 ? "성공" : "실패"));
			if(result == 2) {
				break;
			}
			
			System.out.println("Client 연결을 종료합니다.");
			socket.close();
		}
		
		serverSocket.close();
		System.out.println("서버를 종료합니다.");
	}

	private static int connectClient(Socket socket) {
		try (   InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is);
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);
				) {
			while(true) {
				String readStr = br.readLine();
				System.out.println("수신된 메세지 : " + readStr);
				bw.append(readStr);
				bw.newLine();
				bw.flush();
				
				if(readStr.toLowerCase().contains("close") == true) {
					return 1;
				} else if(readStr.toLowerCase().contains("exit") == true) {
					return 2;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
