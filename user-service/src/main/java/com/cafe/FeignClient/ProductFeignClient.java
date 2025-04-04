package com.cafe.FeignClient;
import com.cafe.DTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// ✅ Feign Client calls Product Service
@FeignClient(name = "product-service", url = "http://localhost:8082/products")
public interface ProductFeignClient {

    @GetMapping
    List<ProductDTO> getAllProducts();

    @GetMapping("/{id}")
    ProductDTO getProductById(@PathVariable Long id);
}