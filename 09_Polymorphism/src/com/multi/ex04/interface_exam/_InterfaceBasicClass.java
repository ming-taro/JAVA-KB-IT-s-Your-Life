package com.multi.ex04.interface_exam;

public class _InterfaceBasicClass implements _InterfaceBasic {
    @Override
    public void abstractMethod1() {
        System.out.println("abstractMethod1 " + STATIC_VALUE1);
    }

    @Override
    public void abstractMethod2() {
        System.out.println("abstractMethod2 "  + STATIC_VALUE2);
    }

    public static void main(String[] args) {
        _InterfaceBasicClass obj = new _InterfaceBasicClass();
        obj.abstractMethod1();
        obj.abstractMethod2();
        obj.defaultMethod();
        System.out.println(_InterfaceBasic.STATIC_VALUE1);
        System.out.println(_InterfaceBasic.STATIC_VALUE2);
    }
}
