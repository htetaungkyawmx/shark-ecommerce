package org.ecommerce.sharkecommerce.service.impl;

import org.ecommerce.sharkecommerce.DTO.CustomerDTO;
import org.ecommerce.sharkecommerce.model.Customer;
import org.ecommerce.sharkecommerce.repo.CustomerRepo;
import org.ecommerce.sharkecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer create(CustomerDTO customerDTO) {

        Customer cus = Customer
                .builder()
                .name(customerDTO.getName())
                .email(customerDTO.getEmail())
                .password(customerDTO.getPassword())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();


        return customerRepo.save(cus);
    }
}
