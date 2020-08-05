package com.myRetail.productsInfo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class product {

//Fields for the DB
    @Id
    private String id;
    private String name;
    private String value;
    private String currency_code;

//Common get and set functions for GET and PUT requests
    public String getID(){
        return id;
    }

    public void setID(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getCurrencyCode(){
        return currency_code;
    }

    public void setCurrencyCode(String currency_code){
        this.currency_code = currency_code;
    }

}