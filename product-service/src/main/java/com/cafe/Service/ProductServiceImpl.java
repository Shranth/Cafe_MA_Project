package com.cafe.Service;


import com.cafe.Client.UserFeignClient;
import com.cafe.DTO.UserDTO;
import com.cafe.Entity.Product;
import com.cafe.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
     @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id); // Delete function implementation
    }

    @Override
    public Product updateProduct(Long userId, Long productId, Product updatedProduct) {
        UserDTO user = userFeignClient.getUserById(userId);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        System.out.println("Received User Data: " + user.getUsername() + " | Role: " + user.getRole());

        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setCategory(updatedProduct.getCategory());
            return productRepository.save(product);
        } else {
            System.out.println("Forbidden: User " + user.getUsername() + " tried to update product.");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Only admins can update products.");
        }
    }

    public double calculateTotalPrice(List<Long> productIds) {
        return productRepository.findAllById(productIds)
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
