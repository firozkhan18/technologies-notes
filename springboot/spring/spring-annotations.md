# Spring Annotations List

1. Annotations in Spring Framework
Similar to other places, annotations help by providing metadata and instructions to the Spring container. They allow the container to understand and configure various components within a Spring application.

To make it more precise, annotations help during component scanning, dependency injection, autowiring, defining configurations, aspect-oriented programming, data access, testing and many more areas. Over all annotations provide a declarative way to express the intentions and behavior of components, leading to cleaner, more maintainable code.

2. Bean Annotations
In the Spring Framework, a bean is an object that is instantiated, assembled, and managed by the Spring IoC (Inversion of Control) container. The container also performs dependency injection, allowing beans to be wired together and collaborate with each other.

The following annotations provide metadata to Spring to control how to instantiate, configure, and wire the beans together.

2.1. @Bean
The @Bean is a method-level annotation used to declare a spring bean. When the container executes the annotated method, it registers the return value as a bean within a BeanFactory.

By default, the bean name will be the same as the method name. To customize the bean name, use its’ name‘  or  ‘value‘ attribute.

@Bean
EmployeeService employeeService()
{
    return new EmployeeServiceImpl();
}

2.2. @Component, @Controller, @Repository, @Service
These annotations are called stereotype annotations. When component scanning is enabled, Spring will automatically import these beans into the container and inject them into dependencies.

The @Component annotation is a generic annotation and marks a Java class as a bean.
The @Controller annotation marks a class as a Spring MVC controller.
The @Repository annotation is a specialization of the @Component annotation. In addition to importing the DAOs into the DI container, it also makes the unchecked exceptions (thrown from DAO methods) eligible for translation into Spring DataAccessException.
The @Service annotation is also a specialization of @Component and used over service-layer classes because it specifies intent better. It doesn’t currently provide any additional behavior.
@Controller
public class UserMgmtController {

   //API handler methods
}

@Service
public class EmployeeServiceImpl inplements EmployeeService {
   //... 
}

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    ...
}

2.3. @Qualifier
During autowiring, if more than one bean of the same type is available in the container then the container will throw runtime exception. To fix this problem, we have to specifically tell Spring which bean has to be injected using this annotation.

In the given example, if there are two beans of type Repository then on runtime, the bean with the name ‘fsRepository‘ will be injected.

public class EmployeeService {
 
    @Autowired
    @Qualifier("fsRepository")
    private Repository repository;
}

2.4. @Autowired
This annotation marks a constructor, field, setter method, or config method as to be autowired by dependency injection. We can mark whether the annotated dependency is required (mandatory to populate) or not using it’s ‘required’ attribute. By default, its value is ‘true’.

@Service
public class EmployeeService {
 
    @Autowired
    private EmployeeDao dao;
}

2.5. @Value
Applicable at the field or method/constructor parameter level, and indicates a default value expression for the affected argument.

public class SomeService {
 
    @Value("${ENV:DEV}")
    private String environment;
}

2.6. @Lazy
Indicates whether a bean is to be lazily initialized. By default, in spring DI, eager initialization will occur. When applied over any bean, initialization of that bean will not happen until referenced by another bean or explicitly retrieved from the enclosing BeanFactory.

@Component
public class SomeService {
 
    @Autowired
    @Lazy
    private RemoteService remoting;
}

2.7. @DependsOn
During component scanning, it is used to specify the beans on which the current bean depends on. The specified beans are guaranteed to be created by the container before this bean.

@Component
public class SomeService {
 
    @Autowired
    @DependsOn ("pingService")
    private RemoteService remoting;
}

2.8. @Lookup
Indicates a method as a lookup method. It is best used for injecting a prototype-scoped bean into a singleton bean.

@Component
@Scope("prototype")
public class AppNotification {
    //prototype-scoped bean
}
 
@Component
public class NotificationService {
 
    @Lookup
    public AppNotification getNotification() {
        //return new AppNotification();
    }
}

2.9. @Primary
Indicates that a bean should be given preference when multiple candidates are qualified to autowire a single-valued dependency. When not using @Primary, we may need to provide @Qualifier annotation to correctly inject the beans.

In the given example, when FooRepository will be autowired, the instance of HibernateFooRepository will be injected – until @Qualifier annotation is used.

@Component
public class JdbcFooRepository
  extends FooRepository {
}
 
@Primary
@Component
public class HibernateFooRepository
  extends FooRepository {
}

2.10. @Scope
Indicates the name of a scope to use for instances of the annotated type. In Spring, beans can be in one of six bean scopes i.e. singleton, prototype, request, session, application and WebSocket. Note that the default scope is ‘singleton‘.

@Bean
@Scope("prototype") 
public class BeanClass {

  return new BeanClass();
}

3. Configuration Annotations
The following discussed annotations help in binding the different beans together to form the runtime application context. They control how the other beans are discovered and the scope where they can be used.

3.1. @ComponentScan
@ComponentScan along with @Configuration is used to enable and configure component scanning. By default, if we do not specify the path, it scans the current package and all of its sub-packages for components.

Using component scanning, spring can auto-scan all classes annotated with the stereotype annotations @Component, @Controller, @Service and @Repository and configure them with BeanFactory.

@Configuration
@ComponentScan(basePackages = {com.howtodoinjava.data.jpa})
public class JpaConfig {
 
}

3.2. @Configuration
It indicates that a class declares one or more @Bean methods and can be processed by the container to generate bean definitions when used along with @ComponentScan.

@Configuration
public class AppConfig {
 
  @Bean
  public AppUtils appUtils()
  {
    return new AppUnits();
  }
}

3.3. @Profile
It indicates that a component is eligible for bean registration when one or more specified profiles are active. A profile is a named logical grouping of beans e.g. dev, prod etc.

@Profile("dev")
@Configuration
public class DevelopmentProfileConfiguration {

   @Bean
   public DataSource mySqlDataSource() {/*...*/}
}

3.4. @Import and @ImportResource
The @Import annotation indicates one or more component classes to import – typically @Configuration classes. The @Bean definitions declared in imported @Configuration classes should be accessed by using @Autowired injection.

@Configuration
@Import({ JpaConfig.class, SchedulerConfig.class })
public class AppConfig {
 
}

Similar to @Import, the @ImportResource indicates one or more resources containing bean definitions to import. It is used for XML bean definitions just like @Import is used for Java configuration using @Bean.

@Configuration
@ImportResource( { "spring-context.xml" } )
public class ConfigClass { 
 
}
