package categories;

import order.Product;

import java.util.ArrayList;

public class Handcare extends SubCategory {

    public Handcare() {
        super("핸드 케어");
        products.add(new Product("오센트 퍼퓸 핸드크림 35ml 3종(포레스트/러브/소프트)", 12600));
        products.add(new Product("타입넘버 핸드크림 40ml 5종 택 1", 10800));
        products.add(new Product("카밀 핸드앤네일 크림 30ml 미니 7종 택 1", 2900));
    }

}