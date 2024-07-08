package com.multi.ex02.string;

public class String1 {
    // String 사용 Tip
    // 1. String의 저장소는 Heap과 String constant pool 두가지가 있다.
    // 2. String constant pool을 사용하는 것이 메모리 관리측면에서 유리하다.
    // 3. 일반적인 String은 new(생성자)로 생성하지 않는다. -> Heap을 거쳐서 생성됨으로 사용하지 않는다.
    //    ※ 생성자를 활용 할 필요도 있음으로 일반적인 상황을 말한다.

    public static void main(String[] args) {
        // String pool test
        String str1 = "Test String"; // String pool에 저장된 값, 이게 정석적인 표현법
        String str2 = new String("Test String"); // heap에서 생성된 문자, 해당 문법 사용하지 말것!
        String str3 = str2.toString(); // heap에서 생성된 문자
        String str4 = str2.intern(); // 문자열을 복사할때 쓰는 메소드!! pool of unique strings.

        // 문자열 hashCode(고유ID) 출력 -> 결과 모두 같은 값이 나온다.
        System.out.println(str1.hashCode()); // 432811871
        System.out.println(str2.hashCode()); // 432811871
        System.out.println(str3.hashCode()); // 432811871
        System.out.println(str4.hashCode()); // 432811871

        // equals로 비교 -> 모두 같은 결과
        // hashCode 기준으로 비교함으로 같은 결과
        System.out.println("--------equals--------");
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1.equals(str3)); // true
        System.out.println(str1.equals(str4)); // true
        System.out.println("----------------------");


        // 비교연산자 활용하는 경우 (==) -> 메모리주소 기반으로 비교함으로 heap, String pool 값이 다르게 출력
        System.out.println("-------- '==' --------");
        System.out.println(str1 == str2); // false
        System.out.println(str1 == str3); // false
        System.out.println(str1 == str4); // true
        System.out.println("----------------------");

        // 메모리 주소(고유주소)
        System.out.println(System.identityHashCode(str1)); // 1365202186 -> String pool
        System.out.println(System.identityHashCode(str2)); // 1651191114 -> heap
        System.out.println(System.identityHashCode(str3)); // 1651191114 -> heap
        System.out.println(System.identityHashCode(str4)); // 1365202186 -> String pool

        // 문자열 초기화 하는 방법
        String temp = ""; // 공백으로 초기화 하는 방법, 임시변수 만들때 활용
        temp += "1234" + "홍길동\n";
        temp += "1234" + "홍길동\n";
        temp += "1234" + "홍길동\n";
        System.out.println(temp);
    }
}