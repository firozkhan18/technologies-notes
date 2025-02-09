
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


To configure Kafka consumer and producer in a Spring MVC project using an XML-based Spring configuration, and ensuring the use of SSL certificates for secure communication, we need to define both Kafka consumer and producer settings in the `applicationContext.xml` (or a similar XML configuration file). 

This guide assumes that you have the following requirements:

1. **SSL certificates for Kafka communication** — A keystore and truststore need to be configured for SSL.
2. **Spring Kafka dependencies** — Ensure that you have included Spring Kafka dependencies in your project (via Maven or Gradle).

Here’s the setup for Kafka with SSL certificates:

---

### Step 1: Include the Required Dependencies

In your `pom.xml`, ensure you have the necessary dependencies for Kafka and Spring Kafka:

```xml
<dependencies>
    <!-- Spring Kafka -->
    <dependency>
        <groupId>org.springframework.kafka</groupId>
        <artifactId>spring-kafka</artifactId>
        <version>2.8.0</version> <!-- Choose the latest compatible version -->
    </dependency>

    <!-- Apache Kafka Client -->
    <dependency>
        <groupId>org.apache.kafka</groupId>
        <artifactId>kafka-clients</artifactId>
        <version>2.8.0</version> <!-- Choose the latest compatible version -->
    </dependency>

    <!-- SLF4J logging (for logging) -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.32</version>
    </dependency>
</dependencies>
```

---

### Step 2: Configure Kafka Consumer and Producer in Spring MVC XML Configuration

In the XML configuration file (e.g., `applicationContext.xml`), we will configure both the Kafka consumer and producer along with SSL settings.

#### 2.1 Kafka Producer Configuration

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <!-- Kafka Producer Configuration -->
    <bean id="producerFactory" class="org.springframework.kafka.core.DefaultKafkaProducerFactory">
        <constructor-arg>
            <bean class="org.apache.kafka.common.serialization.StringSerializer"/>
        </constructor-arg>
        <constructor-arg>
            <bean class="org.apache.kafka.common.serialization.StringSerializer"/>
        </constructor-arg>
        <property name="producerConfig">
            <map>
                <entry key="bootstrap.servers" value="your.kafka.server:9093"/>
                <entry key="security.protocol" value="SSL"/>
                <entry key="ssl.truststore.location" value="classpath:/path/to/your/truststore.jks"/>
                <entry key="ssl.truststore.password" value="truststore-password"/>
                <entry key="ssl.keystore.location" value="classpath:/path/to/your/keystore.jks"/>
                <entry key="ssl.keystore.password" value="keystore-password"/>
                <entry key="ssl.key.password" value="key-password"/>
            </map>
        </property>
    </bean>

    <bean id="kafkaTemplate" class="org.springframework.kafka.core.KafkaTemplate">
        <constructor-arg ref="producerFactory"/>
    </bean>
</beans>
```

Explanation:
- **`DefaultKafkaProducerFactory`**: Configures the producer factory for Kafka with key and value serializers (in this case, `StringSerializer`).
- **SSL Configuration**: SSL-related properties like `security.protocol`, `ssl.truststore.location`, `ssl.keystore.location`, and their respective passwords are specified.
- **`KafkaTemplate`**: This bean is used to send messages to Kafka.

---

#### 2.2 Kafka Consumer Configuration

```xml
<bean id="consumerFactory" class="org.springframework.kafka.core.DefaultKafkaConsumerFactory">
    <constructor-arg>
        <bean class="org.apache.kafka.common.serialization.StringDeserializer"/>
    </constructor-arg>
    <constructor-arg>
        <bean class="org.apache.kafka.common.serialization.StringDeserializer"/>
    </constructor-arg>
    <property name="consumerConfig">
        <map>
            <entry key="bootstrap.servers" value="your.kafka.server:9093"/>
            <entry key="security.protocol" value="SSL"/>
            <entry key="ssl.truststore.location" value="classpath:/path/to/your/truststore.jks"/>
            <entry key="ssl.truststore.password" value="truststore-password"/>
            <entry key="ssl.keystore.location" value="classpath:/path/to/your/keystore.jks"/>
            <entry key="ssl.keystore.password" value="keystore-password"/>
            <entry key="ssl.key.password" value="key-password"/>
            <entry key="group.id" value="your-consumer-group"/>
        </map>
    </property>
</bean>

<bean id="kafkaListenerContainerFactory" class="org.springframework.kafka.listener.ConcurrentMessageListenerContainer">
    <constructor-arg ref="consumerFactory"/>
    <constructor-arg ref="kafkaMessageListenerContainer"/>
</bean>
```

Explanation:
- **`DefaultKafkaConsumerFactory`**: Configures the consumer factory with key and value deserializers (`StringDeserializer` in this case).
- **SSL Configuration**: Similar to the producer configuration, SSL properties are set.
- **`ConcurrentMessageListenerContainer`**: The `KafkaListenerContainer` is configured to handle the consumption of messages from Kafka.

---

#### 2.3 Kafka Listener Bean (Optional)

To consume messages from Kafka, you can define a listener method:

```xml
<bean id="kafkaListener" class="com.example.kafka.KafkaMessageListener">
    <property name="kafkaTemplate" ref="kafkaTemplate"/>
</bean>
```

Then, in your `KafkaMessageListener` class:

```java
package com.example.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    @KafkaListener(topics = "your-topic", groupId = "your-consumer-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
```

Explanation:
- **`@KafkaListener`**: A Spring annotation used to create a method that listens to Kafka messages from a specific topic and consumer group.

---

### Step 3: Configuration in `application.properties` (Optional)

Instead of specifying the Kafka SSL configuration in the XML file, you can also use `application.properties` to store the Kafka configuration if using Spring Boot. Here's how you might do that in a Spring Boot setup:

```properties
# Kafka Configuration for SSL
spring.kafka.bootstrap-servers=your.kafka.server:9093
spring.kafka.consumer.group-id=your-consumer-group
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.security.protocol=SSL
spring.kafka.consumer.ssl.truststore-location=classpath:/path/to/your/truststore.jks
spring.kafka.consumer.ssl.truststore-password=truststore-password
spring.kafka.consumer.ssl.keystore-location=classpath:/path/to/your/keystore.jks
spring.kafka.consumer.ssl.keystore-password=keystore-password
spring.kafka.consumer.ssl.key-password=key-password
```

This is for Spring Boot projects, where you typically would not need to manually configure the beans in XML, but instead rely on auto-configuration properties in `application.properties` or `application.yml`.

---

### Step 4: Run Your Application

- Make sure Kafka is running and configured with SSL enabled on the desired port (e.g., `9093`).
- Use the `KafkaTemplate` to send messages to Kafka and `@KafkaListener` to listen to messages from Kafka.

---

### Summary:

- We configured both **Kafka Producer** and **Kafka Consumer** using SSL certificates in an XML-based Spring MVC configuration.
- For the producer, we specified `ssl.keystore` and `ssl.truststore` properties, including passwords for both the truststore and keystore.
- We also provided configuration for a **Kafka consumer** using SSL, along with a listener method to consume messages from a specified topic.

This configuration ensures secure communication with Kafka over SSL, ensuring that both sending and receiving messages are properly secured.

To configure a Spring MVC application with Jetty as the embedded servlet container (along with Kafka producer and consumer configuration using SSL certificates), you'll need to set up your `applicationContext.xml`, configure Jetty in `web.xml`, and provide the necessary dependencies. This example will guide you through configuring both Kafka with SSL and Jetty for serving your Spring MVC application.

### Step 1: Add Dependencies to `pom.xml`

First, ensure you have the necessary dependencies for Spring Kafka, Jetty, and Spring MVC in your `pom.xml` file.

```xml
<dependencies>
    <!-- Spring MVC -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.12</version>
    </dependency>
    
    <!-- Spring Kafka -->
    <dependency>
        <groupId>org.springframework.kafka</groupId>
        <artifactId>spring-kafka</artifactId>
        <version>2.8.0</version>
    </dependency>

    <!-- Kafka Client -->
    <dependency>
        <groupId>org.apache.kafka</groupId>
        <artifactId>kafka-clients</artifactId>
        <version>2.8.0</version>
    </dependency>

    <!-- Jetty Server -->
    <dependency>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-server</artifactId>
        <version>9.4.40.v20210413</version>
    </dependency>
    
    <dependency>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-servlet</artifactId>
        <version>9.4.40.v20210413</version>
    </dependency>

    <!-- Spring Web and AOP -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>5.3.12</version>
    </dependency>

    <!-- Logging (SLF4J) -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.32</version>
    </dependency>
</dependencies>
```

### Step 2: Create `applicationContext.xml` for Kafka Configuration

As discussed before, we configure both Kafka producer and consumer using SSL certificates. Here’s the `applicationContext.xml` with Spring Kafka setup for SSL configuration:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

    <!-- Kafka Producer Configuration -->
    <bean id="producerFactory" class="org.springframework.kafka.core.DefaultKafkaProducerFactory">
        <constructor-arg>
            <bean class="org.apache.kafka.common.serialization.StringSerializer"/>
        </constructor-arg>
        <constructor-arg>
            <bean class="org.apache.kafka.common.serialization.StringSerializer"/>
        </constructor-arg>
        <property name="producerConfig">
            <map>
                <entry key="bootstrap.servers" value="your.kafka.server:9093"/>
                <entry key="security.protocol" value="SSL"/>
                <entry key="ssl.truststore.location" value="classpath:/path/to/your/truststore.jks"/>
                <entry key="ssl.truststore.password" value="truststore-password"/>
                <entry key="ssl.keystore.location" value="classpath:/path/to/your/keystore.jks"/>
                <entry key="ssl.keystore.password" value="keystore-password"/>
                <entry key="ssl.key.password" value="key-password"/>
            </map>
        </property>
    </bean>

    <bean id="kafkaTemplate" class="org.springframework.kafka.core.KafkaTemplate">
        <constructor-arg ref="producerFactory"/>
    </bean>

    <!-- Kafka Consumer Configuration -->
    <bean id="consumerFactory" class="org.springframework.kafka.core.DefaultKafkaConsumerFactory">
        <constructor-arg>
            <bean class="org.apache.kafka.common.serialization.StringDeserializer"/>
        </constructor-arg>
        <constructor-arg>
            <bean class="org.apache.kafka.common.serialization.StringDeserializer"/>
        </constructor-arg>
        <property name="consumerConfig">
            <map>
                <entry key="bootstrap.servers" value="your.kafka.server:9093"/>
                <entry key="security.protocol" value="SSL"/>
                <entry key="ssl.truststore.location" value="classpath:/path/to/your/truststore.jks"/>
                <entry key="ssl.truststore.password" value="truststore-password"/>
                <entry key="ssl.keystore.location" value="classpath:/path/to/your/keystore.jks"/>
                <entry key="ssl.keystore.password" value="keystore-password"/>
                <entry key="ssl.key.password" value="key-password"/>
                <entry key="group.id" value="your-consumer-group"/>
            </map>
        </property>
    </bean>

    <bean id="kafkaListenerContainerFactory" class="org.springframework.kafka.listener.ConcurrentMessageListenerContainer">
        <constructor-arg ref="consumerFactory"/>
        <constructor-arg ref="kafkaMessageListenerContainer"/>
    </bean>
</beans>
```

### Step 3: Configure Jetty as the Embedded Server in `web.xml`

Spring MVC will typically use a servlet container like Tomcat by default, but we can configure Jetty to serve our Spring application as an embedded server.

#### `web.xml` Configuration:

```xml
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
         http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         version="3.0">

    <!-- Spring Dispatcher Servlet -->
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/applicationContext.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

</web-app>
```

#### `web.xml` for Jetty Configuration:

Since we're embedding Jetty as the servlet container, you typically would not need a traditional `web.xml` to start the server, but you still need it for servlet configuration. For the embedded Jetty configuration, Jetty will automatically pick up the `web.xml`.

### Step 4: Create Jetty Server Configuration Class (Embedded Jetty)

For embedded Jetty, you will need a Java class to initialize Jetty as the servlet container. This class will be responsible for launching the Jetty server.

```java
package com.example.config;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class JettyServerConfig extends AbstractDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Add Spring's DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        context.addServlet(new ServletHolder(dispatcherServlet), "/");

        server.start();
        server.join();
    }
}
```

Explanation:
- **`JettyServerConfig`** extends `AbstractDispatcherServletInitializer` to configure Spring's DispatcherServlet.
- **`Server`**: Starts Jetty on port `8080`, and adds a handler for the Spring `DispatcherServlet`.

### Step 5: Run Your Application

You can now run your Spring MVC application with Jetty. The Jetty server will handle your requests and use the Spring configuration for Kafka with SSL.

### Step 6: Inject Configuration into Your Application

Ensure that you inject the configuration values (Kafka settings, etc.) into your services, for example:

```java
@Service
public class RegistryService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("your-topic", message);
    }
}
```

### Conclusion

- **Kafka**: The configuration of Kafka producer and consumer using SSL was demonstrated.
- **Jetty**: The embedded Jetty server was configured to serve the Spring MVC application.
- **XML Configuration**: Spring MVC and Kafka configurations are managed through `applicationContext.xml` and `web.xml`.

This setup allows secure communication with Kafka using SSL while embedding Jetty as the server for Spring MVC.
### Conclusion

By Dockerizing your Vue.js application, you ensure a consistent, isolated, and reproducible environment that is easy to deploy, scale, and maintain. With the help of Nginx, you can efficiently serve your app and handle any reverse proxy requirements. Docker simplifies the deployment process, making it easier to move your app between environments and manage its dependencies. By following this tutorial, you can leverage the power of Docker for seamless Vue.js development and deployment.

====

Introduction to XML XSD
XML Schema Definition is defined as a language to describe the structure of the XML document. It means that all the XML Standards are defined in the XSD and they are written in XML. It is recommended by W3C to replace the Document Type Definition (DTD). The schema defines their types or built-in types. XML Schema is also allowed to check whether a given XML document is valid with syntactic Confirmation. W3C recommended XML-Schema with 1.0 and 1.1 version.

How XSD works in XML?
A separated file is created for XSD and this document is linked with the respective XML document. With XML Schema Specification a method is specified which is to be included in the root of the XML Document.

<xs: schemaxmlns: xs=http://www.w3.org/2001/XMLSchema
xsi:noNamespaceSchemaLocation="filename.xs"

Here the first statement is the Namespace Declaration.

xs is the namespace Prefix used within the elements a document element of XML Schemas and takes the attribute. The first statement describes the elements and attributes used in the code are defined in the above namespace. Next fragments say that the schema must be namespace-qualified.

The second statement denotes XML-Schema-instance i.e. xi which prefers to use schema Location and namespace which is sometimes made optional.

XSD defines two types of data types.

Simple Type
Complex Type
1. Simple Type
This type permits text-based Elements with fewer attributes and child names.

Some of the Simple types and its description is given below:

Element: It contains simple element as well as other element content.
Attribute: It’s a type used in Simple data types.
Restriction: It has acceptable values in the respective XML document.
a. Elements: Elements being an important part in the Document that contains the data.

The elements are defined in XSD as follows :

<xs : element name  = “ hgfhj” type = “ xxxx” />

So, this is the name property and holds the description about the element. This includes few pre-defined types like xs : integer, xs : date, xs : string, xs : Boolean. The appearance of an element is defined by a cardinality which are specified using attributes like minOccurs and maxOccurs.

Example:

For the XML like:

<manuf_date> 2019 - 05 – 12 </manuf_date>
<Product_company><br />
New jersey <br />
</ Product_company>

The XSD is:

<xs: element name=" manuf_date>"<br />
type="xs: date"/>
<xs: element name=" Product_company "<br />
type="xs: string"/>

The element takes two values which is reflected in the XML document that is fixed and default.

Default is used when there is no specific value assigned in the XML document, XML parser assigns the default that is specified in the XSD.
Fixed is assigned when the value of the XML document matches XSD value in the element.
b. Attributes: The attribute by itself declares it has simple types. If an element has specified attributes then it is a complex type.

Syntax of attribute:

<xs : attribute name =” order” type =” string/integer/Boolean”/>

An XML document with attribute.

<product  id = “2123” > Body Wash </product>

XSD line for the above XML document.

<xs :attribute name =” product “ type =xs :int”/>

If attributes are needed then it is important to assign the keyword ‘use’ to the statement.

<xs :attribute name =” product “ type =xs :int” use=”required” />

c. Restriction: The elements which have some restrictions are called facets. It defines the accepting elements. It takes data types like enumeration, length, max inclusive, exclusive.

Example:

<xs:element name="bookno">
<xs:simpleType>
<xs:restriction base="xs:integer">
<xs:pattern value="[1-81-8][1-8][1-8]"/>
</xs:restriction>
</xs:simpleType>
</xs:element>

So, here an element name book accepts only four-digit between the range [ 1- 8]. Even restrictions can be done on a series of values with strings.

2. Complex Type
This type holds multiple elements and attributes as well and could have empty elements. It can be structured as a container element which allows us to define all the child element within it. Complex type is made global which has a name and can be re-used with the schema. The compositors of Complex types are sequence, all, choice.

<xs:element name="delivery">
<xs:complexType>
<xs:sequence>
<xs:element name="mobile" type="xs:integer"/>
<xs:element name="location" type="xs:string"/>
</xs:sequence>
</xs:complexType>
</xs:element>

The child element for delivery are mobile and location.

Examples to Implement XSD in XML
XML file using Schema Definition.

Example #1
College detail with root element followed by child elements.

Here individual Schema file is created with the perschema.xsd that should be included as the namespace in the XML document.

Code:

pre.xml

<?XML version="1.0" encoding="utf-8"?>
<Result xmlns="College" xsi: schemaLocation="perschema.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<College noOfWorkers="-4420">
<Principal>
<SurName>string</SurName>
<Idno>string</Idno>
</Principal>
<Faculty>
<FullName>string</FullName>
<SurName>string</SurName>
<Address>string</Address>
<Idno>string</Idno>
</Faculty>
<Dept>string</Dept>
</College>
</Result>

Creating a Schema File.

Code:

perschema.xsd

<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns="College" targetNamespace="College" elementFormDefault="qualified" attributeFormDefault="unqualified">
<xs:element name="Faculty" type="FacultyType"/>
<xs:element name="Result">
<xs:complexType>
<xs:sequence>
<xs:element ref="College" maxOccurs="unbounded"/>
</xs:sequence>
</xs:complexType>
</xs:element>
<xs:element name="College">
<xs:complexType>
<xs:sequence>
<xs:choice maxOccurs="unbounded">
<xs:element name="Faculty" type="FacultyType"/>
<xs:element name="Principal" type="FacultyType"/>
</xs:choice>
<xs:element name="Dept" type="xs:string" maxOccurs="unbounded"/>
</xs:sequence>
<xs:attribute name="noOfWorkers" type="xs:int"/>
</xs:complexType>
</xs:element>
<xs:complexType name="FacultyType">
<xs:sequence>
<xs:element name="FullName" type="xs:string" minOccurs="0"/>
<xs:element name="SurName" type="xs:string" minOccurs="0"/>
<xs:element name="Address" type="xs:string" minOccurs="0"/>
<xs:element name="Idno" type="xs:string"/>
<xs:element name="YearsOfExperience" type="xs:int" minOccurs="0"/>
</xs:sequence>
</xs:complexType>
</xs:schema>

Output:

XML XSD 1

Example #2
Order details.

Code:

ord.xml

<?xml version="1.0" standalone="yes"?>
<Orderdetails>
<Customer id="011">
<cname>Mark Lewis</cname>
<destination Country ="Australia" Delivdate=" 6 days">Free Delivery</destination>
<eid>MarkLew@hotmail.com</eid>
</Customer>
<Customer id="022">
<fname from="jersey">Loafther cris</fname>
<destination Country ="USA" Delivdate=" 11 days">Shipping Charges</destination>
<eid>Loafther@email.com</eid>
</Customer>
<Customer id="033">
<cname>Amal Raj</cname>
<destination Country ="Thailand" Delivdate=" 6 days">Shipping Charges</destination>
<email>Anamljjk@ymail.com</email>
</Customer>
</Orderdetails>

Code:

ord.xsd

<?xml version="1.0" encoding="utf-8"?>
<xs:schema attributeFormDefault="unqualified" elementFormDefault="qualified" xmlns:xs="http://www.w3.org/2001/XMLSchema">
<xs:element name="Orderdetails">
<xs:complexType>
<xs:sequence>
<xs:element maxOccurs="unbounded" name="Customer">
<xs:complexType>
<xs:sequence>
<xs:element minOccurs="0" name="fname">
<xs:complexType>
<xs:simpleContent>
<xs:extension base="xs:string">
<xs:attribute name="from" type="xs:string" use="required" />
</xs:extension>
</xs:simpleContent>
</xs:complexType>
</xs:element>
<xs:element minOccurs="0" name="cname" type="xs:string" />
<xs:element name="destination">
<xs:complexType>
<xs:simpleContent>
<xs:extension base="xs:string">
<xs:attribute name="Country" type="xs:string" use="required" />
<xs:attribute name="Delivdate" type="xs:string" use="required" />
</xs:extension>
</xs:simpleContent>
</xs:complexType>
</xs:element>
<xs:element minOccurs="0" name="email" type="xs:string" />
<xs:element minOccurs="0" name="eid" type="xs:string" />
</xs:sequence>
<xs:attribute name="id" type="xs:unsignedByte" use="required" />
</xs:complexType>
</xs:element>
</xs:sequence>
</xs:complexType>
</xs:element>
</xs:schema>

Conclusion
In this article, we saw Schema building formats which are highly evolving as the most important facets in the XML world. Schema is a collection of standard rules that designs how a document is put together. Therefore, to conclude we have seen schema definition for a XML document with an implementation.
