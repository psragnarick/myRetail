package com.psragnarick.myRetail.models;

public class ProductClassification {
    public String product_type_name;
    public String merchandise_type_name;

    @Override
    public String toString() {
        return "ProductClassification{" +
                "product_type_name='" + product_type_name + '\'' +
                ", merchandise_type_name='" + merchandise_type_name + '\'' +
                '}';
    }
}
