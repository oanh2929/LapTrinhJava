package Workshop1;
import java.util.Random;

public class NguoiTieuDung extends Thread {
    private final BoDem boDem;
    private final int soLuong;
    private final Random random = new Random();

    public NguoiTieuDung(BoDem boDem, int soLuong) {
        this.boDem = boDem;
        this.soLuong = soLuong;
    }

    public void run() {
        try {
            for (int i = 1; i <= soLuong; i++) {
                boDem.tieuThu();
                Thread.sleep(random.nextInt(1500));
            }
        } catch (InterruptedException e) {
            System.out.println("⚠️ Người tiêu dùng bị gián đoạn!");
        }
    }

}
