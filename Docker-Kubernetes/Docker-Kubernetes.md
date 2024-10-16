### Introduction to Docker and Kubernetes

---
### Table Of Contents

Introduction to Docker
Introduction
Course Overview
What is Docker
Installing Docker
Verify Installation

Images, Containers, and Ports
Images & Containers
Pulling NGINX Image
Running Containers
Exposing Ports
Exposing Multiple Ports
Managing Containers
Naming Containers

Volumes
Volumes
Volumes Between Host and Container
Customize Website
Volumes Between Containers

Building Images
Dockerfile
Creating Dockerfile
Docker Build

Project: Build an Image for an API
Node JS and Express JS
Dockerfile for our API
Running Containers for our API

Caching and Layers
.dockerignore
Caching and Layers
Caching and Layers Part 2

Reducing Image Size
Alpine
Pulling Alpine Images
Using Alpine

Tags and Versioning
Tags and Versions
Using Tags with Versions
Running Containers and Tags
Tagging Override
Tagging Own Images
Running Containers with Different Tags

Docker Registries
Docker Registry
Create Docker Hub Repo
Pushing Images to Docker Hub
Pulling Own Images

Debugging Containers
Docker Inspect
Docker Logs
Docker Exec

Introduction to Kubernetes
Kubernetes
Course Overview
What is Kubernetes

Kubernetes Architecture & Components
Kubernetes Architecture
Pod, Service & Ingress
Config Map and Secret
Volumes
Deployments and Stateful Sets
Components Summary

Developing Locally
Minikube and kubectl
Installing Minikube and kubectl
Create Deployment 
Debugging Pods
kubectl apply -f
kubectl commands summary

Project: MongoDB and Mongo Express
Deploying MongoDB and Mongo Express
MongoDB Pod
Secret
MongoDB Internal Service
Deployment Service and Config Map
Mongo Express External Service

## Docker

### Introduction

Docker is a platform that allows developers to automate the deployment of applications inside lightweight, portable containers. Containers bundle an application with its dependencies, ensuring it runs consistently across different environments.

### Course Overview

- **Introduction**: Basic concepts of Docker.
- **Images, Containers, and Ports**: Working with Docker images and containers.
- **Volumes**: Managing data with Docker volumes.
- **Building Images**: Creating and optimizing Docker images.
- **Tags and Versioning**: Managing image versions and tags.
- **Docker Registries**: Storing and retrieving images.
- **Debugging Containers**: Diagnosing and troubleshooting Docker containers.

---

### What is Docker

Docker enables containerization, which is the process of encapsulating an application and its dependencies into a container. This ensures that the application behaves the same way regardless of where it is run.

#### Key Concepts

- **Images**: Read-only templates that define the contents of a container.
- **Containers**: Instances of Docker images that run the application.
- **Dockerfile**: A script to automate the creation of Docker images.
- **Volumes**: Mechanisms to persist and share data between containers and hosts.

### Installing Docker

#### On Ubuntu/Debian:

```bash
sudo apt update
sudo apt install docker.io
sudo systemctl start docker
sudo systemctl enable docker
```

#### On macOS:

1. Download Docker Desktop from [Docker's website](https://www.docker.com/products/docker-desktop).
2. Follow the installation instructions.

#### On Windows:

1. Download Docker Desktop from [Docker's website](https://www.docker.com/products/docker-desktop).
2. Follow the installation instructions.

### Verify Installation

```bash
docker --version
```

### Images, Containers, and Ports

#### Images & Containers

- **List Images**: `docker images`
- **List Containers**: `docker ps` (for running), `docker ps -a` (all)

#### Pulling NGINX Image

```bash
docker pull nginx
```

#### Running Containers

```bash
docker run -d --name mynginx nginx
```

- `-d` runs the container in detached mode.
- `--name` assigns a name to the container.

#### Exposing Ports

```bash
docker run -d -p 8080:80 nginx
```

- `-p` maps port 80 in the container to port 8080 on the host.

#### Exposing Multiple Ports

```bash
docker run -d -p 8080:80 -p 8443:443 nginx
```

#### Managing Containers

- **Stop Container**: `docker stop mynginx`
- **Start Container**: `docker start mynginx`
- **Remove Container**: `docker rm mynginx`

#### Naming Containers

```bash
docker run -d --name webserver nginx
```

### Volumes

#### Volumes Between Host and Container

```bash
docker run -d -p 8080:80 -v /host/path:/container/path nginx
```

- `-v` mounts a host directory to a container directory.

#### Customize Website

```bash
docker run -d -p 8080:80 -v /host/custom/index.html:/usr/share/nginx/html/index.html nginx
```

#### Volumes Between Containers

```bash
docker run -d --name app1 -v mydata:/data nginx
docker run -d --name app2 -v mydata:/data nginx
```

### Building Images

#### Dockerfile

A `Dockerfile` is a text file containing a series of instructions on how to build a Docker image.

#### Creating Dockerfile

Example `Dockerfile` for a simple web server:

```Dockerfile
FROM nginx:alpine
COPY index.html /usr/share/nginx/html/index.html
```

#### Docker Build

```bash
docker build -t mynginximage .
```

### Project: Build an Image for an API

#### Node.js and Express.js

- **Create a `Dockerfile` for Node.js API:**

```Dockerfile
FROM node:14
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 8080
CMD ["node", "server.js"]
```

#### Running Containers for Our API

```bash
docker build -t mynodeapi .
docker run -d -p 8080:8080 mynodeapi
```

### Caching and Layers

#### .dockerignore

Create a `.dockerignore` file to exclude files from the Docker context:

```text
node_modules
npm-debug.log
```

#### Caching and Layers

Docker caches layers to optimize builds. Changes in a layer will invalidate subsequent layers.

### Reducing Image Size

#### Alpine

Use lightweight base images like `alpine` to reduce image size.

- **Pulling Alpine Images:**

```bash
docker pull alpine
```

- **Using Alpine:**

```Dockerfile
FROM node:14-alpine
```

### Tags and Versioning

#### Tags and Versions

- **Tagging an Image:**

```bash
docker tag myimage myimage:1.0
```

- **Running Containers and Tags:**

```bash
docker run -d myimage:1.0
```

- **Tagging Override:**

```bash
docker tag myimage:latest myimage:1.1
```

#### Tagging Own Images

```bash
docker build -t myimage:latest .
docker tag myimage:latest myrepository/myimage:latest
```

#### Running Containers with Different Tags

```bash
docker run -d myrepository/myimage:1.0
```

### Docker Registries

#### Docker Registry

Docker Hub is a public registry. Private registries are also available.

- **Create Docker Hub Repo**:
  Go to [Docker Hub](https://hub.docker.com/), sign in, and create a new repository.

- **Pushing Images to Docker Hub:**

```bash
docker login
docker tag myimage:latest myusername/myimage:latest
docker push myusername/myimage:latest
```

- **Pulling Own Images:**

```bash
docker pull myusername/myimage:latest
```

### Debugging Containers

#### Docker Inspect

```bash
docker inspect mycontainer
```

#### Docker Logs

```bash
docker logs mycontainer
```

#### Docker Exec

```bash
docker exec -it mycontainer /bin/sh
```

---

## Kubernetes

### Introduction

Kubernetes (K8s) is an open-source container orchestration platform designed to automate deploying, scaling, and operating application containers.

### Course Overview

- **Introduction**: Basic concepts of Kubernetes.
- **Architecture & Components**: Core components of Kubernetes.
- **Developing Locally**: Using Minikube and kubectl.
- **Project**: Deploying MongoDB and Mongo Express.

### What is Kubernetes

Kubernetes manages containerized applications across a cluster of machines, ensuring high availability and scaling.

### Kubernetes Architecture & Components

#### Kubernetes Architecture

- **Master Node**: Manages the cluster.
- **Worker Nodes**: Run the application containers.

#### Key Components

- **Pod**: The smallest deployable unit, containing one or more containers.
- **Service**: Exposes a set of Pods as a network service.
- **Ingress**: Manages external access to services.
- **ConfigMap**: Stores configuration data.
- **Secret**: Stores sensitive data.
- **Volume**: Provides storage to Pods.
- **Deployment**: Manages application deployment.
- **StatefulSet**: Manages stateful applications.

### Developing Locally

#### Minikube and kubectl

- **Install Minikube and kubectl:**

```bash
# On Linux
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube

# On macOS
brew install minikube kubectl
```

- **Start Minikube:**

```bash
minikube start
```

- **Verify kubectl Configuration:**

```bash
kubectl cluster-info
```

#### Create Deployment

Example `deployment.yaml`:

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
        image: myimage:latest
        ports:
        - containerPort: 8080
```

```bash
kubectl apply -f deployment.yaml
```

#### Debugging Pods

- **List Pods:**

```bash
kubectl get pods
```

- **Describe Pod:**

```bash
kubectl describe pod mypod
```

- **Get Logs:**

```bash
kubectl logs mypod
```

- **Exec into a Pod:**

```bash
kubectl exec -it mypod -- /bin/sh
```

### Project: MongoDB and Mongo Express

#### Deploying MongoDB and Mongo Express

1. **MongoDB Pod**

`mongo-pod.yaml`:

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: mongodb
spec:
  containers:
  - name: mongodb
    image: mongo:latest
    ports:
    - containerPort: 27017
```

2. **Secret**

`mongodb-secret.yaml`:

```yaml
apiVersion: v1
kind: Secret


metadata:
  name: mongodb-secret
type: Opaque
data:
  mongodb-root-password: <base64-encoded-password>
```

3. **MongoDB Internal Service**

`mongodb-service.yaml`:

```yaml
apiVersion: v1
kind: Service
metadata:
  name: mongodb
spec:
  ports:
  - port: 27017
  selector:
    app: mongodb
```

4. **Deployment Service and Config Map**

`mongodb-configmap.yaml`:

```yaml
apiVersion: v1
kind: ConfigMap
metadata:
  name: mongodb-config
data:
  mongodb.config.json: |
    {
      "storage": {
        "dbPath": "/data/db"
      }
    }
```

5. **Mongo Express External Service**

`mongo-express.yaml`:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: mongo-express
spec:
  replicas: 1
  selector:
    matchLabels:
      app: mongo-express
  template:
    metadata:
      labels:
        app: mongo-express
    spec:
      containers:
      - name: mongo-express
        image: mongo-express:latest
        ports:
        - containerPort: 8081
        env:
        - name: ME_CONFIG_MONGODB_SERVER
          value: mongodb
        - name: ME_CONFIG_MONGODB_PORT
          value: "27017"
---
apiVersion: v1
kind: Service
metadata:
  name: mongo-express
spec:
  ports:
  - port: 8081
  selector:
    app: mongo-express
```

These configurations and commands provide a comprehensive guide to working with Docker and Kubernetes. Adjust configurations and commands based on your specific project requirements and environment.
In this complete Docker and Kubernetes tutorial Nana from Techworld With Nana and I have collaborated to teach you the fundamentals of docker and Kubernetes. There will be 2 parts. Docker tutorial and Kubernetes tutorial. 

Starting with docker for beginners to all you need to know about creating docker images, running docker containers, docker volumes, container registry and docker architecture.

Then Kubernetes turorial for beginners including Kubernetes architecture, Kubernetes pods, services, config maps all the way to Kubernetes deployments.

You will learn the differences between docker vs Kubernetes allowing to start using these two technologies with confidence upon course completion

This course is very hands on. So if you prefer you can enrol for free on my website: 


Introduction to Docker
0:00 - Introduction
2:34 - Course Overview
5:03 - What is Docker
9:34 - Installing Docker
12:56 - Verify Installation
Microsoft Windows [Version 10.0.19045.4651]
(c) Microsoft Corporation. All rights reserved.

C:\windows\system32>docker

Usage:  docker [OPTIONS] COMMAND

A self-sufficient runtime for containers

Common Commands:
  run         Create and run a new container from an image
  exec        Execute a command in a running container
  ps          List containers
  build       Build an image from a Dockerfile
  pull        Download an image from a registry
  push        Upload an image to a registry
  images      List images
  login       Log in to a registry
  logout      Log out from a registry
  search      Search Docker Hub for images
  version     Show the Docker version information
  info        Display system-wide information

Management Commands:
  builder     Manage builds
  buildx*     Docker Buildx
  checkpoint  Manage checkpoints
  compose*    Docker Compose
  container   Manage containers
  context     Manage contexts
  debug*      Get a shell into any image or container
  desktop*    Docker Desktop commands (Alpha)
  dev*        Docker Dev Environments
  extension*  Manages Docker extensions
  feedback*   Provide feedback, right in your terminal!
  image       Manage images
  init*       Creates Docker-related starter files for your project
  manifest    Manage Docker image manifests and manifest lists
  network     Manage networks
  plugin      Manage plugins
  sbom*       View the packaged-based Software Bill Of Materials (SBOM) for an image
  scout*      Docker Scout
  system      Manage Docker
  trust       Manage trust on Docker images
  volume      Manage volumes

Swarm Commands:
  config      Manage Swarm configs
  node        Manage Swarm nodes
  secret      Manage Swarm secrets
  service     Manage Swarm services
  stack       Manage Swarm stacks
  swarm       Manage Swarm

Commands:
  attach      Attach local standard input, output, and error streams to a running container
  commit      Create a new image from a container's changes
  cp          Copy files/folders between a container and the local filesystem
  create      Create a new container
  diff        Inspect changes to files or directories on a container's filesystem
  events      Get real time events from the server
  export      Export a container's filesystem as a tar archive
  history     Show the history of an image
  import      Import the contents from a tarball to create a filesystem image
  inspect     Return low-level information on Docker objects
  kill        Kill one or more running containers
  load        Load an image from a tar archive or STDIN
  logs        Fetch the logs of a container
  pause       Pause all processes within one or more containers
  port        List port mappings or a specific mapping for the container
  rename      Rename a container
  restart     Restart one or more containers
  rm          Remove one or more containers
  rmi         Remove one or more images
  save        Save one or more images to a tar archive (streamed to STDOUT by default)
  start       Start one or more stopped containers
  stats       Display a live stream of container(s) resource usage statistics
  stop        Stop one or more running containers
  tag         Create a tag TARGET_IMAGE that refers to SOURCE_IMAGE
  top         Display the running processes of a container
  unpause     Unpause all processes within one or more containers
  update      Update configuration of one or more containers
  wait        Block until one or more containers stop, then print their exit codes

Global Options:
      --config string      Location of client config files (default
                           "C:\\Users\\HP\\.docker")
  -c, --context string     Name of the context to use to connect to the
                           daemon (overrides DOCKER_HOST env var and
                           default context set with "docker context use")
  -D, --debug              Enable debug mode
  -H, --host list          Daemon socket to connect to
  -l, --log-level string   Set the logging level ("debug", "info",
                           "warn", "error", "fatal") (default "info")
      --tls                Use TLS; implied by --tlsverify
      --tlscacert string   Trust certs signed only by this CA (default
                           "C:\\Users\\HP\\.docker\\ca.pem")
      --tlscert string     Path to TLS certificate file (default
                           "C:\\Users\\HP\\.docker\\cert.pem")
      --tlskey string      Path to TLS key file (default
                           "C:\\Users\\HP\\.docker\\key.pem")
      --tlsverify          Use TLS and verify the remote
  -v, --version            Print version information and quit

Run 'docker COMMAND --help' for more information on a command.

For more help on how to use Docker, head to https://docs.docker.com/go/guides/

C:\windows\system32>docker --version
Docker version 27.0.3, build 7d4bcd8

C:\windows\system32>docker ps
error during connect: Get "http://%2F%2F.%2Fpipe%2FdockerDesktopLinuxEngine/v1.46/containers/json": open //./pipe/dockerDesktopLinuxEngine: The system cannot find the file specified.

C:\windows\system32>docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

C:\windows\system32>docker pull nginx
Using default tag: latest
latest: Pulling from library/nginx
efc2b5ad9eec: Pull complete
8fe9a55eb80f: Pull complete
045037a63be8: Pull complete
7111b42b4bfa: Pull complete
3dfc528a4df9: Pull complete
9e891cdb453b: Pull complete
0f11e17345c5: Pull complete
Digest: sha256:6af79ae5de407283dcea8b00d5c37ace95441fd58a8b1d2aa1ed93f5511bb18c
Status: Downloaded newer image for nginx:latest
docker.io/library/nginx:latest

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview nginx

C:\windows\system32>docker images
REPOSITORY                    TAG       IMAGE ID       CREATED        SIZE
nginx                         latest    a72860cb95fd   6 weeks ago    188MB
gcr.io/k8s-minikube/kicbase   v0.0.44   5a6e59a9bdc0   2 months ago   1.26GB

C:\windows\system32>docker run nginx:latest
/docker-entrypoint.sh: /docker-entrypoint.d/ is not empty, will attempt to perform configuration
/docker-entrypoint.sh: Looking for shell scripts in /docker-entrypoint.d/
/docker-entrypoint.sh: Launching /docker-entrypoint.d/10-listen-on-ipv6-by-default.sh
10-listen-on-ipv6-by-default.sh: info: Getting the checksum of /etc/nginx/conf.d/default.conf
10-listen-on-ipv6-by-default.sh: info: Enabled listen on IPv6 in /etc/nginx/conf.d/default.conf
/docker-entrypoint.sh: Sourcing /docker-entrypoint.d/15-local-resolvers.envsh
/docker-entrypoint.sh: Launching /docker-entrypoint.d/20-envsubst-on-templates.sh
/docker-entrypoint.sh: Launching /docker-entrypoint.d/30-tune-worker-processes.sh
/docker-entrypoint.sh: Configuration complete; ready for start up
2024/08/05 00:37:35 [notice] 1#1: using the "epoll" event method
2024/08/05 00:37:35 [notice] 1#1: nginx/1.27.0
2024/08/05 00:37:35 [notice] 1#1: built by gcc 12.2.0 (Debian 12.2.0-14)
2024/08/05 00:37:35 [notice] 1#1: OS: Linux 5.15.153.1-microsoft-standard-WSL2
2024/08/05 00:37:35 [notice] 1#1: getrlimit(RLIMIT_NOFILE): 1048576:1048576
2024/08/05 00:37:35 [notice] 1#1: start worker processes
2024/08/05 00:37:35 [notice] 1#1: start worker process 29
2024/08/05 00:37:35 [notice] 1#1: start worker process 30
2024/08/05 00:37:35 [notice] 1#1: start worker process 31
2024/08/05 00:37:35 [notice] 1#1: start worker process 32
2024/08/05 00:49:24 [notice] 1#1: signal 3 (SIGQUIT) received, shutting down
2024/08/05 00:49:24 [notice] 29#29: gracefully shutting down
2024/08/05 00:49:24 [notice] 30#30: gracefully shutting down
2024/08/05 00:49:24 [notice] 32#32: gracefully shutting down
2024/08/05 00:49:24 [notice] 30#30: exiting
2024/08/05 00:49:24 [notice] 29#29: exiting
2024/08/05 00:49:24 [notice] 32#32: exiting
2024/08/05 00:49:24 [notice] 30#30: exit
2024/08/05 00:49:24 [notice] 29#29: exit
2024/08/05 00:49:24 [notice] 32#32: exit
2024/08/05 00:49:24 [notice] 31#31: gracefully shutting down
2024/08/05 00:49:24 [notice] 31#31: exiting
2024/08/05 00:49:24 [notice] 31#31: exit
2024/08/05 00:49:24 [notice] 1#1: signal 17 (SIGCHLD) received from 31
2024/08/05 00:49:24 [notice] 1#1: worker process 30 exited with code 0
2024/08/05 00:49:24 [notice] 1#1: worker process 31 exited with code 0
2024/08/05 00:49:24 [notice] 1#1: worker process 32 exited with code 0
2024/08/05 00:49:24 [notice] 1#1: signal 29 (SIGIO) received
2024/08/05 00:49:24 [notice] 1#1: signal 17 (SIGCHLD) received from 29
2024/08/05 00:49:24 [notice] 1#1: worker process 29 exited with code 0
2024/08/05 00:49:24 [notice] 1#1: exit

C:\windows\system32>
Images, Containers, and Ports
15:36 - Images & Containers
17:06 - Pulling NGINX Image
21:12 - Running Containers
25:48 - Exposing Ports
30:01 - Exposing Multiple Ports
31:38 - Managing Containers
39:37 - Naming Containers
Microsoft Windows [Version 10.0.19045.4651]
(c) Microsoft Corporation. All rights reserved.

C:\Users\HP>docker container ls
CONTAINER ID   IMAGE          COMMAND                  CREATED          STATUS          PORTS     NAMES
f0acd78f9625   nginx:latest   "/docker-entrypoint.…"   31 seconds ago   Up 30 seconds   80/tcp    gallant_bell

C:\Users\HP>docker stop f0acd78f9625
f0acd78f9625

C:\Users\HP>docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

C:\Users\HP>docker run -d -p 8080:80 nginx:latest
4c7ee9baaf1fcad0154b1d12c139dc818647cb0ce35db0eae3c02792bbeda9ff

C:\Users\HP>docker ps
CONTAINER ID   IMAGE          COMMAND                  CREATED          STATUS          PORTS                  NAMES
4c7ee9baaf1f   nginx:latest   "/docker-entrypoint.…"   10 seconds ago   Up 10 seconds   0.0.0.0:8080->80/tcp   quizzical_kare

C:\Users\HP>docker stop 4c7ee9baaf1f
4c7ee9baaf1f

C:\Users\HP>docker run -d -p 3000:80 nginx:latest
b22a61b294c580c7361d442a41292bf7b4cbcf54deec80c772c229197a036e46

C:\Users\HP>docker ps
CONTAINER ID   IMAGE          COMMAND                  CREATED              STATUS              PORTS                  NAMES
b22a61b294c5   nginx:latest   "/docker-entrypoint.…"   About a minute ago   Up About a minute   0.0.0.0:3000->80/tcp   relaxed_wescoff

C:\Users\HP>docker stop b22a61b294c5
b22a61b294c5

C:\Users\HP>docker run -d -p 3000:80 8080:80 nginx:latest
Unable to find image '8080:80' locally
docker: Error response from daemon: pull access denied for 8080, repository does not exist or may require 'docker login': denied: requested access to the resource is denied.
See 'docker run --help'.

C:\Users\HP>docker run -d -p 3000:80 -p 8080:80 nginx:latest
87350baf757d640ac3d22d4462500658f54b12d1ae93ab00b260aedd0f154d1a

C:\Users\HP>docker ps
CONTAINER ID   IMAGE          COMMAND                  CREATED          STATUS          PORTS                                        NAMES
87350baf757d   nginx:latest   "/docker-entrypoint.…"   13 seconds ago   Up 12 seconds   0.0.0.0:3000->80/tcp, 0.0.0.0:8080->80/tcp   brave_hofstadter

C:\Users\HP>docker stop brave_hofstadter
brave_hofstadter

C:\Users\HP>docker start brave_hofstadter
brave_hofstadter

C:\Users\HP>docker ps -a
CONTAINER ID   IMAGE                                 COMMAND                  CREATED          STATUS                      PORTS                                        NAMES
87350baf757d   nginx:latest                          "/docker-entrypoint.…"   6 minutes ago    Up 2 minutes                0.0.0.0:3000->80/tcp, 0.0.0.0:8080->80/tcp   brave_hofstadter
b22a61b294c5   nginx:latest                          "/docker-entrypoint.…"   8 minutes ago    Exited (0) 7 minutes ago                                                 relaxed_wescoff
4c7ee9baaf1f   nginx:latest                          "/docker-entrypoint.…"   12 minutes ago   Exited (0) 9 minutes ago                                                 quizzical_kare
f0acd78f9625   nginx:latest                          "/docker-entrypoint.…"   25 minutes ago   Exited (0) 13 minutes ago                                                gallant_bell
dd0da265f12b   gcr.io/k8s-minikube/kicbase:v0.0.44   "/usr/local/bin/entr…"   6 days ago       Exited (130) 6 days ago                                                  minikube

Volumes
45:38 - Volumes
49:47 -  Volumes Between Host and Container
57:53 - Customize Website
1:00:48 - Volumes Between Containers

Microsoft Windows [Version 10.0.19045.4651]
(c) Microsoft Corporation. All rights reserved.

C:\Users\HP>docker ps
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES

C:\Users\HP>docker ps -a
CONTAINER ID   IMAGE                                 COMMAND                  CREATED             STATUS                         PORTS                                        NAMES
a5600743f023   nginx:latest                          "/docker-entrypoint.…"   About an hour ago   Exited (255) 49 seconds ago    0.0.0.0:9000->80/tcp                         website-two
ff4ffe4e1162   nginx:latest                          "/docker-entrypoint.…"   About an hour ago   Exited (255) 49 seconds ago    0.0.0.0:3000->80/tcp, 0.0.0.0:8080->80/tcp   website
afa01d9db5e4   nginx:latest                          "/docker-entrypoint.…"   About an hour ago   Created                                                                     vigilant_mahavira
87350baf757d   nginx:latest                          "/docker-entrypoint.…"   3 hours ago         Exited (0) About an hour ago                                                brave_hofstadter
4c7ee9baaf1f   nginx:latest                          "/docker-entrypoint.…"   3 hours ago         Exited (0) 3 hours ago                                                      quizzical_kare
f0acd78f9625   nginx:latest                          "/docker-entrypoint.…"   4 hours ago         Exited (0) 3 hours ago                                                      gallant_bell
dd0da265f12b   gcr.io/k8s-minikube/kicbase:v0.0.44   "/usr/local/bin/entr…"   6 days ago          Exited (130) 6 days ago                                                     minikube

C:\Users\HP>docker stop website
website

C:\Users\HP>docker rm website
website

C:\Users\HP>cd desktop
The system cannot find the path specified.

C:\Users\HP>cd C:\Users\HP\OneDrive\Desktop\website

C:\Users\HP\OneDrive\Desktop\website>ls
'ls' is not recognized as an internal or external command,
operable program or batch file.

C:\Users\HP\OneDrive\Desktop\website>dir
 Volume in drive C is Windows
 Volume Serial Number is 9AC2-15F9

 Directory of C:\Users\HP\OneDrive\Desktop\website

05-08-2024  09:36    <DIR>          .
05-08-2024  09:36    <DIR>          ..
05-08-2024  09:36                31 index.html
               1 File(s)             31 bytes
               2 Dir(s)  150,772,441,088 bytes free

C:\Users\HP\OneDrive\Desktop\website>docker run --name website -v $(pwd):/usr/share/nginx/html:ro -d -p 8080:80 nginx
docker: Error response from daemon: create $(pwd): "$(pwd)" includes invalid characters for a local volume name, only "[a-zA-Z0-9][a-zA-Z0-9_.-]" are allowed. If you intended to pass a host directory, use absolute path.
See 'docker run --help'.

C:\Users\HP\OneDrive\Desktop\website>docker run --name website -v C:\Users\HP\OneDrive\Desktop\website:/usr/share/nginx/html:ro -d -p 8080:80 nginx
3efff8bfdf3951240dab2cca1adc97aaff3c5ebe533f24190e0a0e8ca87a7d10

C:\Users\HP\OneDrive\Desktop\website>docker exec -it website bash
root@3efff8bfdf39:/# ls -al
total 72
drwxr-xr-x   1 root root 4096 Aug  5 04:12 .
drwxr-xr-x   1 root root 4096 Aug  5 04:12 ..
-rwxr-xr-x   1 root root    0 Aug  5 04:12 .dockerenv
lrwxrwxrwx   1 root root    7 Jul 22 00:00 bin -> usr/bin
drwxr-xr-x   2 root root 4096 Mar 29 17:20 boot
drwxr-xr-x   5 root root  340 Aug  5 04:12 dev
drwxr-xr-x   1 root root 4096 Jul 23 07:14 docker-entrypoint.d
-rwxr-xr-x   1 root root 1620 Jul 23 07:14 docker-entrypoint.sh
drwxr-xr-x   1 root root 4096 Aug  5 04:12 etc
drwxr-xr-x   2 root root 4096 Mar 29 17:20 home
lrwxrwxrwx   1 root root    7 Jul 22 00:00 lib -> usr/lib
lrwxrwxrwx   1 root root    9 Jul 22 00:00 lib64 -> usr/lib64
drwxr-xr-x   2 root root 4096 Jul 22 00:00 media
drwxr-xr-x   2 root root 4096 Jul 22 00:00 mnt
drwxr-xr-x   2 root root 4096 Jul 22 00:00 opt
dr-xr-xr-x 184 root root    0 Aug  5 04:12 proc
drwx------   2 root root 4096 Jul 22 00:00 root
drwxr-xr-x   1 root root 4096 Aug  5 04:12 run
lrwxrwxrwx   1 root root    8 Jul 22 00:00 sbin -> usr/sbin
drwxr-xr-x   2 root root 4096 Jul 22 00:00 srv
dr-xr-xr-x  11 root root    0 Aug  5 04:12 sys
drwxrwxrwt   2 root root 4096 Jul 22 00:00 tmp
drwxr-xr-x   1 root root 4096 Jul 22 00:00 usr
drwxr-xr-x   1 root root 4096 Jul 22 00:00 var
root@3efff8bfdf39:/# cd /usr/shared/nginx/html
bash: cd: /usr/shared/nginx/html: No such file or directory
root@3efff8bfdf39:/# cd /usr/share/nginx/html
root@3efff8bfdf39:/usr/share/nginx/html# ls -al
total 4
drwxrwxrwx 1 root root 4096 Aug  5 04:06 .
drwxr-xr-x 3 root root 4096 Jul 23 07:14 ..
-rwxrwxrwx 1 root root   31 Aug  5 04:06 index.html
root@3efff8bfdf39:/usr/share/nginx/html# touch about.html
touch: cannot touch 'about.html': Read-only file system
root@3efff8bfdf39:/usr/share/nginx/html#
exit

What's next:
    Try Docker Debug for seamless, persistent debugging tools in any container or image → docker debug website
    Learn more at https://docs.docker.com/go/debug-cli/

C:\Users\HP\OneDrive\Desktop\website>docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED         STATUS         PORTS                  NAMES
3efff8bfdf39   nginx     "/docker-entrypoint.…"   4 minutes ago   Up 4 minutes   0.0.0.0:8080->80/tcp   website

C:\Users\HP\OneDrive\Desktop\website>docker rm -f website
website

C:\Users\HP\OneDrive\Desktop\website>docker run --name website -v C:\Users\HP\OneDrive\Desktop\website:/usr/share/nginx/html -d -p 8080:80 nginx
3372d3013344b212a5481f32761bf351864d82eed659ebe4bb3d522c33941428

C:\Users\HP\OneDrive\Desktop\website>docker exec -it website bash
root@3372d3013344:/# cd /usr/share/nginx/html
root@3372d3013344:/usr/share/nginx/html# ls -al
total 4
drwxrwxrwx 1 root root 4096 Aug  5 04:06 .
drwxr-xr-x 3 root root 4096 Jul 23 07:14 ..
-rwxrwxrwx 1 root root   31 Aug  5 04:06 index.html
root@3372d3013344:/usr/share/nginx/html# touch about.html
root@3372d3013344:/usr/share/nginx/html# ls -al
total 216
drwxrwxrwx 1 root root   4096 Aug  5 04:24 .
drwxr-xr-x 3 root root   4096 Jul 23 07:14 ..
-rwxrwxrwx 1 root root    246 Mar 25  2023 .editorconfig
-rwxrwxrwx 1 root root     22 Mar 25  2023 .gitignore
-rwxrwxrwx 1 root root   1091 Mar 25  2023 LICENSE
-rwxrwxrwx 1 root root   4756 Mar 25  2023 README.md
drwxrwxrwx 1 root root   4096 Mar 25  2023 dist
-rwxrwxrwx 1 root root 197858 Mar 25  2023 package-lock.json
-rwxrwxrwx 1 root root   1730 Mar 25  2023 package.json
drwxrwxrwx 1 root root   4096 Mar 25  2023 scripts
drwxrwxrwx 1 root root   4096 Mar 25  2023 src
root@3372d3013344:/usr/share/nginx/html#
exit

What's next:
    Try Docker Debug for seamless, persistent debugging tools in any container or image → docker debug website
    Learn more at https://docs.docker.com/go/debug-cli/

C:\Users\HP\OneDrive\Desktop\website>docker run --name website-copy --volumes-from website -d -p 8081:80 nginx
834e84300adf8a111dccf4418750448bafecc0e781fe5f81348bd0c14a2123b4

C:\Users\HP\OneDrive\Desktop\website>
Building Images

Microsoft Windows [Version 10.0.19045.4651]
(c) Microsoft Corporation. All rights reserved.

C:\Users\HP>cd C:\Users\HP\OneDrive\Desktop\user-service-api

C:\Users\HP\OneDrive\Desktop\user-service-api>node --version
v20.16.0

C:\Users\HP\OneDrive\Desktop\user-service-api>npm init
This utility will walk you through creating a package.json file.
It only covers the most common items, and tries to guess sensible defaults.

See `npm help init` for definitive documentation on these fields
and exactly what they do.

Use `npm install <pkg>` afterwards to install a package and
save it as a dependency in the package.json file.

Press ^C at any time to quit.
package name: (user-service-api)
version: (1.0.0)
description:
entry point: (index.js)
test command:
git repository:
keywords:
author:
license: (ISC)
About to write to C:\Users\HP\OneDrive\Desktop\user-service-api\package.json:

{
  "name": "user-service-api",
  "version": "1.0.0",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC",
  "description": ""
}


Is this OK? (yes) yes

npm notice
npm notice New patch version of npm available! 10.8.1 -> 10.8.2
npm notice Changelog: https://github.com/npm/cli/releases/tag/v10.8.2
npm notice To update run: npm install -g npm@10.8.2
npm notice

C:\Users\HP\OneDrive\Desktop\user-service-api>ll
'll' is not recognized as an internal or external command,
operable program or batch file.

C:\Users\HP\OneDrive\Desktop\user-service-api>dir
 Volume in drive C is Windows
 Volume Serial Number is 9AC2-15F9

 Directory of C:\Users\HP\OneDrive\Desktop\user-service-api

05-08-2024  17:51    <DIR>          .
05-08-2024  17:51    <DIR>          ..
05-08-2024  17:51               212 package.json
               1 File(s)            212 bytes
               2 Dir(s)  156,428,390,400 bytes free

C:\Users\HP\OneDrive\Desktop\user-service-api>npm install --save express

added 64 packages, and audited 65 packages in 9s

12 packages are looking for funding
  run `npm fund` for details

found 0 vulnerabilities

C:\Users\HP\OneDrive\Desktop\user-service-api>dir
 Volume in drive C is Windows
 Volume Serial Number is 9AC2-15F9

 Directory of C:\Users\HP\OneDrive\Desktop\user-service-api

05-08-2024  17:55    <DIR>          .
05-08-2024  17:55    <DIR>          ..
05-08-2024  17:55               228 index.js
05-08-2024  17:52    <DIR>          node_modules
05-08-2024  17:52            27,052 package-lock.json
05-08-2024  17:52               262 package.json
               3 File(s)         27,542 bytes
               3 Dir(s)  156,096,135,168 bytes free

C:\Users\HP\OneDrive\Desktop\user-service-api>node index.js
Example app listening on port 3000
^C
C:\Users\HP\OneDrive\Desktop\user-service-api>node index.js
Example app listening on port 3000
^C
C:\Users\HP\OneDrive\Desktop\user-service-api>node index.js
Example app listening on port 3000
^C
C:\Users\HP\OneDrive\Desktop\user-service-api>docker build Dockerfile -t user-service-api:latest .
ERROR: "docker buildx build" requires exactly 1 argument.
See 'docker buildx build --help'.

Usage:  docker buildx build [OPTIONS] PATH | URL | -

Start a build

C:\Users\HP\OneDrive\Desktop\user-service-api>docker build -t user-service-api:latest .
[+] Building 0.1s (1/1) FINISHED                                                                                                                       docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                   0.1s
 => => transferring dockerfile: 31B                                                                                                                                    0.0s
ERROR: failed to solve: the Dockerfile cannot be empty

C:\Users\HP\OneDrive\Desktop\user-service-api>docker build -t user-service-api:latest .
[+] Building 0.1s (1/1) FINISHED                                                                                                                       docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                   0.0s
 => => transferring dockerfile: 113B                                                                                                                                   0.0s
Dockerfile:3
--------------------
   1 |     FROM node:latest
   2 |     WORKDIR /app
   3 | >>> ADDD . .
   4 |     RUN npm install
   5 |     CMD node index.js
--------------------
ERROR: failed to solve: dockerfile parse error on line 3: unknown instruction: ADDD (did you mean ADD?)

C:\Users\HP\OneDrive\Desktop\user-service-api>docker build -t user-service-api:latest .
[+] Building 873.0s (9/9) FINISHED                                                                                                                     docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                   0.0s
 => => transferring dockerfile: 112B                                                                                                                                   0.0s
 => [internal] load metadata for docker.io/library/node:latest                                                                                                         5.1s
 => [internal] load .dockerignore                                                                                                                                      0.0s
 => => transferring context: 2B                                                                                                                                        0.0s
 => [1/4] FROM docker.io/library/node:latest@sha256:86915971d2ce1548842315fcce7cda0da59319a4dab6b9fc0827e762ef04683a                                                 864.5s
 => => resolve docker.io/library/node:latest@sha256:86915971d2ce1548842315fcce7cda0da59319a4dab6b9fc0827e762ef04683a                                                   0.0s
 => => sha256:ca4e5d6727252f0dbc207fbf283cb95e278bf562bda42d35ce6c919583a110a0 49.55MB / 49.55MB                                                                     328.2s
 => => sha256:a06fbbb263de33a720cdfc83a490de7e49cf27b0c672fc36dae1bff658b7178b 2.49kB / 2.49kB                                                                         0.0s
 => => sha256:b966edc80bd3ac6f33caa225b973225f65aceb35309a20257d38ab0c361a91d7 6.55kB / 6.55kB                                                                         0.0s
 => => sha256:86915971d2ce1548842315fcce7cda0da59319a4dab6b9fc0827e762ef04683a 6.41kB / 6.41kB                                                                         0.0s
 => => sha256:30b93c12a9c9326732b35d9e3ebe57148abe33f8fa6e25ab76867410b0ccf876 24.05MB / 24.05MB                                                                     175.6s
 => => sha256:10d643a5fa823cd013a108b2076f4d2edf1b2a921f863b533e83ea5ed8d09bd4 64.14MB / 64.14MB                                                                     394.4s
 => => sha256:d6dc1019d7935fe82827434da11bf96cf14e24979f8155e73b794286f10b7f05 211.24MB / 211.24MB                                                                   852.0s
 => => extracting sha256:ca4e5d6727252f0dbc207fbf283cb95e278bf562bda42d35ce6c919583a110a0                                                                              3.2s
 => => sha256:63824f9ef39780d5771ca7d6ec172805135c58e65d275728e90c7455f513f3b8 3.32kB / 3.32kB                                                                       331.5s
 => => sha256:50fc95442b3dcf226696593e95e3a85ef92b19b63390d2aef2549fa6dd605372 53.11MB / 53.11MB                                                                     573.4s
 => => extracting sha256:30b93c12a9c9326732b35d9e3ebe57148abe33f8fa6e25ab76867410b0ccf876                                                                              0.8s
 => => extracting sha256:10d643a5fa823cd013a108b2076f4d2edf1b2a921f863b533e83ea5ed8d09bd4                                                                              4.3s
 => => sha256:9e3b63b7d03839fc150e4d82b2405a89f6d5c539846a65e70530f12421f703d6 1.25MB / 1.25MB                                                                       405.2s
 => => sha256:18bb0bf9b4dcd97ffc178a0cf00e13b4e9a082c9d07738c9f30e1836bca7f6e2 449B / 449B                                                                           406.9s
 => => extracting sha256:d6dc1019d7935fe82827434da11bf96cf14e24979f8155e73b794286f10b7f05                                                                              8.4s
 => => extracting sha256:63824f9ef39780d5771ca7d6ec172805135c58e65d275728e90c7455f513f3b8                                                                              0.0s
 => => extracting sha256:50fc95442b3dcf226696593e95e3a85ef92b19b63390d2aef2549fa6dd605372                                                                              3.4s
 => => extracting sha256:9e3b63b7d03839fc150e4d82b2405a89f6d5c539846a65e70530f12421f703d6                                                                              0.1s
 => => extracting sha256:18bb0bf9b4dcd97ffc178a0cf00e13b4e9a082c9d07738c9f30e1836bca7f6e2                                                                              0.0s
 => [internal] load build context                                                                                                                                      3.0s
 => => transferring context: 2.21MB                                                                                                                                    3.0s
 => [2/4] WORKDIR /app                                                                                                                                                 0.6s
 => [3/4] ADD . .                                                                                                                                                      0.2s
 => [4/4] RUN npm install                                                                                                                                              2.2s
 => exporting to image                                                                                                                                                 0.2s
 => => exporting layers                                                                                                                                                0.1s
 => => writing image sha256:a18f5e68fd49bcea7500f7cae901efe42c0016738b4290a62de504f4fa9d9760                                                                           0.0s
 => => naming to docker.io/library/user-service-api:latest                                                                                                             0.0s

 1 warning found (use --debug to expand):
 - JSONArgsRecommended: JSON arguments recommended for CMD to prevent unintended behavior related to OS signals (line 5)

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview

C:\Users\HP\OneDrive\Desktop\user-service-api>docker image ls
REPOSITORY                    TAG       IMAGE ID       CREATED        SIZE
user-service-api              latest    a18f5e68fd49   2 hours ago    1.11GB
nginx                         latest    a72860cb95fd   6 weeks ago    188MB
gcr.io/k8s-minikube/kicbase   v0.0.44   5a6e59a9bdc0   2 months ago   1.26GB

C:\Users\HP\OneDrive\Desktop\user-service-api>docker run --name user-api -d -p 3000:3000 user-service-api:latest
5929987301bfc834c22edeba3766f1eea57564dc855e1d0f8a3151f9038daf78

C:\Users\HP\OneDrive\Desktop\user-service-api>docker ps
CONTAINER ID   IMAGE                     COMMAND                  CREATED          STATUS          PORTS                    NAMES
5929987301bf   user-service-api:latest   "docker-entrypoint.s…"   19 seconds ago   Up 18 seconds   0.0.0.0:3000->3000/tcp   user-api
b450fe855ee2   nginx                     "/docker-entrypoint.…"   35 minutes ago   Up 35 minutes   0.0.0.0:6060->80/tcp     Real-Estate-Management-System

C:\Users\HP\OneDrive\Desktop\user-service-api>node index.js
node:internal/modules/cjs/loader:1148
  throw err;
  ^

Error: Cannot find module 'express'
Require stack:
- C:\Users\HP\OneDrive\Desktop\user-service-api\index.js
    at Module._resolveFilename (node:internal/modules/cjs/loader:1145:15)
    at Module._load (node:internal/modules/cjs/loader:986:27)
    at Module.require (node:internal/modules/cjs/loader:1233:19)
    at require (node:internal/modules/helpers:179:18)
    at Object.<anonymous> (C:\Users\HP\OneDrive\Desktop\user-service-api\index.js:1:17)
    at Module._compile (node:internal/modules/cjs/loader:1358:14)
    at Module._extensions..js (node:internal/modules/cjs/loader:1416:10)
    at Module.load (node:internal/modules/cjs/loader:1208:32)
    at Module._load (node:internal/modules/cjs/loader:1024:12)
    at Function.executeUserEntryPoint [as runMain] (node:internal/modules/run_main:174:12) {
  code: 'MODULE_NOT_FOUND',
  requireStack: [ 'C:\\Users\\HP\\OneDrive\\Desktop\\user-service-api\\index.js' ]
}

Node.js v20.16.0

C:\Users\HP\OneDrive\Desktop\user-service-api>npm i

added 64 packages, and audited 65 packages in 2s

12 packages are looking for funding
  run `npm fund` for details

found 0 vulnerabilities

C:\Users\HP\OneDrive\Desktop\user-service-api>node index.js
node:events:497
      throw er; // Unhandled 'error' event
      ^

Error: listen EADDRINUSE: address already in use :::3000
    at Server.setupListenHandle [as _listen2] (node:net:1904:16)
    at listenInCluster (node:net:1961:12)
    at Server.listen (node:net:2063:7)
    at Function.listen (C:\Users\HP\OneDrive\Desktop\user-service-api\node_modules\express\lib\application.js:635:24)
    at Object.<anonymous> (C:\Users\HP\OneDrive\Desktop\user-service-api\index.js:14:5)
    at Module._compile (node:internal/modules/cjs/loader:1358:14)
    at Module._extensions..js (node:internal/modules/cjs/loader:1416:10)
    at Module.load (node:internal/modules/cjs/loader:1208:32)
    at Module._load (node:internal/modules/cjs/loader:1024:12)
    at Function.executeUserEntryPoint [as runMain] (node:internal/modules/run_main:174:12)
Emitted 'error' event on Server instance at:
    at emitErrorNT (node:net:1940:8)
    at process.processTicksAndRejections (node:internal/process/task_queues:82:21) {
  code: 'EADDRINUSE',
  errno: -4091,
  syscall: 'listen',
  address: '::',
  port: 3000
}

Node.js v20.16.0

C:\Users\HP\OneDrive\Desktop\user-service-api>node index.js
Example app listening on port 3000
^C
C:\Users\HP\OneDrive\Desktop\user-service-api>npm install -S react webpack gulp grunt
npm warn deprecated osenv@0.1.5: This package is no longer supported.
npm warn deprecated inflight@1.0.6: This module is not supported, and leaks memory. Do not use it. Check out lru-cache if you want a good and tested way to coalesce async requests by a key value, which is much more comprehensive and powerful.
npm warn deprecated glob@7.1.7: Glob versions prior to v9 are no longer supported

added 260 packages, and audited 325 packages in 1m

33 packages are looking for funding
  run `npm fund` for details

found 0 vulnerabilities

C:\Users\HP\OneDrive\Desktop\user-service-api>docker build -t user-service-api:latest .
[+] Building 23.2s (9/9) FINISHED                                                                                                                      docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                   0.0s
 => => transferring dockerfile: 112B                                                                                                                                   0.0s
 => [internal] load metadata for docker.io/library/node:latest                                                                                                         3.2s
 => [internal] load .dockerignore                                                                                                                                      0.0s
 => => transferring context: 70B                                                                                                                                       0.0s
 => [1/4] FROM docker.io/library/node:latest@sha256:86915971d2ce1548842315fcce7cda0da59319a4dab6b9fc0827e762ef04683a                                                   0.0s
 => [internal] load build context                                                                                                                                      0.2s
 => => transferring context: 137.25kB                                                                                                                                  0.1s
 => CACHED [2/4] WORKDIR /app                                                                                                                                          0.0s
 => [3/4] ADD . .                                                                                                                                                      0.1s
 => [4/4] RUN npm install                                                                                                                                             18.5s
 => exporting to image                                                                                                                                                 1.1s
 => => exporting layers                                                                                                                                                1.0s
 => => writing image sha256:d3b772c4178d00d23ffbce5367e0b7970d91840af319a4f876787c2b66641630                                                                           0.0s
 => => naming to docker.io/library/user-service-api:latest                                                                                                             0.0s

 1 warning found (use --debug to expand):
 - JSONArgsRecommended: JSON arguments recommended for CMD to prevent unintended behavior related to OS signals (line 5)

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview

C:\Users\HP\OneDrive\Desktop\user-service-api>docker run --name user-api -d -p 3000:3000 user-service-api:latest
docker: Error response from daemon: Conflict. The container name "/user-api" is already in use by container "5929987301bfc834c22edeba3766f1eea57564dc855e1d0f8a3151f9038daf78". You have to remove (or rename) that container to be able to reuse that name.
See 'docker run --help'.

C:\Users\HP\OneDrive\Desktop\user-service-api>docker rm -f user-api
user-api

C:\Users\HP\OneDrive\Desktop\user-service-api>docker run --name user-api -d -p 3000:3000 user-service-api:latest
895f8a8c686d6f0e627935740ec4b9a2128763f966d353d107fe3e1c6a2ed73f

C:\Users\HP\OneDrive\Desktop\user-service-api>docker build -t user-service-api:latest .
[+] Building 18.8s (9/9) FINISHED                                                                                                                      docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                   0.0s
 => => transferring dockerfile: 112B                                                                                                                                   0.0s
 => [internal] load metadata for docker.io/library/node:latest                                                                                                         2.8s
 => [internal] load .dockerignore                                                                                                                                      0.0s
 => => transferring context: 70B                                                                                                                                       0.0s
 => [1/4] FROM docker.io/library/node:latest@sha256:86915971d2ce1548842315fcce7cda0da59319a4dab6b9fc0827e762ef04683a                                                   0.0s
 => [internal] load build context                                                                                                                                      0.0s
 => => transferring context: 570B                                                                                                                                      0.0s
 => CACHED [2/4] WORKDIR /app                                                                                                                                          0.0s
 => [3/4] ADD . .                                                                                                                                                      0.0s
 => [4/4] RUN npm install                                                                                                                                             14.8s
 => exporting to image                                                                                                                                                 0.9s
 => => exporting layers                                                                                                                                                0.9s
 => => writing image sha256:43eec05d380a7909785eb43a199614e2ff81806014b5f5d541ff1dc2cfb151ef                                                                           0.0s
 => => naming to docker.io/library/user-service-api:latest                                                                                                             0.0s

 1 warning found (use --debug to expand):
 - JSONArgsRecommended: JSON arguments recommended for CMD to prevent unintended behavior related to OS signals (line 5)

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview

C:\Users\HP\OneDrive\Desktop\user-service-api>docker build -t user-service-api:latest .
[+] Building 15.0s (10/10) FINISHED                                                                                                                    docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                   0.0s
 => => transferring dockerfile: 133B                                                                                                                                   0.0s
 => [internal] load metadata for docker.io/library/node:latest                                                                                                         1.7s
 => [internal] load .dockerignore                                                                                                                                      0.0s
 => => transferring context: 70B                                                                                                                                       0.0s
 => [1/5] FROM docker.io/library/node:latest@sha256:86915971d2ce1548842315fcce7cda0da59319a4dab6b9fc0827e762ef04683a                                                   0.0s
 => [internal] load build context                                                                                                                                      0.0s
 => => transferring context: 132B                                                                                                                                      0.0s
 => CACHED [2/5] WORKDIR /app                                                                                                                                          0.0s
 => [3/5] ADD package*.json .                                                                                                                                          0.0s
 => [4/5] RUN npm install                                                                                                                                             12.1s
 => [5/5] ADD . .                                                                                                                                                      0.1s
 => exporting to image                                                                                                                                                 0.9s
 => => exporting layers                                                                                                                                                0.8s
 => => writing image sha256:7ba862dff670e6e0da85334ece7339d3bd75ad186ad68af6911e42e91abca405                                                                           0.0s
 => => naming to docker.io/library/user-service-api:latest                                                                                                             0.0s

 1 warning found (use --debug to expand):
 - JSONArgsRecommended: JSON arguments recommended for CMD to prevent unintended behavior related to OS signals (line 6)

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview

C:\Users\HP\OneDrive\Desktop\user-service-api>docker build -t user-service-api:latest .
[+] Building 16.6s (10/10) FINISHED                                                                                                                    docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                   0.0s
 => => transferring dockerfile: 134B                                                                                                                                   0.0s
 => [internal] load metadata for docker.io/library/node:latest                                                                                                         2.6s
 => [internal] load .dockerignore                                                                                                                                      0.0s
 => => transferring context: 70B                                                                                                                                       0.0s
 => [1/5] FROM docker.io/library/node:latest@sha256:86915971d2ce1548842315fcce7cda0da59319a4dab6b9fc0827e762ef04683a                                                   0.0s
 => [internal] load build context                                                                                                                                      0.0s
 => => transferring context: 132B                                                                                                                                      0.0s
 => CACHED [2/5] WORKDIR /app                                                                                                                                          0.0s
 => [3/5] ADD package*.json ./                                                                                                                                         0.0s
 => [4/5] RUN npm install                                                                                                                                             12.8s
 => [5/5] ADD . .                                                                                                                                                      0.1s
 => exporting to image                                                                                                                                                 0.9s
 => => exporting layers                                                                                                                                                0.8s
 => => writing image sha256:d1a055af74d22804a2e80617bf1cd1eb7d306053141fe5be8ad0ca965e23ec15                                                                           0.0s
 => => naming to docker.io/library/user-service-api:latest                                                                                                             0.0s

 1 warning found (use --debug to expand):
 - JSONArgsRecommended: JSON arguments recommended for CMD to prevent unintended behavior related to OS signals (line 6)

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview

C:\Users\HP\OneDrive\Desktop\user-service-api>docker build -t user-service-api:latest .
[+] Building 2.2s (10/10) FINISHED                                                                                                                     docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                   0.0s
 => => transferring dockerfile: 134B                                                                                                                                   0.0s
 => [internal] load metadata for docker.io/library/node:latest                                                                                                         1.8s
 => [internal] load .dockerignore                                                                                                                                      0.0s
 => => transferring context: 70B                                                                                                                                       0.0s
 => [1/5] FROM docker.io/library/node:latest@sha256:86915971d2ce1548842315fcce7cda0da59319a4dab6b9fc0827e762ef04683a                                                   0.0s
 => [internal] load build context                                                                                                                                      0.0s
 => => transferring context: 630B                                                                                                                                      0.0s
 => CACHED [2/5] WORKDIR /app                                                                                                                                          0.0s
 => CACHED [3/5] ADD package*.json ./                                                                                                                                  0.0s
 => CACHED [4/5] RUN npm install                                                                                                                                       0.0s
 => [5/5] ADD . .                                                                                                                                                      0.0s
 => exporting to image                                                                                                                                                 0.1s
 => => exporting layers                                                                                                                                                0.1s
 => => writing image sha256:5f19f71e1ccf0e5154419d0d659f14b21a6db471274f1c7192b8dac444599300                                                                           0.0s
 => => naming to docker.io/library/user-service-api:latest                                                                                                             0.0s

 1 warning found (use --debug to expand):
 - JSONArgsRecommended: JSON arguments recommended for CMD to prevent unintended behavior related to OS signals (line 6)

What's next:
    View a summary of image vulnerabilities and recommendations → docker scout quickview

C:\Users\HP\OneDrive\Desktop\user-service-api>docker ps
CONTAINER ID   IMAGE          COMMAND                  CREATED             STATUS             PORTS                    NAMES
895f8a8c686d   d3b772c4178d   "docker-entrypoint.s…"   9 minutes ago       Up 9 minutes       0.0.0.0:3000->3000/tcp   user-api
b450fe855ee2   nginx          "/docker-entrypoint.…"   About an hour ago   Up About an hour   0.0.0.0:6060->80/tcp     Real-Estate-Management-System

C:\Users\HP\OneDrive\Desktop\user-service-api>docker rm -f user-api
user-api

C:\Users\HP\OneDrive\Desktop\user-service-api>docker run --name user-api -d -p 3000:3000 user-service-api:latest
da41f5297392c9c664a860220550d701c6768aaff63587c118751169277bc12e

C:\Users\HP\OneDrive\Desktop\user-service-api>docker ps
CONTAINER ID   IMAGE                     COMMAND                  CREATED              STATUS              PORTS                    NAMES
da41f5297392   user-service-api:latest   "docker-entrypoint.s…"   About a minute ago   Up About a minute   0.0.0.0:3000->3000/tcp   user-api
b450fe855ee2   nginx                     "/docker-entrypoint.…"   About an hour ago    Up About an hour    0.0.0.0:6060->80/tcp     Real-Estate-Management-System

C:\Users\HP\OneDrive\Desktop\user-service-api>

1:04:03 - Dockerfile
1:06:10 - Creating Dockerfile
1:11:55 - Docker Build

Project: Build an Image for an API
1:19:16 - Node JS and Express JS
1:25:50 - Dockerfile for our API
1:31:57 - Running Containers for our API

Caching and Layers
1:35:02 - .dockerignore
1:40:17 - Caching and Layers
1:45:32 - Caching and Layers Part 2

Reducing Image Size
1:51:39 - Alpine
1:54:30 - Pulling Alpine Images
2:00:02 - Using Alpine

Tags and Versioning
2:06:28 - Tags and Versions
2:09:31 - Using Tags with Versions
2:13:35 - Running Containers and Tags
2:17:23 - Tagging Override
2:20:22 - Tagging Own Images
2:25:06 - Running Containers with Different Tags

Docker Registries
2:29:58 - Docker Registry
2:32:58 - Create Docker Hub Repo
2:35:31 - Pushing Images to Docker Hub
2:41:32 - Pulling Own Images

Debugging Containers
2:46:06 - Docker Inspect
2:49:30 - Docker Logs
2:53:51 - Docker Exec

Here's a table summarizing some commonly used Docker commands along with their descriptions and explanations:

| **Command**                         | **Description**                                                | **Explanation**                                                                                         |
|-------------------------------------|----------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| `docker --version`                  | Show Docker version                                            | Displays the installed version of Docker.                                                              |
| `docker pull <image>`                | Download an image from Docker Hub                              | Fetches an image from a registry (like Docker Hub) to your local machine.                              |
| `docker run <options> <image>`       | Run a container from an image                                  | Creates and starts a container from the specified image. Options can include port mappings, environment variables, etc. |
| `docker ps`                          | List running containers                                        | Shows a list of all currently running containers.                                                       |
| `docker ps -a`                       | List all containers                                            | Lists all containers, including those that are stopped.                                                 |
| `docker images`                      | List available images                                         | Displays all images that are stored locally on your machine.                                            |
| `docker rmi <image>`                 | Remove an image                                                | Deletes a specific image from your local machine.                                                        |
| `docker rm <container>`              | Remove a container                                             | Deletes a stopped container from your system.                                                            |
| `docker exec -it <container> <command>` | Execute a command in a running container                      | Runs a command inside a running container, with `-it` for interactive mode and a terminal.             |
| `docker logs <container>`            | View logs of a container                                       | Displays the logs generated by a container.                                                              |
| `docker build -t <tag> <path>`       | Build an image from a Dockerfile                               | Creates a Docker image from a Dockerfile located at the specified path, tagging it with `<tag>`.       |
| `docker-compose up`                  | Start services defined in a `docker-compose.yml` file          | Reads the `docker-compose.yml` file and starts the defined services.                                    |
| `docker-compose down`                | Stop and remove services defined in a `docker-compose.yml` file| Stops and removes containers, networks, and volumes created by `docker-compose up`.                     |
| `docker-compose build`               | Build or rebuild services defined in a `docker-compose.yml` file | Builds or rebuilds images for services defined in the `docker-compose.yml` file.                        |
| `docker network ls`                  | List networks                                                   | Shows all networks available on your Docker engine.                                                     |
| `docker volume ls`                   | List volumes                                                    | Displays all volumes managed by Docker.                                                                  |
| `docker volume create <name>`        | Create a new volume                                            | Creates a new volume with the specified `<name>`.                                                        |
| `docker network create <name>`       | Create a new network                                           | Creates a new network with the specified `<name>`.                                                       |

This table covers basic Docker commands useful for container management, building, and networking. For more advanced usage and options, refer to Docker’s official documentation or use `docker <command> --help`.

### Execution Order Explanation:

- Check Docker Version: Verify Docker installation.
- Pull Image: Download any required base images from a registry.
- Build Image: Create your custom image if needed.
- List Images: Check the images available locally.
- Create Network: Set up networks for container communication.
- Create Volume: Prepare volumes for persistent storage.
- Run Container: Start containers from images.
- List Running Containers: Check which containers are actively running.
- View Logs: Monitor container logs for debugging.
- Execute Commands: Interact with a running container.
- Start Services: Use Docker Compose to start defined multi-container setups.
- Build Services: Rebuild Docker Compose services if needed.
- List All Containers: Review both running and stopped containers.
- List Volumes: Check all Docker-managed volumes.
- List Networks: Review all Docker-managed networks.
- Remove Container: Clean up stopped containers.
- Remove Image: Clean up unused images to free space.
- Stop and Remove Services: Clean up all services, networks, and volumes created by Docker Compose.

This sequence covers the lifecycle of working with Docker, from setting up your environment to managing and cleaning up resources.

Introduction to Kubernetes
2:57:30 - Kubernetes
2:58:35 - Course Overview
2:59:03 - What is Kubernetes

Kubernetes Architecture & Components
3:02:28 - Kubernetes Architecture
3:07:01 - Pod, Service & Ingress
3:12:51 - Config Map and Secret
3:16:05 - Volumes
3:18:06 - Deployments and Stateful Sets
3:23:25 - Components Summary

Developing Locally
3:24:23 - Minikube and kubectl
3:28:06 - Installing Minikube and kubectl
3:34:06 - Create Deployment 
3:37:17 - Debugging Pods
3:40:21 - kubectl apply -f
3:44:48 - kubectl commands summary

Project: MongoDB and Mongo Express
3:45:42 - Deploying MongoDB and Mongo Express
3:48:00 - MongoDB Pod
3:52:01 - Secret
3:58:16 - MongoDB Internal Service
4:03:08 - Deployment Service and Config Map
4:09:56 - Mongo Express External Service
