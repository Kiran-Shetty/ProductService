package dev.kiran.productservice.controllers;

import dev.kiran.productservice.models.Product;
import dev.kiran.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;
 // Nothing

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public void getAllProducts() {

    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        productService.getProductDetails(id);
        return null;
    }

    public void createProduct() {

    }


}
