package com.psragnarick.myRetail.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "productPrice")
public class ProductPrice {

    @Id
    private int id;

    private Float price;

    private String curCode;

    public ProductPrice(Float price, String code){
        this.price = price;
        this.curCode = code;
    }

    public ProductPrice() {

    }

    @JsonIgnore
    @JsonProperty(value = "id")
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id =id;
    }

    public ProductPrice getPrice(int id) {
        return new ProductPrice();
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurCode() {
        return curCode;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    @Override
    public String toString(){
        return "ProductPrice {"
                + "price=" + price + ","
                + "currencyCode =" + curCode + "}";
    }
}
