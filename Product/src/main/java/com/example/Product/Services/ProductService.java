package com.example.Product.Services;

import com.example.Product.Models.Product;

import java.util.List;

public interface ProductService {
     Product createProduct(Product product);
     List<Product> getAllProduct();
     Product getProductbyId(long id);
     void deleteProductbyId(long id);
}
