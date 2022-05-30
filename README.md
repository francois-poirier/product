## How to run Application
By default, Spring Boot configures the application to connect to an in-memory store with the username sa and an empty password.
However, we can change those parameters by adding the following properties to the application.yml file
```
spring:
  application:
    name: product
  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: sa
    password: password
    jpa.database-platform: org.hibernate.dialect.H2Dialect
```

Running application from command line using Maven
```mvn spring-boot:run```
* Application will be running on: http://localhost:8080

## How to run the Unit and Integration Test

```mvn -B clean verify```
