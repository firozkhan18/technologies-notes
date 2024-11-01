# Java 8 Features

## What are the new features in Java 8 and JDK 8?
- **Lambda Expressions**
- **Functional Interfaces**
- **Default Methods in Interfaces**
- **Method References**
- **Stream API**
- **Optional Class**
- **New Date and Time API**
- **Nashorn JavaScript Engine**
- **Base64 Encoding/Decoding**
- **Improvements in Concurrency and Collections**

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
