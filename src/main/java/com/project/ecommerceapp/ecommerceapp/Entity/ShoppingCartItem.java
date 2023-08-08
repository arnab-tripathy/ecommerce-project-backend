package com.project.ecommerceapp.ecommerceapp.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shopping_cart_item")
@Getter
@Setter
public class ShoppingCartItem {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "quantity")
    private  int quantity;


}
