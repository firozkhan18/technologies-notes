# 🎯 Key Takeaways for Quick Navigation

- 🚀 **Tutorial on Developing a Spring Boot Application**: Using microservices architecture, covering patterns like service discovery, configuration, and tracing.
- 📦 **Services**: Includes product, order, inventory, and notification, with communication being both synchronous and asynchronous.
- 🏗️ **Architecture**: Services include product service with MongoDB, order service with MySQL, managed through an API Gateway and services like Eureka, Config Server, Vault, Zipkin, etc.
- 📚 **Service Structure**: Each service follows a similar structure with controller, service, and repository layers for handling HTTP requests, business logic, and database interactions.
- 🧪 **Integration Testing**: Spring Boot facilitates integration tests with annotations like `@AutoConfigureMockMvc` and `MockMvc`.
- 🐳 **Testcontainers**: Supports writing JUnit tests by providing disposable instances of common software, enabling integration tests without relying on external infrastructure.
- 📦 **BOM for Testcontainers**: Allows managing versions in a centralized way.
- 🖥️ **Integration Tests**: Can be written using Testcontainers and JUnit.
- 📝 **Controller Testing**: Involves using `MockMvc` to simulate HTTP requests and verify responses.
- 🏗️ **IntelliJ Access**: Access both product and order services by opening the microservices parent folder.
- ⚙️ **OrderController Class**: Create with annotations for REST endpoints, request mapping, and post mapping for placing orders.
- 🧭 **Inventory Controller**: Create a method `isInStock` to check product availability.
- 🧩 **InventoryService Class**: Includes an `isInStock` method that queries the inventory repository.
- 📦 **Data Loading**: Load data into the database at application startup using a `CommandLineRunner` bean.
- 🚀 **Project Restructure**: Restructure into a single parent Maven project with modules for each service.
- 🛠️ **Production Setup**: Avoid using `ddl-auto` as `create-drop`; use `ddl-auto` as `none` and employ a database migration library like Liquibase or Flyway.
- 🔄 **Service Communication**: Should be synchronous or asynchronous.
- 🔄 **Synchronous Communication**: Use HTTP clients like RestTemplate or WebClient.
- 🔄 **Batch Data**: Collect relevant information and pass them as a list to the service instead of multiple HTTP calls.
- 🌐 **API Gateway**: Can route requests to the Discovery server using a specified path.
- 🔒 **Microservice Security**: Introduce an authentication mechanism like Keycloak.
- 🔑 **Keycloak Realms**: Use realms to group clients and interact with the authentication server.
- 🔍 **Distributed Tracing**: Helps track requests from start to finish, crucial for understanding performance issues.
- 🌐 **Spring Cloud Sleuth**: Generates trace IDs and Zipkin visualizes distributed tracing information.
- 🔎 **Tracing Integration**: Spring Cloud Sleuth with Zipkin enables tracing of request lifecycle across microservices.
- 🐋 **Docker Introduction**: For containerizing microservices, focusing on Dockerizing a Spring Boot project using a Dockerfile.
- 🏗️ **Dockerfile Optimization**: Improve with multi-stage builds to optimize image size and build times.
- 🐳 **Docker Image Optimization**: Reduces image size and improves efficiency using multi-stage builds.
- 🏗 **Jib**: A library from Google that builds containers from Java applications without using Dockerfiles or Docker itself.
- 🛠 **Maven Jib Plugin**: Configured in `pom.xml` to automate building and pushing Docker images to Docker Hub.
- 🔑 **Docker Hub Credentials**: Add authentication credentials to `settings.xml` in Maven to avoid unauthorized exceptions.
- 🚀 **Jib Command**: Use `mvn clean compile jib:build` to build and push Docker images for all projects in a Maven setup.
- 🐋 **Docker Compose**: Manage multi-container Docker applications, simplifying deployment and orchestration.
- 🗃 **External Services Setup**: Docker Compose allows setting up external services like databases (MySQL, PostgreSQL) and linking them to microservices.
- 📂 **Docker Volumes**: Persist data between container restarts, ensuring data integrity and availability.
- 🌐 **Service Startup Configuration**: Docker Compose can be configured to start services like Eureka server, API Gateway, and others, defining dependencies for proper startup sequence.
- 💻 **Service Management**: The Spring Boot microservices project uses Docker Compose to manage multiple services, each with its own Docker container.
- 🛠 **Configuration Flexibility**: Properties for each service can be overridden through the Docker Compose file.
- 🐳 **Container Communication**: Often requires specific port configurations, especially for services like Kafka.
- 📦 **Microservice Configuration**: Each microservice is configured with its dependencies (e.g., databases, Kafka, Zipkin, Discovery server) and exposed ports.
- 🚀 **Single Command Start**: Docker Compose can start all services with a single command, pulling required images and running containers in daemon mode.
- 🔒 **Keycloak Accessibility**: Accessing Keycloak services from Docker containers may require updating the host file for DNS resolution.
- 🚫 **JWT Claims Validation**: Errors can occur if the token's ISS (Issuer) claim does not match the expected value.
- 🖥 **Windows Host File**: May need editing for Docker containers to communicate with services like Keycloak using hostnames.
- 🔄 **Monitoring Setup**: Configure monitoring using Prometheus and Grafana; Spring Boot Actuator exposes metrics for Prometheus to visualize.
- 🔄 **Actuator Endpoints**: Enable Spring Boot Actuator endpoints and configure Prometheus to scrape metrics.
- 🐛 **Error Resolution**: Remove duplicate property key errors by eliminating unused wildcard actuator configuration.
- 🐳 **Monitoring with Docker Compose**: Use Docker Compose to set up Prometheus and Grafana for monitoring.
- 🛠 **Prometheus Configuration**: Configure Prometheus in Docker Compose to scrape metrics from Spring Boot applications.
- 📊 **Grafana Setup**: Set up Grafana in Docker Compose with user credentials for UI login.
- 📝 **Prometheus Configuration File**: Create to define scrape intervals and targets.

### Key Takeaways for Developing a Spring Boot Microservices Application

#### Architecture Overview
- **Microservices Structure**: Application includes product, order, inventory, and notification services.
- **Data Storage**: 
  - Product Service: MongoDB
  - Order Service: MySQL
- **Communication**: Utilizes both synchronous (HTTP) and asynchronous methods (e.g., message queues).

#### Essential Components
- **Service Discovery**: Eureka for locating services.
- **Configuration Management**: Spring Cloud Config Server for externalized configuration.
- **API Gateway**: Routes requests and manages communication.
- **Distributed Tracing**: Spring Cloud Sleuth and Zipkin for tracking requests across services.

#### Development Practices
- **Project Structure**: Organize as a parent Maven project with individual modules for each service.
- **Layered Architecture**:
  - **Controller Layer**: Handles HTTP requests.
  - **Service Layer**: Contains business logic.
  - **Repository Layer**: Manages database interactions.

#### Testing
- **Integration Testing**:
  - Use `@AutoConfigureMockMvc` and `MockMvc` for simulating HTTP requests.
  - Testcontainers for running tests with disposable instances of external services.

#### Docker and Containerization
- **Dockerization**: Create Dockerfiles for each service.
- **Multi-Stage Builds**: Optimize image size and build times.
- **Jib Plugin**: Build Docker images directly from Java projects without Dockerfile.

#### Deployment
- **Docker Compose**: Manage multi-container applications, defining services and dependencies.
- **Volume Management**: Use Docker volumes for data persistence.
- **Configuration Overrides**: Customize settings in Docker Compose.

#### Security and Monitoring
- **Authentication**: Use Keycloak for securing microservices.
- **Monitoring**:
  - Spring Boot Actuator to expose application metrics.
  - Prometheus and Grafana for monitoring and visualization.

#### Best Practices
- **Avoid `ddl-auto` in Production**: Use migration tools like Liquibase or Flyway instead.
- **Optimize Service Communication**: Collect and batch data to reduce HTTP calls.
- **Configuration Management**: Ensure properties can be overridden as needed in different environments.

# Step-by-step guide to building a microservices

### Step 1: Introduction to Microservices

Microservices architecture is an approach to software development where applications are composed of small, independent services that communicate over well-defined APIs. This architecture promotes scalability, resilience, and flexibility.

---

### Step 2: High-Level Architecture

#### Diagram
You can create a high-level architecture diagram using tools like Lucidchart or draw.io. Here's a simple description:

- **API Gateway**: Routes requests to various services.
- **Service Registry (Eureka)**: Maintains a list of available services.
- **Microservices**: Individual services handling specific business capabilities.
- **Database**: Each service may have its own database.
- **Message Broker (Kafka)**: Manages asynchronous communication between services.

---

### Step 3: Logical Architecture

Define the logical architecture with microservices corresponding to business capabilities, for example:

- **User Service**: Handles user management.
- **Product Service**: Manages product details.
- **Order Service**: Processes orders.

---

### Step 4: Build Services

#### Example: User Service

1. **Create a Spring Boot Project**

   Use Spring Initializr (https://start.spring.io/) to create a new project with the following dependencies:
   - Spring Web
   - Spring Data JPA
   - H2 Database (for demo purposes)

2. **Project Structure**
   ```
   user-service
   ├── src
   │   ├── main
   │   │   ├── java
   │   │   │   └── com
   │   │   │       └── example
   │   │   │           └── userservice
   │   │   │               ├── UserServiceApplication.java
   │   │   │               ├── controller
   │   │   │               │   └── UserController.java
   │   │   │               ├── model
   │   │   │               │   └── User.java
   │   │   │               └── repository
   │   │   │                   └── UserRepository.java
   │   │   └── resources
   │   │       └── application.yml
   ```

3. **Code Example**

   - **User.java**
     ```java
     package com.example.userservice.model;

     import javax.persistence.Entity;
     import javax.persistence.GeneratedValue;
     import javax.persistence.GenerationType;
     import javax.persistence.Id;

     @Entity
     public class User {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;
         private String name;
         private String email;

         // Getters and Setters
     }
     ```

   - **UserRepository.java**
     ```java
     package com.example.userservice.repository;

     import com.example.userservice.model.User;
     import org.springframework.data.jpa.repository.JpaRepository;

     public interface UserRepository extends JpaRepository<User, Long> {}
     ```

   - **UserController.java**
     ```java
     package com.example.userservice.controller;

     import com.example.userservice.model.User;
     import com.example.userservice.repository.UserRepository;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.web.bind.annotation.*;

     import java.util.List;

     @RestController
     @RequestMapping("/users")
     public class UserController {

         @Autowired
         private UserRepository userRepository;

         @GetMapping
         public List<User> getAllUsers() {
             return userRepository.findAll();
         }

         @PostMapping
         public User createUser(@RequestBody User user) {
             return userRepository.save(user);
         }
     }
     ```

   - **application.yml**
     ```yaml
     server:
       port: 8081

     spring:
       datasource:
         url: jdbc:h2:mem:testdb
         driver-class-name: org.h2.Driver
         username: sa
         password:
       h2:
         console:
           enabled: true
       jpa:
         hibernate:
           ddl-auto: update
         show-sql: true
     ```

4. **Run the Application**
   Use the following command:
   ```bash
   ./mvnw spring-boot:run
   ```

---

### Step 5: Inter-Process Communication

For communication, you can use REST APIs or messaging. Here’s how to use REST.

### Step 6: Service Discovery using Netflix Eureka

1. **Add Eureka Server Dependency**
   Create a new Spring Boot project for Eureka Server with the following dependency:
   - Spring Cloud Eureka Server

2. **Code Example**

   - **EurekaServerApplication.java**
     ```java
     package com.example.eurekaserver;

     import org.springframework.boot.SpringApplication;
     import org.springframework.boot.autoconfigure.SpringBootApplication;
     import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

     @SpringBootApplication
     @EnableEurekaServer
     public class EurekaServerApplication {
         public static void main(String[] args) {
             SpringApplication.run(EurekaServerApplication.class, args);
         }
     }
     ```

   - **application.yml**
     ```yaml
     server:
       port: 8761

     eureka:
       client:
         register-with-eureka: false
         fetch-registry: false
       server:
         enable-self-preservation: false
     ```

3. **Run the Eureka Server**
   ```bash
   ./mvnw spring-boot:run
   ```

---

### Step 7: Implement API Gateway using Spring Cloud Gateway

1. **Add Gateway Dependency**
   Create a new Spring Boot project for the API Gateway with the following dependency:
   - Spring Cloud Gateway

2. **Code Example**

   - **GatewayApplication.java**
     ```java
     package com.example.gateway;

     import org.springframework.boot.SpringApplication;
     import org.springframework.boot.autoconfigure.SpringBootApplication;

     @SpringBootApplication
     public class GatewayApplication {
         public static void main(String[] args) {
             SpringApplication.run(GatewayApplication.class, args);
         }
     }
     ```

   - **application.yml**
     ```yaml
     spring:
       cloud:
         gateway:
           routes:
             - id: user-service
               uri: lb://user-service
               predicates:
                 - Path=/users/**
     ```

3. **Run the API Gateway**
   ```bash
   ./mvnw spring-boot:run
   ```

---

### Step 8: Secure Microservices using Keycloak

1. **Set Up Keycloak**
   - Download and run Keycloak:
     ```bash
     docker run -d -p 8080:8080 --name keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak
     ```

2. **Create a Realm and Client**
   - Access Keycloak at `http://localhost:8080`.
   - Create a new realm (e.g., `myrealm`).
   - Create a client (e.g., `user-service`) and set the access type to `confidential`.

3. **Configure Microservices**
   - Add Keycloak dependencies in your microservices:
     ```xml
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-oauth2-client</artifactId>
     </dependency>
     <dependency>
         <groupId>org.keycloak</groupId>
         <artifactId>keycloak-spring-boot-starter</artifactId>
     </dependency>
     ```

   - **application.yml**
     ```yaml
     keycloak:
       realm: myrealm
       auth-server-url: http://localhost:8080/auth
       resource: user-service
       credentials:
         secret: YOUR_CLIENT_SECRET
     ```

4. **Run the Service**
   Ensure the service is running and accessible.

---

### Step 9: Implement Circuit Breaker

1. **Add Resilience4j Dependency**
   ```xml
   <dependency>
       <groupId>io.github.resilience4j</groupId>
       <artifactId>resilience4j-spring-boot2</artifactId>
   </dependency>
   ```

2. **Implement Circuit Breaker in Service**
   - **UserController.java**
     ```java
     @GetMapping("/fallback")
     @CircuitBreaker
     public String fallback() {
         return "Fallback response";
     }
     ```

---

### Step 10: Implement Distributed Tracing

1. **Add Spring Cloud Sleuth Dependency**
   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-sleuth</artifactId>
   </dependency>
   ```

2. **Run Zipkin for Tracing**
   ```bash
   docker run -d -p 9411:9411 openzipkin/zipkin
   ```

3. **Configure Application to Use Zipkin**
   - **application.yml**
     ```yaml
     spring:
       sleuth:
         sampler:
           probability: 1.0
       zipkin:
         base-url: http://localhost:9411
     ```

---

### Step 11: Event Driven Architecture using Kafka

1. **Run Kafka using Docker**
   ```bash
   docker run -d --name=zookeeper -p 2181:2181 zookeeper
   docker run -d --name=kafka -p 9092:9092 --link zookeeper -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_LISTENER_SECURITY

_PROTOCOL_MAP=PLAINTEXT:PLAINTEXT -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 wurstmeister/kafka
   ```

2. **Add Kafka Dependencies to Microservice**
   ```xml
   <dependency>
       <groupId>org.springframework.kafka</groupId>
       <artifactId>spring-kafka</artifactId>
   </dependency>
   ```

3. **Producer and Consumer Example**
   - **KafkaProducer.java**
     ```java
     @Service
     public class KafkaProducer {
         @Autowired
         private KafkaTemplate<String, String> kafkaTemplate;

         public void sendMessage(String message) {
             kafkaTemplate.send("topic-name", message);
         }
     }
     ```

   - **KafkaConsumer.java**
     ```java
     @Service
     public class KafkaConsumer {
         @KafkaListener(topics = "topic-name", groupId = "group_id")
         public void consume(String message) {
             System.out.println("Consumed message: " + message);
         }
     }
     ```

---

### Step 12: Dockerize the Application

1. **Create Dockerfile for User Service**
   ```dockerfile
   FROM openjdk:11-jre-slim
   VOLUME /tmp
   COPY target/user-service.jar app.jar
   ENTRYPOINT ["java","-jar","/app.jar"]
   ```

2. **Build and Run Docker Image**
   ```bash
   ./mvnw clean package
   docker build -t user-service .
   docker run -p 8081:8081 user-service
   ```

---

### Step 13: Monitoring Microservices using Prometheus and Grafana

1. **Run Prometheus and Grafana using Docker**
   ```bash
   docker run -d -p 9090:9090 prom/prometheus
   docker run -d -p 3000:3000 grafana/grafana
   ```

2. **Configure Prometheus**
   Create a `prometheus.yml` configuration file:
   ```yaml
   global:
     scrape_interval: 15s

   scrape_configs:
     - job_name: 'user-service'
       static_configs:
         - targets: ['user-service:8081']
   ```

   Run Prometheus with the configuration:
   ```bash
   docker run -d -p 9090:9090 -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
   ```

3. **Access Grafana**
   Access Grafana at `http://localhost:3000`, and add Prometheus as a data source to visualize metrics.

---

### Conclusion

You now have a basic microservices architecture with user service, API gateway, service discovery, security, circuit breaking, distributed tracing, event-driven architecture, containerization, and monitoring in place. 

# Tutorial: Developing a Spring Boot Application Using Microservices Architecture

This tutorial will guide you through developing a Spring Boot application using a microservices architecture, covering essential components like service discovery, configuration management, and tracing.

## Project Overview

### Services Included
- **Product Service**: Manages product information using MongoDB.
- **Order Service**: Handles orders using MySQL.
- **Inventory Service**: Manages inventory stock levels.
- **Notification Service**: Sends notifications for events.

### Architecture Components
- **API Gateway**: Routes requests to various services.
- **Eureka**: Service discovery for locating services.
- **Config Server**: Centralized configuration management.
- **Zipkin**: Distributed tracing for tracking request flow.

## Project Structure

We'll use a Maven multi-module project structure, where each service is a separate module. Here’s a high-level view:

```
microservices-parent
│
├── product-service
│   └── src/main/java/com/example/product
│
├── order-service
│   └── src/main/java/com/example/order
│
├── inventory-service
│   └── src/main/java/com/example/inventory
│
├── notification-service
│   └── src/main/java/com/example/notification
│
└── gateway-service
    └── src/main/java/com/example/gateway
```

## Step-by-Step Implementation

### 1. Create the Parent Maven Project

Create a new Maven project with the following `pom.xml`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>microservices-parent</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>pom</packaging>
    <modules>
        <module>product-service</module>
        <module>order-service</module>
        <module>inventory-service</module>
        <module>notification-service</module>
        <module>gateway-service</module>
    </modules>
</project>
```

### 2. Create the Product Service

**pom.xml** for `product-service`:

```xml
<project>
    <parent>
        <groupId>com.example</groupId>
        <artifactId>microservices-parent</artifactId>
    </parent>
    <artifactId>product-service</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```

**Product Model**:

```java
package com.example.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private double price;

    // Getters and setters
}
```

**Product Repository**:

```java
package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
```

**Product Controller**:

```java
package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
```

### 3. Create the Order Service

**pom.xml** for `order-service`:

```xml
<project>
    <parent>
        <groupId>com.example</groupId>
        <artifactId>microservices-parent</artifactId>
    </parent>
    <artifactId>order-service</artifactId>
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
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
    </dependencies>
</project>
```

**Order Model**:

```java
package com.example.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private int quantity;

    // Getters and setters
}
```

**Order Repository**:

```java
package com.example.order.repository;

import com.example.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
```

**Order Controller**:

```java
package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
```

### 4. Create the Inventory Service

**pom.xml** for `inventory-service`:

```xml
<project>
    <parent>
        <groupId>com.example</groupId>
        <artifactId>microservices-parent</artifactId>
    </parent>
    <artifactId>inventory-service</artifactId>
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
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
    </dependencies>
</project>
```

**Inventory Model**:

```java
package com.example.inventory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private int stock;

    // Getters and setters
}
```

**Inventory Repository**:

```java
package com.example.inventory.repository;

import com.example.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
```

**Inventory Controller**:

```java
package com.example.inventory.controller;

import com.example.inventory.model.Inventory;
import com.example.inventory.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping("/{productId}")
    public boolean isInStock(@PathVariable String productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId);
        return inventory != null && inventory.getStock() > 0;
    }
}
```

### 5. Create the API Gateway

**pom.xml** for `gateway-service`:

```xml
<project>
    <parent>
        <groupId>com.example</groupId>
        <artifactId>microservices-parent</artifactId>
    </parent>
    <artifactId>gateway-service</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-client</artifactId>
        </dependency>
    </dependencies>
</project>
```

**Gateway Configuration**:

```java
package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product_service", r -> r.path("/products/**").uri("lb://

product-service"))
                .route("order_service", r -> r.path("/orders/**").uri("lb://order-service"))
                .route("inventory_service", r -> r.path("/inventory/**").uri("lb://inventory-service"))
                .build();
    }
}
```

### 6. Setup Service Discovery with Eureka

**Add Dependencies**:

In each service's `pom.xml`, add:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```

**Eureka Server Application**:

```java
package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
```

### 7. Configure Docker

**Dockerfile Example for Each Service**:

```dockerfile
# Dockerfile
FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/product-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

**docker-compose.yml**:

```yaml
version: '3.8'
services:
  eureka-server:
    image: eureka-server:latest
    build: ./eureka-server
    ports:
      - "8761:8761"

  product-service:
    image: product-service:latest
    build: ./product-service
    ports:
      - "8081:8080"
    environment:
      - EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8761/eureka/

  order-service:
    image: order-service:latest
    build: ./order-service
    ports:
      - "8082:8080"
    environment:
      - EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8761/eureka/

  inventory-service:
    image: inventory-service:latest
    build: ./inventory-service
    ports:
      - "8083:8080"
    environment:
      - EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8761/eureka/

  gateway-service:
    image: gateway-service:latest
    build: ./gateway-service
    ports:
      - "8080:8080"
    environment:
      - EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8761/eureka/
```

### 8. Running the Application

To run your application, navigate to your project root directory and execute:

```bash
docker-compose up --build
```

### 9. Testing the Services

You can test the services by accessing the following endpoints:

- **Product Service**: 
  - `POST /products` to create a product.
  - `GET /products` to retrieve products.

- **Order Service**:
  - `POST /orders` to create an order.
  - `GET /orders` to retrieve orders.

- **Inventory Service**:
  - `GET /inventory/{productId}` to check stock.

### 10. Integration Tests

For testing, create integration tests using JUnit and Testcontainers.

**Example Test**:

```java
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateProduct() throws Exception {
        String json = "{\"name\":\"Test Product\",\"price\":100.0}";

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}
```

### 11. Monitoring with Prometheus and Grafana

Add Spring Boot Actuator to each service for monitoring and configure Prometheus and Grafana in your Docker Compose file.

### 12. Conclusion

You now have a fully functional microservices architecture using Spring Boot with essential services, API gateway, service discovery, and Docker setup. This setup provides a solid foundation for building scalable and maintainable applications. Further enhancements can include adding security with Keycloak, distributed tracing with Zipkin, and implementing database migrations using Liquibase or Flyway.

Spring Boot Microservices Tutorial - Part 1
March 28, 2024
Introduction
In this Spring Boot Microservices Tutorial series, you will learn how to develop applications with Microservices Architecture using Spring Boot and Spring Cloud and deploy them using Docker and Kubernetes.

We will cover several concepts and Microservices Architectural Patterns as part of this tutorial series, here are the topics we are going to cover in each part:

Part -1 covers building REST-based applications using Spring Boot 3 and following several best practices.

Part -2 of this tutorial series covers, the Synchronous Inter-Service Communication Pattern using Spring Cloud Open Feign

Part - 3 covers the Service Discovery Pattern using Spring Cloud Netflix Eureka

Part - 4 covers the API Gateway Pattern using Spring Cloud Gateway

Part - 5 covers the Microservices Security using Keycloak

Part - 6 covers the Circuit Breaker Pattern using Spring Cloud CircuitBreaker with Resilience4J

Part - 7 covers the Event Driven Architecture Pattern using Kafka

Part - 8 covers the Observability Pattern, and we will be implementing Distributed Tracing using Open Telemetry and Grafana Tempo, we will be implementing the Log Aggregation Pattern to view the logs of our services using Grafana Loki, and we will be using Prometheus to collect the Metrics and Grafana to visualize the metrics in a dashboard.

In Part - 9, we will be containerizing all our applications using Docker. We will see how to run our applications using Docker Compose

In Part - 10, we will migrate our Docker Compose Workloads to Kubernetes

Application Overview
We will be building a simple e-commerce application where customers can order products. Our application contains the following services:

Product Service

Order Service

Inventory Service

Notification Service

To focus on the principles of Spring Cloud and Microservices, we will develop services with essential functionality rather than creating fully-featured e-commerce services.

Download Source Code
You can download the source code of this project through Github – https://github.com/SaiUpadhyayula/spring-boot-microservices/tree/initial-setup

Architecture Diagram of the Project
Here is the architecture diagram of the project we are going to cover in this tutorial series

Architecture Diagram for Spring Boot Microservices Project

Creating our First Microservice: Product Service
Let's start creating our first microservice (Product Service). As discussed before, we will keep this service simple and only include the most important features.

We are going to expose a REST API endpoint that will CREATE and READ products.

Service Operation	HTTP METHOD	Service End point
CREATE PRODUCT	POST	/api/product/
READ ALL PRODUCTS	GET	/api/product/
Product Service REST Operations

To create the project, let’s go to start.spring.io and create our project based on the following configuration:

Start.Spring.IO Configuration for Product Service

Here are the dependencies you need to add:

Lombok

Spring Web

Test Containers

Spring Data MongoDB

Java 21

Maven as the build tool

We are going to use MongoDB as the database backing our Product Service

After adding the necessary configuration, click on the Generate button, and the source code should be downloaded to your machine.

Unzip the source code and open it in your favorite IDE.

After opening the project, run the below command to build the project:

mvn clean verify
The application should be built successfully without any errors.

Download MongoDB using Docker and Docker Compose
We will be using Docker to install the necessary software like Databases, Message Queues, and other required software for this project.

If you don't have Docker installed on your machine, you can download it at this link: https://docs.docker.com/get-docker/

Once Docker is installed, create a file called docker-compose.yml in the root folder:

version: '4'
services:
  mongo:
    image: mongo:7.0.5
    container_name: mongo
    ports:
      - "27017:27017"
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: password
      MONGO_INITDB_DATABASE: product-service
    volumes:
      - ./docker/mongodb/data:/data/db
We have to configure the MongoDB URI Details inside the application.properties file:

spring.data.mongodb.uri=mongodb://root:password@localhost:27017/product-service?authSource=admin
If you are not aware of how to work with MongoDB and Spring Boot, have a look at the Spring Boot MongoDB REST API Tutorial

Creating the Create and Read Endpoints
Let's create the below model class which acts as the domain for the Products.

Product.java

package com.programmingtechie.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}

Next, let's create the Spring Data MongoDB interface for the Product class - ProductRepository.java

ProductRepository.java

package com.programming.techie.productservice.repository;


import com.programming.techie.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
Now let's create the service class - ProductService.java, which contains the actual business logic of our product-service, that is responsible for creating and reading the products from the database.

ProductService.java

package com.programmingtechie.productservice.service;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;
import com.programmingtechie.productservice.model.Product;
import com.programmingtechie.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }
}
Next, we need the Controller class that exposes the POST and GET endpoint to create and read the products.

ProductRestController.java

package com.programmingtechie.productservice.controller;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;
import com.programmingtechie.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}
The ProductController class uses ProductRequest and ProductResponse as the DTOs, let's also create those records

ProductRequest.java

package com.programmingtechie.productservice.dto;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, BigDecimal price) {
}
ProductResponse.java

package com.programmingtechie.productservice.dto;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, BigDecimal price) {
}
Testing the Product Service APIs
Let’s start the application and test our two Endpoints

We will start by creating a product, by calling the URL http://localhost:8080/api/product with HTTP Method POST, this REST call should return a status 201.

Create Product Test from Postman

Now let’s make a GET call to the URL - http://localhost:8080/api/product to test whether the created product is returned as a response or not.

Get All Products Test from Postman

Write Integration Tests for Product Service
Let's write a couple of Integration Tests to test our Create Product and Get Products Endpoints, for the integration test, as we need a real Mongo database, we will be using TestContainers to spin up a MongoDB Container as part of the test.

If you are unaware of Testcontainers, you can read more about it here: https://testcontainers.com/

Before writing our tests, we need to add one dependency to our pom.xml file:

        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.3.2</version>
        </dependency>
We added the rest-assured dependency as we need a real HTTP Client to call the endpoints while running the Integration Tests.

Let's create the integration test with the below code:

ProductServiceApplicationTests.java

package com.programmingtechie.productservice;

import com.programmingtechie.productservice.dto.ProductRequest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.7");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();
    }

    @Test
    void shouldCreateProduct() throws Exception {
        ProductRequest productRequest = getProductRequest();

        RestAssured.given()
                .contentType("application/json")
                .body(productRequest)
                .when()
                .post("/api/product")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo(productRequest.name()))
                .body("description", Matchers.equalTo(productRequest.description()))
                .body("price", Matchers.is(productRequest.price().intValueExact()));
    }

    private ProductRequest getProductRequest() {
        return new ProductRequest("iPhone 13", "iPhone 13", BigDecimal.valueOf(1200));
    }

}
Create Second Microservice - Order Service
Now let's create our 2nd Microservice, the order service, this service contains only one endpoint, to submit an order.

Service Operation	Endpoint Method	Service Endpoint
PLACE ORDER	POST	/api/order
Operations for Order Service

Let's create the project, by visiting the site start.spring.io

Create the project with below dependencies:

Spring Web

Lombok

Spring Data JPA

MySQL Driver

Flyway Migration

Testcontainers

We will be using Java 21 also for this service and Maven as the build tool.

Order Service Starter Configuratione

In Order Service, we are going to use MySQL Database, so let’s go ahead and download MySQL using docker-compose.

Create a docker-compose.yml file with the below contents:
```yaml
version: '4'
services:
  mysql:
    image: mysql:8.3.0
    container_name: mysql
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: mysql
    volumes:
      - ./mysql/init.sql:/docker-entrypoint-initdb.d/init.sql
      - ./docker/mysql/data:/var/lib/mysql
```
We need to create the database schema during the start-up of our MySQL Database, for that we added the line ./mysql/init.sql:/docker-entrypoint-initdb.d/init.sql which asks docker to copy the SQL file from the folder 'mysql' into the docker-entrypoint-initdb.d location and executes the SQL file.

If we don't add the above step, then we need to manually create the database.

Now let's configure our project to use MySQL by adding below properties in the application.properties file:
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/order_service
spring.datasource.username=root
spring.datasource.password=mysql
spring.jpa.hibernate.ddl-auto=none
server.port=8081
```
We are using the spring.jpa.hibernate.ddl-auto property as none because we don't want Hibernate to create the database tables and manage migrations, we will be handling that using the Flyway library.

Notice that we are running the order-service application on port 8081, as product-service is already running on port 8080

Database Migrations with Flyway
As mentioned before, we will be using Flyway to execute database migrations, the necessary dependencies for it are already added in the generated project. Here are the dependencies for Flyway:
```pom
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-mysql</artifactId>
</dependency>
```
By using Flyway, we can provide the necessary SQL scripts that will be executed whenever we need to change our database schema. We need to provide these scripts under the src/main/resources/db/migration folder.

Flyway will look for the scripts under this particular folder, and Flyway will also follow a particular naming convention to identify the SQL scripts, we need to name the files like below:

V<Number>__file-name.sql

Example: V1__init.sql, V2__add_products.sql, etc.

Note that the number, inside the name of the SQL file, needs to be incremented for each database migration you want to run.

Let's create the below file to create the Order table

V1__init.sql
```sql
CREATE TABLE `t_orders`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `order_number` varchar(255) DEFAULT NULL,
    `sku_code`  varchar(255),
    `price`    decimal(19, 2),
    `quantity` int(11),
    PRIMARY KEY (`id`)
);
```
Before running the migrations, let's create the necessary Model classes and the Submit Order Endpoint.

NOTE: I simplified some logic and the table structure recently. I removed the OrderLineItems table and the related logic to make the who logic simple. So you may find some discrepancies compared to the first version of the article which contains references to the OrderLineItems table.

### Order.java
```java
package com.programmingtechie.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
```
### OrderRepository.java
```java
package com.programmingtechie.orderservice.repository;

import com.programmingtechie.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
```
### OrderService.java
```java
package com.programmingtechie.orderservice.service;

import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        var order = mapToOrder(orderRequest);
        orderRepository.save(order);
    }

    private static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        return order;
    }
}
```
### OrderController.java
```java
package com.programmingtechie.orderservice.controller;

import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
```
### OrderRequest.java
```java
package com.programmingtechie.orderservice.dto;


import java.math.BigDecimal;

public record OrderRequest(Long id, String skuCode, BigDecimal price, Integer quantity) {
}
```
Testing the Application through Postman
Now Let's test our endpoints using Postman, before that let's start our application by running the OrderServiceApplication.java class

Let's make a POST request to the URL http://localhost:8081/api/order as seen in the below screenshot:

Testing Order Service through Postman

The request should be successful with HTTP Status 201 Created and the response body should have the text "Order Placed Successfully".

Writing Integration Tests for Order Service
Let's write the integration tests also for the OrderService.

### OrderServiceApplicationTests.java
```java
package com.programmingtechie.orderservice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }

    @Test
    void shouldSubmitOrder() {
        String submitOrderJson = """
                {
                     "skuCode": "iphone_15",
                     "price": 1000,
                     "quantity": 1
                }
                """;


        var responseBodyString = RestAssured.given()
                .contentType("application/json")
                .body(submitOrderJson)
                .when()
                .post("/api/order")
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .body().asString();

        assertThat(responseBodyString, Matchers.is("Order Placed Successfully"));
    }
}
```
## Creating Third Microservice - Inventory Service
Now let's create our 3rd microservice the Inventory Service. Go to start.spring.io and select the below dependencies:

Spring Web
Spring Data JPA
Lombok
Flyway
MySQL JDBC Driver
Test Containers
Java 21 and Maven as Build tool

The Inventory Service exposes only 1 endpoint, similar to the Order Service, here is a brief overview of the endpoint:

Service Operation	Endpoint Method	Service Endpoint
GET Inventory	GET	/api/inventory
REST Operations for Inventory Service

As we are using MySQL Database also for the inventory service, we need to first update the mysql/init.sql file with the SQL commands to create the inventory database.

mysql/init.sql
```sql
CREATE DATABASE IF NOT EXISTS order_service;
CREATE DATABASE IF NOT EXISTS inventory_service;
```
Now let's configure the application.properties file with the relevant Spring Data JPA and Hibernate properties to interact with MySQL Database:

application.yml
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_service
spring.datasource.username=root
spring.datasource.password=mysql
spring.jpa.hibernate.ddl-auto=none
server.port=8082
```
We are using almost the same configuration as the Order Service, the only difference is we will be running the Inventory Service on port 8082.

Let's also create the Flyway migration scripts under the src/main/resources/db/migration folder, here we will be creating 2 scripts:
- V1__init.sql
- V2__add_inventory.sql

The V1__init.sql file as the name suggests, creates the t_inventory table

V1__init.sql
```sql
CREATE TABLE `t_inventory`
(
    `id`       bigint(20) NOT NULL AUTO_INCREMENT,
    `sku_code`  varchar(255) DEFAULT NULL,
    `quantity` int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`)
);
```
V2__add_inventory.sql
```sql
insert into t_inventory (quantity, sku_code)
values (100, 'iphone_15'),
       (100, 'pixel_8'),
       (100, 'galaxy_24'),
       (100, 'oneplus_12');
```
Now let's go ahead and create the necessary code for implementing the Get Inventory endpoint.

### Inventory.java
```java
package com.programmingtechie.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(name = "t_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
InventoryRepository.java

package com.programmingtechie.inventoryservice.repository;

import com.programmingtechie.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
```
### InventoryService.java
```java
package com.programmingtechie.inventoryservice.service;

import com.programmingtechie.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
```
### InventoryController.java
```java
package com.programmingtechie.inventoryservice.controller;

import com.programmingtechie.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }
}
```
Now let's start the application by running the InventoryServiceApplication.class, and you should see the below logs, indicating that the database migrations are executed successfully.

Successfully applied 2 migrations to schema `inventory_service`, now at version v2 (execution time 00:00.033s)
Testing using Postman
Now let's open Postman and call the http://localhost:8082/api/inventory?skuCode=iphone_15&quantity=100 endpoint, notice that we are passing multiple SKUCodes in the Request Params.

Testing Inventory Service through Postman

Writing Integration Tests
Let's write integration tests for the Inventory Service.
```java
InventoryServiceApplicationTests.java

package com.programmingtechie.inventoryservice;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }

    @Test
    void shouldReadInventory() {
        var response = RestAssured.given()
                .when()
                .get("/api/inventory?skuCode=iphone_15&quantity=1")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response().as(Boolean.class);
        assertTrue(response);

        var negativeResponse = RestAssured.given()
                .when()
                .get("/api/inventory?skuCode=iphone_15&quantity=1000")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response().as(Boolean.class);
        assertFalse(negativeResponse);

    }

}
```
Conclusion
That's it for the first part of the Spring Boot Microservices Tutorial Series, we create 3 services for our application, and from the next part, we will be concentrating on applying the Microservice Design Patterns to our application.

In the next part, we will learn about Synchronous Inter-Service Communication Pattern using Spring Cloud OpenFeign. Until then, Happy Coding Techies!

Spring Boot Microservices Tutorial - Part 2

In Part 2 of this Spring Boot Microservices Tutorial series, we will implement Synchronous Communication between our Order Service and Inventory Service using Spring Cloud OpenFeign Library.

Spring Cloud OpenFeign library uses that provides OpenFeign integrations with Spring Boot and Spring Cloud. It provides a declarative REST Client that makes consuming REST Endpoints in our code easy.

Inter Process Communication

We will implement Synchronous Communication between Order Service and Inventory Service using the Spring Cloud OpenFeign library.

Add Spring Cloud OpenFeign to Order Service
To get started, let's add the Spring Cloud OpenFeign Starter to the pom.xml file of the Order Service.

pom.xml

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
We also need to add the spring-cloud-dependencies bom dependency to the <dependencyManagement> section in the pom.xml file.

<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
This is how your pom.xml should look like at the end:

pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>microservices-new</artifactId>
        <groupId>com.programming.techie</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>order-service</artifactId>

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
            <groupId>org.flywaydb</groupId>
            <artifactId>flyway-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.flywaydb</groupId>
            <artifactId>flyway-mysql</artifactId>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
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
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-testcontainers</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>mysql</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.3.2</version>
        </dependency>
    </dependencies>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>

Create FeignClient for Inventory Service
As we will be calling Inventory Service from Order Service, we need to create a class called InventoryClient.java inside the client package inside the order-service.

client/InventoryClient.java

package com.programmingtechie.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}

Notice that the @FeignClient annotation has an attribute called URL that is pointing to the inventory.url property in the application.properties file

inventory.url=http://localhost:8082
By externalizing this property we can replace it dynamically in tests or during startup time.

Coming to the method, we have the @RequestMapping annotation that is calling the path - /api/inventory.

Now we have to call the isInStock() method from the placeOrder() method of the Order Service.

If the client returns true, then we will place the order and save it to the database successfully, or else, we will throw a Runtime Exception

Here's how the OrderService class looks like with the final logic.

OrderService.java

package com.programmingtechie.orderservice.service;

import com.programmingtechie.orderservice.client.InventoryClient;
import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        boolean inStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (inStock) {
            var order = mapToOrder(orderRequest);
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with Skucode " + orderRequest.skuCode() + "is not in stock");
        }
    }

    private static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        return order;
    }
}

Before we go ahead and test our implementation, we have to add the @EnableFeignClients annotation to enable Feign Client Capabilities

OrderServiceApplication.java

package com.programmingtechie.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}

Manual Testing using Postman
Now it's time to test our implementation using Postman, make sure you start both the Order Service as well as the Inventory Service and call the Place Order Endpoint of Order Service.

Let's order the skuCode iphone_15, with a quantity of 100, as in Part -1 we initialized all skuCodes with quantity 100, this product should be in stock, and our Order should go through.

Submit Order with OpenFeign

Now let's change the quantity to 101, and this time our Order call should fail with a 500 error.

Order Service negative case

If you observe logs, then you should see the below exception message:

java.lang.RuntimeException: Product with Skucode iphone_15is not in stock
Updating the Integration Tests
Now if you run our Integration Tests in the order service, you will notice that they no longer run successfully as we are calling the Inventory Service.

To make these test successful, we have to use a library called Wiremock that provides a mock server environment to test our Order Service by making some mock HTTP calls.

By using Wiremock, we can verify if our Order Service is calling the inventory service with correct URL Params/Request Body/ Path Variables or not. We can also stub the response and test how our service is responding for various scenarios.

To enable wiremock, we need to add the following dependency to our pom.xml file of Order Service

pom.xml

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-contract-stub-runner</artifactId>
            <scope>test</scope>
        </dependency>
Here's how the update Integration Test looks like:

OrderServiceApplicationTests.java

package com.programmingtechie.orderservice;

import com.programmingtechie.orderservice.stub.InventoryStubs;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }

    @Test
    void shouldSubmitOrder() {
        String submitOrderJson = """
                {
                     "skuCode": "iphone_15",
                     "price": 1000,
                     "quantity": 1
                }
                """;

        InventoryStubs.stubInventoryCall("iphone_15", 1);
        var responseBodyString = RestAssured.given()
                .contentType("application/json")
                .body(submitOrderJson)
                .when()
                .post("/api/order")
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .body().asString();

        assertThat(responseBodyString, Matchers.is("Order Placed Successfully"));
    }
}

application.properties

inventory.url=http://localhost:${wiremock.server.port}
InventoryStubs.java

package com.programmingtechie.orderservice.stub;

import lombok.experimental.UtilityClass;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@UtilityClass
public class InventoryStubs {

    public void stubInventoryCall(String skuCode, Integer quantity) {
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true")));
    }
}

Conclusion
That's it for Part -2 of this tutorial, in the next part we will learn how to implement Service Discovery using Netflix Eureka.

Spring Boot Microservices Tutorial - Part 3
April 14, 2024
In Part 2 of this Spring Boot Microservices Tutorial series, we will implement Synchronous Communication between our Order Service and Inventory Service using Spring Cloud OpenFeign Library.

Spring Cloud OpenFeign library uses that provides OpenFeign integrations with Spring Boot and Spring Cloud. It provides a declarative REST Client that makes consuming REST Endpoints in our code easy.

Inter Process Communication

We will implement Synchronous Communication between Order Service and Inventory Service using the Spring Cloud OpenFeign library.

Add Spring Cloud OpenFeign to Order Service
To get started, let's add the Spring Cloud OpenFeign Starter to the pom.xml file of the Order Service.

pom.xml

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
We also need to add the spring-cloud-dependencies bom dependency to the <dependencyManagement> section in the pom.xml file.

<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
This is how your pom.xml should look like at the end:

pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>microservices-new</artifactId>
        <groupId>com.programming.techie</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>order-service</artifactId>

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
            <groupId>org.flywaydb</groupId>
            <artifactId>flyway-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.flywaydb</groupId>
            <artifactId>flyway-mysql</artifactId>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
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
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-testcontainers</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>mysql</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.3.2</version>
        </dependency>
    </dependencies>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>

Create FeignClient for Inventory Service
As we will be calling Inventory Service from Order Service, we need to create a class called InventoryClient.java inside the client package inside the order-service.

client/InventoryClient.java

package com.programmingtechie.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}

Notice that the @FeignClient annotation has an attribute called URL that is pointing to the inventory.url property in the application.properties file

inventory.url=http://localhost:8082
By externalizing this property we can replace it dynamically in tests or during startup time.

Coming to the method, we have the @RequestMapping annotation that is calling the path - /api/inventory.

Now we have to call the isInStock() method from the placeOrder() method of the Order Service.

If the client returns true, then we will place the order and save it to the database successfully, or else, we will throw a Runtime Exception

Here's how the OrderService class looks like with the final logic.

OrderService.java

package com.programmingtechie.orderservice.service;

import com.programmingtechie.orderservice.client.InventoryClient;
import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        boolean inStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (inStock) {
            var order = mapToOrder(orderRequest);
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with Skucode " + orderRequest.skuCode() + "is not in stock");
        }
    }

    private static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        return order;
    }
}

Before we go ahead and test our implementation, we have to add the @EnableFeignClients annotation to enable Feign Client Capabilities

OrderServiceApplication.java

package com.programmingtechie.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}

Manual Testing using Postman
Now it's time to test our implementation using Postman, make sure you start both the Order Service as well as the Inventory Service and call the Place Order Endpoint of Order Service.

Let's order the skuCode iphone_15, with a quantity of 100, as in Part -1 we initialized all skuCodes with quantity 100, this product should be in stock, and our Order should go through.

Submit Order with OpenFeign

Now let's change the quantity to 101, and this time our Order call should fail with a 500 error.

Order Service negative case

If you observe logs, then you should see the below exception message:

java.lang.RuntimeException: Product with Skucode iphone_15is not in stock
Updating the Integration Tests
Now if you run our Integration Tests in the order service, you will notice that they no longer run successfully as we are calling the Inventory Service.

To make these test successful, we have to use a library called Wiremock that provides a mock server environment to test our Order Service by making some mock HTTP calls.

By using Wiremock, we can verify if our Order Service is calling the inventory service with correct URL Params/Request Body/ Path Variables or not. We can also stub the response and test how our service is responding for various scenarios.

To enable wiremock, we need to add the following dependency to our pom.xml file of Order Service

pom.xml

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-contract-stub-runner</artifactId>
            <scope>test</scope>
        </dependency>
Here's how the update Integration Test looks like:

OrderServiceApplicationTests.java

package com.programmingtechie.orderservice;

import com.programmingtechie.orderservice.stub.InventoryStubs;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }

    @Test
    void shouldSubmitOrder() {
        String submitOrderJson = """
                {
                     "skuCode": "iphone_15",
                     "price": 1000,
                     "quantity": 1
                }
                """;

        InventoryStubs.stubInventoryCall("iphone_15", 1);
        var responseBodyString = RestAssured.given()
                .contentType("application/json")
                .body(submitOrderJson)
                .when()
                .post("/api/order")
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .body().asString();

        assertThat(responseBodyString, Matchers.is("Order Placed Successfully"));
    }
}
In Part 3 of this **Spring Boot Microservices Tutorial** series, we will implement the API Gateway pattern using the Spring Cloud Gateway MVC library.

## What is an API Gateway?

An API Gateway also called an Edge Server, acts as an entry point for our microservices, so that external clients can access the services easily. It also helps us to handle cross-cutting concerns like Monitoring, Security, etc. In some instances, API Gateway also acts as Load Balancers.

## Why to use API Gateway?

In our microservice project landscape, we have 3 services accessible to the user:

- Product Service

- Order Service

- Inventory service

For example, imagine that external clients like Web and Mobile applications consume these three independent services through the exposed endpoints. If the internal implementation of these services changes, then also the clients need to update the Endpoints on their side.

To workaround this issue, we use an API Gateway as the facade that provides an abstraction over the internal microservices.

## Spring Cloud Gateway MVC

**Spring Cloud Gateway MVC** is a library under the Spring Cloud project, that provides the API Gateway functionality. Let's go ahead and create the API Gateway for our project, as usual, we use the start.spring.io website to create the project.

![Start.spring.io for creating Spring Cloud Gateway](images/image-6-1024x663.png)

Make sure you use the above configuration and click on Generate Project to download the source code to your machine.

As we learned before, an API Gateway acts as an abstraction over the microservices, and it forwards the request from the client to the relevant microservices.

To implement this feature, Spring Cloud Gateway uses the below building blocks:

- Routes

- Predicates

- Filters

### Routes

A Route is the basic building block of the gateway, it can be defined using a uniqueId, a destination URI, and a collection of predicates and filters

### Predicates

A Predicate is nothing but a criteria or a condition that you define to match against the incoming HTTP Request, for example, you can create a routing rule where you want to route the requests that have a specific Header and Request Parameter to Service A, then you can consider the headers and request parameters you want to match against the request as predicates.

### Filters

Filters are components that allow you to modify the requests and responses before they are sent to the destination.

Let's see how we can implement the API Gateway in our project using Spring Cloud Gateway MVC.

Note that we will be using Spring Cloud Gateway MVC, but not Spring Cloud Gateway which is based on reactive stack backed by Spring Webflux.


Here are the routing rules we will implement:

- If a request matches the path - /api/product, then forward it to Product Service

- If a request matches the path - /api/order, then forward it to Order Service

- If a request matches the path - /api/inventory, then forward it to Inventory Service

## Coding

Let's start developing our API Gateway, once you open the project downloaded from start.spring.io, you should see the below **pom.xml** file

**pom.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.2.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.programming.techie</groupId>
	<artifactId>api-gateway</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>api-gateway</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>21</java.version>
		<spring-cloud.version>2023.0.1</spring-cloud.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-gateway-mvc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<dependencyManagement>
		<dependencies>
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
    		</plugin>
    	</plugins>
    </build>

</project>

And the main Spring Boot application class, ApiGatewayApplication.java


package com.programming.techie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
    	SpringApplication.run(ApiGatewayApplication.class, args);
    }

}

Now it's time to create the routing rules defined above, for that we can follow 2 approaches

Using Java API

Using Property files

We will go with the approach of using Java API in this tutorial, for that let's create a class called Routes.java

Routes.java


package com.programming.techie.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

import static org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions.circuitBreaker;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration(proxyBeanMethods = false)
public class Routes {
@Bean
public RouterFunction<ServerResponse> productServiceRoute() {
return route("product_service")
.route(RequestPredicates.path("/api/product"), http("http://localhost:8080"))
.build();
}
}

The above code defines a route to the product service, the route() method takes in two arguments one for the path which is the predicate we want to match in this case (/api/product), and the second argument is http("<target-destination-url>") which points to the target destination ie. product service that is running at http://localhost:8080.

We will see how to use Filters in the upcoming section when we implement Circuit Breakers for resiliency.

Let's add also the remaining routes for the order service and inventory service


package com.programming.techie.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

import static org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions.circuitBreaker;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration(proxyBeanMethods = false)
public class Routes {
@Bean
public RouterFunction<ServerResponse> productServiceRoute() {
return route("product_service")
.route(RequestPredicates.path("/api/product"), http("http://localhost:8080"))
.build();
}

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        return route("order_service")
                .route(RequestPredicates.path("/api/order"), http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return route("inventory_service")
                .route(RequestPredicates.path("/api/inventory"), http("http://localhost:8082"))
                .build();
    }

}

You can observe that the other routes have very similar code, but the only differences are obvious, with the path being /api/order, routed to the Order Service, and the path /api/inventory to the Inventory Service.

Finally, let's add a property in the application.properties file to make sure that the api-gateway service runs on port 9000 as 8080 is already taken by the product service.


server.port=9000

Now if you make an HTTP GET request to the URL:

http://localhost:9000/api/product then you should see the below response

[
  {
    "id": "661b5c40ad645e4a98d0f623",
    "name": "iPhone 15",
    "description": "iPhone 15 is a smartphone from Apple",
    "price": 1000
  }
]
That's it for this part, in the next part we will discuss how to implement security in our project by integrating OAuth2 using Keycloak.

Spring Boot Microservices Tutorial - Part 4
April 18, 2024
In Part 4 of this Spring Boot Microservices Tutorial series, we will secure our API Gateway using Keycloak

What is Keycloak?
Keycloak is an open-source Authorization Server that can be used to outsource the authentication and authorization from our application. Keycloak supports various authentication and authorization protocols like OAuth2, OpenID Connect, SAML, etc. It also offers features like Single Sign On (SSO), and Multi-Factor Authentication (MFA) out of the box.

If you want to learn more about OAuth2 and OIDC you can refer to the below documentation
https://oauth.net/2/ and https://openid.net/developers/how-connect-works/

Download Keycloak
To download Keycloak, we must create the docker-compose.yml file inside our API gateway project.

docker-compose.yml

version: '3.8'
services:
  keycloak-mysql:
    container_name: keycloak-mysql
    image: mysql:8
    volumes:
      - ./volume-data/mysql_keycloak_data:/var/lib/mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: keycloak
      MYSQL_USER: keycloak
      MYSQL_PASSWORD: password
  keycloak:
    container_name: keycloak
    image: quay.io/keycloak/keycloak:24.0.1
    command: [ "start-dev", "--import-realm" ]
    environment:
      DB_VENDOR: MYSQL
      DB_ADDR: mysql
      DB_DATABASE: keycloak
      DB_USER: keycloak
      DB_PASSWORD: password
      KEYCLOAK_ADMIN: admin
      KEYCLOAK_ADMIN_PASSWORD: admin
    ports:
      - "8181:8080"
    volumes:
      - ./docker/keycloak/realms/:/opt/keycloak/data/import/
    depends_on:
      - keycloak-mysql

The above file sets up Keycloak along with a MySQL database to store the keycloak configuration. For now, we are starting Keycloak in the dev environment using the 'start-dev' argument provided through the command field of the docker-compose configuration.

Now you can run the below command to start the Keycloak docker container:

docker compose up -d
Keycloak Configuration
After starting the Keycloak docker container, it's time to set up Keycloak, open the URL http://localhost:8181 this should open the home page of keycloak, provide admin/admin as the credentials as we have configured it in the docker-compose file.

In Keycloak, all the clients, users, and roles related to a particular application (or) a group of applications reside inside something known as a realm. Realms are independent of each other, so if you create one client/user in one realm, you cannot use it from another realm.

In our project, we will be using the Client Credentials grant, to communicate with the API Gateway and fetch an Access Token, and this access token will be verified by the API Gateway against Keycloak.

To get started, log in to the Keycloak Admin page using the above-mentioned credentials and the first thing we are going to do is to create the realm.

After logging in, click on the dropdown with the text "Keycloak" in the top left-side corner and click on the Create Realm button


Provide the name of the realm(eg: spring-microservices-realm) and click on the Create button

Now the realm should be created successfully

Next, click on the Clients link to the left sidebar, and click on Create Client

Provide any Client ID you like eg: test-client-id and click on Next

Check Client Authentication as ON

In the Authentication Flow, select Service accounts roles and unselect all other options, this makes sure that our client supports Client Credentials grant

Click on Next and then Save

Finally, click on the Credentials tab, here you can view the client secret that is generated automatically and you can also regenerate a new client secret. Make sure to copy the client secret, we will use this in the later parts to request a token to access the API Gateway

Configure Keycloak in API Gateway
Now let's configure keycloak in our api-gateway application, for that we need to add the spring-security-oauth2-resource-server dependency to our pom.xml file

Here is how our pom.xml file now looks like after adding the dependency.

pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.2.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.programming.techie</groupId>
	<artifactId>api-gateway</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>api-gateway</name>
	<description>API Gateway</description>
	<properties>
		<java.version>21</java.version>
		<spring-cloud.version>2023.0.1</spring-cloud.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-gateway-mvc</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
		</dependency>
	</dependencies>
	<dependencyManagement>
		<dependencies>
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
			</plugin>
		</plugins>
	</build>

</project>

Now let's configure the application.properties with the Authorization Server details. For that first, we need to retrieve the Issuer URI of our authorization server. For keycloak, it's usually in the format:
http://<key-cloak-url>/realm/<realm-name>

For the realm we created in the previous step, the issuer uri will be: http://localhost:8181/realms/spring-microservices-realm

Now let's go ahead and configure this inside our Spring Boot API Gateway application.

spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8181/realms/spring-microservices-realm
The next step is to create the Security Configuration class, let's create a package called config and create a class inside the package - SecurityConfig.class

package com.programming.techie.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }
}

This is the basic Security Configuration, Spring Security already creates for us out of the box, you can also choose to ignore adding this file if you don't need to add any additional configuration.

Now let's run the ApiGatewayApplication.java class and test out our endpoints using postman.

Open the Postman client and inside the request window, click on the Authorization tab and then select OAuth2.

Select the Grant Type as Client Credentials

Enter the Client ID and Client Secret of the client we created in the previous steps

Leave the rest of the fields as it is, and click on the Get New Access Token button.

This will make a call to the Token Endpoint and fetches us a new Access Token.

Click on the Use Token method, to add the token to our Request Context Window.

Select any request you want to make for example: call the Product Service Endpoint - GET HTTP://localhost:9000/api/product and click on Send

You should receive a successful response from the API Gateway.

Postman

In the next part, we will learn how to implement Circuit Breaker Pattern using Resilience4J and Spring Cloud Circuit Breaker Project.

Spring Boot Microservices Tutorial - Part 5
May 5, 2024
In Part 5 of this Spring Boot Microservices Tutorial series, we will document our REST APIs using Springdoc Open API and Swagger.

What is Open API?
Open API (don't mistake it with Open AI :D )is a specification that defines a standard way to document the APIs. No matter which programming language or framework you use, Open AI provides a standard way of defining and documenting your API so that it's easy to read and use the API.

In the Java world, it's similar to the Java Persistence API (JPA) that defines a specification on how to persist data in our applications. Hibernate is a library that implements JPA, similarly, we have a tool called Swagger, which helps us implement the OpenAPI specification.

Springdoc OpenAPI
Swagger does not provide out-of-the-box support with Spring Boot, that's where the library Springdoc OpenAPI comes in, it provides good support with Spring Boot and helps us generate the API documentation automatically in JSON/YML and HTML formats.

If you want to view the documentation in HTML format, we should add the below dependency in all our services:

   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.5.0</version>
   </dependency>

Make sure to check the documentation, to get the latest version of the dependency -https://springdoc.org/#getting-started

Next, let's customize the URL we want to serve the REST API documentation, by default, spring doc open API exposes the documentation at URL path - /swagger-ui/index.html, if we want to customize the URL path, add the below property to the application.properties file.

springdoc.swagger-ui.path=/swagger-ui.html
Next, we have to create a configuration class, to define some metadata about our API, to create a class called OpenAPIConfig in a package called config.

OpenAPIConfig.java

package com.techie.microservices.product.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI productServiceAPI() {
        return new OpenAPI()
                .info(new Info().title("Product Service API")
                        .description("This is the REST API for Product Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("You can refer to the Product Service Wiki Documentation")
                        .url("https://product-service-dummy-url.com/docs"));
    }
}

You can see the above configuration is for the ProductService application, we can create a similar configuration for the Order Service and the inventory service.

Now, let's start all the applications and go to the path /swagger-ui.html for all our 3 services, you will see the API documentation like below screenshots.

API Documentation for Product Service

API Documentation for Product Service

API Documentation for Order Service

API Documentation for Order Service

API Documentation for Product Service

API Documentation for Product Service

Documentation in JSON/YML Format
To generate the documentation in JSON/YML format, we have to add the following dependency:

   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-api</artifactId>
      <version>2.5.0</version>
   </dependency>

Let's customize the path of the API documentation by adding the below property in the application.properties file

springdoc.api-docs.path=/api-docs
Now, after restarting the application, go to the URL: http://localhost:8080/api-docs and you should see the documentation below:

  "openapi": "3.0.1",
  "info": {
    "title": "Product Service API",
    "description": "This is the REST API for Product Service",
    "license": {
      "name": "Apache 2.0"
    },
    "version": "v0.0.1"
  },
  "externalDocs": {
    "description": "You can refer to the Product Service Wiki Documentation",
    "url": "https://product-service-dummy-url.com/docs"
  },
  "servers": [
    {
      "url": "http://localhost:8080",
      "description": "Generated server url"
    }
  ],
  "paths": {
    "/api/product": {
      "get": {
        "tags": [
          "product-controller"
        ],
        "operationId": "getAllProducts",
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/ProductResponse"
                  }
                }
              }
            }
          }
        }
      },
      "post": {
        "tags": [
          "product-controller"
        ],
        "operationId": "createProduct",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/ProductRequest"
              }
            }
          },
          "required": true
        },
        "responses": {
          "201": {
            "description": "Created",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/ProductResponse"
                }
              }
            }
          }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "ProductRequest": {
        "type": "object",
        "properties": {
          "id": {
            "type": "string"
          },
          "name": {
            "type": "string"
          },
          "description": {
            "type": "string"
          },
          "price": {
            "type": "number"
          }
        }
      },
      "ProductResponse": {
        "type": "object",
        "properties": {
          "id": {
            "type": "string"
          },
          "name": {
            "type": "string"
          },
          "description": {
            "type": "string"
          },
          "price": {
            "type": "number"
          }
        }
      }
    }
  }
}
Aggregating the documentation in API Gateway
You may have observed that to access the documentation we have to manually visit the URL of each service, we can aggregate all the documentation and expose it in a single place in the API Gateway.

To do that add the below dependencies to the pom.xml of the API Gateway service.

		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.5.0</version>
		</dependency>
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-api</artifactId>
			<version>2.5.0</version>
		</dependency>
Next, let's add the below properties to aggregate the URLs of all the 3 services.

springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true
springdoc.api-docs.enabled=true
springdoc.swagger-ui.urls[0].name=Product Service
springdoc.swagger-ui.urls[0].url=/aggregate/product-service/v3/api-docs
springdoc.swagger-ui.urls[1].name=Order Service
springdoc.swagger-ui.urls[1].url=/aggregate/order-service/v3/api-docs
springdoc.swagger-ui.urls[2].name=Inventory Service
springdoc.swagger-ui.urls[2].url=/aggregate/inventory-service/v3/api-docs
We defined each service with a separate URL, whenever the user visits this URL, we have to route this request to the appropriate service, and for that, we need to add the corresponding routes in the Routes.java class.

Routes.java

@Bean
    public RouterFunction<ServerResponse> productServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("product_service_swagger")
                .route(RequestPredicates.path("/aggregate/product-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8080"))
                .filter(setPath("/api-docs"))
                .build();
    }

@Bean
    public RouterFunction<ServerResponse> orderServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("order_service_swagger")
                .route(RequestPredicates.path("/aggregate/order-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8081"))
                .filter(setPath("/api-docs"))
                .build();
    }

@Bean
    public RouterFunction<ServerResponse> inventoryServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("inventory_service_swagger")
                .route(RequestPredicates.path("/aggregate/inventory-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8082"))
                .filter(setPath("/api-docs"))
                .build();
    }
The above configuration will route all the incoming requests to the /api-docs path of the corresponding service. Note that, we previously exposed the path /api-docs to serve the documentation in the JSON format.

Next, we have to add the security configuration to make sure that API Gateway allows the requests without authentication.

package com.programming.techie.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    private final String[] freeResourceUrls = {"/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/aggregate/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(freeResourceUrls).permitAll()
                        .anyRequest().authenticated())
                .cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()))
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

In the above configuration, we have defined a variable called freeResourceUrls, where we should permit all the requests to these paths. To allow the calls to the downstream microservices, we added the path /aggregate/ that covers the path for all the 3 services:

/aggregate/product-service/v3/api-docs

/aggregate/inventory-service/v3/api-docs

/aggregate/order-service/v3/api-docs

Lastly, we have also defined CORS configuration, as we will be accessing different services through the browser from API Gateway.

We also need to update the microservices to define CORS, or else we will get a CORS ERROR while accessing the API Documentation. So, let's add the below CORS Configuration in all the services by creating a class CorsConfig.java

package com.techie.microservices.product.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowedOriginPatterns("*")
                .allowCredentials(false);
    }
}
Lastly, now let's run all the services, and go to the URL- http://localhost:9000/swagger-ui.html, and on the top right corner you should see a dropdown where you can switch between different API documentation of the services.

Spring Boot Microservices Tutorial - Part 6
May 26, 2024
In Part 6 of this Spring Boot Microservices Tutorial, we will learn how to implement Resiliency in our project by implementing the Circuit Breaker pattern. We will use the library Resilience4J together with Spring Cloud Circuit Breaker Resilience4J to implement the circuit breaker pattern in our project

What is Circuit Breaker Pattern ?
Circuit Breaker is one of the widely used best practice in the real world distributed systems

Consider a scenario where your application A makes synchronous calls to a remote service R. If service R becomes unavailable or responds very slowly due to performance issues, this situation will negatively impact application A as well.

If the application A receives a large number of requests, then there will be lot of threads in the waiting state, waiting for the response from R, leading to ultimately crashing the application A. To avoid this issue, we can make use of the Circuit Breaker Pattern, which works very similar to the Circuit Breaker used in our homes to protect the electrical devices from the power spikes. If there is a power spike, then the Circuit Breaker is tripped and will stop the flow of electricity. Similarly, when the remote service R in our case, if it's unavailable or responding very slowly, we can introduce a Circuit Breaker that will stop the calls to the service, for a certain amount of time. After this timeout, the Circuit Breaker will again start allowing calls to the service R gradually.

In our Microservices Project, we can introduce this Circuit Breaker mechanism in the API Gateway and the Order Service.

API Gateway is the main service that is calling 3 other services, so this will be the best place to use Circuit Breaker, similarly we can also implement this feature in the Order Service as the service is calling Inventory Service to fetch the inventory information.

Different States in the Circuit Breaker Pattern
At any given point of time, a circuit breaker will be in different states like:

Open: This states indicates that the Circuit Breaker is open, and all the traffic going through the Circuit Breaker will be blocked.

Half-Open: In this state, the Circuit Breaker will start allowing gradually the traffic to the remote service R

Closed: In this state, the Circuit Breaker will allow all the requests to the service, which means that the service R is working well without any problems.

Different States in the Circuit Breaker Pattern

Implement Circuit Breaker in the API Gateway
Now let's implement this pattern in our API Gateway project, for that I am going to add the following dependencies to the pom.xml of the API Gateway project

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
The first dependency adds the Resilience4J library in our project and the second dependency adds the Spring Boot Actuator that provides us with useful endpoints to get useful information about our application like Metrics, we can make use of these endpoints to check the state of the Resilience4J Circuit Breaker.

After adding the above dependency, we need to add the circuitBreaker() method to our Route Configuration for all the routes.

@Bean
    public RouterFunction<ServerResponse> productServiceRoute() {
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/api/product"), HandlerFunctions.http("http://localhost:8080"))
                .filter(circuitBreaker("productServiceCircuitBreaker", URI.create("forward:/fallbackRoute")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> productServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("product_service_swagger")
                .route(RequestPredicates.path("/aggregate/product-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8080"))
                .filter(circuitBreaker("productServiceSwaggerCircuitBreaker", URI.create("forward:/fallbackRoute")))
                .filter(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        return GatewayRouterFunctions.route("order_service")
                .route(RequestPredicates.path("/api/order"), HandlerFunctions.http("http://localhost:8081"))
                .filter(circuitBreaker("orderServiceCircuitBreaker", URI.create("forward:/fallbackRoute")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("order_service_swagger")
                .route(RequestPredicates.path("/aggregate/order-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8081"))
                .filter(circuitBreaker("orderServiceSwaggerCircuitBreaker", URI.create("forward:/fallbackRoute")))
                .filter(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return GatewayRouterFunctions.route("inventory_service")
                .route(RequestPredicates.path("/api/inventory"), HandlerFunctions.http("http://localhost:8082"))
                .filter(circuitBreaker("inventoryServiceCircuitBreaker", URI.create("forward:/fallbackRoute")))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("inventory_service_swagger")
                .route(RequestPredicates.path("/aggregate/inventory-service/v3/api-docs"), HandlerFunctions.http("http://localhost:8082"))
                .filter(circuitBreaker("inventoryServiceSwaggerCircuitBreaker", URI.create("forward:/fallbackRoute")))
                .filter(setPath("/api-docs"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> fallbackRoute() {
        return route("fallbackRoute")
                .GET("/fallbackRoute", request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service Unavailable, please try again later"))
                .build();
    }
You can see that the circuitBreaker() method is taking an ID which is a string and then a URL parameter which points to a fallback endpoint that will be displayed when the requests are blocked when the CircuitBreaker is OPEN

We have the fallbackRoute() bean that is defined as a fallback route at the path - /fallbackRoute that sends a HTTP 503 Service Unavailable response back to the client.

After adding this configuration for our routes, we have to now configure Resilience4J in our project, for that open application.properties file:

#Resilinece4j Properties
resilience4j.circuitbreaker.configs.default.registerHealthIndicator=true
resilience4j.circuitbreaker.configs.default.slidingWindowType=COUNT_BASED
resilience4j.circuitbreaker.configs.default.slidingWindowSize=10
resilience4j.circuitbreaker.configs.default.failureRateThreshold=50
resilience4j.circuitbreaker.configs.default.waitDurationInOpenState=5s
resilience4j.circuitbreaker.configs.default.permittedNumberOfCallsInHalfOpenState=3
resilience4j.circuitbreaker.configs.default.automaticTransitionFromOpenToHalfOpenEnabled=true
resilience4j.circuitbreaker.configs.default.minimum-number-of-calls=5
The above properties make sure that Resilience4J is configured in our project.

Enable Circuit Breaker for Timeouts
We can enable Circuit Breaker to implement a timeout, when the remote service is taking a very long time to respond, for that all we have to do is add the following property:

resilience4j.timelimiter.configs.default.timeout-duration=3s
With this configuration, the circuit breaker will be OPEN, when the remote service is taking more than 3 seconds to send back the response.

Implement Retries
Sometimes, the service can be unavailable due to a small network issue (or) any other minor issue, in those cases, it's better to retry the call instead of directly activating the Circuit Breaker. For this reason, the Resilience4J library allows us to implement retries by adding the following configuration:

#Resilience4J Retry Properties
resilience4j.retry.configs.default.max-attempts=3
resilience4j.retry.configs.default.wait-duration=2s
The above configuration will retry for a maximum of 3 times, with a wait of 5 seconds in between the retries.

Implement Circuit Breaker in the Order Service
Now let's implement the Circuit Breaker also in the Order Service, as we are making a synchronous call to the inventory service in this service.

For that, I am going to add the below dependencies, in the pom.xml of the project:

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
After that, let's add the configuration for Resilience4J in the application.properties file, like below:

#Resilinece4j Properties
resilience4j.circuitbreaker.instances.inventory.registerHealthIndicator=true
resilience4j.circuitbreaker.instances.inventory.event-consumer-buffer-size=10
resilience4j.circuitbreaker.instances.inventory.slidingWindowType=COUNT_BASED
resilience4j.circuitbreaker.instances.inventory.slidingWindowSize=5
resilience4j.circuitbreaker.instances.inventory.failureRateThreshold=50
resilience4j.circuitbreaker.instances.inventory.waitDurationInOpenState=5s
resilience4j.circuitbreaker.instances.inventory.permittedNumberOfCallsInHalfOpenState=3
resilience4j.circuitbreaker.instances.inventory.automaticTransitionFromOpenToHalfOpenEnabled=true
resilience4j.circuitbreaker.instances.inventory.minimum-number-of-calls=5

#Resilience4J Timeout Properties
resilience4j.timelimiter.instances.inventory.timeout-duration=3s

#Resilience4J Retry Properties
resilience4j.retry.instances.inventory.max-attempts=3
resilience4j.retry.instances.inventory.wait-duration=5s
After that to enable Circuit Breaker on the specific endpoints we can add the @CircuitBreaker annotation, similarly to enable retries, we can add the @Retry annotation respectively.

We can add these above annotations in the Inventory Client class, this is how the class looks like after adding the necessary annotations:

package com.techie.microservices.order.client;

import groovy.util.logging.Slf4j;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

@Slf4j
public interface InventoryClient {

    Logger log = LoggerFactory.getLogger(InventoryClient.class);

    @GetExchange("/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

    default boolean fallbackMethod(String code, Integer quantity, Throwable throwable) {
        log.info("Cannot get inventory for skucode {}, failure reason: {}", code, throwable.getMessage());
        return false;
    }
}

In the above class, you can notice that we defined a method called fallbackMethod that will be executed whenever the Circuit Breaker is OPEN.

To implement Timeout, we can configure the RestClient to have a connection and read time out through the requestFactory() method. This is how the RestClientConfig.java class looks like:

package com.techie.microservices.order.config;

import com.techie.microservices.order.client.InventoryClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
public class RestClientConfig {

    @Value("${inventory.url}")
    private String inventoryServiceUrl;

    @Bean
    public InventoryClient inventoryClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(inventoryServiceUrl)
                .requestFactory(getClientRequestFactory())
                .build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }

    private ClientHttpRequestFactory getClientRequestFactory() {
        ClientHttpRequestFactorySettings clientHttpRequestFactorySettings = ClientHttpRequestFactorySettings.DEFAULTS
                .withConnectTimeout(Duration.ofSeconds(3))
                .withReadTimeout(Duration.ofSeconds(3));
        return ClientHttpRequestFactories.get(clientHttpRequestFactorySettings);
    }
}

Testing the Circuit Breaker Pattern
To test the Circuit Breaker in the API Gateway, make sure that one of the services like Product, Order or Inventory Service is unavailable, and then call the corresponding service.

You should see an error - Service Unavailable, please try again later with the status HTTP_503

You can try the same thing also for the Order Service project, by stopping the Inventory Service.

To test the Timeout and Retry, we can introduce a slight delay by adding something like Thread.sleep() to simulate latency for our requests and you can observe that Circuit Breaker will be activated also in these cases.

Conclusion
In this blogpost, you learned about Circuit Breaker pattern, why and when to use it. We also learned how to enable the pattern using libraries like Resilience4J and Spring Cloud Circuit Breaker.

In the next part of the Spring Boot Microservice Tutorial series, we will learn how to implement asynchronous communication using Kafka.

Spring Boot Microservices Tutorial - Part 7
June 9, 2024
In Part 7 of this Spring Boot Microservices Tutorial series, we will set up a UI for our project, we will be using Angular as our frontend framework. This tutorial contains logical steps to build the UI.

We will use the latest Angular version - v18- to build this project. Ensure you have Node and Npm installed on your machine before following the instructions below.

Link to download Node - https://nodejs.org/en/download/package-manager

Link to download NPM - https://docs.npmjs.com/downloading-and-installing-node-js-and-npm

Link to download Angular CLI - https://angular.dev/tools/cli/setup-local#install-the-angular-cli

Create Angular Scaffolding Project
To get started, let's create a new angular project with the below command:

ng new microservices-shop-frontend
Angular CLI will ask you a set of questions, I will provide the answers to the relevant settings for the project, for the rest of the settings, feel free to pick as per your preferences.

Which stylesheet format would you like to use? - CSS

Do you want to enable Server-Side Rendering (SSR) and Static Site Generation (SSG/Prerendering)? N

After answering the above questions, press Enter, and the project should now be created successfully.

Once the project is created, you can start the scaffolding application by typing the below command:

ng serve
Angular CLI will now compile the project and start a webserver to serve the application and it will also watch for the changes in the project files so that whenever a change occurs in the code, the webserver will automatically reload and apply the new changes.

After the application is started successfully open the URL - http://localhost:4200

Now you have created the Angular app, now it's time to configure Tailwind CSS as our CSS framework.

Install Tailwind CSS
We will be using TailwindCSS as our CSS framework, to install it in our angular project, type the below commands:

npm install -D tailwindcss postcss autoprefixer

npx tailwindcss init
After executing both commands there will be a tailwind.config.js file, update its content below:

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}
The above configuration will apply tailwind CSS to all the HTML templates in our project.

To enable CSS, we also have to update the src/styles.css file with the following code:

@tailwind base;
@tailwind components;
@tailwind utilities;
Once this is done, restart the application by running the ng serve command again.

Add Angular Auth OIDC Client dependency
The next thing we are going to do is to enable OAuth2 capabilities in our project, by adding the angular-auth-oidc-client dependency, by executing the below command:

 npm install angular-auth-oidc-client
After installing the library, we need to configure it by creating a file called src/app/config/auth-config.ts

import { PassedInitialConfig } from 'angular-auth-oidc-client';

export const authConfig: PassedInitialConfig = {
  config: {
    authority: 'http://localhost:8181/realms/spring-microservices-security-realm',
    redirectUrl: window.location.origin,
    postLogoutRedirectUri: window.location.origin,
    clientId: 'angular-client',
    scope: 'openid profile offline_access',
    responseType: 'code',
    silentRenew: true,
    useRefreshToken: true,
    renewTimeBeforeTokenExpiresInSeconds: 30,
  }
}

The above configuration will set up our angular application to talk with the Keycloak server, if you want to revise how to set up the Keycloak server, refer to my previous post here - https://programmingtechie.com/2024/04/18/spring-boot-microservices-tutorial-part-4/

The authority field is pointing to the URL of the Realm we created in the previous parts, and then the client ID is going to be angular-client, which is the name of the client ID we will create soon in Keycloak.

We are going to use the Refresh Token mechanism to get a new token whenever our existing token is expired.

Create Header Component
So in the next step, we are going to add the header component, to generate a new component, type the following command:

ng g c shared/header
The above command generates a component at the location src/app/shared/header, if you just provide header instead of shared/header, then the component will be created at location - src/app/header

header.component.html

<nav class="bg-white border border-gray-200 dark:border-gray-700 px-2 sm:px-4 py-2.5 rounded dark:bg-gray-800 shadow">
    <div class="container flex flex-wrap justify-between items-center mx-auto">
        <a href="/" class="flex items-center">
      <span class="self-center text-xl font-semibold whitespace-nowrap dark:text-white">
        Spring Boot Microservices Shop
      </span>
        </a>

        <div class="flex items-center">
            <button
                    id="menu-toggle"
                    type="button"
                    class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600 md:hidden"
            >
                <span class="sr-only">Open main menu</span>
                <!-- Hamburger icon -->
                <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            stroke-width="2"
                            d="M4 6h16M4 12h16m-7 6h7"
                    />
                </svg>
            </button>
        </div>

        <div
                class="w-full md:block md:w-auto hidden"
                id="mobile-menu"
        >
            <ul class="flex flex-col mt-4 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium">
                <li>
                    @if (isAuthenticated) {
                      <p class="text-white">Hi {{ username }}</p>
                      <a
                        (click)="logout()"
                        class="block py-2 pr-4 pl-3 text-gray-700 hover:bg-gray-50 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">
                        Logout
                      </a>
                    } @else {
                      <a
                        (click)="login()"
                        class="block py-2 pr-4 pl-3 text-gray-700 hover:bg-gray-50 md:hover:bg-transparent md:border-0 md:hover:text-blue-700 md:p-0 dark:text-gray-400 md:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent">
                        Login
                      </a>
                    }
                </li>
            </ul>
        </div>

    </div>
</nav>

header.component.ts

import {Component, inject, OnInit} from '@angular/core';
import {OidcSecurityService} from "angular-auth-oidc-client";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {

  private readonly oidcSecurityService = inject(OidcSecurityService);
  isAuthenticated = false;
  username = "";

  ngOnInit(): void {
    this.oidcSecurityService.isAuthenticated$.subscribe(
      ({isAuthenticated}) => {
        this.isAuthenticated = isAuthenticated;
      }
    )
    this.oidcSecurityService.userData$.subscribe(
      ({userData}) => {
        this.username = userData.preferred_username
      }
    )
  }

  login(): void {
    this.oidcSecurityService.authorize();
  }

  logout(): void {
    this.oidcSecurityService
      .logoff()
      .subscribe((result) => console.log(result));
  }
}

The header component is mainly responsible for displaying the information about the currently logged-in user (like the username) and then providing the links to Login/Logout of the application. Here we are using the OidcSecurityService from the angular-auth-oidc-client dependency to implement login and logout functionalities.

Create Home Page Component
The next step is going to be to create the Home Page component

home-page.component.html

<main>
  <div class="p-4">
    <div class="flex justify-between items-center mb-4">
      <h1 class="text-2xl font-bold mb-4">Products ({{ products.length }})</h1>
      @if (isAuthenticated) {
        <button class="bg-green-500 text-white px-4 py-2 rounded-lg hover:bg-green-600 ml-4"
                (click)="goToCreateProductPage()">
          Create Product
        </button>
      }
    </div>
    @if (products.length > 0) {
      @if (orderSuccess) {
        <h4 class="text-green-500 font-bold">Order Placed Successfully</h4>
      } @else if (orderFailed) {
        <h4 class="text-red-500 font-bold">Order Failed, please try again later</h4>
        @if(quantityIsNull) {
          <h4 class="text-red-500 font-bold">Quantity cannot be null</h4>
        }
      }
      <ul class="list-disc list-inside">
        @for (product of products; track product.id) {
          <li class="mb-2 p-4 bg-gray-100 rounded-lg shadow-sm flex justify-between items-center">
            <div>
              <span class="font-semibold">{{ product.name }}</span> -
              <span class="text-gray-600">
                Price: {{ product.price }}
              </span>
              <br/>
              <span >
                Quantity: <input type="number" #quantityInput/>
              </span>
              <br/>
            </div>
            <button class="bg-green-500 text-white px-4 py-2 rounded-lg hover:bg-green-600 ml-4"
                    (click)="orderProduct(product, quantityInput.value)">
              Order Now
            </button>
          </li>
        }
      </ul>
    } @else if (products.length === 100) {
      <span class="text-sm text-gray-700">
      Click <a class="text-blue-500 hover:underline cursor-pointer">Load More</a> to see more products
    </span>
    } @else {
      <p class="text-red-500 font-semibold">No products found!</p>
    }
  </div>
</main>

home-page.component.ts

import {Component, inject, OnInit} from '@angular/core';
import {OidcSecurityService} from "angular-auth-oidc-client";
import {Product} from "../../model/product";
import {ProductService} from "../../services/product/product.service";
import {AsyncPipe, JsonPipe} from "@angular/common";
import {Router} from "@angular/router";
import {Order} from "../../model/order";
import {FormsModule} from "@angular/forms";
import {OrderService} from "../../services/order/order.service";

@Component({
  selector: 'app-homepage',
  templateUrl: './home-page.component.html',
  standalone: true,
  imports: [
    AsyncPipe,
    JsonPipe,
    FormsModule
  ],
  styleUrl: './home-page.component.css'
})
export class HomePageComponent implements OnInit {
  private readonly oidcSecurityService = inject(OidcSecurityService);
  private readonly productService = inject(ProductService);
  private readonly orderService = inject(OrderService);
  private readonly router = inject(Router);
  isAuthenticated = false;
  products: Array<Product> = [];
  quantityIsNull = false;
  orderSuccess = false;
  orderFailed = false;

  ngOnInit(): void {
    this.oidcSecurityService.isAuthenticated$.subscribe(
      ({isAuthenticated}) => {
        this.isAuthenticated = isAuthenticated;
        this.productService.getProducts()
          .pipe()
          .subscribe(product => {
            this.products = product;
          })
      }
    )
  }

  goToCreateProductPage() {
    this.router.navigateByUrl('/add-product');
  }

  orderProduct(product: Product, quantity: string) {

    this.oidcSecurityService.userData$.subscribe(result => {
      const userDetails = {
        email: result.userData.email,
        firstName: result.userData.firstName,
        lastName: result.userData.lastName
      };

      if(!quantity) {
        this.orderFailed = true;
        this.orderSuccess = false;
        this.quantityIsNull = true;
      } else {
        const order: Order = {
          skuCode: product.skuCode,
          price: product.price,
          quantity: Number(quantity),
          userDetails: userDetails
        }

        this.orderService.orderProduct(order).subscribe(() => {
          this.orderSuccess = true;
        }, error => {
          this.orderFailed = false;
        })
      }
    })
  }
}
The home page will interact with the Order Service, that is responsible to make HTTP calls to our microservice backend, to create the order service, type the below command:

ng g s services/order
And then add the below code:

order.service.ts

import {Component, inject, OnInit} from '@angular/core';
import {OidcSecurityService} from "angular-auth-oidc-client";
import {Product} from "../../model/product";
import {ProductService} from "../../services/product/product.service";
import {AsyncPipe, JsonPipe} from "@angular/common";
import {Router} from "@angular/router";
import {Order} from "../../model/order";
import {FormsModule} from "@angular/forms";
import {OrderService} from "../../services/order/order.service";

@Component({
  selector: 'app-homepage',
  templateUrl: './home-page.component.html',
  standalone: true,
  imports: [
    AsyncPipe,
    JsonPipe,
    FormsModule
  ],
  styleUrl: './home-page.component.css'
})
export class HomePageComponent implements OnInit {
  private readonly oidcSecurityService = inject(OidcSecurityService);
  private readonly productService = inject(ProductService);
  private readonly orderService = inject(OrderService);
  private readonly router = inject(Router);
  isAuthenticated = false;
  products: Array<Product> = [];
  quantity = 1;
  orderSuccess = false;
  orderFailed = false;

  ngOnInit(): void {
    this.oidcSecurityService.isAuthenticated$.subscribe(
      ({isAuthenticated}) => {
        this.isAuthenticated = isAuthenticated;
        this.productService.getProducts()
          .pipe()
          .subscribe(product => {
            this.products = product;
          })
      }
    )
  }

  goToCreateProductPage() {
    this.router.navigateByUrl('/add-product');
  }

  orderProduct(product: Product, quantity: string) {

    this.oidcSecurityService.userData$.subscribe(result => {
      const userDetails = {
        email: result.userData.email,
        firstName: result.userData.firstName,
        lastName: result.userData.lastName
      };

      const order: Order = {
        skuCode: product.skuCode,
        price: product.price,
        quantity: Number(quantity),
        userDetails: userDetails
      }

      this.orderService.orderProduct(order).subscribe(() => {
        this.orderSuccess = true;
      }, error => {
        this.orderFailed = false;
      })
    })
  }
}

We also need to create the model classes to transfer the payload, for that create a package called model and a file inside called order.ts

export interface Order {
  id?: number;
  orderNumber?: string;
  skuCode: string;
  price: number;
  quantity: number;
  userDetails: UserDetails
}

export interface UserDetails {
  email: string;
  firstName: string;
  lastName: string;
}

When we are making calls from the frontend to the backend we have to make sure that our frontend is sending the access token for each HTTP request to the backend, for that we need to create an interceptor to intercept all outgoing requests and add the token.

interceptor/auth.interceptor.ts

import {HttpInterceptorFn} from "@angular/common/http";
import {inject} from "@angular/core";
import {OidcSecurityService} from "angular-auth-oidc-client";

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(OidcSecurityService);

  authService.getAccessToken().subscribe(token => {
    if (token) {
      let header = 'Bearer ' + token;

      let headers = req.headers
        .set('Authorization', header);

      req = req.clone({headers});

      return next(req);
    }

    return next(req);
  })

  return next(req);

}

We are also reading the products from the backend and displaying them in the frontend, for that we also have to create a product service similar to the order service by executing the below command:

ng g s services/product
product.service.ts

import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
  }

  getProducts(): Observable<Array<Product>> {
    return this.httpClient.get<Array<Product>>('http://localhost:9000/api/product');
  }

  createProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>('http://localhost:9000/api/product', product);
  }
}

model/product.ts

export interface Product {
  id?: string;
  skuCode: string;
  name: string;
  description: string;
  price: number;
}

Create Add Product Component
We also need to create a component to Add Products, for that execute the below command:

ng g c pages/add-product
add-product.component.html

<div class="container mx-auto p-4">
  <h2 class="text-2xl font-bold mb-4">Add Product</h2>
  @if (productCreated) {
    <h4 class="text-green-500">Product Created Successfully</h4>
  }
  <form [formGroup]="addProductForm" (ngSubmit)="onSubmit()">
    <div class="mb-4">
      <label class="block text-gray-700" for="skuCode">SKU Code</label>
      <input
        type="text"
        id="skuCode"
        formControlName="skuCode"
        class="border rounded w-full py-2 px-3 text-gray-700"
      />
      <div *ngIf="skuCode?.invalid && (skuCode?.dirty || skuCode?.touched)" class="text-red-500">
        <div *ngIf="skuCode?.errors?.['required']">SKU Code is required.</div>
        <div *ngIf="skuCode?.errors?.['minlength']">SKU Code must be at least 3 characters long.</div>
      </div>
    </div>

    <div class="mb-4">
      <label class="block text-gray-700" for="name">Name</label>
      <input
        type="text"
        id="name"
        formControlName="name"
        class="border rounded w-full py-2 px-3 text-gray-700"
      />
      <div *ngIf="name?.invalid && (name?.dirty || name?.touched)" class="text-red-500">
        <div *ngIf="name?.errors?.['required']">Name is required.</div>
        <div *ngIf="name?.errors?.['minlength']">Name must be at least 3 characters long.</div>
      </div>
    </div>

    <div class="mb-4">
      <label class="block text-gray-700" for="description">Description</label>
      <textarea
        id="description"
        formControlName="description"
        class="border rounded w-full py-2 px-3 text-gray-700"
      ></textarea>
      <div *ngIf="description?.invalid && (description?.dirty || description?.touched)" class="text-red-500">
        <div *ngIf="description?.errors?.['required']">Description is required.</div>
        <div *ngIf="description?.errors?.['minlength']">Description must be at least 10 characters long.</div>
      </div>
    </div>

    <div class="mb-4">
      <label class="block text-gray-700" for="price">Price</label>
      <input
        type="number"
        id="price"
        formControlName="price"
        class="border rounded w-full py-2 px-3 text-gray-700"
      />
      <div *ngIf="price?.invalid && (price?.dirty || price?.touched)" class="text-red-500">
        <div *ngIf="price?.errors?.['required']">Price is required.</div>
        <div *ngIf="price?.errors?.['min']">Price must be greater than 0.</div>
      </div>
    </div>

    <button
      type="submit"
      class="bg-green-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600"
      [disabled]="addProductForm.invalid"
    >
      Add Product
    </button>
  </form>
</div>

add-product.component.ts

import {Component, inject} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Product} from "../../model/product";
import {ProductService} from "../../services/product/product.service";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-add-product',
  standalone: true,
  imports: [ReactiveFormsModule, NgIf],
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.css'
})
export class AddProductComponent {
  addProductForm: FormGroup;
  private readonly productService = inject(ProductService);
  productCreated = false;

  constructor(private fb: FormBuilder) {
    this.addProductForm = this.fb.group({
      skuCode: ['', [Validators.required]],
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],
      price: [0, [Validators.required]]
    })
  }

  onSubmit(): void {
    if (this.addProductForm.valid) {
      const product: Product = {
        skuCode: this.addProductForm.get('skuCode')?.value,
        name: this.addProductForm.get('name')?.value,
        description: this.addProductForm.get('description')?.value,
        price: this.addProductForm.get('price')?.value
      }
      this.productService.createProduct(product).subscribe(product => {
        this.productCreated = true;
        this.addProductForm.reset();
      })
    } else {
      console.log('Form is not valid');
    }
  }

  get skuCode() {
    return this.addProductForm.get('skuCode');
  }

  get name() {
    return this.addProductForm.get('name');
  }

  get description() {
    return this.addProductForm.get('description');
  }

  get price() {
    return this.addProductForm.get('price');
  }
}

Configure Routes
Now we have a couple of components, we have to configure routing between these components, for open the app.routes.ts file and add the below content:

import {Routes} from '@angular/router';
import {HomePageComponent} from "./pages/home-page/home-page.component";
import {AddProductComponent} from "./pages/add-product/add-product.component";

export const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'add-product', component: AddProductComponent}
];

Now let's add some final configuration changes to enable the functionalities like HTTP Client, OAuth2, and interceptor in our angular application, by updating the app.config.ts file:

import {ApplicationConfig, provideZoneChangeDetection} from '@angular/core';
import {provideRouter} from '@angular/router';

import {routes} from './app.routes';
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {authConfig} from "./config/auth.config";
import {provideAuth} from "angular-auth-oidc-client";
import {authInterceptor} from "./interceptor/auth.interceptor";

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({eventCoalescing: true}),
    provideRouter(routes),
    provideHttpClient(withInterceptors([authInterceptor])),
    provideAuth(authConfig),
  ]
};

And finally, this is how the app.component.html file looks like:

<app-header></app-header>
<router-outlet />
Setting up Angular Client in Keycloak
Before we go ahead and test our application, we have to create the Angular Client in the Keycloak server. For that open localhost:8181 and login to Keycloak with your admin credentials.

Select the realm - spring-microservices-security-realm

Click on Clients on the left side menu bar

Click on the Create client button

Enter Client ID as angular-client

Click Next

Only Select the option - Standard Flow and nothing else, de-select the option Direct access grants that is enabled by default, we don't need it for our use case

Click Next

Under the input Valid redirect URIs - provide the value - http://localhost:4200

Under the input Web origins - provide the value - * to allow requests from all origins.

Click on Save

That's all you need to configure the Angular client in Keycloak, we already configured our Angular app to use the client we just created.

Enable User Registration for Keycloak
The next thing we want to do is to enable the users to self-register on Keycloak, for that open the Realm Settings, click on Login, and select the User Registration option to enable it.

Enable CORS on API Gateway
Before we go ahead and test our implementation, we have to enable CORS on the API Gateway because our Frontend application is running at http://localhost:4200, whereas our API Gateway is running at http://localhost:9000, as they are two different origins, the browser will not allow the requests to the API Gateway, it will only allow if we explicitly allow the origin in our API Gateway.

To add this configuration, use the following configuration in the SecurityConfig.java class of the API Gateway project.

package com.programming.techie.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    private final String[] freeResourceUrls = {"/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**",
            "/swagger-resources/**", "/api-docs/**", "/aggregate/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(freeResourceUrls)
                        .permitAll()
                        .anyRequest().authenticated())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.applyPermitDefaultValues();
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

We created a bean called corsConfigurationSource and inside the bean, we are allowing any HTTP method, in a production-grade application you should not do this, but instead should check which HTTP method is allowed, as well as which URL is allowed to access your service.

Testing the application
To test the application, open the URL: http://localhost:4200 you will be greeted with the page that looks like below:

Home Page

Click on Login and you will be redirected to the Keycloak login page.

On the login page, click on Register provide the necessary details, and submit it.

You will be automatically logged in to the application.

If you don't have any products in the product service, you can create one by clicking on the Add Products Page providing the necessary information, and submit it.

Add Products

After adding the product, you can view it on the home page like below:

Home Page with products

You can order the products by clicking on the Order Now button, make sure to add the quantity before you click on the Order Now button.

Conclusion
I hope you learned something from this tutorial, in the next tutorial we will continue with our microservices series and we will see how to implement event driven architecture using Kafka in our microservices project.

Spring Boot Microservices Tutorial - Part 8
July 7, 2024
In Part 8 of this Spring Boot Microservices Tutorial series, we will integrate Kafka into our project and learn how to build Event-Driven Microservices with Spring Boot and Kafka.

What are Event Driven Microservices?
Event-driven microservices architecture is a way of building applications, where the systems communicate by publishing and consuming events, these events are available whenever other consumers need to read them at any time.

Apache Kafka is a distributed messaging and streaming platform used frequently in the industry to implement Event-Driven Architecture.

Installing Apache Kafka through Docker
We will use Docker to install Apache Kafka together with Zookeeper. We will also use a Kafka UI to see the topics and messages in our Kafka Cluster using the Kafka UI project. Here is how the Docker compose file looks like in the order-service docker-compose.yaml file:

version: '4'
services:
  mysql:
    image: mysql:8.3.0
    container_name: mysql
    environment:
      MYSQL_ROOT_PASSWORD: mysql
    ports:
      - "3306:3306"
    volumes:
      - ./mysql:/var/lib/mysql
      - ./docker/mysql/init.sql:/docker-entrypoint-initdb.d/init.sql
  zookeeper:
    image: confluentinc/cp-zookeeper:7.5.0
    hostname: zookeeper
    container_name: zookeeper
    ports:
      - "2181:2181"
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  broker:
    image: confluentinc/cp-kafka:7.5.0
    container_name: broker
    ports:
      - "9092:9092"
      - "29092:29092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://broker:29092,PLAINTEXT_HOST://localhost:9092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1

  schema-registry:
    image: confluentinc/cp-schema-registry:7.5.0
    hostname: schema-registry
    container_name: schema-registry
    depends_on:
      - broker
    ports:
      - "8085:8081"
    environment:
      SCHEMA_REGISTRY_HOST_NAME: schema-registry
      SCHEMA_REGISTRY_KAFKASTORE_BOOTSTRAP_SERVERS: 'broker:29092'
      SCHEMA_REGISTRY_LISTENERS: http://schema-registry:8081
  kafka-ui:
    container_name: kafka-ui
    image: provectuslabs/kafka-ui:latest
    ports:
      - "8086:8080"
    depends_on:
      - broker
      - schema-registry
    environment:
      KAFKA_CLUSTERS_NAME: local
      KAFKA_CLUSTERS_BOOTSTRAPSERVERS: broker:29092
      KAFKA_CLUSTERS_SCHEMAREGISTRY: http://schema-registry:8081
      DYNAMIC_CONFIG_ENABLED: 'true'
The main services we use are

cp-zookeeper which is a Zookeeper cluster that is used to orchestrate multiple Kafka clusters.

cp-kafka which is the Kafka server itself

cp-schema-registry is the service we used to define the schema of the messages that are sent between producers and consumers

Lastly, we have kafka-ui which provides a nice UI to allow us to view the Kafka topics that are created and also helps us to view the messages from and send messages to the Kafka topic.

After updating the docker-compose file, just run docker compose up -d to start all the services.

Spring Kafka
We will be using the Spring Kafka project to implement Kafka functionality in our Spring Boot projects, for that add the below dependencies in the order-service project.

        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>
        <dependency>
            <groupId>io.confluent</groupId>
            <artifactId>kafka-avro-serializer</artifactId>
            <version>7.6.0</version>
        </dependency>
        <dependency>
            <groupId>io.confluent</groupId>
            <artifactId>kafka-schema-registry-client</artifactId>
            <version>7.6.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.avro</groupId>
            <artifactId>avro</artifactId>
            <version>1.11.3</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka-test</artifactId>
            <scope>test</scope>
        </dependency>
The above dependencies not only add the spring-kafka functionality but also bring in dependencies to work with schema-registry. We will define our schema in avro format, for that reason we need to also add the avro and kafka-avro-serializer dependencies.

After adding the above dependencies, now it's time to implement the logic to send an event to the kafka topic whenever there is an order placed in the order-service. We will first start by defining the avro-schema of the event we want to send. And we will define the schema in a .avsc file, avsc is the format to define the Avro schema, let's add the below file under src/main/resources/avro folder.

order-placed.avsc

{
  "type": "record",
  "name": "OrderPlacedEvent",
  "namespace": "com.techie.microservices.order.event",
  "fields": [
    { "name": "orderNumber", "type": "string" },
    { "name": "email", "type": "string" },
    { "name": "firstName", "type": "string" },
    { "name": "lastName", "type": "string" }
  ]
}
Here we have a few fields orderNumber, email, firstName, and lastName that are used to send notifications to the user whenever an order is placed successfully.

The idea is to generate the Java classes automatically using this schema, so if there is a change in the schema file, then those changes will be automatically applied during the build time.

To be able to generate the Java classes automatically, we are going to use the avro-maven-plugin:

            <plugin>
                <groupId>org.apache.avro</groupId>
                <artifactId>avro-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <id>schemas</id>
                        <phase>generate-sources</phase>
                        <goals>
                            <goal>schema</goal>
                        </goals>
                        <configuration>
                            <sourceDirectory>${project.basedir}/src/main/resources/avro</sourceDirectory>
                            <outputDirectory>${project.basedir}/src/main/java/</outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
Add the above plugin under the <plugins> section and run mvn clean compile command.

Now you should see a file called OrderPlacedEvent.java under the com.techie.microservices.order.event package.

Producing Messages from Order Service
Now it's time to configure Kafka in our Spring Boot application, for that we are going to add the following properties in the application.properties file.

#Kafka Properties
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.template.default-topic=order-placed
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=io.confluent.kafka.serializers.KafkaAvroSerializer
spring.kafka.producer.properties.schema.registry.url=http://localhost:8085
The above properties provide the necessary configuration to run Kafka Producer and to use the Kafka Schema registry in our Order service application.

Inside the OrderService.java class, let's add the logic to send the messages to the Kafka topic using the KafkaTemplate class.

Here is how the OrderService.java class looks like:

OrderService.java

package com.techie.microservices.order.service;

import com.techie.microservices.order.client.InventoryClient;
import com.techie.microservices.order.dto.OrderRequest;
import com.techie.microservices.order.event.OrderPlacedEvent;
import com.techie.microservices.order.event.handler.OrderPlacedEventHandler;
import com.techie.microservices.order.model.Order;
import com.techie.microservices.order.repository.OrderRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest) {

        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price().multiply(BigDecimal.valueOf(orderRequest.quantity())));
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
            var orderPlacedEvent = new OrderPlacedEvent(order.getOrderNumber(), orderRequest.userDetails()
                    .email(),
                    orderRequest.userDetails()
                            .firstName(),
                    orderRequest.userDetails()
                            .lastName());
            log.info("Start- Sending OrderPlacedEvent {} to Kafka Topic", orderPlacedEvent);
            kafkaTemplate.send("order-placed", orderPlacedEvent);
            log.info("End- Sending OrderPlacedEvent {} to Kafka Topic", orderPlacedEvent);
        } else {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + " is not in stock");
        }
    }
}

This is all the logic we need to produce the events to order-placed kafka topic. Now let's see how to consume the messages in our consumer, that would be the notification-service.

Consuming Messages from Notification Service
Let's create a new Spring Boot application called Notification Service with the following dependencies.

Spring Kafka

Java Mail Sender

Lombok

Test Containers

After adding these dependencies, generate the project and open it in your IDE.

Now we need to add some more dependencies like Kafka Schema Registry, Avro Serializer, etc.

The complete pom.xml for notification-service looks like below:

pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.0</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.programming.techie</groupId>
    <artifactId>notification-service</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>notification-service</name>
    <description>notification-service</description>
    <properties>
        <java.version>21</java.version>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>io.confluent</groupId>
            <artifactId>kafka-avro-serializer</artifactId>
            <version>7.6.0</version>
        </dependency>
        <dependency>
            <groupId>io.confluent</groupId>
            <artifactId>kafka-schema-registry-client</artifactId>
            <version>7.6.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.avro</groupId>
            <artifactId>avro</artifactId>
            <version>1.11.3</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-testcontainers</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.kafka</groupId>
            <artifactId>spring-kafka-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>junit-jupiter</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>kafka</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

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
                <groupId>org.apache.avro</groupId>
                <artifactId>avro-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <id>schemas</id>
                        <phase>generate-sources</phase>
                        <goals>
                            <goal>schema</goal>
                        </goals>
                        <configuration>
                            <sourceDirectory>${project.basedir}/src/main/resources/avro</sourceDirectory>
                            <outputDirectory>${project.basedir}/src/main/java/</outputDirectory>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <repositories>
        <repository>
            <id>confluent</id>
            <url>https://packages.confluent.io/maven/</url>
        </repository>
    </repositories>
</project>

Place the order-placed.avsc file under the src/main/resources/avro folder

order-placed.avsc

{
  "type": "record",
  "name": "OrderPlacedEvent",
  "namespace": "com.techie.microservices.order.event",
  "fields": [
    { "name": "orderNumber", "type": "string" },
    { "name": "email", "type": "string" },
    { "name": "firstName", "type": "string" },
    { "name": "lastName", "type": "string" }
  ]
}
Now let's configure the properties for Kafka Consumer in our Spring Boot Application's application.properties file:

spring.application.name=notification-service
# Mail Properties
spring.mail.host=sandbox.smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=<username>
spring.mail.password=<password>
spring.mail.protocol=smtp
# Kafka Config
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=notificationService
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
spring.kafka.consumer.properties.spring.deserializer.key.delegate.class=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.properties.spring.deserializer.value.delegate.class=io.confluent.kafka.serializers.KafkaAvroDeserializer
spring.kafka.consumer.properties.schema.registry.url=http://localhost:8085
spring.kafka.consumer.properties.specific.avro.reader=true
Create a class called NotificationService.java that listens for the messages on the topic - "order-placed" and sends email

NotificationService.java

package com.techie.microservices.notification.service;

import com.techie.microservices.order.event.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final JavaMailSender javaMailSender;

    @KafkaListener(topics = "order-placed")
    public void listen(OrderPlacedEvent orderPlacedEvent){
        log.info("Got Message from order-placed topic {}", orderPlacedEvent);
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("springshop@email.com");
            messageHelper.setTo(orderPlacedEvent.getEmail().toString());
            messageHelper.setSubject(String.format("Your Order with OrderNumber %s is placed successfully", orderPlacedEvent.getOrderNumber()));
            messageHelper.setText(String.format("""
                            Hi %s,%s

                            Your order with order number %s is now placed successfully.

                            Best Regards
                            Spring Shop
                            """,
                    orderPlacedEvent.getFirstName().toString(),
                    orderPlacedEvent.getLastName().toString(),
                    orderPlacedEvent.getOrderNumber()));
        };
        try {
            javaMailSender.send(messagePreparator);
            log.info("Order Notifcation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new RuntimeException("Exception occurred when sending mail to springshop@email.com", e);
        }
    }
}
Spring Boot 3 Observability with Grafana Stack
September 9, 2023
In this blog post - Spring Boot 3 Observability with Grafana Stack, we will learn how to implement Observability in our Spring Boot applications using Grafana Stack which comprises Grafana, Loki, and Tempo.

Spring Boot 3 Observability with Grafana Stack
What is Observability?
In a nutshell, Observability is the process of understanding the internal state of the application with the help of different indicators such as Logs, Metrics, and Tracing information.

For a more detailed explanation, have a look at this article.

We will see how to implement Observability for a sample loan processing system built with Spring Boot 3 using the Grafana Stack.

Grafana Stack
Grafana Stack comprises about 3 softwares:

Grafana: This is the most widely used tool that helps to monitor and visualize the metrics of our application. Users can visualize the metrics by building different dashboards and can use different kinds of charts to visualize the metrics. We can also configure alerts to be notified whenever a metric reaches a certain required threshold.

To collect metrics, we will be using Prometheus, a metrics aggregation tool.

Loki: is a Log Aggregation tool that receives the logs from our application and indexes the logs to be visualized using Grafana.

Tempo: is used as a distributed tracing tool, which can track requests that span across different systems.

Implementing Observability
The below picture shows you a high-level overview of our project and how tools like Grafana, Loki, and Tempo fit into our overall architecture.

Observability
We have a loan-service that is responsible for accepting requests for loans and this request is validated against a fraud-service that verifies if the applicant is on the fraud list.

You can find the source code of this application at - https://github.com/SaiUpadhyayula/springboot3-observablity

This tutorial will only concentrate on implementing the observability aspects of the application, the initial working version of the application can be found in the branch - start-here.

The application is built as a maven multi-module project, where loan-service and fraud-service are created as maven modules.

Logging
Let's start with implementing logging in our application. To send our application logs to Loki, we have to add the below dependency to the pom.xml of both loan-service and fraud-service.

    <dependency>
        <groupId>com.github.loki4j</groupId>
        <artifactId>loki-logback-appender</artifactId>
        <version>1.3.2</version>
    </dependency>
The loki-logback-appender adds the necessary integration with Loki with the help of the Logback logging library.

Next, we have to define a logback-spring.xml file inside the src/main/resources which contains necessary information about how to structure our logs and where to send the logs (in other words it contains the information about Loki URL).

<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/base.xml"/>
    <springProperty scope="context" name="appName" source="spring.application.name"/>

    <appender name="LOKI" class="com.github.loki4j.logback.Loki4jAppender">
        <http>
            <url>http://localhost:3100/loki/api/v1/push</url>
        </http>
        <format>
            <label>
                <pattern>application=${appName},host=${HOSTNAME},level=%level</pattern>
            </label>
            <message>
                <pattern>${FILE_LOG_PATTERN}</pattern>
            </message>
            <sortByTime>true</sortByTime>
        </format>
    </appender>

    <root level="INFO">
        <appender-ref ref="LOKI"/>
    </root>
</configuration>

The <appender> defines the Loki4JAppender, which contains the reference to the Loki url under the <url> tag. It also defines the log pattern using the <pattern> tag which is defined as application=${app.name}, host=${HOSTNAME}, level=%level, where we display the application name which is defined in the <springProperty> tag, host, and the log level, which is defined as INFO under the <root> tag.

That's all we need to do to implement logging using Loki. You can download and run Loki on your machine using Docker. In the sample project, I am using docker-compose, add the below Loki configuration in the docker-compose.yml file:

loki:
  image: grafana/loki:main
  command: ['-config.file=/etc/loki/local-config.yaml']
  ports:
    - '3100:3100'
Now let's see how to implement Metrics using Prometheus and Grafana.

Metrics
Metrics can be any kind of measurable information about our application like JVM statistics, Thread Count, Heap Memory information, etc. To collect metrics of our application, we need to first enable Spring Boot Actuator in our project by adding the below dependency:

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
Next, we have to add another dependency to expose the metrics of our application, Spring Boot uses Micrometer to collect metrics, and by adding the below dependency we can configure Micrometer to expose an endpoint that can be scraped by Prometheus.

		<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-registry-prometheus</artifactId>
			<scope>runtime</scope>
		</dependency>

To see different metrics exposed by Spring Boot you can refer to this link from Spring Boot documentation - https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.metrics.supported

The next step is to add some properties to our application.yml file.

management.endpoints.web.exposure.include=health, info, metrics, prometheus
management.metrics.distribution.percentiles-histogram.http.server.requests=true
management.observations.key-values.application=loan-service
The property - management.endpoints.web.exposure.include=health, info, metrics, prometheus exposes the endpoints health, info, metrics, and prometheus through the actuator.

Next, we are defining a property called management.metrics.distribution.percentiles-histogram.http.server.requests=true which is used by the micrometer to gather the metrics in the form of a histogram and send it to Prometheus. You can read more about this concept here - https://micrometer.io/docs/concepts#_histograms_and_percentiles.

After adding the above properties run both applications and open the URL - http://localhost:8080/actuator/prometheus to see different metrics that are exposed by the micrometer.

You can run Prometheus by adding the below entry in the docker-compose.yml file

prometheus:
  image: prom/prometheus:v2.46.0
  command:
    - --enable-feature=exemplar-storage
    - --config.file=/etc/prometheus/prometheus.yml
  volumes:
    - ./docker/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml:ro
  ports:
    - '9090:9090'
We need a configuration file, to tell Prometheus where it can find the necessary metrics to scrape. For that, we need to create a file called prometheus.yml with the following content.

global:
  scrape_interval: 2s
  evaluation_interval: 2s

scrape_configs:
  - job_name: 'prometheus'
    static_configs:
      - targets: ['prometheus:9090']
  - job_name: 'loan-service'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['host.docker.internal:8080'] ## only for demo purposes don't use host.docker.internal in production
  - job_name: 'fraud-detection'
    metrics_path: '/actuator/prometheus'
    static_configs:
      - targets: ['host.docker.internal:8081'] ## only for demo purposes don't use host.docker.internal in production
Under the global field, we defined the scrape and evaluation interval as 2s. In the scrape_configs section, we have 3 jobs, one for prometheus, loan-service, and fraud-detection service. Notice that to scrape the loan-service and fraud-detection services we defined the URL of both the services and the metrics path as - /actuator/prometheus

Tracing
Now let's go ahead and implement Distributed Tracing using Tempo. For that, we need to add some more dependencies.

Prior to Spring Boot 3, we used to add the Spring Cloud Sleuth dependency to add distributed tracing capabilities to our application, but from Spring Boot 3, Spring Cloud Sleuth is no longer needed and this is replaced by the Micrometer Tracing Project. To add the support, add the below dependencies:

		<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-tracing-bridge-brave</artifactId>
		</dependency>
		<dependency>
			<groupId>io.zipkin.reporter2</groupId>
			<artifactId>zipkin-reporter-brave</artifactId>
		</dependency>
micrometer-tracing-bridge-brave is the dependency that does all the magic and adds distributed tracing for our application. Whereas zipkin-reporter-brave will exportthe tracing information to Tempo.

NOTE: You can also use other tracing implementation like OpenTelemetry - micrometer-tracing-bridge-otel dependency instead of Brave - micrometer-tracing-bridge-brave
If you want to trace the calls to the database, as we are using Spring Data JDBC, we can add the dependency datasource-micrometer-spring-boot dependency.

		<dependency>
			<groupId>net.ttddyy.observation</groupId>
			<artifactId>datasource-micrometer-spring-boot</artifactId>
			<version>1.0.1</version>
		</dependency>
As we are using a RestTemplate to call fraud-detection service from loan-service , the traceId and spanId are generated and propagated automatically.

But if you want to create manual tracing for specific calls you can use the Observation API and the @Observed annotation.

For example, as we wanted to trace the calls to the database, we can do that by adding the @Observed annotation on the LoanRepository interface.

@Repository
@RequiredArgsConstructor
@Observed
public class LoanRepository {

    private final JdbcClient jdbcClient;

    .....
    .....
    .....
}
Next, we need to define a bean of type `ObservedAspect` we can do that by creating a class called ObservationConfig.java

package com.programming.techie.loans.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObservationConfig {
    @Bean
    ObservedAspect observedAspect(ObservationRegistry registry) {
        return new ObservedAspect(registry);
    }
}
Finally, to enable the Aspect Oriented Programming, we need to add the spring-boot-starter-aop dependency.

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>
Micrometer Tracing will only send 10% of the traces it generates to Tempo, just to avoid overwhelming it with a lot of requests. We can set it to 100% by adding the below property to our application.yml file

management.tracing.sampling.probability=1.0
Finally, you can run Tempo using docker, by adding the below piece of code inside the docker-compose.yml file:

tempo:
  image: grafana/tempo:2.2.2
  command: ['-config.file=/etc/tempo.yaml']
  volumes:
    - ./docker/tempo/tempo.yml:/etc/tempo.yaml:ro
    - ./docker/tempo/tempo-data:/tmp/tempo
  ports:
    - '3110:3100' # Tempo
    - '9411:9411' # zipkin
Finally, we need to configure a file called tempo.yml file to store the necessary settings to be used in Tempo. I created this file under the docker folder

server:
  http_listen_port: 3200

distributor:
  receivers:
    zipkin:

storage:
  trace:
    backend: local
    local:
      path: /tmp/tempo/blocks
You can observe that we are referring to this file inside the docker-compose service, and we are mounting this file into the /etc/ location of the container.

Running Grafana
Before testing our implementation, let's also see how to run Grafana using Docker. After all, this is what brings all the services like Tempo, Loki, and Prometheus together and visualizes the information produced by our services.

grafana:
  image: grafana/grafana:10.1.0
  volumes:
    - ./docker/grafana:/etc/grafana/provisioning/datasources:ro
  environment:
    - GF_AUTH_ANONYMOUS_ENABLED=true
    - GF_AUTH_ANONYMOUS_ORG_ROLE=Admin
    - GF_AUTH_DISABLE_LOGIN_FORM=true
  ports:
    - '3000:3000'
The above configuration will run Grafana by disabling the login and authentication, do not use this configuration in Production.

Also for Grafana, we need to define the data sources from which it needs to gather the information to visualize, for that let's create a file called datasources.yml

apiVersion: 1

datasources:
  - name: Prometheus
    type: prometheus
    access: proxy
    url: http://prometheus:9090
    editable: false
    jsonData:
      httpMethod: POST
      exemplarTraceIdDestinations:
        - name: trace_id
          datasourceUid: tempo
  - name: Tempo
    type: tempo
    access: proxy
    orgId: 1
    url: http://tempo:3200
    basicAuth: false
    isDefault: true
    version: 1
    editable: false
    apiVersion: 1
    uid: tempo
    jsonData:
      httpMethod: GET
      tracesToLogs:
        datasourceUid: 'loki'
      nodeGraph:
        enabled: true
  - name: Loki
    type: loki
    uid: loki
    access: proxy
    orgId: 1
    url: http://loki:3100
    basicAuth: false
    isDefault: false
    version: 1
    editable: false
    apiVersion: 1
    jsonData:
      derivedFields:
        - datasourceUid: tempo
            matcherRegex: \[.+,(.+?),
            name: TraceID
            url: $${__value.raw}

This file defines all the data sources like Prometheus, Loki, and Tempo and references to the respective URLs.

Testing
Okay, now it's Testing Time.

Start all the services by running the command:

docker compose up -d
Also, run both the loan-service and fraud-detection services.

After you make some calls to GET/loan and POST/loan, let's first open Loki and check for logs.

Open the URL - http://localhost:3000

Click on the toggle menu and click on 'Explore'

Under the dropdown select - 'Loki' and run the query with your desired parameters, e.g.: select the application label as - loan-service.

TraceID
Now let's open Prometheus, and apply the same filter, you should see the results below:

Prometheus Dashboard
Note down the traceId from the logs that are generated by the GET/loan (or) POST/loan calls.

TraceID
Now open Tempo, go to the Query Type - TraceQL, paste the traceId, and press Shift-Enter.
You should see the tracing information of that particular request.

You can observe from the below image that the fraud-detection service also displays the calls made to the database, thanks to the datasource-micrometer-spring-boot dependency we added before.

Tempo Dashboard
Conclusion
Observability plays a vital role in ensuring that our applications are running as expected and provides us insights into the inner state of the application.

```
# 1

# Spring Boot Microservices Tutorial - Part 1

## Introduction
In this Spring Boot Microservices Tutorial series, you will learn how to develop applications with Microservices Architecture using Spring Boot and Spring Cloud and deploy them using Docker and Kubernetes.

We will cover several concepts and Microservices Architectural Patterns as part of this tutorial series. Here are the topics we will cover in each part:

- **Part 1:** Building REST-based applications using Spring Boot 3 and following several best practices.
- **Part 2:** Synchronous Inter-Service Communication Pattern using Spring Cloud Open Feign.
- **Part 3:** Service Discovery Pattern using Spring Cloud Netflix Eureka.
- **Part 4:** API Gateway Pattern using Spring Cloud Gateway.
- **Part 5:** Microservices Security using Keycloak.
- **Part 6:** Circuit Breaker Pattern using Spring Cloud CircuitBreaker with Resilience4J.
- **Part 7:** Event Driven Architecture Pattern using Kafka.
- **Part 8:** Observability Pattern, including Distributed Tracing with Open Telemetry and Grafana Tempo, Log Aggregation with Grafana Loki, and Metrics collection with Prometheus.
- **Part 9:** Containerizing all applications using Docker and running them with Docker Compose.
- **Part 10:** Migrating Docker Compose workloads to Kubernetes.

## Application Overview
We will build a simple e-commerce application where customers can order products. Our application will contain the following services:

- Product Service
- Order Service
- Inventory Service
- Notification Service

To focus on the principles of Spring Cloud and Microservices, we will develop services with essential functionality rather than creating fully-featured e-commerce services.

## Download Source Code
You can download the source code of this project through GitHub: [spring-boot-microservices](https://github.com/SaiUpadhyayula/spring-boot-microservices/tree/initial-setup)

## Architecture Diagram of the Project
Here is the architecture diagram of the project we are going to cover in this tutorial series:

![Architecture Diagram for Spring Boot Microservices Project](link_to_your_diagram)

## Creating Our First Microservice: Product Service
Let's start creating our first microservice (Product Service). As discussed before, we will keep this service simple and only include the most important features.

### Service Operations
| Operation        | HTTP Method | Service Endpoint      |
|------------------|-------------|------------------------|
| CREATE PRODUCT    | POST        | /api/product/          |
| READ ALL PRODUCTS | GET         | /api/product/          |

### Project Setup
To create the project, go to [start.spring.io](https://start.spring.io) and configure the following:

#### Dependencies:
- Lombok
- Spring Web
- Test Containers
- Spring Data MongoDB
- Java 21
- Maven as the build tool

We will use MongoDB as the database backing our Product Service.

After adding the necessary configuration, click on the **Generate** button to download the source code. Unzip the source code and open it in your favorite IDE.

Run the following command to build the project:

```bash
mvn clean verify
```

The application should build successfully without any errors.

### Download MongoDB using Docker and Docker Compose
We will use Docker to install the necessary software like databases, message queues, and other required software for this project.

If you don't have Docker installed, you can download it [here](https://docs.docker.com/get-docker/).

Create a file called `docker-compose.yml` in the root folder:

```yaml
version: '4'
services:
  mongo:
    image: mongo:7.0.5
    container_name: mongo
    ports:
      - "27017:27017"
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: password
      MONGO_INITDB_DATABASE: product-service
    volumes:
      - ./docker/mongodb/data:/data/db
```

Configure the MongoDB URI Details in the `application.properties` file:

```properties
spring.data.mongodb.uri=mongodb://root:password@localhost:27017/product-service?authSource=admin
```

### Creating the Create and Read Endpoints
Create a model class for the Products.

**Product.java**
```java
package com.programmingtechie.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
```

Next, create the Spring Data MongoDB interface for the Product class.

**ProductRepository.java**
```java
package com.programmingtechie.productservice.repository;

import com.programmingtechie.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
```

Now, create the service class which contains the actual business logic.

**ProductService.java**
```java
package com.programmingtechie.productservice.service;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;
import com.programmingtechie.productservice.model.Product;
import com.programmingtechie.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }
}
```

Next, create the Controller class to expose the POST and GET endpoints.

**ProductRestController.java**
```java
package com.programmingtechie.productservice.controller;

import com.programmingtechie.productservice.dto.ProductRequest;
import com.programmingtechie.productservice.dto.ProductResponse;
import com.programmingtechie.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
```

### Product Request and Response DTOs
Create the DTOs used by the ProductController.

**ProductRequest.java**
```java
package com.programmingtechie.productservice.dto;

import java.math.BigDecimal;

public record ProductRequest(String name, String description, BigDecimal price) {}
```

**ProductResponse.java**
```java
package com.programmingtechie.productservice.dto;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, BigDecimal price) {}
```

### Testing the Product Service APIs
Start the application and test the two endpoints. 

To create a product, call the URL `http://localhost:8080/api/product` with HTTP Method POST. This should return a status of 201.

To test whether the created product is returned as a response, make a GET call to `http://localhost:8080/api/product`.

### Write Integration Tests for Product Service
Let's write integration tests for the Create Product and Get Products endpoints using TestContainers for MongoDB.

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.3.2</version>
</dependency>
```

Create the integration test:

**ProductServiceApplicationTests.java**
```java
package com.programmingtechie.productservice;

import com.programmingtechie.productservice.dto.ProductRequest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.7");

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();
    }

    @Test
    void shouldCreateProduct() throws Exception {
        ProductRequest productRequest = getProductRequest();

        RestAssured.given()
                .contentType("application/json")
                .body(product

Request)
                .when()
                .post("/api/product")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo(productRequest.name()))
                .body("description", Matchers.equalTo(productRequest.description()))
                .body("price", Matchers.is(productRequest.price().intValueExact()));
    }

    private ProductRequest getProductRequest() {
        return new ProductRequest("iPhone 13", "iPhone 13", BigDecimal.valueOf(1200));
    }
}
```

## Create Second Microservice - Order Service
Now let's create our second microservice, the Order Service. This service will contain only one endpoint to submit an order.

### Service Operations
| Operation   | HTTP Method | Service Endpoint |
|-------------|-------------|-------------------|
| PLACE ORDER | POST        | /api/order        |

### Project Setup
Create the project by visiting [start.spring.io](https://start.spring.io) with the following dependencies:

- Spring Web
- Lombok
- Spring Data JPA
- MySQL Driver
- Flyway Migration
- Testcontainers

We will be using Java 21 and Maven as the build tool.

### Docker Compose for MySQL
Create a `docker-compose.yml` file with the following contents:

```yaml
version: '4'
services:
  mysql:
    image: mysql:8.3.0
    container_name: mysql
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: mysql
    volumes:
      - ./mysql/init.sql:/docker-entrypoint-initdb.d/init.sql
      - ./docker/mysql/data:/var/lib/mysql
```

The SQL file (`init.sql`) will create the database schema during the startup of our MySQL database.

### Configure MySQL
Add the following properties to the `application.properties` file:

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/order_service
spring.datasource.username=root
spring.datasource.password=mysql
spring.jpa.hibernate.ddl-auto=none
server.port=8081
```
```markdown
# Spring Boot Microservices Tutorial - Part 2: Order Service, Inventory Service, and Database Migrations

**March 28, 2024**

## Introduction
In Part 1 of this tutorial series, we built our first microservice, the Product Service. In this part, we will develop the Order Service and Inventory Service, along with implementing database migrations using Flyway.

## Service Overview
We will create two new microservices:
- **Order Service:** Handles order placements.
- **Inventory Service:** Checks product availability.

### Order Service
#### Service Operations
| Operation   | HTTP Method | Service Endpoint |
|-------------|-------------|-------------------|
| PLACE ORDER | POST        | /api/order        |

#### Project Setup
Use [start.spring.io](https://start.spring.io) to create the Order Service with the following dependencies:
- Spring Web
- Lombok
- Spring Data JPA
- MySQL Driver
- Flyway Migration
- Test Containers

**Configure `application.properties`:**
```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/order_service
spring.datasource.username=root
spring.datasource.password=mysql
spring.jpa.hibernate.ddl-auto=none
server.port=8081
```

#### Flyway Database Migrations
Add Flyway dependencies to your `pom.xml`:

```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-mysql</artifactId>
</dependency>
```

Create migration scripts under `src/main/resources/db/migration`:

**V1__init.sql**
```sql
CREATE TABLE `t_orders` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `order_number` varchar(255) DEFAULT NULL,
    `sku_code` varchar(255),
    `price` decimal(19, 2),
    `quantity` int(11),
    PRIMARY KEY (`id`)
);
```

#### Implementing the Order Service
**Order.java**
```java
package com.programmingtechie.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
```

**OrderRepository.java**
```java
package com.programmingtechie.orderservice.repository;

import com.programmingtechie.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
```

**OrderService.java**
```java
package com.programmingtechie.orderservice.service;

import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.model.Order;
import com.programmingtechie.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        var order = mapToOrder(orderRequest);
        orderRepository.save(order);
    }

    private static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        return order;
    }
}
```

**OrderController.java**
```java
package com.programmingtechie.orderservice.controller;

import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
```

**OrderRequest.java**
```java
package com.programmingtechie.orderservice.dto;

import java.math.BigDecimal;

public record OrderRequest(String skuCode, BigDecimal price, Integer quantity) {}
```

### Testing the Order Service
Start the application and use Postman to test the POST request at `http://localhost:8081/api/order` with the following JSON body:

```json
{
    "skuCode": "iphone_15",
    "price": 1000,
    "quantity": 1
}
```

### Writing Integration Tests for Order Service
**OrderServiceApplicationTests.java**
```java
package com.programmingtechie.orderservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {
    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }

    @Test
    void shouldSubmitOrder() {
        String submitOrderJson = """
                {
                     "skuCode": "iphone_15",
                     "price": 1000,
                     "quantity": 1
                }
                """;

        RestAssured.given()
                .contentType("application/json")
                .body(submitOrderJson)
                .when()
                .post("/api/order")
                .then()
                .log().all()
                .statusCode(201)
                .body(is("Order Placed Successfully"));
    }
}
```

---

### Inventory Service
#### Service Operations
| Operation   | HTTP Method | Service Endpoint  |
|-------------|-------------|--------------------|
| CHECK INVENTORY | GET        | /api/inventory    |

#### Project Setup
Create the Inventory Service with similar dependencies as before using [start.spring.io](https://start.spring.io). Configure the application to run on port 8082.

**Configure `application.properties`:**
```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_service
spring.datasource.username=root
spring.datasource.password=mysql
spring.jpa.hibernate.ddl-auto=none
server.port=8082
```

#### Flyway Migration Scripts
Add migration scripts for the Inventory Service:

**V1__init.sql**
```sql
CREATE TABLE `t_inventory` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `sku_code` varchar(255) DEFAULT NULL,
    `quantity` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
```

**V2__add_inventory.sql**
```sql
INSERT INTO t_inventory (quantity, sku_code) VALUES 
(100, 'iphone_15'),
(100, 'pixel_8'),
(100, 'galaxy_24'),
(100, 'oneplus_12');
```

#### Implementing the Inventory Service
**Inventory.java**
```java
package com.programmingtechie.inventoryservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
```

**InventoryRepository.java**
```java
package com.programmingtechie.inventoryservice.repository;

import com.programmingtechie.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
```

**InventoryService.java**
```java
package com.programmingtechie.inventoryservice.service;

import com.programmingtechie.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
```

**InventoryController.java**
```java
package com.programmingtechie.inventoryservice.controller;

import com.programmingtechie.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@Request

Param String skuCode, @RequestParam Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }
}
```

### Testing the Inventory Service
Use Postman to test the GET request at `http://localhost:8082/api/inventory?skuCode=iphone_15&quantity=100`.

### Writing Integration Tests for Inventory Service
**InventoryServiceApplicationTests.java**
```java
package com.programmingtechie.inventoryservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {
    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");
    
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }

    @Test
    void shouldReadInventory() {
        var response = RestAssured.given()
                .when()
                .get("/api/inventory?skuCode=iphone_15&quantity=1")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response().as(Boolean.class);
        assertTrue(response);

        var negativeResponse = RestAssured.given()
                .when()
                .get("/api/inventory?skuCode=iphone_15&quantity=1000")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response().as(Boolean.class);
        assertFalse(negativeResponse);
    }
}
```

## Conclusion
In this part of the tutorial series, we successfully built the Order and Inventory Services, along with implementing Flyway for database migrations. In the next part, we will focus on applying microservice design patterns to enhance our application.


### While connecting local mysql workbench with docker

**failed to connect mysql at 127.0.0.1:3307 with user root authentication plugin "caching_sha2_password" can not be loaded; the specified module could not be found;**

### Solution:

- Create folder structure in microservice-->docker->mysql->init.db
- run below docker-compose.yml file

**`docker-compose.yml`:**
```yaml
version: '3.9'
services:
  mysql:
    image: mysql:8.0.27
    container_name: mysql-micro
    ports:
      - "3307:3306"
    environment:
      MYSQL_ROOT_PASSWORD: mysql
    volumes:
      - ./mysql/init.sql:/docker-entrypoint-initdb.d/init.sql
      - ./docker/mysql/data:/var/lib/mysql
```
To connect your MySQL Workbench to a MySQL instance running in Docker and resolve the **`caching_sha2_password`** authentication plugin issue, follow these steps:

### Step 1: Modify MySQL Configuration

1. **Update `docker-compose.yml`:** Ensure that the MySQL server in your Docker setup uses the `mysql_native_password` authentication plugin. Modify your `docker-compose.yml` file like this:

   ```yaml
   version: '3.9'
   services:
     mysql:
       image: mysql:8.0.27
       container_name: mysql-micro
       ports:
         - "3307:3306"
       environment:
         MYSQL_ROOT_PASSWORD: mysql
         MYSQL_ROOT_HOST: '%'
       command: --default-authentication-plugin=mysql_native_password
       volumes:
         - ./docker/mysql/data:/var/lib/mysql
   ```

2. **Recreate the Container:**
   Run the following commands in your terminal to stop and remove any existing container, then recreate it:

   ```bash
   docker-compose down -v
   docker-compose up -d
   ```

### Step 2: Connect MySQL Workbench

1. **Open MySQL Workbench:**
   Launch MySQL Workbench.

2. **Create a New Connection:**
   - Click on the "+" icon next to "MySQL Connections" to create a new connection.
   - In the connection settings:
     - **Connection Name:** Any name you prefer.
     - **Connection Method:** Standard (TCP/IP).
     - **Hostname:** `127.0.0.1`.
     - **Port:** `3307`.
     - **Username:** `root`.
     - **Password:** Click "Store in Vault..." and enter `mysql`.

3. **Test Connection:**
   - Click on "Test Connection." If everything is set up correctly, you should see a success message.

### Step 3: Verify Authentication Method

If you still face issues, log into your MySQL container and check the authentication method used by the root user:

1. **Access MySQL Container:**

   ```bash
   docker exec -it mysql-micro mysql -u root -p
   ```

2. **Run the following SQL command:**

   ```sql
   SELECT User, Host, plugin FROM mysql.user WHERE User = 'root';
   ```

   Make sure that the plugin for `root` is set to `mysql_native_password`. If it's still set to `caching_sha2_password`, run the following command:

   ```sql
   ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'mysql';
   FLUSH PRIVILEGES;
   ```

### Additional Tips

- Ensure that no other MySQL services are running on port 3307 or 3306 that might conflict with your Docker MySQL instance.
- If using a firewall or security software, ensure that it allows connections to port 3307.

### What is Flyway?

**Flyway** is an open-source database migration tool that allows developers to manage schema changes in relational databases. It is especially useful in microservices architectures where multiple services may require different database schemas. Flyway helps ensure that all database changes are versioned, repeatable, and easily manageable.

### Key Features of Flyway

1. **Version Control for Database Migrations**:
   - Flyway allows you to track changes to your database schema using versioned migration scripts. Each script is associated with a version number, enabling you to apply changes in a controlled manner.

2. **Support for Multiple Databases**:
   - Flyway supports a wide range of databases, including PostgreSQL, MySQL, Oracle, SQL Server, and more. This flexibility is vital in microservices architectures where different services might use different databases.

3. **Repeatable Migrations**:
   - In addition to versioned migrations, Flyway allows for repeatable migrations, which can be reapplied every time changes are detected. This is useful for data transformations or non-structural changes.

4. **Rollback Support**:
   - While Flyway primarily focuses on forward migrations, you can manually create rollback scripts to revert changes if needed.

5. **Integration with Build Tools**:
   - Flyway can easily integrate with build tools like Maven, Gradle, or as part of CI/CD pipelines, automating the deployment of database migrations.

6. **Java-based Migration**:
   - Migrations can be defined in SQL or Java. This allows for flexibility and the ability to handle complex migrations programmatically.

7. **Easy Monitoring and Control**:
   - Flyway maintains a metadata table in the database to track applied migrations, making it easy to monitor the state of your database schema.

### Why Use Flyway in Microservices?

1. **Decentralized Development**:
   - In microservices, different teams often work on different services. Flyway allows each team to manage their database migrations independently while still maintaining a consistent approach.

2. **Automated Deployments**:
   - When deploying microservices, it's crucial to ensure that the database schema is updated correctly. Flyway can automate these updates as part of the deployment process, reducing the risk of manual errors.

3. **Versioning and Rollback**:
   - With multiple services, keeping track of different versions of database schemas can be challenging. Flyway’s versioning system simplifies this, and having rollback capabilities helps handle issues that may arise after deployment.

4. **Ease of Use**:
   - Flyway's command-line interface and API make it easy for developers to apply migrations, check the status of migrations, and handle versioning without needing deep knowledge of SQL.

### How Flyway Works

1. **Migration Scripts**:
   - Migration scripts are typically stored in a directory within the application, named in a specific format (e.g., `V1__Initial_setup.sql`). The format includes a version number and a description.
   - Scripts can be written in SQL or Java, depending on the complexity of the migration.

2. **Database Metadata Table**:
   - Flyway creates a metadata table (`flyway_schema_history`) in the database. This table keeps track of applied migrations, their version numbers, descriptions, and checksums.

3. **Executing Migrations**:
   - When you run Flyway (either via command line, build tool, or programmatically), it checks the metadata table to see which migrations have already been applied.
   - It then executes any new migration scripts in the order of their version numbers.

4. **Error Handling**:
   - If a migration fails, Flyway stops the process and leaves the database in a consistent state, allowing developers to investigate and fix issues before retrying.

### Example Workflow in a Microservices Environment

1. **Define Migrations**:
   - A developer creates a migration script for a new feature in their microservice. The script is named `V1__Create_users_table.sql`.

2. **Version Control**:
   - The migration script is committed to version control alongside the service code.

3. **Run Migrations**:
   - During the CI/CD pipeline, Flyway is invoked to apply the migration to the database before deploying the microservice.

4. **Monitor and Rollback**:
   - After deployment, if issues are detected, the team can either fix the migration script and reapply it or create a rollback script to revert the changes.

### Conclusion

Flyway provides a robust and efficient way to manage database migrations in microservices architectures. By offering features such as version control, repeatable migrations, and easy integration into deployment processes, it helps teams maintain consistency across their database schemas while allowing for the flexibility required in a microservices environment. This leads to better collaboration, reduced deployment risks, and a smoother development workflow.
