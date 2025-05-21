package com.example.ProductService.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    @Column(nullable = false, unique = true, name = "category_Name")
    private String name;        // it's not null & unique in table
    @Basic(fetch = FetchType.LAZY)
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> featureProducts;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
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