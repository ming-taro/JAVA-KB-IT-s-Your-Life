package ex02.factory;

import java.lang.reflect.InvocationTargetException;

public class Factory {

    // 문자열을 활용한 create 메소드
    // -> 강사는 아래와 같이 관리가 필요한 코드 안좋아했다.
    public static Product createProduct(String type, String name, int price){
        if (type.equalsIgnoreCase("Mouse")) {
            return new Mouse(name, price);
        } else if (type.equalsIgnoreCase("Keyboard")) {
            return new Keyboard(name, price);
        } else {
            return null;
        }
    }

    // 리플렉션을 통한 생성자 자동으로 만들어주는 코드
    // -> 아래 코드는 여기서 유지보수 하지 않는다. Type만 관리되면 된다.
    // -> 또한 Type check를 강력하게 할수 있어 편리하다.
    public static Product createProduct(ObjectType type, String name, int price){
        Product product = null;
        try {
            Object obj = type.productClass().getDeclaredConstructors()[0].newInstance(name, price);
            product = (Product) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
