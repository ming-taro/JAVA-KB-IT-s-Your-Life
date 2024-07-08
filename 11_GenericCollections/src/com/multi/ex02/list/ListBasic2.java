package com.multi.ex02.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListBasic2 {

    // 컬렉션 계열의 메소드 활용법 정리
    public static void main(String[] args) {
        // 1. List 선언법
        List<Integer> intList = new ArrayList<>();
        LinkedList<String> stringList = new LinkedList<>();
        List<Member> list = new ArrayList<>();
        LinkedList<Member> list2 = new LinkedList<>();

        // 1. add : 데이터를 삽입하는 메소드
        // 기본형
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.forEach(System.out::println);
        System.out.println("------------------------------------------");

        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.forEach(System.out::println);
        System.out.println("------------------------------------------");

        // 객체형 추가
        list.add(new Member("TestID3", "홍길동3", 44, 11110.1));
        list.add(new Member("TestID4", "홍길동", 21, 143.1));
        list.add(new Member("TestID2", "홍길동2", 22, 100.1));
        list.add(new Member("TestID5", "최길동", 32, 4400.1));
        list.add(new Member("TestID6", "홍동길", 25, 10550.1));
        list.add(new Member("TestID7", "홍길순", 21, 10550.1));
        list.add(new Member("TestID8", "홍길동", 25, 20550.1));
        list.add(new Member("TestID1", "김길동", 25, 10550.1));
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 2. addAll : 컬렉션을 모두 추가 시킬 때 사용
        list2.addAll(list); // list에 있던 값이 list2로 모두 추가된다
        list2.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        // 3. add 메소드의 index 활용 방법
        list.add(0, new Member("TestID9", "홍길동9", 24, 121212));
        // -> 0번째 인덱스에 추가되고, 기존 값들은 index + 1로 밀려나가는 문법
        list.forEach(System.out::println);
        // ※ 주의점 : 기존 size보다 값이 큰경우 에러가 발생한다!!
        // java.lang.IndexOutOfBoundsException: Index: 12, Size: 9 -> index 범위를 벗어났다
        // list.add(12, new Member("TestID9", "홍길동9", 24, 121212));
        // 가장 마지막 index에 추가하는 방법
        list.add(list.size() - 1, new Member("TestID9", "홍길동9", 24, 121212));
        System.out.println("---------------------------------------------------------");

        // LinkedList인 경우는 addFirst addLast가 추가적으로 있다
        list2.addFirst(new Member("TestID9", "홍길동9", 24, 121212));
        list2.addLast(new Member("TestID9", "홍길동9", 24, 121212));

        // 4. size() : 크기를 알아오는 방법
        System.out.println(list.size());
        System.out.println(list2.size());
        System.out.println("---------------------------------------------------------");

        // 5. get() : index를 통해 값을 가져오는 방법
        Member member = list.get(0);
        System.out.println(member);
        System.out.println(list.get(3));
        System.out.println(list.get(3).getName());
        System.out.println("---------------------------------------------------------");

        // 6. contains : 특정 객체가 list에 존재하는지 확인하는 메소드 (boolean)
        // -> ※ 주의 : 비교할 객체에 equals가 구현되어 있어야 제대로 활용 가능!!
//        Member member1 = list2.get(0); // 같은 주소지를 가지는 객체를 주소지로 비교한 사례
        Member member1 = new Member("TestID3", "홍길동3", 44, 11110.1); // new로 만들어서 새로운 객체가 생성됨 -> equals를 오버라이드해야 비교가 가능하다
        System.out.println(list.contains(member1));
        System.out.println("---------------------------------------------------------");

        // list에 특정 이름을 가지는 사람 찾는 방법 -> 반복문으로 구현
        for (Member m: list) {
            if (m.getName().equals("홍길동")) {
                System.out.println("홍길동 : " + m);
            }
        }
        System.out.println("---------------------------------------------------------");

        list.forEach(m -> {
            if (m.getName().equals("홍길동")) {
                System.out.println("홍길동 : " + m);
            }
        });
        System.out.println("---------------------------------------------------------");

        // 7.remove : 특정 객체 삭제하는 방법, 삭제된 객체는 반환!
        // index로 삭제
        Member removeMember = list.remove(3); // 4번째 사람 삭제
        System.out.println(removeMember);

        // 객체로 삭제
        Member removeMember1 = list.remove(0);
        boolean result = list.remove(removeMember1);
        System.out.println(result);
        System.out.println("---------------------------------------------------------");

        // 8. clear() : 데이터 모두 삭제
//        list.clear();
//        list = null;
//        list = new ArrayList<>();
        System.out.println(list);
        System.out.println("---------------------------------------------------------");

        // 9. indexOf : 객체에 해당되는 index 반환
        System.out.println(list.indexOf(member));
        System.out.println("---------------------------------------------------------");

        // 10. isEmpty : 비었는지 확인하는 방법
        System.out.println(list.isEmpty());
        System.out.println(list.size() == 0);
        System.out.println("---------------------------------------------------------");

        // 11. set : 추가가 아닌 교체!! ★
        Member setMember = list.get(3); // 3 -> 0으로 복사
//        setMember.setName("박수정"); // -> 이 상태면 이미 수정된 상태
        System.out.println("변경 전");
        System.out.println(list.get(0));
        System.out.println();
        System.out.println("변경 후");
        list.set(0, setMember);
        System.out.println(list.get(0));
        System.out.println("---------------------------------------------------------");

        // 12. subList : 자르기 용도
        List<Member> list3 = list.subList(0, 3); // 0~3까지 자르기
        System.out.println(list3.size());
        System.out.println(list3);
    }
}
