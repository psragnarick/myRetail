package com.psragnarick.myRetail.services;

import com.psragnarick.myRetail.models.ProductDetails;
import com.psragnarick.myRetail.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class ProductServiceImpl implements ProductService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Optional<ProductDetails> getProductNameById(Integer productId){
        return ProductRepository.findById(productId);
    }
}
