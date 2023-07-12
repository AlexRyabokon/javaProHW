package org.example.repository;

import org.example.entities.Product;
import org.example.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;

public class ProductDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable(final String sql){
        jdbcTemplate.execute(Objects.requireNonNull(sql));
    }

    public void addProduct(Product product) {
        Objects.requireNonNull(product);
        String sql = "INSERT INTO Products (id, name, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice());
    }

    public void deleteProduct(long productId) {
        if (productId <=0) {
            throw new RuntimeException("Product ID cannot have 0 or negative number");
        }
        String sql = "DELETE FROM Products WHERE id = ?";
        jdbcTemplate.update(sql, productId);
    }

    public Product getProductById(long productId) {
        if (productId <=0) {
            throw new RuntimeException("Product ID cannot have 0 or negative number");
        }
        String sql = "SELECT * FROM Products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, new ProductMapper());
    }

    public List<Product> getAvailableProducts() {
        String sql = "SELECT * FROM Products";
        return jdbcTemplate.query(sql, new ProductMapper());
    }
}
