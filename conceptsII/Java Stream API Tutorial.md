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

## Java Stream Definition

A stream in Java is a sequence of elements that can be processed in parallel or sequentially. It is not a data structure but rather a view of the data source, allowing operations to be performed on the data without modifying the underlying source.

## Stream Processing

Stream processing allows you to work with data in a declarative manner, focusing on what to do with the data rather than how to do it. This leads to clearer and more maintainable code.

## Obtain a Stream

Streams can be obtained from various data sources, including collections, arrays, or I/O channels. The most common way is through the `stream()` method available on collections.

## Terminal and Non-Terminal Operations

### Non-Terminal Operations

Non-terminal operations return a new stream and are lazy, meaning they are not executed until a terminal operation is called.

#### filter()

The `filter()` method is used to select elements from a stream that match a given predicate.

#### map()

The `map()` method transforms each element of the stream into another form.

#### flatMap()

The `flatMap()` method is similar to `map()`, but it flattens nested streams into a single stream.

#### distinct()

The `distinct()` method removes duplicate elements from the stream.

#### limit()

The `limit()` method is used to truncate the stream to a specified size.

#### peek()

The `peek()` method is used for debugging, allowing you to see elements as they are processed.

### Terminal Operations

Terminal operations produce a non-stream result, such as a primitive value, a collection, or no value at all.

#### anyMatch()

The `anyMatch()` method checks if any elements in the stream match a given predicate.

#### allMatch()

The `allMatch()` method checks if all elements in the stream match a given predicate.

#### noneMatch()

The `noneMatch()` method checks if no elements in the stream match a given predicate.

#### collect()

The `collect()` method is used to accumulate the elements of the stream into a collection.

#### count()

The `count()` method returns the number of elements in the stream.

#### findAny()

The `findAny()` method returns any element from the stream, if available.

#### findFirst()

The `findFirst()` method returns the first element of the stream, if available.

#### forEach()

The `forEach()` method performs an action for each element in the stream.

#### min()

The `min()` method returns the minimum element in the stream according to a specified comparator.

#### max()

The `max()` method returns the maximum element in the stream according to a specified comparator.

#### reduce()

The `reduce()` method performs a reduction on the elements of the stream using an associative accumulation function.

#### toArray()

The `toArray()` method converts the stream into an array.

## Concatenate Streams

You can concatenate multiple streams using the `Stream.concat()` method, which combines two streams into one.

## Create Stream From Array

Streams can be created from arrays using the `Arrays.stream()` method, allowing easy processing of array elements.

## Java Stream API Critique

While the Java Stream API is powerful, it has its criticisms.

### Batch, Not Streaming

The API processes data in batches rather than continuously, which can be a limitation for certain applications.

### Chain, Not Graph

The API supports a chain of operations but does not naturally handle complex graphs of data.

### Internal, Not External Iteration

The Stream API relies on internal iteration, which can be less intuitive for developers accustomed to external iteration patterns.

---
