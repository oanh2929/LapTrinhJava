package Workshop2;


import java.util.concurrent.Semaphore;


public class TrietGia extends Thread {
    private int id;
    private Semaphore duaTrai, duaPhai;


    public TrietGia(int id, Semaphore duaTrai, Semaphore duaPhai) {
        this.id = id;
        this.duaTrai = duaTrai;
        this.duaPhai = duaPhai;

    }

    private void suyNghi() throws InterruptedException {
        System.out.println(" 💭 Triết gia " + id + " đang suy nghĩ...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void an() throws InterruptedException {
        System.out.println(" 🍽️ Triết gia " + id + " đang ăn...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                suyNghi();
                duaTrai.acquire();
                System.out.println(" 🥢 Triết gia " + id + " đã cầm đũa trái.");
                duaPhai.acquire();
                System.out.println(" 🥢 Triết gia " + id + " đã cầm đũa phải.");
                an();
                duaPhai.release();
                System.out.println(" 🥢 Triết gia " + id + " đã đặt đũa phải xuống.");
                duaTrai.release();
                System.out.println(" 🥢 Triết gia " + id + " đã đặt đũa trái xuống.");
            }
        } catch (InterruptedException e) {
            System.out.println("⚠️ Triết gia " + id + " bị gián đoạn!");
            Thread.currentThread().interrupt();
        }
    }
}


