package Workshop2;


import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng triết gia: ");
        int soLuongTrietGia = scanner.nextInt();

        Semaphore[] dua = new Semaphore[soLuongTrietGia];
        TrietGia[] trietGias = new TrietGia[soLuongTrietGia];

        for (int i = 0; i < soLuongTrietGia; i++) {
            dua[i] = new Semaphore(1);
        }

        for (int i = 0; i < soLuongTrietGia; i++) {
            int trai = i;
            int phai = (i + 1) % soLuongTrietGia;
            if (i == soLuongTrietGia - 1) {
                trietGias[i] = new TrietGia(i, dua[phai], dua[trai]);
            } else {
                trietGias[i] = new TrietGia(i, dua[trai], dua[phai]);
            }
            trietGias[i].start();
        }

        scanner.close();
    }
}



