# Fetch-Rewards-Backend-Challenge

A simple Spring Boot application for processing receipts and calculating points. This project uses an H2 in-memory database for persistence and provides two REST APIs.
Implemented with Java 23, Spring Boot (Spring Initalizr), Maven and Docker.


## Java and Docker versions in project

* Java 23
* Docker (docker build) & docker-compose

## Building and Running Locally

Default port is 8080

* http://localhost:8080


### Run and Build With Docker Compose

Must have Docker installed on machine. To start and deploy the Spring Boot application specified in docker-compose.yml to docker containers, run

```
docker-compose up --build
```
To stop and remove running docker container

```
docker-compose down
```
### Run and Build With Docker Build

Alternatively, build the docker image directly using the Dockerfile by running

```
docker build -t fetch-rewards .
```
And once docker image is built and present locally, run it by 
```
docker run -p 8080:8080 fetch-rewards
```



### Test with Postman

Package with Maven if needed to build the jar files
```
mvn package -DskipTests
```
```
mvn clean package -DskipTests
```

Once Docker container starts (or alternatively run directly using IDE like IntelliJ to locally launch Spring Boot Application)

Open Postman and test :
1. POST Method with the JSON Request Body
```
http://localhost:8080/receipts/process
```
```
{
  "retailer": "M&M Corner Market",
  "purchaseDate": "2022-03-20",
  "purchaseTime": "14:33",
  "items": [
    {
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    },{
      "shortDescription": "Gatorade",
      "price": "2.25"
    }
  ],
  "total": "9.00"
}
```
2. GET Method where {id} is a UUID string returned as response by the POST method
   ```
   http://localhost:8080/receipts/{id}/points
   ```

BONUS : Added Data Sanitation and JSON Validation to parse Invalid Prices/Total amount, Invalid Date & Time format, Minimum Size for Items[], as well as Blank/Null RetailerName/Description

Postman should display correct error messages and Error Codes for Edge Cases or incorrect JSON data.

### H2 memory console

(ONLY works Locally)

Navigate to the url and enter as credentials :

```
http://localhost:8080/h2-console/
```

username = 
```
admin
```
password = 
```
admin
```

This should open connect to the h2 memory database. You can run 2 SQL commands to track the entire db
```
SELECT * FROM RECEIPT
```
```
SELECT * FROM RECEIPT_ITEMS
```
