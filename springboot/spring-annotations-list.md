Java, Java EE, Spring and Spring Boot Annotations with Examples
author: Ramesh Fadatare

This page contains a one-stop shop for commonly used Java, Java EE, Spring, and Spring Boot annotations with examples. Each annotation is explained with source code examples and its usage.

1. Spring Core Annotations
List of Spring core annotations s

@Component Annotation
The @Component annotation indicates that an annotated class is a “spring bean/component”. The @Component annotation tells the Spring container to automatically create Spring bean.

@Autowired Annotation
The @Autowired annotation is used to inject the bean automatically. The @Autowired annotation is used in constructor injection, setter injection, and field injection

@Qualifier Annotation
@Qualifier annotation is used in conjunction with Autowired to avoid confusion when we have two or more beans configured for the same type.

@Primary Annotation
We use @Primary annotation to give higher preference to a bean when there are multiple beans of the same type.

@Bean Annotation
@Bean annotation indicates that a method produces a bean to be managed by the Spring container. The @Bean annotation is usually declared in the Configuration class to create Spring Bean definitions.

@Lazy Annotation
By default, Spring creates all singleton beans eagerly at the startup/bootstrapping of the application context. You can load the Spring beans lazily (on-demand) using @Lazy annotation.

@Scope Annotation
The @Scope annotation is used to define the scope of the bean. We use @Scope to define the scope of a @Component class or a @Bean definition.

@Value Annotation
Spring @Value annotation is used to assign default values to variables and method arguments. @Value annotation is mostly used to get value for specific property keys from the properties file.

@PropertySource Annotation
Spring @PropertySource annotation is used to provide properties files to Spring Environment.

2. Spring MVC Web Annotations
List of Spring MVC annotations s

@Controller Annotation
Spring provides @Controller annotation to make a Java class as a Spring MVC controller. The @Controller annotation indicates that a particular class serves the role of a controller.

@ResponseBody Annotation
The @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.

@RestController Annotation
Spring 4.0 introduced @RestController, a specialized version of the @Controller which is a convenience annotation that does nothing more than add the @Controller and @ResponseBody annotations.

@RequestMapping Annotation
@RequestMapping is the most common and widely used annotation in Spring MVC. It is used to map web requests onto specific handler classes and/or handler methods.

@GetMapping Annotation
The GET HTTP request is used to get single or multiple resources and @GetMapping annotation for mapping HTTP GET requests onto specific handler methods.

@PostMapping Annotation
The POST HTTP method is used to create a resource and @PostMapping annotation for mapping HTTP POST requests onto specific handler methods.

@PutMapping Annotation
The PUT HTTP method is used to update the resource and @PutMapping annotation for mapping HTTP PUT requests onto specific handler methods.

@DeleteMapping Annotation
The DELETE HTTP method is used to delete the resource and @DeleteMapping annotation for mapping HTTP DELETE requests onto specific handler methods.

@PatchMapping Annotation
The PATCH HTTP method is used to update the resource partially and the @PatchMapping annotation is for mapping HTTP PATCH requests onto specific handler methods.

@PathVariable Annotation
Spring boot @PathVariable annotation is used on a method argument to bind it to the value of a URI template variable.

@ResponseStatus Annotation
The @ResponseStatus annotation is a Spring Framework annotation that is used to customize the HTTP response status code returned by a controller method in a Spring MVC or Spring Boot application.

@Service Annotation
@Service annotation is used to create Spring beans at the Service layer.

@Repository Annotation
@Repository is used to create Spring beans for the repositories at the DAO layer.

@Controller Annotation
@Controller is used to create Spring beans at the controller layer.

3. Spring Boot Annotations
List of Spring Boot Annotations s

@SpringBootApplication annotation
The @SpringBootApplication annotation is a core annotation in the Spring Boot framework. It is used to mark the main class of a Spring Boot application.

@EnableAutoConfiguration annotation
@EnableAutoConfiguration annotation enables Spring Boot's auto-configuration feature, which automatically configures the application based on the classpath dependencies and the environment.

@Async Annotation
The @Async annotation can be provided on a method so that invocation of that method will occur asynchronously.

@Scheduled Annotation
The @Scheduled annotation is added to a method along with some information about when to execute it, and Spring takes care of the rest.

@SpringBootTest annotation
Spring Boot provides @SpringBootTest annotation for Integration testing. This annotation creates an application context and loads the full application context.

@WebMvcTest annotation
The @WebMvcTest annotation is used to perform unit tests on Spring MVC controllers. It allows you to test the behavior of controllers, request mappings, and HTTP responses in a controlled and isolated environment.

4. Spring Data JPA Annotations
List of 4. Spring Data JPA Annotations s

@Query Annotation
In Spring Data JPA, the @Query annotation is used to define custom queries. It allows developers to execute both JPQL (Java Persistence Query Language) and native SQL queries.

@DataJpaTest annotation
Spring Boot provides the @DataJpaTest annotation to test the persistence layer components that will autoconfigure the in-memory embedded database for testing purposes.

5. JPA and Hibernate Annotations
List of JPA and Hibernate Annotations s

JPA @Id and @GeneratedValue
@Id: Marks a field as the primary key of an entity. 
@GeneratedValue: Specifies the strategy for generating primary key values.

JPA @Entity and @Table
@Entity: Specifies that a class is an entity and is mapped to a database table. 
@Table: Specifies the table name associated with an entity.

@Column Annotation
@Column: Specifies the mapping for a database column.

JPA @Transient Annotation
@Transient: Excludes a field from being persisted in the database.

JPA @OneToOne Annotation
@OneToOne: Defines a one-to-one relationship between two entities.

JPA @OneToMany Annotation
@OneToMany: Defines a one-to-many relationship between two entities.

JPA @ManyToOne Annotation
@ManyToOne: Defines a many-to-one relationship between two entities.

JPA @ManyToMany Annotation
@ManyToMany: Defines a many-to-many relationship between two entities.

JPA @JoinTable Annotation
@JoinTable: The @JoinTable annotation in JPA is used to customize the association table that holds the relationships between two entities in a many-to-many relationship.

Hibernate @PrimaryKeyJoinColumn
The @PrimaryKeyJoinColumn annotation in JPA (Java Persistence API) and Hibernate is used in the context of inheritance relationships and table mappings, particularly in the Joined Strategy.

Hibernate @Embeddable and @Embedded
@Embeddable: This annotation is used to declare a class as an Embeddable class. 
@Embedded: This annotation is used in the entity class to specify a field that will be embedded.

6. Java and Servlet Annotations
List of Servlet Annotations s

@WebServlet Annotation
The @WebServlet annotation is used to define a Servlet component in a web application.

@WebInitParam Annotation
The @WebInitParam annotation is used to specify any initialization parameters that must be passed to the Servlet or the Filter.

@WebListener Annotation
The @WebListener annotation is used to annotate a listener to get events for various operations on the particular web application context.

@WebFilter Annotation
The @WebFilter annotation is used to define a Filter in a web application.

@MultipartConfig Annotation
The @MultipartConfig annotation, when specified on a Servlet, indicates that the request it expects is of type multipart/form-data.

Java @FunctionalInterface
The @FunctionalInterface annotation indicates that an interface is a functional interface and contains exactly one abstract method.

