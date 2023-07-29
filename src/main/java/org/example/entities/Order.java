package org.example.entities;

import java.util.Arrays;

public class Order {
    private Long id;
    private String date;
    private double cost;
    private Product[] products;

    public Order(Long id, String date, double cost, Product[] products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", cost=" + cost +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
