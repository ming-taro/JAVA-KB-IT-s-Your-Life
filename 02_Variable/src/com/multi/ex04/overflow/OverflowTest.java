package com.multi.ex04.overflow;

public class OverflowTest { // Overflow = 홍수, 흘러넘침

    public static void main(String[] args) {
        byte temp = 125; // temp = 일반적인 임시 변수 명칭
        System.out.println(++temp); // temp = temp + 1, 126?
        System.out.println(++temp); // 127
        System.out.println(++temp); // 128X -> -128
        System.out.println(++temp); // 129X -> -127
        System.out.println(++temp); // 130X -> -126
        // 의도치 않은 overflow 발생!!
        // 해결법 : 개발자 알아서 적절한 범위의 변수를 선택하거나 casting의 해야한다.
        // Tip. 적절하게 큰 범위의 type을 사용한다. byte short 굳이 사용하지 않는다. ★

        // byte 범위 : -128, 0, 127
        for(byte i = 0; i < 300; i++) {
            System.out.println(i);
        }
    }

}