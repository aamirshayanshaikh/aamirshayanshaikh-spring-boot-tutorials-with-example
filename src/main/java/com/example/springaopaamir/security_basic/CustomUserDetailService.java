package com.example.springaopaamir.security_basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("customUserService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final CustomerEntity customer = customerRepository.findByEmail(username);
        if(customer ==null){
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(customer.getEmail()).password(customer.getPassword()).authorities("USER").build();
        return user;
    }
}