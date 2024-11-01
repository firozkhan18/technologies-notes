Sure! Here’s the translation:

# Interview Questions for Java Developer

+ [OOP](#OOP) ![icon][done]
+ [Java Core](#java-core) ![icon][done]
+ [Java Collections Framework](#java-collections) ![icon][done]
+ [Java 8](#java-8) ![icon][done]
+ [Input-Output Streams in Java](#input-output-streams-in-java) ![icon][done]
+ [Serialization](#serialization) ![icon][done]
+ [Multithreading](#multithreading) ![icon][done]
+ [Servlets, JSP, JSTL](#servlets-jsp-jstl) ![icon][done]
+ [Databases](#databases) ![icon][done]
+ [SQL](#sql) ![icon][done]
+ [JDBC](#jdbc) ![icon][done]
+ [Testing](#testing) ![icon][done]
+ [Logging](#logging) ![icon][done]
+ [UML](#uml) ![icon][done]
+ [XML](#xml) ![icon][done]
+ [Design Patterns](#design-patterns) ![icon][done]
+ [Basics of HTML](#basics-of-html) ![icon][done]
+ [Basics of CSS](#basics-of-css) ![icon][done]
+ [Basics of Web](#basics-of-web) ![icon][done]
+ [Additional Materials](#additional-materials) ![icon][done]

[done]:done.png

## OOP
+ [What is _OOP_?](oop.md#What-is-OOP)
+ [Name the main principles of _OOP_.](oop.md#Name-the-main-principles-of-OOP)
+ [What is _“encapsulation”?](oop.md#What-is-encapsulation)
+ [What is _“inheritance”?](oop.md#What-is-inheritance)
+ [What is _“polymorphism”?](oop.md#What-is-polymorphism)
+ [What is _“abstraction”?](oop.md#What-is-abstraction)
+ [What does _“message passing”_ represent?](oop.md#What-does-message-passing-represent)
+ [Tell us about the main concepts of OOP: _“class”_, _“object”_, _“interface”_.](oop.md#Tell-us-about-the-main-concepts-of-OOP-class-object-interface)
+ [What are the advantages and disadvantages of the object-oriented approach in programming?](oop.md#What-are-the-advantages-and-disadvantages-of-the-object-oriented-approach-in-programming)
+ [What do the terms _“is a”_ and _“has a”_ imply in terms of OOP principles?](oop.md#What-do-the-terms-is-a-and-has-a-imply-in-terms-of-OOP-principles)
+ [What is the difference between _composition_ and _aggregation_?](oop.md#What-is-the-difference-between-composition-and-aggregation)
+ [What is _static_ and _dynamic binding_?](oop.md#What-is-static-and-dynamic-binding)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Java Core
+ [What is the difference between JRE, JVM, and JDK?](core.md#What-is-the-difference-between-JRE-JVM-and-JDK)
+ [What access modifiers exist?](core.md#What-access-modifiers-exist)
+ [What does the keyword `final` indicate?](core.md#What-does-the-keyword-final-indicate)
+ [What values are variables initialized to by default?](core.md#What-values-are-variables-initialized-to-by-default)
+ [What do you know about the `main()` function?](core.md#What-do-you-know-about-the-main-function)
+ [What logical operations and operators do you know?](core.md#What-logical-operations-and-operators-do-you-know)
+ [What is the ternary conditional operator?](core.md#What-is-the-ternary-conditional-operator)
+ [What bitwise operations do you know?](core.md#What-bitwise-operations-do-you-know)
+ [Where and for what purpose is the `abstract` modifier used?](core.md#Where-and-for-what-purpose-is-the-abstract-modifier-used)
+ [Define the concept of _“interface”_. What default modifiers do interface fields and methods have?](core.md#Define-the-concept-of-interface-What-default-modifiers-do-interface-fields-and-methods-have)
+ [How does an abstract class differ from an interface? In what cases should an abstract class be used, and in what cases an interface?](core.md#How-does-an-abstract-class-differ-from-an-interface-In-what-cases-should-an-abstract-class-be-used-and-in-what-cases-an-interface)
+ [Why are methods not defined in some interfaces at all?](core.md#Why-are-methods-not-defined-in-some-interfaces-at-all)
+ [Why can’t a method in an interface be declared with the `final` modifier?](core.md#Why-can-t-a-method-in-an-interface-be-declared-with-the-final-modifier)
+ [What has a higher level of abstraction - a class, an abstract class, or an interface?](core.md#What-has-a-higher-level-of-abstraction---a-class-an-abstract-class-or-an-interface)
+ [Can an object access a `private` variable of a class? If yes, how?](core.md#Can-an-object-access-a-private-variable-of-a-class-If-yes-how)
+ [What is the order of constructor and initialization block calls considering class hierarchy?](core.md#What-is-the-order-of-constructor-and-initialization-block-calls-considering-class-hierarchy)
+ [What are initialization blocks for, and what types are there?](core.md#What-are-initialization-blocks-for-and-what-types-are-there)
+ [To which Java constructs can the `static` modifier be applied?](core.md#To-which-Java-constructs-can-the-static-modifier-be-applied)
+ [What are static initialization blocks used for in Java?](core.md#What-are-static-initialization-blocks-used-for-in-Java)
+ [What happens if an exception occurs in an initialization block?](core.md#What-happens-if-an-exception-occurs-in-an-initialization-block)
+ [What exception is thrown when an error occurs in a class initialization block?](core.md#What-exception-is-thrown-when-an-error-occurs-in-a-class-initialization-block)
+ [Can a static method be overridden or overloaded?](core.md#Can-a-static-method-be-overridden-or-overloaded)
+ [Can non-static methods overload static ones?](core.md#Can-non-static-methods-overload-static-ones)
+ [Can the access level/return type be narrowed when overriding a method?](core.md#Can-the-access-level-return-type-be-narrowed-when-overriding-a-method)
+ [Is it possible to change the access modifier, return type, argument type or number, argument names or order, remove, add, change the order of elements in the `throws` section when overriding a method?](core.md#Is-it-possible-to-change-the-access-modifier-return-type-argument-type-or-number-argument-names-or-order-remove-add-change-the-order-of-elements-in-the-throws-section-when-overriding-a-method)
+ [How to access overridden methods of the parent class?](core.md#How-to-access-overridden-methods-of-the-parent-class)
+ [Can a method be declared both abstract and static at the same time?](core.md#Can-a-method-be-declared-both-abstract-and-static-at-the-same-time)
+ [What is the difference between an instance member of a class and a static member of a class?](core.md#What-is-the-difference-between-an-instance-member-of-a-class-and-a-static-member-of-a-class)
+ [Where is the initialization of static/non-static fields allowed?](core.md#Where-is-the-initialization-of-static-non-static-fields-allowed)
+ [What types of classes exist in Java?](core.md#What-types-of-classes-exist-in-Java)
+ [Tell us about nested classes. In what cases are they used?](core.md#Tell-us-about-nested-classes-In-what-cases-are-they-used)
+ [What is a _“static class”?](core.md#What-is-a-static-class)
+ [What features exist in the use of nested classes: static and inner? What is the difference between them?](core.md#What-features-exist-in-the-use-of-nested-classes-static-and-inner-What-is-the-difference-between-them)
+ [What is a _“local class”? What are its features?](core.md#What-is-a-local-class-What-are-its-features)
+ [What are _“anonymous classes”? Where are they used?](core.md#What-are-anonymous-classes-Where-are-they-used)
+ [How can a nested class access a field of the outer class?](core.md#How-can-a-nested-class-access-a-field-of-the-outer-class)
+ [What is the `assert` operator used for?](core.md#What-is-the-assert-operator-used-for)
+ [What is a garbage collector?](core.md#What-is-a-garbage-collector)
+ [How does a garbage

 collector work?](core.md#How-does-a-garbage-collector-work)
+ [What methods of the `Object` class do you know?](core.md#What-methods-of-the-Object-class-do-you-know)
+ [What is the difference between `==` and `.equals()`?](core.md#What-is-the-difference-between-==-and-equals)
+ [What does the `hashCode()` method return?](core.md#What-does-the-hashCode-method-return)
+ [What is a _“wrapper class”?](core.md#What-is-a-wrapper-class)
+ [What is the difference between primitive data types and reference types?](core.md#What-is-the-difference-between-primitive-data-types-and-reference-types)
+ [What does the keyword `volatile` indicate?](core.md#What-does-the-keyword-volatile-indicate)
+ [What is the difference between _“checked”_ and _“unchecked”_ exceptions?](core.md#What-is-the-difference-between-checked-and-unchecked-exceptions)
+ [When should you use exceptions?](core.md#When-should-you-use-exceptions)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Java Collections Framework
+ [What is the Java Collections Framework?](collections.md#What-is-the-Java-Collections-Framework)
+ [What interfaces are included in the Java Collections Framework?](collections.md#What-interfaces-are-included-in-the-Java-Collections-Framework)
+ [What is the difference between _List_, _Set_, and _Map_?](collections.md#What-is-the-difference-between-List-Set-and-Map)
+ [What are the main implementations of the _List_ interface?](collections.md#What-are-the-main-implementations-of-the-List-interface)
+ [What are the main implementations of the _Set_ interface?](collections.md#What-are-the-main-implementations-of-the-Set-interface)
+ [What are the main implementations of the _Map_ interface?](collections.md#What-are-the-main-implementations-of-the-Map-interface)
+ [What does the _Iterator_ interface represent?](collections.md#What-does-the-Iterator-interface-represent)
+ [What are _Collections_ and _Arrays_ in Java?](collections.md#What-are-Collections-and-Arrays-in-Java)
+ [What is a _Collection_?](collections.md#What-is-a-Collection)
+ [What is a _List_?](collections.md#What-is-a-List)
+ [What is a _Set_?](collections.md#What-is-a-Set)
+ [What is a _Map_?](collections.md#What-is-a-Map)
+ [What is the difference between _List_ and _Set_?](collections.md#What-is-the-difference-between-List-and-Set)
+ [What is the difference between _Set_ and _Map_?](collections.md#What-is-the-difference-between-Set-and-Map)
+ [What is the difference between _ArrayList_ and _LinkedList_?](collections.md#What-is-the-difference-between-ArrayList-and-LinkedList)
+ [What is the difference between _HashMap_ and _TreeMap_?](collections.md#What-is-the-difference-between-HashMap-and-TreeMap)
+ [What is the difference between _HashSet_ and _TreeSet_?](collections.md#What-is-the-difference-between-HashSet-and-TreeSet)
+ [What is the purpose of the _Collections_ utility class?](collections.md#What-is-the-purpose-of-the-Collections-utility-class)
+ [How do you sort a collection in Java?](collections.md#How-do-you-sort-a-collection-in-Java)
+ [What methods are provided in the _List_ interface?](collections.md#What-methods-are-provided-in-the-List-interface)
+ [What methods are provided in the _Set_ interface?](collections.md#What-methods-are-provided-in-the-Set-interface)
+ [What methods are provided in the _Map_ interface?](collections.md#What-methods-are-provided-in-the-Map-interface)
+ [How do you convert a _List_ to a _Set_?](collections.md#How-do-you-convert-a-List-to-a-Set)
+ [How do you convert a _Set_ to a _List_?](collections.md#How-do-you-convert-a-Set-to-a-List)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Java 8
+ [What is new in Java 8?](java8.md#What-is-new-in-Java-8)
+ [What are _lambda expressions_?](java8.md#What-are-lambda-expressions)
+ [What is the _Stream API_?](java8.md#What-is-the-Stream-API)
+ [What is _functional programming_ in Java?](java8.md#What-is-functional-programming-in-Java)
+ [What is the _Optional_ class?](java8.md#What-is-the-Optional-class)
+ [What is the difference between _Stream_ and _Collection_?](java8.md#What-is-the-difference-between-Stream-and-Collection)
+ [How can you filter data using the _Stream API_?](java8.md#How-can-you-filter-data-using-the-Stream-API)
+ [What is a _default method_ in Java 8?](java8.md#What-is-a-default-method-in-Java-8)
+ [What is the _@FunctionalInterface_ annotation?](java8.md#What-is-the-FunctionalInterface-annotation)
+ [How does _method reference_ work?](java8.md#How-does-method-reference-work)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Input-Output Streams in Java
+ [What are streams in Java?](io.md#What-are-streams-in-Java)
+ [What is the difference between byte streams and character streams?](io.md#What-is-the-difference-between-byte-streams-and-character-streams)
+ [How do you read data from a file in Java?](io.md#How-do-you-read-data-from-a-file-in-Java)
+ [How do you write data to a file in Java?](io.md#How-do-you-write-data-to-a-file-in-Java)
+ [What are the advantages of using buffers in I/O operations?](io.md#What-are-the-advantages-of-using-buffers-in-IO-operations)
+ [What are _BufferedInputStream_ and _BufferedOutputStream_?](io.md#What-are-BufferedInputStream-and-BufferedOutputStream)
+ [What are _ObjectInputStream_ and _ObjectOutputStream_?](io.md#What-are-ObjectInputStream-and-ObjectOutputStream)
+ [What is _FileReader_ and _FileWriter_?](io.md#What-is-FileReader-and-FileWriter)
+ [What is _PrintWriter_?](io.md#What-is-PrintWriter)
+ [What exceptions can be thrown when working with streams?](io.md#What-exceptions-can-be-thrown-when-working-with-streams)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Serialization
+ [What is _serialization_ in Java?](serialization.md#What-is-serialization-in-Java)
+ [What is the difference between _serialization_ and _deserialization_?](serialization.md#What-is-the-difference-between-serialization-and-deserialization)
+ [What does the `Serializable` interface do?](serialization.md#What-does-the-Serializable-interface-do)
+ [What are the possible methods of the `Serializable` interface?](serialization.md#What-are-the-possible-methods-of-the-Serializable-interface)
+ [What is the purpose of the `transient` keyword?](serialization.md#What-is-the-purpose-of-the-transient-keyword)
+ [How to control the process of serialization?](serialization.md#How-to-control-the-process-of-serialization)
+ [What is the `serialVersionUID`? Why is it important?](serialization.md#What-is-the-serialVersionUID-Why-is-it-important)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Multithreading
+ [What is _multithreading_ in Java?](multithreading.md#What-is-multithreading-in-Java)
+ [What is the difference between _process_ and _thread_?](multithreading.md#What-is-the-difference-between-process-and-thread)
+ [What is the _Thread_ class in Java?](multithreading.md#What-is-the-Thread-class-in-Java)
+ [What are the different states of a thread?](multithreading.md#What-are-the-different-states-of-a-thread)
+ [How to create a thread in Java?](multithreading.md#How-to-create-a-thread-in-Java)
+ [What is the difference between `Runnable` and `Callable`?](multithreading.md#What-is-the-difference-between-Runnable-and-Callable)
+ [What is the purpose of the `synchronized` keyword?](multithreading.md#What-is-the-purpose-of-the-synchronized-keyword)
+ [What are the differences between `wait()`, `notify()`, and `notifyAll()`?](multithreading.md#What-are-the-differences-between-wait-notify-and-notifyAll)
+ [What is a _

deadlock_?](multithreading.md#What-is-a-deadlock)
+ [What is a _race condition_?](multithreading.md#What-is-a-race-condition)
+ [What are _locks_ in Java?](multithreading.md#What-are-locks-in-Java)
+ [What are _thread pools_?](multithreading.md#What-are-thread-pools)
+ [What is the _Executor framework_?](multithreading.md#What-is-the-Executor-framework)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Java Networking
+ [What is Java Networking?](networking.md#What-is-Java-Networking)
+ [What is a _socket_?](networking.md#What-is-a-socket)
+ [What is the difference between TCP and UDP?](networking.md#What-is-the-difference-between-TCP-and-UDP)
+ [What is the purpose of the `ServerSocket` class?](networking.md#What-is-the-purpose-of-the-ServerSocket-class)
+ [What are _URL_ and _URLConnection_?](networking.md#What-are-URL-and-URLConnection)
+ [What are the different types of networking protocols?](networking.md#What-are-the-different-types-of-networking-protocols)
+ [What is the purpose of the `InetAddress` class?](networking.md#What-is-the-purpose-of-the-InetAddress-class)
+ [How do you create a client-server application in Java?](networking.md#How-do-you-create-a-client-server-application-in-Java)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Java Database Connectivity (JDBC)
+ [What is JDBC?](jdbc.md#What-is-JDBC)
+ [What are the main components of JDBC?](jdbc.md#What-are-the-main-components-of-JDBC)
+ [What is the purpose of the `Connection` interface?](jdbc.md#What-is-the-purpose-of-the-Connection-interface)
+ [What are the different types of JDBC drivers?](jdbc.md#What-are-the-different-types-of-JDBC-drivers)
+ [How do you execute a SQL query using JDBC?](jdbc.md#How-do-you-execute-a-SQL-query-using-JDBC)
+ [What is the difference between `Statement`, `PreparedStatement`, and `CallableStatement`?](jdbc.md#What-is-the-difference-between-Statement-PreparedStatement-and-CallableStatement)
+ [What exceptions are commonly thrown when working with JDBC?](jdbc.md#What-exceptions-are-commonly-thrown-when-working-with-JDBC)
+ [How do you handle transactions in JDBC?](jdbc.md#How-do-you-handle-transactions-in-JDBC)
+ [What is connection pooling in JDBC?](jdbc.md#What-is-connection-pooling-in-JDBC)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Spring Framework
+ [What is the Spring Framework?](spring.md#What-is-the-Spring-Framework)
+ [What are the main features of the Spring Framework?](spring.md#What-are-the-main-features-of-the-Spring-Framework)
+ [What is _Dependency Injection_?](spring.md#What-is-Dependency-Injection)
+ [What is the purpose of the `@Autowired` annotation?](spring.md#What-is-the-purpose-of-the-Autowired-annotation)
+ [What is _Aspect-Oriented Programming_ (AOP)?](spring.md#What-is-Aspect-Oriented-Programming-AOP)
+ [What is the Spring IoC container?](spring.md#What-is-the-Spring-IoC-container)
+ [What is the difference between `@Component`, `@Service`, and `@Repository`?](spring.md#What-is-the-difference-between-Component-Service-and-Repository)
+ [What are _Spring Boot_ and its advantages?](spring.md#What-are-Spring-Boot-and-its-advantages)
+ [How do you handle exceptions in Spring?](spring.md#How-do-you-handle-exceptions-in-Spring)
+ [What is a _Spring bean_?](spring.md#What-is-a-Spring-bean)
+ [What is the purpose of the `@Value` annotation?](spring.md#What-is-the-purpose-of-the-Value-annotation)
+ [What is _Spring MVC_?](spring.md#What-is-Spring-MVC)
+ [What are _Spring Profiles_?](spring.md#What-are-Spring-Profiles)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Java Testing Frameworks
+ [What is the purpose of unit testing?](testing.md#What-is-the-purpose-of-unit-testing)
+ [What is JUnit?](testing.md#What-is-JUnit)
+ [What are _test cases_ and _test suites_?](testing.md#What-are-test-cases-and-test-suites)
+ [What is the difference between _mocking_ and _stubbing_?](testing.md#What-is-the-difference-between-mocking-and-stubbing)
+ [What is a _TestNG_ framework?](testing.md#What-is-a-TestNG-framework)
+ [How do you perform _data-driven testing_ in JUnit?](testing.md#How-do-you-perform-data-driven-testing-in-JUnit)
+ [What is the purpose of the `@Test` annotation in JUnit?](testing.md#What-is-the-purpose-of-the-Test-annotation-in-JUnit)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Design Patterns
+ [What are design patterns?](patterns.md#What-are-design-patterns)
+ [What is the _Singleton_ pattern?](patterns.md#What-is-the-Singleton-pattern)
+ [What is the _Factory_ pattern?](patterns.md#What-is-the-Factory-pattern)
+ [What is the _Observer_ pattern?](patterns.md#What-is-the-Observer-pattern)
+ [What is the _Strategy_ pattern?](patterns.md#What-is-the-Strategy-pattern)
+ [What is the _Decorator_ pattern?](patterns.md#What-is-the-Decorator-pattern)
+ [What is the _Adapter_ pattern?](patterns.md#What-is-the-Adapter-pattern)
+ [What is the _Builder_ pattern?](patterns.md#What-is-the-Builder-pattern)
+ [What is the _Proxy_ pattern?](patterns.md#What-is-the-Proxy-pattern)
+ [What is the _Command_ pattern?](patterns.md#What-is-the-Command-pattern)

[back to table of contents](#Interview-Questions-for-Java-Developer)

## Java Best Practices
+ [What are Java best practices?](bestpractices.md#What-are-Java-best-practices)
+ [What is the significance of code readability?](bestpractices.md#What-is-the-significance-of-code-readability)
+ [How do you handle exceptions properly in Java?](bestpractices.md#How-do-you-handle-exceptions-properly-in-Java)
+ [What are some common code smells in Java?](bestpractices.md#What-are-some-common-code-smells-in-Java)
+ [What is the purpose of code reviews?](bestpractices.md#What-is-the-purpose-of-code-reviews)
+ [What is the significance of code documentation?](bestpractices.md#What-is-the-significance-of-code-documentation)
+ [What is the purpose of using version control systems?](bestpractices.md#What-is-the-purpose-of-using-version-control-systems)

---

Feel free to ask about any specific topic or question you have in mind!
