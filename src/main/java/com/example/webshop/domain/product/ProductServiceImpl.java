package com.example.webshop.domain.product;

import com.example.webshop.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(UUID id) {
        Optional<Product> productFromDb =  productRepository.findById(id);
        if (!productFromDb.isPresent()) throw new NoSuchElementException();
        Product p = productFromDb.get();
        return p;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        //TODO: write method and implement lower todo
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
}
