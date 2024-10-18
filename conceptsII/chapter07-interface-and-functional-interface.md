# Interface
Java is a typed language, even if you don't explicitly write a type
the compiler you compute the type of every variables
Once you start to want to mix several records, you may need to declare
common type between records, such type are known as interface

## The problem
let say we have a Square and Rectangle, and both have a method `area()`
```java
record Square(int side) {
  public double area() {
    return side * side;
  }
}
record Rectangle(int width, int height) {
  public double area() {
    return width * height;
  }
}
```

let create a list of a square and a rectangle
```java
var figures = List.of(new Square(2), new Rectangle(3, 4));
```

try to loop over the elements of the figures to print the area doesn't compile
```java
for(var figure: figures) {
  System.out.println(figure.area());
}
```

The problem is that compiler try to find the type of the element of the list
and find that they are java.lang.Object, and Object has no method area()
so the code does not compile


### Interface and abstract method
The idea is to introduce a type Figure has a common type for Square and Rectangle.
In Java, we use the keyword `interface` for that.

The method `area()` in Figure is not a classical method with some code because
the code is defined in Square and Rectangle. It's an `abstract` method.
The definition of the method is present but the code has to be implemented by the
records that implement the interface
```java
interface Figure {
  public abstract double area();
}
```

and declare that a Square and a Rectangle are a kind of Figure
using the keyword `implements`
```java
record Square(int side) implements Figure {
  public double area() {
    return side * side;
  }
}
record Rectangle(int width, int height) implements Figure {
  public double area() {
    return width * height;
  }
}
```

Now, the list is correctly typed as a list of figure (`List<Figure>`)
so looping over the figures to call `area()` works
```java
List<Figure> figures = List.of(new Square(2), new Rectangle(3, 4));
for(var figure: figures) {
  System.out.println(figure.area());
}
```

An interface is a common type that you need to declare when you want to
call the same method on different records
At runtime, when you call a method of the interface, the virtual machine calls
the correct implementation (this is called polymorphism)


## Static method
Like a record, an interface can have `static` methods
```java
interface Figure {
  public abstract double area();
  public static Figure createASquare(int side) {
    return new Square(side);
  }
}
var aSquare = Figure.createASquare(3);
System.out.println(aSquare);
```


## Default method
Inside an interface, the instance methods are implicitly abstract,
if we want to declare a method with some code in it, we have to use
the keyword `default`.
By example, we can write a method `isBig` that is true if the area is big enough.
```java
interface Figure {
  public abstract double area();
  public default boolean isBig() {
    return area() >= 10;
  }
}
System.out.println(new Square(2).isBig());
System.out.println(new Rectangle(3, 4).isBig());
```

Because a default method is declared on the interface, all records that
implement that interface will have that method. Default methods are named like this
because if a record that implements the interface doesn't define the method,
the method will be provided by default.


## Functional interface
An interface with only one abstract method is equivalent to a function type.
We name this kind of interfaces, _functional_ interfaces.
They can be implemented by two special constructs.

### Lambda
The parameter are declared in between the parenthesis and the body of the method
is declared after the arrow (like the expression switch).
```java
interface Figure {
  public abstract double area();
}
Figure anotherFigure = () -> 4;
System.out.println(anotherFigure.area());
```

and rewrite the method rectangularTriangle()
You can notice that a lambda can access to the parameter `width` and `height`
```java
Figure rectangularTriangle(int width, int height) {
  return () -> width * height / 2.0;
}
var triangle = rectangularTriangle(3, 4);
System.out.println(triangle.area());
```


### Method Reference
In case of the method already exists instead of 
calling it inside a lambda, we can make a reference on it using the operator ::
(notice that EquilaterlaTriangle doesn't implement Figure)
```java
record EquilateralTriangle(int side) {
  double area() {
    return Math.sqrt(3) * side * side / 4.0;
  }
}
var equilateral = new EquilateralTriangle(2);
```

so instead of
```java
var figures = List.<Figure>of(new Square(2), () -> equilateral.area());
for(var figure: figures) {
  System.out.println(figure.area());
}
```

you can use a method reference
```java
var figures = List.<Figure>of(new Square(2), equilateral::area);
for(var figure: figures) {
  System.out.println(figure.area());
}
```
---
# Java Functional Programming

Java has increasingly embraced functional programming concepts, especially with the introduction of Java 8. This approach focuses on using functions as first-class citizens, allowing for more concise and expressive code. Below is an overview of key concepts in Java functional programming.

## Table of Contents

- [1. Java Higher Order Functions](#1-java-higher-order-functions)
- [2. Java Functional Interfaces](#2-java-functional-interfaces)
- [3. Java Functional Composition](#3-java-functional-composition)
- [4. Java Stream API](#4-java-stream-api)

---

## 1. Java Higher Order Functions
Higher order functions are functions that can take other functions as parameters or return them as results. This allows for greater flexibility and code reuse.

### Example:
```java
import java.util.function.Function;

public class HigherOrderExample {
    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> result = applyFunction(square, 5);
        System.out.println(result); // Outputs: 25
    }

    static Integer applyFunction(Function<Integer, Integer> func, Integer value) {
        return func.apply(value);
    }
}
```

## 2. Java Functional Interfaces
A functional interface is an interface that contains exactly one abstract method. These interfaces can be implemented using lambda expressions or method references.

### Common Functional Interfaces:
- **`Predicate<T>`**: Represents a boolean-valued function of one argument.
- **`Function<T, R>`**: Represents a function that accepts one argument and produces a result.
- **`Consumer<T>`**: Represents an operation that accepts a single input argument and returns no result.
- **`Supplier<T>`**: Represents a supplier of results.

### Example:
```java
import java.util.function.Function;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        Function<String, Integer> stringLength = String::length;
        System.out.println(stringLength.apply("Hello")); // Outputs: 5
    }
}
```

## 3. Java Functional Composition
Functional composition allows you to combine multiple functions into a single function. This enables more modular and reusable code.

### Example:
```java
import java.util.function.Function;

public class CompositionExample {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleValue = x -> x * 2;
        Function<Integer, Integer> addThree = x -> x + 3;

        // Compose the two functions
        Function<Integer, Integer> composedFunction = doubleValue.andThen(addThree);
        System.out.println(composedFunction.apply(5)); // Outputs: 13
    }
}
```

## 4. Java Stream API
The Stream API is a powerful feature that enables functional-style operations on sequences of elements, such as collections. It allows for easy manipulation and processing of data.

### Key Operations:
- **Filtering**: Using `filter()` to select elements based on a condition.
- **Mapping**: Using `map()` to transform elements.
- **Reducing**: Using `reduce()` to aggregate results.

### Example:
```java
import java.util.Arrays;
import java.util.List;

public class StreamApiExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Calculate the sum of squares of even numbers
        int sum = numbers.stream()
                         .filter(n -> n % 2 == 0)
                         .map(n -> n * n)
                         .reduce(0, Integer::sum);

        System.out.println(sum); // Outputs: 20
    }
}
```

---

# Java Functional Programming

Java functional programming refers to functional programming practices applied within the Java programming language. While Java's support for functional programming was historically limited, Java 8 introduced features that make it more accessible and effective. This tutorial covers the foundational concepts of functional programming as they relate to Java.

## Table of Contents

- [1. Functional Programming Basics](#1-functional-programming-basics)
- [2. Functions as First Class Objects](#2-functions-as-first-class-objects)
- [3. Pure Functions](#3-pure-functions)
- [4. Higher Order Functions](#4-higher-order-functions)
- [5. No State](#5-no-state)
- [6. No Side Effects](#6-no-side-effects)
- [7. Immutable Variables](#7-immutable-variables)
- [8. Favour Recursion Over Looping](#8-favour-recursion-over-looping)
- [9. Functional Interfaces](#9-functional-interfaces)

---

## 1. Functional Programming Basics
Functional programming is characterized by several key concepts:
- Functions as first class objects
- Pure functions
- Higher order functions

### Pure Functional Programming Rules
Pure functional programming adheres to specific rules:
- **No state**: Functions should not rely on external state.
- **No side effects**: Functions should not affect external state.
- **Immutable variables**: Variables should not change after being assigned.
- **Favour recursion over looping**: Use recursive calls instead of loops for iteration.

Even if all these rules aren't followed strictly, functional programming concepts can still be beneficial.

---

## 2. Functions as First Class Objects
In functional programming, functions are treated as first class citizens, meaning they can be assigned to variables, passed as arguments, and returned from other functions. In Java, this is achieved through lambda expressions.

### Example:
```java
import java.util.function.Function;

public class FunctionAsFirstClass {
    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // Outputs: 25
    }
}
```

---

## 3. Pure Functions
A pure function is one where the output is determined solely by its input parameters and has no side effects.

### Example of a Pure Function:
```java
public class ObjectWithPureFunction {
    public int sum(int a, int b) {
        return a + b;
    }
}
```

### Example of a Non-Pure Function:
```java
public class ObjectWithNonPureFunction {
    private int value = 0;

    public int add(int nextValue) {
        this.value += nextValue;
        return this.value;
    }
}
```

---

## 4. Higher Order Functions
A higher order function either takes other functions as parameters or returns a function as a result.

### Example:
```java
public class HigherOrderFunctionClass {
    public <T> IFactory<T> createFactory(IProducer<T> producer, IConfigurator<T> configurator) {
        return () -> {
           T instance = producer.produce();
           configurator.configure(instance);
           return instance;
        };
    }
}
```

### Functional Interfaces:
```java
public interface IFactory<T> {
   T create();
}
public interface IProducer<T> {
   T produce();
}
public interface IConfigurator<T> {
   void configure(T t);
}
```

---

## 5. No State
The principle of "no state" means that functions should not rely on external state, only using local variables.

### Example of No External State:
```java
public class Calculator {
    public int sum(int a, int b) {
       return a + b;
    }
}
```

### Example of External State:
```java
public class Calculator {
    private int initVal = 5;

    public int sum(int a) {
       return initVal + a; // Violates no state rule
    }
}
```

---

## 6. No Side Effects
Functions should not change any external state. This includes not modifying member variables of a class or affecting external systems.

---

## 7. Immutable Variables
Immutable variables help to avoid side effects, ensuring that once a variable is assigned, it cannot change.

### Example:
```java
final int constantValue = 10; // constantValue cannot be changed
```

---

## 8. Favour Recursion Over Looping
Functional programming encourages the use of recursion for iteration, allowing for more functional code.

### Example of Recursion:
```java
public class Factorial {
    public int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }
}
```

---

## 9. Functional Interfaces
A functional interface is an interface with only one abstract method. They can have multiple default or static methods but must retain one abstract method.

### Example of a Functional Interface:
```java
public interface MyInterface {
    void run();
}
```

### Example with Default and Static Methods:
```java
public interface MyInterface2 {
    void run();

    default void doIt() {
        System.out.println("doing it");
    }

    static void doItStatically() {
        System.out.println("doing it statically");
    }
}
```

---

# Java Higher Order Functions

A higher order function is a function that either takes another function as a parameter or returns a function after its execution. In this section, we'll explore some examples of higher order functions in Java, particularly focusing on sorting collections.

## Table of Contents

- [1. Higher Order Functions Overview](#1-higher-order-functions-overview)
- [2. Sorting Collections](#2-sorting-collections)
- [3. Sorting in Reverse Order](#3-sorting-in-reverse-order)

---

## 1. Higher Order Functions Overview
Higher order functions are a fundamental concept in functional programming. They allow functions to be treated as first-class citizens, meaning functions can be passed as arguments or returned as values. This enables a more flexible and expressive programming style.

---

## 2. Sorting Collections
One of the classic examples of a higher order function in Java is the `Collections.sort()` method, which takes a `Comparator` as a parameter. The `Comparator` defines the order in which elements are sorted.

### Example:
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Abc");
        list.add("BCD");

        // Sorting the list using a lambda expression as a Comparator
        Collections.sort(list, (String a, String b) -> {
            return a.compareTo(b);
        });

        System.out.println(list);  // Output: [Abc, BCD, One]
    }
}
```
In this example:
- `Collections.sort()` takes two parameters: the list to be sorted and a lambda expression that defines the sorting logic. 
- The lambda expression `(String a, String b) -> a.compareTo(b)` implements the `compare` method of the `Comparator` interface.

---

## 3. Sorting in Reverse Order
Another example of a higher order function is when a function returns another function. The `Comparator` interface provides a method called `reversed()` that creates a comparator for reverse ordering.

### Example:
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReverseSortExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Abc");
        list.add("BCD");

        // Create a Comparator for natural ordering
        Comparator<String> comparator = (String a, String b) -> {
            return a.compareTo(b);
        };

        // Create a reversed Comparator
        Comparator<String> comparatorReversed = comparator.reversed();

        // Sorting the list in reverse order
        Collections.sort(list, comparatorReversed);

        System.out.println(list);  // Output: [One, BCD, Abc]
    }
}
```
In this example:
1. A `Comparator` is created using a lambda expression that defines the natural ordering.
2. The `reversed()` method is called on the `Comparator`, which returns a new `Comparator` that reverses the comparison result.
3. Finally, `Collections.sort()` uses this reversed comparator to sort the list in descending order.

---

# Java Functional Interfaces

In Java, a functional interface is an interface that contains only one abstract method. Introduced in Java 8, functional interfaces can be implemented using lambda expressions, making it easier to pass behavior as parameters in functional programming. They may also contain default and static methods with implementations.

## Table of Contents

- [1. Overview of Functional Interfaces](#1-overview-of-functional-interfaces)
- [2. Implementing Functional Interfaces with Lambda Expressions](#2-implementing-functional-interfaces-with-lambda-expressions)
- [3. Built-in Functional Interfaces](#3-built-in-functional-interfaces)
  - [3.1 Function](#31-function)
  - [3.2 Predicate](#32-predicate)
  - [3.3 UnaryOperator](#33-unaryoperator)
  - [3.4 BinaryOperator](#34-binaryoperator)
  - [3.5 Supplier](#35-supplier)
  - [3.6 Consumer](#36-consumer)

---

## 1. Overview of Functional Interfaces

A functional interface is defined as follows:

```java
public interface MyFunctionalInterface {
    void execute();
}
```

In this example, `MyFunctionalInterface` contains a single abstract method, making it a functional interface. It can also include default and static methods:

```java
public interface MyFunctionalInterface2 {
    void execute();

    default void print(String text) {
        System.out.println(text);
    }

    static void print(String text, PrintWriter writer) throws IOException {
        writer.write(text);
    }
}
```

---

## 2. Implementing Functional Interfaces with Lambda Expressions

Functional interfaces can be implemented using lambda expressions. For instance, the following lambda expression implements `MyFunctionalInterface`:

```java
MyFunctionalInterface lambda = () -> {
    System.out.println("Executing...");
};
```

This allows for more concise and readable code.

---

## 3. Built-in Functional Interfaces

Java provides several built-in functional interfaces for common use cases:

### 3.1 Function

The `Function<T, R>` interface represents a function that takes a single parameter and returns a single value.

```java
public interface Function<T, R> {
    R apply(T t);
}
```

#### Example Implementation:

```java
public class AddThree implements Function<Long, Long> {
    @Override
    public Long apply(Long aLong) {
        return aLong + 3;
    }
}

// Using the Function interface
Function<Long, Long> adder = new AddThree();
Long result = adder.apply(4L);
System.out.println("result = " + result);  // Output: 7
```

You can also implement `Function` using a lambda expression:

```java
Function<Long, Long> adderLambda = (value) -> value + 3;
Long resultLambda = adderLambda.apply(8L);
System.out.println("resultLambda = " + resultLambda);  // Output: 11
```

### 3.2 Predicate

The `Predicate<T>` interface represents a function that takes a single value and returns a boolean.

```java
public interface Predicate<T> {
    boolean test(T t);
}
```

#### Example Implementation:

```java
Predicate<Object> checkForNull = (value) -> value != null;
```

### 3.3 UnaryOperator

The `UnaryOperator<T>` interface represents an operation that takes a single parameter and returns a result of the same type.

#### Example:

```java
UnaryOperator<Person> unaryOperator = (person) -> {
    person.name = "New Name";
    return person;
};
```

### 3.4 BinaryOperator

The `BinaryOperator<T>` interface represents an operation that takes two parameters of the same type and returns a single value.

#### Example:

```java
BinaryOperator<MyValue> binaryOperator = (value1, value2) -> {
    value1.add(value2);
    return value1;
};
```

### 3.5 Supplier

The `Supplier<T>` interface represents a function that supplies a value without taking any parameters.

#### Example:

```java
Supplier<Integer> supplier = () -> (int) (Math.random() * 1000);
```

### 3.6 Consumer

The `Consumer<T>` interface represents a function that takes a single parameter and returns no result. It is often used for operations that produce side effects.

#### Example:

```java
Consumer<Integer> consumer = (value) -> System.out.println(value);
```

---

# Java Functional Composition

Functional composition is a technique used to combine multiple functions into a single function that utilizes the composed functions internally. Java provides built-in support for functional composition, making it easier to create complex operations from simpler functions.

## Table of Contents

- [1. Java Functional Composition Example](#1-java-functional-composition-example)
- [2. Java Functional Composition Support](#2-java-functional-composition-support)
  - [2.1 Predicate Composition](#21-predicate-composition)
    - [2.1.1 and()](#211-and)
    - [2.1.2 or()](#212-or)
  - [2.2 Function Composition](#22-function-composition)
    - [2.2.1 compose()](#221-compose)
    - [2.2.2 andThen()](#222-andthen)

---

## 1. Java Functional Composition Example

Here’s a simple example of functional composition using `Predicate`:

```java
Predicate<String> startsWithA = (text) -> text.startsWith("A");
Predicate<String> endsWithX = (text) -> text.endsWith("x");

Predicate<String> startsWithAAndEndsWithX =
        (text) -> startsWithA.test(text) && endsWithX.test(text);

String input = "A hardworking person must relax";
boolean result = startsWithAAndEndsWithX.test(input);
System.out.println(result);  // Output: false
```

In this example, two predicates are defined to check if a string starts with "A" and ends with "x". The composed predicate returns true only if both conditions are satisfied.

---

## 2. Java Functional Composition Support

Java's functional interfaces include built-in methods that support functional composition.

### 2.1 Predicate Composition

The `Predicate` interface has methods that help compose new instances:

#### 2.1.1 and()

The `and()` method combines two `Predicate` instances.

```java
Predicate<String> composed = startsWithA.and(endsWithX);

String input = "A hardworking person must relax";
boolean result = composed.test(input);
System.out.println(result);  // Output: false
```

The composed predicate will return true if both `startsWithA` and `endsWithX` return true.

#### 2.1.2 or()

The `or()` method combines two `Predicate` instances, returning true if either predicate returns true.

```java
Predicate<String> composed = startsWithA.or(endsWithX);

String input = "A hardworking person must relax sometimes";
boolean result = composed.test(input);
System.out.println(result);  // Output: true
```

---

### 2.2 Function Composition

The `Function` interface also has methods for composition:

#### 2.2.1 compose()

The `compose()` method creates a new `Function` instance by first applying the passed function, then the original function.

```java
Function<Integer, Integer> multiply = (value) -> value * 2;
Function<Integer, Integer> add = (value) -> value + 3;

Function<Integer, Integer> addThenMultiply = multiply.compose(add);

Integer result1 = addThenMultiply.apply(3);
System.out.println(result1);  // Output: 12
```

Here, the function first adds 3, then multiplies the result by 2.

#### 2.2.2 andThen()

The `andThen()` method works in the opposite direction. It first applies the original function, then the passed function.

```java
Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

Integer result2 = multiplyThenAdd.apply(3);
System.out.println(result2);  // Output: 9
```

In this case, the function multiplies by 2, then adds 3.

**Note:** The behavior of `andThen()` is the same as calling `b.compose(a)` where `a` is the original function and `b` is the function passed to `andThen()`.

---

