package com.psragnarick.myRetail.models;




//Model for Product within Database

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDetailsResponse {

    private int id;
    private String name;
    @JsonProperty(value = "current_price")
    private CurrentPrice currentprice;


    public ProductDetailsResponse(int id, String name, CurrentPrice price) {
        super();
        this.id = id;
        this.name = name;
        this.currentprice = price;
    }

    public ProductDetailsResponse() {
    }

    //Getters and Setters

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


    public void setCurrentPrice(CurrentPrice price) {
        this.currentprice = price;
    }

    @Override
    public String toString() {
        return "ProductDetails {" + "id=" + id + "," + "name=" + name + "," + currentprice + "}";
    }

}