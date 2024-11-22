package com.example.Product.Dtos;

import com.example.Product.Models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

@Setter
@Getter
public class GetProductResponseDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private  String image;
    private String category;

    public static GetProductResponseDto fromProduct(Product product)
    {
        GetProductResponseDto getProductResponseDto= new GetProductResponseDto();
        getProductResponseDto.setId(product.getId());
        getProductResponseDto.setTitle(product.getTitle());
        getProductResponseDto.setPrice(product.getPrice());
        getProductResponseDto.setDescription(product.getDescription());
        getProductResponseDto.setImage(product.getImageurl());
        getProductResponseDto.setCategory(product.getCategory());
        return getProductResponseDto;
    }
}
