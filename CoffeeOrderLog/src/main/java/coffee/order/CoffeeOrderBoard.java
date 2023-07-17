package coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;


public class CoffeeOrderBoard {


    private static final Logger LOGGER = LogManager.getLogger(CoffeeOrderBoard.class);
    private List<Order> orders;

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
    }


    public void add(Order order) {
        if (order == null) {
            LOGGER.error("Order cannot be null", new RuntimeException());
        }
        order.setNumber(orders.size() + 1);
        orders.add(order);
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            LOGGER.error("Queue is empty", new RuntimeException());
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
            LOGGER.error("Order not found", new RuntimeException());
        }
        return order;
    }

    public String draw() {
        StringBuilder sb = new StringBuilder();

        sb.append("=============\n");
        sb.append("Num | Name\n");
        for (Order order : orders) {
            sb.append(order.getNumber() + " | " + order.getName() + "\n");
        }
        return sb.toString();
    }

}
