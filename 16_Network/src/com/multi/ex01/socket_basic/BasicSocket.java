package com.multi.ex01.socket_basic;

import java.net.InetAddress;
import java.util.Arrays;

public class BasicSocket {

	public static void main(String[] args) throws Exception {
		// PC의 IP 받아오기
		// InetAddress : IPv4, IPv6의 주소정보를 담을수 있는 Class
		
//		InetAddress myIP = new InetAddress();  // 생성불가!
		// The constructor InetAddress() is not visible
		// 생성자를 private(default) -> Singleton 패턴
		//  - 사용자가 임의로 생성하는 것을 막을때 사용
		
		// 정상적인 사용법
		// 자신의 IP주소 확인하는 법
		InetAddress myIP = InetAddress.getLocalHost();
		System.out.println(myIP.getHostAddress()); // 192.168.0.49
		
		// 자신의 ip를 byte[] 받는 방법
		byte[] address = myIP.getAddress();
		System.out.println(Arrays.toString(address)); // [-64, -88, 0, 49]
		
		// 192.168.0.49로 출력하는 방법
		for(int i =0; i < address.length; i++) {
			System.out.print(Byte.toUnsignedInt(address[i]));
			if(i < 3) {
				System.out.print(".");
			}else {
				System.out.println();
			}
		}
		
		// 자신의 host name 알아오기 : LAPTOP-UT95RHIL, PC의 이름
		System.out.println(myIP.getHostName());
		
		// DNS 활용 : domain name -> ip 바꿔오는 방법
		//           www.naver.com -> 100.21.122.56
		InetAddress naverAddress = InetAddress.getByName("www.naver.com");
		System.out.println(naverAddress.getHostName()); // 네이버 host 네임
		System.out.println(naverAddress.getHostAddress()); // 네이버 ip
//		www.naver.com
//		223.130.195.200
//		223.130.195.95
		
		InetAddress googleAddress = InetAddress.getByName("www.google.com");
		System.out.println(googleAddress.getHostName()); // 구글 host 네임
		System.out.println(googleAddress.getHostAddress()); // 구글 ip
//		142.250.76.132
//		142.250.76.132
	}
}







