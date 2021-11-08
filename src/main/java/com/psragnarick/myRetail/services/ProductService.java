package com.psragnarick.myRetail.services;

import com.psragnarick.myRetail.models.ProductDetails;

import java.util.Optional;

public interface ProductService {
    Optional<ProductDetails> getProductNameById(Integer id);
}
