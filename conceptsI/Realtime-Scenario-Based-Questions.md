I found the GitHub document: Real-Time Scenarios – Updated, from the `technologies-notes` repository.

It contains interview questions and answers focused on:

- Java and Spring Boot microservices
- System design and scalability
- Kafka and distributed systems
- Kubernetes and Docker
- Database performance
- High availability and fault tolerance
- Monitoring, logging and distributed tracing
- Real-world production troubleshooting

Source: [Real-Time-Scenarios-Updated.md on GitHub](<https://github.com/firozkhan18/technologies-notes/blob/main/conceptsI/Real-Time-Scenarios-Updated.md?utm_source=chatgpt.com>).

I'll organize the questions by topic and preserve their original question numbering wherever possible.

## Part 1: Main interview questions (Q1–Q50)

### 1. Scaling in microservices

1. What is scaling in microservices?
2. What is the difference between horizontal and vertical scaling?
3. How do you scale a microservice in Kubernetes?
4. A service scales from 5 pods to 20 pods, but throughput does not improve. Why?
5. How do you scale a service that depends on a single database?
6. What is a stateless microservice, and why is it important?
7. How do you calculate how many instances are needed?

### 2. Throughput

8. What is throughput in microservices?
9. What is the difference between throughput, latency, and concurrency?
10. What is Little's Law, and how is it used?
11. Why can increasing the thread pool size reduce throughput?
12. How do database connection pools affect throughput?
13. How does caching improve throughput?
14. A service receives 10,000 RPS but processes only 6,000 RPS. How do you troubleshoot?

### 3. Latency

15. What is latency, and how is it different from response time?
16. What are p50, p95, and p99 latency?
17. Why can p99 latency increase while average latency remains stable?
18. What is tail latency amplification?
19. How do retries affect latency?
20. What is a timeout budget in a microservices architecture?
21. An API has p50 latency of 50 ms but p99 latency of 2 seconds. How would you troubleshoot it?

### 4. Performance optimization

22. What metrics would you monitor for a Spring Boot microservice?
23. How would you diagnose high CPU utilization in a Java microservice?
24. How would you investigate a memory leak?
25. What is the difference between CPU-bound and I/O-bound workloads?
26. How do you identify slow SQL queries?
27. What is the N+1 query problem?
28. A service performs well at 100 concurrent users but fails at 2,000. How would you investigate?
29. What is the difference between load testing, stress testing, spike testing, and soak testing?

### 5. Distributed tracing

30. What is distributed tracing?
31. What is the difference between a trace ID and a span ID?
32. What is the difference between logs, metrics, and traces?
33. How does trace context propagate between microservices?
34. How do you implement distributed tracing in Spring Boot?
35. What is OpenTelemetry?
36. What is the difference between head-based and tail-based sampling?
37. How would you troubleshoot a trace that is missing spans?
38. How do you trace asynchronous Kafka communication?
39. How do you reduce distributed tracing overhead?

### 6. Real-world microservices troubleshooting

40. API latency increases from 200 ms to 2 seconds, but CPU utilization is normal. What would you do?
41. A downstream service is slow, and upstream services start failing. How do you prevent cascading failures?
42. Kafka consumer lag keeps increasing. How would you troubleshoot it?
43. A service receives 5,000 RPS and needs to handle 50,000 RPS. How would you approach the design?
44. How would you investigate a production performance regression after deployment?

### 7. Numerical interview questions

45. A service processes 2,000 RPS with 100 ms average latency. How many requests are in progress on average?
46. Three services take 20 ms, 80 ms, and 150 ms sequentially. What is the total latency?
47. Incoming traffic is 800 messages/sec, but consumers process 500 messages/sec. How fast does lag grow?
48. One instance handles 400 RPS. How many instances are required for 4,000 RPS?
49. A downstream dependency has a 500 ms timeout, but the API gateway times out after 300 ms. What happens?
50. A service has a 99.9% availability SLO. How much downtime is allowed in a 30-day month?

## Part 2: Additional interview question categories

The document also contains expanded sections with repeated and additional scenario-based questions.

| Section | Topics |
| --- | --- |
| Microservices scaling | Scaling fundamentals, load balancing, statelessness |
| Docker and Kubernetes | Containerization, replicas, orchestration |
| Autoscaling | HPA, VPA, CPU, memory and custom metrics |
| Database scaling | Connection pools, read replicas, database bottlenecks |
| Caching | Redis, Caffeine, cache invalidation |
| Distributed systems | Thundering herd, resilience, backpressure |
| Kafka | Consumer lag, partitions, parallel processing |
| Monitoring | Actuator, Micrometer, Prometheus, Grafana |
| Throughput | RPS, TPS, concurrency and thread pools |

Some additional scenario questions include:

1. What is scaling in microservices, and why is it required?
2. What are the advantages of horizontal scaling over vertical scaling?
3. How does a load balancer distribute requests across multiple service instances?
4. What is the difference between scaling a monolith and scaling microservices?
5. What is a stateless service, and why is statelessness important for scaling?
6. How do Docker and Kubernetes help scale microservices?
7. What is auto-scaling, and which metrics can trigger it?
8. How do you handle session management when scaling service instances horizontally?
9. What challenges arise when scaling services that maintain local caches?
10. How do you prevent a thundering herd problem during scale-out?
11. How do Kubernetes Horizontal Pod Autoscaler (HPA) and Vertical Pod Autoscaler (VPA) differ?
12. How do you handle database connection pool limits when increasing the number of service instances?
The document is approximately 126 KB, so the 50 numbered questions above are the main interview series, not an exhaustive transcription of every repeated question, sub-question, and practical exercise.

---
# Real-Time Scenarios – Interview Questions and Answers

Below are answers to the 50 questions listed above, with practical examples from Java, Spring Boot, microservices, Kafka, and Kubernetes.

## 1. Microservices scaling

### Q1. What is scaling in microservices?

Scaling means increasing or decreasing application resources to handle changes in workload.

There are two main approaches:

- Horizontal scaling: Add more application instances.
- Vertical scaling: Increase CPU and memory of existing instances.

Example: If one Spring Boot instance handles 1,000 requests per second, adding four instances can increase the total processing capacity, provided the database and other dependencies can handle the additional load.

### Q2. Difference between horizontal and vertical scaling?

| Horizontal scaling | Vertical scaling |
| --- | --- |
| Adds more instances | Increases machine resources |
| Better fault tolerance | Limited by hardware |
| Requires load balancing | Usually simpler |
| Supports distributed workloads | Suitable for smaller workloads |

Example:

- Horizontal: 2 Kubernetes pods become 10 pods.
- Vertical: A pod's CPU limit increases from 1 core to 4 cores.

### Q3. How do you scale a microservice in Kubernetes?

Use Kubernetes Deployment replicas and Horizontal Pod Autoscaler (HPA).

Example:

yaml

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: order-service
spec:
  replicas: 3
  selector:
    matchLabels:
      app: order-service
  template:
    metadata:
      labels:
        app: order-service
    spec:
      containers:
        - name: order-service
          image: order-service:1.0
          resources:
            requests:
              cpu: "250m"
              memory: "512Mi"
            limits:
              cpu: "1"
              memory: "1Gi"
```

HPA configuration:

yaml

```yaml
apiVersion: autoscaling/v2
kind: HorizontalPodAutoscaler
metadata:
  name: order-service-hpa
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: order-service
  minReplicas: 3
  maxReplicas: 10
  metrics:
    - type: Resource
      resource:
        name: cpu
        target:
          type: Utilization
          averageUtilization: 70
```

When CPU utilization increases beyond the target, Kubernetes can increase the number of pods.

### Q4. A service scales from 5 pods to 20 pods, but throughput does not improve. Why?

Possible reasons:

1. Database connection pool exhaustion.
2. Database CPU or I/O bottleneck.
3. Downstream service limitations.
4. Kafka partition limitations.
5. Thread pool saturation.
6. Network bandwidth limitations.
7. Shared locks or synchronized code.
8. External API rate limits.

Solution: Identify the bottleneck using metrics, distributed tracing, database monitoring, and load testing.

### Q5. How do you scale a service that depends on a single database?

I would:

- Optimize SQL queries and indexes.
- Introduce caching using Redis.
- Use database read replicas for read-heavy workloads.
- Use connection pooling.
- Implement pagination.
- Consider database partitioning or sharding.
- Introduce asynchronous processing for suitable operations.

Important: Adding application pods alone does not solve a database bottleneck.

### Q6. What is a stateless microservice?

A stateless microservice does not store user session or request-specific state in its local memory between requests.

For example, instead of maintaining a user's session in an individual Spring Boot instance, we can use JWT authentication.

Advantages:

- Easy horizontal scaling.
- Better fault tolerance.
- No session affinity requirement.
- Easier deployment and recovery.

### Q7. How do you calculate how many instances are needed?

Formula:

$$
Instances = \frac{Required\ RPS}{Capacity\ per\ instance}
$$

Example:

- Required traffic = 10,000 RPS.
- Capacity per instance = 1,000 RPS.

$$
Instances = \frac{10000}{1000}=10
$$

If we want 30% spare capacity, provision additional instances and validate the result through load testing.

## 2. Throughput

### Q8. What is throughput in microservices?

Throughput is the number of requests or transactions processed successfully per unit of time.

Example:

A payment service processes 5,000 transactions in one second.

Throughput = 5,000 TPS.

### Q9. Difference between throughput, latency, and concurrency?

| Metric | Meaning |
| --- | --- |
| Throughput | Requests processed per second |
| Latency | Time taken to process a request |
| Concurrency | Number of requests being processed simultaneously |

Example:

An API has:

- Throughput: 2,000 RPS.
- Average latency: 100 ms.
- Concurrency: Approximately 200 requests in progress.

### Q10. What is Little's Law?

Little's Law explains the relationship between concurrency, throughput, and response time.

$$
L = \lambda \times W
$$

Where:

- L = Average number of requests in the system.
- λ = Arrival rate.
- W = Average time spent in the system.

Example:

Throughput = 1,000 RPS.

Average latency = 200 ms = 0.2 seconds.

$$
L=1000\times0.2=200
$$

Therefore, approximately 200 requests are in progress on average.

### Q11. Why can increasing thread pool size reduce throughput?

Increasing thread count can cause:

- Excessive context switching.
- Increased memory consumption.
- CPU contention.
- Database connection exhaustion.
- Thread scheduling overhead.

For example, increasing a thread pool from 100 to 1,000 does not necessarily improve performance.

Solution: Tune thread pools based on CPU cores, workload type, downstream capacity, and load-test results.

### Q12. How do database connection pools affect throughput?

Connection pools reuse database connections rather than creating a new connection for every request.

Example using HikariCP:

properties

```properties
spring.datasource.hikari.maximum-pool-size=30
spring.datasource.hikari.minimum-idle=10
spring.datasource.hikari.connection-timeout=30000
```

A pool that is too small causes connection waiting. A pool that is too large can overload the database.

### Q13. How does caching improve throughput?

Caching stores frequently accessed data in memory or Redis.

Without caching:

text

```text
Request → Spring Boot → Database → Response
```

With caching:

text

```text
Request → Spring Boot → Redis → Response
```

Example:

java

```java
@Cacheable(value = "products", key = "#id")
public Product getProduct(Long id) {
    return productRepository.findById(id)
            .orElseThrow();
}
```

Caching reduces database queries and improves response time.

### Q14. A service receives 10,000 RPS but processes only 6,000 RPS. How do you troubleshoot?

I would investigate:

1. CPU and memory utilization.
2. Thread pool utilization.
3. Database connection pool.
4. Slow SQL queries.
5. GC pauses.
6. Downstream API latency.
7. Kafka consumer lag, if applicable.
8. Network latency.

Then I would identify the bottleneck, optimize it, and repeat load testing.

## 3. Latency

### Q15. What is latency?

Latency is the time taken between sending a request and receiving the corresponding response.

Example:

An API request takes 250 milliseconds to return a response.

Its response latency is 250 ms.

### Q16. What are p50, p95, and p99 latency?

These are percentile measurements.

- p50: 50% of requests complete within this time.
- p95: 95% of requests complete within this time.
- p99: 99% of requests complete within this time.

Example:

| Metric | Latency |
| --- | --- |
| p50 | 50 ms |
| p95 | 200 ms |
| p99 | 1,000 ms |

This means 99% of requests complete within one second, while the slowest 1% take longer.

### Q17. Why can p99 latency increase while average latency remains stable?

Because a small percentage of requests may experience unusually high latency.

Possible reasons:

- Garbage collection pauses.
- Slow database queries.
- Network delays.
- Thread contention.
- Lock contention.
- Downstream service problems.

Monitor percentiles rather than relying only on average latency.

### Q18. What is tail latency amplification?

Tail latency amplification happens when a request depends on multiple downstream services and the overall response time is affected by slow responses from one or more dependencies.

Example:

text

```text
API Gateway
   |
   ├── User Service: 50 ms
   ├── Order Service: 100 ms
   └── Payment Service: 900 ms
```

The slow payment service can significantly increase the total response time.

Solutions include timeouts, parallel execution where appropriate, caching, and reducing unnecessary dependencies.

### Q19. How do retries affect latency?

Retries can improve reliability when failures are temporary.

However, excessive retries can:

- Increase response latency.
- Increase server load.
- Create retry storms.
- Cause cascading failures.

Use exponential backoff, jitter, maximum retry limits, and retry only appropriate transient failures.

### Q20. What is a timeout budget?

A timeout budget is the maximum time allocated to complete a request across all dependent services.

Example:

Total API timeout = 2 seconds.

- User service: 300 ms.
- Order service: 500 ms.
- Payment service: 800 ms.
- Remaining budget: 400 ms.

The timeout values must account for the actual call structure, including parallel calls and network overhead.

### Q21. An API has p50 latency of 50 ms but p99 latency of 2 seconds. How would you troubleshoot?

I would:

1. Examine slow request traces.
2. Check database query execution times.
3. Check garbage collection pauses.
4. Inspect thread pool saturation.
5. Investigate network latency.
6. Review downstream service performance.
7. Check connection pool wait times.

I would compare slow and normal requests to identify the difference.

## 4. Performance optimization

### Q22. What metrics would you monitor for a Spring Boot microservice?

Important metrics:

- CPU utilization.
- Heap and non-heap memory.
- Garbage collection.
- Request rate.
- Error rate.
- p95 and p99 latency.
- Thread count.
- Database connection pool.
- JVM pauses.
- Kafka consumer lag.

Tools:

- Spring Boot Actuator.
- Micrometer.
- Prometheus.
- Grafana.
- OpenTelemetry.

### Q23. How would you diagnose high CPU utilization?

I would:

1. Check CPU usage per pod.
2. Capture Java thread dumps.
3. Identify busy threads.
4. Analyze CPU profiling.
5. Inspect inefficient loops and algorithms.
6. Check excessive serialization or deserialization.
7. Investigate garbage collection.
8. Optimize the identified bottleneck.

### Q24. How would you investigate a memory leak?

I would:

1. Monitor heap usage over time.
2. Check whether memory continues increasing after GC.
3. Capture a heap dump.
4. Analyze retained objects and references.
5. Check static collections and caches.
6. Inspect ThreadLocal usage.
7. Fix the retention issue and verify through load testing.

Tools include Eclipse MAT, VisualVM, and Java Flight Recorder.

### Q25. Difference between CPU-bound and I/O-bound workloads?

CPU-bound: Workload spends most of its time processing data.

Example: Image processing or encryption.

I/O-bound: Workload spends most of its time waiting for external resources.

Example: Database queries or HTTP calls.

CPU-bound workloads benefit from CPU-efficient parallelism. I/O-bound workloads can benefit from appropriately sized thread pools or asynchronous processing.

### Q26. How do you identify slow SQL queries?

- Enable database slow query logs.
- Monitor query execution time.
- Use `EXPLAIN` or `EXPLAIN ANALYZE`.
- Check indexes.
- Identify full table scans.
- Check locks and blocking queries.
- Review query plans.

### Q27. What is the N+1 query problem?

It occurs when an application executes one query to retrieve a list and then executes another query for each item.

Example:

java

```java
List<Order> orders = orderRepository.findAll();

for (Order order : orders) {
    System.out.println(order.getCustomer().getName());
}
```

If there are 100 orders, this can generate 101 queries.

Solutions:

- JOIN FETCH.
- Entity graphs.
- Batch fetching.
- DTO projections.

### Q28. A service performs well at 100 concurrent users but fails at 2,000. How would you investigate?

I would check:

- Thread pool saturation.
- Database connection pool exhaustion.
- CPU and memory limits.
- Garbage collection.
- Database query performance.
- External API limits.
- Queue buildup.

Then perform stress testing and identify the maximum sustainable concurrency.

### Q29. Difference between load, stress, spike, and soak testing?

| Testing | Purpose |
| --- | --- |
| Load testing | Test expected traffic |
| Stress testing | Find system breaking point |
| Spike testing | Test sudden traffic increase |
| Soak testing | Test long-duration stability |

## 5. Distributed tracing

### Q30. What is distributed tracing?

Distributed tracing tracks a single request as it travels across multiple microservices.

Example:

text

```text
API Gateway
    |
    v
Order Service
    |
    v
Payment Service
    |
    v
Notification Service
```

A distributed trace helps identify:

- Which service is slow.
- Where an exception occurred.
- Which downstream dependency failed.
- How much time each service consumed.

Popular tools:

- OpenTelemetry.
- Jaeger.
- Zipkin.
- Grafana Tempo.

### Q31. Difference between Trace ID and Span ID?

| Trace ID | Span ID |
| --- | --- |
| Identifies the complete request | Identifies an individual operation |
| Shared across services | Different for each span |
| Connects all operations | Represents one operation |

Example:

text

```text
Trace ID: abc123

API Gateway      Span ID: 101
Order Service    Span ID: 102
Payment Service  Span ID: 103
```

All three spans belong to the same trace.

### Q32. Difference between logs, metrics, and traces?

| Logs | Metrics | Traces |
| --- | --- | --- |
| Event details | Numerical measurements | Request journey |
| Explain what happened | Show system health | Show where time was spent |
| Example: Payment failed | Example: Error rate 5% | Example: Payment API took 2 seconds |

All three are important for production troubleshooting.

### Q33. How does trace context propagate between microservices?

Trace context is passed through HTTP headers.

For example, OpenTelemetry commonly uses the W3C `traceparent` header.

text

```text
Service A
   |
   | traceparent header
   v
Service B
   |
   | traceparent header
   v
Service C
```

Each service extracts the existing context and creates a child span.

This allows all services to appear under one distributed trace.

### Q34. How do you implement distributed tracing in Spring Boot?

One approach is to use Spring Boot Actuator, Micrometer Tracing, and an OpenTelemetry-compatible exporter.

Example Maven dependencies:

xml

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-tracing-bridge-otel</artifactId>
</dependency>

<dependency>
    <groupId>io.opentelemetry</groupId>
    <artifactId>opentelemetry-exporter-otlp</artifactId>
</dependency>
```

Configuration depends on the Spring Boot version and telemetry backend.

The application generates trace and span information and exports it to the configured collector.

### Q35. What is OpenTelemetry?

OpenTelemetry (OTel) is an open-source observability framework.

It provides:

- Distributed tracing.
- Metrics collection.
- Log instrumentation.
- Context propagation.
- Telemetry export.

It is vendor-neutral, meaning the same instrumentation can work with different observability backends.

### Q36. Difference between head-based and tail-based sampling?

Head-based sampling:

- Sampling decision is made when a trace starts.
- Lower resource overhead.
- May miss rare errors.

Tail-based sampling:

- Decision is made after collecting the trace.
- Can retain slow or failed traces.
- Requires more infrastructure and buffering.

Example:

If a request fails or takes more than two seconds, tail-based sampling can be configured to retain that trace.

### Q37. How would you troubleshoot a trace that is missing spans?

Check:

1. Whether instrumentation is enabled.
2. Whether trace context is propagated.
3. Whether HTTP clients are instrumented.
4. Whether sampling dropped spans.
5. Whether exporter configuration is correct.
6. Whether the collector is receiving telemetry.
7. Whether asynchronous execution preserves context.

### Q38. How do you trace asynchronous Kafka communication?

Use trace context propagation through Kafka message headers.

Example:

text

```text
Order Service
     |
     | Publish Kafka message
     | trace context in headers
     v
Kafka Topic
     |
     v
Payment Consumer
     |
     v
Notification Consumer
```

The producer creates a span for publishing. Consumers extract the context and create processing spans.

This makes it possible to follow a business operation across asynchronous boundaries.

### Q39. How do you reduce distributed tracing overhead?

- Use sampling.
- Avoid collecting unnecessary attributes.
- Configure batch exporters.
- Avoid excessive span creation.
- Use asynchronous telemetry export.
- Monitor collector resource utilization.
- Avoid logging sensitive information.

## 6. Real-world microservices troubleshooting

### Q40. API latency increases from 200 ms to 2 seconds, but CPU utilization is normal. What would you do?

CPU is not necessarily the bottleneck.

I would investigate:

1. Database query latency.
2. Database connection pool waiting.
3. Downstream API response time.
4. Network latency.
5. Thread pool saturation.
6. Lock contention.
7. Garbage collection pauses.
8. DNS resolution delays.

Example:

text

```text
API Gateway       50 ms
Order Service    100 ms
Database         900 ms
Payment Service  800 ms
-----------------------
Total           1850 ms
```

Distributed tracing can help locate the bottleneck.

### Q41. A downstream service is slow, and upstream services start failing. How do you prevent cascading failures?

Use resilience patterns:

1. Timeout

Do not wait indefinitely for a downstream response.

2. Circuit breaker

Temporarily stop calling a failing service.

3. Retry

Retry transient failures with exponential backoff and jitter.

4. Bulkhead

Isolate resources so one dependency cannot consume all available threads or connections.

5. Fallback

Return cached or default data where business requirements permit.

Example using Resilience4j:

java

```java
@CircuitBreaker(
    name = "paymentService",
    fallbackMethod = "paymentFallback"
)
public String processPayment() {
    return paymentClient.process();
}

public String paymentFallback(Exception ex) {
    return "Payment service temporarily unavailable";
}
```

The fallback should not falsely report a payment as successful.

### Q42. Kafka consumer lag keeps increasing. How would you troubleshoot it?

Consumer lag means the difference between the latest available offset and the consumer's committed or processed position.

Possible reasons:

- Consumer processing is slow.
- Insufficient consumer instances.
- Too few partitions.
- Database calls are slow.
- External API calls are blocking.
- Frequent consumer rebalancing.
- Consumer errors and repeated retries.

Solutions:

1. Monitor lag per partition.
2. Increase consumers up to the available partition parallelism.
3. Optimize message processing.
4. Batch database operations where appropriate.
5. Avoid unnecessary synchronous external calls.
6. Review partition distribution.
7. Implement proper retry and dead-letter handling.

Example:

text

```text
Producer: 10,000 messages/sec
Consumer:  7,000 messages/sec

Lag growth = 3,000 messages/sec
```

If the rates remain constant, lag increases by 180,000 messages per minute.

### Q43. A service receives 5,000 RPS and needs to handle 50,000 RPS. How would you approach the design?

I would follow a systematic scaling strategy.

Step 1: Establish baseline performance

- Measure current throughput.
- Measure p95 and p99 latency.
- Identify CPU and memory utilization.
- Measure database performance.

Step 2: Scale application instances

Use Kubernetes HPA and load balancing.

Step 3: Optimize database

- Add appropriate indexes.
- Introduce Redis caching.
- Use read replicas.
- Tune connection pools.

Step 4: Introduce asynchronous processing

Use Kafka for suitable background workloads.

Step 5: Optimize application code

- Avoid unnecessary database calls.
- Use pagination.
- Optimize serialization.
- Avoid blocking operations where appropriate.

Step 6: Load test

Gradually increase traffic and verify:

- 50,000 RPS throughput.
- Acceptable p95 and p99 latency.
- Error rate.
- Resource utilization.
- Database capacity.

Important: The target must be demonstrated through end-to-end testing, not estimated only from the number of pods.

### Q44. How would you investigate a production performance regression after deployment?

I would compare the current deployment with the previous stable version.

Investigation checklist:

1. Review deployment changes.
2. Compare application metrics.
3. Compare error rates and latency.
4. Check database query changes.
5. Review JVM and GC metrics.
6. Check configuration changes.
7. Examine distributed traces.
8. Check resource limits.
9. Review dependency versions.

If the regression affects customers significantly, I would consider rolling back to the last stable release while investigating.

## 7. Numerical interview questions

### Q45. A service processes 2,000 RPS with 100 ms average latency. How many requests are in progress on average?

Use Little's Law:

$$
L=\lambda\times W
$$

Given:

- Throughput = 2,000 RPS.
- Latency = 100 ms = 0.1 seconds.

$$
L=2000\times0.1
$$

Answer: 200 concurrent requests### Q46. Three services take 20 ms, 80 ms, and 150 ms sequentially. What is the total latency?

Since the calls are sequential:

$$
Total=20+80+150
$$

Answer: 250 msIf they execute in parallel and the response waits for all three, the approximate dependency time is 150 ms, excluding overhead.

### Q47. Incoming traffic is 800 messages/sec, but consumers process 500 messages/sec. How fast does lag grow?

$$
LagGrowth=800-500
$$

$$
=300\ messages/sec
$$

Answer: 300 messages per secondAfter one minute:

$$
300\times60=18,000
$$

Lag increases by 18,000 messages per minute.

### Q48. One instance handles 400 RPS. How many instances are required for 4,000 RPS?

$$
Instances=\frac{4000}{400}
$$

$$
=10
$$

Answer: 10 instancesIn production, additional capacity should be provisioned for failures, traffic spikes, and operational headroom.

### Q49. A downstream dependency has a 500 ms timeout, but the API gateway times out after 300 ms. What happens?

The API gateway stops waiting after 300 ms.

The downstream service may continue processing until its own 500 ms timeout, depending on cancellation and propagation behavior.

Possible consequences:

- The client receives a timeout.
- The downstream request may continue consuming resources.
- The client may retry.
- Duplicate operations may occur if the operation is not idempotent.

Solution:

Configure a consistent end-to-end timeout budget and propagate cancellation where supported.

For example:

text

```text
API Gateway:  300 ms
Service:      250 ms
Database:     150 ms
```

The actual values should account for the call structure and overhead.

### Q50. A service has a 99.9% availability SLO. How much downtime is allowed in a 30-day month?

Availability:

$$
99.9\%=0.999
$$

Allowed downtime:

$$
30\times24\times60\times0.001
$$

$$
=43.2\ minutes
$$

Answer: 43.2 minutes per 30-day monthFor comparison:

| Availability | Downtime per 30 days |
| --- | --- |
| 99% | 7 hours 12 minutes |
| 99.9% | 43.2 minutes |
| 99.95% | 21.6 minutes |
| 99.99% | 4.32 minutes |
| 99.999% | 25.92 seconds |

## 8. Important formulas for interviews

Keep these formulas handy for real-time scenario and system-design interviews.

| Concept | Formula |
| --- | --- |
| Throughput | Requests / Time |
| Concurrency | Throughput × Latency |
| Required instances | Required RPS / Instance capacity |
| Kafka lag growth | Incoming rate − Processing rate |
| Availability | Uptime / Total time × 100 |
| Downtime | Total time × (1 − Availability) |
| Sequential latency | Sum of service latencies |
| Parallel latency | Maximum dependency latency (when waiting for all) |

## 9. Recommended practical preparation

Practice these five scenarios particularly well:

1. High API latency: Diagnose using Spring Boot Actuator, Grafana and distributed tracing.
2. Kafka consumer lag: Explain partitions, consumer groups, concurrency and offset management.
3. Database bottleneck: Explain HikariCP, indexing, Redis and read replicas.
4. Production outage: Explain circuit breakers, retries, fallbacks and rollback.
5. Scaling from 5K to 50K RPS: Explain Kubernetes HPA, load balancing, caching and load testing.

Interview tip: Don't just explain definitions. For each scenario, structure your answer as:

- What is the problem?
- What metrics would you check?
- How would you identify the root cause?
- What solution would you implement?
- How would you verify the solution?

This approach makes your answers much stronger in senior Java developer, Spring Boot microservices and production-support interviews.
