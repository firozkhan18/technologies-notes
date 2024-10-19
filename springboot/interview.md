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

42. **File upload in Spring?**
    - Use `@RequestParam` with `MultipartFile`.

43. **Maintaining API versioning?**
    - Include version in the URL or use request headers.

44. **Documenting REST API?**
    - Use Swagger/OpenAPI for documentation.

45. **Hiding REST endpoints?**
    - Use security configurations or restrict access with annotations.

46. **Consuming RESTful API?**
    - Use `RestTemplate` or `WebClient` in Spring.

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

This summary covers a wide range of Spring Boot concepts and should be helpful for your understanding and preparation!
