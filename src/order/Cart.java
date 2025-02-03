package order;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
        System.out.println("\n✅  장바구니에 추가되었습니다.\n");
    }

    public int getPrice() {
        int total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void showCart() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("\n🛒 장바구니 목록");
        int total = 0;
        for (Product item : items) {
            System.out.println("\t🎁 " + item.getName() + " | 💵 " + item.getPrice() + "원");
            total += item.getPrice();
        }
        System.out.println("\n---------------------------------------------------\n");
        System.out.println("💰 제품 총 금액: " + total + "원");
        System.out.println("\n---------------------------------------------------\n");
    }
}