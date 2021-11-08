package com.psragnarick.myRetail.controller;


import com.mongodb.MongoException;
import com.psragnarick.myRetail.models.ProductDetails;
import com.psragnarick.myRetail.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    @Qualifier(value="productService")
    ProductService productService;

    @RequestMapping(value="product/{id}",method = RequestMethod.GET)
    public ProductDetails getProduct(@PathVariable int id) throws HttpClientErrorException, MongoException, IOException{
        log.info("in controller getProduct id :"+id);
        ProductDetails product=null;
        product=productService.getProductById(id);
        log.info(" return productDetails :"+ product);
        return product;
    }

    @RequestMapping(value="product/{id}",method = RequestMethod.PUT)
    public ProductDetails putProduct(@PathVariable int id,@RequestBody ProductDetails product) throws Exception {
        log.info("in controller putProduct id :" + id);
        log.info("in controller putProduct requestBody :" + product);
        ProductDetails updatedProduct = productService.putProductUsingId(id, product);
        log.info(" updated putProductDetails :" + updatedProduct);
        return updatedProduct;
    }

}
