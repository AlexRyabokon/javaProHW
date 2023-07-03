package org.springexample.repository;

import org.springexample.entites.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductRepository {

    private static final Logger LOGGER = Logger.getLogger(ProductRepository.class.getName());
    private List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>(
                List.of(new Product(1L, "Cement", 100),
                        new Product(2L, "Door", 340),
                        new Product(3L, "Wall", 200))
        );
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getById(long id) {
        if (id < 1) {throw new RuntimeException("ID cannot be null or less than 1");}

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        LOGGER.info("Product with " + id + " wasn`t found!");
        return null;
    }


}
