Table of Contents

1) What is Spring Framework? What are it's main modules?
2) What are the benefits of using Spring Framework?
3) What is Inversion of Control (IoC) and Dependency Injection?
4) Explain IoC in Spring Framework?
5) Difference between BeanFactory and ApplicationContext? 
6) In how many ways, you can configure Spring into our application?
7) What is Spring XML-Based Configuration?
8) What is Spring Java-Based Configuration?
9) What is Spring Annotation-based Configuration?
10) Explain Spring Bean lifecycle?
11) What are different Spring Bean Scopes?
12) What are inner beans in Spring?
13) Are Singleton beans thread safe in Spring Framework?
14) How can you inject a Java Collection in Spring? Give example?
15) How to inject a java.util.Properties into a Spring Bean?
16) Explain Spring Bean Autowiring?
17) Explain different modes of bean autowiring? 
18) How do you turn on annotation based autowiring?
19) Explain @Required annotation with example?
20) Explain @Autowired annotation with example?
21) Explain @Qualifier annotation with example?
22) Difference between constructor injection and setter injection?
23) What are the different types of events in spring framework?
24) Difference between FileSystemResource and ClassPathResource?
25) Name some of the design patterns used in Spring Framework?

1.	What is Spring Framework?
2.	What are some of the important features and advantages of Spring Framework?
3.	What do you understand by Dependency Injection?
4.	How do we implement DI in Spring Framework?
5.	What are the benefits of using Spring Tool Suite?
6.	Name some of the important Spring Modules?
7.	What do you understand by Aspect Oriented Programming?
8.	What is Aspect, Advice, Pointcut, JointPoint and Advice Arguments in AOP?
9.	What is the difference between Spring AOP and AspectJ AOP?
10.	What is Spring IoC Container?
11.	What is a Spring Bean?
12.	What is the importance of Spring bean configuration file?
13.	What are different ways to configure a class as Spring Bean?
14.	What are different scopes of Spring Bean?
15.	What is Spring Bean life cycle?
16.	How to get ServletContext and ServletConfig object in a Spring Bean?
17.	What is Bean wiring and @Autowired annotation?
18.	What are different types of Spring Bean autowiring?
19.	Does Spring Bean provide thread safety?
20.	What is a Controller in Spring MVC?
21.	What’s the difference between @Component, @Repository & @Service annotations in Spring?
22.	What is DispatcherServlet and ContextLoaderListener?
23.	What is ViewResolver in Spring?
24.	What is a MultipartResolver and when its used?
25.	How to handle exceptions in Spring MVC Framework?
26.	How to create ApplicationContext in a Java Program?
27.	Can we have multiple Spring configuration files?
28.	What is ContextLoaderListener?
29.	What are the minimum configurations needed to create Spring MVC application?
30.	How would you relate Spring MVC Framework to MVC architecture?
31.	How to achieve localization in Spring MVC applications?
32.	How can we use Spring to create Restful Web Service returning JSON response?
33.	What are some of the important Spring annotations you have used?
34.	Can we send an Object as the response of Controller handler method?
35.	How to upload file in Spring MVC Application?
36.	How to validate form data in Spring Web MVC Framework?
37.	What is Spring MVC Interceptor and how to use it?
38.	What is Spring JdbcTemplate class and how to use it?
39.	How to use Tomcat JNDI DataSource in Spring Web Application?
40.	How would you achieve Transaction Management in Spring?
41.	What is Spring DAO?
42.	How to integrate Spring and Hibernate Frameworks?
43.	What is Spring Security?
44.	How to inject a java.util.Properties into a Spring Bean?
45.	Name some of the design patterns used in Spring Framework?
46.	What are some of the best practices for Spring Framework?
    
#### 1) What is Spring Framework? What are its main modules?
The Spring Framework is a Java platform that provides comprehensive infrastructure support for developing Java applications. Spring handles the infrastructure part so you can focus on your application part. Inside itself, Spring Framework codifies formalized design patterns as first-class objects that you can integrate into your own application(s) without worrying too much about how they work in backend.
At present, Spring Framework consists of features organized into about 20 modules. These modules are grouped into Core Container, Data Access/Integration, Web, AOP (Aspect Oriented Programming), Instrumentation, Messaging, and Test, as shown in the following diagram.
 
#### 2) What are the benefits of using Spring Framework?
Following is the list of few of the great benefits of using Spring Framework –
•	With the Dependency Injection(DI) approach, dependencies are explicit and evident in constructor or JavaBean properties.
•	IoC containers tend to be lightweight, especially when compared to EJB containers, for example. This is beneficial for developing and deploying applications on computers with limited memory and CPU resources.
•	Spring does not reinvent the wheel instead; it truly makes use of some of the existing technologies like several ORM frameworks, logging frameworks, JEE, Quartz and JDK timers, other view technologies.
•	Spring is organized in a modular fashion. Even though the number of packages and classes are substantial, you have to worry only about ones you need and ignore the rest.
•	Testing an application written with Spring is simple because environment-dependent code is moved into this framework. Furthermore, by using JavaBean-style POJOs, it becomes easier to use dependency injection for injecting test data.
•	Spring’s web framework is a well-designed web MVC framework, which provides a great alternative to web frameworks such as Struts or other over engineered or less popular web frameworks.
•	Spring provides a consistent transaction management interface that can scale down to a local transaction (using a single database, for example) and scale up to global transactions (using JTA, for example).
#### 3) What is Inversion of Control (IoC) and Dependency Injection? 
In software engineering, inversion of control (IoC) is a programming technique in which object coupling is bound at run time by an assembler object and is typically not known at compile time using static analysis. In traditional programming, the flow of the business logic is determined by objects that are statically assigned to one another. With inversion of control, the flow depends on the object graph that is instantiated by the assembler and is made possible by object interactions being defined through abstractions. The binding process is achieved through “dependency injection”.
Inversion of control is a design paradigm with the goal of giving more control to the targeted components of your application, the ones that are actually doing the work.
Dependency injection is a pattern used to create instances of objects that other objects rely on without knowing at compile time which class will be used to provide that functionality. Inversion of control relies on dependency injection because a mechanism is needed in order to activate the components providing the specific functionality. Otherwise how will the framework know which components to create if it is no longer in control?
In Java, dependency injection may happen through 3 ways:
1.	A constructor injection
2.	A setter injection
3.	An interface injection
#### 4) Explain IoC in Spring Framework?
The org.springframework.beans and org.springframework.context packages provide the basis for the Spring Framework’s IoC container. The BeanFactory interface provides an advanced configuration mechanism capable of managing objects of any nature. The ApplicationContext interface builds on top of the BeanFactory (it is a sub-interface) and adds other functionality such as easier integration with Spring’s AOP features, message resource handling (for use in internationalization), event propagation, and application-layer specific contexts such as the WebApplicationContext for use in web applications.
The org.springframework.beans.factory.BeanFactory is the actual representation of the Spring IoC container that is responsible for containing and otherwise managing the aforementioned beans. The BeanFactory interface is the central IoC container interface in Spring.
#### 5) Difference between BeanFactory and ApplicationContext? 
A BeanFactory is like a factory class that contains a collection of beans. The BeanFactory holds Bean Definitions of multiple beans within itself and then instantiates the bean whenever asked for by clients. BeanFactory is able to create associations between collaborating objects as they are instantiated. This removes the burden of configuration from bean itself and the beans client. BeanFactory also takes part in the life cycle of a bean, making calls to custom initialization and destruction methods.
On the surface, an application context is same as a bean factory.Both load bean definitions, wire beans together, and dispense beans upon request. But it also provides:
1.	A means for resolving text messages, including support for internationalization.
2.	A generic way to load file resources.
3.	Events to beans that are registered as listeners.
The three commonly used implementations of ApplicationContext are:
1.	ClassPathXmlApplicationContext : It Loads context definition from an XML file located in the classpath, treating context definitions as classpath resources. The application context is loaded from the application’s classpath by using the code. 
ApplicationContext context = new ClassPathXmlApplicationContext(“bean.xml”);
2.	FileSystemXmlApplicationContext : It loads context definition from an XML file in the filesystem. The application context is loaded from the file system by using the code. 
ApplicationContext context = new FileSystemXmlApplicationContext(“bean.xml”);
3.	XmlWebApplicationContext : It loads context definition from an XML file contained within a web application.
#### 6) In how many ways, you can configure Spring into our application?
You can configure spring into your application in 3 ways:
1.	XML Based Configuration
2.	Annotation-based configuration
3.	Java-based configuration
#### 7) What is Spring XML-Based Configuration? 
In Spring framework, dependencies and the services needed by beans are specified in configuration files, which are typically in an XML format. These configuration files usually start with <beans> tag and contain a lot of bean definitions AND application specific configuration options.
The main goal of Spring XML Configuration is to have all the Spring components configured by using xml files.
This means that there will not be present any other type of Spring Configuration (like annotations or configuration via Java classes).
A Spring XML Configuration uses Spring namespaces to make available the sets of XML tags used in the configuration; the main Spring namespaces are: context, beans, jdbc, tx, aop, mvc, aso.
```xml
<beans>
 
    <!-- JSON Support -->
    <bean name="viewResolver" class="org.springframework.web.servlet.view.BeanNameViewResolver"/>
    <bean name="jsonTemplate" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
     
    <bean id="restTemplate" class="org.springframework.web.client.RestTemplate"/>
 
</beans>
```
And simplest web.xml file to make your application load configuration file and configure the runtime components for you is below where you configure only DispatcherServlet.
```xml
<web-app>
  <display-name>Archetype Created Web Application</display-name>
   
  <servlet>
        <servlet-name>spring</servlet-name>
            <servlet-class>
                org.springframework.web.servlet.DispatcherServlet
            </servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
 
    <servlet-mapping>
        <servlet-name>spring</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
     
</web-app>
```
#### 8) What is Spring Java-Based Configuration? 
The central artifacts in Spring’s new Java-configuration support are @Configuration annotated classes and @Bean annotated methods. 
The @Bean annotation is used to indicate that a method instantiates, configures and initializes a new object to be managed by the Spring IoC container. @Bean annotation plays the same role as the <bean/> element. 
Annotating a class with @Configuration indicates that its primary purpose is as a source of bean definitions. Furthermore, @Configuration classes allow inter-bean dependencies to be defined by simply calling other @Bean methods in the same class. The simplest possible @Configuration class would read as follows:
```java
@Configuration
public class AppConfig 
{
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```
The equivalent XML configuration for above java config would be:
```xml
<beans>
    <bean id="myService" class="com.howtodoinjava.services.MyServiceImpl"/>
</beans>
```
To instantiate such config, you will need the help of AnnotationConfigApplicationContext class.
```java
public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    MyService myService = ctx.getBean(MyService.class);
    myService.doStuff();
}
```
To enable component scanning, just annotate your @Configuration class as follows:
```java
@Configuration
@ComponentScan(basePackages = "com.howtodoinjava")
public class AppConfig  {
    ...
}
```
In the example above, the com.acme package will be scanned, looking for any @Component annotated classes, and those classes will be registered as Spring bean definitions within the container.
If you are using above configuration in a web application then you will be using AnnotationConfigWebApplicationContext class. This implementation may be used when configuring the Spring ContextLoaderListener servlet listener, Spring MVC DispatcherServlet etc. 
```xml
<web-app>
    <!-- Configure ContextLoaderListener to use AnnotationConfigWebApplicationContext
        instead of the default XmlWebApplicationContext -->
    <context-param>
        <param-name>contextClass</param-name>
        <param-value>
            org.springframework.web.context.support.AnnotationConfigWebApplicationContext
        </param-value>
    </context-param>
 
    <!-- Configuration locations must consist of one or more comma- or space-delimited
        fully-qualified @Configuration classes. Fully-qualified packages may also be
        specified for component-scanning -->
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
        <!-- Configure DispatcherServlet to use AnnotationConfigWebApplicationContext
            instead of the default XmlWebApplicationContext -->
        <init-param>
            <param-name>contextClass</param-name>
            <param-value>
                org.springframework.web.context.support.AnnotationConfigWebApplicationContext
            </param-value>
        </init-param>
        <!-- Again, config locations must consist of one or more comma- or space-delimited
            and fully-qualified @Configuration classes -->
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
```
#### 9) What is Spring Annotation-based Configuration?
Starting from Spring 2.5 it became possible to configure the dependency injection using annotations. So instead of using XML to describe a bean wiring, you can move the bean configuration into the component class itself by using annotations on the relevant class, method, or field declaration. Annotation injection is performed before XML injection, thus the latter configuration will override the former for properties wired through both approaches.
Annotation wiring is not turned on in the Spring container by default. So, before we can use annotation-based wiring, we will need to enable it in our Spring configuration file. So consider to have following configuration file in case you want to use any annotation in your Spring application.
```xml
<beans>
 
   <context:annotation-config/>
   <!-- bean definitions go here -->
 
</beans>
```
Once <context:annotation-config/> is configured, you can start annotating your code to indicate that Spring should automatically wire values into properties, methods, and constructors.
Few important annotations which you will be using in this type of configuration are :
1.	@Required : The @Required annotation applies to bean property setter methods.
2.	@Autowired : The @Autowired annotation can apply to bean property setter methods, non-setter methods, constructor and properties.
3.	@Qualifier : The @Qualifier annotation along with @Autowired can be used to remove the confusion by specifiying which exact bean will be wired.
4.	JSR-250 Annotations : Spring supports JSR-250 based annotations which include @Resource, @PostConstruct and @PreDestroy annotations.
#### 10) Explain Spring Bean lifecycle?
The life cycle of a Spring bean is easy to understand. When a bean is instantiated, it may be required to perform some initialization to get it into a usable state. Similarly, when the bean is no longer required and is removed from the container, some cleanup may be required.
Spring bean factory is responsible for managing the life cycle of beans created through spring container. The life cycle of beans consist of call back methods which can be categorized broadly in two groups:
1.	Post initialization call back methods
2.	Pre destruction call back methods
Spring framework provides following 4 ways for controlling life cycle events of bean:
•	InitializingBean and DisposableBean callback interfaces
•	Other Aware interfaces for specific behavior
•	Custom init() and destroy() methods in bean configuration file
•	@PostConstruct and @PreDestroy annotations
For example, customInit() and customDestroy() methods are example of life cycle method.
<beans>
    <bean id="demoBean" class="com.howtodoinjava.task.DemoBean"
            init-method="customInit" destroy-method="customDestroy"></bean>
</beans>
#### 11) What are different Spring Bean Scopes?
The beans in spring container can be created in five scopes. All the scope names are self-explanatory but lets make them clear so that there will not be any doubt.
1.	singleton: This bean scope is default and it enforces the container to have only one instance per spring container irrespective of how much time you request for its instance. This singleton behavior is maintained by bean factory itself.
2.	prototype: This bean scope just reverses the behavior of singleton scope and produces a new instance each and every time a bean is requested.
3.	request: With this bean scope, a new bean instance will be created for each web request made by client. As soon as request completes, bean will be out of scope and garbage collected.
4.	session: Just like request scope, this ensures one instance of bean per user session. As soon as user ends its session, bean is out of scope.
5.	global-session: global-session is something which is connected to Portlet applications. When your application works in Portlet container it is built of some amount of portlets. Each portlet has its own session, but if your want to store variables global for all portlets in your application than you should store them in global-session. This scope doesn’t have any special effect different from session scope in Servlet based applications.
#### 12) What are inner beans in Spring?
In Spring framework, whenever a bean is used for only one particular property, it’s advise to declare it as an inner bean. And the inner bean is supported both in setter injection ‘property‘ and constructor injection ‘constructor-arg‘.
For example, let’s say we one Customer class having reference of Person class. In our application, we will be creating only one instance of Person class, and use it inside Customer. 
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
            <property name="name" value="lokesh" />
            <property name="address" value="India" />
            <property name="age" value="34" />
        </bean>
    </property>
</bean>
#### 13) Are Singleton beans thread safe in Spring Framework?
Spring framework does not do anything under the hood concerning the multi-threaded behavior of a singleton bean. It is the developer’s responsibility to deal with concurrency issue and thread safety of the singleton bean. 
While practically, most spring beans have no mutable state (e.g. Service and DAO clases), and as such are trivially thread safe. But if your bean has mutable state (e.g. View Model Objects), so you need to ensure thread safety. The most easy and obvious solution for this problem is to change bean scope of mutable beans from “singleton” to “prototype“.
#### 14) How can you inject a Java Collection in Spring? Give example?
Spring offers four types of collection configuration elements which are as follows:
<list> : This helps in wiring ie injecting a list of values, allowing duplicates.
<set> : This helps in wiring a set of values but without any duplicates.
<map> : This can be used to inject a collection of name-value pairs where name and value can be of any type.
<props> : This can be used to inject a collection of name-value pairs where the name and value are both Strings.
Let’s see example of each type.
```xml
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
```
#### 15) How to inject a java.util.Properties into a Spring Bean?
First way is to use <props> tag as below.
```xml
<bean id="adminUser" class="com.howtodoinjava.common.Customer">
  
    <!-- java.util.Properties -->
    <property name="emails">
        <props>
            <prop key="admin">admin@nospam.com</prop>
            <prop key="support">support@nospam.com</prop>
        </props>
    </property>
 
</bean>
```
You can use “util:” namespace as well to create properties bean from properties file, and use bean reference for setter injection.
<util:properties id="emails" location="classpath:com/foo/emails.properties" />
#### 16) Explain Spring Bean Autowiring?
In spring framework, setting bean dependencies in configuration files is a good practice to follow, but the spring container is also able to autowire relationships between collaborating beans. This means that it is possible to automatically let Spring resolve collaborators (other beans) for your bean by inspecting the contents of the BeanFactory. Autowiring is specified per bean and can thus be enabled for some beans, while other beans will not be autowired.
The following excerpt from the XML configuration file shows a bean being autowired by name.
<bean id="employeeDAO" class="com.howtodoinjava.EmployeeDAOImpl" autowire="byName" />
Apart from the autowiring modes provided in bean configuration file, autowiring can be specified in bean classes also using @Autowired annotation. To use @Autowired annotation in bean classes, you must first enable the annotation in spring application using below configuration.
<context:annotation-config />
Same can be achieved using AutowiredAnnotationBeanPostProcessor bean definition in configuration file.
<bean class ="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
Now, when annotation configuration has been enables, you are free to autowire bean dependencies using @Autowired, the way you like. 
@Autowired
public EmployeeDAOImpl ( EmployeeManager manager ) {
    this.manager = manager;
}
#### 17) Explain different modes of bean autowiring? 
There are five auto wiring modes in spring framework. Lets discuss them one by one.
1.	no: This option is default for spring framework and it means that autowiring is OFF. You have to explicitly set the dependencies using tags in bean definitions.
2.	byName: This option enables the dependency injection based on bean names. When autowiring a property in bean, property name is used for searching a matching bean definition in configuration file. If such bean is found, it is injected in property. If no such bean is found, a error is raised.
3.	byType: This option enables the dependency injection based on bean types. When autowiring a property in bean, property’s class type is used for searching a matching bean definition in configuration file. If such bean is found, it is injected in property. If no such bean is found, a error is raised.
4.	constructor: Autowiring by constructor is similar to byType, but applies to constructor arguments. In autowire enabled bean, it will look for class type of constructor arguments, and then do a autowire by type on all constructor arguments. Please note that if there isn’t exactly one bean of the constructor argument type in the container, a fatal error is raised.
5.	autodetect: Autowiring by autodetect uses either of two modes i.e. constructor or byType modes. First it will try to look for valid constructor with arguments, If found the constructor mode is chosen. If there is no constructor defined in bean, or explicit default no-args constructor is present, the autowire byType mode is chosen.
#### 18) How do you turn on annotation based autowiring?
To enable @Autowired, you have to register AutowiredAnnotationBeanPostProcessor, and you can do it in two ways.
1. Include <context:annotation-config > in bean configuration file.
<beans>
    <context:annotation-config />
</beans>
2. Include AutowiredAnnotationBeanPostProcessor directly in bean configuration file.
<beans>
    <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
</beans>
#### 19) Explain @Required annotation with example?
In a production-scale application, there may be hundreds or thousands of beans declared in the IoC container, and the dependencies between them are often very complicated. One of the shortcomings of setter injection is that it’s very hard for you to check if all required properties have been set or not. To overcome this problem, you can set “dependency-check” attribute of <bean> and set one of four attributes i.e. none, simple, objects or all (none is default option). 
In real life application, you will not be interested in checking all the bean properties configured in your context files. Rather you would like to check if particular set of properties have been set or not in some specific beans only. Spring’s dependency checking feature using “dependency-check” attribute, will not able to help you in this case. So solve this problem, you can use @Required annotation.
To Use the @Required annotation over setter method of bean property in class file as below:
public class EmployeeFactoryBean extends AbstractFactoryBean<Object>
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
RequiredAnnotationBeanPostProcessor is a spring bean post processor that checks if all the bean properties with the @Required annotation have been set. To enable this bean post processor for property checking, you must register it in the Spring IoC container.
<bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor" />
If any properties with @Required have not been set, a BeanInitializationException will be thrown by this bean post processor.
#### 20) Explain @Autowired annotation with example?
The @Autowired annotation provides more fine-grained control over where and how autowiring should be accomplished. The @Autowired annotation can be used to autowire bean on the setter method just like @Required annotation, constructor, a property or methods with arbitrary names and/or multiple arguments.
E.g. You can use @Autowired annotation on setter methods to get rid of the <property> element in XML configuration file. When Spring finds an @Autowired annotation used with setter methods, it tries to perform byType autowiring on the method.
You can apply @Autowired to constructors as well. A constructor @Autowired annotation indicates that the constructor should be autowired when creating the bean, even if no <constructor-arg> elements are used while configuring the bean in XML file.
```java
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
```
And it’s configuration without constructor arguments.
```xml
<beans>
 
   <context:annotation-config/>
 
   <!-- Definition for textEditor bean without constructor-arg  -->
   <bean id="textEditor" class="com.howtodoinjava.TextEditor">
   </bean>
 
   <!-- Definition for spellChecker bean -->
   <bean id="spellChecker" class="com.howtodoinjava.SpellChecker">
   </bean>
 
</beans>
```
#### 21) Explain @Qualifier annotation with example?
@Qualifier means, which bean is qualify to autowired on a field. The qualifier annotation helps disambiguate bean references when Spring would otherwise not be able to do so.
See below example, it will autowired a “person” bean into customer’s person property.
```java
public class Customer 
{
    @Autowired
    private Person person;
}
```
And we have two bean definitions for Person class.
```xml
<bean id="customer" class="com.howtodoinjava.common.Customer" />
 
<bean id="personA" class="com.howtodoinjava.common.Person" >
    <property name="name" value="lokesh" />
</bean>
 
<bean id="personB" class="com.howtodoinjava.common.Person" >
    <property name="name" value="alex" />
</bean>
```
Will Spring know which person bean should autowired? NO. When you run above example, it hits below exception :
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: 
    No unique bean of type [com.howtodoinjava.common.Person] is defined: 
        expected single matching bean but found 2: [personA, personB]
To fix above problem, you need @Quanlifier to tell Spring about which bean should autowired.
```java
public class Customer 
{
    @Autowired
    @Qualifier("personA")
    private Person person;
}
```
#### 22) Difference between constructor injection and setter injection?
Please find below the noticeable differences:
1.	In Setter Injection, partial injection of dependencies can possible, means if we have 3 dependencies like int, string, long, then its not necessary to inject all values if we use setter injection. If you are not inject it will takes default values for those primitives. In constructor injection, partial injection of dependencies is not possible, because for calling constructor we must pass all the arguments right, if not so we may get error.
2.	Setter Injection will overrides the constructor injection value, provided if we write setter and constructor injection for the same property. But, constructor injection cannot overrides the setter injected values. It’s obvious because constructors are called to first to create the instance.
3.	Using setter injection you can not guarantee that certain dependency is injected or not, which means you may have an object with incomplete dependency. On other hand constructor Injection does not allow you to construct object, until your dependencies are ready.
4.	In constructor injection, if Object A and B are dependent each other i.e A is depends on B and vice-versa, Spring throws ObjectCurrentlyInCreationException while creating objects of A and B because A object cannot be created until B is created and vice-versa. So spring can resolve circular dependencies through setter-injection because Objects are constructed before setter methods invoked.
#### 23) What are the different types of events in spring framework?
Spring’s ApplicationContext provides the functionality to support events and listeners in code. We can create beans that listen for events which are published through our ApplicationContext. Event handling in the ApplicationContext is provided through the ApplicationEvent class and ApplicationListener interface. So if a bean implements the ApplicationListener, then every time an ApplicationEvent gets published to the ApplicationContext, that bean is notified.
```java
public class AllApplicationEventListener implements ApplicationListener < ApplicationEvent > 
{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) 
    {
        //process event
    }
}
```
Spring provides the following 5 standard events:
1.	ContextRefreshedEvent : This event is published when the ApplicationContext is either initialized or refreshed. This can also be raised using the refresh() method on the ConfigurableApplicationContext interface.
2.	ContextStartedEvent : This event is published when the ApplicationContext is started using the start() method on the ConfigurableApplicationContext interface. You can poll your database or you can re/start any stopped application after receiving this event.
3.	ContextStoppedEvent : This event is published when the ApplicationContext is stopped using the stop() method on the ConfigurableApplicationContext interface. You can do required house keeping work after receiving this event.
4.	ContextClosedEvent : This event is published when the ApplicationContext is closed using the close() method on the ConfigurableApplicationContext interface. A closed context reaches its end of life; it cannot be refreshed or restarted.
5.	RequestHandledEvent : This is a web-specific event telling all beans that an HTTP request has been serviced.
Apart from above, you can create your own custom events by extending ApplicationEvent class. e.g.
```java
public class CustomApplicationEvent extends ApplicationEvent 
{ 
    public CustomApplicationEvent ( Object source, final String msg ) 
    {
        super(source);
        System.out.println("Created a Custom event");
    }
}
To listen this event, create a listener like this:
public class CustomEventListener implements ApplicationListener < CustomApplicationEvent > 
{
    @Override
    public void onApplicationEvent(CustomApplicationEvent applicationEvent) {
        //handle event
    }
}
```
And to publish this event, you will need the help of applicationContext instance.
CustomApplicationEvent customEvent = new CustomApplicationEvent( applicationContext, "Test message" );
applicationContext.publishEvent ( customEvent ); 
#### 24) Difference between FileSystemResource and ClassPathResource? 
In FileSystemResource you need to give path of spring-config.xml (Spring Configuration) file relative to your project or the absolute location of the file.
In ClassPathResource spring looks for the file using ClassPath so spring-config.xml should be included in classpath. If spring-config.xml is in “src” so we can give just its name because src is in classpath path by default.
In one sentence, ClassPathResource looks in the class path and FileSystemResource looks in the file system. 
#### 25) Name some of the design patterns used in Spring Framework?
There are loads of different design patterns used, but there are a few obvious ones:
•	Proxy – used heavily in AOP, and remoting.
•	Singleton – beans defined in spring config files are singletons by default.
•	Template method – used extensively to deal with boilerplate repeated code e.g. RestTemplate, JmsTemplate, JpaTemplate.
•	Front Controller – Spring provides DispatcherServlet to ensure an incoming request gets dispatched to your controllers.
•	View Helper – Spring has a number of custom JSP tags, and velocity macros, to assist in separating code from presentation in views.
•	Dependency injection – Center to the whole BeanFactory / ApplicationContext concepts.
•	Factory pattern – BeanFactory for creating instance of an object.
•	
#### 1) What is spring framework? Why Java programmer should use Spring framework
Very common Spring interview question, Spring is a framework which helps Java programmer in development. Spring provides dependency Injection and IOC container, Spring MVC flow and several useful API for Java programmer.

#### 2) What is default scope of bean in Spring framework ?
default scope of bean is Singleton, you can read this article which explains about all possible scope of a spring bean : What is bean scope in Spring

#### 3) Does Spring singleton beans are thread-safe ?
No, Spring singleton beans are not thread-safe. Singleton doesn't mean bean would be thread-safe.

#### 4) What is dependency Injection?
Dependency Injection is one of the design pattern, which allows to inject dependency on Object, instead of object resolving dependency.

#### 5) What is Inversion of Control concept, how does Spring support IOC?

#### 6) What is Spring MVC ? Can you explain How one request is processed ?

#### 7) How to you create controller in Spring ?


#### 8) What is view Resolver pattern ? how it work in Spring MVC
View Resolver patter is a J2EE pattern which allows a web application to dynamically choose it's view technology e.g. HTML, JSP, Tapestry, JSF, XSLT or any other view technology. In this pattern, View resolver holds mapping of different views, controller return name of view, which is than passed to View Resolver for selecting appropriate view. Spring MVC framework supplies inbuilt view resolver for selecting views.



#### 9) What is Spring Security ?
Spring security is a project under spring framework umbrella, which provides support for security requirements of enterprise Java projects. Spring Security formerly known as aegis security provides out of box support for creating login screen, remember me cookie support, securing URL, authentication provider to authenticate user from database, LDAP and in memory, concurrent active session management support and many more. In order to use Spring security in a Spring MVC based project, you need to include spring-security.jar and configure it in application-Context-security.xml file, you can name it whatever you want, but make sure to supply this to ContextLoaderListener, which is responsible for creating Spring context and initializing dispatcher servlet.

#### 10) How do you control concurrent Session on Java web application using Spring Security.
You can use Spring Security to control number of active session in Java web application. Spring security framework provides this feature out of box and when enabled , a user can only have one active session at a time. See this Spring Security example to learn more about How to control concurrent user session using Spring security


#### 11) What types of dependency injection is supported by Spring Framework? When do you use Setter and Constructor Injection, pros and cons?
There are 2 types of dependency injection supported by Spring, constructor based injection and setter based injection. Both types have their own advantages and disadvantages, you should use Constructor injection when object's dependencies are not optional and they must be initialized with their dependencies. Also use constructor injection if order of initialization or dependency matters because in Setter based injection you cannot impose any order. Use setter injection when dependencies are optional. See difference between setter and constructor injection in Spring for more detailed answer.


#### 12) What is difference between ApplicationContext and BeanFactory in Spring framework?

#### 13) How do you call stored procedure by using Spring framework?

#### 14) What does JdbcTemplate and JmsTemplate class offer in Spring?

#### 15) Can we use more than one configuration file for our Spring project?

#### 16) Explain Spring MVC flow with a simple example e.g. starting from Container receives request and forward to your Java application ?

#### 17) What is difference in Spring MVC and Spring core?

#### 18) Can you use Spring MVC framework along with Struts ? I have an existing Java MVC application which is based in Struts, Can I migrate that to use Spring MVC ? How ?

#### 19) What is advantage of Spring MVC framework over Struts 1.0 or Struts 2.0 ? is it worth to convert an existing Struts application to Spring MVC ?

#### 20) How does Spring resolves view returned by ModelAndView class ?

Some Spring MVC questions are tricky e.g. Struts and Spring integration and can be only answered by experienced Java program with 2 to 4 year experience in Spring MVC framework.

#### 21) IF User checked in CheckBox and got validation error on otherfields and than he unchecked the CheckBox, what would be selection status in command object in Spring MVC ? How do you fix this issue?
Since during HTTP post, if checkbox is unchecked than HTTP does include a request parameter for checkbox, which means updated selection won't be picked up. you can use hidden form field, starting with _ to fix this in Spring MVC. quite tricky question to answer if you are not aware of HTTP POST behavior and Spring MVC.

#### 22) What are different implementation of View interface you have used in Spring MVC?
ULBased View e.g. JSP , JSTLView,

#### 23) How to escape HTML special characters using Spring MVC?
There are some methods in Spring tag library, can't remember now.








#### 1.	What is Spring Framework?
Spring is one of the most widely used Java EE framework. Spring framework core concepts are “Dependency Injection” and “Aspect Oriented Programming”.
Spring framework can be used in normal java applications also to achieve loose coupling between different components by implementing dependency injection and we can perform cross cutting tasks such as logging and authentication using spring support for aspect oriented programming.
I like spring because it provides a lot of features and different modules for specific tasks such as Spring MVC and Spring JDBC. Since it’s an open source framework with a lot of online resources and active community members, working with Spring framework is easy and fun at same time.
#### 2.	What are some of the important features and advantages of Spring Framework?
Spring Framework is built on top of two design concepts – Dependency Injection and Aspect Oriented Programming.
Some of the features of spring framework are:
o	Lightweight and very little overhead of using framework for our development.
o	Dependency Injection or Inversion of Control to write components that are independent of each other, spring container takes care of wiring them together to achieve our work.
o	Spring IoC container manages Spring Bean life cycle and project specific configurations such as JNDI lookup.
o	Spring MVC framework can be used to create web applications as well as restful web services capable of returning XML as well as JSON response.
o	Support for transaction management, JDBC operations, File uploading, Exception Handling etc with very little configurations, either by using annotations or by spring bean configuration file.
Some of the advantages of using Spring Framework are:
o	Reducing direct dependencies between different components of the application, usually Spring IoC container is responsible for initializing resources or beans and inject them as dependencies.
o	Writing unit test cases are easy in Spring framework because our business logic doesn’t have direct dependencies with actual resource implementation classes. We can easily write a test configuration and inject our mock beans for testing purposes.
o	Reduces the amount of boiler-plate code, such as initializing objects, open/close resources. I like JdbcTemplate class a lot because it helps us in removing all the boiler-plate code that comes with JDBC programming.
o	Spring framework is divided into several modules, it helps us in keeping our application lightweight. For example, if we don’t need Spring transaction management features, we don’t need to add that dependency in our project.
o	Spring framework support most of the Java EE features and even much more. It’s always on top of the new technologies, for example there is a Spring project for Android to help us write better code for native android applications. This makes spring framework a complete package and we don’t need to look after different framework for different requirements.
#### 3.	What do you understand by Dependency Injection?
Dependency Injection design pattern allows us to remove the hard-coded dependencies and make our application loosely coupled, extendable and maintainable. We can implement dependency injection pattern to move the dependency resolution from compile-time to runtime.
Some of the benefits of using Dependency Injection are: Separation of Concerns, Boilerplate Code reduction, Configurable components and easy unit testing.
Read more at Dependency Injection Tutorial. We can also use Google Guice for Dependency Injection to automate the process of dependency injection. But in most of the cases we are looking for more than just dependency injection and that’s why Spring is the top choice for this.
#### 4.	How do we implement DI in Spring Framework?
We can use Spring XML based as well as Annotation based configuration to implement DI in spring applications. For better understanding, please read Spring Dependency Injection example where you can learn both the ways with JUnit test case. The post also contains sample project zip file, that you can download and play around to learn more.
#### 5.	What are the benefits of using Spring Tool Suite?
We can install plugins into Eclipse to get all the features of Spring Tool Suite. However STS comes with Eclipse with some other important stuffs such as Maven support, Templates for creating different types of Spring projects and tc server for better performance with Spring applications.
I like STS because it highlights the Spring components and if you are using AOP pointcuts and advices, then it clearly shows which methods will come under the specific pointcut. So rather than installing everything on our own, I prefer using STS when developing Spring based applications.
#### 6.	Name some of the important Spring Modules?
Some of the important Spring Framework modules are:
o	Spring Context – for dependency injection.
o	Spring AOP – for aspect oriented programming.
o	Spring DAO – for database operations using DAO pattern
o	Spring JDBC – for JDBC and DataSource support.
o	Spring ORM – for ORM tools support such as Hibernate
o	Spring Web Module – for creating web applications.
o	Spring MVC – Model-View-Controller implementation for creating web applications, web services etc.
#### 7.	What do you understand by Aspect Oriented Programming?
Enterprise applications have some common cross-cutting concerns that is applicable for different types of Objects and application modules, such as logging, transaction management, data validation, authentication etc. In Object Oriented Programming, modularity of application is achieved by Classes whereas in AOP application modularity is achieved by Aspects and they are configured to cut across different classes methods.
AOP takes out the direct dependency of cross-cutting tasks from classes that is not possible in normal object oriented programming. For example, we can have a separate class for logging but again the classes will have to call these methods for logging the data. Read more about Spring AOP support at Spring AOP Example.
#### 8.	What is Aspect, Advice, Pointcut, JointPoint and Advice Arguments in AOP?
Aspect: Aspect is a class that implements cross-cutting concerns, such as transaction management. Aspects can be a normal class configured and then configured in Spring Bean configuration file or we can use Spring AspectJ support to declare a class as Aspect using @Aspect annotation.
Advice: Advice is the action taken for a particular join point. In terms of programming, they are methods that gets executed when a specific join point with matching pointcut is reached in the application. You can think of Advices as Spring interceptors or Servlet Filters.
Pointcut: Pointcut are regular expressions that is matched with join points to determine whether advice needs to be executed or not. Pointcut uses different kinds of expressions that are matched with the join points. Spring framework uses the AspectJ pointcut expression language for determining the join points where advice methods will be applied.
Join Point: A join point is the specific point in the application such as method execution, exception handling, changing object variable values etc. In Spring AOP a join points is always the execution of a method.
Advice Arguments: We can pass arguments in the advice methods. We can use args() expression in the pointcut to be applied to any method that matches the argument pattern. If we use this, then we need to use the same name in the advice method from where argument type is determined.
These concepts seems confusing at first, but if you go through Spring Aspect, Advice Example then you can easily relate to them.
#### 9.	What is the difference between Spring AOP and AspectJ AOP?
AspectJ is the industry-standard implementation for Aspect Oriented Programming whereas Spring implements AOP for some cases. Main differences between Spring AOP and AspectJ are:
o	Spring AOP is simpler to use than AspectJ because we don’t need to worry about the weaving process.
o	Spring AOP supports AspectJ annotations, so if you are familiar with AspectJ then working with Spring AOP is easier.
o	Spring AOP supports only proxy-based AOP, so it can be applied only to method execution join points. AspectJ support all kinds of pointcuts.
o	One of the shortcoming of Spring AOP is that it can be applied only to the beans created through Spring Context.
#### 10.	What is Spring IoC Container?
Inversion of Control (IoC) is the mechanism to achieve loose-coupling between Objects dependencies. To achieve loose coupling and dynamic binding of the objects at runtime, the objects define their dependencies that are being injected by other assembler objects. Spring IoC container is the program that injects dependencies into an object and make it ready for our use.
Spring Framework IoC container classes are part of org.springframework.beans and org.springframework.context packages and provides us different ways to decouple the object dependencies.
Some of the useful ApplicationContext implementations that we use are;
o	AnnotationConfigApplicationContext: For standalone java applications using annotations based configuration.
o	ClassPathXmlApplicationContext: For standalone java applications using XML based configuration.
o	FileSystemXmlApplicationContext: Similar to ClassPathXmlApplicationContext except that the xml configuration file can be loaded from anywhere in the file system.
o	AnnotationConfigWebApplicationContext and XmlWebApplicationContext for web applications.
#### 11.	What is a Spring Bean?
Any normal java class that is initialized by Spring IoC container is called Spring Bean. We use Spring ApplicationContext to get the Spring Bean instance.
Spring IoC container manages the life cycle of Spring Bean, bean scopes and injecting any required dependencies in the bean.
#### 12.	What is the importance of Spring bean configuration file?
We use Spring Bean configuration file to define all the beans that will be initialized by Spring Context. When we create the instance of Spring ApplicationContext, it reads the spring bean xml file and initialize all of them. Once the context is initialized, we can use it to get different bean instances.
Apart from Spring Bean configuration, this file also contains spring MVC interceptors, view resolvers and other elements to support annotations based configurations.
#### 13.	What are different ways to configure a class as Spring Bean?
There are three different ways to configure Spring Bean.
1.	XML Configuration: This is the most popular configuration and we can use bean element in context file to configure a Spring Bean. For example:
<bean name="myBean" class="com.journaldev.spring.beans.MyBean"></bean>
2.	Java Based Configuration: If you are using only annotations, you can configure a Spring bean using @Bean annotation. This annotation is used with @Configuration classes to configure a spring bean. Sample configuration is:
3.	@Configuration
4.	@ComponentScan(value="com.journaldev.spring.main")
5.	public class MyConfiguration {
6.	
7.		@Bean
8.		public MyService getService(){
9.			return new MyService();
10.		}
}
To get this bean from spring context, we need to use following code snippet:
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
		MyConfiguration.class);
MyService service = ctx.getBean(MyService.class);
11.	Annotation Based Configuration: We can also use @Component, @Service, @Repository and @Controller annotations with classes to configure them to be as spring bean. For these, we would need to provide base package location to scan for these classes. For example:
<context:component-scan base-package="com.journaldev.spring" />
#### 14.	What are different scopes of Spring Bean?
There are five scopes defined for Spring Beans.
0.	singleton: Only one instance of the bean will be created for each container. This is the default scope for the spring beans. While using this scope, make sure spring bean doesn’t have shared instance variables otherwise it might lead to data inconsistency issues because it’s not thread-safe.
1.	prototype: A new instance will be created every time the bean is requested.
2.	request: This is same as prototype scope, however it’s meant to be used for web applications. A new instance of the bean will be created for each HTTP request.
3.	session: A new bean will be created for each HTTP session by the container.
4.	global-session: This is used to create global session beans for Portlet applications.
Spring Framework is extendable and we can create our own scopes too, however most of the times we are good with the scopes provided by the framework.
To set spring bean scopes we can use “scope” attribute in bean element or @Scope annotation for annotation based configurations.
#### 15.	What is Spring Bean life cycle?
Spring Beans are initialized by Spring Container and all the dependencies are also injected. When context is destroyed, it also destroys all the initialized beans. This works well in most of the cases but sometimes we want to initialize other resources or do some validation before making our beans ready to use. Spring framework provides support for post-initialization and pre-destroy methods in spring beans.
We can do this by two ways – by implementing InitializingBean and DisposableBean interfaces or using init-method and destroy-method attribute in spring bean configurations. For more details, please read Spring Bean Life Cycle Methods.
#### 16.	How to get ServletContext and ServletConfig object in a Spring Bean?
There are two ways to get Container specific objects in the spring bean.
0.	Implementing Spring *Aware interfaces, for these ServletContextAware and ServletConfigAware interfaces, for complete example of these aware interfaces, please read Spring Aware Interfaces
1.	Using @Autowired annotation with bean variable of type ServletContext and ServletConfig. They will work only in servlet container specific environment only though.
2.	@Autowired
ServletContext servletContext;
#### 17.	What is Bean wiring and @Autowired annotation?
The process of injection spring bean dependencies while initializing it called Spring Bean Wiring.
Usually it’s best practice to do the explicit wiring of all the bean dependencies, but spring framework also supports autowiring. We can use @Autowired annotation with fields or methods for autowiring byType. For this annotation to work, we also need to enable annotation based configuration in spring bean configuration file. This can be done by context:annotation-config element.
For more details about @Autowired annotation, please read Spring Autowire Example.
#### 18.	What are different types of Spring Bean autowiring?
There are four types of autowiring in Spring framework.
0.	autowire byName
1.	autowire byType
2.	autowire by constructor
3.	autowiring by @Autowired and @Qualifier annotations
Prior to Spring 3.1, autowire by autodetect was also supported that was similar to autowire by constructor or byType. For more details about these options, please read Spring Bean Autowiring.
#### 19.	Does Spring Bean provide thread safety?
The default scope of Spring bean is singleton, so there will be only one instance per context. That means that all the having a class level variable that any thread can update will lead to inconsistent data. Hence in default mode spring beans are not thread-safe.
However we can change spring bean scope to request, prototype or session to achieve thread-safety at the cost of performance. It’s a design decision and based on the project requirements.
#### 20.	What is a Controller in Spring MVC?
Just like MVC design pattern, Controller is the class that takes care of all the client requests and send them to the configured resources to handle it. In Spring MVC, org.springframework.web.servlet.DispatcherServlet is the front controller class that initializes the context based on the spring beans configurations.
A Controller class is responsible to handle different kind of client requests based on the request mappings. We can create a controller class by using @Controller annotation. Usually it’s used with @RequestMapping annotation to define handler methods for specific URI mapping.
#### 21.	What’s the difference between @Component, @Controller, @Repository & @Service annotations in Spring?
@Component is used to indicate that a class is a component. These classes are used for auto detection and configured as bean, when annotation based configurations are used.
@Controller is a specific type of component, used in MVC applications and mostly used with RequestMapping annotation.
@Repository annotation is used to indicate that a component is used as repository and a mechanism to store/retrieve/search data. We can apply this annotation with DAO pattern implementation classes.
@Service is used to indicate that a class is a Service. Usually the business facade classes that provide some services are annotated with this.
We can use any of the above annotations for a class for auto-detection but different types are provided so that you can easily distinguish the purpose of the annotated classes.
#### 22.	What is DispatcherServlet and ContextLoaderListener?
DispatcherServlet is the front controller in the Spring MVC application and it loads the spring bean configuration file and initialize all the beans that are configured. If annotations are enabled, it also scans the packages and configure any bean annotated with @Component, @Controller, @Repository or @Service annotations.
ContextLoaderListener is the listener to start up and shut down Spring’s root WebApplicationContext. It’s important functions are to tie up the lifecycle of ApplicationContext to the lifecycle of the ServletContext and to automate the creation of ApplicationContext. We can use it to define shared beans that can be used across different spring contexts.


#### 23.	What is ViewResolver in Spring?
ViewResolver implementations are used to resolve the view pages by name. Usually we configure it in the spring bean configuration file. For example:
<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<beans:property name="prefix" value="/WEB-INF/views/" />
	<beans:property name="suffix" value=".jsp" />
</beans:bean>
InternalResourceViewResolver is one of the implementation of ViewResolver interface and we are providing the view pages directory and suffix location through the bean properties. So if a controller handler method returns “home”, view resolver will use view page located at /WEB-INF/views/home.jsp.
#### 24.	What is a MultipartResolver and when its used?
MultipartResolver interface is used for uploading files – CommonsMultipartResolver and StandardServletMultipartResolver are two implementations provided by spring framework for file uploading. By default there are no multipart resolvers configured but to use them for uploading files, all we need to define a bean named “multipartResolver” with type as MultipartResolver in spring bean configurations.
Once configured, any multipart request will be resolved by the configured MultipartResolver and pass on a wrapped HttpServletRequest. Then it’s used in the controller class to get the file and process it. For a complete example, please read Spring MVC File Upload Example.
#### 25.	How to handle exceptions in Spring MVC Framework?
Spring MVC Framework provides following ways to help us achieving robust exception handling.
0.	Controller Based – We can define exception handler methods in our controller classes. All we need is to annotate these methods with @ExceptionHandler annotation.
1.	Global Exception Handler – Exception Handling is a cross-cutting concern and Spring provides @ControllerAdvice annotation that we can use with any class to define our global exception handler.
2.	HandlerExceptionResolver implementation – For generic exceptions, most of the times we serve static pages. Spring Framework provides HandlerExceptionResolver interface that we can implement to create global exception handler. The reason behind this additional way to define global exception handler is that Spring framework also provides default implementation classes that we can define in our spring bean configuration file to get spring framework exception handling benefits.
For a complete example, please read Spring Exception Handling Example.
#### 26.	How to create ApplicationContext in a Java Program?
There are following ways to create spring context in a standalone java program.
0.	AnnotationConfigApplicationContext: If we are using Spring in standalone java applications and using annotations for Configuration, then we can use this to initialize the container and get the bean objects.
1.	ClassPathXmlApplicationContext: If we have spring bean configuration xml file in standalone application, then we can use this class to load the file and get the container object.
2.	FileSystemXmlApplicationContext: This is similar to ClassPathXmlApplicationContext except that the xml configuration file can be loaded from anywhere in the file system.
#### 27.	Can we have multiple Spring configuration files?
For Spring MVC applications, we can define multiple spring context configuration files through contextConfigLocation. This location string can consist of multiple locations separated by any number of commas and spaces. For example;
<servlet>
	<servlet-name>appServlet</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<init-param>
            <param-name>contextConfigLocation</param-name>
	    <param-value>/WEB-INF/spring/appServlet/servlet-context.xml,/WEB-INF/spring/appServlet/servlet-jdbc.xml</param-value>
	</init-param>
	<load-on-startup>1</load-on-startup>
</servlet>
We can also define multiple root level spring configurations and load it through context-param. For example;
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>/WEB-INF/spring/root-context.xml /WEB-INF/spring/root-security.xml</param-value>
</context-param>
Another option is to use import element in the context configuration file to import other configurations, for example:
<beans:import resource="spring-jdbc.xml"/>
#### 28.	What is ContextLoaderListener?
ContextLoaderListener is the listener class used to load root context and define spring bean configurations that will be visible to all other contexts. It’s configured in web.xml file as:
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>/WEB-INF/spring/root-context.xml</param-value>
</context-param>
	
<listener>
	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
#### 29.	What are the minimum configurations needed to create Spring MVC application?
For creating a simple Spring MVC application, we would need to do following tasks.
o	Add spring-context and spring-webmvc dependencies in the project.
o	Configure DispatcherServlet in the web.xml file to handle requests through spring container.
o	Spring bean configuration file to define beans, if using annotations then it has to be configured here. Also we need to configure view resolver for view pages.
o	Controller class with request mappings defined to handle the client requests.
Above steps should be enough to create a simple Spring MVC Hello World application.
#### 30.	How would you relate Spring MVC Framework to MVC architecture?
As the name suggests Spring MVC is built on top of Model-View-Controller architecture. DispatcherServlet is the Front Controller in the Spring MVC application that takes care of all the incoming requests and delegate it to different controller handler methods.
Model can be any Java Bean in the Spring Framework, just like any other MVC framework Spring provides automatic binding of form data to java beans. We can set model beans as attributes to be used in the view pages.
View Pages can be JSP, static HTMLs etc. and view resolvers are responsible for finding the correct view page. Once the view page is identified, control is given back to the DispatcherServlet controller. DispatcherServlet is responsible for rendering the view and returning the final response to the client.
#### 31.	How to achieve localization in Spring MVC applications?
Spring provides excellent support for localization or i18n through resource bundles. Basis steps needed to make our application localized are:
0.	Creating message resource bundles for different locales, such as messages_en.properties, messages_fr.properties etc.
1.	Defining messageSource bean in the spring bean configuration file of type ResourceBundleMessageSource or ReloadableResourceBundleMessageSource.
2.	For change of locale support, define localeResolver bean of type CookieLocaleResolver and configure LocaleChangeInterceptor interceptor. Example configuration can be like below:
3.	<beans:bean id="messageSource"
4.	class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
5.	<beans:property name="basename" value="classpath:messages" />
6.	<beans:property name="defaultEncoding" value="UTF-8" />
7.	</beans:bean>
8.	 
9.	<beans:bean id="localeResolver"
10.	    class="org.springframework.web.servlet.i18n.CookieLocaleResolver">
11.	    <beans:property name="defaultLocale" value="en" />
12.	    <beans:property name="cookieName" value="myAppLocaleCookie"></beans:property>
13.	    <beans:property name="cookieMaxAge" value="3600"></beans:property>
14.	</beans:bean>
15.	 
16.	<interceptors>
17.	    <beans:bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
18.	        <beans:property name="paramName" value="locale" />
19.	    </beans:bean>
</interceptors>
20.	Use spring:message element in the view pages with key names, DispatcherServlet picks the corresponding value and renders the page in corresponding locale and return as response.



#### 32.	How can we use Spring to create Restful Web Service returning JSON response?
We can use Spring Framework to create Restful web services that returns JSON data. Spring provides integration with Jackson JSON API that we can use to send JSON response in restful web service.
We would need to do following steps to configure our Spring MVC application to send JSON response:
0.	Adding Jackson JSON dependencies, if you are using Maven it can be done with following code:
1.	<!-- Jackson -->
2.	<dependency>
3.	    <groupId>com.fasterxml.jackson.core</groupId>
4.	    <artifactId>jackson-databind</artifactId>
5.	    <version>${jackson.databind-version}</version>
</dependency>
6.	Configure RequestMappingHandlerAdapter bean in the spring bean configuration file and set the messageConverters property to MappingJackson2HttpMessageConverter bean. Sample configuration will be:
7.	<!-- Configure to plugin JSON as request and response in method handler -->
8.	<beans:bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
9.	    <beans:property name="messageConverters">
10.	        <beans:list>
11.	            <beans:ref bean="jsonMessageConverter"/>
12.	        </beans:list>
13.	    </beans:property>
14.	</beans:bean>
15.	     
16.	<!-- Configure bean to convert JSON to POJO and vice versa -->
17.	<beans:bean id="jsonMessageConverter" class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
</beans:bean>
18.	In the controller handler methods, return the Object as response using @ResponseBody annotation. Sample code:
19.	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
20.	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
21.	    logger.info("Start getEmployee. ID="+empId);
22.	     
23.	    return empData.get(empId);
}
24.	You can invoke the rest service through any API, but if you want to use Spring then we can easily do it using RestTemplate class.
For a complete example, please read Spring Restful Webservice Example.
#### 33.	What are some of the important Spring annotations you have used?
Some of the Spring annotations that I have used in my project are:
o	@Controller – for controller classes in Spring MVC project.
o	@RequestMapping – for configuring URI mapping in controller handler methods. This is a very important annotation, so you should go through Spring MVC RequestMapping Annotation Examples
o	@ResponseBody – for sending Object as response, usually for sending XML or JSON data as response.
o	@PathVariable – for mapping dynamic values from the URI to handler method arguments.
o	@Autowired – for autowiring dependencies in spring beans.
o	@Qualifier – with @Autowired annotation to avoid confusion when multiple instances of bean type is present.
o	@Service – for service classes.
o	@Scope – for configuring scope of the spring bean.
o	@Configuration, @ComponentScan and @Bean – for java based configurations.
o	AspectJ annotations for configuring aspects and advices, @Aspect, @Before, @After, @Around, @Pointcut etc.
#### 34.	Can we send an Object as the response of Controller handler method?
Yes we can, using @ResponseBody annotation. This is how we send JSON or XML based response in restful web services.
#### 35.	How to upload file in Spring MVC Application?
Spring provides built-in support for uploading files through MultipartResolver interface implementations. It’s very easy to use and requires only configuration changes to get it working. Obviously we would need to write controller handler method to handle the incoming file and process it. For a complete example, please refer Spring File Upload Example.
#### 36.	How to validate form data in Spring Web MVC Framework?
Spring supports JSR-303 annotation based validations as well as provide Validator interface that we can implement to create our own custom validator. For using JSR-303 based validation, we need to annotate bean variables with the required validations.
For custom validator implementation, we need to configure it in the controller class. For a complete example, please read Spring MVC Form Validation Example.
#### 37.	What is Spring MVC Interceptor and how to use it?
Spring MVC Interceptors are like Servlet Filters and allow us to intercept client request and process it. We can intercept client request at three places – preHandle, postHandle and afterCompletion.
We can create spring interceptor by implementing HandlerInterceptor interface or by extending abstract class HandlerInterceptorAdapter.
We need to configure interceptors in the spring bean configuration file. We can define an interceptor to intercept all the client requests or we can configure it for specific URI mapping too. For a detailed example, please refer Spring MVC Interceptor Example.
#### 38.	What is Spring JdbcTemplate class and how to use it?
Spring Framework provides excellent integration with JDBC API and provides JdbcTemplate utility class that we can use to avoid bolier-plate code from our database operations logic such as Opening/Closing Connection, ResultSet, PreparedStatement etc.
For JdbcTemplate example, please refer Spring JDBC Example.
#### 39.	How to use Tomcat JNDI DataSource in Spring Web Application?
For using servlet container configured JNDI DataSource, we need to configure it in the spring bean configuration file and then inject it to spring beans as dependencies. Then we can use it with JdbcTemplate to perform database operations.
Sample configuration would be:
<beans:bean id="dbDataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
    <beans:property name="jndiName" value="java:comp/env/jdbc/MyLocalDB"/>
</beans:bean>
For complete example, please refer Spring Tomcat JNDI Example.
40.	How would you achieve Transaction Management in Spring?
Spring framework provides transaction management support through Declarative Transaction Management as well as programmatic transaction management. Declarative transaction management is most widely used because it’s easy to use and works in most of the cases.
We use annotate a method with @Transactional annotation for Declarative transaction management. We need to configure transaction manager for the DataSource in the spring bean configuration file.
<bean id="transactionManager"
    class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource" />
</bean>
#### 41.	What is Spring DAO?
Spring DAO support is provided to work with data access technologies like JDBC, Hibernate in a consistent and easy way. For example we have JdbcDaoSupport, HibernateDaoSupport, JdoDaoSupport and JpaDaoSupport for respective technologies.
Spring DAO also provides consistency in exception hierarchy and we don’t need to catch specific exceptions.
#### 42.	How to integrate Spring and Hibernate Frameworks?
We can use Spring ORM module to integrate Spring and Hibernate frameworks, if you are using Hibernate 3+ where SessionFactory provides current session, then you should avoid using HibernateTemplate or HibernateDaoSupport classes and better to use DAO pattern with dependency injection for the integration.
Also Spring ORM provides support for using Spring declarative transaction management, so you should utilize that rather than going for hibernate boiler-plate code for transaction management.
For better understanding you should go through following tutorials:
o	Spring Hibernate Integration Example
o	Spring MVC Hibernate Integration Example
43.	What is Spring Security?
Spring security framework focuses on providing both authentication and authorization in java applications. It also takes care of most of the common security vulnerabilities such as CSRF attack.
It’s very beneficial and easy to use Spring security in web applications, through the use of annotations such as @EnableWebSecurity. You should go through following posts to learn how to use Spring Security framework.
o	Spring Security in Servlet Web Application
o	Spring MVC and Spring Security Integration Example
44.	How to inject a java.util.Properties into a Spring Bean?
We need to define propertyConfigurer bean that will load the properties from the given property file. Then we can use Spring EL support to inject properties into other bean dependencies. For example;
<bean id="propertyConfigurer" 
  class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">
    <property name="location" value="/WEB-INF/application.properties" />
</bean> 

<bean class="com.journaldev.spring.EmployeeDaoImpl">
    <property name="maxReadResults" value="${results.read.max}"/>
</bean>
If you are using annotation to configure the spring bean, then you can inject property like below.
@Value("${maxReadResults}") 
private int maxReadResults;
45.	Name some of the design patterns used in Spring Framework?
Spring Framework is using a lot of design patterns, some of the common ones are:
0.	Singleton Pattern: Creating beans with default scope.
1.	Factory Pattern: Bean Factory classes
2.	Prototype Pattern: Bean scopes
3.	Adapter Pattern: Spring Web and Spring MVC
4.	Proxy Pattern: Spring Aspect Oriented Programming support
5.	Template Method Pattern: JdbcTemplate, HibernateTemplate etc
6.	Front Controller: Spring MVC DispatcherServlet
7.	Data Access Object: Spring DAO support
8.	Dependency Injection and Aspect Oriented Programming
46.	What are some of the best practices for Spring Framework?
Some of the best practices for Spring Framework are:
0.	Avoid version numbers in schema reference, to make sure we have the latest configs.
1.	Divide spring bean configurations based on their concerns such as spring-jdbc.xml, spring-security.xml.
2.	For spring beans that are used in multiple contexts in Spring MVC, create them in the root context and initialize with listener.
3.	Configure bean dependencies as much as possible, try to avoid autowiring as much as possible.
4.	For application level properties, best approach is to create a property file and read it in the spring bean configuration file.
5.	For smaller applications, annotations are useful but for larger applications annotations can become a pain. If we have all the configuration in xml files, maintaining it will be easier.
6.	Use correct annotations for components for understanding the purpose easily. For services use @Service and for DAO beans use @Repository.
7.	Spring framework has a lot of modules, use what you need. Remove all the extra dependencies that gets usually added when you create projects through Spring Tool Suite templates.
8.	If you are using Aspects, make sure to keep the join pint as narrow as possible to avoid advice on unwanted methods. Consider custom annotations that are easier to use and avoid any issues.
9.	Use dependency injection when there is actual benefit, just for the sake of loose-coupling don’t use it because it’s harder to maintain.



