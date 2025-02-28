package Workshop1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class BoDem {

        private final BlockingQueue<Integer> hangDoi;

        public BoDem(int sucChua) {
            this.hangDoi = new LinkedBlockingQueue<>(sucChua);
        }

        public void sanXuat(int sanPham) throws InterruptedException {
            hangDoi.put(sanPham); // Nếu đầy thì chờ
            System.out.println("🏭 [SẢN XUẤT] Đã tạo sản phẩm: " + sanPham + " | Bộ đệm: " + hangDoi);
        }

        public int tieuThu() throws InterruptedException {
            int sanPham = hangDoi.take();
            System.out.println("🛒 [TIÊU DÙNG] Đã lấy sản phẩm: " + sanPham + " | Bộ đệm: " + hangDoi);
            return sanPham;
        }
    }

