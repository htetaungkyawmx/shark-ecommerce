package org.ecommerce.sharkecommerce.controller;

import jakarta.validation.Valid;
import org.ecommerce.sharkecommerce.DTO.ProductDTO;
import org.ecommerce.sharkecommerce.model.Category;
import org.ecommerce.sharkecommerce.model.Product;
import org.ecommerce.sharkecommerce.repo.ProductRepo;
import org.ecommerce.sharkecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductService productService;


    @GetMapping("/all")
    public String showProductList(Model model){
        List<Product>products = productService.findAll();
        model.addAttribute("product",products);
        return "product/product";
//        model.addAttribute("products", new Product());
//        return "product/product";
    }

    @GetMapping("/show")
    public String showProductForm(Model model){
        model.addAttribute("product",new Product());
        return "product/createProduct";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes,Model model){
        productService.save(product);
        redirectAttributes.addAttribute("success",true);
        return "redirect:/product/all";
    }

//    @GetMapping("/create")
//    public String showCreatePage(Model model) {
//        ProductDTO productDTO = new ProductDTO();
//        model.addAttribute("productDto", productDTO);
//        return "product/createProduct";
//    }

//    @PostMapping("/create")
//    public String createProduct(
//             @ModelAttribute ProductDTO productDTO, BindingResult result
//    ) {
//
//        if (productDTO.getProductImage().isEmpty()) {
//            result.addError(new FieldError("productDto","imageFile", "The image file is required"));
//        }
//
//        if (result.hasErrors()) {
//            return "product/createProduct";
//        }
//
//        productService.createProduct(productDTO);
//
//        return "redirect:/product";
//    }

    @GetMapping("/edit")
    public String showProductUpdate(@RequestParam("id") long id, Model model) {
        System.out.println("RIT" + id);
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        ProductDTO productDto = new ProductDTO();
        productDto.setProductName(product.getProductName());
        productDto.setBrand(product.getBrand());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());

        model.addAttribute("productDto", productDto);
        return "product/editProduct";
    }


    @PostMapping("/edit")
    public String productUpdate(@RequestParam("id") int id, @ModelAttribute ProductDTO productDto, BindingResult result, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("productDto", productDto);


        if (productDto.getProductImage().isEmpty()) {
            result.addError(new FieldError("productDto","imageFile", "The image file is required"));
        }
        productService.updateProduct(productDto,id);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }


}
