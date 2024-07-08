package com.multi.ex01.array_basic;

import java.util.Arrays;

public class ArrayBasic {
    public static void main(String[] args) {
        System.out.println("1. 배열 기본 생성법");

        int[] array = null;   // null 초기화 가능하다 = 참조형이다
        array = new int[10];  // 10개의 공간을 heap으로 할당하는 문법, 내부는 0으로 초기화 시켜준다

        System.out.println(array[0]); // 초기값은 0
        System.out.println(array[1]); // 두번째는 0
        System.out.println("----------------------------");

        // 배열 접근하는 방법, 수정
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;

        // 순회하는 방법
//        for (int i = 0; i < 10; i++) {  // 상수접근은 좋지 않다!
        for (int i = 0; i < array.length; i++) { // 정수 표기
            array[0] = i;
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println("----------------------------");

        System.out.println("2. 배열 리터럴로 생성하는 방법");
        int[] array2 = new int[10]; // 기본적인 배열 선언법
        int[] array3 = { 1, 2, 3, 4, 5, 6, }; // 가장 간단한 리터럴 표기법
        int[] array4 = new int[]{ 1, 2, 3, 4, 5, 6, };
//        int[] array5 = new int[10]{ 1, 2, 3, 4, 5, 6, }; // 크기 지정시 에러 발생!

        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + ", ");
        }
        System.out.println();

        System.out.println("3. 배열 응용 메소드");
        int[] array5 = new int[12];
        for (int i = 0; i < array5.length; i++) {
            array5[i] = i;
        }

        // 배열 편하게 출력하는 방법
        String str = Arrays.toString(array5);
        System.out.println(str);
        System.out.println(Arrays.toString(array5));

        // 문자 배열
        char[] charArray1 = new char[5];
        char[] charArray2 = { 'a', 'b', 'c', 'd', 'e' };
        System.out.println(Arrays.toString(charArray2));

        // 문자열 배열
        String[] strArray1 = new String[5];
        String[] strArray2 = { "사과", "바나나", "딸기", "수박", "멜론" };
        System.out.println(Arrays.toString(strArray2));
    }
}
