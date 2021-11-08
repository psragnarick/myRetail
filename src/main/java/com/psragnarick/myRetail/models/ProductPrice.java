package com.psragnarick.myRetail.models;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "productPrice")
public class ProductPrice {
    private Float price;

    private String curCode;

    public ProductPrice(Float price, String curCode){
        this.price = price;
        this.curCode = curCode;
    }
}
