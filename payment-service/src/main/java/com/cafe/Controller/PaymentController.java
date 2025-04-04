package com.cafe.Controller;

import com.cafe.Client.OrderServiceClient;
import com.cafe.DTO.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private OrderServiceClient orderServiceClient;

    @PostMapping("/process")
    public String processPayment(@RequestParam Long userId, @RequestParam Long orderId) {
        Order order = orderServiceClient.getOrderById(orderId);

        if (order == null) {
            return "Order not found!";
        }

        if (!order.getUserId().equals(userId)) {
            return "Payment Failed: User is not authorized to pay for this order!";
        }

        orderServiceClient.updatePaymentStatus(orderId, "COMPLETE");
        return "Payment Success";
    }
}
