# Java 8 Features

## Table of Contents
- [Java 8 Features](#java-8-features)
  - [What are the new features in Java 8 and JDK 8?](#what-are-the-new-features-in-java-8-and-jdk-8)
  - [What is "lambda"? What is the structure and features of using a lambda expression?](#what-is-lambda-what-is-the-structure-and-features-of-using-a-lambda-expression)
  - [What variables do lambda expressions have access to?](#what-variables-do-lambda-expressions-have-access-to)
  - [How do I sort a list of strings using a lambda expression?](#how-do-i-sort-a-list-of-strings-using-a-lambda-expression)
  - [What is a "method reference"?](#what-is-a-method-reference)
  - [What kinds of method references do you know?](#what-kinds-of-method-references-do-you-know)
  - [Explain the expression `System.out::println`.](#explain-the-expression-systemoutprintln)
  - [What are "functional interfaces"?](#what-are-functional-interfaces)
  - [What are the `Function<T, R>`, `DoubleFunction<R>`, `IntFunction<R>`, and `LongFunction<R>` functional interfaces for?](#what-are-the-functiont-r-doublefunctionr-intfunctionr-and-longfunctionr-functional-interfaces-for)
  - [What are the functional interfaces `UnaryOperator<T>`, `DoubleUnaryOperator`, `IntUnaryOperator`, and `LongUnaryOperator` for?](#what-are-the-functional-interfaces-unaryoperatort-doubleunaryoperator-intunaryoperator-and-longunaryoperator-for)
  - [What are the functional interfaces `BinaryOperator<T>`, `DoubleBinaryOperator`, `IntBinaryOperator`, and `LongBinaryOperator` for?](#what-are-the-functional-interfaces-binaryoperatort-doublebinaryoperator-intbinaryoperator-and-longbinaryoperator-for)
  - [What are the functional interfaces `Predicate<T>`, `DoublePredicate`, `IntPredicate`, and `LongPredicate` for?](#what-are-the-functional-interfaces-predicatet-doublepredicate-intpredicate-and-longpredicate-for)
  - [What are the functional interfaces `Consumer<T>`, `DoubleConsumer`, `IntConsumer`, and `LongConsumer` for?](#what-are-the-functional-interfaces-consumert-doubleconsumer-intconsumer-and-longconsumer-for)
  - [What are the functional interfaces `Supplier<T>`, `BooleanSupplier`, `DoubleSupplier`, `IntSupplier`, and `LongSupplier` for?](#what-are-the-functional-interfaces-suppliert-booleansupplier-doublesupplier-intsupplier-and-longsupplier-for)
  - [What is the functional interface of `BiConsumer<T,U>`?](#what-is-the-functional-interface-of-biconsumertu)
  - [What is the functional interface of `BiFunction<T,U,R>`?](#what-is-the-functional-interface-of-bifunctiontur)
  - [What is the functional interface of `BiPredicate<T,U>`?](#what-is-the-functional-interface-of-bipredicatetu)
  - [What are functional interfaces of the _To_Function type for?](#what-are-functional-interfaces-of-the-to_function-type-for)
  - [What are the `ToDoubleBiFunction<T,U>`, `ToIntBiFunction<T,U>`, and `ToLongBiFunction<T,U>` functional interfaces for?](#what-are-the-todoublebifunctiontu-tointbifunctiontu-and-tolongbifunctiontu-functional-interfaces-for)
  - [What are the `ToDoubleFunction<T>`, `ToIntFunction<T>`, and `ToLongFunction<T>` functional interfaces for?](#what-are-the-todoublefunctiont-tointfunctiont-and-tolongfunctiont-functional-interfaces-for)
  - [What are the `ObjDoubleConsumer<T>`, `ObjIntConsumer<T>`, and `ObjLongConsumer<T>` functional interfaces for?](#what-are-the-objdoubleconsumert-objintconsumert-and-objlongconsumert-functional-interfaces-for)
  - [What is a StringJoiner?](#what-is-a-stringjoiner)
  - [What are default interface methods?](#what-are-default-interface-methods)
  - [How do you call the default method of an interface in a class that implements that interface?](#how-do-you-call-the-default-method-of-an-interface-in-a-class-that-implements-that-interface)
  - [What is a static interface method?](#what-is-a-static-interface-method)
  - [How do I call a static interface method?](#how-do-i-call-a-static-interface-method)
  - [What is Optional?](#what-is-optional)
  - [What is Stream?](#what-is-stream)
  - [What are the different ways to create a stream?](#what-are-the-different-ways-to-create-a-stream)
  - [What is the difference between Collection and Stream?](#what-is-the-difference-between-collection-and-stream)
  - [What is the collect() method for in streams?](#what-is-the-collect-method-for-in-streams)
  - [What are the forEach() and forEachOrdered() methods used for in streams?](#what-are-the-foreach-and-foreachordered-methods-used-for-in-streams)
  - [What are the map() and mapToInt(), mapToDouble(), and mapToLong() methods used for in streams?](#what-are-the-map-and-maptoint-maptodouble-and-maptolong-methods-used-for-in-streams)
  - [What is the purpose of the filter() method in streams?](#what-is-the-purpose-of-the-filter-method-in-streams)
  - [What is the limit() method used for in streams?](#what-is-the-limit-method-used-for-in-streams)
  - [What is the sorted() method used for in streams?](#what-is-the-sorted-method-used-for-in-streams)
  - [What are the flatMap(), flatMapToInt(), flatMapToDouble(), flatMapToLong() methods used for in streams?](#what-are-the-flatmap-flatmaptoint-flatmaptodouble-flatmaptolong-methods-used-for-in-streams)
  - [Talk about parallel processing in Java 8.](#talk-about-parallel-processing-in-java-8)
  - [What are the final methods of working with streams?](#what-are-the-final-methods-of-working-with-streams)
  - [What intermediate methods of working with streams do you know?](#what-intermediate-methods-of-working-with-streams-do-you-know)
  - [How do you display 10 random numbers using forEach()?](#how-do-you-display-10-random-numbers-using-foreach)
  - [How can I display unique squares of numbers using the map() method?](#how-can-i-display-unique-squares-of-numbers-using-the-map-method)
  - [How do I display the number of blank lines using the filter() method?](#how-do-i-display-the-number-of-blank-lines-using-the-filter-method)
  - [How do I display 10 random numbers in ascending order?](#how-do-i-display-10-random-numbers-in-ascending-order)
  - [How do you find the maximum number in a set?](#how-do-you-find-the-maximum-number-in-a-set)
  - [How do I find the minimum number in a set?](#how-do-i-find-the-minimum-number-in-a-set)
  - [How do you get the sum of all the numbers in a set?](#how-do-you-get-the-sum-of-all-the-numbers-in-a-set)
  - [How do you get the average of all numbers?](#how-do-you-get-the-average-of-all-numbers)
  - [What additional methods for working with associative arrays (maps) have been introduced in Java 8?](#what-additional-methods-for-working-with-associative-arrays-maps-have-been-introduced-in-java-8)
  - [What is LocalDateTime?](#what-is-localdatetime)
  - [What is ZonedDateTime?](#what-is-zoneddatetime)
  - [How do I get the current date using the Date Time API from Java 8?](#how-do-i-get-the-current-date-using-the-date-time-api-from-java-8)
  - [How do I add 1 week, 1 month, 1 year, 10 years to the current date using the Date Time API?](#how-do-i-add-1-week-1-month-1-year-10-years-to-the-current-date-using-the-date-time-api)
  - [How do I get next Tuesday using the Date Time API?](#how-do-i-get-next-tuesday-using-the-date-time-api)
  - [How do I get the second Saturday of the current month using the Date Time API?](#how-do-i-get-the-second-saturday-of-the-current-month-using-the-date-time-api)
  - [How do I get the current time to the millisecond using the Date Time API?](#how-do-i-get-the-current-time-to-the-millisecond-using-the-date-time-api)
  - [How do I get the current local time to the millisecond using the Date Time API?](#how-do-i-get-the-current-local-time-to-the-millisecond-using-the-date-time-api)


  - [How do I identify repeatable annotation?](#how-do-i-identify-repeatable-annotation)
  - [What is Nashorn?](#what-is-nashorn)
  - [What is `jjs`?](#what-is-jjs)
  - [What class did Java 8 introduce for data encoding/decoding?](#what-class-did-java-8-introduce-for-data-encodingdecoding)
  - [How to create a Base64 encoder and decoder?](#how-to-create-a-base64-encoder-and-decoder)
  - [Summary of Java 8 Features](#summary-of-java-8-features)

---

## What are the new features in Java 8 and JDK 8?
Java 8 introduced several significant features, including:

- Lambda expressions
- Functional interfaces
- Default methods in interfaces
- Streams API
- New Date and Time API
- Optional class
- Nashorn JavaScript engine
- Base64 encoding and decoding
- Improvements to existing classes and interfaces

---

## What is "lambda"? What is the structure and features of using a lambda expression?
A lambda expression is a concise way to represent a function as an object. It provides a clear and expressive syntax for writing instances of single-method interfaces (functional interfaces).

### Structure:
```java
(parameters) -> expression
```
### Example:
```java
(x, y) -> x + y
```

---

## What variables do lambda expressions have access to?
Lambda expressions have access to:
- Variables that are declared in their enclosing scope (effectively final or final).
- Instance variables of the enclosing class.
- Static variables of the class.

---

## How do I sort a list of strings using a lambda expression?
```java
List<String> list = Arrays.asList("banana", "apple", "orange");
list.sort((s1, s2) -> s1.compareTo(s2));
```

---

## What is a "method reference"?
A method reference is a shorthand notation of a lambda expression to call a method. It provides a clear and concise way to refer to methods without executing them.

---

## What kinds of method references do you know?
- **Static method reference**: `ClassName::staticMethodName`
- **Instance method reference of a particular object**: `instance::instanceMethodName`
- **Instance method reference of an arbitrary object**: `ClassName::instanceMethodName`
- **Constructor reference**: `ClassName::new`

---

## Explain the expression `System.out::println`.
This is a method reference that refers to the `println` method of the `PrintStream` class (which is `System.out`). It can be used to print strings in a more concise way.

---

## What are "functional interfaces"?
A functional interface is an interface that contains exactly one abstract method. They can have multiple default or static methods.

---

## What are the `Function<T, R>`, `DoubleFunction<R>`, `IntFunction<R>`, and `LongFunction<R>` functional interfaces for?
These interfaces represent functions that take one argument and return a result:
- `Function<T, R>`: Takes a generic type T and returns R.
- `DoubleFunction<R>`, `IntFunction<R>`, `LongFunction<R>`: Specialized versions for double, int, and long primitive types.

---

## What are the functional interfaces `UnaryOperator<T>`, `DoubleUnaryOperator`, `IntUnaryOperator`, and `LongUnaryOperator` for?
These interfaces represent operations on a single operand:
- `UnaryOperator<T>`: Takes one argument of type T and returns the same type T.
- `DoubleUnaryOperator`, `IntUnaryOperator`, `LongUnaryOperator`: Specialized versions for double, int, and long.

---

## What are the functional interfaces `BinaryOperator<T>`, `DoubleBinaryOperator`, `IntBinaryOperator`, and `LongBinaryOperator` for?
These interfaces represent operations on two operands:
- `BinaryOperator<T>`: Takes two arguments of type T and returns a result of the same type T.
- `DoubleBinaryOperator`, `IntBinaryOperator`, `LongBinaryOperator`: Specialized versions for double, int, and long.

---

## What are the functional interfaces `Predicate<T>`, `DoublePredicate`, `IntPredicate`, and `LongPredicate` for?
These interfaces represent a single argument function that returns a boolean value:
- `Predicate<T>`: Takes an argument of type T and returns a boolean.
- `DoublePredicate`, `IntPredicate`, `LongPredicate`: Specialized versions for double, int, and long.

---

## What are the functional interfaces `Consumer<T>`, `DoubleConsumer`, `IntConsumer`, and `LongConsumer` for?
These interfaces represent operations that accept a single input argument and return no result:
- `Consumer<T>`: Takes an argument of type T.
- `DoubleConsumer`, `IntConsumer`, `LongConsumer`: Specialized versions for double, int, and long.

---

## What are the functional interfaces `Supplier<T>`, `BooleanSupplier`, `DoubleSupplier`, `IntSupplier`, and `LongSupplier` for?
These interfaces represent a supplier of results:
- `Supplier<T>`: Represents a function that supplies a value of type T.
- `BooleanSupplier`, `DoubleSupplier`, `IntSupplier`, `LongSupplier`: Specialized versions for their respective primitive types.

---

## What is the functional interface of `BiConsumer<T,U>`?
`BiConsumer<T,U>` represents an operation that accepts two input arguments and returns no result.

---

## What is the functional interface of `BiFunction<T,U,R>`?
`BiFunction<T,U,R>` represents a function that accepts two arguments of types T and U and produces a result of type R.

---

## What is the functional interface of `BiPredicate<T,U>`?
`BiPredicate<T,U>` represents a predicate (boolean-valued function) of two arguments.

---

## What are functional interfaces of the _To_Function type for?
The _To_Function interfaces convert a value of one type to another:
- `ToDoubleFunction<T>`: Converts T to double.
- `ToIntFunction<T>`: Converts T to int.
- `ToLongFunction<T>`: Converts T to long.

---

## What are the `ToDoubleBiFunction<T,U>`, `ToIntBiFunction<T,U>`, and `ToLongBiFunction<T,U>` functional interfaces for?
These interfaces take two arguments and convert them to a primitive type:
- `ToDoubleBiFunction<T,U>`: Converts T and U to double.
- `ToIntBiFunction<T,U>`: Converts T and U to int.
- `ToLongBiFunction<T,U>`: Converts T and U to long.

---

## What are the `ToDoubleFunction<T>`, `ToIntFunction<T>`, and `ToLongFunction<T>` functional interfaces for?
These interfaces represent a function that takes one argument and produces a primitive type:
- `ToDoubleFunction<T>`: Converts T to double.
- `ToIntFunction<T>`: Converts T to int.
- `ToLongFunction<T>`: Converts T to long.

---

## What are the `ObjDoubleConsumer<T>`, `ObjIntConsumer<T>`, and `ObjLongConsumer<T>` functional interfaces for?
These interfaces represent a consumer that takes an object and a primitive type:
- `ObjDoubleConsumer<T>`: Takes an object of type T and a double.
- `ObjIntConsumer<T>`: Takes an object of type T and an int.
- `ObjLongConsumer<T>`: Takes an object of type T and a long.

---

## What is a StringJoiner?
`StringJoiner` is a utility class that provides an easy way to construct a sequence of strings separated by a delimiter.

---

## What are default interface methods?
Default methods are methods defined in an interface with a body. They allow interfaces to evolve without breaking existing implementations.

---

## How do you call the default method of an interface in a class that implements that interface?
You can call the default method using the instance of the implementing class:
```java
class MyClass implements MyInterface {
    // Implementation
}
MyClass obj = new MyClass();
obj.defaultMethod();
```

---

## What is a static interface method?
A static interface method is a method that belongs to the interface rather than any instance of the interface. It can be called using the interface name.

---

## How do I call a static interface method?
```java
MyInterface.staticMethod();
```

---

## What is Optional?
`Optional` is a container object that may or may not contain a value. It is used to avoid `NullPointerExceptions` and provides methods to deal with potentially absent values.

---

## What is Stream?
A `Stream` is a sequence of elements supporting sequential and parallel aggregate operations. It allows functional-style operations on collections.

---

## What are the different ways to create a stream?
- From a collection (e.g., `List`, `Set`).
- From arrays.
- Using `Stream.of()`.
- Using `Stream.generate()` or `Stream.iterate()`.

---

## What is the difference between Collection and Stream?
- **Collection**: A data structure that stores elements.
- **Stream**: A sequence of elements that can be processed; it does not store elements and is not a data structure.

---

## What is the collect() method for in streams?
The `collect()` method is a terminal operation that transforms the elements of a stream into a different form, usually a collection like a List or Set.

---

## What are the forEach() and forEachOrdered() methods used for in streams?
- **forEach()**: Performs an action for each element in the stream.
- **forEachOrdered()**: Performs an action for each element in the stream, preserving the encounter order.

---

## What are the map() and mapToInt(), mapToDouble(), and mapToLong() methods used

 for in streams?
- **map()**: Transforms elements using a provided function.
- **mapToInt()**, **mapToDouble()**, **mapToLong()**: Specialized versions that produce IntStream, DoubleStream, and LongStream respectively.

---

## What is the purpose of the filter() method in streams?
The `filter()` method allows you to select elements from the stream that match a certain condition.

---

## What is the limit() method used for in streams?
The `limit()` method is used to truncate a stream to a given size, returning a new stream that contains no more than the specified number of elements.

---

## What is the sorted() method used for in streams?
The `sorted()` method returns a stream that is sorted according to natural order or a specified comparator.

---

## What are the flatMap(), flatMapToInt(), flatMapToDouble(), flatMapToLong() methods used for in streams?
These methods are used to flatten nested structures into a single stream:
- **flatMap()**: Flattens streams of collections.
- **flatMapToInt()**, **flatMapToDouble()**, **flatMapToLong()**: Specialized versions for producing respective primitive streams.

---

## Talk about parallel processing in Java 8.
Java 8 introduced the ability to process streams in parallel. By calling `parallelStream()` on a collection, you can achieve parallel processing, utilizing multiple threads for performance improvements.

---

## What are the final methods of working with streams?
Final methods produce a result or a side effect. Examples include `collect()`, `forEach()`, `reduce()`, and `count()`.

---

## What intermediate methods of working with streams do you know?
Intermediate methods return a new stream and include operations like `filter()`, `map()`, `flatMap()`, `sorted()`, and `distinct()`.

---

## How do you display 10 random numbers using forEach()?
```java
new Random().ints(10).forEach(System.out::println);
```

---

## How can I display unique squares of numbers using the map() method?
```java
Stream.of(1, 2, 2, 3)
      .map(x -> x * x)
      .distinct()
      .forEach(System.out::println);
```

---

## How do I display the number of blank lines using the filter() method?
```java
Files.lines(Paths.get("file.txt"))
     .filter(String::isEmpty)
     .count();
```

---

## How do I display 10 random numbers in ascending order?
```java
new Random().ints(10).sorted().forEach(System.out::println);
```

---

## How do you find the maximum number in a set?
```java
int max = numbers.stream().max(Integer::compare).orElseThrow();
```

---

## How do I find the minimum number in a set?
```java
int min = numbers.stream().min(Integer::compare).orElseThrow();
```

---

## How do you get the sum of all the numbers in a set?
```java
int sum = numbers.stream().mapToInt(Integer::intValue).sum();
```

---

## How do you get the average of all numbers?
```java
double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
```

---

## What additional methods for working with associative arrays (maps) have been introduced in Java 8?
Java 8 introduced several methods for the `Map` interface, including:
- `forEach()`
- `putIfAbsent()`
- `remove()`
- `replace()`
- `computeIfAbsent()`
- `computeIfPresent()`
- `merge()`

---

## What is LocalDateTime?
`LocalDateTime` is a date-time without a time zone in the ISO-8601 calendar system.

---

## What is ZonedDateTime?
`ZonedDateTime` is a date-time with a time zone in the ISO-8601 calendar system.

---

## How do I get the current date using the Date Time API from Java 8?
```java
LocalDate currentDate = LocalDate.now();
```

---

## How do I add 1 week, 1 month, 1 year, 10 years to the current date using the Date Time API?
```java
LocalDate date = LocalDate.now();
date = date.plusWeeks(1).plusMonths(1).plusYears(1).plusYears(10);
```

---

## How do I get next Tuesday using the Date Time API?
```java
LocalDate nextTuesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
```

---

## How do I get the second Saturday of the current month using the Date Time API?
```java
LocalDate secondSaturday = LocalDate.now()
    .with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SATURDAY));
```

---

## How do I get the current time to the millisecond using the Date Time API?
```java
LocalTime currentTime = LocalTime.now();
```

---

## How do I get the current local time to the millisecond using the Date Time API?
```java
LocalTime currentLocalTime = LocalTime.now(ZoneId.systemDefault());
```

---

## How do I identify repeatable annotation?
Repeatable annotations are a feature that allows the same annotation type to be used more than once on the same declaration.

---

## What is Nashorn?
Nashorn is a JavaScript engine that allows you to execute JavaScript code on the Java Virtual Machine (JVM).

---

## What is `jjs`?
`jjs` is a command-line tool introduced in Java 8 to execute JavaScript code using the Nashorn engine.

---

## What class did Java 8 introduce for data encoding/decoding?
Java 8 introduced the `java.util.Base64` class for encoding and decoding data in Base64.

---

## How to create a Base64 encoder and decoder?
```java
Base64.Encoder encoder = Base64.getEncoder();
Base64.Decoder decoder = Base64.getDecoder();
```

---

## Summary of Java 8 Features
Java 8 introduced significant features that improved the Java programming experience, such as lambda expressions, the Streams API, new date/time API, and optional values, which facilitate functional programming styles and reduce boilerplate code.


---

## What is "lambda"? What is the structure and features of using a lambda expression?
A **lambda expression** is a concise way to represent an anonymous function that can be used to create functional interfaces. The structure consists of parameters, an arrow (`->`), and a body.

### Example:
```java
interface Operationable {
    int calculate(int x, int y);
}

public static void main(String[] args) {
    Operationable operation = (x, y) -> x + y;     
    int result = operation.calculate(10, 20);
    System.out.println(result); // Output: 30
}
```

### Features:
- Can access variables from the enclosing scope (must be effectively final).
- Can be used as an implementation of functional interfaces.

---

## What variables do lambda expressions have access to?
Lambda expressions can access:
- Effectively final local variables
- Instance variables
- Static variables

---

## How do I sort a list of strings using a lambda expression?
```java
public static List<String> sort(List<String> list) {
    Collections.sort(list, (a, b) -> a.compareTo(b));
    return list;
}
```

---

## What is a "method reference"?
A **method reference** is a shorthand notation of a lambda expression to call a method. The syntax includes:
- `ClassName::staticMethodName` for static methods
- `instance::instanceMethodName` for instance methods
- `ClassName::new` for constructors

### Example:
```java
private interface Measurable {
    int length(String string);
}

public static void main(String[] args) {
    Measurable a = String::length;
    System.out.println(a.length("abc")); // Output: 3
}
```

---

## What kinds of method references do you know?
1. Static Method Reference
2. Instance Method Reference
3. Constructor Reference

---

## Explain the expression `System.out::println`.
This expression is a method reference that refers to the instance method `println()` of the `System.out` object.

---

## What are "functional interfaces"?
A **functional interface** is an interface that contains exactly one abstract method. It can contain multiple default methods. You can define a functional interface using the `@FunctionalInterface` annotation.

---

## What are the `Function<T, R>`, `DoubleFunction<R>`, `IntFunction<R>`, and `LongFunction<R>` functional interfaces for?
- **Function<T, R>**: Represents a function that accepts one argument of type T and produces a result of type R.
- **DoubleFunction<R>**: Accepts a double and returns a result of type R.
- **IntFunction<R>**: Accepts an int and returns a result of type R.
- **LongFunction<R>**: Accepts a long and returns a result of type R.

---

## What are the functional interfaces `UnaryOperator<T>`, `DoubleUnaryOperator`, `IntUnaryOperator`, and `LongUnaryOperator` for?
- **UnaryOperator<T>**: Represents an operation on a single operand that produces a result of the same type.
- **DoubleUnaryOperator**: Takes a double as input and produces a double result.
- **IntUnaryOperator**: Takes an int as input and produces an int result.
- **LongUnaryOperator**: Takes a long as input and produces a long result.

---

## What are the functional interfaces `BinaryOperator<T>`, `DoubleBinaryOperator`, `IntBinaryOperator`, and `LongBinaryOperator` for?
- **BinaryOperator<T>**: Represents an operation that accepts two operands of the same type and produces a result of the same type.
- **DoubleBinaryOperator**: Accepts two doubles and produces a double result.
- **IntBinaryOperator**: Accepts two ints and produces an int result.
- **LongBinaryOperator**: Accepts two longs and produces a long result.

---

## What are the functional interfaces `Predicate<T>`, `DoublePredicate`, `IntPredicate`, and `LongPredicate` for?
- **Predicate<T>**: Represents a boolean-valued function of one argument.
- **DoublePredicate**: Accepts a double and returns a boolean.
- **IntPredicate**: Accepts an int and returns a boolean.
- **LongPredicate**: Accepts a long and returns a boolean.

---

## What are the functional interfaces `Consumer<T>`, `DoubleConsumer`, `IntConsumer`, and `LongConsumer` for?
- **Consumer<T>**: Represents an operation that accepts a single input argument and returns no result.
- **DoubleConsumer**: Accepts a double and returns no result.
- **IntConsumer**: Accepts an int and returns no result.
- **LongConsumer**: Accepts a long and returns no result.

---

## What are the functional interfaces `Supplier<T>`, `BooleanSupplier`, `DoubleSupplier`, `IntSupplier`, and `LongSupplier` for?
- **Supplier<T>**: Represents a supplier of results, does not take any input.
- **BooleanSupplier**: Returns a boolean result.
- **DoubleSupplier**: Returns a double result.
- **IntSupplier**: Returns an int result.
- **LongSupplier**: Returns a long result.

---

## What is the functional interface of `BiConsumer<T,U>`?
`BiConsumer<T, U>` represents an operation that accepts two input arguments and returns no result.

---

## What is the functional interface of `BiFunction<T,U,R>`?
`BiFunction<T, U, R>` represents a function that accepts two arguments and produces a result.

---

## What is the functional interface of `BiPredicate<T,U>`?
`BiPredicate<T, U>` represents a function that accepts two arguments and returns a boolean result.

---

## What are functional interfaces of the _To_Function type for?
Functional interfaces like `ToDoubleFunction<T>`, `ToIntFunction<T>`, and `ToLongFunction<T>` are used to convert an object of type T to a primitive type (double, int, long).

---

## What are the `ToDoubleBiFunction<T,U>`, `ToIntBiFunction<T,U>`, and `ToLongBiFunction<T,U>` functional interfaces for?
These interfaces are used to convert two arguments of types T and U into primitive types:
- **ToDoubleBiFunction**: Converts two arguments to a double.
- **ToIntBiFunction**: Converts two arguments to an int.
- **ToLongBiFunction**: Converts two arguments to a long.

---

## What are the `ToDoubleFunction<T>`, `ToIntFunction<T>`, and `ToLongFunction<T>` functional interfaces for?
These interfaces convert a single argument of type T into a primitive type:
- **ToDoubleFunction**: Converts an argument to a double.
- **ToIntFunction**: Converts an argument to an int.
- **ToLongFunction**: Converts an argument to a long.

---

## What are the `ObjDoubleConsumer<T>`, `ObjIntConsumer<T>`, and `ObjLongConsumer<T>` functional interfaces for?
These interfaces accept an object and a primitive type, and perform an action without returning a result:
- **ObjDoubleConsumer<T>**: Takes an object and a double.
- **ObjIntConsumer<T>**: Takes an object and an int.
- **ObjLongConsumer<T>**: Takes an object and a long.

---

## What is a StringJoiner?
`StringJoiner` is a utility class for creating a sequence of strings separated by a specified delimiter. It can also handle optional prefixes and suffixes.

### Example:
```java
StringJoiner joiner = new StringJoiner(", ", "[", "]");
joiner.add("apple").add("banana").add("cherry");
System.out.println(joiner); // Output: [apple, banana, cherry]
```

---

## What are default interface methods?
Default methods are methods defined in interfaces that have an implementation. They allow you to add new methods to interfaces without breaking existing implementations.

### Example:
```java
interface MyInterface {
    default void myDefaultMethod() {
        System.out.println("Default Implementation");
    }
}
```

---

## How do you call the default method of an interface in a class that implements that interface?
You can call a default method from an implementing class like this:
```java
public class MyClass implements MyInterface {
    public void someMethod() {
        myDefaultMethod(); // Calls the default method
    }
}
```

---

## What is a static interface method?
A static method in an interface is a method that can be called without an instance of the interface.

### Example:
```java
interface MyStaticInterface {
    static void myStaticMethod() {
        System.out.println("Static Method");
    }
}
```

---

## How do I call a static interface method?
You can call a static method using the interface name:
```java
MyStaticInterface.myStaticMethod(); // Output: Static Method
```

---

## What is Optional?
`Optional` is a container object which may or may not contain a value. It helps to avoid `NullPointerException` by providing methods to handle the presence or absence of a value.

### Example:
```java
Optional<String> optional = Optional.ofNullable(getValue());
optional.ifPresent(System.out::println);
``

`

---

## What is Stream?
A `Stream` is a sequence of elements supporting sequential and parallel aggregate operations. It allows functional-style operations on collections.

---

## What are the different ways to create a stream?
- From a collection (e.g., `List`, `Set`).
- From arrays.
- Using `Stream.of()`.
- Using `Stream.generate()` or `Stream.iterate()`.

---

## What is the difference between Collection and Stream?
- **Collection**: A data structure that stores elements.
- **Stream**: A sequence of elements that can be processed; it does not store elements and is not a data structure.

---

## What is the collect() method for in streams?
The `collect()` method is a terminal operation that transforms the elements of a stream into a different form, usually a collection like a List or Set.

---

## What are the forEach() and forEachOrdered() methods used for in streams?
- **forEach()**: Performs an action for each element in the stream.
- **forEachOrdered()**: Performs an action for each element in the stream, preserving the encounter order.

---

## What are the map() and mapToInt(), mapToDouble(), and mapToLong() methods used for in streams?
- **map()**: Transforms each element in the stream to another object.
- **mapToInt()**, **mapToDouble()**, **mapToLong()**: Transform each element to a primitive type (int, double, long).

---

## What is the purpose of the filter() method in streams?
The `filter()` method is used to exclude elements from the stream that do not match a specified predicate.

---

## What is the limit() method used for in streams?
The `limit()` method is used to truncate the stream to a specified number of elements.

---

## What is the sorted() method used for in streams?
The `sorted()` method is used to sort the elements of the stream based on their natural order or a specified comparator.

---

## What are the flatMap(), flatMapToInt(), flatMapToDouble(), flatMapToLong() methods used for in streams?
- **flatMap()**: Transforms each element into a stream and flattens the resulting streams into a single stream.
- **flatMapToInt()**, **flatMapToDouble()**, **flatMapToLong()**: Similar to flatMap, but for primitive types.

---

## Talk about parallel processing in Java 8.
Java 8 introduced parallel streams, allowing operations on data in parallel using multiple threads. This can improve performance for large datasets by leveraging multicore processors.

### Example:
```java
List<String> list = Arrays.asList("a", "b", "c", "d");
list.parallelStream().forEach(System.out::println);
```

---

## What are the final methods of working with streams?
Final methods include operations that terminate the stream pipeline and produce a result:
- `collect()`
- `forEach()`
- `reduce()`
- `count()`
- `anyMatch()`
- `allMatch()`
- `noneMatch()`
- `findFirst()`
- `findAny()`

---

## What intermediate methods of working with streams do you know?
Intermediate methods return a new stream and include operations such as:
- `filter()`
- `map()`
- `flatMap()`
- `sorted()`
- `distinct()`
- `limit()`
- `skip()`

---

## How do you display 10 random numbers using forEach()?
```java
new Random().ints(10).forEach(System.out::println);
```

---

## How can I display unique squares of numbers using the map() method?
```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4);
numbers.stream().map(n -> n * n).distinct().forEach(System.out::println);
```

---

## How do I display the number of blank lines using the filter() method?
```java
long blankLines = lines.stream().filter(String::isEmpty).count();
System.out.println(blankLines);
```

---

## How do I display 10 random numbers in ascending order?
```java
new Random().ints(10).sorted().forEach(System.out::println);
```

---

## How do you find the maximum number in a set?
```java
Optional<Integer> max = numbers.stream().max(Integer::compare);
max.ifPresent(System.out::println);
```

---

## How do I find the minimum number in a set?
```java
Optional<Integer> min = numbers.stream().min(Integer::compare);
min.ifPresent(System.out::println);
```

---

## How do you get the sum of all the numbers in a set?
```java
int sum = numbers.stream().mapToInt(Integer::intValue).sum();
```

---

## How do you get the average of all numbers?
```java
OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();
average.ifPresent(System.out::println);
```

---

## What additional methods for working with associative arrays (maps) have been introduced in Java 8?
Java 8 introduced several new methods in the `Map` interface:
- `forEach()`
- `replaceAll()`
- `putIfAbsent()`
- `remove()`
- `computeIfAbsent()`
- `computeIfPresent()`
- `merge()`

---

## What is LocalDateTime?
`LocalDateTime` is a date-time without a time zone, representing a date and time in the ISO-8601 calendar system.

---

## What is ZonedDateTime?
`ZonedDateTime` is a date-time with a time zone, representing a date and time with timezone information.

---

## How do I get the current date using the Date Time API from Java 8?
```java
LocalDate currentDate = LocalDate.now();
```

---

## How do I add 1 week, 1 month, 1 year, 10 years to the current date using the Date Time API?
```java
LocalDate date = LocalDate.now();
date = date.plusWeeks(1);
date = date.plusMonths(1);
date = date.plusYears(1);
date = date.plusYears(10);
```

---

## How do I get next Tuesday using the Date Time API?
```java
LocalDate nextTuesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
```

---

## How do I get the second Saturday of the current month using the Date Time API?
```java
LocalDate secondSaturday = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SATURDAY));
```

---

## How do I get the current time to the millisecond using the Date Time API?
```java
LocalTime currentTime = LocalTime.now();
```

---

## How do I get the current local time to the millisecond using the Date Time API?
```java
LocalTime localTime = LocalTime.now(ZoneId.systemDefault());
```

---

## How do I identify repeatable annotation?
You can use the `@Repeatable` annotation on an annotation type, which allows it to be used multiple times on the same declaration.

---

## What is Nashorn?
Nashorn is a JavaScript engine introduced in Java 8, allowing you to run JavaScript code on the Java Virtual Machine (JVM).

---

## What is `jjs`?
`jjs` is a command-line tool introduced in Java 8 for running JavaScript code using the Nashorn engine.

---

## What class did Java 8 introduce for data encoding/decoding?
Java 8 introduced the `java.util.Base64` class for encoding and decoding Base64.

---

## How to create a Base64 encoder and decoder?
### Example:
```java
Base64.Encoder encoder = Base64.getEncoder();
Base64.Decoder decoder = Base64.getDecoder();

String encoded = encoder.encodeToString("Hello".getBytes());
byte[] decoded = decoder.decode(encoded);
```

---

## Summary of Java 8 Features
- Default interface methods
- Lambda expressions
- Functional interfaces
- Method references
- Repeatable annotations
- New Date and Time API
- Stream API for collections
- Parallel sorting of arrays
- Nashorn JavaScript engine
- Base64 encoding/decoding
- Improvements in concurrency
