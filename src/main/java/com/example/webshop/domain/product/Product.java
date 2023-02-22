package com.example.webshop.domain.product;

import com.example.webshop.domain.cart.Cart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "product_id", nullable = false)
    private UUID id;
    @Column
    private int quantity;
    @Column
    private BigDecimal price;
    @Column
    private String name;


    @ManyToMany(mappedBy = "productsInCart")
    Set<Cart> carts;

}
