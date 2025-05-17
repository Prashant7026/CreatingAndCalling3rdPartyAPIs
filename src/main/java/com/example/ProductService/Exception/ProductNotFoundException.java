package com.example.ProductService.Exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
