package org.example;

import org.example.entities.Cart;
import org.example.entities.Product;
import org.example.repository.ProductDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext("org.example");

        ProductDAO productDAO = context.getBean(ProductDAO.class);
        Cart cart = context.getBean(Cart.class);


        Product product = productDAO.getProductById(2);
        cart.add(product);
    }
}
