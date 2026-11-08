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


Absolutely. For a **senior Java/Spring Boot microservices interview**, scenario-based questions are much more valuable than "what is `@Autowired`?" questions. Interviewers typically test whether you can **design, debug, scale, secure, and evolve a distributed system**.

Below is a deep interview set organized from architecture → Spring Boot → data → resilience → messaging → security → observability → design patterns.

# 1\. Microservices Architecture — Scenario Questions

### Q1. Your Product Service is working, but Inventory Service is down. A customer tries to place an order. What should happen?

A strong answer should discuss:

```
Order
  ↓
Inventory
  ↓
Payment
```

You should **not** make the entire system unavailable simply because Inventory is temporarily unavailable.

Discuss:

- timeout
- retry
- circuit breaker
- fallback
- idempotency
- reservation
- eventual consistency
- order states

A good design:

```
POST /orders

        Order Service
             |
             | reserve stock
             ↓
       Inventory Service
             |
       ┌─────┴─────┐
       |           |
    success      timeout
       |           |
       ↓           ↓
   CONFIRMED    PENDING
```

The order could initially become:

```
PENDING_INVENTORY
```

rather than immediately returning failure.

**Patterns:**

- Circuit Breaker
- Saga
- State Pattern
- Retry Pattern

---

### Q2. Product Service has 10 million products. Your API currently returns all products. What would you change?

Expected discussion:

```
GET /products
```

should become something like:

```
GET /products?page=0&size=20&sort=price,asc
```

Use:

- pagination
- sorting
- filtering
- database indexes
- projections
- caching
- cursor pagination for very large datasets

Spring Data:

```
Page<Product> findAll(Pageable pageable);
```

For search-heavy systems:

```
Product DB
    ↓
Search indexing
    ↓
Elasticsearch/OpenSearch
```

Patterns:

- Repository
- CQRS
- Cache-Aside

---

# 2\. Service-to-Service Communication

### Q3. Product Service needs category information. Should Product Service call Category Service every time?

Naive architecture:

```
GET product
    ↓
Product Service
    ↓
Category Service
    ↓
return product
```

This creates:

- network dependency
- latency
- cascading failures
- availability problems

Better alternatives:

### Option 1 — Store category ID

```
Product
---------
id
name
categoryId
```

Fetch category only when required.

### Option 2 — Local read model

```
Category Service
      |
      | CategoryUpdated
      ↓
 Message Broker
      ↓
Product read model
```

### Option 3 — API composition

An API Gateway/BFF combines responses.

Patterns:

- API Gateway
- CQRS
- Event-Driven Architecture
- Local Read Model

---

# 3\. REST vs Messaging

### Q4. When would you use REST and when Kafka/RabbitMQ?

Use REST when you need immediate response:

```
GET Product
GET Category
```

Use messaging when immediate coupling isn't necessary:

```
OrderCreated
ProductCreated
PaymentCompleted
InventoryReserved
```

Example:

```
Order Service
      |
      | OrderCreated
      ↓
    Kafka
      |
 ┌────┼─────────┐
 ↓    ↓         ↓
Inventory Payment Notification
```

Advantages:

- loose coupling
- asynchronous processing
- replay
- scalability

But discuss:

- duplicate messages
- ordering
- consumer failures
- idempotency
- dead-letter queues
- eventual consistency

---

# 4\. Saga Pattern

### Q5. Explain a real-world Saga scenario.

Suppose checkout requires:

```
Order
Inventory
Payment
```

Successful flow:

```
Order Created
     ↓
Inventory Reserved
     ↓
Payment Completed
     ↓
Order Confirmed
```

What if payment fails?

You need compensation:

```
Order Created
     ↓
Inventory Reserved
     ↓
Payment FAILED
     ↓
Release Inventory
     ↓
Cancel Order
```

This is a Saga.

## Choreography

Services react to events:

```
OrderCreated
     ↓
Inventory
     ↓
InventoryReserved
     ↓
Payment
     ↓
PaymentFailed
     ↓
InventoryReleased
```

## Orchestration

A central orchestrator controls the workflow:

```
        Order Saga
            |
     ┌──────┼──────┐
     ↓      ↓      ↓
Inventory Payment Notification
```

For complex business processes, **orchestration is often easier to reason about**.

---

# 5\. Database Per Service

### Q6. Why shouldn't multiple microservices share the same database?

Bad:

```
Product Service ──┐
Inventory Service ├──→ ecommerce DB
Order Service ────┘
```

Problems:

- tight coupling
- schema dependency
- difficult deployments
- transaction coupling
- ownership ambiguity

Better:

```
Product ───→ product_db
Inventory ─→ inventory_db
Order ─────→ order_db
Payment ───→ payment_db
```

Each service owns its data.

---

# 6\. Distributed Transactions

### Q7. You need to update Order DB and Inventory DB atomically. Can `@Transactional` do this?

Normally:

```
@Transactional
public void placeOrder() {
    orderRepository.save(order);
    inventoryRepository.save(inventory);
}
```

doesn't magically create one transaction across independent service databases.

Discuss:

- distributed transactions
- 2PC
- Saga
- eventual consistency

In modern microservices, Saga is generally preferred over tightly coupled distributed transactions.

---

# 7\. Outbox Pattern

### Q8. You save an Order successfully, but publishing `OrderCreated` to Kafka fails. What happens?

Bad implementation:

```
orderRepository.save(order);

kafkaTemplate.send("order-created", event);
```

Possible result:

```
DB = success
Kafka = failure
```

Now other services don't know the order exists.

Use **Transactional Outbox**:

```
Order DB
----------------
orders
outbox_events
```

Same DB transaction:

```
BEGIN

INSERT order
INSERT outbox_event

COMMIT
```

Then a publisher reads:

```
outbox_events
       ↓
Kafka
```

This is one of the most important senior-level microservices patterns.

---

# 8\. Idempotency

### Q9. Payment API receives the same request twice. How do you prevent duplicate payment?

Client sends:

```
Idempotency-Key: abc-123
```

Store:

```
idempotency_key
----------------
abc-123
```

Before processing:

```
Does abc-123 already exist?
       |
   ┌───┴───┐
  yes      no
   |        |
return    process
existing
result
```

Patterns:

- Idempotent Consumer
- Idempotency Key
- Unique database constraint

---

# 9\. Retry

### Q10. Your Product Service calls Inventory Service and receives 500\. Should you retry?

Not blindly.

Retry appropriate transient failures:

```
timeout
connection failure
503
```

Avoid retrying:

```
400
401
403
404
```

Also use:

```
exponential backoff
+
jitter
+
maximum attempts
```

Example:

```
1 sec
2 sec
4 sec
8 sec
```

Without limits, retry storms can make the outage worse.

---

# 10\. Circuit Breaker

### Q11. Inventory Service is down and Product Service keeps calling it. What happens?

Without circuit breaker:

```
Product
 ↓
Inventory ❌
 ↓
timeout
 ↓
retry
 ↓
timeout
 ↓
retry
```

Eventually Product becomes unhealthy too.

Circuit breaker:

```
CLOSED
  ↓ failures
OPEN
  ↓ timeout period
HALF_OPEN
  ↓ successful
CLOSED
```

With Resilience4j in Spring Boot:

```
@CircuitBreaker(
    name = "inventory",
    fallbackMethod = "inventoryFallback"
)
public InventoryResponse checkInventory(...) {
    ...
}
```

Know the three states very well.

---

# 11\. Rate Limiting

### Q12. Your login API is receiving 50,000 requests/minute. What do you do?

Possible architecture:

```
Client
  ↓
API Gateway
  ↓
Rate Limiter
  ↓
Auth Service
```

Algorithms:

- Token Bucket
- Leaky Bucket
- Fixed Window
- Sliding Window

Redis is commonly used for distributed rate limiting.

---

# 12\. API Gateway

### Q13. Why use an API Gateway?

Instead of:

```
Frontend
 ↓
Product
Inventory
Order
Payment
```

use:

```
Frontend
    ↓
API Gateway
 ┌──┼───────┐
 ↓  ↓       ↓
Product Inventory Order
```

Gateway responsibilities:

- routing
- authentication
- authorization
- rate limiting
- request correlation
- TLS termination
- aggregation
- CORS

Pattern:

**API Gateway Pattern**

---

# 13\. Authentication vs Authorization

### Q14. JWT is valid, but user gets 403. Why?

Authentication:

```
Who are you?
```

Authorization:

```
Are you allowed?
```

For example:

```
JWT valid
        ↓
ROLE_USER
        ↓
POST /products
        ↓
403 Forbidden
```

because endpoint requires:

```
ROLE_ADMIN
```

Know the difference between:

```
401 Unauthorized
403 Forbidden
```

---

# 14\. JWT / Keycloak

### Q15. Your Spring Boot service receives a JWT. How does it validate it?

With:

```
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8180/realms/ecommerce
```

Spring Security obtains issuer metadata/JWK information and validates:

- signature. Inventory responds in 30 seconds. Your HTTP client timeout is 60 seconds. What happens under 1,000 concurrent
- expiration
- issuer
- claims

Request:

```
Authorization: Bearer <JWT>
```

Flow:

```
Client
  ↓
JWT
  ↓
Spring Security
  ↓
JWT validation
  ↓
SecurityContext
  ↓
Controller
```

---

# 15\. Swagger OAuth2

### Q16. Swagger's Authorize button asks for `bearerAuth`. Why doesn't it automatically authenticate with Keycloak?

Because a simple HTTP Bearer security scheme only means:

```
Enter a token manually
```

For OAuth2 login, your OpenAPI definition must declare an OAuth2 security scheme with authorization-code flow.

Conceptually:

```
Swagger UI
    ↓
Keycloak Authorization Endpoint
    ↓
Login
    ↓
Authorization Code
    ↓
Token Endpoint
    ↓
Access Token
    ↓
Swagger API calls
```

This is different from simply defining:

```
type: http
scheme: bearer
```

---

# 16\. Global Exception Handling

### Q17. Every microservice returns different error structures. How would you standardize them?

Create a common error contract:

```
{
  "success": false,
  "code": "PRODUCT_NOT_FOUND",
  "message": "Product not found",
  "path": "/api/products/10",
  "traceId": "abc-123",
  "timestamp": "2026-10-04T10:00:00Z"
}
```

Spring:

```
@RestControllerAdvice
public class GlobalExceptionHandler {
}
```

Patterns:

- Exception Translation
- Adapter
- Template Method

---

# 17\. Correlation ID

### Q18. A request passes through five services and fails. How do you trace it?

Generate:

```
X-Correlation-Id
```

at the edge.

Then:

```
Gateway
 correlationId=ABC
      ↓
Product
 correlationId=ABC
      ↓
Inventory
 correlationId=ABC
      ↓
Order
 correlationId=ABC
```

Logs:

```
2026-10-04 INFO Product request corrId=ABC
2026-10-04 INFO Inventory request corrId=ABC
2026-10-04 ERROR Order failure corrId=ABC
```

This is essential for distributed debugging.

---

# 18\. Distributed Tracing

### Q19. Correlation ID and distributed tracing — what's the difference?

Correlation ID:

```
One identifier across logs
```

Distributed tracing:

```
Trace
 ├── Gateway span
 ├── Product span
 ├── Inventory span
 └── Order span
```

Technologies:

- OpenTelemetry
- Micrometer Tracing
- Zipkin
- Jaeger

Know:

```
traceId
spanId
parentSpanId
```

---

# 19\. Caching

### Q20. Product catalog receives 10,000 reads/sec but changes rarely. What do you do?

Use Redis:

```
Client
 ↓
Product Service
 ↓
Redis
 ↓ cache miss
Database
```

Cache-aside:

```
@Cacheable("products")
public Product findById(Long id) {
    return repository.findById(id);
}
```

On update:

```
@CacheEvict(
    value = "products",
    key = "#product.id"
)
```

Discuss:

- TTL
- invalidation
- stale data
- cache stampede
- distributed cache

---

# 20\. Cache Stampede

### Q21. Redis cache expires for a highly popular product. Suddenly 10,000 requests hit PostgreSQL. How do you handle it?

Possible solutions:

- locking
- request coalescing
- randomized TTL
- cache warming
- stale-while-revalidate

This is a good senior-level question.

---

# 21\. Optimistic Locking

### Q22. Two users buy the last product simultaneously. How do you prevent overselling?

Use optimistic locking:

```
@Version
private Long version;
```

Example:

```
Stock = 1

Transaction A reads 1
Transaction B reads 1

A updates → success
B updates → OptimisticLockException
```

Alternative:

```
UPDATE inventory
SET quantity = quantity - 1
WHERE sku = ?
AND quantity > 0;
```

Check affected rows:

```
1 → success
0 → insufficient stock
```

This is often an excellent practical solution.

---

# 22\. Pessimistic Locking

### Q23. When would you use pessimistic locking?

For example:

```
@Lock(LockModeType.PESSIMISTIC_WRITE)
Optional<Inventory> findBySku(String sku);
```

Database locks the row while transaction runs.

But discuss:

- contention
- deadlocks
- reduced concurrency

Don't blindly use pessimistic locking everywhere.

---

# 23\. N+1 Query Problem

### Q24. Your `/products` API executes 1 \+ 100 SQL queries. Why?

Example:

```
SELECT * FROM products;

SELECT * FROM categories WHERE id=1;
SELECT * FROM categories WHERE id=2;
...
```

This is N+1.

Solutions:

- fetch join
- EntityGraph
- DTO projection
- batch fetching

Avoid blindly changing everything to `EAGER`.

---

# 24\. Lazy vs Eager

### Q25. Why can `FetchType.EAGER` be dangerous?

Because loading:

```
@ManyToOne(fetch = FetchType.EAGER)
private Category category;
```

may cause unnecessary database queries and larger object graphs.

In microservices, DTO projections are often better than returning entities directly.

---

# 25\. JPA Entity vs DTO

### Q26. Why shouldn't controllers return JPA entities?

Because entities contain:

- persistence relationships
- lazy collections
- internal fields
- implementation details

Returning entities can cause:

```
serialization problems
N+1
recursive relationships
data leakage
```

Use:

```
Entity
 ↓
Mapper
 ↓
DTO
 ↓
Controller
```

This is the **Data Transfer Object Pattern**.

---

# 26\. Your Category Problem

You actually encountered a classic Hibernate issue:

```
object references an unsaved transient instance
Category.parentCategory
```

Because you were doing effectively:

```
Category.builder()
    .parentCategory(
        Category.builder()
            .categoryId(parentCategoryDto.getCategoryId())
            .build()
    )
    .build();
```

You're constructing a new transient `Category` instead of referencing an existing managed entity.

A better approach:

```
Category parent = null;

if (dto.getParentCategoryDto() != null &&
    dto.getParentCategoryDto().getCategoryId() != null) {

    parent = categoryRepository
        .findById(dto.getParentCategoryDto().getCategoryId())
        .orElseThrow(...);
}

category.setParentCategory(parent);
```

This is a very realistic interview scenario.

---

# 27\. Design Patterns You Should Know

For Spring Boot microservices, focus on these.

| Pattern | Where you'd use it |
| --- | --- |
| Repository | Database access |
| Service Layer | Business logic |
| DTO | API contracts |
| Factory | Object creation |
| Strategy | Multiple business algorithms |
| Builder | Complex object construction |
| Adapter | External APIs |
| Facade | Simplify complex subsystem |
| Proxy | Spring AOP/security/transactions |
| Template Method | Common workflow |
| Chain of Responsibility | Filters/security |
| Observer | Events |
| State | Order/payment states |
| Saga | Distributed transactions |
| Circuit Breaker | Service failures |
| Retry | Transient failures |
| Outbox | Reliable event publishing |
| CQRS | Separate read/write models |
| API Gateway | Central entry point |
| Cache-Aside | Redis caching |

---

# 28\. Strategy Pattern Scenario

### Q27. Your payment service supports Stripe, PayPal and Razorpay. How do you avoid a giant `if/else`?

Bad:

```
if (type.equals("STRIPE")) {
   ...
} else if (type.equals("PAYPAL")) {
   ...
} else if (type.equals("RAZORPAY")) {
   ...
}
```

Use Strategy:

```
public interface PaymentStrategy {

    PaymentResponse pay(PaymentRequest request);
}
```

Implement:

```
StripePaymentStrategy
PaypalPaymentStrategy
RazorpayPaymentStrategy
```

Then:

```
@Service
public class PaymentService {

    private final Map<String, PaymentStrategy> strategies;
}
```

This demonstrates **Open/Closed Principle**.

---

# 29\. Factory Pattern Scenario

### Q28. How do you select the correct payment strategy?

Factory:

```
@Component
public class PaymentStrategyFactory {

    private final Map<String, PaymentStrategy> strategies;

    public PaymentStrategy getStrategy(String type) {
        return strategies.get(type);
    }
}
```

Flow:

```
Payment Request
      ↓
Payment Factory
      ↓
Stripe Strategy
      ↓
Stripe API
```

---

# 30\. Adapter Pattern

### Q29. Stripe returns one response format and PayPal returns another. How does your service expose one common response?

External:

```
StripeResponse
PayPalResponse
```

Your application:

```
PaymentResponse
```

Adapters:

```
StripeAdapter
PayPalAdapter
```

```
External API
    ↓
Adapter
    ↓
Common domain model
```

---

# 31\. State Pattern

### Q30. Your Order can have 10 different statuses. How do you avoid hundreds of `if` statements?

States:

```
CREATED
 ↓
PAYMENT_PENDING
 ↓
PAID
 ↓
INVENTORY_RESERVED
 ↓
CONFIRMED
 ↓
SHIPPED
 ↓
DELIVERED
```

Invalid transitions should be rejected.

Example:

```
DELIVERED → PAYMENT_PENDING
```

should not be possible.

State Pattern can encapsulate transition rules.

---

# 32\. SOLID Interview Scenario

### Q31. A ProductService class has 2,000 lines and handles:

```
validation
database
pricing
inventory
notification
payment
logging
```

What's wrong?

Multiple violations of:

**Single Responsibility Principle**

Refactor:

```
ProductService
ProductValidator
ProductRepository
PricingService
InventoryClient
NotificationService
```

Also discuss:

- Dependency Inversion
- Open/Closed
- Interface Segregation
- Liskov Substitution

---

# 33\. Failure Scenario

### Q32. Inventory responds in 30 seconds. Your HTTP client timeout is 60 seconds. What happens under 1,000 concurrent requests?

You potentially exhaust:

```
Tomcat threads
HTTP connection pool
memory
database connections
```

Eventually:

```
Inventory slow
 ↓
Product slow
 ↓
Gateway slow
 ↓
Entire system degraded
```

Solution:

```
short timeout
+
bulkhead
+
circuit breaker
+
bounded connection pool
```

This is a very important distributed-systems concept.

---

# 34\. Bulkhead Pattern

Separate resources:

```
Product calls
 ├── connection pool A
 │
Payment calls
 ├── connection pool B
 │
Inventory calls
 └── connection pool C
```

If Inventory becomes slow, it shouldn't consume all resources needed by Payment.

This is the **Bulkhead Pattern**.

---

# 35\. Dead Letter Queue

### Q33. Kafka consumer keeps failing to process an event. What happens?

Don't retry forever.

```
Kafka
 ↓
Consumer
 ↓ failure
Retry
 ↓
Retry
 ↓
Retry
 ↓
DLQ
```

DLQ allows operators to inspect and replay failed messages.

---

# 36\. Exactly Once

### Q34. Does Kafka guarantee your business operation executes exactly once?

Be careful.

Messaging systems can provide various delivery guarantees, but your **business operation** still needs idempotency.

Assume:

```
at-least-once delivery
```

and design consumers to tolerate duplicates.

---

# 37\. Kubernetes Scenario

### Q35. Product Service has three replicas. Where should session state be stored?

Avoid:

```
Pod A
 └── session
```

because next request may hit:

```
Pod B
```

Use:

- stateless JWT
- Redis/session store if server-side sessions are necessary

This is why stateless microservices scale more easily.

---

# 38\. Health Checks

### Q36. What's the difference between liveness and readiness?

**Liveness:**

```
Is the application alive?
```

**Readiness:**

```
Can this instance receive traffic?
```

For example:

```
Application running
Database unavailable
```

The application may be alive but should potentially be marked **not ready** depending on the dependency and architecture.

Spring Boot Actuator is commonly used.

---

# 39\. Graceful Shutdown

You already have:

```
server:
  shutdown: graceful

spring:
  lifecycle:
    timeout-per-shutdown-phase: 30s
```

Interview question:

### Q37. What happens when Kubernetes sends SIGTERM?

A good answer:

```
SIGTERM
  ↓
Pod stops accepting new traffic
  ↓
Existing requests complete
  ↓
Grace period
  ↓
Application terminates
```

This prevents requests from being abruptly terminated during deployment.

---

# 40\. Database Migration

### Q38. Why Liquibase/Flyway instead of `ddl-auto=update` in production?

`ddl-auto=update` is convenient during development but dangerous as the primary production migration strategy.

Prefer:

```
Liquibase/Flyway
      ↓
Versioned schema changes
      ↓
CI/CD
      ↓
Production
```

Example:

```
001-create-product
002-add-sku-index
003-add-category
004-add-price
```

Every environment gets controlled schema evolution.

---

# 41\. Your Current Liquibase Issue

Your Product Service had:

```
liquibase:
  enabled: true
  change-log: classpath:db/changelog/db.changelog-master.yaml
```

but the master file only contained:

```
databaseChangeLog:
  - changeSet:
      id: product-service-0001-bootstrap
      author: codex
      changes:
        - sql:
            sql: SELECT 1;
```

So Liquibase was successfully running but **wasn't creating `categories` or `products`**.

That's an excellent interview scenario:

> "Liquibase is healthy and application starts, but tables don't exist. How do you debug it?"

Answer:

1. Verify datasource URL.
2. Verify active profile.
3. Verify Liquibase master path.
4. Inspect changelog includes.
5. Check `databasechangelog`.
6. Check actual schema.
7. Check migration logs.
8. Check whether migrations are being executed against the expected database.

---

# 42\. Senior-Level System Design Question

## Design an E-commerce Checkout System

You could be asked:

> Design Product, Inventory, Cart, Order, Payment and Notification microservices.

A strong architecture:

```
                         ┌───────────────┐
                         │   Frontend    │
                         └───────┬───────┘
                                 │
                                 ↓
                         ┌───────────────┐
                         │ API Gateway   │
                         └───────┬───────┘
                                 │
             ┌───────────────────┼───────────────────┐
             ↓                   ↓                   ↓
       Product Service      Cart Service       Order Service
             │                   │                   │
       product_db             cart_db             order_db
                                                     │
                              ┌──────────────────────┼─────────────┐
                              ↓                      ↓             ↓
                       Inventory Service       Payment Service Notification
                              │                      │
                        inventory_db            payment_db
                              │
                              └────────── Kafka ─────┘
```

Important flows:

### Product creation

```
POST /products
      ↓
Product Service
      ↓
product_db
      ↓
ProductCreated
      ↓
Kafka
      ↓
Inventory Service
      ↓
inventory_db
```

### Checkout

```
POST /orders
      ↓
Order Service
      ↓
Inventory reservation
      ↓
Payment
      ↓
Order confirmation
      ↓
OrderConfirmed event
      ↓
Notification
```

Failure:

```
Payment FAILED
      ↓
Release inventory
      ↓
Cancel order
```

Patterns involved:

```
API Gateway
Repository
DTO
Strategy
Factory
Adapter
Circuit Breaker
Retry
Bulkhead
Saga
Outbox
Idempotency
CQRS
Event-Driven Architecture
Cache-Aside
State
Observer
```

---

# 43\. Questions You Should Be Able to Answer Without Preparation

For a senior Spring Boot microservices interview, make sure you can explain these deeply:

### Spring Boot

- How does Spring Boot auto-configuration work?
- What happens during application startup?
- `@Component` vs `@Service` vs `@Repository`
- `@Bean` vs `@Component`
- Spring profiles
- Configuration properties
- Actuator
- graceful shutdown
- virtual threads
- Spring Security filter chain
- `@Transactional`
- transaction propagation
- isolation levels

### Microservices

- Database-per-service
- API Gateway
- Service Discovery
- REST vs Kafka
- synchronous vs asynchronous communication
- Saga
- Outbox
- CQRS
- eventual consistency
- idempotency
- distributed transactions
- circuit breaker
- retry
- timeout
- bulkhead
- rate limiting

### Database

- indexing
- composite indexes
- optimistic locking
- pessimistic locking
- N+1
- pagination
- connection pools
- transaction isolation
- deadlocks
- database migrations

### Security

- OAuth2
- JWT
- Keycloak
- access token vs refresh token
- authentication vs authorization
- 401 vs 403
- RBAC
- CORS
- CSRF
- service-to-service authentication

### Messaging

- Kafka partitions
- consumer groups
- offsets
- ordering
- retries
- DLQ
- idempotent consumers
- at-most-once
- at-least-once
- exactly-once semantics
- schema evolution

### Design Patterns

Prioritize:

```
Strategy
Factory
Builder
Adapter
Facade
Proxy
Template Method
Observer
State
Repository
DTO
Saga
Outbox
Circuit Breaker
Bulkhead
CQRS
API Gateway
```

The biggest difference between a **mid-level** and **senior** answer is usually not knowing the names of these patterns. It's being able to explain **why you chose one, what failure it prevents, what trade-off it introduces, and what happens when the dependency/database/message broker fails**.

---
Certainly! Below is a set of interview questions and answers tailored to the job description of a Lead Java Engineer,
focusing on the key skills and responsibilities mentioned.

---

### **1. Question:**

**Can you explain the core principles of microservices architecture and how it differs from a monolithic architecture?**

**Answer:**
Microservices architecture breaks down an application into small, independent services that are loosely coupled and can
be developed, deployed, and scaled independently. Each service typically handles a specific business function and
communicates with other services via APIs.

**Key Differences from Monolithic Architecture:**

- **Modularity:** Microservices are modular and can be developed and deployed independently, whereas monolithic
  applications are tightly coupled, making them harder to manage and scale.
- **Scalability:** Microservices allow individual components to be scaled independently based on their needs, while in a
  monolithic architecture, scaling requires scaling the entire application.
- **Development Speed:** Microservices enable teams to work on different services simultaneously, potentially speeding
  up development, while monolithic applications often require coordination across the whole codebase.
- **Technology Diversity:** Different microservices can use different technologies and languages, whereas monolithic
  applications are usually built with a single technology stack.

---

### **2. Question:**

**Describe your experience with creating a streaming data pipeline using Kafka. What are the key considerations when
designing such a pipeline?**

**Answer:**
In my experience with Kafka, I've implemented streaming data pipelines that handle real-time data ingestion, processing,
and delivery. The key considerations for designing a Kafka-based streaming data pipeline include:

- **Topic Design:** Properly design topics based on data types and consumer needs to ensure efficient data processing
  and retrieval.
- **Partitioning:** Use partitioning to enable parallel processing and ensure high throughput. The number of partitions
  should be based on the volume of data and the need for parallelism.
- **Replication:** Configure replication to ensure fault tolerance and high availability. Ensure that replication
  factors are set to meet the desired level of durability.
- **Consumer Groups:** Use consumer groups to distribute the workload and achieve horizontal scaling. Ensure proper
  handling of offsets to avoid data loss or duplication.
- **Data Schema:** Implement a consistent schema for data to ensure compatibility and ease of processing across
  different services.
- **Error Handling:** Design mechanisms for handling errors and retries to ensure reliability and robustness of the
  pipeline.

---

### **3. Question:**

**How do you implement and manage CI/CD pipelines in your projects? What tools and practices do you use?**

**Answer:**
In my projects, I implement CI/CD pipelines to automate the build, test, and deployment processes. The tools and
practices I use include:

- **CI/CD Tools:** Jenkins, GitLab CI, or GitHub Actions for orchestrating the CI/CD processes.
- **Version Control Integration:** Integrate with version control systems (e.g., Git) to trigger builds on code commits.
- **Automated Testing:** Incorporate unit, integration, and end-to-end tests to ensure code quality before deployment.
- **Build Automation:** Use build tools like Maven or Gradle to automate the build process.
- **Deployment Automation:** Deploy applications using tools like Docker, Kubernetes, or cloud-native solutions such as
  AWS CodeDeploy.
- **Configuration Management:** Use configuration management tools like Ansible or Terraform for environment setup and
  management.
- **Monitoring and Alerts:** Implement monitoring and alerting to track the health of deployments and quickly address
  issues.

---

### **4. Question:**

**Explain the key concepts of Spring Boot and how it facilitates microservices development.**

**Answer:**
Spring Boot simplifies the development of Spring-based applications by providing:

- **Auto-Configuration:** Automatically configures Spring application context based on the dependencies in the
  classpath, reducing boilerplate configuration.
- **Standalone Applications:** Allows creating standalone applications that can be run independently with an embedded
  server (e.g., Tomcat, Jetty).
- **Production-Ready Features:** Provides features such as health checks, metrics, and application monitoring
  out-of-the-box.
- **Spring Initializr:** A web-based tool to generate Spring Boot projects with pre-configured dependencies.
- **Microservices Support:** Facilitates the development of microservices with support for building RESTful APIs,
  integrating with databases, and configuring service discovery and load balancing (e.g., via Spring Cloud).

---

### **5. Question:**

**Can you discuss your approach to handling multi-threading and concurrency issues in Java applications?**

**Answer:**
Handling multi-threading and concurrency in Java involves understanding and using various concurrency utilities provided
by the Java standard library. My approach includes:

- **Using Concurrent Collections:** Utilize thread-safe collections like `ConcurrentHashMap` and `CopyOnWriteArrayList`
  to manage shared data.
- **Executor Framework:** Use `ExecutorService` to manage and control thread pools and task execution, avoiding manual
  thread management.
- **Synchronization:** Apply synchronization techniques (e.g., `synchronized` blocks or methods) to protect shared
  resources and avoid race conditions.
- **Locks and Conditions:** Use `ReentrantLock` and `Condition` objects for more fine-grained control over thread
  synchronization compared to synchronized blocks.
- **Avoiding Deadlocks:** Be cautious of potential deadlocks by ensuring proper ordering of lock acquisitions and
  avoiding nested locks.
- **Atomic Operations:** Use `AtomicInteger`, `AtomicLong`, and other atomic classes to perform lock-free thread-safe
  operations on single variables.

---

### **6. Question:**

**What are some best practices for designing RESTful APIs, and how do you ensure that they are both effective and
efficient?**

**Answer:**
Best practices for designing RESTful APIs include:

- **Resource-Oriented Design:** Focus on resources (e.g., `/users`, `/orders`) and use HTTP methods (GET, POST, PUT,
  DELETE) to represent actions on these resources.
- **Statelessness:** Ensure that each API request contains all necessary information for processing, and avoid
  maintaining server-side state between requests.
- **Use of HTTP Status Codes:** Return appropriate HTTP status codes to indicate the result of the request (e.g., 200
  OK, 201 Created, 404 Not Found).
- **Versioning:** Include versioning in the API (e.g., `/api/v1/resources`) to handle changes and backward
  compatibility.
- **Pagination and Filtering:** Implement pagination and filtering for endpoints that return large datasets to improve
  performance and usability.
- **Documentation:** Provide clear and comprehensive API documentation (e.g., using Swagger/OpenAPI) to help consumers
  understand and use the API effectively.
- **Security:** Implement security measures such as authentication (OAuth, JWT) and authorization to protect sensitive
  data and operations.

---

### **7. Question:**

**How do you approach performance tuning in a Java application? What tools and techniques do you use?**

**Answer:**
Performance tuning in Java involves identifying and resolving performance bottlenecks. My approach includes:

- **Profiling:** Use profiling tools (e.g., VisualVM, JProfiler) to identify performance issues and hotspots in the
  code.
- **Heap Dump Analysis:** Analyze heap dumps to detect memory leaks and inefficient memory usage using tools like
  Eclipse MAT.
- **Monitoring:** Implement application monitoring and logging (e.g., using ELK stack) to track performance metrics and
  identify anomalies.
- **Code Optimization:** Refactor code to improve efficiency, reduce complexity, and optimize algorithms and data
  structures.
- **Concurrency Optimization:** Tune thread pool sizes and use concurrent data structures to improve multi-threading
  performance.
- **Caching:** Implement caching strategies (e.g., using Ehcache, Redis) to reduce redundant computations and database
  access.

---

### **8. Question:**

**Describe your experience with Agile development and Scrum. How do you ensure successful implementation in a team?**

**Answer:**
My experience with Agile and Scrum includes:

- **Sprint Planning:** Participate in sprint planning meetings to define and prioritize user stories and tasks for the
  upcoming sprint.
- **Daily Stand-ups:** Facilitate or attend daily stand-ups to track progress, address roadblocks, and ensure team
  alignment.
- **Retrospectives:** Conduct retrospectives at the end of each sprint to review performance, discuss what went well,
  and identify areas for improvement.
- **Backlog Management:** Maintain and refine the product backlog to ensure that it reflects current priorities and
  project needs.
- **Collaboration:** Foster a collaborative environment where team members can share knowledge, work together, and
  address challenges proactively.

---

### **9. Question:**

**Can you provide an example of a challenging problem you solved in a distributed system?**

**Answer:**
One challenging problem I encountered was managing data consistency in a distributed microservices architecture. We had
multiple services that needed to update shared data while ensuring eventual consistency.

**Solution:**

- **Event Sourcing:** Implemented an event sourcing pattern where changes to the system state were stored as a sequence
  of events, allowing us to reconstruct the state if needed.
- **CQRS:** Used Command Query Responsibility Segregation (CQRS) to separate read and write operations, improving
  performance and consistency.
- **Distributed Transactions:** Implemented the Saga pattern to manage distributed transactions across microservices,
  ensuring that each service could participate in a long-running transaction with compensating actions for rollback.
- **Monitoring and Alerts:** Set up monitoring and alerts to detect and respond to inconsistencies or failures in
  real-time.

---

# Spring Boot Microservices: Real-Time Scenario-Based Interview Questions and Solutions

**Post Category:** Interview Preparation / Java / Spring Boot / Microservices\
**Level:** Intermediate to Advanced\
**Focus:** Real-world production scenarios, system design, debugging, coding, and senior developer interviews\
**Technology Stack:** Java 17+, Spring Boot 3.x, Spring Cloud, REST APIs, Kafka, PostgreSQL, Redis, Docker, Kubernetes, and Resilience4j

---

## Table of Contents

1. Microservices Fundamentals
2. Service Communication and API Gateway
3. Service Discovery and Load Balancing
4. Resilience and Fault Tolerance
5. Distributed Transactions and Data Consistency
6. Kafka and Event-Driven Architecture
7. Database and Performance Optimization
8. Security and Authentication
9. Monitoring, Logging, and Distributed Tracing
10. Deployment and Kubernetes
11. Real-World Coding Scenarios
12. Production Troubleshooting Scenarios
13. Advanced System Design Questions
14. Senior-Level Interview Questions
15. Common Interview Traps
16. Quick Revision Cheat Sheet

---

# 1\. Microservices Fundamentals

## Q1. Your Spring Boot application is becoming difficult to maintain. How would you decide whether to migrate it to microservices?

### Scenario

You have a monolithic application containing:

- User management
- Product catalog
- Order processing
- Payment processing
- Inventory management

A small change in the payment module requires redeploying the entire application.

### Solution

First, identify whether the monolith has genuine scaling, deployment, ownership, or maintainability problems. Microservices are not automatically better than a modular monolith.

If independent deployment and scaling are justified, divide the system into business capabilities.

text

```
                    API Gateway
                         |
          +--------------+--------------+
          |              |              |
     User Service   Product Service  Order Service
                                         |
                                  +------+------+
                                  |             |
                            Payment Service  Inventory Service
```

Each service should ideally:

- Own a clearly defined business capability.
- Have its own data ownership and persistence boundary.
- Be independently deployable.
- Communicate through explicit contracts.
- Handle failures from dependent services.
- Expose health and observability information.

### Interview Answer

"I would start by identifying bounded contexts and business capabilities. I would extract services incrementally rather than rewriting the entire application. I would also establish service contracts, monitoring, deployment automation, and failure-handling mechanisms before increasing the number of services."

**Important:** Do not create a separate microservice for every entity or database table.

## Q2. How do you design an Order Service that depends on Payment and Inventory services?

### Scenario

A customer places an order. The application must reserve inventory, process payment, and confirm the order.

### Solution

Use an explicit order state machine and a saga-style workflow.

text

```
Order Created
     |
     v
Inventory Reserved
     |
     v
Payment Processed
     |
     v
Order Confirmed
```

If payment fails:

text

```
Payment Failed
      |
      v
Release Inventory
      |
      v
Mark Order Failed
```

A possible order state model is:

java

```
public enum OrderStatus {
    PENDING,
    INVENTORY_RESERVED,
    PAYMENT_PENDING,
    CONFIRMED,
    FAILED,
    CANCELLED
}
```

The Order Service should persist state transitions and coordinate the workflow. For long-running workflows, consider a durable orchestration engine or a saga orchestrator backed by persistent storage.

### Production Considerations

- Use idempotency keys for payment requests.
- Make inventory reservation and release operations idempotent.
- Persist workflow state before acknowledging important transitions.
- Define timeouts and recovery for each step.
- Reconcile orders stuck in intermediate states.
- Never assume that a timeout means the payment failed; the payment provider may have completed the operation without returning a response.

---

# 2\. Service Communication and API Gateway

## Q3. One microservice needs to call another microservice. Would you use REST or Kafka?

### Scenario

The Order Service needs information from the Product Service and also needs to notify other services when an order is placed.

### Solution

Use synchronous communication when the caller needs an immediate response. Use asynchronous messaging when work can happen independently.

| Requirement | Recommended Approach |
| --- | --- |
| Fetch product details | REST |
| Check a current shipping quote | REST or another request-response API |
| Notify downstream services about an order | Kafka |
| Trigger email notifications | Kafka or another asynchronous mechanism |
| Process large event streams | Kafka |
| Coordinate a long-running business workflow | Saga or workflow engine |

### Example REST Client Using Spring's RestClient

java

```
@Service
public class ProductClient {

    private final RestClient restClient;

    public ProductClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://product-service")
                .build();
    }

    public ProductDto getProduct(Long productId) {
        return restClient.get()
                .uri("/api/products/{id}", productId)
                .retrieve()
                .body(ProductDto.class);
    }
}
```

This example assumes the hostname can be resolved through your deployment environment or configured service discovery.

### Interview Answer

"I use REST when an immediate response is required and asynchronous messaging when the producer and consumer should be decoupled. I also define timeouts, error handling, retries, and idempotency for either approach."

## Q4. The API Gateway becomes a single point of failure. How would you solve it?

### Scenario

All client requests pass through Spring Cloud Gateway. When the gateway becomes unavailable, every microservice appears unavailable to clients.

### Solution

Deploy multiple gateway instances behind a load balancer.

text

```
                  Clients
                     |
                Load Balancer
                     |
             +-------+-------+
             |               |
         Gateway 1        Gateway 2
             |               |
       +-----+---------------+-----+
       |             |             |
   User Service  Order Service  Product Service
```

Recommended measures:

- Run multiple gateway replicas.
- Use health checks and readiness probes.
- Configure connection and response timeouts.
- Apply rate limiting and request-size limits.
- Avoid storing critical session state only in gateway memory.
- Monitor gateway latency, error rate, and saturation.
- Configure graceful shutdown and rolling deployments.

### Spring Cloud Gateway Example

yaml

```
spring:
  cloud:
    gateway:
      routes:
        - id: order-service
          uri: http://order-service:8080
          predicates:
            - Path=/api/orders/**
```

The destination shown here is a logical service address in a suitable network or service-discovery environment.

**Interview Trap:** An API Gateway is not automatically highly available merely because it routes traffic to multiple backend services.

## Q5. A REST call between services is taking too long. What would you investigate?

### Scenario

The frontend calls the Order Service, which calls Inventory, Payment, and Shipping sequentially.

Each downstream call takes approximately 500 ms.

### Solution

Start with tracing and latency measurements rather than immediately adding threads.

Investigate:

- DNS and service discovery latency.
- Connection pool exhaustion.
- Database query time.
- Network latency.
- Downstream service saturation.
- Serialization overhead.
- Retry amplification.
- Sequential dependencies that could safely run in parallel.

If independent calls are involved, asynchronous composition may reduce latency.

java

```
CompletableFuture<InventoryDto> inventory =
        CompletableFuture.supplyAsync(
                () -> inventoryClient.getInventory(productId),
                ioExecutor
        );

CompletableFuture<ShippingDto> shipping =
        CompletableFuture.supplyAsync(
                () -> shippingClient.getShippingEstimate(address),
                ioExecutor
        );

CompletableFuture.allOf(inventory, shipping).join();
```

Here, `ioExecutor` is a configured executor appropriate for the workload. In production, also configure timeouts, exception handling, cancellation where appropriate, and a policy for partial failures.

Do not parallelize operations with business dependencies, such as charging a payment before the required order validation has completed.

## Q6. How do you handle API versioning when one service changes its response format?

### Scenario

The Product Service changes its response:

Old response:

json

```
{
  "productId": 10,
  "price": 100
}
```

New response:

json

```
{
  "id": 10,
  "pricing": {
    "amount": 100,
    "currency": "INR"
  }
}
```

Older consumers still expect the original format.

### Solution

Prefer backward-compatible evolution whenever possible.

- Add optional fields before removing old fields.
- Avoid renaming or changing the meaning of existing fields unexpectedly.
- Maintain contract tests for consumers.
- Use an explicit versioning strategy for breaking changes.
- Migrate consumers before removing the old contract.
- Use a compatibility period and monitor remaining old-version traffic.

Possible URL versioning:

text

```
/api/v1/products/10
/api/v2/products/10
```

Alternatively, teams may use media-type or header-based versioning.

### Interview Answer

"I prefer additive, backward-compatible changes. For breaking changes, I introduce a new contract, migrate consumers gradually, and remove the old version only after verifying that it is no longer used."

---

# 3\. Service Discovery and Load Balancing

## Q7. A service's IP address changes after deployment. How do other services find it?

### Scenario

The Order Service uses a hardcoded address:

java

```
http://192.168.1.20:8080
```

After redeployment, the Product Service gets a new IP address.

### Solution

Avoid hardcoded instance addresses.

Depending on the environment, use:

- Kubernetes Services and DNS.
- Spring Cloud service discovery, such as Eureka.
- A platform load balancer.
- DNS-based service routing.

In Kubernetes, a client can call a stable service name:

text

```
http://product-service:8080
```

Kubernetes routes traffic to ready endpoints behind that Service.

In a Spring Cloud deployment with discovery configured, a load-balanced client may use a logical service name:

java

```
RestClient client = restClientBuilder
        .baseUrl("http://product-service")
        .build();
```

This requires the appropriate Spring Cloud LoadBalancer and discovery configuration.

**Key Point:** Service discovery and load balancing solve related but different problems. Discovery identifies available instances; load balancing distributes requests among them.

## Q8. One service instance is unhealthy, but requests are still routed to it. Why?

### Scenario

The application process is running, but its database connection pool is exhausted. Clients continue receiving errors.

### Solution

Distinguish between process liveness and application readiness.

- **Liveness:** Should the process be restarted?
- **Readiness:** Can the instance safely receive traffic?
- **Startup probe:** Has the application completed startup?

Spring Boot Actuator can expose health endpoints:

text

```
/actuator/health
/actuator/health/liveness
/actuator/health/readiness
```

Example dependency:

xml

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Example Kubernetes configuration:

yaml

```
readinessProbe:
  httpGet:
    path: /actuator/health/readiness
    port: 8080
  initialDelaySeconds: 10
  periodSeconds: 5

livenessProbe:
  httpGet:
    path: /actuator/health/liveness
    port: 8080
  initialDelaySeconds: 20
  periodSeconds: 10
```

Configure Spring Boot health groups and availability-state integration as needed. Do not make every transient dependency failure trigger an immediate restart.

---

# 4\. Resilience and Fault Tolerance

## Q9. Payment Service is down. How do you prevent the Order Service from failing completely?

### Scenario

Every order request synchronously calls Payment Service. Payment becomes unavailable, causing requests to accumulate and threads to become exhausted.

### Solution

Apply several complementary controls.

- Connection and response timeouts.
- Bounded retries for transient errors.
- Circuit breaker.
- Bulkhead isolation.
- Graceful degradation where business rules permit it.
- Durable queuing or a saga for workflows that can continue asynchronously.

### Example Resilience4j Configuration

yaml

```
resilience4j:
  circuitbreaker:
    instances:
      paymentService:
        slidingWindowSize: 20
        minimumNumberOfCalls: 10
        failureRateThreshold: 50
        waitDurationInOpenState: 10s
  retry:
    instances:
      paymentService:
        maxAttempts: 3
        waitDuration: 200ms
```

Example service:

java

```
@Service
public class PaymentServiceClient {

    @CircuitBreaker(name = "paymentService")
    @Retry(name = "paymentService")
    public PaymentResponse charge(PaymentRequest request) {
        return callPaymentProvider(request);
    }

    private PaymentResponse callPaymentProvider(
            PaymentRequest request) {
        // Call the payment provider using a configured HTTP client.
        throw new UnsupportedOperationException(
                "Implement the actual provider integration");
    }
}
```

The example assumes the relevant Resilience4j Spring integration is installed and configured.

### Important Production Detail

Retrying a payment operation can accidentally charge a customer twice. Use provider-supported idempotency keys and distinguish retryable failures from permanent failures.

Do not blindly retry every HTTP 4xx or 5xx response.

## Q10. What is the difference between a timeout, retry, circuit breaker, and bulkhead?

| Mechanism | Purpose | Example |
| --- | --- | --- |
| Timeout | Limits how long a request may wait | Stop waiting after 2 seconds |
| Retry | Reattempts eligible transient failures | Retry a temporary network error |
| Circuit breaker | Temporarily blocks calls to an unhealthy dependency | Fail fast when payment repeatedly fails |
| Bulkhead | Limits resource consumption by one workload | Restrict concurrent payment calls |

These mechanisms complement each other.

A retry without a timeout may wait too long. A retry without a circuit breaker can amplify an outage. A circuit breaker without appropriate monitoring may open too aggressively or remain open longer than necessary.

## Q11. A downstream service is slow, and your retry mechanism makes the problem worse. Why?

### Scenario

An Inventory Service normally responds in 100 ms. During an incident, it takes 5 seconds. The Order Service retries each failed request three times.

### Solution

Retries multiply traffic precisely when the dependency is overloaded.

Use:

- Strict request deadlines.
- Exponential backoff.
- Randomized jitter.
- Limited retry attempts.
- Retry budgets.
- Circuit breakers.
- Separate concurrency limits.
- Monitoring for retry rate and downstream saturation.

For example, a retry policy might use increasing delays rather than immediately repeating the request.

text

```
Initial attempt
      |
      v
Failure
      |
      v
Wait 200 ms + jitter
      |
      v
Retry
      |
      v
Wait 400 ms + jitter
      |
      v
Final attempt
```

The exact delay and retry count should depend on the remaining request deadline and the operation's idempotency.

---

# 5\. Distributed Transactions and Data Consistency

## Q12. Order Service and Payment Service have separate databases. How do you maintain consistency?

### Scenario

The Order Service saves an order successfully, but Payment Service fails before recording payment.

### Solution

A traditional local database transaction cannot atomically commit changes across independently managed databases.

Use a saga or another explicit distributed workflow.

text

```
Order Service
    |
    | Create pending order
    v
Inventory Service
    |
    | Reserve stock
    v
Payment Service
    |
    | Charge payment
    v
Order confirmed
```

If payment fails, execute a compensating action to release stock and update the order status.

### Two Saga Approaches

**Orchestration**

A coordinator explicitly directs the workflow and records progress.

**Choreography**

Services publish and react to domain events.

For a complex workflow with multiple branches, timeouts, and compensation steps, orchestration is often easier to observe and manage.

### Interview Answer

"I would not attempt to share a database transaction across services. I would model the workflow as a saga, persist its state, use idempotent commands, and add recovery and reconciliation for incomplete transactions."

## Q13. What is the Transactional Outbox Pattern, and when would you use it?

### Scenario

The Order Service commits an order to its database, then publishes an OrderCreated event to Kafka.

The database commit succeeds, but Kafka is unavailable. Other services never receive the event.

### Problem

Writing to a database and publishing to Kafka are two independent operations. A crash between them can cause inconsistency.

### Solution

Write the business record and event to the same database transaction.

text

```
Database Transaction
    |
    +-- Insert Order
    |
    +-- Insert Outbox Event
    |
    +-- Commit
             |
             v
      Outbox Publisher
             |
             v
           Kafka
             |
             v
       Event Consumers
```

Simplified schema:

sql

```
CREATE TABLE outbox_event (
    id UUID PRIMARY KEY,
    aggregate_id VARCHAR(100) NOT NULL,
    event_type VARCHAR(100) NOT NULL,
    payload JSONB NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    published_at TIMESTAMP NULL
);
```

The application writes the order and outbox event in one local transaction. A separate publisher or CDC-based mechanism forwards the event to Kafka.

### Production Considerations

- Publish events with stable IDs.
- Make consumers idempotent.
- Track publication failures.
- Handle duplicate delivery.
- Monitor outbox backlog.
- Define retention and cleanup policies.

**Important:** The outbox pattern does not automatically guarantee exactly-once business processing. It closes the database/event dual-write gap, while delivery and consumer processing still need appropriate guarantees.

## Q14. A Kafka consumer receives the same event twice. How do you prevent duplicate business operations?

### Scenario

The Payment Service receives OrderCreated twice and attempts to charge the customer twice.

### Solution

Implement idempotent consumption.

sql

```
CREATE TABLE processed_events (
    event_id UUID PRIMARY KEY,
    processed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

Simplified transaction logic:

java

```
@Transactional
public void process(OrderCreatedEvent event) {
    boolean firstDelivery = eventRepository
            .insertIfAbsent(event.eventId());

    if (!firstDelivery) {
        return;
    }

    paymentRepository.createPaymentIfAbsent(
            event.orderId(),
            event.amount()
    );
}
```

Here, `insertIfAbsent` represents a database operation backed by a unique constraint. The event record and business update must commit in the same transaction for this pattern to work reliably.

For an external payment provider, also use a stable idempotency key at the provider boundary.

### Interview Answer

"Kafka consumers can receive duplicate messages. I use a stable event ID, a unique database constraint, transactional processing, and idempotent business operations. I do not rely on the consumer alone to guarantee that a payment happens exactly once."

---

# 6\. Kafka and Event-Driven Architecture

## Q15. A Kafka consumer is slower than the producer. What would you do?

### Scenario

The producer publishes 10,000 messages per second, while consumers process only 5,000 messages per second.

The consumer lag keeps increasing.

### Solution

Investigate before increasing the number of consumers.

Check:

- Consumer lag per partition.
- Processing time per message.
- Database or external API latency.
- Number of partitions.
- Consumer concurrency.
- Rebalances and failed messages.
- Batch size and polling configuration.
- Serialization and deserialization overhead.

Potential improvements include:

- Increasing partition count when appropriate.
- Scaling consumers up to the useful partition parallelism.
- Batching database writes.
- Reducing expensive downstream calls.
- Using asynchronous processing carefully.
- Separating slow event types into different topics.
- Implementing bounded retries and dead-letter handling.

**Important:** A consumer group cannot actively consume more partitions in parallel than the topic has available partitions. Adding consumers beyond useful partition parallelism may leave some consumers idle.

## Q16. What happens when a Kafka consumer fails while processing a message?

### Scenario

The consumer reads a message, updates a database, and crashes before committing its offset.

### Solution

The message may be delivered again after restart.

That is why message handling should be idempotent.

text

```
Read message
    |
    v
Begin database transaction
    |
    v
Check event ID
    |
    v
Apply business update
    |
    v
Record event as processed
    |
    v
Commit database transaction
    |
    v
Acknowledge/commit Kafka offset
```

The database transaction and Kafka offset commit are not automatically one atomic transaction. A crash between them can cause reprocessing, so the business update must tolerate duplicates.

### Additional Considerations

- Use manual acknowledgments or carefully configured acknowledgment modes where appropriate.
- Configure retries for transient failures.
- Send poison messages to a dead-letter topic after a defined policy.
- Monitor consumer lag and dead-letter volume.
- Preserve ordering where the business requires it, usually by keying events appropriately.

## Q17. How do you handle a poison message that always fails?

### Scenario

A malformed event causes the same consumer to fail repeatedly, preventing progress.

### Solution

Use a bounded retry strategy and a dead-letter topic.

text

```
Main Topic
    |
    v
Consumer
    |
    +---- Success
    |
    +---- Retryable Failure
    |          |
    |          v
    |     Retry Policy
    |
    +---- Permanent / Exhausted Failure
               |
               v
          Dead-Letter Topic
```

Include enough metadata to diagnose the failure:

- Original topic and partition.
- Original offset.
- Event ID.
- Failure reason.
- Number of attempts.
- Timestamp.

Avoid putting credentials, payment data, or unnecessary personal information in dead-letter records.

A dead-letter topic should have an operational replay procedure, not simply become a permanent dumping ground.

---

# 7\. Database and Performance Optimization

## Q18. Two services need the same customer data. Should they share one database?

### Scenario

Order Service and Notification Service both need customer email addresses.

### Solution

Prefer clear data ownership.

- Customer Service owns the authoritative customer record.
- Order Service stores only the customer information it needs for its own business workflow.
- Notification Service may maintain a projection or consume customer update events.
- Services communicate through APIs or events when current authoritative information is required.

Sharing a database can introduce schema coupling, coordinated deployments, and accidental cross-service transactions.

However, duplicating selected data for read performance is often appropriate when ownership and synchronization rules are explicit.

### Interview Answer

"I prefer database ownership per service. If another service needs the data, I use an API or event-driven projection. I accept controlled duplication when it improves resilience or performance, with a clear consistency strategy."

## Q19. An API is slow because it executes too many database queries. How do you fix it?

### Scenario

The Order Service retrieves 100 orders. For each order, it separately queries the customer and product tables.

This is the N+1 query problem.

### Solution

Use:

- Appropriate joins or projections.
- Batch fetching.
- Bulk repository methods.
- Query-specific DTOs.
- Database indexes.
- Query-plan analysis.

Example:

java

```
public interface OrderRepository
        extends JpaRepository<Order, Long> {

    @Query("""
        select new com.example.api.OrderSummary(
            o.id, o.status, o.totalAmount
        )
        from Order o
        where o.customerId = :customerId
        """)
    List<OrderSummary> findSummaries(
            Long customerId);
}
```

For cross-service data, do not assume a JPA join can fetch data from another service's database. Use a suitable API, event-driven read model, or aggregation strategy.

Measure query count and latency before and after the change.

## Q20. Your service's memory usage grows continuously. What would you investigate?

### Scenario

A Spring Boot service starts with 300 MB of memory usage, then grows to several gigabytes over several hours.

### Solution

Investigate:

- Heap usage after garbage collection.
- Object allocation rate.
- Large collections or unbounded caches.
- Thread-local data.
- Retained references.
- Thread count and thread stacks.
- Direct buffers and native memory.
- Metaspace usage.
- Request and connection accumulation.

Useful tools include:

- Java Flight Recorder.
- Java Mission Control.
- VisualVM.
- Heap dumps.
- `jcmd`.
- Garbage-collection logs.
- Micrometer and application metrics.

Useful diagnostic commands:

bash

```
jcmd <pid> GC.heap_info
jcmd <pid> Thread.print
jcmd <pid> GC.class_histogram
```

Run diagnostic commands according to your environment's permissions and operational policies.

### Interview Answer

"I would compare heap occupancy after garbage collection over time, capture a heap dump if appropriate, and inspect retained objects. I would also check native memory, thread growth, caches, and connection pools rather than assuming every memory problem is a Java heap leak."

---

# 8\. Security and Authentication

## Q21. How do you secure communication between microservices?

### Scenario

The API Gateway authenticates a user, but internal services are accessible directly.

An attacker who can reach the internal network may bypass the gateway.

### Solution

Apply defense in depth.

- Authenticate external requests.
- Enforce authorization at the service that owns the resource.
- Use TLS for service-to-service traffic when required by the security model.
- Use service identities or OAuth 2.0 client credentials for machine-to-machine access.
- Restrict network access with firewall or network policies.
- Validate token issuer, audience, expiration, and required scopes.
- Keep secrets in a dedicated secret-management system.

### Example Spring Security Resource-Server Configuration

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
                        .requestMatchers("/actuator/health")
                        .permitAll()
                        .requestMatchers("/api/admin/**")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt()
                )
                .build();
    }
}
```

This example assumes JWT resource-server dependencies and issuer or decoder configuration are supplied. Production health endpoints should expose only the information appropriate for their intended audience.

## Q22. A JWT token is valid, but a user can access another user's order. What is wrong?

### Scenario

The request is authenticated, but the application checks only whether the user has a valid token.

text

```
GET /api/orders/123
```

The order belongs to another customer.

### Solution

Authentication establishes identity. Authorization determines whether that identity can access a specific resource.

java

```
public OrderDto getOrder(
        Long orderId,
        String authenticatedCustomerId) {

    Order order = orderRepository
            .findById(orderId)
            .orElseThrow(OrderNotFoundException::new);

    if (!order.getCustomerId()
            .equals(authenticatedCustomerId)) {
        throw new AccessDeniedException(
                "Not authorized to access this order");
    }

    return mapToDto(order);
}
```

In real applications, derive the customer identity from the validated security context rather than trusting a client-supplied identity parameter.

Also consider tenant isolation, administrative roles, and resource-level authorization.

---

# 9\. Monitoring, Logging, and Distributed Tracing

## Q23. A customer reports that an order failed, but every service log looks normal. How would you debug it?

### Scenario

The request passes through API Gateway, Order Service, Inventory Service, and Payment Service.

Each service has a separate log file.

### Solution

Use distributed tracing and structured logging.

text

```
Client
  |
  | traceId = abc123
  v
API Gateway
  |
  v
Order Service
  |
  +---- Inventory Service
  |
  +---- Payment Service
```

Propagate trace context across supported HTTP and messaging boundaries.

Record useful fields such as:

- Trace ID and span ID.
- Order ID or another safe correlation identifier.
- Service name.
- HTTP status.
- Latency.
- Error category.
- Retry count.

Use Micrometer Observation and tracing integrations with an exporter such as OpenTelemetry.

Do not log access tokens, passwords, full payment details, or sensitive personal data.

## Q24. Which metrics should you monitor for a Spring Boot microservice?

### Solution

Start with four broad categories.

| Category | Useful Metrics |
| --- | --- |
| Traffic | Request count, throughput, message rate |
| Errors | HTTP 5xx rate, failed jobs, exceptions |
| Latency | p50, p95, p99 response time |
| Saturation | CPU, memory, thread pools, connection pools |

Also monitor business and dependency-specific metrics:

- Orders created and completed.
- Payment success and failure rate.
- Kafka consumer lag.
- Database connection acquisition latency.
- Circuit breaker state.
- Retry volume.
- Outbox backlog.
- Dead-letter message count.

Example Actuator configuration:

yaml

```
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  endpoint:
    health:
      probes:
        enabled: true
```

Expose endpoints only through an appropriate security and network policy. Add a Prometheus registry dependency if Prometheus metrics are required.

---

# 10\. Deployment and Kubernetes

## Q25. Your application works locally but fails in Docker. How do you investigate?

### Scenario

The application connects successfully to PostgreSQL on a developer's machine but fails in a container.

### Common Causes

- Using localhost to refer to another container.
- Incorrect environment variables.
- Missing configuration files.
- Wrong container port.
- DNS or network configuration issues.
- File-system permission problems.
- Java version mismatch.
- Insufficient container memory.

### Solution

Check the effective configuration and container logs.

bash

```
docker logs <container-name>
docker inspect <container-name>
docker ps
```

Inside a container, localhost refers to that container itself. Use the appropriate service name when communicating with another container on the same Docker network.

For example:

yaml

```
spring:
  datasource:
    url: jdbc:postgresql://postgres:5432/orders
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

Here, `postgres` must resolve to the database container or service in the deployment environment.

Never commit production database passwords into the repository.

## Q26. A Kubernetes pod keeps restarting. What steps would you take?

### Solution

Start with pod status and events.

bash

```
kubectl get pods
kubectl describe pod <pod-name>
kubectl logs <pod-name>
kubectl logs <pod-name> --previous
kubectl get events --sort-by=.metadata.creationTimestamp
```

Investigate likely causes:

- OOMKilled: memory limit exceeded.
- CrashLoopBackOff: repeated application failures.
- ImagePullBackOff: image or registry access problem.
- Failed startup or liveness probes.
- Invalid environment variables or secrets.
- Database connectivity failures.
- Incorrect command or entry point.
- Permission or volume-mount problems.

Do not simply increase memory limits without checking heap, native memory, allocation rate, and container limits.

### Interview Answer

"I inspect pod events, current and previous logs, termination reasons, resource usage, and probe failures. I identify the underlying failure before changing resource limits or restarting the workload."

## Q27. How do you deploy a new microservice version without downtime?

### Solution

Use a deployment strategy appropriate for the platform and application.

For a typical Kubernetes rolling update:

- Run multiple replicas.
- Define readiness probes.
- Set suitable rolling-update parameters.
- Handle graceful shutdown.
- Keep API and event contracts backward-compatible.
- Use database changes that support old and new versions during rollout.
- Monitor error rate and latency during deployment.
- Have a rollback strategy.

A safe database migration commonly follows an expand-and-contract approach:

text

```
Release 1: Add new nullable column
       |
       v
Release 2: Write old and new representations
       |
       v
Release 3: Migrate existing data
       |
       v
Release 4: Read new representation
       |
       v
Release 5: Remove old column after validation
```

The exact sequence depends on the schema and compatibility requirements.

**Important:** Rolling deployments alone do not guarantee zero downtime. Database compatibility, readiness, connection draining, and request handling also matter.

---

# 11\. Real-World Coding Scenarios

## Q28. How would you prevent duplicate order creation when a client retries a request?

### Scenario

The client submits an order, but the network connection times out before receiving the response. The client retries and accidentally creates a second order.

### Solution

Use an idempotency key.

Request:

http

```
POST /api/orders
Idempotency-Key: 8b20e5c1-example
Content-Type: application/json
```

Store the key with a unique constraint and associate it with the resulting order or response.

Conceptual database schema:

sql

```
CREATE TABLE idempotency_record (
    idempotency_key VARCHAR(100) PRIMARY KEY,
    request_hash VARCHAR(64) NOT NULL,
    order_id BIGINT,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

### Processing Flow

1. Validate the request.
2. Look up the idempotency key.
3. If already completed with the same request, return the original result.
4. If the key exists with a different request payload, reject the request.
5. Otherwise, create the order and record the outcome transaction.

---


Additional Spring Boot Microservices Interview Questions and Solutions
The existing document covers Q1–Q28. Below is the continuation, designed to fill the missing sections and prepare you for Intermediate, Advanced, and Senior Java Developer interviews.

The additional material focuses on production incidents, coding exercises, distributed systems, architecture decisions, and questions frequently asked in senior-level interviews.

Technology assumptions:

Java 17+

Spring Boot 3.x

Spring Cloud

Spring Security 6

Kafka

PostgreSQL

Redis

Docker and Kubernetes

Resilience4j

Micrometer and OpenTelemetry

11. Real-World Coding Scenarios (Continued)
    Q29. How would you implement pagination and sorting for millions of records?
    Scenario
    An Order Service contains 10 million records. Returning all orders in one API response causes high memory usage and slow response times.

Solution
Use database-level pagination and sorting.

Spring Data JPA example:


java
public interface OrderRepository
extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerId(
            Long customerId,
            Pageable pageable
    );
}
Service:


java
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Page<Order> getOrders(
            Long customerId,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("createdAt").descending()
        );

        return repository.findByCustomerId(
                customerId,
                pageable
        );
    }
}
API:


text
GET /api/orders?page=0&size=20
Production Considerations
Set a maximum page size.

Index frequently filtered and sorted columns.

Avoid fetching unnecessary entity relationships.

Use DTO projections.

Consider keyset pagination for very large datasets.

Avoid expensive count queries when totals are not required.

For keyset pagination, use a stable ordering such as (created_at, id) and fetch records after the last returned key.

Q30. How would you implement caching using Redis in Spring Boot?
Scenario
The Product Service receives 50,000 requests per minute for frequently accessed product details.

Repeated database queries increase database CPU utilization.

Solution
Use Redis caching with an appropriate expiration policy.

Dependency:


xml
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
Enable caching:


java
@Configuration
@EnableCaching
public class CacheConfig {
}
Service:


java
@Service
public class ProductService {

    @Cacheable(
        value = "products",
        key = "#productId"
    )
    public ProductDto getProduct(Long productId) {
        return fetchFromDatabase(productId);
    }

    @CacheEvict(
        value = "products",
        key = "#productId"
    )
    public void updateProduct(Long productId) {
        updateDatabase(productId);
    }

    private ProductDto fetchFromDatabase(Long id) {
        // Database implementation
        return null;
    }

    private void updateDatabase(Long id) {
        // Database implementation
    }
}
Production Considerations
Configure TTL.

Prevent cache stampedes.

Consider cache penetration and hot keys.

Define cache invalidation rules.

Avoid caching sensitive data unnecessarily.

Monitor cache hit ratio and Redis memory usage.

Interview trap: Redis caching does not automatically guarantee consistency between the cache and database.

Q31. How do you prevent race conditions when two customers purchase the last available product?
Scenario
Inventory shows one item available.

Two customers place orders simultaneously.

Both requests read the inventory value as one and attempt to reserve it.

Solution
Use atomic database operations rather than a separate read followed by an update.

PostgreSQL example:


sql
UPDATE inventory
SET available_quantity = available_quantity - 1
WHERE product_id = :productId
AND available_quantity >= 1;
Check the affected row count:

One row updated: reservation succeeded.

Zero rows updated: insufficient inventory or missing product.

Java:


java
@Transactional
public void reserveInventory(Long productId) {

    int updated = inventoryRepository
            .reserveOneItem(productId);

    if (updated == 0) {
        throw new InsufficientInventoryException(
                "Product unavailable"
        );
    }
}
Repository:


java
@Modifying
@Query(value = """
UPDATE inventory
SET available_quantity = available_quantity - 1
WHERE product_id = :productId
AND available_quantity >= 1
""", nativeQuery = true)
int reserveOneItem(Long productId);
Alternative Approaches
Optimistic locking using @Version.

Pessimistic locking using SELECT FOR UPDATE.

Atomic Redis operations, with a durable database consistency strategy.

For critical inventory operations, the database should remain the authoritative source of truth.

Q32. How would you implement global exception handling in Spring Boot?
Solution
Use @RestControllerAdvice.


java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
        ResourceNotFoundException.class
    )
    public ResponseEntity<ProblemDetail> handleNotFound(
            ResourceNotFoundException ex) {

        ProblemDetail problem =
                ProblemDetail.forStatus(
                        HttpStatus.NOT_FOUND
                );

        problem.setTitle("Resource Not Found");
        problem.setDetail(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(problem);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleGeneral(
            Exception ex) {

        ProblemDetail problem =
                ProblemDetail.forStatus(
                        HttpStatus.INTERNAL_SERVER_ERROR
                );

        problem.setTitle("Internal Server Error");
        problem.setDetail(
                "An unexpected error occurred"
        );

        return ResponseEntity
                .internalServerError()
                .body(problem);
    }
}
Best Practices
Use consistent error response formats.

Include correlation or trace IDs.

Do not expose stack traces to clients.

Map validation failures to HTTP 400.

Map unauthorized access to HTTP 401 or 403 appropriately.

Log unexpected exceptions with sufficient diagnostic context.

Avoid logging sensitive information.

Q33. How do you handle multiple downstream API calls efficiently?
Scenario
The Dashboard Service needs information from:

Customer Service

Order Service

Payment Service

Notification Service

Calling them sequentially creates high latency.

Solution
Use parallel execution for independent operations.


java
CompletableFuture<CustomerDto> customerFuture =
CompletableFuture.supplyAsync(
() -> customerClient.getCustomer(customerId),
ioExecutor
);

CompletableFuture<List<OrderDto>> ordersFuture =
CompletableFuture.supplyAsync(
() -> orderClient.getOrders(customerId),
ioExecutor
);

CompletableFuture<PaymentSummary> paymentFuture =
CompletableFuture.supplyAsync(
() -> paymentClient.getSummary(customerId),
ioExecutor
);

CompletableFuture.allOf(
customerFuture,
ordersFuture,
paymentFuture
).join();

CustomerDto customer = customerFuture.join();
List<OrderDto> orders = ordersFuture.join();
PaymentSummary payments = paymentFuture.join();
Production Considerations
Use a bounded executor.

Configure per-service timeouts.

Handle partial failures.

Avoid unbounded thread creation.

Consider bulkheads for individual dependencies.

Define a fallback or partial-response policy.

For Java 21 deployments, virtual threads can also be evaluated for suitable blocking workloads. They do not eliminate the need for downstream concurrency limits.

Q34. How would you implement optimistic locking in Spring Boot?
Scenario
Two administrators update the same product simultaneously.

The second administrator accidentally overwrites the first administrator's changes.

Solution
Use JPA optimistic locking.


java
@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    @Version
    private Long version;
}
When updating, JPA checks the version.

If another transaction has already modified the record, the update fails with an optimistic locking exception.

Handle the conflict:


java
try {
productRepository.save(product);
} catch (OptimisticLockingFailureException ex) {
throw new ConcurrentUpdateException(
"Product was modified by another user"
);
}
Use optimistic locking when conflicts are relatively uncommon.

Use pessimistic locking when concurrent modifications need stronger serialization and the resulting lock contention is acceptable.

12. Production Troubleshooting Scenarios
    Q35. Your Spring Boot application suddenly starts returning HTTP 503. How do you investigate?
    Scenario
    The application was working normally, but users suddenly receive:


text
503 Service Unavailable
Investigation Steps
Check API Gateway health.

Check Kubernetes pod readiness.

Check downstream service availability.

Inspect connection pool utilization.

Check circuit breaker states.

Investigate thread pool exhaustion.

Check database availability.

Review recent deployments.

Examine distributed traces.

Check infrastructure and network events.

Useful commands:


bash
kubectl get pods
kubectl get services
kubectl describe pod <pod-name>
kubectl logs <pod-name> --previous
Possible Root Causes
All application replicas are unhealthy.

Readiness probes are failing.

Database connection pool is exhausted.

Downstream dependencies are unavailable.

API Gateway cannot reach backend instances.

Thread pools are saturated.

Network policies prevent communication.

Senior-level answer: Identify whether the failure is caused by the application, infrastructure, or a dependency before applying a mitigation.

Q36. Database connections are exhausted. What would you do?
Scenario
Your application logs show:


text
HikariPool - Connection is not available,
request timed out after 30000ms
Solution
Investigate:

Connection pool size.

Long-running SQL queries.

Transactions that remain open.

Missing indexes.

Connection leaks.

Excessive concurrent requests.

Database maximum connection settings.

Example configuration:


yaml
spring:
datasource:
hikari:
maximum-pool-size: 20
minimum-idle: 5
connection-timeout: 30000
idle-timeout: 600000
max-lifetime: 1800000
The correct pool size depends on database capacity, application replica count, query workload, and concurrency.

Important
If Kubernetes runs 10 replicas, each with a maximum pool size of 20, the application may attempt to use up to 200 database connections.

Increasing pool size blindly can make database overload worse.

Q37. Kafka messages are published successfully, but consumers are not receiving them. What could be wrong?
Possible Causes
Incorrect topic name.

Consumer subscribed to the wrong topic.

Consumer group configuration problems.

Deserialization errors.

Authentication or authorization failures.

Incorrect bootstrap server configuration.

Consumer group rebalancing.

Offset management problems.

Topic partition or retention configuration.

Debugging Commands

bash
kafka-topics.sh \
--bootstrap-server localhost:9092 \
--list
Describe topic:


bash
kafka-topics.sh \
--bootstrap-server localhost:9092 \
--describe \
--topic orders
Check consumer groups:


bash
kafka-consumer-groups.sh \
--bootstrap-server localhost:9092 \
--describe \
--group order-consumer-group
Senior-Level Consideration
Differentiate between messages not being produced, messages being produced to the wrong topic, and messages being consumed but failing during processing.

Q38. Your service is experiencing high CPU utilization. How do you debug it?
Solution
Investigate:

CPU utilization per pod.

Thread count.

Excessive garbage collection.

Infinite loops.

High request volume.

Expensive serialization.

Inefficient database processing.

Regular expression performance.

Lock contention.

Useful commands:


bash
top -H -p <pid>
jcmd <pid> Thread.print
jcmd <pid> JFR.start
Use Java Flight Recorder to identify expensive methods and CPU hotspots.

Do not assume high CPU is caused by insufficient Kubernetes CPU limits.

Q39. A service is responding slowly even though CPU utilization is low. Why?
Possible Reasons
Database connection pool exhaustion.

Network latency.

Downstream API delays.

Thread pool starvation.

Lock contention.

DNS resolution problems.

Slow disk I/O.

Excessive garbage collection pauses.

Connection pool waiting.

Solution
Use distributed tracing and thread dumps to determine where requests are spending time.

A low CPU metric does not necessarily mean that an application is healthy.

Q40. How would you investigate a memory leak in production without restarting the service?
Solution
Start with non-invasive diagnostics.


bash
jcmd <pid> GC.heap_info
jcmd <pid> Thread.print
jcmd <pid> GC.class_histogram
Then:

Examine memory trends.

Check heap occupancy after garbage collection.

Identify classes with growing object counts.

Review cache sizes.

Inspect thread-local variables.

Examine direct memory and native allocations.

Capture a heap dump when operationally safe.

Compare heap dumps to identify retained objects.

Use Java Flight Recorder and Java Mission Control for additional evidence.

Interview answer: A memory leak is usually demonstrated by objects remaining reachable when they should have been released, not simply by high memory usage.

13. Advanced System Design Questions
    Q41. Design an e-commerce microservices architecture.
    Requirements
    User registration and authentication.

Product catalog.

Shopping cart.

Order processing.

Inventory management.

Payment processing.

Notifications.

Order tracking.

Proposed Architecture

text
Web / Mobile Clients
|
v
API Gateway
|
+-------------------+-------------------+
|                   |                   |
v                   v                   v
User Service       Product Service       Cart Service
|                   |                   |
Database             Database            Redis
|
v
Order Service
|
+----------+----------+
|                     |
v                     v
Inventory Service     Payment Service
|                     |
Database              Database
|                     |
+----------+----------+
|
v
Kafka
|
+------------+------------+
|            |            |
v            v            v
Notification     Analytics   Shipping
Service        Service     Service
Important Design Decisions
1. Data ownership

Each service owns its business data.

2. Communication

REST for immediate queries.

Kafka for asynchronous business events.

3. Order processing

Use a saga for inventory reservation, payment, and order confirmation.

4. Caching

Use Redis for appropriate high-read workloads such as product information and shopping carts.

5. Reliability

Use timeouts, circuit breakers, retries, idempotency, and bulkheads.

6. Observability

Use centralized logging, metrics, and distributed tracing.

7. Security

Use OAuth 2.0/OIDC, JWT validation, service identities, and resource-level authorization.

8. Deployment

Deploy services as independently managed Kubernetes workloads.

Q42. Design a highly scalable notification service.
Requirements
Send email, SMS, and push notifications.

Handle millions of notification requests.

Retry temporary failures.

Avoid duplicate notifications.

Track delivery status.

Architecture

text
Order Service
|
v
Kafka
|
v
Notification Service
|
+----------------+
|        |       |
v        v       v
Email     SMS    Push
Provider Provider Provider
Solution
Publish notification requests to Kafka.

Partition messages using an appropriate key.

Use multiple consumer instances.

Implement provider-specific adapters.

Track delivery attempts.

Use idempotency keys.

Apply exponential backoff.

Route exhausted failures to dead-letter topics.

Monitor delivery success rate and lag.

Important Consideration
Do not block the Order Service while waiting for an email or SMS provider to respond.

Q43. Design a URL shortening system using Spring Boot microservices.
Functional Requirements
Generate short URLs.

Redirect users.

Support expiration.

Track clicks.

Provide basic analytics.

Architecture

text
Client
|
v
API Gateway
|
v
URL Service
|
+----------+
|          |
v          v
PostgreSQL  Redis
|
v
Kafka
|
v
Analytics Service
Design Decisions
Short code generation

Use a unique ID and encode it using Base62, or use another collision-safe generation strategy.

Storage

Store short code and original URL in PostgreSQL.

Caching

Cache frequently accessed short codes in Redis.

Analytics

Publish click events asynchronously to Kafka.

Scaling

Scale redirect instances independently from analytics processing.

Security

Validate submitted URLs and protect against malicious redirects.

Q44. How would you design an inventory system that supports high concurrency?
Solution
Use:

Atomic database updates.

Optimistic locking where suitable.

Pessimistic locking for selected critical workflows.

Inventory reservations with expiration.

Idempotent reservation commands.

Saga-based order processing.

Reconciliation jobs.

Example reservation table:


sql
CREATE TABLE inventory_reservation (
id UUID PRIMARY KEY,
order_id BIGINT NOT NULL,
product_id BIGINT NOT NULL,
quantity INTEGER NOT NULL,
status VARCHAR(30) NOT NULL,
expires_at TIMESTAMP NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
Important Design Decision
A reservation is not necessarily a completed sale.

If payment fails or the reservation expires, the system must release the reserved inventory safely.

Q45. How would you implement rate limiting in Spring Cloud Gateway?
Scenario
An external client sends 10,000 requests per second and overloads your services.

Solution
Use gateway-level rate limiting, backed by Redis when distributed rate-limit state is required.

Example configuration:


yaml
spring:
cloud:
gateway:
routes:
- id: product-route
uri: http://product-service
predicates:
- Path=/api/products/**
filters:
- name: RequestRateLimiter
args:
redis-rate-limiter.replenishRate: 10
redis-rate-limiter.burstCapacity: 20
A key resolver must also be configured to identify the client, such as by authenticated user or API key.

Production Considerations
Apply different limits to different clients.

Use a trusted identity rather than an arbitrary forwarded header.

Return HTTP 429 when appropriate.

Monitor rejected requests.

Protect internal services as well as the public gateway.

Q46. What is CQRS, and when would you use it?
CQRS stands for Command Query Responsibility Segregation.

It separates write operations from read operations.

Traditional Approach

text
Client
|
v
Single Service
|
v
Single Database
CQRS Approach

text
Client
|
v
API Layer
/     \
v       v
Command Side  Query Side
|       |
v       v
Write DB   Read Model
|
v
Events
|
v
Projection
When to Use It
Read and write workloads have significantly different requirements.

Read models need different structures from write models.

Complex queries are difficult to support efficiently.

Event-driven projections are appropriate.

Disadvantages
More architectural complexity.

Eventual consistency.

More operational components.

Projection rebuilding and reconciliation requirements.

Do not introduce CQRS into every CRUD application.

Q47. What is eventual consistency?
Eventual consistency means that different parts of a distributed system may temporarily have different views of data, but they are expected to converge if updates stop and processing succeeds.

Example
Customer places an order.

Order Service publishes OrderCreated.

Notification Service receives the event.

Analytics Service updates its projection.

Both services eventually reflect the new order.

Interview Question
What if the user immediately checks analytics after placing the order?

Answer:

"I would define the consistency requirements explicitly. If immediate confirmation is required, I would return the authoritative order result from the Order Service. Analytics can remain eventually consistent."

Q48. How would you handle database schema changes across multiple microservices?
Solution
Use backward-compatible database migrations.

Recommended practices:

Use Flyway or Liquibase.

Version database migrations.

Avoid destructive changes during the first deployment.

Support old and new application versions during rollout.

Use expand-and-contract migrations.

Test migrations against production-like datasets.

Have a backup and recovery strategy.

Example Flyway migration:


sql
ALTER TABLE orders
ADD COLUMN order_reference VARCHAR(100);
Do not make application deployment depend on all services upgrading simultaneously.

14. Senior-Level Interview Questions
    Q49. How do you decide between a monolith, modular monolith, and microservices?
    Factor

Monolith

Modular Monolith

Microservices

Deployment

Single unit

Single unit

Independent services

Complexity

Lower initially

Moderate

Higher

Scaling

Whole application

Whole application

Per service

Data management

Shared

Explicit module boundaries

Service ownership

Team organization

Small teams

Multiple collaborating teams

Autonomous teams

Operations

Simpler

Moderate

More demanding

Senior-Level Answer
"I would choose the architecture based on business requirements, team structure, deployment frequency, scaling needs, and operational maturity. I would avoid microservices when the organization cannot support distributed observability, automation, and independent ownership."

Q50. How do you manage backward compatibility in event-driven systems?
Solution
Use schema evolution.

Add optional fields rather than removing existing fields.

Avoid changing field meanings.

Version event schemas where necessary.

Use schema registries when appropriate.

Test producers and consumers together through contract testing.

Support older consumers during migration.

Example
Old event:


json
{
"orderId": 1001,
"amount": 500
}
New event:


json
{
"orderId": 1001,
"amount": 500,
"currency": "INR"
}
Adding an optional field is generally safer than changing an existing field's type.

Q51. How would you handle a distributed system outage?
Senior-Level Answer
I would follow a structured incident-management process.

Establish incident severity and customer impact.

Identify affected services and dependencies.

Stop further damage through containment.

Check recent deployments and configuration changes.

Examine metrics, logs, and traces.

Restore critical functionality.

Validate data consistency.

Communicate status to stakeholders.

Perform root-cause analysis.

Implement preventive actions.

Important
Restoring service availability and correcting data inconsistency are separate responsibilities. Both must be addressed.

Q52. How do you handle a distributed deadlock?
A distributed deadlock can occur when services or workflows wait on each other in a dependency cycle.

Example:


text
Order Service
|
v
Payment Service
|
v
Inventory Service
|
v
Order Service
Prevention
Avoid circular synchronous dependencies.

Define clear ownership boundaries.

Use asynchronous communication where appropriate.

Establish request deadlines.

Avoid holding database locks while calling remote services.

Monitor long-running workflows.

A dependency graph can help identify circular dependencies before they reach production.

Q53. How do you improve the performance of a Spring Boot application under heavy traffic?
Solution
Investigate and optimize systematically.

Application layer

Reduce unnecessary object creation.

Optimize serialization.

Use efficient data structures.

Avoid blocking operations on inappropriate thread pools.

Database layer

Add appropriate indexes.

Optimize query plans.

Use pagination.

Avoid N+1 queries.

Tune connection pools.

Caching layer

Cache frequently accessed data.

Use suitable TTLs.

Prevent cache stampedes.

Infrastructure

Scale horizontally.

Configure Kubernetes resource requests and limits.

Use load balancing.

Monitor CPU and memory.

Architecture

Reduce synchronous dependencies.

Use asynchronous processing for suitable workloads.

Apply bulkheads and rate limiting.

Q54. What is the difference between horizontal and vertical scaling?
Horizontal Scaling

Vertical Scaling

Add more application instances

Increase CPU and RAM

Improves distributed capacity

Improves capacity of one machine

Requires load balancing

Usually simpler initially

Requires stateless or shared state management

Has hardware limits

Supports resilient deployments when designed correctly

Can preserve existing architecture

Example:


text
Horizontal:
2 Pods -> 5 Pods -> 10 Pods

Vertical:
2 CPU / 4 GB -> 4 CPU / 8 GB
For stateless Spring Boot services, horizontal scaling is often preferred.

Q55. What is the difference between Kubernetes Service, Deployment, and Ingress?
Resource

Responsibility

Deployment

Manages application replicas and rollout

Service

Provides stable networking and access to selected pods

Ingress

Defines HTTP/HTTPS routing from outside the cluster through an ingress controller

Example Deployment

yaml
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
ports:
- containerPort: 8080
Example Service

yaml
apiVersion: v1
kind: Service
metadata:
name: order-service
spec:
selector:
app: order-service
ports:
- port: 8080
targetPort: 8080
type: ClusterIP
Q56. What is the difference between OAuth 2.0 and OpenID Connect?
OAuth 2.0 is an authorization framework.

It enables applications to obtain limited access to protected resources.

OpenID Connect (OIDC) is an identity layer built on OAuth 2.0.

It provides authentication and identity information, commonly through an ID token.

Common Interview Trap
A JWT is a token format. OAuth 2.0 and OIDC are protocols/frameworks. They are not interchangeable terms.

Q57. How do you ensure that one microservice cannot overload another?
Solution
Use multiple protective mechanisms:

Rate limiting.

Bulkheads.

Connection pool limits.

Request timeouts.

Circuit breakers.

Bounded queues.

Backpressure.

Consumer concurrency controls.

Kubernetes resource limits.

The objective is to prevent one overloaded component from causing cascading failures throughout the system.

Q58. What is the difference between orchestration and choreography in microservices?
Orchestration

Choreography

Central coordinator controls workflow

Services react to events

Workflow is explicitly defined

Workflow emerges from event interactions

Easier centralized visibility

More distributed visibility

Coordinator can become a complexity point

Event dependencies can become difficult to understand

Orchestration Example

text
Order Orchestrator
|
+---- Reserve Inventory
|
+---- Process Payment
|
+---- Confirm Order
Choreography Example

text
OrderCreated
|
v
Inventory Service
|
v
InventoryReserved
|
v
Payment Service
|
v
PaymentCompleted
Choose based on workflow complexity, ownership, observability, and recovery requirements.

15. Common Interview Traps
    These are common questions where technically correct but incomplete answers can hurt an interview.

Interview Question

Common Wrong Answer

Better Answer

Are microservices always better?

Yes

Depends on business and operational needs

Does Kafka guarantee exactly-once business execution?

Yes

Processing guarantees require careful design

Does JWT provide authorization automatically?

Yes

Authentication and authorization are different

Should every service have its own database server?

Yes

Each service needs clear data ownership; physical infrastructure can be shared

Should all failures be retried?

Yes

Retry only eligible failures

Does a circuit breaker replace timeouts?

Yes

They solve different problems

Does Kubernetes restart every unhealthy application?

Yes

Liveness and readiness have different responsibilities

Does Redis guarantee database consistency?

Yes

Cache consistency needs explicit design

Does an API Gateway eliminate the need for security inside services?

Yes

Resource services must enforce authorization

Does adding more Kafka consumers always increase throughput?

Yes

Partition count and processing bottlenecks matter

Does a rolling deployment guarantee zero downtime?

Yes

Compatibility, readiness, and graceful shutdown matter

Is a timeout proof that a remote operation failed?

Yes

The operation may have succeeded without a response

16. Quick Revision Cheat Sheet
    Spring Boot
    Concept

Key Point

Dependency Injection

IoC container manages dependencies

@Component

Generic Spring-managed component

@Service

Service-layer component

@Repository

Persistence-layer component

@RestController

REST controller

@Configuration

Java-based configuration

@Bean

Registers a bean

@Transactional

Defines transaction boundaries

@ControllerAdvice

Centralized exception handling

Actuator

Application health and metrics

Microservices
Concept

Key Point

API Gateway

Central routing and cross-cutting policies

Service Discovery

Identifies service instances

Load Balancing

Distributes traffic

Circuit Breaker

Prevents repeated calls to failing dependencies

Bulkhead

Isolates resource usage

Saga

Manages distributed workflows

Outbox

Addresses the database/event dual-write problem

CQRS

Separates command and query responsibilities

Eventual Consistency

Data converges asynchronously

Idempotency

Repeated requests do not repeat business effects

Kafka
Concept

Key Point

Producer

Publishes records

Consumer

Reads records

Topic

Logical event stream

Partition

Unit of ordering and parallelism

Offset

Position in a partition

Consumer Group

Coordinates consumer processing

Consumer Lag

Difference between produced and consumed positions

Dead-Letter Topic

Stores messages that exhaust failure handling

Retention

Controls how long records are stored

Replication

Improves availability and durability

Database
Concept

Key Point

Index

Improves suitable lookup operations

Composite Index

Supports queries using multiple columns

Optimistic Locking

Detects conflicting updates

Pessimistic Locking

Acquires locks before modification

Connection Pool

Reuses database connections

N+1 Problem

Excessive queries caused by relationship loading

Pagination

Retrieves data in bounded portions

Keyset Pagination

Uses ordered key values to continue through records

ACID

Atomicity, Consistency, Isolation, Durability

Flyway

Database migration tool

Redis
Concept

Key Point

Cache-Aside

Application loads cache on demand

TTL

Time to live

Cache Invalidation

Removing or updating stale entries

Cache Stampede

Many requests regenerate the same missing entry

Distributed Lock

Coordinates access across processes

Pub/Sub

Message distribution without durable queue semantics

Kubernetes
Concept

Key Point

Pod

Smallest deployable workload unit

Deployment

Manages replicas and rollouts

Service

Stable networking

Ingress

External HTTP/HTTPS routing

ConfigMap

Non-sensitive configuration

Secret

Sensitive configuration data

Readiness Probe

Controls traffic eligibility

Liveness Probe

Controls restart decisions

Startup Probe

Allows time for application startup

HPA

Horizontal Pod Autoscaler

17. Advanced Spring Boot and Spring Cloud Questions
    Q59. What is the difference between Spring Cloud Config Server and Kubernetes ConfigMap?
    Spring Cloud Config

Kubernetes ConfigMap

Centralized external configuration

Kubernetes-native configuration

Supports Git-backed configuration

Stores cluster configuration

Supports configuration management across environments

Supports pod configuration

Can integrate with refresh mechanisms

Changes require suitable application reload or restart behavior

Interview Answer
"Spring Cloud Config is useful when multiple applications need centralized configuration management. Kubernetes ConfigMaps are useful for environment-specific configuration within Kubernetes. The choice depends on deployment architecture and operational requirements."

Q60. What is the difference between Feign Client, RestClient, and WebClient?
Client

Use Case

OpenFeign

Declarative HTTP clients

RestClient

Synchronous HTTP communication

WebClient

Non-blocking reactive HTTP communication

OpenFeign Example

java
@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    ProductDto getProduct(@PathVariable Long id);
}
RestClient Example

java
@Service
public class ProductClient {

    private final RestClient client;

    public ProductClient(RestClient.Builder builder) {
        this.client = builder
                .baseUrl("http://product-service")
                .build();
    }

    public ProductDto getProduct(Long id) {
        return client.get()
                .uri("/api/products/{id}", id)
                .retrieve()
                .body(ProductDto.class);
    }
}
Interview Trap
WebClient is not automatically faster for every application. Its non-blocking model is particularly useful when the application is designed to use reactive processing end to end.

Q61. What is the difference between @Async and CompletableFuture?
@Async allows Spring-managed methods to execute asynchronously through a configured executor.

CompletableFuture provides an API for composing asynchronous operations.

Both require appropriate executor configuration.

Exceptions must


---

# Spring Boot Microservices: Real-Time Scenario-Based Interview Questions and Solutions

**Post Category:** Interview Preparation / Java / Spring Boot / Microservices
**Level:** Intermediate to Advanced
**Focus:** Real-world production scenarios, system design, debugging, coding, and senior developer interviews
**Technology Stack:** Java 17+, Spring Boot 3.x, Spring Cloud, REST APIs, Kafka, PostgreSQL, Redis, Docker, Kubernetes, and Resilience4j

---

## Table of Contents

1. Microservices Fundamentals
2. Service Communication and API Gateway
3. Service Discovery and Load Balancing
4. Resilience and Fault Tolerance
5. Distributed Transactions and Data Consistency
6. Kafka and Event-Driven Architecture
7. Database and Performance Optimization
8. Security and Authentication
9. Monitoring, Logging, and Distributed Tracing
10. Deployment and Kubernetes
11. Real-World Coding Scenarios
12. Production Troubleshooting Scenarios
13. Advanced System Design Questions
14. Senior-Level Interview Questions
15. Common Interview Traps
16. Quick Revision Cheat Sheet

---

# 1. Microservices Fundamentals

## Q1. Your Spring Boot application is becoming difficult to maintain. How would you decide whether to migrate it to microservices?

### Scenario

You have a monolithic application containing:

- User management
- Product catalog
- Order processing
- Payment processing
- Inventory management

A small change in the payment module requires redeploying the entire application.

### Solution

First, identify whether the monolith has genuine scaling, deployment, ownership, or maintainability problems. Microservices are not automatically better than a modular monolith.

If independent deployment and scaling are justified, divide the system into business capabilities.

```text
                    API Gateway
                         |
          +--------------+--------------+
          |              |              |
     User Service   Product Service  Order Service
                                         |
                                  +------+------+
                                  |             |
                            Payment Service  Inventory Service
```

Each service should ideally:

- Own a clearly defined business capability.
- Have its own data ownership and persistence boundary.
- Be independently deployable.
- Communicate through explicit contracts.
- Handle failures from dependent services.
- Expose health and observability information.

### Interview Answer

"I would start by identifying bounded contexts and business capabilities. I would extract services incrementally rather than rewriting the entire application. I would also establish service contracts, monitoring, deployment automation, and failure-handling mechanisms before increasing the number of services."

Important: Do not create a separate microservice for every entity or database table.

## Q2. How do you design an Order Service that depends on Payment and Inventory services?

### Scenario

A customer places an order. The application must reserve inventory, process payment, and confirm the order.

### Solution

Use an explicit order state machine and a saga-style workflow.

text

```
Order Created
     |
     v
Inventory Reserved
     |
     v
Payment Processed
     |
     v
Order Confirmed
```

If payment fails:

text

```
Payment Failed
      |
      v
Release Inventory
      |
      v
Mark Order Failed
```

A possible order state model is:

java

```
public enum OrderStatus {
    PENDING,
    INVENTORY_RESERVED,
    PAYMENT_PENDING,
    CONFIRMED,
    FAILED,
    CANCELLED
}
```

The Order Service should persist state transitions and coordinate the workflow. For long-running workflows, consider a durable orchestration engine or a saga orchestrator backed by persistent storage.

### Production Considerations

- Use idempotency keys for payment requests.
- Make inventory reservation and release operations idempotent.
- Persist workflow state before acknowledging important transitions.
- Define timeouts and recovery for each step.
- Reconcile orders stuck in intermediate states.
- Never assume that a timeout means the payment failed; the payment provider may have completed the operation without returning a response.

# 2. Service Communication and API Gateway

## Q3. One microservice needs to call another microservice. Would you use REST or Kafka?

### Scenario

The Order Service needs information from the Product Service and also needs to notify other services when an order is placed.

### Solution

Use synchronous communication when the caller needs an immediate response. Use asynchronous messaging when work can happen independently.

| Requirement | Recommended Approach |
| --- | --- |
| Fetch product details | REST |
| Check a current shipping quote | REST or another request-response API |
| Notify downstream services about an order | Kafka |
| Trigger email notifications | Kafka or another asynchronous mechanism |
| Process large event streams | Kafka |
| Coordinate a long-running business workflow | Saga or workflow engine |

### Example REST Client Using Spring's RestClient

java

```
@Service
public class ProductClient {

    private final RestClient restClient;

    public ProductClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("http://product-service")
                .build();
    }

    public ProductDto getProduct(Long productId) {
        return restClient.get()
                .uri("/api/products/{id}", productId)
                .retrieve()
                .body(ProductDto.class);
    }
}
```

This example assumes the hostname can be resolved through your deployment environment or configured service discovery.

### Interview Answer

"I use REST when an immediate response is required and asynchronous messaging when the producer and consumer should be decoupled. I also define timeouts, error handling, retries, and idempotency for either approach."

## Q4. The API Gateway becomes a single point of failure. How would you solve it?

### Scenario

All client requests pass through Spring Cloud Gateway. When the gateway becomes unavailable, every microservice appears unavailable to clients.

### Solution

Deploy multiple gateway instances behind a load balancer.

text

```
                  Clients
                     |
                Load Balancer
                     |
             +-------+-------+
             |               |
         Gateway 1        Gateway 2
             |               |
       +-----+---------------+-----+
       |             |             |
   User Service  Order Service  Product Service
```

Recommended measures:

- Run multiple gateway replicas.
- Use health checks and readiness probes.
- Configure connection and response timeouts.
- Apply rate limiting and request-size limits.
- Avoid storing critical session state only in gateway memory.
- Monitor gateway latency, error rate, and saturation.
- Configure graceful shutdown and rolling deployments.

### Spring Cloud Gateway Example

yaml

```
spring:
  cloud:
    gateway:
      routes:
        - id: order-service
          uri: http://order-service:8080
          predicates:
            - Path=/api/orders/**
```

The destination shown here is a logical service address in a suitable network or service-discovery environment.

Interview Trap: An API Gateway is not automatically highly available merely because it routes traffic to multiple backend services.

## Q5. A REST call between services is taking too long. What would you investigate?

### Scenario

The frontend calls the Order Service, which calls Inventory, Payment, and Shipping sequentially.

Each downstream call takes approximately 500 ms.

### Solution

Start with tracing and latency measurements rather than immediately adding threads.

Investigate:

- DNS and service discovery latency.
- Connection pool exhaustion.
- Database query time.
- Network latency.
- Downstream service saturation.
- Serialization overhead.
- Retry amplification.
- Sequential dependencies that could safely run in parallel.

If independent calls are involved, asynchronous composition may reduce latency.

java

```
CompletableFuture<InventoryDto> inventory =
        CompletableFuture.supplyAsync(
                () -> inventoryClient.getInventory(productId),
                ioExecutor
        );

CompletableFuture<ShippingDto> shipping =
        CompletableFuture.supplyAsync(
                () -> shippingClient.getShippingEstimate(address),
                ioExecutor
        );

CompletableFuture.allOf(inventory, shipping).join();
```

Here, `ioExecutor` is a configured executor appropriate for the workload. In production, also configure timeouts, exception handling, cancellation where appropriate, and a policy for partial failures.

Do not parallelize operations with business dependencies, such as charging a payment before the required order validation has completed.

## Q6. How do you handle API versioning when one service changes its response format?

### Scenario

The Product Service changes its response.

Old response:

json

```
{
  "productId": 10,
  "price": 100
}
```

New response:

json

```
{
  "id": 10,
  "pricing": {
    "amount": 100,
    "currency": "INR"
  }
}
```

Older consumers still expect the original format.

### Solution

Prefer backward-compatible evolution whenever possible.

- Add optional fields before removing old fields.
- Avoid renaming or changing the meaning of existing fields unexpectedly.
- Maintain contract tests for consumers.
- Use an explicit versioning strategy for breaking changes.
- Migrate consumers before removing the old contract.
- Use a compatibility period and monitor remaining old-version traffic.

Possible URL versioning:

text

```
/api/v1/products/10
/api/v2/products/10
```

Alternatively, teams may use media-type or header-based versioning.

### Interview Answer

"I prefer additive, backward-compatible changes. For breaking changes, I introduce a new contract, migrate consumers gradually, and remove the old version only after verifying that it is no longer used."

# 3. Service Discovery and Load Balancing

## Q7. A service's IP address changes after deployment. How do other services find it?

### Scenario

The Order Service uses a hardcoded address:

java

```
http://192.168.1.20:8080
```

After redeployment, the Product Service gets a new IP address.

### Solution

Avoid hardcoded instance addresses.

Depending on the environment, use:

- Kubernetes Services and DNS.
- Spring Cloud service discovery, such as Eureka.
- A platform load balancer.
- DNS-based service routing.

In Kubernetes, a client can call a stable service name:

text

```
http://product-service:8080
```

Kubernetes routes traffic to ready endpoints behind that Service.

In a Spring Cloud deployment with discovery configured, a load-balanced client may use a logical service name:

java

```
RestClient client = restClientBuilder
        .baseUrl("http://product-service")
        .build();
```

This requires the appropriate Spring Cloud LoadBalancer and discovery configuration.

Key Point: Service discovery and load balancing solve related but different problems. Discovery identifies available instances; load balancing distributes requests among them.

## Q8. One service instance is unhealthy, but requests are still routed to it. Why?

### Scenario

The application process is running, but its database connection pool is exhausted. Clients continue receiving errors.

### Solution

Distinguish between process liveness and application readiness.

- Liveness: Should the process be restarted?
- Readiness: Can the instance safely receive traffic?
- Startup probe: Has the application completed startup?

Spring Boot Actuator can expose health endpoints:

text

```
/actuator/health
/actuator/health/liveness
/actuator/health/readiness
```

Example dependency:

xml

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Example Kubernetes configuration:

yaml

```
readinessProbe:
  httpGet:
    path: /actuator/health/readiness
    port: 8080
  initialDelaySeconds: 10
  periodSeconds: 5

livenessProbe:
  httpGet:
    path: /actuator/health/liveness
    port: 8080
  initialDelaySeconds: 20
  periodSeconds: 10
```

Configure Spring Boot health groups and availability-state integration as needed. Do not make every transient dependency failure trigger an immediate restart.

# 4. Resilience and Fault Tolerance

## Q9. Payment Service is down. How do you prevent the Order Service from failing completely?

### Scenario

Every order request synchronously calls Payment Service. Payment becomes unavailable, causing requests to accumulate and threads to become exhausted.

### Solution

Apply several complementary controls.

- Connection and response timeouts.
- Bounded retries for transient errors.
- Circuit breaker.
- Bulkhead isolation.
- Graceful degradation where business rules permit it.
- Durable queuing or a saga for workflows that can continue asynchronously.

### Example Resilience4j Configuration

yaml

```
resilience4j:
  circuitbreaker:
    instances:
      paymentService:
        slidingWindowSize: 20
        minimumNumberOfCalls: 10
        failureRateThreshold: 50
        waitDurationInOpenState: 10s
  retry:
    instances:
      paymentService:
        maxAttempts: 3
        waitDuration: 200ms
```

Example service:

java

```
@Service
public class PaymentServiceClient {

    @CircuitBreaker(name = "paymentService")
    @Retry(name = "paymentService")
    public PaymentResponse charge(PaymentRequest request) {
        return callPaymentProvider(request);
    }

    private PaymentResponse callPaymentProvider(
            PaymentRequest request) {
        // Call the payment provider using a configured HTTP client.
        throw new UnsupportedOperationException(
                "Implement the actual provider integration");
    }
}
```

The example assumes the relevant Resilience4j Spring integration is installed and configured.

### Important Production Detail

Retrying a payment operation can accidentally charge a customer twice. Use provider-supported idempotency keys and distinguish retryable failures from permanent failures.

Do not blindly retry every HTTP 4xx or 5xx response.

## Q10. What is the difference between a timeout, retry, circuit breaker, and bulkhead?

| Mechanism | Purpose | Example |
| --- | --- | --- |
| Timeout | Limits how long a request may wait | Stop waiting after 2 seconds |
| Retry | Reattempts eligible transient failures | Retry a temporary network error |
| Circuit breaker | Temporarily blocks calls to an unhealthy dependency | Fail fast when payment repeatedly fails |
| Bulkhead | Limits resource consumption by one workload | Restrict concurrent payment calls |

These mechanisms complement each other.

A retry without a timeout may wait too long. A retry without a circuit breaker can amplify an outage. A circuit breaker without appropriate monitoring may open too aggressively or remain open longer than necessary.

## Q11. A downstream service is slow, and your retry mechanism makes the problem worse. Why?

### Scenario

An Inventory Service normally responds in 100 ms. During an incident, it takes 5 seconds. The Order Service retries each failed request three times.

### Solution

Retries multiply traffic precisely when the dependency is overloaded.

Use:

- Strict request deadlines.
- Exponential backoff.
- Randomized jitter.
- Limited retry attempts.
- Retry budgets.
- Circuit breakers.
- Separate concurrency limits.
- Monitoring for retry rate and downstream saturation.

For example, a retry policy might use increasing delays rather than immediately repeating the request.

text

```
Initial attempt
      |
      v
Failure
      |
      v
Wait 200 ms + jitter
      |
      v
Retry
      |
      v
Wait 400 ms + jitter
      |
      v
Final attempt
```

The exact delay and retry count should depend on the remaining request deadline and the operation's idempotency.

# 5. Distributed Transactions and Data Consistency

## Q12. Order Service and Payment Service have separate databases. How do you maintain consistency?

### Scenario

The Order Service saves an order successfully, but Payment Service fails before recording payment.

### Solution

A traditional local database transaction cannot atomically commit changes across independently managed databases.

Use a saga or another explicit distributed workflow.

text

```
Order Service
    |
    | Create pending order
    v
Inventory Service
    |
    | Reserve stock
    v
Payment Service
    |
    | Charge payment
    v
Order confirmed
```

If payment fails, execute a compensating action to release stock and update the order status.

### Two Saga Approaches

Orchestration

A coordinator explicitly directs the workflow and records progress.

Choreography

Services publish and react to domain events.

For a complex workflow with multiple branches, timeouts, and compensation steps, orchestration is often easier to observe and manage.

### Interview Answer

"I would not attempt to share a database transaction across services. I would model the workflow as a saga, persist its state, use idempotent commands, and add recovery and reconciliation for incomplete transactions."

## Q13. What is the Transactional Outbox Pattern, and when would you use it?

### Scenario

The Order Service commits an order to its database, then publishes an OrderCreated event to Kafka.

The database commit succeeds, but Kafka is unavailable. Other services never receive the event.

### Problem

Writing to a database and publishing to Kafka are two independent operations. A crash between them can cause inconsistency.

### Solution

Write the business record and event to the same database transaction.

text

```
Database Transaction
    |
    +-- Insert Order
    |
    +-- Insert Outbox Event
    |
    +-- Commit
             |
             v
      Outbox Publisher
             |
             v
           Kafka
             |
             v
       Event Consumers
```

Simplified schema:

sql

```
CREATE TABLE outbox_event (
    id UUID PRIMARY KEY,
    aggregate_id VARCHAR(100) NOT NULL,
    event_type VARCHAR(100) NOT NULL,
    payload JSONB NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    published_at TIMESTAMP NULL
);
```

The application writes the order and outbox event in one local transaction. A separate publisher or CDC-based mechanism forwards the event to Kafka.

### Production Considerations

- Publish events with stable IDs.
- Make consumers idempotent.
- Track publication failures.
- Handle duplicate delivery.
- Monitor outbox backlog.
- Define retention and cleanup policies.

Important: The outbox pattern does not automatically guarantee exactly-once business processing. It closes the database/event dual-write gap, while delivery and consumer processing still need appropriate guarantees.

## Q14. A Kafka consumer receives the same event twice. How do you prevent duplicate business operations?

### Scenario

The Payment Service receives OrderCreated twice and attempts to charge the customer twice.

### Solution

Implement idempotent consumption.

sql

```
CREATE TABLE processed_events (
    event_id UUID PRIMARY KEY,
    processed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

Simplified transaction logic:

java

```
@Transactional
public void process(OrderCreatedEvent event) {
    boolean firstDelivery = eventRepository
            .insertIfAbsent(event.eventId());

    if (!firstDelivery) {
        return;
    }

    paymentRepository.createPaymentIfAbsent(
            event.orderId(),
            event.amount()
    );
}
```

Here, `insertIfAbsent` represents a database operation backed by a unique constraint. The event record and business update must commit in the same transaction for this pattern to work reliably.

For an external payment provider, also use a stable idempotency key at the provider boundary.

### Interview Answer

"Kafka consumers can receive duplicate messages. I use a stable event ID, a unique database constraint, transactional processing, and idempotent business operations. I do not rely on the consumer alone to guarantee that a payment happens exactly once."

# 6. Kafka and Event-Driven Architecture

## Q15. A Kafka consumer is slower than the producer. What would you do?

### Scenario

The producer publishes 10,000 messages per second, while consumers process only 5,000 messages per second.

The consumer lag keeps increasing.

### Solution

Investigate before increasing the number of consumers.

Check:

- Consumer lag per partition.
- Processing time per message.
- Database or external API latency.
- Number of partitions.
- Consumer concurrency.
- Rebalances and failed messages.
- Batch size and polling configuration.
- Serialization and deserialization overhead.

Potential improvements include:

- Increasing partition count when appropriate.
- Scaling consumers up to the useful partition parallelism.
- Batching database writes.
- Reducing expensive downstream calls.
- Using asynchronous processing carefully.
- Separating slow event types into different topics.
- Implementing bounded retries and dead-letter handling.

Important: A consumer group cannot actively consume more partitions in parallel than the topic has available partitions. Adding consumers beyond useful partition parallelism may leave some consumers idle.

## Q16. What happens when a Kafka consumer fails while processing a message?

### Scenario

The consumer reads a message, updates a database, and crashes before committing its offset.

### Solution

The message may be delivered again after restart.

That is why message handling should be idempotent.

text

```
Read message
    |
    v
Begin database transaction
    |
    v
Check event ID
    |
    v
Apply business update
    |
    v
Record event as processed
    |
    v
Commit database transaction
    |
    v
Acknowledge/commit Kafka offset
```

The database transaction and Kafka offset commit are not automatically one atomic transaction. A crash between them can cause reprocessing, so the business update must tolerate duplicates.

### Additional Considerations

- Use manual acknowledgments or carefully configured acknowledgment modes where appropriate.
- Configure retries for transient failures.
- Send poison messages to a dead-letter topic after a defined policy.
- Monitor consumer lag and dead-letter volume.
- Preserve ordering where the business requires it, usually by keying events appropriately.

## Q17. How do you handle a poison message that always fails?

### Scenario

A malformed event causes the same consumer to fail repeatedly, preventing progress.

### Solution

Use a bounded retry strategy and a dead-letter topic.

text

```
Main Topic
    |
    v
Consumer
    |
    +---- Success
    |
    +---- Retryable Failure
    |          |
    |          v
    |     Retry Policy
    |
    +---- Permanent / Exhausted Failure
               |
               v
          Dead-Letter Topic
```

Include enough metadata to diagnose the failure:

- Original topic and partition.
- Original offset.
- Event ID.
- Failure reason.
- Number of attempts.
- Timestamp.

Avoid putting credentials, payment data, or unnecessary personal information in dead-letter records.

A dead-letter topic should have an operational replay procedure, not simply become a permanent dumping ground.

# 7. Database and Performance Optimization

## Q18. Two services need the same customer data. Should they share one database?

### Scenario

Order Service and Notification Service both need customer email addresses.

### Solution

Prefer clear data ownership.

- Customer Service owns the authoritative customer record.
- Order Service stores only the customer information it needs for its own business workflow.
- Notification Service may maintain a projection or consume customer update events.
- Services communicate through APIs or events when current authoritative information is required.

Sharing a database can introduce schema coupling, coordinated deployments, and accidental cross-service transactions.

However, duplicating selected data for read performance is often appropriate when ownership and synchronization rules are explicit.

### Interview Answer

"I prefer database ownership per service. If another service needs the data, I use an API or event-driven projection. I accept controlled duplication when it improves resilience or performance, with a clear consistency strategy."

## Q19. An API is slow because it executes too many database queries. How do you fix it?

### Scenario

The Order Service retrieves 100 orders. For each order, it separately queries the customer and product tables.

This is the N+1 query problem.

### Solution

Use:

- Appropriate joins or projections.
- Batch fetching.
- Bulk repository methods.
- Query-specific DTOs.
- Database indexes.
- Query-plan analysis.

Example:

java

```
public interface OrderRepository
        extends JpaRepository<Order, Long> {

    @Query("""
        select new com.example.api.OrderSummary(
            o.id, o.status, o.totalAmount
        )
        from Order o
        where o.customerId = :customerId
        """)
    List<OrderSummary> findSummaries(
            Long customerId);
}
```

For cross-service data, do not assume a JPA join can fetch data from another service's database. Use a suitable API, event-driven read model, or aggregation strategy.

Measure query count and latency before and after the change.

## Q20. Your service's memory usage grows continuously. What would you investigate?

### Scenario

A Spring Boot service starts with 300 MB of memory usage, then grows to several gigabytes over several hours.

### Solution

Investigate:

- Heap usage after garbage collection.
- Object allocation rate.
- Large collections or unbounded caches.
- Thread-local data.
- Retained references.
- Thread count and thread stacks.
- Direct buffers and native memory.
- Metaspace usage.
- Request and connection accumulation.

Useful tools include:

- Java Flight Recorder.
- Java Mission Control.
- VisualVM.
- Heap dumps.
- `jcmd`.
- Garbage-collection logs.
- Micrometer and application metrics.

Useful diagnostic commands:

bash

```
jcmd <pid> GC.heap_info
jcmd <pid> Thread.print
jcmd <pid> GC.class_histogram
```

Run diagnostic commands according to your environment's permissions and operational policies.

### Interview Answer

"I would compare heap occupancy after garbage collection over time, capture a heap dump if appropriate, and inspect retained objects. I would also check native memory, thread growth, caches, and connection pools rather than assuming every memory problem is a Java heap leak."

# 8. Security and Authentication

## Q21. How do you secure communication between microservices?

### Scenario

The API Gateway authenticates a user, but internal services are accessible directly.

An attacker who can reach the internal network may bypass the gateway.

### Solution

Apply defense in depth.

- Authenticate external requests.
- Enforce authorization at the service that owns the resource.
- Use TLS for service-to-service traffic when required by the security model.
- Use service identities or OAuth 2.0 client credentials for machine-to-machine access.
- Restrict network access with firewall or network policies.
- Validate token issuer, audience, expiration, and required scopes.
- Keep secrets in a dedicated secret-management system.

### Example Spring Security Resource-Server Configuration

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
                        .requestMatchers("/actuator/health")
                        .permitAll()
                        .requestMatchers("/api/admin/**")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt()
                )
                .build();
    }
}
```

This example assumes JWT resource-server dependencies and issuer or decoder configuration are supplied. Production health endpoints should expose only the information appropriate for their intended audience.

## Q22. A JWT token is valid, but a user can access another user's order. What is wrong?

### Scenario

The request is authenticated, but the application checks only whether the user has a valid token.

text

```
GET /api/orders/123
```

The order belongs to another customer.

### Solution

Authentication establishes identity. Authorization determines whether that identity can access a specific resource.

java

```
public OrderDto getOrder(
        Long orderId,
        String authenticatedCustomerId) {

    Order order = orderRepository
            .findById(orderId)
            .orElseThrow(OrderNotFoundException::new);

    if (!order.getCustomerId()
            .equals(authenticatedCustomerId)) {
        throw new AccessDeniedException(
                "Not authorized to access this order");
    }

    return mapToDto(order);
}
```

In real applications, derive the customer identity from the validated security context rather than trusting a client-supplied identity parameter.

Also consider tenant isolation, administrative roles, and resource-level authorization.

# 9. Monitoring, Logging, and Distributed Tracing

## Q23. A customer reports that an order failed, but every service log looks normal. How would you debug it?

### Scenario

The request passes through API Gateway, Order Service, Inventory Service, and Payment Service.

Each service has a separate log file.

### Solution

Use distributed tracing and structured logging.

text

```
Client
  |
  | traceId = abc123
  v
API Gateway
  |
  v
Order Service
  |
  +---- Inventory Service
  |
  +---- Payment Service
```

Propagate trace context across supported HTTP and messaging boundaries.

Record useful fields such as:

- Trace ID and span ID.
- Order ID or another safe correlation identifier.
- Service name.
- HTTP status.
- Latency.
- Error category.
- Retry count.

Use Micrometer Observation and tracing integrations with an exporter such as OpenTelemetry.

Do not log access tokens, passwords, full payment details, or sensitive personal data.

## Q24. Which metrics should you monitor for a Spring Boot microservice?

### Solution

Start with four broad categories.

| Category | Useful Metrics |
| --- | --- |
| Traffic | Request count, throughput, message rate |
| Errors | HTTP 5xx rate, failed jobs, exceptions |
| Latency | p50, p95, p99 response time |
| Saturation | CPU, memory, thread pools, connection pools |

Also monitor business and dependency-specific metrics:

- Orders created and completed.
- Payment success and failure rate.
- Kafka consumer lag.
- Database connection acquisition latency.
- Circuit breaker state.
- Retry volume.
- Outbox backlog.
- Dead-letter message count.

Example Actuator configuration:

yaml

```
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  endpoint:
    health:
      probes:
        enabled: true
```

Expose endpoints only through an appropriate security and network policy. Add a Prometheus registry dependency if Prometheus metrics are required.

# 10. Deployment and Kubernetes

## Q25. Your application works locally but fails in Docker. How do you investigate?

### Scenario

The application connects successfully to PostgreSQL on a developer's machine but fails in a container.

### Common Causes

- Using localhost to refer to another container.
- Incorrect environment variables.
- Missing configuration files.
- Wrong container port.
- DNS or network configuration issues.
- File-system permission problems.
- Java version mismatch.
- Insufficient container memory.

### Solution

Check the effective configuration and container logs.

bash

```
docker logs <container-name>
docker inspect <container-name>
docker ps
```

Inside a container, localhost refers to that container itself. Use the appropriate service name when communicating with another container on the same Docker network.

For example:

yaml

```
spring:
  datasource:
    url: jdbc:postgresql://postgres:5432/orders
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

Here, `postgres` must resolve to the database container or service in the deployment environment.

Never commit production database passwords into the repository.

## Q26. A Kubernetes pod keeps restarting. What steps would you take?

### Solution

Start with pod status and events.

bash

```
kubectl get pods
kubectl describe pod <pod-name>
kubectl logs <pod-name>
kubectl logs <pod-name> --previous
kubectl get events --sort-by=.metadata.creationTimestamp
```

Investigate likely causes:

- OOMKilled: memory limit exceeded.
- CrashLoopBackOff: repeated application failures.
- ImagePullBackOff: image or registry access problem.
- Failed startup or liveness probes.
- Invalid environment variables or secrets.
- Database connectivity failures.
- Incorrect command or entry point.
- Permission or volume-mount problems.

Do not simply increase memory limits without checking heap, native memory, allocation rate, and container limits.

### Interview Answer

"I inspect pod events, current and previous logs, termination reasons, resource usage, and probe failures. I identify the underlying failure before changing resource limits or restarting the workload."

## Q27. How do you deploy a new microservice version without downtime?

### Solution

Use a deployment strategy appropriate for the platform and application.

For a typical Kubernetes rolling update:

- Run multiple replicas.
- Define readiness probes.
- Set suitable rolling-update parameters.
- Handle graceful shutdown.
- Keep API and event contracts backward-compatible.
- Use database changes that support old and new versions during rollout.
- Monitor error rate and latency during deployment.
- Have a rollback strategy.

A safe database migration commonly follows an expand-and-contract approach:

text

```
Release 1: Add new nullable column
       |
       v
Release 2: Write old and new representations
       |
       v
Release 3: Migrate existing data
       |
       v
Release 4: Read new representation
       |
       v
Release 5: Remove old column after validation
```

The exact sequence depends on the schema and compatibility requirements.

Important: Rolling deployments alone do not guarantee zero downtime. Database compatibility, readiness, connection draining, and request handling also matter.

# 11. Real-World Coding Scenarios

## Q28. How would you prevent duplicate order creation when a client retries a request?

### Scenario

The client submits an order, but the network connection times out before receiving the response. The client retries and accidentally creates a second order.

### Solution

Use an idempotency key.

Request:

http

```
POST /api/orders
Idempotency-Key: 8b20e5c1-example
Content-Type: application/json
```

Store the key with a unique constraint and associate it with the resulting order or response.

Conceptual database schema:

sql

```
CREATE TABLE idempotency_record (
    idempotency_key VARCHAR(100) PRIMARY KEY,
    request_hash VARCHAR(64) NOT NULL,
    order_id BIGINT,
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

### Processing Flow

1. Validate the request.
2. Look up the idempotency key.
3. If already completed with the same request, return the original result.
4. If the key exists with a different request payload, reject the request.
5. Otherwise, create the order and record the outcome transaction.

# 12. Production Troubleshooting Scenarios

Additional scenarios to be developed.

Suggested topics:

- High CPU utilization in a Spring Boot application.
- PostgreSQL connection pool exhaustion.
- Kafka consumer lag suddenly increasing.
- Redis cache returning stale data.
- Intermittent HTTP 503 errors.
- Deadlocks in concurrent order processing.
- Thread pool exhaustion.
- Kubernetes OOMKilled incidents.
- Slow API responses after deployment.
- Database replication lag.

# 13. Advanced System Design Questions

Additional scenarios to be developed.

Suggested topics:

- Design an e-commerce microservices architecture.
- Design a high-throughput order processing system.
- Design an inventory reservation system.
- Design a distributed payment processing system.
- Design a notification platform using Kafka.
- Design a real-time analytics pipeline.
- Design a multi-tenant SaaS application.
- Design an event-driven architecture with eventual consistency.

# 14. Senior-Level Interview Questions

Additional questions to be developed.

Suggested topics:

- How do you define service boundaries?
- How do you handle cross-service data ownership?
- How do you design for horizontal scalability?
- How do you manage backward compatibility?
- How do you prevent cascading failures?
- How do you establish SLOs and SLIs?
- How do you perform production incident analysis?
- How do you manage technical debt in microservices?
- How do you decide between orchestration and choreography?
- How do you conduct architecture reviews?

# 15. Common Interview Traps

1. Assuming microservices are always better than monoliths.
2. Creating one microservice for every database table.
3. Assuming Kafka guarantees exactly-once business processing.
4. Retrying every failed HTTP request.
5. Ignoring idempotency in payment operations.
6. Sharing databases without defining ownership.
7. Assuming an API Gateway provides automatic high availability.
8. Confusing authentication with authorization.
9. Assuming a successful liveness probe means the application is ready.
10. Scaling Kafka consumers without considering partition count.
11. Ignoring distributed tracing.
12. Assuming rolling deployments guarantee zero downtime.
13. Treating a timeout as proof that a remote operation failed.
14. Ignoring database schema compatibility during deployments.
15. Treating a dead-letter queue as a permanent solution.

# 16. Quick Revision Cheat Sheet

| Topic | Key Concept |
| --- | --- |
| Service boundaries | Bounded Context |
| Inter-service communication | REST / Kafka |
| API Gateway | Routing, authentication, rate limiting |
| Service discovery | Eureka / Kubernetes DNS |
| Load balancing | Distribute traffic across instances |
| Fault tolerance | Circuit Breaker |
| Resource isolation | Bulkhead |
| Failure recovery | Retry with backoff and jitter |
| Distributed transactions | Saga Pattern |
| Database-event consistency | Transactional Outbox |
| Duplicate messages | Idempotent Consumer |
| Kafka performance | Partitions and Consumer Lag |
| Poison messages | Dead-Letter Topic |
| Database ownership | Database per Service |
| Query optimization | Indexes, projections, batch fetching |
| Authentication | OAuth 2.0 / JWT |
| Authorization | Roles, scopes, resource ownership |
| Monitoring | Metrics, logs, traces |
| Observability | Micrometer / OpenTelemetry |
| Containerization | Docker |
| Orchestration | Kubernetes |
| Zero-downtime deployment | Rolling / Blue-Green / Canary |
| API compatibility | Backward-Compatible Versioning |
| Duplicate API requests | Idempotency Key |

## Final Interview Preparation Advice

For intermediate-to-advanced Spring Boot Microservices interviews, focus on explaining not only what a technology does, but also why you selected it and what trade-offs it introduces.

For every production scenario, structure your answer around:

1. Problem Identification: What is failing and how do you detect it?
2. Root Cause Analysis: What evidence would you collect?
3. Solution: Which architectural or technical approach would you implement?
4. Failure Handling: What happens if the solution or a dependency fails?
5. Production Readiness: How do you monitor, test, deploy, and recover?

Remember: Senior-level interviews evaluate architectural reasoning, trade-off analysis, production experience, and the ability to solve distributed-system problems—not just knowledge of Spring Boot annotations.

```

**Note:** The Markdown above preserves the supplied Q1–Q28 material and includes the remaining requested sections as clearly marked topics for further development.
```

---
Below is the Markdown (`.md`) version of your content, structured with proper headings, tables, bullet points, and fenced code blocks. You can copy it into a file named:

`Additional_Spring_Boot_Microservices_Interview_Questions.md`

Additional\_Spring\_Boot\_Microservices\_Interview\_Questions.md

Markdown

Writing

# Additional Spring Boot Microservices Interview Questions and Solutions

The existing document covers Q1–Q28. Below is the continuation, designed to fill the missing sections and prepare you for Intermediate, Advanced, and Senior Java Developer interviews.

The additional material focuses on production incidents, coding exercises, distributed systems, architecture decisions, and questions frequently asked in senior-level interviews.

## Technology Assumptions

- Java 17+
- Spring Boot 3.x
- Spring Cloud
- Spring Security 6
- Kafka
- PostgreSQL
- Redis
- Docker and Kubernetes
- Resilience4j
- Micrometer and OpenTelemetry

---

# 11\. Real-World Coding Scenarios (Continued)

## Q29. How would you implement pagination and sorting for millions of records?

### Scenario

An Order Service contains 10 million records. Returning all orders in one API response causes high memory usage and slow response times.

### Solution

Use database-level pagination and sorting.

**Spring Data JPA example:**

java

```
public interface OrderRepository
        extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerId(
            Long customerId,
            Pageable pageable
    );
}
```

**Service:**

java

```
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Page<Order> getOrders(
            Long customerId,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("createdAt").descending()
        );

        return repository.findByCustomerId(
                customerId,
                pageable
        );
    }
}
```

**API:**

http

```
GET /api/orders?page=0&size=20
```

### Production Considerations

- Set a maximum page size.
- Index frequently filtered and sorted columns.
- Avoid fetching unnecessary entity relationships.
- Use DTO projections.
- Consider keyset pagination for very large datasets.
- Avoid expensive count queries when totals are not required.

For keyset pagination, use a stable ordering such as `(created_at, id)` and fetch records after the last returned key.

## Q30. How would you implement caching using Redis in Spring Boot?

### Scenario

The Product Service receives 50,000 requests per minute for frequently accessed product details.

Repeated database queries increase database CPU utilization.

### Solution

Use Redis caching with an appropriate expiration policy.

**Dependency:**

xml

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

**Enable caching:**

java

```
@Configuration
@EnableCaching
public class CacheConfig {
}
```

**Service:**

java

```
@Service
public class ProductService {

    @Cacheable(
        value = "products",
        key = "#productId"
    )
    public ProductDto getProduct(Long productId) {
        return fetchFromDatabase(productId);
    }

    @CacheEvict(
        value = "products",
        key = "#productId"
    )
    public void updateProduct(Long productId) {
        updateDatabase(productId);
    }

    private ProductDto fetchFromDatabase(Long id) {
        // Database implementation
        return null;
    }

    private void updateDatabase(Long id) {
        // Database implementation
    }
}
```

### Production Considerations

- Configure TTL.
- Prevent cache stampedes.
- Consider cache penetration and hot keys.
- Define cache invalidation rules.
- Avoid caching sensitive data unnecessarily.
- Monitor cache hit ratio and Redis memory usage.

**Interview trap:** Redis caching does not automatically guarantee consistency between the cache and database.

## Q31. How do you prevent race conditions when two customers purchase the last available product?

### Scenario

- Inventory shows one item available.
- Two customers place orders simultaneously.
- Both requests read the inventory value as one and attempt to reserve it.

### Solution

Use atomic database operations rather than a separate read followed by an update.

**PostgreSQL example:**

sql

```
UPDATE inventory
SET available_quantity = available_quantity - 1
WHERE product_id = :productId
AND available_quantity >= 1;
```

Check the affected row count:

- One row updated: reservation succeeded.
- Zero rows updated: insufficient inventory or missing product.

**Java:**

java

```
@Transactional
public void reserveInventory(Long productId) {

    int updated = inventoryRepository
            .reserveOneItem(productId);

    if (updated == 0) {
        throw new InsufficientInventoryException(
                "Product unavailable"
        );
    }
}
```

**Repository:**

java

```
@Modifying
@Query(value = """
    UPDATE inventory
    SET available_quantity = available_quantity - 1
    WHERE product_id = :productId
      AND available_quantity >= 1
    """, nativeQuery = true)
int reserveOneItem(Long productId);
```

### Alternative Approaches

- Optimistic locking using `@Version`.
- Pessimistic locking using `SELECT FOR UPDATE`.
- Atomic Redis operations, with a durable database consistency strategy.

For critical inventory operations, the database should remain the authoritative source of truth.

## Q32. How would you implement global exception handling in Spring Boot?

### Solution

Use `@RestControllerAdvice`.

java

```
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
        ResourceNotFoundException.class
    )
    public ResponseEntity<ProblemDetail> handleNotFound(
            ResourceNotFoundException ex) {

        ProblemDetail problem =
                ProblemDetail.forStatus(
                        HttpStatus.NOT_FOUND
                );

        problem.setTitle("Resource Not Found");
        problem.setDetail(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(problem);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleGeneral(
            Exception ex) {

        ProblemDetail problem =
                ProblemDetail.forStatus(
                        HttpStatus.INTERNAL_SERVER_ERROR
                );

        problem.setTitle("Internal Server Error");
        problem.setDetail(
                "An unexpected error occurred"
        );

        return ResponseEntity
                .internalServerError()
                .body(problem);
    }
}
```

### Best Practices

- Use consistent error response formats.
- Include correlation or trace IDs.
- Do not expose stack traces to clients.
- Map validation failures to HTTP 400.
- Map unauthorized access to HTTP 401 or 403 appropriately.
- Log unexpected exceptions with sufficient diagnostic context.
- Avoid logging sensitive information.

## Q33. How do you handle multiple downstream API calls efficiently?

### Scenario

The Dashboard Service needs information from:

- Customer Service
- Order Service
- Payment Service
- Notification Service

Calling them sequentially creates high latency.

### Solution

Use parallel execution for independent operations.

java

```
CompletableFuture<CustomerDto> customerFuture =
        CompletableFuture.supplyAsync(
                () -> customerClient.getCustomer(customerId),
                ioExecutor
        );

CompletableFuture<List<OrderDto>> ordersFuture =
        CompletableFuture.supplyAsync(
                () -> orderClient.getOrders(customerId),
                ioExecutor
        );

CompletableFuture<PaymentSummary> paymentFuture =
        CompletableFuture.supplyAsync(
                () -> paymentClient.getSummary(customerId),
                ioExecutor
        );

CompletableFuture.allOf(
        customerFuture,
        ordersFuture,
        paymentFuture
).join();

CustomerDto customer = customerFuture.join();
List<OrderDto> orders = ordersFuture.join();
PaymentSummary payments = paymentFuture.join();
```

### Production Considerations

- Use a bounded executor.
- Configure per-service timeouts.
- Handle partial failures.
- Avoid unbounded thread creation.
- Consider bulkheads for individual dependencies.
- Define a fallback or partial-response policy.

For Java 21 deployments, virtual threads can also be evaluated for suitable blocking workloads. They do not eliminate the need for downstream concurrency limits.

## Q34. How would you implement optimistic locking in Spring Boot?

### Scenario

Two administrators update the same product simultaneously.

The second administrator accidentally overwrites the first administrator's changes.

### Solution

Use JPA optimistic locking.

java

```
@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    @Version
    private Long version;
}
```

When updating, JPA checks the version.

If another transaction has already modified the record, the update fails with an optimistic locking exception.

**Handle the conflict:**

java

```
try {
    productRepository.save(product);
} catch (OptimisticLockingFailureException ex) {
    throw new ConcurrentUpdateException(
            "Product was modified by another user"
    );
}
```

Use optimistic locking when conflicts are relatively uncommon.

Use pessimistic locking when concurrent modifications need stronger serialization and the resulting lock contention is acceptable.

---

# 12\. Production Troubleshooting Scenarios

## Q35. Your Spring Boot application suddenly starts returning HTTP 503. How do you investigate?

### Scenario

The application was working normally, but users suddenly receive:

http

```
503 Service Unavailable
```

### Investigation Steps

1. Check API Gateway health.
2. Check Kubernetes pod readiness.
3. Check downstream service availability.
4. Inspect connection pool utilization.
5. Check circuit breaker states.
6. Investigate thread pool exhaustion.
7. Check database availability.
8. Review recent deployments.
9. Examine distributed traces.
10. Check infrastructure and network events.

**Useful commands:**

bash

```
kubectl get pods
kubectl get services
kubectl describe pod <pod-name>
kubectl logs <pod-name> --previous
```

### Possible Root Causes

- All application replicas are unhealthy.
- Readiness probes are failing.
- Database connection pool is exhausted.
- Downstream dependencies are unavailable.
- API Gateway cannot reach backend instances.
- Thread pools are saturated.
- Network policies prevent communication.

**Senior-level answer:** Identify whether the failure is caused by the application, infrastructure, or a dependency before applying a mitigation.

## Q36. Database connections are exhausted. What would you do?

### Scenario

Your application logs show:

text

```
HikariPool - Connection is not available,
request timed out after 30000ms
```

### Solution

Investigate:

- Connection pool size.
- Long-running SQL queries.
- Transactions that remain open.
- Missing indexes.
- Connection leaks.
- Excessive concurrent requests.
- Database maximum connection settings.

**Example configuration:**

yaml

```
spring:
  datasource:
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
```

The correct pool size depends on database capacity, application replica count, query workload, and concurrency.

### Important

If Kubernetes runs 10 replicas, each with a maximum pool size of 20, the application may attempt to use up to 200 database connections.

Increasing pool size blindly can make database overload worse.

## Q37. Kafka messages are published successfully, but consumers are not receiving them. What could be wrong?

### Possible Causes

- Incorrect topic name.
- Consumer subscribed to the wrong topic.
- Consumer group configuration problems.
- Deserialization errors.
- Authentication or authorization failures.
- Incorrect bootstrap server configuration.
- Consumer group rebalancing.
- Offset management problems.
- Topic partition or retention configuration.

### Debugging Commands

bash

```
kafka-topics.sh \
  --bootstrap-server localhost:9092 \
  --list
```

**Describe topic:**

bash

```
kafka-topics.sh \
  --bootstrap-server localhost:9092 \
  --describe \
  --topic orders
```

**Check consumer groups:**

bash

```
kafka-consumer-groups.sh \
  --bootstrap-server localhost:9092 \
  --describe \
  --group order-consumer-group
```

### Senior-Level Consideration

Differentiate between messages not being produced, messages being produced to the wrong topic, and messages being consumed but failing during processing.

## Q38. Your service is experiencing high CPU utilization. How do you debug it?

### Solution

Investigate:

- CPU utilization per pod.
- Thread count.
- Excessive garbage collection.
- Infinite loops.
- High request volume.
- Expensive serialization.
- Inefficient database processing.
- Regular expression performance.
- Lock contention.

**Useful commands:**

bash

```
top -H -p <pid>
jcmd <pid> Thread.print
jcmd <pid> JFR.start
```

Use Java Flight Recorder to identify expensive methods and CPU hotspots.

Do not assume high CPU is caused by insufficient Kubernetes CPU limits.

## Q39. A service is responding slowly even though CPU utilization is low. Why?

### Possible Reasons

- Database connection pool exhaustion.
- Network latency.
- Downstream API delays.
- Thread pool starvation.
- Lock contention.
- DNS resolution problems.
- Slow disk I/O.
- Excessive garbage collection pauses.
- Connection pool waiting.

### Solution

Use distributed tracing and thread dumps to determine where requests are spending time.

A low CPU metric does not necessarily mean that an application is healthy.

## Q40. How would you investigate a memory leak in production without restarting the service?

### Solution

Start with non-invasive diagnostics.

bash

```
jcmd <pid> GC.heap_info
jcmd <pid> Thread.print
jcmd <pid> GC.class_histogram
```

Then:

1. Examine memory trends.
2. Check heap occupancy after garbage collection.
3. Identify classes with growing object counts.
4. Review cache sizes.
5. Inspect thread-local variables.
6. Examine direct memory and native allocations.
7. Capture a heap dump when operationally safe.
8. Compare heap dumps to identify retained objects.

Use Java Flight Recorder and Java Mission Control for additional evidence.

**Interview answer:** A memory leak is usually demonstrated by objects remaining reachable when they should have been released, not simply by high memory usage.

---

# 13\. Advanced System Design Questions

## Q41. Design an e-commerce microservices architecture.

### Requirements

- User registration and authentication.
- Product catalog.
- Shopping cart.
- Order processing.
- Inventory management.
- Payment processing.
- Notifications.
- Order tracking.

### Proposed Architecture

text

```
                     Web / Mobile Clients
                              |
                              v
                         API Gateway
                              |
          +-------------------+-------------------+
          |                   |                   |
          v                   v                   v
     User Service       Product Service       Cart Service
          |                   |                   |
       Database             Database            Redis
                              |
                              v
                         Order Service
                              |
                   +----------+----------+
                   |                     |
                   v                     v
             Inventory Service     Payment Service
                   |                     |
                Database              Database
                   |                     |
                   +----------+----------+
                              |
                              v
                            Kafka
                              |
                 +------------+------------+
                 |            |            |
                 v            v            v
          Notification     Analytics   Shipping
             Service        Service     Service
```

### Important Design Decisions

**1\. Data ownership**

Each service owns its business data.

**2\. Communication**

- REST for immediate queries.
- Kafka for asynchronous business events.

**3\. Order processing**

Use a saga for inventory reservation, payment, and order confirmation.

**4\. Caching**

Use Redis for appropriate high-read workloads such as product information and shopping carts.

**5\. Reliability**

Use timeouts, circuit breakers, retries, idempotency, and bulkheads.

**6\. Observability**

Use centralized logging, metrics, and distributed tracing.

**7\. Security**

Use OAuth 2.0/OIDC, JWT validation, service identities, and resource-level authorization.

**8\. Deployment**

Deploy services as independently managed Kubernetes workloads.

## Q42. Design a highly scalable notification service.

### Requirements

- Send email, SMS, and push notifications.
- Handle millions of notification requests.
- Retry temporary failures.
- Avoid duplicate notifications.
- Track delivery status.

### Architecture

text

```
Order Service
     |
     v
    Kafka
     |
     v
Notification Service
     |
     +----------------+
     |        |       |
     v        v       v
   Email     SMS    Push
  Provider Provider Provider
```

### Solution

- Publish notification requests to Kafka.
- Partition messages using an appropriate key.
- Use multiple consumer instances.
- Implement provider-specific adapters.
- Track delivery attempts.
- Use idempotency keys.
- Apply exponential backoff.
- Route exhausted failures to dead-letter topics.
- Monitor delivery success rate and lag.

**Important Consideration:** Do not block the Order Service while waiting for an email or SMS provider to respond.

## Q43. Design a URL shortening system using Spring Boot microservices.

### Functional Requirements

- Generate short URLs.
- Redirect users.
- Support expiration.
- Track clicks.
- Provide basic analytics.

### Architecture

text

```
Client
  |
  v
API Gateway
  |
  v
URL Service
  |
  +----------+
  |          |
  v          v
PostgreSQL  Redis
  |
  v
Kafka
  |
  v
Analytics Service
```

### Design Decisions

**Short code generation**

Use a unique ID and encode it using Base62, or use another collision-safe generation strategy.

**Storage**

Store short code and original URL in PostgreSQL.

**Caching**

Cache frequently accessed short codes in Redis.

**Analytics**

Publish click events asynchronously to Kafka.

**Scaling**

Scale redirect instances independently from analytics processing.

**Security**

Validate submitted URLs and protect against malicious redirects.

## Q44. How would you design an inventory system that supports high concurrency?

### Solution

Use:

- Atomic database updates.
- Optimistic locking where suitable.
- Pessimistic locking for selected critical workflows.
- Inventory reservations with expiration.
- Idempotent reservation commands.
- Saga-based order processing.
- Reconciliation jobs.

**Example reservation table:**

sql

```
CREATE TABLE inventory_reservation (
    id UUID PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    status VARCHAR(30) NOT NULL,
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Important Design Decision

A reservation is not necessarily a completed sale.

If payment fails or the reservation expires, the system must release the reserved inventory safely.

## Q45. How would you implement rate limiting in Spring Cloud Gateway?

### Scenario

An external client sends 10,000 requests per second and overloads your services.

### Solution

Use gateway-level rate limiting, backed by Redis when distributed rate-limit state is required.

**Example configuration:**

yaml

```
spring:
  cloud:
    gateway:
      routes:
        - id: product-route
          uri: http://product-service
          predicates:
            - Path=/api/products/**
          filters:
            - name: RequestRateLimiter
              args:
                redis-rate-limiter.replenishRate: 10
                redis-rate-limiter.burstCapacity: 20
```

A key resolver must also be configured to identify the client, such as by authenticated user or API key.

### Production Considerations

- Apply different limits to different clients.
- Use a trusted identity rather than an arbitrary forwarded header.
- Return HTTP 429 when appropriate.
- Monitor rejected requests.
- Protect internal services as well as the public gateway.

## Q46. What is CQRS, and when would you use it?

CQRS stands for Command Query Responsibility Segregation.

It separates write operations from read operations.

### Traditional Approach

text

```
Client
  |
  v
Single Service
  |
  v
Single Database
```

### CQRS Approach

text

```
               Client
                  |
                  v
             API Layer
              /     \
             v       v
       Command Side  Query Side
             |       |
             v       v
        Write DB   Read Model
             |
             v
           Events
             |
             v
        Projection
```

### When to Use It

- Read and write workloads have significantly different requirements.
- Read models need different structures from write models.
- Complex queries are difficult to support efficiently.
- Event-driven projections are appropriate.

### Disadvantages

- More architectural complexity.
- Eventual consistency.
- More operational components.
- Projection rebuilding and reconciliation requirements.

Do not introduce CQRS into every CRUD application.

## Q47. What is eventual consistency?

Eventual consistency means that different parts of a distributed system may temporarily have different views of data, but they are expected to converge if updates stop and processing succeeds.

### Example

1. Customer places an order.
2. Order Service publishes `OrderCreated`.
3. Notification Service receives the event.
4. Analytics Service updates its projection.
5. Both services eventually reflect the new order.

### Interview Question

What if the user immediately checks analytics after placing the order?

**Answer:**

"I would define the consistency requirements explicitly. If immediate confirmation is required, I would return the authoritative order result from the Order Service. Analytics can remain eventually consistent."

## Q48. How would you handle database schema changes across multiple microservices?

### Solution

Use backward-compatible database migrations.

### Recommended Practices

- Use Flyway or Liquibase.
- Version database migrations.
- Avoid destructive changes during the first deployment.
- Support old and new application versions during rollout.
- Use expand-and-contract migrations.
- Test migrations against production-like datasets.
- Have a backup and recovery strategy.

**Example Flyway migration:**

sql

```
ALTER TABLE orders
ADD COLUMN order_reference VARCHAR(100);
```

Do not make application deployment depend on all services upgrading simultaneously.

---

# 14\. Senior-Level Interview Questions

## Q49. How do you decide between a monolith, modular monolith, and microservices?

| Factor | Monolith | Modular Monolith | Microservices |
| --- | --- | --- | --- |
| Deployment | Single unit | Single unit | Independent services |
| Complexity | Lower initially | Moderate | Higher |
| Scaling | Whole application | Whole application | Per service |
| Data management | Shared | Explicit module boundaries | Service ownership |
| Team organization | Small teams | Multiple collaborating teams | Autonomous teams |
| Operations | Simpler | Moderate | More demanding |

### Senior-Level Answer

"I would choose the architecture based on business requirements, team structure, deployment frequency, scaling needs, and operational maturity. I would avoid microservices when the organization cannot support distributed observability, automation, and independent ownership."

## Q50. How do you manage backward compatibility in event-driven systems?

### Solution

Use schema evolution.

- Add optional fields rather than removing existing fields.
- Avoid changing field meanings.
- Version event schemas where necessary.
- Use schema registries when appropriate.
- Test producers and consumers together through contract testing.
- Support older consumers during migration.

**Example**

Old event:

json

```
{
  "orderId": 1001,
  "amount": 500
}
```

New event:

json

```
{
  "orderId": 1001,
  "amount": 500,
  "currency": "INR"
}
```

Adding an optional field is generally safer than changing an existing field's type.

## Q51. How would you handle a distributed system outage?

### Senior-Level Answer

I would follow a structured incident-management process.

1. Establish incident severity and customer impact.
2. Identify affected services and dependencies.
3. Stop further damage through containment.
4. Check recent deployments and configuration changes.
5. Examine metrics, logs, and traces.
6. Restore critical functionality.
7. Validate data consistency.
8. Communicate status to stakeholders.
9. Perform root-cause analysis.
10. Implement preventive actions.

**Important:** Restoring service availability and correcting data inconsistency are separate responsibilities. Both must be addressed.

## Q52. How do you handle a distributed deadlock?

A distributed deadlock can occur when services or workflows wait on each other in a dependency cycle.

**Example:**

text

```
Order Service
     |
     v
Payment Service
     |
     v
Inventory Service
     |
     v
Order Service
```

### Prevention

- Avoid circular synchronous dependencies.
- Define clear ownership boundaries.
- Use asynchronous communication where appropriate.
- Establish request deadlines.
- Avoid holding database locks while calling remote services.
- Monitor long-running workflows.

A dependency graph can help identify circular dependencies before they reach production.

## Q53. How do you improve the performance of a Spring Boot application under heavy traffic?

### Solution

Investigate and optimize systematically.

**Application layer**

- Reduce unnecessary object creation.
- Optimize serialization.
- Use efficient data structures.
- Avoid blocking operations on inappropriate thread pools.

**Database layer**

- Add appropriate indexes.
- Optimize query plans.
- Use pagination.
- Avoid N+1 queries.
- Tune connection pools.

**Caching layer**

- Cache frequently accessed data.
- Use suitable TTLs.
- Prevent cache stampedes.

**Infrastructure**

- Scale horizontally.
- Configure Kubernetes resource requests and limits.
- Use load balancing.
- Monitor CPU and memory.

**Architecture**

- Reduce synchronous dependencies.
- Use asynchronous processing for suitable workloads.
- Apply bulkheads and rate limiting.

## Q54. What is the difference between horizontal and vertical scaling?

| Horizontal Scaling | Vertical Scaling |
| --- | --- |
| Add more application instances | Increase CPU and RAM |
| Improves distributed capacity | Improves capacity of one machine |
| Requires load balancing | Usually simpler initially |
| Requires stateless or shared state management | Has hardware limits |
| Supports resilient deployments when designed correctly | Can preserve existing architecture |

**Example:**

text

```
Horizontal:
2 Pods -> 5 Pods -> 10 Pods

Vertical:
2 CPU / 4 GB -> 4 CPU / 8 GB
```

For stateless Spring Boot services, horizontal scaling is often preferred.

## Q55. What is the difference between Kubernetes Service, Deployment, and Ingress?

| Resource | Responsibility |
| --- | --- |
| Deployment | Manages application replicas and rollout |
| Service | Provides stable networking and access to selected pods |
| Ingress | Defines HTTP/HTTPS routing from outside the cluster through an ingress controller |

### Example Deployment

yaml

```
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
          ports:
            - containerPort: 8080
```

### Example Service

yaml

```
apiVersion: v1
kind: Service
metadata:
  name: order-service
spec:
  selector:
    app: order-service
  ports:
    - port: 8080
      targetPort: 8080
  type: ClusterIP
```

## Q56. What is the difference between OAuth 2.0 and OpenID Connect?

OAuth 2.0 is an authorization framework.

It enables applications to obtain limited access to protected resources.

OpenID Connect (OIDC) is an identity layer built on OAuth 2.0.

It provides authentication and identity information, commonly through an ID token.

### Common Interview Trap

A JWT is a token format. OAuth 2.0 and OIDC are protocols/frameworks. They are not interchangeable terms.

## Q57. How do you ensure that one microservice cannot overload another?

### Solution

Use multiple protective mechanisms:

- Rate limiting.
- Bulkheads.
- Connection pool limits.
- Request timeouts.
- Circuit breakers.
- Bounded queues.
- Backpressure.
- Consumer concurrency controls.
- Kubernetes resource limits.

The objective is to prevent one overloaded component from causing cascading failures throughout the system.

## Q58. What is the difference between orchestration and choreography in microservices?

| Orchestration | Choreography |
| --- | --- |
| Central coordinator controls workflow | Services react to events |
| Workflow is explicitly defined | Workflow emerges from event interactions |
| Easier centralized visibility | More distributed visibility |
| Coordinator can become a complexity point | Event dependencies can become difficult to understand |

### Orchestration Example

text

```
Order Orchestrator
       |
       +---- Reserve Inventory
       |
       +---- Process Payment
       |
       +---- Confirm Order
```

### Choreography Example

text

```
OrderCreated
     |
     v
Inventory Service
     |
     v
InventoryReserved
     |
     v
Payment Service
     |
     v
PaymentCompleted
```

Choose based on workflow complexity, ownership, observability, and recovery requirements.

---

# 15\. Common Interview Traps

These are common questions where technically correct but incomplete answers can hurt an interview.

| Interview Question | Common Wrong Answer | Better Answer |
| --- | --- | --- |
| Are microservices always better? | Yes | Depends on business and operational needs |
| Does Kafka guarantee exactly-once business execution? | Yes | Processing guarantees require careful design |
| Does JWT provide authorization automatically? | Yes | Authentication and authorization are different |
| Should every service have its own database server? | Yes | Each service needs clear data ownership; physical infrastructure can be shared |
| Should all failures be retried? | Yes | Retry only eligible failures |
| Does a circuit breaker replace timeouts? | Yes | They solve different problems |
| Does Kubernetes restart every unhealthy application? | Yes | Liveness and readiness have different responsibilities |
| Does Redis guarantee database consistency? | Yes | Cache consistency needs explicit design |
| Does an API Gateway eliminate the need for security inside services? | Yes | Resource services must enforce authorization |
| Does adding more Kafka consumers always increase throughput? | Yes | Partition count and processing bottlenecks matter |
| Does a rolling deployment guarantee zero downtime? | Yes | Compatibility, readiness, and graceful shutdown matter |
| Is a timeout proof that a remote operation failed? | Yes | The operation may have succeeded without a response |

---

# 16\. Quick Revision Cheat Sheet

## Spring Boot

| Concept | Key Point |
| --- | --- |
| Dependency Injection | IoC container manages dependencies |
| `@Component` | Generic Spring-managed component |
| `@Service` | Service-layer component |
| `@Repository` | Persistence-layer component |
| `@RestController` | REST controller |
| `@Configuration` | Java-based configuration |
| `@Bean` | Registers a bean |
| `@Transactional` | Defines transaction boundaries |
| `@ControllerAdvice` | Centralized exception handling |
| Actuator | Application health and metrics |

## Microservices

| Concept | Key Point |
| --- | --- |
| API Gateway | Central routing and cross-cutting policies |
| Service Discovery | Identifies service instances |
| Load Balancing | Distributes traffic |
| Circuit Breaker | Prevents repeated calls to failing dependencies |
| Bulkhead | Isolates resource usage |
| Saga | Manages distributed workflows |
| Outbox | Addresses the database/event dual-write problem |
| CQRS | Separates command and query responsibilities |
| Eventual Consistency | Data converges asynchronously |
| Idempotency | Repeated requests do not repeat business effects |

## Kafka

| Concept | Key Point |
| --- | --- |
| Producer | Publishes records |
| Consumer | Reads records |
| Topic | Logical event stream |
| Partition | Unit of ordering and parallelism |
| Offset | Position in a partition |
| Consumer Group | Coordinates consumer processing |
| Consumer Lag | Difference between produced and consumed positions |
| Dead-Letter Topic | Stores messages that exhaust failure handling |
| Retention | Controls how long records are stored |
| Replication | Improves availability and durability |

## Database

| Concept | Key Point |
| --- | --- |
| Index | Improves suitable lookup operations |
| Composite Index | Supports queries using multiple columns |
| Optimistic Locking | Detects conflicting updates |
| Pessimistic Locking | Acquires locks before modification |
| Connection Pool | Reuses database connections |
| N+1 Problem | Excessive queries caused by relationship loading |
| Pagination | Retrieves data in bounded portions |
| Keyset Pagination | Uses ordered key values to continue through records |
| ACID | Atomicity, Consistency, Isolation, Durability |
| Flyway | Database migration tool |

## Redis

| Concept | Key Point |
| --- | --- |
| Cache-Aside | Application loads cache on demand |
| TTL | Time to live |
| Cache Invalidation | Removing or updating stale entries |
| Cache Stampede | Many requests regenerate the same missing entry |
| Distributed Lock | Coordinates access across processes |
| Pub/Sub | Message distribution without durable queue semantics |

## Kubernetes

| Concept | Key Point |
| --- | --- |
| Pod | Smallest deployable workload unit |
| Deployment | Manages replicas and rollouts |
| Service | Stable networking |
| Ingress | External HTTP/HTTPS routing |
| ConfigMap | Non-sensitive configuration |
| Secret | Sensitive configuration data |
| Readiness Probe | Controls traffic eligibility |
| Liveness Probe | Controls restart decisions |
| Startup Probe | Allows time for application startup |
| HPA | Horizontal Pod Autoscaler |

---

# 17\. Advanced Spring Boot and Spring Cloud Questions

## Q59. What is the difference between Spring Cloud Config Server and Kubernetes ConfigMap?

| Spring Cloud Config | Kubernetes ConfigMap |
| --- | --- |
| Centralized external configuration | Kubernetes-native configuration |
| Supports Git-backed configuration | Stores cluster configuration |
| Supports configuration management across environments | Supports pod configuration |
| Can integrate with refresh mechanisms | Changes require suitable application reload or restart behavior |

### Interview Answer

"Spring Cloud Config is useful when multiple applications need centralized configuration management. Kubernetes ConfigMaps are useful for environment-specific configuration within Kubernetes. The choice depends on deployment architecture and operational requirements."

## Q60. What is the difference between Feign Client, RestClient, and WebClient?

| Client | Use Case |
| --- | --- |
| OpenFeign | Declarative HTTP clients |
| RestClient | Synchronous HTTP communication |
| WebClient | Non-blocking reactive HTTP communication |

### OpenFeign Example

java

```
@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    ProductDto getProduct(@PathVariable Long id);
}
```

### RestClient Example

java

```
@Service
public class ProductClient {

    private final RestClient client;

    public ProductClient(RestClient.Builder builder) {
        this.client = builder
                .baseUrl("http://product-service")
                .build();
    }

    public ProductDto getProduct(Long id) {
        return client.get()
                .uri("/api/products/{id}", id)
                .retrieve()
                .body(ProductDto.class);
    }
}
```

### Interview Trap

WebClient is not automatically faster for every application. Its non-blocking model is particularly useful when the application is designed to use reactive processing end to end.

## Q61. What is the difference between `@Async` and `CompletableFuture`?

`@Async` allows Spring-managed methods to execute asynchronously through a configured executor.

`CompletableFuture` provides an API for composing asynchronous operations.

Both require appropriate executor configuration.

Exceptions must be handled explicitly, and asynchronous execution does not automatically propagate the caller's transaction context.

---
You're right. The previous Markdown document stopped midway through Q61.

Here is the continuation, starting from Q61, with additional Intermediate, Advanced, and Senior-level Spring Boot Microservices interview questions.

Writing

## Q61. What is the difference between `@Async` and `CompletableFuture`?

`@Async` allows Spring-managed methods to execute asynchronously through a configured executor.

`CompletableFuture` provides an API for composing asynchronous operations.

### Comparison

| Feature | `@Async` | `CompletableFuture` |
| --- | --- | --- |
| Purpose | Asynchronous method execution | Asynchronous task composition |
| Configuration | Spring executor | Executor or common pool |
| Result handling | Can return `Future` or `CompletableFuture` | Supports rich composition |
| Exception handling | `AsyncUncaughtExceptionHandler` for void methods | `exceptionally()`, `handle()` |
| Chaining | Limited directly | Supports chaining and combining |
| Spring integration | Built into Spring | Java standard library |

### @Async Example

java

```
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor =
                new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("async-");

        executor.initialize();
        return executor;
    }
}
```

Service:

java

```
@Service
public class EmailService {

    @Async
    public CompletableFuture<String> sendEmail() {

        // Simulate email processing

        return CompletableFuture.completedFuture(
                "Email sent successfully"
        );
    }
}
```

### CompletableFuture Example

java

```
CompletableFuture<String> future =
        CompletableFuture.supplyAsync(
                () -> "Order processed",
                executor
        );

future.thenApply(String::toUpperCase)
      .thenAccept(System.out::println)
      .exceptionally(ex -> {
          System.err.println(ex.getMessage());
          return null;
      });
```

### Important Considerations

- Configure bounded thread pools.
- Handle exceptions explicitly.
- Avoid blocking operations on inappropriate executors.
- Remember that Spring `@Async` uses proxy-based interception by default, so self-invocation does not trigger asynchronous execution.
- Do not assume transactions automatically propagate to asynchronous threads.

---

## Q62. What is the difference between `@Transactional` and distributed transactions?

`@Transactional` manages transaction boundaries within a transaction manager, typically for a single database resource.

Distributed transactions coordinate changes across multiple transactional resources.

### Local Transaction Example

java

```
@Service
public class OrderService {

    @Transactional
    public void createOrder() {

        orderRepository.save(new Order());

        paymentRepository.save(new Payment());
    }
}
```

Both operations can participate in the same transaction when they use the same transactional resource and transaction manager.

### Distributed Transaction Approaches

- Two-Phase Commit (2PC).
- Saga pattern.
- Transactional Outbox pattern.
- Event-driven eventual consistency.

### Comparison

| Local Transaction | Distributed Transaction |
| --- | --- |
| Usually one transactional resource | Multiple resources or services |
| Simpler transaction management | More complex coordination |
| ACID within transaction boundaries | Depends on coordination strategy |
| Usually lower operational complexity | Higher operational complexity |

### Interview Answer

"In microservices, I generally prefer Saga and Outbox patterns over tightly coupled distributed database transactions. They improve service autonomy and allow independent failure handling."

---

## Q63. What is the Transactional Outbox Pattern?

The Transactional Outbox Pattern solves the dual-write problem.

### Scenario

An Order Service must:

1. Save an order in PostgreSQL.
2. Publish an `OrderCreated` event to Kafka.

If the database transaction succeeds but Kafka publishing fails, the system becomes inconsistent.

### Solution

Save the business record and event in the same database transaction.

### Database Table

sql

```
CREATE TABLE outbox_event (
    id UUID PRIMARY KEY,
    aggregate_type VARCHAR(100),
    aggregate_id VARCHAR(100),
    event_type VARCHAR(100),
    payload JSONB,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    published_at TIMESTAMP
);
```

### Java Example

java

```
@Transactional
public void createOrder(Order order) {

    orderRepository.save(order);

    OutboxEvent event = new OutboxEvent();

    event.setId(UUID.randomUUID());
    event.setAggregateType("Order");
    event.setAggregateId(order.getId().toString());
    event.setEventType("OrderCreated");

    outboxRepository.save(event);
}
```

A separate publisher or CDC mechanism reads unpublished events and publishes them to Kafka.

### Advantages

- Prevents database/event dual-write inconsistency.
- Supports reliable event publication.
- Keeps business updates and event creation atomic.

### Important Considerations

- Published events may be delivered more than once.
- Consumers must be idempotent.
- Failed events need retry handling.
- Outbox records need cleanup or archival.
- Event ordering must be considered.

---

## Q64. What is the difference between Kafka and RabbitMQ?

| Feature | Kafka | RabbitMQ |
| --- | --- | --- |
| Architecture | Distributed event streaming platform | Message broker |
| Message storage | Retained records | Queue-based delivery |
| Consumption | Consumers track offsets | Messages are acknowledged |
| Replay | Supported through offsets | Not the primary consumption model |
| Throughput | Designed for high-throughput streaming | Suitable for flexible messaging workloads |
| Ordering | Within a partition | Queue-level ordering with caveats |
| Use cases | Event streaming, analytics, event-driven systems | Task queues, routing, RPC-style messaging |

### Kafka Use Cases

- Event streaming.
- Audit logs.
- Analytics.
- Event-driven microservices.
- Data integration.

### RabbitMQ Use Cases

- Background jobs.
- Task distribution.
- Complex message routing.
- Request/reply messaging.

### Interview Answer

"I would choose Kafka when event retention, replay, and high-throughput streaming are important. I would choose RabbitMQ when flexible routing and traditional message queue behavior are the primary requirements."

---

## Q65. What is the difference between Kafka delivery semantics?

Kafka supports different message delivery and processing approaches.

### 1\. At-Most-Once

Messages may be lost, but are not intentionally redelivered.

### 2\. At-Least-Once

Messages are delivered one or more times.

Duplicates are possible.

### 3\. Exactly-Once Semantics

Kafka supports transactional processing for specific Kafka read-process-write workflows.

However, exactly-once business effects involving external databases or payment systems require additional coordination and idempotency.

### Comparison

| Guarantee | Possible Result |
| --- | --- |
| At-most-once | Message may be lost |
| At-least-once | Duplicate processing possible |
| Exactly-once | Supported within configured transactional Kafka workflows |

### Interview Trap

Kafka exactly-once semantics do not automatically guarantee exactly-once execution across an entire microservices architecture.

---

## Q66. How do you implement idempotency in a Spring Boot REST API?

Idempotency ensures that repeating the same request does not repeat the business operation.

### Scenario

A customer clicks the payment button twice because the first request times out.

Without idempotency, two payments might be processed.

### Solution

Use an idempotency key.

### Database Table

sql

```
CREATE TABLE idempotency_record (
    id BIGSERIAL PRIMARY KEY,
    idempotency_key VARCHAR(100) UNIQUE NOT NULL,
    response JSONB,
    status VARCHAR(30),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### API Example

http

```
POST /api/payments
Idempotency-Key: payment-12345
```

### Java Concept

java

```
@Transactional
public PaymentResponse processPayment(
        String idempotencyKey,
        PaymentRequest request) {

    return idempotencyRepository
            .findByIdempotencyKey(idempotencyKey)
            .map(this::getStoredResponse)
            .orElseGet(() -> {

                PaymentResponse response =
                        paymentProcessor.process(request);

                saveIdempotencyResult(
                        idempotencyKey,
                        response
                );

                return response;
            });
}
```

### Production Considerations

- Enforce a unique constraint on the idempotency key.
- Handle concurrent requests using database locking or atomic insertion.
- Validate that a reused key has the same request parameters.
- Store the final result.
- Define an expiration and cleanup policy.
- Consider payment provider idempotency support.

---

## Q67. What is the difference between authentication and authorization in Spring Security?

**Authentication** verifies who the user is.

**Authorization** determines what the authenticated user can access.

### Example

A user successfully logs in.

Authentication succeeds.

However, the user attempts to access an administrator API.

Authorization checks whether the user has the required permission.

### Spring Security Example

java

```
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
}
```

java

```
@RestController
public class AdminController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/admin/users")
    public List<String> getUsers() {
        return List.of("User1", "User2");
    }
}
```

### Comparison

| Authentication | Authorization |
| --- | --- |
| Verifies identity | Checks permissions |
| Login and token validation | Role and permission checks |
| Who are you? | What can you access? |
| Happens before protected access decisions | Applies access policies |

---

## Q68. How do you secure communication between microservices?

### Solution

Use multiple security mechanisms.

- OAuth 2.0 client credentials flow.
- JWT validation.
- Mutual TLS (mTLS).
- Service identities.
- Network policies.
- Least-privilege access.
- Secret management.
- TLS encryption.

### Example Architecture

text

```
Order Service
     |
     | OAuth2 Access Token
     | TLS / mTLS
     v
Payment Service
     |
     v
Validate Token
     |
     v
Check Permissions
     |
     v
Process Request
```

### Important Considerations

- Validate token signatures.
- Validate issuer and audience.
- Check token expiration.
- Use short-lived credentials where appropriate.
- Rotate secrets and certificates.
- Do not trust internal network location alone.

---

## Q69. What is the difference between Liveness, Readiness, and Startup Probes in Kubernetes?

| Probe | Responsibility |
| --- | --- |
| Liveness | Determines whether a container should be restarted |
| Readiness | Determines whether a pod should receive traffic |
| Startup | Determines whether the application has completed startup |

### Example

yaml

```
livenessProbe:
  httpGet:
    path: /actuator/health/liveness
    port: 8080
  initialDelaySeconds: 30
  periodSeconds: 10

readinessProbe:
  httpGet:
    path: /actuator/health/readiness
    port: 8080
  periodSeconds: 5

startupProbe:
  httpGet:
    path: /actuator/health
    port: 8080
  failureThreshold: 30
  periodSeconds: 10
```

### Interview Trap

Readiness failure does not necessarily restart a container.

Liveness failure can cause Kubernetes to restart it.

---

## Q70. What is graceful shutdown in Spring Boot?

Graceful shutdown allows an application to stop accepting new requests while completing requests that are already in progress.

### Configuration

yaml

```
server:
  shutdown: graceful

spring:
  lifecycle:
    timeout-per-shutdown-phase: 30s
```

### Why Is It Important?

During Kubernetes rolling deployments:

1. Kubernetes terminates an old pod.
2. The application stops accepting new requests.
3. Existing requests are allowed to complete within the configured timeout.
4. The application shuts down.

### Production Considerations

- Configure readiness and termination behavior.
- Handle SIGTERM correctly.
- Stop accepting new work.
- Allow Kafka consumers to stop gracefully.
- Commit or safely reprocess unfinished messages.
- Set appropriate termination grace periods.

---

## Q71. What is the difference between Resilience4j Retry and Circuit Breaker?

| Retry | Circuit Breaker |
| --- | --- |
| Repeats eligible failed operations | Stops calls to failing dependencies |
| Handles temporary failures | Protects against repeated failures |
| Can increase downstream traffic | Reduces traffic during failures |
| Uses retry policies | Uses state transitions |

### Retry Example

java

```
@Retry(name = "paymentService")
public PaymentResponse makePayment() {
    return paymentClient.pay();
}
```

### Circuit Breaker Example

java

```
@CircuitBreaker(
    name = "paymentService",
    fallbackMethod = "paymentFallback"
)
public PaymentResponse makePayment() {
    return paymentClient.pay();
}

public PaymentResponse paymentFallback(
        Exception ex) {

    return new PaymentResponse(
            "PAYMENT_PENDING"
    );
}
```

### Best Practices

- Configure timeouts before retries.
- Use exponential backoff.
- Add jitter.
- Retry only transient failures.
- Avoid retrying non-idempotent operations without protection.
- Configure circuit breaker thresholds based on workload.

---

## Q72. What is the difference between Micrometer and OpenTelemetry?

| Micrometer | OpenTelemetry |
| --- | --- |
| Application metrics and instrumentation facade | Observability instrumentation framework |
| Integrates with Spring Boot Actuator | Supports traces, metrics, and logs |
| Commonly used for metrics collection | Supports vendor-neutral telemetry |
| Integrates with Prometheus and other monitoring systems | Integrates with multiple telemetry backends |

### Example

Spring Boot Actuator dependency:

xml

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

### Production Observability

Monitor:

- Request rate.
- Error rate.
- Response latency.
- JVM memory.
- Garbage collection.
- Database connection pools.
- Kafka consumer lag.
- Distributed traces.

---

## Q73. What is the difference between logs, metrics, and distributed traces?

| Type | Purpose | Example |
| --- | --- | --- |
| Logs | Detailed event records | Payment processing failed |
| Metrics | Numerical measurements over time | HTTP 500 error rate |
| Traces | Follow requests across services | Order → Payment → Inventory |

### Example

text

```
Client Request
     |
     v
API Gateway
     |
     v
Order Service
     |
     v
Payment Service
     |
     v
Inventory Service
```

A distributed trace helps identify which service contributes most to the total request latency.

### Interview Answer

"Logs explain what happened, metrics indicate how frequently or severely something is happening, and traces show where time is spent across distributed service calls."

---

## Q74. What is the difference between API Gateway and Load Balancer?

| API Gateway | Load Balancer |
| --- | --- |
| Routes API requests | Distributes traffic |
| Can perform authentication | Can distribute connections |
| Can enforce rate limits | Can perform health-based routing |
| Can transform requests and responses | Usually focuses on traffic distribution |
| Provides API-level policies | Provides traffic-level distribution |

They can be used together.

---

## Q75. What is the difference between Stateful and Stateless microservices?

### Stateless Service

Does not depend on local application memory to maintain user session state between requests.

Example:

An Order Service stores order information in PostgreSQL.

### Stateful Service

Maintains state that influences subsequent requests or processing.

Example:

A Kafka consumer maintains offsets.

### Comparison

| Stateless | Stateful |
| --- | --- |
| Easier horizontal scaling | Requires state coordination |
| Requests can reach different instances | May require partition or ownership management |
| Session data stored externally | State may be maintained internally or externally |
| Easier recovery | Recovery requires state restoration |

For horizontally scalable Spring Boot REST services, stateless application instances are generally preferred.

---

## Q76. What is the Strangler Fig Pattern?

The Strangler Fig Pattern is a migration strategy for gradually replacing a legacy monolithic application with new services.

### Architecture

text

```
              Client
                 |
                 v
             API Gateway
                 |
          +------+------+
          |             |
          v             v
     Legacy System   New Services
          |             |
          v             v
       Old DB       New Databases
```

### Implementation Steps

1. Identify a business capability in the monolith.
2. Extract that functionality into a new service.
3. Route the corresponding requests to the new service.
4. Migrate data and integrations.
5. Monitor behavior.
6. Gradually retire the legacy implementation.

### Advantages

- Reduces migration risk.
- Allows incremental modernization.
- Avoids rewriting the entire system at once.

---

## Q77. What is the difference between Database per Service and Shared Database in microservices?

| Database per Service | Shared Database |
| --- | --- |
| Each service owns its data | Multiple services access shared storage |
| Stronger service autonomy | Tighter coupling |
| Independent schema evolution | Coordinated schema changes |
| Requires distributed communication | Direct database access may be simpler |
| Supports independent deployment | Can restrict independent deployment |

### Senior-Level Answer

"Database per service is generally preferred for strong microservice boundaries. However, services do not necessarily require separate physical database servers. Separate schemas or databases on shared infrastructure can be acceptable when ownership and access boundaries are enforced."

---

## Q78. How would you migrate a monolithic Spring Boot application to microservices?

### Solution

Use an incremental migration strategy.

1. Analyze business capabilities.
2. Identify bounded contexts.
3. Identify highly coupled modules.
4. Define service ownership.
5. Extract one capability at a time.
6. Introduce API Gateway where appropriate.
7. Establish service-to-service communication.
8. Introduce event-driven integration where useful.
9. Implement observability and security.
10. Gradually remove legacy functionality.

### Important Considerations

- Avoid splitting services based only on technical layers.
- Avoid creating distributed monoliths.
- Preserve data consistency.
- Plan rollback strategies.
- Introduce automation and deployment pipelines.
- Measure operational complexity.

---

## Q79. What is the difference between a Saga and Two-Phase Commit?

| Saga | Two-Phase Commit |
| --- | --- |
| Uses local transactions and compensating actions | Coordinates participating transactions |
| Supports eventual consistency | Coordinates atomic commit |
| Better suited to loosely coupled services | Requires transaction coordination |
| Compensation may not perfectly reverse effects | Uses prepare and commit phases |
| Common in microservices | Can introduce availability and coupling concerns |

### Saga Example

text

```
Create Order
     |
     v
Reserve Inventory
     |
     v
Process Payment
     |
     +------ Success ------> Confirm Order
     |
     +------ Failure ------> Release Inventory
```

---

## Q80. How do you handle duplicate Kafka messages?

### Solution

Implement idempotent consumers.

### Example

Maintain a processed event table.

sql

```
CREATE TABLE processed_events (
    event_id UUID PRIMARY KEY,
    processed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

Consumer logic:

java

```
@Transactional
public void processEvent(OrderEvent event) {

    if (processedEventRepository
            .existsById(event.getEventId())) {
        return;
    }

    updateOrder(event);

    processedEventRepository.save(
            new ProcessedEvent(event.getEventId())
    );
}
```

The event record and business update must be committed atomically in the same transactional database.

### Important Considerations

- Use stable event IDs.
- Enforce uniqueness in the database.
- Handle concurrent deliveries.
- Commit offsets only after successful processing according to the chosen acknowledgment strategy.
- Implement dead-letter handling.

---

## Q81. How do you handle poison messages in Kafka?

A poison message is a message that repeatedly fails processing because of malformed data, invalid business conditions, or incompatible schemas.

### Solution

1. Identify the failure type.
2. Retry eligible transient failures.
3. Avoid repeatedly retrying permanent failures.
4. Send exhausted failures to a dead-letter topic.
5. Store the original message and error details.
6. Monitor dead-letter topic volume.
7. Correct and replay messages when appropriate.

### Example Configuration Concept

yaml

```
spring:
  kafka:
    consumer:
      enable-auto-commit: false
```

The exact acknowledgment and error-handling configuration should match the listener container and Spring Kafka version.

---

## Q82. What is backpressure in distributed systems?

Backpressure is a mechanism that prevents a producer from overwhelming a downstream consumer.

### Example

An Order Service publishes 100,000 events per second, but the Notification Service can process only 10,000 events per second.

Without flow control, consumer lag increases continuously.

### Solutions

- Limit producer throughput where appropriate.
- Control consumer concurrency.
- Use bounded queues.
- Apply rate limiting.
- Monitor Kafka lag.
- Scale consumers according to partition availability.
- Reject or defer work when capacity is exhausted.

---

## Q83. What is the difference between Redis Cache-Aside and Write-Through caching?

| Cache-Aside | Write-Through |
| --- | --- |
| Application checks cache first | Writes update cache as part of the write path |
| Cache miss loads from database | Cache is updated during writes |
| Simple to implement | Requires coordinated write behavior |
| May temporarily serve stale data | Can improve cache freshness |
| Application controls loading | Cache write is part of the update process |

### Cache-Aside Flow

text

```
Client
  |
  v
Application
  |
  v
Redis Cache
  |
  +---- Hit ----> Return Data
  |
  +---- Miss ---> Database
                     |
                     v
                 Update Cache
                     |
                     v
                 Return Data
```

---

## Q84. How do you handle configuration changes without restarting Spring Boot services?

### Solution

Depending on the deployment architecture, use:

- Spring Cloud Config.
- Kubernetes ConfigMaps.
- Configuration refresh mechanisms.
- Application-specific dynamic configuration.
- Feature flags.

### Important Considerations

- Not all Spring properties can safely be refreshed dynamically.
- Validate new configuration before applying it.
- Maintain a rollback strategy.
- Avoid exposing secrets in configuration endpoints.
- Ensure configuration changes are observable and auditable.

---

## Q85. What is the difference between Blue-Green and Canary Deployment?

| Blue-Green | Canary |
| --- | --- |
| Maintains two deployment environments | Gradually introduces a new version |
| Switches traffic between environments | Routes a percentage of traffic to the new version |
| Supports relatively quick rollback | Supports gradual risk evaluation |
| Requires capacity for both environments | Requires traffic splitting and monitoring |

### Blue-Green Example

text

```
             Load Balancer
                   |
            +------+------+
            |             |
            v             v
        Blue v1         Green v2
```

### Canary Example

text

```
             Load Balancer
                   |
          +--------+--------+
          |                 |
          v                 v
       v1 - 90%          v2 - 10%
```

---

## Q86. How do you prevent cascading failures in microservices?

### Solution

Use:

- Circuit breakers.
- Request timeouts.
- Retry with backoff and jitter.
- Bulkheads.
- Rate limiting.
- Bounded thread pools.
- Queue limits.
- Graceful degradation.
- Health monitoring.
- Dependency isolation.

### Example

If Payment Service becomes unavailable, Order Service should not continuously create unlimited requests to it.

Instead, it should use appropriate timeout, retry, circuit breaker, and business recovery policies.

---

## Q87. How would you design a payment processing system?

### Requirements

- Accept payment requests.
- Integrate with external payment gateways.
- Prevent duplicate charges.
- Track payment status.
- Handle gateway timeouts.
- Support refunds.
- Reconcile transactions.

### Proposed Architecture

text

```
             Client
                |
                v
           API Gateway
                |
                v
          Order Service
                |
                v
         Payment Service
                |
          +-----+-----+
          |           |
          v           v
      PostgreSQL   Payment Gateway
          |
          v
         Kafka
          |
          v
    Notification Service
```

### Important Design Decisions

1. Use idempotency keys.
2. Store payment state durably.
3. Handle unknown payment outcomes.
4. Use gateway callbacks or webhooks.
5. Validate webhook signatures.
6. Implement retry policies carefully.
7. Use reconciliation jobs.
8. Keep audit records.
9. Avoid logging sensitive payment information.
10. Use a Saga where payment participates in a larger workflow.

**Senior-Level Consideration:** A timeout from the payment gateway does not prove that the payment failed. The gateway may have processed the payment but failed to return a response.

---

## Q88. How do you handle API versioning in Spring Boot?

### Common Approaches

**1\. URI versioning**

http

```
GET /api/v1/orders
GET /api/v2/orders
```

**2\. Header versioning**

http

```
Accept: application/vnd.company.orders-v1+json
```

**3\. Query parameter versioning**

http

```
GET /api/orders?version=1
```

### Comparison

| Approach | Advantage |
| --- | --- |
| URI versioning | Easy to understand and test |
| Header versioning | Keeps URI stable |
| Query parameter versioning | Simple for certain use cases |

### Best Practices

- Maintain backward compatibility.
- Define a deprecation policy.
- Document changes.
- Monitor old API usage.
- Avoid creating unnecessary versions.

---

## Q89. How do you handle N+1 query problems in Spring Data JPA?

### Scenario

An application loads 100 orders and executes an additional query for each order to retrieve customer information.

This results in 101 database queries.

### Solutions

**1\. Fetch Join**

java

```
@Query("""
    SELECT o
    FROM Order o
    JOIN FETCH o.customer
    WHERE o.id = :id
    """)
Optional<Order> findOrderWithCustomer(Long id);
```

**2\. Entity Graph**

java

```
@EntityGraph(attributePaths = {"customer"})
List<Order> findByStatus(String status);
```

**3\. DTO Projection**

java

```
@Query("""
    SELECT new com.example.dto.OrderSummary(
        o.id,
        o.status,
        c.name
    )
    FROM Order o
    JOIN o.customer c
    """)
List<OrderSummary> findOrderSummaries();
```

### Best Practices

- Inspect generated SQL.
- Use appropriate fetch strategies.
- Avoid indiscriminate eager loading.
- Use pagination carefully with collection fetch joins.
- Measure query performance.

---

## Q90. How do you handle database indexing for high-performance Spring Boot applications?

### Solution

Use indexes based on actual query patterns.

### Example

sql

```
CREATE INDEX idx_orders_customer_created
ON orders(customer_id, created_at DESC);
```

### Important Considerations

- Index frequently filtered columns.
- Use composite indexes for common multi-column predicates.
- Consider column order in composite indexes.
- Analyze execution plans using `EXPLAIN ANALYZE`.
- Avoid excessive indexes.
- Monitor write overhead.
- Consider partial indexes when appropriate.

An index is not automatically beneficial for every column.

---

# 18\. Final Senior Developer Interview Preparation

## Important Topics to Master

| Area | Topics |
| --- | --- |
| Java | Collections, Streams, Concurrency, JVM, Garbage Collection, Virtual Threads |
| Spring Boot | Dependency Injection, AOP, Transactions, Security, Actuator |
| Spring Cloud | Gateway, Config, OpenFeign, Load Balancing |
| Microservices | Saga, Outbox, CQRS, Eventual Consistency |
| Kafka | Partitions, Consumer Groups, Offsets, Retry, DLQ |
| Database | Indexing, Transactions, Locking, Query Optimization |
| Redis | Caching, TTL, Cache Invalidation, Distributed Locks |
| Security | OAuth 2.0, OIDC, JWT, mTLS |
| Kubernetes | Pods, Deployments, Services, Ingress, Probes, HPA |
| DevOps | Docker, CI/CD, Blue-Green, Canary |
| Observability | Logs, Metrics, Traces, OpenTelemetry |
| System Design | Scalability, Availability, Reliability, Consistency |

## How to Answer Senior-Level Interview Questions

Use the following structure when answering architecture and production-related questions:

1. **Understand the problem:** Explain the business requirement and constraints.
2. **Describe the architecture:** Identify services and communication patterns.
3. **Explain the implementation:** Discuss Spring Boot, Java, database, and messaging choices.
4. **Discuss failure scenarios:** Explain timeouts, retries, duplicates, and recovery.
5. **Discuss scalability:** Explain concurrency, caching, partitioning, and horizontal scaling.
6. **Discuss observability:** Explain logs, metrics, and distributed tracing.
7. **Discuss trade-offs:** Explain why you selected one approach over alternatives.

## Final Interview Checklist

- [ ]Can explain Spring Boot auto-configuration.
- [ ]Can implement REST APIs with validation and exception handling.
- [ ]Can explain transaction propagation and isolation.
- [ ]Can implement pagination and sorting.
- [ ]Can explain optimistic and pessimistic locking.
- [ ]Can troubleshoot database connection exhaustion.
- [ ]Can explain Kafka partitions and consumer groups.
- [ ]Can implement idempotent consumers.
- [ ]Can explain Saga and Outbox patterns.
- [ ]Can design an e-commerce microservices architecture.
- [ ]Can explain OAuth 2.0 and OpenID Connect.
- [ ]Can configure Resilience4j.
- [ ]Can troubleshoot high CPU and memory usage.
- [ ]Can explain Kubernetes probes and deployments.
- [ ]Can implement caching with Redis.
- [ ]Can explain distributed tracing.
- [ ]Can discuss monolith versus microservices trade-offs.
- [ ]Can explain production incident management.
- [ ]Can discuss backward-compatible API and event changes.
- [ ]Can explain deployment and rollback strategies.

---

# Complete Spring Boot Microservices Interview Preparation – All 20 Topics

This guide explains all 20 topics from your checklist with:

- Simple explanations.
- Real-world examples.
- Spring Boot / Java code.
- Production scenarios.
- Common interview questions.
- Senior-level answers and important points.

Technology stack: Java 17+, Spring Boot 3.x, Spring Security 6, Spring Cloud, PostgreSQL, Kafka, Redis, Docker, Kubernetes, and Resilience4j.

# 1. Spring Boot Auto-Configuration

## What is auto-configuration?

Spring Boot Auto-Configuration automatically configures application components based on:

- Dependencies available in the classpath.
- Existing Spring beans.
- Application properties.
- Configuration conditions.

It reduces the amount of manual configuration required.

### Example

Suppose you add the Spring Web dependency:

xml

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Spring Boot automatically configures several web application components, including:

- Embedded Tomcat.
- DispatcherServlet.
- JSON message converters.
- Default MVC infrastructure.

You do not need to configure all these components manually.

## How does auto-configuration work?

The main annotation is:

java

```
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                OrderApplication.class,
                args
        );
    }
}
```

`@SpringBootApplication` combines three important annotations:

| Annotation | Purpose |
| --- | --- |
| `@Configuration` | Allows Java-based bean configuration |
| `@EnableAutoConfiguration` | Enables automatic configuration |
| `@ComponentScan` | Scans components in the application package and subpackages |

### Example of conditional configuration

java

```
@Configuration
@ConditionalOnClass(DataSource.class)
public class DatabaseConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public MyDatabaseService databaseService() {
        return new MyDatabaseService();
    }
}
```

Important conditional annotations:

- `@ConditionalOnClass`: Configuration applies when a class exists.
- `@ConditionalOnMissingBean`: Creates a bean only when no matching bean already exists.
- `@ConditionalOnProperty`: Configuration depends on a property.
- `@ConditionalOnBean`: Configuration applies when another bean exists.

## How can you debug auto-configuration?

Run the application with:

bash

```
java -jar application.jar --debug
```

Spring Boot prints the auto-configuration condition evaluation report.

## Interview question

What happens if you define your own DataSource bean?

Spring Boot's default DataSource auto-configuration generally backs off when an appropriate DataSource bean already exists.

Senior-level answer:

"Spring Boot auto-configuration is based on conditional configuration. It provides sensible defaults but allows developers to override those defaults through custom beans and properties."

# 2. Implement REST APIs with Validation and Exception Handling

## What is REST?

REST is an architectural style used to build APIs that communicate through HTTP.

Common HTTP methods:

| Method | Purpose | Example |
| --- | --- | --- |
| GET | Retrieve data | Get product |
| POST | Create data | Create order |
| PUT | Replace data | Update product |
| PATCH | Partially update data | Update product price |
| DELETE | Delete data | Delete product |

## Step 1: Create an Entity

java

```
@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;
}
```

## Step 2: Create a DTO with validation

java

```
public record ProductRequest(

    @NotBlank(message = "Name is required")
    String name,

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    BigDecimal price

) {}
```

## Step 3: Create a Repository

java

```
public interface ProductRepository
        extends JpaRepository<Product, Long> {
}
```

## Step 4: Create a Service

java

```
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(ProductRequest request) {

        Product product = new Product();

        product.setName(request.name());
        product.setPrice(request.price());

        return repository.save(product);
    }

    public Product getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                        "Product not found"
                    )
                );
    }
}
```

## Step 5: Create a REST Controller

java

```
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Product> create(
            @Valid @RequestBody ProductRequest request) {

        Product product = service.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getById(id)
        );
    }
}
```

## Step 6: Global Exception Handling

java

```
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleNotFound(
            ResourceNotFoundException ex) {

        ProblemDetail problem =
                ProblemDetail.forStatus(
                        HttpStatus.NOT_FOUND
                );

        problem.setTitle("Resource Not Found");
        problem.setDetail(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleValidation(
            MethodArgumentNotValidException ex) {

        ProblemDetail problem =
                ProblemDetail.forStatus(
                        HttpStatus.BAD_REQUEST
                );

        problem.setTitle("Validation Failed");
        problem.setDetail(
                "One or more request fields are invalid"
        );

        return ResponseEntity.badRequest()
                .body(problem);
    }
}
```

## Important HTTP status codes

| Status | Meaning |
| --- | --- |
| 200 | OK |
| 201 | Created |
| 204 | No Content |
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |
| 409 | Conflict |
| 429 | Too Many Requests |
| 500 | Internal Server Error |
| 503 | Service Unavailable |

## Interview question

Why should we use DTOs instead of directly exposing entities?

Answer:

- Prevent exposing internal database structures.
- Control request and response fields.
- Apply validation.
- Avoid accidental modification of sensitive fields.
- Reduce coupling between API and database models.

# 3. Transaction Propagation and Isolation

## What is @Transactional?

`@Transactional` manages database transaction boundaries.

Example:

java

```
@Transactional
public void createOrder() {

    orderRepository.save(order);

    paymentRepository.save(payment);
}
```

If both operations participate in the same transaction and the transaction rolls back, both database changes are rolled back.

## Transaction propagation

Propagation determines how a method behaves when an existing transaction is present.

### Important propagation types

| Propagation | Explanation |
| --- | --- |
| REQUIRED | Uses existing transaction or creates a new one |
| REQUIRES\_NEW | Suspends existing transaction and creates a new one |
| SUPPORTS | Uses existing transaction if available |
| MANDATORY | Requires an existing transaction |
| NOT\_SUPPORTED | Executes without an active transaction |
| NEVER | Throws an exception if a transaction exists |
| NESTED | Uses a nested transaction/savepoint when supported |

### REQUIRED example

java

```
@Transactional(
    propagation = Propagation.REQUIRED
)
public void createOrder() {
    // Business logic
}
```

If an existing transaction exists, this method joins it.

Otherwise, Spring creates a new transaction.

### REQUIRES\_NEW example

java

```
@Transactional(
    propagation = Propagation.REQUIRES_NEW
)
public void saveAuditLog() {
    auditRepository.save(new AuditLog());
}
```

This transaction is independent of the caller's transaction.

For example, an audit record can commit even if the outer business transaction later rolls back.

However, it requires a separate transaction and connection while the outer transaction is suspended.

## Transaction isolation

Isolation determines how concurrent database transactions interact.

| Isolation | Dirty Read | Non-repeatable Read | Phantom Read |
| --- | --- | --- | --- |
| READ\_UNCOMMITTED | Possible | Possible | Possible |
| READ\_COMMITTED | Prevented | Possible | Possible |
| REPEATABLE\_READ | Prevented | Prevented | Database-dependent |
| SERIALIZABLE | Prevented | Prevented | Prevented |

### Common problems

Dirty Read: Reading uncommitted data from another transaction.

Non-repeatable Read: Reading the same row twice and getting different values because another transaction updated it.

Phantom Read: Repeating a range query and getting additional or missing rows because another transaction inserted or deleted matching records.

### Example

java

```
@Transactional(
    isolation = Isolation.READ_COMMITTED
)
public void updateAccount() {
    // Business logic
}
```

## Interview question

Which isolation level does PostgreSQL use by default?

PostgreSQL uses `READ COMMITTED` by default.

Senior-level answer:

"I select transaction isolation according to business consistency requirements and concurrency patterns. Higher isolation can reduce anomalies but may increase locking, contention, or transaction retries."

# 4. Implement Pagination and Sorting

## Why is pagination important?

Imagine an Order Service contains 10 million records.

Returning all records in one API call can cause:

- High memory consumption.
- Slow responses.
- Database overload.
- Network overhead.

Pagination retrieves records in smaller portions.

## Repository

java

```
public interface OrderRepository
        extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerId(
            Long customerId,
            Pageable pageable
    );
}
```

## Service

java

```
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Page<Order> getOrders(
            Long customerId,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("createdAt").descending()
        );

        return repository.findByCustomerId(
                customerId,
                pageable
        );
    }
}
```

## Controller

java

```
@GetMapping
public Page<Order> getOrders(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {

    if (size < 1 || size > 100) {
        throw new IllegalArgumentException(
                "Page size must be between 1 and 100"
        );
    }

    return orderService.getOrders(
            customerId,
            page,
            size
    );
}
```

API:

http

```
GET /api/orders?page=0&size=20
```

## Page vs Slice

| Page | Slice |
| --- | --- |
| Includes total element count | Does not require total count |
| Can require an additional count query | Usually cheaper for large datasets |
| Supports total pages | Indicates whether another slice exists |

## What is keyset pagination?

Offset pagination becomes expensive when retrieving very deep pages.

Keyset pagination uses the last returned record as the starting point for the next request.

Example:

sql

```
SELECT *
FROM orders
WHERE (created_at, id) < (:lastCreatedAt, :lastId)
ORDER BY created_at DESC, id DESC
LIMIT 20;
```

Use a stable ordering and matching index.

Interview answer: For millions of records, I would evaluate keyset pagination rather than relying exclusively on large OFFSET values.

# 5. Optimistic and Pessimistic Locking

These mechanisms prevent concurrent transactions from incorrectly modifying the same data.

## Optimistic locking

Assumes conflicts are uncommon.

Uses a version column.

### Entity

java

```
@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    @Version
    private Long version;
}
```

### How it works

Suppose the product version is 1.

- Admin A reads version 1.
- Admin B reads version 1.
- Admin A updates the product. Version becomes 2.
- Admin B tries updating using version 1.
- The update fails because the version has changed.

This prevents silent overwrites.

## Pessimistic locking

Assumes conflicts may occur and acquires a database lock before modification.

### Repository

java

```
public interface ProductRepository
        extends JpaRepository<Product, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        SELECT p FROM Product p
        WHERE p.id = :id
        """)
    Optional<Product> findByIdForUpdate(Long id);
}
```

### Service

java

```
@Transactional
public void updateProduct(Long id) {

    Product product = repository
            .findByIdForUpdate(id)
            .orElseThrow();

    product.setPrice(
            new BigDecimal("1500")
    );
}
```

## Comparison

| Optimistic Locking | Pessimistic Locking |
| --- | --- |
| Uses version checks | Uses database locks |
| Good for low-conflict workloads | Good for critical serialized updates |
| Does not hold a lock during normal reads | Can block concurrent transactions |
| Conflicts detected during update | Conflicts handled through locking |

Real-world example:

- Product catalog updates: optimistic locking.
- Critical inventory reservation: atomic SQL update or suitable pessimistic locking.

# 6. Troubleshoot Database Connection Exhaustion

## What is database connection exhaustion?

Spring Boot applications use connection pools to reuse database connections.

HikariCP is the default connection pool in many Spring Boot JDBC/JPA configurations.

Imagine:

- Database supports 200 connections.
- Application has 10 Kubernetes pods.
- Each pod has a maximum pool size of 30.

Potential application connections:

$$
10 \times 30 = 300
$$

The application can request more connections than the database supports.

### Common error

text

```
HikariPool - Connection is not available,
request timed out after 30000ms
```

## Common causes

1. Connection pool is too small.
2. SQL queries are taking too long.
3. Transactions remain open too long.
4. Database connections are leaked.
5. Missing indexes cause slow queries.
6. Too many concurrent requests.
7. Database connection limits are too low.

## HikariCP configuration

yaml

```
spring:
  datasource:
    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
      leak-detection-threshold: 20000
```

Leak detection is a diagnostic aid, not a substitute for fixing connection lifecycle problems.

## How to troubleshoot

Step 1: Check connection pool metrics.

Using Spring Boot Actuator and Micrometer, monitor:

- Active connections.
- Idle connections.
- Pending connection requests.
- Maximum pool size.
- Connection acquisition time.

Step 2: Identify slow queries.

PostgreSQL example:

sql

```
SELECT
    pid,
    state,
    query,
    query_start
FROM pg_stat_activity
WHERE state <> 'idle';
```

Step 3: Check for long-running transactions.

Step 4: Review application logs.

Step 5: Inspect database connection limits.

Step 6: Optimize queries and transaction boundaries.

## Interview question

Should we increase HikariCP maximum-pool-size whenever connections are exhausted?

No.

Increasing pool size can overload the database further.

First investigate query performance, connection leaks, application concurrency, and total connections across all replicas.

Senior-level answer:

"I would calculate the total connection budget across all application instances, reserve capacity for other database clients, monitor pool utilization, and optimize slow queries before increasing pool size."

# 7. Kafka Partitions and Consumer Groups

## What is Kafka?

Kafka is a distributed event streaming platform used for asynchronous communication between microservices.

Example:

text

```
Order Service
     |
     v
    Kafka
     |
     +----------------+
     |                |
     v                v
Payment Service  Notification Service
```

The Order Service publishes an event. Other services consume it independently.

## What is a Kafka topic?

A topic is a logical stream of records.

Example topics:

- `orders`
- `payments`
- `inventory`
- `notifications`

## What is a partition?

A partition is a unit of storage and parallelism within a topic.

Apache Kafka - Event Sourcing, Monitoring, Librdkafka, Scaling & Partitioning | PDF

[slideshare.net](<https://www.slideshare.net/slideshow/apache-kafka-event-sourcing-monitoring-librdkafka-scaling-partitioning/109398462?utm_source=chatgpt.com>)

Example:

text

```
Topic: orders

Partition 0: [Order1] [Order4] [Order7]

Partition 1: [Order2] [Order5] [Order8]

Partition 2: [Order3] [Order6] [Order9]
```

Kafka guarantees ordering within a partition, not across all partitions.

If you use `orderId` as the message key, events for the same order can be routed to the same partition, preserving their partition order.

## What is a consumer group?

A consumer group is a collection of consumers that share the work of consuming a topic.

Example:

text

```
Topic: orders
Partitions: 3

Consumer Group: payment-group

Partition 0 ---> Consumer 1
Partition 1 ---> Consumer 2
Partition 2 ---> Consumer 3
```

If you add a fourth consumer, it cannot receive a fourth partition while the topic still has only three partitions. It will remain idle for that topic.

## Important Kafka concepts

| Concept | Explanation |
| --- | --- |
| Producer | Publishes messages |
| Consumer | Reads messages |
| Topic | Logical event stream |
| Partition | Unit of parallelism |
| Offset | Record position within a partition |
| Consumer Group | Coordinates consumption |
| Consumer Lag | Difference between produced and consumed positions |
| Replication | Maintains copies of partitions |
| Retention | Controls record storage duration |

## Spring Boot Kafka example

Dependency:

xml

```
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

Producer:

java

```
@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent>
            kafkaTemplate;

    public void publish(OrderEvent event) {

        kafkaTemplate.send(
                "orders",
                event.getOrderId().toString(),
                event
        );
    }
}
```

Consumer:

java

```
@Service
public class OrderConsumer {

    @KafkaListener(
        topics = "orders",
        groupId = "payment-group"
    )
    public void consume(OrderEvent event) {

        System.out.println(
                "Processing order: " + event.getOrderId()
        );
    }
}
```

## Interview question

Can two consumers in the same consumer group read the same partition simultaneously?

Normally, a partition is assigned to only one consumer within a consumer group at a time.

However, different consumer groups can independently consume the same topic.

For example:

- Payment group processes orders.
- Notification group sends emails.
- Analytics group updates reports.

All three groups can independently consume the same events.

# 8. Implement Idempotent Consumers

## What is idempotency?

Idempotency means executing the same operation multiple times produces the same business result as executing it once.

### Real-world scenario

An Order Service publishes:

json

```
{
  "eventId": "EVT-1001",
  "orderId": 5001,
  "amount": 2500
}
```

The Payment Service processes the message.

However, due to a consumer failure or offset redelivery, Kafka delivers the same message again.

Without idempotency, the customer might be charged twice.

## Solution

Maintain a processed event table.

sql

```
CREATE TABLE processed_events (
    event_id UUID PRIMARY KEY,
    processed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Spring Boot implementation

java

```
@Service
@RequiredArgsConstructor
public class PaymentConsumer {

    private final ProcessedEventRepository
            processedEventRepository;

    private final PaymentRepository paymentRepository;

    @Transactional
    public void process(OrderEvent event) {

        if (processedEventRepository
                .existsById(event.getEventId())) {

            return;
        }

        Payment payment = new Payment();

        payment.setOrderId(event.getOrderId());
        payment.setAmount(event.getAmount());

        paymentRepository.save(payment);

        processedEventRepository.save(
                new ProcessedEvent(event.getEventId())
        );
    }
}
```

### Important production improvement

The `existsById()` check alone is insufficient under concurrent delivery.

Use a unique constraint and an atomic insert strategy so that only one transaction can claim an event ID.

The business update and processed-event record must be committed in the same database transaction.

For external payment gateways, also use the gateway's idempotency mechanism.

## Interview question

Does Kafka guarantee that consumers will never receive duplicate messages?

No.

Kafka applications commonly use at-least-once processing.

Consumers must be designed to handle duplicates safely.

Senior-level answer:

"I use a stable event ID, database uniqueness constraints, atomic processing, and external provider idempotency where applicable. This prevents duplicate business effects even when message delivery occurs more than once."

# 9. Explain Saga and Outbox Patterns

These are two extremely important microservices design patterns.

## A. Saga Pattern

A Saga manages a business transaction across multiple independent microservices.

### Example: E-commerce order

A customer places an order.

text

```
Order Service
     |
     v
Inventory Service
     |
     v
Payment Service
     |
     v
Order Confirmation
```

What happens if payment fails after inventory has been reserved?

The system needs to release the reserved inventory.

This is called a compensating transaction.

### Saga example

| Step | Action | Compensation |
| --- | --- | --- |
| 1 | Create order | Cancel order |
| 2 | Reserve inventory | Release inventory |
| 3 | Process payment | Refund payment, where possible |
| 4 | Confirm order | Apply business-specific cancellation |

### Two Saga approaches

1. Choreography

Services communicate using events.

text

```
OrderCreated
     |
     v
Inventory Service
     |
     v
InventoryReserved
     |
     v
Payment Service
     |
     v
PaymentCompleted
     |
     v
Order Confirmed
```

2. Orchestration

A central orchestrator controls the workflow.

text

```
       Order Orchestrator
              |
       +------+------+
       |      |      |
       v      v      v
   Inventory Payment Order
    Service  Service Service
```

| Choreography | Orchestration |
| --- | --- |
| Event-driven coordination | Central coordinator |
| Less central control | Explicit workflow |
| Can become difficult to trace | Easier workflow visibility |
| Suitable for simpler event flows | Suitable for complex workflows |

## B. Transactional Outbox Pattern

The Outbox Pattern solves the database and Kafka dual-write problem.

### Problem

Consider:

java

```
@Transactional
public void createOrder() {

    orderRepository.save(order);

    kafkaTemplate.send("orders", event);
}
```

The database save and Kafka publication are not one atomic transaction.

Possible situation:

- Database transaction commits.
- Kafka publication fails.
- Order exists, but the event is missing.

### Solution

Save the order and event in the same database transaction.

java

```
@Transactional
public void createOrder(Order order) {

    orderRepository.save(order);

    OutboxEvent event = new OutboxEvent();

    event.setEventType("ORDER_CREATED");
    event.setAggregateId(order.getId().toString());

    outboxRepository.save(event);
}
```

A separate publisher or CDC process reads the outbox and publishes events to Kafka.

Outbox Pattern for Reliable Event Publishing | Conduktor

[conduktor.io](<https://www.conduktor.io/glossary/outbox-pattern-for-reliable-event-publishing?utm_source=chatgpt.com>)

### Comparison

| Saga | Outbox |
| --- | --- |
| Manages distributed business workflows | Solves database-event dual writes |
| Uses compensating actions | Uses reliable event publication |
| Coordinates multiple services | Coordinates database changes and event delivery |

Interview tip: Saga and Outbox are complementary patterns. They solve different problems and can be used together.

# 10. Design an E-commerce Microservices Architecture

This is one of the most common senior-level system design interview questions.

## Requirements

An e-commerce application should support:

- User registration and authentication.
- Product management.
- Shopping cart.
- Order creation.
- Inventory management.
- Payment processing.
- Shipping.
- Notifications.
- Order tracking.

## Proposed architecture

Agents365-ai/drawio-skill — Hermes Agent Skills & Skill Registries | Hermes Atlas

[hermesatlas.com](<https://hermesatlas.com/projects/Agents365-ai/drawio-skill?utm_source=chatgpt.com>)

text

```
                  Web / Mobile
                       |
                       v
                  API Gateway
                       |
          +------------+------------+
          |            |            |
          v            v            v
     User Service Product Service Cart Service
          |            |            |
       Database     Database       Redis
                       |
                       v
                  Order Service
                       |
              +--------+--------+
              |                 |
              v                 v
        Inventory Service  Payment Service
              |                 |
              v                 v
           Database          Database
              |
              v
             Kafka
              |
       +------+-------+
       |      |       |
       v      v       v
 Notification Shipping Analytics
    Service    Service Service
```

## Responsibilities of each service

| Service | Responsibility | Storage |
| --- | --- | --- |
| User | User registration and profiles | PostgreSQL |
| Product | Product catalog | PostgreSQL |
| Cart | Shopping cart | Redis or database |
| Order | Order lifecycle | PostgreSQL |
| Inventory | Stock and reservations | PostgreSQL |
| Payment | Payment processing | PostgreSQL |
| Notification | Email and SMS | Kafka plus delivery store |
| Shipping | Shipment tracking | PostgreSQL |
| Analytics | Reporting | Read-optimized storage |

## Order processing workflow

1. Customer adds products to cart.
2. Customer checks out.
3. Order Service creates a pending order.
4. Inventory Service reserves stock.
5. Payment Service processes payment.
6. Order Service confirms the order.
7. Kafka publishes business events.
8. Notification Service sends confirmation.
9. Shipping Service starts fulfillment.

## Important architecture decisions

1. Database per service

Each service owns its data.

2. Synchronous communication

Use REST when an immediate response is required.

3. Asynchronous communication

Use Kafka for business events and background processing.

4. Distributed transactions

Use Saga and Outbox patterns.

5. Caching

Use Redis for frequently accessed data.

6. Security

Use OAuth 2.0/OIDC and service-level authorization.

7. Reliability

Use timeouts, circuit breakers, retries, and bulkheads.

8. Observability

Use centralized logging, Micrometer, and OpenTelemetry.

## Senior-level interview answer

"I would design the platform around business capabilities, with each microservice owning its data and deployment lifecycle. I would use REST for immediate operations, Kafka for asynchronous events, Saga for distributed workflows, and Outbox for reliable event publication. I would also implement idempotency, distributed tracing, and failure recovery."

# 11. OAuth 2.0 and OpenID Connect

## What is OAuth 2.0?

OAuth 2.0 is an authorization framework.

It allows an application to access protected resources on behalf of a user or another application.

Example:

A mobile application wants to access a user's order information.

The application obtains an access token and sends it to the Order Service.

## What is OpenID Connect?

OpenID Connect (OIDC) is an identity layer built on OAuth 2.0.

It provides authentication and identity information.

### OAuth 2.0 vs OIDC

| Feature | OAuth 2.0 | OpenID Connect |
| --- | --- | --- |
| Main purpose | Authorization | Authentication |
| Access token | Yes | Yes |
| ID token | Not defined by OAuth itself | Yes |
| User identity | Not standardized | Standardized |
| Typical use | API access | Login and identity |

## Important tokens

| Token | Purpose |
| --- | --- |




Let's continue by expanding the checklist into a practical interview preparation guide, with explanations, important concepts, coding examples, and interview questions.

# Spring Boot Microservices – Practical Interview Preparation (Part 1)

## 1. Spring Boot Auto-Configuration

What is auto-configuration?

Spring Boot automatically configures application components based on:

- Dependencies available in the classpath.
- Existing beans.
- Application properties.
- Conditional configuration annotations.

Example:

java

```
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            OrderApplication.class, args
        );
    }
}
```

`@SpringBootApplication` combines:

- `@Configuration`
- `@EnableAutoConfiguration`
- `@ComponentScan`

Important annotations:

| Annotation | Purpose |
| --- | --- |
| `@ConditionalOnClass` | Configures when a class exists |
| `@ConditionalOnMissingBean` | Configures when a bean is missing |
| `@ConditionalOnProperty` | Configures based on properties |
| `@ConditionalOnBean` | Configures when a bean exists |

Interview questions:

1. How does Spring Boot auto-configuration work internally?
2. What is the difference between `@Configuration` and `@AutoConfiguration`?
3. How do you exclude auto-configuration?
4. What is the purpose of `@ConditionalOnMissingBean`?

## 2. REST APIs with Validation and Exception Handling

Scenario: You need to develop a REST API to create customers.

DTO:

java

```
public record CustomerRequest(

    @NotBlank(message = "Name is required")
    String name,

    @Email(message = "Invalid email")
    String email,

    @NotNull(message = "Age is required")
    @Min(18)
    Integer age

) {}
```

Controller:

java

```
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public ResponseEntity<CustomerResponse> create(
            @Valid @RequestBody CustomerRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(request));
    }
}
```

Global Exception Handler:

java

```
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
            handleValidation(
                MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
          .getFieldErrors()
          .forEach(error ->
              errors.put(
                  error.getField(),
                  error.getDefaultMessage()
              )
          );

        return ResponseEntity.badRequest()
                .body(errors);
    }
}
```

Interview questions:

1. Difference between `@RequestParam` and `@PathVariable`?
2. Difference between PUT and PATCH?
3. How does `@Valid` work?
4. How do you handle validation exceptions globally?
5. What is the difference between HTTP 400, 401, 403, 404 and 500?

## 3. Transaction Propagation and Isolation

### Transaction propagation

Propagation defines how a method participates in an existing transaction.

| Propagation | Behavior |
| --- | --- |
| REQUIRED | Uses existing transaction or creates one |
| REQUIRES\_NEW | Creates a new transaction |
| SUPPORTS | Uses existing transaction if available |
| NOT\_SUPPORTED | Executes without a transaction |
| MANDATORY | Requires an existing transaction |
| NEVER | Fails if a transaction exists |
| NESTED | Uses a nested transaction when supported |

Example:

java

```
@Transactional(
    propagation = Propagation.REQUIRES_NEW
)
public void saveAuditLog() {
    auditRepository.save(new AuditLog());
}
```

### Transaction isolation

Isolation controls how concurrent transactions interact.

| Isolation | Dirty Read | Non-repeatable Read | Phantom Read |
| --- | --- | --- | --- |
| READ\_UNCOMMITTED | Possible | Possible | Possible |
| READ\_COMMITTED | Prevented | Possible | Possible |
| REPEATABLE\_READ | Prevented | Prevented | Depends on database |
| SERIALIZABLE | Prevented | Prevented | Prevented |

Spring Boot example:

java

```
@Transactional(
    isolation = Isolation.READ_COMMITTED,
    propagation = Propagation.REQUIRED
)
public void transferMoney() {
    // Business logic
}
```

Interview questions:

1. What is a dirty read?
2. What is a phantom read?
3. Difference between REQUIRED and REQUIRES\_NEW?
4. Why does `@Transactional` sometimes not work with self-invocation?
5. Does Spring roll back transactions for checked exceptions by default?

## 4. Pagination and Sorting

Repository:

java

```
public interface OrderRepository
        extends JpaRepository<Order, Long> {

    Page<Order> findByCustomerId(
        Long customerId,
        Pageable pageable
    );
}
```

Service:

java

```
public Page<Order> getOrders(
        Long customerId,
        int page,
        int size) {

    Pageable pageable = PageRequest.of(
        page,
        size,
        Sort.by("createdAt").descending()
    );

    return repository.findByCustomerId(
        customerId,
        pageable
    );
}
```

API:

http

```
GET /api/orders?page=0&size=20
```

Important production concepts:

- Maximum page size.
- Database indexes.
- DTO projections.
- Avoiding N+1 queries.
- Keyset pagination.
- Avoiding expensive count queries.

Interview questions:

1. Difference between `Page` and `Slice`?
2. What is keyset pagination?
3. Why is offset pagination slow for millions of records?
4. How do you implement dynamic sorting?

## 5\. Optimistic and Pessimistic Locking

### Optimistic locking

Uses a version field to detect conflicting updates.

java

```
@Entity
public class Product {

    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    @Version
    private Long version;
}
```

### Pessimistic locking

Locks a database record during a transaction.

java

```
@Lock(LockModeType.PESSIMISTIC_WRITE)
@Query("""
    SELECT p
    FROM Product p
    WHERE p.id = :id
    """)
Optional<Product> findByIdForUpdate(Long id);
```

### Comparison

| Optimistic | Pessimistic |
| --- | --- |
| Detects conflicting updates | Acquires locks |
| Suitable for low contention | Suitable for selected high-contention workflows |
| Less locking overhead | More locking overhead |
| Can fail during commit | Can cause blocking and deadlocks |

Interview scenario: Two customers purchase the last available product simultaneously. How do you prevent overselling?

A strong answer includes atomic database updates, appropriate locking, and idempotent reservation handling.

## Self-assessment

Part 1 progress

# 0/5

[ ]Spring Boot auto-configuration

[ ]REST API validation and exception handling

[ ]Transaction propagation and isolation

[ ]Pagination and sorting

[ ]Optimistic and pessimistic locking

Next: Part 2 will cover database connection exhaustion, Kafka partitions and consumer groups, idempotent consumers, Saga, Outbox, and e-commerce microservices system design.


---

# Spring Boot Microservices – Practical Interview Preparation (Part 2)

This part covers topics 6–10 from your Senior Java Developer interview checklist, focusing on real-world production scenarios and frequently asked interview questions.

## 6. Database Connection Pool Exhaustion

### What is a database connection pool?

A connection pool maintains reusable database connections instead of creating a new connection for every request.

Spring Boot commonly uses HikariCP as its default JDBC connection pool.

Effective API Optimization Techniques for Modern Applications | by Code Wiz | Javarevisited | Medium

[medium.com](<https://medium.com/javarevisited/effective-api-optimization-techniques-for-modern-applications-5363bd8149ff?utm_source=chatgpt.com>)

### Scenario

Your production application suddenly shows:

text

```
HikariPool - Connection is not available,
request timed out after 30000ms
```

### Possible reasons

1. Too many concurrent requests.
2. Long-running SQL queries.
3. Missing database indexes.
4. Connections not being released.
5. Long-running transactions.
6. Connection pool configuration problems.
7. Database maximum connection limit reached.

### Configuration

yaml

```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/orderdb
    username: postgres
    password: password

    hikari:
      maximum-pool-size: 20
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
```

### Monitoring connection pool

java

```
@Component
@RequiredArgsConstructor
public class ConnectionPoolMonitor {

    private final DataSource dataSource;

    public void printPoolDetails() {

        HikariDataSource hikari =
                (HikariDataSource) dataSource;

        HikariPoolMXBean pool =
                hikari.getHikariPoolMXBean();

        System.out.println(
            "Active: " + pool.getActiveConnections()
        );

        System.out.println(
            "Idle: " + pool.getIdleConnections()
        );

        System.out.println(
            "Waiting: " + pool.getThreadsAwaitingConnection()
        );
    }
}
```

### Important production consideration

Suppose:

- Kubernetes replicas = 10
- Maximum pool size = 20

Potential maximum connections:

$$
10 \times 20 = 200
$$

Your database must support this connection demand alongside other applications and administrative connections.

### Interview questions

1. What is HikariCP?
2. What happens when the connection pool is exhausted?
3. How do you identify connection leaks?
4. How do you calculate the appropriate pool size?
5. Why can increasing connection pool size reduce performance?

Senior-level answer: I would inspect active connections, waiting threads, slow queries, transaction duration, and database capacity before increasing the pool size.

## 7. Kafka Partitions and Consumer Groups

### What is Kafka?

Apache Kafka is a distributed event streaming platform used for asynchronous communication between microservices.

All things Kafka - DEV Community

[dev.to](<https://dev.to/alamfatima1999/all-things-kafka-3cdb?utm_source=chatgpt.com>)

### Important Kafka concepts

| Concept | Explanation |
| --- | --- |
| Producer | Publishes messages |
| Consumer | Reads messages |
| Topic | Logical event stream |
| Partition | Unit of parallelism and ordering |
| Offset | Position of a record in a partition |
| Broker | Kafka server |
| Consumer Group | Coordinates consumer processing |
| Replication | Maintains copies of partitions |
| Consumer Lag | Difference between produced and consumed positions |

### Kafka architecture

text

```
             Producer
                 |
                 v
             Kafka Topic
                 |
        +--------+--------+
        |        |        |
        v        v        v
    Partition  Partition Partition
        0        1        2
        |        |        |
        v        v        v
    Consumer  Consumer  Consumer
        1        2        3
```

### Spring Boot Kafka producer

Dependency:

xml

```
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

Producer:

java

```
@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent>
            kafkaTemplate;

    public void publishOrder(OrderEvent event) {

        kafkaTemplate.send(
            "orders",
            event.getOrderId().toString(),
            event
        );
    }
}
```

### Kafka consumer

java

```
@Service
public class OrderConsumer {

    @KafkaListener(
        topics = "orders",
        groupId = "order-consumer-group"
    )
    public void consume(OrderEvent event) {

        System.out.println(
            "Received Order: " + event.getOrderId()
        );
    }
}
```

### Configuration

yaml

```
spring:
  kafka:
    bootstrap-servers: localhost:9092

    consumer:
      group-id: order-consumer-group
      auto-offset-reset: earliest
      enable-auto-commit: false

    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer

    consumer:
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
```

Configuration note: In a complete application, configure the JSON deserializer's trusted packages and type mapping appropriately. The YAML example should combine the consumer settings into one consumer block.

### Interview question: Can five consumers read from a topic with three partitions in the same consumer group?

Answer:

- Three consumers can actively own one partition each.
- Two consumers will remain idle.
- A partition is assigned to only one consumer within a consumer group at a time.

### Important interview questions

1. What is the difference between a topic and a partition?
2. What happens when a consumer crashes?
3. What is consumer rebalancing?
4. What is consumer lag?
5. How does Kafka maintain message ordering?
6. Can multiple consumers read the same partition?
7. What happens when a consumer group changes?

## 8. Implementing Idempotent Kafka Consumers

### What is idempotency?

Idempotency means processing the same event multiple times does not repeat the business effect.

### Scenario

An Order Service publishes an event.

The Payment Service processes it successfully, but crashes before committing its Kafka offset.

Kafka delivers the event again.

Without idempotency, the customer might be charged twice.

### Solution

Maintain a processed event table.

sql

```
CREATE TABLE processed_events (
    event_id UUID PRIMARY KEY,
    processed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Event class

java

```
public record OrderEvent(
    UUID eventId,
    Long orderId,
    BigDecimal amount
) {}
```

### Consumer service

java

```
@Service
@RequiredArgsConstructor
public class PaymentConsumer {

    private final ProcessedEventRepository
            processedRepository;

    private final PaymentService paymentService;

    @Transactional
    public void process(OrderEvent event) {

        if (processedRepository
                .existsById(event.eventId())) {
            return;
        }

        paymentService.processPayment(
            event.orderId(),
            event.amount()
        );

        processedRepository.save(
            new ProcessedEvent(event.eventId())
        );
    }
}
```

### Important production improvement

A simple existence check followed by an insert is vulnerable to concurrent duplicate deliveries.

Use a unique constraint and an atomic insert or equivalent database mechanism. The payment operation and processed-event record must participate in the same database transaction when they share a transactional resource.

For external payment providers, use their idempotency support as well.

### Interview questions

1. Why does Kafka deliver duplicate messages?
2. How do you prevent duplicate payments?
3. What is the difference between idempotent producer and idempotent consumer?
4. Why is a unique database constraint important?
5. Does Kafka exactly-once processing guarantee exactly-once business execution?

## 9. Saga and Transactional Outbox Patterns

### What is the Saga pattern?

The Saga pattern manages distributed business transactions using a sequence of local transactions and compensating actions.

### Scenario

An e-commerce order requires:

1. Creating an order.
2. Reserving inventory.
3. Processing payment.
4. Confirming the order.

If payment fails, inventory must be released and the order cancelled.

Saga Pattern Is a Lie — Here’s What Really Happens in Production | by Build Break Learn | Medium

[medium.com](<https://medium.com/%40poojarana20072001/saga-pattern-is-a-lie-heres-what-really-happens-in-production-7d0e300a50d0?utm_source=chatgpt.com>)

### Saga workflow

text

```
       Create Order
            |
            v
     Reserve Inventory
            |
            v
      Process Payment
            |
       +----+----+
       |         |
    Success    Failure
       |         |
       v         v
 Confirm Order  Release Inventory
                 |
                 v
             Cancel Order
```

### Two Saga approaches

| Orchestration | Choreography |
| --- | --- |
| Central coordinator manages workflow | Services react to events |
| Centralized workflow visibility | Distributed workflow |
| Easier to inspect complex workflows | Can be simpler for smaller workflows |
| Coordinator adds responsibility | Event dependencies can become difficult to understand |

### What is the Transactional Outbox Pattern?

It solves the database and Kafka dual-write problem.

Without Outbox:

text

```
Save Order to Database
          |
          v
     Publish Kafka
          |
          v
       Failure?
```

The order might be saved even though its event was not published.

With Outbox:

text

```
       Order Service
             |
             v
       Database Transaction
          /          \
         v            v
    Save Order    Save Event
         \            /
          +----------+
               |
               v
         Outbox Publisher
               |
               v
             Kafka
```

### Example

java

```
@Transactional
public void createOrder(Order order) {

    orderRepository.save(order);

    OutboxEvent event =
            OutboxEvent.from(order);

    outboxRepository.save(event);
}
```

A separate publisher or CDC process publishes the event to Kafka.

### Interview questions

1. What problem does Saga solve?
2. What is a compensating transaction?
3. Difference between orchestration and choreography?
4. Why do we need the Outbox pattern?
5. How do you handle duplicate Outbox events?
6. How do you handle a failed compensation?

## 10. Design an E-Commerce Microservices Architecture

### Functional requirements

- User registration.
- Authentication.
- Product catalog.
- Shopping cart.
- Order management.
- Inventory management.
- Payment processing.
- Notifications.
- Shipping and tracking.

### Proposed architecture

Agents365-ai/drawio-skill — Hermes Agent Skills & Skill Registries | Hermes Atlas

[hermesatlas.com](<https://hermesatlas.com/projects/Agents365-ai/drawio-skill?utm_source=chatgpt.com>)

### Architecture diagram

text

```
                  Web / Mobile
                       |
                       v
                  API Gateway
                       |
       +---------------+---------------+
       |               |               |
       v               v               v
  User Service   Product Service   Cart Service
       |               |               |
       v               v               v
    Database        Database          Redis

                   Order Service
                        |
              +---------+---------+
              |                   |
              v                   v
       Inventory Service    Payment Service
              |                   |
              v                   v
           Database            Database
              |                   |
              +---------+---------+
                        |
                        v
                       Kafka
                        |
           +------------+------------+
           |            |            |
           v            v            v
      Notification   Shipping    Analytics
        Service      Service      Service
```

### Technology selection

| Component | Technology |
| --- | --- |
| API Gateway | Spring Cloud Gateway |
| Backend | Spring Boot 3 |
| Security | Spring Security 6, OAuth 2.0/OIDC |
| Communication | REST and Kafka |
| Database | PostgreSQL |
| Cache | Redis |
| Messaging | Kafka |
| Containerization | Docker |
| Orchestration | Kubernetes |
| Monitoring | Micrometer, Prometheus |
| Distributed tracing | OpenTelemetry |

### Important design decisions

1. Database per service

Each service owns its business data.

2. Communication

Use REST for synchronous queries and Kafka for asynchronous events.

3\. Distributed transactions

Use Saga and Outbox patterns.

4\. Reliability

Implement timeouts, retries, circuit breakers, bulkheads, and idempotency.

5\. Security

Use OAuth 2.0/OIDC, token validation, and service-level authorization.

6\. Scalability

Scale Product Service, Order Service, and other workloads independently.

7\. Observability

Use centralized logs, metrics, and distributed tracing.

### Senior-level interview question

What happens if payment succeeds but the Order Service does not receive the response?

Answer:

"The payment outcome is uncertain from the Order Service's perspective. I would not blindly initiate another payment. I would use a stable idempotency key, query or reconcile the payment status with the payment provider, and update the order through a reliable workflow."

# Part 2 – Self-assessment

Your progress

# 0/5

[ ]Database connection pool exhaustion

[ ]Kafka partitions and consumer groups

[ ]Idempotent Kafka consumers

[ ]Saga and Transactional Outbox

[ ]E-commerce microservices architecture

## What comes next – Part 3

The next five topics will cover:

1. OAuth 2.0 and OpenID Connect with Spring Security 6.
2. Resilience4j – Circuit Breaker, Retry, Bulkhead and Rate Limiter.
3. Production troubleshooting – High CPU, memory leaks and JVM analysis.
4. Kubernetes – Deployment, Service, Ingress, probes and HPA.
5. Redis caching – Cache-Aside, TTL, invalidation and cache stampede.

These are particularly important for Senior Java Developer interviews because interviewers often expect practical production experience, not just definitions.

---
# Spring Boot Microservices – Practical Interview Preparation (Part 3)

This part covers topics 11–15 of your Senior Java Developer interview checklist.

The focus is on Spring Security 6, Resilience4j, JVM troubleshooting, Kubernetes, and Redis caching, with practical configuration examples and production interview scenarios.

## 11. OAuth 2.0 and OpenID Connect with Spring Security 6

### What is OAuth 2.0?

OAuth 2.0 is an authorization framework that allows applications to access protected resources without sharing user passwords with those applications.

### What is OpenID Connect (OIDC)?

OIDC is an identity layer built on OAuth 2.0. It adds authentication and identity information through an ID token.

OAuth 2.0 Authorization Code Flow with PKCE: A Complete Guide

[ashishsrivastav.com](<https://ashishsrivastav.com/blog/oauth2-authorization-code-pkce-guide?utm_source=chatgpt.com>)

### Important concepts

| Concept | Explanation |
| --- | --- |
| Resource Owner | User who owns the data |
| Client | Application requesting access |
| Authorization Server | Issues tokens |
| Resource Server | Protects APIs |
| Access Token | Used to access protected resources |
| Refresh Token | Used to obtain new access tokens |
| ID Token | Contains authentication information in OIDC |
| Scope | Defines permitted access |

### OAuth 2.0 Authorization Code Flow

text

```
User
 |
 v
Client Application
 |
 v
Authorization Server
 |
 v
User Login and Consent
 |
 v
Authorization Code
 |
 v
Client Exchanges Code
 |
 v
Access Token + ID Token
 |
 v
Resource Server
```

### Spring Boot dependency

xml

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>
```

### Spring Security configuration

Example of a JWT-protected REST API:

java

```
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/api/admin/**")
                    .hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth ->
                oauth.jwt(Customizer.withDefaults())
            )
            .build();
    }
}
```

Configuration:

yaml

```
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://identity.example.com
```

### Interview traps

- JWT is a token format, not an authentication protocol.
- OAuth 2.0 is primarily about authorization.
- OIDC adds authentication.
- A valid JWT does not automatically mean the user has permission to access every resource.
- A resource server must validate token signature, issuer, expiry, and appropriate audience and claims.

### Interview questions

1. Difference between OAuth 2.0 and OIDC?
2. Difference between access token and refresh token?
3. What is JWT?
4. How does Spring Security validate JWT?
5. What is the Authorization Code Flow with PKCE?
6. Difference between authentication and authorization?
7. How do you implement role-based access control?

## 12. Resilience4j – Circuit Breaker, Retry, Bulkhead and Rate Limiter

### What is Resilience4j?

Resilience4j is a fault-tolerance library used to make distributed applications more resilient when downstream services fail or become slow.

### Why do we need it?

Scenario:

Order Service calls Payment Service.

Payment Service becomes unavailable.

Without protection, repeated calls can exhaust Order Service threads and connections.

### Circuit Breaker states

| State | Behavior |
| --- | --- |
| CLOSED | Requests are allowed |
| OPEN | Requests are rejected |
| HALF\_OPEN | Limited test requests are allowed |

### Dependency

xml

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
</dependency>
```

Use a Spring Cloud release train compatible with your Spring Boot version.

### Configuration

yaml

```
resilience4j:
  circuitbreaker:
    instances:
      paymentService:
        slidingWindowType: COUNT_BASED
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        failureRateThreshold: 50
        waitDurationInOpenState: 10s
        permittedNumberOfCallsInHalfOpenState: 3

  retry:
    instances:
      paymentService:
        maxAttempts: 3
        waitDuration: 1s

  bulkhead:
    instances:
      paymentService:
        maxConcurrentCalls: 10
```

### Circuit Breaker example

java

```
@Service
@RequiredArgsConstructor
public class PaymentClient {

    private final PaymentApi paymentApi;

    @CircuitBreaker(
        name = "paymentService",
        fallbackMethod = "paymentFallback"
    )
    public PaymentResponse processPayment(
            PaymentRequest request) {

        return paymentApi.process(request);
    }

    public PaymentResponse paymentFallback(
            PaymentRequest request,
            Throwable ex) {

        return PaymentResponse.pending(
            "Payment temporarily unavailable"
        );
    }
}
```

A fallback must not falsely report a payment as successful. For payment processing, an unknown outcome should generally remain pending until reconciled.

### Four important resilience mechanisms

| Mechanism | Purpose |
| --- | --- |
| Circuit Breaker | Stops repeated calls to failing services |
| Retry | Repeats eligible failed operations |
| Bulkhead | Limits resource consumption |
| Rate Limiter | Restricts request frequency |
| TimeLimiter | Limits operation duration |

### Production best practices

- Configure connection and request timeouts.
- Retry only transient and safe operations.
- Use exponential backoff and jitter.
- Avoid retry storms.
- Do not retry non-idempotent payment operations blindly.
- Monitor circuit breaker state transitions.

### Interview questions

1. What happens when a circuit breaker opens?
2. Difference between Retry and Circuit Breaker?
3. What is the Bulkhead pattern?
4. What is a fallback method?
5. Why can excessive retries cause cascading failures?
6. How do you configure Resilience4j in Spring Boot?

## 13. Production Troubleshooting – High CPU and Memory Usage

This is one of the most important topics for Senior Java Developer interviews.

Interviewers want to know how you investigate real production problems without blindly restarting applications.

### Scenario 1: Spring Boot application has high CPU utilization

Your application suddenly starts consuming 95–100% CPU.

Profiling Java with JFR or Async-Profiler

[liufuyang.github.io](<https://liufuyang.github.io/2019/11/02/java-profiler.html?utm_source=chatgpt.com>)

### Possible root causes

1. Infinite loops.
2. Excessive garbage collection.
3. High request volume.
4. Expensive database processing.
5. Inefficient algorithms.
6. Lock contention.
7. Expensive JSON serialization.
8. Regular expression performance issues.

### Step 1: Identify the process

bash

```
top
```

Find the Java process ID.

bash

```
ps -ef | grep java
```

### Step 2: Identify CPU-intensive threads

bash

```
top -H -p <pid>
```

This displays individual threads consuming CPU.

### Step 3: Capture thread dump

bash

```
jcmd <pid> Thread.print
```

Look for:

- Threads continuously executing the same code.
- Deadlocks.
- Lock contention.
- Unexpectedly high thread counts.

### Step 4: Use Java Flight Recorder

bash

```
jcmd <pid> JFR.start \
  name=production-recording \
  duration=60s \
  filename=/tmp/production.jfr
```

Analyze the recording using Java Mission Control.

### Scenario 2: Spring Boot application has high memory usage

Possible causes:

- Memory leaks.
- Large collections retained in memory.
- Unbounded caches.
- Thread-local variables not cleared.
- Excessive object creation.
- Large HTTP responses.
- Direct memory consumption.

### Useful JVM commands

Check heap information:

bash

```
jcmd <pid> GC.heap_info
```

Check class histogram:

bash

```
jcmd <pid> GC.class_histogram
```

Capture heap dump:

bash

```
jcmd <pid> GC.heap_dump /tmp/heap.hprof
```

Analyze heap dumps using Eclipse MAT or another compatible heap analyzer.

Tool to Analyze Offline Java Heap Dumps | Baeldung

[baeldung.com](<https://www.baeldung.com/java-analyze-offline-heap-dumps?utm_source=chatgpt.com>)

### Important JVM concepts

| Concept | Explanation |
| --- | --- |
| Heap | Stores Java objects |
| Stack | Stores method frames and local variables |
| Young Generation | Region where many new objects are allocated |
| Old Generation | Holds longer-lived objects |
| Garbage Collector | Reclaims unreachable objects |
| Memory Leak | Objects remain reachable unnecessarily |
| Metaspace | Stores class metadata |
| Direct Memory | Native memory used by off-heap allocations |

### Scenario 3: Application has low CPU but high response time

Possible causes:

- Database connection pool exhaustion.
- Downstream API delays.
- Network latency.
- Thread pool starvation.
- Lock contention.
- Slow disk I/O.
- DNS resolution delays.

Use distributed tracing and thread dumps to identify where requests spend their time.

### Senior-level interview questions

1. How do you investigate high CPU in production?
2. How do you identify a Java memory leak?
3. Difference between heap and stack?
4. What is garbage collection?
5. What is a Full GC?
6. What is the purpose of Java Flight Recorder?
7. How do you investigate OutOfMemoryError?
8. Can an application have high memory usage without a memory leak?

Senior-level answer: I would establish whether the problem is CPU-bound, memory-bound, or waiting on an external resource before choosing a mitigation.

## 14. Kubernetes – Deployment, Service, Ingress and Probes

### What is Kubernetes?

Kubernetes is a container orchestration platform used to deploy, scale, manage, and monitor containerized applications.

Visual creativity for any AI or app · Depicta

[depicta.ai](<https://depicta.ai/?utm_source=chatgpt.com>)

### Important Kubernetes components

| Component | Responsibility |
| --- | --- |
| Pod | Smallest deployable workload unit |
| Deployment | Manages replicas and rollouts |
| Service | Provides stable networking |
| Ingress | Defines external HTTP/HTTPS routing |
| ConfigMap | Stores non-sensitive configuration |
| Secret | Stores sensitive configuration data |
| HPA | Automatically adjusts replica count |
| Node | Worker machine |
| Namespace | Logical resource isolation |

### Example 1: Deployment

yaml

```
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

          ports:
            - containerPort: 8080

          resources:
            requests:
              cpu: "250m"
              memory: "512Mi"

            limits:
              cpu: "1000m"
              memory: "1Gi"
```

This creates three application replicas.

### Example 2: Kubernetes Service

yaml

```
apiVersion: v1
kind: Service

metadata:
  name: order-service

spec:
  selector:
    app: order-service

  ports:
    - port: 8080
      targetPort: 8080

  type: ClusterIP
```

The Service provides stable networking to the selected pods.

### Example 3: Kubernetes probes

Spring Boot Actuator dependency:

xml

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Application configuration:

yaml

```
management:
  endpoints:
    web:
      exposure:
        include: health

  endpoint:
    health:
      probes:
        enabled: true
```

Deployment probe configuration:

yaml

```
containers:
  - name: order-service
    image: order-service:1.0

    ports:
      - containerPort: 8080

    startupProbe:
      httpGet:
        path: /actuator/health/liveness
        port: 8080
      failureThreshold: 30
      periodSeconds: 10

    livenessProbe:
      httpGet:
        path: /actuator/health/liveness
        port: 8080
      periodSeconds: 10

    readinessProbe:
      httpGet:
        path: /actuator/health/readiness
        port: 8080
      periodSeconds: 5
```

### Difference between Kubernetes probes

Liveness Probe

Determines whether the application should be restarted.

Readiness Probe

Determines whether the pod should receive traffic.

Startup Probe

Gives the application additional time to start before liveness and readiness checks take effect.

### Interview scenario

Your Spring Boot application starts slowly. Kubernetes keeps restarting the container.

Solution:

- Configure an appropriate startup probe.
- Check JVM startup time.
- Investigate application initialization.
- Check memory limits.
- Review container logs.

### Useful Kubernetes commands

bash

```
kubectl get pods

kubectl get deployments

kubectl get services

kubectl describe pod <pod-name>

kubectl logs <pod-name>

kubectl logs <pod-name> --previous

kubectl rollout status deployment/order-service

kubectl rollout history deployment/order-service
```

Rollback:

bash

```
kubectl rollout undo deployment/order-service
```

### Rolling deployment vs rollback

- Rolling deployment gradually replaces old pods with new pods.
- Rollback restores a previous deployment revision.
- Readiness checks help prevent unready pods from receiving traffic.
- Graceful shutdown helps existing requests complete.

### Senior-level interview questions

1. Difference between Pod and Deployment?
2. Difference between Service and Ingress?
3. Difference between readiness and liveness probes?
4. What happens when a pod crashes?
5. What is CrashLoopBackOff?
6. What is ImagePullBackOff?
7. How does Horizontal Pod Autoscaler work?
8. How do you perform zero-downtime deployment?
9. How do you roll back a failed deployment?

## 15. Redis Caching with Spring Boot

### What is Redis?

Redis is an in-memory data store commonly used for caching, session management, counters, and other low-latency data access patterns.

### Why use Redis?

Scenario:

Product Service receives 50,000 requests per minute.

Every request queries PostgreSQL.

This increases database CPU usage and response time.

Solution: Cache frequently accessed product details in Redis.

Caching in APIs: Basics and Implementation in Spring | by Code Wiz | Javarevisited | Medium

[medium.com](<https://medium.com/javarevisited/caching-in-apis-basics-and-implementation-in-spring-6b76304ef93b?utm_source=chatgpt.com>)

### Step 1: Add dependency

xml

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

### Step 2: Configure Redis

yaml

```
spring:
  data:
    redis:
      host: localhost
      port: 6379
      timeout: 2s
```

### Step 3: Enable caching

java

```
@Configuration
@EnableCaching
public class CacheConfig {
}
```

### Step 4: Implement caching

java

```
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @Cacheable(
        value = "products",
        key = "#productId"
    )
    public ProductDto getProduct(Long productId) {

        System.out.println("Fetching from database");

        Product product = repository
                .findById(productId)
                .orElseThrow();

        return ProductDto.from(product);
    }

    @CacheEvict(
        value = "products",
        key = "#productId"
    )
    public void deleteProduct(Long productId) {

        repository.deleteById(productId);
    }
}
```

### Important Spring caching annotations

| Annotation | Purpose |
| --- | --- |
| `@EnableCaching` | Enables caching |
| `@Cacheable` | Reads from cache or computes and stores result |
| `@CachePut` | Executes method and updates cache |
| `@CacheEvict` | Removes cache entries |
| `@Caching` | Combines multiple cache operations |

### Cache-Aside pattern

text

```
        Client Request
              |
              v
         Product Service
              |
              v
         Check Redis
           /     \
       Found    Missing
         |         |
         v         v
     Return     Query DB
      Cache        |
                   v
               Save Redis
                   |
                   v
                Return
```

### Production challenges

1. Cache invalidation

When the product changes, the old cached data must be removed or updated.

2. Cache stampede

Many requests simultaneously try to regenerate the same expired cache entry.

Solutions include:

- Distributed coordination.
- Request coalescing.
- TTL jitter.
- Background refresh.

3. Cache penetration

Requests repeatedly query nonexistent records.

Solutions include:

- Short-lived negative caching.
- Input validation.
- Appropriate request rate limiting.

4. Hot keys

One Redis key receives unusually high traffic.

Solutions include:

- Local caching where appropriate.
- Replication and workload distribution.
- Traffic shaping.

5. TTL configuration

Avoid keeping stale data indefinitely.

### Configure TTL

For a production application, you can define a Redis cache configuration:

java

```
@Configuration
@EnableCaching
public class RedisCacheConfig {

    @Bean
    public RedisCacheConfiguration
            cacheConfiguration() {

        return RedisCacheConfiguration
            .defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(10))
            .disableCachingNullValues();
    }
}
```

### Important interview questions

1. What is Redis?
2. Difference between Redis and PostgreSQL?
3. What is Cache-Aside?
4. What is cache invalidation?
5. What is TTL?
6. What is cache stampede?
7. What is cache penetration?
8. How do you prevent stale cache data?
9. What happens if Redis becomes unavailable?
10. Is Redis a replacement for a relational database?

Senior-level answer: Redis improves read performance, but caching introduces consistency and invalidation challenges. I would define cache ownership, TTL, eviction behavior, and a database fallback strategy.

# Part 3 – Self-assessment

Part 3 progress

# 0/5

[ ]OAuth 2.0 and OpenID Connect

[ ]Resilience4j configuration

[ ]High CPU and memory troubleshooting

[ ]Kubernetes deployments and probes

[ ]Redis caching

# Next: Part 4 – Final Senior-Level Interview Preparation

The remaining five checklist topics:

1. Distributed tracing using Micrometer, OpenTelemetry and Jaeger.
2. Monolith vs Modular Monolith vs Microservices architecture.
3. Production incident management and root-cause analysis.
4. Backward-compatible REST API and Kafka event changes.
5. Deployment strategies: Rolling, Blue-Green, Canary and rollback.

These five topics complete your original 20-point Senior Java Developer interview checklist.

---
# Microservices Interview Questions: Scaling, Throughput, Latency, Performance & Distributed Tracing

Below is a curated set of microservices interview questions from basic to advanced level, covering system design, production troubleshooting, performance optimization, and real-world scenarios. These are especially useful for backend engineers, Java/Spring Boot developers, SREs, and architects.

## 1. Scaling in Microservices

Focus: horizontal scaling, vertical scaling, load balancing, autoscaling, bottlenecks, and resilience.

### Basic questions

1. What is scaling in microservices, and why is it required?
2. What is the difference between horizontal scaling and vertical scaling?
3. What are the advantages of horizontal scaling over vertical scaling?
4. How does a load balancer distribute requests across multiple service instances?
5. What is the difference between scaling a monolith and scaling microservices?
6. What is a stateless service, and why is statelessness important for scaling?
7. How do Docker and Kubernetes help scale microservices?
8. What is auto-scaling, and which metrics can trigger it?

### Intermediate questions

9. How do you scale a service when CPU utilization is low but response times are high?
10. How would you scale a microservice that depends on a single database?
11. How do you handle session management when scaling service instances horizontally?
12. What challenges arise when scaling services that maintain local caches?
13. How do you prevent a thundering herd problem during scale-out?
14. How do Kubernetes Horizontal Pod Autoscaler (HPA) and Vertical Pod Autoscaler (VPA) differ?
15. How would you scale a service with uneven traffic across different endpoints?
16. How do you handle database connection pool limits when increasing the number of service instances?

### Advanced and scenario-based questions

17. A service handles 1,000 requests per second on four instances. How would you estimate the number of instances needed for 5,000 requests per second?
18. Your service scales from 5 to 30 pods, but throughput barely improves. What could be the reason?
19. A service scales out successfully, but its downstream database becomes overloaded. How would you solve this?
20. How would you design auto-scaling for unpredictable traffic spikes?
21. How would you scale a stateful microservice that cannot easily be made stateless?
22. How would you prevent cascading failures during simultaneous scale-out across multiple services?
23. How do you scale consumers in a Kafka-based microservices architecture?
24. How would you identify whether the bottleneck is CPU, memory, network, database, or a downstream service?

## 2. Throughput in Microservices

Focus: requests per second, transactions per second, concurrency, queues, batching, and capacity planning.

### Basic questions

1. What is throughput in a microservices architecture?
2. What is the difference between throughput, latency, and response time?
3. What is the difference between requests per second (RPS) and transactions per second (TPS)?
4. What factors affect the throughput of a microservice?
5. How do you measure throughput in a Spring Boot application?
6. What is concurrency, and how does it affect throughput?
7. What is the difference between synchronous and asynchronous processing in terms of throughput?
8. How do thread pools affect throughput?

### Intermediate questions

9. Why might adding more threads reduce throughput?
10. How do database connection pools influence application throughput?
11. How does connection pooling improve throughput?
12. How can caching increase throughput?
13. How does batching improve throughput in REST APIs, databases, or Kafka consumers?
14. What is backpressure, and how does it protect a service under heavy load?
15. How do message queues help absorb traffic spikes?
16. How do you calculate the maximum sustainable throughput of a service?
17. How can rate limiting affect throughput and system stability?
18. How do you distinguish between peak throughput and sustainable throughput?

### Advanced and scenario-based questions

19. Your service receives 10,000 RPS but processes only 6,000 RPS. How would you investigate the bottleneck?
20. A service's throughput decreases as concurrent users increase. What are the possible causes?
21. How would you improve throughput without increasing the number of service instances?
22. Your Kafka consumer lag keeps increasing even though consumer CPU usage is low. What would you investigate?
23. How would you calculate the number of Kafka consumers required to handle a target event rate?
24. How do you prevent a slow downstream service from reducing the throughput of the entire system?
25. How would you design a service to handle 50,000 RPS with predictable resource usage?
26. How do you determine whether a throughput bottleneck is caused by lock contention, thread starvation, database queries, or network I/O?

## 3. Latency in Microservices

Focus: p50/p95/p99, network overhead, tail latency, timeouts, retries, and service dependencies.

### Basic questions

1. What is latency in microservices?
2. What is the difference between latency and response time?
3. What are p50, p90, p95, and p99 latency?
4. Why is average latency insufficient for production monitoring?
5. What factors contribute to latency in a distributed system?
6. How does network latency affect communication between microservices?
7. What is the difference between client-side and server-side latency?
8. How do synchronous REST calls affect end-to-end latency?

### Intermediate questions

9. Why can p99 latency increase even when average latency remains stable?
10. How do connection pooling and connection reuse reduce latency?
11. How do DNS lookup, TLS handshake, and TCP connection establishment contribute to latency?
12. How do database indexes and query plans affect API latency?
13. How do timeouts prevent requests from waiting indefinitely?
14. How can retries increase latency and worsen an outage?
15. How do caching and asynchronous processing reduce latency?
16. What is tail latency amplification in a fan-out request pattern?
17. How do thread pool exhaustion and garbage collection pauses affect latency?
18. How would you set timeout values across a chain of dependent services?

### Advanced and scenario-based questions

19. An API has a p50 latency of 50 ms but a p99 latency of 2 seconds. How would you investigate?
20. An endpoint takes 200 ms locally but 1.5 seconds in production. What would you check?
21. Service A calls B, C, and D sequentially. How could you reduce the total latency?
22. Service A calls five downstream services in parallel. Why could the overall latency still be high?
23. Your API latency suddenly doubles after a deployment, but CPU usage is unchanged. What could explain it?
24. How would you troubleshoot intermittent latency spikes that occur only during peak traffic?
25. How would you reduce latency when the database is geographically distant from the application?
26. How would you meet a 200 ms p99 latency SLO when some downstream dependencies take 500 ms?
27. When would you use asynchronous communication instead of synchronous calls to improve user-perceived latency?

## 4. Performance Optimization and Troubleshooting

Focus: profiling, JVM tuning, memory, garbage collection, thread pools, databases, and load testing.

### Basic questions

1. What does performance optimization mean in microservices?
2. What is the difference between application performance monitoring (APM) and infrastructure monitoring?
3. Which metrics would you monitor for a Spring Boot microservice?
4. How do CPU utilization, memory usage, and garbage collection affect performance?
5. What is the difference between CPU-bound and I/O-bound workloads?
6. What is profiling, and when would you use a profiler?
7. What is the difference between load testing, stress testing, soak testing, and spike testing?
8. How do you establish a performance baseline before optimization?

### Intermediate questions

9. How would you diagnose high CPU usage in a Java microservice?
10. How would you investigate frequent garbage collection or long GC pauses?
11. How can memory leaks occur in long-running microservices?
12. How do thread pools and connection pools affect performance?
13. How do N+1 database queries affect performance?
14. How do serialization and deserialization overheads affect API performance?
15. How can excessive logging reduce throughput?
16. How would you identify slow SQL queries?
17. How do HTTP keep-alive and connection reuse improve performance?
18. How would you optimize a service that spends most of its time waiting for external APIs?

### Advanced and scenario-based questions

19. After deployment, CPU utilization reaches 95% and response times rise sharply. How would you troubleshoot?
20. Memory usage steadily increases over 24 hours, eventually causing container restarts. How would you investigate?
21. A service performs well at 100 concurrent users but fails at 2,000. How would you identify the limiting resource?
22. An endpoint makes only three database queries but takes two seconds. How would you find the actual bottleneck?
23. How would you investigate thread starvation in a Java application?
24. How would you determine whether increasing the thread pool size would improve performance or make it worse?
25. Your application performs well in a load test but poorly in production. What differences would you examine?
26. How do you perform capacity planning using CPU, memory, latency, and throughput metrics?
27. How would you optimize a service while keeping error rates and p99 latency within their SLOs?

## 5. Distributed Tracing in Microservices

Focus: trace IDs, span IDs, context propagation, OpenTelemetry, sampling, trace visualization, and cross-service debugging.

Distributed Tracing: Following Requests Across Services

System Design Deep Dive: Building a Distributed Tracing Infrastructure

API Development Series Part 12: Monitoring & Analytics - Wasil Zafar

### Basic questions

1. What is distributed tracing, and why is it important in microservices?
2. What is the difference between logs, metrics, and traces?
3. What is a trace ID?
4. What is a span ID?
5. What is the difference between a trace and a span?
6. What are parent spans and child spans?
7. Why are correlation IDs useful in distributed systems?
8. What is the difference between distributed tracing and request logging?
9. What are OpenTelemetry, Jaeger, and Zipkin?
10. What information should a trace span contain?

### Intermediate questions

11. How does a trace ID propagate between services?
12. How does OpenTelemetry instrument a Spring Boot application?
13. How is tracing context propagated through HTTP headers?
14. What are W3C Trace Context and the `traceparent` header?
15. How do you propagate trace context through Kafka messages?
16. How do you trace asynchronous workflows?
17. What is trace sampling, and why is it needed?
18. What is the difference between head-based and tail-based sampling?
19. How can you correlate traces with application logs and metrics?
20. How do you identify the slowest span in a distributed trace?
21. What problems can occur when trace context is lost between services?
22. How do baggage and trace attributes differ?
23. What is the difference between instrumentation and context propagation?
24. How do you minimize the overhead and storage cost of distributed tracing?

### Advanced and scenario-based questions

25. A request passes through six microservices, but the trace shows only four. How would you troubleshoot the missing spans?
26. The trace ID changes between two services. What could cause this?
27. A trace shows that the API spends 80% of its time in one downstream service. How would you investigate further?
28. How would you trace a request that begins with an HTTP API, publishes a Kafka event, and finishes in an asynchronous consumer?
29. How would you investigate a request that times out at the gateway but completes successfully downstream?
30. How do retries, parallel calls, and asynchronous operations affect trace visualization?
31. How would you trace requests across services written in Java, Go, and Node.js?
32. How would you configure sampling to retain errors and slow requests without collecting every trace?
33. How do you avoid exposing credentials, personal data, or sensitive payloads in trace attributes?
34. How would you distinguish a genuine service bottleneck from instrumentation or clock-synchronization issues?

## 6. Integrated System Design and Production Scenarios

These questions combine scaling, throughput, latency, performance, and tracing. They are particularly valuable for senior and lead-level interviews.

1. An e-commerce API experiences a tenfold traffic spike during a sale. How would you design it to scale without overwhelming the database?
2. A checkout request passes through an API gateway, order service, inventory service, payment service, and notification service. How would you measure and optimize end-to-end latency?
3. Your service meets its throughput target but violates its p99 latency SLO. What would you do?
4. A service is CPU-efficient but has low throughput and high latency. How would you diagnose it?
5. A downstream service becomes slow, causing thread pools to fill up across several upstream services. How would you prevent cascading failure?
6. How would you combine distributed tracing, metrics, and logs to troubleshoot a production incident?
7. How would you design an observability dashboard for 100 microservices?
8. How would you determine whether to scale a service, optimize its code, tune its database, or introduce caching?
9. A deployment increases error rates and p99 latency, but average latency remains unchanged. How would you investigate and roll back safely?
10. How would you design a resilient API with a 99.99% availability target and a strict latency budget?
11. How would you perform capacity planning for a system expecting traffic to grow from 5,000 to 50,000 RPS?
12. How would you diagnose a production incident when CPU, memory, and request counts look normal but users report slow responses?
13. How would you design graceful degradation when a recommendation service or notification service is unavailable?
14. How would you use load testing and distributed tracing together to identify the true system bottleneck?
15. How would you define and monitor SLIs, SLOs, and error budgets for a critical microservice?

## 7. Practical Numerical and Troubleshooting Questions

These are useful because interviewers often expect you to calculate, reason, and explain trade-offs rather than simply define terms.

| Question | Concept tested |
| --- | --- |
| A service handles 2,000 RPS with 100 ms average response time. Estimate average in-flight requests. | Little's Law |
| A request takes 20 ms in A, 80 ms in B, and 150 ms in C sequentially. What is the minimum expected end-to-end latency, ignoring overhead? | Latency budgeting |
| A service processes 500 events/sec, but 800 events/sec arrive. How quickly does consumer lag grow? | Queue growth |
| One instance sustains 400 RPS. How many instances are theoretically needed for 4,000 RPS? What safety margin would you add? | Capacity planning |
| A downstream service has a p99 latency of 800 ms. What happens if an upstream timeout is 500 ms? | Timeouts and tail latency |
| A service's error rate rises from 0.1% to 5% after scaling. What would you investigate? | Resource contention and dependencies |
| A trace shows 50 ms in the API, 20 ms in service B, and 700 ms in a database span. Where would you start? | Trace analysis |
| A service has 16 CPU cores but runs 200 application threads. How would you determine whether this is appropriate? | Concurrency and thread pools |
| A Kafka topic has 12 partitions and 24 consumers in one consumer group. How many consumers can actively consume assigned partitions at once? | Kafka partition parallelism |
| A service has a 99.9% availability SLO. How much downtime does that allow over 30 days? | SRE and SLO calculations |

## 8. Key concepts to prepare before the interview

Scaling and throughput

Horizontal scaling, load balancing, concurrency, autoscaling, Little's Law, queue depth, backpressure, and capacity planning.

Latency and performance

p95/p99 latency, timeout budgets, connection pools, caching, profiling, JVM tuning, garbage collection, and database optimization.

Distributed tracing

Trace/span IDs, parent-child relationships, context propagation, OpenTelemetry, sampling, trace waterfalls, and trace-log-metric correlation.

Resilience and reliability

Circuit breakers, bulkheads, retries with backoff and jitter, rate limiting, graceful degradation, SLIs, SLOs, and error budgets.

## 9. Practice with answers

Choose the level you'd like, and I can provide the questions with detailed answers, real-world examples, architecture diagrams, and Java/Spring Boot implementation where relevant.

Interview preparation

Select your preferences to generate a focused question-and-answer set.

DifficultyBasic — fundamentals and definitions

Intermediate — implementation and troubleshooting

Advanced Advanced — production incidents and system design

Senior/Architect — trade-offs and architecture

TopicAll topics All five areas

Scaling and throughput

Latency and performance

Distributed tracing and observability

Production troubleshooting and system design

Answer formatShort answers for quick revision

Detailed answers Detailed answers with examples

Scenario-based answers with troubleshooting steps

Generate interview Q&A
