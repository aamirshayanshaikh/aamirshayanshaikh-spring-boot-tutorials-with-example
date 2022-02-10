package com.example.springaopaamir.security_basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RegistrationController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity getRegistrationView(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.saveCustomer(customerDto));
    }
}
