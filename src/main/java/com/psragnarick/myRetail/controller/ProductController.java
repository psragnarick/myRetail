package com.psragnarick.myRetail.controller;


import com.psragnarick.myRetail.models.ProductDetailsResponse;
import com.psragnarick.myRetail.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller for the repository

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;
    ProductController(final ProductService productService){
        this.productService = productService;
    }
    private final Logger log = LoggerFactory.getLogger(ProductController.class);


    @GetMapping("/product/{tcin}")
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

//    @PutMapping("/product/{tcin}")
//    public ResponseEntity<ProductPrice> updatePrice(@PathVariable int tcin, @RequestBody ProductPrice productPrice){
//        Optional<ProductPrice> priceData = Optional.ofNullable(productRepository.findByTcin(tcin));
//        log.info("in controller updatePrice id :" + tcin);
//        if(priceData.isPresent()){
//            ProductPrice _productPrice = priceData.get();
//            _productPrice.setTcin(productPrice.getTcin());
//            _productPrice.setPrice(productPrice.getPrice());
//            _productPrice.setCurrencyCode(productPrice.getCurrencyCode());
//            log.info("new productPrice :" + _productPrice);
//            return new ResponseEntity<>(productRepository.save(_productPrice), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
