package BaiTap10_4;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private List<User> danhSachNguoiDung = new ArrayList<>();

    public boolean dangKy(String tenDangNhap, String matKhauGoc) {
        for (User u : danhSachNguoiDung) {
            if (u.getTenDangNhap().equals(tenDangNhap)) {
                return false; // Tên đã tồn tại
            }
        }
        String bam = HashUtil.bamMatKhau(matKhauGoc);
        danhSachNguoiDung.add(new User(tenDangNhap, bam));
        return true;
    }

    public boolean dangNhap(String tenDangNhap, String matKhauNhap) {
        for (User u : danhSachNguoiDung) {
            if (u.getTenDangNhap().equals(tenDangNhap) &&
                    HashUtil.kiemTraMatKhau(matKhauNhap, u.getMatKhauDaBam())) {
                return true;
            }
        }
        return false;
    }

    public List<User> getDanhSachNguoiDung() {
        return danhSachNguoiDung;
    }

    public void setDanhSachNguoiDung(List<User> danhSach) {
        this.danhSachNguoiDung = danhSach;
    }
}

