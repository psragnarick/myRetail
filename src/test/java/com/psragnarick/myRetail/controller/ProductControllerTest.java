//package com.psragnarick.myRetail.controller;
//
//import com.psragnarick.myRetail.models.CurrentPrice;
//import com.psragnarick.myRetail.models.ProductDetailsResponse;
//
//class ProductControllerTest {
//
//
////    private MockMvc mockMvc;
////
////    private ProductService productServiceMock = Mockito.mock(ProductService.class);
////
////    @InjectMocks
////    private ProductController productController;
////
////    @Before
////    void setUp(){
//////        MockitoAnnotations.initMocks(productController);
//////        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//////        currentPrice.setPrice(435.34F);
//////        currentPrice.setCurrencyCode("EUR");
//////        productDetailsResponse = new ProductDetailsResponse(13860428,"The Bigger Lebowski (Blu-ray)",currentPrice);
//////        productController =  new ProductController(productServiceMock);
////
////    }
//
//
//    ProductDetailsResponse productDetailsResponse = null;
//    CurrentPrice currentPrice = new CurrentPrice();
//
//
////    @Test
////    void getProduct() throws Exception {
//////        Mockito.when(productServiceMock.getProductById(13860428)).thenReturn(productDetailsResponse);
//////        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/13860428").accept(MediaType.APPLICATION_JSON);
//////        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//////        String expected = "{\"id\":13860428,\"name\":\"The Bigger Lebowski (Blu-ray)\",\"current_price\":{\"price\":435.34,\"currencyCode\":\"EUR\"}}";
//////        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
////    }
//}