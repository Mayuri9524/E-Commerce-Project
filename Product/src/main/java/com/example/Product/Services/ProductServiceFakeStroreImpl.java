package com.example.Product.Services;

import com.example.Product.CustomeException.InvalidIdException;
import com.example.Product.CustomeException.InvalidResponse;
import com.example.Product.CustomeException.NoProductFound;
import com.example.Product.Dtos.FakeStoreCreateProductRequestDto;
import com.example.Product.Dtos.FakeStoreCreateProductResponseDto;
import com.example.Product.Models.Product;
import org.apache.tomcat.jni.Pool;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@Primary
public class ProductServiceFakeStroreImpl implements ProductService{

    private RestTemplate restTemplate;

    public ProductServiceFakeStroreImpl(RestTemplate restTemplate)
    {
        this.restTemplate= restTemplate;
    }
    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto request=new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategory());
        request.setDescription(product.getDescription());
        request.setTitle(product.getTitle());
        request.setPrice(product.getPrice());
        request.setImage(product.getImageurl());
        request.setId(product.getId());

        FakeStoreCreateProductResponseDto response= restTemplate.postForObject("https://fakestoreapi.com/products",request, FakeStoreCreateProductResponseDto.class);

        if(response!=null)
        {return response.toProduct();}
        throw new InvalidResponse("Failed to create product, received empty response.");
    }

    @Override
    public List<Product> getAllProduct() {
        FakeStoreCreateProductResponseDto[] response= restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreCreateProductResponseDto[].class);

        List<FakeStoreCreateProductResponseDto> responseDtoList= Stream.of(response).toList();
        List<Product> products= new ArrayList<>();
        for(FakeStoreCreateProductResponseDto fakeStoreCreateProductResponseDto: responseDtoList)
        {
            products.add(fakeStoreCreateProductResponseDto.toProduct());
        }
        if(products.size()>1)
        {return products;}
        throw new NoProductFound("No products found in the Product");
    }

    @Override
    public Product getProductbyId(long id) {
        FakeStoreCreateProductResponseDto[] response= restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreCreateProductResponseDto[].class);
        List<FakeStoreCreateProductResponseDto> responseDtoList= Stream.of(response).toList();
        for(FakeStoreCreateProductResponseDto fakeStoreCreateProductResponseDto: responseDtoList)
        {
            if(fakeStoreCreateProductResponseDto.toProduct().getId()==id)
            { return fakeStoreCreateProductResponseDto.toProduct();}
        }
        throw new InvalidIdException("Invalid Id");
    }

    @Override
    public void deleteProductbyId(long id) {
        FakeStoreCreateProductResponseDto[] response= restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreCreateProductResponseDto[].class);
        List<FakeStoreCreateProductResponseDto> responseDtoList= Stream.of(response).toList();
        for(FakeStoreCreateProductResponseDto fakeStoreCreateProductResponseDto: responseDtoList)
        {
            if(fakeStoreCreateProductResponseDto.toProduct().getId()==id)
            { restTemplate.delete("https://fakestoreapi.com/products",fakeStoreCreateProductResponseDto.toProduct());}
        }
        throw new InvalidIdException("Invalid Id");
    }
}
