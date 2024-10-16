# SPRING BOOT MICROSERVICE USING CLOUD

# Contents

- [01 - Spring Boot Microservices Building Services](Part_01_Spring_Boot_Microservices_Building_Services.md)
- [02 - Spring Boot Microservices Inter Service Communication](Part_02_Spring_Boot_Microservices_Inter_Service_Communication.md)
- [03 - Spring Boot Microservices Service Discovery](Part_03_Spring_Boot_Microservices_Service_Discovery.md)
- [04 - Spring Boot Microservices API Gateway](Part_04_Spring_Boot_Microservices_API_Gateway.md)
- [05 - Spring Boot Microservices Security](Part_05_Spring_Boot_Microservices_Security.md)
- [06 - Spring Boot Microservices Resilience4J Circuit Breaker](Part_06_Spring_Boot_Microservices_Resilience4J_Circuit_Breaker.md)
- [07 - Spring Boot Microservices Distributed Tracing](Part_07_Spring_Boot_Microservices_Distributed_Tracing.md)
- [08 - Spring Boot Microservices Event Driven Architecture Using Kafka](Part_08_Spring_Boot_Microservices_Event_Driven_Architecture_Using_Kafka.md)
- [09 - Spring Boot Microservices Dockerize The Application](Part_09_Spring_Boot_Microservices_Dockerize_The_Application.md)
- [10 - Spring Boot Microservices Monitoring Using Prometheus And Grafana](Part_10_Spring_Boot_Microservices_Monitoring_Using_Prometheus_And_Grafana.md)


## How to run the application using Docker

1. Run `mvn clean package -DskipTests` to build the applications and create the docker image locally.
2. Run `docker-compose up -d` to start the applications.

## How to run the application without Docker

1. Run `mvn clean verify -DskipTests` by going inside each folder to build the applications.
2. After that run `mvn spring-boot:run` by going inside each folder to start the applications.
