package org.ecommerce.sharkecommerce.repo;

import org.ecommerce.sharkecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    Product findById(long id);
}
