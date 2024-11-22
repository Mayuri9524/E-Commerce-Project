package com.example.Product.Services;

import com.example.Product.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceDbImple implements ProductService{
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product getProductbyId(long id) {
        return null;
    }

    @Override
    public void deleteProductbyId(long id) {
        return;
    }
}
