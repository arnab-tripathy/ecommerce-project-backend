package com.project.ecommerceapp.ecommerceapp.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.Address;
import com.project.ecommerceapp.ecommerceapp.Entity.User;
import com.project.ecommerceapp.ecommerceapp.Model.AddAddressRequest;
import com.project.ecommerceapp.ecommerceapp.Repository.AddressRepository;
import com.project.ecommerceapp.ecommerceapp.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements  OrderService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

private static Logger logger= LoggerFactory.getLogger(OrderServiceImpl.class);
    @Override
    public void addnewAddress(AddAddressRequest addAddressRequest) {

        Address address= addAddressRequest.getAddress();

       // BeanUtils.copyProperties(addAddressRequest,address);
        logger.info("addess transformed"+address.toString());
        Optional<User> user= userRepository.findByEmail(addAddressRequest.getEmail());
                user.ifPresent(u->{
                    logger.info("user id"+u.getId());
                    address.setUserId(u.getId());
                });

       addressRepository.save(address);

    }

    @Override
    public List<Address> fetchAllAddress(String email) {
          List<Address>  addressList=new ArrayList<>();
        Optional<User> user= userRepository.findByEmail(email);
        user.ifPresent(u->{
            logger.info("user id"+u.getId());
            addressList.addAll(addressRepository.findByUserId(u.getId()));
        });
        return addressList;
    }
}
