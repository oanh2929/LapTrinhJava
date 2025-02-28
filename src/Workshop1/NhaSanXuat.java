package Workshop1;
import java.util.Random;

public class NhaSanXuat extends Thread{
    private final BoDem boDem;
    private final int soLuong;
    private final Random random = new Random();

    public NhaSanXuat(BoDem boDem, int soLuong) {
        this.boDem = boDem;
        this.soLuong = soLuong;
    }

    public void run() {
        try {
            for (int i = 1; i <= soLuong; i++) {
                int sanPham = random.nextInt(100); // Sản phẩm ngẫu nhiên từ 0-99
                boDem.sanXuat(sanPham);
                Thread.sleep(random.nextInt(1000)); // Giả lập thời gian sản xuất
            }
        } catch (InterruptedException e) {
            System.out.println("⚠️ Nhà sản xuất bị gián đoạn!");
        }
    }
}
