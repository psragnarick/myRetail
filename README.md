# myRetail

This is a REST controller that handles price information retrieval from local database.

Building the service:

1. Install [Gradle](https://gradle.org/install/)
2. Download or clone this repository,
3. Open your CLI, go to the code directory
4. Build with `$ gradle build clean`

Testing the Service:

 1. Install [MongoDB](https://docs.mongodb.com/guides/server/install/)
 2. Connect to your MongoDB Instance
 3. Setup Local Database with `use test`
 4. Create Collection ProductPrices with `db.createCollection(ProductPrices)`
 5. Enter the following:
		`db.ProductPrices.insertOne({"tcin":13860428,"price":13.49,"currencyCode":"USD"})`
		`db.ProductPrices.insertOne({"tcin":54456119,"price":420.69,"currencyCode":"EUR"})`
		`db.ProductPrices.insertOne({"tcin":13264003,"price":123.45,"currencyCode":"INR"})`
		`db.ProductPrices.insertOne({"tcin":12954218,"price":65.45,"currencyCode":"USD"})`
 6. Open Postman and send requests 
	 `http://localhost:8085/product/13860428`
	 `http://localhost:8085/product/54456119`
	 `http://localhost:8085/product/13264003`
	 `http://localhost:8085/product/12954218`

Expected Output for http://localhost:8085/product/13860428 should be:
`{`
`"id":  13860428,`
`"name":  "The Big Lebowski (Blu-ray)",`
`"current_price":  {`
`"price":  13.49,`
`"currencyCode":  "USD"`
`}`
`}`
