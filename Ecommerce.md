Serviceicemplete, ready-to-go project prompt for your microservices shop system — including 4 services (Shop, Product, Inventory, Order), shared libs, H2 database, WebClient internal calls, Docker support, plus example APIs and flows.

---

# Complete Project Prompt for Microservices Shop System

---

## Project Overview

Build a microservices-based Shop Management System composed of 4 independent Spring Boot services, each with its own embedded H2 database:

* **shop-service**: Manages shops (create, retrieve)
* **product-service**: Manages products linked to shops
* **inventory-service**: Manages inventory stock per product per shop
* **order-service**: Manages orders, validates stock & reduces inventory

---

## Architecture and Communication

* Each service is an independent Spring Boot app with REST APIs.
* Services use embedded **H2 databases** for persistence.
* Internal communication between services is done via **Spring WebClient** (reactive HTTP clients).
* Shared DTOs and data classes are defined in a **common-lib**.
* WebClient wrappers for calling services live in a **rest-client-lib**.
* Each service can be packaged and run independently or via Docker.
* Ready for extension to Kubernetes/Docker Compose orchestration.

---

## Service Details

### 1. Shop Service (`shop-service`)

* Port: 8080
* API:

  * `POST /api/shops`: Create a shop
  * `GET /api/shops/{id}`: Retrieve shop details
* Data:

  * Shop: `id` (string), `name`, `address`
* Persistence: H2 database with table `shop`

---

### 2. Product Service (`product-service`)

* Port: 8081
* API:

  * `POST /api/products`: Create a product with `shopId` association
  * `GET /api/products/{id}`: Retrieve product details
* Data:

  * Product: `id` (string), `name`, `description`, `shopId`
* Persistence: H2 database with table `product`

---

### 3. Inventory Service (`inventory-service`)

* Port: 8082
* API:

  * `POST /api/inventory`: Add/update inventory (productId, shopId, quantity)
  * `GET /api/inventory/{shopId}/{productId}`: Get current stock
  * `POST /api/inventory/reduce`: Reduce stock atomically for order fulfillment
* Data:

  * Inventory composite key: `(productId, shopId)`
  * Quantity (int)
* Persistence: H2 database with composite key table `inventory`

---

### 4. Order Service (`order-service`)

* Port: 8083
* API:

  * `POST /api/orders`: Place an order (shopId, productId, quantity)
  * `GET /api/orders/{id}`: Get order details
* Workflow:

  * Verify shop exists (call Shop Service)
  * Verify product exists and belongs to shop (call Product Service)
  * Check inventory stock (call Inventory Service)
  * If sufficient stock, reduce inventory (call Inventory Service)
  * Persist order in local H2 DB
* Data:

  * Order: `id` (auto), `shopId`, `productId`, `quantity`, `status`
* Persistence: H2 database with `order` table

---

## Libraries

### common-lib

* DTO classes shared between services and clients (e.g., OrderRequest, InventoryResponse)

### rest-client-lib

* WebClient wrappers for communicating with Shop, Product, Inventory services from Order service or others

---

## Database Setup

* All services use **in-memory H2 database** with `spring.jpa.hibernate.ddl-auto=update`.
* Sample data loaded via `data.sql` scripts in each service for demo/testing.
* Schema generated via JPA entities.

---

## Inter-Service Communication

* Services communicate via REST over HTTP.
* Use Spring WebClient inside `rest-client-lib` for reactive HTTP calls.
* URLs and ports configured in each service’s `application.yml` or `application.properties`.

---

## Docker Support

* Each service includes a simple `Dockerfile` for containerization.
* Ready to build and run containers individually or orchestrated.

---

## Example Use Case Flow

### Place an Order

1. Client calls `order-service POST /api/orders` with `{shopId, productId, quantity}`
2. `order-service`:

   * Calls `shop-service GET /api/shops/{shopId}` to verify shop
   * Calls `product-service GET /api/products/{productId}` to verify product belongs to shop
   * Calls `inventory-service GET /api/inventory/{shopId}/{productId}` to check stock
   * Calls `inventory-service POST /api/inventory/reduce` to reduce stock if available
   * Saves order locally with status "PLACED"
3. Returns order confirmation

---

## Example API Endpoints

### Shop Service

```bash
POST /api/shops
GET /api/shops/{id}
```

### Propromptervice

```bash
POST /api/products
GET /api/products/{id}
```

### Inventory Service

```bash
POST /api/inventory
GET /api/inventory/{shopId}/{productId}
POST /api/inventory/reduce
```

### Order Service

```bash
POST /api/orders
GET /api/orders/{id}
```

---

## Example Curl Commands

```bash
curl -X POST http://localhost:8080/api/shops \
-H "Content-Type: application/json" \
-d '{"id":"shop-1","name":"Main Shop","address":"123 Main St"}'

curl -X POST http://localhost:8081/api/products \
-H "Content-Type: application/json" \
-d '{"id":"prod-1","name":"iPhone","description":"Latest","shopId":"shop-1"}'

curl -X POST http://localhost:8082/api/inventory \
-H "Content-Type: application/json" \
-d '{"id":{"productId":"prod-1","shopId":"shop-1"},"quantity":100}'

curl -X POST http://localhost:8083/api/orders \
-H "Content-Type: application/json" \
-d '{"shopId":"shop-1","productId":"prod-1","quantity":5}'
```

---

## Deliverables

* Complete Java source code for all services and libraries with packages:

  * Models, Repositories, Services, Controllers, Clients
* Configuration files (`application.yml`) with ports and H2 setup
* Sample data scripts (`data.sql`) for demo content
* Dockerfiles for all services
* README with build and run instructions
* Optional: Docker Compose file to run all services locally

---

## Optional Extensions (Future)

* Add Swagger/OpenAPI for API docs
* Add Spring Security for authentication/authorization
* Integrate distributed tracing (e.g., Zipkin)
* Use external database (Postgres) instead of H2
* Kubernetes manifests for deployment

---

Here’s a full project structure with all 4 services + common-lib + rest-client-lib, including Dockerfiles, ready for you to start coding and running locally or containerized.

---

# Project Structure

```
microservices-shop/
├── common-lib/
│   └── src/main/java/com/example/common/dto/
│       ├── InventoryResponse.java
│       └── OrderRequest.java
├── rest-client-lib/
│   └── src/main/java/com/example/restclient/clients/
│       ├── InventoryClient.java
│       ├── ProductClient.java
│       └── ShopClient.java
├── shop-service/
│   ├── src/main/java/com/example/shop/
│   │   ├── model/Shop.java
│   │   ├── repository/ShopRepository.java
│   │   ├── service/ShopService.java
│   │   └── controller/ShopController.java
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── data.sql
│   └── Dockerfile
├── product-service/
│   ├── src/main/java/com/example/product/
│   │   ├── model/Product.java
│   │   ├── repository/ProductRepository.java
│   │   ├── service/ProductService.java
│   │   └── controller/ProductController.java
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── data.sql
│   └── Dockerfile
├── inventory-service/
│   ├── src/main/java/com/example/inventory/
│   │   ├── model/Inventory.java
│   │   ├── model/InventoryKey.java
│   │   ├── repository/InventoryRepository.java
│   │   ├── service/InventoryService.java
│   │   └── controller/InventoryController.java
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── data.sql
│   └── Dockerfile
├── order-service/
│   ├── src/main/java/com/example/order/
│   │   ├── model/Order.java
│   │   ├── repository/OrderRepository.java
│   │   ├── service/OrderService.java
│   │   └── controller/OrderController.java
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── application.properties  # for WebClient URLs
│   └── Dockerfile
└── README.md
```

---

# Sample Dockerfile for each service

**Example (shop-service/Dockerfile):**

```dockerfile
FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/shop-service.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

---

# Sample README.md (top level)

````markdown
# Microservices Shop Example

## Services

- shop-service (port 8080)
- product-service (port 8081)
- inventory-service (port 8082)
- order-service (port 8083)

## Build & Run

Each service is a Spring Boot application with embedded H2 database.

Build all with Maven:

```bash
./mvnw clean package
````

Run services individually:

```bash
java -jar shop-service/target/shop-service.jar
java -jar product-service/target/product-service.jar
java -jar inventory-service/target/inventory-service.jar
java -jar order-service/target/order-service.jar
```

Or run Docker images (build with Dockerfile):

```bash
docker build -t shop-service ./shop-service
docker run -p 8080:8080 shop-service
# similarly for others...
```

## Usage

Use the API endpoints to create shops, products, inventory, and place orders.

Example curl commands:

```bash
curl -X POST http://localhost:8080/api/shops -H "Content-Type: application/json" -d '{"id":"shop-1","name":"Main Shop","address":"123 Main St"}'

curl -X POST http://localhost:8081/api/products -H "Content-Type: application/json" -d '{"id":"prod-1","name":"iPhone","description":"Latest","shopId":"shop-1"}'

curl -X POST http://localhost:8082/api/inventory -H "Content-Type: application/json" -d '{"id":{"productId":"prod-1","shopId":"shop-1"},"quantity":100}'

curl -X POST http://localhost:8083/api/orders -H "Content-Type: application/json" -d '{"shopId":"shop-1","productId":"prod-1","quantity":5}'
```

---

```

---

# Next Steps for You

- Let me know if you want me to generate all Java source files fully here or package as a GitHub repo archive.
- I can also help write a Docker Compose file to run all 4 services together.
- Or add more features like Swagger docs, monitoring, etc.

---

Would you like me to **generate the full Java source files for all 4 services + libs here**, or provide a **ready GitHub repo zip**, or **Docker Compose** next?
```


Alright! This is a solid full-stack microservices setup with:

* **4 services**: shop, product, inventory, order
* Full entities, controllers, repos, services
* Inter-service communication via WebClient
* H2 in-memory DB for each
* Sample API definitions and example calls
* Sample data SQL scripts

I'll break this down service-by-service with code snippets and explanations. To keep things manageable, I’ll do the core classes and configs. You can later extend or customize.

---

# 1. shop-service

---

### Entity: Shop

```java
package com.example.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Shop {
    @Id
    private String id;
    private String name;
    private String address;
}
```

---

### Repository:

```java
package com.example.shop.repository;

import com.example.shop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, String> {}
```

---

### Service:

```java
package com.example.shop.service;

import com.example.shop.model.Shop;
import com.example.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public Optional<Shop> findById(String id) {
        return shopRepository.findById(id);
    }

    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }
}
```

---

### Controller:

```java
package com.example.shop.controller;

import com.example.shop.model.Shop;
import com.example.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable String id) {
        return shopService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop saved = shopService.save(shop);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Shop> getAllShops() {
        return shopService.shopRepository.findAll();
    }
}
```

---

### application.yml

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:shopdb
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

---

### Sample data (`data.sql`)

```sql
INSERT INTO SHOP (id, name, address) VALUES ('shop-1', 'Main Shop', '123 Main St');
INSERT INTO SHOP (id, name, address) VALUES ('shop-2', 'Second Shop', '456 Side St');
```

---

# 2. product-service

---

### Entity: Product

```java
package com.example.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private String shopId;  // FK reference to Shop
}
```

---

### Repository

```java
package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByShopId(String shopId);
}
```

---

### Service

```java
package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> findByShopId(String shopId) {
        return productRepository.findByShopId(shopId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
```

---

### Controller

```java
package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/shop/{shopId}")
    public List<Product> getProductsByShop(@PathVariable String shopId) {
        return productService.findByShopId(shopId);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product saved = productService.save(product);
        return ResponseEntity.ok(saved);
    }
}
```

---

### application.yml

```yaml
server:
  port: 8081

spring:
  datasource:
    url: jdbc:h2:mem:productdb
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

---

### Sample data (`data.sql`)

```sql
INSERT INTO PRODUCT (id, name, description, shop_id) VALUES ('prod-1', 'Apple iPhone', 'Latest iPhone', 'shop-1');
INSERT INTO PRODUCT (id, name, description, shop_id) VALUES ('prod-2', 'Samsung Galaxy', 'Latest Galaxy', 'shop-1');
INSERT INTO PRODUCT (id, name, description, shop_id) VALUES ('prod-3', 'Dell Laptop', 'High performance', 'shop-2');
```

---

# 3. inventory-service

---

### Composite Key Class (InventoryKey.java)

```java
package com.example.inventory.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InventoryKey implements Serializable {
    private String productId;
    private String shopId;

    public InventoryKey() {}

    public InventoryKey(String productId, String shopId) {
        this.productId = productId;
        this.shopId = shopId;
    }

    // equals & hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryKey)) return false;
        InventoryKey that = (InventoryKey) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(shopId, that.shopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, shopId);
    }

    // getters/setters
}
```

---

### Entity: Inventory.java

```java
package com.example.inventory.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Inventory {

    @EmbeddedId
    private InventoryKey id;

    private int quantity;
}
```

---

### Repository

```java
package com.example.inventory.repository;

import com.example.inventory.model.Inventory;
import com.example.inventory.model.InventoryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, InventoryKey> {}
```

---

### Service

```java
package com.example.inventory.service;

import com.example.inventory.model.Inventory;
import com.example.inventory.model.InventoryKey;
import com.example.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public Optional<Inventory> getInventory(String productId, String shopId) {
        return inventoryRepository.findById(new InventoryKey(productId, shopId));
    }

    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public void reduceStock(String productId, String shopId, int amount) {
        InventoryKey key = new InventoryKey(productId, shopId);
        Inventory inv = inventoryRepository.findById(key)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
        if (inv.getQuantity() < amount) throw new RuntimeException("Not enough stock");
        inv.setQuantity(inv.getQuantity() - amount);
        inventoryRepository.save(inv);
    }
}
```

---

### Controller

```java
package com.example.inventory.controller;

import com.example.inventory.model.Inventory;
import com.example.inventory.model.InventoryKey;
import com.example.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{shopId}/{productId}")
    public ResponseEntity<Inventory> getInventory(@PathVariable String shopId, @PathVariable String productId) {
        Optional<Inventory> inventory = inventoryService.getInventory(productId, shopId);
        return inventory.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inventory> createOrUpdateInventory(@RequestBody Inventory inventory) {
        Inventory saved = inventoryService.save(inventory);
        return ResponseEntity.ok(saved);
    }
}
```

---

### application.yml

```yaml
server:
  port: 8082

spring:
  datasource:
    url: jdbc:h2:mem:inventorydb
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

---

### Sample data (`data.sql`)

```sql
INSERT INTO INVENTORY (product_id, shop_id, quantity) VALUES ('prod-1', 'shop-1', 100);
INSERT INTO INVENTORY (product_id, shop_id, quantity) VALUES ('prod-2', 'shop-1', 50);
INSERT INTO INVENTORY (product_id, shop_id, quantity) VALUES ('prod-3', 'shop-2', 30);
```

---

# 4. order-service

---

### Entity: Order.java

```java
package com.example.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shopId;

    private String productId;

    private int quantity;

    private LocalDateTime orderDate;
}
```

---

### Repository

```java
package com.example.order.repository;

import com.example.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
```

---

### Service

```java
package com.example.order.service;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import com.example.restclient.clients.InventoryClient;
import com.example.restclient.clients.ShopClient;
import com.example.restclient.clients.ProductClient;
import com.example.common.dto.InventoryResponse;
import com.example.common.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final InventoryClient inventoryClient;
    private final ShopClient shopClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    public Mono<String> placeOrder(OrderRequest orderRequest) {
        return Mono.zip(
                shopClient.getShop(orderRequest.shopId()),
                productClient.getProduct(orderRequest.productId())
        ).flatMap(tuple -> {
            if (tuple.getT1() == null) return Mono.error(new RuntimeException("Shop not found"));
            if (tuple.getT2() == null) return Mono.error(new RuntimeException("Product not found"));

            return inventoryClient.checkStock(orderRequest.productId(), orderRequest.shopId())
                    .flatMap(inventoryResponse -> {
                        if (inventoryResponse.availableQuantity() >= orderRequest.quantity()) {
                            // reduce stock (call inventory-service to update)
                            return inventoryClient.reduceStock(orderRequest.productId(), orderRequest.shopId(), orderRequest.quantity())
                                    .map(v -> {
                                        Order order = new Order();
                                        order.setShopId(orderRequest.shopId());
                                        order.setProductId(orderRequest.productId());
                                        order.setQuantity(orderRequest.quantity());
                                        order.setOrderDate(LocalDateTime.now());
                                        Order saved = orderRepository.save(order);
                                        return saved.getId().toString();
                                    });
                        } else {
                            return Mono.error(new RuntimeException("Insufficient stock"));
                        }
                    });
        });
    }
}
```

---

### Controller

```java
package com.example.order.controller;

import com.example.common.dto.OrderRequest;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Mono<ResponseEntity<String>> createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest)
                .map(id -> ResponseEntity.ok("Order created with ID: " + id))
                .onErrorResume(ex -> Mono.just(ResponseEntity.badRequest().body(ex.getMessage
```


())));
}
}

````

---

### application.yml

```yaml
server:
  port: 8083

spring:
  datasource:
    url: jdbc:h2:mem:orderdb
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

spring:
  main:
    web-application-type: reactive  # For WebClient/reactive support
````

---

# Common Library (common-lib)

---

Define shared DTOs and possibly exceptions.

### DTO: OrderRequest.java

```java
package com.example.common.dto;

public record OrderRequest(String shopId, String productId, int quantity) {}
```

### DTO: InventoryResponse.java

```java
package com.example.common.dto;

public record InventoryResponse(String productId, String shopId, int availableQuantity) {}
```

---

# REST Client Library (rest-client-lib)

---

Implement WebClient-based clients for inter-service calls:

---

### InventoryClient.java

```java
package com.example.restclient.clients;

import com.example.common.dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class InventoryClient {

    private final WebClient webClient;

    public InventoryClient(@Value("${inventory.service.url}") String baseUrl) {
        this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    }

    public Mono<InventoryResponse> checkStock(String productId, String shopId) {
        return webClient.get()
                .uri("/api/inventory/{shopId}/{productId}", shopId, productId)
                .retrieve()
                .bodyToMono(InventoryResponse.class);
    }

    public Mono<Void> reduceStock(String productId, String shopId, int amount) {
        return webClient.post()
                .uri("/api/inventory/reduce")
                .bodyValue(new ReduceStockRequest(productId, shopId, amount))
                .retrieve()
                .bodyToMono(Void.class);
    }

    private record ReduceStockRequest(String productId, String shopId, int amount) {}
}
```

---

### ShopClient.java

```java
package com.example.restclient.clients;

import com.example.shop.model.Shop;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ShopClient {

    private final WebClient webClient;

    public ShopClient(@Value("${shop.service.url}") String baseUrl) {
        this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    }

    public Mono<Shop> getShop(String shopId) {
        return webClient.get()
                .uri("/api/shops/{id}", shopId)
                .retrieve()
                .bodyToMono(Shop.class)
                .onErrorReturn(null);
    }
}
```

---

### ProductClient.java

```java
package com.example.restclient.clients;

import com.example.product.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ProductClient {

    private final WebClient webClient;

    public ProductClient(@Value("${product.service.url}") String baseUrl) {
        this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    }

    public Mono<Product> getProduct(String productId) {
        return webClient.get()
                .uri("/api/products/{id}", productId)
                .retrieve()
                .bodyToMono(Product.class)
                .onErrorReturn(null);
    }
}
```

---

# Additional notes

* For **InventoryService**, add `/api/inventory/reduce` POST endpoint to reduce stock atomically.

* Each service runs on its own port:

  * shop-service: 8080
  * product-service: 8081
  * inventory-service: 8082
  * order-service: 8083

* In `order-service`’s `application.yml`, set the base URLs of other services via environment or properties:

```yaml
inventory:
  service:
    url: http://localhost:8082

shop:
  service:
    url: http://localhost:8080

product:
  service:
    url: http://localhost:8081
```

---

# Example API calls

---

**Create a shop**

```bash
curl -X POST http://localhost:8080/api/shops -H "Content-Type: application/json" -d '{"id":"shop-1","name":"Main Shop","address":"123 Main St"}'
```

---

**Create a product**

```bash
curl -X POST http://localhost:8081/api/products -H "Content-Type: application/json" -d '{"id":"prod-1","name":"iPhone","description":"Latest","shopId":"shop-1"}'
```

---

**Add inventory**

```bash
curl -X POST http://localhost:8082/api/inventory -H "Content-Type: application/json" -d '{"id":{"productId":"prod-1","shopId":"shop-1"},"quantity":100}'
```

---

**Place an order**

```bash
curl -X POST http://localhost:8083/api/orders -H "Content-Type: application/json" -d '{"shopId":"shop-1","productId":"prod-1","quantity":5}'
```

---

































