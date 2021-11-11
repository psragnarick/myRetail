package com.psragnarick.myRetail.models;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//Model for the Product Pricing
@Document(value = "ProductPrice")
public class ProductPrice {

    @Indexed
    private int tcin;

    private  Float price;

    private String currencyCode;

//    @CreatedDate
//    private LocalDateTime createdDate;
//
//    @LastModifiedDate
//    private LocalDateTime lastModifiedDate;
//
//    @CreatedBy
//    private String createdByUser;
//
//    @LastModifiedBy
//    private String modifiedByUser;


    public ProductPrice(Float price, String code){
        this.price = price;
        this.currencyCode = code;
    }

    public ProductPrice() {

    }

    public int getTcin() {
        return tcin;
    }

    public void setTcin(int tcin) {
        this.tcin = tcin;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public LocalDateTime getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getCreatedByUser() {
//        return createdByUser;
//    }
//
//    public void setCreatedByUser(String createdByUser) {
//        this.createdByUser = createdByUser;
//    }
//
//    public String getModifiedByUser() {
//        return modifiedByUser;
//    }
//
//    public void setModifiedByUser(String modifiedByUser) {
//        this.modifiedByUser = modifiedByUser;
//    }

    @Override
    public String toString(){
        return "ProductPrice {"
                + "price=" + price + ","
                + "currencyCode =" + currencyCode + "}";
    }
}
