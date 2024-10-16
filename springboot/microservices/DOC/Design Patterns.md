A Quick “Flashback” on Microservice Architecture
Microservice refers to a decentralized and distributed approach to software development. The microservices architecture enables a complex application to be broken down into smaller, loosely coupled, and separate services. Each has its own database and can be built, tested, deployed, and managed independently.

In the microservice architecture, the concept of service instances is an intrinsic part. What is it, anyway? By its essence, a service instance is a single running copy of a specific microservice. Each microservice within the architecture can have multiple instances running concurrently. These instances are independent, and they are self-contained units that encapsulate a specific business functionality or any business capability. If one service instance goes down, others can take over, ensuring uninterrupted service. Additionally, as demand increases, more instances of a service can be deployed to handle the load, thereby allowing for efficient scalability.

A Quick Flashback on Microservice Architecture

For example, let’s consider an e-commerce application that is composed of multiple microservices such as user management, product catalog, shopping cart, payment processing, and more. Each of these microservices could have multiple service instances running at any given time to handle incoming requests. Having multiple instances of each service facilitates load balancing and fault tolerance. As aforementioned, if one instance of a service fails or becomes unavailable, requests can be rerouted to another instance of the same service, minimizing downtime and ensuring smooth business transactions as well as user experience. Additionally, if a particular service is experiencing high demand, more instances of that service can be spun up to handle the increased load.

Compared to the traditional monolithic architecture that uses a single codebase for the entire application, microservices provide more flexibility in development and are easier to scale. Furthermore, they can be reused across different applications. As against service-oriented architecture (SOA), microservices are more lightweight and can be deployed independently without affecting the rest of the other services.

Types of Microservices Design Patterns
What is a microservices design pattern? Microservice architecture patterns are reusable solutions to a common set of problems that occur in the development and maintenance of distributed services. Such a pattern provides an abstraction layer, allowing developers to quickly implement common architecture solutions without having to reinvent the wheel each time. These patterns are proven solutions to recurring design challenges related to microservice architecture. They cover various aspects, such as communication and messaging between services, service discovery, scalability, fault tolerance, database management, storage, etc.

These microservices patterns are divided into five main categories: Service Decomposition, Service Discovery, Database Management, Messaging, Integration, and Cross-Cutting Concern patterns.

Service Decomposition Patterns
Overall, service decomposition patterns are concerned with the breaking down of single monolithic applications into multiple, manageable, small services. These are further divided into subtypes:

Decompose by Business Capability

These patterns place a premium on business logic and aim for all the services to have specific business capabilities and to encapsulate certain functionality. For example, services related to user authentication, product catalog management, order processing, etc.

Decompose by Subdomain

In a like manner, an application is decomposed into different subdomains in this pattern; each will span multiple services of its own.

Strangler Pattern

This type of pattern is named after the strangler fig tree that gradually envelops and replaces its host. The strangler pattern takes an existing monolithic application and incrementally refactors it into a set of microservices. This is done by gradually replacing some of the components with new microservice-based services. These patterns are the type of choice for web applications.

In detail, the pattern creates two separate applications - one is the existing monolithic application deployed in a production environment, while the other is the refactored version of it. Both live alongside each other in the same URI space. Eventually, the monolithic application is phased out and replaced with the microservice counterpart steadily.

Integration Patterns
Integration patterns are concerned with how the services integrate and interact with each other, and they consist of some subtypes:

API Gateway Pattern

The API gateway design pattern is composed of a single point of entry for all clients, which serves as an aggregator for multiple microservices. This gateway exposes both internal and external APIs that allow client applications to access the services it provides. The API gateway can also be used for authentication, rate-limiting, routing requests, and caching responses.

Event-driven Architecture Pattern

Event-driven architecture (EDA) is a microservice architecture pattern focusing on the flow of messages or events among services. EDA is based on the concept of sending and receiving messages to trigger actions between different services. In this pattern, services communicate with each other by publishing and subscribing to events. Services can subscribe to certain types of events, process them as they come in, and publish various events that will then be handled by other service instances related to the same event.

Aggregator Pattern

This pattern is used to combine multiple data sources from microservice-based applications. It acts as a mediator between services and clients, allowing them to access the necessary data without calling multiple endpoints. Utilizing services that provide necessary data in a single request enables the client to receive all the required information in an efficient manner.

Event Sourcing Pattern

This microservices architecture pattern uses an event log as a means of tracking changes to data within the system, resulting in a complete audit trail. All changes are recorded and stored as events within a log, which can then be used to reconstruct models completely at any given point in time.

Database Patterns
Database management patterns in microservices are designs used to handle, store, and retrieve data across different services. In simple terms, these patterns are set up to manage data between micro-services. The database patterns are not only aimed at securing data consistency and handling business transactions but also dealing with a lot of challenges associated with distributed data management in the microservices environment. Given the autonomous nature of microservices, each service should ideally have its own database to ensure loose coupling and independence.

Database per Service Pattern

In this pattern, each microservice has its own dedicated database, which can be different in terms of type and vendor based on the specific requirements of that service. This pattern promotes the principle of loose coupling among various services and makes certain that the database schema of a service can evolve without directly affecting others.

Shared Database Pattern

Contrary to Database per Service, the Shared Database Pattern allows different services to share the same database. This method can simplify data management and keep data consistent in exchange for tight coupling among services and potentially create conflicts with concurrent access.

Saga Pattern

The Saga pattern is used to maintain data consistency across services in microservices architecture where transactions involve multiple services. Instead of using distributed transactions, this pattern sequences local transactions in each service. If one transaction fails, the Saga orchestrates compensating transactions to undo the influence of the preceding transactions.

CQRS (Command Query Responsibility Segregation) Pattern

CQRS suggests splitting one application into two parts – the Command side and the Query side. The Command side handles all create, update, and delete requests and is optimized for write operations, while the Query side handles all read requests and is optimized for read operations. This segregation allows each side to scale independently and to use the most appropriate persistence technologies.

Event Sourcing Pattern

Referred to earlier under Integration Patterns, Event Sourcing can also serve as a database pattern. In this pattern, all changes to the system state are stored as a sequence of events.

You query these events. Also, you can utilize the event log as the foundation to automatically adjust the state to cope with retroactive changes and to reconstruct past states.

Cross-Cutting Concern Patterns
Cross-cutting concerns relate to aspects (from logging, authentication, and security to distributed tracing, monitoring, and service discovery); they have an impact on multiple layers of the architecture, transcending individual services or components.

External Configuration Pattern

As the name defines, the pattern recommends keeping all configurations in an external store, which makes conditions for easy maintaining and updating configuration values. Keeping the configuration outside the codebase also promotes service autonomy and enables each service instance to use different configurations as needed.

Circuit Breaker Pattern

The circuit breaker pattern is created to prevent cascading failures in a distributed system. It sets up a communication link among services and creates one additional layer of abstraction between them, letting the participating services detect and respond to any misbehaving service. The circuit breaker pattern facilitates graceful degradation when certain services become unavailable or fail.

Service Discovery Pattern

Locating, detecting, and monitoring the availability of services is what service discovery is meant to handle. A service registry keeps track of all registered services and their locations. Client-side load balancers then use this information to route requests accordingly. This allows for easy scaling of services as nodes are added or removed from the cluster.

Centralized Logging Service Pattern

Centralized logging service patterns are used in the microservices architecture to consolidate and standardize logs from separate services into one centralized location. This approach eases the process of monitoring, analyzing, and troubleshooting the system since all logs are available in a single place.

Blue-Green Deployment Pattern

The blue-green deployment strategy is often implemented to minimize or even remove downtime and reduce the risk associated with deploying new versions of an application or service.

It involves running two identical production environments – the ‘blue’ environment and the ‘green’ environment. The blue environment contains the currently running version of the application, while the green environment runs a newer version. After testing, traffic can then be shifted to the green environment, making it the new blue. This can be an assistant in securing zero downtime during deployments and allows for easy rollbacks in case of failure.

Observability Patterns
For your information, observability patterns are the ones defined as practices and tools that operators and developers employ to gather insights into the internal state and behavior of a microservice-based application. If there is any issue, they can debug the systems accordingly. For the purpose of validating the “overall health” of a system and taking timely action, these patterns monitor different facets, specifically performance, availability, and usage.

Log Aggregation Pattern

As simple as the name implies, log aggregation refers to the sub-type of patterns used to collect logs from various services and store them in an indexed format for easy searching and analysis. Accordingly, it will require much less effort in tracking events, diagnosing, and troubleshooting problems in a distributed system. Not only that, log aggregation patterns are capable of identifying and monitoring trends within a system by analyzing log entries over time.

Distributed Tracing Pattern

It is in use for tracking the flow of a request across multiple services and components in a distributed system. Distributed tracing equips developers with the means to discover performance bottlenecks, pinpoint the root cause of issues, detect slow requests, or else. Developers using distributed tracing patterns can channel their focus on the right areas and prioritize efforts to diagnose issues more efficiently.

Performance Metrics Pattern

These patterns are put to work for tracking and monitoring the performance of each service alone as well as the entire system. They tend to CPU utilization, memory usage, response time, throughput, and more aspects alike. Since each service is responsible for collecting its own metrics, this technique allows for a more accurate and detailed analysis of a microservices-based system. Through data, software developers and operators are able to discover any bottleneck occurring in the system and take proactive moves to get rid of them.

Health Check API Pattern

The health API check pattern allows services to periodically call an endpoint to determine the health of interconnected services within the system. Thanks to this type of system-wide self-monitoring, it is easy to check and determine whether a system is up and running as required or not, thus facilitating faster troubleshooting and identification of any issues.
