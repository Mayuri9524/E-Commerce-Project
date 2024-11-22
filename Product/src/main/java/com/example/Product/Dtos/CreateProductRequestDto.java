package com.example.Product.Dtos;

import com.example.Product.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageurl;
    private String category;

    public Product toProduct()
    {
        Product product= new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setCategory(this.category);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageurl(this.imageurl);
        return product;
    }
}
