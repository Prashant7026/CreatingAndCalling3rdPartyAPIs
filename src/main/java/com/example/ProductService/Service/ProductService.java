package com.example.ProductService.Service;

import com.example.ProductService.Models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product partialUpdate(Long productId, Product product);
}
