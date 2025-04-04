package com.cafe.Controller;

import com.cafe.Client.OrderServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private OrderServiceClient orderServiceClient;

    @PostMapping("/process")
    public String processPayment(@RequestParam Long userId, @RequestParam Long orderId) {
        orderServiceClient.updatePaymentStatus(orderId, "COMPLETE");
        return "Payment Success";
    }
}
