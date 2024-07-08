package com.multi.ex02.list;

import java.util.*;

public class ListBasic3 {
    public static void main(String[] args) {
        // 기본형/ 커스텀 정렬 방법 정리 ★★★★★
        // -> 코테 풀때 매우 중요하므로 아래 문법중 외울 문법을 정해서 반드시 외울것!!!! ★★★★★

        //  1. 컬렉션 기본형 정렬 (String, Integer, Double ...)
        // - Collections.sort or List.sort를 활용하여 정렬 가능
        // - 기본적으로 오름차순으로 정렬할 수 있고, 내림차순 정렬시 몇가지 방법이 존재!
        //   -> 내림차순 필요시 Collections.reverse 활용
        List<Integer> intList = new ArrayList<>(List.of(4, 3, 2, 1, 5));
        Collections.sort(intList);    // 가장 외울만 하다!! ★★★★★
        intList.sort(Integer::compare);
        intList.sort(Comparator.naturalOrder());
        System.out.println("오름차순: " + intList);

        // 내림차순 방법
        Collections.reverse(intList); // 코테용으로 외울만하다 ★★★★★
        System.out.println("내림차순: " + intList);
        // 내림차순 다른 방법들
        intList.sort(Comparator.reverseOrder());
        System.out.println("내림차순: " + intList);

        // 문자열
        List<String> strList = new ArrayList<>(List.of("홍길동", "박길동", "김길동", "홍길순"));
        Collections.sort(strList);
        strList.sort(String::compareTo);
        strList.sort(Comparator.naturalOrder()); // 문자, 숫자 상관 없음
        System.out.println("문자열(오름차순) : " + strList);
        // 내림차순
        strList.sort(Comparator.reverseOrder());
        System.out.println("문자열(내림차순) : " + strList);
        System.out.println("---------------------------------------------------------");

        // 2. 객체 커스텀 정렬 활용하기 ★★★★★
        // - 기본형이 아닌 경우 Comparator, Comparable을 통해 정렬할수 있다.
        // - Java8 이후 lambda 문법을 통해 간략화(?) 되었다.

        List<Member> list = new ArrayList<>();
        list.add(new Member("TestID3", "홍길동3", 44, 11110.1));
        list.add(new Member("TestID4", "홍길동", 21, 143.1));
        list.add(new Member("TestID2", "홍길동2", 22, 100.1));
        list.add(new Member("TestID5", "최길동", 32, 4400.1));
        list.add(new Member("TestID6", "홍길동", 25, 10550.1));
        list.add(new Member("TestID7", "홍길순", 21, 10550.1));
        list.add(new Member("TestID8", "홍길동", 25, 20550.1));
        list.add(new Member("TestID1", "김길동", 25, 10550.1));

        System.out.println("정렬 이전!");
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 1) 객체에서 Comparable을 구현해서 정렬하는 방법 -> 추천 안함!!
        // Comparable을 객체에 직접 구현하고, 1개 기준으로만 정렬시킬 수 있다
        Collections.sort(list);
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 2) Comparator를 통해 정렬하는 방법 ★★★★★
        // - 장점 : 다양한 기준으로 정렬이 가능하다
        // - 단점 : 문법이 어렵다 -> 람다로 외우면 할만하다
        System.out.println("나이순 정렬 시키기");
        // list.sort() 사용법
        // - 고전(1.6)으로 익명 클래스를 통해 Comparator를 구현하는 방법, 외우기 어렵다! 비추!
        list.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                // 커스텀 정렬 구현부
                return Integer.compare(o1.getAge(), o2.getAge());   // o1 -> o2 : 오름차순 (정방향)
//                return Integer.compare(o2.getAge(), o1.getAge()); // o2 -> o1 : 내림차순 (역방향)
            }
        });
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        System.out.println("이름순 정렬하는 방법");
        Collections.sort(list, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 3. 람다식 정렬 방법 (Java8 이상) ★★★★★★
        // - 익명클래스나 함수를 람다식으로 바꿔 쉽게 표현 가능하다.
        // - 방법1 : Comparator 직접 구현 ex : (o1, o2) -> (returnValue) : 람다식 표현
        // - 방법2 : Comparator에서 getter로 정렬순서 정하기 가능
        // - 생소해서 문법 가독성이 살짝 떨어짐 -> 익숙해지면 편하다!
        System.out.println("계좌 잔액순 정렬");

        // 방법1. Comparator 람다식으로 직접 구현
        list.sort((o1, o2) -> Double.compare(o1.getAccount(), o2.getAccount()));
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 방법2. Comparator에서 선언된 객체의 getter를 통해 정렬하기
        list.sort(Comparator.comparingDouble(Member::getAccount)); // 오름차순
        list.sort(Comparator.comparingDouble(Member::getAccount).reversed()); // 내림차순
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 4. Stream(=데이터 처리 용도, Java8 이상)을 통한 정렬
        // - 람다식중 하나인 Stream문법을 통해 정렬하는 방법
        // - parallel를 활용하면 병렬처리되어 매우 빠르게 정렬된다고 한다.
        System.out.println("나이순으로 정렬");
        List<Member> newList1 = list.stream()
                .sorted(Comparator.comparingInt(Member::getAge))
                .toList();
        newList1.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // parallel 활용 문법
        List<Member> newList2 = list.stream().parallel()
                .sorted(Comparator.comparingInt(Member::getAge))
                .toList();
        newList2.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 사용자 커스텀 정렬 활용하기 ★★★★★
        // - 이름-나이-계좌순으로 정렬
        // 1. 정렬을 3번 한다. -> 절대 비추!!!!
        System.out.println("이름-나이-계좌순 정렬1");
        list.sort(Comparator.comparingDouble(Member::getAccount));
        list.sort(Comparator.comparingInt(Member::getAge));
        list.sort(Comparator.comparing(Member::getName));
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 2. 익명 클래스 (람다식) ★★★★★ 외워라!!
        System.out.println("이름-나이-계좌순 정렬2");
        list.sort((o1, o2) -> {
            int result = o1.getName().compareTo(o2.getName());
            if (result == 0) {
                result = o1.getAge() - o2.getAge(); // Integer.compare(o1.getAge(), o2.getAge());
            }
            if (result == 0) {
                result = Double.compare(o1.getAccount(), o2.getAccount());
            }
            return result;
        });
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 3. 스트림을 통해 한 줄로 표현
        System.out.println("이름-나이-계좌순 정렬3");
        list.sort(Comparator.comparing(Member::getName).thenComparingInt(Member::getAge).thenComparingDouble(Member::getAccount));
        list.forEach(System.out::println);
    }
}
