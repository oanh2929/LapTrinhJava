package BaiTap17_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncryptionApp extends JFrame {

    private JTextArea inputArea, outputArea;
    private JButton encryptButton, decryptButton;
    private JComboBox<String> algorithmComboBox;

    private Encryptable aesEncryptor;
    private Encryptable rsaEncryptor;

    public EncryptionApp() {
        setTitle("Mã hóa & Giải mã");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        try {
            aesEncryptor = new AESEncryption();
            rsaEncryptor = new RSAEncryption();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Giao diện chính
        JPanel topPanel = new JPanel(new BorderLayout());
        inputArea = new JTextArea(5, 40);
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);

        topPanel.add(new JLabel("Nhập dữ liệu:"), BorderLayout.NORTH);
        topPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        algorithmComboBox = new JComboBox<>(new String[]{"AES", "RSA"});
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        buttonPanel.add(new JLabel("Thuật toán:"));
        buttonPanel.add(algorithmComboBox);
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Kết quả:"), BorderLayout.NORTH);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        add(outputPanel, BorderLayout.SOUTH);

        // Sự kiện nút
        encryptButton.addActionListener(e -> handleEncrypt());
        decryptButton.addActionListener(e -> handleDecrypt());
    }

    private void handleEncrypt() {
        String text = inputArea.getText();
        String algorithm = (String) algorithmComboBox.getSelectedItem();

        Encryptable encryptor = algorithm.equals("AES") ? aesEncryptor : rsaEncryptor;

        new Thread(() -> {
            try {
                String result = encryptor.encrypt(text);
                SwingUtilities.invokeLater(() -> outputArea.setText(result));
            } catch (Exception ex) {
                ex.printStackTrace();
                SwingUtilities.invokeLater(() -> outputArea.setText("Lỗi mã hóa"));
            }
        }).start();
    }

    private void handleDecrypt() {
        String text = inputArea.getText();
        String algorithm = (String) algorithmComboBox.getSelectedItem();

        Encryptable encryptor = algorithm.equals("AES") ? aesEncryptor : rsaEncryptor;

        new Thread(() -> {
            try {
                String result = encryptor.decrypt(text);
                SwingUtilities.invokeLater(() -> outputArea.setText(result));
            } catch (Exception ex) {
                ex.printStackTrace();
                SwingUtilities.invokeLater(() -> outputArea.setText("Lỗi giải mã"));
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EncryptionApp().setVisible(true));
    }
}
