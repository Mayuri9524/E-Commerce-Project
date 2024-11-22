package com.example.Product.Dtos;

import com.example.Product.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductResponseDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private  String image;
    private String category;

    public Product toProduct()
    {
        Product product= new Product();
        product.setId(this.getId());
        product.setTitle(this.getTitle());
        product.setCategory(this.getCategory());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setImageurl(this.getImage());
        return product;
    }
}
