
### Application Structure:

```
parent-app
├───base-app (sub module1)
│   ├───activities (sub module1 child 1)
│   │    ├───customerservice
│   │    │    └───src
│   │    │        ├───main
│   │    │        │   ├───java
│   │    │        │   │   └───com
│   │    │        │   │       └───baseapp
│   │    │        │   │           └───activities
│   │    │        │   │               └───customerservice
│   │    │        │   │                   ├───CustomerServiceActivity.java
│   │    │        │   │                   └───StandardCustomerServiceActivity.java
│   │    │        │   ├───resources
│   │    │        │   │   └───application.properties
│   │    │        │   └───test
│   │    │        │       └───java
│   │    │        │           └───com
│   │    │        │               └───baseapp
│   │    │        │                   └───activities
│   │    │        │                       └───customerservice
│   │    │        │                           ├───CustomerServiceActivityTest.java
│   │    │        │                           └───StandardCustomerServiceActivityTest.java
│   │    │        └───pom.xml  <-- Customer Service module POM
│   │    └───pom.xml  <-- Activities module POM
│   ├───base-app-config (sub module1 child 2)
│   │    └───src
│   │        ├───main
│   │        │   ├───java
│   │        │   │   └───com
│   │        │   │       └───baseapp
│   │        │   │           └───config
│   │        │   │               ├───base-app-config.xml
│   │        │   │               ├───context-config.xml
│   │        │   │               ├───homepage-config.xml
│   │        │   │               ├───jms-config.xml
│   │        │   │               └───kafka-service-config.xml
│   │        │   ├───resources
│   │        │   │   └───application.properties
│   │        │   └───test
│   │        │       └───java
│   │        │           └───com
│   │        │               └───baseapp
│   │        │                   └───config
│   │        │                       ├───BaseAppConfigTest.java
│   │        │                       └───MessagingConfigTest.java
│   │        └───pom.xml  <-- Base App Config module POM
│   └───pom.xml  <-- Base App module POM
├───base-app-sites (sub module2)
│   ├───admin (sub module2 child 1)
│   ├───brand2 (sub module2 child 2)
│   ├───brand3 (sub module2 child 3)
│   │   └───src
│   │       ├───main
│   │       │   ├───java
│   │       │   │   └───com
│   │       │   │       └───baseapp
│   │       │   │           └───brand3
│   │       │   │               └───controller
│   │       │   │                   └───CustomerServiceController.java
│   │       │   ├───jetty
│   │       │   │   ├───app-specification.properties
│   │       │   │   ├───jetty.xml
│   │       │   │   ├───jetty-env.xml
│   │       │   │   ├───jetty-http.xml
│   │       │   │   ├───jetty-https.xml
│   │       │   │   ├───jetty-jmx.xml
│   │       │   │   ├───jetty-ssl.xml
│   │       │   │   └───log4j.properties
│   │       │   ├───resources
│   │       │   │   └───com
│   │       │   │       ├───brand3
│   │       │   │       │   ├───application.properties
│   │       │   │       │   ├───services-servlet.xml
│   │       │   │       │   └───spring-context.xml
│   │       │   │       └───application.properties
│   │       │   └───webapp
│   │       │       └───WEB-INF
│   │       │           └───web.xml
│   │       └───pom.xml  <-- Brand3 module POM
│   └───pom.xml  <-- base-app-sites module POM
├───pom.xml  <-- Parent POM that manages dependencies and modules
└───README.md

```

### `pom.xml` Files:

#### 1. **Parent `pom.xml`** (`base-parent/pom.xml`):

This file will be the parent POM to manage dependencies and build configuration for the entire project. It includes references to all the submodules (`base-app`, `base-app-sites`, etc.).

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.baseapp</groupId>
    <artifactId>base-parent</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <modules>
        <module>base-app</module>
        <module>base-app-sites</module>
    </modules>

    <dependencyManagement>
        <dependencies>
            <!-- Define common dependencies here -->
        </dependencies>
    </dependencyManagement>
</project>
```

#### 2. **`base-app` `pom.xml`** (`base-app/pom.xml`):

This file will configure the `base-app` module and include the `activity` and `base-app-config` submodules.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.baseapp</groupId>
        <artifactId>base-parent</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <artifactId>base-app</artifactId>

    <modules>
        <module>activity</module>
        <module>base-app-config</module>
    </modules>
</project>
```

#### 3. **`base-app-sites` `pom.xml`** (`base-app-sites/pom.xml`):

This file will configure the `base-app-sites` module and include child submodules (`admin`, `brand2`, `brand3`).

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.baseapp</groupId>
        <artifactId>base-parent</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <artifactId>base-app-sites</artifactId>

    <modules>
        <module>admin</module>
        <module>brand2</module>
        <module>brand3</module>
    </modules>
</project>
```

#### 4. **Activity and Base App Config POMs**:

Both the `activity` and `base-app-config` modules also have their own `pom.xml` files to define their dependencies and configurations.

Each module's `pom.xml` can look like this:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.baseapp</groupId>
        <artifactId>base-app</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <artifactId>activity</artifactId>
    <!-- Add dependencies and other configurations here -->
</project>
```

### Introduction to Docker and Its Benefits in Vue.js Development

Docker is an open-source platform that automates the deployment, scaling, and management of applications inside containers. It encapsulates your application and its dependencies into a standardized unit called a container, ensuring consistency across various environments (development, staging, and production). Docker offers many benefits for Vue.js development:

- **Portability**: Docker containers can run on any machine that supports Docker, making it easy to move your application between different environments.
- **Isolation**: Containers encapsulate the application and its dependencies, preventing conflicts between different versions of libraries.
- **Reproducibility**: Docker ensures the same environment every time you build or deploy the application, eliminating issues that arise from "works on my machine" syndrome.
- **Scalability**: Docker works seamlessly with orchestration tools like Kubernetes, allowing you to scale your application as needed.
- **Efficient deployment**: Docker can package and deploy the app with minimal overhead, ensuring rapid deployment cycles.

### Setting Up a Vue.js Project

First, let’s set up a basic Vue.js application. If you haven’t installed Vue CLI yet, you can do so with the following command:

```bash
npm install -g @vue/cli
```

To create a new Vue.js project:

```bash
vue create my-vue-app
```

Follow the prompts to choose your preferred setup. Once the project is set up, navigate into the project folder:

```bash
cd my-vue-app
```

Test the project to make sure everything is working:

```bash
npm run serve
```

Visit `http://localhost:8080` in your browser to verify the app is running.

### Creating a Dockerfile for Vue.js Application

Now that your Vue.js project is ready, let’s create a `Dockerfile` to containerize the application. In the root of your Vue.js project, create a file named `Dockerfile` with the following contents:

```dockerfile
# Step 1: Build the application
FROM node:16 AS build

# Set working directory inside container
WORKDIR /app

# Install dependencies
COPY package*.json ./
RUN npm install

# Copy the source code
COPY . .

# Build the Vue.js app
RUN npm run build

# Step 2: Serve the application with Nginx
FROM nginx:alpine

# Copy the build output from the first stage
COPY --from=build /app/dist /usr/share/nginx/html

# Expose port 80 for the app
EXPOSE 80

# Start Nginx to serve the app
CMD ["nginx", "-g", "daemon off;"]
```

### Explanation of the Dockerfile:

1. **Build Stage**:
   - The `node:16` image is used to install dependencies and build the application.
   - We copy the `package.json` and `package-lock.json` to install dependencies.
   - Then, we copy the entire project into the container and run the `npm run build` command to generate the production-ready files in the `dist` folder.

2. **Serve Stage**:
   - The `nginx:alpine` image is used to serve the built Vue.js application.
   - The `dist` folder is copied from the build stage into the Nginx HTML directory.
   - The `CMD` directive tells Nginx to start in the foreground.

### Configuring Nginx as a Reverse Proxy for the Vue.js Application

Nginx can be used as a reverse proxy to handle HTTP requests and forward them to your Vue.js application. The default configuration in the `nginx:alpine` image will suffice for most cases, but you can create a custom `nginx.conf` file if needed.

Here’s an example `nginx.conf` for a Vue.js app:

```nginx
server {
    listen 80;

    server_name localhost;

    root /usr/share/nginx/html;
    index index.html;

    location / {
        try_files $uri $uri/ /index.html;
    }
}
```

This configuration ensures that Vue Router works with history mode by redirecting all requests to `index.html`.

You can copy this `nginx.conf` file to the appropriate location in the Docker image by adding this line in the `Dockerfile`:

```dockerfile
COPY nginx.conf /etc/nginx/nginx.conf
```

### Building and Running the Docker Container

To build and run your Docker container, use the following commands in the root directory of your project:

1. **Build the Docker image**:

   ```bash
   docker build -t vue-app .
   ```

   This will create a Docker image with the name `vue-app`.

2. **Run the container**:

   ```bash
   docker run -d -p 80:80 vue-app
   ```

   This will run the Vue.js app in a container and bind it to port `80` on your local machine.

3. **Access the application**:

   Open your browser and visit `http://localhost`. You should see your Vue.js application being served by Nginx inside the Docker container.

### Deploying the Dockerized Vue.js Application to a Production Environment

To deploy your Dockerized Vue.js application to production:

1. **Push the image to a Docker registry** (like Docker Hub, AWS ECR, or GCP Container Registry):

   First, log in to your Docker account:

   ```bash
   docker login
   ```

   Then, tag your image:

   ```bash
   docker tag vue-app username/vue-app:latest
   ```

   Finally, push the image:

   ```bash
   docker push username/vue-app:latest
   ```

2. **Deploy to a server**:

   - On your production server, install Docker and pull the image:

     ```bash
     docker pull username/vue-app:latest
     ```

   - Run the Docker container:

     ```bash
     docker run -d -p 80:80 username/vue-app:latest
     ```

This will deploy your Dockerized Vue.js app to a production environment, accessible via the server’s IP or domain name.

### Troubleshooting Common Issues and Best Practices

1. **Build issues**: Ensure your `Dockerfile` is correctly configured and dependencies are up to date. Run `docker build` with the `--no-cache` option to rebuild everything from scratch.

2. **Nginx not serving correctly**: Double-check your `nginx.conf` file and ensure it’s properly copied into the container. Check the container logs for errors by running `docker logs <container-id>`.

3. **Docker container not starting**: Inspect container logs to debug startup issues. If the container fails to start, running the container interactively with `docker run -it vue-app sh` can help diagnose problems.

4. **Production deployment**: When deploying to production, consider using a reverse proxy like Nginx or Traefik to handle HTTPS, load balancing, and other production-level configurations.

5. **Cache issues**: Ensure that your app's static assets are versioned, especially in production, to avoid caching issues after updates.

### Conclusion

By Dockerizing your Vue.js application, you ensure a consistent, isolated, and reproducible environment that is easy to deploy, scale, and maintain. With the help of Nginx, you can efficiently serve your app and handle any reverse proxy requirements. Docker simplifies the deployment process, making it easier to move your app between environments and manage its dependencies. By following this tutorial, you can leverage the power of Docker for seamless Vue.js development and deployment.
