# Shopping Cart

## What you need
- Java 8
- Maven
- You can also import the code straight into your IDE:
    - Spring Tool Suite (STS)
    - IntelliJ IDEA

## To skip the basics, do the following:
* download the source
* cd into freemarket
* run: mvn clean install
 
## Run process
1. mvn spring-boot:run


## Endpoints

### Endpoint to get all products
> GET http://localhost:8092/shopping/product/

### Endpoint to load file with products csv
> GET http://localhost:8092/shopping/product/loadfile?fileName=${filename}

### Endpoint to get products by filters like product name, price range and mark
> GET http://localhost:8092/shopping/product/filters?name=${productName}&initialPrice=${initialPrice}&endPrice=${endPrice}&mark=${mark}

### Endpoint to add product to the shopping cart
> POST http://localhost:8092/shopping/shopping-cart/add

#### Example Request
```json
{
    "productName": "Htc One M7 Negro",
    "productAmount": 5
}
```

### Endpoint get all products in the shopping cart
> GET http://localhost:8092/shopping/shopping-cart/list

### Endpoint to clean the shopping cart
> DELETE http://localhost:8092/shopping/shopping-cart/delete

### Endpoint to proccess the purchase
> PUT http://localhost:8092/shopping/shopping-cart/endShopping

# Response
there is a general response with dinamyc status.
```json
{
    "code": 200,
    "message": "There are not products in the shopping cart"
}
```
