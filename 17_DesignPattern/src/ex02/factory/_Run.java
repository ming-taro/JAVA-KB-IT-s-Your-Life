package ex02.factory;

public class _Run {

    public static void main(String[] args) {
        Keyboard keyboard1 = (Keyboard) Factory.createProduct("Keyboard", "로지텍 MX Keys", 133000);
        Keyboard keyboard2 = (Keyboard) Factory.createProduct(ObjectType.KEYBOARD, "로지텍 MX Keys mini", 113000);
        Mouse mouse1 = (Mouse) Factory.createProduct("Mouse", "로지텍 MX Vertical", 101000);
        Mouse mouse2 = (Mouse) Factory.createProduct(ObjectType.MOUSE, "로지텍 Vertical lift", 67000);
        System.out.println(keyboard1);
        System.out.println(keyboard2);
        System.out.println(mouse1);
        System.out.println(mouse2);
    }
}
