package com.example.webshop.domain.user;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> findAll();
    User findById(UUID id);
    User save(User user);
    void deleteById(UUID id);
    void updateUser(User user);
}
