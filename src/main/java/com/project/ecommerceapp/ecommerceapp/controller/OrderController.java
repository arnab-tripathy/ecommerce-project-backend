package com.project.ecommerceapp.ecommerceapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
}
