package dao.interfaces;
import models.Product;

import java.util.List;
public interface ProductDao {
    void add(Product product);
    List<Product> getAll();
}