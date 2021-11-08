package com.psragnarick.myRetail.repositories;


import com.psragnarick.myRetail.models.ProductDetails;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<ProductDetails,Integer> {
    Optional<ProductDetails> findById(Integer id);
}
