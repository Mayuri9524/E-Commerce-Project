package com.example.Product.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductRequestDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private  String image;
    private String category;
}

