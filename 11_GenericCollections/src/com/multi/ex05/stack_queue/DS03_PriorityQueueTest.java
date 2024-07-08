package com.multi.ex05.stack_queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DS03_PriorityQueueTest {
    // PriorityQueue=heapQueue
    //  - 우선순위 관리 하는 큐로 정렬된 상태를 유지할수 있다. (내부적으로는 heap)을 사용
    //  - TreeSet과 유사하지만 다르다. PriorityQueue는 중복을 허용한다.
    //  - 그냥 print 하는 경우 정렬된 상태로 보이지 않는다.(배열로 된 heap tree 상태이다.)
    //    -> 반드시 poll을 통해서 값을 꺼내야 정렬된 상태로 만들수 있다.
    //  - https://wayhome25.github.io/cs/2017/04/19/cs-23/
    //  - 코테 문제에서 heap 문제인 정렬된 상태를 유지할때 활용해야 O(nlogn)의 꼴로 알고리즘을 유지한다.

    public static void main(String[] args) {
        // 기존 list로 구현된 정렬된 queue
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(4);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
        Collections.sort(queue);
        System.out.println(queue); // 정렬된 상태 만들기
        System.out.println("-------------------------------------");

        // PriorityQueue를 통해 정렬된 heap queue 만들기
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 오름차순
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(4);
        System.out.println("정렬되어 보이지 않는 상태 : " + priorityQueue); // heap 트리 상태이기 때문에 그냥 출력하면 안됨
        // -> 내부 자료구조로 heap을 사용하고 있으므로 전위나 후위순회를 출력해야 제대로 나온다

        // poll : 우선순위에 따라 값을 가져오는 유일한 방법!!
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
//            System.out.println(priorityQueue.remove()); -> remove로 가져와도 가능하다
        }
        System.out.println("-------------------------------------");

        // peek : 정렬되어 있는 가장 앞에 값을 볼 수 있는 메소드
        priorityQueue.addAll(List.of(1, 4, 2, 3, 4));
        System.out.println("heap : " + priorityQueue); // [1, 3, 2, 4, 4]
        System.out.println("peek : " + priorityQueue.peek());
        priorityQueue.poll(); // poll 1
        System.out.println("peek : " + priorityQueue.peek());
    }
}
