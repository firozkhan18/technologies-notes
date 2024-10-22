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

