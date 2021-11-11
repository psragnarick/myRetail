package com.psragnarick.myRetail.services;

import com.psragnarick.myRetail.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

class ProductServiceTest {

    @MockBean
    ProductRepository productRepository;


    @Test
    void getPrice() {
//        Mockito.when(productRepository.findByTcin(13860428)).thenReturn("The Bigger Lebowski (Blu-ray)");

    }

    @Test
    void getProductById() {

    }
}