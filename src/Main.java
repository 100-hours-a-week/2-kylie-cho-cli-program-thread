import categories.*;
import order.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        System.out.println("\n🤗 올리브영에 오신 걸 환영합니다 🤗");

        while (true) {
            // 1. 카테고리 선택
            Category category = new Category("전체 카테고리");
            System.out.println("\n🔶 카테고리를 선택하세요");
            category.showProducts();
            System.out.print("👉 ");
            int categoryChoice = scanner.nextInt();

            switch (categoryChoice) {
                case 1 -> category = new categories.Skincare();
                case 2 -> category = new categories.Makeup();
                case 3 -> category = new categories.Bodycare();
                default -> {
                    System.out.println("\n⚠️ 카테고리 번호를 잘못 입력했어요. ⚠️");
                    continue;
                }
            }

            // 2. 세부 카테고리 선택
            System.out.println("\n🔶 세부 카테고리를 선택하세요");
            category.showProducts();
            System.out.print("👉 ");
            int subCategoryChoice = scanner.nextInt();

            SubCategory subCategory = null;

            if (category instanceof Skincare) {
                subCategory = switch (subCategoryChoice) {
                    case 1 -> new SkinToner();
                    case 2 -> new EssenceSerum();
                    default -> null;
                };
            } else if (category instanceof Makeup) {
                subCategory = switch (subCategoryChoice) {
                    case 1 -> new LipMakeup();
                    case 2 -> new BaseMakeup();
                    case 3 -> new EyeMakeup();
                    default -> null;
                };
            } else if (category instanceof Bodycare) {
                subCategory = switch (subCategoryChoice) {
                    case 1 -> new ShowerBath();
                    case 2 -> new Handcare();
                    default -> null;
                };
            }

            if (subCategory == null) {
                System.out.println("\n⚠️ 세부 카테고리 번호를 잘못 입력했어요. ⚠️");
                continue;
            }

            // 3. 제품 선택
            System.out.println("\n🔶 구매할 제품 번호를 선택하세요");
            subCategory.showProducts();
            System.out.print("👉 ");
            int productChoice = scanner.nextInt();

            Product selectedProduct = subCategory.getProduct(productChoice - 1);
            if (selectedProduct != null) cart.addProduct(selectedProduct);
            else System.out.println("\n⚠️ 제품 번호를 잘못 입력했어요. ⚠️");

            // 4. 추가 구매 여부 확인
            System.out.println("다른 제품도 구매하시겠습니까? [Y/N]");
            System.out.print("👉 ");
            String moreShopping = scanner.next();
            if(!moreShopping.equalsIgnoreCase("Y")) break;
        }

        // 5. 장바구니 출력
        cart.showCart();

        // 6. 배송 방법 선택 및 결제
        int points = 0;
        Order order = new Order(cart, points);
        order.orderProcess();
    }
}