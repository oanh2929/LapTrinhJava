package BaiTap10_4;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    // Hàm băm mật khẩu bằng SHA-256
    public static String bamMatKhau(String matKhauGoc) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(matKhauGoc.getBytes());
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // So sánh mật khẩu đã băm
    public static boolean kiemTraMatKhau(String matKhauNhap, String matKhauDaBam) {
        String matKhauNhapBam = bamMatKhau(matKhauNhap);
        return matKhauNhapBam.equals(matKhauDaBam);
    }

    // Hàm hỗ trợ chuyển byte[] thành chuỗi hex
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}


