package org.ecommerce.sharkecommerce.controller;


import org.ecommerce.sharkecommerce.model.Category;
import org.ecommerce.sharkecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public String showCategory(Model model){
        List<Category> categories = categoryService.findAll();
        System.out.println(categories);
        model.addAttribute("categories",categories);
        return "product/category";
    }

    @GetMapping("/show")
    public String showCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return "product/categoryForm";
    }
    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
//        List<Category> categories =
        categoryService.save(category);
        redirectAttributes.addAttribute("success",true);
        return "product/category";
    }
}
