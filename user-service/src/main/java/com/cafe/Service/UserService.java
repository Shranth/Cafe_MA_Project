package com.cafe.Service;

import com.cafe.DTO.ProductDTO;
import com.cafe.Entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    List<ProductDTO> fetchAllProducts();
    ProductDTO fetchProductById(Long productId);
    User updateUser(Long id, User updatedUser);
    boolean deleteUser(Long id);
}