package com.multi.ex05.enum_exam;

// 상수 이름과 하나의 인자로 구성된 enum
public enum Week2 {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String day;

    Week2(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }
}
