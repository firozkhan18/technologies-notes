# Kubernetes Learning Part I - Architecture Decision and Purpose of K8s

---

### Table of Content
* [Introduction](#introduction)
* [Monolithic Architecture vs Microservice Architecture](#monolithic-architecture-vs-microservice-architecture)
  * [Monolithic](#monolithic)
  * [Microservice](#microservice)
* [Purpose and features of Kubernetes](#purpose-and-features-of-kubernetes)
* [Stateless Application](#stateless-application)
* [Stateful Application](#stateful-application)
* [Conclusion](#conclusion)
* [Bibliography](#bibliography)
  
### Introduction
- We will have look into the important concepts of Kubernetes in detail. This blog is part of Kubernetes learning series.
- Since we are going to discuss concepts, this blog is going to be theoretical and `TLDR` in nature :-)
- Please do checkout the [Kubernetes Learning Series](https://dev.to/chefgs/series/14137)
### Monolithic Architecture vs Microservice Architecture
### Monolithic
- Monolithic architecture is traditional approach and has tightly coupled components
- Let us consider a scenario for Monolithic architecture,
 - If there are 10 modules in a monolithic application, then we have to develop, package and deploy the modules as one single package
 - In case, if there is a change in one module, then we have to fix or develop the module changes and can deploy it only along other modules Hence this approach is tedious and difficult adopt for a fast growing environment
### Microservice
- On contrast, Microservice architecture has independent modules and can have the development and deployment of the modules happen separately without having to deploy other modules
In the example of 10 modules application explain above,
 - Each module will be exposed as a separate REST API and it interacts with UI module
 - Since we separate all the modules as REST API, it is easy to deploy specific module, if there are any changes
- So the modules can be containerised and orchestrated using kubernetes
### Purpose and features of Kubernetes
- Infrastructure created using container has been immutable in nature. It means, we will have to every time re-build the re-deploy the changes into application and services to create app containers. Then it will be orchestrated using K8s config files
Major purpose of Kubernetes is container orchestration has below features,
- Service discovery and load balancing: Kubernetes can expose a container using the DNS name or using their own IP address. If traffic to a container is high, Kubernetes is able to load balance and distribute the network traffic so that the deployment is stable.
- Storage orchestration: Kubernetes allows you to automatically mount a storage system of your choice, such as local storages, public cloud providers, and more.
- Automated rollouts and rollbacks: You can describe the desired state for your deployed containers using Kubernetes, and it can change the actual state to the desired state at a controlled rate.
- Automatic bin packing: You provide Kubernetes with a cluster of nodes that it can use to run containerised tasks. You tell Kubernetes how much CPU and memory (RAM) each container needs. Kubernetes can fit containers onto your nodes to make the best use of your resources.
- Self-healing: Kubernetes restarts containers that fail, replaces containers, kills containers that don't respond to your user-defined health check.
Secret and configuration management: Kubernetes lets you store and manage sensitive information, such as passwords, OAuth tokens, and SSH keys.
### Stateless Application
- A stateless process or application can be understood in isolation. There is no stored knowledge of or reference to past transactions. Each transaction is made as if from scratch for the first time.
- An example of a stateless transaction would be doing a search online to answer a question you’ve thought of. You type your question into a search engine and hit enter.
- If your transaction is interrupted or closed accidentally, you just start a new one. Think of stateless transactions as a vending machine: a single request and a response.
### Stateful Application
- Stateful applications and processes, however, are those that can be returned to again and again, like online banking or email.
- They’re performed with the context of previous transactions and the current transaction may be affected by what happened during previous transactions. For these reasons, stateful apps use the same servers each time they process a request from a user.
- The majority of applications we use day to day are stateful, but as technology advances, microservices and containers make it easier to build and deploy applications in the cloud.
### Conclusion
I'm intending to write a series of blogs on Kubernetes and this is part 1 of important concepts.

### Bibliography
* [What is Kubernetes](https://kubernetes.io/docs/concepts/overview/what-is-kubernetes/)
* [Monolithic Architecture vs Microservices Architecture](https://www.tutorialspoint.com/difference-between-monolithic-and-microservices-architecture)


[PREV](/kubernetes-complete-reference-0.md) - [NEXT](/kubernetes-complete-reference-2.md)
