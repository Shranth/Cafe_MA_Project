package com.cafe.Service;

import com.cafe.DTO.ProductDTO;
import com.cafe.Entity.User;
import com.cafe.FeignClient.ProductFeignClient;
import com.cafe.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private ProductFeignClient productFeignClient;



    @Override
    public User createUser(User user) {
        System.out.println("Saving user: " + user);
        return userRepository.save(user);
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = userRepository.findAll();
        System.out.println("Returning users: " + users);
        return users;
    }

    public List<ProductDTO> fetchAllProducts() {
        return productFeignClient.getAllProducts();
    }

    public ProductDTO fetchProductById(Long productId) {
        return productFeignClient.getProductById(productId);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }).orElse(null);
    }


    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}