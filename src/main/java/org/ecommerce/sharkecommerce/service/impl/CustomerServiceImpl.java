package org.ecommerce.sharkecommerce.service.impl;

import jakarta.servlet.http.HttpSession;
import org.ecommerce.sharkecommerce.DTO.CustomerDTO;
import org.ecommerce.sharkecommerce.model.Customer;
import org.ecommerce.sharkecommerce.repo.CustomerRepo;
import org.ecommerce.sharkecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer checkEmail(String email){

        Customer customer = customerRepo.findByEmail(email).orElse(
                (null)
        );


       return customer;
    }

    @Override
    public Customer create(CustomerDTO customerDTO){


        String encodedPassword = new BCryptPasswordEncoder().encode(customerDTO.getPassword());
//        System.out.println(encodedPassword);
//
//        System.out.println(bCryptPasswordEncoder.matches("asdf", encodedPassword));

        Customer customer = Customer
                .builder()
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .password(encodedPassword)
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        return customerRepo.save(customer);
    }
}
