package com.multi.ex06.anotation_exam;

// 어노테이션을 사용할 Class

//@AnotaionBasic // 사용자 입력값은 없고 어노테이션만 붙은 상태, default 값이 초기화 됨
//@AnotaionBasic("test") // value에 test값이 들어옴
//@AnotaionBasic(values = "test")  // values(배열)에 하나의 인자만 넣을 때
//@AnotaionBasic(values = { "test1", "test2" })  // values(배열)에 여러개를 넣을 때
@AnotaionBasic(number = 5, value = "test", values = { "1", "2", "3" })
public class Service {
    @AnotaionBasic
    @PrintAnnotation
    public void method1() {
        System.out.println("method1 실행");
    }

    public void method2() {
        System.out.println("method2 실행");
    }

    @PrintAnnotation(value = "#", number = 20)
    public void method3() {
        System.out.println("method3 실행");
    }
}
