package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;

//The service layer should be implemented as interface so we can achieve loose coupling and modularity
public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
