package categories;

public class Bodycare extends Category {
    public Bodycare() {
        super("바디 케어");
    }

    public void showProducts() {
        System.out.println("1. 샤워.입욕\n2. 핸드 케어");
    }
}