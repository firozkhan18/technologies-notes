# Microservices Interview Questions and Answers

This guide covers scaling, throughput, latency, performance optimization, and distributed tracing, with practical answers and real-world production scenarios. The examples are particularly relevant to Java/Spring Boot microservices, Kubernetes, Kafka, databases, and observability tools.

## 1. Scaling in Microservices — Questions and Answers

### Q1. What is scaling in microservices?

Answer: Scaling is the process of increasing a service's capacity to handle more requests, users, or data while maintaining acceptable latency and reliability.

There are two main types:

- Vertical scaling: Increase the CPU, RAM, or other resources of an existing instance.
- Horizontal scaling: Add more instances of a service and distribute requests between them.

For example, if a product service cannot handle increased traffic on two instances, we could increase the number of instances to eight behind a load balancer.

Horizontal scaling is generally preferred for cloud-native microservices because it supports elasticity and fault tolerance.

### Q2. What is the difference between horizontal and vertical scaling?

| Feature | Horizontal scaling | Vertical scaling |
| --- | --- | --- |
| Approach | Add instances | Increase resources |
| Availability | Can improve resilience | Still depends on one instance |
| Upper limit | Depends on architecture and dependencies | Limited by machine capacity |
| Complexity | Requires distributed coordination in some cases | Often simpler |
| Example | 3 pods → 10 pods | 4 CPU cores → 16 cores |

Interview tip: Horizontal scaling does not automatically solve bottlenecks in a shared database, distributed locks, or external APIs.

### Q3. How do you scale a microservice in Kubernetes?

Answer: A typical approach is:

1. Containerize the service.
2. Deploy multiple replicas.
3. Expose the service through Kubernetes networking or a load balancer.
4. Configure a Horizontal Pod Autoscaler (HPA).
5. Set appropriate CPU and memory requests and limits.
6. Monitor latency, error rates, throughput, and resource utilization.

Example HPA configuration:

yaml
```
apiVersion: autoscaling/v2
kind: HorizontalPodAutoscaler
metadata:
  name: product-service
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: product-service
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

This example targets average CPU utilization of 70%, subject to the configured resource requests and the HPA's control behavior.

Important: CPU-based scaling may not help if the service is blocked on database queries or downstream network calls. For those cases, consider suitable custom metrics, such as request queue depth or consumer lag.

### Q4. A service scales from 5 pods to 20 pods, but throughput does not improve. Why?

Answer: Adding pods helps only when the application instances are the limiting resource.

Possible bottlenecks include:

- Database connection limits or slow SQL queries.
- A shared cache or distributed lock.
- Rate limits imposed by an external API.
- Thread pool or connection pool exhaustion.
- Kafka partition limits.
- Network bandwidth or CPU throttling.
- Uneven load distribution.

How I would troubleshoot:

1. Compare throughput before and after scaling.
2. Check CPU, memory, thread counts, and connection pool metrics.
3. Inspect database wait events and query latency.
4. Review distributed traces to identify slow dependencies.
5. Check whether the new instances are receiving traffic evenly.
6. Scale or optimize the actual bottleneck rather than adding instances blindly.

### Q5. How do you scale a service that depends on a single database?

Answer: First, determine whether the database is CPU-bound, I/O-bound, connection-bound, or limited by query execution.

Potential solutions include:

- Add indexes and optimize expensive queries.
- Reduce unnecessary database calls through caching.
- Tune connection pools and transaction duration.
- Use read replicas for suitable read-heavy workloads.
- Batch writes where consistency requirements permit.
- Partition or shard data when justified by workload and architecture.
- Use queues to smooth traffic bursts.
- Apply admission control or backpressure when the database reaches capacity.

Adding more application instances without protecting the database can make the outage worse by creating more concurrent queries and connections.

### Q6. What is a stateless microservice, and why is it important?

Answer: A stateless service does not rely on in-memory instance state to process the next request. Each request contains the required context, or the context is stored in an external system.

For example, instead of keeping a user's session in the memory of one Spring Boot instance, we can use a signed token or a shared session store.

Benefits include:

- Easier horizontal scaling.
- Better recovery after instance failure.
- Flexible load balancing.
- Simpler rolling deployments.

Note that stateless application instances may still depend on stateful databases, caches, or message brokers.

### Q7. How do you calculate how many instances are needed?

Suppose one instance sustainably handles 400 requests per second, and the expected load is 4,000 requests per second.

$$
N_{\text{theoretical}}=\frac{4000}{400}=10
$$

So, ten instances are required under the measured conditions.

However, ten instances leave no headroom if 400 RPS is the practical limit of each instance. If we target 70% of that capacity:

$$
N=\left\lceil\frac{4000}{400\times0.7}\right\rceil=15
$$

We would start with 15 instances as a capacity-planning estimate, then validate using load tests, failure scenarios, and real production metrics.

## 2. Throughput — Questions and Answers

### Q8. What is throughput in microservices?

Answer: Throughput is the amount of work a system completes per unit of time.

Common measurements include:

- RPS: requests per second.
- TPS: transactions per second.
- Messages per second: messages processed by a consumer.
- MB/s: data processed per second.

For example, if a payment service successfully completes 2,000 payment operations per second, its successful transaction throughput is 2,000 TPS.

Be careful to distinguish offered traffic, accepted requests, completed requests, and successful business transactions.

### Q9. What is the difference between throughput, latency, and concurrency?

- Throughput: How much work is completed per second.
- Latency: How long an individual operation takes.
- Concurrency: How many operations are in progress at the same time.

A system can have high throughput and high latency if it processes many requests concurrently. Conversely, it can have low latency but low throughput if it processes requests serially.

These metrics should be evaluated together.

### Q10. What is Little's Law, and how is it used?

Little's Law describes the relationship between average concurrency, throughput, and average time in a stable system:

$$
L=\lambda W
$$

Where:

- $L$ = average number of requests in the system.
- $\lambda$ = average throughput.
- $W$ = average time spent in the system.

Example: A service processes 2,000 requests per second, with an average response time of 100 milliseconds.

$$
L=2000\times0.1=200
$$

The service has approximately 200 requests in progress on average.

This is useful for capacity planning and reasoning about concurrency, but it does not tell you the exact number of threads required.

### Q11. Why can increasing the thread pool size reduce throughput?

Answer: More threads can improve concurrency when requests spend time waiting for I/O. However, too many threads introduce overhead:

- Context switching.
- Increased memory consumption.
- Lock contention.
- More concurrent database queries.
- Connection pool contention.
- CPU saturation.

For CPU-bound work, excessive threads usually do not improve throughput beyond what the available CPU resources can support.

For I/O-bound work, thread pool sizing should reflect wait time, resource limits, and the concurrency model. Measure before changing it.

### Q12. How do database connection pools affect throughput?

Answer: A connection pool reuses database connections instead of repeatedly opening and closing them.

An undersized pool can cause requests to wait for available connections. An oversized pool can overwhelm the database with concurrent work.

For example, if ten pods each have a pool size of 50, they can collectively attempt to maintain up to 500 database connections.

Therefore, pool sizing must consider the database's connection budget across all application instances, background workers, and administrative clients.

### Q13. How does caching improve throughput?

Answer: Caching avoids repeating expensive operations, especially database queries or remote API calls.

For example, if a product service receives 10,000 requests per second and 80% can be served from a cache, the database may avoid a substantial portion of the corresponding read workload.

Common approaches include:

- In-memory caching, such as Caffeine.
- Distributed caching, such as Redis.
- HTTP caching.
- CDN caching for suitable content.

Trade-offs include stale data, cache invalidation, memory limits, and cache stampedes. Caching is most useful when the data access pattern and freshness requirements justify it.

### Q14. A service receives 10,000 RPS but processes only 6,000 RPS. How do you troubleshoot?

Answer:

1. Confirm whether the figures represent offered requests, accepted requests, or completed requests.
2. Check CPU utilization, throttling, memory, and garbage collection.
3. Inspect application thread pools and connection pool wait times.
4. Review database query latency and connection usage.
5. Inspect downstream API latency and error rates.
6. Examine queue depth, Kafka lag, and rejected requests.
7. Use distributed tracing and profiling to locate expensive operations.
8. Run a controlled load test to identify the saturation point.

If incoming traffic continuously exceeds completed throughput, queues or waiting requests may grow until the service begins timing out or rejecting traffic. Introduce backpressure, load shedding, or rate limiting rather than allowing unbounded queues.

## 3. Latency in Microservices — Questions and Answers

### Q15. What is latency, and how is it different from response time?

Answer: Latency is the time taken for an operation or request to reach a specified point or complete a specified action. Response time usually refers to the elapsed time from sending a request until receiving its response.

In API monitoring, these terms are sometimes used interchangeably, so clarify what the metric measures.

For example, an API may take 300 ms end to end, including 20 ms of network overhead, 80 ms in application processing, and 200 ms waiting for a database response.

### Q16. What are p50, p95, and p99 latency?

Answer: These are latency percentiles.

- p50: 50% of requests complete at or below this latency; the median.
- p95: 95% complete at or below this latency.
- p99: 99% complete at or below this latency.

Example:

| Metric | Latency |
| --- | --- |
| p50 | 40 ms |
| p95 | 180 ms |
| p99 | 900 ms |

Most requests are fast, but a small percentage take much longer.

The average alone might hide these slow requests. High p99 latency can indicate database contention, garbage collection pauses, overloaded dependencies, connection establishment overhead, or other tail-latency problems.

### Q17. Why can p99 latency increase while average latency remains stable?

Answer: A small proportion of slow requests may have little impact on the average while dramatically affecting p99.

Possible causes include:

- Occasional slow database queries.
- Garbage collection pauses.
- Lock contention.
- Thread pool exhaustion.
- Network retransmissions.
- Slow downstream services.
- Cold cache misses.
- Uneven load distribution.

I would compare latency distributions over time, segment requests by endpoint and dependency, and inspect traces for slow requests. I would also compare error rates and resource utilization to determine whether the problem is capacity-related or isolated to a particular operation.

### Q18. What is tail latency amplification?

Answer: Tail latency amplification occurs when a request depends on multiple operations and the slow behavior of one or more operations disproportionately increases the total request latency.

Consider a service that calls five downstream services in parallel. If the overall request can complete only when all five responses arrive, the slowest response determines completion time.

If each dependency independently has a 99% probability of completing within a particular latency threshold, the probability that all five meet that threshold is:

$$
P(\text{all five})=0.99^5\approx95.1\%
$$

Thus, the combined operation meets the threshold only about 95.1% of the time under these assumptions.

Ways to reduce the impact include:

- Reducing unnecessary dependencies.
- Optimizing slow downstream calls.
- Using bounded concurrency.
- Applying timeouts and bulkheads.
- Returning partial results when the business operation permits it.
- Caching suitable data.

### Q19. How do retries affect latency?

Answer: Retries can recover from transient failures, but they can also increase latency and amplify load.

Suppose a downstream request has a 500 ms timeout. If the caller retries twice, the operation could spend up to approximately 1.5 seconds waiting on three attempts, excluding other overhead and backoff.

To use retries safely:

- Retry only transient failures.
- Use bounded attempts.
- Apply exponential backoff with jitter.
- Set an overall deadline for the operation.
- Avoid retrying simultaneously at every layer.
- Ensure that non-idempotent operations are protected against duplicate execution.

Retries should be part of a deliberate resilience strategy, not a default response to every failure.

### Q20. What is a timeout budget in a microservices architecture?

Answer: A timeout budget is the maximum time allocated to complete a request across its dependency chain.

Suppose an API gateway allows 2 seconds for an entire request. The upstream service might allocate 1.5 seconds to its own processing and downstream operations, preserving time for response generation and network overhead.

The key principles are:

1. Establish an end-to-end deadline.
2. Propagate or derive remaining time for downstream calls.
3. Configure connection, read, and overall request timeouts appropriately.
4. Avoid allowing each dependency to consume the full upstream timeout independently.
5. Cancel work when possible after the caller's deadline expires.

This prevents requests from continuing to consume resources long after they can provide a useful response.

### Q21. An API has p50 latency of 50 ms but p99 latency of 2 seconds. How would you troubleshoot it?

Answer:

1. Compare slow and fast requests using distributed traces.
2. Determine whether the delay occurs in application processing, database access, network communication, or a downstream API.
3. Check thread pool queues, connection acquisition time, and timeout counts.
4. Inspect JVM garbage collection and CPU throttling.
5. Compare cache hits and misses.
6. Identify whether the problem occurs at specific traffic levels or with specific request types.
7. Fix the identified bottleneck and validate the result with a repeatable load test.

I would not immediately increase pod count because the issue could be caused by a slow dependency or resource contention rather than insufficient application instances.

## 4. Performance Optimization — Questions and Answers

### Q22. What metrics would you monitor for a Spring Boot microservice?

Answer: I would monitor four main categories.

| Category | Key metrics |
| --- | --- |
| Traffic | Request rate, requests by endpoint, active requests |
| Latency | p50, p95, p99 response times |
| Errors | HTTP 5xx rate, exceptions, timeouts, failed transactions |
| Saturation | CPU, memory, GC pauses, thread pools, connection pools, queue depth |

I would also monitor dependency-specific metrics, such as database query duration, Kafka consumer lag, cache hit ratio, and downstream HTTP latency.

Spring Boot Actuator and Micrometer can expose application metrics. Prometheus can collect them, and Grafana can visualize them.

### Q23. How would you diagnose high CPU utilization in a Java microservice?

Answer:

1. Check whether the CPU usage is sustained or occurs in short bursts.
2. Determine whether the JVM is CPU-bound or waiting on external resources.
3. Capture a CPU profile using an appropriate profiler.
4. Inspect hot methods, tight loops, serialization, regular expressions, and excessive object processing.
5. Examine garbage collection activity.
6. Check synchronization and lock contention.
7. Review recent deployments and traffic changes.
8. Optimize the identified hot path and compare results under the same workload.

A thread dump can help identify blocked or runnable threads, but CPU profiling is generally more useful for finding methods consuming the most CPU.

** In Details

For a Spring Boot microservice, I would monitor metrics across several layers: application performance, JVM health, API performance, database health, infrastructure, and business functionality.

The goal is to answer five questions:

1. Is the service available?
2. Is it responding quickly?
3. Is it processing requests successfully?
4. Is it running efficiently?
5. Are downstream dependencies healthy?

## 1. Application / API metrics

These are the most important metrics for understanding microservice behavior.

| Metric | What it tells you |
| --- | --- |
| Request Count | Number of incoming API requests |
| Request Rate (RPS) | Requests processed per second |
| Response Time | Time taken to process requests |
| P50 Latency | Median response time |
| P95 Latency | 95% of requests complete within this time |
| P99 Latency | Identifies slow requests and tail latency |
| HTTP 2xx Count | Successful requests |
| HTTP 4xx Count | Client-side errors |
| HTTP 5xx Count | Server-side errors |
| Error Rate | Percentage of failed requests |
| Active Requests | Requests currently being processed |

Example:

Suppose your service has the following metrics:

- Request rate: 1,000 requests/sec
- P95 latency: 200 ms
- P99 latency: 800 ms
- Error rate: 2%
- HTTP 5xx: 1.5%

This indicates that some requests are taking significantly longer and the service is experiencing server-side failures.

## 2. JVM metrics

Since Spring Boot typically runs on the JVM, monitoring JVM health is essential.

| Metric | Why monitor it? |
| --- | --- |
| Heap Memory Used | Detect memory pressure |
| Heap Memory Max | Understand available heap capacity |
| Non-Heap Memory | Monitor Metaspace and other memory |
| Garbage Collection Count | Detect frequent GC |
| GC Pause Time | Identify application pauses |
| Thread Count | Monitor application threads |
| Deadlocked Threads | Detect thread deadlocks |
| CPU Usage | Detect CPU bottlenecks |
| JVM Uptime | Track application uptime |

Important warning signs:

- Heap usage continuously increasing.
- Frequent Full GC.
- Long GC pause times.
- Thread count growing continuously.
- CPU usage consistently above 80%.

## 3. Database metrics

If your Spring Boot service uses MySQL, PostgreSQL, Oracle, etc., monitor:

| Metric | Why monitor it? |
| --- | --- |
| Active DB Connections | Current database connections |
| Idle Connections | Available connections |
| Connection Pool Usage | Detect pool exhaustion |
| Connection Acquisition Time | Time to acquire a connection |
| Query Execution Time | Identify slow queries |
| Slow Query Count | Detect database performance issues |
| DB Connection Errors | Detect connectivity problems |
| Transaction Rollbacks | Identify failed transactions |
| Lock Wait Time | Identify database contention |

For Spring Boot applications using HikariCP, particularly monitor:

- `hikaricp.connections.active`
- `hikaricp.connections.idle`
- `hikaricp.connections.pending`
- `hikaricp.connections.max`
- `hikaricp.connections.timeout`

## 4. Thread pool and executor metrics

Spring Boot applications frequently use asynchronous processing and thread pools.

Monitor:

- Active thread count.
- Current pool size.
- Maximum pool size.
- Queue size.
- Rejected task count.
- Task execution time.
- Thread pool utilization.

For example, if your executor has 50 threads and all 50 are busy while the queue keeps growing, your service might eventually stop accepting new tasks.

## 5. External dependency metrics

Microservices communicate with other services, so monitor downstream dependencies.

For each dependent service, track:

| Metric | Description |
| --- | --- |
| Request Count | Number of outgoing calls |
| Response Time | Downstream response latency |
| Error Rate | Failed downstream calls |
| Timeout Count | Number of timed-out requests |
| Retry Count | Number of retries |
| Circuit Breaker State | Closed, Open, Half-Open |
| Connection Failures | Failed connections |

If you use Resilience4j, monitor its circuit breaker, retry, rate limiter, and bulkhead metrics.

## 6. Infrastructure metrics

Monitor the infrastructure where your Spring Boot application runs.

- CPU utilization.
- Memory utilization.
- Disk usage.
- Disk I/O.
- Network traffic.
- Network errors.
- Container restarts.
- Container memory limits.
- Kubernetes pod health.
- Pod CPU throttling.

If deployed on Kubernetes, also monitor:

- Pod restarts.
- CrashLoopBackOff events.
- OOMKilled events.
- Readiness probe failures.
- Liveness probe failures.
- Replica availability.

## 7. Business metrics

Technical metrics alone don't tell you whether the business functionality is working.

For example, if you have an e-commerce microservice, monitor:

- Orders created per minute.
- Orders successfully processed.
- Payment success rate.
- Payment failure rate.
- Order cancellation rate.
- Average order processing time.
- Pending orders.
- Failed transactions.

These metrics help detect business-level failures even when APIs return HTTP 200.

## 8. Recommended monitoring stack for Spring Boot

A common production monitoring architecture looks like this:

Spring Boot Microservice

REST APIs · JVM · Database · Thread Pools

Spring Boot Actuator + Micrometer

Expose application and JVM metrics

Prometheus

Scrapes and stores metrics

Grafana

Dashboards · Alerts · Visualization

Alertmanager

Alert notifications

Distributed Tracing

OpenTelemetry / Tempo / Jaeger

### Useful Spring Boot dependencies

For Maven:

xml

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
```

Configuration:

yaml

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus

  endpoint:
    health:
      show-details: when-authorized

  metrics:
    tags:
      application: order-service
```

Prometheus can scrape:

text

```text
http://localhost:8080/actuator/prometheus
```

Secure actuator endpoints appropriately in production.

## 9. My top 15 metrics for production monitoring

If I had to build a production dashboard for a Spring Boot microservice, I would prioritize these:

| Priority | Metric | Alert condition (example) |
| --- | --- | --- |
| 1 | Request rate | Sudden unexpected drop |
| 2 | P95 response time | Above 500 ms |
| 3 | P99 response time | Above 1 second |
| 4 | HTTP 5xx error rate | Above 1% |
| 5 | CPU utilization | Above 80% |
| 6 | JVM heap usage | Above 85% |
| 7 | GC pause time | Sustained high pauses |
| 8 | Thread pool utilization | Above 85% |
| 9 | DB active connections | Near maximum pool size |
| 10 | DB connection pending | Sustained pending requests |
| 11 | Slow query count | Unexpected increase |
| 12 | Downstream latency | Above service-specific SLO |
| 13 | Downstream error rate | Above threshold |
| 14 | Pod restart count | Unexpected restarts |
| 15 | Business transaction success rate | Below target |

These are illustrative starting thresholds, not universal production limits. Tune them according to your traffic patterns and SLOs.

## 10. One important concept: RED and USE methodologies

Two useful monitoring methodologies:

RED methodology (for microservices):

- Rate – How many requests per second?
- Errors – How many requests are failing?
- Duration – How long do requests take?

USE methodology (for infrastructure):

- Utilization – How much of the resource is being used?
- Saturation – How overloaded is the resource?
- Errors – How many resource-related errors occur?

Combining RED and USE gives you a strong foundation for production observability.

## Interview perspective

If an interviewer asks, "What metrics would you monitor for a Spring Boot microservice?", a good concise answer would be:

"I would monitor four major areas: application metrics, JVM metrics, infrastructure metrics, and dependency metrics. At the application level, I track request rate, P95/P99 latency, HTTP error rate, and throughput. At the JVM level, I track heap usage, GC pauses, CPU, and thread counts. For database and downstream dependencies, I monitor connection pool utilization, query latency, timeout rates, and circuit breaker status. Finally, I monitor business KPIs and use distributed tracing to troubleshoot requests across microservices. I would implement this using Spring Boot Actuator, Micrometer, Prometheus, and Grafana."

One additional recommendation: Don't just collect metrics. Connect them to distributed tracing and centralized logging using correlation or trace IDs. Metrics tell you something is wrong, logs and traces help you understand why it is wrong.

### Q24. How would you investigate a memory leak?

Answer: A memory leak occurs when objects remain reachable even though the application no longer needs them.

Symptoms may include continuously increasing heap usage, more frequent garbage collection, degraded latency, and eventual out-of-memory errors.

My approach would be:

1. Monitor heap usage after garbage collection.
2. Compare heap usage across repeated workload cycles.
3. Capture heap dumps safely.
4. Compare heap dumps to identify growing object populations.
5. Inspect GC roots and object references.
6. Check unbounded caches, static collections, retained request objects, and listener registrations.
7. Fix the retention issue and verify that memory stabilizes under a sustained test.

High memory usage alone does not prove a leak. The JVM may legitimately retain allocated heap space for reuse.

### Q25. What is the difference between CPU-bound and I/O-bound workloads?

Answer:

- CPU-bound: Most time is spent performing computation. Examples include encryption, compression, and intensive data transformation.
- I/O-bound: Most time is spent waiting for operations such as database queries, HTTP calls, or file access.

CPU-bound workloads often benefit from efficient algorithms and careful CPU parallelism. I/O-bound workloads may benefit from connection reuse, asynchronous I/O, concurrency improvements, and reduced waiting.

However, increasing concurrency is useful only while downstream capacity and resource limits can support it.

### Q26. How do you identify slow SQL queries?

Answer:

- Measure query duration and frequency.
- Use the database's query statistics and slow-query logs.
- Inspect execution plans using tools such as `EXPLAIN`.
- Check index usage, row counts, join strategies, and full table scans.
- Look for N+1 queries and excessive data retrieval.
- Examine locks, blocking transactions, and connection wait times.
- Validate any index or query changes under representative workloads.

For example, a query that retrieves a customer's orders might scan an entire orders table. A suitable index on the filtering columns may significantly reduce execution time, depending on selectivity and the query plan.

### Q27. What is the N+1 query problem?

Answer: The N+1 problem occurs when an application executes one query to retrieve a collection and then issues an additional query for each item in that collection.

For example, fetching 100 orders and separately querying the customer for every order may result in 101 database queries.

Possible solutions include:

- Fetch joins where appropriate.
- Batch fetching.
- Explicitly retrieving related entities in one query.
- DTO projections that retrieve only the required fields.
- Carefully designed caching.

In JPA/Hibernate, avoid blindly switching everything to eager fetching because it can create large joins, duplicate rows, and excessive memory consumption.

### Q28. A service performs well at 100 concurrent users but fails at 2,000. How would you investigate?

Answer:

I would increase load gradually and record throughput, latency percentiles, error rates, and resource utilization at each stage.

Then I would look for the saturation point:

- Does CPU reach its limit?
- Does the database connection pool become exhausted?
- Do thread queues grow?
- Does garbage collection become more frequent?
- Does a downstream API impose rate limits?
- Does queue depth grow faster than consumers can process work?
- Are requests rejected, queued indefinitely, or timing out?

I would optimize the bottleneck, establish safe concurrency limits, and rerun the same load test. The goal is to find the maximum sustainable throughput within the latency and error-rate targets, not merely the highest request rate the service can briefly accept.

### Q29. What is the difference between load testing, stress testing, spike testing, and soak testing?

| Test | Purpose |
| --- | --- |
| Load testing | Validate behavior under expected traffic |
| Stress testing | Find the breaking point beyond normal capacity |
| Spike testing | Observe response to sudden traffic increases |
| Soak testing | Detect long-running issues such as leaks and resource exhaustion |

For a production-ready microservice, I would establish a baseline with load testing, investigate capacity limits with stress testing, validate autoscaling with spike testing, and examine memory stability with soak testing.

## 5. Distributed Tracing — Questions and Answers

API Development Series Part 12: Monitoring & Analytics - Wasil Zafar

System Design Series Part 10: Monitoring & Observability - Wasil Zafar

What is Distributed Tracing and How to implement it with Open Source? | SigNoz

### Q30. What is distributed tracing?

Answer: Distributed tracing follows a request as it travels through multiple services and dependencies.

Consider an e-commerce request:

`API Gateway → Order Service → Inventory Service → Payment Service → Database`

A distributed trace provides a view of the work performed at each stage, including timing, errors, and relationships between operations.

It helps answer:

- Which service caused the delay?
- Where did the request fail?
- How much time was spent in each dependency?
- Did retries occur?
- Did the request cross asynchronous boundaries?

Common technologies include OpenTelemetry for instrumentation and context propagation, and Jaeger or Grafana Tempo for trace storage and visualization.

### Q31. What is the difference between a trace ID and a span ID?

Answer:

- Trace ID: Identifies the entire distributed operation.
- Span ID: Identifies one individual operation within the trace.

Example:

Trace ID: `abc123`

Entire checkout request

Span 1 — Order Service

Span ID: `span001`

Span 2 — Inventory Service

Span ID: `span002`

Span 3 — Payment Service

Span ID: `span003`

All three spans belong to the same trace, but each span has its own identifier. Parent-child relationships indicate how the operations are connected.

### Q32. What is the difference between logs, metrics, and traces?

Answer:

| Signal | Answers | Example |
| --- | --- | --- |
| Logs | What happened? | `Payment request timed out` |
| Metrics | How often, how much, or how long? | 5% payment timeout rate |
| Traces | Where did the time go? | Payment service consumed 1.2 seconds |

These signals complement each other.

For example, a latency dashboard reveals that p99 response time increased. Distributed traces identify the slow downstream service, while logs show the relevant exception or timeout details.

Correlating them through trace IDs, timestamps, and service metadata helps accelerate troubleshooting.

### Q33. How does trace context propagate between microservices?

Answer: The calling service injects tracing context into outgoing requests. The receiving service extracts that context and creates a related span.

For HTTP requests, a common standard is W3C Trace Context, which uses the `traceparent` header.

Conceptually:

1. Service A starts a trace.
2. Service A creates a client span and injects its context into the HTTP request.
3. Service B extracts the context and creates a server span.
4. Service B propagates context to Service C.
5. The tracing backend assembles the spans into a trace.

If a service does not propagate context correctly, a trace may appear broken into separate traces or may omit parts of the request path.

### Q34. How do you implement distributed tracing in Spring Boot?

Answer: A typical implementation uses OpenTelemetry instrumentation or supported Spring Boot observability integrations, depending on the application's version and requirements.

A common setup involves:

1. Instrument incoming HTTP requests.
2. Instrument outgoing HTTP clients.
3. Configure the OpenTelemetry SDK or a compatible agent.
4. Export traces using OTLP to a collector or supported backend.
5. Configure trace sampling and resource attributes.
6. Verify context propagation across synchronous and asynchronous calls.
7. Correlate trace IDs with application logs.

Illustrative configuration for an OpenTelemetry Java agent deployment:

bash
```
java \
  -javaagent:/opt/opentelemetry-javaagent.jar \
  -Dotel.service.name=order-service \
  -Dotel.exporter.otlp.endpoint=http://otel-collector:4317 \
  -Dotel.traces.exporter=otlp \
  -jar app.jar
```

This is an illustrative starting point. Actual configuration depends on the agent version, exporter protocol, TLS requirements, and deployment environment.

The Java agent can instrument many common frameworks automatically, reducing the need to create spans manually. Custom spans are useful for important business operations that automatic instrumentation does not capture.

### Q35. What is OpenTelemetry?

Answer: OpenTelemetry is an open-source observability framework for generating, collecting, and exporting telemetry data.

Its core signals include:

- Traces.
- Metrics.
- Logs.

It provides APIs, SDKs, instrumentation libraries, and a Collector.

The Collector can receive telemetry from applications, process or transform it, and export it to compatible observability backends. OpenTelemetry is not itself a trace-storage database or visualization platform.

### Q36. What is the difference between head-based and tail-based sampling?

Answer:

- Head-based sampling: The sampling decision is made near the beginning of the trace. It is relatively simple and can reduce instrumentation export volume early.
- Tail-based sampling: The decision is made after spans have been collected, allowing policies based on trace characteristics such as errors or duration.

For example, a head-based policy might sample 10% of traces. A tail-based policy might retain all traces with errors or unusually high latency, subject to its configuration and resource limits.

Tail-based sampling can preserve diagnostically valuable traces, but it requires infrastructure capable of collecting and evaluating trace data before making the final sampling decision.

### Q37. How would you troubleshoot a trace that is missing spans?

Answer:

I would investigate in this order:

1. Confirm that all relevant services are instrumented.
2. Verify that the incoming trace context is extracted correctly.
3. Check whether outgoing HTTP or messaging clients propagate context.
4. Inspect sampling configuration.
5. Check exporter errors, Collector logs, and backend ingestion limits.
6. Verify that asynchronous execution preserves context.
7. Confirm that the spans fall within the same trace and expected time window.

The cause may be missing instrumentation, broken propagation, sampling, dropped telemetry, or a backend query issue. Missing spans do not necessarily mean that the underlying operation never happened.

### Q38. How do you trace asynchronous Kafka communication?

Answer: The producer creates or continues a trace and injects the appropriate tracing context into Kafka message headers. The consumer extracts that context and creates a related processing span.

The trace can then connect:

`HTTP Request → Order Service → Kafka Publish → Kafka Consumer → Inventory Update`

Depending on the messaging pattern and tracing implementation, the relationship may be represented through parent-child spans or span links.

I would verify that the Kafka instrumentation supports the client library and that context propagation works across the producer and consumer boundaries. Retries and dead-letter queues should also be instrumented so that failed processing can be investigated.

### Q39. How do you reduce distributed tracing overhead?

Answer:

- Use appropriate sampling policies.
- Avoid creating excessive custom spans for trivial operations.
- Use bounded queues and sensible batch-export settings.
- Set limits on attributes, events, and span counts.
- Avoid attaching large request or response payloads.
- Filter sensitive data.
- Monitor Collector resource utilization and dropped telemetry.
- Use trace retention policies suited to diagnostic needs.

Never include passwords, access tokens, payment card data, or other sensitive payloads in span attributes.

## 6. Real-World Microservices Troubleshooting Scenarios

These are common senior-level interview questions. Use the symptom → investigation → root cause → solution → validation approach when answering.

### Q40. API latency increases from 200 ms to 2 seconds, but CPU utilization is normal. What would you do?

Answer:

Normal CPU usage does not mean the service is healthy. It may be waiting for I/O or blocked on a dependency.

My troubleshooting steps would be:

1. Check p95 and p99 latency, request rate, and error rate.
2. Inspect distributed traces to determine where the extra time is spent.
3. Check database connection acquisition time and query execution time.
4. Examine downstream API latency and timeout rates.
5. Check thread pool queues and blocked threads.
6. Inspect recent deployments and configuration changes.
7. Fix the identified bottleneck and verify the result through load testing.

For example, if the trace shows that database connection acquisition takes 1.5 seconds, I would investigate connection pool exhaustion and database capacity rather than increase CPU resources.

### Q41. A downstream service is slow, and upstream services start failing. How do you prevent cascading failures?

Answer:

I would combine several resilience mechanisms:

- Timeouts: Prevent requests from waiting indefinitely.
- Circuit breakers: Temporarily stop calls to an unhealthy dependency.
- Bulkheads: Isolate resources so one dependency cannot consume all available capacity.
- Bounded retries: Retry eligible transient failures with backoff and jitter.
- Rate limiting: Restrict incoming traffic to a sustainable rate.
- Backpressure: Prevent queues and waiting work from growing without bound.
- Graceful degradation: Return partial or reduced functionality when the business permits it.

For example, if a recommendation service is slow, the product page might display the product without recommendations. The checkout path, however, must preserve essential inventory and payment correctness.

### Q42. Kafka consumer lag keeps increasing. How would you troubleshoot it?

Answer: Consumer lag is the difference between the latest available offsets and the offsets processed or committed by consumers, interpreted according to the monitoring system's convention.

I would check:

1. Incoming message rate versus processing rate.
2. Consumer processing duration and error rate.
3. Database or HTTP calls performed by consumers.
4. Number of topic partitions and active consumers.
5. Consumer rebalances and repeated failures.
6. Batch size, polling configuration, and commit behavior.
7. Whether downstream services are throttling consumers.

If a topic has 12 partitions, a consumer group generally cannot have more than 12 consumers actively assigned partitions at the same time. Adding more consumers beyond that does not increase parallelism for that group unless the partition count or consumption design changes.

### Q43. A service receives 5,000 RPS and needs to handle 50,000 RPS. How would you approach the design?

Answer:

I would not simply multiply the number of pods by ten without testing.

My approach would be:

1. Establish the current sustainable throughput and latency SLOs.
2. Load-test representative traffic to identify bottlenecks.
3. Profile CPU, memory, database, network, and downstream calls.
4. Optimize inefficient queries and application hot paths.
5. Introduce caching where freshness requirements permit.
6. Scale stateless instances horizontally.
7. Protect databases and dependencies with concurrency limits and backpressure.
8. Scale Kafka consumers according to partition and processing constraints.
9. Configure autoscaling and test sudden traffic spikes.
10. Validate 50,000 RPS under failure scenarios, not only under ideal conditions.

The objective is to sustain the target traffic while meeting latency, availability, and error-rate requirements.

### Q44. How would you investigate a production performance regression after deployment?

Answer:

I would compare the new deployment with the previous known-good version.

- Compare throughput, p95/p99 latency, and error rates.
- Review changes to code, configuration, dependencies, and resource limits.
- Examine traces to identify operations whose duration increased.
- Compare CPU profiles and allocation patterns if necessary.
- Inspect database query plans and connection pool behavior.
- Check garbage collection, thread pool saturation, and downstream behavior.
- Roll back if the regression threatens reliability, following the deployment and incident-management procedures.

After remediation, I would repeat the performance test and add regression checks to the deployment pipeline.

## 7. Numerical Interview Questions with Answers

### Q45. A service processes 2,000 RPS with 100 ms average latency. How many requests are in progress on average?

Using Little's Law:

$$
L=\lambda W
$$

$$
L=2000\times0.1=\boxed{200}
$$

Answer: Approximately 200 requests are in progress on average, assuming a stable system and consistent measurement boundaries.

### Q46. Three services take 20 ms, 80 ms, and 150 ms sequentially. What is the total latency?

$$
T=20+80+150=\boxed{250\text{ ms}}
$$

Answer: 250 ms, excluding network overhead, queuing, and other processing.

If the services execute in parallel and all results are required, the idealized execution time is approximately the slowest duration, 150 ms, plus orchestration and communication overhead.

### Q47. Incoming traffic is 800 messages/sec, but consumers process 500 messages/sec. How fast does lag grow?

$$
\Delta Q=800-500=\boxed{300\text{ messages/sec}}
$$

Answer: Lag grows by approximately 300 messages per second if both rates remain constant.

After 10 minutes:

$$
Q=300\times600=\boxed{180,000\text{ messages}}
$$

This assumes no initial lag reduction, no change in processing capacity, and no message loss or traffic fluctuation.

### Q48. One instance handles 400 RPS. How many instances are required for 4,000 RPS?

At the measured capacity:

$$
N=\frac{4000}{400}=\boxed{10}
$$

Answer: Ten instances theoretically meet the target. More may be needed for headroom, uneven load distribution, failures, and peak demand.

At a 70% target utilization of the measured per-instance capacity:

$$
N=\left\lceil\frac{4000}{400(0.7)}\right\rceil
=\boxed{15}
$$

This is a starting estimate, not a substitute for testing.

### Q49. A downstream dependency has a 500 ms timeout, but the API gateway times out after 300 ms. What happens?

Answer: The gateway can terminate the request before the downstream call reaches its own timeout. The backend may continue processing after the caller has given up, consuming resources unnecessarily.

A better design aligns timeouts with an end-to-end deadline and gives downstream operations less time than their callers have remaining. Cancellation should be propagated where supported.

### Q50. A service has a 99.9% availability SLO. How much downtime is allowed in a 30-day month?

A 30-day month contains:

$$
30\times24\times60=43,200\text{ minutes}
$$

The allowed downtime at 0.1% is:

$$
43,200\times0.001=\boxed{43.2\text{ minutes}}
$$

Answer: Approximately 43 minutes and 12 seconds, assuming the SLO is measured continuously over that 30-day window. Actual error-budget calculations depend on the service's SLO definition and measurement method.

## 8. Quick Revision: The Most Important Concepts

| Topic | Interview-ready takeaway |
| --- | --- |
| Scaling | Add capacity only after identifying the bottleneck. |
| Throughput | Measure completed work, not just incoming requests. |
| Latency | Track p95/p99, not just averages. |
| Performance | Profile and measure before optimizing. |
| Thread pools | More threads do not always mean more throughput. |
| Database | Application scaling can overwhelm shared data stores. |
| Caching | Improves efficiency but introduces freshness and invalidation concerns. |
| Retries | Use bounded retries, backoff, jitter, and idempotency. |
| Distributed tracing | Use traces to locate where time is spent across services. |
| OpenTelemetry | Provides vendor-neutral telemetry instrumentation and collection. |
| Kafka | Consumer parallelism is constrained by partition assignment. |
| Resilience | Use timeouts, circuit breakers, bulkheads, and backpressure together. |
| SLOs | Optimize against measurable reliability and latency targets. |

## 9. Recommended interview preparation order

1. Fundamentals: Scaling, throughput, concurrency, latency percentiles, and trace/span IDs.
2. Implementation: Spring Boot metrics, connection pools, caching, OpenTelemetry, and Kafka context propagation.
3. Troubleshooting: High p99 latency, database bottlenecks, consumer lag, CPU spikes, and memory leaks.
4. System design: Capacity planning, autoscaling, resilience, distributed tracing, and SLOs.
5. Hands-on practice: Load-test a Spring Boot service, inspect metrics and traces, introduce a slow dependency, and diagnose the resulting latency increase.

Interview tip: For every scenario, explain not just what tool you would use, but which metric or trace evidence would confirm your hypothesis, what trade-offs your fix introduces, and how you would verify the improvement.

---
# Microservices Scaling: Interview Questions with Code Examples

These eight questions cover scaling fundamentals, load balancing, stateless services, Docker, Kubernetes, and autoscaling. The examples use Java with Spring Boot, Docker, and Kubernetes, which are common technologies in microservices architectures.

## 1. What is scaling in microservices, and why is it required?

Answer: Scaling is the process of increasing or decreasing the resources available to a microservice so that it can handle changes in traffic, workload, and data volume while meeting performance and availability requirements.

There are two main approaches:

- Vertical scaling: Increase the CPU or memory of an existing instance.
- Horizontal scaling: Add or remove instances of the service.

### Example: Spring Boot microservice

Suppose we have a product service that returns product information.

java
```
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Map<String, Object> getProduct(
            @PathVariable Long id) {

        return Map.of(
            "id", id,
            "name", "Laptop",
            "price", 75000
        );
    }
}
```

Initially, we run one instance:

Incoming requests

Product Service — 1 instance

If traffic increases, a single instance may reach its CPU, memory, thread, or connection limits.

We can run multiple instances:

Incoming requests

Load balancer

Instance 1

Instance 2

Instance 3

### Why is scaling required?

1. Handle increased user traffic.
2. Maintain acceptable response times.
3. Improve availability if an instance fails.
4. Handle seasonal or sudden traffic spikes.
5. Use infrastructure resources efficiently.
6. Support business growth without redesigning the entire application.

Interview example: An e-commerce product service handles 1,000 requests per second, but traffic increases to 5,000 requests per second during a sale. We can add more instances, provided the database and other dependencies can support the additional load.

## 2. What is the difference between horizontal scaling and vertical scaling?

### Horizontal scaling

Add more instances of the same service.

Example:

- Initially: 1 instance with 2 CPU cores and 4 GB RAM.
- After scaling: 4 instances, each with 2 CPU cores and 4 GB RAM.

### Vertical scaling

Increase the resources of an existing instance.

Example:

- Initially: 1 instance with 2 CPU cores and 4 GB RAM.
- After scaling: 1 instance with 8 CPU cores and 16 GB RAM.

Server Rack

Vertical scaling

One larger server

2 CPU → 8 CPU

4 GB → 16 GB RAM

network workstation servers 3d illustration

Horizontal scaling

Multiple servers

1 instance → 4 instances

Requests distributed across instances

### Comparison

| Feature | Horizontal | Vertical |
| --- | --- | --- |
| Method | Add instances | Increase machine resources |
| Capacity | Grows across instances | Limited by machine capacity |
| Fault tolerance | Can survive individual instance failures if designed correctly | One instance may remain a single point of failure |
| Complexity | Requires load balancing and distributed-state considerations | Often simpler |
| Cost | Can grow incrementally | Larger machines can become expensive |
| Best suited for | Cloud-native, distributed services | Workloads that benefit from larger machines or are harder to distribute |

### Code/configuration example

Vertical scaling in Docker Compose:

yaml
```
services:
  product-service:
    image: product-service:1.0
    cpus: "4.0"
    mem_limit: 4g
```

This sets resource limits for one container, subject to host capacity and Docker's resource controls.

Horizontal scaling with Docker Compose:

bash
```
docker compose up -d --scale product-service=4
```

This requests four service containers. It does not automatically configure a load balancer or guarantee that all four instances are reachable through one published port.

Interview takeaway: Vertical scaling makes an instance bigger; horizontal scaling adds more instances to distribute work.

## 3. What are the advantages of horizontal scaling over vertical scaling?

Answer: Horizontal scaling is useful because it lets us distribute traffic across multiple instances and increase capacity incrementally.

The main advantages are:

- Improved resilience: Requests can continue through healthy instances if another instance fails, provided routing and dependencies remain available.
- Elasticity: Instances can be added or removed as demand changes.
- Incremental capacity: We can increase capacity in smaller steps.
- Cloud-native compatibility: It works naturally with containers and Kubernetes.
- Workload isolation: Separate instances can process requests independently.
- Maintenance flexibility: Instances can be replaced or updated gradually.

### Example: Spring Boot and Kubernetes

Suppose our application starts with three replicas:

yaml
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: product-service
spec:
  replicas: 3
  selector:
    matchLabels:
      app: product-service
  template:
    metadata:
      labels:
        app: product-service
    spec:
      containers:
        - name: product-service
          image: product-service:1.0
          ports:
            - containerPort: 8080
```

If traffic increases, we can scale to six replicas:

bash
```
kubectl scale deployment product-service --replicas=6
```

Kubernetes attempts to maintain six replicas, subject to available cluster resources and scheduling constraints.

### Important limitation

Horizontal scaling is not always better. It may introduce:

- Network communication overhead.
- Distributed consistency challenges.
- More database connections.
- Additional operational complexity.
- Shared dependency bottlenecks.

For example, if all six instances connect to a database that can handle only 100 concurrent connections, increasing the number of instances may worsen database contention.

Interview takeaway: Horizontal scaling improves elasticity and can improve fault tolerance, but only when shared dependencies and distributed-state requirements are designed appropriately.

## 4. How does a load balancer distribute requests across multiple service instances?

Answer: A load balancer receives incoming requests and forwards them to healthy service instances according to a routing algorithm.

Common algorithms include:

- Round robin: Distributes requests sequentially across instances.
- Least connections: Prefers the instance with fewer active connections.
- Weighted round robin: Sends more traffic to instances with higher assigned weights.
- IP hash: Uses the client's IP address to select an instance.
- Least response time: Prefers instances based on observed response times and active connections, depending on the implementation.

### Architecture

Client / Browser

Load Balancer

Routing + health checks

Instance A

Healthy

Instance B

Healthy

Instance C

Healthy

### Example 1: NGINX load balancer

Suppose three Spring Boot instances listen on ports 8081, 8082, and 8083.

nginx
```
http {
    upstream product_backend {
        least_conn;

        server product-1:8081;
        server product-2:8082;
        server product-3:8083;
    }

    server {
        listen 80;

        location /products/ {
            proxy_pass http://product_backend;
        }
    }
}
```

NGINX distributes requests to the configured upstream servers using the `least_conn` method.

The hostnames in this example must resolve to the actual instances, such as through Docker networking. Production configurations should also include appropriate timeouts and health-check or service-discovery mechanisms.

### Example 2: Kubernetes Service

In Kubernetes, a Service provides a stable network endpoint for a group of matching Pods.

yaml
```
apiVersion: v1
kind: Service
metadata:
  name: product-service
spec:
  selector:
    app: product-service
  ports:
    - port: 80
      targetPort: 8080
  type: ClusterIP
```

When the Deployment creates multiple Pods with the label `app: product-service`, Kubernetes networking directs traffic to eligible endpoints.

Check the available endpoints using:

bash
```
kubectl get endpointslice \
  -l kubernetes.io/service-name=product-service
```

Important distinction: A Kubernetes Service distributes traffic within the cluster. External traffic may require an Ingress controller, Gateway, cloud load balancer, or another entry point.

### What happens if an instance fails?

A properly configured load-balancing system can stop routing new requests to an unhealthy instance after health checks or endpoint updates identify the failure.

For Spring Boot, a readiness endpoint can be exposed through Actuator:

properties
```
management.endpoints.web.exposure.include=health
management.endpoint.health.probes.enabled=true
```

The readiness endpoint is typically available at `/actuator/health/readiness` when the relevant Actuator health probes are enabled.

A readiness check indicates whether an instance should receive traffic. A liveness check indicates whether it should be restarted. These checks serve different purposes.

## 5. What is the difference between scaling a monolith and scaling microservices?

Answer: In a traditional monolith, multiple application instances typically run the entire application. In a microservices architecture, each independently deployed service can be scaled according to its own workload.

### Monolithic architecture

Suppose an e-commerce application contains:

- Product management
- Order management
- Payment processing
- Notifications

All components are deployed together.

Monolithic Application

Products

Orders

Payments

Notifications

Scaling the deployment generally duplicates all modules.

If product browsing receives heavy traffic, we may need to add entire monolith instances even if order and notification processing need little additional capacity.

### Microservices architecture

Each service is deployed and scaled independently.

Product Service

6 replicas

Order Service

3 replicas

Payment Service

2 replicas

Notification Service

1 replica

The replica counts above are illustrative, not universal recommendations.

### Comparison

| Factor | Monolith | Microservices |
| --- | --- | --- |
| Scaling unit | Usually the whole application | Individual services |
| Independent deployment | Usually limited | Supported by service boundaries |
| Resource efficiency | May allocate resources to lightly used modules | Can allocate resources according to service demand |
| Operational complexity | Generally simpler | Higher due to networking, monitoring, and coordination |
| Shared dependencies | Often internal components and shared databases | Network calls and shared or service-owned dependencies |
| Failure modes | A failure can affect the whole process | Failures can be isolated, but may propagate through dependencies |

### Example

Suppose product browsing receives 10 times more traffic than notifications.

With microservices, we can scale only the product service:

bash
```
kubectl scale deployment product-service --replicas=10
```

We do not necessarily need to scale the notification service at the same rate.

Interview takeaway: Microservices enable independent scaling, but this benefit depends on sensible service boundaries, capacity planning, and control of shared dependencies. A well-designed monolith can also scale horizontally.

## 6. What is a stateless service, and why is statelessness important for scaling?

Answer: A stateless service does not depend on information stored only in a particular application instance's memory to process the next request.

Each request carries the required information, or the service retrieves that information from an external state store.

### Example of a stateful service

java
```
@RestController
public class CounterController {

    private int counter = 0;

    @GetMapping("/counter")
    public int increment() {
        return ++counter;
    }
}
```

Here, `counter` is stored in the memory of one application instance.

If a load balancer sends requests to three instances, each instance has its own counter. The values can diverge, and restarting an instance resets its counter.

This is a simple illustration of instance-local state; a shared counter would require appropriate synchronization or atomic operations.

### Example of a stateless service

java
```
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Map<String, Object> getProduct(
            @PathVariable Long id) {

        return Map.of(
            "id", id,
            "name", "Laptop"
        );
    }
}
```

The response depends on the request and application logic, not on a counter held in the particular instance's memory.

For real product data, the service would usually retrieve the product from a database or cache.

### What about user sessions?

Avoid storing the only copy of a session in the memory of one application instance if requests must be routed freely across instances.

Common alternatives include:

- Signed access tokens, such as JWTs, when appropriate.
- A shared session store such as Redis.
- Database-backed sessions.

For example, a signed JWT can carry user identity and expiry information, allowing multiple instances to validate it without sharing a local session object. Token revocation and authorization still require deliberate design.

### Benefits of statelessness

1. Requests can be sent to any healthy instance.
2. New instances can join without session migration.
3. Failed instances can be replaced more easily.
4. Load balancing is simpler.
5. Rolling deployments become easier.

Interview takeaway: Statelessness makes horizontal scaling easier, but it does not mean the entire system is stateless. Databases, caches, and message brokers can still maintain state.

## 7. How do Docker and Kubernetes help scale microservices?

Answer: Docker packages a microservice and its runtime dependencies into a container image. Kubernetes manages containerized workloads across a cluster, including replicas, scheduling, networking, health checks, and scaling.

### Docker's role

Docker helps provide consistent environments across development, testing, and production.

Example `Dockerfile` for a Spring Boot application:

dockerfile
```
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/product-service.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
```

Build and run the image:

bash
```
docker build -t product-service:1.0 .
docker run -p 8080:8080 product-service:1.0
```

Docker can run multiple containers, but running multiple containers does not by itself provide automatic traffic distribution, health-based routing, or autoscaling.

### Kubernetes' role

Kubernetes manages multiple replicas and attempts to maintain the desired number of running Pods.

Example Deployment:

yaml
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: product-service
spec:
  replicas: 3
  selector:
    matchLabels:
      app: product-service
  template:
    metadata:
      labels:
        app: product-service
    spec:
      containers:
        - name: product-service
          image: product-service:1.0
          ports:
            - containerPort: 8080
          resources:
            requests:
              cpu: "250m"
              memory: "256Mi"
            limits:
              cpu: "1"
              memory: "512Mi"
```

This declares three desired replicas and specifies resource requests and limits for each container.

Deploy it with:

bash
```
kubectl apply -f deployment.yaml
```

Check the Pods:

bash
```
kubectl get pods -l app=product-service
```

Scale the Deployment:

bash
```
kubectl scale deployment product-service --replicas=5
```

Kubernetes attempts to maintain five replicas. Actual availability depends on cluster capacity, image availability, scheduling, and application health.

### Docker vs. Kubernetes

| Feature | Docker | Kubernetes |
| --- | --- | --- |
| Primary role | Build and run containers | Orchestrate containerized workloads |
| Container images | Builds or runs images | Deploys workloads using images |
| Replicas | Can run multiple containers manually | Maintains desired replica counts |
| Service discovery | Available through configured networking | Built-in Service and DNS mechanisms |
| Self-healing | Limited to configured runtime behavior | Reconciles Pods and supports health-based restarts |
| Autoscaling | Not a complete orchestration autoscaler | Supports HPA and other scaling mechanisms |

Interview takeaway: Docker packages the application; Kubernetes orchestrates, distributes, and scales its instances.

## 8. What is auto-scaling, and which metrics can trigger it?

Answer: Auto-scaling automatically increases or decreases application capacity based on workload, resource utilization, or other configured metrics.

For example, when product-service CPU utilization rises, Kubernetes may increase its replicas. When demand falls, it may reduce them, subject to the configured minimum and maximum.

### Common autoscaling metrics

| Metric | When it is useful |
| --- | --- |
| CPU utilization | CPU-intensive services |
| Memory utilization | Memory-sensitive workloads, with careful consideration of whether scaling reduces memory pressure |
| Requests per second | Traffic-heavy APIs |
| Active requests or queue depth | Services accumulating concurrent work |
| Kafka consumer lag | Asynchronous event processing |
| Custom business metrics | Workloads whose demand is not well represented by CPU |

CPU and memory are resource metrics. RPS, queue depth, and consumer lag often require an appropriate metrics adapter or monitoring integration.

### Example 1: Kubernetes HPA using CPU

First, the Deployment should define CPU requests so Kubernetes can calculate CPU utilization relative to requested CPU.

The following HPA scales between 2 and 10 replicas:

yaml
```
apiVersion: autoscaling/v2
kind: HorizontalPodAutoscaler
metadata:
  name: product-service-hpa
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: product-service
  minReplicas: 2
  maxReplicas: 10
  metrics:
    - type: Resource
      resource:
        name: cpu
        target:
          type: Utilization
          averageUtilization: 70
```

Apply the configuration:

bash
```
kubectl apply -f hpa.yaml
```

Check the scaling status:

bash
```
kubectl get hpa
kubectl describe hpa product-service-hpa
```

If the average CPU utilization exceeds the target, the HPA can increase replicas, subject to its control algorithm, stabilization behavior, available metrics, and cluster resources.

Important: The HPA does not guarantee that CPU will remain at exactly 70%. It continuously adjusts toward a target.

### Example 2: Scaling with requests per second

CPU is not always a good indicator of load. An I/O-bound service might have high latency and increasing requests while CPU usage remains low.

For such workloads, we can use a custom metric, such as requests per second per Pod, if it is exposed through a compatible metrics adapter.

Conceptually:

yaml
```
metrics:
  - type: Pods
    pods:
      metric:
        name: http_requests_per_second
      target:
        type: AverageValue
        averageValue: "200"
```

This is a partial HPA metric configuration, not a complete standalone manifest. It requires the `http_requests_per_second` metric to be available through the Kubernetes custom metrics API.

The target means approximately 200 requests per second per Pod, averaged according to the metric's semantics. It should be selected using load testing rather than assumed to be universally safe.

### Example 3: Scaling Kafka consumers

A Kafka consumer service may be better scaled using consumer lag than CPU utilization.

Suppose incoming traffic increases while each consumer is waiting on database calls. CPU utilization may remain low even though lag grows.

A suitable autoscaling system can use Kafka lag to increase consumer replicas. However, active consumption within a consumer group is constrained by the number of topic partitions.

For example, if the topic has 12 partitions, increasing a consumer group from 12 to 20 consumers will not give all 20 consumers active partition assignments simultaneously.

### What are the risks of autoscaling?

- Scaling too slowly during sudden traffic spikes.
- Scaling too aggressively and increasing database load.
- Repeated scale-up and scale-down oscillations.
- Insufficient cluster capacity to schedule new Pods.
- Using CPU metrics when the actual bottleneck is I/O.
- Scaling consumers beyond useful partition parallelism.

A production setup should consider minimum and maximum replicas, stabilization windows, resource requests, startup times, downstream capacity, and meaningful scaling metrics.

## Final interview revision

The most important distinction is:

- Scaling: Increasing or decreasing capacity.
- Horizontal scaling: Adding or removing instances.
- Vertical scaling: Increasing or decreasing resources per instance.
- Load balancing: Distributing requests among eligible instances.
- Statelessness: Allowing requests to be handled by different instances without depending on instance-local state.
- Docker: Packaging and running containers.
- Kubernetes: Orchestrating workloads and maintaining desired replicas.
- Autoscaling: Adjusting capacity automatically based on measured demand.

In an interview, connect these concepts rather than treating them separately: a stateless Spring Boot service runs in Docker, Kubernetes manages its replicas, a Service or load balancer routes requests, and an HPA adjusts replica counts based on suitable metrics. The database and other dependencies must also be able to handle the resulting load.

---
# Microservices Scaling: 8 Interview Questions with Answers and Code Examples

These questions focus on real-world scaling challenges in Java/Spring Boot microservices, databases, caching, session management, and Kubernetes.

The key principle is: identify the bottleneck before adding more instances. Low CPU utilization does not necessarily mean a service has spare capacity; it may be waiting for a database, an external API, a connection, or a lock.

## 1. How do you scale a service when CPU utilization is low but response times are high?

Answer: First, identify where requests are spending their time. Low CPU utilization combined with high latency often indicates an I/O bottleneck, connection pool exhaustion, lock contention, or an overloaded downstream dependency.

### Example scenario

Suppose a Spring Boot order service has these metrics:

| Metric | Observed value |
| --- | --- |
| CPU utilization | 20% |
| Average API latency | 2 seconds |
| Database query latency | 1.5 seconds |
| Database connection pool | 50 connections |
| Waiting requests for connections | Increasing |

Adding more CPU resources will probably not solve the problem. The service is spending most of its time waiting for database access.

### How would you troubleshoot it?

1. Check p95 and p99 latency.
2. Inspect distributed traces to identify slow spans.
3. Measure database connection acquisition time separately from query execution time.
4. Check thread pool queues and blocked threads.
5. Inspect downstream API latency and database locks.
6. Optimize the actual bottleneck before increasing replicas.

### Code example: Measure API latency in Spring Boot

java
```
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(
            @PathVariable Long id) {

        long start = System.nanoTime();

        try {
            return ResponseEntity.ok(
                orderService.getOrder(id)
            );
        } finally {
            long elapsedMs =
                (System.nanoTime() - start) / 1_000_000;

            // Illustrative only; prefer metrics for production.
            System.out.println(
                "getOrder latency: " + elapsedMs + " ms"
            );
        }
    }
}
```

For production, use Micrometer timers or distributed tracing rather than logging every request synchronously. Record latency distributions and avoid high-cardinality metric labels.

### Kubernetes consideration

CPU-based autoscaling may not react to a service that is waiting on database calls. A custom metric such as active requests, queue depth, or requests per second may be more appropriate.

However, increasing replicas is safe only if the database can handle the additional concurrent requests.

Interview takeaway: Low CPU and high latency usually call for bottleneck analysis first, not automatic scale-out.

## 2. How would you scale a microservice that depends on a single database?

Answer: I would identify the database bottleneck, optimize the workload, and introduce appropriate controls before increasing application replicas.

A typical progression is:

1. Optimize SQL queries and indexes.
2. Reduce unnecessary database calls.
3. Cache frequently accessed data.
4. Tune database connection pools.
5. Use read replicas for suitable read-heavy workloads.
6. Batch writes where appropriate.
7. Partition or shard data if workload and scale justify the added complexity.
8. Apply backpressure and admission control to protect the database.

### Example architecture

Load Balancer

Order Pod 1

Order Pod 2

Order Pod 3

Shared database

Potential bottleneck

Adding more order-service Pods increases potential concurrency against the same database. This can make database saturation worse.

### Code example: Cache frequently accessed data

Using Spring's caching abstraction:

java
```
@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Cacheable(
        cacheNames = "products",
        key = "#id"
    )
    public Product getProduct(Long id) {
        return repository.findById(id)
            .orElseThrow(() ->
                new RuntimeException("Product not found")
            );
    }
}
```

Enable caching:

java
```
@Configuration
@EnableCaching
public class CacheConfig {
}
```

This avoids repeated database reads for cache hits. The cache provider must be configured separately, and the cache needs an appropriate expiry and invalidation strategy.

### When should you use read replicas?

Read replicas can help when read traffic dominates and the application can tolerate the replica's consistency characteristics.

For example:

- Product catalog reads → potentially served by replicas.
- Payment writes → typically require the authoritative write database.
- Inventory reservations → need careful consistency and concurrency control.

Interview takeaway: Scale the application and database as one capacity-planning problem. Application replicas alone cannot eliminate a single database bottleneck.

## 3. How do you handle session management when scaling service instances horizontally?

Answer: When an application scales horizontally, requests from the same user can reach different service instances. If a user's session exists only in one instance's memory, another instance may not recognize that session.

Three common approaches are:

- Stateless authentication with JWT: Each request carries a signed token containing the required identity and claims.
- Shared session storage: Store sessions in Redis or another shared data store.
- Sticky sessions: Configure the load balancer to route a user to the same instance when possible.

### Option A: Stateless authentication using JWT

The client sends a token with each request:

http
```
GET /profile
Authorization: Bearer <access-token>
```

Each service instance validates the token using the appropriate signing key or public key.

Client with access token

Load balancer

Instance A

Instance B

Both instances validate the same token independently.

Illustrative Spring Security configuration for an API that accepts JWTs:

java
```
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        return http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth -> oauth
                .jwt(Customizer.withDefaults())
            )
            .build();
    }
}
```

This configures JWT resource-server authentication; the application's issuer or public-key configuration must also be supplied.

Advantages: No server-local session is required, and any healthy instance can validate a request.

Trade-offs: Revocation, logout, token expiry, key rotation, and changes to user permissions need deliberate handling.

### Option B: Shared sessions using Redis

If the application needs server-side session state, store it centrally so every instance can access it.

Spring Boot can use Spring Session with Redis:

xml
```
<dependency>
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session-data-redis</artifactId>
</dependency>
```

Example configuration:

properties
```
spring.session.store-type=redis
spring.data.redis.host=redis
spring.data.redis.port=6379
```

This is a configuration fragment; Redis connectivity, Spring Session integration, and compatible Spring Boot dependencies must be in place.

### Option C: Sticky sessions

Sticky sessions try to route the same client to the same instance.

They can help legacy applications that depend on local session state, but they have disadvantages:

- Uneven load distribution.
- Session loss when an instance fails.
- Reduced flexibility during scaling and deployments.

Interview takeaway: Prefer stateless authentication or shared session storage when possible. Sticky sessions are a workaround, not a substitute for reliable session-state design.

## 4. What challenges arise when scaling services that maintain local caches?

Answer: A local cache exists in the memory of an individual service instance. When the service scales to multiple instances, each instance has its own cache, which can lead to inconsistent values, duplicated memory usage, and cache stampedes.

### Example scenario

Suppose three product-service instances cache the price of product 101.

- Instance A caches price = ₹1,000.
- Instance B caches price = ₹1,000.
- Instance C caches price = ₹1,000.

The price changes in the database to ₹1,200. If only instance A invalidates its cache, instances B and C may continue returning ₹1,000.

### Challenge 1: Cache inconsistency

Different instances can return different values.

### Challenge 2: Cold caches after scale-out

A newly created instance has an empty cache and may send a large number of requests to the database.

### Challenge 3: Duplicate memory consumption

If each Pod caches the same 100,000 products, the same data is stored multiple times.

### Challenge 4: Cache stampede

When a popular cache entry expires, many concurrent requests may try to reload it simultaneously.

### Code example: Local caching with Caffeine

java
```
@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager manager =
            new CaffeineCacheManager("products");

        manager.setCaffeine(
            Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(
                    Duration.ofMinutes(5)
                )
        );

        return manager;
    }
}
```

Service:

java
```
@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Cacheable(
        cacheNames = "products",
        key = "#id"
    )
    public Product getProduct(Long id) {
        return repository.findById(id)
            .orElseThrow();
    }

    @CacheEvict(
        cacheNames = "products",
        key = "#product.id"
    )
    public Product updateProduct(Product product) {
        return repository.save(product);
    }
}
```

The example uses Caffeine as an in-process cache. The eviction method shown is illustrative; a production update method should ensure the cache key and saved entity match, and the cache must be updated or invalidated consistently with the persistence operation.

### How do you solve the challenges?

- Use expiration times to limit how long values remain stale.
- Invalidate or refresh caches after relevant data changes.
- Use distributed cache invalidation events when multiple local caches exist.
- Use Redis when a shared cache is more appropriate.
- Apply request coalescing or single-flight mechanisms for expensive cache misses.
- Add jitter to expiration times to reduce synchronized expirations.
- Monitor cache hit rate, miss rate, eviction rate, and load on the backing database.

Interview takeaway: Local caches are fast, but horizontal scaling introduces cache-coherence and cold-start problems. Choose between local and distributed caching based on latency, freshness, and consistency requirements.

## 5. How do you prevent a thundering herd problem during scale-out?

Answer: A thundering herd occurs when many instances or requests simultaneously attempt the same expensive operation, overwhelming a shared resource.

This often happens when new Pods start with empty caches, when popular cache entries expire simultaneously, or when many requests retry after a dependency recovers.

### Example scenario

A product service scales from 3 Pods to 20 Pods during a traffic spike. All new Pods have empty local caches and query the database for the same popular products.

The database receives a burst of duplicate queries just when the application is already under pressure.

### Common solutions

1. Request coalescing: Combine concurrent requests for the same key into one database fetch per instance.
2. Cache warming: Preload frequently requested data before directing full traffic to new instances.
3. Jittered expiration: Randomize cache expiry to avoid simultaneous misses.
4. Distributed caching: Let instances reuse the same cached data.
5. Rate limiting and backpressure: Limit the load on the database.
6. Exponential backoff with jitter: Spread retries over time.
7. Controlled scale-out: Avoid launching too many instances simultaneously when startup causes heavy shared-resource load.

### Code example: Single-flight cache loading

The following Java example ensures that concurrent calls for the same key share an in-progress load within a single application instance.

java
```
@Service
public class ProductLoader {

    private final ProductRepository repository;

    private final ConcurrentHashMap<
        Long, CompletableFuture<Product>
    > inFlight = new ConcurrentHashMap<>();

    public ProductLoader(ProductRepository repository) {
        this.repository = repository;
    }

    public Product load(Long id) {
        CompletableFuture<Product> future =
            inFlight.computeIfAbsent(id, key ->
                CompletableFuture.supplyAsync(() ->
                    repository.findById(key)
                        .orElseThrow()
                ).whenComplete((value, error) ->
                    inFlight.remove(key)
                )
            );

        return future.join();
    }
}
```

This is an illustrative pattern, not a complete production implementation. The default `CompletableFuture` executor may be unsuitable for blocking database calls. A bounded executor, explicit timeout policy, exception handling, and careful removal of failed loads are important in production.

Also, the map is local to one instance. It does not coordinate requests across multiple Pods. A shared cache, distributed coordination, or database-side controls may be needed for cross-instance protection.

### How does jitter help?

Instead of expiring every cache entry exactly five minutes after insertion, vary the expiry duration slightly.

For example:

java
```
long ttlMinutes =
    ThreadLocalRandom.current().nextLong(4, 7);
```

This produces a TTL of 4, 5, or 6 minutes. In a real cache configuration, the chosen TTL must actually be applied to the entry; merely calculating it does not change cache behavior.

Interview takeaway: Prevent synchronized work, coalesce duplicate requests, and protect downstream dependencies. Autoscaling without these controls can amplify an outage.

## 6. How do Kubernetes Horizontal Pod Autoscaler (HPA) and Vertical Pod Autoscaler (VPA) differ?

Answer: HPA adjusts the number of Pod replicas, whereas VPA adjusts the CPU and memory requests assigned to containers.

### HPA: Horizontal Pod Autoscaler

HPA adds or removes replicas according to configured metrics.

For example:

- Minimum replicas: 2.
- Maximum replicas: 10.
- CPU utilization target: 70%.

When utilization rises, HPA may increase the number of Pods.

yaml
```
apiVersion: autoscaling/v2
kind: HorizontalPodAutoscaler
metadata:
  name: product-hpa
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: product-service
  minReplicas: 2
  maxReplicas: 10
  metrics:
    - type: Resource
      resource:
        name: cpu
        target:
          type: Utilization
          averageUtilization: 70
```

The Deployment must define CPU requests for CPU utilization-based scaling to work as intended.

### VPA: Vertical Pod Autoscaler

VPA recommends or adjusts the CPU and memory requests for containers based on observed resource usage and its configured update policy.

For example, a Pod that consistently needs more memory than its configured request may receive a higher recommendation.

An illustrative VPA resource:

yaml
```
apiVersion: autoscaling.k8s.io/v1
kind: VerticalPodAutoscaler
metadata:
  name: product-vpa
spec:
  targetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: product-service
  updatePolicy:
    updateMode: "Off"
```

Here, `updateMode: "Off"` is intended for recommendation-only use; it does not automatically apply resource changes. VPA must be installed in the cluster, and the supported configuration depends on its version.

### Comparison

| Feature | HPA | VPA |
| --- | --- | --- |
| What changes? | Number of replicas | CPU and memory requests |
| Example | 3 Pods → 8 Pods | 250m CPU → 500m CPU request |
| Best suited for | Variable traffic and parallel workloads | Right-sizing resource requirements |
| Typical limitation | More Pods may not solve a shared bottleneck | Applying updates may restart or recreate Pods |
| Scaling dimension | Horizontal | Vertical |

### Can HPA and VPA be used together?

Yes, but their interaction requires care.

For example, HPA based on CPU utilization calculates utilization relative to CPU requests. If VPA changes those requests, the utilization percentage can change even when actual CPU consumption remains the same.

A common approach is to use HPA for scaling replicas and VPA in recommendation-only mode to guide resource sizing. Other combinations can work, but should be validated for the specific metrics, update policy, and workload.

Interview takeaway: HPA changes how many instances run; VPA changes how much CPU and memory each instance requests.

## 7. How would you scale a service with uneven traffic across different endpoints?

Answer: I would first measure traffic, latency, and resource consumption by endpoint. If different endpoints have substantially different workloads, I would consider separating the high-demand functionality into independently scalable services.

### Example scenario

Suppose one Spring Boot application exposes three endpoints:

| Endpoint | Traffic | Resource demand |
| --- | --- | --- |
| `GET /products` | 8,000 RPS | High database reads |
| `POST /orders` | 1,000 RPS | High database writes |
| `GET /health` | 100 RPS | Very low |

Scaling the entire application to handle product reads also creates more order-processing instances and potentially more database connections.

### Option A: Optimize and cache the high-traffic endpoint

For product browsing, caching may reduce repeated database reads:

java
```
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
```

The service can use `@Cacheable` for appropriate product data, as demonstrated earlier.

### Option B: Separate services by workload

A possible architecture is:

API Gateway

Product Service

8 replicasRead-heavy traffic

Order Service

3 replicasWrite-heavy traffic

Illustrative replica counts. Each service scales according to measured capacity.

Now the product and order services can be deployed and scaled independently.

### Kubernetes implementation

Each service can have its own Deployment and HPA:

bash
```
kubectl scale deployment product-service --replicas=8
kubectl scale deployment order-service --replicas=3
```

For fully automated scaling, configure separate HPAs with appropriate metrics for each Deployment.

### Important considerations

- Avoid splitting a service into microservices solely because one endpoint has more traffic.
- Consider caching and query optimization before introducing new services.
- Monitor database connections across both services.
- Use suitable routing and security policies at the gateway.
- Consider data ownership and transaction boundaries when separating services.

Interview takeaway: Measure endpoint-level demand first. Optimize hot endpoints, then separate independently scalable workloads when the benefits justify the additional distributed-system complexity.

## 8. How do you handle database connection pool limits when increasing the number of service instances?

Answer: Every application instance may maintain its own database connection pool. When the number of instances increases, the total number of database connections can exceed the database's capacity.

This is a common reason why horizontal scaling can make an application slower rather than faster.

### Example scenario

Suppose a Spring Boot application uses HikariCP with a maximum of 50 connections per instance.

Initially:

- 3 Pods.
- 50 maximum connections per Pod.
- Maximum potential connections: $3 \times 50 = 150$.

After scaling to 10 Pods:

- 10 Pods.
- 50 maximum connections per Pod.
- Maximum potential connections: $10 \times 50 = 500$.

If the database can safely support only 200 application connections, the new configuration may cause connection failures or excessive database contention.

### Calculate the connection budget

Use the following formula:

$$
C_{\text{total}}=N_{\text{pods}}\times C_{\text{pool}}
$$

Where:

- $N_{\text{pods}}$ = number of application instances.
- $C_{\text{pool}}$ = maximum connections per instance.

Assume:

- Database connection budget for this application: 180.
- Maximum application Pods: 10.

The theoretical upper bound per Pod is:

$$
C_{\text{pool}}=\frac{180}{10}=18
$$

This assumes the entire 180-connection budget is available to these Pods. In production, reserve capacity for administrative connections, migrations, background jobs, other applications, and operational headroom.

### Code example: Configure HikariCP in Spring Boot

properties
```
spring.datasource.url=jdbc:postgresql://db:5432/orders
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.datasource.hikari.maximum-pool-size=15
spring.datasource.hikari.minimum-idle=3
spring.datasource.hikari.connection-timeout=2000
spring.datasource.hikari.idle-timeout=300000
spring.datasource.hikari.max-lifetime=1500000
```

What these settings mean:

- `maximum-pool-size=15`: Each application instance can use up to 15 pooled connections.
- `minimum-idle=3`: HikariCP aims to maintain three idle connections.
- `connection-timeout=2000`: A caller waits up to 2 seconds to obtain a connection before failing.
- `idle-timeout=300000`: An idle connection can be removed when pool settings permit.
- `max-lifetime=1500000`: Connections are retired after their configured lifetime, subject to HikariCP's behavior.

With 10 Pods and a pool maximum of 15, the application can potentially maintain up to 150 pooled connections.

Important: These values are examples, not universal recommendations. Pool sizing should be based on database capacity, query duration, measured concurrency, and peak workload.

### How would you monitor connection pool exhaustion?

Monitor:

- Active connections.
- Idle connections.
- Pending threads waiting for connections.
- Connection acquisition latency.
- Connection timeout counts.
- Database CPU, query latency, and lock waits.

Spring Boot Actuator and Micrometer can expose HikariCP pool metrics for monitoring systems such as Prometheus.

### What if the application needs more connections than the database can support?

Consider these options:

1. Reduce unnecessary database queries.
2. Shorten transaction duration so connections are released sooner.
3. Reduce per-Pod pool sizes and establish concurrency limits.
4. Cache appropriate read-heavy data.
5. Optimize slow queries and indexes.
6. Use read replicas for suitable read workloads.
7. Introduce a database connection proxy or pooler, such as PgBouncer for PostgreSQL, where appropriate.
8. Scale or reconfigure the database if its resources are the actual bottleneck.

A connection pooler can reduce the number of backend connections in some configurations, but transaction pooling has compatibility considerations, including session-level database features.

### Interview scenario: Why does the application fail after scaling from 5 Pods to 20 Pods?

Sample answer:

"I would first calculate the aggregate database connection limit across all Pods. Then I would inspect HikariCP active, idle, and pending connection metrics alongside database CPU and query latency. If connection exhaustion is the cause, I would right-size the pools, optimize query and transaction duration, and ensure the aggregate connection budget stays within database capacity. I would then load-test the scaled deployment to verify throughput, p99 latency, and error rates."

## Final revision: How the eight topics connect

| Problem | Recommended first step |
| --- | --- |
| Low CPU, high latency | Identify waiting time and slow dependencies |
| Single database bottleneck | Optimize queries and protect database capacity |
| Sessions break after scaling | Use stateless authentication or shared sessions |
| Inconsistent local caches | Define expiration and invalidation strategies |
| Thundering herd | Coalesce requests and spread cache refreshes |
| Incorrect resource sizing | Choose HPA, VPA, or a carefully validated combination |
| Uneven endpoint traffic | Measure endpoint demand and isolate workloads when justified |
| Database connection exhaustion | Calculate aggregate pool capacity and tune concurrency |

The most important senior-level interview principle: Scaling is not simply adding more Pods. You must ensure that the entire request path—including caches, databases, connection pools, message brokers, and downstream services—can handle the additional load while meeting latency and reliability targets.

---
# Throughput in Microservices Architecture (with Spring Boot Examples)

## 1. What is throughput in a microservices architecture?

Throughput is the amount of work a microservice successfully processes within a given period of time.

It is commonly measured in:

- Requests per second (RPS): Number of HTTP requests handled per second.
- Transactions per second (TPS): Number of business transactions completed per second.
- Messages per second: Number of messages consumed or processed per second.

For example, imagine an Order Service built using Spring Boot.

- It receives 1,000 order requests per second.
- It successfully processes 800 orders per second.
- The remaining 200 requests are rejected, delayed, or still being processed.

Its successful order-processing throughput is 800 orders per second, assuming each successfully processed order represents one business transaction.

### Visualizing throughput

1,000 incoming requests/second

Spring Boot Order Service

Processes requests using CPU, threads, database connections and downstream services

## 800/sec

Successfully completed

## 200/sec

Not yet completed or unsuccessful

Illustrative numbers only. A proper measurement distinguishes successful completions, errors, and requests still in flight.

### Why is throughput important?

In a microservices system, throughput helps you understand:

- How much traffic a service can handle.
- Whether the service can support growing user demand.
- Whether a database, thread pool, or downstream service is a bottleneck.
- How many application instances you may need.
- Whether a performance improvement actually increases completed work.

For example, an e-commerce application may have an API Gateway, Order Service, Payment Service, Inventory Service, and Notification Service. Even if the Order Service can handle 2,000 requests per second, the entire order workflow may only complete 500 orders per second if the Payment Service is the bottleneck.

Important: The throughput of an individual microservice is not necessarily the throughput of the complete business workflow.

## 2. Difference between throughput, latency, and response time

These three metrics are related, but they measure different things.

| Metric | Meaning | Example |
| --- | --- | --- |
| Throughput | How much work is completed per unit of time | 800 requests/sec |
| Latency | Time taken for an operation or request to travel from its start to its completion, depending on the measurement boundary | 100 ms |
| Response time | Time between sending a request and receiving the response, typically including server processing and relevant network delays | 150 ms |

Latency and response time are sometimes used interchangeably in everyday engineering discussions. More precisely, latency usually refers to a particular delay or elapsed operation time, whereas response time is the full request-response duration. Always define the measurement boundaries.

### Example

Suppose a client calls an Order Service.

text
```
Client sends request
       |
       v
Network: 20 ms
       |
       v
Order Service processing: 80 ms
       |
       v
Response travels back: 20 ms
       |
       v
Client receives response
```

The response time is approximately:

$$
20 + 80 + 20 = 120\text{ ms}
$$

Suppose the service completes 800 requests per second at the same time. Then:

- Throughput: 800 requests/second.
- Response time: approximately 120 ms.
- Internal processing duration: approximately 80 ms.

A service can have high throughput and still have high response time. For example, it might process thousands of concurrent requests while each request waits a long time for a database response.

### How are throughput and response time related?

For a stable system, Little's Law gives:

$$
L = \lambda W
$$

Where:

- $L$ = average number of requests in the system.
- $\lambda$ = throughput, in requests per second.
- $W$ = average time spent in the system, in seconds.

For example, if a service completes 500 requests/sec and each request spends an average of 0.2 seconds in the system:

$$
L = 500 \times 0.2 = 100
$$

On average, approximately 100 requests are in progress or waiting within the measured system boundary.

This relationship is useful when diagnosing concurrency and queueing problems.

## 3. Difference between RPS and TPS

RPS and TPS are related, but they measure different units of work.

- RPS (Requests Per Second): How many requests an application or endpoint receives or handles per second.
- TPS (Transactions Per Second): How many business transactions are completed per second.

A transaction may consist of multiple HTTP requests and database operations.

### Example: Placing an order

Consider an order workflow that performs these operations:

1. Create an order.
2. Check inventory.
3. Process payment.
4. Update the order status.

One business transaction may invoke several services and generate multiple HTTP requests.

1 business transaction

Customer places an order

4 internal API calls

Order → Inventory → Payment → Order update

## 400 RPS

## 100 TPS

Illustrative example: four counted requests per completed transaction, with no additional requests included in the calculation.

If 100 orders are completed per second and each order generates four counted API requests:

$$
RPS = 100 \times 4 = 400
$$

$$
TPS = 100
$$

The exact RPS depends on which services and endpoints are included in the measurement.

### Spring Boot example: Measuring RPS and TPS

Use Micrometer to count incoming HTTP requests and completed business transactions separately.

Business transaction counter:

java
```
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final Counter completedOrders;

    public OrderService(MeterRegistry registry) {
        this.completedOrders = Counter.builder(
                "orders.completed")
            .description("Successfully completed orders")
            .register(registry);
    }

    public void placeOrder() {
        // 1. Validate the order
        // 2. Check inventory
        // 3. Process payment
        // 4. Save the order

        completedOrders.increment();
    }
}
```

The counter increases only when execution reaches the successful completion point.

If the service completes 6,000 orders over 60 seconds:

$$
TPS = \frac{6000}{60} = 100
$$

For HTTP RPS, Spring Boot Actuator and Micrometer can automatically record server request metrics. We'll configure them in section 5.

Interview takeaway: RPS measures API traffic; TPS measures completed business transactions. They may be equal, but they often are not.

## 4. What factors affect the throughput of a microservice?

Throughput depends on application code, infrastructure, configuration, and downstream dependencies.

Closeup detail of CPU Chip over socket of a modern computer black motherboard. Electronic small component details. Select focus

1. CPU and memory

CPU-intensive tasks such as encryption, serialization, and complex calculations can limit how many requests a service completes. Garbage collection and memory pressure can also reduce throughput.

Cấu tạo, hoạt động và lưu ý khi sử dụng tủ rack

2. Database performance

Slow SQL queries, missing indexes, database locks, limited connection pools, and transaction contention can cause requests to wait.

Threading - In a language independent context - DEV Community

3. Thread pools and concurrency

Too few worker threads can leave requests waiting. Too many can cause excessive context switching, memory usage, and resource contention.

Monolith vs Microservices vs Modular Monoliths

4. Downstream services

An Order Service that calls a slow Payment Service may be limited by payment processing, network delays, connection pools, or downstream rate limits.

CADD Arabia | Connecting Tech, Delivering Excellence

5. Network and serialization

Network latency, bandwidth limits, large JSON payloads, TLS overhead, and repeated remote calls affect how much work can be completed.

Real-Time App Performance Monitoring with Apache Pinot

6. Application and deployment configuration

Inefficient code, logging overhead, retries, rate limiting, container CPU limits, autoscaling settings, and the number of service replicas can all affect throughput.

### Example: Finding the bottleneck

Suppose your Order Service has the following approximate results under a load test:

| Configuration | Completed orders/sec |
| --- | --- |
| Initial implementation | 200 |
| Optimize database queries | 350 |
| Tune connection pools | 450 |
| Add two more replicas | 900 |

These are illustrative results, not guaranteed improvements. Adding replicas only helps if the database, downstream services, and other shared resources can handle the additional load.

Key principle: Optimize the actual bottleneck rather than increasing thread counts or server replicas blindly.

## 5. How do you measure throughput in a Spring Boot application?

A practical approach combines Spring Boot Actuator, Micrometer, and a load-testing tool such as Apache JMeter, Gatling, or k6.

### Step 1: Add dependencies

For a Maven-based Spring Boot application, add Actuator and Prometheus registry support.

xml
```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <dependency>
        <groupId>io.micrometer</groupId>
        <artifactId>micrometer-registry-prometheus</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

Use dependency versions managed by your Spring Boot parent or BOM.

### Step 2: Configure the metrics endpoint

In `application.properties`:

properties
```
management.endpoints.web.exposure.include=health,metrics,prometheus

management.endpoint.health.show-details=never
```

In a production environment, secure management endpoints and restrict access to trusted monitoring systems.

### Step 3: Create a sample REST endpoint

java
```
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products")
    public String getProducts() {
        return "Products retrieved successfully";
    }
}
```

Spring Boot's web instrumentation can record HTTP request counts and timing metrics automatically when the standard Actuator/Micrometer setup is active.

### Step 4: Inspect the metrics

Start the application, then access:

text
```
http://localhost:8080/actuator/metrics/http.server.requests
```

This shows the HTTP server request metric and its available measurements and tags.

For Prometheus-format metrics, access:

text
```
http://localhost:8080/actuator/prometheus
```

Look for metrics such as:

text
```
http_server_requests_seconds_count
http_server_requests_seconds_sum
http_server_requests_seconds_max
```

Exact names and available labels can vary with the Spring Boot and Micrometer versions.

The `_count` value indicates the number of recorded HTTP server request events for the selected metric series.

### Step 5: Calculate throughput

Suppose the request count changes as follows:

- Count at the beginning: 10,000
- Count after 60 seconds: 40,000

Then:

$$
RPS = \frac{40,000 - 10,000}{60}
$$

$$
\boxed{RPS = 500}
$$

This represents an average of 500 recorded requests per second over that interval for the selected metric series.

To measure only a particular endpoint, select the appropriate URI tag or filter in Prometheus. Also distinguish successful responses from errors, because a high total request rate does not necessarily mean high successful throughput.

### Step 6: Use Prometheus to calculate the rate

A common PromQL query is:

promql
```
sum(
  rate(http_server_requests_seconds_count[1m])
)
```

This estimates the average recorded HTTP requests per second over the previous minute across the selected series.

To measure only successful responses, a typical query is:

promql
```
sum(
  rate(http_server_requests_seconds_count{
    status=~"2.."
  }[1m])
)
```

To measure successful requests for a particular endpoint, filter on its actual `uri` label as well. Be careful with high-cardinality labels, and don't include raw user IDs or request IDs as metric labels.

### Step 7: Perform a load test

For example, using k6:

javascript
```
import http from 'k6/http';
import { check } from 'k6';

export const options = {
  vus: 100,
  duration: '60s',
};

export default function () {
  const response = http.get(
    'http://localhost:8080/products'
  );

  check(response, {
    'status is 200': (r) => r.status === 200,
  });
}
```

Run the test with:

bash
```
k6 run load-test.js
```

k6 reports metrics such as request rate, duration, and failed requests. Compare those results with server-side metrics.

For a meaningful throughput test:

- Warm up the application before measuring.
- Run a steady load for a defined period.
- Track successful requests and errors separately.
- Monitor CPU, memory, garbage collection, database connections, and thread pools.
- Increase load gradually until throughput stops increasing or response times and errors become unacceptable.

Important distinction: A load generator's offered request rate is not the same as the service's successful completion rate. Measure both.

## 6. What is concurrency, and how does it affect throughput?

Concurrency is the number of operations that can be in progress during overlapping periods of time. It does not necessarily mean they are executing simultaneously on different CPU cores; that is parallelism.

For example, an Order Service may process 100 requests concurrently. Some requests might be executing Java code while others wait for a database or an external API.

### Java example: Sequential versus concurrent requests

Suppose each request takes 200 ms.

Sequential processing

java
```
for (int i = 0; i < 10; i++) {
    processOrder(); // Takes 200 ms
}
```

Approximate total duration:

$$
10 \times 200\text{ ms} = 2\text{ seconds}
$$

Throughput over this short batch is approximately 5 orders/sec.

Concurrent processing

If all 10 independent operations can run concurrently and each takes 200 ms, the batch might finish in approximately 200 ms, ignoring overhead.

That gives a potential batch throughput of:

$$
\frac{10}{0.2} = 50\text{ orders/sec}
$$

These calculations assume independent work and enough resources. A shared database or a downstream API could prevent this improvement.

### How concurrency affects throughput

- Too little concurrency: Resources may remain idle while requests wait for I/O.
- Appropriate concurrency: Multiple requests make progress while waiting on different resources.
- Too much concurrency: Threads compete for CPU, database connections become saturated, queues grow, and response times increase.

Consider this illustrative example:

Concurrency versus throughput

Illustrative performance measurements, not benchmark results.

|  | Throughput |
| --- | --- |
| 1 | 50 req/s |
| 10 | 300 req/s |
| 25 | 600 req/s |
| 50 | 750 req/s |
| 100 | 760 req/s |
| 200 | 740 req/s |

Throughput increases as concurrency rises, then plateaus and may decline. The optimal point depends on the workload and available resources.

### How to control concurrency in Spring Boot

For a blocking Spring MVC application, you can configure the embedded Tomcat worker pool:

properties
```
server.tomcat.threads.max=200
server.tomcat.threads.min-spare=10
```

These properties configure the maximum and minimum spare Tomcat worker threads, respectively, for supported Spring Boot/Tomcat versions.

They do not mean the application can successfully process 200 requests at once without bottlenecks. Database pools, downstream connection limits, CPU capacity, and other resources also matter.

## 7. Synchronous versus asynchronous processing in terms of throughput

The main difference is what happens while a request waits for a slower operation to finish.

### Synchronous processing

In synchronous, blocking processing, a thread typically waits for each operation to complete before continuing.

Example:

java
```
@GetMapping("/orders/{id}")
public Order getOrder(@PathVariable Long id) {
    Order order = orderClient.fetchOrder(id);
    Payment payment = paymentClient.fetchPayment(id);

    return order;
}
```

Assume both remote calls take 100 ms and execute sequentially. Ignoring other overhead, the request takes approximately 200 ms.

Advantages

- Simple programming model.
- Straightforward exception handling and debugging.
- Appropriate for many ordinary request-response APIs.

Disadvantages

- Worker threads can remain occupied while waiting for I/O.
- High concurrency may require more threads and resources.
- Slow downstream services can reduce throughput.

### Asynchronous processing

Asynchronous processing allows work to be scheduled or continued without requiring the initiating thread to wait synchronously for the entire operation.

For example, an order may be accepted immediately, while inventory updates and notification delivery happen through a message queue.

### Synchronous order flow

Client request

Order Service

Wait for inventory and payment responses

Return final result

### Asynchronous order flow

Client request

Validate and accept order

Publish order event to a message broker

Inventory Consumer

Notification Consumer

The API can respond before all downstream work finishes, provided the business contract permits this.

### Spring Boot asynchronous example

For simple background execution, Spring supports `@Async`.

java
```
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Async("notificationExecutor")
    public void sendNotification(Long orderId) {
        // Send email, SMS, or push notification
    }
}
```

Enable asynchronous execution and configure a bounded executor:

java
```
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent
    .ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean("notificationExecutor")
    public Executor notificationExecutor() {
        ThreadPoolTaskExecutor executor =
            new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(16);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("notification-");

        executor.initialize();
        return executor;
    }
}
```

Invoke the service from another Spring-managed bean:

java
```
notificationService.sendNotification(orderId);
return ResponseEntity.accepted().build();
```

This illustrates returning an accepted response while notification work is scheduled separately. It does not guarantee that the notification has been delivered or durably queued.

For critical order events, a durable broker such as Kafka or RabbitMQ, retries, idempotency, and appropriate delivery guarantees are usually more suitable than relying solely on an in-memory task executor.

### Comparison

| Feature | Synchronous | Asynchronous |
| --- | --- | --- |
| Client response | Often waits for the operation | May return before background work finishes |
| Thread behavior | May block while waiting for I/O | Can free or reuse execution resources while work is pending |
| Throughput | Can be limited by blocked threads | Can improve resource utilization for I/O-heavy workloads |
| Complexity | Generally simpler | Requires careful error handling and lifecycle management |
| Result availability | Often immediate | May be eventually available |
| Best suited for | Immediate results and simple workflows | Background jobs, event processing, independent tasks |

Interview takeaway: Asynchronous processing can increase throughput by reducing blocking and separating workloads, but it does not automatically make the underlying work faster. If the database is already saturated, asynchronous execution may simply create a larger queue.

## 8. How do thread pools affect throughput?

A thread pool is a collection of reusable threads that execute submitted tasks. It avoids creating a new thread for every task and provides a way to control concurrency.

In a Spring Boot microservice, several pools may exist independently:

- Tomcat request-processing threads.
- Application task-execution threads.
- JDBC database connections, which are not threads but another constrained resource.
- HTTP client connection pools.
- Message consumer threads.

These resources must be tuned together.

### Example: Thread pool and throughput

Suppose requests spend 20 ms doing CPU work and 180 ms waiting for a database. The average request duration is 200 ms.

With only 10 blocking worker threads, the theoretical maximum throughput implied by thread occupancy is approximately:

$$
\frac{10}{0.2} = 50\text{ requests/sec}
$$

With 40 threads, the corresponding theoretical upper bound is:

$$
\frac{40}{0.2} = 200\text{ requests/sec}
$$

These are simplified thread-capacity estimates, not predictions of actual throughput. The database must be able to sustain the additional work, and real systems incur other overheads.

If the database can handle only 100 requests/sec, increasing the worker pool to 100 threads will not make the database process 200 requests/sec. It may instead increase waiting, connection contention, and response times.

### How a thread pool works

Incoming tasks

Task queue

Tasks wait if no worker is available

Worker 1

Worker 2

Worker N

Completed tasks

### What happens when you change pool size?

| Configuration | Likely effect |
| --- | --- |
| Too few threads | Tasks wait in the queue; throughput may be unnecessarily low |
| Appropriate pool size | Good utilization without excessive contention |
| Too many threads | More memory use, context switching, and resource contention |
| Queue too small | Tasks may be rejected quickly during traffic spikes |
| Queue too large | Long waiting times, memory pressure, and delayed responses |

### Spring Boot example: Measuring executor throughput

You can use a custom executor for background jobs and record completed tasks using Micrometer.

java
```
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.concurrent
    .ThreadPoolTaskExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;

@Configuration
public class WorkerConfig {

    @Bean("workerExecutor")
    public Executor workerExecutor(
            MeterRegistry registry) {

        Counter completed = Counter.builder(
                "worker.tasks.completed")
            .register(registry);

        ThreadPoolTaskExecutor executor =
            new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(16);
        executor.setQueueCapacity(200);
        executor.setThreadNamePrefix("worker-");

        executor.setTaskDecorator(task -> () -> {
            try {
                task.run();
            } finally {
                // Counts task execution, including failures.
                completed.increment();
            }
        });

        executor.initialize();
        return executor;
    }
}
```

Here, `worker.tasks.completed` is a counter of tasks whose execution has finished, including tasks that threw exceptions. For successful task throughput, increment a separate counter only after the business operation succeeds.

You can calculate the task execution rate in Prometheus:

promql
```
sum(rate(worker_tasks_completed_total[1m]))
```

The exact exported metric name depends on Micrometer's naming conventions and configuration.

For real production monitoring, also track queue size, active threads, rejected tasks, task failures, execution duration, and downstream resource utilization. A completed-task counter alone does not show whether the pool is overloaded.

## 9. Quick interview revision

| Question | Short answer |
| --- | --- |
| What is throughput? | The amount of work completed per unit of time. |
| What is latency? | A delay or elapsed time associated with an operation; its measurement boundary must be defined. |
| What is response time? | The time from sending a request until receiving its response. |
| RPS versus TPS? | Requests per second versus completed business transactions per second. |
| What limits throughput? | CPU, memory, database performance, downstream services, networks, concurrency, and configuration. |
| How do you measure Spring Boot throughput? | Use Actuator, Micrometer, Prometheus, and a load-testing tool. |
| What is concurrency? | The number of operations in progress over overlapping periods. |
| Does asynchronous processing improve throughput? | It can improve resource utilization, particularly for I/O-bound workloads, but is not guaranteed to. |
| How do thread pools affect throughput? | They control task concurrency; both undersizing and oversizing can hurt performance. |

### Final practical example

Imagine your Spring Boot Order Service has these measurements under a steady load test:

- Incoming requests: 1,000 RPS.
- Successful API responses: 950 RPS.
- Completed business orders: 300 TPS.
- Average response time: 120 ms.
- 95th-percentile response time: 400 ms.
- Database connection pool: 30 connections.

These metrics tell different parts of the story. The service receives 1,000 requests/sec but returns successful responses at 950/sec, while business workflows complete at 300 orders/sec. The average and p95 response times show how long requests take, and the database pool provides one clue to investigate if requests spend substantial time waiting for connections.

The most important performance objective is not simply maximizing RPS. It is maximizing successful business throughput while meeting your latency, reliability, and resource-utilization targets.

---
