package com.project.ecommerceapp.ecommerceapp.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.Product;
import com.project.ecommerceapp.ecommerceapp.Entity.ShoppingCart;
import com.project.ecommerceapp.ecommerceapp.Entity.ShoppingCartItem;
import com.project.ecommerceapp.ecommerceapp.Entity.User;
import com.project.ecommerceapp.ecommerceapp.Model.AddToCartRequest;
import com.project.ecommerceapp.ecommerceapp.Model.CartResponse;
import com.project.ecommerceapp.ecommerceapp.Model.ProductDTO;
import com.project.ecommerceapp.ecommerceapp.Repository.CartItemRepository;
import com.project.ecommerceapp.ecommerceapp.Repository.CartRepository;
import com.project.ecommerceapp.ecommerceapp.Repository.ProductRepository;
import com.project.ecommerceapp.ecommerceapp.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements  CartService {

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartRepository cartRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;
    private static Logger logger= LoggerFactory.getLogger(CartServiceImpl.class);
    @Override
    public void addToCart(AddToCartRequest addToCartRequest) {
        ShoppingCartItem shoppingCartItem=new ShoppingCartItem();
        logger.info(addToCartRequest.getUserEmail());
        User user=userRepository.findByEmail(addToCartRequest.getUserEmail()).get();


        ShoppingCart userCart=cartRepo.findByUserId(user.getId());
        ShoppingCartItem shoppingCartItemExisting=cartItemRepository.findByCartAndProductId(userCart.getId(),addToCartRequest.getProductId());

        if(shoppingCartItemExisting!=null){
            logger.info("exist");
            shoppingCartItemExisting.setQuantity(shoppingCartItemExisting.getQuantity()+1);
            cartItemRepository.save(shoppingCartItemExisting);
        }
        else {
            shoppingCartItem.setProductId(addToCartRequest.getProductId());
            shoppingCartItem.setCartId(userCart.getId());
            cartItemRepository.save(shoppingCartItem);
        }
    }

    @Override
    public List<CartResponse> getCartProducts(String username) {
        User user=userRepository.findByEmail(username).get();

        ShoppingCart shoppingCart=cartRepo.findByUserId(userRepository.findByEmail(username).get().getId());
        List<ShoppingCartItem> shoppingCartItems=cartItemRepository.findByCartId(shoppingCart.getId());
        //List<Integer> productIds=shoppingCartItem.stream().map(ShoppingCartItem::getProductId).collect(Collectors.toList());
        List<CartResponse> cartResponses=new ArrayList<>();
        List<Product> productList=new ArrayList<>();
       shoppingCartItems.forEach(item->{
           CartResponse cartResponse=new CartResponse();
                cartResponse.setProduct(productRepository.findById(item.getProductId()).get());
                cartResponse.setQuantity(item.getQuantity());
                cartResponses.add(cartResponse);

       });
    return cartResponses;
    }
}
