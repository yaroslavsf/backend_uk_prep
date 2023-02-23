package com.example.webshop.domain.cart;

import com.example.webshop.domain.product.Product;
import com.example.webshop.domain.user.User;

import java.util.List;
import java.util.UUID;

public interface CartService {
    void create(User user);

    void addProductToUser(User user, Product product);

    void addProductToCart(Cart cart, Product product);

    Cart findByUserId(UUID uId);

    void deleteProductFromCart(Cart cart, Product product);


}
