package com.psragnarick.myRetail.repositories;


import com.psragnarick.myRetail.models.ProductDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDetails,Integer> {
    public ProductDetails findById(int id);
}
