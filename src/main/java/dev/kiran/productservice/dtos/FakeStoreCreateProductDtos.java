package dev.kiran.productservice.dtos;

import dev.kiran.productservice.models.Category;
import dev.kiran.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductDtos {
    String title;
    String description;
    String image;
    double price;
    String category;

    public Product toProduct(){

        Product product = new Product();

        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(getPrice());
        product.setImageUrl(getImage());

        Category category = new Category();

        category.setName(getCategory());
        product.setCategory(category);

        return product;
    }
}
