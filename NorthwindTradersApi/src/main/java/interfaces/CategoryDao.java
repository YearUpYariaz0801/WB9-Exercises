package com.pluralsight.NorthwindTradersAPI.dao.interfaces;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import java.util.List;
public interface CategoryDao {
    List<Category> getAll();
    Category findByCategoryId(int id);
}