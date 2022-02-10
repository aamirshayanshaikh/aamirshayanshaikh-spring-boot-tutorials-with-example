package com.example.springaopaamir.security_basic;

import lombok.Data;

@Data
public class CustomerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
