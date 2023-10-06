package com.project.ecommerceapp.ecommerceapp.Model;

import com.project.ecommerceapp.ecommerceapp.Entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAddressRequest {
    private String email;
   private Address address;


}
