package com.project.ecommerceapp.ecommerceapp.controller;

import com.project.ecommerceapp.ecommerceapp.Entity.Product;
import com.project.ecommerceapp.ecommerceapp.Entity.ShoppingCart;
import com.project.ecommerceapp.ecommerceapp.Entity.ShoppingCartItem;
import com.project.ecommerceapp.ecommerceapp.Entity.User;
import com.project.ecommerceapp.ecommerceapp.Model.AddToCartRequest;
import com.project.ecommerceapp.ecommerceapp.Model.CartResponse;
import com.project.ecommerceapp.ecommerceapp.Repository.CartItemRepository;
import com.project.ecommerceapp.ecommerceapp.Repository.CartRepository;
import com.project.ecommerceapp.ecommerceapp.Repository.UserRepository;
import com.project.ecommerceapp.ecommerceapp.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

@Autowired
    CartService cartService;


    @PostMapping("/addtocart")
    public ResponseEntity<Boolean> addProductToCart(@RequestBody AddToCartRequest addToCartRequest){
        System.out.println("add to cart called");
    cartService.addToCart(addToCartRequest);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @DeleteMapping("/deletefromcart")
    public ResponseEntity<Boolean> deleteFromCart(@RequestParam Integer prodductId, @RequestParam String userEmail){

            cartService.removeFromCart(prodductId,userEmail);
            return new ResponseEntity<>(true,HttpStatus.OK);
    }



    @GetMapping("/getcartproducts")
    public List<CartResponse> getCartProducts(@RequestParam String userName){
        //CartResponse cartResponse=new CartResponse();
       // cartResponse.setProductList(productList);
        return cartService.getCartProducts(userName);

    }
}
