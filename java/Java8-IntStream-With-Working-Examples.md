Here's the content you provided formatted into a proper Markdown file:


# Java 8 `IntStream` With Working Examples

A quick guide to understanding the primitive `int` representation of `Stream` as interface `IntStream` to support integer operations, along with useful examples.

## 1. Overview

In this tutorial, we’ll learn how to use `IntStream` in Java 8 with example programs.

For `int` primitives, the Java `IntStream` class is a specialization of the `Stream` interface. It’s a stream of primitive `int`-valued items that can be used in both sequential and parallel aggregate operations.

`AutoCloseable` and `BaseStream` interfaces are implemented by `IntStream`, which is part of the `java.util.stream` package.

We will cover the following topics:

- IntStream Creation
- ForEach Loop
- IntStream Ranges
- IntStream Min and Max
- IntStream Find
- IntStream Map
- IntStream Filter
- IntStream Distinct
- IntStream to Array
- IntStream to List

## 2. Creating `IntStream`

An `IntStream` can be generated in a variety of ways, but it cannot be created using the `new` keyword.

The `IntStream` objects are created using the methods listed below:

- `IntStream.of()`
- `IntStream.range()`
- `IntStream.rangeClosed()`
- `IntStream.generate()`
- `IntStream.iterate()`

Let us explore these methods with example programs to create an instance of `IntStream` with primitive `int` values.

### 2.1 `IntStream.of()`

This method returns a sequentially ordered stream with the provided values as its elements.

It is available in two forms: single element stream and multiple values stream.

- `IntStream of(int t)` – Returns a stream consisting of a single supplied element.
- `IntStream of(int… values)` – Returns a stream with all the components supplied.

```java
package com.javaprogramto.java8.intstream;

import java.util.stream.IntStream;

public class IntStreamOf {
    public static void main(String[] args) {
        IntStream singleValue = IntStream.of(10);
        IntStream multipleValues = IntStream.of(1, 5, 10, 20, 30);
    }
}
```

### 2.2 `IntStream.range()`

`range()` is used to generate numbers in the order with incremental by one.

```java
static IntStream range(int startInclusive, int endExclusive)
IntStream range10to30 = IntStream.range(10, 20);
```

### 2.3 `IntStream.rangeClosed()`

`rangeClosed()` is similar to `range()` but includes the end index of this method.

```java
static IntStream rangeClosed(int startInclusive, int endInclusive)
IntStream range10to15closed = IntStream.rangeClosed(10, 15);
```

### 2.4 `IntStream.generate()`

Use the `generate()` method if you wish to generate random numbers with custom logic.

```java
IntStream random = IntStream.generate(() -> (int) (Math.random() * 5000));
```

### 2.5 `IntStream.iterate()`

The `iterate()` method generates an infinite stream of integers using incremental or decremental custom logic.

```java
IntStream iterate = IntStream.iterate(1000, i -> i + 4000).limit(5);
```

## 3. `IntStream.forEach()`

Typically, we use a traditional `for` loop for certain ranges. However, the same task can be accomplished using the `IntStream.forEach()` function instead.

```java
package com.javaprogramto.java8.intstream;

import java.util.stream.IntStream;

public class IntStreamForEach {
    public static void main(String[] args) {
        System.out.println("for loop");
        for(int i = 1000; i < 20000; i += 4000) {
            print(i);
        }

        System.out.println("IntStream forEach loop");
        IntStream iterate = IntStream.iterate(1000, i -> i + 4000).limit(5);
        iterate.forEach(n -> print(n));
    }

    private static void print(int n) {
        System.out.println(n);
    }
}
```

## 4. `IntStream` Ranges

Two methods are offered by the `IntStream` API to work with numbers generated in a defined range:

- `range(start, endExclusive)`: Excludes the end index from the output range.
- `rangeClosed(start, endInclusive)`: Includes the end index in the output range.

```java
IntStream range10to15range = IntStream.range(10, 15);
IntStream range10to15closed = IntStream.rangeClosed(10, 15);

System.out.println("range(10, 15) : " + Arrays.toString(range10to15range.toArray()));
System.out.println("rangeClosed(10, 15) : " + Arrays.toString(range10to15closed.toArray()));
```

**Output:**

```
range(10, 15) : [10, 11, 12, 13, 14]
rangeClosed(10, 15) : [10, 11, 12, 13, 14, 15]
```

## 5. `IntStream` Min and Max

`IntStream` has utility methods for determining the minimum and maximum values from a series of numbers.

- Use `min()` to retrieve the lowest value.
- Use `max()` to retrieve the highest value.

```java
System.out.println("range(10, 15) min value : " + IntStream.range(10, 15).min().getAsInt());
System.out.println("range(10, 15) max value : " + IntStream.range(10, 15).max().getAsInt());
```

**Output:**

```
range(10, 15) min value : 10
range(10, 15) max value : 14
```

## 6. `IntStream` Find Value

Use `findFirst()` or `findAny()` methods on the `IntStream` object to get the first or any value.

`findFirst()` vs `findAny()`: By default, `IntStream` is created as a sequential stream unless you call `parallel()` on the `IntStream`. For sequential streams, `findFirst()` and `findAny()` return the same result. In parallel streams, however, `findAny()` gives a random value.

```java
System.out.println("findFirst value : " + IntStream.iterate(10, i -> i + 2).limit(100).findFirst().getAsInt());
System.out.println("findAny value : " + IntStream.iterate(10, i -> i + 2).limit(100).findAny().getAsInt());
System.out.println("parallel findAny value : " + IntStream.iterate(10, i -> i + 2).limit(100).parallel().findAny().getAsInt());
```

**Output:**

```
findFirst value : 10
findAny value : 10
parallel findAny value : 160
```

## 7. `IntStream` `map()` or `flatMap()`

We can transform the `IntStream` into a new form using `map()` method, but `flatMap()` method flattens the `IntStream` into primitives.

```java
IntStream mapInput = IntStream.iterate(10, i -> i + 1).limit(10);
System.out.println("map input stream : " + Arrays.toString(mapInput.toArray()));

IntStream mapOutput = mapInput.map(i -> i * 2);
System.out.println("map Output stream : " + Arrays.toString(mapOutput.toArray()));

IntStream input1 = IntStream.iterate(10, i -> i + 1).limit(10);
System.out.println("flat map : " + Arrays.toString(input1.flatMap(i -> IntStream.of(i)).toArray()));
```

**Output:**

```
map input stream : [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
map Output stream : [20, 22, 24, 26, 28, 30, 32, 34, 36, 38]
flat map : [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
```

## 8. `IntStream` Filter

Use the `filter()` method to filter integer values based on a given `IntPredicate` condition.

After applying the `filter()` method, you can call `forEach()` or `collect()` to convert it into a `List` or `Set`.

```java
IntStream stream = IntStream.range(100, 200);
System.out.println("numbers divisible by 5 and 7 are : ");
stream.filter(i -> (i % 5 == 0 && i % 7 == 0)).forEach(System.out::println);

IntStream stream2 = IntStream.range(100, 200);
List<Integer> primes = stream2.filter(IntStreamOf::checkPrime).boxed().collect(Collectors.toList());
System.out.println("Prime numbers (100, 200) are " + primes);
```

**Output:**

```
numbers divisible by 5 and 7 are :
105
140
175

Prime numbers (100, 200) are [101, 103, 107,

 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199]
```

## 9. `IntStream` `distinct()`

Use `distinct()` method to remove duplicate values from `IntStream`.

```java
Arrays.toString(IntStream.of(1, 2, 3, 1, 2, 3).distinct().toArray());
```

**Output:**

```
[1, 2, 3]
```

## 10. `IntStream` to Array and List or Set

Use `toArray()` method to collect the output of `IntStream` into an array.

Use `collect()` method to collect the output of `IntStream` into a `List` or `Set`.

To remove duplicates from `IntStream`, you can collect the results into a `Set` rather than using the `distinct()` method. However, `distinct()` is recommended.

```java
int[] intArray = IntStream.of(1, 2, 3, 1, 2, 3).toArray();
System.out.println("int array : " + Arrays.toString(intArray));

List<Integer> list = IntStream.of(1, 2, 3, 1, 2, 3).boxed().collect(Collectors.toList());
System.out.println("IntStream to List : " + list);

Set<Integer> set = IntStream.of(1, 2, 3, 1, 2, 3).boxed().collect(Collectors.toSet());
System.out.println("IntStream to Set : " + set);
```


### We'll learn how to convert primitives to wrapper objects in java 8. 

Java programs to convert a stream of int, long, double values into Collection using boxed() method.

This boxed() method is present in IntStream, LongStream, and DoubleStream primitive specialization streams.

boxed() method returns a Stream consisting of the elements of this stream, each boxed to a Wrapper.

### Stream of Strings:

Basically, converting String values into List works very well without any errors.
```java
package com.javaprogramto.w3schools.programs.java8.boxed;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Boxed {

    public static void main(String[] args) {

        // Creating String Stream
        Stream stringStream = Stream.of("java", "program", "to", ".com");

        // converting String's Stream to List
        List strList = stringStream.collect(Collectors.toList());

        // printing each value from list.
        System.out.println("List values are : ");
        strList.forEach(value -> System.out.println(value));

    }
}
```
Stream of int values into List:
```java
        // Creating String Stream
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // converting String's Stream to List
        intStream.collect(Collectors.toList());
```

This code will end up in a compile-time error.

The solution is boxed() method for the primitive streams.

### 2. IntStream.boxed() method Example

Converting primitive int to Wrapper Integer using boxed() method.

Example program to convert int stream to List of Integers:
```java
package com.javaprogramto.w3schools.programs.java8.boxed;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Java Program To IntStream.boxed() method
 * 
 * @author JavaProgramTo.com
 *
 */
public class IntStreamBoxedExample {

    public static void main(String[] args) {

        // creating int stream
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        
        // using boxed() method for boxing primitive int.
        List intList = intStream.boxed().collect(Collectors.toList());

        // print list
        intList.forEach(value -> System.out.println(value));
    }
}
```
Output:

1
2
3
4
5


### 3. LongStream.boxed() method Example

Converting primitive long to Wrapper Long using boxed() method.

Example program to convert the long stream to List of Long values:
```java
package com.javaprogramto.w3schools.programs.java8.boxed;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Java Program To LongStream.boxed() method
 * 
 * @author JavaProgramTo.com
 *
 */
public class LongStreamBoxedExample {

    public static void main(String[] args) {

        // creating long primitive stream
        LongStream longStream = LongStream.of(1l, 2l, 3l, 4l, 5l);

        // using boxed() method for boxing primitive long.
        List longList = longStream.boxed().collect(Collectors.toList());

        // print list
        longList.forEach(value -> System.out.println(value));

    }

}
```
Output:

1
2
3
4
5

### 4. DoubleStream.boxed() method Example

Converting primitive double to Wrapper Double using boxed() method.

Example program to convert the double stream to List of Double:
```java
package com.javaprogramto.w3schools.programs.java8.boxed;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * Java Program To DoubleStream.boxed() method
 * 
 * @author JavaProgramTo.com
 *
 */
public class DoubleStreamBoxedExample {

    public static void main(String[] args) {

        // creating double primitive stream
        DoubleStream doubleStream = DoubleStream.of(1d, 2d, 3d, 4d, 5d);

        // using boxed() method for boxing primitive long.
        List doubleList = doubleStream.boxed().collect(Collectors.toList());

        // print list
        doubleList.forEach(value -> System.out.println(value));

    }

}
```
Output:


1.0
2.0
3.0
4.0
5.0

### we'll learn about java 8 in the aspect of the following.

- Impact of Multi-Core CPU
- Anonymous Inner classes
- Stream Pipe Line
- Functional Interfaces
- How java 8 code looks with Examples

]Stream API provides a package java.util.stream. This API provides several methods to iterate over a stream. This iterator can be called as New Fancy Iterator.
These methods can be used as a chain of the pipeline with complex logic similar to the UNIX pipeline command as below.

grep 'Exception' application.log | grep -V 'Server Exception' | tail -10

### 2. Multicore CPU
By using stream API, we can express our logic at a high level and the execution part is taken care of by Stream Library. As part of this, developers need to worry about synchronizing. The synchronized keyword makes to put many efforts to handle the errors caused by multiple threads. This stream API avoids high error-prone and uses multi-core CPU effectively.

If we do not use much multi-threading then we will not be using all the cores in the CPU.  That means not utilizing all core properly. So, We will experience performance issues If we don't use all the core properly. Java 8 has been developed after considering all these issues.

Java 8 stream API consumes all available core effectively and improves the performance significantly. 

### 3. Anonymous Inner class
Prior to Java 8, Anonymous inner classes are widely used by all the developers.
```java
Inerface AddOn {
 boolean addAddon(String addOnType);
}

public void processingCreditCardAddOn(int cardNumber, AddOn addOn){

 boolean isValid = ValidateAccountNumber(cardNumber);
 if(isValid){
  addOn.addAddon("Extra Reward Points")
 }
}
```
When we call the processingCreditCardAddOn() method from service class, the implementation for the AddOn interface. Instead of creating a new class with implementation, We can pass the anonymous class to this method as below.
```java
processor.processingCreditCardAddOn(1234567898765432, new AddOn() {
 public boolean addAddon(String addOnType){
  
  //logic to add the addOnType to the given account number.
 }
})
```
Now the code has become non readable and looks ugly by seeing anonymous class implementation.
The same can be simplified and making it more readable using Lambda concept.

```java
processingCreditCardAddOn(1234567898765432, (addOnType) ->  //logic to add the addOnType to the given account number );
```
### 4. Stream Pipe Line

Java Stream API is developed mainly for Big Data application to process the large data sets effectively using all the hardware.

Example on Stream API to find the error in the log file.

First converting the log content into stream.
```java
Stream stream = Stream.of(responseContent.split("\n"));

String firstException = stream.filter(line -> line.indexOf("ERROR") > -1 || line.indexOf("Exception) > -1).findFirst();
```

Here, First a pipe line will be created and every operation that perform on stream are placed in this pipe line. In other words, After that what ever we do like filter(), map() etc all the operations are placed into pipe line. But all not executed immediately unless invoke terminal methods.

Terminal methods that close the stream by producing the result. Terminal methods examples are reduce(), count(), findFirst() etc.

Once any terminal method is invoked than code is optimized by API and executes in the best order.

### 5. Functional Interfaces

To work with streams, we must have an idea about functional interface.
If any interface has only one abstract method then it is called Functional Interfaces. Functional Interfaces can have any number of default and private methods.

Filter(), Map() methods will be using internally Functional Interfaces.

Examples are BiConsumer, Predicate, BinaryOperator, Function. All these are in java.util.function package.

Find list of all Functional Interfaces introduced in Java 8.

### 6. Stream API Intermediate Operations

Every stream code or pipeline must-have a map() or filter() methods. These methods are called as Intermediate Functions because these methods again create a temporary Stream to hold the intermediate output.

Learn about all intermediate stream operations in-depth.

- filter()
- map()
- flatMap()
- distinct()
- sorted()
- peek()
- limit()
- skip()

### 7. Stream API Terminal Operations

After calling the intermediate methods, to collect the final output stream api has another set of methods. Those are called Terminal Operations. These methods produce output such as Collection, List, Set, or Optional values.

I have shown an in-depth tutorial on Terminal Operations.

- toArray()
- collect()
- count()
- reduce()
- forEach()
- forEachOrdered()
- min()
- max()
- anyMatch()
- allMatch()
- noneMatch()
- findAny()
- findFirst()

We'll learn about What are Intermediate Operations in Java 8 Stream. All these operations are in package java.util.stream.Stream.

In the last tutorial, We've discussed Java 8 Stream API and Lambda Expressions.


Rules:

Java 8 Stream intermediate operations return another Stream which allows you to call multiple operations in the form of a query.

Stream intermediate operations do not get executed until a terminal operation is invoked.
All Intermediate operations are lazy, so they’re not executed until a result of processing is actually needed.

Traversal of the Stream does not begin until the terminal operation of the pipeline is executed.

### Stream Intermediate Operations:
Here is the list of all Stream intermediate operations:
- filter()
- map()
- flatMap()
- distinct()
- sorted()
- peek()
- limit()
- skip()




We will see example programs on each operation in the further article.

### 2. filter() 
Returns a stream consisting of the elements of this stream that match the given predicate.
Syntax:
```
Stream filter​(Predicate predicate)
```
Example:
```
Stream intStream = Stream.of(1, 2, 3, 4, 5);
Stream subStream = intStream.filter(value -> value > 3);
long count = subStream.count();
System.out.println(count);
```
Output:
2

This program takes Predicate functional interface as lambda and checks for the number is greater than 3.

### 3. map()

Returns a stream consisting of the results of applying the given function to the elements of this stream.

Syntax: 
```
Stream map​(Function mapper)
```

Example:

```
// map() Operation
Stream strStream = Stream.of("Welcome", "To", "java", "blog");
Stream subStream2 = strStream.map(string -> {
 if (string == "java")
  return "Java-W3schools";
 return string;
});
List welomeList = subStream2.collect(Collectors.toList());
System.out.println(welomeList);
```

Here, map function takes an argument type of Function. The function is a functional interface and has a method apply(). This method takes a value and returns another value.
Output:

[Welcome, To, Java-W3schools, blog]

In this example, replacing the word "java" with "Java-W3schools".

map() wrpper types are also comes under intermediate operations category.
> mapToDouble(), mapToLong(), mapToInt()

### 4. flatMap()

This flatmap works best for a list of collections. We will show the example with two lists and how to convert them into a single stream using flatmap() method.
syntax:
```
<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
```
Example:

Example program to count the number of unique fruit names from two lists.

```
Stream flatStream = stream.flatMap(list -> list.stream());
//flatStream.forEach(str -> System.out.println(str));
long distinctFruites = flatStream.distinct().count();
System.out.println(distinctFruites);
```
Output:
6

And also see the most common problem with solution when working with Stream "stream has already been operated upon or closed". After uncomming line `flatStream.forEach(str -> System.out.println(str));` this program will exception java.lang.IllegalStateException.

Similar flatMap() methods for wrapper types such as flatMapToInt(), flatMapToLong(), flatMapToDouble().

### 5. distinct()

Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.

For ordered streams, the selection of distinct elements is stable (for duplicated elements, the element appearing first in the encounter order is preserved.) For unordered streams, no stability guarantees are made.
Syntax:
Copy All Code
Stream distinct()

Example:
```
// distinct() Operation
Stream fruitsStream = Stream.of("Apple", "Jack Fruit", "Water Melon", "Apple");
Stream distinctStream = fruitsStream.distinct();
distinctStream.forEach(name -> System.out.println(name));
```
Output:
Apple
Jack Fruit
Water Melon


### 6. sorted()

Returns a stream consisting of the elements of this stream, sorted according to the natural order.
If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed.


Note: For ordered streams, the sort is stable. For unordered streams, no stability guarantees are made.
Syntax:
```
Stream sorted()
```
Example:
```
// sort() Operation
Stream vegStream = Stream.of("tomoto", "Green Chilli", "Pototo", "Beet root");
Stream sortedStream = vegStream.sorted();
sortedStream.forEach(name -> System.out.println(name));
```
Output:
Beet root
Green Chilli
Pototo
tomoto

### 7. peek()

Returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.

peek() method is the best way to debug the streams in Java 8. The eclipse will not support for debugging.

Note: We can not predict the order of peek() invocation for parallel stream pipelines.

Syntax:
Copy All Code
Stream peek​(Consumer action)

Example:
```
// peek() Operation
Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
  .peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
  .peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
```
For each time filter condition satisfies, immediately peek() method will be invoked. See the output, you'll understand better.

Output:

Filtered value: three
Mapped value: THREE
Filtered value: four
Mapped value: FOUR

### 8. limit()

Returns a stream with the limited size given. It will truncate the remaining elements from the stream.

Note: limit() is suitable for sequential streams and cannot give good performance results for parallel streams.

Syntax:
```
Stream limit​(long maxSize)
```
Example:
Program to limit the stream to first two elements.

```
Stream.of("one", "two", "three", "four").limit(2).forEach(item -> System.out.println(item));
```
Output:
one
two

### 9. skip()

This method skips the given n elements and returns a Stream. This is the most useful when want to perform any operations on last n records or lines from a List or Stream.

Syntax:
```
Stream skip​(long n)
```
Example:
program to skip the first 2 elements and print remaining elements.
```
Stream.of("one", "two", "three", "four", "five").skip(2).forEach(item -> System.out.println(item));
```
Output:
three
four
five

We'll learn What are Terminal Operations in Java 8. List all Java 8 Stream Terminal Operations with Examples.
Java-8 Stream terminal operations produce a non-stream, result such as primitive value, a collection or no value at all.
Terminal operations are typically preceded by intermediate operations that return another Stream which allows operations to be connected in a form of a query. 

OR 

Terminal operations can be performed on Java Stream directly.

Whereas Stream Intermediate operations produce a stream as a result.




### 2. List Terminal Operations

Here is the list of all Stream terminal operations:

- toArray()
- collect()
- count()
- reduce()
- forEach()
- forEachOrdered()
- min()
- max()
- anyMatch()
- allMatch()
- noneMatch()
- findAny()
- findFirst()
In further this article, we will be showing example programs on each operations.

### 3. Stream toArray() Method Example

Returns an array containing the elements of this stream, using the provided generator function to allocate the returned array, as well as any additional arrays that might be required for a partitioned execution or for resizing.

This will convert a stream into Object[] array or into a specified array to the IntFunction.

Syntax:
```
Object[] toArray()
<A> A[] toArray(IntFunction<A[]> generator)
```
Example:
```
Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

Object[] objArray = stream.toArray();
System.out.println("objArray length " + objArray.length);
```
 Output:

objArray length 5
### 4. Stream collect() Method Example

collect() method is the one most used in stream pipeline at the end. This method is used to collect the output of the Stream into List or Set or to perform groupingby and partioningby operations on the stream.
We have covered all possible operations on collect() method in the previous article.

Java 8 Stream Collectors API working examples.

Syntax:
```
<R,​A> R collect​(Collector<? super T,​A,​R> collector)
```
Example:

Stream<Integer> streamCOllect = Stream.of(1, 2, 3, 4, 5);
```
List<Integer> intList = streamCOllect.collect(Collectors.toList());
Set<Integer> intSet = streamCOllect.collect(Collectors.toSet());
Long count = streamCOllect.collect(Collectors.counting());
```
Output:

We will get the count or size 5 for all statements.

### 6. Stream count() Method Example

This method count of elements in this stream.

Syntax:
```
long count()
```
Simply returns the long value for the stream.

Example:
```
// Stream count() Method Example
Stream<Integer> streamCount = Stream.of(1, 2, 3, 4, 5);
long count = streamCount.count();
System.out.println("count :: " + count);
```
Output:

count :: 5
This is a special case of a reduction and is equivalent to:
```
return mapToLong(e -> 1L).sum();
```
### 7. Stream reduce() Example

Wherever we need to perform the one operation multiple times and finally it produces one result such as min, max, avg, sum. In these scenarios reduce() method is very useful.

Syntax:
```
Optional<T> reduce(BinaryOperator<T> accumulator)
```
Example:

To find the sum of the first 5 integers from the stream.
```
// Stream count() Method Example
Stream<Integer> streamReduce = Stream.of(1, 2, 3, 4, 5);
Optional<Integer> sum = streamReduce.reduce((value1, value2) -> value1 + value2);
System.out.println("sum of first 5 numbers using reduce opration : " + sum.get());
```
Output:


sum of first 5 numbers using reduce opration : 15  
### 7. Stream forEach() Example

This is very useful while debugging to print the values of the stream. This is used to perform one action on each value of stream and finally returns nothing.

Syntax:
```
void forEach(Consumer<? super T> action)
```
This takes Consumer Functional Interface as an argument.

Example:
```
// Stream forEach() Method Example
Stream<Integer> streamForEach = Stream.of(1, 2, 3, 4, 5);
// Printing the values
streamForEach.forEach(value -> System.out.println(value));

// Adding values to list.
List<Integer> numList = new ArrayList<>();
streamForEach.forEach(value -> numList.add(value));
System.out.println("numList : " + numList);
```
Output:
3
5
4
1
2
numList : [3, 5, 1, 4, 2]

Note: This works for both sequential and parellel streams.


### 8. Stream forEachOrdered() Example

This method works similarly to the forEach() but it executes the order they appear in the stream. This ignores the parallel() method invocation.

Syntax:
```
void forEachOrdered(Consumer<? super T> action)
```
Example:

```
// Stream streamForEachOrdered() Method Example
Stream<Integer> streamForEachOrdered = Stream.of(1, 2, 3, 4, 5).parallel();
// Printing the values
streamForEachOrdered.forEachOrdered(value -> System.out.println(value));

// Adding values to list.
Stream<Integer> streamForEachOrderedList = Stream.of(1, 2, 3, 4, 5).parallel();
List<Integer> numList1 = new ArrayList<>();
streamForEachOrderedList.forEachOrdered(value -> numList1.add(value));
System.out.println("numList1 : " + numList1);
```
Output:
1
2
3
4
5
numList1 : [1, 2, 3, 4, 5]
Compare the output with forEach() method output and see the order.

### 9. Stream min() Example

min() method returns the minimum element of this stream according to the provided Comparator. This does first sorting and takes the first element from the sorted array.

Syntax:
```
Optional<T> min(Comparator<? super T> comparator)
```
Example:
```
// Stream min() Method Example
Stream<Integer> streamMin = Stream.of(1, 2, 3, 4, 5).parallel();
Optional<Integer> min = streamMin.min((v1, v2) -> v1.compareTo(v2));
System.out.println("Min value : " + min.get());
```
Output:
Min value : 1
### 10. Stream max() Example

This method returns the maximum element of this stream according to the provided Comparator. This internally does sorting first and get the last element from it. If the stream is having large data set then better not to use this.

Syntax:
```
Optional<T> max(Comparator<? super T> comparator)
```
Example:
```
// Stream max() Method Example
Stream<Integer> streamMax = Stream.of(1, 2, 3, 4, 5).parallel();
Optional<Integer> max = streamMax.max((v1, v2) -> v1.compareTo(v2));
System.out.println("Max value : " + max.get());
```
Output:

Max value : 5
### 11. Stream anyMatch() Example

This method checks the predicate condition. If any value in the stream matches to the given predicate then it returns true else false.

Predicate is a functional interface that holds the condition.
```
Predicate p = value -> value > 0;
```
Syntax:
```
boolean anyMatch(Predicate<? super T> predicate)
```
Example:
```
// Stream anymatch() Method Example
Stream<Integer> streamAnymatch = Stream.of(1, 2, 3, 4, 5).parallel();
Predicate<Integer> anymatch = value -> value > 4;
boolean isAnymatch = streamAnymatch.anyMatch(anymatch);
System.out.println("anymatch value : " + isAnymatch);
```
Output:
anymatch value : true
If the stream is empty then returns false and predicate condition is not evaluated.

### 12. Stream allMatch() Example

This method also takes a predicate as an argument. Predicate holds a condition. If all values of stream match to the given predicate then it returns true else false.


Syntax:
```
boolean allMatch(Predicate<? super T> predicate)
```
Example:
```
// Stream allmatch() Method Example 
Stream<Integer> streamAllmatch = Stream.of(1, 2, 3, 4, 5).parallel();
Predicate<Integer> allmatch = value -> value > 2;
boolean isAllmatch = streamAllmatch.allMatch(allmatch);
System.out.println("allmatch value : " + isAllmatch);
```
Output:
allmatch value : false
If the stream is empty then returns true and predicate condition is not evaluated.


### 13. Stream noneMatch() Example

This takes a predicate as an argument. If all of the stream elements do not match the predicate condition then it returns true else false.

Syntax:
```
boolean noneMatch(Predicate<? super T> predicate)
```
Example:
```
// Stream noneMatch() Method Example
Stream<Integer> streamNoneMatch = Stream.of(1, 2, 3, 4, 5).parallel();
Predicate<Integer> nonematch = value -> value > 7;
boolean isNoneMatch = streamNoneMatch.noneMatch(nonematch);
System.out.println("noneMatch method returned value : " + isNoneMatch);
```
Output:
noneMatch method returned value : true


See the above output and printed it as true. because the predicate condition is value greater than 7 and all values are below 7. No con
If the stream is empty then returns true and predicate condition is not evaluated.

14. Stream findAny() Example

This will be getting the value randomly from the stream. That's why the method is named findAny if any value present in the stream.
The value will be returned as an Optional object. If the stream is empty then it returns empty Optional object.

Syntax:
```
Optional<T> findAny()
```
Example:
```
// Stream findAny() Method Example
Stream<Integer> streamFindAny = Stream.of(1, 2, 3, 4, 5).parallel();
Predicate<Integer> findAny = value -> value % 2 == 1;
Optional<Integer> findAnyOpt = streamFindAny.filter(findAny).findAny();
System.out.println("Find any odd number : " + findAnyOpt.get());
```
Output:
Find any odd number : 5
Here 5 is picked up by findAny() method. If we run multiple times then it will return 1 or 3.

### 15. Stream findFirst() Example

This method get the first value always from stream. The value is returned as an instance of Optional. If the stream is empty them returns empty Optional object.

Syntax:
```
Optional<T> findFirst()
```
Example:
```
// Stream findFirst() Method Example
Stream<Integer> streamFindFirst = Stream.of(1, 2, 3, 4, 5).parallel();
Predicate<Integer> findFirst = value -> value % 2 == 0;
Optional<Integer> findFirstOpt = streamFindFirst.filter(findFirst).findFirst();
System.out.println("Find first odd number : " + findFirstOpt.get());
```
Output:
Find first odd number : 2
If we call findFirst() multiple times and it will return always value 2.

### 16. Full Examples Program

All the examples are shown in the single java program with output.
```java
package com.java.w3schools.blog.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream api terminal operations of java 8
 * 
 * @author java-w3schools
 *
 */
public class StreamTerminalOperations {

 public static void main(String[] args) {

  Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

  // Stream toArray() Method Example
  Object[] objArray = stream.toArray();
  System.out.println("objArray length " + objArray.length);

  // Stream collect() Method Example
  Stream<Integer> streamCOllect = Stream.of(1, 2, 3, 4, 5);

  List<Integer> intList = streamCOllect.collect(Collectors.toList());
  // Set<Integer> intSet = streamCOllect.collect(Collectors.toSet());
  // Long count = streamCOllect.collect(Collectors.counting());

  // Stream count() Method Example
  Stream<Integer> streamCount = Stream.of(1, 2, 3, 4, 5);
  Long count = streamCount.count();
  System.out.println("count :: " + count);

  // Stream count() Method Example
  Stream<Integer> streamReduce = Stream.of(1, 2, 3, 4, 5);
  Optional<Integer> sum = streamReduce.reduce((value1, value2) -> value1 + value2);
  System.out.println("sum of first 5 numbers using reduce opration : " + sum.get());

  // Stream forEach() Method Example
  Stream<Integer> streamForEach = Stream.of(1, 2, 3, 4, 5).parallel();
  // Printing the values
  // streamForEach.forEach(value -> System.out.println(value));

  // Adding values to list.
  List<Integer> numList = new ArrayList<>();
  streamForEach.forEach(value -> numList.add(value));
  System.out.println("numList : " + numList);

  // Stream streamForEachOrdered() Method Example
  Stream<Integer> streamForEachOrdered = Stream.of(1, 2, 3, 4, 5).parallel();
  // Printing the values
  streamForEachOrdered.forEachOrdered(value -> System.out.println(value));

  // Adding values to list.
  Stream<Integer> streamForEachOrderedList = Stream.of(1, 2, 3, 4, 5).parallel();
  List<Integer> numList1 = new ArrayList<>();
  streamForEachOrderedList.forEachOrdered(value -> numList1.add(value));
  System.out.println("numList1 : " + numList1);

  // Stream min() Method Example
  Stream<Integer> streamMin = Stream.of(1, 2, 3, 4, 5).parallel();
  Optional<Integer> min = streamMin.min((v1, v2) -> v1.compareTo(v2));
  System.out.println("Min value : " + min.get());

  // Stream max() Method Example
  Stream<Integer> streamMax = Stream.of(1, 2, 3, 4, 5).parallel();
  Optional<Integer> max = streamMax.max((v1, v2) -> v1.compareTo(v2));
  System.out.println("Max value : " + max.get());

  // Stream anymatch() Method Example
  Stream<Integer> streamAnymatch = Stream.of(1, 2, 3, 4, 5).parallel();
  Predicate<Integer> anymatch = value -> value > 4;
  boolean isAnymatch = streamAnymatch.anyMatch(anymatch);
  System.out.println("anymatch value : " + isAnymatch);

  // Stream allmatch() Method Example
  Stream<Integer> streamAllmatch = Stream.of(1, 2, 3, 4, 5).parallel();
  Predicate<Integer> allmatch = value -> value > 2;
  boolean isAllmatch = streamAllmatch.allMatch(allmatch);
  System.out.println("allmatch value : " + isAllmatch);

  // Stream noneMatch() Method Example
  Stream<Integer> streamNoneMatch = Stream.of(1, 2, 3, 4, 5).parallel();
  Predicate<Integer> nonematch = value -> value > 7;
  boolean isNoneMatch = streamNoneMatch.noneMatch(nonematch);
  System.out.println("noneMatch method returned value : " + isNoneMatch);

  // Stream findAny() Method Example
  Stream<Integer> streamFindAny = Stream.of(1, 2, 3, 4, 5).parallel();
  Predicate<Integer> findAny = value -> value % 2 == 1;
  Optional<Integer> findAnyOpt = streamFindAny.filter(findAny).findAny();
  System.out.println("Find any odd number : " + findAnyOpt.get());

  // Stream findFirst() Method Example
  Stream<Integer> streamFindFirst = Stream.of(1, 2, 3, 4, 5).parallel();
  Predicate<Integer> findFirst = value -> value % 2 == 0;
  Optional<Integer> findFirstOpt = streamFindFirst.filter(findFirst).findFirst();
  System.out.println("Find first odd number : " + findFirstOpt.get());

 }

}
````
Output:
objArray length 5
count :: 5
sum of first 5 numbers using reduce opration : 15
numList : [3, 1, 4, 2, 5]
1
2
3
4
5
numList1 : [1, 2, 3, 4, 5]
Min value : 1
Max value : 5
anymatch value : true
allmatch value : false
noneMatch method returned value : true
Find any odd number : 1
Find first odd number : 2


We'll learn what are the ways to create a read only collection List, Set, or Map in java 8 and older versions. In other ways, It is called as Imuutale or unmodifiable collection.

Usually, Whatever the objects that we create using a new keyword will create mutable collections objects as below.
```java
List<String> list = new ArrayList<String>();
Next, On list instance, you can call add() or remove() methods of List interface.

list.add("one");
list.add("two");

list.remove("two");

list.add("three");

System.out.println("List values : "+list);
```
Output:


List values : [one, three]
You can observe that previously added value "two" is removed from the list and added a new value "three" to it.

Our main core concept of this article is to make the existing list as read only after adding the needed values.


### 2. Collections.unmodifiableCollection() Method

The Collections utility class is added with several methods to make the collection as Read Only. All of these are static methods so directly can be accessed with the Collections class.

Collections.unmodifiableCollection() method returns an unmodifiable view of the specified collection. This method works for both list and set examples.

Syntax:

```
public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> c)
```
Collections.unmodifiableCollection() Example:
```java

package com.javaprogramto.readonly;

import java.util.ArrayList;

import java.util.Collection;

import java.util.Collections;

import java.util.List;


public class ReadOnlyCollectionExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("one");

        list.add("two");

        list.add("three");


        list.remove("two");


        System.out.println("List values : " + list);


        Collection<String> readOnlyList = Collections.unmodifiableCollection(list);


        System.out.println("Read only collection : " + readOnlyList);

    }
}
```
Output:


List values : [one, three]
Read only collection : [one, three]
Now try to add the new value to the readOnlyList. Then, it will produce the runtime exception saying "UnsupportedOperationException".

readOnlyList.add("new value");
Error:

```
Exception in thread "main" java.lang.UnsupportedOperationException
at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
at ReadOnlyCollectionExample.main(ReadOnlyCollectionExample.java:25)
```
### 3. Collections.unmodifiableList() - To make List as read only

Returns an unmodifiable view of the specified list. Input argument must be a List interface implementation.
```java
package com.javaprogramto.readonly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ReadOnlyCollectionunmodifiableListExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("one");

        list.add("two");

        list.add("three");

        list.remove("two");

        System.out.println("List values : " + list);


        List<String> readOnlyList = Collections.unmodifiableList(list);


        System.out.println("Read only collection : " + readOnlyList);


        if (readOnlyList.getClass().getName().contains("Unmodifiable")) {

            System.out.println("readOnlyList is a Read only collections");

        } else {

            System.out.println("This is not Read only collections");

        }

    }
}
```
Output:
List values : [one, three]
Read only collection : [one, three]
readOnlyList is a Read only collectionsNote: Making List as read only can be done in another way using Arrays.asList() method but Arrays class a utility method to only for List and not for Set, Map implementations.


### 4. Collections.unmodifiableSet() - To make Set as read only

Collections.unmodifiableSet() returns a unmodifiable view for the given set. Input arguemnt must be Set interface implementation and either HashSet or LikedHashSet.
```java
package com.javaprogramto.readonly;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;


public class ReadOnlyCollectionunmodifiableSetExample {

    public static void main(String[] args) {

        Set<String> set = new LinkedHashSet<String>();

        set.add("one");
        set.add("two");
        set.add("three");
       
        set.remove("two");


        System.out.println("Set values : " + set);


        Set<String> readOnlySet = Collections.unmodifiableSet(set);


        System.out.println("Read only collection : " + readOnlySet);


        if (readOnlySet.getClass().getName().contains("Unmodifiable")) {

            System.out.println("readOnlySet is a Read only collections");

        } else {

            System.out.println("readOnlySet not Read only collections");
        }
       
    }
}
```
Output:
Set values : [one, three]
Read only collection : [one, three]
readOnlySet is a Read only collections
### 5. Collections.unmodifiableMap() - To make Map as read only

Collections.unmodifiableMap() returns a unmodifiable view for the given Map. Input arguments must be Set interface implementation and either HashMap or LikedHashMap or TreeMap.
```java
package com.javaprogramto.readonly;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class ReadOnlyCollectionunmodifiableMapExample {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<Integer, String>();

        map.put(100, "one");
        map.put(200, "two");
        map.put(300, "three");

        map.remove(100);

        System.out.println("Set map : " + map);


        Map<Integer, String> readOnlyMap = Collections.unmodifiableMap(map);


        System.out.println("Read only map : " + readOnlyMap);


        if (readOnlyMap.getClass().getName().contains("Unmodifiable")) {

            System.out.println("readOnlyMap is a Read only collections");

        } else {

            System.out.println("readOnlyMap not Read only collections");

        }
    }
}
```
Output:
Set map : {200=two, 300=three}
Read only map : {200=two, 300=three}
readOnlyMap is a Read only collections
### 6. Java 9 Read Only List

In java 9, It is very easy to do converting an Array into a List as read-only

List interface is added with static method List.of() which takes the varargs.
String[] stringArray = {"1", "2"};

List<String> stringList = List.of(stringArray);
### 7. Java 10 Read Only List

In java 10 api, List is added with copyOf() and Collectors added with toUnmodifiableList() method.
List.copyOf(list);

List<String> readOnlyListJava10 = list.stream().collect(Collectors.toUnmodifiableList());

Set<String> readOnlySetJava10 = list.stream().collect(Collectors.toUnmodifiableSet());

Map<Integer, String> readOnlyMapJava10 = list.stream().collect(Collectors.toUnmodifiableMap());


We'll learn how to write programs using java 8 lambda and Stream concepts with examples. Many developers feel learning java 8 concepts may be hard to understand. But once we are good using them then feel reduces error prone code and improves the performance of the application.

Read article on Java 8 Lamda Expression Rules


In this article, We will see the example programs on sorting using Comparator, File names validation, Retrieving only hidden files and filtering list objects based on conditions.

## 2. Sorting - Lambda Expression
### 2.1 Before Java 8

See the below code which is implemented in older versions of Java. Here trying to sort the Employee's based on the id column.

Collections.sort(emplyeesList, new Comparator() {
 public int compare(Employee a1, Employee a2){
  return a1.getId().compareTo(a2.getId());
 }
});


Here, written code in 5 lines in which includes Comparator implementation.
### 2.2 In Java 8
See the below code in Java 8. All the code is in single line and not seeing comparing logic.

emplyeesList.sort(Comparator.comparing(Employee::getId));
Here, Comparator is a Functional Interface which has only one abstract method.

Comparator has a static method comparing(.Function.) which accepts only Funtion interface.
https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html

Note: Function<T, R> also a Functional Interface. This has a method apply(T t) which will be called from Comparator.comparing() method.

## 3. File Name Validation with Lambda Expression
### 3.1 Before Java 8

See the code in java old version. Here the core logic is file.getName().endsWith(".xml"); The remaining code is just syntax.

File[] hiddenFiles = new File("directory_name").listFiles(new FileFilter() {
 public boolean accept(File file) {
  return file.getName().endsWith(".xml");
 }
});
### 3.2 In Java 8
The above code is simplified to single line which reduces the errors.

File[] hiddenFiles = new File("directory_name").listFiles( file -> file.getName().endsWith(".xml"));
Note: Java 8, just focus on the business logic and takes its syntax internally. Developer need not to worry about it.


## 4. Retrieving only Hidden files - Lambda Expression
### 4.1 Before java 8

File has a method to check the method is hidden or not using isHidden() method.

File[] hiddenFiles = new File("directory_name").listFiles(new FileFilter() {
 public boolean accept(File file) {
  return file.isHidden();
 }
});
### 4.2 In Java 8
Just using the new Method Reference concept as part of new Java 8.

File[] hiddenFiles = new File("directory_name").listFiles(File::isHidden);


Lambda word came from lambda calculus which is used to describe computations. We will go through one by one as below topics today.

Definition
Comparing to Older Java Versions
Lambda Syntax
Lambda Valid Examples
Lambda Rules
Where to Use Lambda
Lambda Sorting Example
Invalid Lambda Expressions
We have already shown few examples on Java 8 Examples Programs Before and After Lambda & Streams. Go through this article before continuing further on this tutorial. If you have basic understanding of lambda's then you are good to continue.

## 2. Definition

Lambda Expression can be explained as an anonymous function without having a name and passing this anonymous function to another method as an argument.

Anonymous method does not have name but it has list of method arguments, body, return type and valid list of exceptions that can be thrown. 

Lambda Expression will become more concise because this will avoid lots of boiler place coding.

This can be passed as an argument to a method or store in a variable.

If you do not understand at this point, please do not worry. You will definitely understand after reading this complete tutorial.

### 3. Comparing to Older Java versions

Many developers have a doubt why this concept is introduced in Java 8, not in prior versions of java. And also what is the importance of Lambda?

In java 8 using lambda makes us not write clumsy code using anonymous classes to benefit from behavior parameterization.

Behavior parameterization means passing our logic to a method as a argument.

Note:
Lambdas technically don’t let you do anything that you couldn’t do prior to Java 8. Whatever can be done in older version of Java are same can be done in java 8 also. This just makes us to focus only the core business logic instead of writing tedious syntax.

Now code will become more readable and flexible.

### 4. Lambda Syntax
Now, We'll take a look at the Lambda syntax.

(lambda parameters) -> (lambda body);
Lambda has mainly three pars.

a) lambda Parameters
b) Lambda Symbol
c) Method body

Here lambda parameters are optional. This is similar to the method arguments. A number of arguments from 0 to N. Parenthesis are mandatory.

Lambda is defined by the symbol '->' (Arrow mark). separates the list of parameters from the body of the lambda.

Next lambda body is similar to the method body. If this is a single line then no need to use the curly braces. We need to write the core logic in the lambda body.

We will learn more about Lambda rules in this further tutorial. For now, take a look at the below simple example.

Interface interf = (int number) -> (System.out.println("Given number "+number));
In the above example program, We are passing a number as an argument to lambda and printing the same value. On the left side, assigned Lambda to a functional interface that is perfectly legal. You will learn more about later in this article.

## 5. Lambda Valid Examples
We will see valid lambda examples. See more examples on java.util.Stream package.


### 5.1 Getting String length
(String str) -> str.length();
Here this takes one parameter of type string. This also returns a value that is int type. But, we can not see the returned type because not declared anywhere in the declaration. It is applied internally based on the lambda body. If lambda has only one statement and that hold value that becomes as a return type.

### 5.2 Employee Rating check

(Employee emp) -> emp.getGrade().equals("A");
Takes one parameter of type Employee and returns boolean. Lambda Body checks grade equal to the "A" then returns true or false.

### 5.3 Concatenate two strings and print output

(String str1, String str2) -> {
                               String output = str1.concat(str2);
          System.out.println("Concantenated string "+output);
         }
Takes two String parameters and returns nothing. That means the return type is void. The body has two statements that concatenate and prints the output string.

## 6. Lambda Rules
As of have seen a few examples but you still may have some queries. Now we will see all the rules here that make clear for us.

### 6.1 Parameters are optional. It can be zero or more.

 () -> {System.out.println("Hello World");};
 (int a) -> {System.out.println("value "+a);};
### 6.2 If no parameters are available then we need to use empty parenthesis ().

() -> {System.out.println("Hello World");};
### 6.3 If we have multiple parameters then need to separate them with a comma(,)

(int a, int b) -> System.out.println("sum "+(a+b));
### 6.4 if the body has the only statement then curly braces are optional.

 (int a) -> System.out.println("value "+a);
### 6.5 if the body has more than one statement then curly braces are mandatory.

 () -> {
   System.out.println("Hello World");};
   System.out.println("value "+a);
    };
### 6.6 parameter type(s) is optional. No need to declare manually because compile can expect based on the context. We will discuss more in the next post.

 (a) -> System.out.println("value "+a);
 (a, b) -> System.out.println("sum "+(a+b));
### 6.7 If only one parameter is available then parenthesis is optional.

(int a) -> {System.out.println("value "+a);};
The above can be rewritten as a -> {System.out.println("value "+a);};

### 6.8 We can assign a lambda to Functional Interface.

SummatiobInterface sumInt = (int a, int b) -> a+b;

## 7. Where to Use Lambda
You may have a question that where should we use Lambda Expression. For this, the Answer is "usage on any interface which has only one abstract method". In other words, on any Functional Interface.

Examples java API interfaces are Comparator, Runnable, Callable. All these interfaces are available in before java 8.
```java
public interface Comparator {
 int compare(T o1, T o2);
}

public interface Runnable {
 void run();
}

public interface Callable {
 V call() throws Exception;
}
```
Many functional interfaces are introduced in Java 8 also. Predicate and Supplier are well known to developers.

### 7.1 Predicate:
Evaluates this predicate on the given argument. This takes type t as input and returns boolean.
```java
@FunctionalInterface
public interface Predicate {
 boolean test (T t);
}
```
Predicate Example
```
Predicate p = (emp) -> emp.isCompleted5years();
```
### 7.2 Supplier:
Represents a supplier of results. This can hold any value.
```java
@FunctionalInterface
public interface Supplier {

    T get();
}
```
Supplier Example
```
Supplier supplier = () -> "Java-W3schools";
String str = supplier.get();
```
The Supplier is getting string type and we can get the value by calling get() method of Supplier.

List of all functional interfaces in Java 12APIi

## 8. Lambda Sorting Example
Taking Employee class with id, salary, and designation fields. Now we want to sort the employees on salary.

Creating Employee class with constructor, setter and getter methods. And also overridden toString() method to print all the fields of Employee.
```java
package com.java.w3schools.blog.streams.sorting;

public class Employee {

 private int id;
 private Long salary;
 private String designation;

 public Employee(int id, Long salary, String designation) {
  this.id = id;
  this.salary = salary;
  this.designation = designation;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public Long getSalary() {
  return salary;
 }

 public void setSalary(Long salary) {
  this.salary = salary;
 }

 public String getDesignation() {
  return designation;
 }

 public void setDesignation(String designation) {
  this.designation = designation;
 }

 @Override
 public String toString() {
  return "Employee [id=" + id + ", salary=" + salary + ", designation=" + designation + "]";
 }
}
```
Creating an Employee's array.

Employee[] employees = { new Employee(100, 10000L, "Software Engineer"), new Employee(101, 5000L, "Junior SE"),
    new Employee(105, 6000L, "Junior SE"), new Employee(110, 2500L, "Intern") };
Converting Employee array into List<Employee>.

List empList = Arrays.asList(employees);

### 8.1 Sorting Traditional Approach
First, we will write a program using traditional comparator object creation using an anonymous inner class.

Calling sort() method of List and passing an anonymous object for Comparator.
```java
System.out.println("empList Before sorting : "+empList);
empList.sort(new Comparator() {
 @Override
 public int compare(Employee o1, Employee o2) {

  return o1.getSalary().compareTo(o2.getSalary());
 }
});

System.out.println("empList after sorting : "+empList);
```
Output:

empList Before sorting : [Employee [id=100, salary=10000, designation=Software Engineer], Employee [id=101, salary=5000, designation=Junior SE], Employee [id=105, salary=6000, designation=Junior SE], Employee [id=110, salary=2500, designation=Intern]]
empList after sorting : [Employee [id=110, salary=2500, designation=Intern], Employee [id=101, salary=5000, designation=Junior SE], Employee [id=105, salary=6000, designation=Junior SE], Employee [id=100, salary=10000, designation=Software Engineer]]
### 8.2 Sorting with Lambda
The above sorting code has lots of boiler plate code which is not required to write every time you sort.

See the below code with lambda which reduces the code and makes it clear to focus on sorting logic.
```java
List lambdaEmpList = Arrays.asList(employees);

System.out.println("lambdaEmpList Before sorting : " + lambdaEmpList);
lambdaEmpList.sort((Employee o1, Employee o2) -> o1.getSalary().compareTo(o2.getSalary()));
System.out.println("lambdaEmpList after sorting : " + lambdaEmpList);
```
Output will be the same as the traditional approach but the coding effort is reduced.

sort() method takes two Employee parameters and compares the salary fields.

The same can be rewritten as below and works without any issues.

lambdaEmpList.sort((o1, o2) -> o1.getSalary().compareTo(o2.getSalary()));
Just removed the lambda parameters type because the compiler can infer the type from the underlying list. Here the list lambdaEmpList holds the Employee objects. So, the compiler can imply the type of Employee to o1 and o2.

## 9. Invalid Lambda Expressions
We've seen till now all valid lambda expressions. Now we'll see the invalid and what cases will get compile time errors.

Creating a interface with only one Abstract Method.

interface LambdaInt {
 public String convertIntToString(Integer value);
}
Writing the implementation for this interface using Lambda.

LambdaInt lambdaInt = (Integer value) -> return value.toString();
Here will get a compile time error.

Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
 Syntax error on token "return", delete this token
Here, this lambda is returning String. This problem can be solved in two ways.
### 9.1 return with curly braces
if we write a statement with return "some value" statement then it must be enclosing in curly braces.

LambdaInt lambdaInt =  (Integer value) -> { return value.toString();};
### 9.2 remove return keyword
If the lambda body has only one statement and that is a value then no need to use the return keyword. And also no need of curly braces. Now, We can rewrite as below.

LambdaInt lambdaInt = (Integer value) -> value.toString();
### 9.3 Another Illegal Lambda
See the below Lambda which also give a compile error.

LambdaInt lambdaInt2 = (Integer value) -> {"String Value of ";};
compile error:

Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
 Syntax error, insert "AssignmentOperator Expression" to complete Expression

First, guess the problem before seeing the solution.

This is similar to the above problem that we solved.

To fix, We should add a return statement.

LambdaInt lambdaInt2 = (Integer value) -> {return "String Value of ";};
Or remove the curly braces and semicolon.

LambdaInt lambdaInt2 = (Integer value) -> "String Value of ";
## 10. Conclusion
In this article, We've seen What is Lambda Expression and how it is added to Java 8.

As well discussed all the following areas of Lambda's.

Comparing to Older Java Versions
Lambda Syntax
Lambda Valid Examples
Lambda Rules
Where to Use Lambda
Lambda Sorting Example
Invalid Lambda Expressions


Introduction:

Java 8 is first released in 2014 and introduced lot of new features. Lambda expressions are the most significant change in java 8 version.
As of java 7, Oracle/Sun people have given importance to the object oriented programming languages but in java 8, they have introduced functional programming to compete with other programming languages such as Scala, C# etc.






What is Lambda Expression?

Any function which is having no name is called as Lambda expression. Which is also called as anonymous function.


Rules:

1) function should not have access modifier
2) Should not have any return type (even void also not allowed)
3) Should not have name for function
4) Should use arrow symbol "->"

We will see now a few examples how to convert normal java fucntions to lambda expression.


Example 1:

Before java 8:


 public void print() {
  System.out.println("Hello World");
 }
In java 8:


() -> {
  System.out.println("Hello World");
   };
  Please observe here, we have remvoed fucntion access modifier (public), return type(void) and method name (print) in the lambda expression and added -> symbol. Note: If method body has only statement then curly braces are optional. Curly braces are mandetory if multiple statements are present in the method body. we can rewrite the above lambda expression as below.
() -> System.out.println("Hello World");

Example 2:

Before java 8:

public void sum(int a, int b) {
  System.out.println("sum :" + (a + b));
 }
 
In java 8:

(int a, int b) -> System.out.println("sum :" + (a + b));
Example 3: Finding the length of string Before java 8:

public int getLength(String value) {
  return value.length();
 }
 
In java 8:

(String value) -> {
   return value.length();
  };  
Lambda Expressions Thumb Rules:
The following are the main rules in creating and using the lambda expressions.


1) Parameters are optional. It can be zero or more.

 () -> {System.out.println("Hello World");};
 (int a) -> {System.out.println("value "+a);};
 
2) If no parameters are available then need to use empty parenthesis ().
 
 () -> {System.out.println("Hello World");};
 
3) If we have multiple parameters then need to separate them with comma(,)

 (int a, int b) -> System.out.println("sum "+(a+b));
 
4) if body has only statement then curly braces are optional.

 (int a) -> System.out.println("value "+a);
 
5) if body has more than one statement then curly braces are mandatory.


 () -> {
   System.out.println("Hello World");};
   System.out.println("value "+a);
    };
  
6) parameter type(s) is optional. No need to declare manually because compile can expect based on the context. 
 
 (a) -> System.out.println("value "+a);
 (a, b) -> System.out.println("sum "+(a+b));
 
7) If only one parameter is available then parenthesis are optional.

 (int a) -> {System.out.println("value "+a);};
 The above can be rewritten as a -> {System.out.println("value "+a);};


 We'll learn about how to access variables from Lambda Expressions in Java 8.

Before that, We suggest you read the tutorial on Java 8 Lambda Expressions discussed in the previous tutorial.

If you already know about Lambda's, just ignore and continue reading this article.

Can we declare a variable inside Lambda Expression?



The answer is yes. We can declare variables as many as needed.

What do you think if lambda has a reference to another variable?

Here, We have two scenarios to know.

First, What will happen for local variables in Lambda.

Second, Non-local variables to Lambda.


Creating a Functional Interface.

@FunctionalInterface
interface BookInterface {
 int getBooksCount(String catefory);
}
Complete guide to Functional Interfaces in Java 8.

2. Local Variables To Lambda

We can declare any type of variable in a Lambda block as similar to declaring variables inside a method.

In the below example, creating a lambda expression with local variable localLamdbdaVar.

public class LambdaVariables {
 public static void main(String[] args) {

  BookInterface bookInterface = (catefory) -> {
   int localLamdbdaVar = 10; // Local Variable to Lambda and can not be accessed from outside of it.
   
   // some logic to get books count from Library for a Category.
   localLamdbdaVar++; // Incrementing value by 1.

   return localLamdbdaVar;
  };

  int count = bookInterface.getBooksCount("Technology");
  System.out.println("count " + count);
 }
}
This program compiles and runs with no errors.

Output:

count 11

If we declare the same variable outside lambda like below, it will through compile time error.

int localLamdbdaVar = 5; 
BookInterface bookInterface = (catefory) -> {
 int localLamdbdaVar = 10; // Local Variable to Lambda and can not be accessed from outside of it.
 
 // some logic to get books count from Library for a Category.
 localLamdbdaVar++; // Incrementing value by 1.

 return localLamdbdaVar;
};
Error: Lambda expression's local variable localLamdbdaVar cannot redeclare another local variable defined in an enclosing scope.

Because compiler saying error at below line inside Lambda.

int localLamdbdaVar = 10;

Already, We have outside a Lambda variable is declared with the same name. So, We can not redeclare it.

Java 8 Examples Programs Before and After Lambda & Streams
3. Non-Local To Lambda

Now, we will remove the variable localLamdbdaVar from Lambda and add it outside as below.

int localLamdbdaVar = 10; 
BookInterface bookInterface = (catefory) -> {

 // some logic to get books count from Library for a Category.
 localLamdbdaVar++; // Incrementing value by 1.

 return localLamdbdaVar;
};
Variable localLamdbdaVar is declared in enclosed scope.

At compile time it fails with reason "Local variable localLamdbdaVar defined in an enclosing scope must be final or effectively final" at localLamdbdaVar++;

Because localLamdbdaVar value is getting changed inside the lambda. It is not allowed in Lambda. Because whatever the changes are done inside Lambda is not visible to the enclosed scope.

Note: Changes are made to a variable (which is declared in enclosed scope or Outside Lambda) inside Lambda is not visible to the enclosed block. If the value is modified then enclosed block cannot find them. Because of this compile will through compile time error saying "variable must be final or effective final"

Effectively Final variable is a variable or parameter whose value isn’t changed after it is initialized.

Below is the solution using effective final variable.

int localLamdbdaVar = 10; 
BookInterface bookInterface = (catefory) -> {
 // some logic to get books count from Library for a Category.
 return localLamdbdaVar;
};

Here, Compiler considers localLamdbdaVar variable as effective final.

Note:
If we try to change the value either in the lambda itself or elsewhere in the enclosing scope, we will get an error.
No keyword is required to declare a variable as an effective final.
Enclosed variables can be used at any place in Lambda but the value can not be changed.


We'll learn how to use Method References in Java 8 and where we can use Method References in the programs. To understand this article, you should have a minimal understanding of Lambda Expressions.

Read: Introduction to Lambda Expressions in Java 8

Method References are part of the new Java 8 concept and used to refer to the functional method of Functional Interface. Syntax is ClassName::methodName. Method ref is indicated with "::" - double colon operator. This is a compact and simple form of the lambda expression. If you are using a lambda expression to refer only functional method and not any additional logic then it is best to use method references in these kinds of scenarios.

We'll learn types of method references and their example programs.





2. Types of Method References

Java 8 introduced typically with 4 types of Method References. The following are the types and will write example programs on each type.

A) Reference to a Static Method
B) Reference to instance method from instance - ClassInstance::instanceMethodName
C) Reference to instance method from class type - Class::instanceMethodName
D) Reference to constructor - Class::new

3. Reference to a Static Method

Example 1: Using Supplier Functional Interface

In the below example program, we have used Supplier FI and its functional method which does not take any value and returns a value.


package com.javaprogramto.w3schools.programs.java8.method.reference;

import java.util.function.Supplier;

/**
 * 
 * Static Method Reference Example
 * 
 * @author JavaProgramTo.com
 *
 */
public class StaticMethodReference {

    public static void main(String[] args) {

        Supplier i = StaticMethodReference::print;
        int value = (int) i.get();
        System.out.println("returned value : " + value);

    }

    public static int print() {
        System.out.println("Static method ref.");
        return 1;
    }

}

Output:


Static method ref.
returned value : 1

Example 2: Using custom Functional Interface

Created a Custom FI with process() functional method with no parameters and return type. So, we can assign the print() method to CustomFI. In the below example, assigned StaticMethodReference2::print method to the CustomFI ref. That means mapping print() method to process() method. So, When we call customFI.process() then its underlying method print() will be executed.

package com.javaprogramto.w3schools.programs.java8.method.reference;

import java.util.function.Supplier;

/**
 * 
 * Static Method Reference Example 2
 * 
 * @author JavaProgramTo.com
 *
 */
 
@FunctionalInterface 
interface CustomFI {

    void process();
}

public class StaticMethodReference2 {

    public static void main(String[] args) {

        CustomFI customFI = StaticMethodReference2::print;
        customFI.process();

    }

    public static void print() {
        System.out.println("Static method ref example 2.");
    }

}

Output:

Static method ref example 2.

Example 3: 

Static method reference to find the sum of two numbers. Here, we used BiFunction to hold the ref of the Static Method Reference. When BiFunction apply(10, 20) method is called then addition(10, 20) method will be executed and values also will be passed to the addition method from the apply method.


package com.javaprogramto.w3schools.programs.java8.method.reference;

import java.util.function.BiFunction;

/**
 * 
 * Static Method Reference Example with addition formulae
 * 
 * @author JavaProgramTo.com
 *
 */

public class StaticMethodReference2 {

    public static void main(String[] args) {

        BiFunction customFI = StaticMethodReference2::addition;
        int sum = customFI.apply(10, 20);
        System.out.println("Addition : " + sum);

    }

    public static int addition(int a, int b) {
        return a + b;
    }

}

Output:

Addition : 30

4. Reference to instance method from instance - ClassInstance::instanceMethodName

The below program demonstrates how to use a class instance with method reference. This is similar to the static method ref but here we need to create the instance first then use a double colon :: on the instance like classInstanceMethodReference::addition;.


package com.javaprogramto.w3schools.programs.java8.method.reference;

import java.util.function.BiFunction;

/**
 * 
 * Class Instance Method Reference Example with addition formulae
 * 
 * @author JavaProgramTo.com
 *
 */

public class ClassInstanceMethodReference {

    public static void main(String[] args) {

        ClassInstanceMethodReference classInstanceMethodReference = new ClassInstanceMethodReference();

        BiFunction customFI = classInstanceMethodReference::addition;
        int sum = customFI.apply(10, 20);
        System.out.println("Addition : " + sum);

    }

    public int addition(int a, int b) {
        return a + b;
    }

}

Output:


Addition : 30

5) Reference to instance method from class type - Class::instanceMethodName

This is to where ever we use the method on two Strings or two same type objects. For example, s1.compareTo(s2) can be rewritten as String::compareTo.

Example program to sort strings.

package com.javaprogramto.w3schools.programs.java8.method.reference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceFromClassInstance {

    public static void main(String[] args) {
        List strings = Arrays.asList("java", "program", "to", "com", "java-w3schools", "blog", "core java",
                "JavaProgramTo.com");

        // without method ref.
        List sorted = strings.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());

        System.out.println(sorted);

        // with method ref.
        List sortedAlt = strings.stream().sorted(String::compareTo).collect(Collectors.toList());

        System.out.println(sortedAlt);
    }

}

Output:

[JavaProgramTo.com, blog, com, core java, java, java-w3schools, program, to]
[JavaProgramTo.com, blog, com, core java, java, java-w3schools, program, to]


6) Reference to constructor - Class::new

As of now, we have seen how to access the instance and static methods using method reference. But you have a question that is it possible for constructors?
Yes, It is allowed in Java to use :: to invoke the constructor.

process(new ArrayList()) can be simplified as process(ArrayList::new);

ArrayList::new calls the constructor to create the ArrayList instance.

Creating a list of numbers from range 1 to 100 by creating ArrayList object using method ref.

List integers = IntStream
                .range(1, 100)
                .boxed()
                .collect(Collectors.toCollection( ArrayList::new ));



7. Conclusion

In this article, We've seen the following.

A) what is Method Reference?
B) why it is introduced?
C) what is the advantage? 
D) Where to use?

Example program on each type of Method Reference.

Math class has many static methods so we can use all of them with static method reference such as Math::max, Math::min, Math::pow
Where ever Reduce FI is needed there you can use the static method reference.


We'll learn about Functional Interface added to Java 8. Functional Interface is abbreviated as FI.

These Functional Interfaces are used extensively in Lambda Expressions.

Please read article on "A Complete Guide to Lambda Expressions"

If you have a basic understanding of Lambda's that will help in using Functional Interface(FI) properly. But, We will discuss in short about Lambda's.



We will cover the following concepts in this article.


Intro to Lambda
Lambda Examples
Functional Interface Definition
@FunctionalInterface annotation
Built-in FI's
Types of Functional Interfaces with examples




2. Lambda Expression and Examples

Before Lambda's introduction, We were using anonymous inner classes widely in our applications. Lambda Expression denotes a function or method without any name to it. But it takes method arguments, body, and valid return type.

We will write a program to create a Thread using Runnable interface using an anonymous inner class.

2.1 Runnable with Anonymous Inner Class

We will be demonstrating anonymous inner class usage with the Runnable interface. The runnable interface has a method called run() which should have the thread implementation.

package com.java.w3schools.blog.java8.functional;

public class ThreadCreation {

 public static void main(String[] args) {

  Thread t = new Thread(new Runnable() {
   @Override
   public void run() {
    System.out.println("Thread execution started.");
   }
  });

 }
}

t.start();
Output:

A Runnable anonymous inner class object is created and passed to Thread class. Invoking t.start() will initiate the thread and starts execution. See the below output.

Thread execution started.
2.2 Runnable with Lambda's

In the above program, using an anonymous inner class for the Runnable interface is having many lines of code. But, the same code can be reduced to a few lines using new java 8 lambda expressions syntax.

Just see the below code.

Thread lambdaThread = new Thread(() -> System.out.println("Lambda Trhead exection started."));
lambdaThread.start();
Now, the new code written in lambda is in a single line. Removed all boilerplate code and converted it to more readable as well as easy to maintain.


3. Functional Interface Definition

In simple words, If the interface has only one abstract method then it is called Function Interface(FI).
All of FI's implementations can be used with Lambda.

You already know many Function Interface's that are available before Java 8 also. They are Comparable, Runnable, Callable, etc. But these are not declared as FunctionalInterface.
3.1 @FunctionalInterface Annotation

We can define any interface @FunctionalInterface annotation but it shows compile error if not having exactly one abstract method.

This annotation is very helpful to avoid accidentally adding additional abstract methods or removing the existing ones. Hence, stops breaking other code.

Note: This annotation is not mandatory and it is optional.

@FunctionalInterface
interface RunParellel {
boolean run();
}
We can explicitly identify a functional interface using the @FunctionalInterface annotation as above.

Compiler error : "The target type of this expression must be a functional interface"
Note: To create a custom Functional Interface, We must annotate the interface with @FunctionalInterface. That's all, From now this can be used with Lambda.

4. Built-in Functional Interfaces

Java 8 introduced a lot of Functional Interfaces as part of JDK 8. All are bundled into package java.util.function and total 43 functional interfaces.

All these are divided into 4 categories.

A) Suppliers
B) Consumers
C) Predicates
D) Functions

All these functional interfaces are having exactly only one abstract method (these may have static or default and private methods)

Private methods in interfaces are introduced in Java 9.

Note: The abstract method inside a Functional Interface is called as Functional Method.

We'll be using this "Functional Method" terminology in this tutorial from now onwards.

Built-in all FI's in java.util.function package

4.1 Suppliers

Suppliers always return some value and never takes an argument.

Supplier is a Functional Interface which has get() functional method. This is present in java.util.function package.

T get()
Example:

package com.java.w3schools.blog.java8.functional;

import java.util.function.Supplier;

/**
 * Supplier Interface in Java with Examples
 * 
 * @author Venkatesh
 *
 */
public class SupplierExample {

 public static void main(String[] args) {

// This Supper always return a random value
  Supplier randomValue = () -> Math.random();
  System.out.println(randomValue.get());
 }
}

Output:

0.8141135990476829
4.2 Consumers

Consumers consume values. java.util.function.Consumer’s has a functional method accept(). This FI always takes an argument and never returns anything.

This is just consuming the value or object passing to accept() functional method.

Consumer has two methods. One abstract method and one defalut method.

Functional Method: void accept(T t)
Default Method: default Consumer andThen(Consumer after)

Example:

package com.java.w3schools.blog.java8.functional;

import java.util.function.Consumer;

/**
 * Consumer Interface in Java with Examples
 * 
 * @author venkatesh
 *
 */
public class ConsumerExample {
 public static void main(String[] args) {
  Consumer consumer = (String value) -> {
   System.out.println(value.toUpperCase());
  };
  consumer.accept("Welcome to Java W3schools blog");
 }
}

Output:

WELCOME TO JAVA W3SCHOOLS BLOG
4.3 Predicates

Predicates test things and this is used to perform logical operations.

java.util.function.Predicate’s have a functional method test().

This FI has total of 5 methods.

1 Functional Method:

boolean test(T t)
3 default methods:

default Predicate and(Predicate other)
default Predicate negate()
default Predicate or(Predicate other)

1 static method:

static  Predicate isEqual(Object targetRef)

These 4 default methods are very helpfull to perform logical operations such as and, or, negate or equal operations.

Note: Predicate always take an input argument and returns a boolean value. Inside this method, We can perform the requried operations. Finally, It returns true or false.

Example:

package com.java.w3schools.blog.java8.functional;

import java.util.function.Predicate;

/**
 * Predicate Interface in Java with Examples
 * 
 * @author Venkatesh
 *
 */

public class PredicateExample {
 public static void main(String[] args) {

  Predicate predicate = (String str) -> str.contains("Java");

  boolean isJavaDeveloper = predicate.test("Jhon is a Java Developer");

  if (isJavaDeveloper) {
   System.out.println("Yes, Jhon is a Java Developer. He can develop Java based web applications");
  } else {
   System.out.println("Jhob is not a Java developer.");
  }
 }
}

Output:

Yes, Jhon is a Java Developer. He can develop Java based web applications
Here, test() method takes String as argument and checks that string has a word "Java". If the string has Java then it returns true. Otherwise returns false.
In our example, the input string has a Java word. This predicate returns true.

4.4 Functions

Represents a function that accepts one argument and produces a result.

You can think of functions as the most generic of the functional interfaces. java.util.function.Function’s functional method, apply().

Interface Function

Type Parameters:

T - the type of the input to the function
R - the type of the result of the function 
This has 1 functional method, 2 default methods and 1 static method.

R apply(T t)

2 default methods:

default  Function compose(Function before)
default  Function andThen(Function after)

1 static method:

static  Function identity()

Example:

package com.java.w3schools.blog.java8.functional;

import java.util.function.Function;

/**
 * Function Interface in Java with Examples
 * 
 * @author Venkatesh
 *
 */
class FunctionExample {
 public static void main(String[] args) {
  Function function = (String input) -> input.substring(5);
  String output = function.apply("This is a test Function interface in java 8");
  System.out.println(output);
 }
}

Output:

is a test Function interface in java 8
In this example, It taken input type and Output type as String. In other words, apply() method takes String as input and returns String value.

5. Conclusion

In this tutorial, We've seen What is Function Interface(FI) and how FI's are used with Lambda Expression.

How to define a custom functional interface.

What are the Built-in FI's are in Java 8? Discussed 4 types of FI's such as Supplier, Consumer, Predicate, and Function.


what is the Default Method in Java 8 and why it is introduced in java 8 changes.

Java 8 introduces a new concept of default method implementation in interfaces. This capability is added for backward compatibility so that old interfaces can be used to leverage the lambda expression capability of Java 8. For example, the List interface is not having the forEach() method. If they add this method as an abstract method then all List implementation classes must have to provide the implementation since it is common functionality to iterate the list. So they had to introduce this concept to enhance features and support for the backward classes.





2. Java 8 Default Method Syntax

Just need to declare a method keyword default.

Interface InterfaceName {
 
    default void doSomeThing(){
        // some logic here to process
    }
}

3. Java 8 Default Method Example Program

interface TwoWheeler {

    default String print() {

        return "TwoWheeler";
    }
}

class HondaActiva implements TwoWheeler {

    public void printName() {
        System.out.println("This is Honda Activa 7G and it is a " + print() + " Vehicle");
    }

}


Main method:

package com.javaprogramto.w3schools.programs.java8;

/**
 * 
 * Default Methods examples.
 * 
 * @author JavaProgramTo.com
 *
 */
public class DefaultMethods {

    public static void main(String[] args) {

        HondaActiva activa = new HondaActiva();
        activa.printName();

    }

}

Output:

This is Honda Activa 7G and it is a TwoWheeler Vehicle

Note: The default method can not be called with the Interface name. It must be accessed in its implementation classes.

4. Java 8 Multiple default methods

Multiple default methods are allowed in a single interface. Defined two interfaces with the same default method. Refer to the below code.

interface TwoWheeler {

    default String printWheelsType() {

        return "TwoWheeler";
    }
}

interface FourWheller {
    default String printWheelsType() {

        return "FourWheeler";
    }

}

Now, these two interfaces are implemented by a class as below and it throws a compile-time error saying "Duplicate default methods named printWheelsType with the parameters () and () are inherited from the types FourWheller and TwoWheeler".

This error can be cleared with two solutions.

Solution 1: 

Override printWheelsType() method in this class and provide its own logic.

class WheelsUtility implements TwoWheeler, FourWheller {

    @Override
    public String printWheelsType() {
        return "Utility for Wheels";
    }

}

Solution 2:

Override and call a specific to your implementation.


class WheelsUtility implements TwoWheeler, FourWheller {

    @Override
    public String printWheelsType() {
        // TODO Auto-generated method stub
        return FourWheller.super.printWheelsType();
    }

}

The above code used the super keyword to call the default method from FourWheeler interface.

5. Java 8 Static Default Method

Shall use the static keyword on the default method?

yes. It is allowed to use if you have any utility methods that can be called directly with the interface name.


interface DateInterface {

    default void getLocale() {

    }

    static Date getTodayDate() {

        return new Date(Calendar.getInstance().getTimeInMillis());

    }

}

Static default method invocation:

Date date = DateInterface.getTodayDate();

6. Conclusion

In this quick article, we have seen the new concept of Java 8 Default Methods. And also how to solve if the implemented two interfaces have the same default methods.


You will learn in-depth about Java 8 Optional Class methods and its usages.

Optional class is added to the java.util package. The intention of introducing this class in java 8 is mainly to check whether the value is present in the object or it is absent.

The object is to hold the set of values that means it contains the real values. So, such kind of object is called a Container.

The container object may contain a null or non-null value in it.



2. Optional Advantages
Before using Optional class methods you should know what are the benefits that you are going to get from it.

2.1 Completely you can avoid the null checks in the application and no need to write the utility methods

2.2 Zero NullPointerExceptions at runtime.

2.3 Code becomes cleaner and more readable

2.4 Say goodbye to boilerplate coding

2.5 Avoid third party api's such as Apache Commons API ObjectsUtils

3. Optional Main Methods
The Optional class has many methods but only two methods are most used in the coding. Those two are isPresent() and get() methods.

isPresent() returns true if the optional has non-null values,  otherwise false.

get() returns the actual value from Optional object. If optional has null value means it is empty. In such a case, NoSuchElementException is thrown.

Sample Example:

package com.javaprogramto.java8.base64;
package com.javaprogramto.java8.optional;

import java.util.Optional;

public class OptionalGetExample {

    public static void main(String[] args) {

        // Creating non null optional object.
        Optional<String> optional= Optional.of("hello");

        // checking value present in the optional or not.
        if(optional.isPresent()){
            String value = optional.get();
            System.out.println("Optional value : "+value);
        } else {
            // if optional has no value
            System.out.println("Optional has no value");
        }
    }
}
Output:

package com.javaprogramto.java8.base64;
Optional value : hello
4.Optional Constructors and Creating Optional Objects
Optional is a final class and it has two private constructors as below. These two constructors can not be accessed because these are declared as private. 

    private Optional() {
        this.value = null;
    }
	
 private Optional(T value) {
        this.value = Objects.requireNonNull(value);
    }
So, now the question is how to create the Optional object with a non-null value and null value?

Answer: Optional class is added with static methods that help in creating Optional Objects for the given values.  Optional object creation static methods are below with syntax.

static <T> Optional<T> empty(): Returns an empty Optional instance.
static <T> Optional<T> of(T value): Returns an Optional with the specified present non-null value.
the empty() method creates an empty stream with null value whereas. of() method creates Optional object with non-null value.

Example to create Optional objects:

import java.util.Optional;

public class OptionalObjectCreationExample {
	public static void main(String[] args) {

		// creating an empty optional object
		Optional<Void> emptyOptional = Optional.empty();

		// checking if the optional is empty or not
		System.out.println(" Is optional is empty : " + emptyOptional.isEmpty());

		// Creating String type Optional
		Optional<String> stringOptional = Optional.of("Hello");

		if (stringOptional.isPresent()) {
			System.out.println("Getting value from stringOptional : " + stringOptional.get());
		}

		// Integer type optional
		Optional<Integer> intOptionbal = Optional.of(1244);
		System.out.println("Integer Optional: " + intOptionbal.get());
		
		// Passing null to  of() method.
		Optional.of(null);

	}
}
Output:

 Is optional is empty : true
Getting value from stringOptional : Hello
Integer Optional: 1244
Exception in thread "main" java.lang.NullPointerException
	at java.base/java.util.Objects.requireNonNull(Objects.java:221)
	at java.base/java.util.Optional.<init>(Optional.java:107)
	at java.base/java.util.Optional.of(Optional.java:120)
	at com.javaprogramto.java8.optional.OptionalObjectCreationExample.main(OptionalObjectCreationExample.java:26)

Optional of() and empty() methods are to create non-null and empty Optional objects using its static methods.

Non null value must be passed to of() method otherwise it will throw NullPointerException.

5. Optional ofNullable() 
If you are expecting some null values then use the ofNullable() method.

By using this method, if we pass in a null reference, it doesn't throw an exception but rather returns an empty Optional object.

import java.util.Optional;

public class OfNullableExample {
	public static void main(String[] args) {

		// Creating optional
		Optional<String> ofNullable = Optional.ofNullable("Non null value");

		String content = ofNullable.get();
		System.out.println("Ofnullable value :" + content);

		// passing null value
		Optional nullOptional = Optional.ofNullable(null);
		nullOptional.get();
	}
}
Output:

Ofnullable value :Non null value
It is suggested to use the ofNullable() method rather than using of() and empty() method separately.  Because it does uses internally both of() for nonnull value and empty() for a null value.

6. Checking Value Presence
If a method is returning an Optional object then you need to check that whether the Optional is having a value or not.

To check this, the Optional class has an isPresent() method which returns true if it has non-null value or false if it empty or null value.

import java.util.Optional;

public class OfNullableExample {
	public static void main(String[] args) {

		// Creating optional
		Optional<String> optional = Optional.ofNullable("javaprogramto.com");

		System.out.println("Chceking if optional has value with isPresent() method");
		System.out.println("isPresent value : "+optional.isPresent());
		
		// empty optional
		Optional<String> emptyOptional = Optional.ofNullable(null);
		System.out.println("isPresent value for empty optional : "+emptyOptional.isPresent());
		
	}
}
Output:

Chceking if optional has value with isPresent() method
isPresent value : true
isPresent value for empty optional : false
Java 11 api is added with a new method to check if optional isempty or not using isEmpty() method.

public class OptionalIsEmpty {
	public static void main(String[] args) {

		// Creating optional
		Optional<String> optional = Optional.ofNullable("javaprogramto.com");

		System.out.println("Checking if optional has value with isEmpty() method");
		System.out.println("isEmpty value : " + optional.isEmpty());

		// empty optional
		Optional<String> emptyOptional = Optional.ofNullable(null);
		System.out.println("isPreisEmptysent value for empty optional : " + emptyOptional.isEmpty());

	}
}
Output:

Checking if optional has value with isEmpty() method
isEmpty value : false
isPreisEmptysent value for empty optional : true
7. Optional ifPresent()
You can do the if and if-else conditions on Optional object using the ifPresent() method.

public void ifPresent(Consumer<? super T> consumer)
This method takes Consumer as a functional argument and its logic is only be executed if it has not null value.

ifPresent() is introduced mainly to avoid null pointer exception.

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalIfPresent {
	public static void main(String[] args) {

		System.out.println("Example 1 : ------ Optional string ------ ");
		// Creating optional
		Optional<String> optional = Optional.ofNullable("javaprogramto.com");

		// ifpresent syntax
		optional.ifPresent(value -> System.out.println(value));

		System.out.println("Example 2 : ------  Optional List of integers ------ ");

		// Creating list of numbers
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		// Passing lsit to optional
		Optional<List<Integer>> numbersOfListOptional = Optional.ofNullable(list);

		// cheeking with ifpresent
		numbersOfListOptional.ifPresent(optionalList -> optionalList.forEach(v -> System.out.println(v)));

		Optional empty = Optional.empty();
		empty.ifPresent(valeu -> System.out.println("no value"));

	}
}
Output:

Example 1 : ------ Optional string ------ 
javaprogramto.com
Example 2 : ------  Optional List of integers ------ 
1
2
3
4
5
8. Optional Default Values - orElse()
If the Optional is created with empty() or ofNullable(null) then you will get empty optional. 

If the optional is empty then you can still get the default value using orElse() method.

orElse() method takes the value as a type of original Optional caller.

public T orElse(T other)
orElse() Example:

public class OptionalOrElse {
	public static void main(String[] args) {

		Optional<String> o1 = Optional.ofNullable(null);
		
		String value = o1.orElse("Default One");
		
		System.out.println("Fetching the value from orElse() : "+value);
		
		Optional<Integer> intOptional = Optional.empty();
		
		int defaultValue = intOptional.orElse(15);
		
		System.out.println("Int  default value :"+defaultValue);

	}
}
Output:

Fetching the value from orElse() : Default One
Int  default value :15
9. Optional Default Values - orElseGet()
orElseGet() method is to get the alternate value if the Optional is empty or has a null value. This method takes the Supplier as an argument.

public T orElseGet(Supplier<? extends T> other)
orElseGet() Example:

public class OptionalOrElseGet {
	public static void main(String[] args) {

		Optional<String> o1 = Optional.ofNullable(null);

		String value = o1.orElseGet(() -> "Default One  from  supplier");

		System.out.println("Fetching the value from orElseGet() : " + value);

		Optional<Integer> intOptional = Optional.of(134);

		int defaultValue = intOptional.orElseGet(() -> 15);

		System.out.println("orElseGet Int  default value :" + defaultValue);

	}
}
Output:

Fetching the value from orElseGet() : Default One  from  supplier
orElseGet Int  default value :134
10. Differences Between orElse() and orElseGet() Methods
orElseGet() method looks similar to the orElse() method as seen in the above section but there is a little different and that is the most important in the large scale applications.

The main difference is orElse() method will be executed always whether source Optional has value or not whereas orElseGet() will be invoked if and only if source optiona is an empty or null value.

Look at the example below to understand clearly.

Creating a method to get the string as a return. This method will be called by both of these methods.

In the below example, taking the Optional with null value by both methods.

public class OptionalDiffOrElseGetVsorElse {
	public static void main(String[] args) {

		// Optional with null value
		Optional<String> opt1 = Optional.ofNullable(null);
		String orElseValue1 = opt1.orElse(getDefaultValue());
		System.out.println("orElse() value : " + orElseValue1);

		// Optional with null value
		Optional<String> opt2 = Optional.ofNullable(null);
		String orElseValue2 = opt2.orElseGet(() -> getDefaultValue());
		System.out.println("orElseGet() value : " + orElseValue2);

	}

	public static String getDefaultValue() {
		System.out.println("executing to get the default value");
		return "I am  here to get the default value";
	}
}
Output:

executing to get the default value
orElse() value : I am  here to get the default value
executing to get the default value
orElseGet() value : I am  here to get the default value
Here, the source optional has null value so it called the default logic getDefaultValue() in both cases.

Letus see now Optional with values.

public class OptionalDiffOrElseGetVsorElse {
	public static void main(String[] args) {

		// Optional with null value
		Optional<String> opt13 = Optional.ofNullable("123");
		String orElseValue3 = opt13.orElse(getDefaultValue());
		System.out.println("orElse() value : " + orElseValue3);

		// Optional with null value
		Optional<String> opt4 = Optional.ofNullable("789");
		String orElseValue4 = opt4.orElseGet(() -> getDefaultValue());
		System.out.println("orElseGet() value : " + orElseValue4);

	}

	public static String getDefaultValue() {

		System.out.println("executing to get the default value");
		return "I am  here to get the default value";
	}
}
Output:

executing to get the default value
orElse() value : 123
orElseGet() value : 789
In this case,  Both sources optional objects are created with the values which are not null. So, getDefaultValue() method should not be called as we expected but in the output, it printed the content from getDefaultValue() method from orElse() method.

11. Optional filter()
filter() method is used to filter the optional values based on the predicate condition.

public Optional<T> filter(Predicate<? super T> predicate)
Example:

An example to check the given number is even or odd. If the number is even then Optional will have an even number.

public class OptionalFilterExample {
	public static void main(String[] args) {

		// Creating optional
		Optional<Integer> op = Optional.ofNullable(1234);

		Optional<Integer> evenOrNot = op.filter(number -> number % 2 == 0);

		if (evenOrNot.isEmpty()) {
			System.out.println("Odd number");
		} else {
			System.out.println("Even number");
		}

	}
}
Output:

Even number
12. Optional.map() -Value Transformations
Optional map() isused to transform the optional into another form.

public class OptionalMapExample {
	public static void main(String[] args) {

		// Creating optional
		Optional<String> op = Optional.ofNullable("Welcome reader");

		Optional<String> mapOptional = op.map(value -> {
			if (value.contains("Welcome")) {
				return "Articles are good";
			} else {
				return "Welcome to javaprogramto.com";
			}

		});

		mapOptional.ifPresent(action -> System.out.println(action));

	}
}
Output:

Articles are good
13. Optional.ifPresent() 
Run the another logic if the optional value is present.

If a value is present, invoke the specified consumer with the value, otherwise do nothing.

public void ifPresent(Consumer<? super T> consumer)
Example to convert String to Integer using map() and ifPresent()

public class OptionalIfPresentExample {
	public static void main(String[] args) {

		// String value optional
		Optional<String> string = Optional.ofNullable("12345");

		// converting string to number
		Optional<Integer> numberOptional = string.map(value -> Integer.parseInt(value));

		// printing the number using ifPresent()
		numberOptional.ifPresent(newValue -> System.out.println(newValue));

	}
}
Output:

12345
14. Optional.flatMap()
flatMap(): If a value is present, apply the provided Optional-bearing mapping function to it, return that result, otherwise return an empty Optional.

It removes all nested Optional objects and just gets the value from it.

public class OptionalflatmapExample {
	public static void main(String[] args) {

		Optional<String> optional1 = Optional.of("Hello Java 8 Optional");
		Optional<Optional<String>> optional2 = Optional.of(optional1);

		System.out.println("Optional2 value : " + optional2);

		Optional<String> output = optional2.flatMap(value -> value.map(String::toLowerCase));

		System.out.println("output value : " + output);

	}
}
Output:

Optional2 value : Optional[Optional[Hello Java 8]]
output value : Optional[hello java 8]
15. Optional orElseThrow()
Optional API added a new way to throw the exception if the value not present in the optional object.

orElseThrow() looks as similar to the orElse() and orElseGet() pattern.

orElseThrow() returns a value from the optional else throws the. exception saying "java.util.NoSuchElementException: No value present".

Syntax:

public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier)
                                    throws X extends Throwable 
orElseThrow() Example:

public class OptionalOrElseThrowExample {
	public static void main(String[] args) {

		// orElseThrow() example
		String blank = Optional.ofNullable("").orElseThrow();
		System.out.println(blank);

		String value = null;
		String blank2 = Optional.ofNullable(value).orElseThrow();
		System.out.println(blank2);

	}
}
Output:

Exception in thread "main" java.util.NoSuchElementException: No value present
	at java.base/java.util.Optional.orElseThrow(Optional.java:382)
	at com.javaprogramto.java8.optional.OptionalOrElseThrowExample.main(OptionalOrElseThrowExample.java:13)
orElseThrow() Custom Exception Example:

public class OptionalOrElseThrowCustomExExample {
	public static void main(String[] args) throws CustomException {

		// orElseThrow() runtime IllegalArgumentException example
		String nullValue = null;
		String blank = Optional.ofNullable(nullValue).orElseThrow(IllegalArgumentException::new);
		System.out.println(blank);

		// throwing checked exception
		String value = null;
		String blank2 = Optional.ofNullable(value).orElseThrow(CustomException::new);
		System.out.println(blank2);

	}
}

class CustomException extends Exception {

	public CustomException() {

	}
}
This will produce the runtime exception and here used the method reference concept added in java 8.

16. Optional New Methods in Newer JDK's
Optional api is added with new api methods in java 9, java 10, and java 11 versions as below.

Java 9:
public void ifPresentOrElse​(Consumer<? super T> action, Runnable emptyAction): If a value is present, performs the given action with the value, otherwise performs the given empty-based action.

public Optional<T> or​(Supplier<? extends Optional<? extends T>> supplier): If a value is present, returns an Optional describing the value, otherwise returns an Optional produced by the supplying function.

public Stream<T> stream(): If a value is present, returns a sequential Stream containing only that value, otherwise returns an empty Stream.

Java 10:
public T orElseThrow(): If a value is present, returns the value, otherwise throws NoSuchElementException.

Java 11:
public boolean isEmpty(): If a value is not present, returns true, otherwise false.

17. Conclusion

In this article, you've seen all the methods of Optiona class in Java 8 with example programs,

How to work with the null pointer exception in java 8 to avoid manual errors.

Finally, shown what are the new methods added after JDK 8.


https://www.javaprogramto.com/2020/05/spring-boot-data-mongodb-projections-aggregations.html
https://www.javaprogramto.com/2020/05/spring-boot-mongodb-crud.html
https://www.javaprogramto.com/2019/05/spring-boot-mongodb-auto-generated-field.html

https://www.javaprogramto.com/2020/04/spring-boot-properties-file-outside-jar.html

https://www.javaprogramto.com/2020/05/spring-boot-activemq-standalone-example.html
https://www.javaprogramto.com/2020/04/spring-boot-activemq-in-memory-example.html
