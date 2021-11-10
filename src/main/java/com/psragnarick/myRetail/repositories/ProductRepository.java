package com.psragnarick.myRetail.repositories;


import com.psragnarick.myRetail.models.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductPrice,Integer> {

    public ProductPrice findByTcin(int tcin);
}
