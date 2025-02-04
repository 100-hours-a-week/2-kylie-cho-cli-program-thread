package categories;

public class Makeup extends Category {
    public Makeup() {
        super("메이크업");
    }

    public void showProducts() {
        System.out.println("1. 립 메이크업\n2. 베이스 메이크업\n3. 아이 메이크업");
    }
}