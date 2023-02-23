package com.example.webshop.domain.user;

import com.example.webshop.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        Optional<User> userFromDb =  userRepository.findById(id);
        if (!userFromDb.isPresent()) throw new NoSuchElementException();
        User u = userFromDb.get();
        return u;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
//        Optional<User> userFromDb = userRepository.findById(user.getId());
//        if (!userFromDb.isPresent()) throw new NoSuchElementException();
//        // TODO: automaticaly map all fields
//        User u = userFromDb.get();
//        u.setName(user.getName());
//        u.setSurname(user.getSurname());
//        userRepository.save(u);
//        return u;
        return null;
    }

    @Override
    public List<Product> getProductsById(UUID uId) {
        User u = this.findById(uId);
       List<Product> products =  u.getCart().getProductsInCart().stream().toList();
       return products;
    }
}
