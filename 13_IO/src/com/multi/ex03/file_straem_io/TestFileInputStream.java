package com.multi.ex03.file_straem_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
    //	FileInputStream 생성법 3가지
    //	1. File 객체를 통해 file을 여는 방법
    //	2. 상대 경로를 통해 file을 여는 방법 ★
    //	3. 절대 경로를 통해 file을 여는 방법 -> 경로 주의가 필요하다!!

    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            // 오픈부
            // 1. 파일로 읽어오기
//            fis = new FileInputStream(new File("13_IO/test.txt"));
//            fis = new FileInputStream(new File("13_IO/covid.txt"));

            // 2. 경로로 읽어오기
            fis = new FileInputStream("13_IO/test.txt");

            // 출력부 - 1byte씩 읽어오는 예제
            int read = 0;
            while((read = fis.read()) != -1) { // -1 = the end of file, EOF
                System.out.print((char)read);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을수 없습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("입출력 에러가 발생하였습니다.");
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
