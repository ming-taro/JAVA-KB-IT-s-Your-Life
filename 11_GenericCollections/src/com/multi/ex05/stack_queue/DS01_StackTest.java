package com.multi.ex05.stack_queue;

import java.util.*;

public class DS01_StackTest {
    // Stack이란?
    // - 선입후출(FILO)의 구조로 먼저 들어온 값이 가장 늦게 나가는 자료구조
    // - 서버/응용 프로그래밍적으로 Stack을 직접 활용하는 경우는 거의 없다.
    // - 알고리즘 or 코딩테스트 용도로 주로 활용한다.
    // - Stack을 직접 선언해서 사용하기 보단 Deque을 stack으로 활용하는 것이 실용적이다.

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Deque<Integer> stack2 = new LinkedList<>();
        Deque<Integer> stack3 = new ArrayDeque<>();

        // push : 스택에 값 넣기
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        System.out.println(stack1);

        // pop : 스택에서 값 꺼내기
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
//        System.out.println(stack1.pop()); // 에러 발생!!

        stack2.addAll(Arrays.asList(1, 2, 3, 4));
        while (!stack1.empty()) {
            System.out.println(stack2.pop());
        }
    }

}
