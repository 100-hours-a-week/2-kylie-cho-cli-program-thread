package utils;

public class WeatherThread extends Thread {
    private String[] weatherStates = {"맑음 ☀️", "흐림 ☁️", "비 내림 ☔️", "눈이 내림 ❄️"};
    private static String currentWeather = "맑음 ☀️";
    private int idx = 0;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            currentWeather = weatherStates[idx];
//            System.out.println("\n지금 날씨는 " + currentWeather);
            idx = (idx + 1) % weatherStates.length;

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
//                System.out.println("날씨 스레드 종료!");
                break;
            }
        }
    }

    public static String getCurrentWeather() {
        return currentWeather;
    }
}
