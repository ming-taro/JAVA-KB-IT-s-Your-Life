package ex02.factory;

public enum ObjectType {
    KEYBOARD(Keyboard.class), MOUSE(Mouse.class);

    private final Class<?> productClass;
    ObjectType(Class<?> productClass) {
        this.productClass = productClass;
    }
    public Class<?> productClass() {
        return productClass;
    }
}
