package categories;

public class Category {
    protected String name;

    public Category(String name) {
        this.name = name;
    }

    public void showProducts() {
        System.out.println("1. 스킨 케어\n2. 메이크업\n3. 바디 케어");
    };
}