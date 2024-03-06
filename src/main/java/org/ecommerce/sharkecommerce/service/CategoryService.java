package org.ecommerce.sharkecommerce.service;



import org.ecommerce.sharkecommerce.model.Category;

import java.util.List;
import java.util.Locale;

public interface CategoryService {
    List<Category> findAll();
    void save(Category category);



}
