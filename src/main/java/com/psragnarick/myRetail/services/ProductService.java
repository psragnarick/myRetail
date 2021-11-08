package com.psragnarick.myRetail.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.psragnarick.myRetail.models.ProductDetails;

public interface ProductService {
    ProductDetails getProductById(int id) throws JsonProcessingException;
    ProductDetails putProductUsingId(int id, ProductDetails newProduct) throws JsonProcessingException;
}
