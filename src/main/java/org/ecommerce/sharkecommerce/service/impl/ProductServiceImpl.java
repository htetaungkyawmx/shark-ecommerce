package org.ecommerce.sharkecommerce.service.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.ecommerce.sharkecommerce.DTO.ProductDTO;
import org.ecommerce.sharkecommerce.model.Product;
import org.ecommerce.sharkecommerce.repo.ProductRepo;
import org.ecommerce.sharkecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private ProductRepo productRepo;


    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        MultipartFile image = productDTO.getProductImage();
        Date createdAt = new Date();
        String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();

        try {
            String uploadDir = "public/images/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }


        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }

        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setBrand(productDTO.getBrand());

        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());

        product.setProductImage(storageFileName);

        productRepo.save(product);
    }

    @Override
    public Product getProductById(long id) {
        return productRepo.findById(id);
    }


    @Override
    public void updateProduct(ProductDTO productDTO, int id) {
        Optional<Product> optionalExistingProduct = Optional.ofNullable(productRepo.findById(id));
        if (optionalExistingProduct.isPresent()) {
            Product existingProduct = optionalExistingProduct.get();

            // Update the product information
            existingProduct.setProductImage(String.valueOf(productDTO.getProductImage()));
            existingProduct.setBrand(productDTO.getBrand());

            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setDescription(productDTO.getDescription());

            // Check if a new image is provided
//            MultipartFile image = productDTO.getProductImage();
//            if (image != null && !image.isEmpty()) {
//                try {
//                    Date createdAt = new Date();
//                    String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();
//
//                    // Save the new image file
//                    String uploadDir = "public/images/";
//                    Path uploadPath = Paths.get(uploadDir);
//                    if (!Files.exists(uploadPath)) {
//                        Files.createDirectories(uploadPath);
//                    }
//                    try (InputStream inputStream = image.getInputStream()) {
//                        Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
//                                StandardCopyOption.REPLACE_EXISTING);
//                    }
//
//                    // Set the new image file name
//                    existingProduct.setProductImage(storageFileName);
//                } catch (IOException ex) {
//                    System.out.println("Error saving new image file: " + ex.getMessage());
//                }
//            }
            // Save the updated product to the repository
            productRepo.save(existingProduct);
        } else {
            System.out.println("Product with ID " + id + " not found");
        }
    }

    @Override
    public void deleteById(long id) {
        Product product = productRepo.findById(id);

    }

    @Override
    public List<Product> getFourProducts() {
        return null;
    }

    @Override
    public List<Product> getProductsByIds(List<Integer> productIds) {
        return null;
    }


}

//    @Override
//    public void deleteById(Integer id) {
//        Product product = productRepo.findById(id);
//        if (product!=null) {
//            String storageFileName = product.getProductImage();
//            if (storageFileName != null && !storageFileName.isEmpty()) {
//                try {
//                    Files.deleteIfExists(Paths.get("public/images/" + storageFileName));
//                } catch (IOException e) {
//                    System.out.println("Error deleting image file: " + e.getMessage());
//                }
//            }
//            productRepo.deleteById((int)id);
//        }
//    }

