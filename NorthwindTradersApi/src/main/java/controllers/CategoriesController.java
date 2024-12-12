package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.interfaces.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    private final CategoryDao categoryDao;
    @Autowired
    public CategoriesController(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }
    @RequestMapping(path="/categories", method = RequestMethod.GET)
    public List<Category> getCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "fruit"));
        categories.add(new Category(2, "clothing"));
        return categories;
        return categoryDao.getAll();
    }
    @RequestMapping(path="/categories/{id}", method= RequestMethod.GET)
    public Category getCategory(@PathVariable int id){
        return categoryDao.findByCategoryId(id);
    }
}