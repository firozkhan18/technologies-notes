Glossary of Kubernetes Architecture Components
---
# The Art of Creating Container Images and Best Practices
https://dev.to/chefgs/glossary-of-kubernetes-architecture-components-c1b
### Table of Contents
* [Kubernetes Architecture Components](#)
* [Kubernetes cluster](#)
* [Control Plane](#)
  * [Kubernetes Control Plane Components](#)
    * [Kube API Server](#)
    * [Etcd](#)
    * [Kube Scheduler](#)
    * [Kube Controller Manager](#)
    * [Cloud Controller Manager](#)
* [Node](#)
  * [Node Components](#)
    * [Kubelet](#)
    * [Kube proxy](#)
    * [Container Runtime](#)
    * [Pods](#)
      * [Init Containers](#)
* [Kubernetes Workload Essentials](#)
  * [Namespaces](#)
  * [Label](#)
  * [Selector](#)
  * [Controller](#)
  * [Replica Set](#)
  * [Deployment and Deployment Controller](#)
  * [StatefulSet](#)
  * [Service](#)
  * [Ingress](#)
  * [Ingress Controllers](#)
  * [DNS for Services and Pods](#)
  * [Environment Variables](#)
  * [Secret](#)
  * [Config map](#)
* [Kubernetes Storage Concepts](#)
  * [Volume](#)
  * [Persistent volume](#)
  * [Persistent volume claim](#)
* [Workload Resource Types](#)
  * [Stateless Application](#)
  * [Stateful Application](#)
  * [Daemon Set](#)
  * [Job](#)
  * [CronJob](#)
* [Addons](#)
* [Conclusion](#)
* [Further References](#)

Kubernetes (k8s in short) is one of the most famous Open Source container orchestration technologies created by Google and they gave it to Cloud Native Computing Foundation in July 2015.

In this blog I wanted to post a glossary of Kubernetes Architecture Components and Terminologies. Also a brief explanation for each. This collection was heavily inspired from the Kuberetes docs definitions and people who are getting to started learn Kubernetes can use it as a quick reference to read about these terminologies.

Kubernetes Architecture Components
Image description

Kubernetes cluster
A Kubernetes cluster is a set of nodes that run containerized applications. Containerizing applications packages an app with its dependencies and some necessary services. They are more lightweight and flexible than virtual machines. In this way, Kubernetes clusters allow for applications to be more easily developed, moved and managed.
Everything in the kubernetes cluster runs as nodes including Control plane and Node resources.

Kubernetes contains two major building blocks,

Kubernetes Control Plane (or Master Node)
Nodes (or Worker Nodes)
Control Plane
It is the container orchestration layer that exposes the API and interfaces to define, deploy, and manage the lifecycle of containers.

Kubernetes Control Plane Components
The control plane's components make global decisions about the cluster (for example, scheduling), as well as detecting and responding to cluster events (for example, starting up a new pod when a deployment's replicas field is unsatisfied).

Control plane components can be run on any machine in the cluster.

Kube API Server
This component exposes Kubernetes API and acts as a front end of k8s control plane. kubectl is used to interact with API servers.

Etcd
etcd is a consistent and highly-available key value store used as Kubernetes' backing store for all cluster data.
If your Kubernetes cluster uses etcd as its backing store, make sure you have a back up plan for that data.
Secure key-value store

Kube Scheduler
Watches newly created Pod with and selects node for those pods to run

Kube Controller Manager
This component manages the four controller processes of Kubernetes,

Node controller: Responsible for noticing and responding when nodes go down.
Job controller: Watches for Job objects that represent one-off tasks, then creates Pods to run those tasks to completion.
EndpointSlice controller: Populates EndpointSlice objects (to provide a link between Services and Pods).
ServiceAccount controller: Create default ServiceAccounts for new namespaces.
Cloud Controller Manager
This component embeds cloud provider specific control logic. It lets you link your cluster into your cloud provider's API, and separates out the components that interact with that cloud platform from components that only interact with your cluster.

Node
A node is a worker machine in Kubernetes. Node can be a VM or physical machine, depending on the cluster. It has local daemons or services necessary to run Pods and is managed by the control plane. The daemons on a node include kubelet, kube-proxy, and a container runtime implementing the CRI such as Docker.

Image description

Node Components
Kubelet
An agent that runs on each node in the cluster. It makes sure that containers are running in a Pod.

Kube proxy
kube-proxy is a network proxy that runs on each node in your cluster, implementing part of the Kubernetes Service concept.
kube-proxy maintains network rules on nodes. These network rules allow network communication to your Pods from network sessions inside or outside of your cluster. kube-proxy maintains network rules on nodes. These network rules allow network communication to your Pods from network sessions inside or outside of your cluster.

Container Runtime
The container runtime is the software that is responsible for running containers.
Kubernetes supports several container runtimes: Docker, containerd, CRI-O, and any implementation of the Kubernetes CRI (Container Runtime Interface).

Pods
Pods are the smallest deploy-able units of computing that we can create and manage in Kubernetes.
A Pod (as in a pod of whales or pea pod) is a group of one or more containers, with shared storage and network resources, and a specification for how to run the containers.
The main purpose of a pod is to support co-located
processes, such as an application server and its local cache. Containers within a pod can find each other via localhost,
and can also communicate with each other using standard inter-process communications

Init Containers
These are specialized containers that run before app containers in a Pod starts running. Init containers can contain utilities or setup scripts not present in an app image.

You can specify init containers in the Pod specification alongside the containers array (which describes app containers).

A Pod can have multiple containers running apps within it, but it can also have one or more init containers, which are run before the app containers are started.

Init containers are exactly like regular containers, except:

Init containers always run to completion.
Each init container must complete successfully before the next one starts.
Kubernetes Workload Essentials
Image description

Image description

Namespaces
A namespace provides a logical partition of the cluster’s resources. Kubernetes resources can use the same name when found in different namespaces. Different namespaces can be assigned different quotas for resource limitations.

Label
A label is a key/value pair that is attached to a Kubernetes resource, for example, a pod. Labels can be attached to resources at creation time, as well as added and modified at any later time.

Selector
A (label) selector can be used to organize Kubernetes resources that have labels. An equality-based selector defines a condition for selecting resources that have the specified label value. A set-based selector defines a condition for selecting resources that have a label value within the specified set of values

Controller
A controller manages a set of pods and ensures that the cluster is in the specified state. Unlike manually created pods, the pods maintained by a replication controller are automatically replaced if they fail, get deleted, or are terminated.

Replica Set
A ReplicaSet's purpose is to maintain a stable set of replica Pods running at any given time. As such, it is often used to guarantee the availability of a specified number of identical Pods.
A replica set is the next-generation replication controller. A replication controller supports only equality-based selectors, while a replica set supports set-based selectors.

Deployment and Deployment Controller
A Deployment provides declarative updates for Pods and ReplicaSets.

A deployment controller defines a desired state for a logical group of pods and replica sets. It creates new resources or replaces the existing resources, if necessary. A deployment can be updated, rolled out, or rolled back. A practical use case for a deployment is to bring up a replica set and pods, then update the deployment to re-create the pods

StatefulSet
It lets you run one or more related Pods that do track state somehow. For example, if your workload records data persistently, you can run a StatefulSet that matches each Pod with a PersistentVolume. Code running in the Pods for that StatefulSet, can replicate data to other Pods in the same StatefulSet to improve overall resilience.

Service
A service uses a selector to define a logical group of pods and defines a policy to access such logical groups. Because pods are not durable, the actual pods that are running may change. A client that uses one or more containers within a pod should not need to be aware of which specific pod it works with, especially if there are several pods (replicas).

There are several types of services in Kubernetes, including ClusterIP, NodePort, LoadBalancer.

ClusterIP service
exposes pods to connections from inside the cluster.

NodePort service exposes pods to external traffic by
forwarding traffic from a port on each node of the cluster to the container port.

LoadBalancer service
It also exposes pods to external traffic, as NodePort service, however it also provides a load balancer functionality.

Image description

Ingress
An API object that manages external access to the services in a cluster, typically HTTP.

Ingress may provide load balancing, SSL termination and name-based virtual hosting.

Ingress Controllers
In order for the Ingress resource to work, the cluster must have an ingress controller running.
There is support from various third party projects to implement ingress controllers. The list can be found here

DNS for Services and Pods
Kubernetes creates DNS records for Services and Pods. You can contact Services with consistent DNS names instead of IP addresses.

Kubernetes publishes information about Pods and Services which is used to program DNS. Kubelet configures Pods' DNS so that running containers can lookup Services by name rather than IP.

Services defined in the cluster are assigned DNS names. By default, a client Pod's DNS search list includes the Pod's own namespace and the cluster's default domain.

Environment Variables
Kubernetes injects a set of environment variables into pods for each active service. Such environment variables
contain the service host and port.
An application in the pod can use these variables to establish a connection to the service.
The service should be created before the replication controller or replica set creates a pod’s replicas. Changes made to an active service are not reflected in a previously created replica.

Secret
A Kubernetes secret allows users to pass sensitive information, such as passwords, authentication tokens, SSH keys, and database credentials, to containers.
A secret can then be referenced when declaring a container definition, and read from within containers as environment variables or from a local disk.

Config map
A Kubernetes config map allows users to externalize application configuration parameters from a container image and define application configuration details, such as key/value pairs, directory content, or file content. Config map values can be consumed by applications through environment variables, local disks, or command line arguments.

Kubernetes Storage Concepts
Volume
A container file system is ephemeral: if a container crashes, the changes to its file system are lost. A volume is defined at the pod level, and is used to preserve data across container crashes. A volume can be also used to share data between containers in a pod. A volume has the same lifecycle as the pod that encloses it when a pod is deleted, the volume is deleted as well. Kubernetes supports different volume types, which are implemented as plugins.

Persistent volume
A persistent volume represents a real networked storage unit in a cluster that has been provisioned by an
administrator. Persistent storage has a lifecycle independent of any individual pod. It supports different access modes, such as mounting as read-write by a single node, mounting as read-only by many nodes, and mounting
as read-write by many nodes. Kubernetes supports different persistent volume types, which are implemented as plugins. Examples of persistent volume types include AWS EBS, vSphere volume, Azure File, GCE Persistent Disk, iSCSI, NFS, and Host Path.

Persistent volume claim
A persistent volume claim defines a specific amount of storage requested and specific access modes. Kubernetes
finds a matching persistent volume and binds it with the persistent volume claim. If a matching volume does not
exist, a persistent volume claim will remain unbound indefinitely. It will be bound as soon as a matching volume becomes available.

Workload Resource Types
Stateless Application
A stateless process or application can be understood in isolation. There is no stored knowledge of or reference to past transactions. Each transaction is made as if from scratch for the first time.
An example of a stateless transaction would be doing a search online to answer a question you’ve thought of. You type your question into a search engine and hit enter.
If your transaction is interrupted or closed accidentally, you just start a new one. Think of stateless transactions as a vending machine: a single request and a response.
This can be created and managed by a deployment manifest and does not need to maintain the state of the application.

Stateful Application
Stateful applications and processes are those that can be returning transactions from various application services like online banking or shopping applications.
They’re performed with the context of previous transactions and the current transaction may be affected by what happened during previous transactions. For these reasons, stateful apps use the same servers each time they process a request from a user.
The majority of applications we use day to day are stateful, but as technology advances, microservices and containers make it easier to build and deploy applications in the cloud.

In Kubernetes statefulset can be used to create the stateful application. It utilizes the storage concepts of Persistent volume to

Daemon Set
A daemon set ensures that all or some nodes run a copy of a pod. A daemon set tracks the addition and removal of cluster nodes and adds pods for nodes that are added to the cluster, terminating pods on nodes that are being removed from a cluster. Deleting a daemon set will clean up the pods it created. A typical use case for a daemon set is running a log collection daemon or a monitoring daemon on each node of a cluster.

DaemonSet defines Pods that provide node-local facilities. These might be fundamental to the operation of your cluster, such as a networking helper tool, or be part of an add-on.
Every time you add a node to your cluster that matches the specification in a DaemonSet, the control plane schedules a Pod for that DaemonSet onto the new node.

Job
A job is used to create one or more pods and ensure that a specified number of them successfully terminate. It tracks the successful completions, and when a specified number of successful completions is reached, the job itself is complete. There are several types of jobs, including non-parallel jobs, parallel jobs with a fixed
completion count, and parallel jobs with a work queue. A job should be used instead of a replication controller
if you need to spread pods across cluster nodes and ensure, for example, so that each node has only one
running pod of the specified type.

CronJob
It defines tasks that run to completion and then stop. Jobs represent one-off tasks, whereas CronJobs recur according to a schedule.

Addons
Add-ons extend the functionality of Kubernetes. It uses Kubernetes resources (DaemonSet, Deployment, etc) to implement cluster features. Because these are providing cluster-level features, namespaced resources for addons belong within the kube-system namespace.

DNS
All Kubernetes clusters should have cluster DNS, as many examples rely on it. Cluster DNS is a DNS server, in addition to the other DNS server(s) in your environment, which serves DNS records for Kubernetes services.

Containers started by Kubernetes automatically include this DNS server in their DNS searches.

Container Resource Monitoring
Container Resource Monitoring records generic time-series metrics about containers in a central database, and provides a GUI for browsing that data.

Cluster level Logging
A cluster-level logging mechanism is responsible for saving container logs to a central log store with search/browsing interface.

Service Discovery
CoreDNS is a flexible, extensible DNS server which can be installed as the in-cluster DNS for pods.

Conclusion
In this part of the glossary list we've gone through important terminologies of Kubernetes architecture components, Workload essential components and Deployment components.
In the next part, we will see what makes up to create kubernetes design and what building blocks make up an end to end kubernetes implementation.

Further References
Kubernetes Documentation

[PREV](/kubernetes-complete-reference-4.md) - [NEXT](/kubernetes-complete-reference-6.md)
