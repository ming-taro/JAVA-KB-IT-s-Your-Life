package com.multi.ex03.string;

public class StringPractice {
    // String은 자바에서 가장 많이 활용되는 type이고, Java에서 특수 취급(우대)해주는 type
    // -> 웹 페이지 구성시 가장 많이 활용되는 type 문자열이기 때문

    public static void main(String[] args) {
        String str = "abc"; // 이방법이 문자열을 사용하는 가장 표준적인 방법
        str = new String("abc"); // String은 절대 new로 생성하지 않는다!!
        System.out.println(str);

        // 문자열 합연산(결합)
        str = "ABC" + "DEF";
        System.out.println(str);

        // 문자열 합연산시 고려할 사항
        // -> 기본적으로 문자열과 기본형 간 결합이 되면 문자열이 된다.
        // -> type을 고려하여 결합이 됬을때 문자열인지 숫자일지 고민이 필요
        // -> 아주 간단한 해결 방법이 존재.
        int value = 123 + 45; // 168
        System.out.println(value);
        str = 123 + 45 + "ABC" + "DEF";
//		str = 168 + "ABC" + "DEF";
//		str = "168ABC" + "DEF";
//		str = "168ABCDEF";
        System.out.println(str); // 168ABCDEF -> 의도하지 않은 결과!!
        System.out.println("---------------------------------------------------");

        // 해결법1 = 괄호 사용, 3 + 4 * 5 = 35? -> (3 + 4) * 5 = 35
        str = 123 + (45 + "ABC") + "DEF";
        System.out.println(str);

        // 해결법2 = 앞에 ""로 시작하여 결합한다. ★★★★★
        str = "" + 123 + 45 + "ABC" + "DEF";
        System.out.println(str);

        // 문자열 한글 활용
        str = "한글 사용 할수 있다!";
        System.out.println(str);

        // \t : tab, 들여쓰기 문자
        System.out.println("선우길동\t25\t011-423-5678");
        System.out.println("김길\t31\t010-2323-5678");
        System.out.println("최길동\t66\t010-5858-5678");

        // \n : new line(=개행)
        System.out.println("abc\ndef\n");
        System.out.println("abc");

        // \" : "(더블쿼테이션)을 출력하고 싶을 때
        System.out.println("\"안녕하세요\"");

        // \\ : 파일 경로(file path) 혹은 역슬래쉬를 출력 할 때
        System.out.println("\\");
        System.out.println("/02_Variable/src/com/multi/ex03/string/StringPractice.java");
        System.out.println("C:\\dev_source\\work_space_java_kb5\\javakb5\\02_Variable\\src\\com\\multi\\ex03\\string\\StringPractice.java");
        // -> ""문자열 안에서 경로를 붙여놓기 하면 알아서 경로를 \\로 처리한다.

        // \\u : unicode 출력하는 방법
        System.out.println('A');
        System.out.println((int)'A'); // 10진수
        System.out.println("0x"+ Integer.toHexString((int)'A')); // 16진수
        System.out.println("\u0041"); // 유니코드 출력하는 방법
        // 16진수
        // 0x0 ~ 9, 0xA ~ F,  -> 0x10 = 16
    }
}








