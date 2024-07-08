package com.multi.ex02.loop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LoopStatement1 {

    public static void main(String[] args) {
//		myFirstWhileLoop(); // 메소드 호출하는 방법
//		testWhileLoop();
//		testDoWhileLoop();
//		testForLoop();
        testForLoop2();
    }


    // static 메소드
    private static void myFirstWhileLoop() {
        int count = 0;
        while (true) { // while문에 true인 경우는 무한 반복문, 무한 루프문이 만들어진다.
            System.out.println("무한 반복문! count : " + count++);
        }
    }


    private static void testWhileLoop() {
        // 컴퓨터의 시작점 = 0, [0][1][2], 이유 : 메모리 번지를 효율적으로 관리하기 위해 0부터 시작한다.
        int i = 0; // 초기화문, i=index의 약자, 0부터 시작하는 것이 정석

        System.out.println("while 루프 시작!");
        // 0 ~ 9까지 도는 반복문, 10은 도달하지 않는다. 총 10번 실행.
        while (i < 10) { // 조건절, 조건절이 참일때만 안쪽을 실행한다!
            System.out.println(i++);
        }
        System.out.println("while 루프 끝!");


        // while문이 활용되는 케이스
        // 1. 무한루프문
        // 2. 끝이 정해지지 않은 탐색이 필요할때
        // 3. iterator(반복자)의 패턴을 실행 할 때 ※나중에 실습

        // 133의 3번째 배수는 몇인가?
        int count = 0; // 몇번째 배수인가를 세는 변수
        i = 0;
        while (true) {
            i++;
            if (i % 133 == 0) { // 133의 배수를 찾았을때
                count++;
                if (count == 3) {
                    System.out.println(i);
                    break;
                }
            }
        }
        System.out.println(133 * 3);
    }

    // doWhile은 잘 안쓴다.
    // doWhile은 최초 한번은 무조건 실행되는 반복문, 이후에는 조건절에 따라 실행 된다.
    private static void testDoWhileLoop() {
        int i = 0;
        do {
            System.out.println(i++);
        } while (i < 10);
        System.out.println("do-while문 끝!");

        i = 100;
        do {
            System.out.println("최초 한번은 실행되는 문장!");
        } while (i < 10);
    }


    // for문 : 개발자가 가장 많이 사용하는 반복문 ★★★★★
    private static void testForLoop() {
        // 아래 패턴을 따라서 손으로 외울때 까지 쳐보는것을 권장

        // 0부터 시작해서 9까지 돌고, 10은 도달하지 않는 for문, 총 10번 반복.
        // ++i, i++ 상관은 없는데, 개발자들이 i++를 선호
        // 보통 증감하는 값은 'i','j','k'순으로 중첩된 반복문에서 사용된다.
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("for문1 끝!");

        // 1 ~ 10까지 도는 반복문을 만들때
        // 패턴 1 -> 추천하지 않는 문법!, 사유 : 배열 index와 일치하지 않아 향후에는 사용되지 않음
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
        System.out.println("for문2 끝!");

        // 패턴2 -> 항상 기본형으로 만들고, i를 조절하여 출력하는 것을 권장
        for (int i = 0; i < 10; i++) { // 0 ~ 9, 10은 안돈다!
            System.out.println(i + 1); // 절대 i++이 아님!!!!
        }
        System.out.println("for문3 끝!");

    }

    // advanced for : 향상된 for 문, 반복이 가능한 자료구조의 요소를 하나씩 가져오는 문장
	// 가능한 자료구조 : 배열, 컬렉션
	// 불가능한 자료구조 : iterator
    private static void testForLoop2() {
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6));
        Set<Integer> set = new TreeSet<>(List.of(1,2,3,4,5,6,7));

        for (int num : array) {
            System.out.print(num + ", ");
        }
        System.out.println();

        for (int num : list) {
            System.out.print(num + ", ");
        }
        System.out.println();

        for (int num : set) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
}














