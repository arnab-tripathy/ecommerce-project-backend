package com.project.ecommerceapp.ecommerceapp.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Address {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long addressId;

    @Column(name="firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name ="userId")
    private Long userId;

}
