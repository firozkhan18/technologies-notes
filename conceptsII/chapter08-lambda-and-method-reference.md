# Lambda and Method reference 

Java unlike JavaScript or Python, don't let you pass a method as argument of a method
without ceremony

Let say i want to write a method that do either the sum of an array of values or the sum of their square,
it can write if that way
```java
int sumOf(boolean squareSum, int... array) {
  var sum = 0;
  for(var value: array) {
    if (squareSum) {
      sum = sum + value * value;
    } else {
      sum = sum + value;
    }
  }
  return sum;
}
System.out.println(sumOf(true, 1, 2, 3));
```

but you every values of the array, squareSum will have the same value so it's equivalent to write
```java
int sumOf(boolean squareSum, int... array) {
  var sum = 0;
  if (squareSum) {
    for(var value: array) {
      sum = sum + value * value;
    }
  } else {
    for(var value: array) {
      sum = sum + value;
    }
  }
  return sum;
}
System.out.println(sumOf(true, 1, 2, 3));
```

and at that point, you have code duplication.
Usually testing a condition in the middle of a computation is a code smell.
There is a way to solve that, it's to take the part of the computation that change as parameter
so sumOf instead of a boolean that take a function as parameter more or less like this
```java
/*
int sumOf(??? function, int... array) {
  var sum = 0;
  for(var value: array) {
    sum = sum + function(value);
  }
  return sum;
}
*/
```

## Functional interface
the question is what ??? is. The answer in simple in Java, if it can be either a value or another one,
then it's an interface. Exactly like in the previous chapter, we have introduce an interface in
between two records.
Here my interface is a function that takes an int and return an int so
```java
interface Fun {
  int apply(int value);
}
int sumOf(Fun function, int[] array) {
  var sum = 0;
  for(var value: array) {
    sum = sum + function.apply(value);
  }
  return sum;
}
```

then using the lambda syntax we have seeing in the previous chapter sumOf can be called
```java
var array = new int[] { 1, 2, 3 };
System.out.println(sumOf(x -> x, array));
System.out.println(sumOf(x -> x * x, array));
```


## Package java.util.function

Because it's not convenient to have to declare an interface every times you want to send
a function as parameter, Java already provides a bunch of interfaces in the package
java.lang.function, so you often don't have to write your own
Moreover most interface also have variant for primitive types 

```java
import java.util.function.*;
```

- java.lang.Runnable is equivalent to () -> void
```java
Runnable runnable = () -> { System.out.println("hello"); };
runnable.run();
```

- Supplier<T> is equivalent to () -> T
```java
Supplier<String> supplier = () -> "hello supplier";
System.out.println(supplier.get());
```

- IntSupplier, LongSupplier and DoubleSupplier
```java
IntSupplier supplier = () -> 42;
System.out.println(supplier.getAsInt());
```

- Consumer<T> is equivalent to (T) -> void
```java
Consumer<String> consumer = message -> System.out.println(message);
consumer.accept("hello consumer");
```

- IntConsumer, LongConsumer and DoubleConsumer
```java
DoubleConsumer consumer = message -> System.out.println(message);
consumer.accept(42);
```

- Predicate<T> is equivalent to (T) -> boolean
```java
Predicate<String> predicate = text -> text.length() < 5;
System.out.println(predicate.test("hello predicate"));
```

- IntPredicate, LongPredicate and DoublePredicate
```java
DoublePredicate isPositive = v -> v >= 0;
System.out.println(isPositive.test(17.3));
```

- Function<T,U> is equivalent to (T) -> U
```java
Function<String, String> fun = s -> "hello " + s;
System.out.println(fun.apply("function"));
```

- IntFunction<T>, LongFunction<T> and DoubleFunction<T>
```java
IntFunction<String[]> arrayCreator = size -> new String[size];
System.out.println(arrayCreator.apply(5).length);
```

- ToIntFunction<T>, ToLongFunction<T> and ToDoubleFunction<T>
```java
ToIntFunction<String> stringLength = s -> s.length();
System.out.println(stringLength.applyAsInt("hello"));
```

- UnaryOperator<T> is equivalent to (T) -> T
```java
UnaryOperator<String> unaryOp =  s -> "hello " + s;
System.out.println(unaryOp.apply("unary operator"));
```

- IntUnaryOperator, LongUnaryOperator and DoubleUnaryOperator
```java
IntUnaryOperator unaryOp =  x -> - x;
System.out.println(unaryOp.applyAsInt(7));
```

- BiPredicate is equivalent to (T, U) -> boolean
```java
BiPredicate<String, String> predicate = (s, prefix) -> s.startsWith(prefix);
System.out.println(predicate.test("hello", "hell"));
```

- BiFunction<T,U,V> is equivalent to (T, U) -> V
```java
BiFunction<String, String, String> fun = (s1, s2) -> s1 + " " + s2;
System.out.println(fun.apply("hello", "bi-function"));
```

- BinaryOperator<T> is equivalent to (T, T) -> T
```java
BinaryOperator<String> binaryOp =  (s1, s2) -> s1 + " " + s2;
System.out.println(binaryOp.apply("hello", "binary operator"));
```

- IntBinaryOperator, LongBinaryOperator and DoubleBinaryOperator
```java
IntBinaryOperator binaryOp =  (a, b) -> a + b;
System.out.println(binaryOp.applyAsInt(40, 2));
```

## Lambda
Lambda syntax is similar to arrow part the switch syntax
- with 0 parameter: () -> expression
- with 1 parameter: x -> expression
- with 2 or more parameters: (a, b) -> expression
```java
DoubleUnaryOperator op = x -> 2.0 * x;
System.out.println(op.applyAsDouble(2));
```

instead of an expression, you can have statements between curly braces
```java
DoubleUnaryOperator op = x -> {
    return 2.0 * x;
  };
System.out.println(op.applyAsDouble(2));
```

The types of the parameters are optional so you can declare them or not
if you don't declare them the parameter types of the abstract method
of the interface are used
```java
DoubleUnaryOperator op = (double x) -> 2.0 * x;
System.out.println(op.applyAsDouble(2));
```


## Method references
There are 5 kinds of method references












### 1. a reference to an instance method

Seeing an instance method as a function means you have to take the type of `this` into account, here `startsWith` as one parameter but the function as two

```java
BiPredicate<String,String> predicate = String::startsWith;
System.out.println(predicate.test("hello", "hell"));
```
> Note: A reference to an instance method: This refers to a method that belongs to a specific object. It is typically used when you want to call a method on an object that is passed as a parameter or stored in a variable.

- Reference to an instance method: This is a method reference to an instance method of a particular object.

For example:

```java 
List<String> list = Arrays.asList("hi", "hello", "hey");
list.forEach(System.out::println);
```
In this example, System.out::println is a reference to the instance method println of the System.out object.

### 2. a bound reference to an instance method

The value of this is fixed so the parameter of the function are the same as the parameter of the instance method

```java
var text = "hello";
IntSupplier supplier = text::length;
System.out.println(supplier.getAsInt());
```
> Note: A bound reference to an instance method: This is a specific type of instance method reference where you bind the object to which the method belongs. This is useful when you want to provide a method reference with a specific object context.

- Bound reference to an instance method: This is a method reference to an instance method of a specific object, often used with streams.

For example:

```java
List<String> list = Arrays.asList("apple", "banana", "orange");
list.stream()
    .map(String::toUpperCase)
    .forEach(System.out::println);
```
In this example, String::toUpperCase is a bound reference to the instance method toUpperCase of a specific object in the stream.

### 3. a reference to a static method

No instance here, so the parameter of the function are the same as the parameter of the static method

```java
ToIntFunction<String> function = Integer::parseInt;
System.out.println(function.applyAsInt("42"));
```
> Note: A reference to a static method: This refers to a method that belongs to a class rather than an instance of the class. Static methods are typically used for utility functions that do not depend on the state of an object.

Reference to a static method: This is a method reference to a static method of a class. 

For example:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.stream()
    .map(String::valueOf)
    .forEach(System.out::println);
```
In this example, String::valueOf is a reference to the static method valueOf of the String class.

### 4. a reference to a new instance

The parameter of the function are the same as the parameter of the constructor. The return type is the class of the constructor

```java
record Person(String name) {}
Function<String, Person> factory = Person::new;
System.out.println(factory.apply("John"));
```
> A reference to a new instance: This refers to a constructor method that is used to create a new instance of a class. It is used when you want to pass a constructor reference as a method reference.

For example:
```java
Supplier<String> supplier = String::new;
String message = supplier.get();
```
In this example, String::new is a reference to the constructor of the String class, used to create a new instance.

### 5. a reference to a new array

Same as above, the return type is the array.

```java
IntFunction<String[]> arrayCreator = String[]::new;
System.out.println(arrayCreator.apply(2).length);
```
> A reference to a new array: This refers to the creation of a new array using a constructor reference. It is used when you want to create a new array without explicitly calling the constructor method.

This is a method reference to create a new array of a specific type and length. 

For example:
```java
Function<Integer, String[]> function = String[]::new;
String[] newArray = function.apply(3);
```
In this example, String[]::new is a reference to create a new array of type String with a length of 3.

A frequent error is to think that String::length is a reference to a static method because the syntax is close to String.length() which is a call to a static method. But for a method reference, the same syntax is used to reference an instance method and a static method. So String::length is a reference to an instance method because the method length() in the class String is declared as an instance method.

### ===========================================================

Method references are a shorthand notation to refer to methods by their names instead of using lambda expressions. There are four types of method references:

#### Static Method References: 

- Syntax: Class::staticMethodName

Example:

- Using lambda expression
```java
Function<String, Integer> toInteger = (String s) -> Integer.parseInt(s);
```
- Using method reference
```java
Function<String, Integer> toInteger = Integer::parseInt;
```
#### Instance Method References of an Object: 

- Syntax: instance::instanceMethodName

Example:

- Using lambda expression
```java
BiFunction<String, String, Boolean> startsWith = (String s1, String s2) -> s1.startsWith(s2);
```
- Using method reference
```java
BiFunction<String, String, Boolean> startsWith = String::startsWith;
```
#### Instance Method References of a Constructor: 

- Syntax: ClassName::new

Example:
 
- Using lambda expression
```java
Supplier<List<String>> listSupplier = () -> new ArrayList<>();
```
- Using method reference
```java
Supplier<List<String>> listSupplier = ArrayList::new;
```
#### Constructor Method References: 

- Syntax: ClassName::staticMethodName

Example:

- Using lambda expression
```java
Function<Integer, List<String>> listFunction = (Integer size) -> new ArrayList<>(size);
```
- Using method reference
```java
Function<Integer, List<String>> listFunction = ArrayList::new;
```
In all the examples above, the lambda expressions are converted to method references to achieve a cleaner and more concise syntax. Method references improve readability and reduce code redundancy in functional programming.

### ===========================================================

The difference between the four types of method references and the five kinds of method references listed in the above is that the former specifically refer to different ways in which methods can be referenced or used as lambda expressions in Java code, while the latter categorize the different types of method references based on their functionality.

- Static Method References refer to referencing static methods in a class. 

- Instance Method References of an Object refer to referencing non-static instance methods of an object. 

- Instance Method References of a Constructor refer to referencing instance methods of a constructor. 

- Constructor Method References refer to referencing constructors.

On the other hand, the five kinds of method references listed in the original question categorize the different types of method references based on their characteristics or implementation in Java.
