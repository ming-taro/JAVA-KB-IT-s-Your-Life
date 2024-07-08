package com.multi.ex05.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DS02_QueueDequeTest {
    // https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html

    // Queue란?
    // - 선입선출(FIFO)의 구조로 먼저 들어온 값이 먼저 나가는 형태의 자료구조
    // - 서버에서 중요한 자료구조로 버퍼(buffer)로서 트래픽 관리나 성능 관리의 핵심적인 도구로 활용
    // - Queue는 자바에서 성능 튜닝에 대한 가장 핵심적인 도구로 관련된 컬렉션 종류가 가장 많다.
    //   -> Was를 직접 만들던 시절에는 매우 유용했다고 한다. 하지만 지금은...?
    // - 하지만 최근에는 프레임워크 레벨에서 Message Queue나 스케줄 도구를 제공함으로 이로 대체 된다.
    //   ex) Apache Kafka, RabbitMQ, Spring Quartz, Spring batch 등
    // - deque 자료구조와 호환됨으로 deque = queue로 보는것이 일반적

    // 주요한 queue 관련 컬렉션
    // Queue : 컬렉션용 interface로 각 컬렉션의 대표적인 메소드만 가지고 있음 -> 활용X
    // ArrayDeque : 배열 기반의 queue, stack 구성시 활용
    // LinkedList : LinkedList 기반의 queue, stack 구성시 활용 ★★★(코테용)
    // -> Tip. 생각보다 ArrayDeque, LinkedList 성능차이가 많이 나지 않는다.

    // 중요 하지만, 실습하지 않을 컬렉션 (알고만 있자!)
    // ConcurrentLinkedQueue : Concurrent=동시성 관련 큐, Thread safe 하는 특징을 가짐
    // BlockingDeque : Blocking=중지시키는 연산, 일정 조건(큐의 크기)이 성립되면 Block이 발동, 해제를 반복, 기본적으로 Concurrent 하다.
    //                 Thread간 생성자/소비자 패턴으로 활용시에만 유용하다.
    // ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue, SynchronousQueue가 존재
    // DelayQueue : Delayed 구현 필요, Task 구성시 활용하는 컬렉션으로 Delay(지연) 시킬수 있다.

    // -> PriorityQueue.java 참고
    // PriorityQueue : 우선순위 관리하는 큐로 정렬된 상태를 유지할수 있다.
    //                 -> TreeSet과 유사하지만 다르다. PriorityQueue는 중복을 허용한다.

    public static void main(String[] args) {
        // 선언법
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> queue1 = new ArrayDeque<>();
        LinkedList<Integer> queue2 = new LinkedList<Integer>();

        // Queue 기본적 활용
        // 1. add or offer : queue에서 데이터를 삽입하는 방법
        queue.add(1);
        queue.add(2);
        queue.offer(3);
        System.out.println(queue);

        // 2. poll : queue에서 데이터를 꺼내는 방법
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll()); // null이 된다.

        // Deque 활용
        // add류 : 데이터를 
        queue1.add(2);
        queue1.addFirst(1);
        queue1.addLast(3);
        queue1.addLast(4);
        queue1.addLast(5);
        System.out.println(queue1);

        // peek류 : 데이터가 있는지 보는 방법
        System.out.println(queue1.peek());
        System.out.println(queue1.peekFirst());
        System.out.println(queue1.peekLast());

        // 삭제 방법
        queue2.addAll(queue1);
        System.out.println(queue2.poll());
        System.out.println(queue2.pop());
        System.out.println(queue2);
        queue2 = new LinkedList<>(queue1);
        System.out.println(queue2.remove());
        System.out.println(queue2.removeFirst());
        System.out.println(queue2.removeLast());
        System.out.println(queue2);
        queue2 = new LinkedList<>(queue1);
        System.out.println(queue2.remove(4)); // index 삭제
        System.out.println(queue2.remove((Integer)3)); // 객체로 삭제하기 (객체로 up casting되어 해당 객체를 삭제한다)
        System.out.println(queue2);

        // LinkedList 활용시 추가적인 메소드
        queue2 = new LinkedList<>(queue1);
        System.out.println(queue2.get(1));
        queue2.getFirst();
        queue2.getLast();
    }
}
