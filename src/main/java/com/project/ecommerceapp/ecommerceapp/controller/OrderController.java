package com.project.ecommerceapp.ecommerceapp.controller;

import com.project.ecommerceapp.ecommerceapp.Entity.Address;
import com.project.ecommerceapp.ecommerceapp.Model.AddAddressRequest;
import com.project.ecommerceapp.ecommerceapp.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/addAdress")
    public void addNewAdress(@RequestBody AddAddressRequest addAddressRequest){

        orderService.addnewAddress(addAddressRequest);

    }

    @GetMapping("/getAllAddress")
    public List<Address> getAllAddress (@RequestParam String userEmail){
        return orderService.fetchAllAddress(userEmail);
    }
}
