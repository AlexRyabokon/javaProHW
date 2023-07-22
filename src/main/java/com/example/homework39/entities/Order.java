package com.example.homework39.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name= "orders_prods")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private double cost;
    @OneToMany
    @JoinColumn(name = "orders")
    private Set<Product> products;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", cost=" + cost +
                ", products=" + products +
                '}';
    }
}
