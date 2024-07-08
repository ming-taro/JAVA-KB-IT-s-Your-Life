package com.multi.ex02.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ListBasic {
    // https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
    // 컬렉션(Collection)이란?
    // - 컬렉션 자바에서 기본적으로 제공하는 자료구조와 알고리즘을 담당하는 library
    // - 사용자가 별도의 알고리즘을 구현하지 않고, 미리 구현된 구조를 재사용하여 활용
    // - 편리성도 좋지만, 내부적으로 알고리즘 효율도 좋으므로 웬만하면 컬렉션을 활용하는 것이 표준
    
    //  ArrayList - ★★★★★ 추천
    //   -> 필드에서는 주로 ArrayList '만' 사용하는데, (심지어 type으로 통일!!)
    //      이유는 DB에서 데이터를 담고 탐색 용도로 많이 활용하기 때문이다.
    //  - 장점 : 탐색속도가 빠르고, 메모리를 적게 차지한다. 
    //  - 단점 : 삽입, 삭제, 수정이 느리다. 
    
    //  LinkedList -> 일반적으로 활용하지 않고 stack, queue, deque으로 활용한다.
    //   -> 삽입 삭제가 빈번하지 않으면 사용하지 않음. -> 이럴 경우가 많이 없거나 다른 컬렉션(Map)을 사용함
    //  - 장점 : 삽입, 삭제, 수정이 빠르다.
    //  - 단점 : 탐색속도가 느리고, 메모리를 많이 차지한다. << 단순 list의 최악의 효율
    
    //  Vector
    //  -> Thread safe 할때 사용하나 일반적으로 그냥 list를 동기화시 활용할리 없다. 그냥 알아만 두자.

    public static void main(String[] args) {
        // 객체배열 문법
        Member[] memberArray = new Member[3];
        memberArray[0] = new Member("testID1", "김길동", 23, 60000.212);
        memberArray[1] = new Member("testID2", "홍길동", 32, 53123.233);
        memberArray[2] = new Member("testID3", "박길동", 25, 41212.322);
//      memberArray[3] = new Member("testID4", "박길동", 25, 41212.322);

        // 배열의 단점
        // 1. 배열의 크기를 지정해야하고, 크기보다 커지면 새로운 배열을 생성하고 복사 필요
        // 2. 중간에 데이터 삽입/삭제가 어렵다. -> 반드시 빈데이터를 메꿔야한다!
        // 3. 복사도 어렵고, 사용자 실수가 많았다.
        // 결론 : 프로그래머라면 누구든 고통 받았다.

        // List 사용법
        // 1. 초기화 문법
        // - 정석적인 사용법은 List<E>로 type을 선언하는 것이지만, ArrayList<E>로 사용하는 사람도 많다
        List<String> strList = new ArrayList<String>();      // 문자열 List, 뒤에 type 생략 안한 문법
        List<Integer> intList = new ArrayList<>();           // 숫자 List, 정석적인 생략 문법
        ArrayList<Member> memberList = new ArrayList<>();    // 컬렉션의 고유 이름이 생략되지 않은 버전
        LinkedList<Member> memberList2 = new LinkedList<>(); // LinkedList 고유 메소드가 많아 생략하지 않는
        memberList2.addFirst(null); // addFirst : LinkedList 고유 메소드

        // 강사가 권장하는 패턴
        List<Member> list = new ArrayList<>();

        // 2. 그냥 인자를 넣는 방법 or 배열에서 list로 변환하는 방법
        // 1) Arrays.asList()나 List.of를 활용, ※ immutable list(읽기 전용!)으로 생성된다.
        List<String> strList2 = List.of("A", "B", "C");   // immutable, 추가, 수정, 삭제 불가!
        List<Member> mList = Arrays.asList(memberArray);  // immutable, 추가, 수정, 삭제 불가!

//        strList2.add("D"); // error: ImmutableCollections, java.lang.UnsupportedOperationException
//        mList.add(new Member("test7", "박길동", 31, 302021.2));

        // 수정한 가능한 컬렉션(mutable)으로 선언하는 방법
        List<String> strList3 = new ArrayList<>(List.of("A", "B", "C"));   // mutable, 추가/수정/삭제 가능
//        List<Member> mList2 = new ArrayList<>(List.of(memberArray));     // OK!
        List<Member> mList2 = new ArrayList<>(Arrays.asList(memberArray)); // OK!

        strList3.add("D");
        mList2.add(new Member("test7", "박길동", 31, 302021.2));
        System.out.println(strList3);
        System.out.println("mList2 : " +  mList2 + "\n");

        // 2) 고전적인 알고리즘 활용 방법
        List<Member> mList3 = new ArrayList<>();

        // Advanced for loop
        for (Member member : mList) {
            mList3.add(member);
        }
        System.out.println("mList3 : " + mList3 + "\n");

        // 2) 고전적인 알고리즘 활용 방법
        // index for loop
        List<Member> mList4 = new ArrayList<>();
        for (int i = 0; i < memberArray.length; i++) {
//          mList4.add(memberArray[i]);    // 그냥 해도 된다
            mList4.add(i, memberArray[i]); // index를 포함한 add
        }
        System.out.println("mList4 : " + mList4 + "\n");
        System.out.println("-------------------------------------");

        // List 출력하는 방법 + 순회하는 방법
        // - List는 toString을 활용하면 객체 정보를 모두 볼 수 있다 -> 그냥 출력하면 된다
        System.out.println(mList4);
        System.out.println("-------------------------------------");
        System.out.println(mList4.toString().replace("}", "}\n"));

        // 순회하면서 출력하는 방법
        // 기본적인 for문
        for (Member member : mList4) {
            System.out.println(member);
        }
        System.out.println("-------------------------------------");

        // index를 활용한 for문
        for (int i = 0; i < mList4.size(); i++) {
            System.out.println(mList4.get(i));
        }
        System.out.println("-------------------------------------");

        // 스트림 문법(Java8 이후)
        // 1) 익명 클래스로 Consumer를 생성해서 활용하는 방법 -> 권장X
        mList4.forEach(new Consumer<Member>() {
            @Override
            public void accept(Member member) {
                System.out.println(member);
            }
        });
        System.out.println("-------------------------------------");

        // 2) Consumer를 람다식으로 변환하여 출력하는 방법 -> 올바른 방법 ★★★★★
        mList4.forEach((member) -> System.out.println(member));
        System.out.println("-------------------------------------");
        // 3) Consumer + stream 문법을 통해 출력하는 방법 ★★★★★
        mList4.forEach(System.out::println);
        System.out.println("-------------------------------------");
    }
}
