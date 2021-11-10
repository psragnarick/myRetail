package com.psragnarick.myRetail.services;

import com.mongodb.MongoException;
import com.psragnarick.myRetail.models.CurrentPrice;
import com.psragnarick.myRetail.models.ProductDetailsResponse;
import com.psragnarick.myRetail.models.ProductPrice;
import com.psragnarick.myRetail.models.RedSkyResponse;
import com.psragnarick.myRetail.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService{

    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Autowired
    private ProductRepository productRepository;


    //Method to get the name value of a product

    private String getProductName(int id) throws Exception {
        log.info("in getProductName");
        String url = "https://redsky-uat.perf.target.com/redsky_aggregations/v1/redsky/case_study_v1?key=3yUxt7WltYG7MFKPp7uyELi1K40ad2ys&tcin=" + id;
        ResponseEntity<RedSkyResponse> response= restTemplate.getForEntity(url, RedSkyResponse.class);
        log.info("response form redsky {}",response.getBody());

        try{
            log.info("productName: " + response.getBody().data.product.item.product_description.title);
        }
        catch(Exception e){
            log.error("Parsing failed - IOException" + e.getMessage());
            throw new Exception(e.getMessage());
        }

        return response.getBody().data.product.item.product_description.title;
    }

//Method to get price of a product

    public ProductPrice getPrice(int id) throws MongoException {
        log.info("in getPrice");
        log.info("id: " + id);
        ProductPrice price = productRepository.findByTcin(id);
        log.info("price: " + price);
        return price;
    }

    public ProductDetailsResponse getProductById(int id) throws Exception {
        ProductDetailsResponse productDetailsResponse = new ProductDetailsResponse();
        log.info("in getProductById ");
        log.debug("id: "+id);
        String productName = getProductName(id);
        productDetailsResponse.setId(id);
        productDetailsResponse.setName(productName);
        log.debug("productName: "+productName);
        ProductPrice productPrice = getPrice(id);
        if(productPrice==null){
            log.error("price is shown as NULL, mongo exception thrown");
            throw new MongoException("price details for product with id="+id+" not found in mongo db for collection productPrice");
        }
        CurrentPrice currentPrice = new CurrentPrice();
        currentPrice.setPrice(productPrice.getPrice());
        currentPrice.setCurrencyCode(productPrice.getCurrencyCode());
        productDetailsResponse.setCurrentPrice(currentPrice);
        log.info("productDetails: "+ productDetailsResponse.toString());
        return productDetailsResponse;
    }

}
