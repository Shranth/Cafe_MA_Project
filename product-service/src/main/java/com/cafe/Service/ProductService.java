package com.cafe.Service;

import com.cafe.Entity.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
    Product updateProduct(Long userId, Long productId, Product updatedProduct);
     double calculateTotalPrice(List<Long> productIds);
}
