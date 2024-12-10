package com.pluralsight.NorthwindTradersAPI.controllers;
import models.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@RestController
public class ProductsController {
    @RequestMapping(path="/products", method= RequestMethod.GET)
    public List<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Banana", 1, 5.99d));
        products.add(new Product(2, "Apple", 1, 15.99d));
        products.add(new Product(3, "Blue Jeans", 2, 2.99d));
        return products;
    }
}