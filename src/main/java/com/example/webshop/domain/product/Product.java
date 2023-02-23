package com.example.webshop.domain.product;

import com.example.webshop.domain.cart.Cart;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@closureId")
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column
    private BigDecimal price;
    @Column
    private String name;
//    @JsonBackReference
    @ManyToMany(mappedBy = "productsInCart")
    List<Cart> carts;

}
