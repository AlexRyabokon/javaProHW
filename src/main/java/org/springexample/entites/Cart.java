package org.springexample.entites;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Cart {
    private static final Logger LOGGER = Logger.getLogger(Cart.class.getName());

    private final List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProd(Product product) {
        products.add(Objects.requireNonNull(product));
    }


    public void deleteProdById(long id) {
        if (id < 1) {
            throw new RuntimeException("ID cannot be null or less than 1");
        }

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            } else {
                LOGGER.info("Product with " + id + " wasn`t found!");
            }
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }


}
