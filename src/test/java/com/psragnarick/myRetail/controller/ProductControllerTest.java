package com.psragnarick.myRetail.controller;

import com.psragnarick.myRetail.models.ProductDetails;
import com.psragnarick.myRetail.models.ProductPrice;
import com.psragnarick.myRetail.services.ProductServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier(value="ProductService")
    private ProductServiceImpl productService;

    private int MOVIE_ID=13860428;

    ProductDetails prodDetails=null;
    ProductPrice prodPrice= new ProductPrice();

    @BeforeAll
    public void setup(){
        prodPrice.setId(MOVIE_ID);
        prodPrice.setCurCode("USD");
        prodPrice.setPrice(2000F);
        prodDetails= new ProductDetails(MOVIE_ID,"The Big Lebowski (Blu-ray)",prodPrice);
    }

    @Test
    void getProduct() throws Exception{
        Mockito.when(productService.getProductById(MOVIE_ID)).thenReturn(prodDetails);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/product/"+MOVIE_ID).accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":13860428,\"name\":\"The Big Lebowski (Blu-ray)\",\"productPrice\":{\"price\":2000,\"currencyCode\":\"USD\"}}";
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }


    @Test
    void putProduct() throws Exception{
        ProductPrice prodPrice1= new ProductPrice();
        prodPrice1.setId(MOVIE_ID);
        prodPrice1.setCurCode("Rupee");
        prodPrice1.setPrice(300F);
        ProductDetails prodDetails1= new ProductDetails(MOVIE_ID,"The Big Lebowski (Blu-ray)",prodPrice1);

        Mockito.when(productService.putProductUsingId(MOVIE_ID, prodDetails1)).thenReturn(prodDetails1);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
                        "/product/"+MOVIE_ID)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":"+MOVIE_ID+",\"name\":\"The Big Lebowski (Blu-ray)\",\"productPrice\":{\"price\":300,\"currencyCode\":\"Rupee\"}}")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    }
}