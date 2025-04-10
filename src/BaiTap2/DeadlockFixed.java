package BaiTap2;

public class DeadlockFixed {
    private static final Object resourceA = new Object();
    private static final Object resourceB = new Object();

    public static void main(String[] args) {
        Runnable task = () -> {
            synchronized (resourceA) {
                System.out.println(Thread.currentThread().getName() + ": đã khóa A");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread().getName() + ": đã khóa B");
                }
            }
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();
    }
}
