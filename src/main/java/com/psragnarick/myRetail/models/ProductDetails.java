package com.psragnarick.myRetail.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productDetails")

public class ProductDetails extends ProductPrice {


    @Id
    @Indexed
    private int id;

    @Transient
    private String name;

    private ProductDetails price;

    public ProductDetails(int id, String name, ProductPrice price){
        super();
        this.id = id;
        this.name = name;
        this.price = (ProductDetails) price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPrice(ProductPrice price) {
        this.price = (ProductDetails) price;
    }

    @Override
    public String toString(){
        return "ProductDetails {" + "id=" + id + "," + "name=" + name + "," + price + "}";
    }
}
