Here's a comprehensive cheatsheet in tabular format for Java Stream API, including intermediate operations, terminal operations, `Collectors`, and `Comparator` methods. Each entry includes its purpose and an example.

### Stream API Cheatsheet

#### 1. **Intermediate Operations**

| Method            | Purpose                                             | Example                                                                                      |
|-------------------|-----------------------------------------------------|----------------------------------------------------------------------------------------------|
| `filter(Predicate)` | Filters elements based on a condition.             | `Stream.of(1, 2, 3, 4).filter(n -> n % 2 == 0).forEach(System.out::println);` // Output: 2 4 |
| `map(Function)`    | Transforms elements into another form.              | `Stream.of("a", "b", "c").map(String::toUpperCase).forEach(System.out::println);` // Output: A B C |
| `flatMap(Function)` | Flattens a nested structure into a single stream.   | `Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(List::stream).forEach(System.out::println);` // Output: 1 2 3 4 |
| `distinct()`       | Removes duplicate elements.                        | `Stream.of(1, 2, 2, 3).distinct().forEach(System.out::println);` // Output: 1 2 3 |
| `sorted()`         | Sorts elements based on natural order or comparator. | `Stream.of(4, 2, 3, 1).sorted().forEach(System.out::println);` // Output: 1 2 3 4 |
| `limit(long)`      | Limits the number of elements in the stream.        | `Stream.of(1, 2, 3, 4, 5).limit(3).forEach(System.out::println);` // Output: 1 2 3 |
| `skip(long)`       | Skips the first N elements.                        | `Stream.of(1, 2, 3, 4, 5).skip(2).forEach(System.out::println);` // Output: 3 4 5 |
| `peek(Consumer)`   | Allows inspecting elements while streaming.        | `Stream.of(1, 2, 3).peek(n -> System.out.println("Processing: " + n)).forEach(System.out::println);` // Output: Processing: 1 1 Processing: 2 2 Processing: 3 3 |

#### 2. **Terminal Operations**

| Method              | Purpose                                               | Example                                                                                   |
|---------------------|-------------------------------------------------------|-------------------------------------------------------------------------------------------|
| `forEach(Consumer)` | Applies a function to each element.                  | `Stream.of(1, 2, 3).forEach(System.out::println);` // Output: 1 2 3 |
| `collect(Collector)`| Collects the results into a collection.              | `Stream.of("a", "b", "c").collect(Collectors.toList());` // Output: [a, b, c] |
| `reduce(BinaryOperator)` | Reduces elements to a single result.               | `Stream.of(1, 2, 3).reduce((a, b) -> a + b).ifPresent(System.out::println);` // Output: 6 |
| `count()`           | Counts the number of elements.                       | `Stream.of(1, 2, 3).count();` // Output: 3 |
| `anyMatch(Predicate)` | Checks if any element matches a condition.         | `Stream.of(1, 2, 3).anyMatch(n -> n > 2);` // Output: true |
| `allMatch(Predicate)` | Checks if all elements match a condition.          | `Stream.of(1, 2, 3).allMatch(n -> n > 0);` // Output: true |
| `noneMatch(Predicate)` | Checks if no elements match a condition.           | `Stream.of(1, 2, 3).noneMatch(n -> n < 0);` // Output: true |
| `findFirst()`       | Finds the first element.                             | `Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println);` // Output: 1 |
| `findAny()`         | Finds any element (potentially more efficient).       | `Stream.of(1, 2, 3).findAny().ifPresent(System.out::println);` // Output: 1 (or 2 or 3) |

#### 3. **Collectors**

| Method                  | Purpose                                            | Example                                                                                           |
|-------------------------|----------------------------------------------------|---------------------------------------------------------------------------------------------------|
| `toList()`              | Collects elements into a `List`.                   | `Stream.of("a", "b", "c").collect(Collectors.toList());` // Output: [a, b, c] |
| `toSet()`               | Collects elements into a `Set`.                    | `Stream.of("a", "b", "a").collect(Collectors.toSet());` // Output: [a, b] |
| `toMap(Function, Function)` | Collects elements into a `Map` with keys and values. | `Stream.of("a", "b").collect(Collectors.toMap(String::length, Function.identity()));` // Output: {1=a, 1=b} |
| `joining()`             | Concatenates elements into a single `String`.      | `Stream.of("a", "b", "c").collect(Collectors.joining());` // Output: abc |
| `groupingBy(Function)`  | Groups elements by a classifier function.         | `Stream.of("a", "bb", "ccc").collect(Collectors.groupingBy(String::length));` // Output: {1=[a], 2=[bb], 3=[ccc]} |
| `partitioningBy(Predicate)` | Partitions elements into two groups.             | `Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(n -> n % 2 == 0));` // Output: {true=[2, 4], false=[1, 3]} |
| `counting()`            | Counts the number of elements.                    | `Stream.of("a", "b", "c").collect(Collectors.counting());` // Output: 3 |
| `summarizingInt(ToIntFunction)` | Provides summary statistics for integers.        | `Stream.of(1, 2, 3).collect(Collectors.summarizingInt(Integer::intValue));` // Output: IntSummaryStatistics{count=3, sum=6, min=1, average=2.000000, max=3} |
| `mapping(Function, Collector)` | Transforms elements and collects them.            | `Stream.of("a", "bb", "ccc").collect(Collectors.mapping(String::length, Collectors.toList()));` // Output: [1, 2, 3] |

#### 4. **Comparator Methods**

| Method                  | Purpose                                            | Example                                                                                           |
|-------------------------|----------------------------------------------------|---------------------------------------------------------------------------------------------------|
| `comparing(Function)`   | Creates a comparator based on a key extractor.    | `Comparator.comparing(String::length).compare("abc", "de");` // Output: 0 (both have length 3) |
| `reversed()`            | Reverses the order of the comparator.              | `Comparator.comparing(String::length).reversed().compare("abc", "de");` // Output: 0 (both have length 3) |
| `thenComparing(Comparator)` | Combines multiple comparators.                    | `Comparator.comparing(String::length).thenComparing(String::compareTo).compare("abc", "b");` // Output: 1 |
| `nullsFirst()`          | Handles `null` values, putting them first.         | `Comparator.nullsFirst(Comparator.naturalOrder()).compare(null, "b");` // Output: -1 |
| `nullsLast()`           | Handles `null` values, putting them last.          | `Comparator.nullsLast(Comparator.naturalOrder()).compare("a", null);` // Output: 1 |
| `naturalOrder()`        | Provides a natural order comparator for comparable elements. | `Comparator.naturalOrder().compare("a", "b");` // Output: -1 |
| `reverseOrder()`        | Provides a reverse order comparator for comparable elements. | `Comparator.reverseOrder().compare("b", "a");` // Output: 1 |

### Summary

- **Intermediate Operations**: Transform or filter the elements of a stream without modifying the original source.
- **Terminal Operations**: Produce a result or a side effect and terminate the stream.
- **Collectors**: Provide various ways to accumulate the elements of a stream into collections or other results.
- **Comparator Methods**: Used to define custom sorting logic.

This cheatsheet provides a quick reference for common stream operations, `Collector` methods, and `Comparator` utilities. Adjust the examples according to your specific needs and use cases.

Certainly! Here's a comprehensive list of all Stream intermediate and terminal operations in Java, including their purposes and examples.

### Stream Intermediate Operations

Intermediate operations are operations that return a new stream and are used for transforming or filtering the elements of the stream. They are lazy and don't execute until a terminal operation is invoked.

| Method                        | Purpose                                                                                  | Example                                                                                             |
|-------------------------------|------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| `filter(Predicate<T> predicate)` | Filters elements based on a predicate.                                                   | `Stream.of(1, 2, 3, 4).filter(n -> n % 2 == 0).forEach(System.out::println);` // Output: 2 4 |
| `map(Function<T, R> mapper)`    | Transforms each element using the provided function.                                      | `Stream.of("a", "b", "c").map(String::toUpperCase).forEach(System.out::println);` // Output: A B C |
| `flatMap(Function<T, Stream<R>> mapper)` | Flattens nested streams into a single stream.                                             | `Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(List::stream).forEach(System.out::println);` // Output: 1 2 3 4 |
| `distinct()`                    | Removes duplicate elements.                                                               | `Stream.of(1, 2, 2, 3).distinct().forEach(System.out::println);` // Output: 1 2 3 |
| `sorted()`                      | Sorts elements in natural order or using a comparator.                                    | `Stream.of(4, 2, 3, 1).sorted().forEach(System.out::println);` // Output: 1 2 3 4 |
| `sorted(Comparator<T> comparator)` | Sorts elements using the provided comparator.                                              | `Stream.of(4, 2, 3, 1).sorted(Comparator.reverseOrder()).forEach(System.out::println);` // Output: 4 3 2 1 |
| `limit(long maxSize)`           | Limits the number of elements in the stream.                                              | `Stream.of(1, 2, 3, 4, 5).limit(3).forEach(System.out::println);` // Output: 1 2 3 |
| `skip(long n)`                  | Skips the first `n` elements.                                                              | `Stream.of(1, 2, 3, 4, 5).skip(2).forEach(System.out::println);` // Output: 3 4 5 |
| `peek(Consumer<T> action)`       | Performs an action on each element without modifying the stream.                           | `Stream.of(1, 2, 3).peek(n -> System.out.println("Processing: " + n)).forEach(System.out::println);` // Output: Processing: 1 1 Processing: 2 2 Processing: 3 3 |
| `mapToInt(ToIntFunction<T> mapper)` | Converts elements to an `IntStream`.                                                       | `Stream.of("1", "2", "3").mapToInt(Integer::parseInt).sum();` // Output: 6 |
| `mapToDouble(ToDoubleFunction<T> mapper)` | Converts elements to a `DoubleStream`.                                                     | `Stream.of("1.1", "2.2", "3.3").mapToDouble(Double::parseDouble).sum();` // Output: 6.6 |
| `mapToLong(ToLongFunction<T> mapper)` | Converts elements to a `LongStream`.                                                        | `Stream.of("1", "2", "3").mapToLong(Long::parseLong).sum();` // Output: 6 |
| `flatMapToInt(Function<T, IntStream> mapper)` | Flattens nested `IntStream` into a single `IntStream`.                                      | `Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMapToInt(List::stream).sum();` // Output: 10 |
| `flatMapToDouble(Function<T, DoubleStream> mapper)` | Flattens nested `DoubleStream` into a single `DoubleStream`.                                | `Stream.of(Arrays.asList(1.1, 2.2), Arrays.asList(3.3, 4.4)).flatMapToDouble(List::stream).sum();` // Output: 11.0 |
| `flatMapToLong(Function<T, LongStream> mapper)` | Flattens nested `LongStream` into a single `LongStream`.                                     | `Stream.of(Arrays.asList(1L, 2L), Arrays.asList(3L, 4L)).flatMapToLong(List::stream).sum();` // Output: 10 |
| `concat(Stream<T> a, Stream<T> b)`  | Concatenates two streams into a single stream.                                              | `Stream.concat(Stream.of(1, 2), Stream.of(3, 4)).forEach(System.out::println);` // Output: 1 2 3 4 |

### Stream Terminal Operations

Terminal operations produce a result or a side-effect and terminate the stream.

| Method                        | Purpose                                                                          | Example                                                                                           |
|-------------------------------|----------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| `forEach(Consumer<T> action)` | Applies an action to each element.                                                | `Stream.of(1, 2, 3).forEach(System.out::println);` // Output: 1 2 3 |
| `collect(Collector<T, A, R> collector)` | Collects the elements into a collection or another result.                      | `Stream.of("a", "b", "c").collect(Collectors.toList());` // Output: [a, b, c] |
| `reduce(BinaryOperator<T> accumulator)` | Reduces elements to a single result using an associative accumulation function. | `Stream.of(1, 2, 3).reduce((a, b) -> a + b).ifPresent(System.out::println);` // Output: 6 |
| `count()`                     | Counts the number of elements.                                                     | `Stream.of(1, 2, 3).count();` // Output: 3 |
| `anyMatch(Predicate<T> predicate)` | Checks if any element matches the predicate.                                     | `Stream.of(1, 2, 3).anyMatch(n -> n > 2);` // Output: true |
| `allMatch(Predicate<T> predicate)` | Checks if all elements match the predicate.                                      | `Stream.of(1, 2, 3).allMatch(n -> n > 0);` // Output: true |
| `noneMatch(Predicate<T> predicate)` | Checks if no elements match the predicate.                                        | `Stream.of(1, 2, 3).noneMatch(n -> n < 0);` // Output: true |
| `findFirst()`                 | Finds the first element in the stream.                                             | `Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println);` // Output: 1 |
| `findAny()`                   | Finds any element in the stream (potentially more efficient).                      | `Stream.of(1, 2, 3).findAny().ifPresent(System.out::println);` // Output: 1 (or 2 or 3) |
| `toArray()`                   | Converts the stream to an array.                                                   | `Stream.of("a", "b", "c").toArray(String[]::new);` // Output: [a, b, c] |
| `toArray(IntFunction<A[]> generator)` | Converts the stream to an array with a specified generator function.              | `Stream.of(1, 2, 3).toArray(size -> new Integer[size]);` // Output: [1, 2, 3] |
| `toList()`                    | Collects the stream elements into a `List`.                                        | `Stream.of("a", "b", "c").collect(Collectors.toList());` // Output: [a, b, c] |
| `toSet()`                     | Collects the stream elements into a `Set`.                                         | `Stream.of("a", "b", "a").collect(Collectors.toSet());` // Output: [a, b] |
| `toMap(Function<T, K> keyMapper, Function<T, V> valueMapper)` | Collects the stream elements into a `Map` using provided key and value mappers.    | `Stream.of("a", "bb", "ccc").collect(Collectors.toMap(String::length, Function.identity()));` // Output: {1=a, 2=bb, 3=ccc} |
| `partitioningBy(Predicate<T> predicate)` | Partitions the stream into two groups based on the predicate.                      | `Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(n -> n % 2 == 0));` // Output: {true=[2, 4], false=[1, 3]} |

### Summary

- **Intermediate Operations**: Transform or filter elements without modifying the original stream, and are lazily evaluated.
- **Terminal Operations**: Produce results or side effects and terminate the stream processing.
- **`Collectors`**: Utility methods to collect results from streams into collections or other forms.
- **`Comparator`**: Utility methods for custom sorting and comparison.

This cheatsheet covers the most commonly used operations for Java streams, helping you to quickly understand and apply them in your code.


Here's a comprehensive list of Java Stream operations, categorized into intermediate and terminal operations, along with their purposes and examples.

### Stream Intermediate Operations

Intermediate operations are used to transform or filter the elements of a stream and are lazy; they are not executed until a terminal operation is invoked.

| Method                        | Purpose                                                                                       | Example                                                                                           |
|-------------------------------|-----------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| `filter(Predicate<T> predicate)` | Filters elements based on a predicate.                                                        | `Stream.of(1, 2, 3, 4).filter(n -> n % 2 == 0).forEach(System.out::println);` // Output: 2 4 |
| `map(Function<T, R> mapper)`    | Transforms each element using the provided function.                                           | `Stream.of("a", "b", "c").map(String::toUpperCase).forEach(System.out::println);` // Output: A B C |
| `flatMap(Function<T, Stream<R>> mapper)` | Flattens nested streams into a single stream.                                                  | `Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(List::stream).forEach(System.out::println);` // Output: 1 2 3 4 |
| `distinct()`                    | Removes duplicate elements.                                                                    | `Stream.of(1, 2, 2, 3).distinct().forEach(System.out::println);` // Output: 1 2 3 |
| `sorted()`                      | Sorts elements in natural order.                                                               | `Stream.of(4, 2, 3, 1).sorted().forEach(System.out::println);` // Output: 1 2 3 4 |
| `sorted(Comparator<T> comparator)` | Sorts elements using the provided comparator.                                                 | `Stream.of(4, 2, 3, 1).sorted(Comparator.reverseOrder()).forEach(System.out::println);` // Output: 4 3 2 1 |
| `limit(long maxSize)`           | Limits the number of elements in the stream.                                                   | `Stream.of(1, 2, 3, 4, 5).limit(3).forEach(System.out::println);` // Output: 1 2 3 |
| `skip(long n)`                  | Skips the first `n` elements.                                                                   | `Stream.of(1, 2, 3, 4, 5).skip(2).forEach(System.out::println);` // Output: 3 4 5 |
| `peek(Consumer<T> action)`       | Performs an action on each element without modifying the stream.                                | `Stream.of(1, 2, 3).peek(n -> System.out.println("Processing: " + n)).forEach(System.out::println);` // Output: Processing: 1 1 Processing: 2 2 Processing: 3 3 |
| `mapToInt(ToIntFunction<T> mapper)` | Converts elements to an `IntStream`.                                                            | `Stream.of("1", "2", "3").mapToInt(Integer::parseInt).sum();` // Output: 6 |
| `mapToDouble(ToDoubleFunction<T> mapper)` | Converts elements to a `DoubleStream`.                                                          | `Stream.of("1.1", "2.2", "3.3").mapToDouble(Double::parseDouble).sum();` // Output: 6.6 |
| `mapToLong(ToLongFunction<T> mapper)` | Converts elements to a `LongStream`.                                                             | `Stream.of("1", "2", "3").mapToLong(Long::parseLong).sum();` // Output: 6 |
| `flatMapToInt(Function<T, IntStream> mapper)` | Flattens nested `IntStream` into a single `IntStream`.                                            | `Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMapToInt(List::stream).sum();` // Output: 10 |
| `flatMapToDouble(Function<T, DoubleStream> mapper)` | Flattens nested `DoubleStream` into a single `DoubleStream`.                                      | `Stream.of(Arrays.asList(1.1, 2.2), Arrays.asList(3.3, 4.4)).flatMapToDouble(List::stream).sum();` // Output: 11.0 |
| `flatMapToLong(Function<T, LongStream> mapper)` | Flattens nested `LongStream` into a single `LongStream`.                                          | `Stream.of(Arrays.asList(1L, 2L), Arrays.asList(3L, 4L)).flatMapToLong(List::stream).sum();` // Output: 10 |
| `concat(Stream<T> a, Stream<T> b)`  | Concatenates two streams into a single stream.                                                   | `Stream.concat(Stream.of(1, 2), Stream.of(3, 4)).forEach(System.out::println);` // Output: 1 2 3 4 |

### Stream Terminal Operations

Terminal operations produce a result or a side-effect and terminate the stream processing.

| Method                        | Purpose                                                                           | Example                                                                                           |
|-------------------------------|-----------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------|
| `forEach(Consumer<T> action)` | Applies an action to each element.                                                  | `Stream.of(1, 2, 3).forEach(System.out::println);` // Output: 1 2 3 |
| `collect(Collector<T, A, R> collector)` | Collects the elements into a collection or another result.                        | `Stream.of("a", "b", "c").collect(Collectors.toList());` // Output: [a, b, c] |
| `reduce(BinaryOperator<T> accumulator)` | Reduces elements to a single result using an associative accumulation function. | `Stream.of(1, 2, 3).reduce((a, b) -> a + b).ifPresent(System.out::println);` // Output: 6 |
| `count()`                     | Counts the number of elements.                                                      | `Stream.of(1, 2, 3).count();` // Output: 3 |
| `anyMatch(Predicate<T> predicate)` | Checks if any element matches the predicate.                                       | `Stream.of(1, 2, 3).anyMatch(n -> n > 2);` // Output: true |
| `allMatch(Predicate<T> predicate)` | Checks if all elements match the predicate.                                        | `Stream.of(1, 2, 3).allMatch(n -> n > 0);` // Output: true |
| `noneMatch(Predicate<T> predicate)` | Checks if no elements match the predicate.                                          | `Stream.of(1, 2, 3).noneMatch(n -> n < 0);` // Output: true |
| `findFirst()`                 | Finds the first element in the stream.                                             | `Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println);` // Output: 1 |
| `findAny()`                   | Finds any element in the stream (potentially more efficient).                      | `Stream.of(1, 2, 3).findAny().ifPresent(System.out::println);` // Output: 1 (or 2 or 3) |
| `toArray()`                   | Converts the stream to an array.                                                   | `Stream.of("a", "b", "c").toArray(String[]::new);` // Output: [a, b, c] |
| `toArray(IntFunction<A[]> generator)` | Converts the stream to an array with a specified generator function.               | `Stream.of(1, 2, 3).toArray(size -> new Integer[size]);` // Output: [1, 2, 3] |
| `toList()`                    | Collects the stream elements into a `List`.                                        | `Stream.of("a", "b", "c").collect(Collectors.toList());` // Output: [a, b, c] |
| `toSet()`                     | Collects the stream elements into a `Set`.                                         | `Stream.of("a", "b", "a").collect(Collectors.toSet());` // Output: [a, b] |
| `toMap(Function<T, K> keyMapper, Function<T, V> valueMapper)` | Collects the stream elements into a `Map` using provided key and value mappers.    | `Stream.of("a", "bb", "ccc").collect(Collectors.toMap(String::length, Function.identity()));` // Output: {1=a, 2=bb, 3=ccc} |
| `partitioningBy(Predicate<T> predicate)` | Partitions the stream into two groups based on the predicate.                      | `Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(n -> n % 2 == 0));` // Output: {true=[2, 4], false=[1, 3]} |

### Summary

- **Intermediate Operations**: These operations are used to set up a pipeline of operations that will be applied to the elements of the stream. They are lazy and executed only when a terminal operation is invoked.
- **Terminal Operations**: These operations produce a result or side-effect and terminate the stream processing. They trigger the actual computation of the stream pipeline.

This table covers the key operations available in the Java Stream API and provides a quick reference for using streams effectively in Java.
