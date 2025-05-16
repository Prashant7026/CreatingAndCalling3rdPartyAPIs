package com.example.ProductService.Service;

import com.example.ProductService.Models.Category;
import com.example.ProductService.Repository.CategoryRepository;

import java.util.Optional;

public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
