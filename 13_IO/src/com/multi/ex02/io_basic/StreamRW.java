package com.multi.ex02.io_basic;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class StreamRW {
    // reader : 문자열 단위로 읽어오는 기능
    // writer : 문자열 단위로 쓰는 기능
    // java에서 문자열은 2byte를 기준으로 함

    // try-with-resources문  ★★★★★★
    // - java 1.7부터 추가된 문법으로 Closeable 객체의 close를 자동으로 해주는 문법
    // - try (open 부) {~~~} catch(e){~~~}로 활용하는데, open부에서 자원생성을 수행해야한다.
    // - ※ 주의 : Closeable 객체만 활용 가능!

    // IO 객체 사용시의 코딩 테크닉 - try-with-resources ver. (java 1.7 이상)
    // 1. try-catch문을 생성한다.
    // 2. try 뒤에 ()를 열고 IO 객체 선언 및 스트림 오픈을 수행한다.
    // 3. 필요한 IO을 수행한다. 보통 while문으로 수행
    //  -> try-with-resources을 사용하면 finally 구현이 필요 없다.

    public static void main(String[] args) {

        try(InputStreamReader isr = new InputStreamReader(System.in);
            OutputStreamWriter osw = new OutputStreamWriter(System.out); ) {
//            System.out.println("문자열을 입력해주세요. \n");
            osw.append("문자열을 입력해주세요.\n");
            osw.flush(); // buffer를 밀어주는 코드, 관례적 + 기능적으로 활용, 매우 중요

            char[] buf = new char[1024]; // buffer의 크기는 2의 제곱값으로 정한다. // 512, 1024
            int size = isr.read(buf); // read 멈춰있다!
            // read : Blocking 함수, 프로그램의 동작을 멈추고, 특정 이벤트가 발생하면 다시 프로그램 흐름이 실행되는 함수
//            buf = Arrays.copyOf(buf, size);
            osw.append("read size : " + size + "\n");
            osw.append("입력된 문자열 : " + new String(buf).trim() + "\n"); // char[] 문자열로
            osw.append("입력된 문자열 : " + String.valueOf(buf).trim() + "\n"); // char[] 문자열로
            osw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // close부 생략 가능!!
    }
}
