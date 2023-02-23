package com.example.webshop.domain.user;

import com.example.webshop.domain.product.Product;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserService {
    List<User> findAll();
    User findById(UUID id);
    User save(User user);
    void deleteById(UUID id);
    User updateUser(User user);

    List<Product> getProductsById(UUID uId);
}
