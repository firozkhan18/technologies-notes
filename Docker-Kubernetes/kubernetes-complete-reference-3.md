Kubernetes Learning Part III: K8s Workload Resources - Deployment and ReplicaSet
---

### Table of Contents
* [Introduction](#)
* [Kubernetes Object Management](#)
* [K8s Workload Resources](#)
* [Deployments](#)
* [Creating a Deployment](#)
* [Replica Set](#)
* [Updating the deployment](#)
* [Spec Selector Behaviour of Replica Set](#)
* [Conclusion](#)
* [Bibliography](#)
### Introduction
- This article is part-III of Kubernetes Learning Series
- Since we are going to discuss concepts, this article is theoretical and TLDR in nature :-)
- Please do checkout the [Kubernetes Learning Series](https://dev.to/chefgs/series/14137) for other parts in the series
### K8s Workload Resources
Kubernetes provides several built-in workload resources:

- Deployment and ReplicaSet (replacing the legacy resource ReplicationController). Deployment is a good fit for managing a stateless application workload on your cluster, where any Pod in the Deployment is interchangeable and can be replaced if needed.
- StatefulSet lets you run one or more related Pods that do track state somehow. For example, if your workload records data persistently, you can run a StatefulSet that matches each Pod with a PersistentVolume. Your code, running in the Pods for that StatefulSet, can replicate data to other Pods in the same StatefulSet to improve overall resilience.
- DaemonSet defines Pods that provide node-local facilities. These might be fundamental to the operation of your cluster, such as a networking helper tool, or be part of an add-on. Every time you add a node to your cluster that matches the specification in a DaemonSet, the control plane schedules a Pod for that DaemonSet onto the new node.
- Job and CronJob define tasks that run to completion and then stop. Jobs represent one-off tasks, whereas CronJobs recur according to a schedule.

- In this article, we will see about managing the Deployment and Replica set and the behaviour when updating the deployments

### Kubernetes Object Management
- When we talk about creating Kubernetes manifest definition, it is important to know about [3 types of object management](https://kubernetes.io/docs/concepts/overview/working-with-objects/object-management/)

- kubectl tool supports three kinds of object management:

- Imperative commands :

  - When using imperative commands, a user operates directly on live objects in a cluster. The user provides operations to the kubectl command as arguments or flags.
  - This is the recommended way to get started or to run a one-off task in a cluster. Because this technique operates directly on live objects, it provides no history of previous configurations.
> kubectl create deployment nginx --image nginx
- Imperative object configuration :
  - In imperative object configuration, the kubectl command specifies the operation (create, replace, etc.), optional flags and at least one file name. The file specified must contain a full definition of the object in YAML or JSON format.
> kubectl create -f nginx.yaml
- Also, we can use kubectl edit , kubectl delete and kubectl replace in this method of object configuration

- Declarative object configuration :
  - When using declarative object configuration, a user operates on object configuration files stored locally, however the user does not define the operations to be taken on the files.
  - Create, update, and delete operations are automatically detected per-object by kubectl.
  - This enables working on directories, where different operations might be needed for different objects.
### Deployments
- A [Deployment](https://kubernetes.io/docs/concepts/workloads/controllers/deployment/) provides declarative updates for Pods and ReplicaSets.
- We can describe a desired state in a Deployment, and the Deployment Controller changes the actual state to the desired state.
- Deployments can be used to create new ReplicaSets, or to remove existing Deployments and adopt all their resources with new Deployments.
- Example of a Deployment. It creates a ReplicaSet to bring up 3 nginx Pods:
- Create a deployment manifest and save it as deployment.yml
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: nginx-deployment
  labels:
    app: nginx
spec:
  replicas: 3
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: nginx:1.21-alpine
        ports:
        - containerPort: 80
        resources:
          limits:
            memory: "128Mi"
            cpu: "500m"
```
In this example:

- A Deployment named nginx-deployment is created, indicated by the .metadata.name field.
- The Deployment creates 3 replicated Pods, indicated by the .spec.replicas field.
- The .spec.selector field defines how the Deployment finds which Pods to manage. In this case, you select a label that is defined in the Pod template (app: nginx).
- The template field contains the following sub-fields:
  - The Pods are labeled app: nginx using the .metadata.labels field.
  - The Pod template's specification, or .template.spec field, indicates that the Pods run one nginx container, which runs the nginx Docker Hub image at version 1.21-alpine.
- Create one container and name it nginx using the .spec.template.spec.containers[0].name field.

### Creating a Deployment
- Now let us try out different kubectl commands to learn about the k8s deployment workload resource
- Run minikube start to kick start the local k8s cluster
- Use kubectl apply -f to execute the deployment manifest
```
#:~/github/learning2021/kubernetes$ kubectl apply -f deployment.yml 
deployment.apps/nginx-deployment created
```
- Use kubectl get deployments command to list out the deployments manifest
```
#:~/github/learning2021/kubernetes$ kubectl get deployments
NAME               READY   UP-TO-DATE   AVAILABLE   AGE
nginx-deployment   3/3     3            3           76s
```
- Our manifest definition has 3 replicas of nginx pod defined in it.
- List the pods using the command kubectl get po
```
#:~/github/learning2021/kubernetes$ kubectl get po
NAME                               READY   STATUS    RESTARTS   AGE
nginx-deployment-c7768ddc9-6cxtc   1/1     Running   0          80s
nginx-deployment-c7768ddc9-g7v7c   1/1     Running   0          80s
nginx-deployment-c7768ddc9-hcj4s   1/1     Running   0          80s
```
- Replica Sets can be viewed using the command kubectl get rs
```
#:~/github/learning2021/kubernetes$ kubectl get rs
NAME                         DESIRED   CURRENT   READY   AGE
nginx-deployment-c7768ddc9   3         3         3       101s
```
Now let us describe the deployment we just created.
Use the command kubectl describe
```
#:~/github/learning2021/kubernetes$ kubectl describe deployment nginx-deployment
Name:                   nginx-deployment
Namespace:              default
CreationTimestamp:      Thu, 01 Oct 2021 12:27:22 +0530
Labels:                 app=nginx
Annotations:            deployment.kubernetes.io/revision: 1
Selector:               app=nginx
Replicas:               3 desired | 3 updated | 3 total | 3 available | 0 unavailable
StrategyType:           RollingUpdate
MinReadySeconds:        0
RollingUpdateStrategy:  25% max unavailable, 25% max surge
Pod Template:
  Labels:  app=nginx
  Containers:
   nginx:
    Image:      nginx:1.21-alpine
    Port:       80/TCP
    Host Port:  0/TCP
    Limits:
      cpu:        500m
      memory:     128Mi
    Environment:  <none>
    Mounts:       <none>
  Volumes:        <none>
Conditions:
  Type           Status  Reason
  ----           ------  ------
  Available      True    MinimumReplicasAvailable
  Progressing    True    NewReplicaSetAvailable
OldReplicaSets:  <none>
NewReplicaSet:   nginx-deployment-c7768ddc9 (3/3 replicas created)
Events:
  Type    Reason             Age   From                   Message
  ----    ------             ----  ----                   -------
  Normal  ScalingReplicaSet  2m8s  deployment-controller  Scaled up replica set nginx-deployment-c7768ddc9 to 3
```
### Replica Set
- Purpose of the [ReplicaSet](https://kubernetes.io/docs/concepts/workloads/controllers/replicaset/) is to maintain a stable set of replica Pods running at any given time.
- As such, it is often used to guarantee the availability of a specified number of identical Pods.
- It is recommended to use replica-set within deployment definition. Becuase a Deployment is a higher-level concept that manages ReplicaSets and provides declarative updates to Pods along with a lot of other useful features.
- Replica set has been mentioned using the spec.replicas value in our deployment definition
- We will now see, what happens when we update the deployment and what is the role of replica set while updating the deployments

### Updating the deployment
- We will now change the nginx image id from 1.21-alpine to 1.21
- We will imperatively update the deployment definition using kubectl edit command
```
#:~/github/learning2021/kubernetes$ kubectl edit deployment/nginx-deployment
 deployment.apps/nginx-deployment edited
```
- We have updated the deployment which already has running pods
- So let us check the deployment status using kubectl rollout command
```
#:~/github/learning2021/kubernetes$ kubectl rollout status deployment/nginx-deployment
```
- deployment "nginx-deployment" successfully rolled out
- Once the rollout is complete, we will check the status of pods and deployment using kubectl describe command
```
#:~/github/learning2021/kubernetes$ kubectl describe deployment nginx-deployment
Name:                   nginx-deployment
Namespace:              default
CreationTimestamp:      Thu, 16 Sep 2021 12:27:22 +0530
Labels:                 app=nginx
Annotations:            deployment.kubernetes.io/revision: 2
Selector:               app=nginx
Replicas:               3 desired | 3 updated | 3 total | 3 available | 0 unavailable
StrategyType:           RollingUpdate
MinReadySeconds:        0
RollingUpdateStrategy:  25% max unavailable, 25% max surge
Pod Template:
  Labels:  app=nginx
  Containers:
   nginx:
    Image:      nginx:1.21
    Port:       80/TCP
    Host Port:  0/TCP
    Limits:
      cpu:        500m
      memory:     128Mi
    Environment:  <none>
    Mounts:       <none>
  Volumes:        <none>
Conditions:
  Type           Status  Reason
  ----           ------  ------
  Available      True    MinimumReplicasAvailable
  Progressing    True    NewReplicaSetAvailable
OldReplicaSets:  <none>
NewReplicaSet:   nginx-deployment-6f88dfb7c7 (3/3 replicas created)
Events:
  Type    Reason             Age    From                   Message
  ----    ------             ----   ----                   -------
  Normal  ScalingReplicaSet  7m45s  deployment-controller  Scaled up replica set nginx-deployment-c7768ddc9 to 3
  Normal  ScalingReplicaSet  52s    deployment-controller  Scaled up replica set nginx-deployment-6f88dfb7c7 to 1
  Normal  ScalingReplicaSet  39s    deployment-controller  Scaled down replica set nginx-deployment-c7768ddc9 to 2
  Normal  ScalingReplicaSet  39s    deployment-controller  Scaled up replica set nginx-deployment-6f88dfb7c7 to 2
  Normal  ScalingReplicaSet  38s    deployment-controller  Scaled down replica set nginx-deployment-c7768ddc9 to 1
  Normal  ScalingReplicaSet  38s    deployment-controller  Scaled up replica set nginx-deployment-6f88dfb7c7 to 3
  Normal  ScalingReplicaSet  37s    deployment-controller  Scaled down replica set nginx-deployment-c7768ddc9 to 0
```
- Now let us keenly observe the behaviour of deployment and replicas described above,
  - Deployment ensures that only a certain number of Pods are down while they are being updated. By default, it ensures that at least 75% of the desired number of Pods are up (25% max unavailable).
  - Deployment also ensures that only a certain number of Pods are created above the desired number of Pods. By default, it ensures that at most 125% of the desired number of Pods are up (25% max surge).
  - Here you see that when you first created the Deployment, it created a ReplicaSet (nginx-deployment-2035384211) and scaled it up to 3 replicas directly.
  - When you updated the Deployment, it created a new ReplicaSet (nginx-deployment-1564180365) and scaled it up to 1 and then scaled down the old ReplicaSet to 2, so that at least 2 Pods were available and at most 4 Pods were created at all times.
  - It then continued scaling up and down the new and the old ReplicaSet, with the same rolling update strategy. Finally, you'll have 3 available replicas in the new ReplicaSet, and the old ReplicaSet is scaled down to 0.
### Spec Selector Behaviour of Replica Set
- Each time when a new Deployment is observed by the Deployment controller, a ReplicaSet is created to bring up the desired Pods.
- Once If the Deployment is updated, the existing ReplicaSet that controls Pods whose labels match .spec.selector but whose template does not match .spec.template are scaled down.
- Eventually, the new ReplicaSet is scaled to .spec.replicas and all old ReplicaSets is scaled to 0.
```
#:~/github/learning2021/kubernetes$ kubectl get rs
NAME                          DESIRED   CURRENT   READY   AGE
nginx-deployment-6f88dfb7c7   3         3         3       69s
nginx-deployment-c7768ddc9    0         0         0       8m2s
```
```
#:~/github/learning2021/kubernetes$ kubectl get pods
NAME                                READY   STATUS    RESTARTS   AGE
nginx-deployment-6f88dfb7c7-25z2c   1/1     Running   0          106s
nginx-deployment-6f88dfb7c7-m7hst   1/1     Running   0          119s
nginx-deployment-6f88dfb7c7-zrbc2   1/1     Running   0          105s
```
```
#:~/github/learning2021/kubernetes$ kubectl describe pod nginx-deployment-6f88dfb7c7-25z2c
Name:         nginx-deployment-6f88dfb7c7-25z2c
Namespace:    default
Priority:     0
Node:         minikube/192.168.49.2
Start Time:   Thu, 16 Sep 2021 12:34:28 +0530
Labels:       app=nginx
              pod-template-hash=6f88dfb7c7
Annotations:  <none>
Status:       Running
IP:           172.17.0.5
IPs:
  IP:           172.17.0.5
Controlled By:  ReplicaSet/nginx-deployment-6f88dfb7c7
Containers:
  nginx:
    Container ID:   docker://9fd85eb81263d16bc73752a1275c35d6cdc0eb3074734d0820bd327eb39b30b2
    Image:          nginx:1.21
    Image ID:       docker-pullable://nginx@sha256:853b221d3341add7aaadf5f81dd088ea943ab9c918766e295321294b035f3f3e
    Port:           80/TCP
    Host Port:      0/TCP
    State:          Running
      Started:      Thu, 16 Sep 2021 12:34:29 +0530
    Ready:          True
    Restart Count:  0
    Limits:
      cpu:     500m
      memory:  128Mi
    Requests:
      cpu:        500m
      memory:     128Mi
    Environment:  <none>
    Mounts:
      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-4b8m4 (ro)
Conditions:
  Type              Status
  Initialized       True 
  Ready             True 
  ContainersReady   True 
  PodScheduled      True 
Volumes:
  kube-api-access-4b8m4:
    Type:                    Projected (a volume that contains injected data from multiple sources)
    TokenExpirationSeconds:  3607
    ConfigMapName:           kube-root-ca.crt
    ConfigMapOptional:       <nil>
    DownwardAPI:             true
QoS Class:                   Guaranteed
Node-Selectors:              <none>
Tolerations:                 node.kubernetes.io/not-ready:NoExecute op=Exists for 300s
                             node.kubernetes.io/unreachable:NoExecute op=Exists for 300s
Events:
  Type    Reason     Age    From               Message
  ----    ------     ----   ----               -------
  Normal  Scheduled  2m18s  default-scheduler  Successfully assigned default/nginx-deployment-6f88dfb7c7-25z2c to minikube
  Normal  Pulled     2m18s  kubelet            Container image "nginx:1.21" already present on machine
  Normal  Created    2m18s  kubelet            Created container nginx
  Normal  Started    2m18s  kubelet            Started container nginx
```
### Conclusion
- In this blog we have seen the concepts of deployment and replica set and their behaviour
- In next blog we will see about stateful sets
### Bibliography
* [workloads]()
* [Deployment]()
* [ReplicaSet]()

[PREV](/kubernetes-complete-reference-2.md) - [NEXT](/kubernetes-complete-reference-4.md)
