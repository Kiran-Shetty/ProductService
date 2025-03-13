package dev.kiran.productservice.dtos;

import dev.kiran.productservice.models.Category;
import dev.kiran.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDtos {
    private Long id;
    private String title;
    private String price;
    private String description;
    private String image;
    private String category;

    public Product toProduct(){

        Product product = new Product();
        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setPrice(Double.parseDouble(getPrice()));
        product.setImageUrl(getImage());

        Category category = new Category();

        category.setName(getCategory());
        product.setCategory(category);

        return product;
    }
}
