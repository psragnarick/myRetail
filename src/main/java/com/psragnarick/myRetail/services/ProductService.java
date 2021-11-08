package com.psragnarick.myRetail.services;

import com.mongodb.MongoException;
import com.psragnarick.myRetail.models.ProductDetails;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

public interface ProductService {
    ProductDetails getProductById(int id) throws MongoException, HttpClientErrorException, IOException;
    ProductDetails putProductUsingId(int id, ProductDetails newProduct) throws Exception;
}
