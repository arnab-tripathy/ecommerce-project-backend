package com.project.ecommerceapp.ecommerceapp.Model;

import com.project.ecommerceapp.ecommerceapp.Entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartResponse {
    private Product product;
    private int quantity;

}
