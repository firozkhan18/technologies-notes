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
Java Stream API
Java Stream API Tutorial - Video Version
Java Stream Definition
Stream Processing
Obtain a Stream
Terminal and Non-Terminal Operations
Non-Terminal Operations
filter()
map()
flatMap()
distinct()
limit()
peek()
Terminal Operations
anyMatch()
allMatch()
noneMatch()
collect()
count()
findAny()
findFirst()
forEach()
min()
max()
reduce()
toArray()
Concatenate Streams
Create Stream From Array
Java Stream API Critique
Batch, Not Streaming
Chain, Not Graph
Internal, Not External Iteration

The Java Stream API provides a functional approach to processing collections of objects. The Java Stream API was added in Java 8 along with several other functional programming features. This Java Stream tutorial will explain how these functional streams work, and how you use them.

The Java Stream API is not related to the Java InputStream and Java OutputStream of Java IO. The InputStream and OutputStream are related to streams of bytes. The Java Stream API is for processing streams of objects - not bytes.

Java Stream API Tutorial - Video Version
I have a video version of this tutorial here:


### Java Stream Definition
A Java Stream is a component that is capable of internal iteration of its elements, meaning it can iterate its elements itself. In contrast, when you are using the Java Collections iteration features (e.g a Java Iterator or the Java for-each loop used with a Java Iterable) you have to implement the iteration of the elements yourself.

### Stream Processing
You can attach listeners to a Stream. These listeners are called when the Stream iterates the elements internally. The listeners are called once for each element in the stream. That way each listener gets to process each element in the stream. This is referred to as stream processing.

The listeners of a stream form a chain. The first listener in the chain can process the element in the stream, and then return a new element for the next listener in the chain to process. A listener can either return the same element or a new, depending on what the purpose of that listener (processor) is.

### Obtain a Stream
There are many ways to obtain a Java Stream. One of the most common ways to obtain a Stream is from a Java Collection. Here is an example of obtaining a Stream from a Java List:

List<String> items = new ArrayList<String>();

items.add("one");
items.add("two");
items.add("three");

Stream<String> stream = items.stream();    
This example first creates a Java List, then adds three Java Strings to it. Finally, the example calls the stream() method to obtain a Stream instance.

### Terminal and Non-Terminal Operations
The Stream interface has a selection of terminal and non-terminal operations. A non-terminal stream operation is an operation that adds a listener to the stream without doing anything else. A terminal stream operation is an operation that starts the internal iteration of the elements, calls all the listeners, and returns a result.

Here is a Java Stream example which contains both a non-terminal and a terminal operation:

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");

        Stream<String> stream = stringList.stream();

        long count = stream
            .map((value) -> { return value.toLowerCase(); })
            .count();

        System.out.println("count = " + count);

    }
}
The call to the map() method of the Stream interface is a non-terminal operation. It merely sets a lambda expression on the stream which converts each element to lowercase. The map() method will be covered in more detail later on.

The call to the count() method is a terminal operation. This call starts the iteration internally, which will result in each element being converted to lowercase and then counted.

The conversion of the elements to lowercase does not actually affect the count of elements. The conversion part is just there as an example of a non-terminal operation.

### Non-Terminal Operations
The non-terminal stream operations of the Java Stream API are operations that transform or filter the elements in the stream. When you add a non-terminal operation to a stream, you get a new stream back as result. The new stream represents the stream of elements resulting from the original stream with the non-terminal operation applied. Here is an example of a non-terminal operation added to a stream - which results in a new stream:

List<String> stringList = new ArrayList<String>();

stringList.add("ONE");
stringList.add("TWO");
stringList.add("THREE");
    
Stream<String> stream = stringList.stream();
    
Stream<String> stringStream =
    stream.map((value) -> { return value.toLowerCase(); });
Notice the call to stream map() . This call actually returns a new Stream instance representing the original stream of strings with the map operation applied.

You can only add a single operation to a given Stream instance. If you need to chain multiple operations after each other, you will need to apply the second operation to the Stream operation resulting from the first operation. Here is how that looks:

Stream<String> stringStream1 =
        stream.map((value) -> { return value.toLowerCase(); });

Stream<½String> stringStream2 =
        stringStream1.map((value) -> { return value.toUpperCase(); });
Notice how the second call to Stream map() is called on the Stream returned by the first map() call.

It is quite common to chain the calls to non-terminal operations on a Java Stream. Here is an example of chaining the non-terminal operation calls on Java streams:

Stream<String> stream1 = stream
  .map((value) -> { return value.toLowerCase(); })
  .map((value) -> { return value.toUpperCase(); })
  .map((value) -> { return value.substring(0,3); });
Many non-terminal Stream operations can take a Java Lambda Expression as parameter. This lambda expression implements a Java functional interface that fits the given non-terminal operation. For instance, the Function or Predicate interface. The parameter of the non-terminal operation method parameter is typically a functional interface - which is why it can also be implemented by a Java lambda expression.

filter()
The Java Stream filter() can be used to filter out elements from a Java Stream. The filter method takes a Predicate which is called for each element in the stream. If the element is to be included in the resulting Stream, the Predicate should return true. If the element should not be included, the Predicate should return false.

Here is an example of calling the Java Stream filter() method:

Stream<String> longStringsStream = stream.filter((value) -> {
    return value.length() >= 3;
});
map()
The Java Stream map() method converts (maps) an element to another object. For instance, if you had a list of strings it could convert each string to lowercase, uppercase, or to a substring of the original string, or something completely else. Here is a Java Stream map() example:

List<String> list = new ArrayList<String>();
Stream<String> stream = list.stream();

Stream<String> streamMapped = stream.map((value) -> value.toUpperCase());
flatMap()
The Java Stream flatMap() methods maps a single element into multiple elements. The idea is that you "flatten" each element from a complex structure consisting of multiple internal elements, to a "flat" stream consisting only of these internal elements.

For instance, imagine you have an object with nested objects (child objects). Then you can map that object into a "flat" stream consisting of itself plus its nested objects - or only the nested objects. You could also map a stream of Lists of elements to the elements themselves. Or map a stream of strings to a stream of words in these strings - or to the individual Character instances in these strings.

Here is an example that flatmaps a List of strings to the words in each string. This example should give you an idea about how flatMap() can be used to map a single element into multiple elements.

List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

stream.flatMap((value) -> {
    String[] split = value.split(" ");
    return (Stream<String>) Arrays.asList(split).stream();
})
.forEach((value) -> System.out.println(value))
;
This Java Stream flatMap() example first creates a List with 3 strings containing book titles. Then a Stream for the List is obtained, and flatMap() called.

The flatMap() operation called on the Stream has to return another Stream representing the flat mapped elements. In the example above, each original string is split into words, turned into a List, and the stream obtained and returned from that List.

Note that this example finishes with a call to forEach() which is a terminal operation. This call is only there to trigger the internal iteration, and thus flat map operation. If no terminal operation was called on the Stream chain, nothing would have happened. No flat mapping would actually have taken place.

distinct()
The Java Stream distinct() method is a non-terminal operation that returns a new Stream which will only contain the distinct elements from the original stream. Any duplicates will be eliminated. Here is an example of the Java Stream distinct() method:

List<String> stringList = new ArrayList<String>();

stringList.add("one");
stringList.add("two");
stringList.add("three");
stringList.add("one");

Stream<String> stream = stringList.stream();

List<String> distinctStrings = stream
        .distinct()
        .collect(Collectors.toList());

System.out.println(distinctStrings);
In this example the element one appears 2 times in the original stream. Only the first occurrence of this element will be included in the Stream returned by distinct(). Thus, the resulting List (from calling collect()) will only contain one, two and three. The output printed from this example will be:

[one, two, three]
limit()
The Java Stream limit() method can limit the number of elements in a stream to a number given to the limit() method as parameter. The limit() method returns a new Stream which will at most contain the given number of elements. Here is a Java Stream limit() example:

List<String> stringList = new ArrayList<String>();

stringList.add("one");
stringList.add("two");
stringList.add("three");
stringList.add("one");

Stream<String> stream = stringList.stream();
stream
    .limit(2)
    .forEach( element -> { System.out.println(element); });    
This example first creates a Stream, then calls limit() on it, and then calls forEach() with a lambda that prints out the elements in the stream. Only the two first elements will be printed because of the limit(2) call.

peek()
The Java Stream peek() method is a non-terminal operation that takes a Consumer (java.util.function.Consumer) as parameter. The Consumer will get called for each element in the stream. The peek() method returns a new Stream which contains all the elements in the original stream.

The purpose of the peek() method is, as the method says, to peek at the elements in the stream, not to transform them. Keep in mind that the peek method does not start the internal iteration of the elements in the stream. You need to call a terminal operation for that. Here is a Java Stream peek() example:

List<String> stringList = new ArrayList<String>();

stringList.add("abc");
stringList.add("def");

Stream<String> stream = stringList.stream();

Stream<String> streamPeeked = stream.peek((value) -> {
    System.out.println("value");
});
### Terminal Operations
The terminal operations of the Java Stream interface typicall return a single value. Once the terminal operation is invoked on a Stream, the iteration of the Stream and any of the chained streams will get started. Once the iteration is done, the result of the terminal operation is returned.

A terminal operation typically does not return a new Stream instance. Thus, once you call a terminal operation on a stream, the chaining of Stream instances from non-terminal operation ends. Here is an example of calling a terminal operation on a Java Stream:

long count = stream
  .map((value) -> { return value.toLowerCase(); })
  .map((value) -> { return value.toUpperCase(); })
  .map((value) -> { return value.substring(0,3); })
  .count();
It is the call to count() at the end of the example that is the terminal operation. Since count() returns a long, the Stream chain of non-terminal operations (the map() calls) is ended.

anyMatch()
The Java Stream anyMatch() method is a terminal operation that takes a single Predicate as parameter, starts the internal iteration of the Stream, and applies the Predicate parameter to each element. If the Predicate returns true for any of the elements, the anyMatch() method returns true. If no elements match the Predicate, anyMatch() will return false. Here is a Java Stream anyMatch() example:

List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

boolean anyMatch = stream.anyMatch((value) -> { return value.startsWith("One"); });
System.out.println(anyMatch);
In the example above, the anyMatch() method call will return true, because the first string element in the stream starts with "One".

allMatch()
The Java Stream allMatch() method is a terminal operation that takes a single Predicate as parameter, starts the internal iteration of elements in the Stream, and applies the Predicate parameter to each element. If the Predicate returns true for all elements in the Stream, the allMatch() will return true. If not all elements match the Predicate, the allMatch() method returns false. Here is a Java Stream allMatch() example:

List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

boolean allMatch = stream.allMatch((value) -> { return value.startsWith("One"); });
System.out.println(allMatch);
In the example above, the allMatch() method will return false, because only one of the strings in the Stream starts with "One".

noneMatch()
The Java Stream noneMatch() method is a terminal operation that will iterate the elements in the stream and return true or false, depending on whether no elements in the stream matches the Predicate passed to noneMatch() as parameter. The noneMatch() method will return true if no elements are matched by the Predicate, and false if one or more elements are matched. Here is a Java Stream noneMatch() example:

List<String> stringList = new ArrayList<String>();

stringList.add("abc");
stringList.add("def");

Stream<String> stream = stringList.stream();

boolean noneMatch = stream.noneMatch((element) -> {
    return "xyz".equals(element);
});

System.out.println("noneMatch = " + noneMatch);
collect()
The Java Stream collect() method is a terminal operation that starts the internal iteration of elements, and collects the elements in the stream in a collection or object of some kind. Here is a simple Java Stream collect() method example:

List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

List<String> stringsAsUppercaseList = stream
.map(value -> value.toUpperCase())
.collect(Collectors.toList());

System.out.println(stringsAsUppercaseList);
The collect() method takes a Collector (java.util.stream.Collector) as parameter. Implementing a Collector requires some study of the Collector interface. Luckily, the Java class java.util.stream.Collectors contains a set of pre-implemented Collector implementations you can use, for the most common operations. In the example above, it was the Collector implementation returned by Collectors.toList() that was used. This Collector simply collects all elements in the stream in a standard Java List

count()
The Java Stream count() method is a terminal operation which starts the internal iteration of the elements in the Stream, and counts the elements. Here is a Java Stream count() example:

List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

long count = stream.flatMap((value) -> {
    String[] split = value.split(" ");
    return (Stream<String>) Arrays.asList(split).stream();
})
.count();

System.out.println("count = " + count);
This example first creates a List of strings, then obtain the Stream for that List, adds a flatMap() operation for it, and then finishes with a call to count(). The count() method will start the iteration of the elements in the Stream which will result in the string elements being split up into words in the flatMap() operation, and then counted. The final result that will be printed out is 14.

findAny()
The Java Stream findAny() method can find a single element from the Stream. The element found can be from anywhere in the Stream. There is no guarantee about from where in the stream the element is taken. Here is a Java Stream findAny() example:

List<String> stringList = new ArrayList<String>();

stringList.add("one");
stringList.add("two");
stringList.add("three");
stringList.add("one");

Stream<String> stream = stringList.stream();

Optional<String> anyElement = stream.findAny();

System.out.println(anyElement.get());
Notice how the findAny() method returns an Optional. The Stream could be empty - so no element could be returned. You can check if an element was found via the Optional isPresent() method.

findFirst()
The Java Stream findFirst() method finds the first element in the Stream, if any elements are present in the Stream. The findFirst() method returns an Optional from which you can obtain the element, if present. Here is a Java Stream findFirst() example:

List<String> stringList = new ArrayList<String>();

stringList.add("one");
stringList.add("two");
stringList.add("three");
stringList.add("one");

Stream<String> stream = stringList.stream();

Optional<String> result = stream.findFirst();

System.out.println(result.get());
You can check if the Optional returned contains an element via its isPresent() method.

forEach()
The Java Stream forEach() method is a terminal operation which starts the internal iteration of the elements in the Stream, and applies a Consumer (java.util.function.Consumer) to each element in the Stream. The forEach() method returns void. Here is a Java Stream forEach() example:

List<String> stringList = new ArrayList<String>();

stringList.add("one");
stringList.add("two");
stringList.add("three");
stringList.add("one");

Stream<String> stream = stringList.stream();

stream.forEach( element -> { System.out.println(element); });
min()
The Java Stream min() method is a terminal operation that returns the smallest element in the Stream. Which element is the smallest is determined by the Comparator implementation you pass to the min() method. I have explained how the Comparator interface works in my tutorial about sorting Java collections. Here is a Java Stream min() example:

List<String> stringList = new ArrayList<String>();

stringList.add("abc");
stringList.add("def");

Stream<String> stream = stringList.stream();

Optional<String> min = stream.min((val1, val2) -> {
    return val1.compareTo(val2);
});

String minString = min.get();

System.out.println(minString);
Notice how the min() method returns an Optional which may or may not contain a result. If the Stream is empty, the Optional get() method will throw a NoSuchElementException.

max()
The Java Stream max() method is a terminal operation that returns the largest element in the Stream. Which element is the largest is determined by the Comparator implementation you pass to the max() method. I have explained how the Comparator interface works in my tutorial about sorting Java collections. Here is a Java Stream max() example:

List<String> stringList = new ArrayList<String>();

stringList.add("abc");
stringList.add("def");

Stream<String> stream = stringList.stream();

Optional<String> max = stream.max((val1, val2) -> {
    return val1.compareTo(val2);
});

String maxString = max.get();

System.out.println(maxString);
Notice how the max() method returns an Optional which may or may not contain a result. If the Stream is empty, the Optional get() method will throw a NoSuchElementException.

reduce()
The Java Stream reduce() method is a terminal operation that can reduce all elements in the stream to a single element. Here is a Java Stream reduce() example:

List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

Optional<String> reduced = stream.reduce((value, combinedValue) -> {
    return combinedValue + " + " + value;
});

System.out.println(reduced.get());
Notice the Optional returned by the reduce() method. This Optional contains the value (if any) returned by the lambda expression passed to the reduce() method. You obtain the value by calling the Optional get() method.

toArray()
The Java Stream toArray() method is a terminal operation that starts the internal iteration of the elements in the stream, and returns an array of Object containing all the elements. Here is a Java Stream toArray() example:

List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

Object[] objects = stream.toArray();
### Concatenate Streams
The Java Stream interface contains a static method called concat() which can concatenate two streams into one. The result is a new Stream which contains all of the elements from the first stream, followed by all of the elements from the second stream. Here is an example of using the Java Stream concat() method:

List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream1 = stringList.stream();

List<String> stringList2 = new ArrayList<>();
stringList2.add("Lord of the Rings");
stringList2.add("Planet of the Rats");
stringList2.add("Phantom Menace");

Stream<String> stream2 = stringList2.stream();

Stream<String> concatStream = Stream.concat(stream1, stream2);

List<String> stringsAsUppercaseList = concatStream
        .collect(Collectors.toList());

System.out.println(stringsAsUppercaseList);
### Create Stream From Array
The Java Stream interface contains a static method called of() which can be used to create a Stream from one or more objects. Here is an example of using the Java Stream of() metho:

Stream<String> streamOf = Stream.of("one", "two", "three");
### Java Stream API Critique
Having worked with other data streaming API's like the Apache Kafka Streams API, I have a bit of critique of the Java Stream API that I will share with you. They aren't big, important points of critique, but they are useful to have in the back of your head as you venture into stream processing.

### Batch, Not Streaming
Despite its name, the Java Stream API is not truly a stream processing API. The Java Stream API's terminal operations return the final result of iterating through all the elements in the stream, and providing the non-terminal and terminal operations to the elements. The result of the terminal operation is returned after the last element in the stream has been processed.

Returning a final result after having processed the last element of a stream is only possible if you know what element is the last in the stream. The only way to know if a given element is the last element in a stream is, if you are processing a batch which has a last element. In contrast, a true stream does not have a last element. You never know if a given element is the last or not. Therefore it is not possible to perform a terminal operation on a stream. The best you can do is to collect the temporary results after the processing of a given element, but this would be sampling, not a final result.

### Chain, Not Graph
The Java Stream API is designed so that a Stream instance can only be acted upon once. In other words, you can only add a single non-terminal operation to a Stream, resulting in a new Stream object. You can add another non-terminal operation to the resulting Stream object, but not to the first. The resulting structure of non-terminal Stream instances form a chain.

In a true stream processing API, the root stream and the event listeners can typically form a graph, not just a chain. Multiple listeners can listen to the root stream, and each listener may process the elements in the stream in its own way, and may forward a transformed element as a result. Each listener (non-terminal operation) can thus typically act as a stream itself which other listeners can listen to the results of. This is how Apache Kafka Streams is designed. Each listener (intermediate stream) could also have multiple listeners. The resulting structure forms a graph of listeners with listeners with listeners etc.

With a stream processing graph rather than a chain, there is not a single, final operation in the graph. By final operation I mean an operation which is guaranteed to be the last in the processing chain. Instead there can be multiple final operations. Each "leaf" in the graph is a final operation.

When your stream processing structure can be a graph with multiple final operations, the stream API cannot easily support terminal operations like the Java Stream API does. To support terminal operations easily, there has to be a single, final operation from which the final result is returned. A graph based stream processing API could instead support a "sample" operation where each node in the stream processing graph is asked for any value it may hold internally (e.g. a sum), if any (purely transforming listener nodes will not have any internal state).

### Internal, Not External Iteration
The Java Stream API is deliberately designed to have internal iteration of the elements in a Stream. The iteration is started when a terminal operation is invoked on the Stream. In fact, for terminal operations to be able to return a result, the terminal operation has to initiate the iteration of the elements in the Stream.

Some graph based stream processing APIs are also designed to kind of hide the iteration of the elements from the user of the API (e.g. Apache Kafka Streams and RxJava). However, personally I prefer a design where each stream node (root stream and listeners) could have elements passed to them via a method call, and have that element be passed through the complete graph for processing. Such a design would make it easier to test each listener in the graph, as you can configure the graph and push elements through it afterwards, and finally check the result (the sampled state of the graph). Such a design would also enable the stream processing graph to have elements pushed into it via multiple nodes in the graph, and not just via the root stream.
