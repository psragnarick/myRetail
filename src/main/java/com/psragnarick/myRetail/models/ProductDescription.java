package com.psragnarick.myRetail.models;

public class ProductDescription {
    public String title;
    public String downstream_description;

    @Override
    public String toString() {
        return "ProductDescription{" +
                "title='" + title + '\'' +
                ", downstream_description='" + downstream_description + '\'' +
                '}';
    }
}
