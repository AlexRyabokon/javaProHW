package org.example;

import org.example.entities.Order;
import org.example.entities.Product;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet
public class OrderServlet extends HttpServlet {
    private Map<Integer, Order> orders = new HashMap<>();
    private int nextOrderId = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            getAllOrders(request, response);
        } else {
            String orderIdString = pathInfo.substring(1);
            try {
                int orderId = Integer.parseInt(orderIdString);
                getOrderById(request, response, orderId);
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Invalid order ID");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Order order = readOrderFromRequest(request);
        int orderId = addOrder(order);
        response.getWriter().println("Order created with ID: " + orderId);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Order ID is missing in the request URL");
        } else {
            String orderIdString = pathInfo.substring(1);
            try {
                int orderId = Integer.parseInt(orderIdString);
                Order order = readOrderFromRequest(request);
                boolean updated = updateOrder(orderId, order);
                if (updated) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().println("Order updated successfully");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().println("Order not found");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Invalid order ID");
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Order ID is missing in the request URL");
        } else {
            String orderIdString = pathInfo.substring(1);
            try {
                int orderId = Integer.parseInt(orderIdString);
                boolean deleted = deleteOrder(orderId);
                if (deleted) {
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.getWriter().println("Order deleted successfully");
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    response.getWriter().println("Order not found");
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Invalid order ID");
            }
        }
    }

    private void getAllOrders(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Order> orderList = new ArrayList<>(orders.values());
        response.setContentType("application/json");
        response.getWriter().println(orderList);
    }

    private void getOrderById(HttpServletRequest request, HttpServletResponse response, int orderId)
            throws IOException {
        Order order = orders.get(orderId);
        if (order != null) {
            response.setContentType("application/json");
            response.getWriter().println(order);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println("Order not found");
        }
    }

    private Order readOrderFromRequest(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String date = request.getParameter("date");
        int cost = Integer.parseInt(request.getParameter("cost"));

        List<Product> products = new ArrayList<>();
        String[] productIds = request.getParameterValues("productIds");
        String[] productNames = request.getParameterValues("productNames");
        String[] productCosts = request.getParameterValues("productCosts");

        for (int i = 0; i < productIds.length; i++) {
            int productId = Integer.parseInt(productIds[i]);
            String productName = productNames[i];
            double productCost = Double.parseDouble(productCosts[i]);
            Product product = new Product(productId, productName, productCost);
            products.add(product);
        }

        return new Order(id,date,  cost,  products);
    }

    private int addOrder(Order order) {
        int orderId = nextOrderId++;
        order.setId(orderId);
        orders.put(orderId, order);
        return orderId;
    }

    private boolean updateOrder(int orderId, Order updatedOrder) {
        Order existingOrder = orders.get(orderId);
        if (existingOrder != null) {
            updatedOrder.setId(orderId);
            orders.put(orderId, updatedOrder);
            return true;
        }
        return false;
    }

    private boolean deleteOrder(int orderId) {
        return orders.remove(orderId) != null;
    }
}
