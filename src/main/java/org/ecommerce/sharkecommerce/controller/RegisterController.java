package org.ecommerce.sharkecommerce.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.ecommerce.sharkecommerce.DTO.CustomerDTO;
import org.ecommerce.sharkecommerce.model.Customer;
import org.ecommerce.sharkecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    @GetMapping("/invalidateSession")
    public String invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "Session invalidated";
    }

    @PostMapping("/register/create")
    public String createAcc(@Valid CustomerDTO customerDTO, BindingResult bindResult, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        if (bindResult.hasErrors() || !customerDTO.getPassword().equals(customerDTO.getConfirmPassword())) {
            session.setAttribute("wrongPassword", new CustomerDTO());
            return "redirect:/register";
        } else {
            String email = customerDTO.getEmail();
            Customer existingCustomer = customerService.checkEmail(email);

            if (existingCustomer != null){
                session.setAttribute("loggedInCustomer", existingCustomer);
                session.removeAttribute("wrongPassword");

                return "redirect:/register";
            } else {
                customerService.create(customerDTO);

                return "redirect:/login";

            }

        }

//        session.invalidate();

//        return null;
    }

}
