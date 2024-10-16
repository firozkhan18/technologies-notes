# IoC and Dependency Injection: Key Differences in Spring

In software engineering, inversion of control (IoC) is a programming technique in which object coupling is established in runtime by an assembler object and it is typically not known at compile time using static analysis.

Dependency injection is a specific implementation of IoC where dependencies are injected into the component by the IoC container.

In this Spring tutorial, learn the difference between IoC and dependency injection in Spring with examples.


1. What is Inversion of Control (IoC)?
In traditional programming, the flow of the business logic is determined by objects that are statically assigned to one another. With inversion of control, the flow depends on the object graph that is instantiated by the assembler and is made possible by object interactions being defined through abstractions. The binding process is achieved through dependency injection, although some argue that the use of a service locator also provides an inversion of control.

In IoC, the dependent components delegate the dependency resolution to an external service that will take care of injecting the dependencies. The dependent component is not allowed to call the injector service and has very little to say when it comes to the dependencies that will be injected.

This behavior is also known as the “Don’t call us, we’ll call you!” principle.

Inversion of control is a common characteristic of frameworks that facilitate injection of dependencies. And the basic idea of the dependency injection pattern is to have a separate object that injects dependencies with the required behavior, based on an interface contract.

by Martin Fowler
Inversion of control as a design guideline serves the following purposes:

There is a decoupling of the execution of a certain task from implementation.
Every module can focus on what it is designed for.
Modules make no assumptions about what other systems do but rely on their contracts.
Replacing modules has no side effect on other modules.
2. Types of Inversion of Control
In general, IoC can be decomposed into two subtypes which are split further into different implementations (such as factory pattern and service locator pattern).

Dependency Injection
Dependency Lookup
With dependency lookup–style IoC, a component must acquire a reference to a dependency, whereas with dependency injection, the dependencies are injected into the component by the IoC container.

3. Dependency Injection In Detail
The dependency injection is a pattern used to create instances of objects that other objects rely on without knowing at compile time which class will be used to inject them at runtime. IoC relies on dependency injection because a mechanism is needed in order to activate the components providing the specific functionality.

Dependency Injection aims to reduce tight coupling between different parts of a software system, such as classes or modules. When one component relies on another, it “depends” on it. Dependencies are “injected” into a component, which allows for flexibility and customization.

Note that the dependency injection also has two common flavors:

Constructor dependency injection: Dependencies are provided via a component’s constructor. It’s the most common form of DI and ensures that a component is fully initialized upon creation.
public class AppComponent {

  private final MessageProvider messageProvider;

  public AppComponent(MessageProvider messageProvider) {
    this.messageProvider = messageProvider;
  }

  //use messageProvider
}

Setter dependency injection: Dependencies are set through setter methods on a component. This allows for optional dependencies and is more flexible than constructor injection.
public class AppComponent {

  private MessageProvider messageProvider;

  public void setMessageProvider(MessageProvider messageProvider) {
    this.messageProvider = messageProvider;
  }

  //use messageProvider
}

Method dependency injection (or Interface dependency injection): Dependencies are provided as method parameters. This is often used when a specific method requires certain dependencies.
public class AppComponent {

  public String parseMessage(MessageProvider messageProvider) {
  	//use messageProvider
  }
}

4. Inversion of Control in Spring Framework
In Spring, the term bean is used to refer to any object managed by the Spring IoC container. The Spring IoC container creates, configures (assembles), and manages beans throughout their life cycle.

The org.springframework.beans and org.springframework.context packages provide the basis for the Spring Framework’s IoC container. The BeanFactory interface provides an advanced configuration mechanism capable of managing beans of any nature.

The ApplicationContext interface builds on top of the BeanFactory (it is a sub-interface) and adds other functionality such as easier integration with Spring’s AOP features, message resource handling (for use in internationalization), event propagation, and application-layer-specific contexts such as the WebApplicationContext for use in web applications.

The BeanFactory is the actual representation of the Spring IoC container that is responsible for containing and otherwise managing the aforementioned beans. The BeanFactory interface is the central IoC container interface in Spring.

container-magic-1508070
There are a number of implementations of the BeanFactory interface. The most commonly used BeanFactory implementation is the XmlBeanFactory class. Another commonly used class is XmlWebApplicationContext.

Depending on the bean definition, the factory will return either an independent instance of a contained object (the Prototype design pattern), or a single shared instance (a superior alternative to the Singleton design pattern, in which the instance is a singleton in the scope of the factory). The type of instance returned depends on the bean factory configuration: the API remains the same.

5. Dependency Injection in Spring Framework
The basic principle behind DI is that objects define their dependencies only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it has been constructed or returned from a factory method. Then, it is the job of the container to actually inject those dependencies when it creates the bean. This is fundamentally the inverse, hence the name Inversion of Control (IoC).

6.1. Setter Injection
Setter-based DI is realized by calling setter methods on your beans after invoking a no-argument constructor or no-argument static factory method to instantiate your beans.

In this example, we create a setter method for the ApplicationContext, which Spring will use to inject the dependency.

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyBeanUsingSetter {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void doSomething() {
        // Access the ApplicationContext
        // You can use the applicationContext here
    }
}

6.2. Constructor Injection
Constructor-based DI is realized by invoking a constructor with a number of arguments, each representing a collaborator. Constructor injection is often favored because it ensures that the bean is properly initialized with all its required dependencies when it is created.

Constructor injection is useful when dependency must be enforced, and the component requiring a dependency won’t work without it.

In the following code snippet, we are injecting the ApplicationContext through the constructor of the bean. The ApplicationContext is passed as a parameter to the constructor.

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyBeanUsingConstructor {

    private final ApplicationContext applicationContext;

    public MyBeanUsingConstructor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void doSomething() {
        // Access the ApplicationContext
        // You can use the applicationContext here
    }
}

Additionally, calling a static factory method with specific arguments to construct the bean, can be considered almost equivalent, and the rest of this article will consider arguments to a constructor and arguments to a static factory method similarly.

6.3. Interface Injection
Interface injection, also known as method injection, is a form of Dependency Injection where a dependency is injected into a class through a method, typically by implementing an interface with a specific injection method.

In this methodology, we implement an interface from the Spring framework. Spring framework will use the interface method to inject the object. It is much more appropriate to use this approach when the injected dependencies have to be used only inside a limited scope.

Setter injection is useful in cases when the component is exposing its dependencies to the container but is happy to provide its own defaults. It also allows to swap dependencies for a different implementation on-the-fly without creating a new instance of the parent component.

In the following example, we implement ApplicationContextAware interface with a method that takes the ApplicationContext as a parameter.

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyBeanUsingInterfaceInjection implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void doSomething() {
        // Access the ApplicationContext
        // You can use the applicationContext here
    }
}

7. FAQs
7.1. What is the difference between Component and Service?
A component is a glob of software that’s intended to be used, without change, by an application that is out of the control of the writers of the component. By ‘without change’ means that the application doesn’t change the source code of the components, although it may alter the component’s behavior by extending it in ways allowed by the component writers.

A service is similar to a component in that it’s used by foreign applications. The main difference is that a component to be used locally (think jar file, assembly, DLL, or a source import). A service will be used remotely through some remote interface, either synchronous or asynchronous (eg web service, messaging system, RPC, or socket.)

7.2. How DI is different from ‘Service Locator’ pattern?
The key benefit of a Dependency Injector is that it allows to plug-in a suitable implementation of a service according to environment and usage. Injection isn’t the only way to break this dependency, another is to use a service locator. The basic idea behind a service locator is to have an object that knows how to get hold of all of the services that an application might need. It then scans all such services and stores them as a singleton Registry. When asked for a service implementation, a requester can query the registry with a token and get an appropriate implementation.

Mostly these registries are populated via some configuration files. The key difference is that with a Service Locator every user of a service has a dependency on the locator. The locator can hide dependencies to other implementations, but you do need to see the locator.

7.3. Which one should be better to use i.e. service locator or dependency injection?
Well, as I already said the key difference is that with a Service Locator every user of a service has a dependency on the locator. It means you must know the details of the service locator in terms of input and output. So, it actually becomes the deciding factor on which pattern to choose from.

If it is easy and necessary to maintain registry information then go for a service locator, or else simply use dependency injection as it does not bother the users of the service with any prerequisites.

7.4. Which is better constructor injection or setter injection?
The choice between setter and constructor injection is interesting as it mirrors a more general issue with object-oriented programming – should you fill fields in a constructor or with setters?

Constructors with parameters give you a clear statement of what it means to create a valid object in an obvious place. If there’s more than one way to do it, create multiple constructors that show the different combinations. Another advantage of constructor initialization is that it allows you to clearly hide any fields that are immutable by simply not providing a setter. I think this is important – if something shouldn’t change then the lack of a setter communicates this very well. If you use setters for initialization, then this can become a pain.

But If you have a lot of constructor parameters things can look messy, particularly in languages without keyword parameters. If you have multiple ways to construct a valid object, it can be hard to show this through constructors, since constructors can only vary on the number and type of parameters. Constructors also suffer if you have simple parameters such as strings. With setter injection, you can give each setter a name to indicate what the string is supposed to do. With constructors, you are just relying on the position, which is harder to follow.

My preference is to start with constructor injection but be ready to switch to setter injection as soon as the problems I’ve outlined above start to become a problem.

7.5. What is Bean Factory?
A BeanFactory is like a factory class that contains a collection of beans. The BeanFactory holds Bean Definitions of multiple beans within itself and then instantiates the bean whenever asked for by clients.

BeanFactory is able to create associations between collaborating objects as they are instantiated. This removes the burden of configuration from the bean itself and the beans client. BeanFactory also takes part in the life cycle of a bean, making calls to custom initialization and destruction methods.

7.6. What is Application Context?
A bean factory is fine for simple applications, but to take advantage of the full power of the Spring framework, you may want to move up to Spring’s more advanced container, the application context. On the surface, an application context is the same as a bean factory. Both load bean definitions, wire beans together, and dispense beans upon request. But it also provides:

A means for resolving text messages, including support for internationalization.
A generic way to load file resources.
Events to beans that are registered as listeners.
7.7. What should be used preferably BeanFactory or ApplicationContext?
A BeanFactory pretty much just instantiates and configures beans. An ApplicationContext also does that, and it provides the supporting infrastructure to enable lots of enterprise-specific features such as transactions and AOP.

In short, favor the use of an ApplicationContext.
