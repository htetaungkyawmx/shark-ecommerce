package org.ecommerce.sharkecommerce.service.impl;


import org.ecommerce.sharkecommerce.model.Category;
import org.ecommerce.sharkecommerce.repo.CategoryRepo;
import org.ecommerce.sharkecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);

    }
}
