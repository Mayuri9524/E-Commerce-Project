package com.example.Product.Dtos;

import com.example.Product.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageurl;
    private String category;

    public static CreateProductResponseDto fromProduct(Product product)
    {
        CreateProductResponseDto response= new CreateProductResponseDto();
        response.setId(product.getId());
        response.setTitle(product.getTitle());
        response.setCategory(product.getCategory());
        response.setPrice(product.getPrice());
        response.setImageurl(product.getImageurl());
        response.setDescription(product.getDescription());
        return response;
    }
}
