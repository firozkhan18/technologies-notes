Sure! Here’s a concise Java Object-Oriented Programming (OOP) cheat sheet:

### Java Object-Oriented Programming Cheat Sheet

Java is an Object-Oriented language as it is modeled and organized around objects rather than actions; and data rather than logic. It simplifies software development and maintenance by providing some very intriguing features. Object-Oriented Programming in Java aims to implement real-world entities such as objects, classes, abstraction, inheritance, polymorphism, and many more.

#### Classes & Objects
- **Class**: A class in Java is a blueprint which includes all your data. A class contains fields (variables) and methods to describe the behavior of an object.

  ```java
  class Test {
      // member variables  // class body
      // methods
  }
  ```

- **Object**: An object is a major element in a class which has a state and behavior. It is an instance of a class which can access your data. The ‘new’ keyword is used to create the object.
  An instance of a class created using the `new` keyword.
  
  ```java
  //Declaring and Initializing an object
  Test t = new Test();
  ```

#### Constructors

A constructor is a block of code that initializes a newly created object. It is similar to a method in Java but doesn’t have any return type and its name is the same as the class name. There are 3 types of constructors:

- Default Constructor (No-Argument Constructor)
- Parameterized Constructor

- **Default Constructor**: This constructor is created by default by the java compiler at the time of class creation if no other constructor is declared in the class. Sometimes its also called no-argument constructor as it doesn’t contain any parameters.

No parameters, created by the compiler if none are defined.

  ```java
  class Test {
      public Test() { }
  }
  ```
- **Parameterized Constructor**: This constructor is called parameterized as it contains one or more parameters. It is used to provide different values to the distinct objects at the time of their creation.

Accepts parameters to initialize objects.

  ```java
  public class Test {
      int appId; 
      String appName;  
      Test(int id, String name) {
          this.appId = id;
          this.appName = name; 
      }
  }
  ```
  ```
  public class Test {
   int appId; 
   String appName;  
   //parameterized constructor with two parameters
   Test(int id, String name) {
      this.appId = id;
      this.appName = name; 
  } 
  void info() {
   System.out.println("Id: "+appId+" Name: "+appName);
  }
  public static void main(String args[]){ 
   Test obj1 = new Test(11001,"Facebook"); 
   Test obj2 = new Test(23003,"Instagram"); 
   obj1.info(); 
   obj2.info(); 
   }
  }
```

#### Modifiers

- **Access Modifiers**: Java access modifiers specify the scope of accessibility of a data member, method, constructor or class.
                        Control visibility (e.g., `public`, `private`, `protected`).
- **Non-Access Modifiers**: The non-access modifiers in Java, do not change the accessibility of variables and methods rather they provide special properties.
                            These modifiers can alter the behavior of elements as well.
                            Provide additional properties (e.g., `static`, `final`, `abstract`).

#### Inheritance

Inheritance is the property of a child/derived/subclass which allows it to inherit the properties(data members) and functionalities(methods) from its parent/base/superclass.

All objects have the Object class as their top parent.
Methods can be overridden but attributes can not.
To call a parent class constructor, super() is used.
Java supports 5 types of inheritance:

- **Types**:
  - **Single**: One parent. A class inherits the properties of a single parent class.
  - **Multi-Level**: Chain of classes. In multi-level inheritance, one class has more than one parent class but at different levels of inheritance
  - **Hierarchical**: One parent, multiple children. In hierarchical inheritance, one parent can have one or more child/sub/derived classes.
  - **Hybrid**: Combination of types. Hybrid Inheritance is the combination of more than one type of inheritance in a single program, for example, you can combine a multilevel inheritance with a hierarchical inheritance.
  - **Multiple**: Not supported directly (use interfaces). Multiple inheritance is not supported in Java as it leads to the diamond problem. The diamond problem is an ambiguity where the compiler doesn’t know which superclass method to execute in case the superclasses has a method with the same name.
 
```java
class A { }
class B extends A { }
class C extends B { }  // Multi-level
```
** But multiple inheritance in Java can be achieved using interfaces.

#### Polymorphism

Polymorphism is the ability of a variable, function or an object to take multiple forms. It allows you to define one interface or method and have multiple implementations. There are two types of polymorphism in Java.

- **Compile-Time**: Achieved via method overloading. Also called static binding, as the type of the object is determined at the compile time by the compiler itself.

  Example: Method Overloading
  
  ```java
  class Calculator {
      static int add(int a, int b) { return a + b; }
      static double add(double a, double b) { return a + b; }
  }
  ```

  ```java
  class Calculator {
    static int add(int a, int b){
      return a+b;
    }
    static double add( double a, double b){
      return a+b;
    }
    public static void main(String args[]){
      System.out.println(Calculator.add(123,17));
      System.out.println(Calculator.add(18.3,1.9));
    }
  }
```
- **Runtime**: Achieved via method overriding. Also called dynamic binding as the overridden method is resolved at runtime rather than compile-time. In this, a reference variable is used to call an overridden method of a superclass at run time. Example: Method Overriding.

  ```java
  class Mobile {
      void sms() { System.out.println("Mobile class"); }
  }
  class OnePlus extends Mobile {
      void sms() { System.out.println("OnePlus class"); }
  }
  ```
  ```java
    public class Mobile{
      void sms(){
        System.out.println("Mobile class");
      }
    }
    //Extending the Mobile class
    public class OnePlus extends Mobile{
      //Overriding sms() of Mobile class
      void sms(){
      System.out.println(" OnePlus class");
    }
    public static void main(String[] args)
    {
      OnePlus smsObj= new OnePlus();
      smsObj.sms();
    }
  }
 ```

#### Abstraction
- **Abstract Class**: Can have abstract and non-abstract methods.

- Ways To Achieve Abstraction
Abstraction is the process of hiding the details and showing only the necessary things to the user. You can achieve abstraction in two ways in Java:

Using Abstract Class (0–100%)
Using Interface (100%)

  ```java
  public abstract class MyAbstractClass {
      public abstract void abstractMethod();
  }
  ```
**Abstract Class** is a class which is declared with an abstract keyword and cannot be instantiated. Few pointers to create an abstract class:

- It can contain abstract and non-abstract methods.
- It can contain constructors and static methods as well.
- It can contain final methods which force the subclass not to change the body of the method.

- **Interface**: Contains abstract methods; classes implement interfaces.

An interface in java is a blueprint of a class that contains static constants and abstract methods. It represents the IS-A relation. You need to implement an interface to use its methods or constants.
  
  ```java
  public interface Bike {
      void start();
  }
  ```

  ```java

  //Creating an Interface
  public interface Bike { public void start(); }
  //Creating classes to implement Bike interface
  class Honda implements Bike{
    public void start() { System.out.println("Honda Bike"); }
  }
  class Apache implements Bike{
    public void start() { System.out.println("Apache Bike"); }
  }
  class Rider{
    public static void main(String args[]){ 
      Bike b1=new Honda(); 
      b1.start();
      Bike b2=new Apache();
      b2.start(); 
    }
  }
  ```

#### Encapsulation
- **Encapsulation**: Bundles data and methods. Encapsulation is a process of binding your data and code together as a single unit using getter and setter methods.
  - Use `private` fields and public getter/setter methods.

You need to perform two steps to achieve encapsulation:

Declare the variables of a class as private.
Provide public setter and getter methods to modify and view the values of the variables.

  ```java
  public class Artist {
      private String name;
      public String getName() { return name; }
      public void setName(String name) { this.name = name; }
  }
  ```

  ```java
  public class Artist {
    private String name;
    //getter method
    public String getName() { return name; }
    //setter method
    public void setName(String name) { this.name = name; }
  }
  public class Show{
    public static void main(String[] args){
    //creating instance of the encapsulated class
    Artist s=new Artist(); 
    //setting value in the name member 
    s.setName("V"); 
    //getting value of the name member 
    System.out.println(s.getName()); 
    }
}
  ```

#### Association, Aggregation, and Composition

- **Association**: Relationship between classes (e.g., one-to-one, one-to-many).
  
**Association** is the relation between two different classes that is established via their objects. Association can be in many forms:

- One-to-One
- One-to-Many
- Many-to-One
- Many-to-Many.

- **Aggregation**: A "has-a" relationship; both entities can exist independently.

**Aggregation** is a special form of Association which represents the Has-A relationship. It is an uni-directional Association where both the entries can survive individually.

- **Composition**: A strong "part-of" relationship; the part cannot exist without the whole.

**Composition** is a more restrictive form of aggregation that makes two entities highly dependent on each other. It represents the part-of relationship where the composed object cannot exist without the other entity.

### Key Concepts
- **Inheritance** allows reusability and the creation of hierarchical relationships.
- **Polymorphism** enables flexibility and dynamic method resolution.
- **Abstraction** simplifies code by hiding complexity.
- **Encapsulation** protects data and maintains integrity.

  Here are the answers and explanations for each code snippet you've provided:

1. **Output:**
   ```java
   String s1 = "Hello";
   String s2 = "Hello";
   System.out.println(s1 == s2);
   ```
   **Answer:** a) true  
   **Explanation:** Both `s1` and `s2` reference the same object in the String pool.

2. **Output:**
   ```java
   int x = 10;
   if (x == 10) {
       int y = 20;
       System.out.println(y);
   }
   System.out.println(y);
   ```
   **Answer:** b) 20, error  
   **Explanation:** `y` is declared within the `if` block and cannot be accessed outside of it.

3. **Output:**
   ```java
   int x = 5;
   System.out.println(x++ + ++x);
   ```
   **Answer:** c) 12  
   **Explanation:** The calculation is `5 (x++) + 7 (++x)` = 12.

4. **Output:**
   ```java
   int[] arr = {1, 2, 3};
   for (int i = 0; i < arr.length; i++) {
       System.out.print(arr[i] + " ");
       arr[i] = 0;
   }
   System.out.println();
   for (int i : arr) {
       System.out.print(i + " ");
   }
   ```
   **Answer:** a) 1 2 3, 0 0 0  
   **Explanation:** The first loop prints original values before changing them to 0, while the second loop prints the modified array.

5. **Output:**
   ```java
   int x = 10;
   switch (x) {
       case 10:
           System.out.println("x is 10");
           break;
       case 20:
           System.out.println("x is 20");
           break;
       default:
           System.out.println("x is neither 10 nor 20");
           break;
   }
   ```
   **Answer:** a) x is 10  
   **Explanation:** The value of `x` matches the first case.

6. **Output:**
   ```java
   int x = 5;
   int y = ++x + x++ + --x - x--;
   System.out.println(y);
   ```
   **Answer:** b) 10  
   **Explanation:** The operations evaluate to `6 (incremented) + 6 (post-incremented) + 5 (decremented) - 5 (post-decremented) = 10`.

7. **Output:**
   ```java
   int x = 3;
   int y = 4;
   System.out.println("x + y = " + x + y);
   ```
   **Answer:** b) x + y = 34  
   **Explanation:** The expression concatenates strings and integers, resulting in "x + y = 3" followed by "4", yielding "x + y = 34".

8. **Output:**
   ```java
   int[] arr = {1, 2, 3, 4, 5};
   System.out.println(arr[5]);
   ```
   **Answer:** c) An ArrayIndexOutOfBoundsException is thrown  
   **Explanation:** Valid indices are 0-4; accessing index 5 is out of bounds.

9. **Output:**
   ```java
   String s1 = "hello";
   String s2 = new String("hello");
   System.out.println(s1 == s2);
   ```
   **Answer:** b) false  
   **Explanation:** `s1` and `s2` are different objects, so `==` compares references and returns false.

10. **Output:**
    ```java
    for(int i=0; i<5; i++) {
        if(i==3) {
            continue;
        }
        System.out.print(i + " ");
    }
    ```
    **Answer:** b) 0 1 2 4  
    **Explanation:** The `continue` statement skips the iteration when `i` is 3, so 3 is not printed.

What is Spring Boot?
Spring Boot is a Java based spring framework, it provides Rapid application development features like auto-configuration, embedded servers, package structures.

2. Why Spring Boot over Spring?

Spring Boot provides a stand-alone application with minimal configuration.
It provides embedded tomcat, jetty servers. So we just have to write the code and run the application.
No XML configuration is required.
Provides production ready features such as health checks, actuators etc.
Provides In-memory database, version management, component scanning etc.
3. What are all the different HTTP Methods?

Here are the commonly used HTTP methods

1. GET: Retrieves a resource or data from a server.

2. POST: Submits data to be processed to a server, typically resulting in the creation of a new resource.

3. PUT: Updates or replaces an existing resource with new data.

4. DELETE: Deletes a specified resource.

5. PATCH: Partially updates an existing resource with new data.

6. HEAD: Retrieves metadata of a resource without fetching the actual content.

7. OPTIONS: Returns the allowed HTTP methods and capabilities of a server for a given resource.

4. How does Spring Boot works internally?

Spring Boot automatically configures the application based on the dependencies added during creation of the project
The entry point of the Spring boot application is the class that contains @SpringBootApplication annotation and the main method.
Spring Boot automatically scans all the components included in the project by using @ComponentScan annotation.
5. How to disable @EnableAutoConfiguration, included in @SpringBootApplication?

There are some requirements where we do not want to use some of the specific auto-configuration classes. We can disable them using specific attributes.
For this the exclude attribute of the @EnableAutoConfiguration annotation can be used.
@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class) 
  public class ApplicationConfiguration { 
     ... 
  }
6. What is the default port number of Tomcat Server in Spring Boot.
Ans: 8080 is Default port number.

7. Can we change port number of Tomcat?
Ans:- Yes, We can change port number in application.properties file.

Ex: server.port =8081

8. How does @SpringBootApplication works internally?

The @SpringBootApplication internally contains 3 other annotations — @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes.
This enables the developer to use single annotation instead of using all the 3 annotations.
Also, we know spring boot provides loosely coupled feature, we can use each annotation as per our requirement.
9. How to convert Spring Boot REST Application as Web Application?

As we know, by default spring boot provides embedded servers and makes the application production ready in terms of REST API’s
To convert REST into Web application we have to disable the embedded servers and set the configuration to false in properties files.
@SpringBootApplication(exclude = {EmbeddedServletContainerAutoConfiguration.class, 
  WebMvcAutoConfiguration.class})
  public class ApplicationConfiguration { 
     ... 
  }
And need to add the below property to non-rest applications so that spring boot does not try to start the
WebApplicationContext. This should go to the application.properties.
spring.main.web-environment=false
10. How to disable embedded tomcat server and use other servers?

Spring boot by default provides tomcat and Jetty servers, if we do not want we can exclude these default servers.
To exclude tomcat from servers, we just have to add the additional block to the Spring Boot starter dependency.
We have to add <exclusions> tags that make sure the given artifact is removed at build time.
<dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <exclusions>
          <exclusion>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-tomcat</artifactId>
          </exclusion>
      </exclusions>
  </dependency>
11.Explain @RestController annotation of Spring Boot?

The @RestController annotation is a combination of @Controller and @ResponseBody, which is used for creating a restful api’s.
It converts the response to JSON or XML.
It makes sure that data returned by each method will be written directly into the response body instead of returning a template.
12. What are Spring Profiles?

When we are developing the application in the organizations, we deal with multiple environments such as —
— dev : for development

— QA : for test environment

— Pre-Prod : for production environment

— Prod : for live or production ready

So each environment requires different configurations.
For example: we might be using an embedded H2 database for dev but for prod — we might have Oracle or DB2. Even if DBMS is the same across the environment, the URLs will be different.
To make this easy and clean, Spring has the provision of Profiles to keep the separate configuration of environments.
13. What is the difference between @RestController and @Controller in Spring Boot?

@Controller Map the model object to view or template and make it human readable.
@RestController simply returns the object and object data is directly written in HTTP response as JSON or XML.
14. Describe the flow of HTTP request through the Spring Boot Application.


Spring Boot mainly be having 4 layers
— Presentation Layer : Authentication & Json Translation

— Business Layer : Business Logic, Validation & Authorization

— Persistence Layer : Storage Logic

— Database Layer : Actual Database

When the Client makes an HTTP request through GET, PUT, POST, etc. The HTTP request is forwarded to the Controller. The controller maps the request. It processes the handles and calls the server logic, i.e service class
The business logic is performed in the Service layer. The spring boot performs all the logic over the data of the database which is mapped to the spring boot model class through Java Persistence Library(JPA)/Hibernate.
15. What is the difference between application.properties file and application.yml file?

There are the files, where we mention in which port our application should run, what are the credentials required for db is mentioned in these
15. What Are the Basic Annotations that Spring Boot Offers?
Spring Boot offers several annotations that simplify the development of Spring-based applications. Here are some of the basic annotations that Spring Boot provides:

@SpringBootApplication: This annotation is used to mark the main class of a Spring Boot application. It enables component scanning, auto-configuration, and starts the embedded web server.

@Controller: This annotation is used to mark a class as a Spring MVC controller. It handles HTTP requests and returns HTTP responses.

@RestController: This annotation is a combination of @Controller and @ResponseBody. It is used to mark a class as a RESTful controller. It handles HTTP requests and returns JSON/XML responses.

@Service: This annotation is used to mark a class as a service. It encapsulates the business logic of an application.

@Repository: This annotation is used to mark a class as a repository. It is used to interact with a database.

@Component: This annotation is the base annotation for all Spring-managed components. It is used to mark a class as a bean.

@Autowired: This annotation is used to inject dependencies into a Spring-managed bean.

@Qualifier: This annotation is used to specify which bean to inject when multiple beans of the same type are available.

@Value: This annotation is used to inject values from the properties file into a Spring-managed bean.

@Configuration: This annotation is used to mark a class as a configuration class. It provides configuration to the Spring application context.

@Profile: This annotation is used to activate/deactivate a bean based on the specified profile.

@RequestMapping: This annotation is used to map an HTTP request to a method in a controller.

@PathVariable: This annotation is used to extract a variable from the URL path.

These are some of the basic annotations that Spring Boot provides. There are many more annotations available that you can explore in the Spring documentation.

16. What is the difference between RequestMapping and GetMapping?
RequestMapping can be used with GET, POST, PUT, and many other request methods using the method attribute on the annotation. Whereas getMapping is only an extension of RequestMapping which helps you to improve on clarity on request.


Errors arise unexpectedly and can result in disrupting the normal flow of execution. This is something that every programmer faces at one point or the other while coding. Java, being the most prominent object-oriented language, provides a powerful mechanism to handle these errors/exceptions. Through this article on Java Exception Handling, I will give you a complete insight into the fundamentals and various methods of Exception Handling.

In this article, I will be covering the following topics.

Introduction to Exception Handling
Exceptions Hierarchy
Basic Exception Example
Types of Exceptions
Exception Handling Methods
final vs finally vs finalize
throw vs throws
Introduction to Exception Handling
An exception is a problem that arises during the execution of a program. It can occur for various reasons say-

A user has entered an invalid data
File not found
A network connection has been lost in the middle of communications
The JVM has run out of a memory
Exception Handling mechanism follows a flow which is depicted in the below figure. But if an exception is not handled, it may lead to a system failure. That is why handling an exception is very important.


The flow of Exception Handling — Java Exception Handling

Next, begin by understanding the Exceptions Hierarchy.

Exceptions Hierarchy
All exception and error types are subclasses of class Throwable, which is the base class of hierarchy. One branch is headed by Error which occurs at run-time and other by Exception that can happen either at compile time or run-time.


Exceptions Hierarchy — Java Exception Handling

Basically, an Error is used by the Java run-time system (JVM) to indicate errors that are associated with the run-time environment (JRE). StackOverflowError is an example of such an error. Whereas Exception is used for exceptional conditions that user programs should catch. NullPointerException is an example of such an exception.

Now that you know what errors and exceptions are, let’s find out the basic difference between them. Take a look at the below table which draws a clear line between both of them.


Now, we will dive deeper into exceptions and see how they can be handled. First, let’s see the different types of exceptions.

Checked Exception
It is an exception that occurs at compile time, also called compile time exceptions. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using throws keyword.
Unchecked Exception
It is an exception that occurs at the time of execution. These are also called Runtime Exceptions. In C++, all exceptions are unchecked, so it is not forced by the compiler to either handle or specify the exception. It is up to the programmers to specify or catch the exceptions.
Basic Example of Exception
class Exception{
public static void main(String args[]){
try{
//code that may raise exception
}
catch(Exception e){
// rest of the program
  }
 }
}
Above code represent an exception wherein inside try block we are going to write a code that may raise an exception and then, that exception will be handled in the catch block.

Types of Exceptions
Built-in Exceptions

User-Defined Exceptions
Sometimes, the built-in exceptions in Java are not able to describe a certain situation. In such cases, a user can also create exceptions which are called ‘User-Defined Exceptions’.
Key points to note:

A user-defined exception must extend Exception class.

The exception is thrown using throw keyword.

Example:

class MyException extends Exception{ 
 String str1;
 MyException(String str2) {str1=str2;}
  public String toString(){
   return ("MyException Occurred: "+str1);
 }
}
class Example1{
public static void main(String args[]){
 try{
      System.out.println("Start of try block");
      throw new MyException(“Error Message");
    }
    catch(MyException exp){System.out.println("Catch Block");
    System.out.println(exp);
 }
}
Now that you have seen the different types of exceptions, let’s dive deeper into this Java Exception Handling blog to understand various methods for handling these exceptions.

Exception Handling Methods
As I have already mentioned, handling an exception is very important, else it leads to system failure. But how do you handle these exceptions?

Java provides various methods to handle the Exceptions like:

try
catch
finally
throw
throws
Let’s understand each of these methods in detail.

try block
The try block contains a set of statements where an exception can occur. It is always followed by a catch block, which handles the exception that occurs in the associated try block. A try block must be followed by catch blocks or finally block or both.

try{
//code that may throw exception
}catch(Exception_class_Name ref){}
Nested try block
try block within a try block is known as nested try block in java.

class Exception{
  public static void main(String args[]){
    try{
      try{
          System.out.println("going to divide");
          int b=59/0;
         }catch(ArithmeticException e){System.out.println(e);}
      try{
          int a[]=new int[5];
         a[5]=4;
         }
        catch(ArrayIndexOutOfBoundsException e) {System.out.println(e);}
            System.out.println("other statement);
        }catch(Exception e)
         {System.out.println("Exception handeled");}
       System.out.println("casual flow");
    }
}
catch block
A catch block is where you handle the exceptions. This block must follow the try block and a single try block can have several catch blocks associated with it. You can catch different exceptions in different catch blocks. When an exception occurs in a try block, the corresponding catch block that handles that particular exception executes.

public class Testtrycatch1{
  public static void main(String args[]){
    int data=50/0;//may throw exception
    System.out.println("rest of the code...");
 }
}
Multi-catch block
If you have to perform various tasks at the occurrence of various exceptions, you can use the multi-catch block.

public class SampleMultipleCatchBlock{
 public static void main(String args[]){
    try{
       int a[]=new int[5];
       a[5]=30/0;
      }
      catch(ArithmeticException e)
        {System.out.println("task1 is completed");}
      catch(ArrayIndexOutOfBoundsException e)
        {System.out.println("task 2 completed");}
      catch(Exception e)
        {System.out.println("task 3 completed");}
      System.out.println("remaining code");
  }
}
finally block
A finally block contains all the crucial statements that must be executed whether an exception occurs or not. The statements present in this block will always execute, regardless an exception occurs in the try block or not such as closing a connection, stream etc.

class SampleFinallyBlock{
 public static void main(String args[]){
   try{
     int data=55/5;
     System.out.println(data);
    }
    catch(NullPointerException e)
       {System.out.println(e);} 
    finally {System.out.println("finally block is executed");}
    System.out.println("remaining code");
  }
}
So, this was all about the various methods of handling exceptions.

You might have heard that final, finally and finalize are keywords in Java. Yes, they are, but they differ from each other in various aspects. So, let’s see how final, finally and finalize are different from each other with the help of below table.

final vs finally vs finalize

Similarly, throw & throws sound alike, but they are different from each other. Let’s see how, with the help of the below table.

throw vs throws

//Java throw example
void a()
{
  throw new ArithmeticException("Incorrect");
}
//Java throws example
void a()throws ArithmeticException
{
  //method code
}
//Java throw and throws example
void a()throws ArithmeticException
{
  throw new ArithmeticException("Incorrect");
}
This brings us to the end of our blog on Exception Handling in Java. I hope you found this blog informative and added value to your knowledge.
