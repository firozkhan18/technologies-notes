Getting Started Tutorial for Learning Kubernetes
---

### Table of contents

* [Introduction](#introduction)
* [What is Kubernetes](#what-is-kubernetes)
* [Kubernetes High Level Architecture](#kubernetes-high-level-architecture)
* [Control Plane](#control-plane)
* [Node](#node)
* [Kubernetes Tools](#kubernetes-tools)
* [What is Minikube](#what-is-minikube)
* [Minikube Installation](#minikube-installation)
* [Install Curl](#install-curl)
* [Install docker](#install-docker)
* [Install Minikube](#install-minikube)
* [Minikube Run](#minikube-run)
* [Output of minikube start and status](#output-of-minikube-start-and-status)
* [Install Kubectl](#install-kubectl)
* [Verify and Run Minikube Cluster](#verify-and-run-minikube-cluster)
* [Conclusion](#conclusion)
* [Bibliography](#bibliography)

### Introduction
- This article intended for the purpose of getting started with Kubernetes basics
- It also explains about setting up the labs environment to run the basic Kubernetes commands.
- You can consider this blog as scribble pad that is used while getting started with Kubernetes
### What is Kubernetes
- Kubernetes (also called a K8s) is a Container orchestration open-source platform.
- Kubernetes builds upon 15 years of experience of running production workloads at Google, combined with best-of-breed ideas and practices from the community.
- We can manage containerised workloads and services, that facilitates both declarative configuration and automation.
- It has a large, rapidly growing ecosystem. Kubernetes services, support, and tools are widely available.
- [Refer Documentation for more details](https://kubernetes.io/docs/concepts/overview/what-is-kubernetes/)
### Kubernetes High Level Architecture
Kubernetes to two major building blocks,
1. Kubernetes `Control Plane`(or `Master Node` as called previously)
2. `Nodes` (or `Worker Node` as called previously)

### Control Plane
Kubernetes Control Plane has four major components,
1. **Kube API Server** : This component exposes Kubernetes API and acts as a front end of k8s control plane. `kubectl` is used to interact with API servers.
2. **ETCD** : Secure key-value store
3. **Kube Scheduler** : Watches newly created Pod with and selects node for those pods to run
4. **Controller Manager** : This component manages the four controller processes of Kubernetes

- Node Controller
- Job Controller
- End-point Controller
- Service account & Token Controller
- Kubernetes Architecture

### Node
A node consists of,
1. **Kubelet** : An agent that runs on each node in the cluster. It makes sure that containers are running in a Pod.
2. **Kube-proxy** : kube-proxy is a network proxy that runs on each node in your cluster, implementing part of the Kubernetes Service concept.
3. **Container Runtime** : The container runtime is the software that is responsible for running containers.
Kubernetes supports several container runtimes: Docker, containerd, CRI-O, and any implementation of the Kubernetes CRI (Container Runtime Interface).
4. **Pods** : Pods are the smallest deploy-able units of computing that we can create and manage in Kubernetes.
A Pod (as in a pod of whales or pea pod) is a group of one or more containers, with shared storage and network resources, and a specification for how to run the containers.

[Refer Kubernetes Component Documentation](https://kubernetes.io/docs/concepts/overview/components/) for more details.

### Kubernetes Tools
There are various tools available to learn Kubernetes by doing the setup in Workstation

- Minikube
- Kind
- Kubectl
- Kubeadm
As part of learning and to practice Kubernetes, we will pick-up **`minikube`** installation steps and practice lessons.

[Refer documentation for more details](https://kubernetes.io/docs/tasks/tools/)

### What is Minikube
- `minikube` is a CLI tool that lets you run Kubernetes locally on any workstation.
- It runs a single-node Kubernetes cluster on our personal computer (including Windows, macOS and Linux OS) so we can try out Kubernetes learning, and for any daily development work.
- Minikube cluster packs both the master and worker components for us to get started with managing the container.
- Below diagram depicts the minikube single node cluster,Minikube Cluster
### Minikube Installation
- In order to getting started with `minikube`, we need to install below components in our workstation

    - Install `curl` command
    - Install `docker`
    - Install `minikube`
    - Install `kubectl` (optional)
- I have carried out the steps in `Ubuntu 21.04` based operating system

- Refer `minikube` [documentation](https://minikube.sigs.k8s.io/docs/start/) for installation steps for other operating systems

### Install curl
> sudo apt update
> sudo apt install curl -y
### Install docker
```
# Update the apt package index, and install the latest version of Docker Engine and containerd, 
# or go to the next step to install a specific version:
> sudo apt update -y
> sudo apt install -y docker-ce docker-ce-cli containerd.io

# Add current user to 'docker' user group to invoke minikube (otherwise, the .sock permission denied error will occur)
> sudo usermod -aG docker $USER
> newgrp docker

# Verify that Docker Engine is installed correctly by running the hello-world image.
> sudo docker run hello-world
```
### Install Minikube

> cd /tmp

> curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube_latest_amd64.deb

> sudo dpkg -i minikube_latest_amd64.deb

### Minikube Run
- Start `minikube` cluster and provide docker as the container runtime engine
> $ minikube start --driver=docker
### Output of minikube start and status
- It will show up the below output in console
```
😄  minikube v1.22.0 on Ubuntu 21.04
✨  Using the docker driver based on user configuration
👍  Starting control plane node minikube in cluster minikube
🚜  Pulling base image ...
💾  Downloading Kubernetes v1.21.2 preload ...
    > preloaded-images-k8s-v11-v1...: 502.14 MiB / 502.14 MiB  100.00% 7.75 MiB
    > gcr.io/k8s-minikube/kicbase...: 361.09 MiB / 361.09 MiB  100.00% 5.08 MiB
🔥  Creating docker container (CPUs=2, Memory=3900MB) ...
🐳  Preparing Kubernetes v1.21.2 on Docker 20.10.7 ...
    ▪ Generating certificates and keys ...
    ▪ Booting up control plane ...
    ▪ Configuring RBAC rules ...
🔎  Verifying Kubernetes components...
    ▪ Using image gcr.io/k8s-minikube/storage-provisioner:v5
🌟  Enabled addons: storage-provisioner, default-storageclass
💡  kubectl not found. If you need it, try: 'minikube kubectl -- get pods -A'
🏄  Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default
```
- Minikube status command,
> $ minikube status
```
minikube
type: Control Plane
host: Running
kubelet: Running
apiserver: Running
kubeconfig: Configured
```
### Install Kubectl
Please note, Installation of Kubectl is options, because `minikube` comes packed desired version of `kubectl`

so, if we don't install `kubectl` explicitly, then we can invoke `kubectl` commands as below,

> minikube kubectl -- <expected kubectl command>

If we explicitly installed `kubectl`, then we can invoke `kubectl` commands directly as below,

> kubectl <expected kubectl command>

Kubectl installation steps,

Run below commands to install kubectl in `ubuntu`

> sudo snap install kubectl --classic

> kubectl version

### Verify and Run Minikube Cluster
- We can use `kubectl` commands to verify the installed cluster and other details.
- We can use it to access our new cluster created using `minikube`

> kubectl get po -A

or

> minikube kubectl -- get po -A

- It shows the below output, which shows the deployed single node cluster created using `minikube`
- Please note components from control plane and worker node available as part of minikube deployment
> $ kubectl get po -A
```
NAMESPACE              NAME                                         READY   STATUS    RESTARTS   AGE
kube-system            coredns-558bd4d5db-4tncm                     1/1     Running   5          9d
kube-system            etcd-minikube                                1/1     Running   5          9d
kube-system            kube-apiserver-minikube                      1/1     Running   5          9d
kube-system            kube-controller-manager-minikube             1/1     Running   5          9d
kube-system            kube-proxy-wtzn9                             1/1     Running   5          9d
kube-system            kube-scheduler-minikube                      1/1     Running   5          9d
kube-system            storage-provisioner                          1/1     Running   10         9d
kubernetes-dashboard   dashboard-metrics-scraper-7976b667d4-cssj8   1/1     Running   5          9d
kubernetes-dashboard   kubernetes-dashboard-6fcdf4f6d-kqr78         1/1     Running   10         9d
```
- Then, we can try performing the creation of new k8s deployments,
```
minikube kubectl -- create deployment hello-minikube --image=k8s.gcr.io/echoserver:1.4
minikube kubectl -- expose deployment hello-minikube --type=NodePort --port=8080

minikube kubectl -- get services hello-minikube
minikube service hello-minikube

````
- The entire Minikube cluster can be visualised using the below command,
> minikube dashboard
### Conclusion
We have come to the end of kubernetes getting started tutorial - part 1

Try this out and start hands-on with Kubernetes

We will see, next level topics like deployment of pods and services in part 2

### Bibliography
* [Kubernetes official documentation](https://kubernetes.io/docs/home/)
* [Minikube documentation](https://minikube.sigs.k8s.io/docs/start/)

[NEXT](/kubernetes-complete-reference-1.md)
