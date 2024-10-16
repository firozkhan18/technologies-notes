# Spring Bean Lifecycle: Best Practices and Pitfalls

An important part of the Spring IoC container is that beans should be constructed in such a way that they receive notifications at certain points in their life cycle. This helps in intercepting and performing additional logic when these lifecycle events happen.

In this tutorial, we will learn about bean life cycle stages in Spring which are divided into two categories: post-initialization and pre-destruction callbacks. We will also learn to customize the bean life cycle events using XML configuration as well as Java annotation configuration.

1. What is Lifecycle of a Bean in Spring?
The lifecycle of a bean in the Spring Framework refers to the series of steps and methods that a bean goes through from its instantiation to its eventual destruction.

The lifecycle of a bean is managed by the Spring container (BeanFactory) which is responsible for creating, configuring, and destroying beans according to the defined bean scope (singleton, prototype, etc.). It follows the series of steps as described in the below image, in sequence.

Spring Bean Life Cycle
Spring Bean Life Cycle
As part of the bean lifecycle, the container may also be required to perform some pre-and-post initialization steps to get the bean into a usable state.

Similarly, when the bean is no longer required, it will be removed from the IoC container. Like the initialization phase, the Spring framework may need to perform pre-and-post destruction steps to free the other system resources.

2. Bean Lifecycle Callback Methods
To execute some custom code, the bean factory allows to execute the callback methods, which can be categorized broadly into two groups:

Post-initialization callback methods
Pre-destruction callback methods
In Spring, the initialization life-cycle callback methods will be called on objects regardless of bean scope, while for beans with prototype scope, the destruction life-cycle callback methods will not be called.

It’s the responsibility of the application to manage the destruction and cleanup of prototype beans, as Spring does not keep a reference to prototype beans for automatic destruction.

2.1. Post-Initialization Callbacks
Most often, but not limited to, the initialization callbacks are used to perform the dependency checks that are not possible in the constructor. There may be other usecases such as if a bean to run scheduled tasks then the initialization callback is the ideal place to start the scheduler.

The post-initialization callback method cannot accept any arguments. Although, it can return any type which Spring will ignore anyways.

We can even define all initialization mechanisms on the same bean instance. It is allowed in Spring. In this case, Spring invokes the callbacks in the following order:

Method annotated with @PostConstruct
Method InitializingBean.afterPropertiesSet()
Method specified in the @Bean definition
2.2. Pre-destruction Callbacks
When the application shuts down, Spring calls the ConfigurableBeanFactory.destroySingletons() method which provides us a chance to clean up any resources that the beans might be holding open, thus allowing the application to shut down gracefully. When the destroySingletons() is called, the beans get the notifications via pre-destruction callback methods (similar to post-initialization callbacks).

The destruction callback is often used in conjunction with the initialization callback. In many cases, we create and configure a resource in the initialization callback and then release the resource in the destruction callback.

Notice the method name destroySingletons(). It hints that beans with other scopes than singleton do not have their life cycle fully managed by Spring.

As with the case of bean creation, the order of method invocations in case of multiple bean destruction callbacks is:

Method annotated with @PreDestroy
Method DisposableBean.afterPropertiesSet()
Method specified in the @Bean definition
3. Different Ways to add the Bean Lifecycle Callbacks
Spring framework provides the following ways for controlling the lifecycle events of a bean. These are broadly categorized into three categories:

Interface-based Lifecycle Management can be achieved by implementing
InitializingBean and DisposableBean interfaces
*Aware interfaces for specific behavior
Method-based Lifecycle Management is achieved by adding custom init() and destroy() methods in the bean class and declaring them in the bean configuration file.
Annotation-based Lifecycle Management is achieved by adding JSR-250 @PostConstruct and @PreDestroy annotated methods in the bean class.
Overall, the choice of which mechanism you use for receiving life-cycle notifications depends on the application requirements.

Let’s learn about each mechanism in more detail.

4. Implementing the InitializingBean and DisposableBean Interfaces
The org.springframework.beans.factory.InitializingBean interface allows a bean to perform initialization work after all necessary properties on the bean have been set by the container. The InitializingBean interface specifies a single method afterPropertiesSet() which Spring automatically calls after the bean’s properties have been set.

import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
        // Custom initialization logic
    }
}

Similarly, implementing the org.springframework.beans.factory.DisposableBean interface allows a bean to get a callback during bean destruction, such as when the application context is closed.

The DisposableBean interface specifies a single method destroy() which Spring automatically calls automatically.

DemoBean.java
import org.springframework.beans.factory.DisposableBean;

public class MyBean implements DisposableBean {

    @Override
    public void destroy() {
        // Custom destruction logic
    }
}

5. *Aware Interfaces to Add Specific Behavior
Spring offers a range of interfaces that allow the beans to indicate to the container that they require a particular infrastructure dependency. Each of these Aware interfaces will require us to implement a method to inject the dependency in the bean.

Some commonly used Aware interfaces are:

Aware interface	Method to Override	Purpose
ApplicationContextAware	setApplicationContext()	Sets the ApplicationContext that the bean runs in.
ApplicationEventPublisherAware	setApplicationEventPublisher()	Sets the ApplicationEventPublisher that the bean runs in.
BeanNameAware	setBeanName()	Sets the name of the bean in the bean factory.
LoadTimeWeaverAware	setLoadTimeWeaver()	Sets the LoadTimeWeaver of this object’s containing ApplicationContext.
MessageSourceAware	setMessageSource()	Sets the MessageSource that this bean runs in.
NotificationPublisherAware	setNotificationPublisher()	Sets the NotificationPublisher instance for the current managed resource instance.
ResourceLoaderAware	setResourceLoader()	Sets the ResourceLoader that this object runs in.
ServletContextAware	setServletContext()	Sets the ServletContext that this object runs in.
A simple Java bean definition to demonstrate how to use the ‘Aware‘ interfaces.

DemoBean.java
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DemoBean implements ApplicationContextAware {

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

	//Use the context in other bean methods
}

6. Custom init() and destroy() Methods
We can add the default init() and destroy() methods in two ways:

Local definitions applicable to a single bean
Global definitions applicable to all beans defined in whole beans context
6.1. Bean-specific Init and Destroy Methods
The local init() and destroy() methods can be configured to a specific bean as in the given XMl Configuration example.

applicationContext.xml
<beans>
	//...
	<bean id="demoBean" class="com.howtodoinjava.task.DemoBean"
	    init-method="customInit"
	    destroy-method="customDestroy"></bean>
	//...
</beans>

The same configuration can be done using Java @Bean annotation as follows;

@Configuration
public class AppConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public DemoBean demoBean() {
        return new DemoBean();
    }
}

Then the init and destroy methods can be defined in the bean as follows:

public class DemoBean {

    // Properties and methods of your bean

    // Custom initialization method
    public void customInit() {
        // Custom initialization logic
    }

    // Custom destruction method
    public void customDestroy() {
        // Custom destruction logic
    }
}

6.2. Global-scoped Init and Destroy Methods
We can define the init and destroy methods at the global level as well. The container will invoke the global init and destroy methods for all bean definitions using the attributes ‘default-init-method‘ and ‘default-destroy-method‘.

Global overrides are helpful when we have a pattern of defining common method names such as init() and destroy() for all the beans consistently. This feature helps us not to duplicate the init and destroy methods for all beans, separately.

applicationContext.xml
<beans default-init-method="customInit" default-destroy-method="customDestroy">   
	//...
	<bean id="demoBean" class="com.howtodoinjava.task.DemoBean"></bean>
	<bean id="newDemoBean" class="com.howtodoinjava.task.NewDemoBean"></bean>
	<bean id="anotherDemoBean" class="com.howtodoinjava.task.AnotherDemoBean"></bean>
	//...
</beans>

When using global init and destroy methods, all interested beans must write the customInit() and customDestroy() methods in the class definition as in the below example.

DemoBean.java
public class DemoBean {

	public void customInit() {
		System.out.println("Method customInit() invoked...");
	}

	public void customDestroy()	{
		System.out.println("Method customDestroy() invoked...");
	}
}

7. @PostConstruct and @PreDestroy Annotations
From Spring 2.5 onwards, we can use the @PostConstruct and @PreDestroy annotations for specifying the bean life cycle methods.

@PostConstruct annotated method will be invoked after the bean has been constructed using the default constructor and just before its instance is returned to the requesting object.
@PreDestroy annotated method is invoked just before the bean is about to be destroyed inside the bean container.
Java program to show usage of annotation configuration to control using annotations.

DemoBean.java
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class DemoBean {

  @PostConstruct
  public void customInit()
  {
    System.out.println("Method customInit() invoked...");
  }

  @PreDestroy
  public void customDestroy()
  {
    System.out.println("Method customDestroy() invoked...");
  }
}

8. Registering a Shutdown Hook is Necessary
When we run the demo programs listed above, we expect the program to print the messages written in post-init and pre-destroy callback methods. Let’s try it.

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {

    var applicationContext = new AnnotationConfigApplicationContext(Config.class);
  }
}

The program output prints only the init method message. The destroy callback method message is not printed.

Method customInit() invoked...

This is because that to call the pre-destry callbacks, we must call the applicationContext.close() method before the application is closed. But when an application can be closed/stopped/killed in several ways then it becomes harder to place the above statement.

Fortunately, there is a solution. Java allows to register a shutdown hook which is a thread that is executed just before the application shuts down.

To take advantage of this mechanism, we must invoke the AbstractApplicationContext’s registerShutdownHook() method anytime before the application is stopped. Let’s try this in our demo program.

var applicationContext = new AnnotationConfigApplicationContext(Config.class);
applicationContext.registerShutdownHook();

The program output prints both messages this time. This is te expected behavior.

Method customInit() invoked...
Method customDestroy() invoked...

9. Conclusion
