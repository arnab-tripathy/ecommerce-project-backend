package com.project.ecommerceapp.ecommerceapp.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="shopping_cart")
@Getter
@Setter
public class ShoppingCart {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private  User user;
}
