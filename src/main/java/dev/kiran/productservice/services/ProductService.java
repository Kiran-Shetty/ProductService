package dev.kiran.productservice.services;

import dev.kiran.productservice.exceptions.ProductNotFoundException;
import dev.kiran.productservice.models.Product;

import java.util.List;

public interface ProductService{


    public Product getProductDetails(Long id) throws ProductNotFoundException;

    public Product createProduct(String title, String description, String image, double price, String category);

    public List<Product> getAllProducts();

    public String deleteProduct(Long id);


}
