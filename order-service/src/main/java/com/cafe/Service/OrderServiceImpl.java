package com.cafe.Service;

import com.cafe.Client.ProductServiceClient;
import com.cafe.Client.UserServiceClient;
import com.cafe.Entity.Order;
import com.cafe.Entity.OrderStatus;
import com.cafe.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private ProductServiceClient productServiceClient;

    @Override
    public Order createOrder(Order order) {
        if (userServiceClient.getUserById(order.getUserId()) == null) {
            throw new RuntimeException("User not found");
        }

        for (Long productId : order.getProductIds()) {
            if (productServiceClient.getProductById(productId) == null) {
                throw new RuntimeException("Product ID " + productId + " not found");
            }
        }

        double totalAmount = productServiceClient.calculateTotalPrice(order.getProductIds());
        order.setTotalAmount(totalAmount);
        order.setStatus(OrderStatus.PENDING);
        order.setPaymentStatus("INCOMPLETE");

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrderStatus(Long id, OrderStatus status) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setStatus(status);
            return orderRepository.save(order);
        }
        throw new RuntimeException("Order not found");
    }

    @Override
    public Order updatePaymentStatus(Long orderId, String paymentStatus) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            Order order = orderOpt.get();
            order.setPaymentStatus(paymentStatus);
            return orderRepository.save(order);
        }
        throw new RuntimeException("Order not found");
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
