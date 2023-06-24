package com.project.ecommerceapp.ecommerceapp.Model;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
private HttpStatus StatusCode;
private String message;
}
