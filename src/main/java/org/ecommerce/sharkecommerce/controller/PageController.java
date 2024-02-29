package org.ecommerce.sharkecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String homePage(Model model){

        return "index";
    }

    @GetMapping("/admin")
    public String adminDashboard(Model model){

        return "admin/adminDashboard";
    }

    @GetMapping("/seller")
    public String sellerDashboard(Model model){

        return "seller/sellerDashboard";
    }

    @GetMapping("/user")
    public String userDashboard(Model model){

        return "user/userDashoard";
    }
}
