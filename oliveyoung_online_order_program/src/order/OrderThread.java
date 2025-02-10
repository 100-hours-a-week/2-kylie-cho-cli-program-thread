package order;

import utils.WeatherThread;

public class OrderThread extends Thread {
    private Order order;

    public OrderThread(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        String weather = WeatherThread.getCurrentWeather();
        int discount = 0;

        // 날씨에 따라 할인율 적용
        if ("비 내림 ☔️".equals(weather)) {
            discount = 10;
        } else if ("눈이 내림 ❄️".equals(weather)) {
            discount = 20;
        }

        int totalPrice = order.getCart().getPrice();
        int discountedPrice = totalPrice * (100 - discount) / 100;

        // 날씨 할인 적용 후 가격 고지
        System.out.println("🌈 지금 날씨는 " + weather);
        if (discount > 0) {
            System.out.println("✅ 총 제품 가격에 " + discount + "% 추가 할인이 적용됩니다!");
        } else {
            System.out.println("✅ 날씨 할인이 적용되지 않습니다.");
        }
        System.out.println("\n---------------------------------------------------");

        // 최종 가격을 주문 객체에 반영
        order.applyDiscount(discountedPrice);
    }
}
