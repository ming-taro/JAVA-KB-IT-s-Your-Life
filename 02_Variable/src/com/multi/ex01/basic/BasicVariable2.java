package com.multi.ex01.basic;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BasicVariable2 {
    // 기본형 Type (8가지)
    // 1. 정수형 : byte(1), short(2), int(4)★, long(8)★
    // 2. 실수 : float(4), double(8)★
    // 3. 문자 : char(2)
    // 4. 논리형 : boolean(1)★

    public static void main(String[] args) {
        // 1. 정수형 byte(1), short(2), int(4)★, long(8)
        byte byteValue = 127;
        short shortValue = 32000;
        int intValue = 2100000000;
        int intValue2 = 2_100_000_000; // 정수를 _로 분류표기 가능
        long longValue1 = 2100000000l; // long은 리터럴 끝에 'l', 'L' 필요!
        long longValue2 = 2100000000000000000L; // L을 추천!
        // long보다 더큰 수를 사용할때 활용
        BigInteger bigInt = new BigInteger("125981258125812581958195810958190589528");
        BigDecimal bingDecimal = new BigDecimal("21890480284.2194082948219481249");

        System.out.println(byteValue);
        System.out.println(shortValue);
        System.out.println(intValue);
        System.out.println(intValue2);
        System.out.println(longValue1);
        System.out.println(longValue2);
        System.out.println(bigInt);
        System.out.println(bingDecimal);

        
        // 2. 실수 float(4), double(8)★
        // - 실수는 정확도 이슈가 있음으로 가능하면 double을 사용하는 것이 유리
        float floatValue   = 3.141592653589793238f; // float 리터럴 끝에 'f', 'F' 필요!
        double doubleValue = 3.141592653589793238;

        System.out.println(floatValue);
        System.out.println(doubleValue);

        // 부동소수점의 표현은 계산의 오류가 내포한다는 것을 인지해야함
        // 컴퓨터에서 부동소수점 연산은 항상 오차를 발생하나 double로 사용할 경우 오차가 극히 적음.
        // 부동소수점 표현 방법 지수부(10^-1), 가수부(314159265...)로 구성되어 있음
        // 실제 변수 크기에 따라 표현이 제한적이다!

        // BigDecimal -> 가급적 프로그래밍적으로 쓰지 말것!!
        BigDecimal bigValue = new BigDecimal("3.141592653589793238283940823049823904");
        System.out.println(bigValue);

        // 부동소수점 오차 테스트
        float testFloat = 0.1f + 0.2f;
        double testDouble = 0.1 + 0.2;

        System.out.println(testFloat);  // 예측 : 0.3, 결과 : 0.3
        System.out.println(testDouble); // 예측 : 0.3, 결과 : 0.30000000000000004
        // 결론 : 부동소수점은 항상 오차 가능성이 존재함으로 자리수 제한이 필요!

        // 자리수 자르는 예시
        // 1. 문자열 포멧 이용
        String str = String.format("%.2f", testDouble);
        System.out.println(str);

        // 2. printf 활용
        System.out.printf("%.2f\n", testDouble);

        // 3. 문자 char(2) - unsigned char, 유니코드
        // 'a' = char 표기
        // "a" = String 표기
        char charValue = 'A'; // 문자로 표기가 정석
        char charValue1 = 65; // 아스키상에서 'A'가 되는 숫자 참고 : https://domybestinlife.tistory.com/78
        char charValue2 = '가'; // 44032
        char charValue3 = 44032; // 44032
//        char charValue4 = '가나다'; // 에러!
        String strValue = "가나다";

        System.out.println(charValue);
        System.out.println(charValue1);
        System.out.println(charValue2);
        System.out.println(charValue3);
        System.out.println(strValue);

        // char 응용
        System.out.println((char)(charValue + charValue1)); // 130
        System.out.println("" + charValue + charValue1); // AA
        System.out.println((int)charValue2); // 가의 유니코드 알고싶을때
        System.out.println((char)(charValue2 + 1)); // 각
        System.out.println((char)(charValue2 + 2)); // 갂

        // 알파벳순으로 출력하는 방법
        for (int i = 0; i < 'Z' - 'A' + 1; i++) {
            System.out.print((char)('A' + i) + " ");
        }

        // 4. 논리형 boolean(1)
        // 논리형 : 참과 거짓 값을 판별하는 값
        boolean isTrue = true; // 참 = 1
        boolean isFalse = false; // 거짓 = 0
        System.out.println(isTrue);
        System.out.println(isFalse);

        // 상수란? 프로그래밍에서 변하지 않는 값
        // 상수 변수명 표기방법 : 모두 대문자를 사용하고 띄어쓰기를 '_'로 표현하는 헝가리 표기법 사용
        final int USER_MAX_VALUE = 50; // 수강인원 최대 수
        final int USER_MIN_VALUE = 10; // 수강인원 최소 수
//		USER_MAX_VALUE = 10; // 상수는 한번 초기화 하면 변경할수 없다!
        System.out.println(USER_MAX_VALUE);
        System.out.println(USER_MIN_VALUE);

    }
    
    // 상수의 올바른 표기법
    public static final int USER_MAX_VALUE1 = 50;
    final static public int USER_MAX_VALUE2 = 50;
}
