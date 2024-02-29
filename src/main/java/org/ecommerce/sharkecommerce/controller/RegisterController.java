package org.ecommerce.sharkecommerce.controller;

import jakarta.validation.Valid;
import org.ecommerce.sharkecommerce.DTO.CustomerDTO;
import org.ecommerce.sharkecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userCustomerDTO", new CustomerDTO());
        return "registration/signup";
    }

    @PostMapping("/register/create")
    public String createAcc(@Valid CustomerDTO customerDTO, BindingResult bindResult, RedirectAttributes redirectAttributes){

        if (bindResult.hasErrors() || !customerDTO.getPassword().equals(customerDTO.getConfirmPassword())) {
            return "registration/signup";
        }

        customerService.create(customerDTO);




//        userService.create(user);

//        Customer customer = userCustomerDTO.getCustomer();
 //       User user = userCustomerDTO.getUser();

 //       userService.create(user);
//        userService.create(customer);


//        return null;
        return "redirect:/login";
    }
}
