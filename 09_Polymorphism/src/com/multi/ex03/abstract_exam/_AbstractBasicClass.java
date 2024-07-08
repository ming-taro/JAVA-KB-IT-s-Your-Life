package com.multi.ex03.abstract_exam;

public class _AbstractBasicClass extends _AbstractBasic {
    @Override
    public void abstractMethod() {
        System.out.println("abstractMethod!!!");
    }

    public static void main(String[] args) {
        _AbstractBasicClass test = new _AbstractBasicClass();
        test.abstractMethod();
    }
}
