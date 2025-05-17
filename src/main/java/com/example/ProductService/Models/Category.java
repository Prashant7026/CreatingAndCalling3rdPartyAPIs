package com.example.ProductService.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany
    private List<Product> featureProducts;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> allProducts;
}

/*
private List<Product> allProducts;

Problem ->
This creates an infinite recursive loop when serializing to JSON, because:
1. `Product` has a reference to `Category`
2. `Category` has a list of `Product`
3. Each `Product` again has `Category`
And so on...
This causes the kind of JSON output you're seeing — deeply nested, repeating objects.

Solution -> @JsonIgnore     It'll break the loop.

 */