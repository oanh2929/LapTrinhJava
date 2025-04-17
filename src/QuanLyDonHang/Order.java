package QuanLyDonHang;



import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> items;
    private Date orderDate;

    public Order(int id, Customer customer, List<OrderItem> items, Date orderDate) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }
}

