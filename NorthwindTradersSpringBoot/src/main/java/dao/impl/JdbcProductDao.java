package com.pluralsight.NorthwindTradersSpringBoot.dao.impl;
import com.pluralsight.NorthwindTradersSpringBoot.dao.interfaces.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import java.util.List;
public class JdbcProductDao implements ProductDao {
    @Override
    public void add(Product product) {

    }
    @Override
    public List<Product> getAll() {
        return List.of();
    }
}