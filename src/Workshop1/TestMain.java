package Workshop1;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("🔢 Nhập số lượng sản phẩm cần sản xuất: ");
        int soLuongSanXuat = scanner.nextInt();
        System.out.print("🔢 Nhập số lượng sản phẩm cần tiêu thụ: ");
        int soLuongTieuThu = scanner.nextInt();
        System.out.print("📦 Nhập sức chứa tối đa của bộ đệm: ");
        int sucChua = scanner.nextInt();

        scanner.close();

        System.out.println("\n🚀 [KHỞI ĐỘNG] Mô phỏng bài toán Nhà sản xuất - Người tiêu dùng...");
        BoDem boDem = new BoDem(sucChua);
        NhaSanXuat nhaSanXuat = new NhaSanXuat(boDem, soLuongSanXuat);
        NguoiTieuDung nguoiTieuDung = new NguoiTieuDung(boDem, soLuongTieuThu);

        nhaSanXuat.start();
        nguoiTieuDung.start();

        try {
            nhaSanXuat.join();
            nguoiTieuDung.join();
        } catch (InterruptedException e) {
            System.out.println("⚠️ Chương trình bị gián đoạn!");
        }

        System.out.println("\n✅ [HOÀN THÀNH] Quá trình sản xuất và tiêu thụ kết thúc!");
    }
}
