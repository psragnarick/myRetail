package com.psragnarick.myRetail.services;

import com.psragnarick.myRetail.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ProductServiceImpl implements ProductService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String getProductNameById(Integer productId){
        return ProductRepository.findById(productId);
    }
}
