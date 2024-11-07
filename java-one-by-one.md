Java 8, released in March 2014, introduced a host of new features that significantly changed the way Java applications are written, particularly in terms of **functional programming**, **streams**, and **new APIs**. These features aim to make Java programming more expressive, concise, and efficient. Let's take a detailed look at the key features introduced in Java 8:

### 1. **Lambda Expressions**

Lambda expressions enable you to write clear and concise code by treating functionality as a method argument or by passing code around as data. Lambda expressions are primarily used to define the behavior of methods passed as arguments to higher-order functions (like `map()`, `filter()`, etc.).

#### Syntax of Lambda Expression:
```java
(parameters) -> expression or block of statements
```

#### Example:
```java
// Traditional way using an anonymous class
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running");
    }
};

// Using a lambda expression
Runnable r2 = () -> System.out.println("Running");
r2.run();  // Output: Running
```

#### Key Benefits:
- **Conciseness**: Reduces boilerplate code, making code easier to read and maintain.
- **Functional Programming**: Enables functional-style programming in Java.

---

### 2. **Functional Interfaces**

A **functional interface** is an interface that contains just one abstract method, and it may contain multiple default or static methods. Lambda expressions can be used to instantiate functional interfaces.

- Common functional interfaces in the `java.util.function` package include:
  - `Predicate<T>`: Represents a boolean-valued function.
  - `Function<T, R>`: Represents a function that takes an argument of type `T` and returns a result of type `R`.
  - `Consumer<T>`: Represents an operation that takes a single argument of type `T` and returns no result.
  - `Supplier<T>`: Represents a supplier of results.

#### Example:
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void apply(int x);

    // You can still have default or static methods
    default void defaultMethod() {
        System.out.println("This is a default method");
    }
}

public class Example {
    public static void main(String[] args) {
        MyFunctionalInterface myFunc = (x) -> System.out.println(x * x);
        myFunc.apply(5);  // Output: 25
    }
}
```

---

### 3. **Streams API**

The Streams API allows you to work with sequences of elements in a functional style. It supports operations like filtering, mapping, and reducing data in a very readable and concise way. Streams can be processed in a sequential or parallel fashion.

#### Key Features:
- **Laziness**: Stream operations are lazy and are not executed until a terminal operation is invoked.
- **Parallelism**: Streams can be processed in parallel with minimal effort.

#### Example (Working with Collections):
```java
import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using Streams to filter and print the even numbers
        numbers.stream()
               .filter(n -> n % 2 == 0)  // Filter even numbers
               .forEach(System.out::println);  // Print each even number
    }
}
```

#### Stream Operations:
- **Intermediate Operations**: Operations like `map()`, `filter()`, `distinct()`, `sorted()`, etc., which return a new stream.
- **Terminal Operations**: Operations like `collect()`, `reduce()`, `forEach()`, `count()`, etc., which produce a result or a side-effect.

#### Example (Stream Pipeline with Reduce):
```java
int sum = numbers.stream()
                 .reduce(0, (a, b) -> a + b);
System.out.println(sum);  // Output: 15
```

---

### 4. **Default Methods in Interfaces**

Java 8 introduced **default methods** to interfaces. A default method has a body and can be called directly from the interface. This is useful for providing method implementations that can be shared across classes that implement the interface.

#### Example:
```java
interface MyInterface {
    // Abstract method
    void abstractMethod();

    // Default method
    default void defaultMethod() {
        System.out.println("This is a default method");
    }
}

class MyClass implements MyInterface {
    public void abstractMethod() {
        System.out.println("Implementing abstract method");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.abstractMethod();  // Output: Implementing abstract method
        myClass.defaultMethod();   // Output: This is a default method
    }
}
```

---

### 5. **Method References**

Method references provide a way to refer to methods without invoking them directly. Method references are a shorthand notation for lambda expressions that call a method.

#### Types of Method References:
1. **Static method reference**: `ClassName::staticMethod`
2. **Instance method reference**: `objectInstance::instanceMethod`
3. **Constructor reference**: `ClassName::new`

#### Example:
```java
// Using a method reference instead of a lambda expression
List<String> list = Arrays.asList("a", "b", "c", "d");

list.forEach(System.out::println);  // Prints each element of the list
```

---

### 6. **Optional Class**

`Optional` is a container object which may or may not contain a non-null value. It helps to avoid `NullPointerExceptions` by providing a better way to handle nulls and missing values.

#### Key Methods of `Optional`:
- `isPresent()`: Returns `true` if the value is present, `false` otherwise.
- `ifPresent()`: Executes a block of code if the value is present.
- `orElse()`: Provides a fallback value if the value is absent.
- `map()`: Applies a function if the value is present, and returns a new `Optional`.

#### Example:
```java
Optional<String> optional = Optional.ofNullable("Hello");
optional.ifPresent(System.out::println);  // Output: Hello

String value = optional.orElse("Default Value");
System.out.println(value);  // Output: Hello
```

---

### 7. **New Date/Time API (java.time)**

Java 8 introduced a new Date and Time API (`java.time`) to address many shortcomings of the old `java.util.Date` and `java.util.Calendar`. The new API is more comprehensive, immutable, and thread-safe.

#### Key Classes:
- **LocalDate**: Represents a date without time.
- **LocalTime**: Represents a time without date.
- **LocalDateTime**: Combines date and time.
- **ZonedDateTime**: Represents date and time with a timezone.
- **Duration**: Represents a time-based amount of time.
- **Period**: Represents a date-based amount of time.

#### Example:
```java
import java.time.*;

public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2023, Month.OCTOBER, 10);
        LocalTime time = LocalTime.of(10, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime);  // Output: 2023-10-10T10:30
    }
}
```

---

### 8. **Nashorn JavaScript Engine**

Java 8 introduced the **Nashorn JavaScript engine**, which allows you to embed JavaScript code within Java applications and execute it. Nashorn is much faster than the previous JavaScript engine (Rhino).

#### Example:
```java
import javax.script.*;

public class NashornExample {
    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("print('Hello from JavaScript')");
    }
}
```

---

### 9. **New Parallel Operations**

Java 8 makes it easier to write parallel programs using the `Stream` API. With the `parallel()` method, you can process collections in parallel, taking advantage of multi-core processors with minimal effort.

#### Example:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.parallelStream()
                 .reduce(0, Integer::sum);
System.out.println(sum);  // Output: 15
```

Parallel streams can improve performance when applied to large datasets.

---

### 10. **New APIs**

Java 8 also introduced several other important enhancements:
- **java.util.function**: A set of standard functional interfaces, such as `Predicate`, `Function`, `Consumer`, and `Supplier`.
- **java.nio.file**: Improvements to the file I/O APIs, including `Files.walk()` and other utilities for working with files.
- **CompletableFuture**: A new API for asynchronous programming, allowing you to compose multiple asynchronous tasks in a non-blocking manner.

---

### Conclusion

Java 8 is a major update that brings a paradigm shift towards functional programming. The key features such as **lambda expressions**, **streams**, **default methods in interfaces**, and the **new Date/Time API** make Java code more concise, readable, and maintainable. These additions open up new possibilities for writing cleaner, more efficient code, particularly when working with collections, asynchronous tasks, and functional programming patterns.

Java 8 not only modernized Java, making it

 more competitive with languages like Scala and Kotlin but also allowed developers to write more expressive and maintainable code.
