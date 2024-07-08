package ex02.factory;

public class Keyboard extends Product {
    public Keyboard(String name, int price) {
        super(name, price);
    }

    public void inputKey(String key){
        System.out.println("입력된 키값 : " + key);
    }
}
