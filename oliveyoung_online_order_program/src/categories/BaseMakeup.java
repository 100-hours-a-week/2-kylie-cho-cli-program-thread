package categories;

import order.Product;

public class BaseMakeup extends SubCategory {

    public BaseMakeup() {
        super("베이스 메이크업");
        products.add(new Product("정샘물 에센셜 스킨누더 쿠션 (본품+리필)", 42750));
        products.add(new Product("[단독기획] 네이밍 레이어드 핏 쿠션 기획 (본품+리필)", 29700));
        products.add(new Product("[품절대란/밀착커버] 에이프릴스킨 히어로 쿠션(본품+리필)", 23100));
    }

}