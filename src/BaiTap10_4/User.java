package BaiTap10_4;

public class User {
    private String tenDangNhap;
    private String matKhauDaBam;

    public User(String tenDangNhap, String matKhauDaBam) {
        this.tenDangNhap = tenDangNhap;
        this.matKhauDaBam = matKhauDaBam;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhauDaBam() {
        return matKhauDaBam;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhauDaBam(String matKhauDaBam) {
        this.matKhauDaBam = matKhauDaBam;
    }


    @Override
    public String toString() {
        return tenDangNhap;
    }
}


