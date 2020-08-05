package com.myRetail.productsInfo;

import java.util.List;

//Interface for abstract methods
public interface productService {

    List<product> findAllProducts();

    product findByID(String id);
}
