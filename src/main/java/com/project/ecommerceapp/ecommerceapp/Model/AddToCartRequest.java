package com.project.ecommerceapp.ecommerceapp.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartRequest {
    private int productId;
    private String userEmail;
    private String phoneNumber;
}
