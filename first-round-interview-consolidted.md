## Overview of the key features introduced in Java 8


### 1. **Lambda Expressions** (Functional Programming)

Lambda expressions enable you to express instances of single-method interfaces (functional interfaces) in a clear and concise way. They allow you to write more compact code and make use of functional programming constructs.

In Java 8, **lambda expressions** provide a way to write concise, functional-style code. A lambda expression essentially allows you to pass behavior as an argument to a method or store it in a variable. They are primarily used to define the implementation of the abstract method of a functional interface.

### Syntax of Lambda Expression:
The basic syntax of a lambda expression is:

```java
(parameters) -> expression
```

- **parameters**: The input parameters to the lambda function. If there is one parameter, you can omit the parentheses. If there are no parameters, use empty parentheses.
- **arrow (`->`)**: It separates the parameters and the body of the lambda expression.
- **expression**: The logic or behavior the lambda expression implements.

### Example of a Lambda Expression in Java:

1. **Simple Lambda Expression**
   ```java
   // Traditional way (Anonymous class)
   Runnable r1 = new Runnable() {
       @Override
       public void run() {
           System.out.println("Hello from Runnable!");
       }
   };

   // Using Lambda Expression
   Runnable r2 = () -> System.out.println("Hello from Runnable!");
   ```

   In this case, the lambda expression `() -> System.out.println("Hello from Runnable!")` represents a `Runnable` with no parameters and a single statement.

   Lambda expressions allow you to pass behavior as a parameter to methods, making the code more flexible and readable.

2. **Lambda Expression with Parameters**
   A more common example would be with functional interfaces that take parameters, like `Predicate`, `Function`, etc.

   ```java
   // Function interface example (accepts one parameter and returns a value)
   Function<Integer, Integer> square = (x) -> x * x;

   System.out.println(square.apply(4)); // Output: 16
   ```

3. **Lambda Expression with Multiple Parameters**
   You can pass multiple parameters to a lambda expression as well:

   ```java
   // Adding two integers
   BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

   System.out.println(add.apply(5, 3)); // Output: 8
   ```

4. **Using Lambda Expressions in Collections (Streams API)**
   Lambda expressions are particularly powerful when working with collections, especially with the new **Streams API** introduced in Java 8.

   ```java
   // Filtering even numbers from a list
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
   numbers.stream()
          .filter(n -> n % 2 == 0)
          .forEach(n -> System.out.println(n));
   ```

### Key Points to Remember:
- **Functional Interface**: Lambda expressions in Java work with functional interfaces (interfaces with a single abstract method). Examples include `Runnable`, `Comparator`, `Function`, `Predicate`, etc.
- **Type Inference**: The compiler can infer the type of parameters in lambda expressions. So, you don't always need to explicitly define the type (as long as the target type is clear).
  
   ```java
   // Type inference example
   Consumer<String> print = s -> System.out.println(s);
   ```

- **No `this` reference in lambda**: The `this` keyword in a lambda refers to the enclosing class, not the lambda expression itself. If you want to refer to the instance of the lambda expression, you can use the `LambdaClassName.this` syntax.

### Example of Functional Interfaces:

1. **Predicate (Functional Interface)**

   A `Predicate` takes one parameter and returns a boolean value.

   ```java
   Predicate<Integer> isEven = (n) -> n % 2 == 0;
   System.out.println(isEven.test(4)); // Output: true
   ```

2. **Consumer (Functional Interface)**

   A `Consumer` takes one parameter and does not return a value.

   ```java
   Consumer<String> printMessage = message -> System.out.println(message);
   printMessage.accept("Lambda Expression in Java 8");
   ```

3. **Supplier (Functional Interface)**

   A `Supplier` takes no parameters and returns a value.

   ```java
   Supplier<String> getMessage = () -> "Hello, Java 8!";
   System.out.println(getMessage.get());
   ```

### Conclusion:

Lambda expressions in Java 8 make code more concise and readable, particularly in functional-style programming. They are particularly useful when working with collections, handling concurrency, or dealing with APIs that expect functional interfaces.

---
### 2. **Functional Interfaces**

A **functional interface** is an interface with a single abstract method. It can have multiple default and static methods, but it must have one and only one abstract method.

- **Purpose**: Functional interfaces can be used as the target types for lambda expressions and method references.

**Example**:
```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void execute();
    
    default void printMessage() {
        System.out.println("This is a default message");
    }
}
```

Common built-in functional interfaces in Java 8:
- **`Predicate<T>`**: Represents a boolean-valued function.
- **`Function<T, R>`**: Takes one argument and returns a result.
- **`Consumer<T>`**: Takes an argument and performs an action.
- **`Supplier<T>`**: Takes no argument and provides a result.
- **`BiFunction<T, U, R>`**: Takes two arguments and returns a result.

---
## Functional Interface

In Java, a **functional interface** is an interface that has exactly one abstract method (method without a body). Functional interfaces are intended to be used primarily with lambda expressions, method references, and other functional-style constructs introduced in Java 8. These interfaces enable you to pass behavior as arguments to methods and support functional programming paradigms in Java.

### Key Characteristics of a Functional Interface:
1. **Single Abstract Method (SAM)**: A functional interface must have exactly one abstract method.
2. **Can have multiple default or static methods**: In addition to the single abstract method, a functional interface can have any number of **default** or **static** methods. These methods provide default behavior and do not affect the interface's functional status.
3. **Can be annotated with `@FunctionalInterface` (optional)**: The `@FunctionalInterface` annotation is not required, but it helps to explicitly declare that an interface is intended to be a functional interface. If you annotate a non-functional interface with `@FunctionalInterface`, the compiler will generate an error.

### Example of a Functional Interface:
Here's a simple example of a functional interface:

```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void myMethod();  // Single abstract method

    // Default method (can be present, but doesn't interfere with SAM)
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }

    // Static method (can also be present)
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}
```

In the example above, `MyFunctionalInterface` has only **one abstract method** (`myMethod()`), which makes it a valid functional interface. It also has a default method (`defaultMethod()`) and a static method (`staticMethod()`), both of which are allowed in a functional interface.

### Using Functional Interfaces with Lambda Expressions:

A functional interface is often used with lambda expressions, which provide a concise way to implement its abstract method.

Example of using the functional interface `MyFunctionalInterface`:

```java
public class Main {
    public static void main(String[] args) {
        // Using lambda expression to implement the functional interface
        MyFunctionalInterface myFunc = () -> System.out.println("Hello from myMethod!");
        
        // Calling the method of the functional interface
        myFunc.myMethod();  // Output: Hello from myMethod!
        
        // Calling the default method
        myFunc.defaultMethod();  // Output: This is a default method.
        
        // Calling the static method
        MyFunctionalInterface.staticMethod();  // Output: This is a static method.
    }
}
```

In this example:
- We use a **lambda expression** (`() -> System.out.println("Hello from myMethod!")`) to provide an implementation for the abstract method `myMethod()` of `MyFunctionalInterface`.
- We also demonstrate calling a **default method** and **static method**, which are allowed in functional interfaces.

### Built-in Functional Interfaces in Java:

Java 8 introduced several built-in functional interfaces in the `java.util.function` package. These interfaces can be used with lambda expressions or method references. Here are some commonly used functional interfaces:

1. **`Predicate<T>`**: Represents a boolean-valued function (test condition).
   ```java
   Predicate<Integer> isEven = (n) -> n % 2 == 0;
   System.out.println(isEven.test(4));  // Output: true
   ```

2. **`Function<T, R>`**: Represents a function that takes an argument of type `T` and returns a result of type `R`.
   ```java
   Function<Integer, String> toString = (n) -> "Number: " + n;
   System.out.println(toString.apply(5));  // Output: Number: 5
   ```

3. **`Consumer<T>`**: Represents an operation that accepts a single input argument and returns no result.
   ```java
   Consumer<String> printMessage = (message) -> System.out.println(message);
   printMessage.accept("Hello from Consumer!");  // Output: Hello from Consumer!
   ```

4. **`Supplier<T>`**: Represents a supplier of results, taking no arguments and returning a result.
   ```java
   Supplier<String> supplyMessage = () -> "Hello from Supplier!";
   System.out.println(supplyMessage.get());  // Output: Hello from Supplier!
   ```

5. **`BiFunction<T, U, R>`**: Represents a function that takes two arguments (`T` and `U`) and returns a result (`R`).
   ```java
   BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
   System.out.println(add.apply(3, 4));  // Output: 7
   ```

6. **`UnaryOperator<T>`**: A special case of `Function` where the input and output are of the same type.
   ```java
   UnaryOperator<Integer> square = (n) -> n * n;
   System.out.println(square.apply(5));  // Output: 25
   ```

7. **`BinaryOperator<T>`**: A special case of `BiFunction` where the two arguments and the result are of the same type.
   ```java
   BinaryOperator<Integer> addNumbers = (a, b) -> a + b;
   System.out.println(addNumbers.apply(5, 3));  // Output: 8
   ```

### The `@FunctionalInterface` Annotation:

While not required, it's a good practice to use the `@FunctionalInterface` annotation to explicitly mark an interface as a functional interface. The compiler will enforce the rule that the interface has only one abstract method, and if you add more than one, it will throw an error.

Example:

```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void doSomething();  // Single abstract method

    default void defaultMethod() {
        System.out.println("This is a default method.");
    }
}
```

The `@FunctionalInterface` annotation is optional, but it makes the code more readable and helps catch errors at compile-time if the interface is not a valid functional interface.

### Conclusion:

A **functional interface** in Java 8 is an interface with a single abstract method, and it can be used with lambda expressions to provide a clean and concise way to represent behavior. Java 8's functional interfaces, especially those in the `java.util.function` package, have become an essential part of Java's functional programming features, making it easier to write code in a declarative and functional style.

---



### 4. **Default Methods in Interfaces**

Java 8 allows you to define **default methods** in interfaces. These are methods with a default implementation, which means you can provide a default behavior in the interface itself without requiring implementing classes to override them.

- **Why useful?** Default methods enable you to add new methods to existing interfaces without breaking existing code that implements those interfaces.

**Example**:
```java
public interface MyInterface {
    default void defaultMethod() {
        System.out.println("This is a default method");
    }
}
```

---

### 5. **Static Methods in Interfaces**

Java 8 also allows you to define **static methods** in interfaces. These are similar to static methods in classes, and they can be called without an instance of the interface.

**Example**:
```java
public interface MyInterface {
    static void staticMethod() {
        System.out.println("This is a static method");
    }
}
```

---

In Java, **functional interfaces** play a significant role in enabling functional programming features introduced in Java 8, such as **lambda expressions** and **method references**. To understand why functional interfaces have the constraints they do (e.g., only one abstract method) and why **default** and **static** methods are allowed, let's explore the rationale behind these design choices.

### Why Only One Abstract Method in a Functional Interface?

The primary reason why a **functional interface** must have exactly one abstract method is to ensure that it can be used as a **target type** for lambda expressions and method references. A lambda expression defines a single behavior or function, and it needs to map directly to one method. Having more than one abstract method in the interface would create ambiguity, making it unclear which method the lambda expression should implement.

#### Key Reasons:
1. **Simplicity**: A functional interface represents a single operation or behavior. If an interface had multiple abstract methods, it would no longer be possible to associate a single lambda expression with the interface, making it impossible to express a simple, concise operation.

   - **Single abstract method** → One behavior (function) → One lambda expression.
   - **Multiple abstract methods** → Ambiguity in behavior → Cannot be represented by a single lambda expression.

2. **Lambda Expression Semantics**: A lambda expression represents a function that implements a single abstract method. By restricting the interface to one abstract method, the lambda expression can be seen as implementing that method, leading to cleaner, more understandable code.

3. **Target Type for Lambda Expressions**: Java allows you to assign a lambda expression to a variable of a functional interface type, and the compiler can infer which abstract method to implement. If the interface had more than one abstract method, this would not be possible without some ambiguity in deciding which method the lambda should implement.

### Why Allow Default and Static Methods in Functional Interfaces?

While a functional interface must have exactly one abstract method, it is allowed to have **default** and **static** methods. The purpose of allowing default and static methods is to provide flexibility in how interfaces are designed and used, without breaking the contract of a functional interface.

#### 1. **Default Methods**:
   - **Definition**: A `default` method is a method with a body that provides a default implementation. It allows a class (or interface) implementing the interface to use the default behavior or override it if necessary.
   
   - **Why Needed**:
     - **Extensibility**: Java 8 introduced **default methods** to enable interfaces to evolve over time. Without default methods, adding new methods to an existing interface would break existing implementations of that interface. With default methods, new methods can be added without requiring existing classes to implement them.
     - **Code Reusability**: Default methods can provide a default implementation of behavior that all implementing classes can share. For example, in a functional interface, you might want to provide a common implementation of a helper method that can be used by all implementing classes but still allow the main abstract method to be defined by the implementing class.
   
   - **Example**:
     ```java
     @FunctionalInterface
     public interface MyFunctionalInterface {
         void execute(); // Abstract method
        
         // Default method
         default void defaultMethod() {
             System.out.println("This is a default method.");
         }
     }
     ```
     In this example, the interface defines one abstract method (`execute`) and a `default` method (`defaultMethod`). The default method provides shared behavior for all classes that implement this interface.

#### 2. **Static Methods**:
   - **Definition**: A `static` method belongs to the interface itself rather than to instances of implementing classes. Static methods can be called without creating an instance of the interface.
   
   - **Why Needed**:
     - **Utility Methods**: Static methods can provide utility methods related to the interface but are not part of the instance-specific behavior. These methods are useful when you need to have behavior that is tied to the interface itself, rather than to a specific instance of a class implementing the interface.
     - **Code Organization**: They allow functionality that complements the abstract method(s) but doesn’t need to be overridden by implementing classes.
   
   - **Example**:
     ```java
     @FunctionalInterface
     public interface MyFunctionalInterface {
         void execute();  // Abstract method
        
         // Static method
         static void staticMethod() {
             System.out.println("This is a static method.");
         }
     }
     ```
     Here, `staticMethod()` is a static method of the interface, which can be called without an instance of `MyFunctionalInterface`. Static methods are not inherited by implementing classes but can be accessed directly from the interface.

### Why Do We Need Default and Static Methods?

- **Backward Compatibility**: In Java 8, interfaces were extended to support default and static methods to allow developers to **evolve interfaces** without breaking existing code. This is particularly useful in large codebases where interfaces have been in use for a long time and adding a new abstract method would require all implementing classes to provide a new implementation. Default and static methods allow new functionality to be added without breaking backward compatibility.
  
- **Separation of Concerns**: Default and static methods allow an interface to provide a **default implementation** of certain behaviors (without forcing all implementing classes to provide their own) and allow **utility methods** that may help in the context of that interface. These methods are optional, and implementing classes can either use the default behavior or override it if needed.
  
- **Encapsulation**: Static and default methods are a way to add additional functionality that is tied to the interface itself, not to individual objects. This helps separate concerns and keeps the interface focused on defining the abstract behavior, while still providing additional functionality where needed.

### Example: Using Default and Static Methods

Here’s an example that demonstrates both default and static methods within a functional interface:

```java
@FunctionalInterface
public interface Operation {
    int apply(int a, int b);  // Single abstract method

    // Default method providing a common behavior
    default void printResult(int result) {
        System.out.println("The result is: " + result);
    }

    // Static method providing utility
    static int add(int a, int b) {
        return a + b;
    }
}
```

- **Default Method (`printResult`)**: This method provides a default behavior that prints the result of an operation, but it can be overridden if necessary.
- **Static Method (`add`)**: This static method performs a simple addition operation, which can be called without an instance of `Operation`.

### Example Usage:

```java
public class Main {
    public static void main(String[] args) {
        // Lambda expression implementing the abstract method
        Operation addition = (a, b) -> a + b;

        // Calling the abstract method
        int result = addition.apply(5, 3);
        
        // Calling the default method
        addition.printResult(result);  // Output: The result is: 8

        // Calling the static method
        int staticResult = Operation.add(10, 20);
        System.out.println("Static add result: " + staticResult);  // Output: Static add result: 30
    }
}
```

### Conclusion:

- **Single Abstract Method**: The reason a functional interface must have only one abstract method is to ensure that it can represent a single, specific behavior, which is then implemented via a lambda expression or method reference. This makes lambda expressions and functional interfaces highly efficient and easy to use.
  
- **Default and Static Methods**: These are allowed in functional interfaces to provide additional functionality, enable interface evolution without breaking existing code, and support utility methods that are tied to the interface rather than an instance. Default methods enhance flexibility by providing common implementations, while static methods support utility operations.

In short, the combination of a single abstract method with optional default and static methods strikes a balance between **simplicity** (single abstract method) and **flexibility** (default and static methods), making functional interfaces powerful tools in Java's functional programming toolkit.

### 6. **Method References**

Method references provide a shorthand syntax for calling methods directly using the `::` operator. They are often used in combination with streams and lambdas to make the code more readable.

**Example**:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(System.out::println);  // Method reference to println
```

Method references can be used for:
- **Static methods**: `ClassName::staticMethod`
- **Instance methods**: `object::instanceMethod`
- **Constructor references**: `ClassName::new`

---

### 3. **Streams API**

The **Streams API** is one of the most powerful features in Java 8. It allows you to process sequences of elements (such as collections) in a functional style, enabling operations like filtering, mapping, and reducing in a clean and efficient way.

- **Key Operations**:
  - **Intermediate operations** (e.g., `filter()`, `map()`, `sorted()`) return a new stream.
  - **Terminal operations** (e.g., `collect()`, `forEach()`, `reduce()`) trigger the processing of the stream.

**Example**:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

names.stream()
     .filter(name -> name.length() > 3)
     .map(String::toUpperCase)
     .forEach(System.out::println);
```
This example filters names with more than 3 characters, converts them to uppercase, and prints them.

---


### 7. **Optional Class**

The **`Optional<T>`** class is a container object which may or may not contain a non-null value. It helps avoid `NullPointerException` by providing methods to handle the presence or absence of a value without explicitly checking for `null`.

- **Usage**: Instead of returning `null` for empty or missing values, return `Optional.empty()`.
  
**Example**:
```java
Optional<String> name = Optional.ofNullable(getName());
name.ifPresent(System.out::println);  // Prints if value is present, does nothing otherwise
```

---

### 8. **New Date and Time API (java.time)**

Java 8 introduced a completely new **Date and Time API** under the `java.time` package, which addresses the flaws of the old `java.util.Date` and `java.util.Calendar`. It includes classes such as:
- **`LocalDate`**: For date without time.
- **`LocalTime`**: For time without date.
- **`LocalDateTime`**: For both date and time.
- **`ZonedDateTime`**: For date and time with timezone.
- **`Instant`**: For a point in time (timestamps).

**Example**:
```java
LocalDate date = LocalDate.now();
System.out.println(date);  // Prints the current date in ISO-8601 format (e.g., 2024-12-13)
```

---

### 9. **Nashorn JavaScript Engine**

Java 8 introduced **Nashorn**, a much faster JavaScript engine than the previous Rhino engine. It allows you to embed JavaScript code within Java applications and execute it dynamically.

**Example**:
```java
ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
engine.eval("print('Hello from JavaScript in Java!')");
```

---

### 10. **Streams and Parallel Streams**

Java 8 introduced the ability to perform **parallel processing** on collections using streams. This allows you to easily process data concurrently using the **parallelStream()** method.

**Example**:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.parallelStream()
                  .mapToInt(Integer::intValue)
                  .sum();
System.out.println(sum);  // The sum of numbers will be calculated in parallel
```

---

### 11. **Collectors Class**

The **`Collectors`** class provides utility methods to perform common reduction operations, such as **collecting elements into collections** or **grouping** and **partitioning** data.

- **Example**:
  - `Collectors.toList()`
  - `Collectors.joining()`
  - `Collectors.groupingBy()`
  - `Collectors.partitioningBy()`

**Example**:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

Map<Integer, List<String>> groupedByLength = names.stream()
    .collect(Collectors.groupingBy(String::length));

System.out.println(groupedByLength);  // Group names by their length
```

---

### 13. **Type Annotations**

Java 8 allows **type annotations** to be used in the program. This means you can apply annotations not only to variables, methods, and fields, but also to **type parameters** (e.g., generics).

**Example**:
```java
public class Example<T> {
    public void process(@NonNull T value) {
        // ...
    }
}
```

---

### 14. **Improved Type Inference**

Java 8 introduced improved type inference with **diamond operator** (`<>`), which simplifies the creation of generics. This is useful when instantiating objects with generics.

**Example**:
```java
List<String> list = new ArrayList<>();  // Compiler infers the type (List<String>)
```

---

### Conclusion:

Java 8 brought significant advancements, especially in functional programming. The addition of lambda expressions, functional interfaces, the Streams API, the new Date/Time API, and default methods in interfaces helped modernize Java and make it more expressive, concise, and flexible. These changes laid the groundwork for Java to be more competitive in the era of functional programming and to support modern, scalable applications.

---

