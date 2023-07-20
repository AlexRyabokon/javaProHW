package org.example.controllers;

import org.example.entities.Order;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable long id){
        return orderRepository.getById(id);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }



}
