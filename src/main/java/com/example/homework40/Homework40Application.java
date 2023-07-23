package com.example.homework40;

import com.example.homework40.entities.Order;
import com.example.homework40.entities.Product;
import com.example.homework40.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.TreeSet;

@SpringBootApplication
public class Homework40Application {

    public static void main(String[] args) {

        Product product = new Product(1L, "Prod1", 34);
        HashSet<Product> prods = new HashSet<>();
        prods.add(product);


        SpringApplication.run(Homework40Application.class, args);


    }

}
