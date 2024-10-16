The Art of Creating Container Images and Best Practices
---
The Art of Creating Container Images and Best Practices
The Art of Creating Container Images
https://dev.to/aws-builders/the-art-of-creating-container-images-and-best-practices-3p9d
### Introduction
We are in the era of the evolving landscape of software product development, So the need for efficient, consistent, and scalable deployment methods has been more critical.

One of the most significant advancements in this area is the use of containers. Containers have revolutionized the way we build, package, and deploy applications, offering a level of flexibility and reliability that traditional methods often lack.

It is one of key automation pillar in DevOps Process Automation (CI/CD), that helps the developed frozen code has been released. It is making sure nothing gets changed in code once it is packaged into container images.

In this blog, we'll explore the concept of containers, delve into the traditional approach of application packaging, and highlight the best practices for creating container images. Additionally, we'll provide examples of packaging React and Java-based applications using containers.

What are Containers?
Containers are lightweight, portable units of software that package an application and its dependencies together, ensuring that it runs consistently across different computing environments. Unlike virtual machines, containers share the host system's kernel, which makes them more efficient in terms of resource usage. Containers can be run on any system that supports the container runtime, making them an ideal choice for modern, cloud-native application development and deployment.

Docker Born

Packaging the Application: A Traditional Approach
Before the advent of containers, applications were typically packaged and deployed using traditional methods. This often involved creating installation packages that bundled the application binaries along with necessary libraries and configuration files. These packages were then installed on target systems, where the application would run. While this approach worked for many years, it had several inherent limitations.

Disadvantages of the Old Approach
Inconsistent Environments: Traditional packaging methods often led to inconsistencies between development, testing, and production environments. This could cause applications to behave differently depending on where they were running. There is a chance that developers over-writes the finalised packages that are about to be deployed in release environments, causing the delay in product or feature releases.

Dependency Conflicts: Managing dependencies was a significant challenge. Different applications might require different versions of the same library, leading to conflicts and "dependency hell."

Resource Overhead: Traditional methods typically required separate instances of operating systems for each application, leading to high resource consumption and inefficiencies.

Complex Deployment: The deployment process was often complex and error-prone, requiring manual intervention and detailed configuration.

Before and after DevOps

How Containers Help in Overcoming the Shortfall of Traditional Approach
Containers address many of the shortcomings of traditional application packaging methods:

Consistency: By packaging the application and its dependencies together, containers ensure that the application runs the same way, regardless of where it is deployed.

Isolation: Containers provide process and filesystem isolation, reducing the risk of dependency conflicts and enhancing security.

Efficiency: Containers share the host system's kernel and resources, making them more efficient than virtual machines. This allows for higher density and better resource utilization.

Simplified Deployment: Containers can be easily deployed, scaled, and managed using container orchestration platforms like Kubernetes. This simplifies the deployment process and reduces the risk of errors.

Container Image Creation Best Practices
Creating efficient and secure container images is crucial for leveraging the full benefits of containerization. Here are some best practices to follow:

Low Image Size
Use Minimal Base Images: Start with a minimal base image, such as alpine or distroless, to reduce the overall image size.

Multi-stage Builds: Use multi-stage builds to separate the build environment from the runtime environment. This helps in keeping the final image lightweight by excluding unnecessary build tools and dependencies.

Remove Unnecessary Files: Clean up temporary files, cache, and other unnecessary files during the image build process.

Less/No Vulnerable Images
Regular Updates: Regularly update the base images and dependencies to include the latest security patches and updates.

Security Scanning: Use tools like Trivy or Clair to scan images for known vulnerabilities before deploying them.

Minimal Permissions: Ensure that the application runs with the least privileges necessary to reduce potential attack surfaces.

Be Cautious in Opening Ports
Limit Exposed Ports: Only expose the ports that are necessary for the application to function. Avoid exposing unnecessary ports to reduce the attack surface.

Use Non-standard Ports: When possible, use non-standard ports to make it harder for attackers to find and exploit open services.

Follow Security Best Practices
Use Non-root Users: Run applications as non-root users within the container to minimize the impact of a potential security breach.

Environment Variables: Avoid hardcoding sensitive information in the image. Use environment variables to pass sensitive data at runtime.

Network Policies: Implement network policies to control the traffic between containers, enhancing security within the containerized environment.

Example of Packaging React and Java-based Application
Let's look at examples of packaging a React application and a Java-based application using Docker.

Installing Docker
Before you can create and push images, you need to have Docker installed on your machine. You can follow the official Docker installation guide for your operating system here.

Packaging a React Application
Let us consider a React based web application we have. Here is what the container creation Dockerfile will look like,

Dockerfile:
This is a multi-stage Dockerfile. Where we have Two stages, and Stage 2 is dependent on Stage 1 Build.

Dockerfile has to be added into the Project Home path.
```dockerfile
# Stage 1: Build the React app
FROM node:14-alpine as build

WORKDIR /app

COPY package.json ./
COPY package-lock.json ./

RUN npm install

COPY . ./

RUN npm run build

# Stage 2: Serve the React app using Nginx
FROM nginx:alpine

COPY --from=build /app/build /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
```
Build and Run:
Once the Docker file is created, we can run the commands below to create the Image in user Workstation.
```sh
docker build -t my-react-app .
docker run -d -p 80:80 my-react-app
```
Packaging a Java-based Application
Let us consider another application, which is a Java based web application. So here is what the container creation Dockerfile will look like,

Dockerfile:
This is also a multi-stage Dockerfile. Where we have Two stages, Stage 1 build code and Stage 2 is dependent on Stage 1 Build.

Dockerfile has to be added into the Project Home path.
```dockerfile
# Stage 1: Build the Java app
FROM maven:3.8.1-jdk-11 as build

WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2: Run the Java app
FROM openjdk:11-jre-slim

COPY --from=build /app/target/my-java-app.jar /app/my-java-app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/my-java-app.jar"]
```
Build and Run:
Once the Docker file is created, we can run the commands below to create the Image in user Workstation.
```sh
docker build -t my-java-app .
docker run -d -p 8080:8080 my-java-app
```
Pushing Images to Docker Hub or Cloud Registry
Once your container images are built and tested locally, you often need to push them to a container registry for storage and deployment to other environment. Here’s how to push images to different registries.

Pushing Images to Docker Hub
Create a Docker Hub Account: If you don't already have one, go to Docker Hub and create an account.

Login to Docker Hub:
   docker login
You will be prompted to enter your Docker Hub username and password.

Tag Your Image:
   docker tag my-image:latest your-dockerhub-username/my-image:latest
Push the Image:
   docker push your-dockerhub-username/my-image:latest
Pushing Images to Google Container Registry (GCR)
Set Up GCloud: Install the Google Cloud SDK and authenticate.
   gcloud auth login
   gcloud auth configure-docker
Tag Your Image:
   docker tag my-image:latest gcr.io/your-project-id/my-image:latest
Push the Image:
   docker push gcr.io/your-project-id/my-image:latest
Pushing Images to Amazon Elastic Container Registry (ECR)
Create an ECR Repository: Use the AWS Management Console or CLI to create a repository.
   aws ecr create-repository --repository-name my-repo
Authenticate Docker to Your ECR:
   aws ecr get-login-password --region your-region | docker login --username AWS --password-stdin your-account-id.dkr.ecr.your-region.amazonaws.com
Tag Your Image:
   docker tag my-image:latest your-account-id.dkr.ecr.your-region.amazonaws.com/my-repo:latest
Push the Image:
   docker push your-account-id.dkr.ecr.your-region.amazonaws.com/my-repo:latest
Pushing Images to Azure Container Registry (ACR)
Create an ACR: Use the Azure CLI to create a registry.
   az acr create --resource-group myResourceGroup --name myACR --sku Basic
Login to ACR:
   az acr login --name myACR
Tag Your Image:
   docker tag my-image:latest myACR.azurecr.io/my-repo:latest
Push the Image:
   docker push myACR.azurecr.io/my-repo:latest
Summary of Steps
Create an Account/Repository: Create an account on the
desired registry platform and create a repository if necessary.

Login to the Registry: Use CLI commands to authenticate your Docker client with the registry.
Tag Your Image: Properly tag your Docker image to match the registry's naming conventions.
Push the Image: Use the docker push command to upload your image to the registry.
Conclusion
Containers have transformed the way we package and deploy applications, offering significant advantages over traditional methods. By following best practices for container image creation, we can build efficient, secure, and reliable containerized applications. Whether you're working with modern JavaScript frameworks like React or more traditional Java applications, containerization can streamline your development and deployment processes, ensuring consistency and scalability across different environments. Start leveraging containers today to take your application development to the next level.

Suggested Next Steps
Explore container orchestration platforms like Kubernetes.
Integrate continuous integration and continuous deployment (CI/CD) pipelines with containerization.
Learn about service mesh technologies for managing microservices within a containerized environment.
By embracing these technologies and practices, you can further enhance the efficiency and scalability of your applications.

[PREV](/kubernetes-complete-reference-5.md) - [FIRST](/kubernetes-complete-reference-0.md)
