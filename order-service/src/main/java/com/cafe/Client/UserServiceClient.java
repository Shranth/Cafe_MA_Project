package com.cafe.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


    @FeignClient(name = "user-service")
    public interface UserServiceClient {
        @GetMapping("/users/{id}")
        Object getUserById(@PathVariable Long id);
    }
