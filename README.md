# ![Simple Exchange App using Java and Spring](example-logo.png)


> ### Spring boot + MyBatis codebase containing real world examples (CRUD, auth, advanced patterns, etc) that adheres to the [RealWorld](https://github.com/gothinkster/realworld-example-apps) spec and API.

This codebase was created to demonstrate a fully fledged full-stack application built with Spring boot + Mybatis including CRUD operations, authentication, routing, pagination, and more.

# How it works

The application uses Spring Boot (Web, H2 Memory,Spring-Data).



And the code is organized as this:

1. `rest` is the web layer implemented by Spring Rest Controller
2. `infrastructure`  contains all the external dependency(fixer exchange api,h2 memory)
3. `model` contains application model
4. `aspect` contains aspecy operation. For example saving exchnage transaciton saving operation.
5. `port` this package contains data operation interface mehhods.





# Database

It uses a H2 in-memory database  (for easy local test without losing test data after every restart), can be changed easily in the `application.properties` for any other database.

Database 
spring.h2.console.path=/h2-ui

# Getting started

You'll need Java 11 installed.



# Api Documantation
It uses swagger for api documantation.

The entry point address of the swagger is at http://localhost:8080/api,

