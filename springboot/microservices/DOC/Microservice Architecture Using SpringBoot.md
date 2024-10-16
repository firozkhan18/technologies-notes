# Microservice Architecture Using SpringBoot

## ⌚ Introduction


## ⌚ Microservice Overview

Microservices architecture is an architectural style that structures an application as a collection of loosely coupled services. In a microservices architecture, services are fine-grained and the protocols are lightweight. Spring Boot is a popular framework for building microservices in Java.

### Project Structure: 

![Setting the Scheme](../IMAGES/Microservice_Architecture.PNG)

# Create SpringBoot Services Using Spring Initializr: 

## ⌚ Creating Department Service

Creating Department Service: In a microservices architecture, a Department Service would handle operations related to departments in an organization. This could include creating, updating, deleting, and retrieving department information.

![Setting the Scheme](../IMAGES/department-service.PNG)

In a typical Spring Boot Maven project, the package structure for the Department Service may look something like this:

```
department-service
├── src
│    ├── main
│    │   ├── java
│    │   │   └── com
│    │   │       └── springboot
│    │   │           └── microservice
│    │   │               └── department
│    │   │                   ├── DepartmentServiceApplication.java
│    │   │                   ├── controller
│    │   │                   │   └── DepartmentController.java
│    │   │                   ├── model
│    │   │                   │   └── Department.java
│    │   │                   ├── repository
│    │   │                   │   └── DepartmentRepository.java
│    │   │                   └── service
│    │   │                       └── DepartmentService.java
│    │   └── resources
│    │       ├── application.properties
│    │       ├── application.yml
│    │       └── bootstrap.yml
│    └── test
│        ├── java
│        │   └── com
│        │       └── springboot
│        │           └── microservice
│        │               └── department
│        │                   └── DepartmentServiceApplicationTests.java
│        └── resources
│            └── application.properties
└── pom.xml
```

In this structure:
- `DepartmentServiceApplication.java` is the main class that contains the Spring Boot application setup.
- `DepartmentController.java` is the controller class responsible for handling incoming HTTP requests related to department operations.
- `Department.java` is the entity class that represents a department.
- `DepartmentRepository.java` is the repository interface for interacting with the database.
- `DepartmentService.java` is the service class that contains the business logic for managing departments.

You can further organize your packages as needed based on the complexity and size of your project.

- `pom.xml` add below dependency for eureka server configuration in user-service.

### pom.xml:
 
 	<properties>
		<java.version>11</java.version>
  		<spring-cloud.version>Hoxton.SR8</spring-cloud.version>
	</properties>
 
	<dependencies>
 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
  			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
	</dependencies>

 	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

 - `application.yaml` add the below eureka server configuration so that department-service can connect to the eureka server.

### eureka server configuration:

```yaml
server:
  - port: 9001
  
spring:
  - application:	
    - name: DEPARTMENT-SERVICE   

eureka:
  - client:
    - register-with-eureka: true
    - fetch-registry: true
    - service-url:
        - defaultZone: http://localhost:8761/eureka/
  - instance:
    - hostname: localhost
```
Also, to enable the eureka server in your microservices add the @EnableEurekaClient configuration annotation in your microservices main class.

```
@SpringBootApplication
@EnableEurekaClient
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}
}
```

### zipkin server configuration:

```yaml
server:
  - port: 9001
  
spring:
  - application:	
    - name: DEPARTMENT-SERVICE   
  - zipkin:	
    - base-url: http://127.0.0.1:9411/
```
## ⌚ Creating a User Service

Creating a User Service: A User Service in a microservices architecture would be responsible for managing user data, authentication, and authorization. It would handle operations related to user management, such as creating new users, updating user information, and validating user credentials.

![Setting the Scheme](../IMAGES/user-service.PNG)

In a typical Spring Boot Maven project, the package structure for the User Service may look something like this:

```
user-service
├── src
│    ├── main
│    │   ├── java
│    │   │   └── com
│    │   │       └── springboot
│    │   │           └── microservice
│    │   │               └── user
│    │   │                   ├── UserServiceApplication.java
│    │   │                   ├── controller
│    │   │                   │   └── UserController.java
│    │   │                   ├── model
│    │   │                   │   └── User.java
│    │   │                   ├── repository
│    │   │                   │   └── UserRepository.java
│    │   │                   └── service
│    │   │                       └── UserService.java
│    │   └── resources
│    │       ├── application.properties
│    │       ├── application.yml
│    │       └── bootstrap.yml
│    └── test
│        ├── java
│        │   └── com
│        │       └── springboot
│        │           └── microservice
│        │               └── User
│        │                   └── UserServiceApplicationTests.java
│        └── resources
│            └── application.properties
└── pom.xml
```

In this structure:
- `UserServiceApplication.java` is the main class that contains the Spring Boot application setup.
- `UserController.java` is the controller class responsible for handling incoming HTTP requests related to department operations.
- `User.java` is the entity class that represents a department.
- `UserRepository.java` is the repository interface for interacting with the database.
- `UserService.java` is the service class that contains the business logic for managing departments.

You can further organize your packages as needed based on the complexity and size of your project.

- `pom.xml` add below dependency for eureka server configuration in user-service.
  
### pom.xml:
 
 	<properties>
		<java.version>11</java.version>
  		<spring-cloud.version>Hoxton.SR8</spring-cloud.version>
	</properties>
 
	<dependencies>
 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
  			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
	</dependencies>

 	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

 - `application.yaml` add the below eureka server configuration so that user-service can connect to the eureka server.

### eureka server configuration:

```yaml
server:
  - port: 9002
  
spring:
  - application:	
    - name: USER-SERVICE   

eureka:
  - client:
    - register-with-eureka: true
    - fetch-registry: true
    - service-url:
        - defaultZone: http://localhost:8761/eureka/
  - instance:
    - hostname: localhost
```
Also, to enable the eureka server in your microservices add the @EnableEurekaClient configuration annotation in your microservices main class.

```
@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
```

Once you configure the registry service in your microservices then you need to update the hostname and port with application name USER-SERVICE instead of localhost and verify the services in postman. 

### For example in UserService.java

#### Before registration microservices in registry service:
```
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

	// To communicating user-service with department-service we are using RestTemplate.
        Department department =
                restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId()
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
```
#### After registration microservices in registry service:
```
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        // To communicating user-service with department-service we are using RestTemplate.
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
```
In case if you recieved any error in service response you should add the Load Balancer by using @LoadBalanced annotation and verify again.

```
Service Name: user-service
URL: http://localhost:9002/users/1
Request Type: GET
Output:
{
	"timestamp": "2024-06-24T05:19:34.204+00:00",
	"status": "500",
	"error": "Internal Server Error",
	"message": "",
	"path": "/users/1"
}
```

```
@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

        // To communicating user-service with department-service we are using RestTemplate.
	@Bean
        @LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
```

### zipkin server configuration:

```yaml
server:
  - port: 9002
  
spring:
  - application:	
    - name: USER-SERVICE   
  - zipkin:	
    - base-url: http://127.0.0.1:9411/
```
## ⌚ Implementing Service Registry

Implementing Service Registry: A Service Registry is used in microservices architecture to register and discover services dynamically. This allows services to easily find and communicate with each other without hard-coding service locations. Spring Cloud provides tools like Eureka for implementing service registry in Spring Boot microservices.

![Setting the Scheme](../IMAGES/service-registry.PNG)

In a typical Spring Boot Maven project, the package structure for the Service Registry may look something like this:

```
service-registry
├── src
│    ├── main
│    │   ├── java
│    │   │   └── com
│    │   │       └── springboot
│    │   │           └── microservice
│    │   │               └── service
│    │   │                   └── registry
│    │   │                       └── ServiceRegistryApplication.java
│    │   └── resources
│    │       ├── application.properties
│    │       ├── application.yml
│    │       └── bootstrap.yml
│    └── test
│        ├── java
│        │   └── com
│        │       └── springboot
│        │           └── microservice
│        │               └── service
│        │                   └── registry
│        │                       └── ServiceRegistryApplicationTests.java
│        └── resources
│            └── application.properties
└── pom.xml

```

In this structure:
- `ServiceRegistryApplication.java` is the main class that contains the Spring Boot application setup.

You can further organize your packages as needed based on the complexity and size of your project.

- `application.yaml` configuration for eureka server where default port shoud be 8761.

```yaml
server:
  - port: 8761

eureka:
  - client:
    - register-with-eureka: false
    - fetch-registry: false
```
Start the Service Registry Service and verify the eureka server in browser using following URL: http://localhost:8761

![Setting the Scheme](../IMAGES/eureka-server.png)

## ⌚ Implementing API Gateway

Implementing API Gateway: An API Gateway acts as a single entry point for clients to access multiple microservices. It can handle different tasks like routing requests, load balancing, and authentication. Spring Cloud provides Zuul as a tool for implementing API Gateway in Spring Boot microservices.

![Setting the Scheme](../IMAGES/cloud-gateway.PNG)

In a typical Spring Boot Maven project, the package structure for the Cloud Gateway may look something like this:

```
cloud-gateway
├── src
│    ├── main
│    │   ├── java
│    │   │   └── com
│    │   │       └── springboot
│    │   │           └── microservice
│    │   │               └── cloud
│    │   │                 └── gateway
│    │   │                     ├── CloudGatewayApplication.java
│    │   │                     └── fallBackMethodController.java
│    │   └── resources
│    │       ├── application.properties
│    │       ├── application.yml
│    │       └── bootstrap.yml
│    └── test
│        ├── java
│        │   └── com
│        │       └── springboot
│        │           └── microservice
│        │               └── cloud
│        │                   └── gateway
│        │                       └── CloudGatewayApplicationTests.java
│        └── resources
│            └── application.properties
└── pom.xml

```

In this structure:
- `CloudGatewayApplication.java` is the main class that contains the Spring Boot application setup.
- `fallBackMethodController.java` is the controller class responsible for handling incoming HTTP requests related to department operations.

You can further organize your packages as needed based on the complexity and size of your project.

 - `application.yaml` add the below eureka server configuration so that cloud-gateway can connect to the eureka server.

### eureka server configuration:

```yaml
server:
  - port: 9191
  
spring:
  - application:	
    - name: API-GATEWAY   

eureka:
  - client:
    - register-with-eureka: true
    - fetch-registry: true
    - service-url:
        - defaultZone: http://localhost:8761/eureka/
  - instance:
    - hostname: localhost
```

Also, to enable the eureka server in your microservices add the @EnableEurekaClient configuration annotation in your microservices main class.

```
@SpringBootApplication
@EnableEurekaClient
public class CloudGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}
}
```

### Routing the services using API Gateway:

```yaml
server:
  - port: 9191
  
spring:
  - application:	
    - name: API-GATEWAY  
  - cloud:
    - gateway:
      - routes:
         - id: USER-SERVICE
         - uri: lb://USER-SERVICE
         - predicates:
             - Path=/users/**
         - id: DEPARTMENT-SERVICE
         - uri: lb://DEPARTMENT-SERVICE
         - predicates:
             - Path=/departments/**
eureka:
  - client:
    - register-with-eureka: true
    - fetch-registry: true
    - service-url:
        - defaultZone: http://localhost:8761/eureka/
  - instance:
    - hostname: localhost
```
Once you configure your microservices with API Gateway then you need to update the microservices port with API Gateway  instead of individual microservice port and verify the microservices i.e. department-service & user-service) using postman mentioned in Test The Service In Postman using API Gateway port section below.

In case if you are using Hystrix in your microservices add the below hystrix dependency in your API Gateway pom.xml file and add the @EnableHystrix configuration annotation in your microservices main class.

### Implementing CircuitBreaker using hystrix:

pom.xml:
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```  
CloudGatewayApplication.java:
```
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class CloudGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}
}
```
FallBackMethodController.java
```
@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        return "Department Service is taking longer than Expected." +
                " Please try again later";
    }
}
```
application.yml:
```yaml
server:
  port: 9191

spring:
  - application:
   - name: API-GATEWAY
  - cloud:
    - gateway:
      - routes:
         - id: USER-SERVICE
         - uri: lb://USER-SERVICE
         - predicates:
             - Path=/users/**
         - filters:
             - name: CircuitBreaker
             - args:
                - name: USER-SERVICE
                - fallbackuri: forward:/userServiceFallBack
         - id: DEPARTMENT-SERVICE
         - uri: lb://DEPARTMENT-SERVICE
         - predicates:
             - Path=/departments/**
         - filters:
             - name: CircuitBreaker
             - args:
                - name: DEPARTMENT-SERVICE
                - fallbackuri: forward:/departmentServiceFallBack

hystrix:
  - command:
    - fallbackcmd:
      - execution:
        - isolation:
          - thread:
            - timeoutInMilliseconds: 4000

management:
  - endpoints:
    - web:
      - exposure:
        - include: hystrix.stream
```

## ⌚ Creating Hystrix Dashboard

Creating Hystrix Dashboard: Hystrix is a latency and fault tolerance library designed to isolate points of access to remote systems, services, and 3rd party libraries. Hystrix Dashboard is a tool that allows you to monitor and visualize Hystrix metrics in real time. It helps in identifying faults and performance issues in microservices.

![Setting the Scheme](../IMAGES/hystrix-dashboard.png)

In a typical Spring Boot Maven project, the package structure for the Hystrix Dashboard may look something like this:

```
hystrix-dashboard
├── src
│    ├── main
│    │   ├── java
│    │   │   └── com
│    │   │       └── springboot
│    │   │           └── microservice
│    │   │               └── hystrix
│    │   │                   └── dashboard
│    │   │                       └── HystrixDashboardApplication.java
│    │   └── resources
│    │       ├── application.properties
│    │       ├── application.yml
│    │       └── bootstrap.yml
│    └── test
│        ├── java
│        │   └── com
│        │       └── springboot
│        │           └── microservice
│        │               └── hystrix
│        │                   └── dashboard
│        │                       └── HystrixDashboardApplicationTests.java
│        └── resources
│            └── application.properties
└── pom.xml
```

In this structure:
- `HystrixDashboardApplication.java` is the main class that contains the Spring Boot application setup.

You can further organize your packages as needed based on the complexity and size of your project.

 - `application.yaml` add the below eureka server and hystrix dashboard configuration.

### eureka server and hystrix dashboard configuration:

```yaml
server:
  - port: 9295
  
spring:
  - application:	
    - name: HYSTRIX-DASHBOARD

hystrix:
  - dashboard:
    - proxy-stream-allow-list: "*"  

eureka:
  - client:
    - register-with-eureka: true
    - fetch-registry: true
    - service-url:
        - defaultZone: http://localhost:8761/eureka/
  - instance:
    - hostname: localhost
```

Also, add the @EnableHystrixDashboard and @EnableEurekaClient configuration annotation in your hystrix dashboard service main class.

```
@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
public class HystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}
}
```
### hystrix dashboard:

![Setting the Scheme](../IMAGES/hystrix-dashboard-portal.PNG)

### API Gateway actuator hystrix stream:

![Setting the Scheme](../IMAGES/api-gateway-actuator-hystrix-stream.PNG)

### hystrix dashboard with actuator hystrix stream:

![Setting the Scheme](../IMAGES/hystrix-dashboard-with-stream.PNG)

### hystrix stream home:

![Setting the Scheme](../IMAGES/hystrix-dashboard-with-stream-home.PNG)

### hystrix stream after service verification:

![Setting the Scheme](../IMAGES/hystrix-dashboard-with-stream-after-service-verification.png)

### hystrix stream after service down:

![Setting the Scheme](../IMAGES/hystrix-dashboard-after-service-down.PNG)

## ⌚ Cloud Config Server

Cloud Config Server: Cloud Config Server is a centralized configuration server that provides configuration management for microservices. It allows you to externalize configuration from your microservices code and manage it in a centralized location. Spring Cloud Config provides tools for creating and managing a Cloud Config Server.

![Setting the Scheme](../IMAGES/cloud-config-server.PNG)

In a typical Spring Boot Maven project, the package structure for the Cloud Config Server may look something like this:

```
cloud-config-server
├── src
│    ├── main
│    │   ├── java
│    │   │   └── com
│    │   │       └── springboot
│    │   │           └── microservice
│    │   │               └── cloud
│    │   │                   └── CloudConfigServerApplication.java
│    │   └── resources
│    │       ├── application.properties
│    │       └── application.yml
│    └── test
│        ├── java
│        │   └── com
│        │       └── springboot
│        │           └── microservice
│        │               └── cloud
│        │                   └── CloudConfigServerApplicationTest.java
│        └── resources
│            └── application.properties
└── pom.xml
```

In this structure:
- `CloudConfigServerApplication.java` is the main class that contains the Spring Boot application setup.

You can further organize your packages as needed based on the complexity and size of your project.

- `application.yaml` add the below Cloud Config Server configuration and remove the eureka server from all the services and read from GitHub Repo for Config Server.

### Read Cloud Config Server configuration from GitHub Repo for Config Server repository:

```yaml
server:
  - port: 9296

spring:
  - application:
    - name: CONFIG-SERVER
  - cloud:
    - config:
      - server:
        - git:
          - uri: https://github.com/firozkhan18/config-server
          - clone-on-start: true
```
  
### remove the eureka server configuration from all the microservices & services applicarion.yml files and read configuration from GitHub Repo for Config Server repository:

```yaml
eureka:
  - client:
    - register-with-eureka: true
    - fetch-registry: true
    - service-url:
        - defaultZone: http://localhost:8761/eureka/
  - instance:
    - hostname: localhost
```

Also, add the @EnableHystrixDashboard and @EnableEurekaClient & @EnableConfigServer configuration annotation in your Cloud Config Server service main class.

```
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class CloudConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudConfigServerApplication.class, args);
	}
}
```

## ⌚ GitHub Repo for Config Server

GitHub Repo for Config Server: Using a GitHub repository for the Config Server allows you to store and manage configuration files in a version-controlled repository. This makes it easy to track changes, rollback configurations, and collaborate with other team members.

![Setting the Scheme](../IMAGES/git-repo-config-server-configuration.PNG)

Also, we need to add the below dependency in all the microservices and services.

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

Also, we need to remove the below cloud config properties from all the microservices and services application.yml file and create the bootstrap.yml in all the microservices and services and add the below cloud config properties.

### bootstrap.yml

```yaml
spring:
  - cloud:
    - config:
      - enabled: true
      - uri: http://localhost:9296
```

## ⌚ Zipkin and Sleuth

Zipkin and Sleuth: Zipkin and Sleuth are tools for distributed tracing in microservices architectures. They help to monitor and troubleshoot the interactions between microservices by tracing requests as they flow through the system. Zipkin is a distributed tracing system, while Sleuth is a Spring Cloud library that adds tracing capabilities to Spring applications.

Add the below Zipkin and Sleuth dependency in user-service and department-service microservices.

```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-zipkin</artifactId>
</dependency>
```

Add the below Zipkin configuration in user-service and department-service microservices.

```yaml
server:
  - port: 9002

spring:
  - application:
    - name: USER-SERVICE
  - zipkin:
    - base-url: http://127.0.0.1:9411/
```
### Download Zipkin Server

Zipkin Download URL: https://repo1.maven.org/maven2/io/zipkin/zipkin-server/2.21.7/zipkin-server-2.21.7-exec.jar

Open command prompt and run the Zipkin Server by using below command:

CMD Window> java -jar zipkin-server-2.21.7-exec.jar

![Setting the Scheme](../IMAGES/zipkin-server.PNG)

Zipkin Server URL: http://127.0.0.1:9411/

![Setting the Scheme](../IMAGES/zipkin-server-tracing.PNG)

## ⌚ Server Startup

Execute the services in following order in intellij IDEA:

- `service-registry`
- `cloud-config-server`
- `cloude-gateway`
- `department-service`
- `user-service`
- `hystrix-dashboard`
  
![Setting the Scheme](../IMAGES/springboot-microservice-intellij.PNG)

## ⌚ Test The Service In Postman

```
Service Name: department-service
URL: http://localhost:9001/departments/
Request Type: POST
Request Body:
```
```json
{
    "departmentName":"IT",
    "departmentAddress":"3rd Cross, First Street",
    "departmentCode":"IT-006"
}
```
```
Output:
```
![Setting the Scheme](../IMAGES/department-service-postman.PNG)
```
Service Name: department-service
URL: http://localhost:9001/departments/1
Request Type: GET
Output:
```
![Setting the Scheme](../IMAGES/department-get-service-postman.PNG)
```
Service Name: user-service
URL: http://localhost:9002/users/
Request Type: POST
Request Body:
```
```json
{
    "firstName":"Firoz",
    "lastName":"Khan",
    "email":"firoz.khan@gmail.com",
    "departmentId":"1"
}
```
```
Output:
```
![Setting the Scheme](../IMAGES/user-service-postman.PNG)
```
Service Name: user-service
URL: http://localhost:9002/users/1
Request Type: GET
Output:
```
![Setting the Scheme](../IMAGES/user-get-service-postman.PNG)

## ⌚ Test The Service In Postman using API Gateway port

```
Service Name: department-service
URL: http://localhost:9191/departments/
Request Type: POST
Request Body:
```
```json
{
    "departmentName":"IT",
    "departmentAddress":"3rd Cross, First Street",
    "departmentCode":"IT-006"
}
```
```
Output:
```
![Setting the Scheme](../IMAGES/department-service-postman.PNG)
```
Service Name: department-service
URL: http://localhost:9191/departments/1
Request Type: GET
Output:
```
![Setting the Scheme](../IMAGES/department-get-service-postman.PNG)
```
Service Name: user-service
URL: http://localhost:9191/users/
Request Type: POST
Request Body:
```
```json
{
    "firstName":"Firoz",
    "lastName":"Khan",
    "email":"firoz.khan@gmail.com",
    "departmentId":"1"
}
```
```
Output:
```
![Setting the Scheme](../IMAGES/user-service-postman.PNG)
```
Service Name: user-service
URL: http://localhost:9191/users/1
Request Type: GET
Output:
```
![Setting the Scheme](../IMAGES/user-get-service-postman.PNG)
