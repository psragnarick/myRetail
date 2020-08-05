# myRetail
a set of REST apis handling products and product information for a store called my Retail

Running the code:
Download one of the folders and import it to a Java IDE. For productsInfo API, run the ProductsInfoApplication in the IDE

Testing the code:
Open MongoDB and create a local database. The port of the application is already 27017. Create data with line:
db.products.insertMany([{"id":65431852,"name":"Onionne Battleur","current_price":{"value": 650.92,"currency_code":"EUR"}}, {"id":25472365,"name":"Sony Playstation 9","current_price":{"value": 1199.99,"currency_code":"USD"}},{"id":12574632,"name":"Bratz Doll","current_price":{"value": 16.99,"currency_code":"USD"}},{"id":62871852,"name":"Philips LED Vintage Bulb","current_price":{"value": 299,"currency_code":"INR"}} ]);
Then send a request in the form of:
http://localhost:8080/products/{id}

Example:
GET http://localhost:8080/product/?62871852

Response:
{
  "id":62871852,
  "name":"Philips LED Vintage Bulb",
  "current_price":
  {
    "value": 299,
    "currency_code":"INR"
  }
}
