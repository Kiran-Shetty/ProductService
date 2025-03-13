package dev.kiran.productservice.services;

import dev.kiran.productservice.dtos.FakeStoreCreateProductDtos;
import dev.kiran.productservice.dtos.FakeStoreProductDtos;
import dev.kiran.productservice.models.Category;
import dev.kiran.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductDetails(Long id) {
        FakeStoreProductDtos responseDtos =
        restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDtos.class);

        return responseDtos.toProduct();
    }

    @Override
    public Product createProduct(String title, String description, String image, double price, String category) {
        FakeStoreCreateProductDtos requestDto = new FakeStoreCreateProductDtos();
        requestDto.setTitle(title);
        requestDto.setDescription(description);
        requestDto.setPrice(price);
        requestDto.setImage(image);
        requestDto.setCategory(category);

        FakeStoreCreateProductDtos responseDto = restTemplate.postForObject("https://fakestoreapi.com/products", requestDto, FakeStoreCreateProductDtos.class);

        return responseDto.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDtos[] responseDto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDtos[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDtos dto : responseDto){
            products.add(dto.toProduct());
        }

        return products;
    }




}
