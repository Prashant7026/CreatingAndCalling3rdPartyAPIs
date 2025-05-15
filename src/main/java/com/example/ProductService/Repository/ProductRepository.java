package com.example.ProductService.Repository;

import com.example.ProductService.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository annotations tells spring this is a special class, create an object of this particular class.
// If front of you don't see a class but behind the scene at the time of compilation spring will create a class.
// But this annotation is not mandatory coz technically It'll have repository. It's a good practice to annotate with @Repository.
// Can we not annotate with @Repository -> Yes
// Should we not annotate with @Repository -> No
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
