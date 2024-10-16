Kubernetes Learning Part II - K8s Concepts, Pods and Init-Containers
---

### Table of Contents
* [Introduction](#)
* [Kubernetes objects](#)
* [Kubernetes API](#)
* [Workloads](#)
* [Pods](#)
* [Pod controllers](#)
* [Init containers and App containers](#)
* [Init Container](#)
* [Kubernetes yaml](#)
* [Functionality of the sample Pod definition](#)
* [Run the Pod Definition](#)
* [Verify Pod](#)
* [Verify the Nginx Container Content](#)
* [Conclusion](#)
* [Further Reference](#)

### Introduction
- This is part-II of the Kubernetes learning series
- Please note these concepts are taken from Kubernetes documentation. But documentation usually has more topics to cover, so I have hand-picked some important concepts for the purpose of learning.
- Since we are going to discuss concepts, this article is theoretical and TLDR in nature :-)
- Please do checkout the [Kubernetes Learning Series](https://dev.to/chefgs/series/14137) for other parts in the series
### Kubernetes objects
- Kubernetes objects are persistent entities in the Kubernetes system. Kubernetes uses these entities to represent the state of your cluster.
- Specifically, they can describe:
  - What containerised applications are running (and on which nodes)
  - The resources available to those applications
  - The policies around how those applications behave, such as restart policies, upgrades, and fault-tolerance
  - A Kubernetes object is a record of intent -- it means, once you create the object, the Kubernetes system will constantly work to ensure that object exists.
  - By creating an object, you're effectively telling the Kubernetes system what you want your cluster's workload to look like; this is your cluster's desired state.
- We'll need to use the Kubernetes API, to work with Kubernetes objects--whether to create, modify, or delete them--.
- kubectl command-line interface (or simply CLI) makes the necessary Kubernetes API calls for you.
- We can also use the Kubernetes API directly in your own programs using one of the Client Libraries (It is for advanced or pro users).
### Kubernetes API
- The core of Kubernetes' control plane is the API server.
- The API server exposes an HTTP API that allows end users, different parts of your cluster, and external components to communicate with one another.
- The Kubernetes API lets you query and manipulate the state of API objects in Kubernetes (for example: Pods, Namespaces, ConfigMaps, and Events).
- Most operations can be performed through the kubectl command-line interface or other command-line tools, such as kubeadm, which in turn use the API. However, you can also access the API directly using REST calls.
### Workloads
- A workload is an application running on Kubernetes. Whether your workload is a single component or several that work together, on Kubernetes you run it inside a set of pods.
- In Kubernetes, a Pod represents a set of running containers on your cluster.
### Pods
- Pods are the smallest deployable units of computing that you can create and manage in Kubernetes.
- A Pod is a group of one or more containers, with shared storage and network resources, and a specification for how to run the containers.
- A Pod models an application-specific "logical host": it contains one or more application containers which are relatively tightly coupled.
- In Kubernetes, pods have a defined life cycle.
- **For example**, once a pod is running in your cluster then if the node that runs the pod fails, then all the pods in that node also will fail. Kubernetes treats that level of failure as final: so it would need to create a new Pod to recover, even if the node later becomes healthy.
- However, to make life considerably easier, we don't need to manage each Pod directly. Instead, we can use workload resources that manage a set of pods on your behalf.
- These resources configure controllers that make sure the right number of the right kind of pod are running, to match the state you specified in the config.

### Pod controllers
- We can use workload resources to create and manage multiple Pods for us.
- A controller for the resource handles replication and rollout and automatic healing in case of Pod failure.
- **For example**, if a Node fails, a controller notices that Pods on that Node have stopped working and creates a replacement Pod. The scheduler places the replacement Pod onto a healthy Node.
Here are some examples of workload resources that manage one or more Pods:

- Deployment - Manages the replicated application
- StatefulSet - Manages deployment and scaling of Pods with durable storage and persistent identifier for each pod
- DaemonSet - Ensures a copy of pod is running across the nodes in the cluster
The diagram below depicts A `multi-container` Pod that contains a `file puller` and a `web server` that uses a `persistent volume` for shared storage between the containers.

### Multi Container Pod

In this example, the pod has a container that acts as a web server for files in a shared volume, and a separate "sidecar" container that updates those files from a remote source.

### Init containers and App containers
- So the file puller is an init container and webserver is an app container, in this example.
- Init containers run and complete before the app containers are started.
- Pods natively provide two kinds of shared resources for their constituent containers: networking and storage.
### Init Container
These containers are short-lived containers, which runs in the same pod and used to perform below functions and then dies,

- To install utility tools required for the app containers
- It can create some necessary config files or dependent files required for the app containers
We can compare the init containers, with the similar functionality of cloud-init (userdata or metadata) scripts used in the Cloud service providers instance creation

### Kubernetes yaml
- Every Kubernetes object includes two nested object fields that govern the object's configuration: the object spec and the object status.
- For objects that have a spec, you have to set this when you create the object, providing a description of the characteristics you want the resource to have: its desired state
- Below is the structure of a Kubernetes config yaml file,
```yaml
apiVersion:
kind:
metadata:
spec:
```
- Here is the yaml config definition for the Pod, that contains an init-container and nginx app container
- Save the file as initcontainer.yml
```yaml
apiVersion: v1
kind: Pod
metadata:
  name: init-demo-pod
  labels:
    tier: frontend
spec:
  restartPolicy: Always
  containers:
    - name: nginx
      image: nginx:1.21-alpine
      ports:
        - containerPort: 80
      resources:
        limits:
          memory: "128Mi"
          cpu: "500m"
      volumeMounts:
        - name: workdir
          mountPath: /usr/share/nginx/html
  # These containers are run during pod initialization
  initContainers:
    - name: install
      image: busybox
      command:
        - wget
        - "-O"
        - "/work-dir/index.html"
        - http://info.cern.ch
      volumeMounts:
        - name: workdir
          mountPath: "/work-dir"
  dnsPolicy: Default
  volumes:
    - name: workdir
      emptyDir: {}
```
### Functionality of the sample Pod definition
- It has two Pods defined,
1. App container pod, which runs nginx app
2. Init-container pod, which runs busy-box container
- Responsibility of the init-container is to run the wget command over the url http://info.cern.ch and it adds the output to the mounted value path /usr/share/nginx/html
### Run the Pod Definition
- We can run the pod definition using kubectl create command with option -f
> $ kubectl create -f initcontainer.yml 
pod/init-demo created
### Verify Pod
- Use kubectl get po command to check the current state of Pod
> $ kubectl get po init-demo
```
NAME             READY   STATUS    RESTARTS   AGE
init-demo   1/1     Running   0          17m
```
- And then, use kubectl describe po command to see the full details of Pod events, container image used, volume information, and init-container execution details.
> $ kubectl describe po init-demo
```
Name:         init-demo
Namespace:    default
Priority:     0
Node:         minikube/192.168.49.2
Start Time:   Sun, 12 Sep 2021 18:46:15 +0530
Labels:       tier=frontend
Annotations:  <none>
Status:       Running
IP:           172.17.0.4
IPs:
  IP:  172.17.0.4
Init Containers:
  install:
    Container ID:  docker://d51286a8b7f5561c8c4b03351e7fc44055a282cd7e74433ac40e799ce324657e
    Image:         busybox
    Image ID:      docker-pullable://busybox@sha256:b37dd066f59a4961024cf4bed74cae5e68ac26b48807292bd12198afa3ecb778
    Port:          <none>
    Host Port:     <none>
    Command:
      wget
      -O
      /work-dir/index.html
      http://info.cern.ch
    State:          Terminated
      Reason:       Completed
      Exit Code:    0
      Started:      Sun, 12 Sep 2021 18:46:19 +0530
      Finished:     Sun, 12 Sep 2021 18:46:20 +0530
    Ready:          True
    Restart Count:  0
    Environment:    <none>
    Mounts:
      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-v5nxz (ro)
      /work-dir from workdir (rw)
Containers:
  nginx:
    Container ID:   docker://ca22d5c3d55cd5075fc2864edb478ef99ca9eb4dc12bd6e8f64d429e5d033c1a
    Image:          nginx:1.21-alpine
    Image ID:       docker-pullable://nginx@sha256:859ec6f2dc548cd2e5144b7856f2b5c37b23bd061c0c93cfa41fb5fb78307ead
    Port:           80/TCP
    Host Port:      0/TCP
    State:          Running
      Started:      Sun, 12 Sep 2021 18:46:21 +0530
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
      /usr/share/nginx/html from workdir (rw)
      /var/run/secrets/kubernetes.io/serviceaccount from kube-api-access-v5nxz (ro)
Conditions:
  Type              Status
  Initialized       True 
  Ready             True 
  ContainersReady   True 
  PodScheduled      True 
Volumes:
  workdir:
    Type:       EmptyDir (a temporary directory that shares a pod's lifetime)
    Medium:     
    SizeLimit:  <unset>
  kube-api-access-v5nxz:
    Type:                    Projected (a volume that contains injected data from multiple sources)
    TokenExpirationSeconds:  3607
    ConfigMapName:           kube-root-ca.crt
    ConfigMapOptional:       <nil>
    DownwardAPI:             true
QoS Class:                   Burstable
Node-Selectors:              <none>
Tolerations:                 node.kubernetes.io/not-ready:NoExecute op=Exists for 300s
                             node.kubernetes.io/unreachable:NoExecute op=Exists for 300s
Events:
  Type    Reason     Age   From               Message
  ----    ------     ----  ----               -------
  Normal  Scheduled  18m   default-scheduler  Successfully assigned default/init-demo to minikube
  Normal  Pulling    18m   kubelet            Pulling image "busybox"
  Normal  Pulled     18m   kubelet            Successfully pulled image "busybox" in 3.468871965s
  Normal  Created    18m   kubelet            Created container install
  Normal  Started    18m   kubelet            Started container install
  Normal  Pulled     18m   kubelet            Container image "nginx:1.21-alpine" already present on machine
  Normal  Created    18m   kubelet            Created container nginx
  Normal  Started    18m   kubelet            Started container nginx
  ```
### Verify the Nginx Container Content
- We can verify the index.html file inside the nginx container using the command kubectl exec -it
> $ kubectl exec -it init-demo -- /bin/sh
```
Defaulted container "nginx" out of: nginx, install (init)
/ # curl localhost:80
<html><head></head><body><header>
<title>http://info.cern.ch</title>
..
..
</body></html>
```
- When we run the command curl localhost:80, we see the html content of the file is getting served.
  
### Conclusion
- In this Part II blog, We have seen the concepts like,
  - Kubernetes objects
  - Pods and init-containers
  - Kubernetes Yaml structure
  - Pod definition sample of app and init container
- In the next blog, we will deep-dive into Workload resources and how to create and manage them.
### Further Reference
* [Init-container](https://kubernetes.io/docs/concepts/workloads/pods/init-containers/)
* [Pod with init-container](https://kubernetes.io/docs/tasks/configure-pod-container/configure-pod-initialization/#create-a-pod-that-has-an-init-container)
* [Workloads](https://kubernetes.io/docs/concepts/workloads/)

[PREV](/kubernetes-complete-reference-1.md) - [NEXT](/kubernetes-complete-reference-3.md)
