package com.psragnarick.myRetail.models;

public class Item {
    public ProductDescription product_description;
    public Enrichment enrichment;
    public ProductClassification product_classification;
    public PrimaryBrand primary_brand;

    @Override
    public String toString() {
        return "Item{" +
                "product_description=" + product_description +
                ", enrichment=" + enrichment +
                ", product_classification=" + product_classification +
                ", primary_brand=" + primary_brand +
                '}';
    }
}
