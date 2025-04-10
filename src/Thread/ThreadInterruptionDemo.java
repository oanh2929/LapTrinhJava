package Thread;

public class ThreadInterruptionDemo {

    public static void main(String[] args) {

        Thread luongVoHan = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(">>> Luồng bị ngắt! Kết thúc.");
                    break;
                }

                System.out.println("Đang chạy...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(">>> Bị ngắt khi đang ngủ.");
                    break;
                }
            }
        });

        luongVoHan.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(">>> Gọi interrupt() sau 3 giây...");
        luongVoHan.interrupt();
    }
}

