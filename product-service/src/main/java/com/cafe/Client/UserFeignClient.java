package com.cafe.Client;

import com.cafe.DTO.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")  // URL of User Service
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    UserDTO getUserById(@PathVariable Long id);
}