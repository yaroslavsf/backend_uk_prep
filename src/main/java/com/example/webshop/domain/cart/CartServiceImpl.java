package com.example.webshop.domain.cart;

import com.example.webshop.domain.product.Product;
import com.example.webshop.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void create(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        this.cartRepository.save(cart);
    }

    @Override
    public void addProductToUser(User user, Product product) {

    }

    @Override
    public void addProductToCart(Cart cart, Product product) {
        cart.getProductsInCart().add(product);
        cartRepository.save(cart);
    }

    @Override
    public Cart findByUserId(UUID uId) {
       return cartRepository.findByUserId(uId);
    }

    @Override
    public void deleteProductFromCart(Cart cart, Product product) {
        cart.getProductsInCart().remove(product);
        cartRepository.save(cart);
    }


}
