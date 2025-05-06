package com.example.ProductService.Controller;

@RestController
public class ProductController {
    @RequestMapping(name = "NAMAN", value = "/products")
    public String namanMethod() {
        return "Magic";
    }

}
