package org.ecommerce.sharkecommerce.service;

import org.ecommerce.sharkecommerce.DTO.ProductDTO;
import org.ecommerce.sharkecommerce.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    void createProduct(ProductDTO productDTO);
    Product getProductById(long id);
    void updateProduct(ProductDTO productDTO,int id);
    void deleteById(long id);
    List<Product> getFourProducts();
    List<Product> getProductsByIds(List<Integer> productIds);
}
