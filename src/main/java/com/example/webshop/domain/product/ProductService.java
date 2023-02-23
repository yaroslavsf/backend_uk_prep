package com.example.webshop.domain.product;

import com.example.webshop.domain.user.User;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> findAll();
    Product findById(UUID pId);
    Product save(Product product);
    void deleteById(UUID id);
    Product updateProduct(Product product);
}
