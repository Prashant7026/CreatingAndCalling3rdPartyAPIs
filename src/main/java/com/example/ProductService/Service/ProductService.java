package com.example.ProductService.Service;

import com.example.ProductService.Exception.ProductNotFoundException;
import com.example.ProductService.Models.Category;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;

    public Product createProduct(Product product) {
        Category categoryToPutInProduct = this.categoryToPutInProduct(product);
        product.setCategory(categoryToPutInProduct);

        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product partialUpdate(Long productId, Product product) {
        Optional<Product> productToUpdateOptional = this.findById(productId);
        if (productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }
        Product productToUpdate = productToUpdateOptional.get();

        if (product.getTitle() != null) {
            productToUpdate.setTitle(product.getTitle());
        }
        if (product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }
        if (product.getPrice() != null) {
            productToUpdate.setPrice(product.getPrice());
        }
        if (product.getCategory() != null && product.getCategory().getName() != null) {
            Category categoryToPutInProduct = this.categoryToPutInProduct(product);
            productToUpdate.setCategory(categoryToPutInProduct);
        }

        return productRepository.save(productToUpdate);
    }

    // This function firstly check if category available then it will return category else it'll save new category then will return.
    private Category categoryToPutInProduct(Product product) {
        String categoryName = product.getCategory().getName();
        Optional<Category> category = categoryService.findByName(categoryName);
        Category categoryToPutInProduct = null;
        if (category.isEmpty()) {
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);

            categoryToPutInProduct = categoryService.save(toSaveCategory);
        } else {
            categoryToPutInProduct = category.get();
        }

        return categoryToPutInProduct;
    }
}
