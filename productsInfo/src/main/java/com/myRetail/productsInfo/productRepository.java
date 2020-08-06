package com.myRetail.productsInfo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface productRepository extends MongoRepository<product, String> {
//Repository function to get all products
    List<product> findAll();
//Repository function to retrieve one product info
    product findByID(String id);
}
