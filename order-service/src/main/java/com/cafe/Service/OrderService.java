package com.cafe.Service;

import com.cafe.Entity.Order;
import com.cafe.Entity.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getOrdersByUserId(Long userId);
    Optional<Order> getOrderById(Long id);
    void deleteOrder(Long id);
    Order updatePaymentStatus(Long orderId, String paymentStatus);
    List<Order>getAllOrders();
    Order updateOrderStatus(Long id, OrderStatus status);

}