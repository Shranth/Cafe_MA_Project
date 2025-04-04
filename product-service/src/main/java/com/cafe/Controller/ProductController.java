package com.cafe.Controller;

import com.cafe.Entity.Product;
import com.cafe.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully!";
    }

    @PutMapping("/{userId}/{productId}")
    public Product updateProduct(@PathVariable Long userId, @PathVariable Long productId, @RequestBody Product updatedProduct) {
        return productService.updateProduct(userId, productId, updatedProduct);
    }

    @PostMapping("/total-price")
    public double calculateTotalPrice(@RequestBody List<Long> productIds) {
        return productService.calculateTotalPrice(productIds);
    }
}