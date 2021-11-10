package com.psragnarick.myRetail.models;

public class Product {
    public String tcin;
    public Item item;


    @Override
    public String toString() {
        return "Product{" +
                "tcin='" + tcin + '\'' +
                ", item=" + item +
                '}';
    }
}
