# ✵ KUBERNETES basics:

What is K8s

Main K8s Components

![Desktop Screenshot](kubernetes-components/images/k8-1.PNG)

Basic fundamental components of kubernates but just enough to actually get you started using kubernetes 
in paractice either as a DevOps engineer or a software developer 

Now kubernetes has tons of components but most of the time you are going to be working with just a handful.

![Desktop Screenshot](kubernetes-components/images/k8-1-1.PNG) 

Basic setup of a worker node or in kubernetes terms a node which is a simple server a physical or virtual machine and the basic componet or the smallest unit of kubernetes is a pod.

So what pod is basically an abstraction over a container so if you are familier with docker containers or container images so basically what pod does is it creates this running environment or a layer on top of the container and the reason because kubernetes wants to abstract away the container runtime or container technologies so you can replace them.

If you want to and also because you dont have directly work with docker or whatever the container technology you use in kubernates so you only interact with the kubernetes layer so we have an application pod which is our own application and that will may be use a database pod with its own container and this is also an important concept.

Here pod is usually meant to run one application container inside of it you can run multile containers inside one pod but usually its only the case if you have one main application container and helper container or some side service that has  to run inside of that pod and you say this is nothing special just you have one server and two containers running on it with a abstraction layer on top of it. 

So now let's see how they communicate with each other in kubernetes world so kubernetes offers out of the box a virtual network which means that each pod gets its own IP Address no the conatiner the pod gets the IP address and each pod can communicate with each other using that IP address which is an internal IP address obviously its not the public one so my application container can communicate with database using the IP address.

![Desktop Screenshot](kubernetes-components/images/k8-2.PNG) 

However pod component kubernetes also an important concept are ephemeral which means that they can die very easily and that happens for example if I lose a day a base container because the container crash because the application crashed

![Desktop Screenshot](kubernetes-components/images/k8-3.PNG)

Because the application crashed inside because the nodes the server that I am running them on ran out the resources the pod will die and new one will get created in its place and when that happens it will get assigned a new IP address obviously inconvenient if you are communicating with the database using the IP address.

![Desktop Screenshot](kubernetes-components/images/k8-4.PNG)

Because now you have to adjust it every time pod restarts and because of that another component of kubernetes called service is used.
 
![Desktop Screenshot](kubernetes-components/images/k8-5.PNG)

So service is basically a static IP address or permanent IP address that can be attached so to say to each pot so my app will have its own service and database part will have its own service and the good thing here is that the lifecycles of service and pod are not connected so even if the pod dies the services and its IP address will stay.

![Desktop Screenshot](kubernetes-components/images/k8-6.PNG)

So you dont have to change that end points anymore so now obviously you would want your application to be accessible through a browser right and for this you would have to create an external service so external service is a service that opens the communication from external sources but obviously you wouldn't want your database to be open to the public requests and for that you would create something called an internal service so this is a type of service that you specify when creating one.

![Desktop Screenshot](kubernetes-components/images/k8-7.PNG)

However if you notice the URL of the extenal service is not very practical so basically what you have is an HTTP protocol with a node IP Adsress so of the node not the service and the port.

![Desktop Screenshot](kubernetes-components/images/k8-7-1.PNG)

If you want to test something very fast but not for the end product so usually you will want your URL to look to like this if you want to talk to your application with a secure protocol and a domain name and for that another component of kubernetes called Ingress so instead of service request goes first to Ingress and it does the forwarding them to the service.

![Desktop Screenshot](kubernetes-components/images/k8-8.PNG)

So now we saw the some the very basic components of kubernetes and as you see this is a very simple setup we just have one server and a couple of containers running and some service nothing really speacial when kubenetes advantages or the actual cool features really come forward but we're gonna get there step-by-step.

### Summary:

To summarize, the basic fundamental components of Kubernetes to get started as a DevOps engineer or software developer are:

Worker node: A server, physical or virtual machine in Kubernetes terminology.

Pod: Abstraction layer over a container, creating a running environment for applications.

Container: Basic component inside a pod, containing the application or service.

Virtual network: Provided by Kubernetes, each pod gets its own internal IP address for communication.

Ephemeral nature of pods: Pods can easily die and get replaced, causing IP address changes.

Service: Static or permanent IP address attached to a pod, ensuring consistent communication even if the pod dies.

External service: Opens communication from external sources, allowing access to applications through a browser.

Internal service: Restricts access to internal services, preventing public requests to sensitive components like databases.

URL structure of external services: Typically follows HTTP protocol with the node IP address and port number.


![Desktop Screenshot](kubernetes-components/images/k8-9.PNG)

So as we said pods communicate with each other using a service so my appcation will have a database endpoint let's say called MongoDB service that it uses to communicate with the database but where do you configure usually this database URL or endpoints usually you would do it in application properties file or as some kind of external environmental variable but usually its inside of the built image of the application.

![Desktop Screenshot](kubernetes-components/images/k8-10.PNG)

So for example if the endpoint of the service or service name in this case changed to MongoDB you would have to adjust the URL in the application so usually you'd have to rebuild the application with the new version and you have to push it to the repository and now you have to pull that new image in your pod and restart the whole thing so a little bit tedious for a small change like database URL.

![Desktop Screenshot](kubernetes-components/images/k8-13.PNG)

So for that purpose kubernetes has a component called config map.
 
![Desktop Screenshot](kubernetes-components/images/k8-14.PNG)

So what it does is its basically your external configuration to your application so config map would usually contain configuration data like URLs of database or some other services that use and in kubernetes you just connect it to the pod so that pod actually gets the data that config map contains and now if you change the name of the service the endpoint of the service you just adjust the config map and that's it you dont have to build a new image and have to go through this whole cycle now part of the external configuration can also be database username and password righ which may also change in gthe application deployment process but putting a password or other credentials in a config map in a plain text format would be insecure even though its external configuration.

![Desktop Screenshot](kubernetes-components/images/k8-15.PNG)
![Desktop Screenshot](kubernetes-components/images/k8-16.PNG)
![Desktop Screenshot](kubernetes-components/images/k8-17.PNG)

So for this kubernetes has another component called secret so secret is just like config map but the difference is that its used to store secret data creadential.

![Desktop Screenshot](kubernetes-components/images/k8-18.PNG)

For example and its stored not a plain text format of course but in base64 encoded format so secret would contai things like creadentials and of course I mean database user you also put in the config map but whtas important is the password certificates things that you dont want other people to have access to would go in the secret and just like config map you just connect it to your pod so that pod can actually see those data and read from the secret you can actually use the data from the config map or secret inside of your application pod using for example environmental varibales or even as a properties file.

![Desktop Screenshot](kubernetes-components/images/k8-19.PNG)

So now to review we've actually looked at all mostly used kubernetes basic components 

We've looked at the pod

We've see how services are used 

What is ingress component useful for 

And, we have also seen external configuration using config map and secrets.

![Desktop Screenshot](kubernetes-components/images/k8-20.PNG)

Now we will see the anoter important concept generally which is data storegae and how it works in kubenetes.

![Desktop Screenshot](kubernetes-components/images/k8-21.PNG)

So now we have this database pod that our application usesand it has some data or generate some data with this setup you see now if the database container or the pod gets restarted the data would be gone and thats problematics and incovenient obviously because you want your databse data or log data to be persisted reliably long term and the way you can do it in kubernetes is using another componet of kubernetes called volumes and how is that work basically attaches a physical storage on a hard drive to your pod and that storage could be either on a local machine meaning on the same server node where the pod is running or it could be on a remote stoarge meaning outside of the kubernetes cluster it could be a cloud storage or it could be your own premise storage which is not prt of the kubernetes cluster so you just have an external reference on it so now when the database pod or container gets restarted all the data will be there persisted and because data storage and volumes is a very important topic.

The distiction between kubernetes cluster and and all of its components and the storage regardless of whether its a local or remote storage think of a storage as an external hard drive plug in into the kubernetes cluster. 

![Desktop Screenshot](kubernetes-components/images/k8-22.PNG)

Because the point is Kunitz clustered explicitly doesnt manage any data persistnce which means that you as a community's user or an administrator are responsible for backing up the data replicating and meaning it and making sure that its kept on a proper Hardware etc because its not taking care of kubernetes.

![Desktop Screenshot](kubernetes-components/images/k8-23.PNG)

![Desktop Screenshot](kubernetes-components/images/k8-24.PNG)

So now lets see everything is running perfectly and a user can access our application through a browser and they set up what happens if my application pod dies right crushes or i have to restart the pod because built a new container image basically I would have a downtime where a use can reach my application which is obviously a very bad thing if it happens in production and this is exactly the advantages of distributed system and containers.

![Desktop Screenshot](kubernetes-components/images/k8-25.PNG)

So instead of relying on just one application node and one database pod etc we are replicating everything on multiple servers so we would have another node where a replica or clone of our application would run which will also be connected to the service.
 
![Desktop Screenshot](kubernetes-components/images/k8-26.PNG)

So remember previously we said the service is like an persisted static IP address with a DNS name so that you dont have to constantly adjust the end point when pod dies the service is also a load balancer which means that the service will actually catch the request and forward it so whichever part is least busy.

![Desktop Screenshot](kubernetes-components/images/k8-27.PNG)

![Desktop Screenshot](kubernetes-components/images/k8-28.PNG)

So it has both of these functionalities but in order to create the second replica of the my application pod you wouldn't create a second part but instead would define a blueprint for in my application part and specify how many replicas of that pod you would like to run and that component or that blueprint is called deployment which is another component of kubernetes.

![Desktop Screenshot](kubernetes-components/images/k8-29.PNG)
![Desktop Screenshot](kubernetes-components/images/k8-30.PNG)

![Desktop Screenshot](kubernetes-components/images/k8-31.PNG)

kubernetes and in practice yiu would not working with pause or you will not be creating pods you would be creating deployment because there you can specify how many replicas and you can also scale up or scale down number of replicas of pods that you need so with pod we said that part is layer of abstraction on top of containers and deployment is another abstarction on top of the deployment is another abstraction on top of pods which makes it more convenient to interact with the pods replicate them and do some other configuration so in practice you would mostly work with deployments and not with pods so now if one of the replicas of your application pod would die the service will forward the request to another one so your application would still be access for the user.

![Desktop Screenshot](kubernetes-components/images/k8-32.PNG)

So now you're wondering what about the database pod because if the database pod died your application also wouldnt be accessible so we need database replicas as well however we cant replicate database using a deployment and the reason for that is because database has a state  which is its data meaning if we have closed a replicas of the database they would all need to access the same shared data storage and there you would need some kind of mechanism that manages which parts are currently writing to that storage or which parts are reading from that storage in order to avoid data incosistencies and that mechanism in addition to replicating feature is offered by abother kubernetes component called stateful set.

![Desktop Screenshot](kubernetes-components/images/k8-33.PNG)

So this component meant specifically for applications like database so MySQL MogoDB elasticsearch or any other statefull apploications or databases should be created using stateful sets and not deployments its very important distinction and statefull said just like deployment would take care of replicating the pods and scaling them up or scaling them down but making sure that database reads and writes are syncronized so that no database inconsistencies are offered however I must mention here that deploying database applications using stateful sets in kubernetes cluster can be somewhat tedious.

![Desktop Screenshot](kubernetes-components/images/k8-34.PNG)

So its definitely more difficult than working with deployments where you dont have all these challenges thats why its also called a common practice to host database application outside of the kubernetes cluster and jut have the deployments or stateless applications that replicate and scale with no problem inside of the kubernetes cluster and communicate with the external database.

![Desktop Screenshot](kubernetes-components/images/k8-35.PNG)

![Desktop Screenshot](kubernetes-components/images/k8-36.PNG)

So now that we have two replicas of my application pod and two replicas of the database and they're both load balanced our setup is more robust which means that now even if node one whole node server was actually rebooted or crashed and nothing could run on itwe will have a second node with application and database pods running on it and the application would still be accessible by the user until these two replicas get recreated so you can avoid downtime.

![Desktop Screenshot](kubernetes-components/images/k8-37.PNG)

So to summerize we have looked at the most used kubernetes components:-

We start with the pods and the services in order to communicate between the pod and the ingress component which is used to route traffic into the cluster.

We've also looked at exttenal configuration using maps and secrete and data persistence using volumes.

and finally we have looked at pod blueprints with replicating mechanisms like deployments and stateful sets where stateful set is used specifically for stateful applications like databases and yes there are a lot more components that communities offers but these are really the core the basic ones using these core components you actually build pretty powerfull kubernetes clusters.

K8s Architecture

Minikube and kubectl - Local Setup

Main Kubectl Commands - K8s CLI

K8s YAML Configuration File

Demo Project: MongoDB and MongoExpress

Organizing your components with K8s Namespaces

K8s Ingress explained

Helm - Package Manager

Persisting Data in K8s with Volumes

Deploying Stateful Apps with StatefulSet

K8s Services explained

### ▬▬▬▬▬▬ OVERVIEW 📚  ▬▬▬▬▬▬

🔥  What is Kubernetes 🔥 

Kubernetes, often abbreviated as K8s, is an open-source container orchestration platform that automates the deployment, scaling, and management of containerized applications. It allows users to easily manage and scale their containerized applications in a clustered environment.

►  What problems does Kubernetes solve?

Some of the problems that Kubernetes solves include:

**Container management**: Kubernetes provides a platform for managing containers, including deploying, scaling, and updating applications running in containers.

**Orchestration**: Kubernetes automates the deployment and scaling of containers, allowing for efficient resource utilization and improved application performance.

**High availability**: Kubernetes ensures that applications are highly available by automatically restarting failed containers and distributing workloads across multiple nodes.

**Load balancing**: Kubernetes provides load balancing for containerized applications, ensuring that traffic is distributed evenly across resources.

►  What features do container orchestration tools offer?

Container orchestration tools like Kubernetes offer a range of features, including:

- Automation of container deployment, scaling, and management
- High availability and fault tolerance
- Load balancing and service discovery
- Networking and storage management
- Security and access control
- Monitoring and logging

🔥  Main K8s Components 🔥  

Some of the main components of Kubernetes include:

►  Node & Pod

**Node & Pod**: Nodes are individual machines in a Kubernetes cluster, while pods are groups of containers running on a node.

►  Service & Ingress

**Service & Ingress**: Services provide networking capabilities to pods within the cluster, while Ingress allows external access to services.

►  ConfigMap & Secret

**ConfigMap & Secret**: ConfigMaps store configuration data as key-value pairs, while Secrets store sensitive information.

►  Volumes

**Volumes**: Volumes provide persistent storage for pods.

►  Deployment & StatefulSet

**Deployment & StatefulSet**: Deployment manages the deployment and scaling of pods, while StatefulSet ensures stability and ordering for stateful applications.

🔥  K8s Architecture 🔥

In terms of architecture, Kubernetes consists of:

►  Worker Nodes

**Worker Nodes**: Nodes where pods are scheduled and run.

►  Master Nodes

**Master Nodes**: Nodes that manage the cluster and make global decisions about the cluster state.

►  Api Server

**Api Server**: Component responsible for interacting with the cluster configuration and data store.

►  Scheduler

**Scheduler**: Component responsible for deciding which node pods should be scheduled on in the cluster.

►  Controller Manager

**Controller Manager**: Component responsible for regulating the state of the cluster, such as monitoring pods and replication controllers.

►  etcd - the cluster brain

**etcd**: Distributed key-value store used to store the cluster's configuration data and state. It acts as the "brain" of the cluster.

🔥  Minikube and kubectl - Local Setup 🔥

►  What is minikube?

►  What is kubectl?

►   install minikube and kubectl

►  create and start a minikube cluster

For local setup, Minikube and kubectl are commonly used tools. Minikube is a tool that allows you to run Kubernetes locally, while kubectl is the command-line interface for interacting with a Kubernetes cluster. You can install Minikube and kubectl on your machine to create and start a Minikube cluster for testing and development purposes.

🔗 Links:

- Install Minikube (Mac, Linux and Windows): https://bit.ly/38bLcJy
  
- Install Kubectl: https://bit.ly/32bSI2Z
  
- Gitlab: If you are using Mac, you can follow along the commands. I listed them all here: https://bit.ly/3oZzuHY

🔥  Main Kubectl Commands - K8s CLI 🔥

Some of the main kubectl commands used in Kubernetes CLI include:

►  Get status of different components

Get status of different components: kubectl get pods/services/deployments

►  create a pod/deployment

Create a pod/deployment: kubectl create -f <pod/deployment.yaml>

►  layers of abstraction

►  change the pod/deployment

Change the pod/deployment: kubectl apply -f <pod/deployment.yaml>

►  debugging pods

Debugging pods: kubectl logs <pod-name>

►  delete pod/deployment

Delete pod/deployment: kubectl delete pod/deployment <pod/deployment-name>

►  CRUD by applying configuration file

CRUD by applying configuration file: kubectl apply -f <config-file>

🔗 - Git repo link of all the commands: https://bit.ly/3oZzuHY

🔥  K8s YAML Configuration File 🔥

►  3 parts of a Kubernetes config file (metadata, specification, status)

►  format of configuration file

►  blueprint for pods (template)

►  connecting services to deployments and pods (label & selector & port)

►  demo

🔗 - Git repo link: https://bit.ly/2JBVyIk

🔥 Demo Project 🔥

►  Deploying MongoDB and Mongo Express

►  MongoDB Pod

►  Secret

►  MongoDB Internal Service

►  Deployment Service and Config Map

►  Mongo Express External Service

🔗 - Git repo link: https://bit.ly/3jY6lJp

🔥  Organizing your components with K8s Namespaces 🔥

►  What is a Namespace?

►  4 Default Namespaces

►  Create a Namespace

►  Why to use Namespaces? 4 Use Cases

►  Characteristics of Namespaces

►  Create Components in Namespaces

►  Change Active Namespace

🔗 - Install Kubectx: https://github.com/ahmetb/kubectx#ins...

🔥  K8s Ingress explained 🔥

►  What is Ingress? External Service vs. Ingress

►  Example YAML Config Files for External Service and Ingress

►  Internal Service Configuration for Ingress

►  How to configure Ingress in your cluster?

►  What is Ingress Controller?

►  Environment on which your cluster is running (Cloud provider or bare metal)

►  Demo: Configure Ingress in Minikube

►  Ingress Default Backend

►  Routing Use Cases

►  Configuring TLS Certificate

🔗 Links:

- Git Repo: https://bit.ly/3mJHVFc
  
- Ingress Controllers: https://bit.ly/32dfHe3
  
- Ingress Controller Bare Metal: https://bit.ly/3kYdmLB

🔥  Helm - Package Manager 🔥

►  Package Manager and Helm Charts

►  Templating Engine

►  Use Cases for Helm

►  Helm Chart Structure

►  Values injection into template files

►  Release Management / Tiller (Helm Version 2!)

🔗 Links:

- Helm hub: https://hub.helm.sh/
  
- Helm charts GitHub Project: https://github.com/helm/charts
  
- Install Helm: https://helm.sh/docs/intro/install/

🔥  Persisting Data in K8s with Volumes 🔥

►  The need for persistent storage & storage requirements

►  Persistent Volume (PV)

►  Local vs Remote Volume Types

►  Who creates the PV and when?

►  Persistent Volume Claim (PVC)

►  Levels of volume abstractions

►  ConfigMap and Secret as volume types

►  Storage Class (SC)

🔗 - Git Repo: https://bit.ly/2Gv3eLi

🔥  Deploying Stateful Apps with StatefulSet 🔥

►  What is StatefulSet? Difference of stateless and stateful applications

►  Deployment of stateful and stateless apps

►  Deployment vs StatefulSet

►  Pod Identity

►  Scaling database applications: Master and Worker Pods

►  Pod state, Pod Identifier

►  2 Pod endpoints

🔥  K8s Services 🔥

►   What is a Service in K8s and when we need it?

►  ClusterIP Services

►  Service Communication

►  Multi-Port Services

►  Headless Services

►  NodePort Services

►  LoadBalancer Services


Kubernetes, often abbreviated as K8s, is an open-source platform designed to automate deploying, scaling, and operating application containers. It allows users to manage containerized applications across a cluster of machines.

Main K8s components include Nodes, Pods, Services, Ingress, ConfigMap, Secret, Volumes, Deployment, and StatefulSet. These components work together to create a scalable and reliable infrastructure for running containerized applications.

K8s architecture consists of Worker Nodes, Master Nodes, Api Server, Scheduler, Controller Manager, and etcd - the cluster brain. These components collaborate to manage the deployment, scaling, and monitoring of containerized applications.

Minikube and kubectl are essential tools for setting up and interacting with a Kubernetes cluster locally. Minikube allows users to run a single-node cluster on their local machine, while kubectl is the command-line interface for interacting with the cluster.

Main kubectl commands include getting the status of components, creating, changing, and debugging pods and deployments, as well as deleting them. Users can apply configuration files to perform CRUD operations on Kubernetes resources using kubectl.

K8s YAML configuration files define the desired state of Kubernetes resources, including metadata, specification, and status. They act as blueprints for creating pods, connecting services to deployments and pods, and organizing components within the cluster.

A demo project deploying MongoDB and MongoExpress showcases the creation of pods, secrets, services, and config maps using Kubernetes resources. This project demonstrates how different components interact within a Kubernetes cluster.

Organizing components with K8s Namespaces helps manage and isolate resources within a cluster. Users can create namespaces, deploy components within them, and switch between active namespaces to keep resources organized.

K8s Ingress allows external access to services within a cluster. Users can configure Ingress rules, use Ingress controllers, and set up routing for incoming traffic. TLS certificate configuration and routing use cases are also covered in this topic.

Helm is a package manager for Kubernetes that simplifies the deployment of applications using Helm Charts. Helm Charts provide templates for defining application configurations, injecting values, and managing releases within the cluster.

Persisting data in K8s is achieved through Volumes, which provide persistent storage for applications. Users can create Persistent Volumes (PV), Persistent Volume Claims (PVC), and Storage Classes (SC) to manage storage requirements and data persistence.

Deploying stateful applications with StatefulSet in Kubernetes ensures reliable and ordered deployment of pods. StatefulSets are designed for stateful applications that require stable network identities and persistent storage.

K8s Services allow communication between different components within a cluster. ClusterIP, NodePort, and Headless Services are examples of service types used to define access and communication rules between pods and external traffic.

Main Kubernetes components (including Pod, Service, Ingress, Volumes, ConfigMap, Secrets, Deployment, StatefulSet)

Kubernetes architecture for beginners (master, slave nodes & processes)
Understand how does K8s REALLY work? Main Concepts of how to use K8s
Minikube, Kubectl - set up the cluster and connect to it
Kubectl main commands - Demo
Configuration file (YAML) - syntax
Communication between the pods - basic networking concepts in Kubernetes
K8s Deployment in practice - example application deployment (pod + service + Ingress + secret)
K8s Volumes explained
Kubernetes Namespaces

Main Kubernetes components:

Pod: A basic unit of deployment in Kubernetes, usually containing one or more containers.
Service: An abstraction that defines a set of pods and a policy by which to access them.
Ingress: A collection of rules that allow inbound connections to be routed to services.
Volumes: Storage resources that can be mounted to pods, allowing for persistent data storage.
ConfigMap: Configuration settings that can be injected into pods as environment variables or mounted files.
Secrets: Securely store sensitive information, such as passwords or tokens.
Deployment: A declarative way to manage a set of identical pods, ensuring the desired number of replicas are running.
StatefulSet: Manages stateful applications, such as databases, by providing stable network identities and persistent storage.
Kubernetes architecture for beginners:

Master Node: Manages the cluster and makes global decisions about the cluster state.
Worker Node (Slave Node): Executes the workload and communicates with the master node.
Processes: Components such as kube-apiserver, kube-controller-manager, kube-scheduler on the master node and kubelet, kube-proxy on the worker nodes.
Understand how K8s REALLY works: Main concepts include using the declarative approach with YAML configuration files, managing resources with kubectl commands, and scheduling pods based on resource requirements.

Minikube, Kubectl: Minikube is a tool that allows you to run Kubernetes locally on your machine, while kubectl is a command-line tool used to interact with the Kubernetes cluster.

Kubectl main commands: Basic commands include creating, deleting, describing, and managing resources within the cluster.

Configuration file (YAML) - syntax: YAML syntax is used to define Kubernetes resources in configuration files, specifying properties such as metadata, spec, and status.

Communication between pods: Pods communicate with each other using networking concepts like Services, Ingress, and DNS for resolving pod IP addresses.

K8s Deployment in practice - example application deployment: Deploying an application involves creating pods, services, ingresses, and secrets to ensure the application is accessible and secure.

K8s Volumes explained: Volumes provide persistent storage for pods, allowing data to persist even if the pod is restarted or moved to a different node.

Kubernetes Namespaces: Namespaces are virtual clusters within a physical Kubernetes cluster, allowing for better organization and management of resources.
