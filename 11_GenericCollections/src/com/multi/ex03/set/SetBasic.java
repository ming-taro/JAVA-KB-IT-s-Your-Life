package com.multi.ex03.set;

import java.util.*;

public class SetBasic {
    // Set : 중복된 데이터를 허용하지 않는 컬렉션

    // TreeSet : 중복된 데이터를 허용하지 않고, 데이터가 정렬됨 ★★★
    //           -> Comparable 또는 Comparator를 사용하여 정렬, 중복도 제거
    // LinkedHashSet : Hash코드 기준으로 중복을 제거, 들어온 순서가 보존
    //         -> hashCode()을 사용함
    // HashSet : Hash코드 기준으로 중복을 제거, 아무 순서도 보장되지 않음 -> 제일빠르다. ★
    //           -> hashCode()을 사용함
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();   // [김길동, 박길동, 홍길동] 사전순
//        Set<String> set = new HashSet<>();   // [박길동, 김길동, 홍길동] 랜덤
//        Set<String> set = new LinkedHashSet<>(); // [홍길동, 박길동, 김길동] 입력순

        // TreeSet 같은 경우는 고유 메소드가 많아 type으로 선언하는 것이 유리
//        TreeSet<String> treeSet1 = new TreeSet<>(Comparator.reverseOrder());
        TreeSet<String> treeSet1 = new TreeSet<>(Comparator.naturalOrder());
        TreeSet<String> treeSet2 = new TreeSet<>((o1, o2) -> o1.compareTo(o2));

        // add : 데이터 넣기, 중복된 데이터는 제거됨
        set.add("홍길동");
        set.add("박길동");
        set.add("김길동");
        set.add("홍길동");
        System.out.println(set);
        System.out.println("----------------------------------------------");

        // addAll : 컬렉션 넣기
        treeSet1.addAll(set);
        treeSet2.addAll(new ArrayList<>(List.of("홍길동", "박길동", "김길동")));
        System.out.println(treeSet1);
        System.out.println(treeSet2);
        System.out.println("----------------------------------------------");

        // set 순회하는 방법
        // 1. 반복문 -> 일반 for 문은 안됨
        System.out.println("1. 반복문 -> 일반 for 문은 안됨");
        for (String s : treeSet1) {
            System.out.println(s);
        }

        // 2. 리스트로 변환 이후 순회
        System.out.println("2. 리스트로 변환 이후 순회");
        List<String> strList = new ArrayList<>(set);
        strList.forEach(System.out::println);

        // 3. iterator(반복자) -> 비추!! 과거 문법
        System.out.println("3. iterator(반복자)");
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("----------------------------------------------");

        // 객체 set 활용 << 어려운 영역!!
        // -> 객체를 살짝 개조해야 객체 set을 활용할 수 있다
        Set<Member2> treeSet = new TreeSet<>();
        Set<Member2> hashSet = new HashSet<>();
        Set<Member2> linkedHashSet = new LinkedHashSet<>();

        List<Member2> list = new ArrayList<>();
        list.add(new Member2("testID1", "김길동1", 21, 10000.123));
        list.add(new Member2("testID1", "김길동1", 21, 10000.123));  // 완전동일
        list.add(new Member2("testID3", "김길동3", 23, 444000.123));
        list.add(new Member2("testID2", "홍길동3", 41, 3300.123));   // ID 만 다름
        list.add(new Member2("testID2", "김길동2", 22, 10000.123));

        // 1. set에 데이터 추가하기
        treeSet.addAll(list);       // 컬렉션으로 추가
        for (Member2 m : list) { // 반복문
            hashSet.add(m);
        }
        list.forEach(m -> linkedHashSet.add(m)); // 람다

        // 결과 print
        System.out.println("----------------------------------------------");
        System.out.println("treeSet : " + treeSet.size() + " " +  treeSet);                   // 3, Comparable로 id가 필터링됨
        System.out.println("hashSet : " +  hashSet.size() + " " +  hashSet);                  // 4, hashCode를 기준으로 id가 필터링 됨 (hash코드가 구현되어있지 않으면 필터링 되지 않음)
        System.out.println("linkedHashSet : " + linkedHashSet.size() + " " +  linkedHashSet); // 4, hashCode를 기준으로 필터링
        System.out.println("----------------------------------------------");

        // 2. 순회하는 방법
        // 1) for문으로 순회
        System.out.println("treeSet 순회");
        for(Member2 m : treeSet) {
            System.out.println(m);
        }
        System.out.println("----------------------------------------");

        // 2) Iterator(반복자) 활용, 전통적인 방법 ★★
        System.out.println("hashSet 순회");
        Iterator<Member2> iter2 = hashSet.iterator();
        while(iter2.hasNext()) { // hasNext : 다음 값이 있는 경우에만 true
            Member2 m = iter2.next(); //next : 다음 데이터값을 가져오는 메소드, 한번만 가져와야한다.
            System.out.println(m);
        }
        System.out.println("----------------------------------------");

        // 3) 람다식 순회
        System.out.println("linkedHashSet 순회");
        linkedHashSet.forEach((m) -> System.out.println(m));
        System.out.println("----------------------------------------");

        // equals 실험
        // - 객체에 equals가 구현되지 않은 경우 객체 고유주소로 확인함으로 객체 내용은 달라도 주소가 달라 같지 않다고 나옴
        // - 객체 단위로 값을 비교하기 위해선 equals 구현 필요. -> IDE의 자동생성 활용
        Member2 m1 = new Member2("testID1", "김길동1", 21, 10000.123);
        Member2 m2 = new Member2("testID1", "김길동1", 21, 10000.123);
        if(m1.equals(m2)) {
            System.out.println("같다!");
        }else {
            System.out.println("틀리다!");
        }
        System.out.println("---------------------------------------------");

        // contains : 객체가 있는지 확인하는 방법
        System.out.println(treeSet.contains(m1));
        m1.setId("test333");
        System.out.println(treeSet.contains(m1));

        // remove : 객체 단위로 삭제하는 방법
        System.out.println(treeSet.remove(m2));
    }
}