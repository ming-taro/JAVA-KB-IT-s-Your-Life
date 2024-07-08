package com.multi.ex02.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;

public class String2 {

    @SuppressWarnings("all") // : 워닝 없애주는 어노테이션
    public static void main(String[] args) throws Exception {
        // 0. String 생성자 활용법
        // -> 일반적인 String은 생성자를 활용하지 않으나 가끔 쓸일이 있다
        String s0 = "Hello"; // 가장 정상적인 방법!!
        String s1 = new String("Hello"); // 비정상적인 방법!
        String s2 = new String(new char[] { 'H', 'e', 'l', 'l', 'o' }); // 생성자 올바른 활용 예시1
        String s3 = new String(s2.getBytes(StandardCharsets.UTF_8), "utf-8");    // 생성자 올바른 활용 예시2 (인코딩을 맞춰줄 때)

        System.out.println(s0);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("-----------------------------------");

        String a = "aaa";
        String b = "aaabbb";
        // 1. equals : 문자열을 비교해주는 메소드
        //    equalsIgnoreCase : 대소문자를 무시하고 비교해주는 메소드
        System.out.println("[equals]");
        System.out.println(a.equals("aaa")); // true
        System.out.println(a.equals("bbb")); // false
        System.out.println(a.equals(b)); // false
        System.out.println(a.equalsIgnoreCase("AAA")); // true
        System.out.println(a.equalsIgnoreCase("BBB")); // false
        System.out.println("-----------------------------------");

        // 2. contains : 문자열의 포함 여부를 알려주는 메소드, 한글 활용 가능!
        System.out.println("[contains]");
        System.out.println(a.contains("a")); // 포함 -> true
        System.out.println(a.contains("c")); // 미포함 -> false
        System.out.println(a.contains(b));   // 더 큰 범위(비교조차X) -> false
        System.out.println("aaabbb".contains(a)); // true
        System.out.println(b.contains(a));        // true
        System.out.println("-----------------------------------");

        // 3. compareTo : 문자열 대소비교와 같은지 확인할 수 있는 메소드, 사전순으로 비교도 가능!
        // ex) 김길동 > 박길동 > 홍길동 > 홍길홍
        // ★★★★★ 정렬할 때 반드시 필수적으로 외워야 하는 메소드!!!
        System.out.println("[compareTo]");
        System.out.println("홍길동".compareTo("김길동")); // 10253
        System.out.println("김길동".compareTo("홍길동")); // -10253
        System.out.println("홍길동".compareTo("홍길동")); // 0
        System.out.println("-----------------------------------");
        // 같으면 0, 크면 양수, 작으면 음수
        // 여기서의 비교값은 문자열간의 거리!

        // 4. concat : 문자열을 결합하는 메소드
        System.out.println("[concat]");
        String str1 = "홍길동";
        String str2 = "의 주소지는 서울입니다.";
//        str1.concat(str2); -> immutable이기 때문에 새로운 값을 리턴할 뿐이다 (문자열은 자신이 변경되지 않는다)
        System.out.println(str1.concat(str2));
        //올바른 문법
        String str3 = str1.concat(str2); // 정석적인 문법
        String str4 = str1 + str2; // 논리적으로 동치한 문법
        System.out.println(str3);
        System.out.println(str4);
        System.out.println("-----------------------------------");
        // ※ String Lib. 사용시 주의점
        // - 일반 객체 설계 메커니즘과 다른점이 존재, 기능을 적용해서 본인은 바뀌지 않고 바뀐 값을 리턴
        // - this(본인)은 불편하는 원칙 (immutable = 불변성) 때문이다.
        // - 바뀐 값을 다시 문자열로 받아야 메소드 기능을 활용할수 있음.

        // 5. charAt() : 문자열에서 index에 해당되는 문자를 방환하는 메소드
        System.out.println("[charAt]");
        String temp = "abcdef";
        for (int i = 0; i < temp.length(); i++) {
            System.out.print(temp.charAt(i));
        }
        System.out.println("\n-----------------------------------");

        // 6. indexOf() : 문자열 내에서 인자와 일치하는 index 반환
        //    fromIndex : 두 번째 인자로 특정 인덱스 이후로 부터 검색! -> counting
        // -1 : 못 찾음, 0이상이면 문자열 내에 포함!
        System.out.println("[indexOf]");
        String str5 = "안녕하세요? 저는 홍길동입니다.";
        System.out.println(str5.indexOf("안녕"));   // 0
        System.out.println(str5.indexOf("홍길동")); // 10, 10번째 부터 홍길동이 시작됨
        System.out.println(str5.indexOf("하이"));   // -1, 없는 문자열
        System.out.println("-----------------------------------");

        str5 = "abcabcabc";
        System.out.println(str5.indexOf("a")); // 0
        System.out.println(str5.indexOf("z")); // -1
        System.out.println(str5.indexOf("bc")); // 1부터 시작
        System.out.println(str5.indexOf("abc")); // 0
        // 첫번째 abc 다음 abc를 찾을 때 문장 -> fromIndex 활용!
        System.out.println(str5.indexOf("abc", 1)); // 0이 아니면 다음부터 찾는다
        System.out.println(str5.indexOf("abc", 2)); // 0, 1이 아니면 다음부터 찾는다
        // 다음 index를 효율적으로 찾아 오는 관례적인 문법(슬라이딩 윈도우)
        int index = str5.indexOf("abc"); // 기존 index값 = 0;
        System.out.println(str5.indexOf("abc", index + "abc".length()));

        // 응용편
        // '안녕'이라고 친 문자열 개수를 찾고 인덱스도 모두 출력하세요! = indexOf 활용해서
        String str6 = "안녕하세요? 저는 홍길동입니다. 다들 안녕하셨는지요? "
                + "안녕하지 못하셨으면 죄송하고 안녕히 계세요. 저는 안녕을 찾으러 갑니다.";
        int helloCount = 0;

        int start = 0;
        int cnt = 0;

        while (start < str6.length()) {
            cnt++;
            int findIndex = str6.substring(start).indexOf("안녕");
            if (findIndex == -1) break;
            start += findIndex + 2;
            helloCount++;
            if(cnt == 5) {
                break;
            }
        }
        System.out.println("helloCount: " + helloCount);

        // 7. lastIndexOf() : 문자열을 찾는데, 뒤로 부터 찾는다.
        System.out.println(str6.indexOf("안녕")); // 0
        System.out.println(str6.lastIndexOf("안녕")); // 58
        System.out.println(str6.lastIndexOf("안녕", 58 - 2)); // 찾은 위치 - 2, 결과 : 46
        System.out.println(str6.lastIndexOf("안녕", 46 - "안녕".length())); // 찾은 위치 - 2, 결과 : 30
        System.out.println("----------------------------------------------");

        // 8. startWith : 문자열의 시작 패턴을 확인
        String str7 = "test.txt";
        System.out.println(str7);
        System.out.println(str7.startsWith("test")); // true!
        System.out.println(str7.startsWith("txt")); // false
        System.out.println("----------------------------------------------");

        // 9. endsWith : 문자열의 끝 패턴을 확인, 주로 확장자를 확인할때 쓰는 용도 ★★★★★
        str7 = "test.txt";
        System.out.println(str7);
        System.out.println(str7.endsWith("txt")); // true
        System.out.println(str7.endsWith(".txt")); // true, '.' 필요!! ★★★★★
        System.out.println(str7.endsWith(".zip")); // false
        System.out.println("----------------------------------------------");

        // 10. trim 류 : white space를 제거하는 기능, - strip(Since:11)을 추천★★★★★
        // white space란 : 문자열의 노이즈, 사람 눈에 보이지 않는 문자열, 공백, newline, tab등 정보로 필요없는 데이터
        // web 계열에서 사용자의 입력값을 필터링 하는 용도로 가장 많이 활용!!
        final String origin
                = " \r    이름 : #*홍길동, 나이 : #*23, 주소 : #*서울시 강남구   \u2003\n\t";
        //  \u2003 : 문자열로 인지되지만 쓰레기 값
        System.out.println(origin);
        System.out.println("-----------------------------------------------");
        System.out.println(origin.trim()); // trim : 문자 쓰레기 값을 제외한 white space 제거
        System.out.println(origin.strip()); // strip : 모든 white space, 쓰레기 값도 제거, 성능이 좋다★★★★
        System.out.println(origin.stripLeading()); // 앞쪽만 제거하는 방법
        System.out.println(origin.stripTrailing()); // 뒤쪽만 제거하는 방법
        System.out.println(origin.stripIndent()); // \n\t 일부 공백을 살려 indent가 보이도록 제거
        System.out.println("-----------------------------------------------");

        String text = origin.strip(); // 추천!
        System.out.println(text);
        // 이름 : #*홍길동, 나이 : #*23, 주소 : #*서울시 강남구

        // 11. subString : 문자열 지정한 위치로 자를 때 활용
        System.out.println("-----------------------------------------------");
        System.out.println(text.substring(10)); // 앞부터 10글자까지 잘려져 나가는 방법
        System.out.println(text.substring(4, 10)); // 4 ~ 10번째 글자를 잘라서 쓰는 방법
        System.out.println(text.substring(text.length() - 10, text.length())); // 뒤로 부터 10글자 자르는 방법
        System.out.println("-----------------------------------------------");
        
        // 12. replace : 특정 문자열을 모드 교체할 때 활용, 교체를 빈 문자열로 하면 제거하는 기능
        //               -> 모든 문자열이 교체되거나 제거됨 (첫번째만 제거되지 않음!!)
        // replace(oldChar = 변경할 문자열, newChar = 변경될 문자열)
        System.out.println(text.replace("홍길동", "박길동")); // 홍길동 -> 박길동
        System.out.println(text.replace("#*", "")); // #* 제거

        // 13. replaceAll : 일반 문자열도 가능하지만, 정규식 패턴으로 문자열을 교체/제거 할때 활용됨
        // -> id, pw 또는 입력값의 특수문자를 제거하거나 교체하는 용도로도 활용
        // 사례 : https://hobbylists.tistory.com/entry/%EC%97%AC%EA%B8%B0%EC%96%B4%EB%95%8C%EC%97%90%EC%84%9C-%EB%B0%9C%EC%83%9D%ED%95%9C-%EA%B0%9C%EC%9D%B8%EC%A0%95%EB%B3%B4-%EC%9C%A0%EC%B6%9C%EC%82%AC%EA%B1%B4-SQL-Injection-%EC%97%AC%EA%B8%B0%EC%96%B4%EB%95%8C
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]"; // 특수문자를 제거하는 정규식 표현
        System.out.println(origin.replaceAll(match, "").strip());
        System.out.println("-----------------------------------------------");

        // 14. repaceFirst : 처음문자만 교체 할 때
        String str = "AAABBBCC";
        System.out.println(str.replace("A", "Z"));
        System.out.println(str.replaceFirst("A", "Z"));
        System.out.println("-----------------------------------------------");

        // 15. split : 문자열을 특장 인자(Delimiter=구분자,정규식)로 잘라서 토큰(Token)배열로 반환하는 함수
        String[] strArray = text.split(","); // Delimiter = ","
        for(String s : strArray) {
            System.out.println(s.strip());
        }

        System.out.println("----------------------------------------------");
        // 2중으로 잘라서 이름, 나이, 주소값을 발라서 가져오는 방법
        String[] array1 = text.split(",");
        for(String s : array1) {
            String[] array2 = s.split(":");
//        for(String s2 : array2) {
//           System.out.println(s2.strip());
//        }
            System.out.println(array2[1].strip()); // 정보만 가져오는 방법
        }
        System.out.println("----------------------------------------------");


        // 16. join  : 배열된 문자열을 하나의 문자열로 합칠때 사용
        String[] array2 = text.split(",");
        System.out.println(Arrays.toString(array2));
        String temp2 = "";
        for(String s : array2) {
            temp2 += s +"/";
        }
        System.out.println(temp2);
        // 위 코드를 한줄로 표현하는 방법
        temp2 = String.join("_", array2);
        System.out.println(temp2);
        System.out.println("-------------------------------------");

        // 17. StringTokenizer : Split 객체버전
        System.out.println(text);
        StringTokenizer tokens = new StringTokenizer(text, ",");
        // while문 has + nextMore 패턴
        while(tokens.hasMoreElements()) { // 엘리먼트가 더 있을때
            System.out.println(tokens.nextElement()); // 다음 엘리먼트를 가져오는 문장
        }
        System.out.println("-------------------------------------");

        // 18. 대/소문자 변경하기 - toXXXXCase
        String temp5 = "ABC abc AAA bbb";
        System.out.println(temp5.toUpperCase()); // 올려준다=대문자 변경
        System.out.println(temp5.toLowerCase()); // 내려준다=소문자 변경
        System.out.println("-------------------------------------");

        // 19. valueOf : 다른 자료형을 문자열로 변경하는 방법
        int age = 23;
        String ageStr1 = "" + age; // 이 방법 추천
        String ageStr2 = String.valueOf(age);
        System.out.println(ageStr1);
        System.out.println(ageStr2);
        System.out.println("-------------------------------------");

        // 20. repeat : 반복시키기
        String repeatText = "ABC".repeat(10);
        System.out.println(repeatText);
        System.out.println("-".repeat(50));

        // 21. format : %d, %f, %s등 format 출력 지원하는 함수
        // -> 소수점 자르는 용도로 많이 활용
        String str11 = String.format("%d %.2f %s", 10, 3.14, "안녕");
        System.out.println(str11);
    }
}
