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

I can also prepare the complete collection as a question-and-answer interview preparation guide, with Java/Spring Boot examples and detailed real-world production scenarios.
