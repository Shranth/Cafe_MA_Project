package com.cafe.Controller;

import com.cafe.Entity.Order;
import com.cafe.Entity.OrderStatus;
import com.cafe.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        return orderService.updateOrderStatus(id, status);
    }

    @PutMapping("/{id}/payment-status")
    public Order updatePaymentStatus(@PathVariable Long id, @RequestParam String paymentStatus) {
        return orderService.updatePaymentStatus(id, paymentStatus);
    }

    @GetMapping()
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }
}
