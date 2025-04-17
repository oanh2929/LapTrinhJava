package QuanLyDonHang;



public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

}
