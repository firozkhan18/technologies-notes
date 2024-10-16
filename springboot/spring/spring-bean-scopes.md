# Spring Bean Scopes

In the latest Spring framework (and in Spring boot), we can create beans in 6 inbuilt spring bean scopes. These scopes are:

- singleton (default scope)
- prototype
- request
- session
- application
- websocket

Out of these six scopes, the last four (request, session, application, websocket) are available only if we use a web-aware ApplicationContext. The singleton and prototype scopes are available in all types of IOC containers.

We can also define the custom bean scope for special requirements.

### 1. The Default Bean Scopes Registered with Spring
In Spring, the scope can be defined using spring bean @Scope annotation. Let’s quickly list down all six inbuilt bean scopes. These same scopes apply to the spring boot bean scope as well.

The singleton scope is the default scope.

|Scope Name	|Annotation	|Description|
|-----------|-----------|-----------|
|singleton (default)|	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)|	Single bean instance per Spring IoC container. Useful for stateless beans.|
|prototype	|@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)	|A new bean instance is created every time a bean is requested.Useful for stateful beans.|
|request	|@RequestScope	|Only a single instance will be created and available during the complete lifecycle of an HTTP request.Useful for handling request-specific data such as request parameters etc.|
|session	|@SessionScope|	Only a single instance will be created and available during the complete lifecycle of an HTTP Session.Useful for handling session-specific data such as authenticated user details, preferences, shopping cart items, etc.|
|application	|@ApplicationScope|	Only a single instance will be created and available during the complete lifecycle of ServletContext.Useful for creating beans with broader visibility than the default singleton scope.|
|websocket |	@Scope(scopeName = “websocket”,proxyMode = ScopedProxyMode.TARGET_CLASS)	|Only a single instance will be created and available during the complete lifecycle of WebSocket.Useful to manage the state of WebSocket sessions.|

### 2. Singleton Bean Scope
The singleton is the default bean scope in the spring container. It tells the container to create and manage only one bean class instance per container. This single instance is stored in a cache of such singleton beans, and all subsequent requests and references for that named bean return the cached instance.

Java Configuration:
```java
@Configuration
public class AppConfiguration {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)  //This statement is redundant
	public class BeanClass {
		System.out.println("A new BeanClass instance created");
		return new BeanClass();
	}
}
```
XML Configuration:
```xml
<!-- To specify singleton scope is redundant -->
<bean id="beanId" class="com.howtodoinjava.BeanClass" scope="singleton" />
//or
<bean id="beanId" class="com.howtodoinjava.BeanClass" />
```
We can verify the singleton behavior by creating multiple beans and checking their hashcode. Everytime the bean creation code is executed, the same hashcode will be printed.
```java
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
ctx.register(AppConfiguration .class);
ctx.refresh();

BeanClass instance1 = ctx.getBean(BeanClass.class);
System.out.println(instance1.hashCode());

BeanClass instance2 = ctx.getBean(BeanClass.class);
System.out.println(instance2.hashCode());

ctx.close();
```
The program output.

A new BeanClass instance created

324234234
324234234

### 3. Prototype Bean Scope
The prototype scope results in the creation of a new bean instance every time a request for the bean is made by the application code.

In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean. We should know that destruction bean lifecycle methods are not called prototype scoped beans; only initialization callback methods are called. So as a developer, we are responsible for cleaning up prototype-scoped bean instances and any resources they hold using the bean post-processor methods.

Java Configuration:
```java
@Bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  
public class BeanClass {
	System.out.println("A new BeanClass instance created");
	return new BeanClass();
}
```
XML Configuration:
```xml
<bean id="beanId" class="com.howtodoinjava.BeanClass" scope="prototype" />
```
Now if run the previous example code again, we will see that the bean was created twice with different hashcode values.

A new BeanClass instance created
A new BeanClass instance created

324234234
756757767

A common question is that when to use singleton and prototype scope in Spring? As a rule, we should use the prototype scope for all stateful beans and the singleton scope for stateless beans.

### 4. Other Scopes: Web-aware Scopes
The remaining four scopes i.e. request, session, application and websocket are only available in web applications. In the case of non-web applications, an IllegalStateException is thrown with a message for an unknown bean scope.

#### 4.1. Request Scope
In request scope, container creates a new instance for each and every HTTP request. So, if the server is currently handling 50 requests, then the container can have at most 50 individual instances of the bean class. Any state change to one instance, will not be visible to other instances. A bean instance is destructed as soon as the request is completed.

The @RequestScope annotation works as a shortcut for @Scope(“request”) declaration.

Java Configuration:
```java
@Bean
@Scope(value =
       WebApplicationContext.SCOPE_REQUEST,
       proxyMode = ScopedProxyMode.TARGET_CLASS)  
public class BeanClass {
	System.out.println("A new BeanClass instance created for current request");
	return new BeanClass();
}
 
//or
 
@Component
@RequestScope
public class BeanClass {
}
```
We need a proxyMode attribute because when web-aware context is instantiated, we don’t have any HTTP request. Therefore, Spring injects the proxy as a dependency and instantiate the bean when HTTP request is invoked. OR, in short we can annotate with @RequestScope, a shortcut for above.

The same is applicable for the other web-aware scopes i.e. session scope, application scope, and websocket scope.

XML Configuration:
```xml
<bean id="beanId" class="com.howtodoinjava.BeanClass" scope="request" />
```
#### 4.2. Session Scope
In session scope, the application context creates a new instance for each and every HTTP session. So, if the server has 20 active sessions, then the container can have at most 20 individual instances of the bean class. All HTTP requests within a single session lifetime will have access to the same single bean instance in that session scope.

Any state change to one instance will not be visible to other instances. An instance is destructed as soon as the session ends. The @SessionScope annotation works as a shortcut for @Scope(“session”) declaration.

Java Configuration:
```java
@Bean
@Scope(value =
     WebApplicationContext.SCOPE_SESSION,
     proxyMode = ScopedProxyMode.TARGET_CLASS)  
public class BeanClass {
	System.out.println("A new BeanClass instance created for current request");
	return new BeanClass();
}
 
//or
 
@Component
@SessionScope
public class BeanClass {
}
```
XML Configuration:
```xml
<bean id="beanId" class="com.howtodoinjava.BeanClass" scope="session" />
```
#### 4.3. Application Scope
In application scope, the container creates one instance per web application runtime. It is almost similar to singleton scope with only two differences i.e.

The application scoped bean is singleton per ServletContext, whereas singleton scoped bean is singleton per ApplicationContext. Please note that there can be multiple application contexts within a single application.
The application scoped bean is visible as a ServletContext attribute.
The @ApplicationScope annotation works as a shortcut for @Scope(“application”) declaration.

Java Configuration:
```java
@Bean
@Scope(value =
     WebApplicationContext.SCOPE_APPLICATION,
     proxyMode = ScopedProxyMode.TARGET_CLASS)  
public class BeanClass {
	System.out.println("A new BeanClass instance created for current request");
	return new BeanClass();
}
 
//or
 
@Component
@ApplicationScope
public class BeanClass {
}
````
XML Configuration:
```xml
<bean id="beanId" class="com.howtodoinjava.BeanClass" scope="application" />
```
#### 4.4. WebSocket Scope
The WebSocket Protocol enables two-way communication between a client and a remote host that has opted-in to communicate with the client. WebSocket Protocol provides a single TCP connection for traffic in both directions. This is especially useful for multi-user applications with simultaneous editing and multi-user games.

In this type of web application, HTTP is used only for the initial handshake. The server can respond with HTTP status 101 (switching protocols) if it agrees – to the handshake request. If the handshake succeeds, the TCP socket remains open, and both the client and server can use it to send messages to each other.

When first accessed, WebSocket scoped beans are stored in the WebSocket session attributes. The same bean instance is then returned during the entire WebSocket session.

Please note that websocket scoped beans are typically singleton and live longer than any individual WebSocket session.

Java Configuration:
```java
@Component
@Scope(scopeName = "websocket",
      proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BeanClass {
}
```
XML Configuration:
```xml
<bean id="beanId" class="com.howtodoinjava.BeanClass" scope="websocket" />
```
#### 5. Custom Thread Scope
Spring also provides a non-default thread scope using class SimpleThreadScope. Every request for a bean in thread scope will return the same instance within the same thread.

The thread-scoped beans do not clean up any objects associated with them. For this reason, using the request scope instead of the thread scope is recommended as it invokes the destruction callback methods automatically.

To use Thread scope, we must register it with the bean factory as follows:
```java
Scope threadScope = new SimpleThreadScope();
beanFactory.registerScope("thread", threadScope);
```
Now we can use the thread scope similar to other scopes discussed above.

Java Configuration:
```java
@Component
@Scope("websocket")
public class BeanClass {
}
```
XML Configuration:
```xml
<bean id="beanId" class="com.howtodoinjava.BeanClass" scope="websocket" />
```
