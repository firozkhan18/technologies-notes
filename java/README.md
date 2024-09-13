## Table of Contents
* [Why We Need Functional Programming?](#why-we-need-functional-programming)
* [Lambda Expression](#lambda-expression)
* [Functional Interface](#functional-interface)
* [Default Method](#default-method)
* [Method References](#method-references)
* [Stream](#stream)
  * [Generating streams](#generating-streams)
  * [Filter](#filter)
  * [Sorted](#sorted)
  * [Map](#map)
  * [Match](#match)
  * [Count](#count)
  * [Reduce](#reduce)
* [Optional](#optional)
* [Date](#date)
* [Java Programing Exercises](#java-programing-exercises)
* [Java Programing Question Answers](#java-programing-question-answer)

## Why We Need Functional Programming?

Java is indeed an Object-Oriented Programming (OOP) language, and its design principles emphasize the use of classes and objects to model and manage data and behavior. However, the introduction of functional programming concepts into Java, particularly with Java 8's addition of lambda expressions and the Stream API, reflects the recognition that functional programming (FP) offers distinct advantages and complements the traditional OOP approach. Here’s why integrating functional programming into Java is beneficial:

### 1. **Enhanced Expressiveness and Conciseness**

- **Simplified Code**: Functional programming often leads to more concise and expressive code. For example, using lambda expressions and the Stream API, you can perform operations on collections in a more readable and less verbose manner compared to traditional loops and iterators.

  **Example:**

  ```java
  List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
  // Using OOP style with loops
  List<String> filteredNames = new ArrayList<>();
  for (String name : names) {
      if (name.startsWith("A")) {
          filteredNames.add(name);
      }
  }

  // Using functional style with Streams
  List<String> filteredNames = names.stream()
                                     .filter(name -> name.startsWith("A"))
                                     .collect(Collectors.toList());
  ```

### 2. **Improved Readability and Maintainability**

- **Declarative Style**: Functional programming encourages a declarative style of programming, where you describe what you want to achieve rather than how to achieve it. This can make the code more readable and easier to understand, especially for complex data processing tasks.

- **Immutability**: Functional programming emphasizes immutability, which means that data is not modified after it is created. This can reduce bugs related to mutable state and make reasoning about code easier.

### 3. **Facilitating Parallelism**

- **Stream API**: The Stream API in Java 8 provides a straightforward way to perform parallel operations on collections. By simply calling `parallelStream()` on a collection, you can leverage multi-core processors to perform operations concurrently.

  **Example:**

  ```java
  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
  // Sequential processing
  List<Integer> squared = numbers.stream()
                                 .map(n -> n * n)
                                 .collect(Collectors.toList());

  // Parallel processing
  List<Integer> squaredParallel = numbers.parallelStream()
                                         .map(n -> n * n)
                                         .collect(Collectors.toList());
  ```

### 4. **Higher-Order Functions and Reusability**

- **First-Class Functions**: Functional programming treats functions as first-class citizens, meaning functions can be passed as arguments, returned from other functions, and assigned to variables. This enables higher-order functions that can enhance reusability and abstraction.

  **Example:**

  ```java
  // Higher-order function
  public static void performOperation(List<Integer> numbers, Function<Integer, Integer> operation) {
      List<Integer> results = numbers.stream()
                                     .map(operation)
                                     .collect(Collectors.toList());
      System.out.println(results);
  }

  public static void main(String[] args) {
      List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
      // Pass a lambda expression
      performOperation(numbers, n -> n * n); // Square operation
      performOperation(numbers, n -> n + 10); // Increment operation
  }
  ```

### 5. **Reduced Boilerplate Code**

- **Less Boilerplate**: Functional programming features like lambdas and method references help reduce boilerplate code, especially when dealing with anonymous classes or verbose implementations of interfaces.

  **Example:**

  ```java
  // Using anonymous class
  Runnable runnable = new Runnable() {
      @Override
      public void run() {
          System.out.println("Hello, World!");
      }
  };

  // Using lambda expression
  Runnable runnableLambda = () -> System.out.println("Hello, World!");
  ```

### 6. **Better Handling of Side Effects**

- **Pure Functions**: Functional programming encourages the use of pure functions, which have no side effects and always produce the same output for the same input. This predictability and lack of side effects help in writing reliable and testable code.

### 7. **Integration with Existing OOP Code**

- **Interoperability**: Java’s functional features are designed to integrate seamlessly with its existing OOP features. This means you can use functional programming where it fits best while continuing to use OOP principles in other parts of your application.

### Summary

Java’s move towards functional programming with features like lambda expressions, the Stream API, and functional interfaces does not replace OOP but complements it. It provides additional tools and paradigms that enhance code readability, maintainability, and performance. The combination of OOP and FP in Java allows developers to choose the best approach for different problems, leading to more flexible and robust software design.
  
## Lambda Expression
Lambda expressions are introduced in Java 8 and are touted to be the biggest feature of Java 8. Lambda expression facilitates functional programming, and simplifies the development a lot.

The Lambda expression is used to provide the implementation of an interface which has functional interface. It saves a lot of code. In case of lambda expression, we don't need to define the method again for providing the implementation. Here, we just write the implementation code.

```java
List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
});
```

Here instead of creating anonymous object, Java 8 comes with the lambda expression:

```java
Collections.sort(names, (String a, String b) -> {
    return b.compareTo(a);
});
```

[Complete Fundamental Concepts Of Java Lambda expressions](java-basic-fundamental-lambda-expressions.md)

## Functional Interface
An Interface that contains exactly one abstract method is known as functional interface. It can have any number of default, static methods but can contain only one abstract method.

Before Java 8, we had to create anonymous inner class objects or implement these interfaces.

```java
class Test 
{ 
    public static void main(String args[]) 
    { 
        // create anonymous inner class object 
        new Thread(new Runnable() 
        { 
            @Override
            public void run() 
            { 
                System.out.println("New thread created"); 
            } 
        }).start(); 
    } 
} 
```

Java 8 onwards, we can assign lambda expression to its functional interface object like this:

```java
class Test 
{ 
  public static void main(String args[]) 
  { 
  
    // lambda expression to create the object 
    new Thread(()-> 
       {System.out.println("New thread created");}).start(); 
  } 
} 
```

## Default Method
Before Java 8, interfaces could have only abstract methods. The implementation of these methods has to be provided in a separate class. So, if a new method is to be added in an interface, then its implementation code has to be provided in the class implementing the same interface. To overcome this issue, Java 8 has introduced the concept of default methods which allow the interfaces to have methods with implementation without affecting the classes that implement the interface.

```java
interface TI
{ 
    // default method 
    default void show() 
    { 
      System.out.println("Default Method"); 
    } 
} 
```

Java 8 introduced default and static methods in interfaces, providing enhanced functionality and flexibility in designing functional interfaces. Here's an overview of their use and real-time examples:

### 1. Default Methods

**Definition**: Default methods in interfaces allow you to define methods with a default implementation. This helps in extending interfaces with new methods without breaking existing implementations.

**Key Points**:
- Default methods are useful for adding new methods to interfaces with existing implementations.
- They can be overridden by implementing classes if a different behavior is needed.
- They help in providing a common behavior across multiple implementations.

**Syntax**:
```java
public interface MyInterface {
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }
}
```

**Real-Time Example**:

Consider an interface for logging that various classes might implement. You might want to provide a default logging behavior.

```java
public interface Logger {
    default void logInfo(String message) {
        System.out.println("INFO: " + message);
    }

    void logError(String message);
}

public class FileLogger implements Logger {
    @Override
    public void logError(String message) {
        System.out.println("ERROR: " + message);
    }
}

public class App {
    public static void main(String[] args) {
        Logger logger = new FileLogger();
        logger.logInfo("Application started");  // Uses default method
        logger.logError("An error occurred");    // Uses overridden method
    }
}
```

In this example, `FileLogger` implements `Logger` but does not provide an implementation for `logInfo`, so the default implementation is used.

### 2. Static Methods

**Definition**: Static methods in interfaces allow you to define utility methods that are not tied to instance data. They are called on the interface itself rather than on instances of implementing classes.

**Key Points**:
- Static methods in interfaces are similar to static methods in classes; they cannot be overridden.
- They provide utility functions related to the interface but are not tied to specific instances.

**Syntax**:
```java
public interface MyUtility {
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}
```

**Real-Time Example**:

Consider an interface that provides utility methods for mathematical operations.

```java
public interface MathUtils {
    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }
}

public class App {
    public static void main(String[] args) {
        int sum = MathUtils.add(5, 3);         // Call static method
        int difference = MathUtils.subtract(5, 3); // Call static method
        
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
    }
}
```

In this example, `MathUtils` provides static methods for addition and subtraction, which can be used without creating an instance of `MathUtils`.

### Combining Default and Static Methods

You can combine default and static methods in the same interface to provide a mix of common behavior and utility functions.

**Example**:

```java
public interface Device {
    default void powerOn() {
        System.out.println("Device is powered on.");
    }

    static void reset() {
        System.out.println("Device is reset.");
    }
}

public class Laptop implements Device {
    @Override
    public void powerOn() {
        System.out.println("Laptop is powered on.");
    }
}

public class App {
    public static void main(String[] args) {
        Device.reset(); // Static method call
        Laptop laptop = new Laptop();
        laptop.powerOn(); // Default method overridden
    }
}
```

### Summary

- **Default Methods**: Provide a way to add new methods to interfaces with default behavior, helping maintain backward compatibility.
- **Static Methods**: Allow utility functions related to the interface to be implemented directly within the interface.

These methods enhance the flexibility and functionality of interfaces in Java, making it easier to work with functional programming and interface-based design patterns. They also support better code organization and reuse, contributing to more maintainable and extensible codebases.

[Complete Fundamental Concepts Of Java Functional Interfaces](java-basic-fundamental-functional-interfaces.md)

## Method References

[Complete Fundamental Concepts Of Java Method References](java-basic-fundamental-method-references.md)

## Stream
Introduced in Java 8, the Stream API is used to process collections of objects. A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
Streams are an update to the Java API that lets you manipulate collections of data in a declarative way (you express a query rather than code an ad hoc implementation for it). For now you can think of them as fancy iterators over a collection of data. In addition, streams can be processed in parallel transparently, without you having to write any multithreaded code.

### Generating streams

With Java 8, Collection interface has two methods to generate a Stream.

•	<b>stream()</b> − Returns a sequential stream considering collection as its source.

•	<b>parallelStream()</b> − Returns a parallel Stream considering collection as its source.

```java
List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
```

### Filter
Java 8 Stream interface introduces filter() method which can be used to filter out some elements from object collection based on a particular condition. This condition should be specified as a predicate which the filter() method accepts as an argument.

```java
List<String> names = Arrays.asList("Melisandre","Sansa","Jon","Daenerys","Joffery");
Stream<String> allNames = names.stream();
Stream<String> longNames = allNames.filter(str -> str.length() > 6);	
```

### Sorted
Stream sorted() returns a stream consisting of the elements of this stream, sorted according to natural order. For ordered streams, the sort method is stable but for unordered streams, no stability is guaranteed. It is a stateful intermediate operation.

```java
List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4); 
list.stream().sorted().forEach(System.out::println); 
```

### Map
Stream map(Function mapper) is an intermediate operation. These operations are always lazy. Intermediate operations are invoked on a Stream instance and after they finish their processing, they give a Stream instance as output.

```java
List<Integer> list = Arrays.asList(3, 6, 9, 12, 15); 
list.stream().map(number -> number * 3).forEach(System.out::println); 
```

### Match
Java 8 Matching with Streams tutorial explains how to match elements in a stream using the allMatch(), anyMatch() and noneMatch() methods provided by the Streams API with examples to show their usage.

```java
List<String> names = Arrays.asList("Melisandre","Aansa","Jon","Daenerys","Joffery");
Stream<String> allNames = names.stream();
boolean anyRecordStartsWithA = allNames.anyMatch(s-> s.startsWith("a"));
```

### Count
long count() returns the count of elements in the stream.

```java
List<Integer> list = Arrays.asList(0, 2, 4, 6, 8, 10, 12);  
long total = list.stream().count(); 
```

### Reduce
Many times, we need to perform operations where a stream reduces to single resultant value, for example, maximum, minimum, sum, product, etc. Reducing is the repeated process of combining all elements.

```java
List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8); 
int sum = array.stream().reduce(0, (element1, element2) -> element1 + element2); 
```

[Complete Fundamental Concepts Of Java Stream](java-basic-fundamental-Stream.md)

## Optional
Every Java Programmer is familiar with NullPointerException. It can crash your code. And it is very hard to avoid it without using too many null checks.
Java 8 has introduced a new class Optional in java.util package. It can help in writing neat code without using too many null checks. By using Optional, we can specify alternate values to return or alternate code to run. This makes the code more readable because the facts which were hidden are now visible to the developer.

```java
List<String> listOfStrings = Arrays.asList("Mark", "Howard", "Anthony D'Cornian");
Optional<String> largeString = listOfStrings.stream().filter(str -> str.length() > 10).findAny();
largeString.ifPresent(System.out::println);
```

[Complete Fundamental Concepts Of Java Optional](java-basic-fundamental-optional.md)

## Date
Java 8 introduced new APIs for Date and Time to address the shortcomings of the older java.util.Date and java.util.Calendar.

```java
LocalDateTime currentTime = LocalDateTime.now();
System.out.println("Current DateTime: " + currentTime);
		
LocalDate date1 = currentTime.toLocalDate();
System.out.println("date1: " + date1);
```
## Java Programing Exercises
* [java-basic-exercises-001-Basic-1](java-basic-exercises-001-Basic-1.md)
* [java-basic-exercises-002-Basic-2](java-basic-exercises-002-Basic-2.md)
* [java-basic-exercises-003-Recursive](java-basic-exercises-003-Recursive.md)
* [java-basic-exercises-004-Exception](java-basic-exercises-004-Exception.md)
* [java-basic-exercises-005-Array](java-basic-exercises-005-Array.md)
* [java-basic-exercises-006-Inheritance](java-basic-exercises-006-Inheritance.md)
* [java-basic-exercises-007-Abstract](java-basic-exercises-007-Abstract.md)
* [java-basic-exercises-008-Thread](java-basic-exercises-008-Thread.md)
* [java-basic-exercises-009-Multithreading](java-basic-exercises-009-Multithreading.md)
* [java-basic-exercises-010-Generic](java-basic-exercises-010-Generic.md)
* [java-basic-exercises-011-OOPs](java-basic-exercises-011-OOPs.md)
* [java-basic-exercises-012-Interface](java-basic-exercises-012-Interface.md)
* [java-basic-exercises-013-Encapsulation](java-basic-exercises-013-Encapsulation.md)
* [java-basic-exercises-014-Polymorphism](java-basic-exercises-014-Polymorphism.md)
* [java-basic-exercises-015-String](java-basic-exercises-015-String.md)
* [java-basic-exercises-016-Lambda](java-basic-exercises-016-Lambda.md)
* [java-basic-exercises-017-Stream](java-basic-exercises-017-Stream.md)
* [java-basic-exercises-018-Method](java-basic-exercises-018-Method.md)
* [java-basic-exercises-019-Numbers](java-basic-exercises-019-Numbers.md)
* [java-basic-exercises-020-Collection](java-basic-exercises-020-Collection.md)
  * [java-basic-exercises-020-collection-arraylist](java-basic-exercises-020-collection-arraylist.md)
  * [java-basic-exercises-020-collection-hashmap](java-basic-exercises-020-collection-hashmap.md)
  * [java-basic-exercises-020-collection-hashset](java-basic-exercises-020-collection-hashset.md)
  * [java-basic-exercises-020-collection-linkedlist](java-basic-exercises-020-collection-linkedlist.md)
  * [java-basic-exercises-020-collection-priorityqueue](java-basic-exercises-020-collection-priorityqueue.md)
  * [java-basic-exercises-020-collection-treemap](java-basic-exercises-020-collection-treemap.md)
  * [java-basic-exercises-020-collection-treeset](java-basic-exercises-020-collection-treeset.md)
* [java-basic-exercises-021-Sorting](java-basic-exercises-021-Sorting.md)
* [java-basic-exercises-022-Search](java-basic-exercises-022-Search.md)
* [java-basic-exercises-023-Unit-Test](java-basic-exercises-023-Unit-Test.md)
## Java Programing Question Answer
* [java-programming-question-answer-1](java-programming-question-answer-1.md)
* [java-programming-question-answer-2](java-programming-question-answer-2.md)
* [java-programming-question-answer-3-emp-mgmt](java-programming-question-answer-3-emp-mgmt.md)
* [java-programming-question-answer-4-java-8](java-programming-question-answer-4-java-8.md)
* [java-programming-question-answer-5-java-8](java-programming-question-answer-5-java-8.md)
