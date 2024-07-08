package com.multi.ex06.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        // Date : java 1.0 부터 날짜 Type 활용, Calendar와 병행 사용을 권장
        // -> 1.8 이후 LocalDateTime으로 교체되고 있다.
        // -> JSP 사용하는 레거시에는 활용 불가!

//        java.util.Date date = new java.util.Date(); // 이게 정석이다
//        java.sql.Date date2 = new java.sql.Date();
        Date date = new Date();
        System.out.println(date); // 오늘 날짜, Mon Jul 08 14:35:51 KST 2024 -> 미국식 포맷
        System.out.println(date.getTime());             // 1720416970042
        System.out.println(System.currentTimeMillis()); // 1720417028839
        System.out.println("-----------------------------------------");
        // GMT -> 그리니치 표준시, 영국 : 0시, 우리나라 GMT+9, 9시간 시차 존재!
        // 1720417025603 -> 1970년 1월 1일 0시로부터 현재까지 흐른 ms 시차!

        Date date2 = new Date(System.currentTimeMillis()); // currentTimeMillis : OS 시스템의 현재 시간을 가져오는 메소드
        System.out.println(date2);
        System.out.println("-----------------------------------------");

        // Date format 바꾸는 방법 ★
        // https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss.SSS");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분 ss초"); // 날짜 기본 형식 (E - 요일)
        // 주의점! MM : 월, m : 분

        System.out.println(sdf1.format(new Date()));
        System.out.println(sdf2.format(new Date()));
        System.out.println("-----------------------------------------");


        System.out.println("-----------------------------------------");
        // 문자열 -> 날짜로 변경하는 방법 : parse
        Date d = sdf1.parse("2024-07-08(월) 03:07:13");
        System.out.println(sdf1.format(d));

        // Calendar : Date 단점을 보완한 Library, date에서 delicate 된 메소드를 Calendar에서 사용하면 된다.
        // 특징 : 자체 생성이 불가능!!
//     Calendar cal = new Calendar(); // abstract class라 생성되지 않음
        Calendar cal = Calendar.getInstance(); // Class를 대신 생성시켜주는 생성자 패턴
        System.out.println(cal.toString().replace(",", ",\n")); // GregorianCalendar

        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH) + 1); // +1
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.AM_PM));
        System.out.println(cal.get(Calendar.HOUR));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));

        String dateStr1 = sdf1.format(cal.getTime());
        String dateStr2 = sdf1.format(cal.getTimeInMillis());
        System.out.println(dateStr1);
        System.out.println(dateStr2);

        // 날짜를 지정하는 방법 : GregorianCalendar를 권장
        GregorianCalendar gc = new GregorianCalendar(2000, 5 - 1, 10); // 2000-05-10
        System.out.println(sdf1.format(gc.getTime()));

        // 날짜간 대소 비교
        System.out.println(gc.after(cal));
        System.out.println(gc.before(cal));

        // 날짜 더하기
        gc.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(sdf1.format(gc.getTime()));
        System.out.println("-------------------------------------------------");
    }
}
