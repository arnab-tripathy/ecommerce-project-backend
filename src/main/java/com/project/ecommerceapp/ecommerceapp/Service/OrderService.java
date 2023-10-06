package com.project.ecommerceapp.ecommerceapp.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.Address;
import com.project.ecommerceapp.ecommerceapp.Model.AddAddressRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public  void addnewAddress(AddAddressRequest addAddressRequest);

    public List<Address> fetchAllAddress(String email);
}
