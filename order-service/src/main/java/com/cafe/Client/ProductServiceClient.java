package com.cafe.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductServiceClient {
    @GetMapping("/products/{id}")
    Object getProductById(@PathVariable Long id);

    @PostMapping("/products/total-price")
    double calculateTotalPrice(@RequestBody List<Long> productIds);
}