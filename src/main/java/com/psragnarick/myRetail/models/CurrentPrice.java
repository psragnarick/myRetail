package com.psragnarick.myRetail.models;

public class CurrentPrice {
    private Float price;

    private String currencycode;

    public CurrentPrice(Float currentPrice, String currencyCode){
        this.price = currentPrice;
        this.currencycode = currencyCode;
    }

    public CurrentPrice() {
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencycode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencycode = currencyCode;
    }

    @Override
    public String toString() {
        return "CurrentPrice{" +
                "price=" + price +
                ", currencyCode='" + currencycode + '\'' +
                '}';
    }
}
