package com.example.webshop.domain.user;

import com.example.webshop.domain.cart.CartService;
import com.example.webshop.domain.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private CartService cartService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, CartService cartService, UserMapper userMapper) {
        this.userService = userService;
        this.cartService = cartService;
        this.userMapper = userMapper;
    }

    @GetMapping("/get_all")
    public ResponseEntity<List<User>> retrieveAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/get_by_id/{id}")
    public ResponseEntity<User> retrieveById(@PathVariable(value="id") UUID id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        cartService.create(user);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value="id") UUID id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> replace(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }


}
