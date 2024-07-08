package com.multi.ex05.enum_exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _Run {
    public static void main(String[] args) {
        // 선언하는 방법
        EnumBasic enumValue = EnumBasic.VALUE2;
//        EnumBasic enumValue = EnumBasic.valueOf("VALUE2"); // enum에 존재하지 않는 경우 error 발생

        // 출력 방법
        System.out.println(enumValue);                  // toString
        System.out.println(enumValue.name());           // 상수 이름
        System.out.println(enumValue.ordinal());        // 상수 선언 순서
        System.out.println(enumValue.getStringValue()); // getter
        System.out.println(enumValue.getIntValue());

        // 순회 방법, ※ 주의점 : 배열을 생성하여 호출함으로 성능 저하가 발생할 수 있다!
        // -> 성능 개선을 위해 map을 활용하는 것을 권장!
        for (EnumBasic e : EnumBasic.values()) {
            System.out.println(e.name());
        }

        // 비교하는 방법
        EnumBasic enumValue1 = EnumBasic.VALUE1;
        EnumBasic enumValue2 = EnumBasic.VALUE2;

        // equals 로도 비교 가능!
        System.out.println(enumValue1 == EnumBasic.VALUE1);    //true
        System.out.println(enumValue1 == enumValue2);          //false

        // compareTo로 비교하는 방법 -> 정렬할 때 활용!
        System.out.println(enumValue1.compareTo(EnumBasic.VALUE1));  // 0
        System.out.println(enumValue1.compareTo(enumValue2));        // 1

        // Week
        System.out.println(Arrays.toString(Week1.values()));
        System.out.println(Arrays.toString(Week2.values()));
        System.out.println(Arrays.toString(Week3.values()));

        // Collection의 type으로 활용 가능
        List<Week3> list = new ArrayList<>();
        list.add(Week3.TUESDAY);
        list.add(Week3.MONDAY);
        list.add(Week3.THURSDAY);
        list.add(Week3.SUNDAY);
        System.out.println(list);

        // 자연 order로 정렬하기 (선언한 순서) -> (월, 화, 수, ...)
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        // 사용자 order로 정렬하기 -> (일, 월, 화, ..)
        list.sort((o1, o2) -> o1.getOrder() - o2.getOrder());
        System.out.println(list);
    }
}
