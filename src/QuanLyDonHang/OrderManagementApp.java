package QuanLyDonHang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class OrderManagementApp extends JFrame {
    private JComboBox<Customer> customerComboBox;
    private JComboBox<Product> productComboBox;
    private JTextField quantityField;
    private JTable orderTable;
    private DefaultTableModel tableModel;
    private JTextArea historyArea;

    private CustomerDAO customerDAO = new CustomerDAO();
    private ProductDAO productDAO = new ProductDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private List<OrderItem> currentItems = new ArrayList<>();

    public OrderManagementApp() {
        setTitle("Quản Lý Đơn Hàng");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 1));

        JPanel customerPanel = new JPanel();
        customerPanel.add(new JLabel("Khách hàng: "));
        customerComboBox = new JComboBox<>();
        for (Customer c : customerDAO.getAll()) {
            customerComboBox.addItem(c);
        }
        customerPanel.add(customerComboBox);
        topPanel.add(customerPanel);

        JPanel productPanel = new JPanel();
        productPanel.add(new JLabel("Sản phẩm: "));
        productComboBox = new JComboBox<>();
        for (Product p : productDAO.getAll()) {
            productComboBox.addItem(p);
        }
        productPanel.add(productComboBox);
        productPanel.add(new JLabel("Số lượng: "));
        quantityField = new JTextField(5);
        productPanel.add(quantityField);
        JButton addButton = new JButton("Thêm sản phẩm");
        productPanel.add(addButton);
        topPanel.add(productPanel);

        add(topPanel, BorderLayout.NORTH);

        String[] columnNames = {"Sản phẩm", "Giá", "Số lượng", "Thành tiền"};
        tableModel = new DefaultTableModel(columnNames, 0);
        orderTable = new JTable(tableModel);
        add(new JScrollPane(orderTable), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton createOrderButton = new JButton("Tạo đơn hàng");
        bottomPanel.add(createOrderButton, BorderLayout.NORTH);

        historyArea = new JTextArea(10, 40);
        historyArea.setEditable(false);
        bottomPanel.add(new JScrollPane(historyArea), BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener((ActionEvent e) -> {
            Product selectedProduct = (Product) productComboBox.getSelectedItem();
            int quantity;
            try {
                quantity = Integer.parseInt(quantityField.getText());
                if (quantity <= 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
                return;
            }
            OrderItem item = new OrderItem(selectedProduct, quantity);
            currentItems.add(item);
            tableModel.addRow(new Object[]{
                    selectedProduct.getName(),
                    selectedProduct.getPrice(),
                    quantity,
                    item.getSubtotal()
            });
            quantityField.setText("");
        });

        createOrderButton.addActionListener((ActionEvent e) -> {
            Customer customer = (Customer) customerComboBox.getSelectedItem();
            if (currentItems.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm vào đơn!");
                return;
            }
            orderDAO.addOrder(customer, new ArrayList<>(currentItems));
            currentItems.clear();
            tableModel.setRowCount(0);
            showOrderHistory(customer);
        });
    }

    private void showOrderHistory(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== LỊCH SỬ ĐƠN HÀNG CỦA " + customer.getName() + " ===\n");
        for (Order o : orderDAO.getOrdersByCustomerId(customer.getId())) {
            sb.append("Đơn #").append(o.getId()).append(" - Ngày: ").append(o.getOrderDate()).append("\n");
            sb.append("Tổng tiền: ").append(o.getTotalAmount()).append(" đ\n\n");
        }
        historyArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrderManagementApp().setVisible(true));
    }
}
