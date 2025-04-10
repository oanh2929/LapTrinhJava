package BaiTap10_4;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

public class MainApp extends JFrame {
    private JTextField oTenDangNhap = new JTextField();
    private JPasswordField oMatKhau = new JPasswordField();
    private JTextArea oDanhSach = new JTextArea();
    private UserData userData = new UserData();

    public MainApp() {
        setTitle("Ứng dụng người dùng");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel tren = new JPanel(new GridLayout(3, 2));
        tren.add(new JLabel("Tên đăng nhập:"));
        tren.add(oTenDangNhap);
        tren.add(new JLabel("Mật khẩu:"));
        tren.add(oMatKhau);

        JButton nutDangKy = new JButton("Đăng ký");
        JButton nutDangNhap = new JButton("Đăng nhập");
        tren.add(nutDangKy);
        tren.add(nutDangNhap);
        add(tren, BorderLayout.NORTH);

        oDanhSach.setEditable(false);
        add(new JScrollPane(oDanhSach), BorderLayout.CENTER);

        JPanel duoi = new JPanel();
        JButton nutXuat = new JButton("Xuất XML");
        JButton nutNhap = new JButton("Nhập XML");
        duoi.add(nutXuat);
        duoi.add(nutNhap);
        add(duoi, BorderLayout.SOUTH);

        
        nutDangKy.addActionListener(e -> dangKy());
        nutDangNhap.addActionListener(e -> dangNhap());
        nutXuat.addActionListener(e -> xuat());
        nutNhap.addActionListener(e -> nhap());

        setVisible(true);
    }

    private void dangKy() {
        String ten = oTenDangNhap.getText();
        String mk = new String(oMatKhau.getPassword());

        if (ten.isEmpty() || mk.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
            return;
        }

        if (userData.dangKy(ten, mk)) {
            JOptionPane.showMessageDialog(this, "Đăng ký thành công");
            capNhatDanhSach();
        } else {
            JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại");
        }
    }

    private void dangNhap() {
        String ten = oTenDangNhap.getText();
        String mk = new String(oMatKhau.getPassword());

        if (userData.dangNhap(ten, mk)) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Sai tên hoặc mật khẩu");
        }
    }

    private void capNhatDanhSach() {
        StringBuilder sb = new StringBuilder("Danh sách người dùng:\n");
        for (User u : userData.getDanhSachNguoiDung()) {
            sb.append("- ").append(u.getTenDangNhap()).append("\n");
        }
        oDanhSach.setText(sb.toString());
    }

    private void xuat() {
        JFileChooser chonFile = new JFileChooser();
        if (chonFile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chonFile.getSelectedFile();
            try {
                XMLUtil.xuatXML(userData.getDanhSachNguoiDung(), file);
                JOptionPane.showMessageDialog(this, "Đã xuất XML");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void nhap() {
        JFileChooser chonFile = new JFileChooser();
        if (chonFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chonFile.getSelectedFile();
            try {
                List<User> danhSachMoi = XMLUtil.nhapXML(file);
                userData.setDanhSachNguoiDung(danhSachMoi);
                JOptionPane.showMessageDialog(this, "Đã nhập từ XML");
                capNhatDanhSach();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }
}
