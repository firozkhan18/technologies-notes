A complete, ready-to-go project prompt for your microservices shop system — including 4 services (Shop, Product, Inventory, Order), shared libs, H2 database, WebClient internal calls, Docker support, plus example APIs and flows.

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

### Product Service

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

If you want, I can start generating **full code files** for all services + libs with this prompt or create a ready-to-go GitHub repo zip with all files included. Just say theetemptmpt
