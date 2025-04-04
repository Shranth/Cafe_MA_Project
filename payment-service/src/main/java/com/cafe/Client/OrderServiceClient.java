package com.cafe.Client;

import com.cafe.DTO.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service")
public interface OrderServiceClient {
    @PutMapping("/orders/{id}/payment-status")
    void updatePaymentStatus(@PathVariable Long id, @RequestParam String paymentStatus);

    @GetMapping("/orders/{orderId}")
    Order getOrderById(@PathVariable Long orderId);
}
