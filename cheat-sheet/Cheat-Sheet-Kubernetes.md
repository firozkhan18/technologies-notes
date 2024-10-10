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

