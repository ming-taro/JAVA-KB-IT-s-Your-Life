package com.multi.ex06.date;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        // Date : java 1.0 부터 날짜 Type 활용, Calendar와 병행 사용을 권장
        // -> 1.8 이후 LocalDateTime으로 교체되고 있다.
        // -> JSP 사용하는 레거시에는 활용 불가!

//        java.util.Date date = new java.util.Date(); // 이게 정석이다
//        java.sql.Date date2 = new java.sql.Date();
        Date date = new Date();
        System.out.println(date); // 오늘 날짜, Mon Jul 08 14:35:51 KST 2024 -> 미국식 포맷
        System.out.println(date.getTime());             // 1720416970042
        System.out.println(System.currentTimeMillis()); // 1720417028839
        // GMT -> 그리니치 표준시, 영국 : 0시, 우리나라 GMT+9, 9시간 시차 존재!
        // 1720417025603 -> 1970년 1월 1일 0시로부터 현재까지 흐른 ms 시차!
    }
}
