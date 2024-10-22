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

Feel free to expand or customize these components as per your project needs! If you have any specific questions or need further details, let me know!
