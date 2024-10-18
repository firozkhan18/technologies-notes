# Java Stream API Tutorial

## Table of Contents

1. [Java Stream API Overview](#java-stream-api-overview)
2. [Java Stream Definition](#java-stream-definition)
3. [Stream Processing](#stream-processing)
4. [Obtain a Stream](#obtain-a-stream)
5. [Terminal and Non-Terminal Operations](#terminal-and-non-terminal-operations)
   - 5.1 [Non-Terminal Operations](#non-terminal-operations)
     - 5.1.1 [filter()](#filter)
     - 5.1.2 [map()](#map)
     - 5.1.3 [flatMap()](#flatmap)
     - 5.1.4 [distinct()](#distinct)
     - 5.1.5 [limit()](#limit)
     - 5.1.6 [peek()](#peek)
   - 5.2 [Terminal Operations](#terminal-operations)
     - 5.2.1 [anyMatch()](#anymatch)
     - 5.2.2 [allMatch()](#allmatch)
     - 5.2.3 [noneMatch()](#nonematch)
     - 5.2.4 [collect()](#collect)
     - 5.2.5 [count()](#count)
     - 5.2.6 [findAny()](#findany)
     - 5.2.7 [findFirst()](#findfirst)
     - 5.2.8 [forEach()](#foreach)
     - 5.2.9 [min()](#min)
     - 5.2.10 [max()](#max)
     - 5.2.11 [reduce()](#reduce)
     - 5.2.12 [toArray()](#toarray)
6. [Concatenate Streams](#concatenate-streams)
7. [Create Stream From Array](#create-stream-from-array)
8. [Java Stream API Critique](#java-stream-api-critique)
   - 8.1 [Batch, Not Streaming](#batch-not-streaming)
   - 8.2 [Chain, Not Graph](#chain-not-graph)
   - 8.3 [Internal, Not External Iteration](#internal-not-external-iteration)

---

## Java Stream API Overview

The Java Stream API, introduced in Java 8, is a powerful feature that allows developers to process sequences of elements (like collections) in a functional style. It facilitates operations such as filtering, mapping, and reducing data in a more readable and concise manner.

The Java Stream API provides a functional approach to processing collections of objects. The Java Stream API was added in Java 8 along with several other functional programming features. This Java Stream tutorial will explain how these functional streams work, and how you use them.

The Java Stream API is not related to the Java InputStream and Java OutputStream of Java IO. The InputStream and OutputStream are related to streams of bytes. The Java Stream API is for processing streams of objects - not bytes.

## Java Stream Definition

A stream in Java is a sequence of elements that can be processed in parallel or sequentially. It is not a data structure but rather a view of the data source, allowing operations to be performed on the data without modifying the underlying source.

A Java Stream is a component that is capable of internal iteration of its elements, meaning it can iterate its elements itself. In contrast, when you are using the Java Collections iteration features (e.g a Java Iterator or the Java for-each loop used with a Java Iterable) you have to implement the iteration of the elements yourself.

## Stream Processing

Stream processing allows you to work with data in a declarative manner, focusing on what to do with the data rather than how to do it. This leads to clearer and more maintainable code.

You can attach listeners to a Stream. These listeners are called when the Stream iterates the elements internally. The listeners are called once for each element in the stream. That way each listener gets to process each element in the stream. This is referred to as stream processing.

The listeners of a stream form a chain. The first listener in the chain can process the element in the stream, and then return a new element for the next listener in the chain to process. A listener can either return the same element or a new, depending on what the purpose of that listener (processor) is.

## Obtain a Stream

Streams can be obtained from various data sources, including collections, arrays, or I/O channels. The most common way is through the `stream()` method available on collections.

There are many ways to obtain a Java Stream. One of the most common ways to obtain a Stream is from a Java Collection. Here is an example of obtaining a Stream from a Java List:

```java
List<String> items = new ArrayList<String>();

items.add("one");
items.add("two");
items.add("three");

Stream<String> stream = items.stream();
```  
This example first creates a Java List, then adds three Java Strings to it. Finally, the example calls the stream() method to obtain a Stream instance.

## Terminal and Non-Terminal Operations

The Stream interface has a selection of terminal and non-terminal operations. A non-terminal stream operation is an operation that adds a listener to the stream without doing anything else. A terminal stream operation is an operation that starts the internal iteration of the elements, calls all the listeners, and returns a result.

Here is a Java Stream example which contains both a non-terminal and a terminal operation:

```java
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
```
The call to the map() method of the Stream interface is a non-terminal operation. It merely sets a lambda expression on the stream which converts each element to lowercase. The map() method will be covered in more detail later on.

The call to the count() method is a terminal operation. This call starts the iteration internally, which will result in each element being converted to lowercase and then counted.

The conversion of the elements to lowercase does not actually affect the count of elements. The conversion part is just there as an example of a non-terminal operation.

### Non-Terminal Operations

Non-terminal operations return a new stream and are lazy, meaning they are not executed until a terminal operation is called.

The non-terminal stream operations of the Java Stream API are operations that transform or filter the elements in the stream. When you add a non-terminal operation to a stream, you get a new stream back as result. The new stream represents the stream of elements resulting from the original stream with the non-terminal operation applied. Here is an example of a non-terminal operation added to a stream - which results in a new stream:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("ONE");
stringList.add("TWO");
stringList.add("THREE");
    
Stream<String> stream = stringList.stream();
    
Stream<String> stringStream =
    stream.map((value) -> { return value.toLowerCase(); });
```
Notice the call to stream map() . This call actually returns a new Stream instance representing the original stream of strings with the map operation applied.

You can only add a single operation to a given Stream instance. If you need to chain multiple operations after each other, you will need to apply the second operation to the Stream operation resulting from the first operation. Here is how that looks:
```java
Stream<String> stringStream1 =
        stream.map((value) -> { return value.toLowerCase(); });

Stream<½String> stringStream2 =
        stringStream1.map((value) -> { return value.toUpperCase(); });
```
Notice how the second call to Stream map() is called on the Stream returned by the first map() call.

It is quite common to chain the calls to non-terminal operations on a Java Stream. Here is an example of chaining the non-terminal operation calls on Java streams:
```java
Stream<String> stream1 = stream
  .map((value) -> { return value.toLowerCase(); })
  .map((value) -> { return value.toUpperCase(); })
  .map((value) -> { return value.substring(0,3); });
```
Many non-terminal Stream operations can take a Java Lambda Expression as parameter. This lambda expression implements a Java functional interface that fits the given non-terminal operation. For instance, the Function or Predicate interface. The parameter of the non-terminal operation method parameter is typically a functional interface - which is why it can also be implemented by a Java lambda expression.

#### filter()

The `filter()` method is used to select elements from a stream that match a given predicate.

The Java Stream filter() can be used to filter out elements from a Java Stream. The filter method takes a Predicate which is called for each element in the stream. If the element is to be included in the resulting Stream, the Predicate should return true. If the element should not be included, the Predicate should return false.

Here is an example of calling the Java Stream filter() method:
```java
Stream<String> longStringsStream = stream.filter((value) -> {
    return value.length() >= 3;
});
```
#### map()

The `map()` method transforms each element of the stream into another form.

The Java Stream map() method converts (maps) an element to another object. For instance, if you had a list of strings it could convert each string to lowercase, uppercase, or to a substring of the original string, or something completely else. Here is a Java Stream map() example:
```java
List<String> list = new ArrayList<String>();
Stream<String> stream = list.stream();

Stream<String> streamMapped = stream.map((value) -> value.toUpperCase());
```
#### flatMap()

The `flatMap()` method is similar to `map()`, but it flattens nested streams into a single stream.

The Java Stream flatMap() methods maps a single element into multiple elements. The idea is that you "flatten" each element from a complex structure consisting of multiple internal elements, to a "flat" stream consisting only of these internal elements.

For instance, imagine you have an object with nested objects (child objects). Then you can map that object into a "flat" stream consisting of itself plus its nested objects - or only the nested objects. You could also map a stream of Lists of elements to the elements themselves. Or map a stream of strings to a stream of words in these strings - or to the individual Character instances in these strings.

Here is an example that flatmaps a List of strings to the words in each string. This example should give you an idea about how flatMap() can be used to map a single element into multiple elements.
```java
List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

stream.flatMap((value) -> {
    String[] split = value.split(" ");
    return (Stream<String>) Arrays.asList(split).stream();
})
.forEach((value) -> System.out.println(value));
```
This Java Stream flatMap() example first creates a List with 3 strings containing book titles. Then a Stream for the List is obtained, and flatMap() called.

The flatMap() operation called on the Stream has to return another Stream representing the flat mapped elements. In the example above, each original string is split into words, turned into a List, and the stream obtained and returned from that List.

Note that this example finishes with a call to forEach() which is a terminal operation. This call is only there to trigger the internal iteration, and thus flat map operation. If no terminal operation was called on the Stream chain, nothing would have happened. No flat mapping would actually have taken place.

#### distinct()

The `distinct()` method removes duplicate elements from the stream.

The Java Stream distinct() method is a non-terminal operation that returns a new Stream which will only contain the distinct elements from the original stream. Any duplicates will be eliminated. Here is an example of the Java Stream distinct() method:
```java
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
```
In this example the element one appears 2 times in the original stream. Only the first occurrence of this element will be included in the Stream returned by distinct(). Thus, the resulting List (from calling collect()) will only contain one, two and three. The output printed from this example will be:
```
[one, two, three]
```
#### limit()

The `limit()` method is used to truncate the stream to a specified size.

The Java Stream limit() method can limit the number of elements in a stream to a number given to the limit() method as parameter. The limit() method returns a new Stream which will at most contain the given number of elements. Here is a Java Stream limit() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("one");
stringList.add("two");
stringList.add("three");
stringList.add("one");

Stream<String> stream = stringList.stream();
stream
    .limit(2)
    .forEach( element -> { System.out.println(element); });   
```
This example first creates a Stream, then calls limit() on it, and then calls forEach() with a lambda that prints out the elements in the stream. Only the two first elements will be printed because of the limit(2) call.

#### peek()

The `peek()` method is used for debugging, allowing you to see elements as they are processed.

The Java Stream peek() method is a non-terminal operation that takes a Consumer (java.util.function.Consumer) as parameter. The Consumer will get called for each element in the stream. The peek() method returns a new Stream which contains all the elements in the original stream.

The purpose of the peek() method is, as the method says, to peek at the elements in the stream, not to transform them. Keep in mind that the peek method does not start the internal iteration of the elements in the stream. You need to call a terminal operation for that. Here is a Java Stream peek() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("abc");
stringList.add("def");

Stream<String> stream = stringList.stream();

Stream<String> streamPeeked = stream.peek((value) -> {
    System.out.println("value");
});
```
### Terminal Operations

Terminal operations produce a non-stream result, such as a primitive value, a collection, or no value at all.

The terminal operations of the Java Stream interface typicall return a single value. Once the terminal operation is invoked on a Stream, the iteration of the Stream and any of the chained streams will get started. Once the iteration is done, the result of the terminal operation is returned.

A terminal operation typically does not return a new Stream instance. Thus, once you call a terminal operation on a stream, the chaining of Stream instances from non-terminal operation ends. Here is an example of calling a terminal operation on a Java Stream:
```java
long count = stream
  .map((value) -> { return value.toLowerCase(); })
  .map((value) -> { return value.toUpperCase(); })
  .map((value) -> { return value.substring(0,3); })
  .count();
```
It is the call to count() at the end of the example that is the terminal operation. Since count() returns a long, the Stream chain of non-terminal operations (the map() calls) is ended.

#### anyMatch()

The `anyMatch()` method checks if any elements in the stream match a given predicate.

The Java Stream anyMatch() method is a terminal operation that takes a single Predicate as parameter, starts the internal iteration of the Stream, and applies the Predicate parameter to each element. If the Predicate returns true for any of the elements, the anyMatch() method returns true. If no elements match the Predicate, anyMatch() will return false. Here is a Java Stream anyMatch() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

boolean anyMatch = stream.anyMatch((value) -> { return value.startsWith("One"); });
System.out.println(anyMatch);
```
In the example above, the anyMatch() method call will return true, because the first string element in the stream starts with "One".

#### allMatch()

The `allMatch()` method checks if all elements in the stream match a given predicate.

The Java Stream allMatch() method is a terminal operation that takes a single Predicate as parameter, starts the internal iteration of elements in the Stream, and applies the Predicate parameter to each element. If the Predicate returns true for all elements in the Stream, the allMatch() will return true. If not all elements match the Predicate, the allMatch() method returns false. Here is a Java Stream allMatch() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

boolean allMatch = stream.allMatch((value) -> { return value.startsWith("One"); });
System.out.println(allMatch);
```
In the example above, the allMatch() method will return false, because only one of the strings in the Stream starts with "One".

#### noneMatch()

The `noneMatch()` method checks if no elements in the stream match a given predicate.

The Java Stream noneMatch() method is a terminal operation that will iterate the elements in the stream and return true or false, depending on whether no elements in the stream matches the Predicate passed to noneMatch() as parameter. The noneMatch() method will return true if no elements are matched by the Predicate, and false if one or more elements are matched. Here is a Java Stream noneMatch() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("abc");
stringList.add("def");

Stream<String> stream = stringList.stream();

boolean noneMatch = stream.noneMatch((element) -> {
    return "xyz".equals(element);
});

System.out.println("noneMatch = " + noneMatch);
```
#### collect()

The `collect()` method is used to accumulate the elements of the stream into a collection.

The Java Stream collect() method is a terminal operation that starts the internal iteration of elements, and collects the elements in the stream in a collection or object of some kind. Here is a simple Java Stream collect() method example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

List<String> stringsAsUppercaseList = stream
.map(value -> value.toUpperCase())
.collect(Collectors.toList());

System.out.println(stringsAsUppercaseList);
```
The collect() method takes a Collector (java.util.stream.Collector) as parameter. Implementing a Collector requires some study of the Collector interface. Luckily, the Java class java.util.stream.Collectors contains a set of pre-implemented Collector implementations you can use, for the most common operations. In the example above, it was the Collector implementation returned by Collectors.toList() that was used. This Collector simply collects all elements in the stream in a standard Java List

#### count()

The `count()` method returns the number of elements in the stream.

The Java Stream count() method is a terminal operation which starts the internal iteration of the elements in the Stream, and counts the elements. Here is a Java Stream count() example:
```java
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
```
This example first creates a List of strings, then obtain the Stream for that List, adds a flatMap() operation for it, and then finishes with a call to count(). The count() method will start the iteration of the elements in the Stream which will result in the string elements being split up into words in the flatMap() operation, and then counted. The final result that will be printed out is 14.

#### findAny()

The `findAny()` method returns any element from the stream, if available.

The Java Stream findAny() method can find a single element from the Stream. The element found can be from anywhere in the Stream. There is no guarantee about from where in the stream the element is taken. Here is a Java Stream findAny() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("one");
stringList.add("two");
stringList.add("three");
stringList.add("one");

Stream<String> stream = stringList.stream();

Optional<String> anyElement = stream.findAny();

System.out.println(anyElement.get());
```
Notice how the findAny() method returns an Optional. The Stream could be empty - so no element could be returned. You can check if an element was found via the Optional isPresent() method.

#### findFirst()

The `findFirst()` method returns the first element of the stream, if available.

The Java Stream findFirst() method finds the first element in the Stream, if any elements are present in the Stream. The findFirst() method returns an Optional from which you can obtain the element, if present. Here is a Java Stream findFirst() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("one");
stringList.add("two");
stringList.add("three");
stringList.add("one");

Stream<String> stream = stringList.stream();

Optional<String> result = stream.findFirst();

System.out.println(result.get());
```
You can check if the Optional returned contains an element via its isPresent() method.

#### forEach()

The `forEach()` method performs an action for each element in the stream.

The Java Stream forEach() method is a terminal operation which starts the internal iteration of the elements in the Stream, and applies a Consumer (java.util.function.Consumer) to each element in the Stream. The forEach() method returns void. Here is a Java Stream forEach() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("one");
stringList.add("two");
stringList.add("three");
stringList.add("one");

Stream<String> stream = stringList.stream();

stream.forEach( element -> { System.out.println(element); });
```
#### min()

The `min()` method returns the minimum element in the stream according to a specified comparator.

he Java Stream min() method is a terminal operation that returns the smallest element in the Stream. Which element is the smallest is determined by the Comparator implementation you pass to the min() method. I have explained how the Comparator interface works in my tutorial about sorting Java collections. Here is a Java Stream min() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("abc");
stringList.add("def");

Stream<String> stream = stringList.stream();

Optional<String> min = stream.min((val1, val2) -> {
    return val1.compareTo(val2);
});

String minString = min.get();

System.out.println(minString);
```
Notice how the min() method returns an Optional which may or may not contain a result. If the Stream is empty, the Optional get() method will throw a NoSuchElementException.

#### max()

The `max()` method returns the maximum element in the stream according to a specified comparator.

The Java Stream max() method is a terminal operation that returns the largest element in the Stream. Which element is the largest is determined by the Comparator implementation you pass to the max() method. I have explained how the Comparator interface works in my tutorial about sorting Java collections. Here is a Java Stream max() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("abc");
stringList.add("def");

Stream<String> stream = stringList.stream();

Optional<String> max = stream.max((val1, val2) -> {
    return val1.compareTo(val2);
});

String maxString = max.get();

System.out.println(maxString);
```
Notice how the max() method returns an Optional which may or may not contain a result. If the Stream is empty, the Optional get() method will throw a NoSuchElementException.

#### reduce()

The `reduce()` method performs a reduction on the elements of the stream using an associative accumulation function.

The Java Stream reduce() method is a terminal operation that can reduce all elements in the stream to a single element. Here is a Java Stream reduce() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

Optional<String> reduced = stream.reduce((value, combinedValue) -> {
    return combinedValue + " + " + value;
});

System.out.println(reduced.get());
```
Notice the Optional returned by the reduce() method. This Optional contains the value (if any) returned by the lambda expression passed to the reduce() method. You obtain the value by calling the Optional get() method.

#### toArray()

The `toArray()` method converts the stream into an array.

The Java Stream toArray() method is a terminal operation that starts the internal iteration of the elements in the stream, and returns an array of Object containing all the elements. Here is a Java Stream toArray() example:
```java
List<String> stringList = new ArrayList<String>();

stringList.add("One flew over the cuckoo's nest");
stringList.add("To kill a muckingbird");
stringList.add("Gone with the wind");

Stream<String> stream = stringList.stream();

Object[] objects = stream.toArray();
```
## Concatenate Streams

You can concatenate multiple streams using the `Stream.concat()` method, which combines two streams into one.

The Java Stream interface contains a static method called concat() which can concatenate two streams into one. The result is a new Stream which contains all of the elements from the first stream, followed by all of the elements from the second stream. Here is an example of using the Java Stream concat() method:
```java
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
```
## Create Stream From Array

Streams can be created from arrays using the `Arrays.stream()` method, allowing easy processing of array elements.

The Java Stream interface contains a static method called of() which can be used to create a Stream from one or more objects. Here is an example of using the Java Stream of() metho:
```java
Stream<String> streamOf = Stream.of("one", "two", "three");
```
## Java Stream API Critique

While the Java Stream API is powerful, it has its criticisms.

Having worked with other data streaming API's like the Apache Kafka Streams API, I have a bit of critique of the Java Stream API that I will share with you. They aren't big, important points of critique, but they are useful to have in the back of your head as you venture into stream processing.

### Batch, Not Streaming

The API processes data in batches rather than continuously, which can be a limitation for certain applications.

Despite its name, the Java Stream API is not truly a stream processing API. The Java Stream API's terminal operations return the final result of iterating through all the elements in the stream, and providing the non-terminal and terminal operations to the elements. The result of the terminal operation is returned after the last element in the stream has been processed.

Returning a final result after having processed the last element of a stream is only possible if you know what element is the last in the stream. The only way to know if a given element is the last element in a stream is, if you are processing a batch which has a last element. In contrast, a true stream does not have a last element. You never know if a given element is the last or not. Therefore it is not possible to perform a terminal operation on a stream. The best you can do is to collect the temporary results after the processing of a given element, but this would be sampling, not a final result.

### Chain, Not Graph

The API supports a chain of operations but does not naturally handle complex graphs of data.

The Java Stream API is designed so that a Stream instance can only be acted upon once. In other words, you can only add a single non-terminal operation to a Stream, resulting in a new Stream object. You can add another non-terminal operation to the resulting Stream object, but not to the first. The resulting structure of non-terminal Stream instances form a chain.

In a true stream processing API, the root stream and the event listeners can typically form a graph, not just a chain. Multiple listeners can listen to the root stream, and each listener may process the elements in the stream in its own way, and may forward a transformed element as a result. Each listener (non-terminal operation) can thus typically act as a stream itself which other listeners can listen to the results of. This is how Apache Kafka Streams is designed. Each listener (intermediate stream) could also have multiple listeners. The resulting structure forms a graph of listeners with listeners with listeners etc.

With a stream processing graph rather than a chain, there is not a single, final operation in the graph. By final operation I mean an operation which is guaranteed to be the last in the processing chain. Instead there can be multiple final operations. Each "leaf" in the graph is a final operation.

When your stream processing structure can be a graph with multiple final operations, the stream API cannot easily support terminal operations like the Java Stream API does. To support terminal operations easily, there has to be a single, final operation from which the final result is returned. A graph based stream processing API could instead support a "sample" operation where each node in the stream processing graph is asked for any value it may hold internally (e.g. a sum), if any (purely transforming listener nodes will not have any internal state).

### Internal, Not External Iteration

The Java Stream API is deliberately designed to have internal iteration of the elements in a Stream. The iteration is started when a terminal operation is invoked on the Stream. In fact, for terminal operations to be able to return a result, the terminal operation has to initiate the iteration of the elements in the Stream.

Some graph based stream processing APIs are also designed to kind of hide the iteration of the elements from the user of the API (e.g. Apache Kafka Streams and RxJava). However, personally I prefer a design where each stream node (root stream and listeners) could have elements passed to them via a method call, and have that element be passed through the complete graph for processing. Such a design would make it easier to test each listener in the graph, as you can configure the graph and push elements through it afterwards, and finally check the result (the sampled state of the graph). Such a design would also enable the stream processing graph to have elements pushed into it via multiple nodes in the graph, and not just via the root stream.

---
