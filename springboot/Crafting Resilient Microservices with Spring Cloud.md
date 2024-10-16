**Crafting Resilient Microservices with Spring Cloud**: Eureka, Config Server, Zuul, Kafka, Sleuth, Zipkin, and Resilience4j

**You are currently viewing Crafting Resilient Microservices with Spring Cloud**: Eureka, Config Server, Zuul, Kafka, Sleuth, Zipkin, and Resilience4j

## Introduction
Microservices architecture has become increasingly popular in modern  software development due to its ability to create scalable, maintainable, and flexible systems. Unlike traditional monolithic architectures, where an entire  application is built as a single unit, microservices architecture breaks down an  application into smaller, independent services that can be developed, deployed, and scaled independently. Each service focuses on a specific business function and communicates with other services through well-defined APIs.

## Overview of Microservices Architecture
In a microservices architecture, each service is designed to be small, loosely coupled, and independently deployable. Services can be developed using different technologies, programming languages, and databases, depending on the specific requirements of the service. Communication between services typically occurs over lightweight protocols such as HTTP/REST or messaging queues.

## Benefits of microservices architecture include:

Scalability: Individual services can be scaled independently based on demand, allowing for better resource utilization and cost optimization.
Flexibility: Services can be developed, deployed, and updated independently, enabling faster time-to-market and continuous delivery practices.
Resilience: Fault isolation ensures that failures in one service do not affect the entire system, improving overall system resilience.
Technology Diversity: Different services can use the most appropriate technologies for their specific requirements, promoting innovation and flexibility.
Simplified Maintenance: Smaller codebases and clear service boundaries make it easier to understand, maintain, and evolve the system over time.
Technologies Used

We will utilize a variety of technologies commonly associated with building microservices architectures. Some of the key technologies include:

 Spring Cloud: Provides a suite of tools and frameworks for building robust and scalable microservices  applications in the Java ecosystem.
Eureka: A service registry and discovery server used for enabling communication between microservices in a distributed system.
Zuul: An API gateway that provides dynamic routing, monitoring, resiliency, security, and more for microservices.
 Kafka: A distributed event streaming platform used for building real-time data pipelines and streaming  applications.
Config Server: Centralized configuration management tool that allows microservices to dynamically fetch configurations from a remote server.
 Spring Cloud Sleuth and Zipkin: Tools for distributed tracing, which help monitor and diagnose transactions across distributed systems.
 Spring Cloud Load Balancer: Client-side load balancer for distributing incoming requests among multiple instances of a service.
@RefreshScope: Annotation used in  Spring Boot applications to enable dynamic refreshing of configurations without restarting the application.
Using these technologies, we’ll demonstrate how to build, deploy, and manage a microservices architecture that is scalable, resilient, and easy to maintain.

## Order Service
## Project Structure
src/main/java/com/example/orderservice/: Java source files
src/main/resources/: Configuration files
src/test/: Test files
Entity Class: Order.java
import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    private double totalPrice;

    // Constructors, getters, and setters
}
Repository Interface: OrderRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
Service Class: OrderService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        // Implement order creation logic
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
Controller Class: OrderController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
 Application Properties:  application.properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/orders_db
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Eureka Configuration
spring.application.name=order-service
server.port=8082
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
This section provides the implementation details of the Order Service, including the project structure, entity class, repository interface, service class, controller class, and  application properties.

## Order Service
## Project Structure:


src/main/java/com/example/orderservice/: Java source files
src/main/resources/: Configuration files
src/test/: Test files
Entity Class: Order.java

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    private double totalPrice;

    // Constructors, getters, and setters
}
Repository Interface: OrderRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
Service Class: OrderService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        // Implement order creation logic
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
Controller Class: OrderController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
 Application Properties:  application.properties

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/orders_db
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Eureka Configuration
spring.application.name=order-service
server.port=8082
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
This section includes the project structure and source code for the Order Service, including the entity class, repository interface, service class, controller class, and  application properties.

## User Service
## Project Structure:

src/main/java/com/example/userservice/: Java source files
src/main/resources/: Configuration files
src/test/: Test files
Entity Class: User.java

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    // Constructors, getters, and setters
}
Repository Interface: UserRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
Service Class: UserService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
Controller Class: UserController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Check if username already exists
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().build();
        }

        // Create user
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
}
 Application Properties:  application.properties

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/users_db
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Eureka Configuration
spring.application.name=user-service
server.port=8083
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
This section provides the structure of the User Service project along with the source code for its entity, repository, service, and controller classes, as well as the application properties file.

## Setting Up Infrastructure Components
## Eureka Server
## Project Structure:

src/main/java/com/example/eurekaserver/: Java source files
src/main/resources/: Configuration files
src/test/: Test files
Main Class: EurekaServerApplication.java

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
 Application Properties:  application.properties

# Eureka Server Configuration
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
Zuul API Gateway
Project Structure:

src/main/java/com/example/apigateway/: Java source files
src/main/resources/: Configuration files
src/test/: Test files
Main Class: ApiGatewayApplication.java

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
Application Properties: application.properties

# Zuul Configuration
server.port=8765
spring.application.name=api-gateway
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
 Kafka Cluster
Installation: Follow the Kafka documentation for installation instructions.

## Configuration: Update Kafka configuration files as needed.


This setup ensures that you have a functioning Eureka Server for service registration and discovery, a Zuul API Gateway for routing requests, and a  Kafka Cluster for messaging.

## Integrating Infrastructure Components with Microservices
## Product Service

## Project Structure:

src/main/java/com/example/productservice/: Java source files
src/main/resources/: Configuration files
src/test/: Test files
Entity Class: Product.java

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    // Constructors, getters, and setters
}
Repository Interface: ProductRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
Service Class: ProductService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
Controller Class: ProductController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Controller methods

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        // Send message to Kafka
        productProducer.sendMessage("New product created: " + createdProduct.getId());
        return ResponseEntity.ok(createdProduct);
    }
}
 Kafka Producer Class: ProductProducer.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("product-topic", message);
    }
}
 Application Properties:  application.properties

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/products_db
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Eureka Configuration
spring.application.name=product-service
server.port=8081
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

# Kafka Configuration
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=product-group
spring.kafka.consumer.auto-offset-reset=earliest

spring.kafka.producer.bootstrap-servers=localhost:9092
This integration enables the Product Service to produce messages to Kafka, which can be consumed by other microservices in the architecture, and utilize Eureka for service discovery.

## Order Service Integration with Eureka and Kafka
## Order Service

## Project Structure:

src/main/java/com/example/orderservice/: Java source files
src/main/resources/: Configuration files
src/test/: Test files
Entity Class: Order.java

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    private double totalPrice;

    // Constructors, getters, and setters
}
Repository Interface: OrderRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
Service Class: OrderService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        // Implement order creation logic
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
Controller Class: OrderController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);

        // Send message to Kafka
        kafkaTemplate.send("order-topic", "New order created: " + createdOrder.getId());

        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
 Application Properties:  application.properties

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/orders_db
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Eureka Configuration
spring.application.name=order-service
server.port=8082
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

# Kafka Configuration
spring.kafka.producer.bootstrap-servers=localhost:9092
This integration enables the Order Service to register with Eureka for service discovery and produce messages to  Kafka for asynchronous communication.

## User Service Integration with Eureka and  Kafka
## User Service

## Kafka Configuration:

Add Kafka Dependencies: Include the Kafka dependencies in the pom.xml of the User Service:
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
Configure Kafka in application.properties:
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=user-group
spring.kafka.consumer.auto-offset-reset=earliest

spring.kafka.producer.bootstrap-servers=localhost:9092
Kafka Consumer Class: UserConsumer.java

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @KafkaListener(topics = "user-topic", groupId = "user-group")
    public void consume(String message) {
        // Implement message consumption logic
        System.out.println("Consumed message: " + message);
    }
}
Kafka Producer Class: UserProducer.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("user-topic", message);
    }
}
User Controller Class: UserController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserProducer userProducer;

    // Controller methods

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        // Send message to Kafka
        userProducer.sendMessage("New user created: " + createdUser.getId());
        return ResponseEntity.ok(createdUser);
    }
}
 Application Properties:  application.properties

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/users_db
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Eureka Configuration
spring.application.name=user-service
server.port=8083
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

# Kafka Configuration
spring.kafka.consumer.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=user-group
spring.kafka.consumer.auto-offset-reset=earliest

spring.kafka.producer.bootstrap-servers=localhost:9092
This integration enables the User Service to consume and produce messages with Kafka, enhancing the communication capabilities of the microservices architecture.

## Config Server
## Project Structure
src/main/java/com/example/configserver/: Java source files
src/main/resources/: Configuration files
Main Class: ConfigServerApplication.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
 Application Properties:  application.properties
spring.application.name=config-server
server.port=8888

# Git repository configuration
spring.cloud.config.server.git.uri=https://github.com/your-username/config-repo.git
Replace https://github.com/your-username/config-repo.git with the URL of your Git repository containing configuration files.

## Creating Configuration Files
Product Service Configuration: Create a file named product-service.yml in your Git repository with configurations specific to the Product Service:
server:
  port: 8081

spring:
  application:
    name: product-service

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka
Order Service Configuration: Similarly, create a file named order-service.yml with configurations for the Order Service:
server:
  port: 8082

spring:
  application:
    name: order-service

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka
User Service Configuration: Create a file named user-service.yml for the User Service configuration:
server:
  port: 8083

spring:
  application:
    name: user-service

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka
These configuration files will be served by the Config Server to respective microservices upon request.

This setup allows for centralized configuration management, making it easier to manage and update configurations across multiple microservices.

## Distributed Tracing with  Spring Cloud Sleuth and Zipkin
## Project Structure
src/main/java/com/example/zipkinserver/: Java source files
src/main/resources/: Configuration files
Main Class: ZipkinServerApplication.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
 Application Properties:  application.properties
spring.application.name=zipkin-server
server.port=9411
This configuration sets up the Zipkin server  application to enable distributed tracing in the microservices ecosystem. Requests and traces will be collected and displayed for analysis in the Zipkin dashboard.

## Integrating Circuit Breaker for Resilience
1. pom.xml:

<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Data JPA Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Spring Cloud Starter Circuit Breaker Resilience4j -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
    </dependency>
    <dependency>
        <groupId>io.github.resilience4j</groupId>
        <artifactId>resilience4j-spring-boot2</artifactId>
    </dependency>

    <!-- Spring Boot Starter Test -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
2. application.properties:

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.application.name=product-service
server.port=8081

resilience4j.circuitbreaker.instances.productService.registerHealthIndicator=true
3. Product.java:

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    // Constructors, getters, and setters
}
4. ProductRepository.java:

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
5. ProductService.java:

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @CircuitBreaker(name = "productService")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
6. CircuitBreakerConfiguration.java:

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@Configuration
public class CircuitBreakerConfiguration {

    @Bean
    @Primary
    public Customizer<CircuitBreakerConfig> customizer() {
        return CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .slidingWindowSize(5)
                .build();
    }
}
7. ProductController.java:

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
With these files, you have the full source code for integrating circuit breaker into the Product Service using  Spring Cloud Circuit Breaker and Resilience4j.


## Starting Infrastructure Components
## Eureka Server

To start the Eureka Server, navigate to the directory containing the Eureka Server application and run the following command:

java -jar eureka-server.jar
## Config Server

To start the Config Server, navigate to the directory containing the Config Server  application and run the following command:

java -jar config-server.jar
 Kafka Cluster

Ensure that  Kafka is installed and running on your system. You can start Kafka using the following command:

bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
## Starting Microservices
## Product Service

To start the Product Service, navigate to the directory containing the Product Service  application and run the following command:

java -jar product-service.jar
## Order Service

To start the Order Service, navigate to the directory containing the Order Service application and run the following command:

java -jar order-service.jar
## User Service

To start the User Service, navigate to the directory containing the User Service application and run the following command:

java -jar user-service.jar
## Starting Zuul API Gateway
To start the Zuul API Gateway, navigate to the directory containing the Zuul API Gateway  application and run the following command:

java -jar zuul-api-gateway.jar
## Starting Zipkin Server
To start the Zipkin Server, navigate to the directory containing the Zipkin Server application and run the following command:

java -jar zipkin-server.jar
## Testing Microservices
Access the Eureka Dashboard (http://localhost:8761) to ensure that all microservices are registered.
Use Postman or any REST client to send requests to the microservices via the Zuul API Gateway.
Monitor traces and logs in the Zipkin dashboard (http://localhost:9411) to observe distributed tracing.
## Conclusion

We’ve explored various aspects of building a microservices-based  application using  Spring Cloud and associated technologies. We began by setting up the infrastructure components such as Eureka Server for service discovery, Config Server for centralized configuration management, and Zipkin Server for distributed tracing.

Next, we developed three microservices: Product Service, Order Service, and User Service, each responsible for specific functionalities within the  application. These microservices were registered with Eureka for service discovery and utilized Config Server for externalized configuration management.


We integrated Zuul API Gateway to provide a single entry point for clients to access the microservices and route requests accordingly. Additionally, we incorporated  Spring Cloud Sleuth and Zipkin for distributed tracing, enabling us to monitor and analyze the flow of requests across microservices.

Furthermore, we implemented dynamic configuration refresh using  Spring Cloud Config and demonstrated how changes in the centralized configuration repository can be propagated to running microservices without requiring a restart.

To enhance resilience and fault tolerance, we integrated circuit breaker patterns using Spring Cloud Circuit Breaker and Resilience4j, ensuring the stability of the  application under failure conditions.

Finally, we secured our microservices endpoints using Spring Security and OAuth2, ensuring that only authenticated users can access protected resources.
