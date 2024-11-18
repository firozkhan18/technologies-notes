
 - [1. OOP features]
  - [1.1 What is Polymorphism?](#11-what-is-polymorphism)
 - [2. Java 8 features]
  - [2.1 Lambda Expressions](#21-lambda-expressions)
  - [2.2 Streams](#22-streams)
  - [2.3 Default Methods in Interfaces](#23-default-methods-in-interfaces)
  - [2.4 Optional](#24-optional)
  - [2.5 Functional Interfaces](#25-functional-interfaces)
  - [2.6 Method References](#26-method-references)
 
### What is Polymorphism?

**Polymorphism** is a fundamental concept in object-oriented programming (OOP) that allows methods to do different things based on the object it is acting upon, even if they share the same name. It enables one interface to be used for a general class of actions. The specific action is determined by the exact nature of the situation, allowing for flexibility and the ability to extend functionality.

#### Types of Polymorphism

1. **Compile-time Polymorphism (Static Binding)**: Achieved through method overloading and operator overloading.
   - **Method Overloading**: Same method name with different parameters (type or number).
   
   ```java
   public class MathUtils {
       public int add(int a, int b) {
           return a + b;
       }

       public double add(double a, double b) {
           return a + b;
       }
   }
   ```

2. **Runtime Polymorphism (Dynamic Binding)**: Achieved through method overriding, where a subclass provides a specific implementation of a method that is already defined in its superclass.
   - **Method Overriding**: Same method signature but in a derived class.
   
   ```java
   class Animal {
       void sound() {
           System.out.println("Animal makes a sound");
       }
   }

   class Dog extends Animal {
       void sound() {
           System.out.println("Woof");
       }
   }

   class Cat extends Animal {
       void sound() {
           System.out.println("Meow");
       }
   }
   ```

### Interview Questions Related to Polymorphism

1. **Basic Questions**
   - **What is polymorphism? Explain with examples.**
   - **What are the differences between compile-time and runtime polymorphism?**
   - **Can you override a private method in Java? Why or why not?**

2. **Code-Based Questions**
   - **Write a code snippet demonstrating method overloading.**
   - **Write a code snippet demonstrating method overriding.**

3. **Advanced Questions**
   - **What will happen if you override a method in a subclass and change the return type?**
   - **Explain the concept of covariant return types in Java.**
   - **How does polymorphism contribute to code maintainability and flexibility?**

### Trick Questions

1. **What is the output of the following code?**
   ```java
   class Base {
       void show() {
           System.out.println("Base");
       }
   }

   class Derived extends Base {
       void show() {
           System.out.println("Derived");
       }

       void display() {
           show();
       }
   }

   public class Test {
       public static void main(String[] args) {
           Base obj = new Derived();
           obj.show();
       }
   }
   ```
   - **Answer**: The output will be `Derived`. This illustrates runtime polymorphism where the method call is resolved at runtime based on the object type, not the reference type.

2. **Can you use polymorphism with primitive data types? Why or why not?**
   - **Answer**: No, polymorphism applies to objects and their methods. Primitive types in Java do not support polymorphism since they are not objects and do not have methods.

3. **Can you achieve polymorphism with static methods? Explain your answer.**
   - **Answer**: No, static methods are bound at compile time, so they do not exhibit polymorphic behavior. They belong to the class rather than instances of the class.

### Conclusion

Understanding polymorphism is crucial for writing flexible and maintainable object-oriented code. Being able to explain the concept clearly and answer related questions, including tricky ones, can demonstrate your depth of knowledge during an interview. Practice explaining these concepts and writing sample code to prepare effectively!

### Conclusion

Polymorphism in Java allows you to define a common interface for multiple implementations, enabling flexibility and scalability. By leveraging Spring’s dependency injection and configuration features, you can effectively achieve polymorphism in your applications. 

Key steps include:

1. **Defining interfaces** for common behaviors.
2. **Implementing those interfaces** in various classes.
3. **Injecting the appropriate implementation** into your services using dependency injection, `@Qualifier`, or factory patterns.

This approach enhances code reusability and maintainability, making your application more modular and easier to test.

Sure! Here are detailed answers to the questions related to polymorphism in Java.

### Basic Questions

**1. What is polymorphism? Explain with examples.**

**Polymorphism** is a core concept in object-oriented programming (OOP) that allows objects to be treated as instances of their parent class or interface. It enables methods to perform different tasks based on the object that invokes them.

**Example:**
```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}

public class TestPolymorphism {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.sound(); // Outputs: Woof
        myCat.sound(); // Outputs: Meow
    }
}
```

---

**2. What are the differences between compile-time and runtime polymorphism?**

- **Compile-Time Polymorphism (Static Binding):**
  - Achieved through method overloading and operator overloading.
  - Resolved during compilation.
  - Example: Multiple methods with the same name but different parameter types or numbers.

- **Runtime Polymorphism (Dynamic Binding):**
  - Achieved through method overriding.
  - Resolved during runtime based on the object type.
  - Example: A parent class reference pointing to a child class object and invoking overridden methods.

---

**3. Can you override a private method in Java? Why or why not?**

No, you cannot override a private method in Java. Private methods are not accessible outside their own class, so subclasses do not inherit them. Consequently, even if you define a method with the same name in a subclass, it does not override the private method but instead creates a new method.

---

### Code-Based Questions

**4. Write a code snippet demonstrating method overloading.**

```java
class MathUtils {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }
}

public class OverloadingExample {
    public static void main(String[] args) {
        MathUtils math = new MathUtils();
        System.out.println(math.add(2, 3));         // Outputs: 5
        System.out.println(math.add(2, 3, 4));      // Outputs: 9
        System.out.println(math.add(2.5, 3.5));     // Outputs: 6.0
    }
}
```

---

**5. Write a code snippet demonstrating method overriding.**

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle is starting");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car is starting");
    }
}

public class OverridingExample {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start(); // Outputs: Car is starting
    }
}
```

---

### Advanced Questions

**6. What will happen if you override a method in a subclass and change the return type?**

You can change the return type of an overridden method as long as the new return type is a subclass of the original return type (this is known as **covariant return types**). If the return type does not adhere to this rule, it will lead to a compile-time error.

**Example:**
```java
class Animal {
    Animal getAnimal() {
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    Dog getAnimal() { // Covariant return type
        return new Dog();
    }
}
```

---

**7. Explain the concept of covariant return types in Java.**

**Covariant return types** allow a subclass to override a method from its superclass and return a type that is a subclass of the original return type. This enhances the flexibility of the polymorphic behavior, enabling a more specific type to be returned in derived classes.

---

**8. How does polymorphism contribute to code maintainability and flexibility?**

Polymorphism enhances code maintainability and flexibility in several ways:

- **Decoupling**: By relying on interfaces or abstract classes, you can write code that interacts with objects without needing to know their concrete types. This decouples the code, making it easier to maintain.

- **Code Reusability**: Different implementations can be used interchangeably without changing the code that uses them, promoting code reuse.

- **Easier to Extend**: New implementations can be added with minimal changes to existing code. For example, adding a new type of `Animal` only requires creating a new class without modifying the existing logic.

- **Simplified Testing**: Testing becomes easier since you can mock or stub different implementations when writing unit tests.

By leveraging polymorphism, developers can create more robust and flexible applications that are easier to understand, extend, and maintain.

---

## **Java 8 Features**

### **1. Lambda Expressions**

#### **Definition:**
Lambda expressions in Java 8 allow you to express instances of single-method interfaces (functional interfaces) in a more compact and readable form. They provide a way to pass behavior as parameters to methods, enhancing the language's ability to work with functional programming concepts.

#### **Syntax:**
```java
(parameters) -> expression
```

#### **Example:**
```java
public class LambdaExample {
    public static void main(String[] args) {
        // Traditional approach
        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running with traditional approach.");
            }
        };
        new Thread(oldRunnable).start();

        // Using Lambda Expression
        Runnable lambdaRunnable = () -> System.out.println("Running with Lambda Expression.");
        new Thread(lambdaRunnable).start();
    }
}
```

**Explanation**:  
Lambda expressions replace anonymous classes with a more concise syntax, making code more readable and expressive. In the above example, we use a lambda expression to pass behavior to the `Thread` constructor.

---

### **2. Functional Interfaces**

#### **Definition:**
A **Functional Interface** is an interface with just one abstract method. It may contain multiple default or static methods. The `@FunctionalInterface` annotation is used to indicate that an interface is functional, though it's not mandatory.

#### **Example:**
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface obj = () -> System.out.println("Functional Interface in Action!");
        obj.myMethod();
    }
}
```

**Explanation**:  
`MyFunctionalInterface` is a functional interface with one abstract method `myMethod()`. We can implement it with a lambda expression.

---

### **3. Default Methods in Interfaces**

#### **Definition:**
Java 8 allows interfaces to have **default methods** with a body. This allows you to add methods to interfaces without breaking existing implementations, providing a backward-compatible way to extend interfaces.

#### **Example:**
```java
interface MyInterface {
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }
    
    void abstractMethod();
}

class MyClass implements MyInterface {
    public void abstractMethod() {
        System.out.println("Implementing abstract method.");
    }
}

public class DefaultMethodExample {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.defaultMethod();  // Calling the default method
        obj.abstractMethod(); // Calling the abstract method
    }
}
```

**Explanation**:  
In the example, `MyInterface` defines a default method `defaultMethod()`. The class `MyClass` implements the interface and provides an implementation for the abstract method `abstractMethod()`, but it doesn't need to override the default method.

---

### **4. Streams API**

#### **Definition:**
The **Streams API** allows you to process sequences of elements (collections, arrays, etc.) in a functional style. Streams provide methods to perform complex operations like filtering, mapping, and reducing in a more concise way.

#### **Key Operations**:
- **Intermediate Operations**: `filter()`, `map()`, `sorted()`
- **Terminal Operations**: `forEach()`, `collect()`, `reduce()`

#### **Example:**
```java
import java.util.*;
import java.util.stream.*;

public class StreamsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using Stream to filter and print names starting with 'A'
        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println); // Output: Alice
    }
}
```

**Explanation**:  
In the above example, we use `stream()` to convert the list into a stream. Then we filter the names starting with "A" using the `filter()` method, followed by the terminal operation `forEach()` to print the result.

---

### **5. Method References**

#### **Definition:**
Method references provide a shorthand syntax for calling methods. They allow you to refer to methods directly by their names. Method references are often used in conjunction with functional interfaces.

#### **Syntax:**
```java
ClassName::methodName
```

#### **Example:**
```java
import java.util.*;
import java.util.stream.*;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using method reference to print each name
        names.forEach(System.out::println); // Output: Alice, Bob, Charlie
    }
}
```

**Explanation**:  
In this example, `System.out::println` is a method reference that is used to print each element of the list. It's equivalent to using a lambda expression like `name -> System.out.println(name)`.

---

### **6. Optional**

#### **Definition:**
`Optional` is a container object which may or may not contain a non-null value. It is introduced to avoid `NullPointerException` and to make the code more expressive by explicitly handling the possibility of `null`.

#### **Example:**
```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String value = "Hello, World!";
        Optional<String> optional = Optional.ofNullable(value);

        // If the value is present, print it
        optional.ifPresent(System.out::println); // Output: Hello, World!

        // Get value with a default if not present
        String result = optional.orElse("Default Value");
        System.out.println(result);  // Output: Hello, World!
    }
}
```

**Explanation**:  
In this example, `Optional.ofNullable(value)` creates an `Optional` that may or may not contain a value. We use `ifPresent()` to check if the value is present and print it. `orElse()` provides a default value if the value is absent.

---

### **7. Collectors API**

#### **Definition:**
The **Collectors API** provides implementations of common reduction operations, such as accumulating elements into collections, summarizing data, or grouping data. The most commonly used collector is `Collectors.toList()` to collect the results of a stream into a list.

#### **Example:**
```java
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class CollectorsExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using Collectors.toList() to collect stream results into a list
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("A"))
                                          .collect(Collectors.toList());

        System.out.println(filteredNames); // Output: [Alice]
    }
}
```

**Explanation**:  
Here, we use `collect()` with `Collectors.toList()` to collect the filtered stream results into a list.

---

### **8. New Date and Time API (java.time)**

#### **Definition:**
Java 8 introduced a new Date and Time API (`java.time`) to overcome the issues with the old `Date` and `Calendar` classes. The new API is more comprehensive and user-friendly, with better support for time zones and durations.

#### **Example:**
```java
import java.time.*;
import java.time.format.*;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today); // Output: 2024-11-18

        // Parsing and formatting dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = today.format(formatter);
        System.out.println("Formatted Date: " + formattedDate); // Output: 18-11-2024
    }
}
```

**Explanation**:  
We use `LocalDate.now()` to get the current date, and `DateTimeFormatter.ofPattern()` to format the date in a custom format.

---

### **Summary of Java 8 Features:**

1. **Lambda Expressions**: Provide a compact way to pass behavior (functions) as parameters, enabling functional programming.
2. **Functional Interfaces**: Interfaces with just one abstract method. The `@FunctionalInterface` annotation ensures they are used correctly.
3. **Default Methods**: Allow interfaces to have method implementations, providing backward compatibility.
4. **Streams API**: Facilitate functional-style operations on collections, such as filtering, mapping, and reducing.
5. **Method References**: Shorthand syntax for calling methods, making code more readable.
6. **Optional**: A container for possibly null values, eliminating `NullPointerException` by explicitly handling `null`.
7. **Collectors API**: Provides standard methods for collecting the results of stream operations, like grouping or summarizing.
8. **New Date and Time API**: Replaces the old `Date` and `Calendar` classes, providing a more robust and flexible approach to date and time handling.

---
In **Java 8**, there were several important changes and enhancements made to both the **Collections Framework** and **Concurrency Framework**. These changes provided more powerful and flexible ways to work with collections and concurrency, making Java easier to use in multi-threaded, parallel, and functional programming environments.

### **1. Changes in the Collections Framework in Java 8**

Java 8 introduced several improvements to the **Collections Framework**, particularly with the introduction of **Streams API**, **default methods in interfaces**, and **new utility methods** in existing collection classes.

#### **1.1. Introduction of the Streams API**

The **Streams API** is one of the most significant additions to the Collections Framework in Java 8. It enables functional-style operations on collections (like lists, sets, etc.) and allows for more declarative and concise code.

- **Stream**: A sequence of elements supporting sequential and parallel aggregate operations.
  
**Key features of Streams**:
- Supports **filtering**, **mapping**, **reducing**, and **collecting** operations on collections.
- Allows **parallel processing** of data.
- Supports **laziness**: Operations are only executed when a terminal operation (e.g., `collect()`, `forEach()`, etc.) is invoked.

#### **Example of Stream Operations**:
```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using Stream to filter and collect names starting with 'A'
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("A"))
                                          .collect(Collectors.toList());

        System.out.println(filteredNames);  // Output: [Alice]
    }
}
```

#### **1.2. Default Methods in Collection Interfaces**

Java 8 introduced **default methods** in interfaces, which allow you to add new methods to interfaces without breaking existing implementations.

- **For Collections**: The `List`, `Set`, `Queue`, and `Map` interfaces can now have default methods.
  
Some of the key methods added:
- `forEach()`: A default method to iterate over a collection and perform an action.
- `removeIf()`: A method to remove elements based on a condition (available in `Collection`).
- `spliterator()`: Returns a `Spliterator` that can be used to iterate over the collection.

**Example:**
```java
import java.util.*;

public class CollectionDefaultMethods {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

        // Using forEach() (introduced in Java 8)
        list.forEach(System.out::println);

        // Using removeIf() (also introduced in Java 8)
        list.removeIf(name -> name.startsWith("A"));
        System.out.println(list);  // Output: [Bob, Charlie]
    }
}
```

#### **1.3. New Utility Methods in Collections**

Java 8 introduced new methods to enhance the functionality of existing collection classes:

- `List`: Added `replaceAll()`, `sort()`, `stream()`, `parallelStream()`.
- `Map`: Added `compute()`, `computeIfAbsent()`, `computeIfPresent()`, and `merge()` methods for more flexible and concurrent-friendly map operations.

**Example**:
```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 1);
        map.put("Bob", 2);

        // Using computeIfAbsent() to add an entry if not present
        map.computeIfAbsent("Charlie", key -> 3);

        System.out.println(map);  // Output: {Alice=1, Bob=2, Charlie=3}
    }
}
```

#### **1.4. Parallel Streams**

Java 8 allows you to easily process data in parallel using the `parallelStream()` method, which enables multi-core processing with minimal effort.

```java
import java.util.*;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using parallel stream to perform a sum
        int sum = numbers.parallelStream()
                          .mapToInt(Integer::intValue)
                          .sum();

        System.out.println("Sum: " + sum);  // Output: Sum: 15
    }
}
```

#### **1.5. `Optional` Class**

Although **Optional** is not strictly a part of the Collections Framework, it is used widely in combination with collections to avoid `NullPointerException`. It is a container object that may or may not contain a non-null value.

```java
import java.util.*;

public class OptionalExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alice", "Bob", "Charlie");

        // Using Optional with Streams to avoid null
        Optional<String> result = list.stream()
                                      .filter(name -> name.startsWith("Z"))
                                      .findFirst();

        System.out.println(result.orElse("No match found"));  // Output: No match found
    }
}
```

---

### **2. Changes in the Concurrency Framework in Java 8**

Java 8 made several significant improvements to the **Concurrency Framework**, with a focus on **parallelism** and **thread-safe** operations, making it easier to write highly scalable multi-threaded applications.

#### **2.1. The `CompletableFuture` Class**

`CompletableFuture` was introduced in Java 8 to provide a way of handling asynchronous programming more efficiently. It allows you to perform **non-blocking operations** and chain multiple tasks to run in parallel.

- Supports **callbacks**, **composing**, and **synchronizing** asynchronous tasks.
- Provides methods like `thenApply()`, `thenAccept()`, `thenRun()`, etc.

**Example**:
```java
import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Creating an asynchronous task using CompletableFuture
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            return 5;
        }).thenApplyAsync(result -> result * 2); // Chain another task

        System.out.println(future.get());  // Output: 10
    }
}
```

#### **2.2. `Stream.parallel()` for Parallel Processing**

Java 8 introduced a more convenient way to process collections in parallel using the `parallel()` method available in the `Stream` API. It simplifies the task of parallelizing data processing without the need to manage threads explicitly.

```java
import java.util.*;

public class ParallelStreamConcurrency {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Parallel stream for concurrent processing
        int sum = numbers.parallelStream()
                          .mapToInt(Integer::intValue)
                          .sum();

        System.out.println("Sum: " + sum);  // Output: Sum: 15
    }
}
```

#### **2.3. The `ForkJoinPool` Framework**

Java 8 introduced the **ForkJoinPool** as part of the **parallel processing framework**. It is specifically designed for tasks that can be recursively divided into smaller subtasks and then combined. The `ForkJoinPool` framework allows more efficient execution of such tasks.

```java
import java.util.concurrent.*;

public class ForkJoinPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();

        // Submit a task to ForkJoinPool
        int result = pool.submit(() -> {
            return 1 + 1;
        }).get();

        System.out.println(result);  // Output: 2
    }
}
```

#### **2.4. `Collectors` for Concurrent Collections**

Java 8 enhanced the `Collectors` utility class to support concurrency better. For example, you can now collect results of parallel streams into **thread-safe collections** using `Collector.toMap()` or `Collector.toList()`.

#### **2.5. `java.util.concurrent` Enhancements**

Java 8 introduced several new methods to improve concurrency, such as:

- **`ConcurrentMap`**: Added methods like `compute()`, `computeIfAbsent()`, and `merge()`.
- **`ExecutorService`**: Supports new ways of submitting and managing tasks.

---

### **Summary of Key Changes in Java 8**

#### **Collections Framework:**
1. **Streams API**: Provides a functional approach to collections, enabling parallel and lazy operations on data.
2. **Default Methods**: Added default methods in collection interfaces like `forEach()`, `removeIf()`, and `spliterator()`.
3. **Parallel Streams**: Introduced `parallelStream()` for easy parallel processing.
4. **New Methods in Collection Classes**: Methods like `compute()`, `merge()`, and `removeIf()` added to various collections for easier management.
5. **Optional Class**: Used to handle `null` values more safely, especially in collections.

#### **Concurrency Framework:**
1. **`CompletableFuture`**: Makes asynchronous programming more intuitive with methods to chain tasks and handle callbacks.
2. **Parallel Stream Processing**: Simplified parallel processing of collections via `Stream.parallel()`.
3. **ForkJoinPool**: A new concurrency framework for parallelizing tasks with recursion.
4. **Enhanced Concurrency Utilities**: Improvements to existing utilities like `ExecutorService` and `ConcurrentMap` for better concurrency control.

## Concurrency Issues in Java

### **Race Conditions in Java**

#### **Definition**:
A **race condition** occurs in a multi-threaded environment when two or more threads access and modify shared data simultaneously without proper synchronization, leading to unpredictable or inconsistent results. The outcome of such situations depends on the timing of thread execution, making the results unreliable.

---

### **Example of a Race Condition**:

```java
public class Counter {
    private int count = 0;

    public void increment() {
        count++; // Not thread-safe
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Creating multiple threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Expected output: 2000, but might be less due to race condition
        System.out.println("Count: " + counter.getCount());
    }
}
```

**Explanation**:  
In the above example, two threads try to increment the `count` variable 1000 times each. Since the `increment()` method is not thread-safe, both threads might simultaneously access and modify the `count` variable, causing an inconsistent result. The final count is likely to be less than the expected 2000 due to the race condition.

---

### **How to Prevent Race Conditions:**

To prevent race conditions and ensure thread safety, you can use the following techniques:

1. **Synchronization**:  
   Using the `synchronized` keyword ensures that only one thread can access a critical section (method or block of code) at a time, preventing concurrent modification of shared data.

   **Example**:
   ```java
   public synchronized void increment() {
       count++;  // Only one thread can access this at a time
   }
   ```

   In this example, synchronization ensures that the `increment()` method is thread-safe, and only one thread can modify the `count` variable at a time.

2. **Atomic Variables**:  
   Classes from the `java.util.concurrent.atomic` package (e.g., `AtomicInteger`, `AtomicLong`) provide atomic operations that ensure thread-safe updates without explicit synchronization.

   **Example**:
   ```java
   import java.util.concurrent.atomic.AtomicInteger;

   public class Counter {
       private AtomicInteger count = new AtomicInteger(0);

       public void increment() {
           count.incrementAndGet(); // Thread-safe increment
       }

       public int getCount() {
           return count.get();
       }

       public static void main(String[] args) throws InterruptedException {
           Counter counter = new Counter();
           Thread thread1 = new Thread(() -> {
               for (int i = 0; i < 1000; i++) counter.increment();
           });
           Thread thread2 = new Thread(() -> {
               for (int i = 0; i < 1000; i++) counter.increment();
           });

           thread1.start();
           thread2.start();
           thread1.join();
           thread2.join();

           System.out.println("Count: " + counter.getCount()); // Output: 2000
       }
   }
   ```

   Here, `AtomicInteger` guarantees that the `increment()` operation is atomic, meaning it handles the synchronization internally, preventing race conditions.

3. **Using Locks**:  
   For more complex scenarios, you can use `ReentrantLock` from the `java.util.concurrent.locks` package to control access to shared resources more explicitly. This allows finer-grained control over lock acquisition and release.

   **Example**:
   ```java
   import java.util.concurrent.locks.ReentrantLock;

   public class Counter {
       private int count = 0;
       private final ReentrantLock lock = new ReentrantLock();

       public void increment() {
           lock.lock();  // Acquire the lock
           try {
               count++;  // Critical section
           } finally {
               lock.unlock();  // Always release the lock
           }
       }

       public int getCount() {
           return count;
       }
   }
   ```

   The `ReentrantLock` provides a way to lock the critical section manually and release the lock once the operation is complete, preventing other threads from entering the critical section.

---

### **Summary of Prevention Strategies**:

1. **Synchronization**:  
   Use the `synchronized` keyword to ensure that only one thread can access shared resources or methods at a time.

2. **Atomic Variables**:  
   Use classes from the `java.util.concurrent.atomic` package, such as `AtomicInteger`, to perform thread-safe operations without the need for explicit synchronization.

3. **Locks**:  
   Use `ReentrantLock` for more complex scenarios where you need more control over thread synchronization. This allows manual acquisition and release of locks.

---

### **Key Points**:

- **Race Conditions**: Occur when multiple threads modify shared data simultaneously without proper synchronization, leading to inconsistent or unpredictable results.
- **Prevention**: Race conditions can be avoided by using synchronization (e.g., `synchronized` keyword), atomic variables, or locks to manage thread access to shared resources.
- **Atomic Operations**: Using atomic classes like `AtomicInteger` can simplify thread-safe operations and avoid explicit synchronization.

By employing these strategies, you can prevent race conditions and ensure that your multi-threaded Java applications operate predictably and reliably.

Here’s a consolidated version for **Deadlock**, **Starvation**, **Fairness Policies**, and the **Diamond Problem** in the context of multi-threading and concurrency in Java:

---

## **Deadlock**

### **Definition:**
A **deadlock** occurs in a multi-threaded environment when two or more threads are blocked forever, waiting for each other to release resources. This results in a standstill where no thread can proceed because they are all waiting for resources that other threads hold.

Deadlocks typically arise when:
- Multiple threads acquire locks on different resources in different orders.
- Each thread holds a lock and waits for the other to release the resources it needs.

### **Example of Deadlock:**

```java
class ResourceA {
    synchronized void methodA(ResourceB b) {
        System.out.println("Thread 1 holding lock A...");
        try { Thread.sleep(100); } catch (Exception e) {}
        System.out.println("Thread 1 waiting for lock B...");
        b.last();
    }

    synchronized void last() {}
}

class ResourceB {
    synchronized void methodB(ResourceA a) {
        System.out.println("Thread 2 holding lock B...");
        try { Thread.sleep(100); } catch (Exception e) {}
        System.out.println("Thread 2 waiting for lock A...");
        a.last();
    }

    synchronized void last() {}
}

public class DeadlockExample {
    public static void main(String[] args) {
        final ResourceA a = new ResourceA();
        final ResourceB b = new ResourceB();
        
        Thread t1 = new Thread(() -> a.methodA(b));
        Thread t2 = new Thread(() -> b.methodB(a));
        
        t1.start();
        t2.start();
    }
}
```

**Explanation**:  
In the above example, `Thread 1` holds the lock on `ResourceA` and tries to acquire a lock on `ResourceB`. Meanwhile, `Thread 2` holds the lock on `ResourceB` and tries to acquire a lock on `ResourceA`, causing both threads to block indefinitely — this is a deadlock.

### **How to Prevent Deadlock:**

1. **Avoid Nested Locks**:  
   Try to avoid acquiring more than one lock at a time or acquire them in a consistent order across all threads to avoid circular waiting.

2. **Lock Timeout**:  
   Set a timeout for acquiring locks. If a thread cannot acquire the lock within the timeout, it can release the locks and retry.

3. **Deadlock Detection**:  
   Use tools or algorithms to detect circular dependencies between threads and break them.

4. **Use `ReentrantLock` with Timeout**:  
   `ReentrantLock` allows specifying a timeout when attempting to acquire a lock, which prevents indefinite blocking.

---

## **Starvation**

### **Definition:**
Starvation happens when a thread is perpetually denied access to resources due to other threads continuously acquiring those resources. This typically occurs when threads with higher priority keep monopolizing resources and prevent lower-priority threads from executing.

### **Example of Starvation:**

```java
class StarvationExample {
    public static void main(String[] args) {
        Thread lowPriority = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Low priority thread running");
            }
        });

        Thread highPriority = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("High priority thread running");
            }
        });

        lowPriority.setPriority(Thread.MIN_PRIORITY);
        highPriority.setPriority(Thread.MAX_PRIORITY);

        lowPriority.start();
        highPriority.start();
    }
}
```

**Explanation**:  
In the above example, the high-priority thread runs more frequently, and the low-priority thread may not get enough CPU time, potentially starving it from executing.

### **How to Prevent Starvation:**

1. **Fairness Policy**:  
   Use `ReentrantLock` with `fair` parameter set to `true` to ensure that threads acquire locks in the order they request them.

2. **Priority Scheduling**:  
   Balance thread priorities appropriately. Avoid setting overly high priorities for some threads to ensure that all threads get a chance to execute.

3. **Yielding or Sleeping**:  
   Explicitly allow a thread to yield or sleep for short durations, enabling other threads to get a chance to execute.

4. **Round-robin Scheduling**:  
   This approach ensures that each thread receives a fair amount of time for execution by using time slices.

---

## **Fairness Policies**

### **Definition:**
Fairness policies in multi-threading govern how threads acquire locks or access resources, ensuring no thread is indefinitely delayed or starved. Fairness generally means giving each thread an equal chance to acquire a resource.

### **Types of Fairness Policies:**

1. **FIFO (First-In, First-Out)**:  
   The first thread to request a resource is the first one to acquire it. This is commonly seen in `ReentrantLock` when `fair` is set to `true`.

2. **Round-robin Scheduling**:  
   A thread scheduling policy that allocates each thread a fixed time slice (or quantum) in a cyclic order.

3. **Priority-Based Scheduling**:  
   Threads are assigned priorities, and higher-priority threads get preferential treatment. However, this can lead to starvation of lower-priority threads.

### **Fairness Example with `ReentrantLock`:**

```java
import java.util.concurrent.locks.ReentrantLock;

public class FairnessPolicyExample {
    private final ReentrantLock lock = new ReentrantLock(true);  // Fair lock

    public void process() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " processing...");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairnessPolicyExample example = new FairnessPolicyExample();

        Thread t1 = new Thread(example::process);
        Thread t2 = new Thread(example::process);
        Thread t3 = new Thread(example::process);

        t1.start();
        t2.start();
        t3.start();
    }
}
```

**Explanation**:  
In the above example, `ReentrantLock(true)` ensures that the lock is fair, meaning threads will acquire the lock in the order they requested it, preventing starvation.

---

## **Diamond Problem in Java (Multiple Inheritance)**

### **Definition:**
The **diamond problem** occurs when a class inherits from two classes that both inherit from a common base class. This leads to ambiguity about which superclass method to use. Java avoids this issue by not allowing multiple inheritance of classes but allows multiple inheritance through interfaces.

### **Example of Diamond Problem:**

```java
interface A {
    default void display() {
        System.out.println("A");
    }
}

interface B extends A {
    default void display() {
        System.out.println("B");
    }
}

interface C extends A {
    default void display() {
        System.out.println("C");
    }
}

class D implements B, C {
    public void display() {
        B.super.display();  // Resolving ambiguity by explicitly choosing one method
    }
}

public class DiamondProblemExample {
    public static void main(String[] args) {
        D obj = new D();
        obj.display();  // Output: B
    }
}
```

**Explanation**:  
The above code demonstrates the diamond problem where class `D` implements interfaces `B` and `C`, both of which extend interface `A` and have their own `display()` method. Java resolves the ambiguity by allowing the class to explicitly choose which method to call.

### **How Java Avoids the Diamond Problem:**

- **Interfaces**: Java allows multiple inheritance only through interfaces, and if there are conflicting default methods, the class implementing them must override the method to resolve ambiguity.
- **No Multiple Inheritance of Classes**: Java doesn't allow multiple inheritance of classes, which would lead to the diamond problem.

---

### **Summary of Key Concepts:**

1. **Deadlock**: Occurs when threads are stuck waiting for each other to release resources. Prevent deadlocks by avoiding nested locks, using lock timeouts, and ensuring proper lock acquisition order.

2. **Starvation**: Happens when low-priority threads are perpetually denied access to resources. Prevent starvation using fairness policies like `ReentrantLock` with fair parameter, round-robin scheduling, and balanced thread priorities.

3. **Fairness Policies**: These ensure that all threads get a chance to execute. Use `ReentrantLock` with fairness set to true, round-robin scheduling, or priority-based scheduling to enforce fairness.

4. **Diamond Problem**: A potential issue in multiple inheritance where ambiguity arises about which method to use from inherited classes. Java avoids this by not supporting multiple class inheritance but allows multiple inheritance through interfaces with explicit conflict resolution for default methods.

By understanding these concurrency concepts, you can create more robust, thread-safe, and efficient multi-threaded applications in Java.

---
