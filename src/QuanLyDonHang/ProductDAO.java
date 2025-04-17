package QuanLyDonHang;


import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private List<Product> products = new ArrayList<>();

    public ProductDAO() {
        products.add(new Product(1, "Sữa tươi", 15000));
        products.add(new Product(2, "Bánh mì", 12000));
        products.add(new Product(3, "Mì tôm", 5000));
        products.add(new Product(4, "Trứng", 3000));
        products.add(new Product(5, "Phở", 10000));
        products.add(new Product(6, "Snack", 7000));
        products.add(new Product(7, "Nước lọc", 10000));
        products.add(new Product(8, "Kẹo ngọt", 14000));
        products.add(new Product(9, "Xúc xích", 5000));
        products.add(new Product(10, "Thịt hộp", 30000));
    }

    public List<Product> getAll() {
        return products;
    }

    public Product getById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
