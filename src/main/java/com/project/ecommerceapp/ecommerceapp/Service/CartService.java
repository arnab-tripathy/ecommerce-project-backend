package com.project.ecommerceapp.ecommerceapp.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.Product;
import com.project.ecommerceapp.ecommerceapp.Model.AddToCartRequest;
import com.project.ecommerceapp.ecommerceapp.Model.CartResponse;
import com.project.ecommerceapp.ecommerceapp.Model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    public void addToCart(AddToCartRequest addToCartRequest);

    public List<CartResponse> getCartProducts(String UserId);

    public void removeFromCart(Integer productId,String userEmail);
}
