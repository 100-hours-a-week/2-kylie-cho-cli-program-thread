package order;

import java.util.Scanner;

public class Order {
    private Cart cart;
    private int points;

    public Order(Cart cart, int points) {
        this.cart = cart;
        this.points = points;
    }

    public void orderProcess() {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = cart.getPrice();
        int deliveryCost = 0;

        // 1. 배송 방법 선택
        while (true) {
            System.out.println("\n🔶 배송 방법을 선택하세요");
            System.out.println("1. 일반배송\n2. 오늘드림\n3. 매장픽업");
            System.out.print("👉 ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                deliveryCost = (totalPrice >= 20000) ? 0 : 2500;
                break;
            } else if (choice == 2) {
                deliveryCost = (totalPrice >= 30000) ? 0 : 2500;
                break;
            } else if (choice == 3) {
                deliveryCost = 0;
                break;
            } else {
                System.out.println("\n⚠️ 배송 방법 번호를 잘못 입력했어요. ⚠️");
                continue;
            }
        }

        int resultPrice = totalPrice + deliveryCost;

        // 2. 포인트 사용 여부 확인
        System.out.print("\n🔶 보유 포인트를 입력하세요: ");
        points = scanner.nextInt();
        System.out.println("\n💰 보유 포인트: " + points + "원");
        System.out.println("\n🔶 포인트를 사용하시겠습니까? (포인트는 1000원부터 10원 단위로 사용 가능) [Y/N]");
        System.out.print("👉 ");
        String usePoints = scanner.next();

        // 3. 최종 금액 산출
        System.out.println("\n---------------------------------------------------");
        System.out.println("\n✅  제품 금액: " + totalPrice + "원");
        System.out.println("✅  배송비: " + deliveryCost + "원");

        if (usePoints.equalsIgnoreCase("Y")) {
            if (points >= 1000) {
                System.out.println("✅  포인트 " + (points / 10) * 10 + "점 사용");
                resultPrice -= (points / 10) * 10;
                points -= (points / 10) * 10;
            } else {
                System.out.println("⚠️ 1000원 미만의 포인트는 사용할 수 없습니다. ⚠️");
            }
        } else {
            System.out.println("✅  포인트 사용 X");
        }
        System.out.println("\n---------------------------------------------------");

        System.out.println("\n💰 최종 결제 금액: " + resultPrice + "원");

        // 4. 결제
        while(true) {
            System.out.print("\n💳 입금할 금액을 입력하세요: ");
            int payment = scanner.nextInt();

            if (payment == resultPrice) {
                System.out.println("\n---------------------------------------------------");
                System.out.println("\n✅  주문이 완료되었습니다 ^_^\n");
                break;
            } else if (payment > resultPrice) {
                System.out.println("\n---------------------------------------------------");
                System.out.println("\n💰 거스름돈 " + (payment - resultPrice) + "원 드릴게요~");
                System.out.println("\n✅  주문이 완료되었습니다 ^_^\n");
                break;
            } else {
                System.out.println("\n⚠️ 결제 금액이 부족합니다 ㅠㅅㅠ");
            }
        }
    }
}