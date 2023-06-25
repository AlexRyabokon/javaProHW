package org.example;

public class OrderControllerBuilder {
    private OrderRepository orderRepository;

    public OrderControllerBuilder setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        return this;
    }

    public OrderController createOrderController() {
        return new OrderController(orderRepository);
    }
}