package QuanLyDonHang;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO {
    private List<Order> orders = new ArrayList<>();
    private int nextOrderId = 1;

    public void addOrder(Customer customer, List<OrderItem> items) {
        Order newOrder = new Order(nextOrderId++, customer, items, new Date());
        orders.add(newOrder);
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (o.getCustomer().getId() == customerId) {
                result.add(o);
            }
        }
        return result;
    }

    public Order getById(int id) {
        return orders.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }
}

