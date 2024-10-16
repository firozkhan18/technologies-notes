# Spring @Autowired – Spring Bean Autowiring Modes

Bean Autowiring
Spring Bean Autowiring is a core feature that simplifies dependency injection in a Spring application. For automatic dependency injection, the Spring framework recommends using constructor injection for mandatory dependencies and the setter injection for optional dependencies.

In this Spring tutorial, we’ll understand the basics of Spring Bean Autowiring with various examples and best practices.

1. Autowire Modes in Spring Framework
The Spring container can autowire relationships between collaborating beans (dependent beans). Until explicit dependency injection (as in XML configuration), Spring resolves the collaborators automatically by inspecting the contents of the ApplicationContext i.e. beans registered with it.

The following table lists the 4 different bean autowire modes in Spring:

Autowire Mode	Description
no	There is no behind-the-scene autowiring magic. The bean references must be defined, explicitly, either using XML configuration or @Qualifier annotation.
byName	Autowiring by matching the property name with the bean name, if the mode is set as ‘byName‘. This is useful if there are multiple beans of the same type but with different names.
byType	Autowiring by matching the property type with the bean type, if there is exactly one bean of that type in the application context. When autowire ‘byType‘ is used, and more than one bean exists of that type, a fatal exception is thrown.
constructor	Similar to byType but applies to constructor arguments.
2. Bean Resolution Strategy
During component scanning, Spring registers the beans by their name until we specify the name explicitly. During dependency resolution, these bean names play a crucial role. When there are multiple beans of the same type (such as multiple implementations of an interface), the names of the implementation classes are registered as bean names.

When autowiring happens without an explicit strategy, Spring will first try to find the dependency by matching the bean type with the property type.

If there is only one bean with the same type as the field type, the dependency injection happens.
If there are multiple beans of the same type, the Spring tries to match the field name with the bean name. If a match is found then the bean is injected.
If there are multiple beans found with the same type and no matching name, runtime exception NoUniqueBeanDefinitionException is thrown.
If there is no match, bean injection is skipped and the field reference will be null.
This runs without error even though we have multiple beans of the same type. The fatal problem occurs when multiple beans of the same name and type are registered in the container. This is not allowed and a runtime NoUniqueBeanDefinitionException is thrown during autowiring.

Consider the following example. We have a IDemoService interface and its two implementations DemoService and DemoSecondService. The program runs successfully. When we check the beans registered in the container, we see two different beans with the names ‘demoService‘ and ‘demoSecondService‘.

@SpringBootApplication
public class TestAutowiring implements CommandLineRunner {

  @Autowired
  IDemoService demoService;

  @Autowired
  IDemoService demoSecondService;

  @Autowired
  private ApplicationContext appContext;

  public static void main(String[] args) {
    SpringApplication.run(TestAutowiring.class);
  }

  @Override
  public void run(String... args) throws Exception {

    String[] beans = appContext.getBeanDefinitionNames();
    System.out.println(Arrays.deepToString(beans));    // [..., demoSecondService, demoService, ...]

    System.out.println(demoService.getMessage());   //Message from DemoService
    System.out.println(demoSecondService.getMessage());   //Message from DemoSecondService
  }
}

interface IDemoService {

  String getMessage();
}

@Service
class DemoService implements IDemoService {

  @Override
  public String getMessage() {
    return "Message from DemoService";
  }
}

@Service
class DemoSecondService implements IDemoService {

  @Override
  public String getMessage() {
    return "Message from DemoSecondService";
  }
}

The program output:

[..., demoSecondService, demoService, ...]

Message from DemoService
Message from DemoSecondService

2. Spring @Autowired Annotation
The @Autowired annotation in Spring Framework is used for automatic dependency injection. It can be applied to fields, setter methods, and constructors to indicate that Spring should automatically provide the required dependencies.

Consider a ShapeService class that requires a Shape. In this example, Spring will automatically inject a Shape bean into the shape field when creating an instance of ShapeService.

@Service
public class ShapeService {
  
  @Autowired
  private Shape shape;
}

3. Autowiring by Constructor (The Recommended Approach)
Autowiring by constructor is a clean and concise way to inject dependencies. In this approach, we utilize the constructor arguments to inject the dependencies into the bean.

Let’s extend our example with a constructor. In the following code, the Shape dependency is injected through the constructor when the application starts.

This approach is also called the constructor injection and is recommended for the “mandatory“ dependencies.

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ShapeService {

    private final Shape shape;

    public ShapeService(Shape shape) {
        this.shape = shape;
    }

    // Other methods...
}

4. Using @Qualifier for Conflict Resolution
Let’s recap the setter injection (autowire byType).

If there is exactly one bean of the property type in the container, it injects that bean.
If there are multiple candidates of the same type, Spring throws NoUniqueBeanDefinitionException because it cannot determine which one to inject.
In cases where no matching bean is found:
Spring throws NoSuchBeanDefinitionException if the dependency is required.
The field is unset (remains null) if the dependency is optional.
The @Qualifier annotation helps in solving the NoUniqueBeanDefinitionException when there are two matching beans of the same type.

Consider an example where we have two beans of type Shape i.e. Circle and Square.

@Configuration
@ComponentScan
public class BeanConfig {

  @Bean
  Square square() {
    return new Square();
  }

  @Bean
  Circle circle() {
    return new Circle();
  }
}

We we run the program then we will get the runtime error when injecting the Shape into ShapeService. To fix the issue, we must ensure which exact bean we want to inject into the dependency and then use @Qualifier to refer to the bean by its name.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ShapeService {

    @Autowired
    @Qualifier("circle")
    private Shape shape;

    // Other methods...
}

5. Optional Dependencies with ‘required=false‘ (Not Recommended)
Even if you have used the utmost care in autowiring bean dependencies, still you may find strange bean lookup failures. In this case, you want to indicate that a dependency is optional. If Spring cannot find a matching bean for the dependency, it can inject null if the dependency is marked as optional. This can be achieved by setting the required attribute of @Autowired to false.

import org.springframework.beans.factory.annotation.Autowired;

public class ShapeService {

    @Autowired(required = false)
    private Shape shape;

    // Other methods...
}

6. Circular Dependencies and Autowiring
In a Spring application, if there is a circular dependency between two or more beans, Spring will create proxies or use lazy initialization to resolve the circular reference.

Consider this example where bean A and bean B, both refer to each other. When Spring attempts to create beans for these classes, it encounters a circular reference. Which one will be initialized first?

public class A {

    private B b;

    @Autowired
    public A(B b) {
        this.b = b;
    }

    // Other methods...
}

public class B {

    private A a;

    @Autowired
    public B(A a) {
        this.a = a;
    }

    // Other methods...
}

Internally Spring will use either proxy objects or lazy initialization technique or a combination of both.

In the proxy object approach, a proxy object is created for one of the circular dependencies. The actual instance is then injected once it’s fully constructed.
In the lazy initialization approach, Spring creates partially initialized instances of beans involved in the circular reference and then completes their initialization later. This allows Spring to break the circular reference temporarily during the bean creation phase.
7. Best Practices
Though Spring does a lot behind the scenes, we also must follow consistent approaches to create a maintainable code. For example:

Adopt consistent naming conventions for beans and properties to leverage autowiring effectively.
Prefer autowiring by constructor for cleaner code and better testability.
While @Qualifier is useful, we should use it in very specific scenarios where other mechanisms are failing.
Use required = false for dependencies that are genuinely optional. Do not use it to suppress the errors.
Be aware of the bean lifecycle and potential issues with circular dependencies.
Always use Java-based configuration for its conciseness and type safety.
8. Conclusion
