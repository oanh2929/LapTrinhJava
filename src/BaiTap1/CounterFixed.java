package BaiTap1;

public class CounterFixed {
    public static int counter = 0;

    public static synchronized void tangCounter() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                tangCounter();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                tangCounter();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("✅ Giá trị counter cuối cùng: " + counter);
    }
}
