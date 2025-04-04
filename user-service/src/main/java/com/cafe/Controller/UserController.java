package com.cafe.Controller;

import com.cafe.DTO.ProductDTO;
import com.cafe.Entity.User;
import com.cafe.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
     UserService userService;


    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProductsFromProductService() {
        return userService.fetchAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDTO getProductByIdFromProductService(@PathVariable Long id) {
        return userService.fetchProductById(id);


    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
}