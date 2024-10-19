### Part 1

1. **Why choose Spring Boot over Spring Framework?**
   - Simplifies setup and configuration, offers embedded servers, and provides production-ready features out-of-the-box.

2. **Spring Boot starters used?**
   - Common starters include `spring-boot-starter-web`, `spring-boot-starter-data-jpa`, `spring-boot-starter-security`, etc.

3. **Running a Spring Boot application?**
   - Typically run using `mvn spring-boot:run` or by executing the jar file with `java -jar your-app.jar`.

4. **Purpose of `@SpringBootApplication`?**
   - Combines `@EnableAutoConfiguration`, `@ComponentScan`, and `@Configuration` for easier application setup.

5. **Using `@EnableAutoConfiguration`, `@ComponentScan`, and `@Configuration` directly?**
   - Yes, the application will work as expected, but using `@SpringBootApplication` is more convenient.

6. **What is Auto Configuration?**
   - Automatically configures beans based on the classpath and existing beans, reducing manual configuration.

7. **Disabling specific auto-configuration class?**
   - Use `@EnableAutoConfiguration(exclude = {YourAutoConfiguration.class})` in your main class.

8. **Customizing default configuration?**
   - Override properties in `application.properties` or `application.yml`, or define custom beans.

9. **How `run()` method works internally?**
   - It creates the application context, loads beans, and then runs the application.

10. **What is CommandLineRunner?**
    - An interface for running code at startup, allowing you to execute specific actions after the application context is loaded.

### Part 2

11. **Purpose of Stereotype annotations?**
    - They mark classes as Spring components for auto-detection during classpath scanning.

12. **Defining a bean in Spring?**
    - Use `@Bean` in a `@Configuration` class or use stereotype annotations like `@Component`.

13. **What is Dependency Injection?**
    - A design pattern where a class receives its dependencies from an external source rather than creating them internally.

14. **Ways to perform Dependency Injection?**
    - Constructor injection, setter injection, and field injection.

15. **Setter vs Constructor injection?**
    - Use setter injection for optional dependencies and constructor injection for mandatory dependencies.

16. **Example of `@PostConstruct` use?**
    - For initializing resources after bean creation, e.g., setting up a connection after a bean is constructed.

17. **Dynamically loading values?**
    - Use `@Value` with placeholders or external configuration files.

18. **Differences between YML and properties files?**
    - YML supports hierarchical data, while properties files are flat. Choose YML for complex configurations.

19. **Difference between yml & YAML?**
    - None; YML is a shorthand for YAML.

20. **Loading external properties?**
    - Use `@PropertySource` or specify them in `application.properties`.

21. **Mapping config properties to Java Object?**
    - Use `@ConfigurationProperties` with a prefix.

### Part 3

22. **Resolving bean dependency ambiguity?**
    - Use `@Qualifier` to specify which bean to inject.

23. **Avoiding dependency ambiguity without `@Qualifier`?**
    - By using primary beans with `@Primary` or by restructuring your bean definitions.

24. **Bean scope and types?**
    - Singleton, Prototype, Request, Session, and Application scopes.

25. **Defining custom bean scope?**
    - Implement the `Scope` interface.

26. **Use cases for Singleton and Prototype?**
    - Singleton for stateless services; Prototype for stateful services or those requiring unique instances.

27. **Injecting Prototype bean in Singleton?**
    - Yes, it can be injected, but will behave like a Singleton due to the scope of the parent bean.

28. **Difference between Spring singleton and plain singleton?**
    - Spring singleton ensures one instance per Spring IoC container, while a plain singleton is just a single instance of a class.

29. **Purpose of `BeanPostProcessor`?**
    - Allows custom actions before/after bean initialization and destruction.

### Part 4

30. **Working with RESTful web services?**
    - Common HTTP methods include GET, POST, PUT, DELETE.

31. **Specifying HTTP method type?**
    - Use annotations like `@GetMapping`, `@PostMapping`, etc.

32. **Designing a REST endpoint for products?**
    - Use a method annotated with `@GetMapping` and accept `productType` as a request parameter.

33. **Difference between `@PathVariable` & `@RequestParam`?**
    - `@PathVariable` extracts values from the URL path, while `@RequestParam` extracts query parameters.

34. **Why use `@RestController`?**
    - It combines `@Controller` and `@ResponseBody`, simplifying RESTful API development.

35. **Deserializing JSON in Spring MVC?**
    - Use `@RequestBody` to bind JSON to Java objects.

36. **Update operation in POST?**
    - Yes, but POST is generally for creating resources. Use PUT for updates.

37. **Passing Request Body in GET?**
    - Not standard; GET requests should not have a body.

38. **Content negotiation in REST endpoint?**
    - Use `produces` attribute in mapping annotations and configure message converters.

39. **Common HTTP status codes?**
    - 200 OK, 201 Created, 204 No Content, 400 Bad Request, 404 Not Found, 500 Internal Server Error.

40. **Customizing status code?**
    - Use `ResponseEntity` to set status codes explicitly.

41. **Enabling CORS?**
    - Use `@CrossOrigin` annotation or configure global CORS settings.

### Enabling CORS in Spring Boot

Cross-Origin Resource Sharing (CORS) is a security feature that allows or restricts resources requested from a different domain than the one serving the web page. In Spring Boot, you can enable CORS at both the controller level and globally.

### 1. Using `@CrossOrigin` Annotation

The `@CrossOrigin` annotation can be applied to specific controller methods or to entire controller classes. This is a simple way to enable CORS for specific endpoints.

#### Example of `@CrossOrigin`

```java
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://example.com") // Allow requests from this origin
public class MyController {

    @GetMapping("/api/data")
    public String getData() {
        return "CORS enabled for http://example.com";
    }

    @GetMapping("/api/another-data")
    @CrossOrigin(origins = "http://another-example.com") // Different origin for this method
    public String getAnotherData() {
        return "CORS enabled for http://another-example.com";
    }
}
```

### Explanation:

- The `@CrossOrigin` annotation can specify which origins are allowed. You can also use `allowedMethods`, `allowedHeaders`, and more to customize the configuration further.
- In the example, the `/api/data` endpoint allows CORS requests only from `http://example.com`, while the `/api/another-data` endpoint allows requests from `http://another-example.com`.

### 2. Configuring Global CORS Settings

If you want to enable CORS for all endpoints in your application, you can do this by configuring a global CORS mapping.

#### Example of Global CORS Configuration

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow CORS for all paths
                .allowedOrigins("http://example.com", "http://another-example.com") // Allow specific origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials (e.g., cookies)
    }
}
```

### Explanation:

- **WebMvcConfigurer**: This interface allows you to customize the Spring MVC configuration.
- **addCorsMappings**: This method is overridden to define global CORS configurations.
- **addMapping("/**")**: This allows CORS for all endpoints.
- **allowedOrigins(...)**: Specifies which domains can access the endpoints.
- **allowedMethods(...)**: Lists the HTTP methods that are permitted.
- **allowedHeaders("*")**: Allows all headers to be sent in the request.
- **allowCredentials(true)**: Indicates whether the browser should include credentials (like cookies) in the requests.

### Testing CORS

You can test your CORS configuration using tools like Postman or by making requests from a frontend application running on a different domain. For example, if you have a frontend application hosted at `http://localhost:3000`, make an AJAX request to your Spring Boot application.

### Example AJAX Request

Here’s how you might set up a simple AJAX request using JavaScript:

```javascript
fetch('http://localhost:8080/api/data', {
    method: 'GET',
    credentials: 'include' // Include cookies in requests
})
.then(response => {
    if (response.ok) {
        return response.text();
    }
    throw new Error('Network response was not ok.');
})
.then(data => console.log(data))
.catch(error => console.error('There was a problem with the fetch operation:', error));
```

### Conclusion

By using the `@CrossOrigin` annotation or configuring global CORS settings in Spring Boot, you can easily manage cross-origin requests for your REST APIs. This enhances the flexibility of your application while maintaining security protocols.

42. **File upload in Spring?**
    - Use `@RequestParam` with `MultipartFile`.

### 42. File Upload in Spring

To handle file uploads in Spring Boot, you typically use `@RequestParam` with `MultipartFile`. This allows you to accept files as part of your request.

#### Example of File Upload

1. **Dependency**

Make sure to include the following dependency in your `pom.xml` if you’re using Maven:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

2. **Controller Implementation**

```java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // Save the file locally
            String fileName = file.getOriginalFilename();
            file.transferTo(new java.io.File("uploads/" + fileName));
            return "File uploaded successfully: " + fileName;
        } catch (Exception e) {
            return "Failed to upload file: " + e.getMessage();
        }
    }
}
```

### Explanation:

- **@PostMapping("/upload")**: Maps the endpoint for file upload.
- **@RequestParam("file")**: Binds the uploaded file to the `MultipartFile` parameter.
- **file.transferTo(...)**: Saves the uploaded file to a specified directory.

43. **Maintaining API versioning?**
    - Include version in the URL or use request headers.

### 43. Maintaining API Versioning

API versioning is essential to ensure backward compatibility when you make changes to your API. You can implement versioning in a few different ways.

#### Example: Versioning in the URL

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerV1 {

    @GetMapping
    public String getProducts() {
        return "Product list from V1";
    }
}
```

```java
@RestController
@RequestMapping("/api/v2/products")
public class ProductControllerV2 {

    @GetMapping
    public String getProducts() {
        return "Product list from V2 with more details";
    }
}
```

### Explanation:

- Each controller corresponds to a different version of the API, and the version is included in the URL path (`/api/v1/products` and `/api/v2/products`).

#### Example: Versioning using Request Headers

You can also use request headers to specify the API version.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/api/products")
    public String getProducts(@RequestHeader(value = "API-Version", defaultValue = "1") String apiVersion) {
        if ("2".equals(apiVersion)) {
            return "Product list from V2 with more details";
        }
        return "Product list from V1";
    }
}
```
44. **Documenting REST API?**
    - Use Swagger/OpenAPI for documentation.


### 44. Documenting REST API

Documenting your REST APIs is crucial for clarity and usability. One popular way to do this in Spring Boot is using Swagger/OpenAPI.

#### Example Setup with Springdoc OpenAPI

1. **Dependency**

Add the following dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.14</version> <!-- Check for the latest version -->
</dependency>
```

2. **Controller Annotations**

You can add annotations to your controllers for better documentation.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ProductController {

    @GetMapping("/api/products")
    @Operation(summary = "Get all products", description = "Returns a list of all products")
    public List<Product> getAllProducts() {
        // Retrieve and return products
    }
}
```

### Accessing Swagger UI

After running your application, you can access the Swagger UI at `http://localhost:8080/swagger-ui.html`.

45. **Hiding REST endpoints?**
    - Use security configurations or restrict access with annotations.
### 45. Hiding REST Endpoints

Sometimes, you may want to restrict access to certain endpoints for security reasons.

#### Example: Hiding Endpoints with Security Configurations

1. **Add Security Dependency**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

2. **Security Configuration**

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/public/**").permitAll() // Public endpoints
                .antMatchers("/api/private/**").authenticated() // Secure endpoints
                .and()
            .httpBasic(); // Basic authentication
    }
}
```

### Explanation:

- The configuration restricts access to `/api/private/**` endpoints to authenticated users, while allowing unrestricted access to `/api/public/**`.
- 
46. **Consuming RESTful API?**
    - Use `RestTemplate` or `WebClient` in Spring.

### 46. Consuming RESTful API

To consume a RESTful API in your Spring application, you can use `RestTemplate` or `WebClient`.

#### Example using `RestTemplate`

1. **Dependency**

Ensure you have the required dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

2. **Using `RestTemplate`**

```java
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final RestTemplate restTemplate;

    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product[] getProducts() {
        String url = "http://localhost:8080/api/products";
        return restTemplate.getForObject(url, Product[].class);
    }
}
```

### Example using `WebClient`

For reactive applications, use `WebClient`.

1. **Dependency**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
```

2. **Using `WebClient`**

```java
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProductService {

    private final WebClient webClient;

    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<Product[]> getProducts() {
        return webClient.get()
                        .uri("/api/products")
                        .retrieve()
                        .bodyToMono(Product[].class);
    }
}
```

### Part 5

47. **Handling exceptions in projects?**
    - Use `@ControllerAdvice` for centralized exception handling.

48. **Avoiding multiple exception handlers?**
    - Use a single handler with conditional logic or specific exception types.

49. **Validating input payload?**
    - Use `@Valid` with bean validation annotations.

50. **Populating validation error messages?**
    - Use `BindingResult` to capture errors and return them in the response.

51. **Defining custom bean validation?**
    - Implement `ConstraintValidator` for custom validation logic.

52. **Debugging a bug in production?**
    - Use logging and monitoring tools to trace issues.

53. **Enabling specific environment without profiles?**
    - Use environment variables or configuration classes.

54. **Difference between `@Profile` & `@ConditionalOnXXX`?**
    - `@Profile` activates beans based on the active profile, while `@ConditionalOnXXX` uses custom conditions.

55. **What is AOP?**
    - Aspect-Oriented Programming allows separation of cross-cutting concerns.

56. **Pointcut & Join Points in AOP?**
    - Join points are points in execution, while pointcuts define which join points to intercept.

57. **Different types of advice?**
    - Before, After, Around, AfterReturning, AfterThrowing.

58. **Using AOP for performance evaluation or logging?**
    - Yes, AOP is ideal for logging and monitoring method execution times.

### Part 6

59. **Database interaction in applications?**
    - Using Spring Data JPA for database operations.

60. **Importance of physical naming strategy?**
    - Helps in defining consistent table/column naming in databases.

61. **Benefits of using Spring Data JPA?**
    - Simplifies data access, reduces boilerplate code, and provides powerful querying capabilities.

62. **Differences between Hibernate, JPA, and Spring Data JPA?**
    - Hibernate is an implementation of JPA; Spring Data JPA builds on top of JPA for easier data access.

63. **Connecting multiple databases?**
    - Define multiple `DataSource` beans and configure them accordingly.

64. **Defining custom queries in Spring Data JPA?**
    - Use `@Query` annotations or method naming conventions.

65. **Example of finding results based on range?**
    - Use a repository method like `findByAgeBetween(Integer min, Integer max)`.

66. **Finding average salary?**
    - Define a query method like `findAverageSalary()`.

67. **Defining entity relationships in Spring Data JPA?**
    - Use annotations like `@OneToMany`, `@ManyToOne`, etc., for defining relationships.

68. **Executing Join queries?**
    - Yes, you can use JPQL or native queries with Spring Data JPA.

69. **Implementing pagination & sorting?**
    - Use `Pageable` and `Sort` parameters in repository methods.
