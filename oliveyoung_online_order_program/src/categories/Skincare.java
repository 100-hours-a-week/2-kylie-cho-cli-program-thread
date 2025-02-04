package categories;

public class Skincare extends Category {
    public Skincare() {
        super("스킨 케어");
    }

    public void showProducts() {
        System.out.println("1. 스킨.토너\n2. 에센스.세럼");
    }
}