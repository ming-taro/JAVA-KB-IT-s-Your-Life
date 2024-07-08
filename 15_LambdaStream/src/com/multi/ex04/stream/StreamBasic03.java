package com.multi.ex04.stream;
import java.util.*;
import java.util.stream.*;
import java.util.*;
import java.util.stream.*;

class StreamBasic03 {
	// 고유 스트림 : 숫자로 구성된 기본형은 고유 스트림이 존재하고, 전용 메소드가 추가 되어있다.
	// IntStream : int type 숫자로 구성된 스트림, 전용 메소드가 존재한다.
	// DoubleStream : double type 숫자로 구성된 스트림, 전용 메소드가 존재한다.
	// LongStream : long type 숫자로 구성된 스트림, 전용 메소드가 존재한다.
	// 고유 메소드 정보는 아래 참조
	// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html

	public static void main(String[] args) {
		// IntStream 활용
		IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("IntStream");
		System.out.println(Arrays.toString(intStream1.toArray()));

		// 객체 Stream을 IntStream으로 변환하는 방법
		String[] strArr = {
				"Inheritance", "Java", "Lambda", "stream",
				"OptionalDouble", "IntStream", "count", "sum"
		};
		// 문자열 스트림
		Stream<String> strStream = Stream.of(strArr);

		// mapToInt : 일반 스트림을 숫자 스트림으로 바꿔주는 기능
		//  -> 만일 자신을 넣는 경우 항등함수 활용
		IntStream intStream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).mapToInt((a) -> a);
		IntStream intStream3 = strStream.mapToInt(String::length);
		System.out.println(Arrays.toString(intStream2.toArray()));
		System.out.println(Arrays.toString(intStream3.toArray()));

		// DoubleStream 활용
		DoubleStream doubleStream1 = IntStream.of(1, 2, 3, 4, 5).asDoubleStream();
		DoubleStream doubleStream2 = DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5);
		System.out.println("doubleStream");
		System.out.println(Arrays.toString(doubleStream1.toArray()));
		System.out.println(Arrays.toString(doubleStream2.toArray()));

		// IntStream, DoubleStream, LongStream 고유 메소드
		// sum, avg,
		int count1 = IntStream.of(1, 2, 3, 4, 5).reduce(0, (a, b) -> a + 1);
		long count2 = IntStream.of(1, 2, 3, 4, 5).count();
		System.out.println("count : " + count1 + ", " + count2);

		int sum1 = IntStream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum);
		int sum2 = IntStream.of(1, 2, 3, 4, 5).sum();
		System.out.println("sum : " + sum1 + ", " + sum2);

		OptionalDouble avg = IntStream.of(1, 2, 3, 4, 5).average();
		System.out.println("avg : " + avg.getAsDouble());

		OptionalInt max1 = IntStream.of(1, 2, 3, 4, 5).reduce(Integer::max);
		OptionalInt max2 = IntStream.of(1, 2, 3, 4, 5).max();
		OptionalInt min1 = IntStream.of(1, 2, 3, 4, 5).reduce(Integer::min);
		OptionalInt min2 = IntStream.of(1, 2, 3, 4, 5).min();
		System.out.println("max : " + max1.getAsInt() + ", " + max2.getAsInt());
		System.out.println("min : " + min1.getAsInt() + ", " + min1.getAsInt());
	}
}
