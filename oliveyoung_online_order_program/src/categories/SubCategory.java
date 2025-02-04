package categories;

import order.Product;
import java.util.ArrayList;

public class SubCategory extends Category {

    protected ArrayList<Product> products = new ArrayList<>();

    public SubCategory(String name) {
        super(name);
    }

    public void showProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice() + "원");
        }
    }

    public Product getProduct(int index) {
        if (0 <= index && index < products.size()) {
            return products.get(index);
        }
        return null;
    }
}
