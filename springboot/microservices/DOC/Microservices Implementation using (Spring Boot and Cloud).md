# ⌚ Microservices Implementation using (Spring Boot and Cloud)

In recent years, microservices architecture has been a preferred choice for application development due to various advantage that architecture brings in. However, every architecture comes with various pain areas and microservices architecture is no different. In a microservices architecture, there are many independently developed services which will serve some specific functionality. These services will be deployed in different -2 Infrastructure and they would communicate with each other and some external system through API or Events to complete the system functionality. We should minimize this kind of direct dependencies on other microservices, but in some cases, it is unavoidable. So we need to managed these dependencies and this is where the microservices architecture principle comes into the picture and explains, what all concerns (Service Discovery, Circuit Breaker, Distributed Tracing, routing, Connector, Configurations) need to be considered while developing and deploying these small services. 

So, here I am trying to depict the diagram, how can microservices be built using Spring boot and be deployed and managed using Spring Cloud. 

![Setting the Scheme](../IMAGES/microservice-architecture.png)

In Above Diagram, I used various offering provided by Spring Cloud. I will explain, what each component can be used to resolve the specific concern.

## ⌚ Spring Cloud Gateway

Every call to microservice from internet (Web or OpenAPI) should go through from Gateway to handle routing and Cross-Cutting concerns like Security, Monitoring and Resiliency. For information on how to build gateway using Spring Cloud, please visit https://spring.io/projects/spring-cloud-gateway. 
Spring Cloud Gateway

![Setting the Scheme](../IMAGES/gateway.png)

## ⌚ Config Server

Microservices will be having many configurations which will be different for different environments (SIT, UAT or PROD). So maintain these configurations outside the application, central location is required where configuration can be managed and if any changes in configuration then there is no change in the code. Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system. With the Config Server, you have a central place to manage external properties for applications across all environments. Config Server can easily be created using Spring cloud and more details please visit. 
Configuration change management

![Setting the Scheme](../IMAGES/config-server.png)

## ⌚ Service Registry

Users or service use either Client or Server Side discovery to determine the location of a service instance to which to send requests. The problem is how do clients of service know about the available instance of services which will be different for each environment. The solution is to implement Service Registry, which is nothing but a database of services available, their instances and locations. Service instances are registered with service registry on startup. Eureka Server helps us to create Service Registry server and all other services get register with it.  To run your own server use the spring-cloud-starter-netflix-eureka-server dependency and @EnableEurekaServer.

## ⌚ Eureka  Discovery Client

Services need to call to each other. Nowadays, mostly microservices are getting deployed in VM or containerized environment where number of instances of service and their location changes dynamically. We need to must implement mechanism to enable client of service to make a request to dynamically changing set of service instances. This is where Eureka Discovery Client Comes into a picture that helps us to fetch the registered service from the Eureka Service Registry. With Spring Cloud, Service discovery is very easy. As long as Spring Cloud Netflix and Eureka Core are on the classpath any Spring Boot application with @EnableEurekaClient will try to contact a Eureka server on http://localhost:8761 (the default value of eureka.client.serviceUrl.defaultZone): 
Server side discovery

![Setting the Scheme](../IMAGES/eureka-discovery-client.png)

## ⌚ Zipkin Server

In the distributed system, understanding the state of one instance is not sufficient. We need to aggregate the matrices, logs and traces for all instances of the service to provide an insight into the path a particular transaction has taken.  This is where distribute tracing is useful. Distributed tracing, aka request tracing, meanwhile follows operations inside and over a range of systems to pinpoint where failures occur and what is behind poor performance. Zipkin is a distributed tracing system. It helps gather timing data needed to troubleshoot latency problems in service architectures. Features include both the collection and lookup of this data. Spring cloud has added zipkin in its overall solution system and came up with Spring Cloud Sleuth that provides Spring Boot auto-configuration for distributed tracing. 

## ⌚ Circuit Breaker (Hystrix)

In microservice architecture one service call another service synchronously and it's always possible that another service is either not available or taking too much time respond. So resources like threads are consumed in the caller while waiting for other service to respond. It could lead to resource exhaustion and make calling service unable to handle other request. So prevent network or service failure cascading to other service, circuit breaker comes into the picture. The circuit breaker pattern allows you to build a fault tolerant and resilient system that can survive gracefully when key services are either unavailable or have high latency. In the Spring cloud world it can be achieved through Hystrix.  How to use Hystrix with spring boot application, there is a good tutorial already available here. Spring Cloud also provides a nice dashboard to monitor the status of Hystrix commands.
Create a Spring Boot application with Hystrix Dashboard starter and annotate the main entry-point class with @EnableHystrixDashboard. 

## ⌚ Spring Feign Client

Spring Feign Client - In the microservices architecture, Service to Service communication happens very often, hence you need some mechanism to invoke another service. Spring Feign Client is a declarative Rest Client. Feign creates dynamic implementation of an interface decorated with JAX-RS or Spring MVC annotations. It is very easy to use 
Spring feign client

![Setting the Scheme](../IMAGES/feign-client.png)

