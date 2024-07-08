package com.multi.ex04.map;

import java.util.*;

public class MapBasic3 {
    public static void main(String[] args) {
        // ID가 중복이 되어도 HashMap으로 유지하는 방법

        List<Member> list = new ArrayList<Member>();
        list.add(new Member("testID1", "김길동1", 21, 10000.123));
        list.add(new Member("testID1", "황길동2", 31, 10000.123));
        list.add(new Member("testID1", "충길동3", 51, 10000.123));
        list.add(new Member("testID2", "홍길동1", 61, 3300.123));
        list.add(new Member("testID2", "고길동2", 32, 10000.123));
        list.add(new Member("testID2", "박길동3", 22, 10000.123));
        list.add(new Member("testID3", "이길동1", 13, 444000.123));
        list.add(new Member("testID3", "김길동2", 23, 444000.123));
        list.add(new Member("testID3", "홍길동3", 33, 444000.123));

        // 2가지 방법
        // 1. key + 다른값을 조합하여 새로운 ID를 만들어 낸다. -> 살짝 꼼수적인 느낌
        //  - id + 객체의 hashcode <- 그나마 안전 (hashcode는 중복될 수 있음)
        //  - id + name을 하여 새로운 key값으로 분류한다.
        //  - id 기준으로 같은 사용자를 뽑거나 그럴때 알고리즘이 들어간다는 문제점 있음
        //    -> 문제점은 완벽하지 않다는 것!!

        // 2. Map + List를 결합하여 컬렉션을 이중으로 설계하는 방법 ★★★★★
        //  - key기준으로 List를 생성하여 설계하면 된다.
        //  - map + set + list 이런식으로 3중 ~ 4중 컬렉션 조합도 발생하는 경우가 있다.

        //    key        value
        Map<String, List<Member>> listMap = new TreeMap<>();

        // 1. 기본적인 초기화 방법
        for (Member member : list) {
            String key = member.getId();
            // list가 생성되지 않은 경우 초기화 하는 문장
            if (listMap.get(key) == null) {
                listMap.put(key, new ArrayList<>());
            }
            listMap.get(key).add(member);
        }
        System.out.println(listMap);
        System.out.println("------------------------------------------");

        // 순회하는 방법
        Set<String> keySet = listMap.keySet();
        for (String key : keySet) {
            System.out.println("key: " + key);
            List<Member> mList = listMap.get(key);
            for (Member member : mList) {
                System.out.println("\t" + member);
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");

        // 2. 발전된 초기화 방법
        listMap = new TreeMap<>();
        for(Member m : list){
            List<Member> mList = listMap.getOrDefault(m.getId(), new ArrayList<Member>());
            mList.add(m);
            listMap.put(m.getId(), mList);
        }

        // 출력하는 방법
        keySet = listMap.keySet();
        for(String key : keySet) {
            System.out.println("key : " + key);
            List<Member> mlist = listMap.get(key);
            for(Member m : mlist) {
                System.out.println("\t" + m);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
    }
}
