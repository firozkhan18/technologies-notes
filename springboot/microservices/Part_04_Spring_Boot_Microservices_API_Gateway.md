## [<<PREV](Part_03_Spring_Boot_Microservices_Service_Discovery.md) - MICROSERVICE API GATEWAY - [NEXT>>](Part_05_Spring_Boot_Microservices_Security.md)


### Spring Cloud Gateway

This project provides a libraries for building an API Gateway on top of Spring WebFlux or Spring WebMVC. Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.

### Features

Spring Cloud Gateway features:
- Built on Spring Framework and Spring Boot
- Able to match routes on any request attribute.
- Predicates and filters are specific to routes.
- Circuit Breaker integration.
- Spring Cloud DiscoveryClient integration
- Easy to write Predicates and Filters
- Request Rate Limiting
- Path Rewriting

### Getting Started
```java
@SpringBootApplication
public class DemogatewayApplication {
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("path_route", r -> r.path("/get")
				.uri("http://httpbin.org"))
			.route("host_route", r -> r.host("*.myhost.org")
				.uri("http://httpbin.org"))
			.route("rewrite_route", r -> r.host("*.rewrite.org")
				.filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
				.uri("http://httpbin.org"))
			.route("hystrix_route", r -> r.host("*.hystrix.org")
				.filters(f -> f.hystrix(c -> c.setName("slowcmd")))
				.uri("http://httpbin.org"))
			.route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
				.filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
				.uri("http://httpbin.org"))
			.route("limit_route", r -> r
				.host("*.limited.org").and().path("/anything/**")
				.filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
				.uri("http://httpbin.org"))
			.build();
	}
}
```
To run your own gateway use the spring-cloud-starter-gateway dependency.

![Desktop Screenshot](images/api-gateway.PNG)

![Desktop Screenshot](images/api-gateway-2.PNG)

![Desktop Screenshot](images/api-gateway-3.PNG)

- API-Gateway
  - Create a new Spring Boot project for API-Gateway using Spring Cloud Gateway
  - Add dependencies for Spring Cloud Gateway
  - Configure API Gateway to route requests to appropriate microservices based on the path
 
- api-gateway Module

![Desktop Screenshot](images/api-gateway.PNG)

The Service Implementation module implements the service. It depends on Repository Module and Service API Module.
```
api-gateway
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
|   |   |       └── springboot
|   |   |           └── microservice
|   |   |               └── apigateway
|   |   |                   ├── ApiGatewayApplication.java
|   |   |                   ├── controller
|   |   |                   |   └── ApiGatewayController.java
│   │   │                   ├── model
│   │   │                   │   └── ApiGateway.java
|   |   |                   ├── service
|   |   |                   |   └── ApiGatewayService.java
|   |   |                   └── repository
|   |   |                       └── ApiGatewayRepository.java
|   |   └── resources
|   |       ├── application.properties
|   |       ├── static
|   |       ├── templates
|   |       └── META-INF
|   |           └── MANIFEST.MF
|   └── src
|       ├── test
|       │   ├── java
|       │   │   └── com
|       │   │       └── springboot
|       │   │           └── microservice
|       │   │               └── apigateway
|       │   │                   └── ApiGatewayApplicationTest.java
|       └── resources
|           └── application.properties
└── pom.xml
```
In this structure:

ApiGatewayApplication.java is the main class that contains the main method to run the Spring Boot application.
```java
package com.programming.techie.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
```
application.properties contains application-specific properties.

```properties
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
spring.application.name=api-gateway
logging.level.root= INFO
logging.level.org.springframework.cloud.gateway.route.RouteDefinitionRouteLocator= INFO
logging.level.org.springframework.cloud.gateway= TRACE

## Product Service Route
spring.cloud.gateway.routes[0].id=product-service
spring.cloud.gateway.routes[0].uri=lb://product-service
spring.cloud.gateway.routes[0].predicates[0]=Path=/api/product

## Order Service Route
spring.cloud.gateway.routes[1].id=order-service
spring.cloud.gateway.routes[1].uri=lb://order-service
spring.cloud.gateway.routes[1].predicates[0]=Path=/api/order

## Discover Server Route
spring.cloud.gateway.routes[2].id=discovery-server
spring.cloud.gateway.routes[2].uri=http://localhost:8761
spring.cloud.gateway.routes[2].predicates[0]=Path=/eureka/web
spring.cloud.gateway.routes[2].filters[0]=SetPath=/

## Discover Server Static Resources Route
spring.cloud.gateway.routes[3].id=discovery-server-static
spring.cloud.gateway.routes[3].uri=http://localhost:8761
spring.cloud.gateway.routes[3].predicates[0]=Path=/eureka/**
```
pom.xml
```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.3.1</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>
  <groupId>com.springboot.microservice</groupId>
  <artifactId>api-gateway</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>api-gateway</name>
  <description>product-service</description>
  <url/>  
  <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>
  <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
    </dependencies>
</project>
```

By following this structure, you can create a modular and scalable microservice architecture using Spring Boot. Each microservice is responsible for a specific domain (such as products, orders, inventory, notifications) and can be easily extended or updated without affecting other services. Service Discovery and API Gateway help in managing communication between services and routing requests efficiently.

Open the pom.xml (parent pom) file.

pom.xml (parent pom)
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>com.springboot.microservice</groupId>
    <artifactId>spring-boot-microservices</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>product-service</module>
        <module>order-service</module>
        <module>inventory-service</module>
        <module>discovery-server</module>
        <module>api-gateway</module>
    </modules>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <spring-cloud.version>2021.0.2</spring-cloud.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.testcontainers</groupId>
                <artifactId>testcontainers-bom</artifactId>
                <version>1.16.3</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>16</source>
                    <target>16</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
```
spring-boot-microservices
├───product-service
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── product
|   |   |   |                   ├── ProductServiceApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── ProductController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── ProductRequest.java
|   |   |   |                   |   └── ProductResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Product.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── ProductService.java
|   |   |   |                   └── repository
|   |   |   |                       └── ProductRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── product
|   |       │   │                   └── ProductServiceApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
├───order-service
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── order
|   |   |   |                   ├── OrderServiceApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── OrderController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── OrdertRequest.java
|   |   |   |                   |   └── OrderResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Order.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── OrderService.java
|   |   |   |                   └── repository
|   |   |   |                       └── OrderRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── order
|   |       │   │                   └── OrderServiceApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
├───inventory-service
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── inventory
|   |   |   |                   ├── InventoryServiceApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── InventoryController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── InventoryRequest.java
|   |   |   |                   |   └── InventoryResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Inventory.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── InventoryService.java
|   |   |   |                   └── repository
|   |   |   |                       └── InventoryRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── inventory
|   |       │   │                   └── InventoryServiceApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
├───service-discovery
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── product
|   |   |   |                   ├── ProductServiceApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── ProductController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── ProductRequest.java
|   |   |   |                   |   └── ProductResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Product.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── ProductService.java
|   |   |   |                   └── repository
|   |   |   |                       └── ProductRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── product
|   |       │   │                   └── ProductServiceApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
├───api-gateway
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── gateway
|   |   |   |                   ├── ApiGatewayApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── ProductController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── ProductRequest.java
|   |   |   |                   |   └── ProductResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Product.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── ProductService.java
|   |   |   |                   └── repository
|   |   |   |                       └── ProductRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── gateway
|   |       │   │                   └── ApiGatewayApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
└── pom.xml
```
- product-service: This module contains the code for managing products.
- order-service: This module contains the code for managing orders.
- inventory-service: This module contains the code for managing inventory.
- notification-service: This module contains the code for sending notifications.
- service-discovery: This module contains the code for service discovery using Eureka or Consul.
- api-gateway: This module contains the code for API gateway using Zuul or Spring Cloud Gateway.
- pom.xml: Main Maven project file that includes all the submodule dependencies

- POM Aggregator (Parent POM)

The parent pom contains all the application modules. It also includes all the common dependencies and properties that are needed by more than one module. Dependencies are defined without version because the project has defined the Spring IO Platform as a parent.

Let's understand the structure of the multi-module application that we have created.

Spring-boot-microservices  
├── pom.xml  
│   └── REDME.adoc  
├── application  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           ├── java  
│           │   └── sample  
│           │       └── multimodule  
│           │           ├── SampleWebJspApplication.java  
│           │           └── web  
│           │               └── WelcomeController.java  
│           └── resources  
│               ├── application.properties  
│               └── templates  
│                   └── welcome  
│                       └── show.html  
├── model  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           └── java  
│               └── sample  
│                   └── multimodule  
│                       └── domain  
│                           └── entity  
│                               └── Account.java  
|  
├── repository  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           └── java  
│               └── sample  
│                   └── multimodule  
│                       └── repository  
│                           └── AccountRepository.java  
├── service-api  
│   ├── pom.xml  
│   └── src  
│       └── main  
│           └── java  
│               └── sample  
│                   └── multimodule  
│                       └── service  
│                           └── api  
│                               ├── AccountNotFoundException.java  
│                               └── AccountService.java  
└── service-impl  
    ├── pom.xml  
    └── src  
        └── main  
            └── java  
                └── sample  
                    └── multimodule  
                        └── service  
                            └── impl  
                                └── AccountServiceImpl.java  
                                
Step 1: Create a Maven Project with the name spring-boot-microservices.

Step 2: Open the pom.xml (parent pom) file and change the packaging type jar to pom.

pom.xml (parent pom)
```pom
<?xml version="1.0" encoding="UTF-8" standalone="no"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
<modelVersion>4.0.0</modelVersion>  
<!-- Spring IO Platform is the parent of the generated application to  
be able to use Spring Boot and all its default configuration -->  
<parent>  
<groupId>io.spring.platform</groupId>  
<artifactId>platform-bom</artifactId>  
<version>2.0.1.RELEASE</version>  
</parent>  
<groupId>com.springboot.microservices</groupId>  
<artifactId>spring-boot-microservices</artifactId>  
<version>0.0.1-SNAPSHOT</version>  
<packaging>pom</packaging>  
<name>Parent - Pom Aggregator</name>  
<properties>  
<java.version>1.8</java.version>  
</properties>  
<dependencies>  
<!-- Spring Boot dependencies -->  
<dependency>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-starter</artifactId>  
</dependency>  
<dependency>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-starter-data-jpa</artifactId>  
</dependency>  
<dependency>  
<groupId>org.springframework.boot</groupId>  
<artifactId>spring-boot-starter-test</artifactId>  
<scope>test</scope>  
</dependency>  
</dependencies>  
</project>  
```
One thing to be noticed in the above pom file is that there is no maven module configured because we have not created yet. Now we will create Maven Modules one by one that we have specified above.

Step 3: Create a Maven Module with the name application.

Step 4: Open the pom.xml file of application module and ensure that the packaging type is jar.

pom.xml
```pom
<?xml version="1.0" encoding="UTF-8" standalone="no"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
    <modelVersion>4.0.0</modelVersion>  
    <parent>  
        <groupId>sample.multimodule</groupId>  
        <artifactId>sample.multimodule</artifactId>  
        <version>0.0.1-SNAPSHOT</version>  
    </parent>  
    <artifactId>sample.multimodule.application</artifactId>  
    <packaging>jar</packaging>  
    <name>Project Module - Application</name>  
    <dependencies>  
      <!-- Project modules -->  
      <dependency>  
        <groupId>sample.multimodule</groupId>  
        <artifactId>sample.multimodule.service.impl</artifactId>  
        <version>${project.version}</version>  
      </dependency>  
  
      <!-- Spring Boot dependencies -->  
          <dependency>  
              <groupId>org.apache.tomcat.embed</groupId>  
              <artifactId>tomcat-embed-jasper</artifactId>  
              <scope>provided</scope>  
          </dependency>  
      <dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-web</artifactId>  
      </dependency>  
      <dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-thymeleaf</artifactId>  
      </dependency>  
      
    </dependencies>  
      
    <build>  
        <plugins>  
            <!-- Spring Boot plugins -->  
            <plugin>  
                <groupId>org.springframework.boot</groupId>  
                <artifactId>spring-boot-maven-plugin</artifactId>  
            </plugin>  
        </plugins>  
    </build>  
  
</project>
```
Step 5: Create the main class. It is the class that is to be run.
```java
SampleWebJspApplication.java

package sample.multimodule;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.orm.jpa.EntityScan;  
@SpringBootApplication  
public class SampleWebJspApplication   
{  
public static void main(String[] args) throws Exception   
{  
SpringApplication.run(SampleWebJspApplication.class, args);  
}  
}
```
Step 6: Create a Controller class with the name WelocameController under the package smaple.multimodule.web.

WelcomeController.java
```java
package sample.multimodule.web;  
import java.util.Date;  
import java.util.Map;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.beans.factory.annotation.Value;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import sample.multimodule.domain.entity.Account;  
import sample.multimodule.service.api.AccountService;  
@Controller  
public class WelcomeController   
{  
@Value("${application.message:Hello World}")  
private String message = "Hello World";  
@Autowired  
protected AccountService accountService;  
@RequestMapping("/")  
public String welcome(Map<String, Object> model)   
{  
// Trying to obtain 23 account  
Account account = accountService.findOne("23");  
if(account == null){  
// If there's some problem creating account, return show view with error status  
model.put("message", "Error getting account!");  
model.put("account", "");  
return "welcome/show";  
}    
// Return show view with 23 account info  
String accountInfo = "Your account number is ".concat(account.getNumber());  
model.put("message", this.message);  
model.put("account", accountInfo);  
return "welcome/show";  
}  
@RequestMapping("foo")  
public String foo(Map<String, Object> model) {  
throw new RuntimeException("Foo");  
}  
}
```
Step 7: Open theapplication.properties file, configure the application message and thymeleaf cache to false.

application.properties
```
# Application messages  
application.message = Hello User!  
dummy.type = type-inside-the-war  
# Spring Thymeleaf config  
spring.thymeleaf.cache = false
```
After creating all the above files, the application module directory looks like the following:

### Spring Boot Multi-Module Project

Create a multimodule project where parent module named as **spring-boot-microservice**.

Add below dependencies for parent module **spring-boot-microservice** pom.xml.

```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.1</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>com.spring.boot.microservice</groupId>
    <artifactId>spring-boot-microservice</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>product-service</module>
        <module>order-service</module>
        <module>inventory-service</module>
        <module>discovery-server</module>
        <module>api-gateway</module>
        <module>notification-service</module>
    </modules>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        **<spring-cloud.version>2023.0.0</spring-cloud.version>**
    </properties>

    **<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>**

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>com.google.cloud.tools</groupId>
                <artifactId>jib-maven-plugin</artifactId>
                <version>3.2.1</version>
                <configuration>
                    <from>
                        <image>eclipse-temurin:17.0.4.1_1-jre</image>
                    </from>
                    <to>
                        <image>microservices-tutorial/${project.artifactId}</image>
                    </to>
                </configuration>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>dockerBuild</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```
Inside parent module create the child modules named as **product-service**, **order-service**, **inventory-service**, **notification-service**, **dicovery-server** and **api-gateway**.

Add below dependencies for child modules **product-service**, **order-service**, **inventory-service**, **notification-service** and **api-gateway** pom.xml file.

Child module product-service pom.xml:

```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <groupId>com.spring.boot.microservice</groupId>
        <artifactId>spring-boot-microservice</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>product-service</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
       **<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>**
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>mongodb</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-testcontainers</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-tracing-bridge-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin.reporter2</groupId>
            <artifactId>zipkin-reporter-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
</project>
```
Child module order-service pom.xml:
```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <groupId>com.spring.boot.microservice</groupId>
        <artifactId>spring-boot-microservice</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>order-service</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
       **<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>**
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-tracing-bridge-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin.reporter2</groupId>
            <artifactId>zipkin-reporter-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
</project>
```
Child module inventory-service pom.xml:
```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <groupId>com.spring.boot.microservice</groupId>
        <artifactId>spring-boot-microservice</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>inventory-service</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        **<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>**
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-tracing-bridge-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin.reporter2</groupId>
            <artifactId>zipkin-reporter-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
</project>
```
Child module discovery-server pom.xml:
```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <groupId>com.spring.boot.microservice</groupId>
        <artifactId>spring-boot-microservice</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>discovery-server</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        **<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>**
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-tracing-bridge-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin.reporter2</groupId>
            <artifactId>zipkin-reporter-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
</project>
```
Child module api-gateway pom.xml:
```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <groupId>com.spring.boot.microservice</groupId>
        <artifactId>spring-boot-microservice</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>api-gateway</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>
        **<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>**
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-tracing-bridge-brave</artifactId>
        </dependency>
        <dependency>
          <groupId>io.zipkin.reporter2</groupId>
          <artifactId>zipkin-reporter-brave</artifactId>
        </dependency>

        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
        </dependency>
    </dependencies>
</project>
```
Child module notification-service pom.xml:
```pom
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <groupId>com.spring.boot.microservice</groupId>
        <artifactId>spring-boot-microservice</artifactId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>notification-service</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <java.version>17</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>
        **<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>**
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-tracing-bridge-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.zipkin.reporter2</groupId>
            <artifactId>zipkin-reporter-brave</artifactId>
        </dependency>
        <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
</project>
```

### Register the microservices to Eureka Server by adding the **@EnableDiscoveryClient** annotation service main class and EurekaClient properties in **application.properties** file.

- **product-service**

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
```
**application.properties**

```
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=product-service
eureka.client.serviceUrl.defaultZone=http://eureka:password@localhost:8761/eureka
spring.application.name=product-service
server.port=0
```

- **order-service**

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
```
**application.properties**

```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/order_service
spring.datasource.username=root
spring.datasource.password=mysql
spring.jpa.hibernate.ddl-auto=update

server.port=8081
eureka.client.serviceUrl.defaultZone=http://eureka:password@localhost:8761/eureka
spring.application.name=order-service
```

- **inventory-service**

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
}
```

**application.properties**

```
server.port=0
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_service
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=mysql
spring.jpa.hibernate.ddl-auto=update
eureka.client.serviceUrl.defaultZone=http://eureka:password@localhost:8761/eureka
spring.application.name=inventory-service
```

- **notification-service**

```java
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceApplication {

    private final ObservationRegistry observationRegistry;
    private final Tracer tracer;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
        Observation.createNotStarted("on-message", this.observationRegistry).observe(() -> {
            log.info("Got message <{}>", orderPlacedEvent);
            log.info("TraceId- {}, Received Notification for Order - {}", this.tracer.currentSpan().context().traceId(),
                    orderPlacedEvent.getOrderNumber());
        });
        // send out an email notification
    }
}
```

**application.properties** file

```
eureka.client.serviceUrl.defaultZone=http://eureka:password@localhost:8761/eureka
spring.application.name=notification-service
server.port=0
```
- **api-gateway**

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
```
**application.properties**
```
spring.application.name=api-gateway
eureka.client.serviceUrl.defaultZone=http://eureka:password@localhost:8761/eureka
app.eureka-server=localhost

## Product Service Route
spring.cloud.gateway.routes[0].id=product-service
spring.cloud.gateway.routes[0].uri=lb://product-service
spring.cloud.gateway.routes[0].predicates[0]=Path=/api/product

## Order Service Route
spring.cloud.gateway.routes[1].id=order-service
spring.cloud.gateway.routes[1].uri=lb://order-service
spring.cloud.gateway.routes[1].predicates[0]=Path=/api/order

## Discover Server Route
spring.cloud.gateway.routes[2].id=discovery-server
spring.cloud.gateway.routes[2].uri=http://eureka:password@${app.eureka-server}:8761
spring.cloud.gateway.routes[2].predicates[0]=Path=/eureka/web
spring.cloud.gateway.routes[2].filters[0]=SetPath=/

## Discover Server Static Resources Route
spring.cloud.gateway.routes[3].id=discovery-server-static
spring.cloud.gateway.routes[3].uri=http://eureka:password@${app.eureka-server}:8761
spring.cloud.gateway.routes[3].predicates[0]=Path=/eureka/**
```

### Register the **discovery-server** to Eureka Server by adding the **@EnableEurekaServer** annotation service main class and in **application.properties** file.

DiscoveryServerApplication.java

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
**@EnableEurekaServer**
public class DiscoveryServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }
}
```
**discovery-server application.properties** file
```
eureka.instance.hostname=localhost
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
server.port=8761
```


- Service-Discovery
  - Create a new Spring Boot project for Service-Discovery using Netflix Eureka
  - Add dependencies for Spring Cloud Eureka Server
  - Configure Eureka Server to register and discover microservices
- API-Gateway
  - Create a new Spring Boot project for API-Gateway using Spring Cloud Gateway
  - Add dependencies for Spring Cloud Gateway
  - Configure API Gateway to route requests to appropriate microservices based on the path
- Notification-Service
  - Create a new Spring Boot project for Notification-Service
  - Implement REST endpoints for sending notifications to users
  - Add dependencies for Spring Web and Spring Messaging
  - Implement a messaging service to send notifications
    
By following this structure, you can create a modular and scalable microservice architecture using Spring Boot. Each microservice is responsible for a specific domain (such as products, orders, inventory, notifications) and can be easily extended or updated without affecting other services. Service Discovery and API Gateway help in managing communication between services and routing requests efficiently.

Open the pom.xml (parent pom) file.

pom.xml (parent pom)
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>com.springboot.microservice</groupId>
    <artifactId>spring-boot-microservices</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>product-service</module>
        <module>order-service</module>
        <module>inventory-service</module>
    </modules>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <spring-cloud.version>2023.0.1</spring-cloud.version>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
```
spring-boot-microservices
├───product-service
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── product
|   |   |   |                   ├── ProductServiceApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── ProductController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── ProductRequest.java
|   |   |   |                   |   └── ProductResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Product.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── ProductService.java
|   |   |   |                   └── repository
|   |   |   |                       └── ProductRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── product
|   |       │   │                   └── ProductServiceApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
├───order-service
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── order
|   |   |   |                   ├── OrderServiceApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── OrderController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── OrdertRequest.java
|   |   |   |                   |   └── OrderResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Order.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── OrderService.java
|   |   |   |                   └── repository
|   |   |   |                       └── OrderRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── order
|   |       │   │                   └── OrderServiceApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
├───inventory-service
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── inventory
|   |   |   |                   ├── InventoryServiceApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── InventoryController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── InventoryRequest.java
|   |   |   |                   |   └── InventoryResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Inventory.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── InventoryService.java
|   |   |   |                   └── repository
|   |   |   |                       └── InventoryRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── inventory
|   |       │   │                   └── InventoryServiceApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
├───notification-service
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── notification
|   |   |   |                   ├── NotificationServiceApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── NotificationController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── NotificationRequest.java
|   |   |   |                   |   └── NotificationResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Notification.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── NotificationService.java
|   |   |   |                   └── repository
|   |   |   |                       └── NotificationRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── notification
|   |       │   │                   └── NotificationServiceApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
├───service-discovery
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── product
|   |   |   |                   ├── ProductServiceApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── ProductController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── ProductRequest.java
|   |   |   |                   |   └── ProductResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Product.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── ProductService.java
|   |   |   |                   └── repository
|   |   |   |                       └── ProductRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── product
|   |       │   │                   └── ProductServiceApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
└───api-gateway
|   ├── src
|   │   ├── main
|   │   │   ├── java
|   │   │   │   └── com
|   |   |   |       └── springboot
|   |   |   |           └── microservice
|   |   |   |               └── gateway
|   |   |   |                   ├── ApiGatewayApplication.java
|   |   |   |                   ├── controller
|   |   |   |                   |   └── ProductController.java
|   |   |   |                   ├── dto
|   |   |   |                   |   ├── ProductRequest.java
|   |   |   |                   |   └── ProductResponse.java
│   |   │   │                   ├── model
│   |   │   │                   │   └── Product.java
|   |   |   |                   ├── service
|   |   |   |                   |   └── ProductService.java
|   |   |   |                   └── repository
|   |   |   |                       └── ProductRepository.java
|   |   |   └── resources
|   |   |       ├── application.properties
|   |   |       ├── static
|   |   |       ├── templates
|   |   |       └── META-INF
|   |   |           └── MANIFEST.MF
|   |   └── src
|   |       ├── test
|   |       │   ├── java
|   |       │   │   └── com
|   |       │   │       └── springboot
|   |       │   │           └── microservice
|   |       │   │               └── gateway
|   |       │   │                   └── ApiGatewayApplicationTest.java
|   |       └── resources
|   |           └── application.properties
|   └── pom.xml
└── pom.xml
```
- product-service: This module contains the code for managing products.
- order-service: This module contains the code for managing orders.
- inventory-service: This module contains the code for managing inventory.
- notification-service: This module contains the code for sending notifications.
- service-discovery: This module contains the code for service discovery using Eureka or Consul.
- api-gateway: This module contains the code for API gateway using Zuul or Spring Cloud Gateway.
pom.xml: Main Maven project file that includes all the submodule dependencies
