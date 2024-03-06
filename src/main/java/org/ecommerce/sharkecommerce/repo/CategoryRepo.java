package org.ecommerce.sharkecommerce.repo;

import org.ecommerce.sharkecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository <Category, Integer>{

}
