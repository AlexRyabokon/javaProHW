package coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders;

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
    }


    public void add(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        order.setNumber(orders.size() + 1);
        orders.add(order);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return orders.remove(0);
    }

    public Order deliver(int number) {
        Order order = null;
        for (int i = 0; i < orders.size(); i++) {
            Order currentOrder = orders.get(i);
            if (currentOrder.getNumber() == number) {
                order = currentOrder;
                orders.remove(i);
                break;
            }
        }
        if (order == null) {
            throw new IllegalArgumentException("Order not found");
        }
        return order;
    }

    public void draw() {
        System.out.println("============= \nNum | Name");
        for (Order order : orders) {
            System.out.println(order.getNumber() + " | " + order.getName());
        }
    }
}
