package dev.kiran.productservice.controllers;

import dev.kiran.productservice.dtos.ErrorDto;
import dev.kiran.productservice.dtos.FakeStoreCreateProductDtos;
import dev.kiran.productservice.exceptions.ProductNotFoundException;
import dev.kiran.productservice.models.Product;
import dev.kiran.productservice.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    private RestTemplate restTemplate;
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductDetails(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody FakeStoreCreateProductDtos responseDtos) {
        return productService.createProduct(responseDtos.getTitle(), responseDtos.getDescription(), responseDtos.getImage(), responseDtos.getPrice(), responseDtos.getCategory());
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
       return productService.deleteProduct(id);

    }

}