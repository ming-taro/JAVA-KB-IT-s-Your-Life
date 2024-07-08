// Java 언어의 특징
// - 철저한 객체지향 언어로 모듈화(.class, .jar)가 매우 보편적인 언어
// - 문법과 메모리 관리가 굉장히 strict(엄격)하여 이를 지키지 않은 경우 에러 발생(프로세스 종료!)
// - 캡슐화가 가능 하도록 접근 제한자를 제공하며, 이로써 보안적 강점을 가짐
// - 일반적인 다중상속을 지원하지 않으며, 다중상속이 필요한 경우 interface를 통해 제한적으로 가능

// JVM(Java Virtual Machine)의 이해
// - 실제 java를 실행 시키는 프로그램(명령)으로 내부적으로는 C++로 구성되어 있음
//   -> Java와 C, C++언어를 호환시키는 기술도 존재 (JNI, Java Native Interface)
// - OS별로 존재하며, OS별 각기 다른 kernel 명령을 번역, java가 멀티플랫폼이 될수 있는 원리
// - .java 파일을 컴파일한 .class를 인터프리터로 해석하여 실시간으로 실행하는 원리
// - 메모리 관리를 위해 GC(Garbage Collection)을 가지고 있으며, 사용하지 않는 메모리를 자동 정리

// 패키지명 : 폴더 구분 또는 소스 코드 그룹핑 용도
// - 폴더에 들어가는 이름은 모두 소문자!
// - 마지막 Class 명은 첫글자는 대문자로 시작하는 카멜표기법으로 표기
// - 패키지명은 보통 회사명 + 프로젝트 별칭으로 구성된다.
// com.kb.myproject.view.MyView
// com.kb.myproject.model.MyDataVO
package com.kb;


// import : 외부 패키지를 가져오는 명령어
// F4를 누르면 소스코드 위치로 이동!
// -> 돌아올땐 alt + <-, 또는 마우스 5키 중에 뒤로가기
// import java.util.*;
// * : 모든 모듈 임포트용도, 사용하지 않는 모듈을 모두 임포트함으로 좋지않다고한다.
//  -> import java.util.*;는 코테 용도로 외워라!!!
// import java.util.Date; // 정상적인 import 문, 사용할 모듈만 임포트


// 주석 작성법
// - 최근 주석은 코드를 설명하는 용도로 달지 않길 권장. -> 가급적 제거하는 방향이 좋음
// - 단, 학습용으로는 많이 사용하길 권장!
// 1. '//'로 시작하는 방법, 한줄 주석
// 2. '/* */'로 주석의 시작과 끝을 알리는 방법
// 3.  주석 다는 단축키 활용 : ctrl + /  -> shift로 선택된 범위가 주석이 된다.

// 한줄 주석다는 방법
/* 시작과
 * 끝으로 분리되는 주석
 */

// javadoc용 주석

import java.util.Date;

/**
 * 해당 파일의 javadoc을 생성하기 위한 주석
 * 자동완성으로 활용하는 것이 일반적
 * javadoc 플러그인 설치 이후 shift + alt + G로 자동생성됨
 */

// Class 이름을 지칭하는 곳, 'public class'가 파일의 이름과 일치해야한다.
// -> 일치 하지 않은 경우 에러가 발생!!
// class 이름을 바꾸고 싶으면 shift + F6 단축키 추천
public class MyFirstClass {

    // main : 프로그램의 시작 경로 -> c언어의 진짜 main이 아닌 JVM이 실행시켜주는 위치이다.
    // ※ 주의 : main은 반드시 'public static void main(String[] args)'이어야 한다.
    // class당 하나만 존재할수 있다.

    // 'main'을 입력하거나 psvm를 입력하여 자동완성
    // String[] args -> java 명령어로 실행할때 외부 인자가 넣어지는 자리
    public static void main(String[] args) {

        // 프로그램 실행 방법 2가지
        // 1. run(재생) 버튼
        // 2. shift + F10(실행) // F9(디버깅)

        // ctrl + space : 자동완성
        // ctrl + shift + space : 스마트 자동완성(?)
        // tab : hint 자동완성
        String str = "Hello World";

        // sout -> System.out.println(); 자동완성
        System.out.println(str);
        System.out.println("Hello Java World!!"); // println : 한문장 출력이후 line = 줄넘김
        System.out.print("Hello Java World!!"); // print : 한문장 출력이후 줄넘김 없음!!
        System.out.println("Hello Java World!!");

        // fori : for문에서 i 들어가는거
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // iter : advanced for문 완성
        for (String arg : args) {
            System.out.println(arg);
        }

        // 오류 고치는 방법
        // 1. 마우스로 오류(에러, 빨간줄) 위에 위치하면 인텔리제이가 자동으로 팁을 준다.
        //      -> 해결까지 가능하다.
        // 2. alt + enter -> quick fix!
        //    임포트 최적화 : ctrl + shift + o
        System.out.println(new Date()); // 빨간색 코드는 오류
//      System.out.println(new Integer(10)); // deprecated

        // 자주 사용하는 단축키 모음
        // https://insertintoblog.tistory.com/5
        // https://rebornbb.tistory.com/entry/intelliJ-intelliJ-%EC%9C%88%EB%8F%84%EC%9A%B0-%EB%8B%A8%EC%B6%95%ED%82%A4-intelliJ-%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8
        // https://backendcode.tistory.com/232

        // 필수적인 기본 단축키들 (외워라!!)
        // shift + shift : search everywhere, 모든 탐색기(명령어, 파일, 키워드)
        // ctrl + ctrl : cmd 명령어 호출창 열기
        // alt + enter : quick fix(에러 자동 고치기)
        // tab : 들여쓰기 또는 자동완성
        // shift + tab : 역들여쓰기
        // ctrl + space : 자동완성
        // ctrl + shift + space : 스마트 자동완성 추천
        // ctrl + / : 주석 자동완성
        // ctrl + shift + / : 여러줄 주석 자동완성
        // ctrl + a : 모든 라인 선택
        // ctrl + w : 확장된 선택, 입력할수록 범위 커짐
        // ctrl + d : 라인 복사
        // ctrl + y : 선택된 라인지우기
        // ctrl + z : 되돌리기 (undo)
        // ctrl + shift + z : 다시 실행하기 (redo)
        // ctrl + ↑, ↓ : 커서 기준으로 화면이동
        // ctrl + <-, -> : 키워드 이동, 빠르게 이동 가능 (Home, End 키 활용 추천!)
        // alt + ↑, ↓ : 위아래로 코드 이동 빠르게 하기 (메소드, 클래스 단위)
        // alt + <-, -> : 코드 파일간 이동
        // alt + shift + ↑ : 선택된 라인 위로 옮기기
        // alt + shift + ↓ : 선택된 라인 아래로로 옮기기

        // 탐색 (find)
        // ctrl + f : 파일 내에서 키워드 찾기 -> replace로 교체 가능
        // ctrl + r : replace 상태에서 열기
        // 단어가 선택된 상태에서 ctrl + f : 선택된 단어 찾기
        // ctrl + shift + f : 프로젝트 또는 전체 찾기
        // ctrl + shift + r : 프로젝트 또는 전체 교체
        // shift shift : 모든 찾기 모드
        // f3 : 다음 찾기
        // f3 + shift : 이전 찾기

        // 리팩토링
        // ctrl + alt + l : 정해진 포멧으로 자동 정렬
        // ctrl + shift + enter : 세미콜론 자동완성
        // alt + shift + insert : 열선택 모드 전환
        // alt + shift + click : 단어 선택 모드로 전환
        // shift + f6 : remane (변경된 이름은 다른 파일에서도 올바르게 변경됨)
        // ctrl + shift + u : 대소문자 변환
        // shift + ctrl + alt + t : 리팩토링 모드 화
        // ctrl + alt + v : extract variable
        // int length = "hello java world!".length();
        // ctrl + alt + m : extract method
        // ctrl + alt + f : extract field
        // ctrl + alt + shift + u : uml 클래스 다이어그램
        // alt + insert : generate 단축키 -> 나중에 get/setter, tostring 자동완성용
    }
}
