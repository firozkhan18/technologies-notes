```mermaid

graph TD;
    A[Eureka Service] -->|registers| B[Department Service]
    A -->|registers| C[Employee Service]
    A -->|registers| D[API Gateway]
    D -->|calls| B
    D -->|calls| C
    B -->|uses| E[Config Server]
    C -->|uses| E

graph TD;
    A[Orchestartor] -->|Saga| B[User Service]
    A -->|Start Saga| C[Order Service]
    A -->|Start Saga| D[Inventory Service]
    B -->|Confirm Order| E[Order Service]
    C -->|Reverse Order| F[Inventory Service]
    D -->|Complete Order| G[Payment Service]
    E -->|Notify Orchestartor| A
    F -->|Notify Orchestartor| A
    G -->|Notify Orchestartor| A

style A fill:#cef, stroke:#333, stroke-width:2px;
style B fill:#cef, stroke:#333, stroke-width:2px;
style C fill:#cef, stroke:#333, stroke-width:2px;
style D fill:#cef, stroke:#333, stroke-width:2px;
style E fill:#cef, stroke:#333, stroke-width:2px;
style F fill:#cef, stroke:#333, stroke-width:2px;
style G fill:#cef, stroke:#333, stroke-width:2px;
```
Saga design pattern is a way to manage data consistency across microservices in distributed transaction scenarios.  Saga is a sequence of transactions that updates each service and publishes a message or event to trigger the next transaction step. If a step fails, the saga executes compensating transactions that counteract the preceding transaction.

The term saga refers to Long Lived Transactions (LLT) and abbreviated as Segregated Access of Global Atomicity.

Saga pattern is a failure management pattern that helps establish consistency in distributed applications, and coordinates transactions between multiple microservices to maintain data consistency. Microservice publishes an event for every transaction, and the next transaction is initiated based on the event's outcome. It can take two different paths, depending on the success or failure of the transactions.

Transaction is a single unit of logic or work, sometimes made up of multiple operations. Within a transaction, an event is a state change that occurs to an entity, and a command encapsulates all information needed to perform an action or trigger a later event.  Transactions must be atomic, consistent, isolated, and durable (ACID). Transactions within a single service are ACID, but cross-service data consistency requires a cross-service transaction management strategy.

** Type of SAGA – Choreography and Orchestration **
There are two common saga implementation approaches, choreography and orchestration. Each approach has its own set of challenges and technologies to coordinate the workflow.
1. Choreography - Choreography is a way to coordinate sagas where participants exchange events without a centralized point of control. With choreography, each microservices run its own local transaction and publishes events to message broker system and that trigger local transactions in other microservices.
 
2. Orchestration is a way to coordinate sagas where a centralized controller tells the saga participants what local transactions to execute. The saga orchestrator handles all the transactions and tells the participants which operation to perform based on events. The orchestrator executes saga requests, stores and interprets the states of each task, and handles failure recovery with compensating transactions. This centralized controller microservice, orchestrate the saga workflow and invoke to execute local microservices transactions in sequentially. The orchestrator microservices execute saga transaction and manage them in centralized way and if one of the steps is failed, then executes rollback steps with compensating transactions.

** Two Phase Commit Or 2PC or 2 Phase Commit **
The 2PC could be alternative to SAGA pattern. The Two-Phase Commit protocol (2PC) is a widely used pattern to implement distributed transactions in microservices. In a two-phase commit protocol, there is a coordinator component that is responsible for controlling the transaction and contains the logic to manage the transaction. The other component is the participating nodes (e.g., the microservices) that run their local transactions. As the name indicates, the two-phase commit protocol runs a distributed transaction in two phases:
1. Prepare Phase – The coordinator asks the participating nodes whether they are ready to commit the transaction. The participants returned with a yes or no.
2. Commit Phase – If all the participating nodes respond affirmatively in phase 1, the coordinator asks all of them to commit. If at least one node returns negative, the coordinator asks all participants to roll back their local transactions.


#### Introduction to Saga Design Pattern
- Definition and purpose
- Importance in microservices architecture
- Managing data consistency across distributed transactions

#### Real-World Examples of Saga Design Pattern
- E-commerce order processing
  - Steps: Order creation, inventory update, payment processing, shipment
- Travel booking systems
  - Steps: Flight booking, hotel reservation, car rental
- Banking systems
  - Steps: Fund transfer, notification services, account updates

#### Types of Saga Approaches: Choreography
- Explanation of choreography
- Event-driven communication between services
- Advantages and challenges of choreography

#### Types of Saga Approaches: Orchestration
- Explanation of orchestration
- Centralized control by the orchestrator
- Benefits and potential drawbacks of orchestration

#### Saga vs. Two-Phase Commit (2PC) Design Pattern
- Overview of 2PC
- Comparison of transaction management strategies
- Situations where each pattern is preferable

#### Differences Between Saga and 2PC Patterns
- Consistency models: strong vs. eventual consistency
- Flow of operations: single commit vs. sequential execution
- Handling failures and compensating actions

#### Usage of Saga Design Pattern
- Common use cases in microservices
- Integration with event-driven architectures
- Considerations for implementation

#### Advantages of Saga Design Pattern
- Effective management of distributed transactions
- Loosely coupled and message-driven systems
- Flexibility in handling failures and compensating transactions

#saga #choreography #orchestrator

** Difference between SAGA design pattern and 2PC design pattern **
2PC works as a single commit and aims to perform ACID transactions on distributed systems. It is used wherever strong consistency is important. On the other hand, SAGA works sequentially, not as a single commit. Each operation gets committed before the subsequent one, and this makes the data eventually consistent.

** Advantages of this Design Pattern **
1. Best way to handle distributed transactions across the microservices.
2.  Makes transaction management in a loosely coupled, message-driven.
