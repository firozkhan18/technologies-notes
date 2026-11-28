# Complete Real-Time Java & Spring Boot Interview Checklist

I'll organize the questions into interview-preparation topics, with questions only and no answers. You can use this as a revision tracker.

## 1. Microservices architecture

- [ ]Q1. Product Service is working, but Inventory Service is down. What should happen when a customer places an order?
# Scenario: Inventory Service reserves stock successfully, but Payment Service goes down. What happens?

This is a real-world microservices problem involving Saga Pattern, distributed transactions, eventual consistency, and compensating transactions.

## 1. Understand the scenario

Suppose a customer orders a mobile phone worth ₹50,000.

We have four microservices:

- Order Service
- Inventory Service
- Payment Service
- Notification Service

The flow is:

1. Customer places order
   SuccessOrder Service creates order with `PENDING` status.
2. Inventory Service reserves stock
   SuccessOne mobile phone is reserved.
3. Payment Service processes payment
   FailedPayment Service is unavailable.
4. Compensating transaction
   Release the reserved inventory.
5. Update order status
   Set order status to `PAYMENT_FAILED` or `CANCELLED`.
6. Notify customer
   Inform the customer that payment could not be completed.

## 2. How do we implement this using Saga Pattern?

Saga is a sequence of local transactions. If one transaction fails, previously completed transactions are compensated.

| Service | Action | Result |
| --- | --- | --- |
| Order | Create order | Success |
| Inventory | Reserve stock | Success |
| Payment | Process payment | Failure |
| Inventory | Release stock | Compensation |
| Order | Cancel order | Compensation |

Important: We don't use one `@Transactional` transaction across all microservices. Each service manages its own local database transaction.

## 3. Spring Boot implementation example

Let's implement a simplified orchestration-based Saga.

### Step 1: Order Service

java

```java
@Service
public class OrderService {

    private final InventoryClient inventoryClient;
    private final PaymentClient paymentClient;
    private final OrderRepository orderRepository;

    public OrderService(
            InventoryClient inventoryClient,
            PaymentClient paymentClient,
            OrderRepository orderRepository) {

        this.inventoryClient = inventoryClient;
        this.paymentClient = paymentClient;
        this.orderRepository = orderRepository;
    }

    public String placeOrder(OrderRequest request) {

        Order order = new Order();
        order.setStatus("PENDING");

        order = orderRepository.save(order);

        boolean reserved = inventoryClient.reserveStock(
                request.getProductId(),
                request.getQuantity(),
                order.getId()
        );

        if (!reserved) {
            order.setStatus("INVENTORY_FAILED");
            orderRepository.save(order);
            return "Inventory unavailable";
        }

        try {
            paymentClient.processPayment(
                    order.getId(),
                    request.getAmount()
            );

            order.setStatus("CONFIRMED");
            orderRepository.save(order);

            return "Order confirmed";

        } catch (Exception ex) {

            inventoryClient.releaseStock(
                    request.getProductId(),
                    request.getQuantity(),
                    order.getId()
            );

            order.setStatus("PAYMENT_FAILED");
            orderRepository.save(order);

            return "Payment failed. Inventory released.";
        }
    }
}
```

This is an illustrative synchronous implementation. A production implementation should persist Saga progress, use idempotent commands, and recover from failures during compensation.

### Step 2: Inventory Service

java

```java
@Service
public class InventoryService {

    public void reserveStock(Long productId, int quantity) {
        // Check available stock
        // Reduce available quantity
        // Record reservation against order ID
    }

    public void releaseStock(Long productId, int quantity) {
        // Release reservation
        // Restore available quantity
    }
}
```

### Step 3: Payment Service

java

```java
@Service
public class PaymentService {

    public void processPayment(
            Long orderId,
            Double amount) {

        // Validate payment request
        // Process payment
        // Save payment transaction
    }
}
```

## 4. What if Inventory Service is also unavailable during compensation?

This is an important senior-level follow-up.

Suppose:

1. Inventory successfully reserves stock.
2. Payment fails.
3. Order Service tries to release inventory.
4. Inventory Service is also unavailable.

Now we have a distributed consistency problem.

Solution:

- Keep the order in `COMPENSATION_PENDING` status.
- Persist the compensation command.
- Retry releasing inventory using Kafka or a durable retry mechanism.
- Use an idempotency key so inventory isn't released twice.
- Alert operations if compensation continues failing.
- Use reconciliation jobs to identify stuck orders.

Never assume that calling the compensation API means compensation succeeded.

## 5. How would Kafka improve this architecture?

Instead of tightly coupling all services through synchronous REST calls, we can use Kafka.

Order Service

Creates PENDING order

Kafka: OrderCreated

Inventory Service

Reserves stock

Kafka: InventoryReserved

Payment Service

Processes payment

SuccessPaymentCompleted

Order CONFIRMED

FailurePaymentFailed

Release inventory

Kafka makes the workflow asynchronous, but it does not automatically guarantee successful payment or compensation.

For reliability, implement:

- Transactional Outbox Pattern.
- Idempotent consumers.
- Retry topics and Dead Letter Topics.
- Saga state persistence.
- Eventual consistency.

## 6. Important interview follow-up questions

| Interviewer asks | Expected concept |
| --- | --- |
| What if payment succeeds but response is lost? | Idempotency and payment status verification |
| What if inventory release fails? | Compensation retry |
| What if Kafka publishes duplicate events? | Idempotent consumer |
| What if Kafka is unavailable? | Transactional Outbox |
| What if two customers buy the last item? | Optimistic/pessimistic locking |
| What if payment succeeds but order update fails? | Saga recovery and reconciliation |
| Can `@Transactional` solve this? | No, not across independent services |
| What if payment takes 30 seconds? | Async processing and timeout management |

## 7. Interview-ready answer

You can give this answer directly:

> In this scenario, I would implement the Saga Pattern to maintain consistency across microservices.
>
> First, Order Service creates an order with PENDING status. Inventory Service reserves the stock successfully. Then Payment Service attempts to process the payment, but it is unavailable.
>
> I would not confirm the order until payment is successful.
>
> If payment fails, I would trigger a compensating transaction to release the reserved inventory and update the order status to PAYMENT\_FAILED or CANCELLED.
>
> If Inventory Service is also unavailable during compensation, I would persist the compensation request and retry it asynchronously using Kafka.
>
> I would also implement idempotency, retries, Dead Letter Topics and the Transactional Outbox Pattern to ensure reliable event processing.
>
> This approach provides eventual consistency without requiring a distributed database transaction.

Next-level interview practiceNext question: Payment Service successfully deducts ₹50,000 from the customer's bank account, but Order Service crashes before updating the order status to CONFIRMED.

How would you handle this situation without charging the customer twice?
- 
- [ ]Q2. Product Service has 10 million products. How would you optimize the API?
- [ ]Q3. Should Product Service call Category Service every time it needs category information?
- [ ]Q4. When should you use REST versus Kafka or RabbitMQ?
- [ ]Q5. Explain a real-world Saga scenario.
- [ ]Q6. Why shouldn't multiple microservices share the same database?
- [ ]Q7. Can `@Transactional` update two independent microservice databases atomically?
- [ ]Q8. What happens if an order is saved successfully but publishing the Kafka event fails?
- [ ]Q9. How do you prevent duplicate payments when an API receives the same request twice?
- [ ]Q10. Should you retry when Inventory Service returns HTTP 500?
- [ ]Q11. What happens when one service continuously calls an unavailable downstream service?
- [ ]Q12. How would you handle 50,000 login API requests per minute?
- [ ]Q13. Why do we need an API Gateway?

## 2. Spring Security, JWT and OAuth2

- [ ]Q14. JWT is valid, but the user receives HTTP 403. Why?
- [ ]Q15. How does a Spring Boot application validate JWT tokens?
- [ ]Q16. Why doesn't Swagger automatically authenticate with Keycloak when using `bearerAuth`?

## 3. Exception handling and logging

- [ ]Q17. How do you standardize error responses across multiple microservices?
- [ ]Q18. How do you trace a request that passes through five services and fails?
- [ ]Q19. What is the difference between Correlation ID and Distributed Tracing?

## 4. Redis and caching

- [ ]Q20. Your product catalog receives 10,000 reads per second but changes rarely. How would you optimize it?
- [ ]Q21. Redis cache expires for a popular product, causing 10,000 requests to hit PostgreSQL. How would you handle this?

## 5. Database, Hibernate and JPA

- [ ]Q22. Two users buy the last available product simultaneously. How do you prevent overselling?
- [ ]Q23. When would you use pessimistic locking instead of optimistic locking?
- [ ]Q24. Your API executes one query for products and 100 additional queries for categories. What is happening?
- [ ]Q25. Why can `FetchType.EAGER` be dangerous?
- [ ]Q26. Why shouldn't REST controllers return JPA entities directly?
- [ ]Q27. What causes the Hibernate error `object references an unsaved transient instance`?
- [ ]Q28. How do you reference an existing parent entity while saving a child entity?

## 6. Design patterns and SOLID

- [ ]Q29. Your payment service supports Stripe, PayPal and Razorpay. How would you avoid a large `if-else` block?
- [ ]Q30. How would you select the correct payment strategy dynamically?
- [ ]Q31. Stripe and PayPal return different response structures. How would you expose one common response?
- [ ]Q32. How would you manage an Order with multiple states without hundreds of `if-else` conditions?
- [ ]Q33. A ProductService class has 2,000 lines and handles validation, pricing, inventory, notifications and database operations. What's wrong with this design?

## 7. Kafka and asynchronous messaging

- [ ]Q34. Inventory Service takes 30 seconds to respond, but the HTTP timeout is 60 seconds. What happens with 1,000 concurrent requests?
- [ ]Q35. What happens when a Kafka consumer repeatedly fails to process a message?
- [ ]Q36. Does Kafka guarantee exactly-once execution of a business operation?
- [ ]How do you handle duplicate Kafka messages?
- [ ]How do you maintain message ordering?
- [ ]What is consumer lag, and how do you troubleshoot it?
- [ ]What happens when a consumer goes down?
- [ ]What is a Dead Letter Topic (DLT)?
- [ ]How do you retry failed Kafka messages?
- [ ]How do you handle poison messages?
- [ ]How do you scale Kafka consumers?
- [ ]What is the difference between Kafka partitions and consumer groups?
- [ ]How do you ensure reliable event publishing using the Transactional Outbox pattern?

## 8. Docker and Kubernetes

- [ ]Q37. Your Product Service has three replicas. Where should session state be stored?
- [ ]Q38. What is the difference between liveness and readiness probes?
- [ ]Q39. What happens when Kubernetes sends SIGTERM to a running application?
- [ ]Q40. Why use Liquibase/Flyway instead of `ddl-auto=update` in production?
- [ ]Q41. Liquibase runs successfully, but tables don't exist. How would you debug it?
- [ ]What is the difference between Docker and Kubernetes?
- [ ]What is a Kubernetes Pod?
- [ ]What is the difference between a Deployment and a ReplicaSet?
- [ ]What is a Kubernetes Service?
- [ ]What is the difference between ClusterIP, NodePort and LoadBalancer?
- [ ]What is an Ingress Controller?
- [ ]What is a ConfigMap?
- [ ]How do you manage secrets in Kubernetes?
- [ ]What happens when a Pod crashes?
- [ ]How does Horizontal Pod Autoscaling work?
- [ ]What are resource requests and limits?
- [ ]What is a StatefulSet?
- [ ]How do you perform rolling deployments?
- [ ]How do you roll back a failed deployment?
- [ ]How do you troubleshoot CrashLoopBackOff?
- [ ]How do you troubleshoot ImagePullBackOff?

## 9. Spring Boot and application architecture

- [ ]How does Spring Boot auto-configuration work?
- [ ]What happens internally when you use `@SpringBootApplication`?
- [ ]What is the difference between `@Component`, `@Service` and `@Repository`?
- [ ]What is the difference between constructor injection and field injection?
- [ ]How does Spring manage bean lifecycle?
- [ ]What happens when two beans of the same type exist?
- [ ]What is the difference between `@Primary` and `@Qualifier`?
- [ ]How does `@Transactional` work internally?
- [ ]Why does `@Transactional` sometimes not work when calling another method in the same class?
- [ ]What is transaction propagation?
- [ ]What is transaction isolation?
- [ ]What is the difference between checked and unchecked exceptions in Spring transactions?
- [ ]How do you implement global exception handling?
- [ ]How do you validate request payloads?
- [ ]How do you manage environment-specific configurations?
- [ ]How do Spring profiles work?
- [ ]How do you implement asynchronous processing using `@Async`?
- [ ]How do you schedule jobs using `@Scheduled`?
- [ ]How do you handle graceful shutdown?

## 10. REST API and performance

- [ ]How do you design pagination for millions of records?
- [ ]What is the difference between offset and cursor pagination?
- [ ]How do you implement sorting and filtering?
- [ ]How do you version REST APIs?
- [ ]What is the difference between PUT and PATCH?
- [ ]What is the difference between HTTP 401 and 403?
- [ ]How do you handle API rate limiting?
- [ ]How do you prevent duplicate API requests?
- [ ]How do you handle large file uploads?
- [ ]How do you optimize a slow REST API?
- [ ]How do you handle concurrent API requests?
- [ ]How do you design backward-compatible APIs?

## 11. Microservices scaling and throughput

- [ ]What is scaling in microservices?
- [ ]What is the difference between horizontal and vertical scaling?
- [ ]What are the advantages of horizontal scaling?
- [ ]How does a load balancer distribute requests?
- [ ]What is the difference between scaling a monolith and microservices?
- [ ]What is a stateless service?
- [ ]How do Docker and Kubernetes help scale microservices?
- [ ]What is auto-scaling?
- [ ]How do you scale a service when CPU usage is low but response time is high?
- [ ]How do you scale a microservice dependent on a single database?
- [ ]How do you manage sessions when scaling horizontally?
- [ ]What challenges arise when scaling services with local caches?
- [ ]What is the thundering herd problem?
- [ ]What is the difference between HPA and VPA?
- [ ]How do you scale a service with uneven endpoint traffic?
- [ ]How do database connection pool limits affect scaling?
- [ ]A service handles 1,000 RPS on four instances. How would you scale it to 5,000 RPS?
- [ ]Throughput doesn't improve after increasing Pods from 5 to 30. Why?
- [ ]What happens when scaling overloads the database?
- [ ]How would you design auto-scaling for unpredictable traffic?
- [ ]How do you scale stateful microservices?
- [ ]How do you scale Kafka consumers?

## 12. Throughput and concurrency

- [ ]What is throughput in microservices?
- [ ]What is the difference between throughput, latency and response time?
- [ ]What is the difference between RPS and TPS?
- [ ]What factors affect microservice throughput?
- [ ]How do you measure throughput in Spring Boot?
- [ ]What is concurrency?
- [ ]How does synchronous versus asynchronous processing affect throughput?
- [ ]How do thread pools affect throughput?
- [ ]Why can adding more threads reduce throughput?
- [ ]How do database connection pools affect throughput?
- [ ]How does caching improve throughput?
- [ ]How does batching improve performance?
- [ ]What is backpressure?
- [ ]How do message queues absorb traffic spikes?
- [ ]How do you calculate maximum sustainable throughput?
- [ ]How does rate limiting affect throughput?
- [ ]What is the difference between peak and sustainable throughput?
- [ ]Your service receives 10,000 RPS but processes only 6,000 RPS. How do you investigate?
- [ ]Throughput decreases as concurrent users increase. What could be the reason?
- [ ]How would you improve throughput without adding instances?
- [ ]Kafka consumer lag keeps increasing despite low CPU usage. Why?
- [ ]How do you calculate the number of Kafka consumers required?
- [ ]How do you design a service to handle 50,000 RPS?

## 13. Latency and performance optimization

- [ ]What is latency in microservices?
- [ ]What is the difference between latency and response time?
- [ ]What are p50, p90, p95 and p99 latency?
- [ ]Why is average latency insufficient for production monitoring?
- [ ]What factors contribute to distributed-system latency?
- [ ]How does network latency affect microservices?
- [ ]What is the difference between client-side and server-side latency?
- [ ]How do synchronous REST calls affect end-to-end latency?
- [ ]Why can p99 latency increase while average latency remains stable?
- [ ]How does connection pooling reduce latency?
- [ ]How do DNS lookup, TLS handshake and TCP connection establishment affect latency?
- [ ]How do database indexes affect API latency?
- [ ]How do timeouts prevent requests from waiting indefinitely?
- [ ]How can retries worsen an outage?
- [ ]How do caching and asynchronous processing reduce latency?
- [ ]What is tail latency amplification?
- [ ]How do thread pool exhaustion and garbage collection pauses affect latency?
- [ ]How would you configure timeout values across dependent services?
- [ ]An API has 50 ms p50 latency but 2 seconds p99 latency. How would you investigate?

## 14. Distributed tracing and observability

- [ ]What is distributed tracing?
- [ ]What is the difference between Trace ID and Span ID?
- [ ]What is parent-child span relationship?
- [ ]How does OpenTelemetry work?
- [ ]What is Micrometer Tracing?
- [ ]What is the difference between Zipkin and Jaeger?
- [ ]How do you propagate trace context between microservices?
- [ ]How do you trace Kafka events across asynchronous services?
- [ ]Why might some spans be missing?
- [ ]What happens when the Trace ID changes between services?
- [ ]How do you investigate a slow downstream service using traces?
- [ ]How do you configure sampling?
- [ ]How do you avoid exposing sensitive information in trace attributes?
- [ ]How do you combine logs, metrics and traces during production troubleshooting?
- [ ]How do you design an observability dashboard for 100 microservices?

## 15. Production troubleshooting and JVM

- [ ]Your Spring Boot application suddenly consumes 95–100% CPU. How do you investigate?
- [ ]How do you identify CPU-intensive Java threads?
- [ ]How do you analyze a Java thread dump?
- [ ]How do you investigate a Java memory leak?
- [ ]What is the difference between heap and stack?
- [ ]What is garbage collection?
- [ ]What is Full GC?
- [ ]What is Java Flight Recorder?
- [ ]How do you investigate `OutOfMemoryError`?
- [ ]Can an application have high memory usage without a memory leak?
- [ ]How do you analyze a heap dump?
- [ ]What is Metaspace?
- [ ]What is Direct Memory?
- [ ]Your application has low CPU but high response time. What could be the reason?
- [ ]How do you investigate database connection pool exhaustion?
- [ ]How do you identify thread starvation?
- [ ]How do you investigate lock contention?
- [ ]How do you troubleshoot slow disk I/O?
- [ ]How do you identify whether a bottleneck is in CPU, memory, network or database?

## 16. System design and architecture

- [ ]An e-commerce API experiences a tenfold traffic spike during a sale. How would you design it?
- [ ]How would you optimize end-to-end checkout latency?
- [ ]Your service meets throughput targets but violates p99 latency SLO. What would you do?
- [ ]A service has low throughput and high latency despite low CPU utilization. How would you diagnose it?
- [ ]A downstream service becomes slow, filling upstream thread pools. How would you prevent cascading failures?
- [ ]How would you combine metrics, logs and traces to troubleshoot production incidents?
- [ ]How would you decide between scaling, caching, database tuning and code optimization?
- [ ]A deployment increases error rates and p99 latency. How would you investigate?
- [ ]How would you design an API with 99.99% availability?
- [ ]How would you perform capacity planning from 5,000 to 50,000 RPS?
- [ ]How would you implement graceful degradation?
- [ ]How would you define SLIs, SLOs and error budgets?
- [ ]How do you perform load testing and identify bottlenecks?

## 17. Practical numerical interview questions

- [ ]A service handles 2,000 RPS with 100 ms average response time. Estimate average in-flight requests.
- [ ]A request takes 20 ms in Service A, 80 ms in B and 150 ms in C. What is the minimum end-to-end latency?
- [ ]A service processes 500 events/sec, but 800 events/sec arrive. How quickly does consumer lag grow?
- [ ]One instance handles 400 RPS. How many instances are required for 4,000 RPS?
- [ ]A downstream service has p99 latency of 800 ms. What happens if the upstream timeout is 500 ms?
- [ ]Error rate increases from 0.1% to 5% after scaling. What would you investigate?
- [ ]A trace shows 50 ms in the API, 20 ms in Service B and 700 ms in a database call. Where would you start?
- [ ]A service has 16 CPU cores but runs 200 application threads. Is this appropriate?
- [ ]A Kafka topic has 12 partitions and 24 consumers in one group. How many consumers can actively consume assigned partitions?
- [ ]A service has a 99.9% availability SLO. How much downtime is allowed over 30 days?

## 18. Additional senior-level preparation topics

The document also includes dedicated material on:

- [ ]OAuth 2.0 and OpenID Connect.
- [ ]Resilience4j configuration.
- [ ]Circuit Breaker, Retry, Bulkhead and Rate Limiter.
- [ ]High CPU and memory troubleshooting.
- [ ]Kubernetes deployments and probes.
- [ ]Redis caching with Spring Boot.
- [ ]Distributed tracing with Micrometer and OpenTelemetry.
- [ ]Monolith vs Modular Monolith vs Microservices.
- [ ]Production incident management and root-cause analysis.
- [ ]Backward-compatible REST API changes.
- [ ]Backward-compatible Kafka event changes.
- [ ]Rolling deployment.
- [ ]Blue-Green deployment.
- [ ]Canary deployment.
- [ ]Deployment rollback.

## Suggested preparation order

For a Senior Java Developer / Spring Boot Microservices interview, I recommend this order:

| Priority | Topics |
| --- | --- |
| 1 | Core Java, Collections, Multithreading |
| 2 | Java 8+ features and Streams |
| 3 | Spring Boot and Spring Security |
| 4 | Hibernate, JPA and SQL |
| 5 | Microservices architecture |
| 6 | Kafka and messaging |
| 7 | Redis and caching |
| 8 | Design patterns and SOLID |
| 9 | Docker and Kubernetes |
| 10 | Production troubleshooting and system design |
