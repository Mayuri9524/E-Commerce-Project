package com.example.Product.Controllers;


import com.example.Product.CustomeException.InvalidIdException;
import com.example.Product.CustomeException.NoProductFound;
import com.example.Product.Dtos.CreateProductRequestDto;
import com.example.Product.Dtos.CreateProductResponseDto;
import com.example.Product.Dtos.GetProductResponseDto;
import com.example.Product.Models.Product;
import com.example.Product.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService=productService;
    }

    @PostMapping()
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto)
    {
        Product product= productService.createProduct(createProductRequestDto.toProduct());
        return CreateProductResponseDto.fromProduct(product);
    }

    @GetMapping
    public List<GetProductResponseDto> getAllProduct()
    {
        List<Product> products= productService.getAllProduct();
        List<GetProductResponseDto> getProductResponseDtos= new ArrayList<>();
        for(Product prod:products)
        {
            getProductResponseDtos.add(GetProductResponseDto.fromProduct(prod));
        }
        return getProductResponseDtos;
    }

    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable("id") Long id)
    {
        return productService.getProductbyId(id);

    }

    @DeleteMapping("/{id}")
    public void deleteProductbyId(@PathVariable("id") Long id)
    {
        productService.deleteProductbyId(id);
    }

    @PatchMapping("/{id}")
    public void updateProductbyId(@PathVariable("id") Long id)
    {
        return;
    }

    @PutMapping("/{id}")
    public void replaceProductbyId(@PathVariable("id") Long id)
    {
        return;
    }

}
