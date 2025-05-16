package com.example.ProductService.Service;

import com.example.ProductService.Models.Product;
import com.example.ProductService.Repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
