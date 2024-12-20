package com.scaler.productservice.controllers;


import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/products")
    public void getAllProducts() {

    }
    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id){
       return productServices.getProductDetails(id);
    }

    public void createProduct() {

    }
}
