package com.example.ProductService.Controller;

import com.example.ProductService.DTO.Product.*;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Service.ProductServiceDBImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceDBImp productServiceDBImp;

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto productRequestDto) {
        Product product = productServiceDBImp.createProduct(productRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping("")
    public List<CreateProductResponseDto> getAllProduct() {
        List<CreateProductResponseDto> responseProductDto = new ArrayList<>();

        List<Product> products = productServiceDBImp.findAll();
        for (Product product : products) {
            responseProductDto.add(CreateProductResponseDto.fromProduct(product));
        }
        return responseProductDto;
    }

//    @GetMapping("/{id}")
//    public String getSingleProduct(@PathVariable("id") int id) {
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable("id") int id) {
//
//    }
//
    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(@PathVariable("id") Long id, @RequestBody CreateProductDto createProductDto) {
        Product product = productServiceDBImp.partialUpdate(id, createProductDto.toProduct());
        PatchProductResponseDto responseDto = new PatchProductResponseDto();
        responseDto.setProduct(GetProductDto.from(product));

        return responseDto;
    }
//
//    @PutMapping("")
//    public void replaceProduct() {
//
//    }

    /*
    @RequestMapping(name = "NAMAN", value = "/products")
    public String namanMethod() {
        return "Magic";
    }
     */

}
