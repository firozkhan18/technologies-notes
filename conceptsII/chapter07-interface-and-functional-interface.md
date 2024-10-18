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

By leveraging these functional programming concepts, Java developers can write cleaner, more maintainable, and more expressive code. This paradigm promotes immutability and helps reduce side effects, leading to more robust applications.

