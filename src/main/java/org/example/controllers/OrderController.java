package org.example.controllers;

import org.example.entities.Order;
import org.example.repository.OrderRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/{id}")
    public Order getOrder(@PathVariable long id){
        return orderRepository.getById(id);
    }

    @RequestMapping("/orders")
    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }



}
