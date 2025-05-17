package com.example.ProductService.Controller;

import com.example.ProductService.DTO.Product.*;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto productRequestDto) {
        Product product = productService.createProduct(productRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public List<CreateProductResponseDto> getAllProduct() {
        List<CreateProductResponseDto> responseProductDto = new ArrayList<>();

        List<Product> products = productService.findAll();
        for (Product product : products) {
            responseProductDto.add(CreateProductResponseDto.fromProduct(product));
        }
        return responseProductDto;
    }
    @RequestMapping(name = "NAMAN", value = "/products")
    public String namanMethod() {
        return "Magic";
    }

}
