package com.multi.ex04.map;

import java.util.*;

public class MapBasic {
    // Map이란?
    // Key - Value로 데이터가 구성되어 있는 컬랙션
    // Key는 주로 숫자나 문자 활용, Value는 객체를 활용
    // Key 기준으로만 중복확인함 -> Comparable, equals 필요 없음!

    // HashMap       : 순서 보장 안되고, 제일 빠른 성능, 가장 많이 사용하는 Map. ★★★★★
    // LinkedHashMap : Key의 삽입순서 보장 ★
    // TreeMap       : Key의 순서대로 정렬, 고유 메소드가 몇개 존재한다. ★★★
    // HashTable     : HashMap Thread Safe Version ★
    // ConcurrentHashMap : Thread safe한 버전의 map인데 가끔 현업에서 사용 ★★★

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("키", "값");
        map.put("PK", "ROW");     // DB
        System.out.println(map);
        System.out.println(map.get("key"));
        System.out.println(map.get("키"));
        System.out.println(map.get("PK"));
        System.out.println("---------------------------------");

        // 객체 활용법
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member("testID1", "김길동1", 21, 10000.123));
        list.add(new Member("testID1", "김길동1", 21, 10000.123)); // 완전동일
        list.add(new Member("testID3", "김길동3", 23, 444000.123));
        list.add(new Member("testID2", "홍길동3", 41, 3300.123)); // ID 만 다름
        list.add(new Member("testID2", "김길동2", 22, 10000.123));

        // 선언법
        //    key   value
//        Map<String, Member> hashMap = new HashMap<>(String, Member); // 1.6 이전 문법
        Map<String, Member> hashMap = new HashMap<>();
        LinkedHashMap<String, Member> linkedHashMap = new LinkedHashMap<>();
        TreeMap<String, Member> treeMap = new TreeMap<>();

        // put : 데이터 넣는 메소드
        for (Member member : list) {
            hashMap.put(member.getId(), member);
        }
        for (int i = 0; i < list.size(); i++) {
            linkedHashMap.put(list.get(i).getId(), list.get(i));
        }
        list.forEach(m -> treeMap.put(m.getId(), m));

        // 순회하는 방법
        System.out.println("hashMap");
        System.out.println(hashMap);
        hashMap.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());
        System.out.println(hashMap.size());
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.get("testID1"));   // 있는 값
        System.out.println(hashMap.get("testID112")); // 없는 값 -> null
        System.out.println("---------------------------------");


        // 순회하는 방법
        System.out.println("LinkedHashMap");
        System.out.println(linkedHashMap);
        linkedHashMap.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println(linkedHashMap.keySet());
        System.out.println(linkedHashMap.values());
        System.out.println(linkedHashMap.size());
        System.out.println(linkedHashMap.isEmpty());
        System.out.println(linkedHashMap.get("testID1"));   // 있는 값
        System.out.println(linkedHashMap.get("testID112")); // 없는 값 -> null
        System.out.println("---------------------------------");

        // 순회하는 방법
        System.out.println("TreeMap");
        System.out.println(treeMap);
        treeMap.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println(treeMap.keySet());
        System.out.println(treeMap.values());
        System.out.println(treeMap.size());
        System.out.println(treeMap.isEmpty());
        System.out.println(treeMap.get("testID1"));   // 있는 값
        System.out.println(treeMap.get("testID112")); // 없는 값 -> null
        System.out.println("---------------------------------");
    }
}
