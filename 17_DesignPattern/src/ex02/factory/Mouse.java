package ex02.factory;

public class Mouse extends Product {
    public Mouse(String name, int price) {
        super(name, price);
    }

    public void click() {
        System.out.println("마우스가 클릭 되었습니다.");
    }
}
