# kubernetes-cheat-sheet
Quick reference guide for Kubernetes


### Table of Contents

| No. | Questions |
|---- | ---------
|1  | [**What is Kubernetes?**](#what-is-kubernetes) |
|2  | [**Why Kubernetes?**](#why-kubernetes)|
|3  | [**Installation**](#installation) |
|   | **Creating Resources** |
|1  | [Pods](#pods) |
|2  | [Deployments](#deployments)|
|3  | [Services](#Services) |
|4  | [Output YAML to a file](#)|
|   | **Viewing Resources** |
|1  | [Nodes](#nodes)|
|2  | [Pods](#pods) |
|3  | [Namespaces](#namespaces)|
|4  | [Deployments](#deployments)|
|5  | [Services](#Services) |
|6  | [Events](#nodes)|
|7  | [Roles](#pods) |
|8  | [Secrets](#namespaces)|
|9  | [Storage](#deployments)|
|   | **Updating Resources** |
|1  | [Nodes](#nodes)|
|2  | [Pods](#pods) |
|3  | [Namespaces](#namespaces)|
|4  | [Deployments](#deployments)|
|5  | [Services](#Services) |
|   | **Deleting Resources** |
|1  | [Nodes](#nodes)|
|2  | [Pods](#pods) |
|3  | [Namespaces](#namespaces)|
|4  | [Deployments](#deployments)|
|   | **Scaling Resources** |
|1  | [Replicas](#replicas) |
|   | **Interaction** |
|1  | [Nodes](#nodes)|
|2  | [Pods](#pods) |
|3  | [Clusters](#namespaces)|
|   | **Context & Configuration** |

### What is Kubernetes?

Kubernetes (k8s or “kube”) is an open source container orchestration platform which automates many of the manual processes exists in deploying, managing, and scaling containerized applications.
Sure! Here's an in-depth look at the Kubernetes topics you listed, along with some newly added concepts:

### 1. What is Kubernetes?
Kubernetes is an open-source container orchestration platform designed to automate deploying, scaling, and operating application containers. It provides a robust framework for managing containerized applications across clusters of machines, enabling both declarative configuration and automation.

### 2. Why Kubernetes?
Kubernetes offers several benefits:
- **Scalability**: Easily scale applications up or down based on demand.
- **High Availability**: Automatically manages the availability of applications and services.
- **Resource Efficiency**: Optimizes resource utilization through efficient scheduling.
- **Load Balancing**: Distributes traffic across multiple containers.
- **Ecosystem**: Supports a wide range of integrations and a large community.

### 3. Installation
Kubernetes can be installed using various methods, such as:
- **Minikube**: For local development.
- **Kubeadm**: A tool for creating Kubernetes clusters.
- **Managed Services**: Solutions like Google Kubernetes Engine (GKE), Amazon EKS, and Azure AKS.
- **K3s**: A lightweight Kubernetes distribution for resource-constrained environments.

### Creating Resources
#### 1. Pods
Pods are the smallest deployable units in Kubernetes, representing a single instance of a running process. A Pod can contain one or more containers, and they share networking and storage resources.

#### 2. Deployments
Deployments manage the lifecycle of applications. They define the desired state for Pods, ensuring the right number of replicas are running, rolling updates, and rollbacks.

#### 3. Services
Services provide stable networking and DNS for Pods. They define a logical set of Pods and a policy to access them, enabling load balancing.

#### 4. Output YAML to a file
You can output Kubernetes resource configurations in YAML format using the `kubectl` command:
```bash
kubectl get deployment <name> -o yaml > deployment.yaml
```

### Viewing Resources
#### 1. Nodes
Nodes are the worker machines in a Kubernetes cluster. You can view nodes using:
```bash
kubectl get nodes
```

#### 2. Pods
To view running Pods:
```bash
kubectl get pods
```

#### 3. Namespaces
Namespaces provide a way to divide cluster resources among multiple users. To view namespaces:
```bash
kubectl get namespaces
```

#### 4. Deployments
To list deployments:
```bash
kubectl get deployments
```

#### 5. Services
To see services:
```bash
kubectl get services
```

#### 6. Events
Events provide insight into changes in the cluster, including errors and successful deployments:
```bash
kubectl get events
```

#### 7. Roles
Roles define permissions within namespaces. You can view roles using:
```bash
kubectl get roles -n <namespace>
```

#### 8. Secrets
Secrets store sensitive information. To view secrets:
```bash
kubectl get secrets
```

#### 9. Storage
Kubernetes abstracts storage through Persistent Volumes (PV) and Persistent Volume Claims (PVC). You can view storage resources with:
```bash
kubectl get pv
kubectl get pvc
```

### Updating Resources
#### 1. Nodes
Node updates can involve draining and upgrading nodes, typically managed through cloud providers or manual operations.

#### 2. Pods
Updating Pods can be done by changing the deployment configuration:
```bash
kubectl set image deployment/<deployment-name> <container-name>=<new-image>
```

#### 3. Namespaces
Namespaces can be updated to change resource quotas or limits.

#### 4. Deployments
Deployments support rolling updates and can be modified with:
```bash
kubectl apply -f deployment.yaml
```

#### 5. Services
Services can be updated to change selectors or ports.

### Deleting Resources
#### 1. Nodes
To delete a node:
```bash
kubectl delete node <node-name>
```

#### 2. Pods
To delete a Pod:
```bash
kubectl delete pod <pod-name>
```

#### 3. Namespaces
To delete a namespace:
```bash
kubectl delete namespace <namespace-name>
```

#### 4. Deployments
To delete a deployment:
```bash
kubectl delete deployment <deployment-name>
```

### Scaling Resources
#### 1. Replicas
Scaling deployments can be done with:
```bash
kubectl scale deployment <deployment-name> --replicas=<number>
```
Kubernetes also supports Horizontal Pod Autoscaling (HPA) to automatically adjust the number of replicas based on CPU or memory usage.

### Interaction
#### 1. Nodes
Nodes communicate with the master node and manage Pods and services.

#### 2. Pods
Pods communicate with each other using cluster IP addresses or services.

#### 3. Clusters
Clusters consist of a master node and multiple worker nodes, managing the overall orchestration of the applications.

### Context & Configuration
Kubernetes uses `kubectl config` to manage contexts, allowing users to switch between different clusters and namespaces easily. The kubeconfig file stores cluster configuration, user credentials, and namespace settings.

### Newly Added Concepts
1. **Kubernetes Operators**: Extensions that automate the management of complex applications by codifying operational knowledge.
2. **Custom Resource Definitions (CRDs)**: Allow users to extend Kubernetes capabilities by defining their own resource types.
3. **Server-Side Apply**: A declarative way to manage Kubernetes resources, reducing conflicts and improving collaboration.
4. **Pod Security Standards**: Introduced to enhance security by enforcing policies on Pod specifications.

This overview provides a comprehensive understanding of Kubernetes and its various components. If you have any specific area you'd like to dive deeper into, let me know!

Sure! Let's dive deeper into each of the newly added concepts in Kubernetes, including example code, commands, and configurations.

### 1. Kubernetes Operators

**Definition**: Operators are a design pattern in Kubernetes that enables the management of complex applications by using custom controllers. They codify operational knowledge and automate tasks such as deployment, scaling, and management.

**Example**: Let's say you want to manage a custom database (e.g., PostgreSQL) with specific operations like backups and scaling.

**Steps**:
1. **Create a Custom Resource Definition (CRD)** for the PostgreSQL resource.
2. **Implement the Operator** to handle the CRUD operations.

**CRD Example** (postgresql-crd.yaml):
```yaml
apiVersion: apiextensions.k8s.io/v1
kind: CustomResourceDefinition
metadata:
  name: postgresqls.mycompany.com
spec:
  group: mycompany.com
  versions:
    - name: v1
      served: true
      storage: true
  scope: Namespaced
  names:
    plural: postgresqls
    singular: postgresql
    kind: PostgreSQL
```

**Deploy the CRD**:
```bash
kubectl apply -f postgresql-crd.yaml
```

**Custom Resource Example** (postgresql-instance.yaml):
```yaml
apiVersion: mycompany.com/v1
kind: PostgreSQL
metadata:
  name: my-postgres
  namespace: default
spec:
  replicas: 3
  storage: 10Gi
```

**Deploy the Custom Resource**:
```bash
kubectl apply -f postgresql-instance.yaml
```

**Operator Implementation**: Operators can be built using frameworks like the Operator SDK (Go, Ansible, or Helm).

### 2. Custom Resource Definitions (CRDs)

**Definition**: CRDs allow users to extend Kubernetes capabilities by defining their own resource types. This provides a way to manage custom applications alongside built-in Kubernetes resources.

**Example**: Create a CRD for a fictional `Book` resource.

**CRD Definition** (book-crd.yaml):
```yaml
apiVersion: apiextensions.k8s.io/v1
kind: CustomResourceDefinition
metadata:
  name: books.example.com
spec:
  group: example.com
  versions:
    - name: v1
      served: true
      storage: true
  scope: Namespaced
  names:
    plural: books
    singular: book
    kind: Book
```

**Deploy the CRD**:
```bash
kubectl apply -f book-crd.yaml
```

**Create a Custom Resource** (book-instance.yaml):
```yaml
apiVersion: example.com/v1
kind: Book
metadata:
  name: my-book
  namespace: default
spec:
  title: "Kubernetes Guide"
  author: "OpenAI"
  pages: 200
```

**Deploy the Custom Resource**:
```bash
kubectl apply -f book-instance.yaml
```

**Listing Custom Resources**:
```bash
kubectl get books
```

### 3. Server-Side Apply

**Definition**: Server-Side Apply (SSA) is a declarative way to manage Kubernetes resources. It allows users to submit a resource manifest to the server, which then reconciles the desired state with the actual state while tracking field ownership to reduce conflicts.

**Example**: Using Server-Side Apply to create a Deployment.

**Deployment Configuration** (deployment.yaml):
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: my-deployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: my-app
  template:
    metadata:
      labels:
        app: my-app
    spec:
      containers:
      - name: my-container
        image: nginx
```

**Apply Using Server-Side Apply**:
```bash
kubectl apply --server-side -f deployment.yaml
```

**Update Using Server-Side Apply**:
If you want to change the image:
```yaml
spec:
  template:
    spec:
      containers:
      - name: my-container
        image: nginx:latest
```

**Update the Deployment**:
```bash
kubectl apply --server-side -f deployment.yaml
```

**Benefits**: SSA helps to manage multi-user environments by tracking which user owns which fields, thus minimizing conflicts.

### 4. Pod Security Standards

**Definition**: Pod Security Standards (PSS) are policies that enforce security best practices on Pod specifications. They define three levels of security: Privileged, Baseline, and Restricted.

**Example**: Implementing Pod Security Policies using annotations.

**Enabling Pod Security Admission**: Ensure your cluster is configured to use Pod Security Admission.

**Applying Pod Security Standards**: You can apply standards through annotations.

**Example Pod** (pod.yaml):
```yaml
apiVersion: v1
kind: Pod
metadata:
  name: my-secure-pod
  annotations:
    pod-security.kubernetes.io/enforce: restricted
spec:
  containers:
  - name: my-container
    image: nginx
```

**Deploy the Pod**:
```bash
kubectl apply -f pod.yaml
```

**Verification**: To check if the pod adheres to the specified standards:
```bash
kubectl describe pod my-secure-pod
```

### Summary

1. **Kubernetes Operators** automate the management of complex applications, ensuring that operational knowledge is codified in a Kubernetes-native way.
2. **Custom Resource Definitions (CRDs)** extend Kubernetes by allowing users to define their own resource types, enabling custom management for applications.
3. **Server-Side Apply** improves resource management through a declarative approach, reducing conflicts and enhancing collaboration.
4. **Pod Security Standards** enhance security by enforcing best practices in Pod specifications, providing a structured way to apply security policies.

These concepts greatly enhance the capabilities of Kubernetes in managing complex applications securely and efficiently. If you need further details or examples, let me know!

### Kubernetes Overview

**1. What is Kubernetes?**
Kubernetes (K8s) is an open-source platform designed for automating the deployment, scaling, and management of containerized applications. It orchestrates containers, allowing developers to focus on building applications rather than managing the underlying infrastructure.

**2. Why Kubernetes?**
Kubernetes offers numerous advantages:
- **Scalability**: Easily scale applications up or down.
- **High Availability**: Automatically manages failover and recovery.
- **Load Balancing**: Distributes traffic across containers.
- **Self-Healing**: Automatically replaces failed containers.
- **Declarative Configuration**: Define desired states and let K8s manage them.

### Installation
To install Kubernetes, you can use tools like Minikube (for local setups) or kubeadm (for production). Below is an example using Minikube:

1. **Install Minikube**:
   ```bash
   curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
   sudo install minikube-linux-amd64 /usr/local/bin/minikube
   ```

2. **Start Minikube**:
   ```bash
   minikube start
   ```

### Creating Resources

**1. Pods**
A Pod is the smallest deployable unit in Kubernetes, which can hold one or more containers.

**Command to create a Pod**:
```yaml
apiVersion: v1
kind: Pod
metadata:
  name: mypod
spec:
  containers:
  - name: mycontainer
    image: myimage:latest
```
Create the Pod using:
```bash
kubectl apply -f pod.yaml
```

**2. Deployments**
A Deployment provides declarative updates for Pods.

**Command to create a Deployment**:
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: mydeployment
spec:
  replicas: 3
  selector:
    matchLabels:
      app: myapp
  template:
    metadata:
      labels:
        app: myapp
    spec:
      containers:
      - name: mycontainer
        image: myimage:latest
```
Create the Deployment using:
```bash
kubectl apply -f deployment.yaml
```

**3. Services**
Services enable communication between various parts of your application.

**Command to create a Service**:
```yaml
apiVersion: v1
kind: Service
metadata:
  name: myservice
spec:
  selector:
    app: myapp
  ports:
    - protocol: TCP
      port: 80
      targetPort: 8080
```
Create the Service using:
```bash
kubectl apply -f service.yaml
```

**4. Output YAML to a file**
To output the current resource configuration to a YAML file:
```bash
kubectl get deployment mydeployment -o yaml > deployment.yaml
```

### Viewing Resources

**1. Nodes**
List all nodes in the cluster:
```bash
kubectl get nodes
```

**2. Pods**
List all Pods:
```bash
kubectl get pods
```

**3. Namespaces**
List all namespaces:
```bash
kubectl get namespaces
```

**4. Deployments**
List all Deployments:
```bash
kubectl get deployments
```

**5. Services**
List all Services:
```bash
kubectl get services
```

**6. Events**
View events in the cluster:
```bash
kubectl get events
```

**7. Roles**
List roles in the current namespace:
```bash
kubectl get roles
```

**8. Secrets**
List all secrets:
```bash
kubectl get secrets
```

**9. Storage**
List persistent volumes:
```bash
kubectl get pv
```

### Updating Resources

**1. Nodes**
To cordon a node (mark it as unschedulable):
```bash
kubectl cordon <node-name>
```

**2. Pods**
Update a Pod definition:
```bash
kubectl edit pod mypod
```

**3. Namespaces**
Update a namespace:
```bash
kubectl edit namespace mynamespace
```

**4. Deployments**
Update a Deployment:
```bash
kubectl set image deployment/mydeployment mycontainer=myimage:newtag
```

**5. Services**
Update a Service:
```bash
kubectl edit service myservice
```

### Deleting Resources

**1. Nodes**
To delete a node:
```bash
kubectl delete node <node-name>
```

**2. Pods**
To delete a Pod:
```bash
kubectl delete pod mypod
```

**3. Namespaces**
To delete a namespace:
```bash
kubectl delete namespace mynamespace
```

**4. Deployments**
To delete a Deployment:
```bash
kubectl delete deployment mydeployment
```

### Scaling Resources

**1. Replicas**
To scale a Deployment:
```bash
kubectl scale deployment mydeployment --replicas=5
```

### Interaction

**1. Nodes**
To get detailed information about a node:
```bash
kubectl describe node <node-name>
```

**2. Pods**
To get logs from a Pod:
```bash
kubectl logs mypod
```

**3. Clusters**
Get cluster information:
```bash
kubectl cluster-info
```

### Context & Configuration

**Setting the Context**
You can configure kubectl to use different clusters, users, and namespaces:
```bash
kubectl config use-context my-context
```

**View Configurations**
To view current configurations:
```bash
kubectl config view
```

### Microservice and MongoDB Example

To illustrate using a microservice with MongoDB in a Kubernetes environment:

1. **Microservice Setup**: Create a simple Node.js application that connects to MongoDB.

2. **Dockerize the Application**: Create a Dockerfile for your Node.js application.

3. **Kubernetes Manifests**:
   - **Deployment for MongoDB**:
   ```yaml
   apiVersion: apps/v1
   kind: Deployment
   metadata:
     name: mongodb
   spec:
     replicas: 1
     selector:
       matchLabels:
         app: mongodb
     template:
       metadata:
         labels:
           app: mongodb
       spec:
         containers:
         - name: mongodb
           image: mongo:latest
           ports:
           - containerPort: 27017
   ```

   - **Service for MongoDB**:
   ```yaml
   apiVersion: v1
   kind: Service
   metadata:
     name: mongodb
   spec:
     selector:
       app: mongodb
     ports:
       - port: 27017
         targetPort: 27017
   ```

   - **Deployment for Node.js Microservice**:
   ```yaml
   apiVersion: apps/v1
   kind: Deployment
   metadata:
     name: myapp
   spec:
     replicas: 2
     selector:
       matchLabels:
         app: myapp
     template:
       metadata:
         labels:
           app: myapp
       spec:
         containers:
         - name: myapp
           image: my-node-app:latest
           ports:
           - containerPort: 3000
           env:
           - name: MONGODB_URI
             value: mongodb://mongodb:27017/mydb
   ```

   - **Service for Node.js Microservice**:
   ```yaml
   apiVersion: v1
   kind: Service
   metadata:
     name: myapp
   spec:
     selector:
       app: myapp
     ports:
       - port: 3000
         targetPort: 3000
   ```

4. **Apply the Configurations**:
```bash
kubectl apply -f mongodb-deployment.yaml
kubectl apply -f mongodb-service.yaml
kubectl apply -f myapp-deployment.yaml
kubectl apply -f myapp-service.yaml
```

This setup will deploy a MongoDB instance and a Node.js microservice that connects to it, all orchestrated by Kubernetes. The services will allow the microservice to communicate with MongoDB seamlessly.

### Conclusion

Kubernetes provides a powerful way to manage containerized applications and services. With its rich feature set, including scaling, self-healing, and declarative configuration, it simplifies complex deployments such as microservices architecture with MongoDB.

