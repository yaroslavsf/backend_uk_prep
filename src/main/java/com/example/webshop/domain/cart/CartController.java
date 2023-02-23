package com.example.webshop.domain.cart;

import com.example.webshop.domain.product.Product;
import com.example.webshop.domain.product.ProductService;
import com.example.webshop.domain.user.User;
import com.example.webshop.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RequestMapping("/cart")
@RestController
public class CartController {
    private CartService cartService;
    private UserService userService;
    private ProductService productService;

    @Autowired
    public CartController(CartService cartService, UserService userService, ProductService productService) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/add_product/{productId}/to_user/{userId}")
    public ResponseEntity<Void> addProductToUser(@PathVariable(value="productId") UUID pId, @PathVariable(value="userId") UUID uId) {
        Cart cart = cartService.findByUserId(uId);
        Product product = productService.findById(pId);
        cartService.addProductToCart(cart, product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_product/{productId}/from_user/{userId}")
    public ResponseEntity<Void> deleteProductToUser(@PathVariable(value="productId") UUID pId, @PathVariable(value="userId") UUID uId) {
        Cart cart = cartService.findByUserId(uId);
        Product product = productService.findById(pId);
        cartService.deleteProductFromCart(cart, product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get_all_product/by_user/{userId}")
    public ResponseEntity<List<Product>> retrieveProductsByUserId(@PathVariable(value="userId") UUID uId) {
        List<Product> products = userService.getProductsById(uId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
