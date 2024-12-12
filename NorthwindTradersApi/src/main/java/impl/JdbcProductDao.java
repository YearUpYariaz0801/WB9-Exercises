package com.pluralsight.NorthwindTradersAPI.dao.impl;
import com.pluralsight.NorthwindTradersAPI.dao.interfaces.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import java.util.List;
public class JdbcProductDao implements ProductDao {
    @Override
    public List<Product> getAll() {
        return List.of();
    }
    @Override
    public Product getByProductId(int id) {
        return null;
    }
}}