package QuanLyDonHang;


import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private List<Customer> customers = new ArrayList<>();

    public CustomerDAO() {
        customers.add(new Customer(1, "Kiều Oanh", "oanhntk.24ite@vku.udn.vn"));
        customers.add(new Customer(2, "Văn A", "av.24ite@vku.udn.vn"));
    }

    public List<Customer> getAll() {
        return customers;
    }

    public Customer getById(int id) {
        return customers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}
