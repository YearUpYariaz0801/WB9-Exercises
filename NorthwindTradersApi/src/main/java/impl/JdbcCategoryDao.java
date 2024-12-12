package com.pluralsight.NorthwindTradersAPI.dao.impl;
import com.pluralsight.NorthwindTradersAPI.dao.interfaces.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcCategoryDao implements CategoryDao {
    private DataSource dataSource;
    @Autowired
    public JdbcCategoryDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sql = """
                SELECT\s
                CategoryId,
                CategoryName
                FROM categories;""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement query = connection.prepareStatement(sql);
            ResultSet results = query.executeQuery())
        {
            while (results.next()){
                int catId = results.getInt(1);
                String catName = results.getString(2);
                categories.add(new Category(catId, catName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
    @Override
    public Category findByCategoryId(int id) {
        Category category;
        String sql = """
                SELECT\s
                CategoryId,
                CategoryName
                FROM categories
                WHERE CategoryId = ?;""";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement query = connection.prepareStatement(sql);
        )
        {
            query.setInt(1, id);
            try( ResultSet results = query.executeQuery()){
                while (results.next()){
                    int catId = results.getInt(1);
                    String catName = results.getString(2);
                    return new Category(catId, catName);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}