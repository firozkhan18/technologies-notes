# Deploying, Scaling, and Updating an E-Commerce Website on Google Kubernetes Engine

We’ll also transition the existing Monolithic architecture to a Micro-services architecture.

![Google Kubernetes Engine](image-url)  
*Operating websites and applications presents inherent challenges. Anomalies arise unexpectedly, server downtimes occur, surges in demand increase resource utilization, and implementing changes without service disruptions proves intricate and demanding.*

Kubernetes facilitates the execution of these tasks and provides the capability for automation. In this article, I will guide you through the deployment of an e-commerce application onto the Google Kubernetes Engine (GKE) based on a real-world scenario.

---

## Table of Contents

1. [K8s in Short](#k8s-in-short)
2. [Prerequisites](#prerequisites)
3. [Step 1: Create a GKE Cluster](#step-1-create-a-gke-cluster)
4. [Step 2: Create a Docker Container](#step-2-create-a-docker-container)
5. [Step 3: Deploy, Expose and Scale the Container](#step-3-deploy-expose-and-scale-the-container)
   - [Deploying the Container to GKE](#deploying-the-container-to-gke)
   - [Verifying the Deployment](#verifying-the-deployment)
   - [Exposing the GKE Deployment](#exposing-the-gke-deployment)
   - [Accessing the Service](#accessing-the-service)
   - [Scaling the GKE Deployment](#scaling-the-gke-deployment)
6. [Step 4: Modify Our E-Commerce Application](#step-4-modify-our-e-commerce-application)
7. [Step 5: Rollout Our New Version (Zero Downtime)](#step-5-rollout-our-new-version-zero-downtime)
8. [Conclusion](#conclusion)

---

## K8s in Short

First developed by a team at Google and later donated to the Cloud Native Computing Foundation, Kubernetes, commonly referred to as K8s, stands as an open-source container orchestration system for automating software deployment, scaling, and management of containerized applications.

In other words, you can cluster together groups of hosts running Linux containers, and Kubernetes helps you easily and efficiently manage those clusters.

---

## Prerequisites

To maximize your understanding and follow along this guide, please make sure the following requirements are met:

- **Google Cloud Account:** [Sign up here](https://cloud.google.com).
- **Basic understanding of Docker and Kubernetes** (recommended).

---

## Step 1: Create a GKE Cluster

To initiate the deployment of our e-commerce application, a Kubernetes cluster is required.

1. Sign in to the Google Cloud console.
2. Create a Google Cloud project. Your project name must be unique and cannot be changed after creation. I named my project “K8s Ecommerce”.

   ![K8s E-commerce Google Cloud project created](image-url)

3. Click on **“SELECT PROJECT”**. Next, click on the Notifications icon to close the notification.

   ![K8s E-commerce Project Selected](image-url)

4. Click **Activate Cloud Shell** at the top of the Google Cloud console.

   ![Activate Cloud Shell](image-url)

5. Run the following command to enable the Container Registry API. Click **“AUTHORIZE”** when prompted:

   ```sh
   $ gcloud services enable container.googleapis.com
   ```

6. Run the following command to create a GKE cluster named `k8s-ecommerce-cluster` with 3 nodes:

   ```sh
   $ gcloud container clusters create k8s-ecommerce-cluster --num-nodes 3
   ```

   It will take a few minutes for the cluster to be created. If you get an error about region/zone not being specified, make sure to set the default compute zone:

   ```sh
   gcloud config set compute/region us-central1
   ```

7. Run the following command to see the cluster’s three worker VM instances:

   ```sh
   $ gcloud compute instances list
   ```

   Example output:

   ```
   NAME: gke-k8s-ecommerce-cluster-default-pool-fb932da6-4sk6
   ZONE: us-central1-f
   MACHINE_TYPE: e2-medium
   INTERNAL_IP: 10.128.0.3
   EXTERNAL_IP: 34.172.106.173
   STATUS: RUNNING
   ```

8. Click the **Navigation menu** > **Kubernetes Engine** > **Clusters**. You should see your cluster named `k8s-ecommerce-cluster`.

---

## Step 2: Create a Docker Container

1. Run the following commands to clone my git repo to your Cloud Shell instance:

   ```sh
   $ cd ~
   $ git clone https://github.com/rnem/gcp.git
   ```

   ![Expected Git Clone Results](image-url)

2. Change to the appropriate directory and install the NodeJS dependencies so you can test the application before deploying it:

   ```sh
   $ cd ~/gcp/monolith-to-microservices/
   $ chmod +x setup.sh
   $ ./setup.sh
   ```

3. Wait a few minutes for this script to finish running.

   ![Setup Results](image-url)

4. Run the following command to ensure you are running Cloud Shell with the latest version of npm:

   ```sh
   nvm install --lts
   ```

5. Test the Monolith application by running the following command to start the web server:

   ```sh
   cd ~/gcp/monolith-to-microservices/monolith/
   npm start
   ```

   You should see:

   ```
   > monolith@1.0.0 start
   > node ./src/server.js

   Monolith listening on port 8080!
   ```

   To preview your application, click the web preview icon and select **“Preview on port 8080”**:

   ![GCP | Web Preview](image-url)  
   ![Monolith E-Commerce Store running](image-url)  
   ![Monolith E-Commerce Store running | Products page](image-url)

   Press **CTRL+C** in Cloud Shell to stop the web server process.

6. Now it is time to Dockerize our application. 👍

   Typically, you would follow a two-step process: building a Docker container and pushing it to a registry. To simplify, we’ll use Google Cloud Build to build the Docker container and push the image to the Container Registry with a single command.

   6.1. Run the following command to enable the Cloud Build API:

   ```sh
   gcloud services enable cloudbuild.googleapis.com
   ```

   6.2. Change to the desired directory and start the build process:

   ```sh
   cd ~/gcp/monolith-to-microservices/monolith
   gcloud builds submit --tag gcr.io/${GOOGLE_CLOUD_PROJECT}/monolith:1.0.0 .
   ```

   This process will take a few minutes. The Docker image will be pushed to the Google Cloud Container Registry.

   Example output:

   ```
   ID CREATE_TIME DURATION SOURCE IMAGES STATUS
   1ae295d9-63cb-482c-959b-bc52e9644d53 2024-01-10T01:56:35+00:00 33S gs://_cloudbuild/source/1567043793.94-abfd382011724422bf49af1558b894aa.tgz gcr.io/<project-id>/monolith:1.0.0 SUCCESS
   ```

   To view your build history, click the Navigation menu and scroll down to the **CI/CD** section. Then click **“Cloud Build”** > **“History”**.

   ![Cloud Build > History](image-url)

   Click on the build name to see all the details for that build including the log output.

---

## Step 3: Deploy, Expose and Scale the Container

### Deploying the Container to GKE

To deploy your application, create a Deployment resource. The Deployment manages multiple copies of your application (replicas) and schedules them to run on individual nodes in your cluster.

Run the following command to deploy your application:

```sh
kubectl create deployment monolith --image=gcr.io/${GOOGLE_CLOUD_PROJECT}/monolith:1.0.0
```

### Verifying the Deployment

Check the status of your deployment with:

```sh
kubectl get all
```

Rerun the command until the pod status is Running. You should see something like:

```
NAME                            READY   STATUS    RESTARTS   AGE
pod/monolith-7d8bc7bf68-htm7z   1/1     Running   0          6m21s

NAME TYPE CLUSTER-IP EXTERNAL-IP PORT(S) AGE
service/kubernetes ClusterIP 10.27.240.1  443/TCP 24h

NAME DESIRED CURRENT UP-TO-DATE AVAILABLE AGE
deployment.apps/monolith 1 1 1 1 20m

NAME DESIRED CURRENT READY AGE
replicaset.apps/monolith-7d8bc7bf68 1 1 1 20m
```

### Exposing the GKE Deployment

To enable external access, expose your application using a Service resource:

```sh
kubectl expose deployment monolith --type=LoadBalancer --port 80 --target-port 8080
```

###

 Accessing the Service

Find the external IP with:

```sh
kubectl get services
```

Example output:

```
NAME         TYPE           CLUSTER-IP     EXTERNAL-IP     PORT(S)        AGE
monolith     LoadBalancer   10.27.248.54   34.171.36.27    80:32316/TCP   4m14s
```

Visit `http://<external-ip>` in your browser to view the application.

### Scaling the GKE Deployment

To scale your deployment, run:

```sh
kubectl scale deployment monolith --replicas=3
```

Check the scaling status:

```sh
kubectl get pods
```

---

## Step 4: Modify Our E-Commerce Application

Let's modify the e-commerce application by adding a new feature to showcase a sale of the day on the homepage. For demonstration purposes, we'll edit the homepage to display a new sale banner.

1. Open the `monolith/src/views/homepage.js` file.

2. Add a banner to the homepage to display the sale message:

   ```js
   <div>
       <h1>Welcome to Our E-Commerce Store!</h1>
       <p>Check out our Sale of the Day!</p>
   </div>
   ```

3. Commit and push the changes to your GitHub repository.

---

## Step 5: Rollout Our New Version (Zero Downtime)

To implement zero downtime, leverage Kubernetes’ rolling update strategy. 

1. First, build and push the new Docker image with the updated feature.

   ```sh
   cd ~/gcp/monolith-to-microservices/monolith
   gcloud builds submit --tag gcr.io/${GOOGLE_CLOUD_PROJECT}/monolith:1.1.0 .
   ```

2. Update the deployment with the new image version:

   ```sh
   kubectl set image deployment/monolith monolith=gcr.io/${GOOGLE_CLOUD_PROJECT}/monolith:1.1.0
   ```

3. Verify that the new version is being rolled out:

   ```sh
   kubectl rollout status deployment/monolith
   ```

4. Check the status to confirm that the application is updated and still running:

   ```sh
   kubectl get deployments
   ```

   The rollout will ensure that new pods with the updated image will be created, while old pods will be terminated only when the new pods are up and running, ensuring zero downtime.

---

## Conclusion

Deploying an e-commerce website on Google Kubernetes Engine involves creating a GKE cluster, Dockerizing your application, deploying it to Kubernetes, and scaling and updating it as necessary. By leveraging Kubernetes' features, you can efficiently manage your application, automate scaling, and achieve zero downtime during updates.

Feel free to reach out with questions or comments, and happy deploying!

---

*For additional reading, visit:*  
[Google Kubernetes Engine Documentation](https://cloud.google.com/kubernetes-engine/docs)

[Docker Documentation](https://docs.docker.com/)

[Node.js Documentation](https://nodejs.org/en/docs/)
