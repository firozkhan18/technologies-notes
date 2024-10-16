# Docker Kubernetes Concepts Commands

- [Introduction](#introduction)
- [Specific Section](#specific-section)
- [Docker Hub Commands](#docker-hub-commands)

### Introduction

### Specific Section

This is the specific section in the second `readme.md` file that you want to link to from the first `readme.md` file. You can provide a table of contents specific to this section here.

### Monolithic and Microservice

This is the specific section in the second `readme.md` file that you want to link to from the first `readme.md` file. You can provide a table of contents specific to this section here.

Monolithic and Microservice
We started with Monolithic & Microservice Applications, in this we explain different type of deployment methods for applications, what is the monolithic applications and drawback of it, how we can solve these drawbacks using the microservice deployment, what is the difference between Monolithic & Microservice Application, why we are using microservice type application deployment for Kubernetes.

 

micro & Monolithic

Q/A’s asked in the session:

Q) What is the difference between Microservices architecture and Monolithic architecture?
Ans: A Monolithic Application is built as a single unit that combines the user interface and database into a single program running on a single platform. A monolithic program is self-contained and unrelated to other computer programs.

Advantages of Monolithic application.

Easy to Deploy.
It can be Scaled with little Effort.
Easy to Test.
Development is Easy.
Microservices is an architectural design for developing a distributed application using containers. Microservices get their name from the fact that each function of the program runs as a separate unit. This model enables each service to scale or upgrade independently without interfering with other resources in the framework.

Advantages Of Microservices

Every service can be independently scaled.
It can be deployed independently.
It allows each service to be built separately by a team dedicated to that service.
It lowers the barrier to introducing emerging technology because developers are free to select whatever technologies make sense for their service rather than being restricted to the choices made at the outset of the project.
To know more about the Monolithic v/s Microservices

Q) Is Containers are based on N-Tier Architecture. Also, Microservice is a must for containers?
Ans: No, Container and N-Tier Architecture(monolithic) are different terms. We can use a container to deploy a N-tier application. Microservice application can be deployed without containers.

Q) Is Microservices is only for E-Commerce applications?
Ans: No, We can use it with Many of the services. Netflix is one of the good examples of microservice.

Q) Is Containers are based on N-Tier Architecture. Also, Microservice is a must for containers?
Ans: No, Container and N-Tier Architecture(monolithic) are different terms. We can use a container to deploy an N-tier application. The microservice application can be deployed without containers.

Q) Only Microservices applications are for Containers. What about larger applications, I mean more CPU more RAM more storage, those are not for Containers?
Ans: Yes we can, Containers are used to deploy any type of application, it can be small or large. Each application is running through different microservices inside its own container. You can even limit CPU & RAM in a container.

Q) What is system hardening?
Ans: Systems hardening is techniques, and best practices to reduce vulnerability in your systems or host.


FREE Kubernetes Beginners MasterClass
 

Kickstart Your Kubernetes Journey: Free Kubernetes MasterClass For Beginners!

ENROLL FOR FREE

Introduction to Docker and Container
After going through the basics of Monolithic & Microservice Applications, we started to discuss on the Docker and Container, Docker is a containerization platform which is used to create container. We can deploy our application into the Container through an image.

If you are new to the docker watch video on the Docker Tutorial for Beginners: 5 Hour Full Course [Hands-On Labs]

Q/A’s asked in the session are:

Q) What is Docker Engine?
Ans: Docker Engine is the underlying client-server technology that builds and runs containers using Docker’s components and services. When people refer to Docker they mean either Docker Engine — which comprises the Docker daemon, a REST API and the CLI that talks to the Docker daemon through the API — or the company Docker Inc., which offers various editions of containerization technology around Docker Engine.

docker

Q) Is Docker Engine and Hypervisor are used for the same purpose?
Ans: No, they are used for different purpose. A hypervisor is a kind of emulator, it is a computer software, firmware or hardware that creates and runs virtual machines(VM). On the other hand, Docker Engine runs Inside a virtual machines(VM).

To know the difference among Bare Metal (BM), VM and Container (Docker) Read our blog post

 

VM

Q) What is Containerized Application?
Ans: Containerization is a form of operating system virtualization in which programs are run in an isolated user spaces called containers while sharing the same operating system (OS). A container is a fully packaged and compact computing environment.

Q) Can we have multiple Container?
Ans: Yes, you can have multiple containers for a single application.

Q) Can we run Linux OS Container inside Windows OS and in Reverse also?
Ans: Yes, you can use a Linux container in windows or a windows container in Linux. To run the container in different operating systems, OS must support container applications running inside the container.

Q) Is Container is the product of Docker?
Ans: No, Container is not a product of Docker. A container is a standard unit of software that packages up code and all its dependencies so the application runs quickly and reliably from one computing environment to another.

Q) Are there more technologies/software platform like Docker that allows to develop/build/deploy/manage containers?
Ans: We have like containerd, rkt, podman similar like docker provide platform to create containers.

Also Read: Our blog post on Vulnerable Docker Images.

Docker Installation & Architecture
Here we started with explanation of client-server architecture and how Docker leverage the use of client-server architecture. The docker client talks to the Docker daemon, which used to build, run, and distribute the Docker containers. Also, Install Docker In Virtual Machine.

Docker is available for download and installation on Windows OS, Linux, and macOS. You can choose any of the following Machine to Install Docker.

To know how to install docker on your machine read our blog on Docker Installation.

 

4
Here we started with explanation of client-server architecture and how

Docker leverage the use of client-server architecture. The docker client talks to the Docker daemon, which used to build, run, and distribute the Docker containers. The Docker client and daemon communicate using a REST API, over UNIX sockets, or a network interface.

5

Q/A’s asked in the session are:

Q) What do you mean by Docker daemon?
Ans: A context loop that handles Docker images, containers, networks, and storage volumes. The Docker daemon is the one listening for Docker API requests and processing them.

Docker Images
A Docker image is a read-only template containing instructions for building a container that can run on the Docker platform. It offers an easy way to package up software and preconfigured cloud environments that you can use privately or openly with other Docker users.

 

6
To know more about the docker image Read our blog post

Q/A’s asked in the session are:

Q) Can I have multiple images inside a container.
Ans: Yes, you can have multiple images inside a single container.

Q) What is the difference between Docker Registry and Repository?
Ans: A Docker repository is where you can store one or more versions of a specific Docker image. An image can have one or more versions (tags) and registry is a place where it stores a collection of repositories.

Q) What is the industry standard for registry that IT companies uses? Docker hub or they create their own registry?
Ans: In big companies you can host your own private registry to store your images or you can use private registries like ACR from Azure, ECR form AWS or private Docker registry.

Q) What is Docker Image Layers?
Ans: Docker Image consists of read-only layers built on top of each other. Docker uses Union File System (UFS) to build an image. The image is shared across containers. This Dockerfile contains multiple sets of commands, each of them is used to create a layer. Each layer is only a set of differences from the layer before it. The layers are stacked on top of each other. All images start with a base layer, and as changes are made and new content is added, a new layer is added on top.

 

7
Each time Docker launches a container from an image, it adds a thin writable layer, known as the container layer, which stores all changes to the container throughout its runtime.

Q) Can you provide example depicting layered architecture?
Ans:

Consider the following example of building a simple Python application.
You might have a corporate policy that all applications are based on the official Ubuntu 20:04 image.
This would be your image’s base layer.
If you then add the Python package, this will be added as a second layer on top of the base layer.
If you later add source code files, these will be added as additional layers.
 

8
Docker Image vs Container
Docker image and Container are closely related to each other the major difference between them is these images are a collection of File plus metadata which is required to run an application, and a container is a running instance of the image or container is a copy of the image.

Q/A’s asked in sessions are:

Q) Why do images share layers?
Ans: Image share layer to optimize

Disk usage
Transfer times
Memory use
Docker Image Registry
Image Registry is centralized storage used to store container images, which makes these images easily shareable. We can pull and push our images into this repository. There are three main types of registries: Docker Hub, Third-party Registry services and Self-hosted registry.

Docker Registry & Docker Hub
Here we introduced the different types of Docker registries such as Docker Hub, ECR (AWS), ACR (Azure), GCR (Google), OCR (Oracle) etc and how Docker registry works.

7

Container Lifecycle
When a container is created it will goes through various life stages that are called as Container lifecycle. We discussed each stages in Container Lifecycle in detail.

Know more about Docker Lifecycle here.

 

8

Q/A’s asked in the session are:

Q) What does pause mean in Docker container Lifecycle?
Ans: Docker pause is used to pause the running container. Command used for pausing a container is Docker pause container-id or name. It can be un paused using the command using the command Docker unpause container-id or name.

Q) Difference between Docker Image and container?
Ans: Docker container is the runtime instance of docker image.

Q) Are all applications within container started when we start a container?
Ans: We need to mention this in Dockerfile we want some particular binary inside the container when container start.

Q) Can we create multiple container in a single command?
Ans: Using the Docker Compose we can create multiple containers at once and do multiple things with container.

Q) Once container is stopped, can it be restarted with existing application or need to create new, then how data can be retained
Ans: We need to store data on a mounted disk if a container stop you can spin new containers and mount that disk to new container.

Q) Do we have an option to configure HA for those containers?
Ans: Yes, Using Docker Swarm or Kubernetes, we can achieve HA for containers.

Q/A’s on Docker Basic Commands
1) docker – To check all available Docker Commands
$ docker [option] [command] [arguments]

2) docker version – To show Docker version
$ docker version

3) docker info – Displays system wide information
$ docker info

4) docker pull – To pull the docker Images from Docker Hub Repository
$ docker pull ubuntu

5) docker build – To Docker Image from Dockerfile
$ docker build <options>  <directory path> OR <URL>
if you want to include files and folder from current/same directory then use below commands
docker build .

6) docker run – Run a container from a docker image.
$ docker run -i -t ubuntu /bin/bash

Here: 

-i: To start an interactive session.
-t: Allocates a tty and attaches stdin and stdout.
ubuntu: Docker image that is used to create the container.
bash (or /bin/bash): command that is running inside the Ubuntu container.
Note- The container will stop when you leave it with the command exit. If you like to have a container that is running in the background, you just need to add the -d option in the command
OR
To exit from the docker container type CTRL + P + Q. This will leave container running in background an provide you host system console.

Now Run Docker Container in background.
$ docker run -i -t –name=Ubuntu-Linux -d ubuntu /bin/bash

Lets commit to existing docker container (023828e786e0) and create new Docker Image (Ubuntu-apache) OR Docker commit to Same Image
$ docker commit 023828e786e0  ubuntu-apache

7) docker ps – List all the running containers. Add the -a flag to list all the containers.
$ docker ps

To list all Docker Containers including stopped
$ docker ps -a

8) docker start – To start a docker container
$ docker start <container-id>

9) docker stop– To stop a docker container
$ docker stop <container-id>

10) docker logs -To view Logs for a Docker Container
$ docker logs <Container ID>

11) docker rename – To rename Docker Container
$ docker rename <Old_Name> <New_Name>

12) docker rm – To remove the Docker Container, stop it first and then remove it
$ docker rm <CONTAINER ID>

Here, We have covered docker basic commands which you should know.

Docker Image Commands
Docker Image is a application template including binaries and libraries needed to run a Docker container. Below are some commonly used Docker Image commands while working with Docker.

1) docker pull – To pull Docker Image from Docker Hub Registry
$ docker pull [OPTIONS] Image_Name[:TAG]

2) docker images– To list Docker Images
$ docker images

You can use ” docker image” command with “ls” argument also
$ docker image ls

To list out locally stored Docker Images
$ docker images list

To filter Docker Images list
$ docker images –filter “<key>=<value>”

Below are some “–filter” options

dangling– Images are not used
label– List the Docker Images those you added a label
before– List the Docker Images which is created in specific time
since– Created in specific time with another image creation
reference –List Docker Images which has name or Tag
To list Docker Images which is not used or Dangling docker images
$ docker images -a

3) docker history – To show history of Docker Image
$ docker image history [OPTIONS] IMAGE
$ docker history <image-id> –no-trunc

4) docker inspect– To show complete information in JSON format
$ docker inspect IMAGE_ID OR CONTAINER_ID

5) docker rmi– To remove docker images
$ docker rmi IMAGE_ID

Docker Container Commands
Docker container is a virtualized runtime environment created from Image. Below are list of Docker container commands which will be useful for you.

1) docker start – To start a Docker container

docker start [OPTIONS] CONTAINER [CONTAINER]
$ docker start container_id

if you want to see output of your command
$ docker start -ai container_id

2) docker stop – To stop a running docker container
$ docker stop container_id

To stop all the containers
$ docker stop ‘docker ps -q’

To stop all Docker containers
$ docker stop $(docker ps -a -q)

3) docker restart – To restart docker container
$ docker restart container_id

4) docker pause – To pause a running container
$ docker pause container_id

5) Difference between Docker pause vs stop
Docker pause suspends all processes in the defined container .
Docker stop sends SIGTERM to the container’s main process to stop and stops the container.

5) docker unpause – To unpause a running container
$ docker unpause CONTAINER [CONTAINER…]
docker unpause CONTAINER_ID

6) docker run – Creates a docker container from docker image
$ docker run [OPTIONS] IMAGE [COMMAND] [ARG]

docker container run command is used to create a docker container from docker images. Below are the example of docker run container with commands. To run Docker container in foreground
$ docker run ubuntu

you will see output of ubuntu docker container on your terminal, To stop the container type “CTRL + C”.

To run Docker container in detached mode/in background OR you want to keep the docker container running when terminal exit , use option “-d“
$ docker container run -d ubuntu

To run Docker container under specific name
$ docker container run –name [CONTAINER_NAME] [DOCKER_IMAGE]

$ docker run -i -t –name=Ubuntu-Linux -d ubuntu

To run Docker container in interactive mode/ you can enter commands inside docker container while it is running
$ docker run -i -t –name=Ubuntu-Linux -d ubuntu /bin/bash

Expose Docker Container ports and access Apache outside
$ docker run -p 81:80 -itd 4e5021d210f6

-p – Exposes the host port to container port

To verify Apache is accessing from outside, Open your favorite browser , type the IP address of your system IP followed by port 81

http://SystemIP:81/

7) docker ps – To list Docker containers, To verify Docker Container running in background
$ docker ps

To list all Docker Containers including stopped
$ docker ps -a

8) docker exec – To Access the shell of Docker Container
Access the shell of Docker Container that runs in the background mode using “CONTAINER ID”
$ docker exec -i -t 023828e786e0 /bin/bash

Access the shell of Docker Container that runs in the background mode using “NAMES”
$ docker exec -i -t Ubuntu-Linux /bin/bash

Type “Exit” to exit from Docker Container shell.

To update the System Packages of Docker Container
$ docker exec 023828e786e0 apt-get update

9) docker logs – To view logs of Docker container
$ docker logs <Containe ID>

10) docker rename – To rename Docker container
$ docker rename <Old_Name> <New_Name>

11) docker rm – To remove Docker container
$ docker rm <CONTAINER ID>

Run below command to remove all stopped containers
$ sudo docker rm -f $(sudo docker ps -a -q)

To remove untagged docker images
$ sudo docker images | grep none | awk ‘{ print $3; }’ | xargs sudo docker rmi

12) docker inspect – Docker container info command
$ docker inspect [OPTIONS] NAME|ID [NAME|ID…]

OR
$ docker container inspect [OPTIONS] CONTAINER [CONTAINER…]

Example:
$ docker inspect 023828e786e0

12) docker attach – Attach Terminal to Running container
Docker attach command is used to attach your terminal to running container to control Input/Output/Error operations.
$ docker attach [OPTIONS] CONTAINER_ID / CONTAINER_NAME

12) docker kill – To stop and remove Docker containers
$ docker kill [OPTIONS] CONTAINER [CONTAINER…]

To stop all docker containers
$ docker kill $(docker ps -q)

To remove all docker containers
$ docker rm $(docker ps -a -q)

To remove all docker containers forcefully
$ docker rm -f $(docker ps -a -q)

13) docker cp – To copy files or folders between a container and from local filesystem.
$ docker cp [OPTIONS] SRC_PATH|- CONTAINER:DEST_PATH

To copy directory from Docker host to container
$ sudo docker cp ./directory_path 023828e786e0:/home/ubuntu

To copy directory from docker container to host
$ sudo docker cp 023828e786e0:/etc/apache2/sites-enabled .

To copy files from Docker container to host
$ sudo docker cp 023828e786e0:/etc/apache2 .

To copy files from Host to Docker container
$ docker cp SOURCE_HOST_PATH  CONTAINER:DESTINATION_PATH

We have covered Docker Basic commands for Docker Container.

Docker Logs and Monitoring Commands
1) docker ps -a – To show running and stopped containers
$ docker ps -a

2) docker logs – To show Docker container logs
$ docker logs

3) docker events – To get all events of docker container
$ docker events

4) docker top – To show running process in docker container
$ docker top

5) docker stats – To check cpu, memory and network I/O usage
$ docker stats <container_id>

6) docker port – To show docker containers public ports
docker port <container_id>

Docker Prune Commands
Using Docker prune we can delete unused or dangling containers, Images , volumes and networks.

To clean all resources which are dangling or not associated with any docker containers
$ docker system prune

To remove unused and stopped docker images
$ docker system prune -a

To remove Dangling Docker images
$ docker image prune docker image prune -a

To remove all unused docker containers
$ docker container prune

### Docker Hub Commands

To search docker image
$ docker search ubuntu

To pull image from docker hub
$ docker pull ubuntu

We have covered Docker Basic Commands for Docker Logs and Monitoring.
