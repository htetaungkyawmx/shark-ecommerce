package org.ecommerce.sharkecommerce.service;

import org.ecommerce.sharkecommerce.DTO.CustomerDTO;
import org.ecommerce.sharkecommerce.model.Customer;

public interface CustomerService {
    public Customer create(CustomerDTO customerDTO);
}
