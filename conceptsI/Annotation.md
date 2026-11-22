# Complete Java + Spring Boot + Microservices Annotations Guide

This guide covers important annotations asked in Senior Java Developer, Spring Boot, Microservices and Technical Lead interviews, with purpose, usage and practical code examples.

It includes core Java, Spring Framework, Spring Boot, REST APIs, JPA/Hibernate, Spring Security, Kafka, validation, testing, caching, transactions and microservices.

# 1. Core Java annotations

| Annotation | Purpose | Usage |
| --- | --- | --- |
| `@Override` | Overrides parent method | Method overriding |
| `@Deprecated` | Marks API as deprecated | Legacy methods |
| `@SuppressWarnings` | Suppresses compiler warnings | Type safety warnings |
| `@FunctionalInterface` | Ensures one abstract method | Lambda expressions |
| `@SafeVarargs` | Suppresses varargs heap pollution warnings | Generic varargs |
| `@Retention` | Defines annotation lifetime | Custom annotations |
| `@Target` | Defines where annotation can be applied | Custom annotations |
| `@Inherited` | Inherits class annotations | Custom annotations |
| `@Documented` | Includes annotation in Javadoc | Custom annotations |

### Example: @Override

java

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Barking");
    }
}
```

### Example: @FunctionalInterface

java

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = (a, b) -> a + b;

        System.out.println(calculator.add(10, 20));
    }
}
```

# 2. Spring Core annotations

These annotations are very important for Spring Boot interviews.

| Annotation | Purpose | Usage |
| --- | --- | --- |
| `@Component` | Creates Spring-managed bean | Generic component |
| `@Service` | Service layer bean | Business logic |
| `@Repository` | Persistence layer bean | DAO classes |
| `@Controller` | MVC controller | Web applications |
| `@RestController` | REST controller | REST APIs |
| `@Autowired` | Injects dependencies | Dependency injection |
| `@Qualifier` | Selects specific bean | Multiple implementations |
| `@Primary` | Sets default bean | Multiple implementations |
| `@Bean` | Declares bean manually | Configuration |
| `@Configuration` | Configuration class | Bean definitions |
| `@ComponentScan` | Scans components | Bean discovery |
| `@Scope` | Defines bean scope | Singleton, prototype |
| `@Lazy` | Lazy initialization | Delayed bean creation |
| `@Value` | Injects property values | Configuration |
| `@PropertySource` | Loads property file | External properties |
| `@Import` | Imports configuration | Modular configuration |
| `@DependsOn` | Specifies initialization dependency | Bean initialization |
| `@Lookup` | Looks up another bean dynamically | Prototype injection |

### Example: @Component, @Service, @Repository

java

```java
@Component
public class EmailUtil {
    public void sendEmail() {
        System.out.println("Email sent");
    }
}
```

java

```java
@Repository
public class UserRepository {

    public String getUser() {
        return "John";
    }
}
```

java

```java
@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getUser() {
        return repository.getUser();
    }
}
```

Interview question: What is the difference between @Component, @Service and @Repository?

- `@Component`: Generic Spring-managed bean.
- `@Service`: Indicates business logic.
- `@Repository`: Indicates persistence logic and supports persistence exception translation.

All three are Spring stereotype annotations.

### Example: @Autowired and @Qualifier

java

```java
public interface PaymentService {
    void pay();
}
```

java

```java
@Service("upiPayment")
public class UpiPaymentService implements PaymentService {

    public void pay() {
        System.out.println("UPI Payment");
    }
}
```

java

```java
@Service("cardPayment")
public class CardPaymentService implements PaymentService {

    public void pay() {
        System.out.println("Card Payment");
    }
}
```

java

```java
@Service
public class OrderService {

    private final PaymentService paymentService;

    public OrderService(
            @Qualifier("upiPayment")
            PaymentService paymentService) {

        this.paymentService = paymentService;
    }
}
```

Important: Constructor injection is generally preferred over field injection because it makes dependencies explicit and supports immutability.

# 3. Spring Boot annotations

| Annotation | Purpose | Usage |
| --- | --- | --- |
| `@SpringBootApplication` | Main application annotation | Application startup |
| `@EnableAutoConfiguration` | Automatic configuration | Auto configuration |
| `@ConfigurationProperties` | Binds external properties | Configuration management |
| `@ConfigurationPropertiesScan` | Scans configuration properties | Property binding |
| `@EnableConfigurationProperties` | Enables configuration properties | Property registration |
| `@ConditionalOnProperty` | Conditional bean creation | Feature toggles |
| `@ConditionalOnClass` | Bean creation based on classpath | Auto configuration |
| `@ConditionalOnMissingBean` | Creates bean if absent | Default configuration |
| `@Profile` | Environment-specific beans | Dev, QA, Prod |
| `@ImportAutoConfiguration` | Imports auto-configurations | Configuration customization |

### Example: @SpringBootApplication

java

```java
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

It combines:

- `@Configuration`
- `@EnableAutoConfiguration`
- `@ComponentScan`

### Example: @Profile

java

```java
@Configuration
public class DatabaseConfig {

    @Bean
    @Profile("dev")
    public String devDatabase() {
        return "Development Database";
    }

    @Bean
    @Profile("prod")
    public String prodDatabase() {
        return "Production Database";
    }
}
```

Activate profile:

properties

```properties
spring.profiles.active=dev
```

### Example: @ConfigurationProperties

java

```java
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String name;
    private int timeout;

    // getters and setters
}
```

`application.properties`:

properties

```properties
app.name=OrderService
app.timeout=5000
```

# 4. Spring REST API annotations

These are frequently asked in senior interviews.

| Annotation | Purpose |
| --- | --- |
| `@RestController` | Creates REST controller |
| `@RequestMapping` | Defines common request mapping |
| `@GetMapping` | Handles GET |
| `@PostMapping` | Handles POST |
| `@PutMapping` | Handles PUT |
| `@PatchMapping` | Handles PATCH |
| `@DeleteMapping` | Handles DELETE |
| `@PathVariable` | Reads URL path parameter |
| `@RequestParam` | Reads query parameter |
| `@RequestBody` | Reads request body |
| `@ResponseBody` | Writes response body |
| `@ResponseStatus` | Defines HTTP status |
| `@RequestHeader` | Reads HTTP header |
| `@CookieValue` | Reads cookie |
| `@CrossOrigin` | Configures CORS |
| `@ExceptionHandler` | Handles exceptions |
| `@ControllerAdvice` | Global exception handling |
| `@RestControllerAdvice` | Global REST exception handling |
| `@ModelAttribute` | Binds request parameters to object |
| `@InitBinder` | Customizes data binding |

### Complete REST API example

java

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        return "User ID: " + id;
    }

    @GetMapping
    public String searchUser(
            @RequestParam String name) {
        return "User: " + name;
    }

    @PostMapping
    public String createUser(
            @RequestBody User user) {
        return "User created";
    }

    @PutMapping("/{id}")
    public String updateUser(
            @PathVariable Long id,
            @RequestBody User user) {
        return "User updated";
    }

    @PatchMapping("/{id}")
    public String partialUpdate(
            @PathVariable Long id,
            @RequestBody User user) {
        return "User partially updated";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return "User deleted";
    }
}
```

### @ControllerAdvice and @ExceptionHandler

Used to handle exceptions globally.

java

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(
            RuntimeException ex) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}
```

# 5. Spring Validation annotations

These annotations validate incoming API requests.

| Annotation | Purpose |
| --- | --- |
| `@Valid` | Triggers validation |
| `@Validated` | Supports Spring validation groups and method validation |
| `@NotNull` | Value cannot be null |
| `@NotEmpty` | Cannot be null or empty |
| `@NotBlank` | Cannot be null or whitespace |
| `@Size` | Defines length or collection size |
| `@Min` | Minimum numeric value |
| `@Max` | Maximum numeric value |
| `@Email` | Validates email |
| `@Pattern` | Regex validation |
| `@Positive` | Must be positive |
| `@PositiveOrZero` | Must be non-negative |
| `@Past` | Date must be in past |
| `@Future` | Date must be in future |
| `@DecimalMin` | Minimum decimal value |
| `@DecimalMax` | Maximum decimal value |

### Example

java

```java
public class UserRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    private String email;

    @Min(18)
    private int age;

    @NotBlank
    @Size(min = 10, max = 15)
    private String mobile;
}
```

Controller:

java

```java
@PostMapping("/register")
public ResponseEntity<String> register(
        @Valid @RequestBody UserRequest request) {

    return ResponseEntity.ok("Registered successfully");
}
```

# 6. Spring Data JPA and Hibernate annotations

Very important for Java backend interviews.

| Annotation | Purpose |
| --- | --- |
| `@Entity` | Defines database entity |
| `@Table` | Defines table name |
| `@Id` | Primary key |
| `@GeneratedValue` | Generates primary key |
| `@Column` | Column configuration |
| `@Transient` | Excludes field from persistence |
| `@Enumerated` | Enum mapping |
| `@Temporal` | Legacy Date mapping |
| `@Lob` | Large object |
| `@OneToOne` | One-to-one relationship |
| `@OneToMany` | One-to-many relationship |
| `@ManyToOne` | Many-to-one relationship |
| `@ManyToMany` | Many-to-many relationship |
| `@JoinColumn` | Foreign key column |
| `@JoinTable` | Join table |
| `@Embedded` | Embedded value object |
| `@Embeddable` | Defines embedded class |
| `@Version` | Optimistic locking |
| `@Inheritance` | Entity inheritance |
| `@DiscriminatorColumn` | Inheritance discriminator |
| `@MappedSuperclass` | Shared mapped fields |
| `@EntityListeners` | Entity lifecycle listeners |
| `@PrePersist` | Before insert |
| `@PostPersist` | After insert |
| `@PreUpdate` | Before update |
| `@PostUpdate` | After update |
| `@PreRemove` | Before delete |
| `@PostRemove` | After delete |
| `@PostLoad` | After loading entity |

### Example: @Entity

java

```java
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String name;

    private String email;
}
```

### Example: @OneToMany and @ManyToOne

java

```java
@Entity
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
```

java

```java
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
```

### Example: @Version

Used for optimistic locking.

java

```java
@Entity
public class Account {

    @Id
    private Long id;

    private Double balance;

    @Version
    private Long version;
}
```

If two transactions attempt conflicting updates using the same version, the later conflicting update can fail with an optimistic locking exception.

# 7. Spring Data Repository annotations

| Annotation | Purpose |
| --- | --- |
| `@Query` | Custom JPQL or native SQL |
| `@Modifying` | Marks update/delete query |
| `@Param` | Binds query parameter |
| `@EntityGraph` | Controls fetching relationships |
| `@Lock` | Configures lock mode |
| `@Transactional` | Transaction management |

### Example: @Query

java

```java
@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(
            @Param("email") String email);

    @Modifying
    @Query("UPDATE User u SET u.name = :name WHERE u.id = :id")
    int updateName(
            @Param("id") Long id,
            @Param("name") String name);
}
```

The modifying query should be executed within an appropriate transaction.

# 8. Spring Transaction annotations

| Annotation | Purpose |
| --- | --- |
| `@Transactional` | Defines transaction boundary |
| `@EnableTransactionManagement` | Enables annotation-driven transactions |
| `@TransactionalEventListener` | Handles events at transaction phases |

### Example: @Transactional

java

```java
@Service
public class TransferService {

    private final AccountRepository repository;

    public TransferService(AccountRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void transfer(
            Long fromId,
            Long toId,
            double amount) {

        Account from = repository.findById(fromId)
                .orElseThrow();

        Account to = repository.findById(toId)
                .orElseThrow();

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        repository.save(from);
        repository.save(to);
    }
}
```

Important interview concepts:

- Propagation.
- Isolation.
- Rollback rules.
- Read-only transactions.
- Transaction boundaries.
- Self-invocation limitation.
- Proxy-based transaction management.

# 9. Spring Security annotations

| Annotation | Purpose |
| --- | --- |
| `@EnableWebSecurity` | Enables Spring web security configuration |
| `@EnableMethodSecurity` | Enables method security |
| `@PreAuthorize` | Checks authorization before method execution |
| `@PostAuthorize` | Checks authorization after method execution |
| `@Secured` | Role-based method security |
| `@RolesAllowed` | JSR-250 role security |
| `@AuthenticationPrincipal` | Injects current principal |
| `@WithMockUser` | Test authentication context |

### Example: @PreAuthorize

java

```java
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
}
```

java

```java
@Service
public class AdminService {

    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(Long id) {
        return "User deleted";
    }
}
```

Remember: `hasRole('ADMIN')` normally checks for the authority `ROLE_ADMIN`.

### Example: @AuthenticationPrincipal

java

```java
@GetMapping("/profile")
public String profile(
        @AuthenticationPrincipal UserDetails user) {

    return user.getUsername();
}
```

# 10. Spring Kafka annotations

| Annotation | Purpose |
| --- | --- |
| `@EnableKafka` | Enables Kafka listener infrastructure |
| `@KafkaListener` | Consumes Kafka messages |
| `@SendTo` | Defines reply destination |
| `@Header` | Reads Kafka message header |
| `@Payload` | Extracts message payload |
| `@KafkaHandler` | Routes messages by payload type in class-level listener setups |

### Example: Kafka Producer

java

```java
@Service
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderProducer(
            KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String message) {
        kafkaTemplate.send("order-topic", message);
    }
}
```

### Example: Kafka Consumer

java

```java
@Component
public class OrderConsumer {

    @KafkaListener(
        topics = "order-topic",
        groupId = "order-group"
    )
    public void consume(String message) {
        System.out.println(message);
    }
}
```

# 11. Spring Cloud Microservices annotations

| Annotation | Purpose |
| --- | --- |
| `@EnableDiscoveryClient` | Enables discovery integration where required |
| `@EnableFeignClients` | Enables Feign clients |
| `@FeignClient` | Declares HTTP client |
| `@LoadBalanced` | Enables load-balanced client integration |
| `@RefreshScope` | Supports refreshing scoped beans |
| `@EnableCircuitBreaker` | Legacy circuit breaker enablement |
| `@CircuitBreaker` | Resilience4j circuit breaker |
| `@Retry` | Resilience4j retry |
| `@RateLimiter` | Resilience4j rate limiter |
| `@Bulkhead` | Resilience4j bulkhead |
| `@TimeLimiter` | Resilience4j time limiter |
| `@Fallback` | Fallback method in certain libraries |

### Example: @FeignClient

java

```java
@FeignClient(name = "payment-service")
public interface PaymentClient {

    @GetMapping("/api/payments/{id}")
    Payment getPayment(@PathVariable Long id);
}
```

Enable Feign:

java

```java
@SpringBootApplication
@EnableFeignClients
public class OrderApplication {
}
```

### Example: Resilience4j @CircuitBreaker

java

```java
@Service
public class PaymentService {

    @CircuitBreaker(
        name = "paymentService",
        fallbackMethod = "fallback"
    )
    public String processPayment() {

        return "Payment successful";
    }

    public String fallback(Exception ex) {
        return "Payment service temporarily unavailable";
    }
}
```

The fallback should not report a payment as successful when the actual payment outcome is unknown.

# 12. Spring Caching annotations

| Annotation | Purpose |
| --- | --- |
| `@EnableCaching` | Enables caching |
| `@Cacheable` | Reads from cache or computes value |
| `@CachePut` | Always executes method and updates cache |
| `@CacheEvict` | Removes cache entries |
| `@Caching` | Combines multiple cache operations |
| `@CacheConfig` | Class-level cache configuration |

### Example

java

```java
@Configuration
@EnableCaching
public class CacheConfig {
}
```

java

```java
@Service
public class ProductService {

    @Cacheable(value = "products", key = "#id")
    public Product getProduct(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @CachePut(value = "products", key = "#product.id")
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
```

# 13. Spring Scheduling and Async annotations

| Annotation | Purpose |
| --- | --- |
| `@EnableScheduling` | Enables scheduled tasks |
| `@Scheduled` | Executes scheduled method |
| `@EnableAsync` | Enables asynchronous execution |
| `@Async` | Executes method asynchronously |

### Example: @Scheduled

java

```java
@Configuration
@EnableScheduling
public class SchedulerConfig {
}
```

java

```java
@Component
public class ReportScheduler {

    @Scheduled(cron = "0 0 9 * * *")
    public void generateReport() {
        System.out.println("Generating daily report");
    }
}
```

### Example: @Async

java

```java
@Configuration
@EnableAsync
public class AsyncConfig {
}
```

java

```java
@Service
public class EmailService {

    @Async
    public CompletableFuture<String> sendEmail() {

        System.out.println("Sending email");

        return CompletableFuture.completedFuture("Sent");
    }
}
```

Configure a bounded executor in production rather than relying blindly on default executor behavior.

# 14. Spring Testing annotations

| Annotation | Purpose |
| --- | --- |
| `@SpringBootTest` | Full application context testing |
| `@WebMvcTest` | MVC slice testing |
| `@DataJpaTest` | JPA slice testing |
| `@JsonTest` | JSON serialization testing |
| `@RestClientTest` | REST client testing |
| `@MockBean` | Legacy Spring Boot mock bean support |
| `@MockitoBean` | Spring Framework bean overriding with Mockito |
| `@Mock` | Mockito mock |
| `@InjectMocks` | Injects Mockito mocks |
| `@Test` | JUnit test |
| `@BeforeEach` | Runs before each test |
| `@AfterEach` | Runs after each test |
| `@ParameterizedTest` | Parameterized test |
| `@Disabled` | Disables test |
| `@ActiveProfiles` | Selects test profile |
| `@TestConfiguration` | Test-specific configuration |

### Example

java

```java
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void shouldReturnUser() {
        assertNotNull(userService);
    }
}
```

# 15. Lombok annotations

| Annotation | Purpose |
| --- | --- |
| `@Getter` | Generates getters |
| `@Setter` | Generates setters |
| `@Data` | Generates getters, setters, equals, hashCode and toString |
| `@NoArgsConstructor` | Generates no-argument constructor |
| `@AllArgsConstructor` | Generates all-argument constructor |
| `@RequiredArgsConstructor` | Generates constructor for required fields |
| `@Builder` | Builder pattern |
| `@ToString` | Generates toString |
| `@EqualsAndHashCode` | Generates equality methods |
| `@Slf4j` | Generates logger |
| `@Value` | Creates immutable-style value class |
| `@SneakyThrows` | Suppresses checked exception declaration |

### Example

java

```java
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String name;
    private String email;
}
```

Usage:

java

```java
Employee employee = Employee.builder()
        .id(1L)
        .name("John")
        .email("john@gmail.com")
        .build();
```

Interview tip: Be careful with `@Data` on JPA entities because generated `equals()`, `hashCode()` and `toString()` can cause problems with lazy relationships and bidirectional associations.

# 16. Custom annotations

You can create your own annotations in Java.

### Example

java

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackExecution {
}
```

Usage:

java

```java
@Service
public class OrderService {

    @TrackExecution
    public void createOrder() {
        System.out.println("Order created");
    }
}
```

A custom annotation alone does not execute tracking logic. You need an interceptor, aspect or another mechanism to process it.

# 17. Most important annotations for Senior Interviews

| Priority | Annotation | Why important |
| --- | --- | --- |
| 1 | `@SpringBootApplication` | Spring Boot startup |
| 2 | `@Component` | Bean management |
| 3 | `@Service` | Business layer |
| 4 | `@Autowired` | Dependency injection |
| 5 | `@RestController` | REST APIs |
| 6 | `@RequestMapping` | Endpoint mapping |
| 7 | `@RequestBody` | Request handling |
| 8 | `@Valid` | Request validation |
| 9 | `@ControllerAdvice` | Global exceptions |
| 10 | `@Entity` | ORM |
| 11 | `@OneToMany` | Entity relationships |
| 12 | `@Transactional` | Transaction management |
| 13 | `@Version` | Optimistic locking |
| 14 | `@PreAuthorize` | Security |
| 15 | `@KafkaListener` | Event-driven systems |
| 16 | `@FeignClient` | Service communication |
| 17 | `@CircuitBreaker` | Fault tolerance |
| 18 | `@Cacheable` | Performance |
| 19 | `@Async` | Asynchronous execution |
| 20 | `@SpringBootTest` | Testing |

# 18. Interview questions to practice

1. What is the difference between `@Component`, `@Service` and `@Repository`?
2. What happens internally when `@Autowired` is used?
3. What is the difference between `@Bean` and `@Component`?
4. What is the difference between `@Controller` and `@RestController`?
5. What is the difference between `@RequestParam` and `@PathVariable`?
6. What is the difference between `@Valid` and `@Validated`?
7. What is the difference between `@Transactional` and `@Modifying`?
8. What is the difference between `@OneToMany` and `@ManyToOne`?
9. What is the purpose of `@Version`?
10. What happens when `@Transactional` is used on a private method?
11. Why does `@Transactional` sometimes not work during self-invocation?
12. What is the difference between `@Cacheable` and `@CachePut`?
13. What is the difference between `@Primary` and `@Qualifier`?
14. What is the difference between `@SpringBootTest` and `@WebMvcTest`?
15. How does `@KafkaListener` work?
16. What is the difference between `@Async` and `CompletableFuture`?
17. How does `@PreAuthorize` work internally?
18. What is the difference between `@Profile` and `@ConditionalOnProperty`?
19. What is the difference between `@ComponentScan` and `@EnableAutoConfiguration`?
20. How do you create a custom annotation using AOP?

Preparation recommendation: Master sections 2–11 first. They cover the annotations most commonly encountered in senior Java, Spring Boot and Microservices technical interviews.

Version note: Some Spring Cloud and Spring Security annotations vary by library version. Older annotations such as `@EnableCircuitBreaker` are legacy; modern Resilience4j uses annotations such as `@CircuitBreaker`.
