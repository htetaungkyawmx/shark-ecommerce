package org.ecommerce.sharkecommerce.service.impl;

import org.ecommerce.sharkecommerce.DTO.CustomerDTO;
import org.ecommerce.sharkecommerce.model.Customer;
import org.ecommerce.sharkecommerce.repo.CustomerRepo;
import org.ecommerce.sharkecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public String checkEmail(String email){

        Customer customer = customerRepo.findByEmail(email).orElseThrow(
                ()-> new IllegalArgumentException("New Mail")
        );


       return customer.getEmail();
    }

    @Override
    public Customer create(CustomerDTO customerDTO){

        String email = customerDTO.getEmail();

        String existingCustomer = checkEmail(email);

        if (existingCustomer != null){
            System.out.println("This email" + existingCustomer + " have mail");
        }else{
            Customer customer = Customer
                    .builder()
                    .name(customerDTO.getName())
                    .email(customerDTO.getEmail())
                    .password(customerDTO.getPassword())
                    .createAt(LocalDateTime.now())
                    .updateAt(LocalDateTime.now())
                    .build();


            return customerRepo.save(customer);
        }

        return null;
    }
}
