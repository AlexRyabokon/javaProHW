package org.example.repository;

import org.example.entities.Order;
import org.example.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class OrderRepository {
    private static final Logger LOGGER = Logger.getLogger(OrderRepository.class.getName());
    private final List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>(
                List.of(new Order(1L, "01-01-2020", 100,
                                new Product[]{new Product(1L, "Prod1", 30)}),

                        new Order(1L, "01-01-2020", 100,
                                new Product[]{new Product(2L, "Prod2", 11)}),
                        new Order(1L, "01-01-2020", 100,
                                new Product[]{new Product(3L, "Prod3", 233)}))
        );
    }

    public List<Order> getAllOrders(){
        return orders;
    }

    public Order getById(long id) {
        if (id < 1) {throw new RuntimeException("ID cannot be null or less than 1");}

        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        LOGGER.info("Order with " + id + " wasn`t found!");
        return null;
    }
}
