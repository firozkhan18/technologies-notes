# SPRING 

## 4.  What is Spring?

Spring is an open source framework created to address the complexity of enterprise application development. One of the chief advantages of the Spring framework is its layered architecture, which allows you to be selective about which of its components you use while also providing a cohesive framework for J2EE application development. 

## 5. What are the advantages of Spring framework?

The advantages of Spring are as follows: 
 	Spring has layered architecture. Use what you need and leave you don't need now. 
 	Spring Enables POJO Programming. There is no behind the scene magic here. POJO programming enables continuous integration and testability. 
 	Dependency Injection and Inversion of Control Simplifies JDBC 
 	Open source and no vendor lock-in. 
  
## 6. What are features of Spring?

 	Lightweight:
Spring is lightweight when it comes to size and transparency. The basic version of spring framework is around 1MB. And the processing overhead is also very negligible.
 	Inversion of control (IOC):
Loose coupling is achieved in spring using the technique Inversion of Control. The objects give their dependencies instead of creating or looking for dependent objects.
 	Aspect oriented (AOP):
Spring supports Aspect oriented programming and enables cohesive development by separating application business logic from system services.
 	Container:
Spring contains and manages the life cycle and configuration of application objects.
 	MVC Framework:
Spring comes with MVC web application framework, built on core Spring functionality. This framework is highly configurable via strategy interfaces, and accommodates multiple view technologies like JSP, Velocity, Tiles, iText, and POI. But other frameworks can be easily used instead of Spring MVC Framework.
 	Transaction Management:
Spring framework provides a generic abstraction layer for transaction management. This allowing the developer to add the pluggable transaction managers, and making it easy to demarcate transactions without dealing with low-level issues. Spring's transaction support is not tied to J2EE environments and it can be also used in container less environments.
 	JDBC Exception Handling: 
The JDBC abstraction layer of the Spring offers a meaningful exception hierarchy, which simplifies the error handling strategy. Integration with Hibernate, JDO, and iBATIS: Spring provides best Integration services with Hibernate, JDO and iBATIS

## 7. How many modules are there in Spring? What are they?

(Roll over to view the Image )
 
       Spring comprises of seven modules. They are.. 
-	The core container:
The core container provides the essential functionality of the Spring framework. A primary component of the core container is the BeanFactory, an implementation of the Factory pattern. The BeanFactory applies the Inversion of Control (IOC) pattern to separate an application's configuration and dependency specification from the actual application code. 
- 	Spring context:
The Spring context is a configuration file that provides context information to the Spring framework. The Spring context includes enterprise services such as JNDI, EJB, e-mail, internalization, validation, and scheduling functionality. 
- 	Spring AOP:
The Spring AOP module integrates aspect-oriented programming functionality directly into the Spring framework, through its configuration management feature. As a result you can easily AOP-enable any object managed by the Spring framework. The Spring AOP module provides transaction management services for objects in any Spring-based application. With Spring AOP you can incorporate declarative transaction management into your applications without relying on EJB components. 
- 	Spring DAO:
The Spring JDBC DAO abstraction layer offers a meaningful exception hierarchy for managing the exception handling and error messages thrown by different database vendors. The exception hierarchy simplifies error handling and greatly reduces the amount of exception code you need to write, such as opening and closing connections. Spring DAO's JDBC-oriented exceptions comply to its generic DAO exception hierarchy. 
- 	Spring ORM:
The Spring framework plugs into several ORM frameworks to provide its Object Relational tool, including JDO, Hibernate, and iBatis SQL Maps. All of these comply to Spring's generic transaction and DAO exception hierarchies. 
- 	Spring Web module:
The Web context module builds on top of the application context module, providing contexts for Web-based applications. As a result, the Spring framework supports integration with Jakarta Struts. The Web module also eases the tasks of handling multi-part requests and binding request parameters to domain objects. 
- 	Spring MVC framework:
The Model-View-Controller (MVC) framework is a full-featured MVC implementation for building Web applications. The MVC framework is highly configurable via strategy interfaces and accommodates numerous view technologies including JSP, Velocity, Tiles, iText, and POI. 

## 1.  What is IOC (or Dependency Injection)? 
The basic concept of the Inversion of Control pattern (also known as dependency injection) is that you do not create your objects but describe how they should be created. You don't directly connect your components and services together in code but describe which services are needed by which components in a configuration file. A container (in the case of the Spring framework, the IOC container) is then responsible for hooking it all up.

i.e., Applying IoC objects are given their dependencies at creation time by some external entity that coordinates each object in the system. That is, dependencies are injected into objects. So, IoC means an inversion of responsibility with regard to how an object obtains references to collaborating objects. 

## 2. What are the different types of IOC (dependency injection)? 
There are three types of dependency injection: 
 	Constructor Injection (e.g. Pico container, Spring etc): Dependencies are provided as constructor parameters. 
 	Setter Injection (e.g. Spring): Dependencies are assigned through JavaBeans properties (ex: setter methods). 
 	Interface Injection (e.g. Avalon): Injection is done through an interface. 
Note: Spring supports only Constructor and Setter Injection
## 3. What are the benefits of IOC (Dependency Injection)?
Benefits of IOC (Dependency Injection) are as follows: 
 	Minimizes the amount of code in your application. With IOC containers you do not care about how services are created and how you get references to the ones you need. You can also easily add additional services by adding a new constructor or a setter method with little or no extra configuration.
 	Make your application more testable by not requiring any singletons or JNDI lookup mechanisms in your unit test cases. IOC containers make unit testing and switching implementations very easy by manually allowing you to inject your own objects into the object under test.
 	Loose coupling is promoted with minimal effort and least intrusive mechanism. The factory design pattern is more intrusive because components or services need to be requested explicitly whereas in IOC the dependency is injected into requesting piece of code. Also some containers promote the design to interfaces not to implementations design concept by encouraging managed objects to implement a well-defined service interface of your own.
 	IOC containers support eager instantiation and lazy loading of services. Containers also provide support for instantiation of managed objects, cyclical dependencies, life cycles management, and dependency resolution between managed objects etc.

## 8. What are the types of Dependency Injection Spring supports?>
 	Setter Injection:
Setter-based DI is realized by calling setter methods on your beans after invoking a no-argument constructor or no-argument static factory method to instantiate your bean. 
 	Constructor Injection:
Constructor-based DI is realized by invoking a constructor with a number of arguments, each representing a collaborator.
## 9. What is Bean Factory ?
A BeanFactory is like a factory class that contains a collection of beans. The BeanFactory holds Bean Definitions of multiple beans within itself and then instantiates the bean whenever asked for by clients.
 	BeanFactory is able to create associations between collaborating objects as they are instantiated. This removes the burden of configuration from bean itself and the beans client. 
 	BeanFactory also takes part in the life cycle of a bean, making calls to custom initialization and destruction methods. 
## 10. What is Application Context?
A bean factory is fine to simple applications, but to take advantage of the full power of the Spring framework, you may want to move up to Springs more advanced container, the application context. On the surface, an application context is same as a bean factory.Both load bean definitions, wire beans together, and dispense beans upon request. But it also provides: 
 	A means for resolving text messages, including support for internationalization. 
 	A generic way to load file resources. 
 	Events to beans that are registered as listeners. 
## 11. What is the difference between Bean Factory and Application Context ?  
On the surface, an application context is same as a bean factory. But application context offers much more.. 
 	Application contexts provide a means for resolving text messages, including support for i18n of those messages. 
 	Application contexts provide a generic way to load file resources, such as images. 
 	Application contexts can publish events to beans that are registered as listeners. 
 	Certain operations on the container or beans in the container, which have to be handled in a programmatic fashion with a bean factory, can be handled declaratively in an application context. 
 	ResourceLoader support: Spring’s Resource interface us a flexible generic abstraction for handling low-level resources. An application context itself is a ResourceLoader, Hence provides an application with access to deployment-specific Resource instances. 
 	MessageSource support: The application context implements MessageSource, an interface used to obtain localized messages, with the actual implementation being pluggable 
## 12. What are the common implementations of the Application Context ?
   The three commonly used implementation of 'Application Context' are 
 	ClassPathXmlApplicationContext : It Loads context definition from an XML file located in the classpath, treating context definitions as classpath resources. The application context is loaded from the application's classpath by using the code .
ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml"); 
 	FileSystemXmlApplicationContext : It loads context definition from an XML file in the filesystem. The application context is loaded from the file system by using the code . 
ApplicationContext context = new FileSystemXmlApplicationContext("bean.xml"); 
 	XmlWebApplicationContext : It loads context definition from an XML file contained within a web application. 
## 13. How is a typical spring implementation look like ?
   For a typical Spring Application we need the following files:
 	An interface that defines the functions.
 	An Implementation that contains properties, its setter and getter methods, functions etc.,
 	Spring AOP (Aspect Oriented Programming)
 	A XML file called Spring configuration file.
 	Client program that uses the function.

## 14.  What is the typical Bean life cycle in Spring Bean Factory Container ?
   Bean life cycle in Spring Bean Factory Container is as follows:
 	The spring container finds the bean’s definition from the XML file and instantiates the bean. 
 	Using the dependency injection, spring populates all of the properties as specified in the bean definition
 	If the bean implements the BeanNameAware interface, the factory calls setBeanName() passing the bean’s ID. 
 	If the bean implements the BeanFactoryAware interface, the factory calls setBeanFactory(), passing an instance of itself. 
 	If there are any BeanPostProcessors associated with the bean, their 
postProcessBeforeInitialization() methods will be called. 
 	If an init-method is specified for the bean, it will be called.
 	Finally, if there are any BeanPostProcessors associated with the bean, their postProcessAfterInitialization() methods will be called. 

## 15. What do you mean by Bean wiring ? 
The act of creating associations between application components (beans) within the Spring container is reffered to as Bean wiring.

## 16. What do you mean by Auto Wiring?
The Spring container is able to autowire relationships between collaborating beans. This means that it is possible to automatically let Spring resolve collaborators (other beans) for your bean by inspecting the contents of the BeanFactory. The autowiring functionality has five modes.
 	- no 
 	- byName
 	- byType 
 	- constructor 
 	- autodirect 

## 17. What is DelegatingVariableResolver?
Spring provides a custom JavaServer Faces VariableResolver implementation that extends the standard Java Server Faces managed beans mechanism which lets you use JSF and Spring together. This variable resolver is called as DelegatingVariableResolver

## 18. How to integrate  Java Server Faces (JSF) with Spring? 
JSF and Spring do share some of the same features, most noticeably in the area of IOC services. By declaring JSF managed-beans in the faces-config.xml configuration file, you allow the FacesServlet to instantiate that bean at startup. Your JSF pages have access to these beans and all of their properties.We can integrate JSF and Spring in two ways: 
 	DelegatingVariableResolver: Spring comes with a JSF variable resolver that lets you use JSF and Spring together. 
  ```xml
 	<?xml version="1.0" encoding="UTF-8"?>
 	<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN//EN"
 	   "http://www.springframework.org/dtd/spring-beans.dtd">
 	
 	<faces-config>
 	   <application>
 	      <variable-resolver>
 	         org.springframework.web.jsf.DelegatingVariableResolver
 	      </variable-resolver>
 	   </application>
 	</faces-config>
 ```
The DelegatingVariableResolver will first delegate value lookups to the default resolver of the underlying JSF implementation, and then to Spring's 'business context' WebApplicationContext. This allows one to easily inject dependencies into one's JSF-managed beans. 
 	FacesContextUtils:custom VariableResolver works well when mapping one's properties to beans in faces-config.xml, but at times one may need to grab a bean explicitly. The FacesContextUtils class makes this easy. It is similar to WebApplicationContextUtils, except that it takes a FacesContext parameter rather than a ServletContext parameter. 
 	ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
## 19. What is  Java Server Faces (JSF) - Spring integration mechanism? 
Spring provides a custom JavaServer Faces VariableResolver implementation that extends the standard JavaServer Faces managed beans mechanism. When asked to resolve a variable name, the following algorithm is performed:
 	Does a bean with the specified name already exist in some scope (request, session, application)? If so, return it 
 	Is there a standard JavaServer Faces managed bean definition for this variable name? If so, invoke it in the usual way, and return the bean that was created. 
 	Is there configuration information for this variable name in the Spring WebApplicationContext for this application? If so, use it to create and configure an instance, and return that instance to the caller. 
 	If there is no managed bean or Spring definition for this variable name, return null instead. 
 	BeanFactory also takes part in the life cycle of a bean, making calls to custom initialization and destruction methods. 
As a result of this algorithm, you can transparently use either JavaServer Faces or Spring facilities to create beans on demand.

## 20. What is Significance of JSF- Spring integration ?
Spring - JSF integration is useful when an event handler wishes to explicitly invoke the bean factory to create beans on demand, such as a bean that encapsulates the business logic to be performed when a submit button is pressed. 

## 21. How to integrate your Struts application with Spring?  
To integrate your Struts application with Spring, we have two options: 
 	Configure Spring to manage your Actions as beans, using the ContextLoaderPlugin, and set their dependencies in a Spring context file. 
 	Subclass Spring's ActionSupport classes and grab your Spring-managed beans explicitly using a getWebApplicationContext() method. 
## 22. What are ORM’s Spring supports ? 
   Spring supports the following ORM’s : 
 	Hibernate 
 	iBatis 
 	JPA (Java Persistence API) 
 	TopLink 
 	JDO (Java Data Objects) 
 	OJB 
## 23. What are the ways to access Hibernate using Spring ?
   There are two approaches to Spring’s Hibernate integration:
 	Inversion of Control with a HibernateTemplate and Callback 
 	Extending HibernateDaoSupport and Applying an AOP Interceptor 
## 24. How to integrate Spring and Hibernate using HibernateDaoSupport?
Spring and Hibernate can integrate using Spring’s SessionFactory called LocalSessionFactory. The integration process is of 3 steps.
 	Configure the Hibernate SessionFactory 
 	Extend your DAO Implementation from HibernateDaoSupport 
 	Wire in Transaction Support with AOP 
## 25. What are Bean scopes in Spring Framework ?
The Spring Framework supports exactly five scopes (of which three are available only if you are using a web-aware ApplicationContext). The scopes supported are listed below: 
Scope	Description
singleton	Scopes a single bean definition to a single object instance per Spring IoC container.
prototype	Scopes a single bean definition to any number of object instances.
request	Scopes a single bean definition to the lifecycle of a single HTTP request; that is each and every HTTP request will have its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web-aware Spring ApplicationContext.
session	Scopes a single bean definition to the lifecycle of a HTTP Session. Only valid in the context of a web-aware Spring ApplicationContext.
global session	Scopes a single bean definition to the lifecycle of a global HTTP Session. Typically only valid when used in a portlet context. Only valid in the context of a web-aware Spring ApplicationContext.

## 26. What is AOP?
Aspect-oriented programming, or AOP, is a programming technique that allows programmers to modularize crosscutting concerns, or behavior that cuts across the typical divisions of responsibility, such as logging and transaction management. The core construct of AOP is the aspect, which encapsulates behaviors affecting multiple classes into reusable modules. 

## 27. How the AOP used in Spring?
AOP is used in the Spring Framework: To provide declarative enterprise services, especially as a replacement for EJB declarative services. The most important such service is declarative transaction management, which builds on the Spring Framework's transaction abstraction. To allow users to implement custom aspects, complementing their use of OOP with AOP. 

## 28. What do you mean by Aspect ? 
A modularization of a concern that cuts across multiple objects. Transaction management is a good example of a crosscutting concern in J2EE applications. In Spring AOP, aspects are implemented using regular classes (the schema-based approach) or regular classes annotated with the @Aspect annotation (@AspectJ style). 

## 29. What do you mean by JointPoint? 
A point during the execution of a program, such as the execution of a method or the handling of an exception. In Spring AOP, a join point always represents a method execution. 

## 30. What do you mean by Advice?
Actions taken by an aspect at a particular join point. Different types of advice include "around," "before" and "after" advice. Many AOP frameworks, including Spring, model an advice as an interceptor, maintaining a chain of interceptors "around" the join point. 

## 31. What are the types of Advice? 
Types of advice: 
 	Before advice: Advice that executes before a join point, but which does not have the ability to prevent execution flow proceeding to the join point (unless it throws an exception). 
 	After returning advice: Advice to be executed after a join point completes normally: for example, if a method returns without throwing an exception. 
 	After throwing advice: Advice to be executed if a method exits by throwing an exception. 
 	After (finally) advice: Advice to be executed regardless of the means by which a join point exits (normal or exceptional return). 
 	Around advice: Advice that surrounds a join point such as a method invocation. This is the most powerful kind of advice. Around advice can perform custom behavior before and after the method invocation. It is also responsible for choosing whether to proceed to the join point or to shortcut the advised method execution by returning its own return value or throwing an exception
## 32. What are the types of the transaction management Spring supports ?
Spring Framework supports:
 	Programmatic transaction management. 
 	Declarative transaction management. 
## 33. What are the benefits of the Spring Framework transaction management ?
The Spring Framework provides a consistent abstraction for transaction management that delivers the following benefits: 
 	Provides a consistent programming model across different transaction APIs such as JTA, JDBC, Hibernate, JPA, and JDO. 
 	Supports declarative transaction management. 
 	Provides a simpler API for programmatic transaction management than a number of complex transaction APIs such as JTA. 
 	Integrates very well with Spring's various data access abstractions. 
## 34.  Why most users of the Spring Framework choose declarative transaction management ?
Most users of the Spring Framework choose declarative transaction management because it is the option with the least impact on application code, and hence is most consistent with the ideals of a non-invasive lightweight container.

## 35. Explain the similarities and differences between EJB CMT and the Spring Framework's declarative transaction management ?
The basic approach is similar: it is possible to specify transaction behavior (or lack of it) down to individual method level. It is possible to make a setRollbackOnly() call within a transaction context if necessary. The differences are:
 	Unlike EJB CMT, which is tied to JTA, the Spring Framework's declarative transaction management works in any environment. It can work with JDBC, JDO, Hibernate or other transactions under the covers, with configuration changes only. 
 	The Spring Framework enables declarative transaction management to be applied to any class, not merely special classes such as EJBs. 
 	The Spring Framework offers declarative rollback rules: this is a feature with no EJB equivalent. Both programmatic and declarative support for rollback rules is provided. 
 	The Spring Framework gives you an opportunity to customize transactional behavior, using AOP. With EJB CMT, you have no way to influence the container's transaction management other than setRollbackOnly(). 
 	The Spring Framework does not support propagation of transaction contexts across remote calls, as do high-end application servers. 
## 37. When to use programmatic and declarative transaction management ?
Programmatic transaction management is usually a good idea only if you have a small number of transactional operations. 
On the other hand, if your application has numerous transactional operations, declarative transaction management is usually worthwhile. It keeps transaction management out of business logic, and is not difficult to configure. 

## 38. Explain about the Spring DAO support ? 
The Data Access Object (DAO) support in Spring is aimed at making it easy to work with data access technologies like JDBC, Hibernate or JDO in a consistent way. This allows one to switch between the persistence technologies fairly easily and it also allows one to code without worrying about catching exceptions that are specific to each technology.

## 39. What are the exceptions thrown by the Spring DAO classes ? 
Spring DAO classes throw exceptions which are subclasses of DataAccessException(org.springframework.dao.DataAccessException).Spring provides a convenient translation from technology-specific exceptions like SQLException to its own exception class hierarchy with the DataAccessException as the root exception. These exceptions wrap the original exception.

## 40. What is SQLExceptionTranslator ? 
SQLExceptionTranslator, is an interface to be implemented by classes that can translate between SQLExceptions and Spring's own data-access-strategy-agnostic org.springframework.dao.DataAccessException. 
41. What is Spring's JdbcTemplate ?
Spring's JdbcTemplate is central class to interact with a database through JDBC. JdbcTemplate provides many convenience methods for doing things such as converting database data into primitives or objects, executing prepared and callable statements, and providing custom database error handling. 
JdbcTemplate template = new JdbcTemplate(myDataSource);

## 42. What is PreparedStatementCreator ?
PreparedStatementCreator:
 	Is one of the most common used interfaces for writing data to database. 
 	Has one method – createPreparedStatement(Connection) 
 	Responsible for creating a PreparedStatement. 
 	Does not need to handle SQLExceptions. 
## 43. What is SQLProvider ?
SQLProvider:
 	Has one method – getSql() 
 	Typically implemented by PreparedStatementCreator implementers. 
 	Useful for debugging. 
## 44. What is RowCallbackHandler ?
The RowCallbackHandler interface extracts values from each row of a ResultSet. 
 	Has one method – processRow(ResultSet) 
 	Called for each row in ResultSet. 
 	Typically stateful. 
## 45. What are the differences between EJB and Spring ?
Spring and EJB feature comparison. 
Feature	EJB	Spring
Transaction management	 	Must use a JTA transaction manager. 
 	Supports transactions that span remote method calls.	 	Supports multiple transaction environments through its PlatformTransactionManager interface, including JTA, Hibernate, JDO, and JDBC. 
 	Does not natively support distributed transactions—it must be used with a JTA transaction manager.
Declarative transaction support	 	Can define transactions declaratively through the deployment descriptor. 
 	Can define transaction behavior per method or per class by using the wildcard character *. 
 	Cannot declaratively define rollback behavior—this must be done programmatically.	 	Can define transactions declaratively through the Spring configuration file or through class metadata. 
 	Can define which methods to apply transaction behavior explicitly or by using regular expressions. 
 	Can declaratively define rollback behavior per method and per exception type.
Persistence	Supports programmatic bean-managed persistence and declarative container managed persistence.	Provides a framework for integrating with several persistence technologies, including JDBC, Hibernate, JDO, and iBATIS.
Declarative security	 	Supports declarative security through users and roles. The management and implementation of users and roles is container specific. 
 	Declarative security is configured in the deployment descriptor.	 	No security implementation out-of-the box. 
 	Acegi, an open source security framework built on top of Spring, provides declarative security through the Spring configuration file or class metadata.
Distributed computing	Provides container-managed remote method calls.	Provides proxying for remote calls via RMI, JAX-RPC, and web services.


1. What is Spring Framework? What are it’s Main Modules?
Spring is probably the most used Java framework for developing simple web applications to enterprise-class cloud applications and microservices. Spring provides comprehensive infrastructure support for developing applications with complex requirements and designs.

Spring framework handles the infrastructure part (using dependency injection), so we can focus on the application’s core functionality. Spring framework contains formalized design patterns as first-class objects that we can integrate into our application(s) without worrying too much about how they work in the backend.

The Spring Framework is divided into modules. Applications can choose which modules they need based on what functionality they require.

Spring modules are grouped into Core Container, Data Access/Integration, WebMVC, AOP (Aspect Oriented Programming), Instrumentation, Messaging, Testing and, others as shown in the following diagram.

spring modules
Spring Framework Modules
2. What are the Advantages of Spring Framework?
Following is a partial list of benefits of using Spring Framework.

With Dependency Injection (DI) pattern, application dependencies are explicitely declared and maintained.
IoC containers tend to be lightweight, especially when compared to EJB containers. This is beneficial for developing and deploying Spring applications on computers with limited memory and CPU resources.
Spring does not reinvent the wheel, instead, it truly makes use of some of the existing technologies like several ORM frameworks, logging frameworks, JMS and, other view technologies.
Spring is organized in a modular fashion and even though the number of packages and classes are substantial, we have to worry about only those dependencies we need and we can gnore the rest.
Testing a Spring application is simple because the environment-dependent code is managed by the framework. Further, by using java beans style POJOs, it becomes easier to use dependency injection for injecting test data.
Spring’s web framework is a well-designed web MVC framework, which provides a great alternative to web frameworks such as Struts or other over engineered or less popular web frameworks.
Spring provides a consistent transaction management interface that can scale down to a local transaction (using a single database, for example) and scale up to global transactions (using JTA, for example).
3. What is Inversion of Control (IoC) and Dependency Injection (DI)?
In software engineering, inversion of control (IoC) is a programming technique in which object coupling is bound at run time by an assembler object and is typically not known at compile time using static analysis.

In traditional programming, the business logic flow is determined by objects statically assigned to one another.

With inversion of control, the application flow depends on the object graph instantiated by the assembler and is made possible by object interactions defined through abstractions. The binding process is achieved through “dependency injection“.

Inversion of control is a design paradigm to give more control to the targeted components of the application, the ones that are actually doing the work.

Dependency injection is a pattern used to create instances of objects that other objects rely on without knowing at compile time which class will be used to provide that functionality.

Inversion of control relies on dependency injection because a mechanism is needed to activate the components providing the specific functionality. Otherwise, how will the framework know which components to create if it is no longer in control?

In Spring, dependency injection may happen in the following ways:

Constructor injection
Setter injection
Fields Injection
4. Explain Inversion of Control in Spring Framework?
In the spring framework, inversion of control refers to the framework’s ability to create, destroy, and manage the beans’ lifecycle.

The ApplicationContext (internally, it uses BeanFactory) is in the center of inversion of control in Spring.

To assemble beans, the spring bean factory uses configuration metadata, which can be in the form of XML configuration or annotations.

5. Difference between BeanFactory and ApplicationContext?
A BeanFactory is like a factory class that contains a collection of beans. The BeanFactory holds bean definitions within itself and then instantiates a bean whenever asked for by clients.

BeanFactory is able to create associations between collaborating beans as they are instantiated. BeanFactory also takes part in the life cycle of the beans, making calls to custom initialization and destruction methods.

At a high level, an application context is the same as a bean factory. Both load bean definitions, wire beans together, and dispense beans upon request. But the application context also provides:

A means for resolving text messages, including support for internationalization.
A generic way to load file resources.
Events to beans that are registered as listeners.
The three commonly used implementations of ApplicationContext are:

ClassPathXmlApplicationContext: loads context definition from an XML file located in the classpath, treating context definitions as classpath resources. The application context is loaded from the application’s classpath by using the code.
ApplicationContext context = new ClassPathXmlApplicationContext(“bean.xml”);

FileSystemXmlApplicationContext: loads context definition from an XML file in the filesystem. The application context is loaded from the file system by using the code.
ApplicationContext context = new FileSystemXmlApplicationContext(“bean.xml”);

XmlWebApplicationContext: loads context definition from an XML file contained within a web application.
6. In How Many ways, We can Configure Spring into our Applications?
we can configure Spring into our applications in 3 ways:

XML based configuration
Annotation-based configuration
Java-based configuration
We will read about these configurations in the next section.

7. What is XML Configuration for Spring?
In Spring framework, the required dependencies and the services are specified in external configuration files, which are typically in an XML format. These XML configuration files usually start with <beans> tag and contain a lot of bean definitions AND application-specific configuration options.

The main goal of Spring XML Configuration is to have all the Spring components configured by using XML files.
It means that there will not be present any other type of Spring Configuration (like annotations or configuration via Java classes).

A Spring XML Configuration uses Spring namespaces to make available the sets of XML tags used in the configuration; the main Spring namespaces are context, beans, JDBC, TX, AOP, MVC, etc.

<beans>
    <bean name="viewResolver" class="org.springframework.web.servlet.view.BeanNameViewResolver"/>
    <bean name="jsonTemplate" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
    <bean id="restTemplate" class="org.springframework.web.client.RestTemplate"/>
</beans>

8. What is Java-based Configuration in Spring?
The central artifacts in Spring’s java-configuration support are @Configuration annotated classes and @Bean annotated methods.

The @Bean annotation is used to indicate that a method instantiates, configures and initializes a new object to be managed by the Spring IoC container. @Bean annotation plays the same role as the <bean/> element.

Annotating a class with @Configuration indicates that its primary purpose is as a source of bean definitions. Furthermore, @Configuration classes allow inter-bean dependencies to be defined by simply calling other @Bean methods in the same class. The most straightforward possible @Configuration class would read as follows:

@Configuration
public class AppConfig
{
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}

The equivalent XML configuration for the above java-config would be:

<beans>
    <bean id="myService" class="com.howtodoinjava.services.MyServiceImpl"/>
</beans>

To instantiate such config, you will need the help of AnnotationConfigApplicationContext class.

public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
}

To enable component scanning, annotate your @Configuration class as follows:

@Configuration
@ComponentScan(basePackages = "com.howtodoinjava")
public class AppConfig  {
    ...
}

In the example above, the com.acme package will be scanned, looking for any @Component annotated classes and those classes will be registered as Spring bean definitions within the container.

If you are using the above configuration in a web application then you will be using AnnotationConfigWebApplicationContext class. This implementation may be used when configuring the Spring ContextLoaderListener servlet listener, Spring MVC DispatcherServlet etc.

<web-app>
    <!-- Configure ContextLoaderListener to use AnnotationConfigWebApplicationContext instead of the default XmlWebApplicationContext -->
    <context-param>
        <param-name>contextClass</param-name>
        <param-value>
            org.springframework.web.context.support.AnnotationConfigWebApplicationContext
        </param-value>
    </context-param>
 
    <!-- Configuration locations must consist of one or more comma- or space-delimited fully-qualified @Configuration classes. Fully-qualified packages may also be specified for component-scanning -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>com.howtodoinjava.AppConfig</param-value>
    </context-param>
 
    <!-- Bootstrap the root application context as usual using ContextLoaderListener -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
 
    <!-- Declare a Spring MVC DispatcherServlet as usual -->
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- Configure DispatcherServlet to use AnnotationConfigWebApplicationContext instead of the default XmlWebApplicationContext -->
        <init-param>
            <param-name>contextClass</param-name>
            <param-value>
                org.springframework.web.context.support.AnnotationConfigWebApplicationContext
            </param-value>
        </init-param>
        <!-- Again, config locations must consist of one or more comma- or space-delimited and fully-qualified @Configuration classes -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>com.howtodoinjava.web.MvcConfig</param-value>
        </init-param>
    </servlet>
 
    <!-- map all requests for /app/* to the dispatcher servlet -->
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/app/*</url-pattern>
    </servlet-mapping>
</web-app>

9. What is Annotation-based Configuration?
Starting from Spring 2.5, it became possible to configure the dependency injection using annotations. So instead of using XML to describe a bean wiring, we can move the bean configuration into the component class itself by using annotations on the relevant class, method, or field declaration.

Annotation injection is performed before XML injection, thus the XML configuration will override the annotation configuration when we wire the beans through both approaches.

Annotation wiring is not turned on in the Spring container by default. So, before we can use annotation-based wiring, we must enable it in our Spring configuration file. So consider having the following configuration file if you want to use any annotation in your Spring application.

<beans>
 
   <context:annotation-config/>

   <!-- bean definitions go here -->
 
</beans>

Once <context:annotation-config/> is configured, you can start annotating your code to indicate that Spring should automatically wire values into properties, methods, and constructors.

A few essential annotations which you will be using in this type of configuration are :

@Required : The @Required annotation applies to bean property setter methods.
@Autowired : The @Autowired annotation can apply to bean property setter methods, non-setter methods, constructor and properties.
@Qualifier : The @Qualifier annotation along with @Autowired can be used to remove the confusion by specifiying which exact bean will be wired.
JSR-250 Annotations : Spring supports JSR-250 based annotations which include @Resource, @PostConstruct and @PreDestroy annotations.
10. Explain Spring Bean Lifecycle?
The life cycle of a Spring bean is easy to understand. When a bean is instantiated, it may be required to perform some initialization to get it into a usable state. Similarly, spring context may require some cleanup when the bean is no longer needed and is removed from the container.

Spring bean factory is responsible for managing the life cycle of beans created through spring containers. The life cycle of beans consist of call back methods which can be categorized broadly into two groups:

Post initialization call back methods
Pre destruction call back methods
Spring framework provides the following four ways for controlling life cycle events of bean:

InitializingBean and DisposableBean callback interfaces
Other Aware interfaces for specific behavior
Custom init() and destroy() methods in bean configuration file
@PostConstruct and @PreDestroy annotations
For example, customInit() and customDestroy() methods are examples of the life cycle methods.

<beans>
    <bean id="demoBean" class="com.howtodoinjava.task.DemoBean" 
        init-method="customInit" destroy-method="customDestroy"></bean>
</beans>

11. What are Different Spring Bean Scopes?
We can create the beans in the spring container in six bean scopes. All the scope names are self-explanatory, but let us make them clear so there will be no doubt.

Singleton (default): This bean scope is default and it enforces the container to have only one instance per spring container irrespective of how much time you request for its instance. This singleton behavior is maintained by bean factory itself.
Prototype: This bean scope just reverses the behavior of singleton scope and produces a new instance each and every time a bean is requested.
Request: With this bean scope, a new bean instance will be created for each web request made by client. As soon as request completes, bean will be out of scope and garbage collected.
Session: Just like request scope, this ensures one instance of bean per user session. As soon as user ends its session, bean is out of scope.
Application: global-session is something which is connected to Portlet applications. When your application works in Portlet container it is built of some amount of portlets. Each portlet has its own session, but if your want to store variables global for all portlets in your application than you should store them in global-session. This scope doesn’t have any special effect different from session scope in Servlet based applications.
Websocket: enables two-way communication between a client and a remote host. Web socket provides a single TCP connection for traffic in both directions. This is specially useful for multi-user applications with simultaneous editing and multi-user games.
12. What are Inner Beans in Spring?
In Spring framework, whenever a bean is used for only one particular property, it’s advised to declare it as an inner bean. And the inner bean is supported both in setter injection ‘property‘ and constructor injection ‘constructor-arg‘.

For example, let’s say we one Customer class having reference of Person class. In our application, we will be creating only one instance of Person class, and using it inside Customer.

public class Customer
{
	private Person person;

	//Setters and Getters
}

public class Person
{
	private String name;
	private String address;
	private int age;

	//Setters and Getters
}

Now inner bean declaration will look like this:

<bean id="CustomerBean" class="com.howtodoinjava.common.Customer">
    <property name="person">
        <!-- This is inner bean -->
        <bean class="com.howtodoinjava.common.Person">
            <property name="name" value="adminis"></property>
            <property name="address" value="India"></property>
            <property name="age" value="34"></property>
        </bean>
    </property>
</bean>

13. Are Singleton Beans Thread-safe?
Spring framework does not do anything under the hood concerning the multi-threaded behavior of a singleton bean. It is the developer’s responsibility to deal with the singleton bean’s concurrency issues and thread safety.

While practically, most spring beans have no mutable state (e.g., Service and DAO classes), and as such are trivially thread-safe. But if your bean has a mutable state (e.g., View Model Objects), so you need to ensure thread safety.

The easiest and obvious solution for this problem is to change the scope of mutable beans from “singleton” to “prototype“.

14. How to Inject a Collection in Spring? Give an example?
Spring offers four types of collection configuration elements which are as follows:

<list> : This helps in wiring ie injecting a list of values, allowing duplicates.
<set> : This helps in wiring a set of values but without any duplicates.
<map> : This can be used to inject a collection of name-value pairs where name and value can be of any type.
<props> : This can be used to inject a collection of name-value pairs where the name and value are both Strings.
Let’s see an example of each type.

<beans>
 
   <!-- Definition for javaCollection -->
   <bean id="javaCollection" class="com.howtodoinjava.JavaCollection">
 
      <!-- java.util.List -->
      <property name="customList">
        <list>
           <value>INDIA</value>
           <value>Pakistan</value>
           <value>USA</value>
           <value>UK</value>
        </list>
      </property>
 
     <!-- java.util.Set -->
     <property name="customSet">
        <set>
           <value>INDIA</value>
           <value>Pakistan</value>
           <value>USA</value>
           <value>UK</value>
        </set>
      </property>
 
     <!-- java.util.Map -->
     <property name="customMap">
         
        <map>
           <entry key="1" value="INDIA"/>
           <entry key="2" value="Pakistan"/>
           <entry key="3" value="USA"/>
           <entry key="4" value="UK"/>
        </map>
 
      </property>
       
      <!-- java.util.Properties -->
    <property name="customProperies">
        <props>
            <prop key="admin">admin@nospam.com</prop>
            <prop key="support">support@nospam.com</prop>
        </props>
    </property>
 
   </bean>
 
</beans>

15. How to Inject java.util.Properties into a Bean?
The first way is to use <props> tag as below.

<bean id="adminUser" class="com.howtodoinjava.common.Customer">
  
    <!-- java.util.Properties -->
    <property name="emails">
        <props>
            <prop key="admin">admin@nospam.com</prop>
            <prop key="support">support@nospam.com</prop>
        </props>
    </property>
 
</bean>

You can use the “util:” namespace as well to create properties bean from a properties file and use bean reference for setter injection.

<util:properties id="emails" location="classpath:com/foo/emails.properties" />

16. Explain Spring Bean Autowiring?
In the spring framework, setting bean dependencies in configuration files is a good practice, but the spring container can also autowire relationships between collaborating beans.

This means that it is possible to automatically let Spring resolve collaborators (other beans) for your bean by inspecting the contents of the BeanFactory.

Autowiring is specified per bean and can thus be enabled for some beans, while others will not be autowired.

The following excerpt from the XML configuration file shows a bean being autowired by name.

<bean id="employeeDAO" 
        class="com.howtodoinjava.EmployeeDAOImpl" autowire="byName" />

Apart from the autowiring modes provided in the bean configuration file, autowiring can be specified in bean classes using @Autowired annotation. To use @Autowired annotation in bean classes, you must first enable the annotation in the spring application using the below configuration.

<context:annotation-config />

The same can be achieved using AutowiredAnnotationBeanPostProcessor bean definition in the configuration file.

<bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>

Now, when annotation configuration has been enabled, you can autowire bean dependencies using @Autowired, the way you like.

@Autowired
public EmployeeDAOImpl ( EmployeeManager manager ) {
    this.manager = manager;
}

17. Explain Different Autowiring Modes?
There are five auto wiring modes in the spring framework. Let us discuss them one by one.

no: This option is default for spring framework and it means that autowiring is OFF. You have to explicitly set the dependencies using tags in bean definitions.
byName: This option enables the dependency injection based on bean names. When autowiring a property in bean, property name is used for searching a matching bean definition in configuration file.
If such bean is found, it is injected in property. If no such bean is found, a error is raised.
byType: This option enables the dependency injection based on bean types. When autowiring a property in bean, property’s class type is used for searching a matching bean definition in configuration file.
If such bean is found, it is injected in property. If no such bean is found, a error is raised.
constructor: Autowiring by constructor is similar to byType, but applies to constructor arguments. In autowire enabled bean, it will look for class type of constructor arguments, and then do a autowire by type on all constructor arguments.
Please note that if there isn’t exactly one bean of the constructor argument type in the container, a fatal error is raised.
autodetect (deprecated in Spring 3): Autowiring by autodetect uses either of two modes i.e. constructor or byType modes. First it will try to look for valid constructor with arguments, If found the constructor mode is chosen.
If there is no constructor defined in bean, or explicit default no-args constructor is present, the autowire byType mode is chosen.
18. How to Turn On Annotation based Autowiring?
To enable @Autowired, you have to register AutowiredAnnotationBeanPostProcessor, and you can do it in two ways.

1. Include <context:annotation-config > in bean configuration file.

<beans>
    <context:annotation-config />
</beans>

2. Include AutowiredAnnotationBeanPostProcessor directly in bean configuration file.

<beans>
    <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
</beans>

19. Explain @Required Annotation with Example?
There may be hundreds or thousands of beans declared in the IoC container in a production-scale application, and the dependencies between them are often very complicated.

One of the shortcomings of setter injection is that it’s very hard to check if all required properties have been set or not. To overcome this problem, you can set “dependency-check” attribute of <bean> and set one of four attributes, i.e., none, simple, objects or all (none is the default option).

In real life application, you will not be interested in checking all the bean properties configured in your context files. Instead, you would like to check if certain properties have been set or not in some specific beans only.

Spring’s dependency checking feature using “dependency-check” attribute will not help you in this case. To solve this problem, you can use @Required annotation.

To Use the @Required annotation over setter method of bean property in the class file as below:

public class EmployeeFactoryBean extends AbstractFactoryBean&amp;lt;Object&amp;gt;
{
    private String designation;

    public String getDesignation() {
        return designation;
    }

    @Required
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    //more code here
}

RequiredAnnotationBeanPostProcessor is a spring bean post-processor that checks if all the bean properties with the @Required annotation have been set. To enable this bean post-processor for property checking, you must register it in the Spring IoC container.

<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor" />

If any properties with @Required have not been set, a BeanInitializationException will be thrown by this bean post-processor.

20. Explain @Autowired Annotation with Example?
The @Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished. The @Autowired annotation can be used to autowire bean on the setter method just like @Required annotation, constructor, a property or methods with arbitrary names and/or multiple arguments.

For example, we can use @Autowired annotation on setter methods to get rid of the <property> element in the XML configuration file. When Spring finds an @Autowired annotation used with setter methods, it tries to perform byType autowiring on the method.

We can apply @Autowired to constructors as well. A constructor @Autowired annotation indicates that the constructor should be autowired when creating the bean, even if no <constructor-arg> elements are used while configuring the bean in the XML file.

public class TextEditor {
   private SpellChecker spellChecker;

   @Autowired
   public TextEditor(SpellChecker spellChecker){
      System.out.println("Inside TextEditor constructor." );
      this.spellChecker = spellChecker;
   }

   public void spellCheck(){
      spellChecker.checkSpelling();
   }
}

And its configuration without constructor arguments.

<beans>
 
   <context:annotation-config/>
 
   <!-- Definition for textEditor bean without constructor-arg -->
   <bean id="textEditor" class="com.howtodoinjava.TextEditor">
   </bean>
 
   <!-- Definition for spellChecker bean -->
   <bean id="spellChecker" class="com.howtodoinjava.SpellChecker">
   </bean>
 
</beans>

21. Explain @Qualifier Annotation with Example?
@Qualifier means, which bean is qualified to be autowired on a field. The qualifier annotation helps disambiguate bean references when Spring would otherwise not be able to do so.

See below example, it will autowired a “person” bean into customer’s person property.

public class Customer
{
	@Autowired
	private Person person;
}

And we have two bean definitions for Person class.

<bean id="customer" class="com.howtodoinjava.common.Customer" />
 
<bean id="personA" class="com.howtodoinjava.common.Person" >
    <property name="name" value="lokesh" />
</bean>
 
<bean id="personB" class="com.howtodoinjava.common.Person" >
    <property name="name" value="alex" />
</bean>

Will Spring know which person bean should autowired? NO. When you run the above example, it hits the below exception :

Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException:
	No unique bean of type [com.howtodoinjava.common.Person] is defined:
		expected single matching bean but found 2: [personA, personB]

To fix the above problem, you need @Qualifier to tell Spring about which bean should autowired.

public class Customer
{
	@Autowired
	@Qualifier(&amp;quot;personA&amp;quot;)
	private Person person;
}

22. Difference between Constructor Injection and Setter Injection?
Please find below the noticeable differences:

In Setter Injection, partial injection of dependencies can possible, means if we have 3 dependencies like int, string, long, then its not necessary to inject all values if we use setter injection. If you will not inject then it will takes default values for those primitives.
In constructor injection, partial injection of dependencies is not possible, because for calling constructor we must pass all the arguments right, if not so we may get error.
Setter Injection will overrides the constructor injection value, provided if we write setter and constructor injection for the same property.
But, constructor injection cannot overrides the setter injected values. It’s obvious because constructors are called to first to create the instance.
Using setter injection you can not guarantee that certain dependency is injected or not, which means you may have an object with incomplete dependency.
On other hand constructor Injection does not allow you to construct object, until your dependencies are ready.
In constructor injection, if Object A and B are dependent each other i.e A is depends on B and vice-versa, Spring throws ObjectCurrentlyInCreationException while creating objects of A and B because A object cannot be created until B is created and vice-versa.
So spring can resolve circular dependencies through setter-injection because Objects are constructed before setter methods invoked.
23. What are the Different Types of Events in Spring?
Spring’s ApplicationContext provides the functionality to support events and listeners in code. We can create beans that listen for events that are published through our ApplicationContext.

Event handling in the ApplicationContext is provided through the ApplicationEvent class and ApplicationListener interface. So if a bean implements the ApplicationListener, then every time an ApplicationEvent gets published to the ApplicationContext, that bean is notified.

public class AllApplicationEventListener implements ApplicationListener <ApplicationEvent>
{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent)
	{
        //process event
    }
}

Spring provides the following five standard events:

ContextRefreshedEvent : This event is published when the ApplicationContext is either initialized or refreshed. This can also be raised using the refresh() method on the ConfigurableApplicationContext interface.
ContextStartedEvent : This event is published when the ApplicationContext is started using the start() method on the ConfigurableApplicationContext interface. You can poll your database or you can re/start any stopped application after receiving this event.
ContextStoppedEvent : This event is published when the ApplicationContext is stopped using the stop() method on the ConfigurableApplicationContext interface. You can do required house keeping work after receiving this event.
ContextClosedEvent : This event is published when the ApplicationContext is closed using the close() method on the ConfigurableApplicationContext interface. A closed context reaches its end of life; it cannot be refreshed or restarted.
RequestHandledEvent : This is a web-specific event telling all beans that an HTTP request has been serviced.
Apart from the above, you can create your own custom events by extending ApplicationEvent class. e.g.

public class CustomApplicationEvent extends ApplicationEvent
{
	public CustomApplicationEvent ( Object source, final String msg )
	{
		super(source);
		System.out.println("Created a Custom event");
	}
}

To listen to this event, create a listener like this:

public class CustomEventListener implements ApplicationListener <CustomApplicationEvent>
{
	@Override
    public void onApplicationEvent(CustomApplicationEvent applicationEvent) {
		//handle event
	}
}

And to publish this event, you will need the help of the applicationContext instance.

CustomApplicationEvent customEvent 
        = new CustomApplicationEvent( applicationContext, "Test message");
applicationContext.publishEvent ( customEvent )

24. Difference between FileSystemResource and ClassPathResource?
In FileSystemResource you need to give the path of spring-config.xml (Spring Configuration) file relative to your project or the absolute location of the file.

In ClassPathResource spring looks for the file using ClassPath so spring-config.xml should be included in classpath. If spring-config.xml is in “src” so we can give just its name because src is in the classpath path by default.

In one sentence, ClassPathResource looks in the classpath and FileSystemResource looks in the file system.

25. Name few Design Patterns used in Spring Framework?
There are loads of different design patterns used, but there are a few obvious ones:

Proxy – used heavily in AOP, and remoting.
Singleton – beans defined in spring config files are singletons by default.
Template method – used extensively to deal with boilerplate repeated code e.g. RestTemplate, JmsTemplate, JpaTemplate.
Front controller – Spring provides DispatcherServlet to ensure an incoming request gets dispatched to your controllers.
View Helper – Spring has a number of custom JSP tags, and velocity macros, to assist in separating code from presentation in views.
Dependency injection – Center to the whole BeanFactory / ApplicationContext concepts.
Factory pattern – BeanFactory for creating instance of an object.
