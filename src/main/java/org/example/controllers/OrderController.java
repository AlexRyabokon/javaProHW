package org.example.controllers;

import org.example.entities.Order;
import org.example.repository.OrderRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable long id){
        return orderRepository.getById(id);
    }

    @GetMapping()
    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }
}

