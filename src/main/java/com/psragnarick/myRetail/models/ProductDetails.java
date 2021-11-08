package com.psragnarick.myRetail.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productDetails")

public class ProductDetails {

    @Id
    @Indexed
    private Integer id;

    @Transient
    private String name;

    private ProductPrice price;

    public ProductDetails(Integer id, String name, ProductPrice price){
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
    }
}
