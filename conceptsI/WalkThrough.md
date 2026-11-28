Your answer covers the fundamental Kafka concepts well. However, for an interview, I would recommend making it more practical by explaining how you implemented the pipeline, the challenges you faced, and how you ensured reliability and scalability.

### Improved interview answer

"In my experience, I have worked on designing and implementing real-time streaming data pipelines using Apache Kafka. The primary objective was to ingest large volumes of data from multiple sources, process the events in real time, and deliver them to downstream applications or databases with minimal latency.

While designing a Kafka-based streaming pipeline, I focus on the following key considerations:

1. Topic Design: I create separate Kafka topics based on business events or data domains to ensure proper data organization and simplify consumption.

2. Partitioning: I select appropriate partition keys to distribute data evenly across partitions. This enables parallel processing and improves throughput while maintaining ordering for events with the same key.

3. Replication and Fault Tolerance: I configure replication factors, such as 3, to ensure data availability even if a broker fails. I also consider producer acknowledgments and minimum in-sync replicas for durability.

4. Consumer Groups: I use consumer groups to distribute workloads across multiple consumers and support horizontal scalability. I also manage consumer offsets carefully to prevent data loss or duplicate processing.

5. Schema Management: I use schema validation and, where appropriate, a Schema Registry with Avro, Protobuf, or JSON Schema to maintain compatibility between producers and consumers.

6. Error Handling and Retry Mechanisms: I implement retry strategies for transient failures and use Dead Letter Queues (DLQs) to isolate messages that repeatedly fail processing.

7. Monitoring and Performance: I monitor consumer lag, throughput, broker health, message processing latency, and disk utilization to identify bottlenecks and maintain pipeline performance.

8. Data Delivery Guarantees: I choose appropriate delivery semantics, such as at-most-once, at-least-once, or exactly-once processing, depending on business requirements. For at-least-once processing, I also implement idempotency to handle duplicate events.

Overall, my focus is on building a Kafka pipeline that is scalable, fault-tolerant, reliable, and capable of processing real-time data efficiently."

### Important follow-up interview questions

You should also prepare for these questions:

- How do you handle duplicate messages in Kafka?
- What happens when a Kafka consumer goes down?
- How do you manage consumer lag?
- What is the difference between Kafka partitions and consumer groups?
- How do you handle message failures and retries?
- How do you achieve exactly-once processing in Kafka?
- How do you monitor Kafka pipeline performance?
- How do you handle schema evolution?

Interview tip: Don't just explain Kafka concepts. Try to explain one real-world project scenario, including the data source, Kafka topics, producers, consumers, processing logic, destination, and challenges. This makes your answer much stronger and demonstrates hands-on experience.

In Kafka, duplicate messages can occur due to producer retries, consumer failures, offset commit issues, or network interruptions. I handle duplicate messages primarily through idempotent processing and proper offset management.

### Interview-ready answer

"In my experience, I handle duplicate messages in Kafka using the following approaches:

1. Idempotent Producer: I enable `enable.idempotence=true` in the Kafka producer configuration. This prevents duplicate writes caused by producer retries within the supported producer session and sequence-number mechanism.
2. Message Key: I assign a unique event ID or business key to every message so that consumers can identify duplicate events.
3. Idempotent Consumer: On the consumer side, I maintain a unique transaction ID or event ID in the database. Before processing a message, I check whether that event has already been processed. If it exists, I skip it.
4. Offset Management: I commit consumer offsets only after successful processing. This helps prevent message loss, although messages may be reprocessed if a failure occurs before the offset commit.
5. Database-Level Deduplication: I use unique constraints or upsert operations in the target database to ensure that processing the same event multiple times does not create duplicate records.
6. Exactly-Once Semantics: Where required, I use Kafka transactions and idempotent producers to achieve exactly-once processing within supported Kafka workflows. For external databases, I use transactional or idempotent processing patterns."

### Example scenario

Suppose Kafka receives an order event:

json

```json
{
  "event_id": "ORD12345",
  "customer_id": "C101",
  "amount": 5000
}
```

If the consumer processes this event but crashes before committing the offset, Kafka may deliver the same message again after recovery.

To handle this:

- Check whether `ORD12345` already exists in the processed-events table.
- If it exists, skip the duplicate.
- Otherwise, process the order and save its event ID.
- Commit the Kafka offset after successful processing.

### Important Kafka configurations

| Configuration | Purpose |
| --- | --- |
| `enable.idempotence=true` | Prevents duplicate writes from producer retries |
| `acks=all` | Waits for acknowledgment from all in-sync replicas |
| `max.in.flight.requests.per.connection` | Controls outstanding requests |
| `enable.auto.commit=false` | Allows manual offset management |

### Strong closing statement for interviews

"My approach is to combine producer-side idempotency, consumer-side deduplication, and careful offset management. I don't rely only on Kafka's exactly-once semantics because duplicate processing can still happen when integrating with external databases or services. Therefore, I make the entire processing workflow idempotent."

Remember: Kafka's idempotent producer prevents certain duplicate writes to Kafka, but it does not automatically prevent duplicate business operations in downstream systems.

Here is a practical Java Spring Boot example showing how to handle duplicate messages in Kafka using an Idempotent Consumer + Database Unique Constraint.

Let's assume Kafka receives order events, and we want to ensure the same order event is not processed twice.

## 1. Sample Kafka message

json

```json
{
  "eventId": "ORD12345",
  "customerId": "C101",
  "amount": 5000
}
```

The `eventId` uniquely identifies each event.

## 2. Kafka Producer configuration

Enable idempotence to prevent duplicate writes caused by producer retries.

java

```java
@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, String> producerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                   "localhost:9092");

        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                   StringSerializer.class);

        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                   StringSerializer.class);

        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);

        config.put(ProducerConfig.ACKS_CONFIG, "all");

        return new DefaultKafkaProducerFactory<>(config);
    }
}
```

## 3. Database Entity

We maintain a table to track processed events.

java

```java
@Entity
@Table(
    name = "processed_events",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "eventId")
    }
)
public class ProcessedEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String eventId;

    // Getters and setters
}
```

The unique constraint ensures that the same event ID cannot be inserted twice.

## 4. Repository

java

```java
public interface ProcessedEventRepository
        extends JpaRepository<ProcessedEvent, Long> {

    boolean existsByEventId(String eventId);
}
```

## 5. Kafka Consumer – Duplicate Handling

This is the most important part.

java

```java
@Service
public class OrderConsumer {

    @Autowired
    private ProcessedEventRepository repository;

    @Autowired
    private OrderService orderService;

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group"
    )
    @Transactional
    public void consume(OrderEvent event) {

        // Check whether event was already processed
        if (repository.existsByEventId(event.getEventId())) {

            System.out.println(
                "Duplicate message skipped: " + event.getEventId()
            );

            return;
        }

        // Process business logic
        orderService.processOrder(event);

        // Save processed event
        ProcessedEvent processed = new ProcessedEvent();

        processed.setEventId(event.getEventId());

        repository.save(processed);

        System.out.println("Order processed successfully");
    }
}
```

Important: The existence check alone is not sufficient under concurrent processing. The database unique constraint must be enforced, and the business operation and deduplication record should be committed in the same database transaction.

## 6. How does it work?

Kafka Topic

Order event: ORD12345

Kafka Consumer

Check event ID in database

New eventProcess order

Save event ID in DB

DuplicateSkip processing

No duplicate order

## 7. Example execution

Suppose Kafka delivers the same message three times.

| Message | Event ID | Consumer action |
| --- | --- | --- |
| 1 | ORD12345 | Process order |
| 2 | ORD12345 | Skip duplicate |
| 3 | ORD12345 | Skip duplicate |

Result: The order is created only once.

## 8. Important interview point

There are three different concepts you should understand:

| Approach | What it prevents |
| --- | --- |
| Idempotent Producer | Duplicate Kafka writes caused by producer retries |
| Idempotent Consumer | Duplicate business processing |
| Exactly-once semantics | Duplicate processing within supported transactional workflows |

One important production consideration: If your consumer updates an external database, commit the business update and processed-event record atomically. Configure manual offset acknowledgment after successful processing, and ensure the database transaction has completed before acknowledging the Kafka message.

### Interview follow-up question

What happens if your consumer processes the order successfully, but the application crashes before committing the Kafka offset?

Answer: Kafka redelivers the message after recovery. The consumer checks the event ID in the database, identifies that it has already been processed, and skips the business operation. This prevents duplicate order creation.

When a Kafka consumer goes down, Kafka handles the situation through a mechanism called Consumer Group Rebalancing.

Kafka automatically detects that the consumer is unavailable and redistributes its assigned partitions among the remaining active consumers in the same consumer group.

Let's understand this with a practical example.

## 1. What happens when a consumer goes down?

Suppose we have:

- Kafka topic: `order-topic`
- Number of partitions: 3
- Consumer group: `order-group`
- Consumers: C1, C2, C3

Initially, Kafka distributes partitions like this:

Before consumer failure

Consumer C1

Partition 0

Active

Consumer C2

Partition 1

Active

Consumer C3

Partition 2

Active

Consumer C2 goes down

Consumer C2

Failed

After consumer group rebalancing

Consumer C1

Partition 0

Partition 1

Active

Consumer C3

Partition 2

Active

Kafka redistributes the failed consumer's partition to another active consumer.

## 2. How does Kafka detect consumer failure?

Kafka uses a heartbeat mechanism.

Important consumer configurations:

| Configuration | Purpose |
| --- | --- |
| `heartbeat.interval.ms` | Frequency of consumer heartbeats |
| `session.timeout.ms` | Time Kafka waits before considering a consumer dead |
| `max.poll.interval.ms` | Maximum time between consumer poll calls |
| `enable.auto.commit` | Controls automatic offset commits |

For example:

properties

```properties
heartbeat.interval.ms=3000
session.timeout.ms=10000
max.poll.interval.ms=300000
enable.auto.commit=false
```

If Kafka does not receive heartbeats within the session timeout, it considers the consumer unavailable and initiates a rebalance.

Note: `max.poll.interval.ms` handles consumers that are alive but are not polling frequently enough. It is different from heartbeat-based failure detection.

## 3. What happens to messages that were not processed?

This is an important interview question.

Suppose:

1. Consumer C1 reads message 101.
2. C1 processes the message.
3. C1 crashes before committing the offset.
4. Kafka assigns the partition to C2.
5. C2 reads message 101 again.

The message can be processed again because the offset was not committed.

This is why we implement:

- Manual offset commits.
- Idempotent consumers.
- Duplicate message detection.
- Retry and error-handling mechanisms.

## 4. Java Spring Boot example

We can configure a Kafka consumer with manual acknowledgment.

java

```java
@Service
public class OrderConsumer {

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group"
    )
    public void consume(
        OrderEvent event,
        Acknowledgment acknowledgment) {

        try {

            // Process business logic
            processOrder(event);

            // Commit offset after successful processing
            acknowledgment.acknowledge();

        } catch (Exception e) {

            // Log error and allow configured
            // retry/error handler to handle failure
            throw e;
        }
    }

    private void processOrder(OrderEvent event) {
        System.out.println("Processing: " + event.getEventId());
    }
}
```

Configure manual acknowledgment:

properties

```properties
spring.kafka.consumer.enable-auto-commit=false

spring.kafka.listener.ack-mode=manual
```

In production, configure an appropriate retry and dead-letter topic strategy so that failed messages do not block processing indefinitely.

## 5. What if all Kafka consumers go down?

- Kafka retains messages according to the topic's retention configuration.
- No consumer processes messages while the group is inactive.
- When consumers restart, they resume from their committed offsets.
- Uncommitted messages may be delivered again.

## 6. Interview-ready answer

You can explain it like this:

"When a Kafka consumer goes down, Kafka detects the failure through its heartbeat mechanism. Once the consumer is considered unavailable, Kafka triggers a consumer group rebalance.

During rebalancing, the partitions assigned to the failed consumer are redistributed among the remaining active consumers in that group.

The new consumer continues processing from the last committed offset. If the previous consumer processed a message but crashed before committing its offset, that message may be delivered again.

To handle this situation, I use manual offset management, idempotent consumer logic, and proper retry mechanisms to prevent duplicate business processing and data loss.

Kafka also provides fault tolerance through partition replication, so the consumer can continue reading even if a broker failure occurs, provided an available replica can become the partition leader."

## 7. Important follow-up interview questions

Prepare these next:

1. What is consumer group rebalancing in Kafka?
2. What happens if a consumer crashes after processing a message but before committing the offset?
3. What is the difference between `session.timeout.ms` and `max.poll.interval.ms`?
4. How do you avoid frequent consumer rebalancing?
5. What happens when the number of consumers is greater than the number of partitions?
6. How do you handle a poison message that repeatedly fails?

My recommendation: Pay special attention to questions 2, 3, and 4. These are particularly useful for demonstrating practical Kafka troubleshooting knowledge.

Below are the 6 important Kafka consumer interview questions with practical Java Spring Boot examples, including explanations of what happens internally.

We'll use one common scenario throughout:

- Kafka topic: `order-topic`
- Partitions: 3
- Consumer group: `order-group`
- Technology: Java, Spring Boot, Apache Kafka

# 1. What is Consumer Group Rebalancing in Kafka?

Answer:

Consumer group rebalancing is the process by which Kafka redistributes topic partitions among consumers when the group membership or partition assignment changes.

Rebalancing happens when:

- A new consumer joins the group.
- An existing consumer goes down.
- A consumer leaves the group.
- Partitions are added to a topic.

### Example

Initially, we have three consumers and three partitions.

Before rebalancing

C1 → P0

Active

C2 → P1

Active

C3 → P2

Active

After C2 crashes

C1 P0, P1

C3 P2

### Java configuration

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group"
)
public void consume(String message) {
    System.out.println(
        "Consumer received: " + message
    );
}
```

Kafka automatically manages partition assignments through the consumer group coordinator.

Interview point: During a rebalance, some consumption may temporarily pause. Cooperative rebalancing can reduce unnecessary partition revocation and interruption.

# 2. What happens if a consumer crashes after processing a message but before committing the offset?

Answer:

Kafka may deliver the same message again because the offset was not committed.

This results in at-least-once processing.

### Example scenario

1. Consumer reads order `ORD101`.
2. Consumer processes the order successfully.
3. Application crashes before committing the offset.
4. Consumer restarts.
5. Kafka delivers `ORD101` again.

We can prevent duplicate business operations using idempotent consumer logic.

### Java code

First, create a processed-event repository.

java

```java
public interface ProcessedEventRepository
        extends JpaRepository<ProcessedEvent, Long> {

    boolean existsByEventId(String eventId);
}
```

Consumer implementation:

java

```java
@Service
public class OrderConsumer {

    @Autowired
    private ProcessedEventRepository repository;

    @Autowired
    private OrderService orderService;

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group"
    )
    @Transactional
    public void consume(
        OrderEvent event,
        Acknowledgment acknowledgment) {

        if (repository.existsByEventId(event.getEventId())) {

            System.out.println("Duplicate message detected");

            acknowledgment.acknowledge();
            return;
        }

        orderService.processOrder(event);

        ProcessedEvent processed = new ProcessedEvent();
        processed.setEventId(event.getEventId());

        repository.save(processed);

        acknowledgment.acknowledge();
    }
}
```

Configuration:

properties

```properties
spring.kafka.consumer.enable-auto-commit=false
spring.kafka.listener.ack-mode=manual
```

Important production detail: The order update and processed-event insertion must be committed atomically in the same database transaction. Enforce a unique constraint on `eventId` to handle concurrent duplicate deliveries. Also, make sure acknowledgment happens only after the database transaction commits; a transaction-aware listener/container configuration or an acknowledgment-after-commit pattern is preferable.

# 3. What is the difference between session.timeout.ms and max.poll.interval.ms?

Answer:

Both configurations help Kafka detect consumer problems, but they detect different situations.

| Configuration | Meaning |
| --- | --- |
| `session.timeout.ms` | Maximum time Kafka waits without receiving heartbeats |
| `heartbeat.interval.ms` | How frequently the consumer sends heartbeats |
| `max.poll.interval.ms` | Maximum time allowed between consumer poll calls |

### Example configuration

properties

```properties
heartbeat.interval.ms=3000
session.timeout.ms=10000
max.poll.interval.ms=300000
```

### Scenario A: Consumer crashes

- Consumer crashes unexpectedly.
- Heartbeats stop.
- Kafka waits for the session timeout.
- Kafka considers the consumer dead.
- Rebalancing starts.

### Scenario B: Consumer is alive but processing takes too long

Suppose the consumer receives 500 records and takes 10 minutes to process them without calling `poll()` again.

If `max.poll.interval.ms` is 5 minutes, Kafka considers the consumer to have exceeded its allowed processing interval and the group can rebalance.

### Java example

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group"
)
public void consume(OrderEvent event) throws Exception {

    // Simulating slow processing
    Thread.sleep(6000);

    System.out.println("Order processed");
}
```

If processing batches takes too long, tune `max.poll.interval.ms`, reduce `max.poll.records`, or move long-running work into a controlled processing architecture.

Interview point: Heartbeats indicate consumer liveness, while polling indicates that the consumer is making progress through its assigned records.

# 4. How do you avoid frequent consumer rebalancing?

Answer:

Frequent rebalancing affects throughput and increases processing latency.

I address this by:

1. Configuring appropriate heartbeat and session timeouts.
2. Keeping message processing time within the poll interval.
3. Using static membership where appropriate.
4. Using cooperative partition assignment.
5. Avoiding unnecessary consumer restarts.
6. Monitoring consumer lag and processing time.

### Java configuration

java

```java
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
            "localhost:9092"
        );

        config.put(
            ConsumerConfig.GROUP_ID_CONFIG,
            "order-group"
        );

        config.put(
            ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,
            false
        );

        config.put(
            ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG,
            "org.apache.kafka.clients.consumer.CooperativeStickyAssignor"
        );

        config.put(
            ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,
            300000
        );

        config.put(
            ConsumerConfig.MAX_POLL_RECORDS_CONFIG,
            100
        );

        return new DefaultKafkaConsumerFactory<>(config);
    }
}
```

For static membership, you can configure:

properties

```properties
spring.kafka.consumer.properties.group.instance.id=order-consumer-1
```

Each simultaneously active consumer must have a unique instance ID within the group.

Interview point: CooperativeStickyAssignor reduces the number of partitions that need to move during a rebalance, minimizing disruption.

# 5. What happens when the number of consumers is greater than the number of partitions?

Answer:

A partition can be assigned to only one consumer within a consumer group at a time.

Suppose:

- Topic has 3 partitions.
- Consumer group has 5 consumers.

Only 3 consumers can actively consume from those partitions. The remaining 2 consumers remain idle.

### Example

3 partitions, 5 consumers

C1

P0

Active

C2

P1

Active

C3

P2

Active

C4

No partition

Idle

C5

No partition

Idle

### Java example

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group",
    concurrency = "5"
)
public void consume(String message) {

    System.out.println(
        Thread.currentThread().getName()
        + " processing: " + message
    );
}
```

If the topic has only three partitions, at most three consumer instances can actively consume simultaneously in this group.

Interview point: To increase parallelism, increase the number of partitions, considering ordering requirements and broker capacity.

# 6. How do you handle poison messages that repeatedly fail?

Answer:

A poison message is a message that consistently fails processing due to invalid data, business rule violations, or unexpected formats.

For example, suppose Kafka receives an order with an invalid amount.

json

```json
{
  "eventId": "ORD105",
  "amount": -5000
}
```

If the consumer repeatedly fails on this message, it can block progress depending on the processing and error-handling strategy.

I handle this using:

- Retry mechanisms.
- Exponential backoff.
- Dead Letter Topics (DLT).
- Error logging and monitoring.

### Java Spring Boot example

java

```java
@Configuration
public class KafkaErrorConfig {

    @Bean
    public DefaultErrorHandler errorHandler(
            KafkaTemplate<Object, Object> template) {

        DeadLetterPublishingRecoverer recoverer =
            new DeadLetterPublishingRecoverer(template);

        ExponentialBackOffWithMaxRetries backOff =
            new ExponentialBackOffWithMaxRetries(3);

        backOff.setInitialInterval(1000);
        backOff.setMultiplier(2.0);
        backOff.setMaxInterval(10000);

        return new DefaultErrorHandler(
            recoverer,
            backOff
        );
    }
}
```

Register the error handler with the Spring Kafka listener container factory:

java

```java
@Bean
public ConcurrentKafkaListenerContainerFactory<String, String>
        kafkaListenerContainerFactory(
            ConsumerFactory<String, String> consumerFactory,
            DefaultErrorHandler errorHandler) {

    var factory =
        new ConcurrentKafkaListenerContainerFactory<String, String>();

    factory.setConsumerFactory(consumerFactory);

    factory.setCommonErrorHandler(errorHandler);

    return factory;
}
```

Now the flow is:

Kafka order-topic

Consumer processing

Processing failed

Retry 1 → Retry 2 → Retry 3

Dead Letter Topic (order-topic.DLT)

The failed message is moved to the DLT after retries are exhausted.

Note: In Spring Kafka, verify the DLT destination, producer permissions, and acknowledgment/recovery behavior. Also classify exceptions: permanent validation errors often should go directly to the DLT rather than being retried.

# Quick interview revision

| Interview question | Key concept |
| --- | --- |
| Consumer goes down | Heartbeat and rebalancing |
| Consumer crashes before offset commit | Message redelivery |
| Session timeout vs poll interval | Liveness vs polling progress |
| Frequent rebalancing | Cooperative assignment, static membership |
| More consumers than partitions | Extra consumers remain idle |
| Poison messages | Retry and DLT |

## Test your understanding

Kafka knowledge check

0/4 answered

1. A consumer processes an order successfully but crashes before committing its offset. What happens?

Kafka deletes the message

Kafka may deliver the message again

Kafka automatically skips the message

2. A topic has 4 partitions and 6 consumers in one group. How many can actively consume?

6

4

2

3. What is the purpose of a Dead Letter Topic?

Store messages that repeatedly fail processing

Increase partition count

Commit offsets automatically

4. What does max.poll.interval.ms control?

Heartbeat frequency

Maximum interval between poll calls

Kafka retention period

 Check answers

Next recommended topic: Kafka offset management in depth — `commitSync()`, `commitAsync()`, auto commit, manual acknowledgment, and how to avoid data loss in real-world Spring Boot applications.

---
Below are six important Kafka interview questions with practical explanations, real-world scenarios, and Java Spring Boot code examples.

We'll use a common e-commerce project scenario throughout:

- Kafka topic: `order-topic`
- Partitions: 3
- Consumer group: `order-group`
- Producers: Order Service
- Consumers: Payment Service and Notification Service
- Technology: Java, Spring Boot, Apache Kafka

# 1. How do you manage consumer lag?

## Interview answer

Consumer lag is the difference between the latest available offset in a Kafka partition and the consumer group's committed offset.

For example:

- Kafka has received 10,000 messages.
- Consumer has processed up to offset 8,000.
- Consumer lag is approximately 2,000 messages.

Consumer lag indicates that the consumer is not processing messages as quickly as they are being produced.

## How do I handle consumer lag?

1. Monitor consumer lag regularly.
2. Increase consumer concurrency if enough partitions are available.
3. Optimize business processing logic.
4. Increase the number of partitions when appropriate.
5. Tune batch size and polling configurations.
6. Identify slow database queries or external API calls.

## Java configuration example

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group",
    concurrency = "3"
)
public void consume(OrderEvent event) {

    orderService.processOrder(event);
}
```

With three partitions, concurrency of three allows up to three consumers to process partitions in parallel within the group.

### Consumer configuration

properties

```properties
spring.kafka.consumer.max-poll-records=100
spring.kafka.consumer.enable-auto-commit=false

spring.kafka.listener.ack-mode=manual
```

### Monitoring consumer lag using Kafka CLI

bash

```bash
kafka-consumer-groups.sh \
  --bootstrap-server localhost:9092 \
  --group order-group \
  --describe
```

Example output:

text

```text
GROUP       TOPIC        PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG
order-group order-topic  0          1000            1500            500
order-group order-topic  1          2000            2300            300
order-group order-topic  2          3000            4200            1200
```

Total lag = 500 + 300 + 1200 = 2,000 messages.

Interview point: I monitor consumer lag and processing latency. If lag continuously increases, I investigate whether the bottleneck is consumer processing, database performance, insufficient partitions, or external service latency.

# 2. What is the difference between Kafka partitions and consumer groups?

## Interview answer

A partition is a unit of parallelism and storage within a Kafka topic.

A consumer group is a collection of consumers that work together to consume messages from Kafka.

### Example

Suppose we have a topic with three partitions.

Kafka topic: order-topic

Partition 0

Partition 1

Partition 2

Consumer group: order-group

Consumer 1

Consumer 2

Consumer 3

One partition assigned to each consumer in this example.

### Important differences

| Partitions | Consumer groups |
| --- | --- |
| Divide a topic into smaller units | Group consumers together |
| Enable parallel processing | Enable workload distribution |
| Store messages | Consume messages |
| Determine maximum consumer parallelism per group | Maintain group-specific offsets |
| Can have replicas | Can have multiple independent groups |

### Java example: Two independent consumer groups

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "payment-group"
)
public void paymentConsumer(String message) {

    System.out.println("Payment: " + message);
}
```

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "notification-group"
)
public void notificationConsumer(String message) {

    System.out.println("Notification: " + message);
}
```

Here, both consumer groups receive the same topic events independently.

For example:

- Payment Service processes the order.
- Notification Service sends an email.
- Both maintain their own consumer offsets.

Interview point: Partitions provide parallelism, while consumer groups provide independent consumption and horizontal scaling.

# 3. How do you handle message failures and retries?

## Interview answer

In Kafka, message processing can fail because of database errors, network issues, invalid data, or external service failures.

I handle these failures using retry mechanisms, exponential backoff, exception handling, and Dead Letter Topics (DLT).

My approach is:

1. Retry temporary failures.
2. Use exponential backoff to avoid overwhelming downstream services.
3. Send permanently failed messages to a DLT.
4. Log error details for troubleshooting.
5. Monitor retry counts and DLT message volume.

## Java Spring Boot example

First, implement a Kafka consumer.

java

```java
@Service
public class OrderConsumer {

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group"
    )
    public void consume(OrderEvent event) {

        orderService.processOrder(event);

        System.out.println("Order processed");
    }

    @Autowired
    private OrderService orderService;
}
```

Now configure retries.

java

```java
@Configuration
public class KafkaErrorConfig {

    @Bean
    public DefaultErrorHandler errorHandler(
            KafkaTemplate<Object, Object> template) {

        DeadLetterPublishingRecoverer recoverer =
            new DeadLetterPublishingRecoverer(template);

        ExponentialBackOffWithMaxRetries backOff =
            new ExponentialBackOffWithMaxRetries(3);

        backOff.setInitialInterval(1000);
        backOff.setMultiplier(2.0);
        backOff.setMaxInterval(10000);

        return new DefaultErrorHandler(
            recoverer,
            backOff
        );
    }
}
```

Register this error handler with the listener container factory:

java

```java
factory.setCommonErrorHandler(errorHandler);
```

### How does it work?

Kafka: order-topic

Order Consumer

Processing failure

Retry 1 → Retry 2 → Retry 3

Dead Letter Topic

For example, if a database is temporarily unavailable, Kafka retries processing. If the message still fails after the configured attempts, it is published to the DLT.

Important: Configure exception classification carefully. Invalid messages usually should not be retried repeatedly. Also, the DLT publishing operation must succeed before the failed source record is considered recovered.

# 4. How do you achieve exactly-once processing in Kafka?

## Interview answer

Exactly-once processing means ensuring that a message's processing result is reflected only once, even when retries, failures, or application restarts occur.

Kafka supports exactly-once semantics through:

- Idempotent producers.
- Kafka transactions.
- Transactional offset commits.
- Idempotent consumer logic for external systems.

### Real-world example

Suppose an Order Service publishes an order event and a Payment Service consumes it.

We don't want the same payment transaction to be recorded twice if the producer retries or the consumer restarts.

## Step 1: Enable idempotent producer

java

```java
@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, String> producerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
            "localhost:9092"
        );

        config.put(
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
            StringSerializer.class
        );

        config.put(
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
            StringSerializer.class
        );

        config.put(
            ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,
            true
        );

        config.put(
            ProducerConfig.ACKS_CONFIG,
            "all"
        );

        return new DefaultKafkaProducerFactory<>(config);
    }
}
```

## Step 2: Configure Kafka transactions

java

```java
@Bean
public ProducerFactory<String, String> transactionalProducerFactory() {

    DefaultKafkaProducerFactory<String, String> factory =
        new DefaultKafkaProducerFactory<>(producerConfigs());

    factory.setTransactionIdPrefix("order-tx-");

    return factory;
}
```

Configure a Kafka transaction manager:

java

```java
@Bean
public KafkaTransactionManager<String, String>
        kafkaTransactionManager(
            ProducerFactory<String, String> factory) {

    return new KafkaTransactionManager<>(factory);
}
```

## Step 3: Process messages transactionally

Suppose we consume an order event, process it, and publish a payment event.

java

```java
@Service
public class PaymentConsumer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(
        topics = "order-topic",
        groupId = "payment-group"
    )
    @Transactional("kafkaTransactionManager")
    public void consume(String orderEvent) {

        // Process incoming order
        System.out.println("Processing order");

        // Publish payment event
        kafkaTemplate.send(
            "payment-topic",
            orderEvent
        );

        System.out.println("Payment event published");
    }
}
```

For a fully transactional consume-process-produce flow, configure the listener container to send consumed offsets to the Kafka transaction as part of the same transaction. The transaction-aware listener container and Kafka transaction manager handle this integration.

Also configure downstream consumers with:

properties

```properties
spring.kafka.consumer.properties.isolation.level=read_committed
```

This ensures they only read committed transactional messages.

### How does it work?

Order Topic

Payment Consumer

Kafka Transaction

Process event + publish payment + commit consumed offset

SuccessCommit

FailureAbort

Important interview point: Kafka transactions provide exactly-once semantics for Kafka-to-Kafka processing. If we update an external database, Kafka transactions alone cannot make that database update atomic with the Kafka offset. In that case, I use an idempotent consumer, database transactions, unique event IDs, or the transactional outbox pattern.

# 5. How do you monitor Kafka pipeline performance?

## Interview answer

I monitor Kafka pipeline performance using metrics, dashboards, logs, and alerts.

The important metrics I monitor include:

| Metric | Why it matters |
| --- | --- |
| Consumer lag | Identifies slow consumers |
| Producer throughput | Measures messages produced per second |
| Consumer throughput | Measures messages consumed per second |
| Processing latency | Measures message processing time |
| Broker CPU and memory | Identifies resource bottlenecks |
| Disk utilization | Helps prevent storage issues |
| Under-replicated partitions | Identifies replication problems |
| Request latency | Identifies broker/network bottlenecks |
| Failed messages | Identifies processing issues |

## Tools I use

Fichier:Prometheus software logo.svg - Wikisource

Prometheus

Collects Kafka and application metrics.

[Official website](<https://prometheus.io/?utm_source=chatgpt.com>)

Meet the Unit – OpenSTEM

Grafana

Creates dashboards and visualizes Kafka performance.

[Official website](<https://grafana.com/?utm_source=chatgpt.com>)

Running Kafka on Production. Apache Kafka is an open-source… | by Pradyumna Khawas | WorkIndia.in | Medium

Kafka JMX Metrics

Exposes broker, producer, and consumer metrics.

[Kafka monitoring documentation](<https://kafka.apache.org/documentation/?utm_source=chatgpt.com#monitoring>)

INSY2S | Dev Factory

Spring Boot Actuator and Micrometer

Exposes application health and performance metrics.

[Actuator metrics documentation](<https://docs.spring.io/spring-boot/reference/actuator/metrics.html?utm_source=chatgpt.com>)

## Java Spring Boot example

First, add dependencies:

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

Configure the application:

properties

```properties
management.endpoints.web.exposure.include=health,metrics,prometheus

management.endpoint.prometheus.access=unrestricted

management.prometheus.metrics.export.enabled=true
```

You can access application metrics through:

text

```text
http://localhost:8080/actuator/prometheus
```

### Custom message processing timer

We can also measure how long Kafka message processing takes.

java

```java
@Service
public class OrderConsumer {

    private final Timer processingTimer;

    public OrderConsumer(MeterRegistry registry) {

        this.processingTimer = Timer.builder(
            "kafka.order.processing.time"
        )
        .description("Order processing duration")
        .register(registry);
    }

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group"
    )
    public void consume(OrderEvent event) {

        processingTimer.record(() -> {
            orderService.processOrder(event);
        });
    }

    @Autowired
    private OrderService orderService;
}
```

Now Prometheus can scrape this metric, and Grafana can display the processing duration.

Interview point: I set alerts for continuously increasing consumer lag, high processing latency, broker failures, under-replicated partitions, and increasing DLT message counts.

# 6. How do you handle schema evolution in Kafka?

## Interview answer

Schema evolution means modifying the structure of messages over time without breaking existing Kafka producers and consumers.

For example, initially our order event looks like this:

Version 1

json

```json
{
  "orderId": "ORD101",
  "amount": 5000
}
```

Later, the business asks us to add a customer ID.

Version 2

json

```json
{
  "orderId": "ORD101",
  "amount": 5000,
  "customerId": "C101"
}
```

The challenge is that older consumers may not understand the new schema.

To handle this, I use a Schema Registry with Avro, Protobuf, or JSON Schema.

## Schema compatibility types

| Compatibility | Meaning |
| --- | --- |
| BACKWARD | New consumers can read old messages |
| FORWARD | Old consumers can read new messages |
| FULL | Both backward and forward compatible |
| NONE | No compatibility checks |

For most evolving event-driven systems, I prefer backward compatibility.

## Step 1: Define Avro schema

Create `order.avsc`.

Version 1

json

```json
{
  "type": "record",
  "name": "Order",
  "namespace": "com.example",
  "fields": [
    {
      "name": "orderId",
      "type": "string"
    },
    {
      "name": "amount",
      "type": "double"
    }
  ]
}
```

Version 2

Add a new field with a default value.

json

```json
{
  "type": "record",
  "name": "Order",
  "namespace": "com.example",
  "fields": [
    {
      "name": "orderId",
      "type": "string"
    },
    {
      "name": "amount",
      "type": "double"
    },
    {
      "name": "customerId",
      "type": ["null", "string"],
      "default": null
    }
  ]
}
```

The default value allows a new consumer to read older messages that don't contain `customerId`.

## Step 2: Configure Schema Registry

Add Maven dependencies (versions should be aligned with your Confluent Platform version):

xml

```xml
<dependency>
    <groupId>io.confluent</groupId>
    <artifactId>kafka-avro-serializer</artifactId>
    <version>${confluent.version}</version>
</dependency>
```

Configure the producer:

properties

```properties
spring.kafka.producer.bootstrap-servers=localhost:9092

spring.kafka.producer.value-serializer=io.confluent.kafka.serializers.KafkaAvroSerializer

spring.kafka.producer.properties.schema.registry.url=http://localhost:8081
```

Configure the consumer:

properties

```properties
spring.kafka.consumer.bootstrap-servers=localhost:9092

spring.kafka.consumer.value-deserializer=io.confluent.kafka.serializers.KafkaAvroDeserializer

spring.kafka.consumer.properties.schema.registry.url=http://localhost:8081

spring.kafka.consumer.properties.specific.avro.reader=true
```

## Step 3: Java producer example

java

```java
@Service
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void publishOrder() {

        Order order = Order.newBuilder()
            .setOrderId("ORD101")
            .setAmount(5000)
            .setCustomerId("C101")
            .build();

        kafkaTemplate.send(
            "order-topic",
            order.getOrderId(),
            order
        );
    }
}
```

## Step 4: Java consumer example

java

```java
@Service
public class OrderConsumer {

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group"
    )
    public void consume(Order order) {

        System.out.println(
            "Order ID: " + order.getOrderId()
        );

        System.out.println(
            "Amount: " + order.getAmount()
        );

        System.out.println(
            "Customer: " + order.getCustomerId()
        );
    }
}
```

### How does Schema Registry help?

Kafka Producer

Publishes Avro event

Schema Registry

Validates and manages schema versions

Kafka Topic

Stores serialized messages

Kafka Consumer

Deserializes using the schema version

Interview point: I use Schema Registry to maintain schema compatibility, prevent breaking changes, and allow producers and consumers to evolve independently.

One important detail: schema compatibility rules should be configured and enforced in Schema Registry. Adding a field with a default is a common backward-compatible Avro change, but the compatibility behavior also depends on the reader and writer schemas.

# Final interview revision: All six questions

| Question | Important concepts |
| --- | --- |
| Consumer lag | Offsets, throughput, scaling |
| Partitions vs consumer groups | Parallelism, independent consumption |
| Message failures | Retry, exponential backoff, DLT |
| Exactly-once processing | Idempotence, transactions |
| Pipeline monitoring | Prometheus, Grafana, Actuator |
| Schema evolution | Avro, Schema Registry, compatibility |

## Practical Kafka architecture to remember

🚀 From Chaos to Kafka: How Event-Driven Systems Changed the Way We Move Data | by Arpit Srivastav | Medium

[medium.com](<https://medium.com/%40arpitsrivastav15s/from-chaos-to-kafka-how-event-driven-systems-changed-the-way-we-move-data-2506ce71940d?utm_source=chatgpt.com>)

In a real-world project, you can explain the complete flow like this:

1. Order Service publishes events to Kafka.
2. Kafka stores events across multiple partitions.
3. Payment and Notification services consume events using independent consumer groups.
4. Consumers process messages and update their respective databases.
5. Retry mechanisms handle temporary failures.
6. Dead Letter Topics store permanently failed messages.
7. Schema Registry manages message compatibility.
8. Prometheus and Grafana monitor pipeline performance.

## My recommended interview preparation

Make sure you can explain these three scenarios with code:

- Scenario 1: Consumer crashes after processing a message. How do you avoid duplicate processing?
- Scenario 2: Consumer lag increases from 1,000 to 100,000 messages. How do you troubleshoot and fix it?
- Scenario 3: Producer changes the event schema, but older consumers are still running. How do you avoid breaking the application?

These scenarios demonstrate practical Kafka knowledge beyond simply knowing the terminology.

---

Here are the three real-world Kafka interview scenarios with Java Spring Boot code examples, including what happens, how to troubleshoot, and how to implement the solution.

# 1. Consumer crashes after processing a message. How do you avoid duplicate processing?

### Interview answer

Suppose a Kafka consumer receives an order event and successfully saves the order into the database. However, before committing the Kafka offset, the application crashes.

When the consumer restarts, Kafka may deliver the same message again.

To prevent duplicate business operations, I use:

- Unique event IDs.
- Idempotent consumer logic.
- Database unique constraints.
- Transactional database operations.
- Manual offset acknowledgment after successful processing.

### Step 1: Kafka message

json

```json
{
  "eventId": "EVT101",
  "orderId": "ORD101",
  "amount": 5000
}
```

### Step 2: Database entity

java

```java
@Entity
@Table(
    name = "processed_events",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_event_id",
            columnNames = "event_id"
        )
    }
)
public class ProcessedEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id", nullable = false)
    private String eventId;

    // Getters and setters
}
```

### Step 3: Repository

java

```java
public interface ProcessedEventRepository
        extends JpaRepository<ProcessedEvent, Long> {

    boolean existsByEventId(String eventId);
}
```

### Step 4: Service layer

java

```java
@Service
public class OrderService {

    @Autowired
    private ProcessedEventRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void processOrder(OrderEvent event) {

        if (repository.existsByEventId(event.getEventId())) {
            System.out.println("Duplicate event skipped");
            return;
        }

        Order order = new Order();

        order.setOrderId(event.getOrderId());
        order.setAmount(event.getAmount());

        orderRepository.save(order);

        ProcessedEvent processed = new ProcessedEvent();
        processed.setEventId(event.getEventId());

        repository.save(processed);
    }
}
```

### Step 5: Kafka consumer

java

```java
@Service
public class OrderConsumer {

    @Autowired
    private OrderService orderService;

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group"
    )
    public void consume(
            OrderEvent event,
            Acknowledgment acknowledgment) {

        try {

            orderService.processOrder(event);

            // Acknowledge after database transaction completes
            acknowledgment.acknowledge();

        } catch (Exception e) {

            System.out.println("Processing failed: " + e.getMessage());

            throw e;
        }
    }
}
```

Configuration:

properties

```properties
spring.kafka.consumer.enable-auto-commit=false
spring.kafka.listener.ack-mode=manual
```

Important: The service transaction must commit before the listener acknowledges the record. In Spring, a proxied transactional service call normally returns after its transaction commits. The database unique constraint is also essential because two concurrent deliveries can both pass the initial existence check.

### Expected result

| Delivery | Event ID | Result |
| --- | --- | --- |
| First | EVT101 | Order created |
| Second | EVT101 | Duplicate skipped |
| Third | EVT101 | Duplicate skipped |

Interview conclusion: I use database-level idempotency because Kafka can redeliver messages when an application crashes before committing offsets. This ensures the business operation happens only once.

# 2. Consumer lag increases from 1,000 to 100,000 messages. How do you troubleshoot and fix it?

### Interview answer

Consumer lag means the difference between the latest available Kafka offset and the consumer group's committed offset.

If lag increases continuously, it indicates that messages are arriving faster than consumers can process them.

I follow these steps:

1. Check consumer lag using Kafka CLI.
2. Check producer throughput versus consumer throughput.
3. Identify slow database queries or external API calls.
4. Check the number of topic partitions.
5. Increase consumer instances if sufficient partitions exist.
6. Optimize processing and use batch consumption where appropriate.
7. Monitor performance after scaling.

### Step 1: Check consumer lag

Execute:

bash

```bash
kafka-consumer-groups.sh \
  --bootstrap-server localhost:9092 \
  --group order-group \
  --describe
```

Example:

text

```text
GROUP        TOPIC        PARTITION  CURRENT-OFFSET  LOG-END-OFFSET  LAG
order-group  order-topic  0          10000           50000           40000
order-group  order-topic  1          15000           45000           30000
order-group  order-topic  2          20000           50000           30000
```

Total lag = 100,000 messages.

### Step 2: Increase consumer concurrency

Spring Boot allows concurrent Kafka listeners.

java

```java
@Service
public class OrderConsumer {

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group",
        concurrency = "3"
    )
    public void consume(OrderEvent event) {

        orderService.processOrder(event);
    }

    @Autowired
    private OrderService orderService;
}
```

If you increase concurrency to 6:

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group",
    concurrency = "6"
)
```

You can have up to six active consumer instances, provided there are enough partitions.

### Step 3: Optimize consumer configuration

properties

```properties
spring.kafka.consumer.max-poll-records=200

spring.kafka.consumer.fetch-min-size=1024

spring.kafka.consumer.enable-auto-commit=false

spring.kafka.listener.ack-mode=manual
```

These configurations help tune consumption. Actual performance should be measured because larger batches can increase memory use and processing time.

### Step 4: Optimize processing logic

A common problem is slow database operations.

Instead of processing records with inefficient individual queries, consider batch database operations where appropriate.

Example:

java

```java
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional
    public void processOrders(List<OrderEvent> events) {

        List<Order> orders = events.stream()
            .map(event -> {
                Order order = new Order();
                order.setOrderId(event.getOrderId());
                order.setAmount(event.getAmount());
                return order;
            })
            .toList();

        repository.saveAll(orders);
    }
}
```

You can configure a batch listener to receive multiple records:

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group",
    batch = "true"
)
public void consumeBatch(List<OrderEvent> events) {

    orderService.processOrders(events);
}
```

Configure the listener factory for batch mode and implement batch acknowledgment/error handling appropriately.

### Step 5: Monitor performance

Monitor:

- Consumer lag.
- Processing time per message.
- Database response time.
- Number of active consumers.
- Partition distribution.
- Failed messages.

Interview conclusion:

"If consumer lag increases from 1,000 to 100,000, I first identify the bottleneck rather than immediately increasing consumers. If processing capacity is insufficient, I optimize business logic, database operations, and consumer concurrency. If the number of partitions is limiting parallelism, I evaluate increasing partitions while considering ordering requirements."

# 3. Producer changes the event schema, but older consumers are still running. How do you avoid breaking the application?

### Interview answer

This situation is called schema evolution.

For example, initially the producer sends:

Version 1

json

```json
{
  "orderId": "ORD101",
  "amount": 5000
}
```

Later, the producer adds a new field:

Version 2

json

```json
{
  "orderId": "ORD101",
  "amount": 5000,
  "customerId": "C101"
}
```

Older consumers may not expect the new field.

I handle this using:

- Schema Registry.
- Avro or Protobuf serialization.
- Backward compatibility.
- Default values for new fields.
- Gradual producer and consumer deployment.

### Step 1: Define the old Avro schema

`order-v1.avsc`

json

```json
{
  "type": "record",
  "name": "Order",
  "namespace": "com.example",
  "fields": [
    {
      "name": "orderId",
      "type": "string"
    },
    {
      "name": "amount",
      "type": "double"
    }
  ]
}
```

### Step 2: Create the new schema

`order-v2.avsc`

json

```json
{
  "type": "record",
  "name": "Order",
  "namespace": "com.example",
  "fields": [
    {
      "name": "orderId",
      "type": "string"
    },
    {
      "name": "amount",
      "type": "double"
    },
    {
      "name": "customerId",
      "type": ["null", "string"],
      "default": null
    }
  ]
}
```

Notice that `customerId` has a default value.

This allows a new consumer to read old messages without the new field, assuming the schemas are compatible.

### Step 3: Configure Schema Registry

Maven dependency:

xml

```xml
<dependency>
    <groupId>io.confluent</groupId>
    <artifactId>kafka-avro-serializer</artifactId>
    <version>${confluent.version}</version>
</dependency>
```

Producer configuration:

properties

```properties
spring.kafka.producer.value-serializer=io.confluent.kafka.serializers.KafkaAvroSerializer

spring.kafka.producer.properties.schema.registry.url=http://localhost:8081
```

Consumer configuration:

properties

```properties
spring.kafka.consumer.value-deserializer=io.confluent.kafka.serializers.KafkaAvroDeserializer

spring.kafka.consumer.properties.schema.registry.url=http://localhost:8081

spring.kafka.consumer.properties.specific.avro.reader=true
```

### Step 4: Java producer

java

```java
@Service
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void publishOrder() {

        Order order = Order.newBuilder()
            .setOrderId("ORD101")
            .setAmount(5000)
            .setCustomerId("C101")
            .build();

        kafkaTemplate.send(
            "order-topic",
            order.getOrderId(),
            order
        );
    }
}
```

### Step 5: Java consumer

java

```java
@Service
public class OrderConsumer {

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group"
    )
    public void consume(Order order) {

        System.out.println(order.getOrderId());

        System.out.println(order.getAmount());

        System.out.println(order.getCustomerId());
    }
}
```

### How I deploy schema changes safely

1. Define the new schema and validate compatibility.
2. Deploy consumers that support both old and new messages.
3. Deploy the updated producer.
4. Monitor serialization and deserialization errors.
5. Remove old compatibility logic only after all older data and consumers are accounted for.

Interview conclusion:

"I use Schema Registry with Avro and backward-compatible schema changes. I add new fields with defaults and avoid removing or changing existing fields in ways that break old consumers. This allows independent deployments of producers and consumers."

# Quick interview revision

| Scenario | Solution |
| --- | --- |
| Consumer crashes | Idempotent consumer and manual offset management |
| Consumer lag increases | Optimize processing and scale consumers |
| Producer changes schema | Schema Registry and compatibility |
| Duplicate messages | Unique event ID and database constraint |
| Temporary processing failure | Retry with backoff |
| Permanent processing failure | Dead Letter Topic |

## Test your interview knowledge

1. Consumer lag increases continuously. What should you check first?

Immediately delete Kafka messages

Check producer and consumer throughput and processing bottlenecks

Disable all partitions

2. How do you prevent duplicate order creation?

Use a unique event ID and database transaction

Increase heartbeat interval

Increase topic retention

3. What is the purpose of an Avro default value?

Increase consumer concurrency

Support compatible schema evolution

Commit Kafka offsets

 Submit answers

My recommendation: For a Java Kafka developer interview, practice explaining these three scenarios by drawing the architecture and writing the consumer code. Interviewers often want to understand how you handle failures, duplicate processing, scaling, and backward compatibility in an actual production application.

---
# Apache Kafka properties and their usage – Complete interview guide

Apache Kafka has many configuration properties, but as a Java Spring Boot developer, you should understand four major categories:

1. Producer properties – Control how messages are published to Kafka.
2. Consumer properties – Control how messages are consumed.
3. Broker properties – Control Kafka server behavior.
4. Topic properties – Control partitioning, replication, retention, and storage.

There are also important Spring Boot and Spring Kafka listener properties.

I'll explain the commonly used properties with their purpose, practical values, Java configuration, and interview scenarios.

Note: This is a practical reference of commonly used and important properties, not literally every configuration exposed by every Kafka release. Defaults and availability can vary by Kafka version.

## 1. Kafka producer properties

Producer properties control how messages are sent from applications to Kafka brokers.

### A. Connection and serialization properties

| Property | Purpose | Example |
| --- | --- | --- |
| `bootstrap.servers` | Kafka broker addresses | `localhost:9092` |
| `key.serializer` | Serializes message key | `StringSerializer` |
| `value.serializer` | Serializes message value | `StringSerializer` |
| `client.id` | Identifies the producer | `order-producer` |
| `security.protocol` | Communication security protocol | `SASL_SSL` |

Example:

properties

```properties
bootstrap.servers=localhost:9092

key.serializer=org.apache.kafka.common.serialization.StringSerializer

value.serializer=org.apache.kafka.common.serialization.StringSerializer

client.id=order-producer
```

### B. Reliability and acknowledgment properties

These are particularly important for interviews.

| Property | Purpose | Recommended example |
| --- | --- | --- |
| `acks` | Controls broker acknowledgment | `all` |
| `enable.idempotence` | Prevents duplicate writes caused by producer retries | `true` |
| `retries` | Number of send retries | High/default managed |
| `delivery.timeout.ms` | Maximum time allowed for delivery | `120000` |
| `request.timeout.ms` | Request acknowledgment timeout | `30000` |
| `max.in.flight.requests.per.connection` | Maximum unacknowledged requests | `5` |

1. acks

Controls how many acknowledgments the producer waits for.

- `acks=0`: Producer does not wait for acknowledgment.
- `acks=1`: Leader broker acknowledges the message.
- `acks=all`: All current in-sync replicas acknowledge the message.

2. enable.idempotence

properties

```properties
enable.idempotence=true
```

Prevents duplicate Kafka log entries caused by retries within the producer's supported idempotence mechanism.

3. retries

properties

```properties
retries=2147483647
```

Allows retries for retriable errors. Actual delivery remains bounded by `delivery.timeout.ms`.

4. delivery.timeout.ms

properties

```properties
delivery.timeout.ms=120000
```

Maximum time for a record to be successfully acknowledged, including batching and request waiting.

### C. Performance and batching properties

| Property | Purpose | Example |
| --- | --- | --- |
| `batch.size` | Maximum batch size in bytes | `16384` |
| `linger.ms` | Time to wait for additional messages | `5` |
| `buffer.memory` | Total producer buffer memory | `33554432` |
| `compression.type` | Message compression | `lz4` |
| `max.block.ms` | Maximum blocking time for send/buffer allocation | `60000` |
| `max.request.size` | Maximum request size | `1048576` |

Example:

properties

```properties
batch.size=32768
linger.ms=10
buffer.memory=67108864
compression.type=lz4
```

Explanation:

- `batch.size`: Larger batches can improve throughput.
- `linger.ms`: Gives the producer time to collect more records.
- `buffer.memory`: Controls memory available for buffering.
- `compression.type`: Reduces network and storage usage.

### D. Message delivery and partition properties

| Property | Purpose |
| --- | --- |
| `partitioner.class` | Controls partition selection |
| `key.serializer` | Serializes partitioning key |
| `interceptor.classes` | Configures producer interceptors |
| `transactional.id` | Identifies a transactional producer |
| `transaction.timeout.ms` | Maximum transaction duration |

Example:

properties

```properties
transactional.id=order-producer-tx
enable.idempotence=true
```

`transactional.id` enables transactional producer behavior when configured appropriately.

## 2. Kafka consumer properties

Consumer properties control how messages are retrieved and processed.

### A. Connection and deserialization properties

| Property | Purpose | Example |
| --- | --- | --- |
| `bootstrap.servers` | Broker addresses | `localhost:9092` |
| `group.id` | Consumer group identity | `order-group` |
| `key.deserializer` | Converts key bytes into Java objects | `StringDeserializer` |
| `value.deserializer` | Converts value bytes into Java objects | `StringDeserializer` |
| `client.id` | Identifies consumer | `order-consumer` |
| `group.instance.id` | Static consumer membership identity | `consumer-1` |

Example:

properties

```properties
bootstrap.servers=localhost:9092

group.id=order-group

key.deserializer=org.apache.kafka.common.serialization.StringDeserializer

value.deserializer=org.apache.kafka.common.serialization.StringDeserializer
```

### B. Offset management properties

These are among the most important Kafka interview topics.

| Property | Purpose | Example |
| --- | --- | --- |
| `enable.auto.commit` | Enables automatic offset commits | `false` |
| `auto.commit.interval.ms` | Automatic commit interval | `5000` |
| `auto.offset.reset` | Starting position when no valid offset exists | `earliest` |
| `isolation.level` | Controls visibility of transactional messages | `read_committed` |

1. enable.auto.commit

properties

```properties
enable.auto.commit=false
```

Disables automatic offset commits, allowing application-controlled acknowledgment.

2. auto.offset.reset

properties

```properties
auto.offset.reset=earliest
```

Controls where consumption starts when the group has no valid committed offset.

| Value | Meaning |
| --- | --- |
| `earliest` | Start from the earliest retained offset |
| `latest` | Start from the latest offset |
| `none` | Throw an exception if no valid offset exists |

Important: It does not reset an existing valid committed offset.

3. isolation.level

properties

```properties
isolation.level=read_committed
```

- `read_uncommitted`: Can read transactional and non-transactional records, including aborted transactional records.
- `read_committed`: Reads only committed transactional records, along with eligible non-transactional records.

### C. Consumer polling properties

| Property | Purpose | Example |
| --- | --- | --- |
| `max.poll.records` | Maximum records returned by one poll | `500` |
| `max.poll.interval.ms` | Maximum interval between poll calls | `300000` |
| `fetch.min.bytes` | Minimum amount of data requested per fetch | `1` |
| `fetch.max.bytes` | Maximum data returned in a fetch request | `52428800` |
| `max.partition.fetch.bytes` | Maximum fetch size per partition | `1048576` |
| `fetch.max.wait.ms` | Maximum wait for fetch data | `500` |

Example:

properties

```properties
max.poll.records=100
max.poll.interval.ms=300000
fetch.min.bytes=1024
fetch.max.wait.ms=500
```

Use these properties to balance throughput, latency, and memory consumption.

### D. Heartbeat and consumer failure detection properties

| Property | Purpose | Example |
| --- | --- | --- |
| `heartbeat.interval.ms` | Frequency of heartbeats | `3000` |
| `session.timeout.ms` | Time without heartbeat before failure detection | `10000` |
| `max.poll.interval.ms` | Maximum time between poll calls | `300000` |
| `group.instance.id` | Static membership | `order-consumer-1` |

Example:

properties

```properties
heartbeat.interval.ms=3000

session.timeout.ms=10000

max.poll.interval.ms=300000
```

Remember:

- Heartbeats detect consumer liveness.
- Session timeout determines when a missing consumer is considered unavailable.
- Poll interval detects consumers that fail to continue polling.

### E. Partition assignment properties

| Property | Purpose |
| --- | --- |
| `partition.assignment.strategy` | Controls partition assignment |
| `group.protocol` | Selects the consumer group protocol where supported |
| `group.remote.assignor` | Configures remote assignment strategy for the applicable group protocol |

Common assignment strategies include:

- `RangeAssignor`
- `RoundRobinAssignor`
- `StickyAssignor`
- `CooperativeStickyAssignor`

Example:

properties

```properties
partition.assignment.strategy=org.apache.kafka.clients.consumer.CooperativeStickyAssignor
```

Cooperative assignment can reduce unnecessary partition movement during rebalancing.

## 3. Kafka broker properties

Broker properties are configured on the Kafka server, usually in `server.properties`.

They control how Kafka stores messages, handles replication, manages network connections, and recovers from failures.

### A. Broker identification and networking

| Property | Purpose | Example |
| --- | --- | --- |
| `broker.id` | Unique broker identifier in older ZooKeeper-based clusters | `1` |
| `node.id` | Unique node identifier in KRaft clusters | `1` |
| `listeners` | Network endpoints where broker listens | `PLAINTEXT://:9092` |
| `advertised.listeners` | Addresses clients use to reach broker | `PLAINTEXT://localhost:9092` |
| `log.dirs` | Kafka log storage directories | `/tmp/kafka-logs` |
| `num.network.threads` | Network request handling threads | `3` |
| `num.io.threads` | Disk I/O request threads | `8` |
| `socket.send.buffer.bytes` | TCP send buffer size | `102400` |
| `socket.receive.buffer.bytes` | TCP receive buffer size | `102400` |
| `socket.request.max.bytes` | Maximum request size | `104857600` |

Example:

properties

```properties
node.id=1

listeners=PLAINTEXT://:9092

advertised.listeners=PLAINTEXT://localhost:9092

log.dirs=/var/lib/kafka/data

num.network.threads=3

num.io.threads=8
```

Note: `node.id` is used in KRaft mode. Older ZooKeeper-based deployments use `broker.id`.

### B. Replication and fault tolerance

| Property | Purpose | Example |
| --- | --- | --- |
| `default.replication.factor` | Default replication factor for automatically created topics | `3` |
| `min.insync.replicas` | Minimum in-sync replicas required for successful writes with `acks=all` | `2` |
| `unclean.leader.election.enable` | Allows an out-of-sync replica to become leader | `false` |
| `replica.lag.time.max.ms` | Time used to determine replica lag | `30000` |
| `offsets.topic.replication.factor` | Replication factor for consumer offset topic | `3` |
| `transaction.state.log.replication.factor` | Replication factor for transaction state topic | `3` |
| `transaction.state.log.min.isr` | Minimum ISR for transaction state log | `2` |

Example production configuration:

properties

```properties
default.replication.factor=3

min.insync.replicas=2

unclean.leader.election.enable=false

offsets.topic.replication.factor=3

transaction.state.log.replication.factor=3

transaction.state.log.min.isr=2
```

Interview scenario:

Suppose a topic has three replicas:

- Broker 1: Leader
- Broker 2: Follower
- Broker 3: Follower

If the leader fails, Kafka can elect an eligible in-sync replica as the new leader.

With `min.insync.replicas=2` and producer `acks=all`, Kafka requires at least two in-sync replicas for the write to succeed.

### C. Storage and retention properties

| Property | Purpose | Example |
| --- | --- | --- |
| `log.retention.hours` | Default log retention duration | `168` |
| `log.retention.bytes` | Maximum retained log size per partition | `1073741824` |
| `log.segment.bytes` | Maximum log segment size | `1073741824` |
| `log.segment.ms` | Maximum segment age before rolling | `604800000` |
| `log.cleanup.policy` | Log cleanup strategy | `delete` |
| `log.retention.check.interval.ms` | Frequency of retention checks | `300000` |
| `log.dirs` | Data storage location | `/var/lib/kafka/data` |

For example:

properties

```properties
log.retention.hours=168

log.segment.bytes=1073741824

log.retention.check.interval.ms=300000
```

`168` hours means seven days.

### D. Performance and resource properties

| Property | Purpose |
| --- | --- |
| `num.partitions` | Default partition count for automatically created topics |
| `num.replica.fetchers` | Number of threads used to replicate data |
| `queued.max.requests` | Maximum queued requests before network threads block |
| `background.threads` | Background processing threads |
| `compression.type` | Broker-side compression configuration where applicable |
| `message.max.bytes` | Maximum record batch size accepted by the broker |

## 4. Kafka topic properties

Topic properties control how individual topics store and manage messages.

These are configured when creating or altering topics.

| Property | Purpose | Example |
| --- | --- | --- |
| `partitions` | Number of topic partitions | `3` |
| `replication.factor` | Number of replicas | `3` |
| `retention.ms` | Message retention time | `604800000` |
| `retention.bytes` | Maximum retained size per partition | `1073741824` |
| `cleanup.policy` | Retention or compaction strategy | `delete` |
| `min.insync.replicas` | Minimum ISR for `acks=all` writes | `2` |
| `segment.bytes` | Segment size | `1073741824` |
| `max.message.bytes` | Maximum record batch size | `1000000` |
| `delete.retention.ms` | Tombstone retention in compacted topics | `86400000` |

### A. cleanup.policy

Two important options:

1. delete

Kafka deletes old log segments according to retention policies.

properties

```properties
cleanup.policy=delete
```

Use cases:

- Application logs.
- Transaction events.
- Temporary event streams.

2. compact

Kafka retains the latest value for each key, subject to compaction.

properties

```properties
cleanup.policy=compact
```

Use cases:

- Customer profile updates.
- Product configuration.
- Latest account state.

### B. Create a topic using CLI

bash

```bash
kafka-topics.sh \
  --bootstrap-server localhost:9092 \
  --create \
  --topic order-topic \
  --partitions 3 \
  --replication-factor 3 \
  --config retention.ms=604800000 \
  --config min.insync.replicas=2
```

Describe the topic:

bash

```bash
kafka-topics.sh \
  --bootstrap-server localhost:9092 \
  --describe \
  --topic order-topic
```

Interview point: Partitions control parallelism, replication controls fault tolerance, and retention controls how long Kafka keeps messages.

## 5. Spring Boot Kafka properties

In a Spring Boot application, you generally configure Kafka using `application.properties` or `application.yml`.

Spring Boot maps these settings to the underlying Kafka client configuration.

### A. Producer Spring Boot properties

| Spring Boot property | Purpose |
| --- | --- |
| `spring.kafka.producer.bootstrap-servers` | Broker addresses |
| `spring.kafka.producer.key-serializer` | Key serialization |
| `spring.kafka.producer.value-serializer` | Value serialization |
| `spring.kafka.producer.acks` | Acknowledgment level |
| `spring.kafka.producer.retries` | Retry count |
| `spring.kafka.producer.batch-size` | Batch size |
| `spring.kafka.producer.buffer-memory` | Producer buffer memory |
| `spring.kafka.producer.compression-type` | Compression algorithm |
| `spring.kafka.producer.transaction-id-prefix` | Transactional producer prefix |

### B. Consumer Spring Boot properties

| Spring Boot property | Purpose |
| --- | --- |
| `spring.kafka.consumer.bootstrap-servers` | Broker addresses |
| `spring.kafka.consumer.group-id` | Consumer group |
| `spring.kafka.consumer.key-deserializer` | Key deserialization |
| `spring.kafka.consumer.value-deserializer` | Value deserialization |
| `spring.kafka.consumer.enable-auto-commit` | Automatic offset commit |
| `spring.kafka.consumer.auto-offset-reset` | Initial offset behavior |
| `spring.kafka.consumer.max-poll-records` | Records per poll |
| `spring.kafka.consumer.properties.max.poll.interval.ms` | Maximum interval between polls |
| `spring.kafka.consumer.properties.session.timeout.ms` | Session timeout |
| `spring.kafka.listener.ack-mode` | Listener acknowledgment mode |
| `spring.kafka.listener.concurrency` | Listener concurrency |

### C. Complete Spring Boot application.properties example

This is a useful starting configuration for an order-processing application.

properties

```properties
# ==================================
# KAFKA CONNECTION
# ==================================

spring.kafka.bootstrap-servers=localhost:9092

# ==================================
# PRODUCER CONFIGURATION
# ==================================

spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer

spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer

spring.kafka.producer.acks=all

spring.kafka.producer.retries=10

spring.kafka.producer.batch-size=32768

spring.kafka.producer.buffer-memory=67108864

spring.kafka.producer.compression-type=lz4

spring.kafka.producer.properties.enable.idempotence=true

# ==================================
# CONSUMER CONFIGURATION
# ==================================

spring.kafka.consumer.group-id=order-group

spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer

spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer

spring.kafka.consumer.auto-offset-reset=earliest

spring.kafka.consumer.enable-auto-commit=false

spring.kafka.consumer.max-poll-records=100

spring.kafka.consumer.properties.spring.json.trusted.packages=com.example.dto

spring.kafka.consumer.properties.max.poll.interval.ms=300000

spring.kafka.consumer.properties.session.timeout.ms=10000

spring.kafka.consumer.properties.heartbeat.interval.ms=3000

# ==================================
# LISTENER CONFIGURATION
# ==================================

spring.kafka.listener.ack-mode=manual

spring.kafka.listener.concurrency=3
```

Interview tip You should be able to explain why `acks=all`, `enable.idempotence=true`, and `enable-auto-commit=false` are commonly combined in reliability-focused applications.

## 6. Kafka security properties

These properties help secure communication between Kafka clients and brokers.

### A. Security protocol

| Property | Purpose |
| --- | --- |
| `security.protocol` | Defines communication security |
| `ssl.truststore.location` | Location of trusted certificates |
| `ssl.truststore.password` | Truststore password |
| `ssl.keystore.location` | Client certificate location |
| `ssl.keystore.password` | Keystore password |
| `sasl.mechanism` | Authentication mechanism |
| `sasl.jaas.config` | Authentication credentials/configuration |

Common security protocols:

| Protocol | Description |
| --- | --- |
| `PLAINTEXT` | No encryption or authentication |
| `SSL` | TLS encryption |
| `SASL_PLAINTEXT` | SASL authentication without TLS |
| `SASL_SSL` | SASL authentication with TLS |

Example:

properties

```properties
spring.kafka.properties.security.protocol=SASL_SSL

spring.kafka.properties.sasl.mechanism=PLAIN

spring.kafka.properties.sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule required username="user" password="password";
```

For production, keep credentials in a secrets manager or environment variables rather than committing them to configuration files.

## 7. Spring Kafka listener properties

These are especially useful when implementing consumers using `@KafkaListener`.

| Property / annotation | Purpose |
| --- | --- |
| `concurrency` | Number of listener consumer threads |
| `ack-mode` | Offset acknowledgment strategy |
| `poll-timeout` | Listener polling timeout |
| `batch` | Enable batch message consumption |
| `auto-startup` | Automatically start listener |
| `client-id-prefix` | Listener client identifier prefix |
| `missing-topics-fatal` | Fail startup when configured topics are missing |
| `idle-event-interval` | Frequency of idle consumer events |
| `@KafkaListener` | Declares a Kafka listener |
| `@RetryableTopic` | Configures non-blocking retry topics |

### Example: Listener concurrency

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group",
    concurrency = "3"
)
public void consume(String message) {

    System.out.println("Received: " + message);
}
```

This creates three consumer instances for the listener container.

If the topic has three partitions, each can consume one partition.

### Example: Batch listener

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group",
    batch = "true"
)
public void consumeBatch(List<String> messages) {

    for (String message : messages) {
        System.out.println(message);
    }
}
```

### Example: Retryable topic

java

```java
@RetryableTopic(
    attempts = "4",
    backoff = @Backoff(
        delay = 1000,
        multiplier = 2
    ),
    dltTopicSuffix = ".DLT"
)
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group"
)
public void consume(OrderEvent event) {

    orderService.processOrder(event);
}
```

This configures retry topics and a dead-letter topic. It is an alternative to the blocking `DefaultErrorHandler` approach discussed earlier; don't configure both approaches blindly for the same failure flow.

## 8. Kafka Streams properties

Kafka Streams is used for real-time stream processing, filtering, aggregation, joins, and transformations.

| Property | Purpose |
| --- | --- |
| `application.id` | Unique Kafka Streams application identity |
| `bootstrap.servers` | Kafka broker addresses |
| `processing.guarantee` | Processing guarantee |
| `commit.interval.ms` | Commit interval |
| `num.stream.threads` | Number of stream-processing threads |
| `state.dir` | Local state storage directory |
| `replication.factor` | Replication for internal topics |
| `default.key.serde` | Default key serializer/deserializer |
| `default.value.serde` | Default value serializer/deserializer |

Example:

properties

```properties
spring.kafka.streams.application-id=order-stream-app

spring.kafka.streams.bootstrap-servers=localhost:9092

spring.kafka.streams.properties.processing.guarantee=exactly_once_v2

spring.kafka.streams.properties.num.stream.threads=3
```

### Java example

java

```java
@Bean
public KStream<String, OrderEvent> orderStream(
        StreamsBuilder builder) {

    KStream<String, OrderEvent> stream =
        builder.stream("order-topic");

    stream.filter(
        (key, order) -> order.getAmount() > 1000
    )
    .to("high-value-orders");

    return stream;
}
```

This reads order events and sends orders with amounts greater than 1,000 to another Kafka topic.

# 9. Important Kafka properties – Quick revision sheet

These are the properties I recommend memorizing for interviews.

## Top 20 Kafka properties

Most useful for Java Kafka developer interviews

| Property | Main purpose |
| --- | --- |
| `bootstrap.servers` | Broker connection |
| `acks` | Producer acknowledgment |
| `enable.idempotence` | Producer deduplication |
| `retries` | Retry failed sends |
| `batch.size` | Producer batching |
| `linger.ms` | Batching delay |
| `compression.type` | Message compression |
| `buffer.memory` | Producer buffering |
| `group.id` | Consumer group |
| `enable.auto.commit` | Offset commits |
| `auto.offset.reset` | Initial offset selection |
| `max.poll.records` | Records per poll |
| `max.poll.interval.ms` | Polling timeout |
| `session.timeout.ms` | Consumer failure detection |
| `heartbeat.interval.ms` | Consumer heartbeats |
| `fetch.min.bytes` | Minimum fetch data |
| `isolation.level` | Transaction visibility |
| `replication.factor` | Data replication |
| `min.insync.replicas` | Minimum ISR |
| `retention.ms` | Message retention |

# 10. Real-world production configuration example

For an order-processing application, this is a reasonable starting point for the client-side reliability configuration.

Example configurationproperties

```properties
# =================================
# KAFKA CONNECTION
# =================================

spring.kafka.bootstrap-servers=broker1:9092,broker2:9092,broker3:9092

# =================================
# PRODUCER
# =================================

spring.kafka.producer.acks=all

spring.kafka.producer.properties.enable.idempotence=true

spring.kafka.producer.compression-type=lz4

spring.kafka.producer.batch-size=32768

spring.kafka.producer.properties.delivery.timeout.ms=120000

# =================================
# CONSUMER
# =================================

spring.kafka.consumer.group-id=order-group

spring.kafka.consumer.enable-auto-commit=false

spring.kafka.consumer.auto-offset-reset=earliest

spring.kafka.consumer.max-poll-records=100

spring.kafka.consumer.properties.max.poll.interval.ms=300000

spring.kafka.consumer.properties.session.timeout.ms=10000

spring.kafka.consumer.properties.heartbeat.interval.ms=3000

# =================================
# TRANSACTION VISIBILITY
# =================================

spring.kafka.consumer.properties.isolation.level=read_committed

# =================================
# LISTENER
# =================================

spring.kafka.listener.ack-mode=manual

spring.kafka.listener.concurrency=3
```

Important production notes:

- The three broker addresses provide bootstrap redundancy, not a guarantee of cluster availability.
- `acks=all` should be paired with an appropriate replication factor and `min.insync.replicas`.
- Use `read_committed` when consumers should not see aborted transactional records.
- Configure retries and DLT handling separately.
- For a transactional consume-process-produce workflow, use Kafka transaction management rather than assuming manual acknowledgment alone provides exactly-once processing.
- Tune batch size, concurrency, and polling values using actual workload measurements.

# 11. Official Kafka documentation

For the complete version-specific property lists, use these references:

- [Apache Kafka 4.4 – Complete configuration reference](<https://kafka.apache.org/44/configuration/?utm_source=chatgpt.com>)
- [Kafka producer configuration](<https://kafka.apache.org/44/configuration/producer-configs/?utm_source=chatgpt.com>)
- [Kafka consumer configuration](<https://kafka.apache.org/44/configuration/consumer-configs/?utm_source=chatgpt.com>)
- [Kafka broker configuration](<https://kafka.apache.org/44/configuration/broker-configs/?utm_source=chatgpt.com>)
- [Kafka topic configuration](<https://kafka.apache.org/44/configuration/topic-configs/?utm_source=chatgpt.com>)
- [Spring Kafka documentation](<https://docs.spring.io/spring-kafka/reference/?utm_source=chatgpt.com>)

## 12. Test your Kafka property knowledge

Kafka properties quiz

0/5 answered

1. Which property prevents duplicate writes caused by producer retries?

enable.auto.commit

enable.idempotence

auto.offset.reset

2. Which property controls the maximum interval between consumer poll calls?

session.timeout.ms

heartbeat.interval.ms

max.poll.interval.ms

3. What does acks=all mean?

No acknowledgment

Leader acknowledgment only

Acknowledgment from all current in-sync replicas

4. Which topic cleanup policy keeps the latest value for each key, subject to compaction?

delete

compact

earliest

5. Which property controls how many records are returned by a consumer poll?

max.poll.records

batch.size

retention.ms

 Check my answers

My recommendation for interview preparation: Focus especially on `acks`, `enable.idempotence`, `retries`, `linger.ms`, `batch.size`, `enable.auto.commit`, `auto.offset.reset`, `max.poll.records`, `max.poll.interval.ms`, `session.timeout.ms`, `heartbeat.interval.ms`, `replication.factor`, and `min.insync.replicas`.

If you understand these 15 properties with real-world examples, you will be able to answer most practical Kafka configuration questions in Java developer interviews.

---
# Kafka properties explained with types, usage, examples, and interview scenarios

In Kafka, properties are configuration settings that control how producers send messages, how consumers receive messages, and how brokers store and replicate data.

Let's focus on the 13 important properties you mentioned, including their types, typical values, usage, and practical Java Spring Boot examples.

## 1. Kafka producer properties

Producer properties control message publishing, reliability, retries, and performance.

### 1. `acks`

Type: StringPurpose: Determines how many broker acknowledgments the producer waits for before considering a message successfully sent.

| Value | Meaning | Reliability |
| --- | --- | --- |
| `0` | No acknowledgment required | Low |
| `1` | Leader broker acknowledges | Medium |
| `all` | All current in-sync replicas acknowledge | High |

Configuration:

properties

```properties
spring.kafka.producer.acks=all
```

Java example:

java

```java
config.put(
    ProducerConfig.ACKS_CONFIG,
    "all"
);
```

Real-world scenario:

Suppose we have three Kafka brokers:

- Broker 1: Leader
- Broker 2: Follower
- Broker 3: Follower

With `acks=all`, the producer waits for acknowledgment from the current in-sync replicas before considering the write successful.

Interview answer:

"I use `acks=all` in reliability-sensitive applications because it provides stronger durability, especially when combined with replication factor 3 and minimum in-sync replicas 2."

Note: `acks=all` does not necessarily mean every configured replica must acknowledge. It means all replicas currently in the ISR.

### 2. `enable.idempotence`

Type: BooleanPurpose: Prevents duplicate records in the Kafka log caused by producer retries.

Values:

- `true`
- `false`

Configuration:

properties

```properties
spring.kafka.producer.properties.enable.idempotence=true
```

Java example:

java

```java
config.put(
    ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,
    true
);
```

Real-world scenario:

Suppose a producer sends an order event:

json

```json
{
  "orderId": "ORD101",
  "amount": 5000
}
```

The broker writes the message, but the acknowledgment gets lost.

The producer retries. With idempotence enabled, Kafka uses producer IDs and sequence numbers to recognize duplicate producer writes.

Interview answer:

"I enable idempotence to prevent duplicate Kafka log entries caused by retries. However, I also implement consumer-side deduplication because producer idempotence does not prevent duplicate business operations in downstream systems."

### 3. `retries`

Type: IntegerPurpose: Specifies the number of retry attempts for retriable producer errors.

Example:

properties

```properties
spring.kafka.producer.retries=10
```

Java:

java

```java
config.put(
    ProducerConfig.RETRIES_CONFIG,
    10
);
```

Scenario:

1. Producer sends an order.
2. Broker is temporarily unavailable.
3. Producer attempts to resend.
4. Broker becomes available.
5. Message is successfully delivered.

Important: Retries are bounded by `delivery.timeout.ms`. A high retry count does not guarantee unlimited retrying.

Interview answer:

"I configure retries for temporary network and broker failures. I combine retries with idempotence and delivery timeout to ensure reliable message publishing."

### 4. `linger.ms`

Type: Integer (milliseconds)Purpose: Controls how long the producer waits for additional messages before sending a batch.

Example:

properties

```properties
spring.kafka.producer.properties.linger.ms=10
```

Java:

java

```java
config.put(
    ProducerConfig.LINGER_MS_CONFIG,
    10
);
```

Scenario:

Suppose the producer receives 100 messages.

Without batching, messages might be sent in smaller requests.

With `linger.ms=10`, the producer can wait up to 10 milliseconds for more messages to arrive, helping create larger batches.

Without batching

Msg 1

Msg 2

Msg 3

Msg 4

Messages may be sent in smaller requests.

With batching

Msg 1 + Msg 2 + Msg 3 + Msg 4

One batch

Potentially fewer network requests and better throughput.

Interview answer:

"I use `linger.ms` to improve producer throughput by allowing messages to accumulate into batches. Increasing it can improve throughput but may increase publishing latency."

### 5. `batch.size`

Type: Integer (bytes)Purpose: Defines the target maximum size of a batch for a single partition.

Default Kafka client value is generally 16 KB.

Configuration:

properties

```properties
spring.kafka.producer.batch-size=32768
```

Java:

java

```java
config.put(
    ProducerConfig.BATCH_SIZE_CONFIG,
    32768
);
```

Here, `32768` means 32 KB.

Scenario:

Suppose the producer is publishing many order events to the same partition.

A larger batch allows more records to be sent together.

Interview answer:

"I tune batch size based on message volume and throughput requirements. Larger batches can improve efficiency but increase memory consumption and may add latency."

Important: `linger.ms` and `batch.size` work together. A batch may be sent before reaching its size limit when the linger time expires or other conditions trigger sending.

## 2. Kafka consumer properties

Consumer properties control message retrieval, offset management, and consumer group health.

### 6. `enable.auto.commit`

Type: BooleanPurpose: Controls whether the consumer automatically commits offsets periodically.

Values:

- `true`
- `false`

Configuration:

properties

```properties
spring.kafka.consumer.enable-auto-commit=false
```

Java:

java

```java
config.put(
    ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,
    false
);
```

Scenario:

Suppose a consumer receives an order message and starts processing it.

If automatic offset commits happen before business processing finishes, a failure could result in the message not being reprocessed.

With manual offset management, the application can acknowledge the record after successful processing.

Java example:

java

```java
@KafkaListener(
    topics = "order-topic",
    groupId = "order-group"
)
public void consume(
        OrderEvent event,
        Acknowledgment acknowledgment) {

    orderService.processOrder(event);

    acknowledgment.acknowledge();
}
```

Configuration:

properties

```properties
spring.kafka.consumer.enable-auto-commit=false
spring.kafka.listener.ack-mode=manual
```

Interview answer:

"I generally disable auto commit for important business processing and acknowledge messages only after successful processing. This provides better control over offset management."

### 7. `auto.offset.reset`

Type: String / EnumPurpose: Defines where the consumer starts reading when it does not have a valid committed offset.

Values:

| Value | Usage |
| --- | --- |
| `earliest` | Start from the earliest retained message |
| `latest` | Start from new messages |
| `none` | Throw an exception if no valid offset exists |

Configuration:

properties

```properties
spring.kafka.consumer.auto-offset-reset=earliest
```

Java:

java

```java
config.put(
    ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
    "earliest"
);
```

Scenario:

Suppose a new consumer group starts reading `order-topic`.

- With `earliest`, it reads available historical messages.
- With `latest`, it starts with messages arriving after the consumer begins.
- With `none`, it fails if no valid offset exists.

Interview answer:

"I use earliest when a new consumer group needs to process historical data and latest when the application only needs newly arriving messages."

Important: This property does not override an existing valid committed offset.

### 8. `max.poll.records`

Type: IntegerPurpose: Specifies the maximum number of records returned in one consumer poll.

Default: 500 in standard Kafka consumer configurations.

Configuration:

properties

```properties
spring.kafka.consumer.max-poll-records=100
```

Java:

java

```java
config.put(
    ConsumerConfig.MAX_POLL_RECORDS_CONFIG,
    100
);
```

Scenario:

Suppose Kafka has 1,000 messages available.

With `max.poll.records=100`, a single poll returns at most 100 records.

The consumer can then process them before requesting more.

Interview answer:

"I tune max poll records according to processing time and memory requirements. Smaller batches can help when individual messages require expensive processing."

### 9. `max.poll.interval.ms`

Type: Integer (milliseconds)Purpose: Maximum allowed time between two consumer poll calls.

Default: 300,000 milliseconds (5 minutes).

Configuration:

properties

```properties
spring.kafka.consumer.properties.max.poll.interval.ms=300000
```

Java:

java

```java
config.put(
    ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,
    300000
);
```

Scenario:

Suppose the consumer polls 100 messages and takes 10 minutes to process them without polling again.

If the configured interval is 5 minutes, the consumer can exceed its allowed polling interval, triggering a group rebalance.

How to fix it:

- Reduce `max.poll.records`.
- Optimize processing logic.
- Increase `max.poll.interval.ms` if justified.
- Use a suitable processing architecture for long-running work.

Interview answer:

"I configure max.poll.interval.ms based on the maximum expected processing duration. If processing takes longer than the configured interval, Kafka can consider the consumer unhealthy from the group's perspective and trigger reassignment."

### 10. `session.timeout.ms`

Type: Integer (milliseconds)Purpose: Defines how long the broker waits without receiving heartbeats before considering a consumer failed.

Configuration:

properties

```properties
spring.kafka.consumer.properties.session.timeout.ms=10000
```

Java:

java

```java
config.put(
    ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,
    10000
);
```

Here, Kafka waits approximately 10 seconds without the required heartbeats before declaring the consumer unavailable, subject to group protocol and broker settings.

Scenario:

1. Consumer is running.
2. Consumer sends heartbeats.
3. Consumer application crashes.
4. Heartbeats stop.
5. Session timeout expires.
6. Kafka starts consumer group reassignment.

Interview answer:

"I use session.timeout.ms to control how quickly Kafka detects an unavailable consumer. A shorter timeout can improve failure detection but may cause unnecessary rebalancing during temporary network delays."

### 11. `heartbeat.interval.ms`

Type: Integer (milliseconds)Purpose: Controls how frequently the consumer sends heartbeats to the group coordinator under the classic consumer group protocol.

Configuration:

properties

```properties
spring.kafka.consumer.properties.heartbeat.interval.ms=3000
```

Java:

java

```java
config.put(
    ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG,
    3000
);
```

Scenario:

Suppose:

properties

```properties
heartbeat.interval.ms=3000
session.timeout.ms=10000
```

The consumer sends heartbeats approximately every 3 seconds.

If heartbeats stop and the session timeout expires, Kafka detects the failure.

Interview answer:

"I configure heartbeat interval lower than session timeout so Kafka can regularly detect consumer liveness. A commonly used starting point is approximately one-third of the session timeout."

Note: The classic heartbeat/session settings differ from the newer consumer group protocol, where some heartbeat timing is managed through broker-side group configuration.

## 3. Kafka broker and topic properties

These properties control replication and fault tolerance.

### 12. `replication.factor`

Type: IntegerPurpose: Defines how many copies of a partition Kafka maintains across brokers.

Example:

properties

```properties
default.replication.factor=3
```

Or create a topic:

bash

```bash
kafka-topics.sh \
  --bootstrap-server localhost:9092 \
  --create \
  --topic order-topic \
  --partitions 3 \
  --replication-factor 3
```

Scenario:

Suppose we have three brokers:

Topic: order-topic

Replication factor = 3

LeaderBroker 1

Partition 0

FollowerBroker 2

Partition 0

FollowerBroker 3

Partition 0

Each broker maintains a replica of the same partition.

If Broker 1 fails, Kafka can elect an eligible in-sync replica as the new leader.

Interview answer:

"I generally use replication factor 3 for production workloads when the cluster has enough brokers. It provides fault tolerance against broker failures."

### 13. `min.insync.replicas`

Type: IntegerPurpose: Defines the minimum number of in-sync replicas required for a successful write when the producer uses `acks=all`.

Configuration:

properties

```properties
min.insync.replicas=2
```

Scenario:

Suppose:

- Replication factor = 3.
- Minimum ISR = 2.
- Producer acknowledgment = `all`.

Scenario A: Three replicas in sync

Broker 1Broker 2Broker 3

Write succeedsScenario B: One replica unavailable, two in sync

Broker 1Broker 2Broker 3

Write can succeedScenario C: Only one replica in sync

Broker 1Broker 2Broker 3

Write fails with NotEnoughReplicas

Interview answer:

"I configure min.insync.replicas to ensure that Kafka does not acknowledge important writes when too few replicas are available. For example, replication factor 3 and min.insync.replicas 2 provide a good durability starting point."

## 4. All 13 properties – Quick revision table

| Property | Type | Typical value | Main usage |
| --- | --- | --- | --- |
| `acks` | String | `all` | Producer reliability |
| `enable.idempotence` | Boolean | `true` | Prevent producer retry duplicates |
| `retries` | Integer | `10` | Retry failed sends |
| `linger.ms` | Integer | `5–10` | Producer batching delay |
| `batch.size` | Integer (bytes) | `16384–32768` | Batch size |
| `enable.auto.commit` | Boolean | `false` | Manual offset control |
| `auto.offset.reset` | String | `earliest` | Initial offset position |
| `max.poll.records` | Integer | `100` | Records per poll |
| `max.poll.interval.ms` | Integer (ms) | `300000` | Maximum poll gap |
| `session.timeout.ms` | Integer (ms) | `10000` | Failure detection |
| `heartbeat.interval.ms` | Integer (ms) | `3000` | Heartbeat frequency |
| `replication.factor` | Integer | `3` | Replica count |
| `min.insync.replicas` | Integer | `2` | Minimum in-sync replicas |

These are illustrative starting values, not universal production defaults.

## 5. Complete Java configuration example

Here is how you can configure the important producer and consumer properties directly in Java.

java

```java

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, String> producerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
            "localhost:9092"
        );

        config.put(
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
            StringSerializer.class
        );

        config.put(
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
            StringSerializer.class
        );

        // Reliability
        config.put(ProducerConfig.ACKS_CONFIG, "all");
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        config.put(ProducerConfig.RETRIES_CONFIG, 10);

        // Performance
        config.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        config.put(ProducerConfig.BATCH_SIZE_CONFIG, 32768);

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
            "localhost:9092"
        );

        config.put(
            ConsumerConfig.GROUP_ID_CONFIG,
            "order-group"
        );

        config.put(
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class
        );

        config.put(
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
            StringDeserializer.class
        );

        // Offset management
        config.put(
            ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,
            false
        );

        config.put(
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
            "earliest"
        );

        // Polling
        config.put(
            ConsumerConfig.MAX_POLL_RECORDS_CONFIG,
            100
        );

        config.put(
            ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,
            300000
        );

        // Heartbeat and failure detection
        config.put(
            ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,
            10000
        );

        config.put(
            ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG,
            3000
        );

        return new DefaultKafkaConsumerFactory<>(config);
    }
}
```

Broker and topic settings such as replication factor and minimum ISR are configured separately on the Kafka cluster or individual topic, not in the producer factory.

## 6. Interview questions to practice

1. What happens if `acks=0`?
2. What is the difference between `acks=1` and `acks=all`?
3. How does `enable.idempotence` prevent duplicate messages?
4. What is the difference between `linger.ms` and `batch.size`?
5. What happens if `enable.auto.commit=true` and the consumer crashes?
6. What is the difference between `earliest` and `latest`?
7. What happens if `max.poll.interval.ms` is exceeded?
8. What is the difference between session timeout and heartbeat interval?
9. What happens if replication factor is 3 but only one replica is in sync?
10. What is the relationship between replication factor and minimum ISR?

The most important combination to remember for interviews:

properties

```properties
# Producer reliability
acks=all
enable.idempotence=true
retries=10

# Producer performance
linger.ms=10
batch.size=32768

# Consumer reliability
enable.auto.commit=false
auto.offset.reset=earliest

# Consumer performance
max.poll.records=100

# Consumer failure detection
max.poll.interval.ms=300000
session.timeout.ms=10000
heartbeat.interval.ms=3000

# Broker/topic reliability
replication.factor=3
min.insync.replicas=2
```

This configuration gives you a strong foundation for explaining Kafka reliability, performance, offset management, and fault tolerance in Java developer interviews.
