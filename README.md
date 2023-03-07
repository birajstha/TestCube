# Project Name : TestCube
This springboot application is a Maven based project that calculates the side length of a cube given its volume. The cube object is cached in memory for 5 minutes.
The REST endpoints are exposed and are documented using Swagger as below.

## Swagger for Rest API documentation
When you run the SpringBoot application you can visit [SwaggerUI](http://localhost:8080/swagger-ui/index.html) for my Rest API documentation.

## In Memory h2 Database
h2 is used as an in memory database. Please find config details in application.properties 

## Unit test 
Unit test is written for one of the method findByUuid()
Junit5 and Mockito in use.