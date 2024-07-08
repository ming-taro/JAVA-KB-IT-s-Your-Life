package com.multi.ex05.decimal_number;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class DecimalNumberFormatTest {
    public static void main(String[] args) {
        // DecimalFormat : java8에서 추가된 숫자 format library
        // NumberFormat : java8에서 추가된 통화 관련 format library
        // -> 둘다 출력용으로는 거의 쓸일 없다. -> View단에서 JSP나 SPA(react, vue)에서 처리할 예정
        // -> 가끔 입력값으로 들어올때 파싱용으로 활용할일은 있을 듯(?) -> 매우매우 이상한 케이스!!
        // https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/text/DecimalFormat.html

        DecimalFormat df = null;
        double v = 12345.67891534;
        double v1 = 12345.67891534;
        double v2 = 123.456;
        double v3 = 3.14;

        String s1 = "12,345.67892";
        String s2 = "123.45600";
        String s3 = "3.14000";

        // # : 있을 수도 있고 없을 수도 있는 값
        // 0 : 없으면 자리수를 유지하기 위해 0으로 처리되는 값, 자리수 이하는 반올림!
        // 10진수 - # 0 조합 / 단위 구분을 위해 ',' 추가한 코드
        df = new DecimalFormat("###,###.00000");

        System.out.println(df.format(v1));
        System.out.println(df.format(v2));
        System.out.println(df.format(v3));

        // 파싱하는 방법
        // error -> java.lang.NumberFormatException: For input string: "12,345.67892"
//        double p = Double.parseDouble(s1);
//        System.out.println(p);
        try {
            System.out.println("파싱한 값 출력");
            Number number = df.parse(s1);
            System.out.println(number.doubleValue());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        df = new DecimalFormat("0");
        System.out.println(df.format(v)); // 출력값 : 12346

        // 10진수 - 빈자리는 0으로 채움
        df = new DecimalFormat("0.0");
        System.out.println(df.format(v)); // 출력값 : 12345.7

        // 10진수 - 빈자리는 0으로 채움
        df = new DecimalFormat("000000.00000");
        System.out.println(df.format(v)); // 출력값 : 012345.67890

        // 10진수 - 빈자리는 채우지 않음
        df = new DecimalFormat("#");
        System.out.println(df.format(v)); // 출력값 : 12346

        // 10진수 - 빈자리는 채우지 않음
        df = new DecimalFormat("######.###");
        System.out.println(df.format(v)); // 출력값 : 12345.679

        // 100을 곱한 후 문자에 % 붙임
        df = new DecimalFormat("#.##%");
        System.out.println(df.format(v)); // 출력값 : 1234567.89%

        // 통화표시 \u00A4
        df = new DecimalFormat("\u00A4####.##");
        System.out.println(df.format(v)); // 출력값 : ￦12345.68

        // NumberFormat을 이용하여 통화표시를 지정할 수 있다.
        // Locale을 사용하여 국가 지정시 해당 국가의 통화기호 및 자리수 구분까지 된다.
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.KOREA);
        // 소수점 2자리까지 지정
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(v)); // 출력값 : ￦12,345.68


        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
    }
}