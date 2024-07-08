package com.multi.ex03.socket_multiple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultipleEchoServer {
	
	public static ServerSocket serverSocket = null;
	public static int clientCount = 0;
	
	public static void main(String[] args) throws Exception {
		int port = 9000; 

		serverSocket = new ServerSocket(port); 
		System.out.println("Server 소켓을 생성하였습니다. port : " + port);

		while(true) {
			System.out.println("Client 연결 대기");
			Socket socket = serverSocket.accept(); //  새로운 port 번호로 통신
			// Thread
			new ConnectThread(socket, clientCount++).start();;
		}
	}
	
	public static void exit() {
		try {
			serverSocket.close();
			System.exit(0); // 프로그램 죽이는 명령어
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("서버를 종료합니다.");
	}
	
	public static class ConnectThread extends Thread{
		private Socket socket;
		private int clientID;
		
		public ConnectThread(Socket socket, int clientID) {
			super();
			this.socket = socket;
			this.clientID = clientID;
		}
		
		@Override
		public void run() {
			System.out.println("연결 성공");
			System.out.println("\tClient IP : "+ socket.getInetAddress().getHostAddress());
			System.out.println("\tClient Port : "+ socket.getPort());
			System.out.println("\tClientID : "+ clientID);

			int result = connectClient(socket);
			System.out.println("통신 결과 : " + (result != 0 ? "성공" : "실패"));

			System.out.println("Client 연결을 종료합니다.");
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(result == 2) {
				exit();
			}
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
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
	}
}
