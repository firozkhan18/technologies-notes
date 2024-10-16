# Project Name

Welcome to the project! Below is a table of contents:

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Second Readme Table of Contents](#docker-kubernetes-concepts-command-table-of-contents)


### I N T R O D U C T I O N

What is Docker? 
What is a Docker container? 
Understand why Docker is used and what problems do containers solve for the development process and deployment process?

C o n t a i n e r &nbsp;&nbsp; C o n c e p t&nbsp;&nbsp; E x p l a i n e d

Docker is becoming more and more popular and seems like every company is now turning to it to make the development and deployment process more efficient. The reason is that docker solves some common problems that have been around for quite a while in software development.

### Features

The complete step-by-step guide to Docker and Kubernetes will include the following content:

🐳 D O C K E R
 - Container concept

Docker is a platform that enables developers to build, ship, and run applications within containers. Containers are isolated, lightweight environments that contain everything needed to run a particular application, including libraries, dependencies, and configurations.
 
 - Why docker? (image vs. traditional DevOps)

Docker simplifies the process of creating, managing, and deploying applications as it allows developers to package their application along with its dependencies into a single image. This image can then be easily shared and run on any platform that supports Docker, increasing portability and flexibility.
 
 - Install docker on different operating systems

Docker can be installed on a variety of operating systems, including Linux, Windows, and macOS. Installation procedures vary based on the operating system, but Docker provides official installation guides on their website for each supported platform.
 
 - 8 basic commands you need to know

   - docker run
   - docker build
   - docker pull
   - docker push
   - docker ps
   - docker images
   - docker exec
   - docker stop

 - Docker vs. Virtual Machine

Docker containers are more lightweight and efficient compared to virtual machines. Containers share the same operating system kernel as the host system, leading to faster startup times and lower resource consumption. Virtual machines, on the other hand, require a complete operating system to run, resulting in higher overhead and slower performance.

| Docker | Virtual Machine | 
|--------------------------------------|-----------------------------------| 
| Uses containerization technology | Uses hypervisor technology | 
| Shares host OS kernel | Each VM has its own OS | 
| Lightweight, faster startup time | Heavier, slower startup time | 
| Less resource intensive | More resource intensive | 
| Less isolation between containers | Complete isolation between VMs | 
| More suitable for microservices | More suitable for monolithic apps | 
| Easier to deploy and manage | More complex deployment and management | 
| Better performance in terms of speed and efficiency | Lower performance due to overhead of running multiple OS's|

Docker and Virtual Machines (VMs) are both technologies used to run applications in isolated environments, but they differ in how they achieve this isolation.

**Virtual Machines**:

Virtual machines provide hardware virtualization, which means they virtualize the physical hardware of a host machine to create multiple virtual machines that each have their own operating system and resources.
Each virtual machine runs a full operating system, which can make them heavier and slower to start compared to containers.
VMs require more memory and storage space since they include a full OS, making them less efficient in resource usage.
VMs are typically used to run multiple applications with different operating systems on the same hardware.

**Docker**:

Docker uses containerization to isolate applications in lightweight, portable containers that share the host machine's operating system kernel.
Containers are smaller and faster to start compared to VMs, as they don't include a full operating system.
Docker containers are designed to be more efficient in resource usage, as they can share the host machine's resources and only include the necessary dependencies for the application to run.
Docker is typically used to package and deploy applications in a consistent and reproducible way across different environments.

In summary, Docker is lighter, faster, and more efficient in resource usage compared to virtual machines, making it a popular choice for packaging and deploying applications. Virtual machines, on the other hand, provide more isolation by running a full operating system for each application.

 - Docker in Practice:

Overview of whole development process with Docker (development, continuous delivery, deployment).
The development process with Docker involves creating an application image using a Dockerfile, utilizing Docker Compose to define and run multi-container applications, storing and managing images in a private repository, and deploying containerized applications to different environments.
   
      - Develop an application with Docker
      - Docker Compose
      - Dockerfile
      - Private Repository
      - Deploying your containerized application
- Docker Volumes from theory to practice

Docker volumes allow data to persist beyond the life of a container, making it easier to manage data and share information between containers. Volumes can be managed using Docker commands or Docker Compose, and can be used for tasks such as sharing code between a local development environment and a containerized application.

Docker Volumes Demo with Node.js and MongoDB. Understand how to persist your database data when working with Docker using Docker Compose Volumes.

✵ K U B E R N E T E S
 - Main Kubernetes components (including Pod, Service, Ingress, Volumes, ConfigMap, Secrets, Deployment, StatefulSet)

Kubernetes has tons of components, but most of the time you are only working with a handful of them. This video shows you step by step how each component helps you to deploy your application and what the role of each of those components is.

### Node and Pod

Node: A Node is a worker machine in Kubernetes, where containers run. Each node has a kubelet, which manages the pods and containers running on the node.

Pod: A Pod is the smallest deployable unit in Kubernetes and represents a single instance of a group of containers. Pods run on nodes and can contain one or multiple containers.

### Service and Ingress

Service: A Kubernetes Service provides a way to expose an application running in a set of Pods to other applications within the cluster or to the outside world. Services allow for load balancing and automatic service discovery.

Ingress: Ingress is an API object that manages external access to services in a cluster. It provides HTTP and HTTPS routing to services based on rules defined by the user.

### ConfigMap and Secret

ConfigMap and Secret: ConfigMaps allow you to decouple configuration artifacts from image content to keep containerized applications portable. Secrets are similar to ConfigMaps but are used for storing sensitive data such as passwords, API keys, and tokens.

### Volumes

Volumes: A volume is a directory, possibly with some data in it, accessible to a container. Kubernetes Volumes allow for data to be shared between containers in a pod or persisted beyond the lifetime of a container.

### Deployment and StatefulSet

Deployment: A Deployment defines the desired state for a set of pods, updating and scaling them when necessary. It provides declarative updates to Pods and ReplicaSets.

StatefulSet: A StatefulSet is a Kubernetes workload API object used to manage stateful applications. StatefulSets allow for consistent and stable storage, networking, and unique identifiers for each pod in the set.

### Main K8s components summarized

In summary, the main Kubernetes components include Nodes, Pods, Services, Ingress, ConfigMaps, Secrets, Volumes, Deployments, and StatefulSets. These components work together to manage and orchestrate containerized applications in a Kubernetes cluster, providing scalability, reliability, and flexibility.

 - Kubernetes architecture for beginners (master, slave nodes & processes)
 - Understand how does K8s REALLY work? Main Concepts of how to use K8s
 - Minikube, Kubectl - set up the cluster and connect to it
 - Kubectl main commands - Demo
 - Configuration file (YAML) - syntax
 - Kubernetes Namespaces
 - Communication between the pods - basic networking concepts in Kubernetes
 - K8s Deployment in practice - example application deployment (pod + service + Ingress + secret)



List of features here

### Installation

Instructions on how to install the project

### Usage

Usage information

### Second Readme Table of Contents

Click [here](docker-kubernetes-concepts-command.md#specific-section) to navigate to the specific table of contents in the second `readme.md` file.




[Link to Second README.md](docker-kubernetes-concepts-commands.md)
