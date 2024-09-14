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
