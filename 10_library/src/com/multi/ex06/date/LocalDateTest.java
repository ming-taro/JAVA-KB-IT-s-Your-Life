package com.multi.ex06.date;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

// 날짜 관련 Library2
public class LocalDateTest {
	public static void main(String[] args) throws ParseException {
		// Java8 이후 추가된 java.time
		// - 기존 Date, Calendar 체계보다 성능적으로나 활용적으로 더 좋은 Joda-Time을 내장 시켰다.
		// - 레거시 환경에서는 library 버전 이슈나 jsp에서 적용이 되지 않아 사용할수 없다.
		// - Mybatis나 JPA 환경에서는 거의 자동으로 호환됨으로 REST로 만들때는 활용하는게 좋다.

		java.time.LocalDate localDate = java.time.LocalDate.now(); // 날짜 까지만 다룰때
		LocalTime localTime = LocalTime.now(); // 시간만 다룰때
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul")); // 날짜 + 시간
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime); // ISO 표준 포멧팅
		// the ISO-8601 calendar system,such as 2007-12-03T10:15:30.
		System.out.println("----------------------------------------------------");
		
		// 년월일시분 까지 다루는 방법
		LocalDateTime birthDay = LocalDateTime.of(1996, 03, 24, 12, 0);
		System.out.println(birthDay);
		System.out.println(birthDay.format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println(birthDay.format(DateTimeFormatter.ISO_DATE));
		System.out.println(birthDay.format(DateTimeFormatter.ISO_TIME));
		System.out.println(birthDay.format(DateTimeFormatter.ISO_WEEK_DATE)); // 주단위

		// Zone 적용해보기
		System.out.println("한국 시간");
		ZonedDateTime zonedDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul")).atZone(ZoneId.of("Asia/Seoul"));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		System.out.println(zonedDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));

		System.out.println("영국 시간");
		ZonedDateTime zonedDateTime2 = LocalDateTime.now(ZoneId.of("Europe/London")).atZone(ZoneId.of("Europe/London"));
		System.out.println(zonedDateTime2.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.UK)));
		System.out.println(zonedDateTime2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.UK)));
		System.out.println(zonedDateTime2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.UK)));
		System.out.println(zonedDateTime2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK)));
		System.out.println(zonedDateTime2.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK)));

		// 날짜 연산
		java.time.LocalDate dateTime1 = java.time.LocalDate.of(2024, 6, 25);
		java.time.LocalDate dateTime2 = java.time.LocalDate.now();

		System.out.println(dateTime1.isAfter(dateTime2));
		System.out.println(dateTime2.isAfter(dateTime1));
		Period period = Period.between(dateTime1, dateTime2);
		System.out.println(period.getDays());

		System.out.println(dateTime1.plusDays(5));
		System.out.println(dateTime1.minusDays(5));
		System.out.println(dateTime1.plusWeeks(1));
		System.out.println(dateTime1.minusWeeks(1));
		System.out.println(dateTime1.plusMonths(5));
		System.out.println(dateTime1.minusMonths(5));

		// format 바꾸는 방법 ★★★★★
		// https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		LocalDateTime startDateTime = LocalDateTime.of(2021,  1, 1, 0, 0, 0);
		System.out.println("시작일: " + startDateTime.format(dtf));
		LocalDateTime endDateTime = LocalDateTime.of(2021,  12, 31, 0, 0, 0);
		System.out.println("종료일: " + endDateTime.format(dtf));

		// Date -> LocalDateTime
		Date d1 = new Date();
		LocalDateTime ldt = LocalDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault());
		System.out.println(ldt);

		// LocalDateTime -> Date
		LocalDateTime ldt2 = LocalDateTime.now();
		Date d2 = Date.from(ldt2.toInstant(ZoneOffset.ofHours(9)));
		System.out.println(d2);
	}
}
