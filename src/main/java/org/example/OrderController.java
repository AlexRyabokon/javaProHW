package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;
    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderRepository.getOrderById(id);
    }

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @PostMapping("/")
    public void addOrder(@RequestBody Order order) {
        orderRepository.addOrder(order);
    }
}
