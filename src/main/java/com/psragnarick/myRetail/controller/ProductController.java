package com.psragnarick.myRetail.controller;


import com.psragnarick.myRetail.models.ProductDetailsResponse;
import com.psragnarick.myRetail.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller for the repository

@RestController
@RequestMapping("/")
public class ProductController {
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value="product/{tcin}",method = RequestMethod.GET)
    public ResponseEntity<ProductDetailsResponse> getProduct(@PathVariable int tcin) throws Exception {
        ProductDetailsResponse product = null;
        try {
            log.info("in controller getProduct id :" + tcin);
            product = productService.getProductById(tcin);
            log.info(" return productDetails :" + product);
        }catch(Exception exception){
            log.info("Unknown exception occurred {} " ,exception.getMessage());
        }
        return new ResponseEntity(product, HttpStatus.OK);
    }

//    @RequestMapping(value="product/{id}",method = RequestMethod.PUT)
//    public ProductDetailsResponse putProduct(@PathVariable int id,@RequestBody ProductDetailsResponse product) throws Exception {
//        log.info("in controller putProduct id :" + id);
//        log.info("in controller putProduct requestBody :" + product);
//        ProductDetailsResponse updatedProduct = productService.putProductUsingId(id, product);
//        log.info(" updated putProductDetails :" + updatedProduct);
//        return updatedProduct;
//    }

}
