package com.psragnarick.myRetail.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import com.psragnarick.myRetail.models.ProductDetails;
import com.psragnarick.myRetail.models.ProductPrice;
import com.psragnarick.myRetail.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service(value="productService")
public class ProductServiceImpl implements ProductService{

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Autowired
    private ProductServiceImpl _productServiceImpl;

    @Autowired
    private ProductRepository productRepository;

    //Method to get the name value of a product

    private String getProductName(int id) throws IOException {
        log.info("in getProductName");
        String url = env.getProperty("target.restUrl1")+id+env.getProperty("target.restUrl2");
        ResponseEntity<String> response= restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        String productName="";
        try{
            JsonNode root=null;
            String jsonString=response.getBody();
            root = mapper.readTree(jsonString);
            if(root.findValue("product")!=null){
                root=root.findValue("product");
                if(root.findValue("item")!=null){
                    root=root.findValue("item");
                    if(root.findValue("product_description")!=null){
                        root=root.findValue("product_description");
                        if(root.findValue("title")!=null){
                            productName=root.findValue("title").asText();
                        }
                    }
                }
            }
            log.debug("productName: " + productName);
        }
        catch(IOException e){
            log.error("Parsing failed - IOException" + e.getMessage());
            throw new IOException(e.getMessage());
        }

        return productName;
    }

//Method to get price of a product

    public ProductDetails getPrice(int id) throws MongoException {
        log.info("in getPrice");
        log.debug("id: " + id);
        ProductPrice price = productRepository.findById(id);
        log.debug("price: " + price);
        return productRepository.findById(id);
    }

//Method to change the price of a product

    public ProductPrice updatePrice(int id, ProductDetails newProduct) throws MongoException{
        log.info("in updatePrice");
        ProductPrice newPrice = newProduct.getPrice(id);
        newPrice.setId(id);
        return newPrice;
    }

//Method to get all of the details of a product

    @Override
    public ProductDetails getProductById(int id) throws IOException {
        log.info("in  getProductById ");
        log.debug("id: "+id);
        String productName = getProductName(id);
        log.debug("productName: "+productName);
        ProductPrice productPrice = _productServiceImpl.getPrice(id);
        if(productPrice==null){
            log.error("price is shown as NULL, mongo exception thrown");
            throw new MongoException("price details for product with id="+id+" not found in mongo db for collection productPrice");
        }
        ProductDetails pD = new ProductDetails(id, productName, productPrice);
        log.debug("productDetails: "+ pD);
        return pD;
    }

//Method to add product to database

    @Override
    public ProductDetails putProductUsingId(int id, ProductDetails newProduct) throws Exception {
        log.info("in putProductDetails");
        log.debug(" newProduct : "+ newProduct);
        if(id!=newProduct.getId()){
            throw new Exception(" Cannot update the Product Price, the request body should have matching id with path variable.");
        }
        ProductPrice newPrice = newProduct.getPrice(id);
        if(newProduct.getCurCode()==null||newProduct.getPrice(id)==null){
            throw new Exception(" Neither Price nor Currency Code should be empty ");
        }
        newPrice.setId(id);
        String productName = getProductName(id);
        newPrice= _productServiceImpl.updatePrice(id,newProduct);
        newProduct.setPrice(newPrice);
        return newProduct;
    }
}
