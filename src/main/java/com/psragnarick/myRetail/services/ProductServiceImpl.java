package com.psragnarick.myRetail.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psragnarick.myRetail.models.ProductDetails;
import com.psragnarick.myRetail.models.ProductPrice;
import com.psragnarick.myRetail.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProductServiceImpl implements ProductService{

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Autowired
    private ProductServiceImpl _productServiceImpl;

    @Autowired
    private ProductRepository productRepository;

    private String getProductName(int id) throws JsonProcessingException {
        String productName="";
        JsonNode root=null;
        String url = env.getProperty("target.restUrl1")+id+env.getProperty("target.restUrl2");
        ResponseEntity<String> response= restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
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
        return productName;
    }

    public ProductDetails getPrice(int id){
        return productRepository.findById(id);
    }

    public ProductPrice updatePrice(int id, ProductDetails newProduct){
        ProductPrice newPrice = newProduct.getPrice(id);
        newPrice.setId(id);
        return newPrice;
    }

    @Override
    public ProductDetails getProductById(int id) throws JsonProcessingException {
        String productName = getProductName(id);
        ProductDetails productPrice = _productServiceImpl.getPrice(id);
        ProductDetails pD = new ProductDetails(id, productName, productPrice);
        return pD;
    }

    @Override
    public ProductDetails putProductUsingId(int id, ProductDetails newProduct) throws JsonProcessingException {
        ProductPrice newPrice = newProduct.getPrice(id);
        newPrice.setId(id);
        String productName = getProductName(id);
        newPrice= _productServiceImpl.updatePrice(id,newProduct);
        newProduct.setPrice(newPrice);
        return newProduct;
    }
}
