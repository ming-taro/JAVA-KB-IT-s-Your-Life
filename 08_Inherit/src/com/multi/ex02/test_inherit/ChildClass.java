package com.multi.ex02.test_inherit;

// 자식 클래스로 부모 SuperClass를 상속받은 클래스
public class ChildClass extends SuperClass {
    // 자식의 멤버변수는 부모와 이름이 겹쳐서 선언은 가능하다!
    private int privateValue = 105;
    protected int protectedValue = 110;
    public int publicValue = 120;

    public ChildClass() {
//        System.out.println("ChildClass Constructor"); // -> Call to 'super()' must be first statement in constructor body
        super();
        // 관례적인 코드 -> 부모의 생성자를 명시적으로 호출하는 코드
        // 만일 생략하는 경우 JVM에서 자동으로 생성 시켜준다
        // 만일 선언하는 경우 생성자 가장 첫줄에 선언해야하며, 그러지 않을 경우 에러 발생!
        // 부모의 생성자를 호출하는 이유는?
        // -> 부모의 메모리 공간을 미리 확보하고 자식은 그 메모리 주소에서 확장해서 다시 멤버변수가 선언되기 때문이다
        System.out.println("ChildClass의 생성자 입니다.");

        // local 변수 선언 == stack에 메모리가 잡히는 변수, 호출이 끝나면 같이 사라짐
        int publicValue = 300;
        // local 변수가 호출되는 영역, 호출되는 원리는? 블록 = { }!
        System.out.println(publicValue);
        System.out.println();

        // 현재 클래스의 멤버변수 접근하는 방법
        // -> this 키워드
        System.out.println("This Private Value: " + this.privateValue);
        System.out.println("This Protected Value: " + this.protectedValue);
        System.out.println("This Public Value: " + this.publicValue);
        System.out.println();

        // 부모의 멤버변수 접근하는 방법
        // -> super
//        System.out.println("Super Private Value: " + super.privateValue); // 에러 발생!!
        System.out.println("Super Private Value: " + super.getPrivateValue());
        System.out.println("Super Protected Value: " + super.protectedValue);
        System.out.println("Super Public Value: " + super.publicValue);
    }

    @Override
    public void publicMethod() {
        System.out.println("ChildClass에서 오버라이드 된 publicMethod입니다.");
        super.publicMethod(); // 부모의 publicMethod를 호출하는 문장 -> 필요에 따라 삭제할 수 있는 문장!
    }
}
