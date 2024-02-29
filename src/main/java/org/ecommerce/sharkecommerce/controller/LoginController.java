package org.ecommerce.sharkecommerce.controller;

import org.ecommerce.sharkecommerce.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new Customer());
        return "registration/login";
    }


}
