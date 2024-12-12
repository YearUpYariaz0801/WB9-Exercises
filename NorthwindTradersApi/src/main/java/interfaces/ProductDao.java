package com.pluralsight.NorthwindTradersAPI.dao.interfaces;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import java.util.List;
public interface ProductDao {
    List<Product> getAll();
    Product getByProductId(int id);
}